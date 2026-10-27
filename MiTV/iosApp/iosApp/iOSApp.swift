import SwiftUI
import AVFoundation
import ComposeApp

@main
struct iOSApp: App {
    init() {
        do {
            let session = AVAudioSession.sharedInstance()
            try session.setCategory(.playback, mode: .moviePlayback, options: [.allowAirPlay])
            try session.setActive(true)
        } catch {
            // La sesión también es gestionada por NativeVideoPlayer al reproducir
        }

        // Registra la factoría nativa de VLCKit para que Compose cree directamente la vista
        PlatformBridge_iosKt.registerVlcPlayerViewFactory {
            VLCPlayerHostView()
        }
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
                .preferredColorScheme(.dark)
        }
    }
}
