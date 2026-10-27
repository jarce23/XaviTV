package b4;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i1 extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2270a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0 f2271b;

    public i1(b0 b0Var) {
        this.f2271b = b0Var;
    }

    @Override // b4.r0
    public final void a(int i10) {
        if (i10 == 0 && this.f2270a) {
            this.f2270a = false;
            this.f2271b.f();
        }
    }

    @Override // b4.r0
    public final void b(RecyclerView recyclerView, int i10, int i11) {
        if (i10 == 0 && i11 == 0) {
            return;
        }
        this.f2270a = true;
    }
}
