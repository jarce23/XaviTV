package androidx.fragment.app;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o0 implements View.OnAttachStateChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f767o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f768p;

    public /* synthetic */ o0(int i10, Object obj) {
        this.f767o = i10;
        this.f768p = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i10 = this.f767o;
        Object obj = this.f768p;
        switch (i10) {
            case 0:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = m0.k0.f8683a;
                m0.a0.c(view2);
                break;
            case 1:
                g9.p pVar = (g9.p) obj;
                AccessibilityManager accessibilityManager = pVar.H;
                if (pVar.I != null && accessibilityManager != null && pVar.isAttachedToWindow()) {
                    accessibilityManager.addTouchExplorationStateChangeListener(pVar.I);
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        AccessibilityManager accessibilityManager2;
        AccessibilityManager accessibilityManager3;
        switch (this.f767o) {
            case 0:
                break;
            case 1:
                g9.p pVar = (g9.p) this.f768p;
                AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = pVar.I;
                if (touchExplorationStateChangeListener != null && (accessibilityManager = pVar.H) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
                    break;
                }
                break;
            case 2:
                l.f fVar = (l.f) this.f768p;
                ViewTreeObserver viewTreeObserver = fVar.L;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        fVar.L = view.getViewTreeObserver();
                    }
                    fVar.L.removeGlobalOnLayoutListener(fVar.f7969w);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 3:
                l.c0 c0Var = (l.c0) this.f768p;
                ViewTreeObserver viewTreeObserver2 = c0Var.C;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        c0Var.C = view.getViewTreeObserver();
                    }
                    c0Var.C.removeGlobalOnLayoutListener(c0Var.f7952w);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 4:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.f768p;
                m8.a aVar = hideBottomViewOnScrollBehavior.f3660h;
                if (aVar != null && (accessibilityManager2 = hideBottomViewOnScrollBehavior.g) != null) {
                    accessibilityManager2.removeTouchExplorationStateChangeListener(aVar);
                    hideBottomViewOnScrollBehavior.f3660h = null;
                    break;
                }
                break;
            default:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.f768p;
                m8.a aVar2 = hideViewOnScrollBehavior.f3666c;
                if (aVar2 != null && (accessibilityManager3 = hideViewOnScrollBehavior.f3665b) != null) {
                    accessibilityManager3.removeTouchExplorationStateChangeListener(aVar2);
                    hideViewOnScrollBehavior.f3666c = null;
                    break;
                }
                break;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }

    private final void c(View view) {
    }

    private final void d(View view) {
    }

    private final void e(View view) {
    }
}
