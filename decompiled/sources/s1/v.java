package s1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class v implements l1.m, b7.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11470o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f11471p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f11472q;

    public /* synthetic */ v(int i10, i1.n0 n0Var, i1.n0 n0Var2) {
        this.f11470o = i10;
        this.f11471p = n0Var;
        this.f11472q = n0Var2;
    }

    @Override // b7.b
    public Object execute() {
        j9.n nVar = (j9.n) this.f11471p;
        ((android.support.v4.media.session.a0) nVar.f7385s).V((s6.i) this.f11472q, this.f11470o + 1, false);
        return null;
    }

    @Override // l1.m
    public void invoke(Object obj) {
        i1.n0 n0Var = (i1.n0) this.f11471p;
        i1.n0 n0Var2 = (i1.n0) this.f11472q;
        i1.m0 m0Var = (i1.m0) obj;
        m0Var.getClass();
        m0Var.n(this.f11470o, n0Var, n0Var2);
    }

    public /* synthetic */ v(j9.n nVar, s6.i iVar, int i10) {
        this.f11471p = nVar;
        this.f11472q = iVar;
        this.f11470o = i10;
    }
}
