package b4;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2307a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2308b;

    public /* synthetic */ m(int i10, Object obj) {
        this.f2307a = i10;
        this.f2308b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2307a) {
            case 0:
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                n nVar = (n) this.f2308b;
                nVar.f2323c.setAlpha(floatValue);
                nVar.f2324d.setAlpha(floatValue);
                nVar.f2338s.invalidate();
                break;
            case 1:
                ((TextInputLayout) this.f2308b).K0.m(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                d9.j jVar = ((BottomSheetBehavior) this.f2308b).f3693i;
                if (jVar != null) {
                    d9.h hVar = jVar.f4277p;
                    if (hVar.f4267j != floatValue2) {
                        hVar.f4267j = floatValue2;
                        jVar.f4281t = true;
                        jVar.f4282u = true;
                        jVar.invalidateSelf();
                        break;
                    }
                }
                break;
        }
    }
}
