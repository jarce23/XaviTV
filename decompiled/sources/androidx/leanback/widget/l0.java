package androidx.leanback.widget;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1034a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchOrbView f1035b;

    public /* synthetic */ l0(SearchOrbView searchOrbView, int i10) {
        this.f1034a = i10;
        this.f1035b = searchOrbView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f1034a) {
            case 0:
                this.f1035b.setOrbViewColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                break;
            default:
                this.f1035b.setSearchOrbZ(valueAnimator.getAnimatedFraction());
                break;
        }
    }
}
