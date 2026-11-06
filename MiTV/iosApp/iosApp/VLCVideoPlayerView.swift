import UIKit
import AVFoundation

#if canImport(MobileVLCKit)
import MobileVLCKit
#endif

/**
 * Vista contenedora nativa del reproductor VLCKit (MobileVLCKit) para iOS y iPadOS.
 * Integra el motor multimedia LibVLC para decodificar flujos IPTV complejos
 * (MPEG-TS .ts, HLS .m3u8, Xtream Codes, RTSP, RTMP y códecs pesados como MPEG2/H.264/HEVC/AC3)
 * con fallback secundario en AVPlayer.
 */
@objc(VLCPlayerHostView)
public class VLCPlayerHostView: UIView {

    // Superficie nativa sobre la que el motor LibVLC dibuja directamente los frames decodificados
    private let videoSurface = UIView()

    // Instancia persistente del reproductor LibVLC (MobileVLCKit)
    private var vlcMediaPlayer: AnyObject? = nil
    private var vlcMedia: AnyObject? = nil

    // Fallback secundario con AVPlayer en caso de que MobileVLCKit no esté disponible
    private var avPlayer: AVPlayer? = nil
    private var avPlayerLayer: AVPlayerLayer? = nil

    // Posición guardada para reanudar automáticamente una vez que el motor esté listo
    private var pendingResumeSeconds: Double? = nil

    // Almacenamiento seguro interno de textos accesible a nivel de módulo
    internal var _statusMsg: String = "Iniciando motor VLCKit..."
    internal var _currentUrl: String = ""

    @objc public var currentStatusMessage: NSString {
        get { return NSMutableString(string: _statusMsg) }
        set { _statusMsg = String(newValue) }
    }

    @objc public var currentUrl: NSString {
        get { return NSMutableString(string: _currentUrl) }
        set { _currentUrl = String(newValue) }
    }

    @objc public var currentHasError: Bool = false

    @objc(getHasErrorNumber)
    public func getHasErrorNumber() -> NSNumber {
        return NSNumber(value: currentHasError)
    }

    @objc public func getStatusMessageCopy() -> NSString {
        return NSMutableString(string: _statusMsg)
    }

    @objc public func getCurrentUrlCopy() -> NSString {
        return NSMutableString(string: _currentUrl)
    }

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

    private func executeOnMainThread(_ block: @escaping () -> Void) {
        if Thread.isMainThread {
            block()
        } else {
            DispatchQueue.main.async(execute: block)
        }
    }

    /**
     * Inicia la decodificación y reproducción del flujo mediante LibVLC (MobileVLCKit).
     */
    @objc(playStream:isLive:)
    public func playStream(urlString: String?, isLive: Bool) {
        executeOnMainThread { [weak self] in
            guard let self = self else { return }
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

            // 1. Prioridad: Motor nativo VLCKit
            if self.startVlcEngine(url: url, isLive: isLive) {
                let formatTag = clean.lowercased().contains(".ts") ? "MPEG-TS (.ts)" : "HLS (.m3u8)"
                self._statusMsg = "VLCKit • Decodificando \(formatTag) nativo"
                return
            }

            // 2. Fallback: AVPlayer si la librería MobileVLCKit no está enlazada
            self._statusMsg = "Reproductor AVPlayer de respaldo activo"
            self.startAvPlayerFallback(url: url, isLive: isLive)
        }
    }

    @objc(playStreamUrl:)
    public func playStreamUrl(url: NSString?) {
        guard let raw = url else { return }
        playStream(urlString: String(raw), isLive: true)
    }

    @objc(playVodUrl:)
    public func playVodUrl(url: NSString?) {
        guard let raw = url else { return }
        playStream(urlString: String(raw), isLive: false)
    }

