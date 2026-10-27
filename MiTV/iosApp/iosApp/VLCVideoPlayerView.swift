import UIKit
import AVFoundation

#if canImport(MobileVLCKit)
import MobileVLCKit
#endif

/**
 * Vista contenedora nativa del reproductor VLCKit (MobileVLCKit) para iOS y iPadOS.
 * Integra el motor multimedia LibVLC para decodificar flujos IPTV complejos
 * (MPEG-TS .ts, HLS .m3u8, Xtream Codes, RTSP, RTMP y códecs pesados como MPEG2/H.264/HEVC/AC3)
 * que el reproductor nativo AVPlayer no es capaz de procesar.
 */
@objc(VLCPlayerHostView)
public class VLCPlayerHostView: UIView {

    // Superficie nativa sobre la que el motor LibVLC dibuja directamente los frames decodificados
    private let videoSurface = UIView()

    // Instancia dinámica del reproductor LibVLC (MobileVLCKit)
    private var vlcMediaPlayer: AnyObject? = nil
    private var vlcMedia: AnyObject? = nil

    // Fallback secundario con AVPlayer en caso de que MobileVLCKit no esté enlazado
    private var avPlayer: AVPlayer? = nil
    private var avPlayerLayer: AVPlayerLayer? = nil

    // Estado público accesible por el puente
    @objc public var currentStatusMessage: String = "Iniciando motor VLCKit..."
    @objc public var currentHasError: Bool = false
    @objc public var currentUrl: String = ""

    override init(frame: CGRect) {
        super.init(frame: frame)
        setupViews()
        configureAudioSession()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupViews()
        configureAudioSession()
    }

    private func setupViews() {
        backgroundColor = .black
        videoSurface.backgroundColor = .black
        videoSurface.translatesAutoresizingMaskIntoConstraints = false
        addSubview(videoSurface)

        NSLayoutConstraint.activate([
            videoSurface.leadingAnchor.constraint(equalTo: leadingAnchor),
            videoSurface.trailingAnchor.constraint(equalTo: trailingAnchor),
            videoSurface.topAnchor.constraint(equalTo: topAnchor),
            videoSurface.bottomAnchor.constraint(equalTo: bottomAnchor)
        ])
    }

    public override func layoutSubviews() {
        super.layoutSubviews()
        avPlayerLayer?.frame = bounds
    }

    private func configureAudioSession() {
        do {
            let session = AVAudioSession.sharedInstance()
            try session.setCategory(.playback, mode: .moviePlayback, options: [.allowAirPlay])
            try session.setActive(true)
        } catch {
            print("[VLCPlayerHostView] Error configurando sesión de audio: \(error)")
        }
    }

    /**
     * Inicia la decodificación y reproducción del flujo mediante LibVLC (MobileVLCKit).
     */
    @objc(playStream:isLive:)
    public func playStream(urlString: String, isLive: Bool) {
        let clean = urlString.trimmingCharacters(in: .whitespacesAndNewlines)
        self.currentUrl = clean
        self.currentHasError = false

        guard let url = URL(string: clean) else {
            self.currentHasError = true
            self.currentStatusMessage = "URL de stream no válida"
            return
        }

        stopStream()

        // 1. Prioridad: Motor nativo VLCKit (MobileVLCKit)
        if startVlcEngine(url: url, isLive: isLive) {
            let formatTag = clean.lowercased().contains(".ts") ? "MPEG-TS (.ts)" : "HLS (.m3u8)"
            self.currentStatusMessage = "VLCKit • Decodificando \(formatTag) nativo"
            return
        }

        // 2. Fallback: AVPlayer si la librería MobileVLCKit no está enlazada en el binario
        self.currentStatusMessage = "Reproductor AVPlayer de respaldo activo"
        startAvPlayerFallback(url: url, isLive: isLive)
    }

    @objc(playStreamUrl:)
    public func playStreamUrl(url: String) {
        playStream(urlString: url, isLive: true)
    }

    @objc(playVodUrl:)
    public func playVodUrl(url: String) {
        playStream(urlString: url, isLive: false)
    }

