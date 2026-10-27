package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class f0 implements l1.h, l1.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2577o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f2578p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f2579q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f2580r;

    public /* synthetic */ f0(int i10, i1.n0 n0Var, i1.n0 n0Var2, t1.a aVar) {
        this.f2578p = aVar;
        this.f2577o = i10;
        this.f2579q = n0Var;
        this.f2580r = n0Var2;
    }

    @Override // l1.h
    public void accept(Object obj) {
        j0 j0Var = (j0) this.f2578p;
        ((k0) obj).g(j0Var.f2621a, j0Var.f2622b, (u) this.f2579q, (z) this.f2580r, this.f2577o);
    }

    @Override // l1.m
    public void invoke(Object obj) {
        t1.a aVar = (t1.a) this.f2578p;
        i1.n0 n0Var = (i1.n0) this.f2579q;
        i1.n0 n0Var2 = (i1.n0) this.f2580r;
        t1.b bVar = (t1.b) obj;
        bVar.getClass();
        bVar.F(this.f2577o, n0Var, n0Var2, aVar);
    }

    public /* synthetic */ f0(j0 j0Var, u uVar, z zVar, int i10) {
        this.f2578p = j0Var;
        this.f2579q = uVar;
        this.f2580r = zVar;
        this.f2577o = i10;
    }
}
