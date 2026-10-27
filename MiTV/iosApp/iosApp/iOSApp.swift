import SwiftUI
import AVFoundation

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
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
                .preferredColorScheme(.dark)
        }
    }
}
