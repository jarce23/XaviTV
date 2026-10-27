package l4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter implements k {

    /* renamed from: a, reason: collision with root package name */
    public final View f8214a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8215b = false;

    public f(View view) {
        this.f8214a = view;
    }

    @Override // l4.k
    public final void a(m mVar) {
        throw null;
    }

    @Override // l4.k
    public final void b() {
        View view = this.f8214a;
        view.setTag(R.id.transition_pause_alpha, Float.valueOf(view.getVisibility() == 0 ? w.f8260a.w(view) : 0.0f));
    }

    @Override // l4.k
    public final void e() {
        this.f8214a.setTag(R.id.transition_pause_alpha, null);
    }

    @Override // l4.k
    public final void g(m mVar) {
        throw null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        w.f8260a.F(this.f8214a, 1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.f8214a;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.f8215b = true;
            view.setLayerType(2, null);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z10) {
        boolean z11 = this.f8215b;
        View view = this.f8214a;
        if (z11) {
            view.setLayerType(0, null);
        }
        if (z10) {
            return;
        }
        b0 b0Var = w.f8260a;
        b0Var.F(view, 1.0f);
        b0Var.getClass();
    }

    @Override // l4.k
    public final void c(m mVar) {
    }

    @Override // l4.k
    public final void d(m mVar) {
    }

    @Override // l4.k
    public final void f(m mVar) {
    }
}
