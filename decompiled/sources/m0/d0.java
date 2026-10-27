package m0;

import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d0 {
    public static q1 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        q1 g = q1.g(null, rootWindowInsets);
        n1 n1Var = g.f8706a;
        n1Var.p(g);
        n1Var.d(view.getRootView());
        return g;
    }

    public static void b(View view, int i10, int i11) {
        view.setScrollIndicators(i10, i11);
    }
}