    private func getOrCreateMediaPlayer(isLive: Bool) -> NSObject? {
        #if canImport(MobileVLCKit)
        if let existing = self.vlcMediaPlayer as? VLCMediaPlayer {
            return existing
        }
        let vlcOptions: [String] = [
            "--network-caching=\(isLive ? 1500 : 2500)",
            "--live-caching=1500",
            "--clock-jitter=0",
            "--clock-synchro=0",
            "--codec=all",
            "--no-spu",
            "--drop-late-frames",
            "--skip-frames",
            "--rtsp-tcp",
            "--http-reconnect",
            ":no-http-forward-cookies"
        ]
        let player = VLCMediaPlayer(options: vlcOptions)
        player.drawable = videoSurface
        player.delegate = self
        self.vlcMediaPlayer = player
        return player
        #else
        if let existing = self.vlcMediaPlayer as? NSObject {
            return existing
        }
        guard let vlcPlayerClass = NSClassFromString("VLCMediaPlayer") as? NSObject.Type else {
            return nil
        }
        let vlcOptions: NSArray = [
            "--network-caching=\(isLive ? 1500 : 2500)",
            "--live-caching=1500",
            "--clock-jitter=0",
            "--clock-synchro=0",
            "--codec=all",
            "--no-spu",
            "--drop-late-frames",
            "--skip-frames",
            "--rtsp-tcp",
            "--http-reconnect",
            ":no-http-forward-cookies"
        ]
        let player: NSObject
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
                player = (initFn(alloced, initWithOptionsSel, vlcOptions) as? NSObject) ?? vlcPlayerClass.init()
            } else {
                player = vlcPlayerClass.init()
            }
        } else {
            player = vlcPlayerClass.init()
        }
        let setDrawableSel = NSSelectorFromString("setDrawable:")
        if player.responds(to: setDrawableSel) {
            typealias SetDrawableIMP = @convention(c) (AnyObject, Selector, AnyObject) -> Void
            let imp = player.method(for: setDrawableSel)
            let fn = unsafeBitCast(imp, to: SetDrawableIMP.self)
            fn(player, setDrawableSel, videoSurface)
        }
        let setDelegateSel = NSSelectorFromString("setDelegate:")
        if player.responds(to: setDelegateSel) {
            typealias SetDelegateIMP = @convention(c) (AnyObject, Selector, AnyObject) -> Void
            let imp = player.method(for: setDelegateSel)
            let fn = unsafeBitCast(imp, to: SetDelegateIMP.self)
            fn(player, setDelegateSel, self)
        }
        self.vlcMediaPlayer = player
        return player
        #endif
    }

    private func startVlcEngine(url: URL, isLive: Bool) -> Bool {
        #if canImport(MobileVLCKit)
        guard let player = getOrCreateMediaPlayer(isLive: isLive) as? VLCMediaPlayer else {
            return false
        }
        player.stop()
        let media = VLCMedia(url: url)
        media.addOptions([
            "network-caching": isLive ? 1500 : 2500,
            "live-caching": 1500,
            "clock-jitter": 0,
            "clock-synchro": 0,
            ":no-http-forward-cookies": ""
        ])
        player.media = media
        player.play()
        self.vlcMedia = media
        return true
        #else
        guard let playerObj = getOrCreateMediaPlayer(isLive: isLive),
              let vlcMediaClass = NSClassFromString("VLCMedia") as? NSObject.Type else {
            return false
        }
        let stopSel = NSSelectorFromString("stop")
        if playerObj.responds(to: stopSel) {
            typealias VoidIMP = @convention(c) (AnyObject, Selector) -> Void
            let imp = playerObj.method(for: stopSel)
            let fn = unsafeBitCast(imp, to: VoidIMP.self)
            fn(playerObj, stopSel)
        }
        let mediaSel = NSSelectorFromString("mediaWithURL:")
        guard vlcMediaClass.responds(to: mediaSel) else { return false }
        typealias MediaWithUrlIMP = @convention(c) (AnyObject, Selector, NSURL) -> AnyObject?
        let mediaImp = vlcMediaClass.method(for: mediaSel)
        let mediaFn = unsafeBitCast(mediaImp, to: MediaWithUrlIMP.self)
        guard let media = mediaFn(vlcMediaClass, mediaSel, url as NSURL) as? NSObject else {
            return false
        }
        let addOptionsSel = NSSelectorFromString("addOptions:")
        if media.responds(to: addOptionsSel) {
            let optionsDict: NSDictionary = [
                "network-caching": isLive ? 1500 : 2500,
                "live-caching": 1500,
                "clock-jitter": 0,
                "clock-synchro": 0,
                ":no-http-forward-cookies": ""
            ]
            typealias AddOptionsIMP = @convention(c) (AnyObject, Selector, NSDictionary) -> Void
            let addOptImp = media.method(for: addOptionsSel)
            let addOptFn = unsafeBitCast(addOptImp, to: AddOptionsIMP.self)
            addOptFn(media, addOptionsSel, optionsDict)
        }
        let setMediaSel = NSSelectorFromString("setMedia:")
        if playerObj.responds(to: setMediaSel) {
            typealias SetMediaIMP = @convention(c) (AnyObject, Selector, AnyObject) -> Void
            let imp = playerObj.method(for: setMediaSel)
            let fn = unsafeBitCast(imp, to: SetMediaIMP.self)
            fn(playerObj, setMediaSel, media)
        }
        let playSel = NSSelectorFromString("play")
        if playerObj.responds(to: playSel) {
            typealias VoidIMP = @convention(c) (AnyObject, Selector) -> Void
            let imp = playerObj.method(for: playSel)
            let fn = unsafeBitCast(imp, to: VoidIMP.self)
            fn(playerObj, playSel)
        }
        self.vlcMedia = media
        return true
        #endif
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
        executeOnMainThread { [weak self] in
            guard let self = self else { return }
            #if canImport(MobileVLCKit)
            if let player = self.vlcMediaPlayer as? VLCMediaPlayer {
                player.pause()
                self._statusMsg = "VLCKit • En pausa"
                return
            }
            #endif
            if let playerObj = self.vlcMediaPlayer as? NSObject {
                let sel = NSSelectorFromString("pause")
                if playerObj.responds(to: sel) {
                    typealias VoidIMP = @convention(c) (AnyObject, Selector) -> Void
                    let imp = playerObj.method(for: sel)
                    let fn = unsafeBitCast(imp, to: VoidIMP.self)
                    fn(playerObj, sel)
                }
                self._statusMsg = "VLCKit • En pausa"
                return
            }
            self.avPlayer?.pause()
            self._statusMsg = "En pausa"
        }
    }

    @objc(resumeStream)
    public func resumeStream() {
        executeOnMainThread { [weak self] in
            guard let self = self else { return }
            #if canImport(MobileVLCKit)
            if let player = self.vlcMediaPlayer as? VLCMediaPlayer {
                player.play()
                self._statusMsg = "VLCKit • Reproduciendo"
                return
            }
            #endif
            if let playerObj = self.vlcMediaPlayer as? NSObject {
                let sel = NSSelectorFromString("play")
                if playerObj.responds(to: sel) {
                    typealias VoidIMP = @convention(c) (AnyObject, Selector) -> Void
                    let imp = playerObj.method(for: sel)
                    let fn = unsafeBitCast(imp, to: VoidIMP.self)
                    fn(playerObj, sel)
                }
                self._statusMsg = "VLCKit • Reproduciendo"
                return
            }
            self.avPlayer?.play()
            self._statusMsg = "Reproduciendo"
        }
    }

    @objc(togglePlayPause)
    public func togglePlayPause() {
        if getIsPlaying() {
            pauseStream()
        } else {
            resumeStream()
        }
    }

    @objc(stopStream)
    public func stopStream() {
        executeOnMainThread { [weak self] in
            guard let self = self else { return }
            self.pendingResumeSeconds = nil
            #if canImport(MobileVLCKit)
            if let player = self.vlcMediaPlayer as? VLCMediaPlayer {
                player.stop()
            }
            #endif
            if let playerObj = self.vlcMediaPlayer as? NSObject {
                let sel = NSSelectorFromString("stop")
                if playerObj.responds(to: sel) {
                    typealias VoidIMP = @convention(c) (AnyObject, Selector) -> Void
                    let imp = playerObj.method(for: sel)
                    let fn = unsafeBitCast(imp, to: VoidIMP.self)
                    fn(playerObj, sel)
                }
            }
            if let player = self.avPlayer {
                player.pause()
                player.replaceCurrentItem(with: nil)
                self.avPlayer = nil
            }
            self.avPlayerLayer?.removeFromSuperlayer()
            self.avPlayerLayer = nil
        }
    }

    @objc(seekToNumber:)
    public func seekToNumber(number: NSNumber?) {
        guard let num = number else { return }
        seekToSeconds(seconds: num.doubleValue)
    }

    @objc(seekToSeconds:)
    public func seekToSeconds(seconds: Double) {
        guard seconds.isFinite && !seconds.isNaN && seconds >= 0 else { return }
        executeOnMainThread { [weak self] in
            guard let self = self else { return }

            #if canImport(MobileVLCKit)
            if let player = self.vlcMediaPlayer as? VLCMediaPlayer {
                let vlcTime = VLCTime(int: Int32(seconds * 1000.0))
                player.time = vlcTime
                if let len = player.media?.length.intValue, len > 0 {
                    let pos = Float(seconds * 1000.0) / Float(len)
                    player.position = min(max(pos, 0.0), 1.0)
                }
                return
            }
            #endif

            if let player = self.avPlayer {
                let target = CMTimeMakeWithSeconds(seconds, preferredTimescale: 1000)
                player.seek(to: target, toleranceBefore: .zero, toleranceAfter: .zero)
                return
            }

            guard let playerObj = self.vlcMediaPlayer as? NSObject else {
                self.pendingResumeSeconds = seconds
                return
            }

            // Reflexión alternativa para cuando MobileVLCKit se carga dinámicamente
            let timeMs = Int32(seconds * 1000.0)
            if let timeClass = NSClassFromString("VLCTime") as? NSObject.Type {
                let allocSel = NSSelectorFromString("alloc")
                let initSel = NSSelectorFromString("initWithInt:")
                if let alloced = (timeClass as AnyObject).perform?(allocSel)?.takeUnretainedValue() {
                    typealias InitIMP = @convention(c) (AnyObject, Selector, Int32) -> AnyObject?
                    let imp = (alloced as AnyObject).method(for: initSel)
                    let fn = unsafeBitCast(imp, to: InitIMP.self)
                    if let timeObj = fn(alloced, initSel, timeMs) {
                        let setTimeSel = NSSelectorFromString("setTime:")
                        _ = (playerObj as AnyObject).perform?(setTimeSel, with: timeObj)
                    }
                }
            }
            let durMs = self.getDurationMs().int64Value
            if durMs > 0 {
                let pos = Float(Double(timeMs) / Double(durMs))
                let setPosSel = NSSelectorFromString("setPosition:")
                if playerObj.responds(to: setPosSel) {
                    typealias SetPosIMP = @convention(c) (AnyObject, Selector, Float) -> Void
                    let imp = playerObj.method(for: setPosSel)
                    let fn = unsafeBitCast(imp, to: SetPosIMP.self)
                    fn(playerObj, setPosSel, min(max(pos, 0.0), 1.0))
                }
            }
        }
    }

    @objc(jumpForward:)
    public func jumpForward(seconds: Int) {
        executeOnMainThread { [weak self] in
            guard let self = self else { return }
            #if canImport(MobileVLCKit)
            if let player = self.vlcMediaPlayer as? VLCMediaPlayer {
                player.jumpForward(Int32(seconds))
                return
            }
            #endif
            if let player = self.vlcMediaPlayer as? NSObject {
                let sel = NSSelectorFromString("jumpForward:")
                if player.responds(to: sel) {
                    typealias JumpIMP = @convention(c) (AnyObject, Selector, Int32) -> Void
                    let imp = player.method(for: sel)
                    let fn = unsafeBitCast(imp, to: JumpIMP.self)
                    fn(player, sel, Int32(seconds))
                    return
                }
            }
            let current = self.getPlaybackTimeMs().doubleValue / 1000.0
            self.seekToSeconds(seconds: max(0, current + Double(seconds)))
        }
    }

    @objc(jumpBackward:)
    public func jumpBackward(seconds: Int) {
        executeOnMainThread { [weak self] in
            guard let self = self else { return }
            #if canImport(MobileVLCKit)
            if let player = self.vlcMediaPlayer as? VLCMediaPlayer {
                player.jumpBackward(Int32(seconds))
                return
            }
            #endif
            if let player = self.vlcMediaPlayer as? NSObject {
                let sel = NSSelectorFromString("jumpBackward:")
                if player.responds(to: sel) {
                    typealias JumpIMP = @convention(c) (AnyObject, Selector, Int32) -> Void
                    let imp = player.method(for: sel)
                    let fn = unsafeBitCast(imp, to: JumpIMP.self)
                    fn(player, sel, Int32(seconds))
                    return
                }
            }
            let current = self.getPlaybackTimeMs().doubleValue / 1000.0
            self.seekToSeconds(seconds: max(0, current - Double(seconds)))
        }
    }

    @objc(setPosition:)
    public func setPosition(pos: Float) {
        executeOnMainThread { [weak self] in
            guard let self = self else { return }
            let clamped = min(max(pos, 0.0), 1.0)
            #if canImport(MobileVLCKit)
            if let player = self.vlcMediaPlayer as? VLCMediaPlayer {
                player.position = clamped
                return
            }
            #endif
            if let player = self.vlcMediaPlayer as? NSObject {
                let sel = NSSelectorFromString("setPosition:")
                if player.responds(to: sel) {
                    typealias SetPosIMP = @convention(c) (AnyObject, Selector, Float) -> Void
                    let imp = player.method(for: sel)
                    let fn = unsafeBitCast(imp, to: SetPosIMP.self)
                    fn(player, sel, clamped)
                    return
                }
            }
            let dur = self.getDurationMs().doubleValue / 1000.0
            if dur > 0 {
                self.seekToSeconds(seconds: dur * Double(clamped))
            }
        }
    }

    @objc(setAspectRatio:)
    public func setAspectRatio(ratio: NSString?) {
        executeOnMainThread { [weak self] in
            guard let self = self else { return }
            let safeRatio: String = {
                guard let r = ratio else { return "DEFAULT" }
                return String(r).trimmingCharacters(in: .whitespacesAndNewlines)
            }()
            self.applyAspectRatio(safeRatio)
        }
    }

    private func applyAspectRatio(_ safeRatio: String) {
        let upper = safeRatio.uppercased()
        #if canImport(MobileVLCKit)
        if let player = vlcMediaPlayer as? VLCMediaPlayer {
            if !safeRatio.isEmpty && upper != "DEFAULT" && upper != "AUTO" {
                safeRatio.withCString { cStr in
                    player.videoAspectRatio = UnsafeMutablePointer(mutating: cStr)
                }
            } else {
                player.videoAspectRatio = nil
            }
        }
        #else
        if let playerObj = vlcMediaPlayer as? NSObject {
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
        }
        #endif
        if let layer = avPlayerLayer {
            layer.videoGravity = (upper == "FILL") ? .resizeAspectFill : .resizeAspect
        }
    }

    @objc(getPlaybackTimeMs)
    public func getPlaybackTimeMs() -> NSNumber {
        #if canImport(MobileVLCKit)
        if let player = vlcMediaPlayer as? VLCMediaPlayer {
            if let time = player.time, let num = time.value {
                return num
            }
            return NSNumber(value: 0)
        }
        #endif
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
        #if canImport(MobileVLCKit)
        if let player = vlcMediaPlayer as? VLCMediaPlayer {
            if let media = player.media, let len = media.length, let num = len.value {
                return num
            }
            return NSNumber(value: 0)
        }
        #endif
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
        #if canImport(MobileVLCKit)
        if let player = vlcMediaPlayer as? VLCMediaPlayer {
            return player.isPlaying
        }
        #endif
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
        var stateRaw: Int = -1
        #if canImport(MobileVLCKit)
        if let player = vlcMediaPlayer as? VLCMediaPlayer {
            stateRaw = player.state.rawValue
        }
        #endif
        if stateRaw == -1, let playerObj = vlcMediaPlayer as? NSObject {
            let stateSel = NSSelectorFromString("state")
            if playerObj.responds(to: stateSel) {
                typealias StateIMP = @convention(c) (AnyObject, Selector) -> Int
                let imp = playerObj.method(for: stateSel)
                let fn = unsafeBitCast(imp, to: StateIMP.self)
                stateRaw = fn(playerObj, stateSel)
            }
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
                // Reanuda automáticamente si había una posición pendiente de seek
                if let pending = self.pendingResumeSeconds, pending > 2.0 {
                    self.pendingResumeSeconds = nil
                    self.seekToSeconds(seconds: pending)
                }
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

    private func destroyEngine() {
        pendingResumeSeconds = nil
        #if canImport(MobileVLCKit)
        if let player = vlcMediaPlayer as? VLCMediaPlayer {
            player.delegate = nil
            player.drawable = nil
            player.stop()
            self.vlcMediaPlayer = nil
            self.vlcMedia = nil
            return
        }
        #endif
        if let playerObj = vlcMediaPlayer as? NSObject {
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
    }

    public override func willMove(toSuperview newSuperview: UIView?) {
        super.willMove(toSuperview: newSuperview)
        if newSuperview == nil {
            destroyEngine()
            stopStream()
        }
    }

    deinit {
        destroyEngine()
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

    @objc public static func play(url: NSString?, isLive: Bool) {
        guard let raw = url else { return }
        shared.currentHost?.playStream(urlString: String(raw), isLive: isLive)
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

    @objc public static func jumpForward(_ seconds: Int) {
        shared.currentHost?.jumpForward(seconds: seconds)
    }

    @objc public static func jumpBackward(_ seconds: Int) {
        shared.currentHost?.jumpBackward(seconds: seconds)
    }

    @objc public static func setPosition(_ pos: Float) {
        shared.currentHost?.setPosition(pos: pos)
    }

    @objc public static func setAspectRatio(_ ratio: NSString?) {
        shared.currentHost?.setAspectRatio(ratio: ratio)
    }

    @objc public static func getStatus() -> NSString {
        if let host = shared.currentHost {
            return host.getStatusMessageCopy()
        }
        return NSMutableString(string: "VLCKit • Decodificador interno activo")
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
