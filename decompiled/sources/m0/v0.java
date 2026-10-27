package m0;

import android.view.WindowInsetsAnimation;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v0 extends w0 {

    /* renamed from: e, reason: collision with root package name */
    public final WindowInsetsAnimation f8732e;

    public v0(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.f8732e = windowInsetsAnimation;
    }

    @Override // m0.w0
    public final long a() {
        long durationMillis;
        durationMillis = this.f8732e.getDurationMillis();
        return durationMillis;
    }

    @Override // m0.w0
    public final float b() {
        float interpolatedFraction;
        interpolatedFraction = this.f8732e.getInterpolatedFraction();
        return interpolatedFraction;
    }

    @Override // m0.w0
    public final int c() {
        int typeMask;
        typeMask = this.f8732e.getTypeMask();
        return typeMask;
    }

    @Override // m0.w0
    public final void d(float f10) {
        this.f8732e.setFraction(f10);
    }
}
