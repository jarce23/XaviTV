package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class p1 extends l {

    /* renamed from: k, reason: collision with root package name */
    public final a f2679k;

    public p1(a aVar) {
        this.f2679k = aVar;
    }

    public void A() {
        z();
    }

    @Override // c2.a
    public final i1.t0 f() {
        return this.f2679k.f();
    }

    @Override // c2.a
    public final i1.a0 g() {
        return this.f2679k.g();
    }

    @Override // c2.a
    public final boolean h() {
        return this.f2679k.h();
    }

    @Override // c2.a
    public final void k(o1.e0 e0Var) {
        this.f2635j = e0Var;
        this.f2634i = l1.a0.n(null);
        A();
    }

    @Override // c2.a
    public void r(i1.a0 a0Var) {
        this.f2679k.r(a0Var);
    }

    @Override // c2.l
    public final d0 s(Object obj, d0 d0Var) {
        return x(d0Var);
    }

    @Override // c2.l
    public final long t(long j10, Object obj) {
        return j10;
    }

    @Override // c2.l
    public final int u(int i10, Object obj) {
        return i10;
    }

    @Override // c2.l
    public final void v(Object obj, a aVar, i1.t0 t0Var) {
        y(t0Var);
    }

    public abstract void y(i1.t0 t0Var);

    public final void z() {
        w(null, this.f2679k);
    }

    public d0 x(d0 d0Var) {
        return d0Var;
    }
}
