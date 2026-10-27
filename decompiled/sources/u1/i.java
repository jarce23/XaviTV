package u1;

import i2.k0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f12215o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k0 f12216p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ l f12217q;

    public /* synthetic */ i(k0 k0Var, l lVar, int i10) {
        this.f12215o = i10;
        this.f12216p = k0Var;
        this.f12217q = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f12215o;
        final l lVar = this.f12217q;
        k0 k0Var = this.f12216p;
        switch (i10) {
            case 0:
                s1.x xVar = k0Var.f6227c;
                int i11 = l1.a0.f8067a;
                t1.o oVar = xVar.f11482o.f11212s;
                final t1.a N = oVar.N();
                final int i12 = 1;
                oVar.O(N, 1031, new l1.m() { // from class: t1.n
                    @Override // l1.m
                    public final void invoke(Object obj) {
                        switch (i12) {
                            case 0:
                                ((b) obj).I(N, lVar);
                                break;
                            default:
                                ((b) obj).t(N, lVar);
                                break;
                        }
                    }
                });
                break;
            default:
                s1.x xVar2 = k0Var.f6227c;
                int i13 = l1.a0.f8067a;
                t1.o oVar2 = xVar2.f11482o.f11212s;
                final t1.a N2 = oVar2.N();
                final int i14 = 0;
                oVar2.O(N2, 1032, new l1.m() { // from class: t1.n
                    @Override // l1.m
                    public final void invoke(Object obj) {
                        switch (i14) {
                            case 0:
                                ((b) obj).I(N2, lVar);
                                break;
                            default:
                                ((b) obj).t(N2, lVar);
                                break;
                        }
                    }
                });
                break;
        }
    }
}
