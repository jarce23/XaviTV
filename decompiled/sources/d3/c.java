package d3;

import android.util.Pair;
import k2.b0;
import k2.z;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f4017a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f4018b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4019c;

    public c(long j10, long[] jArr, long[] jArr2) {
        this.f4017a = jArr;
        this.f4018b = jArr2;
        this.f4019c = j10 == -9223372036854775807L ? a0.O(jArr2[jArr2.length - 1]) : j10;
    }

    public static Pair a(long j10, long[] jArr, long[] jArr2) {
        int e7 = a0.e(jArr, j10, true);
        long j11 = jArr[e7];
        long j12 = jArr2[e7];
        int i10 = e7 + 1;
        if (i10 == jArr.length) {
            return Pair.create(Long.valueOf(j11), Long.valueOf(j12));
        }
        return Pair.create(Long.valueOf(j10), Long.valueOf(((long) ((jArr[i10] == j11 ? 0.0d : (j10 - j11) / (r6 - j11)) * (jArr2[i10] - j12))) + j12));
    }

    @Override // d3.f
    public final long d() {
        return -1L;
    }

    @Override // k2.a0
    public final boolean h() {
        return true;
    }

    @Override // d3.f
    public final long i(long j10) {
        return a0.O(((Long) a(j10, this.f4017a, this.f4018b).second).longValue());
    }

    @Override // k2.a0
    public final z j(long j10) {
        Pair a10 = a(a0.Z(a0.j(j10, 0L, this.f4019c)), this.f4018b, this.f4017a);
        b0 b0Var = new b0(a0.O(((Long) a10.first).longValue()), ((Long) a10.second).longValue());
        return new z(b0Var, b0Var);
    }

    @Override // d3.f
    public final int k() {
        return -2147483647;
    }

    @Override // k2.a0
    public final long l() {
        return this.f4019c;
    }
}
