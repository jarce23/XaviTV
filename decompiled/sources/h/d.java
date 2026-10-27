package h;

import android.animation.TimeInterpolator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements TimeInterpolator {

    /* renamed from: a, reason: collision with root package name */
    public int[] f5498a;

    /* renamed from: b, reason: collision with root package name */
    public int f5499b;

    /* renamed from: c, reason: collision with root package name */
    public int f5500c;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f10) {
        int i10 = (int) ((f10 * this.f5500c) + 0.5f);
        int i11 = this.f5499b;
        int[] iArr = this.f5498a;
        int i12 = 0;
        while (i12 < i11) {
            int i13 = iArr[i12];
            if (i10 < i13) {
                break;
            }
            i10 -= i13;
            i12++;
        }
        return (i12 / i11) + (i12 < i11 ? i10 / this.f5500c : 0.0f);
    }
}
