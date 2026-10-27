package l4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import m0.q0;
import m0.t0;
import m0.x0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8222a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8223b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8224c;

    public /* synthetic */ i(Object obj, View view, int i10) {
        this.f8222a = i10;
        this.f8223b = obj;
        this.f8224c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f8222a) {
            case 1:
                ((q0) this.f8223b).d();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f8222a) {
            case 0:
                ((p.e) this.f8223b).remove(animator);
                ((m) this.f8224c).B.remove(animator);
                break;
            case 1:
                ((q0) this.f8223b).c();
                break;
            default:
                ((x0) this.f8223b).f8738a.d(1.0f);
                t0.e((View) this.f8224c);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f8222a) {
            case 0:
                ((m) this.f8224c).B.add(animator);
                break;
            case 1:
                ((q0) this.f8223b).e();
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public i(m mVar, p.e eVar) {
        this.f8222a = 0;
        this.f8224c = mVar;
        this.f8223b = eVar;
    }
}
