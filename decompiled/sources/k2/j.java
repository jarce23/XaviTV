package k2;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f7742a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f7743b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f7744c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f7745d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f7746e;

    /* renamed from: f, reason: collision with root package name */
    public final long f7747f;

    public j(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f7743b = iArr;
        this.f7744c = jArr;
        this.f7745d = jArr2;
        this.f7746e = jArr3;
        int length = iArr.length;
        this.f7742a = length;
        if (length > 0) {
            this.f7747f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f7747f = 0L;
        }
    }

    @Override // k2.a0
    public final boolean h() {
        return true;
    }

    @Override // k2.a0
    public final z j(long j10) {
        long[] jArr = this.f7746e;
        int e7 = l1.a0.e(jArr, j10, true);
        long j11 = jArr[e7];
        long[] jArr2 = this.f7744c;
        b0 b0Var = new b0(j11, jArr2[e7]);
        if (j11 >= j10 || e7 == this.f7742a - 1) {
            return new z(b0Var, b0Var);
        }
        int i10 = e7 + 1;
        return new z(b0Var, new b0(jArr[i10], jArr2[i10]));
    }

    @Override // k2.a0
    public final long l() {
        return this.f7747f;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.f7742a + ", sizes=" + Arrays.toString(this.f7743b) + ", offsets=" + Arrays.toString(this.f7744c) + ", timeUs=" + Arrays.toString(this.f7746e) + ", durationsUs=" + Arrays.toString(this.f7745d) + ")";
    }
}
