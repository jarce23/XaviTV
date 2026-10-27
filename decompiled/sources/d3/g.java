package d3;

import k2.b0;
import k2.z;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements f {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f4039a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f4040b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4041c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4042d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4043e;

    public g(long[] jArr, long[] jArr2, long j10, long j11, long j12, int i10) {
        this.f4039a = jArr;
        this.f4040b = jArr2;
        this.f4041c = j10;
        this.f4042d = j12;
        this.f4043e = i10;
    }

    @Override // d3.f
    public final long d() {
        return this.f4042d;
    }

    @Override // k2.a0
    public final boolean h() {
        return true;
    }

    @Override // d3.f
    public final long i(long j10) {
        return this.f4039a[a0.e(this.f4040b, j10, true)];
    }

    @Override // k2.a0
    public final z j(long j10) {
        long[] jArr = this.f4039a;
        int e7 = a0.e(jArr, j10, true);
        long j11 = jArr[e7];
        long[] jArr2 = this.f4040b;
        b0 b0Var = new b0(j11, jArr2[e7]);
        if (j11 >= j10 || e7 == jArr.length - 1) {
            return new z(b0Var, b0Var);
        }
        int i10 = e7 + 1;
        return new z(b0Var, new b0(jArr[i10], jArr2[i10]));
    }

    @Override // d3.f
    public final int k() {
        return this.f4043e;
    }

    @Override // k2.a0
    public final long l() {
        return this.f4041c;
    }
}
