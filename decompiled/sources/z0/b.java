package z0;

import android.view.animation.Interpolator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f13952a;

    /* renamed from: b, reason: collision with root package name */
    public final float f13953b;

    public b(float[] fArr) {
        this.f13952a = fArr;
        this.f13953b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f10) {
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f13952a;
        int min = Math.min((int) ((fArr.length - 1) * f10), fArr.length - 2);
        float f11 = this.f13953b;
        float f12 = (f10 - (min * f11)) / f11;
        float f13 = fArr[min];
        return ((fArr[min + 1] - f13) * f12) + f13;
    }
}
