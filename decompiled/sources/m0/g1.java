package m0;

import android.view.WindowInsets;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class g1 extends f1 {

    /* renamed from: n, reason: collision with root package name */
    public e0.c f8669n;

    public g1(q1 q1Var, WindowInsets windowInsets) {
        super(q1Var, windowInsets);
        this.f8669n = null;
    }

    @Override // m0.n1
    public q1 b() {
        return q1.g(null, this.f8657c.consumeStableInsets());
    }

    @Override // m0.n1
    public q1 c() {
        return q1.g(null, this.f8657c.consumeSystemWindowInsets());
    }

    @Override // m0.n1
    public final e0.c h() {
        if (this.f8669n == null) {
            WindowInsets windowInsets = this.f8657c;
            this.f8669n = e0.c.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f8669n;
    }

    @Override // m0.n1
    public boolean m() {
        return this.f8657c.isConsumed();
    }

    @Override // m0.n1
    public void q(e0.c cVar) {
        this.f8669n = cVar;
    }
}
