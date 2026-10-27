package f3;

import k2.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements g {

    /* renamed from: o, reason: collision with root package name */
    public final f f4963o;

    /* renamed from: p, reason: collision with root package name */
    public final long f4964p;

    /* renamed from: q, reason: collision with root package name */
    public final long f4965q;

    /* renamed from: r, reason: collision with root package name */
    public final i f4966r;

    /* renamed from: s, reason: collision with root package name */
    public int f4967s;

    /* renamed from: t, reason: collision with root package name */
    public long f4968t;

    /* renamed from: u, reason: collision with root package name */
    public long f4969u;

    /* renamed from: v, reason: collision with root package name */
    public long f4970v;

    /* renamed from: w, reason: collision with root package name */
    public long f4971w;

    /* renamed from: x, reason: collision with root package name */
    public long f4972x;

    /* renamed from: y, reason: collision with root package name */
    public long f4973y;

    /* renamed from: z, reason: collision with root package name */
    public long f4974z;

    public b(i iVar, long j10, long j11, long j12, long j13, boolean z10) {
        l1.d.b(j10 >= 0 && j11 > j10);
        this.f4966r = iVar;
        this.f4964p = j10;
        this.f4965q = j11;
        if (j12 == j11 - j10 || z10) {
            this.f4968t = j13;
            this.f4967s = 4;
        } else {
            this.f4967s = 0;
        }
        this.f4963o = new f();
    }

    @Override // f3.g
    public final a0 d() {
        if (this.f4968t != 0) {
            return new a(this);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4  */
    @Override // f3.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long p(k2.o r28) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.b.p(k2.o):long");
    }

    @Override // f3.g
    public final void u(long j10) {
        this.f4970v = l1.a0.j(j10, 0L, this.f4968t - 1);
        this.f4967s = 2;
        this.f4971w = this.f4964p;
        this.f4972x = this.f4965q;
        this.f4973y = 0L;
        this.f4974z = this.f4968t;
    }
}
