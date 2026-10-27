package b4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f1 f2222a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2223b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f2224c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f2225d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2226e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ j f2227f;

    public f(j jVar, f1 f1Var, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2227f = jVar;
        this.f2222a = f1Var;
        this.f2223b = i10;
        this.f2224c = view;
        this.f2225d = i11;
        this.f2226e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i10 = this.f2223b;
        View view = this.f2224c;
        if (i10 != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f2225d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f2226e.setListener(null);
        j jVar = this.f2227f;
        f1 f1Var = this.f2222a;
        jVar.c(f1Var);
        jVar.f2281p.remove(f1Var);
        jVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f2227f.getClass();
    }
}
