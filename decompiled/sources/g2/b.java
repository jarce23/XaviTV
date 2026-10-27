package g2;

import c2.d0;
import i2.k0;
import j9.g1;
import l1.a0;
import o9.g0;
import s1.x;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5079o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f5080p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ long f5081q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ long f5082r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Object f5083s;

    public /* synthetic */ b(Object obj, int i10, long j10, long j11, int i11) {
        this.f5079o = i11;
        this.f5083s = obj;
        this.f5080p = i10;
        this.f5081q = j10;
        this.f5082r = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f5079o;
        Object obj = this.f5083s;
        switch (i10) {
            case 0:
                t1.o oVar = ((c) obj).f5085b;
                g1 g1Var = oVar.f11825r;
                t1.a K = oVar.K(((g0) g1Var.f7291p).isEmpty() ? null : (d0) o9.q.g((g0) g1Var.f7291p));
                oVar.O(K, 1006, new h3.l(K, this.f5080p, this.f5081q, this.f5082r));
                break;
            default:
                x xVar = ((k0) obj).f6227c;
                int i11 = a0.f8067a;
                t1.o oVar2 = xVar.f11482o.f11212s;
                final t1.a N = oVar2.N();
                final int i12 = this.f5080p;
                final long j10 = this.f5081q;
                final long j11 = this.f5082r;
                oVar2.O(N, 1011, new l1.m() { // from class: t1.m
                    @Override // l1.m
                    public final void invoke(Object obj2) {
                        ((b) obj2).y(a.this, i12, j10, j11);
                    }
                });
                break;
        }
    }
}
