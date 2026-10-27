package v1;

import android.os.Build;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g implements r1.a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f12654a;

    static {
        boolean z10;
        if ("Amazon".equals(Build.MANUFACTURER)) {
            String str = Build.MODEL;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z10 = true;
                f12654a = z10;
            }
        }
        z10 = false;
        f12654a = z10;
    }
}
