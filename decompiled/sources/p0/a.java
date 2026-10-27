package p0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f9785a;

    /* renamed from: b, reason: collision with root package name */
    public int f9786b;

    /* renamed from: c, reason: collision with root package name */
    public float f9787c;

    /* renamed from: d, reason: collision with root package name */
    public float f9788d;

    /* renamed from: e, reason: collision with root package name */
    public long f9789e;

    /* renamed from: f, reason: collision with root package name */
    public long f9790f;
    public long g;

    /* renamed from: h, reason: collision with root package name */
    public float f9791h;

    /* renamed from: i, reason: collision with root package name */
    public int f9792i;

    public final float a(long j10) {
        if (j10 < this.f9789e) {
            return 0.0f;
        }
        long j11 = this.g;
        if (j11 < 0 || j10 < j11) {
            return e.b((j10 - r0) / this.f9785a, 0.0f, 1.0f) * 0.5f;
        }
        float f10 = this.f9791h;
        return (e.b((j10 - j11) / this.f9792i, 0.0f, 1.0f) * f10) + (1.0f - f10);
    }
}
