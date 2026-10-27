package l7;

import android.os.Looper;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: i, reason: collision with root package name */
    public static final Object f8300i = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final b f8301a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8302b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8303c;
    public o g;

    /* renamed from: h, reason: collision with root package name */
    public androidx.activity.j f8307h;

    /* renamed from: e, reason: collision with root package name */
    public long f8305e = -1;

    /* renamed from: f, reason: collision with root package name */
    public long f8306f = 0;

    /* renamed from: d, reason: collision with root package name */
    public final b8.e f8304d = new b8.e(Looper.getMainLooper(), 2);

    public p(long j10, String str) {
        this.f8302b = j10;
        this.f8303c = str;
        this.f8301a = new b("RequestTracker", str);
    }

    public final void a(long j10, o oVar) {
        o oVar2;
        long j11;
        long j12;
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = f8300i;
        synchronized (obj) {
            oVar2 = this.g;
            j11 = this.f8305e;
            j12 = this.f8306f;
            this.f8305e = j10;
            this.g = oVar;
            this.f8306f = currentTimeMillis;
        }
        if (oVar2 != null) {
            oVar2.g(j11, j12, currentTimeMillis, this.f8303c);
        }
        synchronized (obj) {
            try {
                androidx.activity.j jVar = this.f8307h;
                if (jVar != null) {
                    this.f8304d.removeCallbacks(jVar);
                }
                androidx.activity.j jVar2 = new androidx.activity.j(24, this);
                this.f8307h = jVar2;
                this.f8304d.postDelayed(jVar2, this.f8302b);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(long j10, int i10, m mVar) {
        synchronized (f8300i) {
            try {
                if (c(j10)) {
                    Locale locale = Locale.ROOT;
                    e(i10, mVar, "request " + j10 + " completed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c(long j10) {
        boolean z10;
        synchronized (f8300i) {
            long j11 = this.f8305e;
            z10 = false;
            if (j11 != -1 && j11 == j10) {
                z10 = true;
            }
        }
        return z10;
    }

    public final boolean d() {
        boolean z10;
        synchronized (f8300i) {
            z10 = this.f8305e != -1;
        }
        return z10;
    }

    public final void e(int i10, Object obj, String str) {
        this.f8301a.b(str, new Object[0]);
        Object obj2 = f8300i;
        synchronized (obj2) {
            try {
                if (this.g != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    o oVar = this.g;
                    r7.r.e(oVar);
                    oVar.n(this.f8303c, this.f8305e, i10, obj, this.f8306f, currentTimeMillis);
                }
                this.f8305e = -1L;
                this.g = null;
                synchronized (obj2) {
                    androidx.activity.j jVar = this.f8307h;
                    if (jVar != null) {
                        this.f8304d.removeCallbacks(jVar);
                        this.f8307h = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            } finally {
            }
        }
    }

    public final boolean f(int i10) {
        synchronized (f8300i) {
            try {
                if (!d()) {
                    return false;
                }
                Locale locale = Locale.ROOT;
                e(i10, null, "clearing request " + this.f8305e);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
