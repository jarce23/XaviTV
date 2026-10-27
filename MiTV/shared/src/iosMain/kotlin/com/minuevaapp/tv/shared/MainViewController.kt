package com.minuevaapp.tv.shared

import androidx.compose.ui.window.ComposeUIViewController
import com.minuevaapp.tv.shared.ui.IosXaviTVApp
import platform.UIKit.UIViewController

/**
 * Punto de entrada nativo para Xcode (SwiftUI / UIKit).
 * Expone un UIViewController que aloja la interfaz de XaviTV en Compose Multiplatform
 * respetando las Safe Areas del iPhone (Notch / Dynamic Island) y del iPad.
 */
fun MainViewController(): UIViewController = ComposeUIViewController(
    configure = {
        enforceStrictPlistSanityCheck = false
    }
) {
    IosXaviTVApp()
}
