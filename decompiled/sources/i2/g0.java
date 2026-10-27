package i2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f6196o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f6197p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ long f6198q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ long f6199r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Object f6200s;

    public /* synthetic */ g0(Object obj, String str, long j10, long j11, int i10) {
        this.f6196o = i10;
        this.f6200s = obj;
        this.f6197p = str;
        this.f6198q = j10;
        this.f6199r = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f6196o;
        k0 k0Var = (k0) this.f6200s;
        switch (i10) {
            case 0:
                s1.x xVar = k0Var.f6227c;
                int i11 = l1.a0.f8067a;
                t1.o oVar = xVar.f11482o.f11212s;
                t1.a N = oVar.N();
                oVar.O(N, 1016, new t1.f(N, this.f6197p, this.f6199r, this.f6198q, 2));
                break;
            default:
                s1.x xVar2 = k0Var.f6227c;
                int i12 = l1.a0.f8067a;
                t1.o oVar2 = xVar2.f11482o.f11212s;
                t1.a N2 = oVar2.N();
                oVar2.O(N2, 1008, new t1.f(N2, this.f6197p, this.f6199r, this.f6198q, 0));
                break;
        }
    }
}
