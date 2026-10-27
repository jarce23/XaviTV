package n;

import android.os.Looper;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends j1.c {

    /* renamed from: c, reason: collision with root package name */
    public static volatile a f9087c;

    /* renamed from: d, reason: collision with root package name */
    public static final i2.a f9088d = new i2.a(1);

    /* renamed from: b, reason: collision with root package name */
    public final c f9089b = new c();

    public static a w() {
        if (f9087c != null) {
            return f9087c;
        }
        synchronized (a.class) {
            try {
                if (f9087c == null) {
                    f9087c = new a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f9087c;
    }

    public final void x(Runnable runnable) {
        c cVar = this.f9089b;
        if (cVar.f9093d == null) {
            synchronized (cVar.f9091b) {
                try {
                    if (cVar.f9093d == null) {
                        cVar.f9093d = c.w(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        cVar.f9093d.post(runnable);
    }
}
