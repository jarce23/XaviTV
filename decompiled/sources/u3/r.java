package u3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12474a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f12475b;

    public /* synthetic */ r(t tVar, int i10) {
        this.f12474a = i10;
        this.f12475b = tVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f12474a) {
            case 0:
                t tVar = this.f12475b;
                View view = tVar.f12480b;
                if (view != null) {
                    view.setVisibility(4);
                }
                ViewGroup viewGroup = tVar.f12481c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                }
                ViewGroup viewGroup2 = tVar.f12483e;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(4);
                    break;
                }
                break;
            case 1:
            default:
                super.onAnimationEnd(animator);
                break;
            case 2:
                this.f12475b.i(0);
                break;
            case 3:
                this.f12475b.i(0);
                break;
            case 4:
                ViewGroup viewGroup3 = this.f12475b.f12484f;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(4);
                    break;
                }
                break;
            case 5:
                ViewGroup viewGroup4 = this.f12475b.f12485h;
                if (viewGroup4 != null) {
                    viewGroup4.setVisibility(4);
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i10 = this.f12474a;
        t tVar = this.f12475b;
        switch (i10) {
            case 0:
                View view = tVar.f12487j;
                if ((view instanceof d) && !tVar.A) {
                    d dVar = (d) view;
                    ValueAnimator valueAnimator = dVar.S;
                    if (valueAnimator.isStarted()) {
                        valueAnimator.cancel();
                    }
                    valueAnimator.setFloatValues(dVar.T, 0.0f);
                    valueAnimator.setDuration(250L);
                    valueAnimator.start();
                    break;
                }
                break;
            case 1:
                View view2 = tVar.f12480b;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ViewGroup viewGroup = tVar.f12481c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                ViewGroup viewGroup2 = tVar.f12483e;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(tVar.A ? 0 : 4);
                }
                View view3 = tVar.f12487j;
                if ((view3 instanceof d) && !tVar.A) {
                    d dVar2 = (d) view3;
                    ValueAnimator valueAnimator2 = dVar2.S;
                    if (valueAnimator2.isStarted()) {
                        valueAnimator2.cancel();
                    }
                    dVar2.U = false;
                    valueAnimator2.setFloatValues(dVar2.T, 1.0f);
                    valueAnimator2.setDuration(250L);
                    valueAnimator2.start();
                    break;
                }
                break;
            case 2:
                tVar.i(4);
                break;
            case 3:
                tVar.i(4);
                break;
            case 4:
                ViewGroup viewGroup3 = tVar.f12485h;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(0);
                    tVar.f12485h.setTranslationX(r9.getWidth());
                    ViewGroup viewGroup4 = tVar.f12485h;
                    viewGroup4.scrollTo(viewGroup4.getWidth(), 0);
                    break;
                }
                break;
            default:
                ViewGroup viewGroup5 = tVar.f12484f;
                if (viewGroup5 != null) {
                    viewGroup5.setVisibility(0);
                    break;
                }
                break;
        }
    }
}
