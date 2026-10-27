import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    jvmToolchain(17)
    compilerOptions {
        freeCompilerArgs.addAll(
            "-Xlambdas=indy"
        )
    }
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.material3)
    implementation(compose.materialIconsExtended)

    // Corrutinas para el hilo principal Swing/AWT y segundo plano (Dispatchers.IO) en Desktop
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.9.0")

    // Red y JSON (idéntico al módulo Android: Retrofit + OkHttp + Gson)
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.google.code.gson:gson:2.11.0")

    // Motor multimedia nativo VLC para Java (vlcj + JNA)
    implementation("uk.co.caprica:vlcj:4.8.3")
}

compose.desktop {
    application {
        mainClass = "com.minuevaapp.tv.desktop.MainKt"

        // Argumentos de JVM para mejorar el arranque, asignación de memoria, G1GC y renderizado Direct3D/Skia
        jvmArgs(
            "-XX:+UseG1GC",
            "-XX:MaxGCPauseMillis=30",
            "-XX:+UseStringDeduplication",
            "-XX:+TieredCompilation",
            "-Xms256m",
            "-Xmx1536m",
            "-Dsun.java2d.d3d=true",
            "-Dsun.java2d.noddraw=false",
            "-Dcompose.interop.blending=true",
            "-Dfile.encoding=UTF-8"
        )

        nativeDistributions {
            targetFormats(TargetFormat.Exe, TargetFormat.Msi)
            packageName = "XaviTV"
            packageVersion = "1.0.0"
            description = "XaviTV - Reproductor IPTV Xtream Codes y M3U para Windows con motor VLCJ"
            vendor = "XaviTV"
            includeAllModules = true
            appResourcesRootDir.set(project.layout.projectDirectory.dir("app-resources"))

            windows {
                iconFile.set(rootProject.file("logo.ico"))
                shortcut = true
                dirChooser = true
                menuGroup = "XaviTV"
            }
        }
    }
}
