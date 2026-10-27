package g9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5330a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f5331b;

    public /* synthetic */ c(d dVar, int i10) {
        this.f5330a = i10;
        this.f5331b = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f5330a) {
            case 1:
                this.f5331b.f5379b.h(false);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f5330a) {
            case 0:
                this.f5331b.f5379b.h(true);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
