package b4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2209a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f1 f2210b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f2211c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2212d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j f2213e;

    public e(j jVar, f1 f1Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2213e = jVar;
        this.f2210b = f1Var;
        this.f2212d = viewPropertyAnimator;
        this.f2211c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f2209a) {
            case 1:
                this.f2211c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f2209a) {
            case 0:
                this.f2212d.setListener(null);
                this.f2211c.setAlpha(1.0f);
                j jVar = this.f2213e;
                f1 f1Var = this.f2210b;
                jVar.c(f1Var);
                jVar.f2282q.remove(f1Var);
                jVar.i();
                break;
            default:
                this.f2212d.setListener(null);
                j jVar2 = this.f2213e;
                f1 f1Var2 = this.f2210b;
                jVar2.c(f1Var2);
                jVar2.f2280o.remove(f1Var2);
                jVar2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f2209a) {
            case 0:
                this.f2213e.getClass();
                break;
            default:
                this.f2213e.getClass();
                break;
        }
    }

    public e(j jVar, f1 f1Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2213e = jVar;
        this.f2210b = f1Var;
        this.f2211c = view;
        this.f2212d = viewPropertyAnimator;
    }
}