    private func startVlcEngine(url: URL, isLive: Bool) -> Bool {
        guard let vlcPlayerClass = NSClassFromString("VLCMediaPlayer") as? NSObject.Type,
              let vlcMediaClass = NSClassFromString("VLCMedia") as? NSObject.Type else {
            return false
        }

        // Argumentos agresivos de optimización de búfer y compatibilidad IPTV para LibVLC
        let vlcOptions: [String] = [
            "--network-caching=300",
            "--live-caching=300",
            "--clock-jitter=0",
            "--clock-synchro=0",
            "--codec=all",
            "--no-spu",
            "--drop-late-frames",
            "--skip-frames",
            "--rtsp-tcp"
        ]

        let player: AnyObject
        let initWithOptionsSel = NSSelectorFromString("initWithOptions:")
        if vlcPlayerClass.instancesRespond(to: initWithOptionsSel) {
            let alloced = vlcPlayerClass.perform(NSSelectorFromString("alloc"))?.takeUnretainedValue()
            if let initObj = alloced?.perform(initWithOptionsSel, with: vlcOptions)?.takeUnretainedValue() {
                player = initObj
            } else {
                player = vlcPlayerClass.init()
            }
        } else {
            player = vlcPlayerClass.init()
        }

        // Asignamos la vista de dibujo de vídeo a LibVLC
        player.setValue(videoSurface, forKey: "drawable")

        // Creamos la media
        let mediaSel = NSSelectorFromString("mediaWithURL:")
        guard let media = vlcMediaClass.perform(mediaSel, with: url)?.takeUnretainedValue() else {
            return false
        }

        // Opciones por stream
        let addOptionsSel = NSSelectorFromString("addOptions:")
        if (media as AnyObject).responds(to: addOptionsSel) {
            let opts: [String: Any] = [
                "network-caching": 300,
                "live-caching": 300,
                ":network-caching=300",
                ":live-caching=300",
                ":clock-jitter=0"
            ]
            _ = (media as AnyObject).perform(addOptionsSel, with: opts)
        }

        player.setValue(media, forKey: "media")

        // Asignamos delegate para recibir cambios de estado de reproducción en tiempo real
        let setDelegateSel = NSSelectorFromString("setDelegate:")
        if (player as AnyObject).responds(to: setDelegateSel) {
            _ = (player as AnyObject).perform(setDelegateSel, with: self)
        }

        // Comenzar decodificación
        _ = player.perform(NSSelectorFromString("play"))

        self.vlcMediaPlayer = player
        self.vlcMedia = media
        return true
    }

    private func startAvPlayerFallback(url: URL, isLive: Bool) {
        let asset = AVURLAsset(url: url)
        let item = AVPlayerItem(asset: asset)
        item.preferredForwardBufferDuration = isLive ? 0.45 : 2.0
        item.canUseNetworkResourcesForLiveStreamingWhilePaused = true

        let player = AVPlayer(playerItem: item)
        player.automaticallyWaitsToMinimizeStalling = !isLive
        player.allowsExternalPlayback = true

        let layer = AVPlayerLayer(player: player)
        layer.videoGravity = .resizeAspect
        layer.frame = bounds
        videoSurface.layer.addSublayer(layer)
        self.avPlayerLayer = layer
        self.avPlayer = player

        if isLive {
            player.playImmediately(atRate: 1.0)
        } else {
            player.play()
        }
    }

    @objc(pauseStream)
    public func pauseStream() {
        if let player = vlcMediaPlayer {
            _ = player.perform(NSSelectorFromString("pause"))
            self.currentStatusMessage = "VLCKit • En pausa"
        } else if let player = avPlayer {
            player.pause()
            self.currentStatusMessage = "En pausa"
        }
    }

    @objc(resumeStream)
    public func resumeStream() {
        if let player = vlcMediaPlayer {
            _ = player.perform(NSSelectorFromString("play"))
            self.currentStatusMessage = "VLCKit • Reproduciendo"
        } else if let player = avPlayer {
            player.play()
            self.currentStatusMessage = "Reproduciendo"
        }
    }

    @objc(stopStream)
    public func stopStream() {
        if let player = vlcMediaPlayer {
            _ = player.perform(NSSelectorFromString("stop"))
            self.vlcMediaPlayer = nil
            self.vlcMedia = nil
        }
        if let player = avPlayer {
            player.pause()
            player.replaceCurrentItem(with: nil)
            self.avPlayer = nil
        }
        avPlayerLayer?.removeFromSuperlayer()
        avPlayerLayer = nil
    }

    @objc(seekToNumber:)
    public func seekToNumber(number: NSNumber) {
        seekTo(seconds: number.doubleValue)
    }

    @objc(seekToSeconds:)
    public func seekToSeconds(seconds: Double) {
        seekTo(seconds: seconds)
    }

    @objc public func seekTo(seconds: Double) {
        if let player = vlcMediaPlayer {
            let timeClass = NSClassFromString("VLCTime") as? NSObject.Type
            if let timeClass = timeClass {
                let timeNumber = NSNumber(value: Int(seconds * 1000.0))
                let timeObj = timeClass.perform(NSSelectorFromString("timeWithNumber:"), with: timeNumber)?.takeUnretainedValue()
                _ = (player as AnyObject).perform(NSSelectorFromString("setTime:"), with: timeObj)
            }
        } else if let player = avPlayer {
            let target = CMTimeMakeWithSeconds(seconds, preferredTimescale: 1000)
            player.seek(to: target)
        }
    }

