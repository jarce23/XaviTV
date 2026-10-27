package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v implements b0, a0 {

    /* renamed from: o, reason: collision with root package name */
    public final d0 f2736o;

    /* renamed from: p, reason: collision with root package name */
    public final long f2737p;

    /* renamed from: q, reason: collision with root package name */
    public final g2.e f2738q;

    /* renamed from: r, reason: collision with root package name */
    public a f2739r;

    /* renamed from: s, reason: collision with root package name */
    public b0 f2740s;

    /* renamed from: t, reason: collision with root package name */
    public a0 f2741t;

    /* renamed from: u, reason: collision with root package name */
    public long f2742u = -9223372036854775807L;

    public v(d0 d0Var, g2.e eVar, long j10) {
        this.f2736o = d0Var;
        this.f2738q = eVar;
        this.f2737p = j10;
    }

    @Override // c2.g1
    public final boolean a() {
        b0 b0Var = this.f2740s;
        return b0Var != null && b0Var.a();
    }

    @Override // c2.f1
    public final void b(g1 g1Var) {
        a0 a0Var = this.f2741t;
        int i10 = l1.a0.f8067a;
        a0Var.b(this);
    }

    @Override // c2.a0
    public final void c(b0 b0Var) {
        a0 a0Var = this.f2741t;
        int i10 = l1.a0.f8067a;
        a0Var.c(this);
    }

    public final void d(d0 d0Var) {
        long j10 = this.f2742u;
        if (j10 == -9223372036854775807L) {
            j10 = this.f2737p;
        }
        a aVar = this.f2739r;
        aVar.getClass();
        b0 a10 = aVar.a(d0Var, this.f2738q, j10);
        this.f2740s = a10;
        if (this.f2741t != null) {
            a10.l(this, j10);
        }
    }

    @Override // c2.g1
    public final long e() {
        b0 b0Var = this.f2740s;
        int i10 = l1.a0.f8067a;
        return b0Var.e();
    }

    @Override // c2.b0
    public final long g() {
        b0 b0Var = this.f2740s;
        int i10 = l1.a0.f8067a;
        return b0Var.g();
    }

    @Override // c2.b0
    public final long h(long j10, s1.f1 f1Var) {
        b0 b0Var = this.f2740s;
        int i10 = l1.a0.f8067a;
        return b0Var.h(j10, f1Var);
    }

    @Override // c2.b0
    public final n1 j() {
        b0 b0Var = this.f2740s;
        int i10 = l1.a0.f8067a;
        return b0Var.j();
    }

    @Override // c2.b0
    public final long k(f2.t[] tVarArr, boolean[] zArr, e1[] e1VarArr, boolean[] zArr2, long j10) {
        long j11 = this.f2742u;
        long j12 = (j11 == -9223372036854775807L || j10 != this.f2737p) ? j10 : j11;
        this.f2742u = -9223372036854775807L;
        b0 b0Var = this.f2740s;
        int i10 = l1.a0.f8067a;
        return b0Var.k(tVarArr, zArr, e1VarArr, zArr2, j12);
    }

    @Override // c2.b0
    public final void l(a0 a0Var, long j10) {
        this.f2741t = a0Var;
        b0 b0Var = this.f2740s;
        if (b0Var != null) {
            long j11 = this.f2742u;
            if (j11 == -9223372036854775807L) {
                j11 = this.f2737p;
            }
            b0Var.l(this, j11);
        }
    }

    @Override // c2.g1
    public final long m() {
        b0 b0Var = this.f2740s;
        int i10 = l1.a0.f8067a;
        return b0Var.m();
    }

    @Override // c2.b0
    public final void n() {
        b0 b0Var = this.f2740s;
        if (b0Var != null) {
            b0Var.n();
            return;
        }
        a aVar = this.f2739r;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // c2.b0
    public final long p(long j10) {
        b0 b0Var = this.f2740s;
        int i10 = l1.a0.f8067a;
        return b0Var.p(j10);
    }

    @Override // c2.b0
    public final void r(long j10) {
        b0 b0Var = this.f2740s;
        int i10 = l1.a0.f8067a;
        b0Var.r(j10);
    }

    @Override // c2.g1
    public final boolean s(s1.k0 k0Var) {
        b0 b0Var = this.f2740s;
        return b0Var != null && b0Var.s(k0Var);
    }

    @Override // c2.g1
    public final void v(long j10) {
        b0 b0Var = this.f2740s;
        int i10 = l1.a0.f8067a;
        b0Var.v(j10);
    }
}
