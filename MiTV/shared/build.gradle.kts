import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    // Target JVM auxiliar para verificación cruzada en Windows/Linux
    jvm("desktopShared") {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    // Targets oficiales de Apple iOS/iPadOS (iPhone e iPad: dispositivos físicos y simuladores Intel / Apple Silicon)
    val iosTargets = listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    )

    iosTargets.forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            // Optimizaciones del nuevo modelo de memoria de Kotlin/Native para iPhone e iPad:
            // - gc=cms: Recolector Concurrent Mark & Sweep para evitar pausas en la UI y reducir picos de RAM
            // - allocator=custom: Asignador de memoria nativo de baja fragmentación
            freeCompilerArgs += listOf(
                "-Xbinary=bundleId=com.minuevaapp.tv.ios",
                "-Xbinary=gc=cms",
                "-Xallocator=custom"
            )
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation(compose.ui)
                implementation(compose.components.resources)

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

                // Cliente HTTP multiplataforma (Ktor) compatible con iOS (Darwin) y JVM
                val ktorVersion = "2.3.12"
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting

        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation("io.ktor:ktor-client-darwin:2.3.12")
            }
        }

        val desktopSharedMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation("io.ktor:ktor-client-okhttp:2.3.12")
            }
        }
    }
}
