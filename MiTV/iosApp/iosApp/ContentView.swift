import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        let controller = MainViewControllerKt.MainViewController()
        // Garantiza que el fondo del contenedor UIKit mantenga el tono verde/carbón de XaviTV
        // incluso durante las rotaciones o bajo el Notch / Dynamic Island / Home Indicator.
        controller.view.backgroundColor = UIColor(
            red: 14.0 / 255.0,
            green: 20.0 / 255.0,
            blue: 16.0 / 255.0,
            alpha: 1.0
        )
        return controller
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ZStack {
            // Fondo de respaldo con los colores de XaviTV que cubre toda la pantalla (incluidas Safe Areas)
            Color(red: 14.0 / 255.0, green: 20.0 / 255.0, blue: 16.0 / 255.0)
                .ignoresSafeArea(.all)

            // ComposeView se extiende de borde a borde; IosAppScaffold aplica WindowInsets.safeDrawing internamente
            ComposeView()
                .ignoresSafeArea(.all)
        }
    }
}
