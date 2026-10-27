package pb;

import java.util.concurrent.TimeUnit;
import nb.w;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10181a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f10182b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f10183c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f10184d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f10185e;

    /* renamed from: f, reason: collision with root package name */
    public static final g f10186f;
    public static final androidx.leanback.widget.i g;

    /* renamed from: h, reason: collision with root package name */
    public static final androidx.leanback.widget.i f10187h;

    static {
        String str;
        int i10 = w.f9346a;
        try {
            str = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "DefaultDispatcher";
        }
        f10181a = str;
        f10182b = nb.a.h(100000L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.resolution.ns");
        int i11 = w.f9346a;
        if (i11 < 2) {
            i11 = 2;
        }
        f10183c = nb.a.i("kotlinx.coroutines.scheduler.core.pool.size", i11, 8);
        f10184d = nb.a.i("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 4);
        f10185e = TimeUnit.SECONDS.toNanos(nb.a.h(60L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        f10186f = g.f10176a;
        g = new androidx.leanback.widget.i(0);
        f10187h = new androidx.leanback.widget.i(1);
    }
}
