# MiTV – Reproductor IPTV (Xtream Codes) en Kotlin + Jetpack Compose

Réplica funcional, escrita desde cero, de la app analizada (`app.shamel.tv`).

## Requisitos
- **JDK 17** (el JRE 11 instalado no basta). Android Studio Ladybug+ ya trae uno (JBR).
- **Android SDK** con plataforma 35 y build-tools (Android Studio lo instala solo).

## Compilar
Opción fácil: abrir la carpeta `MiTV` en Android Studio → *Build > Build APK(s)*.

Por línea de comandos (PowerShell):
```powershell
$env:JAVA_HOME = "C:\Program Files\Android\Android Studio\jbr"
"sdk.dir=C:\\Users\\Javier\\AppData\\Local\\Android\\Sdk" | Out-File -Encoding ascii local.properties
.\gradlew.bat assembleDebug      # -> app\build\outputs\apk\debug\app-debug.apk
.\gradlew.bat assembleRelease    # -> app\build\outputs\apk\release\app-release.apk
```
> La build release se firma con la clave *debug* para pruebas. Para publicar, crea tu keystore
> y configura `signingConfigs` en `app/build.gradle.kts`.

Opcional: `tmdb.apiKey=TU_CLAVE` en `local.properties` (expuesta como `BuildConfig.TMDB_API_KEY`).

## Estructura
```
app/src/main/java/com/minuevaapp/tv/
├─ MiTVApp.kt              Application: playlist activa + repositorio
├─ MainActivity.kt         Host Compose
├─ data/
│  ├─ Models.kt            Modelos JSON Xtream (login, categorías, streams, info, EPG)
│  ├─ XtreamApi.kt         Endpoints player_api.php (Retrofit)
│  └─ Repository.kt        Caché, URLs de stream, playlists y favoritos
├─ player/PlayerActivity.kt  Media3 ExoPlayer a pantalla completa + reanudar
└─ ui/                     Navegación, listas, Home, catálogo, fichas, búsqueda
```
