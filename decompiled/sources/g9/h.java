package g9;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5344a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5345b;

    public /* synthetic */ h(int i10, Object obj) {
        this.f5344a = i10;
        this.f5345b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5344a) {
            case 0:
                m mVar = (m) this.f5345b;
                mVar.getClass();
                mVar.f5381d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                u3.d dVar = (u3.d) this.f5345b;
                dVar.getClass();
                dVar.T = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                dVar.invalidate(dVar.f12365o);
                break;
        }
    }
}
