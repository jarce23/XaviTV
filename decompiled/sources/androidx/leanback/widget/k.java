package androidx.leanback.widget;

import android.graphics.PointF;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends l {

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ p f1031s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(p pVar) {
        super(pVar);
        this.f1031s = pVar;
    }

    @Override // b4.y
    public final PointF f(int i10) {
        if (this.f2451b.B.x() == 0) {
            return null;
        }
        p pVar = this.f1031s;
        int N = b4.o0.N(pVar.w(0));
        int i11 = ((pVar.f1064z & 262144) == 0 ? i10 >= N : i10 <= N) ? 1 : -1;
        return pVar.f1056r == 0 ? new PointF(i11, 0.0f) : new PointF(0.0f, i11);
    }
}
