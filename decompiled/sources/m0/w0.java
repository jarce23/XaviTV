package m0;

import android.view.animation.Interpolator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class w0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f8733a;

    /* renamed from: b, reason: collision with root package name */
    public float f8734b;

    /* renamed from: c, reason: collision with root package name */
    public final Interpolator f8735c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8736d;

    public w0(int i10, Interpolator interpolator, long j10) {
        this.f8733a = i10;
        this.f8735c = interpolator;
        this.f8736d = j10;
    }

    public long a() {
        return this.f8736d;
    }

    public float b() {
        Interpolator interpolator = this.f8735c;
        return interpolator != null ? interpolator.getInterpolation(this.f8734b) : this.f8734b;
    }

    public int c() {
        return this.f8733a;
    }

    public void d(float f10) {
        this.f8734b = f10;
    }
}
