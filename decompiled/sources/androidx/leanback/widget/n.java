package androidx.leanback.widget;

import android.graphics.PointF;
import android.view.View;
import b4.z0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends l {

    /* renamed from: s, reason: collision with root package name */
    public final boolean f1044s;

    /* renamed from: t, reason: collision with root package name */
    public int f1045t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ p f1046u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(p pVar, int i10, boolean z10) {
        super(pVar);
        this.f1046u = pVar;
        this.f1045t = i10;
        this.f1044s = z10;
        this.f2450a = -2;
    }

    @Override // b4.y
    public final PointF f(int i10) {
        int i11 = this.f1045t;
        if (i11 == 0) {
            return null;
        }
        p pVar = this.f1046u;
        int i12 = ((pVar.f1064z & 262144) == 0 ? i11 >= 0 : i11 <= 0) ? 1 : -1;
        return pVar.f1056r == 0 ? new PointF(i12, 0.0f) : new PointF(0.0f, i12);
    }

    @Override // b4.y
    public final void k(z0 z0Var) {
        if (this.f1045t == 0) {
            return;
        }
        super.k(z0Var);
    }

    @Override // androidx.leanback.widget.l
    public final void l() {
        super.l();
        this.f1045t = 0;
        View s10 = this.f2451b.B.s(this.f2450a);
        if (s10 != null) {
            this.f1046u.t1(s10, true);
        }
    }
}
