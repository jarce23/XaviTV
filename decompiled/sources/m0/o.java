package m0;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final View f8698o;

    /* renamed from: p, reason: collision with root package name */
    public ViewTreeObserver f8699p;

    /* renamed from: q, reason: collision with root package name */
    public final Runnable f8700q;

    public o(View view, Runnable runnable) {
        this.f8698o = view;
        this.f8699p = view.getViewTreeObserver();
        this.f8700q = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        o oVar = new o(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(oVar);
        view.addOnAttachStateChangeListener(oVar);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean isAlive = this.f8699p.isAlive();
        View view = this.f8698o;
        if (isAlive) {
            this.f8699p.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f8700q.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f8699p = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean isAlive = this.f8699p.isAlive();
        View view2 = this.f8698o;
        if (isAlive) {
            this.f8699p.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
