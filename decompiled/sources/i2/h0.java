package i2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ k0 f6204o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f6205p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ long f6206q;

    public /* synthetic */ h0(k0 k0Var, Object obj, long j10) {
        this.f6204o = k0Var;
        this.f6205p = obj;
        this.f6206q = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s1.x xVar = this.f6204o.f6227c;
        int i10 = l1.a0.f8067a;
        s1.a0 a0Var = xVar.f11482o;
        t1.o oVar = a0Var.f11212s;
        t1.a N = oVar.N();
        Object obj = this.f6205p;
        oVar.O(N, 26, new a7.g(N, obj, this.f6206q));
        if (a0Var.T == obj) {
            a0Var.f11204m.e(26, new h3.b(18));
        }
    }
}
