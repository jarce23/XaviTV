package d3;

import k2.a0;
import k2.b0;
import k2.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements f, a0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f4006a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4007b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4008c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4009d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4010e;

    /* renamed from: f, reason: collision with root package name */
    public final long f4011f;
    public final boolean g;

    /* renamed from: h, reason: collision with root package name */
    public final long f4012h;

    /* renamed from: i, reason: collision with root package name */
    public final int f4013i;

    /* renamed from: j, reason: collision with root package name */
    public final int f4014j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f4015k;

    /* renamed from: l, reason: collision with root package name */
    public final long f4016l;

    public a(long j10, long j11, int i10, int i11, boolean z10) {
        this.f4006a = j10;
        this.f4007b = j11;
        this.f4008c = i11 == -1 ? 1 : i11;
        this.f4010e = i10;
        this.g = z10;
        if (j10 == -1) {
            this.f4009d = -1L;
            this.f4011f = -9223372036854775807L;
        } else {
            long j12 = j10 - j11;
            this.f4009d = j12;
            this.f4011f = (Math.max(0L, j12) * 8000000) / i10;
        }
        this.f4012h = j11;
        this.f4013i = i10;
        this.f4014j = i11;
        this.f4015k = z10;
        this.f4016l = j10 == -1 ? -1L : j10;
    }

    @Override // d3.f
    public final long d() {
        return this.f4016l;
    }

    @Override // k2.a0
    public final boolean h() {
        return this.f4009d != -1 || this.g;
    }

    @Override // d3.f
    public final long i(long j10) {
        return (Math.max(0L, j10 - this.f4007b) * 8000000) / this.f4010e;
    }

    @Override // k2.a0
    public final z j(long j10) {
        long j11 = this.f4009d;
        long j12 = this.f4007b;
        if (j11 == -1 && !this.g) {
            b0 b0Var = new b0(0L, j12);
            return new z(b0Var, b0Var);
        }
        int i10 = this.f4010e;
        long j13 = this.f4008c;
        long j14 = (((i10 * j10) / 8000000) / j13) * j13;
        if (j11 != -1) {
            j14 = Math.min(j14, j11 - j13);
        }
        long max = Math.max(j14, 0L) + j12;
        long max2 = (Math.max(0L, max - j12) * 8000000) / i10;
        b0 b0Var2 = new b0(max2, max);
        if (j11 != -1 && max2 < j10) {
            long j15 = max + j13;
            if (j15 < this.f4006a) {
                return new z(b0Var2, new b0((Math.max(0L, j15 - j12) * 8000000) / i10, j15));
            }
        }
        return new z(b0Var2, b0Var2);
    }

    @Override // d3.f
    public final int k() {
        return this.f4013i;
    }

    @Override // k2.a0
    public final long l() {
        return this.f4011f;
    }
}
