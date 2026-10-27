package b4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2301a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f2302b;

    public l(n nVar) {
        this.f2302b = nVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f2301a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f2301a) {
            this.f2301a = false;
            return;
        }
        n nVar = this.f2302b;
        if (((Float) nVar.f2345z.getAnimatedValue()).floatValue() == 0.0f) {
            nVar.A = 0;
            nVar.f(0);
        } else {
            nVar.A = 2;
            nVar.f2338s.invalidate();
        }
    }
}
