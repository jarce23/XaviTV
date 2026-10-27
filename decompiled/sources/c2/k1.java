package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k1 implements e1 {

    /* renamed from: o, reason: collision with root package name */
    public final e1 f2631o;

    /* renamed from: p, reason: collision with root package name */
    public final long f2632p;

    public k1(e1 e1Var, long j10) {
        this.f2631o = e1Var;
        this.f2632p = j10;
    }

    @Override // c2.e1
    public final int f(x4.e eVar, r1.e eVar2, int i10) {
        int f10 = this.f2631o.f(eVar, eVar2, i10);
        if (f10 == -4) {
            eVar2.f10412u += this.f2632p;
        }
        return f10;
    }

    @Override // c2.e1
    public final boolean isReady() {
        return this.f2631o.isReady();
    }

    @Override // c2.e1
    public final void r() {
        this.f2631o.r();
    }

    @Override // c2.e1
    public final int t(long j10) {
        return this.f2631o.t(j10 - this.f2632p);
    }
}
