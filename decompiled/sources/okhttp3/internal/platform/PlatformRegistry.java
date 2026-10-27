package okhttp3.internal.platform;

import android.content.Context;
import android.os.Build;
import android.support.v4.media.d;
import okhttp3.internal.platform.android.AndroidLog;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class PlatformRegistry {
    public static final PlatformRegistry INSTANCE = new PlatformRegistry();

    private PlatformRegistry() {
    }

    public final Platform findPlatform() {
        AndroidLog.INSTANCE.enable();
        Platform buildIfSupported = Android10Platform.Companion.buildIfSupported();
        if (buildIfSupported == null) {
            buildIfSupported = AndroidPlatform.Companion.buildIfSupported();
        }
        if (buildIfSupported != null) {
            return buildIfSupported;
        }
        throw new IllegalStateException(d.m(Build.VERSION.SDK_INT, "Expected Android API level 21+ but was "));
    }

    public final Context getApplicationContext() {
        Object obj = Platform.Companion.get();
        ContextAwarePlatform contextAwarePlatform = obj instanceof ContextAwarePlatform ? (ContextAwarePlatform) obj : null;
        if (contextAwarePlatform != null) {
            return contextAwarePlatform.getApplicationContext();
        }
        return null;
    }

    public final boolean isAndroid() {
        return true;
    }

    public final void setApplicationContext(Context context) {
        Object obj = Platform.Companion.get();
        ContextAwarePlatform contextAwarePlatform = obj instanceof ContextAwarePlatform ? (ContextAwarePlatform) obj : null;
        if (contextAwarePlatform != null) {
            contextAwarePlatform.setApplicationContext(context);
        }
    }
}
