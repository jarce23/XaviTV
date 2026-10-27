package i2;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public o9.g0 f6271a;

    /* renamed from: b, reason: collision with root package name */
    public i1.p f6272b;

    /* renamed from: c, reason: collision with root package name */
    public long f6273c;

    /* renamed from: d, reason: collision with root package name */
    public long f6274d;

    /* renamed from: e, reason: collision with root package name */
    public Executor f6275e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ u f6276f;

    public p(u uVar, Context context) {
        this.f6276f = uVar;
        l1.a0.L(context);
        o9.e0 e0Var = o9.g0.f9617p;
        this.f6271a = w0.f9686s;
        this.f6274d = -9223372036854775807L;
        this.f6275e = u.f6279o;
    }

    @Override // i2.n0
    public final void a() {
        u uVar = this.f6276f;
        if (uVar.f6290l == 2) {
            return;
        }
        l1.x xVar = uVar.f6287i;
        if (xVar != null) {
            xVar.f8138a.removeCallbacksAndMessages(null);
        }
        uVar.f6288j = null;
        uVar.f6290l = 2;
    }

    @Override // i2.n0
    public final boolean b() {
        return false;
    }

    @Override // i2.n0
    public final void c() {
        int i10 = l1.u.f8132c.f8133a;
        this.f6276f.f6288j = null;
    }

    @Override // i2.n0
    public final Surface d() {
        l1.d.g(false);
        throw null;
    }

    @Override // i2.n0
    public final void e(float f10) {
        this.f6276f.f6284e.e(f10);
    }

    @Override // i2.n0
    public final void f(i1.p pVar, long j10, int i10, List list) {
        l1.d.g(false);
        this.f6271a = o9.g0.n(list);
        this.f6272b = pVar;
        i1.o a10 = pVar.a();
        i1.g gVar = pVar.D;
        if (gVar == null || !gVar.d()) {
            gVar = i1.g.f5882h;
        }
        a10.C = gVar;
        a10.a();
        throw null;
    }

    @Override // i2.n0
    public final void g(h5.i iVar) {
        this.f6275e = s9.a.f11663o;
    }

    @Override // i2.n0
    public final void h(boolean z10) {
        this.f6274d = -9223372036854775807L;
        u uVar = this.f6276f;
        d dVar = uVar.f6284e;
        if (uVar.f6290l == 1) {
            uVar.f6289k++;
            dVar.h(z10);
            while (uVar.f6286h.h() > 1) {
                uVar.f6286h.e();
            }
            if (uVar.f6286h.h() == 1) {
                ((t) uVar.f6286h.e()).getClass();
                throw null;
            }
            uVar.f6291m = -9223372036854775807L;
            l1.x xVar = uVar.f6287i;
            l1.d.h(xVar);
            xVar.c(new androidx.activity.d(14, uVar));
        }
    }

    @Override // i2.n0
    public final void i(List list) {
        if (this.f6271a.equals(list)) {
            return;
        }
        this.f6271a = o9.g0.n(list);
        i1.p pVar = this.f6272b;
        if (pVar == null) {
            return;
        }
        i1.o a10 = pVar.a();
        i1.g gVar = pVar.D;
        if (gVar == null || !gVar.d()) {
            gVar = i1.g.f5882h;
        }
        a10.C = gVar;
        a10.a();
        throw null;
    }

    @Override // i2.n0
    public final void j() {
        u uVar = this.f6276f;
        if (uVar.f6283d) {
            uVar.f6284e.j();
        }
    }

    @Override // i2.n0
    public final boolean k(long j10, h hVar) {
        l1.d.g(false);
        int i10 = this.f6276f.f6292n;
        if (i10 == -1 || i10 != 0) {
            return false;
        }
        throw null;
    }

    @Override // i2.n0
    public final void l(y yVar) {
        this.f6276f.f6284e.f6152i = yVar;
    }

    @Override // i2.n0
    public final void m(long j10, long j11) {
        this.f6276f.f6284e.m(j10 + this.f6273c, j11);
    }

    @Override // i2.n0
    public final void n(boolean z10) {
        u uVar = this.f6276f;
        if (uVar.f6283d) {
            uVar.f6284e.n(z10);
        }
    }

    @Override // i2.n0
    public final boolean o(boolean z10) {
        return this.f6276f.f6284e.f6145a.b(false);
    }

    @Override // i2.n0
    public final void p() {
        u uVar = this.f6276f;
        if (uVar.f6283d) {
            uVar.f6284e.p();
        }
    }

    @Override // i2.n0
    public final boolean q(i1.p pVar) {
        u uVar = this.f6276f;
        boolean z10 = true;
        l1.d.g(uVar.f6290l == 0);
        i1.g gVar = pVar.D;
        if (gVar == null || !gVar.d()) {
            gVar = i1.g.f5882h;
        }
        int i10 = gVar.f5891c;
        if (i10 == 7) {
            try {
                int i11 = Build.VERSION.SDK_INT;
                if (i11 < 34) {
                    if (i11 >= 33 && l1.b.m("EGL_EXT_gl_colorspace_bt2020_pq")) {
                        l1.v vVar = uVar.f6285f;
                        Looper myLooper = Looper.myLooper();
                        l1.d.h(myLooper);
                        uVar.f6287i = vVar.a(myLooper, null);
                        uVar.f6281b.a();
                        throw null;
                    }
                }
            } catch (l1.j e7) {
                throw new m0(e7, pVar);
            }
        }
        if (i10 == 6) {
            if (Build.VERSION.SDK_INT < 33 || !l1.b.m("EGL_EXT_gl_colorspace_bt2020_pq")) {
                z10 = false;
            }
        } else if (i10 == 7) {
            z10 = l1.b.m("EGL_EXT_gl_colorspace_bt2020_hlg");
        }
        if (!z10 && Build.VERSION.SDK_INT >= 29) {
            Locale locale = Locale.US;
            l1.b.q("PlaybackVidGraphWrapper", "Color transfer " + i10 + " is not supported. Falling back to OpenGl tone mapping.");
            i1.g gVar2 = i1.g.f5882h;
        }
        l1.v vVar2 = uVar.f6285f;
        Looper myLooper2 = Looper.myLooper();
        l1.d.h(myLooper2);
        uVar.f6287i = vVar2.a(myLooper2, null);
        uVar.f6281b.a();
        throw null;
    }

    @Override // i2.n0
    public final void s(long j10) {
        this.f6273c = j10;
    }

    @Override // i2.n0
    public final void t(Surface surface, l1.u uVar) {
        u uVar2 = this.f6276f;
        Pair pair = uVar2.f6288j;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((l1.u) uVar2.f6288j.second).equals(uVar)) {
            return;
        }
        uVar2.f6288j = Pair.create(surface, uVar);
        int i10 = uVar.f8133a;
    }

    @Override // i2.n0
    public final void u() {
        long j10 = this.f6274d;
        u uVar = this.f6276f;
        if (uVar.f6291m >= j10) {
            uVar.f6284e.u();
        }
    }

    @Override // i2.n0
    public final boolean v() {
        return false;
    }

    @Override // i2.n0
    public final void w() {
        u uVar = this.f6276f;
        if (uVar.f6286h.h() == 0) {
            uVar.f6284e.w();
            return;
        }
        app.shamel.tv.activities.v vVar = new app.shamel.tv.activities.v();
        if (uVar.f6286h.h() <= 0) {
            uVar.f6286h = vVar;
        } else {
            ((t) uVar.f6286h.e()).getClass();
            throw null;
        }
    }

    @Override // i2.n0
    public final void x(int i10) {
        this.f6276f.f6284e.x(i10);
    }

    @Override // i2.n0
    public final void r() {
    }
}
