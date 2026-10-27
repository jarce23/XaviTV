package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class g0 implements l1.h {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2581o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ j0 f2582p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ u f2583q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ z f2584r;

    public /* synthetic */ g0(j0 j0Var, u uVar, z zVar, int i10) {
        this.f2581o = i10;
        this.f2582p = j0Var;
        this.f2583q = uVar;
        this.f2584r = zVar;
    }

    @Override // l1.h
    public final void accept(Object obj) {
        k0 k0Var = (k0) obj;
        switch (this.f2581o) {
            case 0:
                j0 j0Var = this.f2582p;
                k0Var.l(j0Var.f2621a, j0Var.f2622b, this.f2583q, this.f2584r);
                break;
            default:
                j0 j0Var2 = this.f2582p;
                k0Var.i(j0Var2.f2621a, j0Var2.f2622b, this.f2583q, this.f2584r);
                break;
        }
    }
}
