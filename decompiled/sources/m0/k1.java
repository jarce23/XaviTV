package m0;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class k1 extends j1 {

    /* renamed from: r, reason: collision with root package name */
    public static final q1 f8689r;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f8689r = q1.g(null, windowInsets);
    }

    public k1(q1 q1Var, WindowInsets windowInsets) {
        super(q1Var, windowInsets);
    }

    @Override // m0.f1, m0.n1
    public e0.c f(int i10) {
        Insets insets;
        insets = this.f8657c.getInsets(o1.a(i10));
        return e0.c.c(insets);
    }

    @Override // m0.f1, m0.n1
    public final void d(View view) {
    }
}
