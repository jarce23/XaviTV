package y4;

import android.content.Context;
import android.os.PowerManager;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13840a;

    static {
        String f10 = o4.p.f("WakeLocks");
        za.h.d("tagWithPrefix(\"WakeLocks\")", f10);
        f13840a = f10;
    }

    public static final PowerManager.WakeLock a(Context context, String str) {
        za.h.e("context", context);
        za.h.e("tag", str);
        Object systemService = context.getApplicationContext().getSystemService("power");
        za.h.c("null cannot be cast to non-null type android.os.PowerManager", systemService);
        String concat = "WorkManager: ".concat(str);
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, concat);
        synchronized (o.f13841a) {
        }
        za.h.d("wakeLock", newWakeLock);
        return newWakeLock;
    }
}