    @objc(setAspectRatio:)
    public func setAspectRatio(ratio: String) {
        let clean = ratio.trimmingCharacters(in: .whitespacesAndNewlines).uppercased()
        if let player = vlcMediaPlayer {
            let setAspectSel = NSSelectorFromString("setVideoAspectRatio:")
            if (player as AnyObject).responds(to: setAspectSel) {
                if clean == "DEFAULT" || clean == "AUTO" {
                    let nilVal: UnsafeMutablePointer<CChar>? = nil
                    _ = (player as AnyObject).perform(setAspectSel, with: nilVal)
                } else {
                    clean.withCString { cStr in
                        let ptr = UnsafeMutablePointer<CChar>(mutating: cStr)
                        _ = (player as AnyObject).perform(setAspectSel, with: ptr)
                    }
                }
            }
        }
        if let layer = avPlayerLayer {
            if clean == "FILL" {
                layer.videoGravity = .resizeAspectFill
            } else {
                layer.videoGravity = .resizeAspect
            }
        }
    }

    @objc(getPlaybackTimeMs)
    public func getPlaybackTimeMs() -> NSNumber {
        var ms: Int64 = 0
        if let player = vlcMediaPlayer {
            if let timeObj = player.value(forKey: "time") as? AnyObject,
               let num = timeObj.value(forKey: "value") as? NSNumber {
                ms = num.int64Value
            }
        } else if let player = avPlayer {
            let sec = CMTimeGetSeconds(player.currentTime())
            if !sec.isNaN && sec >= 0 {
                ms = Int64(sec * 1000.0)
            }
        }
        return NSNumber(value: ms)
    }

    @objc(getIsPlayingNumber)
    public func getIsPlayingNumber() -> NSNumber {
        return NSNumber(value: getIsPlaying())
    }

    @objc(getIsPlaying)
    public func getIsPlaying() -> Bool {
        if let player = vlcMediaPlayer {
            return (player.value(forKey: "isPlaying") as? Bool) ?? false
        }
        if let player = avPlayer {
            return player.rate > 0 && player.error == nil
        }
        return false
    }

    @objc public func mediaPlayerStateChanged(_ aNotification: Notification) {
        guard let player = vlcMediaPlayer else { return }
        DispatchQueue.main.async { [weak self] in
            guard let self = self else { return }
            let stateRaw = (player.value(forKey: "state") as? NSNumber)?.intValue ?? -1
            // VLCMediaPlayerState: 0=Stopped, 1=Opening, 2=Buffering, 3=Ended, 4=Error, 5=Playing, 6=Paused
            switch stateRaw {
            case 1:
                self.currentStatusMessage = "VLCKit • Conectando al stream..."
                self.currentHasError = false
            case 2:
                self.currentStatusMessage = "VLCKit • Búfer de baja latencia (300ms)..."
                self.currentHasError = false
            case 5:
                let format = self.currentUrl.lowercased().contains(".ts") ? "MPEG-TS (.ts)" : "HLS (.m3u8)"
                self.currentStatusMessage = "VLCKit • En directo (\(format))"
                self.currentHasError = false
            case 6:
                self.currentStatusMessage = "VLCKit • En pausa"
            case 4:
                self.currentStatusMessage = "Error decodificando stream con VLCKit"
                self.currentHasError = true
            case 0:
                self.currentStatusMessage = "VLCKit • Detenido"
            default:
                break
            }
        }
    }

    deinit {
        stopStream()
    }
}

/**
 * Puente estático para control directo de VLCKit desde Compose Multiplatform (Kotlin/Native).
 */
@objc(VLCPlayerBridge)
public class VLCPlayerBridge: NSObject {
    @objc public static let shared = VLCPlayerBridge()
    @objc public weak var currentHost: VLCPlayerHostView? = nil

    @objc public static func createHostView() -> UIView {
        let view = VLCPlayerHostView()
        shared.currentHost = view
        return view
    }

    @objc public static func play(url: String, isLive: Bool) {
        shared.currentHost?.playStream(urlString: url, isLive: isLive)
    }

    @objc public static func pause() {
        shared.currentHost?.pauseStream()
    }

    @objc public static func resume() {
        shared.currentHost?.resumeStream()
    }

    @objc public static func stop() {
        shared.currentHost?.stopStream()
    }

    @objc public static func seekTo(seconds: Double) {
        shared.currentHost?.seekTo(seconds: seconds)
    }

    @objc public static func setAspectRatio(_ ratio: String) {
        shared.currentHost?.setAspectRatio(ratio: ratio)
    }

    @objc public static func getStatus() -> String {
        return shared.currentHost?.currentStatusMessage ?? "VLCKit • Decodificador interno activo"
    }

    @objc public static func getHasError() -> Bool {
        return shared.currentHost?.currentHasError ?? false
    }

    @objc public static func getTimeMs() -> Int64 {
        return shared.currentHost?.getPlaybackTimeMs() ?? 0
    }

    @objc public static func isPlaying() -> Bool {
        return shared.currentHost?.getIsPlaying() ?? false
    }
}
