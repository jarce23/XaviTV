package s1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final long f11295a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11296b;

    /* renamed from: c, reason: collision with root package name */
    public long f11297c = -9223372036854775807L;

    /* renamed from: d, reason: collision with root package name */
    public long f11298d = -9223372036854775807L;

    /* renamed from: f, reason: collision with root package name */
    public long f11300f = -9223372036854775807L;
    public long g = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public float f11303j = 0.97f;

    /* renamed from: i, reason: collision with root package name */
    public float f11302i = 1.03f;

    /* renamed from: k, reason: collision with root package name */
    public float f11304k = 1.0f;

    /* renamed from: l, reason: collision with root package name */
    public long f11305l = -9223372036854775807L;

    /* renamed from: e, reason: collision with root package name */
    public long f11299e = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public long f11301h = -9223372036854775807L;

    /* renamed from: m, reason: collision with root package name */
    public long f11306m = -9223372036854775807L;

    /* renamed from: n, reason: collision with root package name */
    public long f11307n = -9223372036854775807L;

    public g(long j10, long j11) {
        this.f11295a = j10;
        this.f11296b = j11;
    }

    public final void a() {
        long j10;
        long j11 = this.f11297c;
        if (j11 != -9223372036854775807L) {
            j10 = this.f11298d;
            if (j10 == -9223372036854775807L) {
                long j12 = this.f11300f;
                if (j12 != -9223372036854775807L && j11 < j12) {
                    j11 = j12;
                }
                j10 = this.g;
                if (j10 == -9223372036854775807L || j11 <= j10) {
                    j10 = j11;
                }
            }
        } else {
            j10 = -9223372036854775807L;
        }
        if (this.f11299e == j10) {
            return;
        }
        this.f11299e = j10;
        this.f11301h = j10;
        this.f11306m = -9223372036854775807L;
        this.f11307n = -9223372036854775807L;
        this.f11305l = -9223372036854775807L;
    }
}
