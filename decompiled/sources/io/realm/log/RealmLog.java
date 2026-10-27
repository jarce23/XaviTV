package io.realm.log;

import android.util.Log;
import java.net.URISyntaxException;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class RealmLog {
    public static void a(URISyntaxException uRISyntaxException, String str, Object... objArr) {
        b(6, uRISyntaxException, str, objArr);
    }

    public static void b(int i10, Throwable th, String str, Object... objArr) {
        if (i10 < nativeGetLogLevel()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        if (str != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        if (th != null) {
            sb2.append(Log.getStackTraceString(th));
        }
        if (str != null) {
            if (th != null) {
                sb2.append("\n");
            }
            sb2.append(str);
        }
        nativeLog(i10, "REALM_JAVA", th, sb2.toString());
    }

    public static void c(String str, Object... objArr) {
        b(5, null, str, objArr);
    }

    private static native int nativeGetLogLevel();

    private static native void nativeLog(int i10, String str, Throwable th, String str2);
}
