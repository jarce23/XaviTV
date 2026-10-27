package b4;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g1 extends m0.b {

    /* renamed from: d, reason: collision with root package name */
    public final h1 f2255d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakHashMap f2256e = new WeakHashMap();

    public g1(h1 h1Var) {
        this.f2255d = h1Var;
    }

    @Override // m0.b
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        m0.b bVar = (m0.b) this.f2256e.get(view);
        return bVar != null ? bVar.a(view, accessibilityEvent) : this.f8638a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // m0.b
    public final h5.i b(View view) {
        m0.b bVar = (m0.b) this.f2256e.get(view);
        return bVar != null ? bVar.b(view) : super.b(view);
    }

    @Override // m0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        m0.b bVar = (m0.b) this.f2256e.get(view);
        if (bVar != null) {
            bVar.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    @Override // m0.b
    public final void d(View view, n0.g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f9111a;
        h1 h1Var = this.f2255d;
        RecyclerView recyclerView = h1Var.f2263d;
        RecyclerView recyclerView2 = h1Var.f2263d;
        boolean L = recyclerView.L();
        View.AccessibilityDelegate accessibilityDelegate = this.f8638a;
        if (L || recyclerView2.getLayoutManager() == null) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            return;
        }
        recyclerView2.getLayoutManager().e0(view, gVar);
        m0.b bVar = (m0.b) this.f2256e.get(view);
        if (bVar != null) {
            bVar.d(view, gVar);
        } else {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        }
    }

    @Override // m0.b
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        m0.b bVar = (m0.b) this.f2256e.get(view);
        if (bVar != null) {
            bVar.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    @Override // m0.b
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        m0.b bVar = (m0.b) this.f2256e.get(viewGroup);
        return bVar != null ? bVar.f(viewGroup, view, accessibilityEvent) : this.f8638a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // m0.b
    public final boolean g(View view, int i10, Bundle bundle) {
        h1 h1Var = this.f2255d;
        RecyclerView recyclerView = h1Var.f2263d;
        RecyclerView recyclerView2 = h1Var.f2263d;
        if (recyclerView.L() || recyclerView2.getLayoutManager() == null) {
            return super.g(view, i10, bundle);
        }
        m0.b bVar = (m0.b) this.f2256e.get(view);
        if (bVar != null) {
            if (bVar.g(view, i10, bundle)) {
                return true;
            }
        } else if (super.g(view, i10, bundle)) {
            return true;
        }
        u0 u0Var = recyclerView2.getLayoutManager().f2358b.f1476q;
        return false;
    }

    @Override // m0.b
    public final void h(View view, int i10) {
        m0.b bVar = (m0.b) this.f2256e.get(view);
        if (bVar != null) {
            bVar.h(view, i10);
        } else {
            super.h(view, i10);
        }
    }

    @Override // m0.b
    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        m0.b bVar = (m0.b) this.f2256e.get(view);
        if (bVar != null) {
            bVar.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
