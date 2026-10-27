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
if [ -f "$SCRIPT_DIR/Frameworks/ComposeApp.framework/ComposeApp" ]; then
    chmod +x "$SCRIPT_DIR/Frameworks/ComposeApp.framework/ComposeApp"
fi
rm -rf "$SCRIPT_DIR/Frameworks/ComposeApp.framework/_CodeSignature"
codesign --remove-signature "$SCRIPT_DIR/Frameworks/ComposeApp.framework" 2>/dev/null || true
xattr -rc "$SCRIPT_DIR/Frameworks/ComposeApp.framework" 2>/dev/null || true
echo "Framework disponible en: $SCRIPT_DIR/Frameworks/ComposeApp.framework"

for TARGET_SDK_DIR in "iphoneos" "$DETECTED_SDK_NAME"; do
    XCODE_FW_DIR="$ROOT_DIR/shared/build/xcode-frameworks/Release/$TARGET_SDK_DIR"
    mkdir -p "$XCODE_FW_DIR"
    rm -rf "$XCODE_FW_DIR/ComposeApp.framework"
    cp -R "$FRAMEWORK_SRC" "$XCODE_FW_DIR/ComposeApp.framework"
    echo "Framework disponible en: $XCODE_FW_DIR/ComposeApp.framework"
done

echo "========================================================"
echo "  2b. Instalando CocoaPods (MobileVLCKit)..."
echo "========================================================"
if command -v pod >/dev/null 2>&1 && [ -f "$SCRIPT_DIR/Podfile" ]; then
    echo "Ejecutando pod install --repo-update en $SCRIPT_DIR..."
    (cd "$SCRIPT_DIR" && (pod install --repo-update || pod install)) || echo "Aviso: pod install finalizó con advertencias."
fi

echo "========================================================"
echo "  2c. Copiando MobileVLCKit.framework en iosApp/Frameworks"
echo "========================================================"
mkdir -p "$SCRIPT_DIR/Frameworks"
VLC_FW_SRC="$(find "$SCRIPT_DIR/Pods" -name "MobileVLCKit.framework" -type d 2>/dev/null | grep -i "ios-arm64" | grep -v -i "simulator" | grep -v -i "macos" | head -n 1 || true)"
if [ -z "$VLC_FW_SRC" ]; then
    VLC_FW_SRC="$(find "$SCRIPT_DIR/Pods" -name "MobileVLCKit.framework" -type d 2>/dev/null | grep -v -i "simulator" | grep -v -i "macos" | head -n 1 || true)"
fi

if [ -n "$VLC_FW_SRC" ] && [ -d "$VLC_FW_SRC" ]; then
    echo "MobileVLCKit.framework físico (arm64) localizado en: $VLC_FW_SRC"
    rm -rf "$SCRIPT_DIR/Frameworks/MobileVLCKit.framework"
    cp -R "$VLC_FW_SRC" "$SCRIPT_DIR/Frameworks/MobileVLCKit.framework"
    FW_BIN="$SCRIPT_DIR/Frameworks/MobileVLCKit.framework/MobileVLCKit"
    if [ -f "$FW_BIN" ]; then
        chmod +x "$FW_BIN"
        if xcrun lipo -info "$FW_BIN" 2>/dev/null | grep -q "Non-fat"; then
            echo "MobileVLCKit ya es single-architecture"
        else
            echo "Adelgazando MobileVLCKit a arm64 puro con lipo..."
            xcrun lipo -thin arm64 "$FW_BIN" -output "$FW_BIN" 2>/dev/null || true
        fi
    fi
    rm -rf "$SCRIPT_DIR/Frameworks/MobileVLCKit.framework/_CodeSignature"
    codesign --remove-signature "$SCRIPT_DIR/Frameworks/MobileVLCKit.framework" 2>/dev/null || true
    xattr -rc "$SCRIPT_DIR/Frameworks/MobileVLCKit.framework" 2>/dev/null || true
    echo "MobileVLCKit.framework copiado con éxito a: $SCRIPT_DIR/Frameworks/MobileVLCKit.framework"
else
    echo "Aviso: No se localizó MobileVLCKit.framework en Pods aún."
fi

# Selección de target: Espacio de trabajo de CocoaPods si existe, o proyecto Xcode
if [ -d "$SCRIPT_DIR/iosApp.xcworkspace" ]; then
    XCODE_TARGET_ARG="-workspace"
    XCODE_TARGET_PATH="$SCRIPT_DIR/iosApp.xcworkspace"
    echo "Usando espacio de trabajo CocoaPods obligatorio: iosApp.xcworkspace"
else
    XCODE_TARGET_ARG="-project"
    XCODE_TARGET_PATH="$SCRIPT_DIR/iosApp.xcodeproj"
    echo "Usando proyecto Xcode estándar: iosApp.xcodeproj"
fi

echo "========================================================"
echo "  3. Compilando proyecto Xcode (iosApp -> XaviTV.app)..."
echo "========================================================"
if [ "${SIGNED_ARCHIVE:-0}" = "1" ]; then
    xcodebuild archive \
        "$XCODE_TARGET_ARG" "$XCODE_TARGET_PATH" \
        -scheme iosApp \
        -configuration Release \
        -sdk iphoneos \
        -archivePath "$ARCHIVE_PATH" \
        PODS_ROOT="$SCRIPT_DIR/Pods" \
        PODS_PODFILE_DIR_PATH="$SCRIPT_DIR" \
        CODE_SIGN_IDENTITY="" \
        CODE_SIGNING_REQUIRED=NO \
        CODE_SIGNING_ALLOWED=NO \
        OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED=YES

    xcodebuild -exportArchive \
        -archivePath "$ARCHIVE_PATH" \
        -exportOptionsPlist "$SCRIPT_DIR/ExportOptions.plist" \
        -exportPath "$IPA_OUTPUT_DIR"
