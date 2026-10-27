package u1;

import i2.k0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f12218o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k0 f12219p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ s1.e f12220q;

    public /* synthetic */ j(k0 k0Var, s1.e eVar, int i10) {
        this.f12218o = i10;
        this.f12219p = k0Var;
        this.f12220q = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12218o) {
            case 0:
                k0 k0Var = this.f12219p;
                s1.e eVar = this.f12220q;
                s1.x xVar = k0Var.f6227c;
                int i10 = l1.a0.f8067a;
                t1.o oVar = xVar.f11482o.f11212s;
                t1.a N = oVar.N();
                oVar.O(N, 1007, new t1.d(N, eVar, 1));
                break;
            default:
                k0 k0Var2 = this.f12219p;
                s1.e eVar2 = this.f12220q;
                synchronized (eVar2) {
                }
                s1.x xVar2 = k0Var2.f6227c;
                int i11 = l1.a0.f8067a;
                t1.o oVar2 = xVar2.f11482o.f11212s;
                t1.a K = oVar2.K((c2.d0) oVar2.f11825r.f7294s);
                oVar2.O(K, 1013, new t1.d(K, eVar2, 2));
                break;
        }
    }
}
