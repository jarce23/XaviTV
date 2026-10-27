#!/usr/bin/env bash
# ==============================================================================
# XaviTV - Script de Compilación y Empaquetado (.ipa) para iOS (iPhone e iPad)
# Soporta tanto exportación firmada (Xcode Archive -> ExportOptions.plist)
# como generación de paquete .ipa sin firma (unsigned/AltStore/Sideloadly).
# ==============================================================================
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"
BUILD_DIR="$SCRIPT_DIR/build"
ARCHIVE_PATH="$BUILD_DIR/XaviTV.xcarchive"
IPA_OUTPUT_DIR="$BUILD_DIR/ipa"
IPA_FILE="$IPA_OUTPUT_DIR/XaviTV.ipa"

echo "========================================================"
echo "  1. Compilando Framework Kotlin Multiplatform (iOS)..."
echo "========================================================"
cd "$ROOT_DIR"
chmod +x ./gradlew
./gradlew :shared:linkReleaseFrameworkIosArm64

echo "========================================================"
echo "  2. Preparando el directorio del Framework para Xcode..."
echo "========================================================"
FRAMEWORK_SRC="$ROOT_DIR/shared/build/bin/iosArm64/releaseFramework/ComposeApp.framework"
XCODE_FW_DIR="$ROOT_DIR/shared/build/xcode-frameworks/Release/iphoneos"
mkdir -p "$XCODE_FW_DIR"
rm -rf "$XCODE_FW_DIR/ComposeApp.framework"
cp -R "$FRAMEWORK_SRC" "$XCODE_FW_DIR/ComposeApp.framework"

echo "========================================================"
echo "  3. Compilando proyecto Xcode (iosApp -> XaviTV.app)..."
echo "========================================================"
rm -rf "$BUILD_DIR"
mkdir -p "$IPA_OUTPUT_DIR"

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