else
    xcodebuild build \
        "$XCODE_TARGET_ARG" "$XCODE_TARGET_PATH" \
        -scheme iosApp \
        -configuration Release \
        -sdk iphoneos \
        -derivedDataPath "$BUILD_DIR/DerivedData" \
        PODS_ROOT="$SCRIPT_DIR/Pods" \
        PODS_PODFILE_DIR_PATH="$SCRIPT_DIR" \
        CODE_SIGN_IDENTITY="" \
        CODE_SIGNING_REQUIRED=NO \
        CODE_SIGNING_ALLOWED=NO \
        OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED=YES

    APP_BUNDLE="$(find "$BUILD_DIR/DerivedData" -name "XaviTV.app" -type d | head -n 1)"
    if [ -z "$APP_BUNDLE" ]; then
        echo "Error: No se encontró XaviTV.app tras la compilación."
        exit 1
    fi

    # Garantiza que ÚNICAMENTE MobileVLCKit.framework esté dentro de Frameworks/ de la aplicación.
    # MobileVLCKit es un framework dinámico externo que dyld debe cargar en runtime.
    # Por el contrario, ComposeApp es un framework estático (isStatic = true) que Xcode enlaza
    # directamente dentro del ejecutable principal XaviTV; NO debe incluirse en Frameworks/
    # para evitar que herramientas como Sideloadly intenten firmarlo y fallen con Error -11.
    mkdir -p "$APP_BUNDLE/Frameworks"
    if [ -d "$SCRIPT_DIR/Frameworks/MobileVLCKit.framework" ]; then
        rm -rf "$APP_BUNDLE/Frameworks/MobileVLCKit.framework"
        cp -R "$SCRIPT_DIR/Frameworks/MobileVLCKit.framework" "$APP_BUNDLE/Frameworks/"
        echo "MobileVLCKit.framework incrustado en el bundle: $APP_BUNDLE/Frameworks/"
    fi
    rm -rf "$APP_BUNDLE/Frameworks/ComposeApp.framework"

    PAYLOAD_DIR="$BUILD_DIR/Payload"
    rm -rf "$PAYLOAD_DIR"
    mkdir -p "$PAYLOAD_DIR"
    cp -R "$APP_BUNDLE" "$PAYLOAD_DIR/XaviTV.app"

    # Eliminación obligatoria y estricta de ComposeApp.framework del bundle final
    rm -rf "$PAYLOAD_DIR/XaviTV.app/Frameworks/ComposeApp.framework"

    echo "========================================================"
    echo "  4. Saneando firmas y permisos Mach-O para Sideloadly"
    echo "========================================================"
    # 4a. Elimina extended attributes de Apple (quarantine, Finder info) y archivos ._*
    xattr -rc "$PAYLOAD_DIR" 2>/dev/null || true
    find "$PAYLOAD_DIR" -name "._*" -delete 2>/dev/null || true

    # 4b. Sanea cada framework dinámico incrustado (MobileVLCKit)
    if [ -d "$PAYLOAD_DIR/XaviTV.app/Frameworks" ]; then
        rm -rf "$PAYLOAD_DIR/XaviTV.app/Frameworks/ComposeApp.framework"
        for fw in "$PAYLOAD_DIR/XaviTV.app/Frameworks/"*.framework; do
            if [ -d "$fw" ]; then
                fw_name="$(basename "$fw" .framework)"
                echo "Saneando framework dinámico Mach-O: $fw_name..."
                rm -rf "$fw/_CodeSignature"
                codesign --remove-signature "$fw" 2>/dev/null || true
                if [ -f "$fw/$fw_name" ]; then
                    chmod +x "$fw/$fw_name"
                    if xcrun lipo -info "$fw/$fw_name" 2>/dev/null | grep -q "Non-fat"; then
                        echo "$fw_name ya es single-architecture"
                    else
                        echo "Adelgazando $fw_name a arm64 puro con lipo..."
                        xcrun lipo -thin arm64 "$fw/$fw_name" -output "$fw/$fw_name" 2>/dev/null || true
                    fi
                fi
                xattr -rc "$fw" 2>/dev/null || true
            fi
        done
    fi

    # 4c. Sanea el ejecutable principal y elimina firmas ad-hoc corruptas
    MAIN_APP_EXEC="$PAYLOAD_DIR/XaviTV.app/XaviTV"
    if [ -f "$MAIN_APP_EXEC" ]; then
        chmod +x "$MAIN_APP_EXEC"
    fi
    rm -rf "$PAYLOAD_DIR/XaviTV.app/_CodeSignature"
    codesign --remove-signature "$PAYLOAD_DIR/XaviTV.app" 2>/dev/null || true
    xattr -rc "$PAYLOAD_DIR" 2>/dev/null || true
    chmod -R u+w,go+rX "$PAYLOAD_DIR"

    cd "$BUILD_DIR"
    zip -qry "$IPA_FILE" Payload
    rm -rf "$PAYLOAD_DIR"
fi

echo "========================================================"
echo "  Paquete IPA generado con éxito en:"
echo "  $IPA_FILE"
echo "========================================================"
