package j9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 implements k9.f {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f7224o;

    /* renamed from: p, reason: collision with root package name */
    public final k9.e f7225p;

    /* renamed from: q, reason: collision with root package name */
    public final d1 f7226q;

    /* renamed from: r, reason: collision with root package name */
    public final k9.e f7227r;

    /* renamed from: s, reason: collision with root package name */
    public final k9.e f7228s;

    /* renamed from: t, reason: collision with root package name */
    public final k9.e f7229t;

    public /* synthetic */ b0(k9.e eVar, d1 d1Var, k9.e eVar2, k9.e eVar3, k9.e eVar4, int i10) {
        this.f7224o = i10;
        this.f7225p = eVar;
        this.f7226q = d1Var;
        this.f7227r = eVar2;
        this.f7228s = eVar3;
        this.f7229t = eVar4;
    }

    @Override // k9.f
    public final Object c() {
        switch (this.f7224o) {
            case 0:
                Object c10 = this.f7225p.c();
                return new a0((p) c10, new k9.e(new h5.i(12, this.f7226q)), new k9.e(new h5.i(12, this.f7227r)), (n0) this.f7228s.c(), (i1) this.f7229t.c());
            default:
                Object c11 = this.f7225p.c();
                return new n1((p) c11, new k9.e(new h5.i(12, this.f7226q)), (u0) this.f7227r.c(), new k9.e(new h5.i(12, this.f7228s)), (n0) this.f7229t.c());
        }
    }
}
