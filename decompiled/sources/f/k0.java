package f;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k0 extends w7.b {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f4798q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ m0 f4799r;

    public /* synthetic */ k0(m0 m0Var, int i10) {
        this.f4798q = i10;
        this.f4799r = m0Var;
    }

    @Override // m0.q0
    public final void c() {
        View view;
        int i10 = this.f4798q;
        m0 m0Var = this.f4799r;
        switch (i10) {
            case 0:
                if (m0Var.f4820q && (view = m0Var.f4812i) != null) {
                    view.setTranslationY(0.0f);
                    m0Var.f4810f.setTranslationY(0.0f);
                }
                m0Var.f4810f.setVisibility(8);
                m0Var.f4810f.setTransitioning(false);
                m0Var.f4824u = null;
                x4.c cVar = m0Var.f4816m;
                if (cVar != null) {
                    cVar.U(m0Var.f4815l);
                    m0Var.f4815l = null;
                    m0Var.f4816m = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = m0Var.f4809e;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = m0.k0.f8683a;
                    m0.a0.c(actionBarOverlayLayout);
                    break;
                }
                break;
            default:
                m0Var.f4824u = null;
                m0Var.f4810f.requestLayout();
                break;
        }
    }
}
