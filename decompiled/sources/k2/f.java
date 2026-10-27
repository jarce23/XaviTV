package k2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final long f7719a;

    /* renamed from: b, reason: collision with root package name */
    public final long f7720b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7721c;

    /* renamed from: d, reason: collision with root package name */
    public long f7722d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f7723e;

    /* renamed from: f, reason: collision with root package name */
    public long f7724f;
    public long g;

    /* renamed from: h, reason: collision with root package name */
    public long f7725h;

    public f(long j10, long j11, long j12, long j13, long j14, long j15) {
        this.f7719a = j10;
        this.f7720b = j11;
        this.f7723e = j12;
        this.f7724f = j13;
        this.g = j14;
        this.f7721c = j15;
        this.f7725h = a(j11, 0L, j12, j13, j14, j15);
    }

    public static long a(long j10, long j11, long j12, long j13, long j14, long j15) {
        if (j13 + 1 >= j14 || j11 + 1 >= j12) {
            return j13;
        }
        long j16 = (long) ((j10 - j11) * ((j14 - j13) / (j12 - j11)));
        return l1.a0.j(((j16 + j13) - j15) - (j16 / 20), j13, j14 - 1);
    }
}
