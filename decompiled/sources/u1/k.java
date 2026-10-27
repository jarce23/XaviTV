package u1;

import i2.k0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ k0 f12221o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ long f12222p;

    public /* synthetic */ k(k0 k0Var, long j10) {
        this.f12221o = k0Var;
        this.f12222p = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s1.x xVar = this.f12221o.f6227c;
        int i10 = l1.a0.f8067a;
        t1.o oVar = xVar.f11482o.f11212s;
        t1.a N = oVar.N();
        oVar.O(N, 1010, new a7.h(N, this.f12222p));
    }
}
