package k2;

import java.util.List;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 implements n {

    /* renamed from: a, reason: collision with root package name */
    public final int f7696a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7697b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7698c;

    /* renamed from: d, reason: collision with root package name */
    public int f7699d;

    /* renamed from: e, reason: collision with root package name */
    public int f7700e;

    /* renamed from: f, reason: collision with root package name */
    public p f7701f;
    public g0 g;

    public c0(String str, int i10, int i11) {
        this.f7696a = i10;
        this.f7697b = i11;
        this.f7698c = str;
    }

    @Override // k2.n
    public final void c(p pVar) {
        this.f7701f = pVar;
        g0 q10 = pVar.q(1024, 4);
        this.g = q10;
        i1.o oVar = new i1.o();
        String str = this.f7698c;
        oVar.f5939l = i1.g0.m(str);
        oVar.f5940m = i1.g0.m(str);
        r.a.i(oVar, q10);
        this.f7701f.f();
        this.f7701f.t(new d0());
        this.f7700e = 1;
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        if (j10 == 0 || this.f7700e == 1) {
            this.f7700e = 1;
            this.f7699d = 0;
        }
    }

    @Override // k2.n
    public final int f(o oVar, i1.s sVar) {
        int i10 = this.f7700e;
        if (i10 != 1) {
            if (i10 == 2) {
                return -1;
            }
            throw new IllegalStateException();
        }
        g0 g0Var = this.g;
        g0Var.getClass();
        int f10 = g0Var.f(oVar, 1024, true);
        if (f10 != -1) {
            this.f7699d += f10;
            return 0;
        }
        this.f7700e = 2;
        this.g.e(0L, 1, this.f7699d, 0, null);
        this.f7699d = 0;
        return 0;
    }

    @Override // k2.n
    public final List g() {
        o9.e0 e0Var = o9.g0.f9617p;
        return w0.f9686s;
    }

    @Override // k2.n
    public final boolean m(o oVar) {
        int i10 = this.f7697b;
        int i11 = this.f7696a;
        l1.d.g((i11 == -1 || i10 == -1) ? false : true);
        l1.t tVar = new l1.t(i10);
        ((k) oVar).m(tVar.f8129a, 0, i10, false);
        return tVar.C() == i11;
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final n b() {
        return this;
    }
}
