package g2;

import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f5115a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5116b;

    public /* synthetic */ h(int i10, long j10, boolean z10) {
        this.f5115a = i10;
        this.f5116b = j10;
    }

    public static h a(k2.o oVar, t tVar) {
        oVar.o(tVar.f8129a, 0, 8);
        tVar.I(0);
        return new h(tVar.j(), tVar.n(), false);
    }

    public h(int i10, long j10) {
        l1.d.b(j10 >= 0);
        this.f5115a = i10;
        this.f5116b = j10;
    }
}
