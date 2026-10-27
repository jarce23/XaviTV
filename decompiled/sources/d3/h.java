package d3;

import k2.b0;
import k2.z;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements f {

    /* renamed from: a, reason: collision with root package name */
    public final long f4044a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4045b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4046c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4047d;

    /* renamed from: e, reason: collision with root package name */
    public final long f4048e;

    /* renamed from: f, reason: collision with root package name */
    public final long f4049f;
    public final long[] g;

    public h(long j10, int i10, long j11, int i11, long j12, long[] jArr) {
        this.f4044a = j10;
        this.f4045b = i10;
        this.f4046c = j11;
        this.f4047d = i11;
        this.f4048e = j12;
        this.g = jArr;
        this.f4049f = j12 != -1 ? j10 + j12 : -1L;
    }

    @Override // d3.f
    public final long d() {
        return this.f4049f;
    }

    @Override // k2.a0
    public final boolean h() {
        return this.g != null;
    }

    @Override // d3.f
    public final long i(long j10) {
        long j11 = j10 - this.f4044a;
        if (!h() || j11 <= this.f4045b) {
            return 0L;
        }
        long[] jArr = this.g;
        l1.d.h(jArr);
        double d6 = (j11 * 256.0d) / this.f4048e;
        int e7 = a0.e(jArr, (long) d6, true);
        long j12 = this.f4046c;
        long j13 = (e7 * j12) / 100;
        long j14 = jArr[e7];
        int i10 = e7 + 1;
        long j15 = (j12 * i10) / 100;
        return Math.round((j14 == (e7 == 99 ? 256L : jArr[i10]) ? 0.0d : (d6 - j14) / (r0 - j14)) * (j15 - j13)) + j13;
    }

    @Override // k2.a0
    public final z j(long j10) {
        double d6;
        double d10;
        boolean h10 = h();
        int i10 = this.f4045b;
        long j11 = this.f4044a;
        if (!h10) {
            b0 b0Var = new b0(0L, j11 + i10);
            return new z(b0Var, b0Var);
        }
        long j12 = a0.j(j10, 0L, this.f4046c);
        double d11 = (j12 * 100.0d) / this.f4046c;
        double d12 = 0.0d;
        if (d11 <= 0.0d) {
            d6 = 256.0d;
        } else if (d11 >= 100.0d) {
            d6 = 256.0d;
            d12 = 256.0d;
        } else {
            int i11 = (int) d11;
            long[] jArr = this.g;
            l1.d.h(jArr);
            double d13 = jArr[i11];
            if (i11 == 99) {
                d6 = 256.0d;
                d10 = 256.0d;
            } else {
                d6 = 256.0d;
                d10 = jArr[i11 + 1];
            }
            d12 = ((d10 - d13) * (d11 - i11)) + d13;
        }
        long j13 = this.f4048e;
        b0 b0Var2 = new b0(j12, j11 + a0.j(Math.round((d12 / d6) * j13), i10, j13 - 1));
        return new z(b0Var2, b0Var2);
    }

    @Override // d3.f
    public final int k() {
        return this.f4047d;
    }

    @Override // k2.a0
    public final long l() {
        return this.f4046c;
    }
}
