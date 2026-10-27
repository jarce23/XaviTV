package b4;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f2293a;

    public k(n nVar) {
        this.f2293a = nVar;
    }

    @Override // b4.r0
    public final void b(RecyclerView recyclerView, int i10, int i11) {
        int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        n nVar = this.f2293a;
        int i12 = nVar.f2321a;
        int computeVerticalScrollRange = nVar.f2338s.computeVerticalScrollRange();
        int i13 = nVar.f2337r;
        nVar.f2339t = computeVerticalScrollRange - i13 > 0 && i13 >= i12;
        int computeHorizontalScrollRange = nVar.f2338s.computeHorizontalScrollRange();
        int i14 = nVar.f2336q;
        boolean z10 = computeHorizontalScrollRange - i14 > 0 && i14 >= i12;
        nVar.f2340u = z10;
        boolean z11 = nVar.f2339t;
        if (!z11 && !z10) {
            if (nVar.f2341v != 0) {
                nVar.f(0);
                return;
            }
            return;
        }
        if (z11) {
            float f10 = i13;
            nVar.f2331l = (int) ((((f10 / 2.0f) + computeVerticalScrollOffset) * f10) / computeVerticalScrollRange);
            nVar.f2330k = Math.min(i13, (i13 * i13) / computeVerticalScrollRange);
        }
        if (nVar.f2340u) {
            float f11 = computeHorizontalScrollOffset;
            float f12 = i14;
            nVar.f2334o = (int) ((((f12 / 2.0f) + f11) * f12) / computeHorizontalScrollRange);
            nVar.f2333n = Math.min(i14, (i14 * i14) / computeHorizontalScrollRange);
        }
        int i15 = nVar.f2341v;
        if (i15 == 0 || i15 == 1) {
            nVar.f(1);
        }
    }
}
