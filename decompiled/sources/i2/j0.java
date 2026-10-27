package i2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class j0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f6220o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k0 f6221p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ s1.e f6222q;

    public /* synthetic */ j0(k0 k0Var, s1.e eVar, int i10) {
        this.f6220o = i10;
        this.f6221p = k0Var;
        this.f6222q = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6220o) {
            case 0:
                k0 k0Var = this.f6221p;
                s1.e eVar = this.f6222q;
                s1.x xVar = k0Var.f6227c;
                int i10 = l1.a0.f8067a;
                t1.o oVar = xVar.f11482o.f11212s;
                t1.a N = oVar.N();
                oVar.O(N, 1015, new t1.d(N, eVar, 3));
                break;
            default:
                k0 k0Var2 = this.f6221p;
                s1.e eVar2 = this.f6222q;
                synchronized (eVar2) {
                }
                s1.x xVar2 = k0Var2.f6227c;
                int i11 = l1.a0.f8067a;
                t1.o oVar2 = xVar2.f11482o.f11212s;
                t1.a K = oVar2.K((c2.d0) oVar2.f11825r.f7294s);
                oVar2.O(K, 1020, new a7.g(K, 10, eVar2));
                break;
        }
    }
}
