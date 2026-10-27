package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.transition.Transition;
import android.view.View;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter implements Transition.TransitionListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f883a;

    /* renamed from: b, reason: collision with root package name */
    public final View f884b;

    /* renamed from: c, reason: collision with root package name */
    public final int f885c;

    /* renamed from: d, reason: collision with root package name */
    public final int f886d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f887e;

    /* renamed from: f, reason: collision with root package name */
    public float f888f;
    public float g;

    /* renamed from: h, reason: collision with root package name */
    public final float f889h;

    /* renamed from: i, reason: collision with root package name */
    public final float f890i;

    public g(View view, View view2, int i10, int i11, float f10, float f11) {
        this.f884b = view;
        this.f883a = view2;
        this.f885c = i10 - Math.round(view.getTranslationX());
        this.f886d = i11 - Math.round(view.getTranslationY());
        this.f889h = f10;
        this.f890i = f11;
        int[] iArr = (int[]) view2.getTag(R.id.transitionPosition);
        this.f887e = iArr;
        if (iArr != null) {
            view2.setTag(R.id.transitionPosition, null);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        if (this.f887e == null) {
            this.f887e = new int[2];
        }
        int[] iArr = this.f887e;
        float f10 = this.f885c;
        View view = this.f884b;
        iArr[0] = Math.round(view.getTranslationX() + f10);
        this.f887e[1] = Math.round(view.getTranslationY() + this.f886d);
        this.f883a.setTag(R.id.transitionPosition, this.f887e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        View view = this.f884b;
        this.f888f = view.getTranslationX();
        this.g = view.getTranslationY();
        view.setTranslationX(this.f889h);
        view.setTranslationY(this.f890i);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        float f10 = this.f888f;
        View view = this.f884b;
        view.setTranslationX(f10);
        view.setTranslationY(this.g);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        float f10 = this.f889h;
        View view = this.f884b;
        view.setTranslationX(f10);
        view.setTranslationY(this.f890i);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
    }
}
