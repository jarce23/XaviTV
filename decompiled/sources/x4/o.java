package x4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f13569a;

    /* renamed from: b, reason: collision with root package name */
    public int f13570b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13571c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13572d;

    /* renamed from: e, reason: collision with root package name */
    public o4.f f13573e;

    /* renamed from: f, reason: collision with root package name */
    public final o4.f f13574f;
    public final long g;

    /* renamed from: h, reason: collision with root package name */
    public final long f13575h;

    /* renamed from: i, reason: collision with root package name */
    public final long f13576i;

    /* renamed from: j, reason: collision with root package name */
    public final o4.d f13577j;

    /* renamed from: k, reason: collision with root package name */
    public final int f13578k;

    /* renamed from: l, reason: collision with root package name */
    public final int f13579l;

    /* renamed from: m, reason: collision with root package name */
    public final long f13580m;

    /* renamed from: n, reason: collision with root package name */
    public long f13581n;

    /* renamed from: o, reason: collision with root package name */
    public final long f13582o;

    /* renamed from: p, reason: collision with root package name */
    public final long f13583p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13584q;

    /* renamed from: r, reason: collision with root package name */
    public int f13585r;

    /* renamed from: s, reason: collision with root package name */
    public final int f13586s;

    /* renamed from: t, reason: collision with root package name */
    public final int f13587t;

    /* renamed from: u, reason: collision with root package name */
    public final long f13588u;

    /* renamed from: v, reason: collision with root package name */
    public final int f13589v;

    /* renamed from: w, reason: collision with root package name */
    public final int f13590w;

    static {
        za.h.d("tagWithPrefix(\"WorkSpec\")", o4.p.f("WorkSpec"));
    }

    public o(String str, int i10, String str2, String str3, o4.f fVar, o4.f fVar2, long j10, long j11, long j12, o4.d dVar, int i11, int i12, long j13, long j14, long j15, long j16, boolean z10, int i13, int i14, int i15, long j17, int i16, int i17) {
        za.h.e("id", str);
        r.a.h(i10, "state");
        za.h.e("workerClassName", str2);
        za.h.e("inputMergerClassName", str3);
        za.h.e("input", fVar);
        za.h.e("output", fVar2);
        za.h.e("constraints", dVar);
        r.a.h(i12, "backoffPolicy");
        r.a.h(i13, "outOfQuotaPolicy");
        this.f13569a = str;
        this.f13570b = i10;
        this.f13571c = str2;
        this.f13572d = str3;
        this.f13573e = fVar;
        this.f13574f = fVar2;
        this.g = j10;
        this.f13575h = j11;
        this.f13576i = j12;
        this.f13577j = dVar;
        this.f13578k = i11;
        this.f13579l = i12;
        this.f13580m = j13;
        this.f13581n = j14;
        this.f13582o = j15;
        this.f13583p = j16;
        this.f13584q = z10;
        this.f13585r = i13;
        this.f13586s = i14;
        this.f13587t = i15;
        this.f13588u = j17;
        this.f13589v = i16;
        this.f13590w = i17;
    }

    public final long a() {
        int i10 = this.f13570b;
        int i11 = this.f13578k;
        boolean z10 = i10 == 1 && i11 > 0;
        long j10 = this.f13581n;
        boolean c10 = c();
        int i12 = this.f13579l;
        r.a.h(i12, "backoffPolicy");
        long j11 = this.f13588u;
        int i13 = this.f13586s;
        if (j11 != Long.MAX_VALUE && c10) {
            if (i13 != 0) {
                long j12 = j10 + 900000;
                if (j11 < j12) {
                    return j12;
                }
            }
            return j11;
        }
        if (z10) {
            long j13 = this.f13580m;
            long scalb = i12 == 2 ? j13 * i11 : (long) Math.scalb(j13, i11 - 1);
            if (scalb > 18000000) {
                scalb = 18000000;
            }
            return j10 + scalb;
        }
        long j14 = this.g;
        if (!c10) {
            if (j10 == -1) {
                return Long.MAX_VALUE;
            }
            return j10 + j14;
        }
        long j15 = this.f13575h;
        long j16 = i13 == 0 ? j10 + j14 : j10 + j15;
        long j17 = this.f13576i;
        return (j17 == j15 || i13 != 0) ? j16 : (j15 - j17) + j16;
    }

    public final boolean b() {
        return !za.h.a(o4.d.f9486i, this.f13577j);
    }

    public final boolean c() {
        return this.f13575h != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return za.h.a(this.f13569a, oVar.f13569a) && this.f13570b == oVar.f13570b && za.h.a(this.f13571c, oVar.f13571c) && za.h.a(this.f13572d, oVar.f13572d) && za.h.a(this.f13573e, oVar.f13573e) && za.h.a(this.f13574f, oVar.f13574f) && this.g == oVar.g && this.f13575h == oVar.f13575h && this.f13576i == oVar.f13576i && za.h.a(this.f13577j, oVar.f13577j) && this.f13578k == oVar.f13578k && this.f13579l == oVar.f13579l && this.f13580m == oVar.f13580m && this.f13581n == oVar.f13581n && this.f13582o == oVar.f13582o && this.f13583p == oVar.f13583p && this.f13584q == oVar.f13584q && this.f13585r == oVar.f13585r && this.f13586s == oVar.f13586s && this.f13587t == oVar.f13587t && this.f13588u == oVar.f13588u && this.f13589v == oVar.f13589v && this.f13590w == oVar.f13590w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = (this.f13574f.hashCode() + ((this.f13573e.hashCode() + android.support.v4.media.d.g(this.f13572d, android.support.v4.media.d.g(this.f13571c, (s.e.b(this.f13570b) + (this.f13569a.hashCode() * 31)) * 31, 31), 31)) * 31)) * 31;
        long j10 = this.g;
        int i10 = (hashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f13575h;
        int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f13576i;
        int b2 = (s.e.b(this.f13579l) + ((((this.f13577j.hashCode() + ((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31)) * 31) + this.f13578k) * 31)) * 31;
        long j13 = this.f13580m;
        int i12 = (b2 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
        long j14 = this.f13581n;
        int i13 = (i12 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
        long j15 = this.f13582o;
        int i14 = (i13 + ((int) (j15 ^ (j15 >>> 32)))) * 31;
        long j16 = this.f13583p;
        int i15 = (i14 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        boolean z10 = this.f13584q;
        int i16 = z10;
        if (z10 != 0) {
            i16 = 1;
        }
        int b10 = (((((s.e.b(this.f13585r) + ((i15 + i16) * 31)) * 31) + this.f13586s) * 31) + this.f13587t) * 31;
        long j17 = this.f13588u;
        return ((((b10 + ((int) ((j17 >>> 32) ^ j17))) * 31) + this.f13589v) * 31) + this.f13590w;
    }

    public final String toString() {
        return "{WorkSpec: " + this.f13569a + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ o(java.lang.String r36, int r37, java.lang.String r38, java.lang.String r39, o4.f r40, o4.f r41, long r42, long r44, long r46, o4.d r48, int r49, int r50, long r51, long r53, long r55, long r57, boolean r59, int r60, int r61, long r62, int r64, int r65, int r66) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.o.<init>(java.lang.String, int, java.lang.String, java.lang.String, o4.f, o4.f, long, long, long, o4.d, int, int, long, long, long, long, boolean, int, int, long, int, int, int):void");
    }
}
