package b4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2250a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f2251b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f2252c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f2253d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j f2254e;

    public /* synthetic */ g(j jVar, h hVar, ViewPropertyAnimator viewPropertyAnimator, View view, int i10) {
        this.f2250a = i10;
        this.f2254e = jVar;
        this.f2251b = hVar;
        this.f2252c = viewPropertyAnimator;
        this.f2253d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f2250a) {
            case 0:
                this.f2252c.setListener(null);
                View view = this.f2253d;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                h hVar = this.f2251b;
                f1 f1Var = hVar.f2257a;
                j jVar = this.f2254e;
                jVar.c(f1Var);
                jVar.f2283r.remove(hVar.f2257a);
                jVar.i();
                break;
            default:
                this.f2252c.setListener(null);
                View view2 = this.f2253d;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                h hVar2 = this.f2251b;
                f1 f1Var2 = hVar2.f2258b;
                j jVar2 = this.f2254e;
                jVar2.c(f1Var2);
                jVar2.f2283r.remove(hVar2.f2258b);
                jVar2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f2250a) {
            case 0:
                f1 f1Var = this.f2251b.f2257a;
                this.f2254e.getClass();
                break;
            default:
                f1 f1Var2 = this.f2251b.f2258b;
                this.f2254e.getClass();
                break;
        }
    }
}
