#!/usr/bin/env bash
# ==============================================================================
# XaviTV - Script de Compilación y Empaquetado (.ipa) para iOS (iPhone e iPad)
# Ejecuta obligatoriamente las tareas de empaquetado de Kotlin Multiplatform
# (:shared:linkReleaseFrameworkIosArm64 y :shared:embedAndSignAppleFrameworkForXcode)
# antes de invocar xcodebuild para garantizar que el módulo ComposeApp esté listo.
# ==============================================================================
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"
BUILD_DIR="$SCRIPT_DIR/build"
ARCHIVE_PATH="$BUILD_DIR/XaviTV.xcarchive"
IPA_OUTPUT_DIR="$BUILD_DIR/ipa"
IPA_FILE="$IPA_OUTPUT_DIR/XaviTV.ipa"

# Detecta el nombre exacto del SDK de iOS instalado en Xcode (ej. iphoneos17.5 / iphoneos18.2)
DETECTED_SDK_NAME="$(xcodebuild -version -sdk iphoneos Path 2>/dev/null | sed -E 's/.*\/([^/]+)\.sdk/\1/' | tr '[:upper:]' '[:lower:]' || true)"
if [ -z "$DETECTED_SDK_NAME" ]; then
    DETECTED_SDK_NAME="iphoneos"
fi
echo "SDK de iOS detectado: $DETECTED_SDK_NAME"

rm -rf "$BUILD_DIR"
mkdir -p "$IPA_OUTPUT_DIR"

echo "========================================================"
echo "  1. Compilando y empaquetando Framework KMP (ComposeApp)"
echo "========================================================"
cd "$ROOT_DIR"
chmod +x ./gradlew

# 1a. Compila el binario estático Release para arm64 (iPhone / iPad)
./gradlew :shared:linkReleaseFrameworkIosArm64 --no-daemon

# 1b. Ejecuta la tarea oficial de empaquetado de Xcode de Kotlin Multiplatform
#     (exporta ComposeApp.framework a shared/build/xcode-frameworks/Release/$SDK_NAME).
#     Si fallara fuera de Xcode, el paso 2 copia el framework manualmente como respaldo.
mkdir -p "$BUILD_DIR/xcode-staging/XaviTV.app/Frameworks"
if ! CONFIGURATION="Release" \
    SDK_NAME="$DETECTED_SDK_NAME" \
    ARCHS="arm64" \
    EXPANDED_CODE_SIGN_IDENTITY="-" \
    CODE_SIGNING_REQUIRED="NO" \
    CODE_SIGNING_ALLOWED="NO" \
    TARGET_BUILD_DIR="$BUILD_DIR/xcode-staging" \
    FRAMEWORKS_FOLDER_PATH="XaviTV.app/Frameworks" \
    ./gradlew :shared:embedAndSignAppleFrameworkForXcode --no-daemon; then
    echo "Aviso: embedAndSignAppleFrameworkForXcode falló; se usará la copia manual del framework."
fi

echo "========================================================"
echo "  2. Verificando rutas de búsqueda de ComposeApp.framework"
echo "========================================================"
FRAMEWORK_SRC="$ROOT_DIR/shared/build/bin/iosArm64/releaseFramework/ComposeApp.framework"
if [ ! -d "$FRAMEWORK_SRC" ]; then
    echo "Error crítico: No se generó $FRAMEWORK_SRC"
    exit 1
fi

# Copia garantizada en iosApp/Frameworks (apuntada directamente por $(SRCROOT)/Frameworks)
mkdir -p "$SCRIPT_DIR/Frameworks"
rm -rf "$SCRIPT_DIR/Frameworks/ComposeApp.framework"
cp -R "$FRAMEWORK_SRC" "$SCRIPT_DIR/Frameworks/ComposeApp.framework"
echo "Framework disponible en: $SCRIPT_DIR/Frameworks/ComposeApp.framework"

for TARGET_SDK_DIR in "iphoneos" "$DETECTED_SDK_NAME"; do
    XCODE_FW_DIR="$ROOT_DIR/shared/build/xcode-frameworks/Release/$TARGET_SDK_DIR"
    mkdir -p "$XCODE_FW_DIR"
    rm -rf "$XCODE_FW_DIR/ComposeApp.framework"
    cp -R "$FRAMEWORK_SRC" "$XCODE_FW_DIR/ComposeApp.framework"
    echo "Framework disponible en: $XCODE_FW_DIR/ComposeApp.framework"
done

echo "========================================================"
echo "  3. Compilando proyecto Xcode (iosApp -> XaviTV.app)..."
echo "========================================================"
if [ "${SIGNED_ARCHIVE:-0}" = "1" ]; then
    xcodebuild archive \
        -project "$SCRIPT_DIR/iosApp.xcodeproj" \
        -scheme iosApp \
        -configuration Release \
        -sdk iphoneos \
        -archivePath "$ARCHIVE_PATH" \
        OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED=YES

    xcodebuild -exportArchive \
        -archivePath "$ARCHIVE_PATH" \
        -exportOptionsPlist "$SCRIPT_DIR/ExportOptions.plist" \
        -exportPath "$IPA_OUTPUT_DIR"
else
    xcodebuild build \
        -project "$SCRIPT_DIR/iosApp.xcodeproj" \
        -scheme iosApp \
        -configuration Release \
        -sdk iphoneos \
        -derivedDataPath "$BUILD_DIR/DerivedData" \
        CODE_SIGN_IDENTITY="" \
        CODE_SIGNING_REQUIRED=NO \
        CODE_SIGNING_ALLOWED=NO \
        OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED=YES

    APP_BUNDLE="$(find "$BUILD_DIR/DerivedData" -name "XaviTV.app" -type d | head -n 1)"
    if [ -z "$APP_BUNDLE" ]; then
        echo "Error: No se encontró XaviTV.app tras la compilación."
        exit 1
    fi

    PAYLOAD_DIR="$BUILD_DIR/Payload"
    rm -rf "$PAYLOAD_DIR"
    mkdir -p "$PAYLOAD_DIR"
    cp -R "$APP_BUNDLE" "$PAYLOAD_DIR/XaviTV.app"

    cd "$BUILD_DIR"
    zip -qry "$IPA_FILE" Payload
    rm -rf "$PAYLOAD_DIR"
fi

echo "========================================================"
echo "  Paquete IPA generado con éxito en:"
echo "  $IPA_FILE"
echo "========================================================"
