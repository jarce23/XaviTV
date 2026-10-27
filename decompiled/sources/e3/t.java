package e3;

import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final q f4547a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4548b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f4549c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f4550d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4551e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f4552f;
    public final int[] g;

    /* renamed from: h, reason: collision with root package name */
    public final long f4553h;

    public t(q qVar, long[] jArr, int[] iArr, int i10, long[] jArr2, int[] iArr2, long j10) {
        l1.d.b(iArr.length == jArr2.length);
        l1.d.b(jArr.length == jArr2.length);
        l1.d.b(iArr2.length == jArr2.length);
        this.f4547a = qVar;
        this.f4549c = jArr;
        this.f4550d = iArr;
        this.f4551e = i10;
        this.f4552f = jArr2;
        this.g = iArr2;
        this.f4553h = j10;
        this.f4548b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public final int a(long j10) {
        long[] jArr = this.f4552f;
        for (int a10 = a0.a(jArr, j10, true); a10 < jArr.length; a10++) {
            if ((this.g[a10] & 1) != 0) {
                return a10;
            }
        }
        return -1;
    }
}
