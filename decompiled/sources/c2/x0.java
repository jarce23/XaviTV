package c2;

import android.net.Uri;
import android.os.Looper;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x0 extends a {

    /* renamed from: h, reason: collision with root package name */
    public final o1.g f2752h;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.fragment.app.v0 f2753i;

    /* renamed from: j, reason: collision with root package name */
    public final v1.f f2754j;

    /* renamed from: k, reason: collision with root package name */
    public final n7.i f2755k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2756l;

    /* renamed from: m, reason: collision with root package name */
    public final i1.p f2757m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2758n = true;

    /* renamed from: o, reason: collision with root package name */
    public long f2759o = -9223372036854775807L;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2760p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2761q;

    /* renamed from: r, reason: collision with root package name */
    public o1.e0 f2762r;

    /* renamed from: s, reason: collision with root package name */
    public i1.a0 f2763s;

    public x0(i1.a0 a0Var, o1.g gVar, androidx.fragment.app.v0 v0Var, v1.f fVar, n7.i iVar, int i10, i1.p pVar) {
        this.f2763s = a0Var;
        this.f2752h = gVar;
        this.f2753i = v0Var;
        this.f2754j = fVar;
        this.f2755k = iVar;
        this.f2756l = i10;
        this.f2757m = pVar;
    }

    @Override // c2.a
    public final b0 a(d0 d0Var, g2.e eVar, long j10) {
        o1.h d6 = this.f2752h.d();
        o1.e0 e0Var = this.f2762r;
        if (e0Var != null) {
            d6.g(e0Var);
        }
        i1.x xVar = g().f5793b;
        xVar.getClass();
        Uri uri = xVar.f6061a;
        l1.d.h(this.g);
        int i10 = 0;
        return new u0(uri, d6, new x4.m((k2.q) this.f2753i.f843p), this.f2754j, new j0(this.f2521d.f2623c, i10, d0Var), this.f2755k, new j0(this.f2520c.f2623c, i10, d0Var), this, eVar, this.f2756l, this.f2757m, l1.a0.O(xVar.f6065e), null);
    }

    @Override // c2.a
    public final synchronized i1.a0 g() {
        return this.f2763s;
    }

    @Override // c2.a
    public final void k(o1.e0 e0Var) {
        this.f2762r = e0Var;
        Looper myLooper = Looper.myLooper();
        myLooper.getClass();
        t1.u uVar = this.g;
        l1.d.h(uVar);
        v1.f fVar = this.f2754j;
        fVar.n(myLooper, uVar);
        fVar.b();
        s();
    }

    @Override // c2.a
    public final void m(b0 b0Var) {
        u0 u0Var = (u0) b0Var;
        if (u0Var.K) {
            for (d1 d1Var : u0Var.H) {
                d1Var.j();
                p4.p pVar = d1Var.f2550h;
                if (pVar != null) {
                    pVar.m(d1Var.f2548e);
                    d1Var.f2550h = null;
                    d1Var.g = null;
                }
            }
        }
        u0Var.f2735z.c(u0Var);
        u0Var.E.removeCallbacksAndMessages(null);
        u0Var.F = null;
        u0Var.f2723c0 = true;
    }

    @Override // c2.a
    public final void o() {
        this.f2754j.a();
    }

    @Override // c2.a
    public final synchronized void r(i1.a0 a0Var) {
        this.f2763s = a0Var;
    }

    public final void s() {
        long j10 = this.f2759o;
        boolean z10 = this.f2760p;
        boolean z11 = this.f2761q;
        i1.a0 g = g();
        i1.t0 i1Var = new i1(-9223372036854775807L, -9223372036854775807L, j10, j10, 0L, 0L, z10, false, false, null, g, z11 ? g.f5794c : null);
        if (this.f2758n) {
            i1Var = new v0(i1Var);
        }
        l(i1Var);
    }

    public final void t(long j10, k2.a0 a0Var, boolean z10) {
        if (j10 == -9223372036854775807L) {
            j10 = this.f2759o;
        }
        boolean h10 = a0Var.h();
        if (!this.f2758n && this.f2759o == j10 && this.f2760p == h10 && this.f2761q == z10) {
            return;
        }
        this.f2759o = j10;
        this.f2760p = h10;
        this.f2761q = z10;
        this.f2758n = false;
        s();
    }

    @Override // c2.a
    public final void i() {
    }
}
