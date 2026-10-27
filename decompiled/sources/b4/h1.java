package b4;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h1 extends m0.b {

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f2263d;

    /* renamed from: e, reason: collision with root package name */
    public final g1 f2264e;

    public h1(RecyclerView recyclerView) {
        this.f2263d = recyclerView;
        g1 g1Var = this.f2264e;
        if (g1Var != null) {
            this.f2264e = g1Var;
        } else {
            this.f2264e = new g1(this);
        }
    }

    @Override // m0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.f2263d.L()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().c0(accessibilityEvent);
        }
    }

    @Override // m0.b
    public final void d(View view, n0.g gVar) {
        this.f8638a.onInitializeAccessibilityNodeInfo(view, gVar.f9111a);
        RecyclerView recyclerView = this.f2263d;
        if (recyclerView.L() || recyclerView.getLayoutManager() == null) {
            return;
        }
        o0 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f2358b;
        layoutManager.d0(recyclerView2.f1476q, recyclerView2.f1487v0, gVar);
    }

    @Override // m0.b
    public final boolean g(View view, int i10, Bundle bundle) {
        if (super.g(view, i10, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f2263d;
        if (recyclerView.L() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        o0 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f2358b;
        return layoutManager.u0(i10, recyclerView2.f1476q, recyclerView2.f1487v0);
    }
}
