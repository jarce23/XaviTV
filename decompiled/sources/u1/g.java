package u1;

import i2.k0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f12210o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k0 f12211p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Exception f12212q;

    public /* synthetic */ g(k0 k0Var, Exception exc, int i10) {
        this.f12210o = i10;
        this.f12211p = k0Var;
        this.f12212q = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f12210o;
        Exception exc = this.f12212q;
        k0 k0Var = this.f12211p;
        switch (i10) {
            case 0:
                s1.x xVar = k0Var.f6227c;
                int i11 = l1.a0.f8067a;
                t1.o oVar = xVar.f11482o.f11212s;
                t1.a N = oVar.N();
                oVar.O(N, 1029, new h3.b(N, exc, 26));
                break;
            default:
                s1.x xVar2 = k0Var.f6227c;
                int i12 = l1.a0.f8067a;
                t1.o oVar2 = xVar2.f11482o.f11212s;
                t1.a N2 = oVar2.N();
                oVar2.O(N2, 1014, new t1.k(N2, exc, 4));
                break;
        }
    }
}
