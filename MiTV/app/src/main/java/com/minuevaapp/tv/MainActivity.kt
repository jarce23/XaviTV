package com.minuevaapp.tv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.minuevaapp.tv.ui.AppNavigation
import com.minuevaapp.tv.ui.theme.MiTVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MiTVTheme { AppNavigation() } }
    }
}
