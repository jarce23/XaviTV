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

    // Gesto táctil para alternar controles (tap to toggle)
    private var tapGesture: UITapGestureRecognizer? = nil

    // Almacenamiento seguro interno de textos para evitar tagged pointers
    private var _statusMsg: String = "Iniciando motor VLCKit..."
    private var _currentUrl: String = ""

    // Propiedades públicas expuestas a KVC / Kotlin: devuelven siempre NSMutableString (en memoria heap)
    // para impedir que el runtime de Apple use NSIndirectTaggedPointerString (que crashea getCharacters:range: en Kotlin/Native)
    @objc public var currentStatusMessage: NSString {
        get { return NSMutableString(string: _statusMsg) }
        set { _statusMsg = String(newValue) }
    }

    @objc public var currentUrl: NSString {
        get { return NSMutableString(string: _currentUrl) }
        set { _currentUrl = String(newValue) }
    }

    @objc public var currentHasError: Bool = false

    @objc public func getStatusMessageCopy() -> NSString {
        return NSMutableString(string: _statusMsg)
    }

    @objc public func getCurrentUrlCopy() -> NSString {
        return NSMutableString(string: _currentUrl)
    }

    override init(frame: CGRect) {
        super.init(frame: frame)
        setupViews()
        setupGesture()
        configureAudioSession()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupViews()
        setupGesture()
        configureAudioSession()
    }

    private func setupViews() {
        backgroundColor = .black
        videoSurface.backgroundColor = .black
        videoSurface.isUserInteractionEnabled = false
        videoSurface.translatesAutoresizingMaskIntoConstraints = false
        addSubview(videoSurface)

        NSLayoutConstraint.activate([
            videoSurface.leadingAnchor.constraint(equalTo: leadingAnchor),
            videoSurface.trailingAnchor.constraint(equalTo: trailingAnchor),
            videoSurface.topAnchor.constraint(equalTo: topAnchor),
            videoSurface.bottomAnchor.constraint(equalTo: bottomAnchor)
        ])
    }

    private func setupGesture() {
        isUserInteractionEnabled = true
        let tap = UITapGestureRecognizer(target: self, action: #selector(handleTapGesture))
        tap.cancelsTouchesInView = false
        addGestureRecognizer(tap)
        self.tapGesture = tap
    }

    @objc private func handleTapGesture() {
        guard window != nil || superview != nil else { return }
        NotificationCenter.default.post(name: NSNotification.Name("VLCPlayerToggleOverlayNotification"), object: nil)
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
    public func playStream(urlString: String?, isLive: Bool) {
        guard let raw = urlString else {
            self.currentHasError = true
            self._statusMsg = "URL de stream no válida"
            return
        }
        let clean = String(raw).trimmingCharacters(in: .whitespacesAndNewlines)
        guard !clean.isEmpty, let url = URL(string: clean) else {
            self.currentHasError = true
            self._statusMsg = "URL de stream no válida"
            return
        }

        self._currentUrl = clean
        self.currentHasError = false

        stopStream()

        // 1. Prioridad: Motor nativo VLCKit (MobileVLCKit)
        if startVlcEngine(url: url, isLive: isLive) {
            let formatTag = clean.lowercased().contains(".ts") ? "MPEG-TS (.ts)" : "HLS (.m3u8)"
            self._statusMsg = "VLCKit • Decodificando \(formatTag) nativo"
            return
        }

        // 2. Fallback: AVPlayer si la librería MobileVLCKit no está enlazada en el binario
        self._statusMsg = "Reproductor AVPlayer de respaldo activo"
        startAvPlayerFallback(url: url, isLive: isLive)
    }

    @objc(playStreamUrl:)
    public func playStreamUrl(url: String?) {
        let safeUrl = String(url ?? "")
        playStream(urlString: safeUrl, isLive: true)
    }

    @objc(playVodUrl:)
    public func playVodUrl(url: String?) {
        let safeUrl = String(url ?? "")
        playStream(urlString: safeUrl, isLive: false)
    }

    private func startVlcEngine(url: URL, isLive: Bool) -> Bool {
        guard let vlcPlayerClass = NSClassFromString("VLCMediaPlayer") as? NSObject.Type,
              let vlcMediaClass = NSClassFromString("VLCMedia") as? NSObject.Type else {
            return false
        }

        // Argumentos agresivos de optimización de búfer y compatibilidad IPTV para LibVLC
        let vlcOptions: NSArray = [
            "--network-caching=\(isLive ? 1500 : 2000)",
            "--live-caching=1500",
            "--clock-jitter=0",
            "--clock-synchro=0",
            "--codec=all",
            "--no-spu",
            "--drop-late-frames",
            "--skip-frames",
            "--rtsp-tcp",
            "--http-reconnect"
        ]

        let player: AnyObject
        let initWithOptionsSel = NSSelectorFromString("initWithOptions:")
        if vlcPlayerClass.instancesRespond(to: initWithOptionsSel) {
            let allocSel = NSSelectorFromString("alloc")
            typealias AllocIMP = @convention(c) (AnyObject, Selector) -> AnyObject?
            let allocImp = vlcPlayerClass.method(for: allocSel)
            let allocFn = unsafeBitCast(allocImp, to: AllocIMP.self)
            if let alloced = allocFn(vlcPlayerClass, allocSel) {
                typealias InitWithOptsIMP = @convention(c) (AnyObject, Selector, NSArray) -> AnyObject?
                let initImp = (alloced as! NSObject).method(for: initWithOptionsSel)
                let initFn = unsafeBitCast(initImp, to: InitWithOptsIMP.self)
                if let initObj = initFn(alloced, initWithOptionsSel, vlcOptions) {
                    player = initObj
                } else {
                    player = vlcPlayerClass.init()
                }
            } else {
                player = vlcPlayerClass.init()
            }
        } else {
            player = vlcPlayerClass.init()
        }

        guard let playerObj = player as? NSObject else {
            return false
        }

        // Asignamos la vista de dibujo de vídeo a LibVLC (-setDrawable:)
        let setDrawableSel = NSSelectorFromString("setDrawable:")
        if playerObj.responds(to: setDrawableSel) {
            typealias SetDrawableIMP = @convention(c) (AnyObject, Selector, AnyObject) -> Void
            let imp = playerObj.method(for: setDrawableSel)
            let fn = unsafeBitCast(imp, to: SetDrawableIMP.self)
            fn(playerObj, setDrawableSel, videoSurface)
        }

        // Creamos la media pasando NSURL explícito (-mediaWithURL:)
        let mediaSel = NSSelectorFromString("mediaWithURL:")
        guard vlcMediaClass.responds(to: mediaSel) else { return false }
        typealias MediaWithUrlIMP = @convention(c) (AnyObject, Selector, NSURL) -> AnyObject?
        let mediaImp = vlcMediaClass.method(for: mediaSel)
        let mediaFn = unsafeBitCast(mediaImp, to: MediaWithUrlIMP.self)
        guard let media = mediaFn(vlcMediaClass, mediaSel, url as NSURL) as? NSObject else {
            return false
        }

        // Opciones por stream (requiere estrictamente un NSDictionary para -[VLCMedia addOptions:])
        let addOptionsSel = NSSelectorFromString("addOptions:")
        if media.responds(to: addOptionsSel) {
            let optionsDict: NSDictionary = [
                "network-caching": isLive ? 1500 : 2000,
                "live-caching": 1500,
                "clock-jitter": 0,
                "clock-synchro": 0
            ]
            typealias AddOptionsIMP = @convention(c) (AnyObject, Selector, NSDictionary) -> Void
            let addOptImp = media.method(for: addOptionsSel)
            let addOptFn = unsafeBitCast(addOptImp, to: AddOptionsIMP.self)
            addOptFn(media, addOptionsSel, optionsDict)
        }

        // Asignamos la media al reproductor (-setMedia:)
        let setMediaSel = NSSelectorFromString("setMedia:")
        if playerObj.responds(to: setMediaSel) {
            typealias SetMediaIMP = @convention(c) (AnyObject, Selector, AnyObject) -> Void
            let imp = playerObj.method(for: setMediaSel)
            let fn = unsafeBitCast(imp, to: SetMediaIMP.self)
            fn(playerObj, setMediaSel, media)
        }

        // Asignamos delegate para recibir cambios de estado de reproducción en tiempo real (-setDelegate:)
        let setDelegateSel = NSSelectorFromString("setDelegate:")
        if playerObj.responds(to: setDelegateSel) {
            typealias SetDelegateIMP = @convention(c) (AnyObject, Selector, AnyObject) -> Void
            let imp = playerObj.method(for: setDelegateSel)
            let fn = unsafeBitCast(imp, to: SetDelegateIMP.self)
            fn(playerObj, setDelegateSel, self)
        }

        // Comenzar decodificación (-play)
        let playSel = NSSelectorFromString("play")
        if playerObj.responds(to: playSel) {
            typealias VoidIMP = @convention(c) (AnyObject, Selector) -> Void
            let imp = playerObj.method(for: playSel)
            let fn = unsafeBitCast(imp, to: VoidIMP.self)
            fn(playerObj, playSel)
        }

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
        guard let playerObj = vlcMediaPlayer as? NSObject else {
            avPlayer?.pause()
            self._statusMsg = "En pausa"
            return
        }
        let sel = NSSelectorFromString("pause")
        if playerObj.responds(to: sel) {
            typealias VoidIMP = @convention(c) (AnyObject, Selector) -> Void
            let imp = playerObj.method(for: sel)
            let fn = unsafeBitCast(imp, to: VoidIMP.self)
            fn(playerObj, sel)
        }
        self._statusMsg = "VLCKit • En pausa"
    }

    @objc(resumeStream)
    public func resumeStream() {
        guard let playerObj = vlcMediaPlayer as? NSObject else {
            avPlayer?.play()
            self._statusMsg = "Reproduciendo"
            return
        }
        let sel = NSSelectorFromString("play")
        if playerObj.responds(to: sel) {
            typealias VoidIMP = @convention(c) (AnyObject, Selector) -> Void
            let imp = playerObj.method(for: sel)
            let fn = unsafeBitCast(imp, to: VoidIMP.self)
            fn(playerObj, sel)
        }
        self._statusMsg = "VLCKit • Reproduciendo"
    }

    @objc(stopStream)
    public func stopStream() {
        if let playerObj = vlcMediaPlayer as? NSObject {
            // Desvincular delegate y drawable antes de detener para evitar callbacks a vistas zombis
            let setDelegateSel = NSSelectorFromString("setDelegate:")
            if playerObj.responds(to: setDelegateSel) {
                typealias SetDelegateIMP = @convention(c) (AnyObject, Selector, AnyObject?) -> Void
                let imp = playerObj.method(for: setDelegateSel)
                let fn = unsafeBitCast(imp, to: SetDelegateIMP.self)
                fn(playerObj, setDelegateSel, nil)
            }
            let setDrawableSel = NSSelectorFromString("setDrawable:")
            if playerObj.responds(to: setDrawableSel) {
                typealias SetDrawableIMP = @convention(c) (AnyObject, Selector, AnyObject?) -> Void
                let imp = playerObj.method(for: setDrawableSel)
                let fn = unsafeBitCast(imp, to: SetDrawableIMP.self)
                fn(playerObj, setDrawableSel, nil)
            }
            let sel = NSSelectorFromString("stop")
            if playerObj.responds(to: sel) {
                typealias VoidIMP = @convention(c) (AnyObject, Selector) -> Void
                let imp = playerObj.method(for: sel)
                let fn = unsafeBitCast(imp, to: VoidIMP.self)
                fn(playerObj, sel)
            }
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
    public func seekToNumber(number: NSNumber?) {
        guard let num = number else { return }
        seekToSeconds(seconds: num.doubleValue)
    }

    @objc public func seekToSeconds(seconds: Double) {
        guard seconds.isFinite && !seconds.isNaN else { return }
        guard let playerObj = vlcMediaPlayer as? NSObject else {
            if let player = avPlayer {
                let target = CMTimeMakeWithSeconds(seconds, preferredTimescale: 1000)
                player.seek(to: target)
            }
            return
        }
        let timeClass = NSClassFromString("VLCTime") as? NSObject.Type
        let setTimeSel = NSSelectorFromString("setTime:")
        if let timeClass = timeClass, playerObj.responds(to: setTimeSel) {
            let timeNumber = NSNumber(value: Int(seconds * 1000.0))
            let timeWithNumberSel = NSSelectorFromString("timeWithNumber:")
            if timeClass.responds(to: timeWithNumberSel) {
                typealias TimeWithNumIMP = @convention(c) (AnyObject, Selector, NSNumber) -> AnyObject?
                let imp = timeClass.method(for: timeWithNumberSel)
                let fn = unsafeBitCast(imp, to: TimeWithNumIMP.self)
                if let timeObj = fn(timeClass, timeWithNumberSel, timeNumber) {
                    typealias SetTimeIMP = @convention(c) (AnyObject, Selector, AnyObject) -> Void
                    let setTimeImp = playerObj.method(for: setTimeSel)
                    let setTimeFn = unsafeBitCast(setTimeImp, to: SetTimeIMP.self)
                    setTimeFn(playerObj, setTimeSel, timeObj)
                }
            }
        }
    }

    @objc(setAspectRatio:)
    public func setAspectRatio(ratio: String?) {
        let safeRatio: String = {
            guard let r = ratio else { return "DEFAULT" }
            return String(r).trimmingCharacters(in: .whitespacesAndNewlines)
        }()
        let upper = safeRatio.uppercased()

        guard let playerObj = vlcMediaPlayer as? NSObject else {
            if let layer = avPlayerLayer {
                layer.videoGravity = (upper == "FILL") ? .resizeAspectFill : .resizeAspect
            }
            return
        }
        let sel = NSSelectorFromString("setVideoAspectRatio:")
        if playerObj.responds(to: sel) {
            typealias SetAspectRatioIMP = @convention(c) (AnyObject, Selector, UnsafePointer<CChar>?) -> Void
            let imp = playerObj.method(for: sel)
            let fn = unsafeBitCast(imp, to: SetAspectRatioIMP.self)
            if !safeRatio.isEmpty && upper != "DEFAULT" && upper != "AUTO" {
                safeRatio.withCString { cStr in
                    fn(playerObj, sel, cStr)
                }
            } else {
                fn(playerObj, sel, nil)
            }
        }
        if let layer = avPlayerLayer {
            layer.videoGravity = (upper == "FILL") ? .resizeAspectFill : .resizeAspect
        }
    }

    @objc(getPlaybackTimeMs)
    public func getPlaybackTimeMs() -> NSNumber {
        var ms: Int64 = 0
        guard let playerObj = vlcMediaPlayer as? NSObject else {
            if let player = avPlayer {
                let sec = CMTimeGetSeconds(player.currentTime())
                if !sec.isNaN && sec >= 0 {
                    ms = Int64(sec * 1000.0)
                }
            }
            return NSNumber(value: ms)
        }
        let timeSel = NSSelectorFromString("time")
        if playerObj.responds(to: timeSel) {
            typealias TimeIMP = @convention(c) (AnyObject, Selector) -> AnyObject?
            let imp = playerObj.method(for: timeSel)
            let fn = unsafeBitCast(imp, to: TimeIMP.self)
            if let timeObj = fn(playerObj, timeSel) as? NSObject {
                let valSel = NSSelectorFromString("value")
                if timeObj.responds(to: valSel) {
                    typealias ValueIMP = @convention(c) (AnyObject, Selector) -> NSNumber?
                    let valImp = timeObj.method(for: valSel)
                    let valFn = unsafeBitCast(valImp, to: ValueIMP.self)
                    if let num = valFn(timeObj, valSel) {
                        ms = num.int64Value
                    }
                }
            }
        }
        return NSNumber(value: ms)
    }

    @objc(getDurationMs)
    public func getDurationMs() -> NSNumber {
        var ms: Int64 = 0
        guard let playerObj = vlcMediaPlayer as? NSObject else {
            if let player = avPlayer, let duration = player.currentItem?.duration {
                let sec = CMTimeGetSeconds(duration)
                if !sec.isNaN && sec >= 0 {
                    ms = Int64(sec * 1000.0)
                }
            }
            return NSNumber(value: ms)
        }
        let mediaSel = NSSelectorFromString("media")
        if playerObj.responds(to: mediaSel) {
            typealias MediaIMP = @convention(c) (AnyObject, Selector) -> AnyObject?
            let imp = playerObj.method(for: mediaSel)
            let fn = unsafeBitCast(imp, to: MediaIMP.self)
            if let mediaObj = fn(playerObj, mediaSel) as? NSObject {
                let lenSel = NSSelectorFromString("length")
                if mediaObj.responds(to: lenSel) {
                    typealias LenIMP = @convention(c) (AnyObject, Selector) -> AnyObject?
                    let lenImp = mediaObj.method(for: lenSel)
                    let lenFn = unsafeBitCast(lenImp, to: LenIMP.self)
                    if let lenObj = lenFn(mediaObj, lenSel) as? NSObject {
                        let valSel = NSSelectorFromString("value")
                        if lenObj.responds(to: valSel) {
                            typealias ValIMP = @convention(c) (AnyObject, Selector) -> NSNumber?
                            let valImp = lenObj.method(for: valSel)
                            let valFn = unsafeBitCast(valImp, to: ValIMP.self)
                            if let num = valFn(lenObj, valSel) {
                                ms = num.int64Value
                            }
                        }
                    }
                }
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
        guard let playerObj = vlcMediaPlayer as? NSObject else {
            if let player = avPlayer {
                return player.rate > 0 && player.error == nil
            }
            return false
        }
        let sel = NSSelectorFromString("isPlaying")
        if playerObj.responds(to: sel) {
            typealias IsPlayingIMP = @convention(c) (AnyObject, Selector) -> Bool
            let imp = playerObj.method(for: sel)
            let fn = unsafeBitCast(imp, to: IsPlayingIMP.self)
            return fn(playerObj, sel)
        }
        return false
    }

    @objc public func mediaPlayerStateChanged(_ aNotification: Notification) {
        guard let playerObj = vlcMediaPlayer as? NSObject else { return }
        let stateSel = NSSelectorFromString("state")
        var stateRaw: Int = -1
        if playerObj.responds(to: stateSel) {
            typealias StateIMP = @convention(c) (AnyObject, Selector) -> Int
            let imp = playerObj.method(for: stateSel)
            let fn = unsafeBitCast(imp, to: StateIMP.self)
            stateRaw = fn(playerObj, stateSel)
        }
        DispatchQueue.main.async { [weak self] in
            guard let self = self, self.vlcMediaPlayer != nil else { return }
            // VLCMediaPlayerState: 0=Stopped, 1=Opening, 2=Buffering, 3=Ended, 4=Error, 5=Playing, 6=Paused
            switch stateRaw {
            case 1:
                self._statusMsg = "VLCKit • Conectando al stream..."
                self.currentHasError = false
            case 2:
                self._statusMsg = "VLCKit • Búfer de baja latencia..."
                self.currentHasError = false
            case 5:
                let format = self._currentUrl.lowercased().contains(".ts") ? "MPEG-TS (.ts)" : "HLS (.m3u8)"
                self._statusMsg = "VLCKit • En directo (\(format))"
                self.currentHasError = false
            case 6:
                self._statusMsg = "VLCKit • En pausa"
            case 4:
                self._statusMsg = "Error decodificando stream con VLCKit"
                self.currentHasError = true
            case 0:
                self._statusMsg = "VLCKit • Detenido"
            default:
                break
            }
        }
    }

    public override func willMove(toSuperview newSuperview: UIView?) {
        super.willMove(toSuperview: newSuperview)
        if newSuperview == nil {
            stopStream()
        }
    }

    deinit {
        if let tap = tapGesture {
            removeGestureRecognizer(tap)
            tapGesture = nil
        }
        NotificationCenter.default.removeObserver(self)
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

    @objc public static func play(url: String?, isLive: Bool) {
        let safe = String(url ?? "")
        shared.currentHost?.playStream(urlString: safe, isLive: isLive)
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
        shared.currentHost?.seekToSeconds(seconds: seconds)
    }

    @objc public static func setAspectRatio(_ ratio: String?) {
        let safe = ratio != nil ? String(ratio!) : nil
        shared.currentHost?.setAspectRatio(ratio: safe)
    }

    @objc public static func getStatus() -> NSString {
        let msg = shared.currentHost?._statusMsg ?? "VLCKit • Decodificador interno activo"
        return NSMutableString(string: msg)
    }

    @objc public static func getHasError() -> Bool {
        return shared.currentHost?.currentHasError ?? false
    }

    @objc public static func getTimeMs() -> Int64 {
        if let num = shared.currentHost?.getPlaybackTimeMs() {
            return Int64(truncating: num)
        }
        return 0
    }

    @objc public static func getDurationMs() -> Int64 {
        if let num = shared.currentHost?.getDurationMs() {
            return Int64(truncating: num)
        }
        return 0
    }

    @objc public static func isPlaying() -> Bool {
        return shared.currentHost?.getIsPlaying() ?? false
    }
}
