package i2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f6213o = 0;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k0 f6214p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ long f6215q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f6216r;

    public /* synthetic */ i0(k0 k0Var, int i10, long j10) {
        this.f6214p = k0Var;
        this.f6216r = i10;
        this.f6215q = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f6213o;
        int i11 = this.f6216r;
        long j10 = this.f6215q;
        k0 k0Var = this.f6214p;
        switch (i10) {
            case 0:
                s1.x xVar = k0Var.f6227c;
                int i12 = l1.a0.f8067a;
                t1.o oVar = xVar.f11482o.f11212s;
                t1.a K = oVar.K((c2.d0) oVar.f11825r.f7294s);
                oVar.O(K, 1018, new t1.g(i11, j10, K));
                break;
            default:
                s1.x xVar2 = k0Var.f6227c;
                int i13 = l1.a0.f8067a;
                t1.o oVar2 = xVar2.f11482o.f11212s;
                t1.a K2 = oVar2.K((c2.d0) oVar2.f11825r.f7294s);
                oVar2.O(K2, 1021, new t1.k(i11, j10, K2));
                break;
        }
    }

    public /* synthetic */ i0(k0 k0Var, long j10, int i10) {
        this.f6214p = k0Var;
        this.f6215q = j10;
        this.f6216r = i10;
    }
}
