package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements b0, a0 {

    /* renamed from: o, reason: collision with root package name */
    public final b0 f2532o;

    /* renamed from: p, reason: collision with root package name */
    public a0 f2533p;

    /* renamed from: q, reason: collision with root package name */
    public c[] f2534q = new c[0];

    /* renamed from: r, reason: collision with root package name */
    public long f2535r;

    /* renamed from: s, reason: collision with root package name */
    public long f2536s;

    /* renamed from: t, reason: collision with root package name */
    public long f2537t;

    /* renamed from: u, reason: collision with root package name */
    public g f2538u;

    public d(b0 b0Var, boolean z10, long j10, long j11) {
        this.f2532o = b0Var;
        this.f2535r = z10 ? j10 : -9223372036854775807L;
        this.f2536s = j10;
        this.f2537t = j11;
    }

    @Override // c2.g1
    public final boolean a() {
        return this.f2532o.a();
    }

    @Override // c2.f1
    public final void b(g1 g1Var) {
        a0 a0Var = this.f2533p;
        a0Var.getClass();
        a0Var.b(this);
    }

    @Override // c2.a0
    public final void c(b0 b0Var) {
        if (this.f2538u != null) {
            return;
        }
        a0 a0Var = this.f2533p;
        a0Var.getClass();
        a0Var.c(this);
    }

    public final boolean d() {
        return this.f2535r != -9223372036854775807L;
    }

    @Override // c2.g1
    public final long e() {
        long e7 = this.f2532o.e();
        if (e7 != Long.MIN_VALUE) {
            long j10 = this.f2537t;
            if (j10 == Long.MIN_VALUE || e7 < j10) {
                return e7;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // c2.b0
    public final long g() {
        if (d()) {
            long j10 = this.f2535r;
            this.f2535r = -9223372036854775807L;
            long g = g();
            return g != -9223372036854775807L ? g : j10;
        }
        long g6 = this.f2532o.g();
        if (g6 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j11 = this.f2536s;
        long j12 = this.f2537t;
        long max = Math.max(g6, j11);
        return j12 != Long.MIN_VALUE ? Math.min(max, j12) : max;
    }

    @Override // c2.b0
    public final long h(long j10, s1.f1 f1Var) {
        long j11 = this.f2536s;
        if (j10 == j11) {
            return j11;
        }
        long j12 = l1.a0.j(f1Var.f11293a, 0L, j10 - j11);
        long j13 = f1Var.f11294b;
        long j14 = this.f2537t;
        long j15 = l1.a0.j(j13, 0L, j14 == Long.MIN_VALUE ? Long.MAX_VALUE : j14 - j10);
        if (j12 != f1Var.f11293a || j15 != f1Var.f11294b) {
            f1Var = new s1.f1(j12, j15);
        }
        return this.f2532o.h(j10, f1Var);
    }

    @Override // c2.b0
    public final n1 j() {
        return this.f2532o.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0079  */
    @Override // c2.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long k(f2.t[] r18, boolean[] r19, c2.e1[] r20, boolean[] r21, long r22) {
        /*
            r17 = this;
            r0 = r17
            r8 = r20
            int r1 = r8.length
            c2.c[] r1 = new c2.c[r1]
            r0.f2534q = r1
            int r1 = r8.length
            c2.e1[] r4 = new c2.e1[r1]
            r1 = 0
        Ld:
            int r2 = r8.length
            if (r1 >= r2) goto L23
            c2.c[] r2 = r0.f2534q
            r3 = r8[r1]
            c2.c r3 = (c2.c) r3
            r2[r1] = r3
            if (r3 == 0) goto L1d
            c2.e1 r10 = r3.f2529o
            goto L1e
        L1d:
            r10 = 0
        L1e:
            r4[r1] = r10
            int r1 = r1 + 1
            goto Ld
        L23:
            c2.b0 r1 = r0.f2532o
            r2 = r18
            r3 = r19
            r5 = r21
            r6 = r22
            long r11 = r1.k(r2, r3, r4, r5, r6)
            long r13 = r0.f2537t
            r3 = 0
            long r9 = java.lang.Math.max(r11, r6)
            r15 = -9223372036854775808
            int r5 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r5 == 0) goto L42
            long r9 = java.lang.Math.min(r9, r13)
        L42:
            boolean r5 = r0.d()
            if (r5 == 0) goto L6e
            int r5 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r5 >= 0) goto L4d
            goto L69
        L4d:
            r5 = 0
            int r5 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r5 == 0) goto L6e
            int r5 = r2.length
            r6 = 0
        L55:
            if (r6 >= r5) goto L6e
            r7 = r2[r6]
            if (r7 == 0) goto L6b
            i1.p r7 = r7.l()
            java.lang.String r11 = r7.f5991n
            java.lang.String r7 = r7.f5988k
            boolean r7 = i1.g0.a(r11, r7)
            if (r7 != 0) goto L6b
        L69:
            r5 = r9
            goto L73
        L6b:
            int r6 = r6 + 1
            goto L55
        L6e:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L73:
            r0.f2535r = r5
            r1 = 0
        L76:
            int r2 = r8.length
            if (r1 >= r2) goto L9c
            r2 = r4[r1]
            if (r2 != 0) goto L82
            c2.c[] r2 = r0.f2534q
            r2[r1] = r3
            goto L93
        L82:
            c2.c[] r5 = r0.f2534q
            r6 = r5[r1]
            if (r6 == 0) goto L8c
            c2.e1 r6 = r6.f2529o
            if (r6 == r2) goto L93
        L8c:
            c2.c r6 = new c2.c
            r6.<init>(r0, r2)
            r5[r1] = r6
        L93:
            c2.c[] r2 = r0.f2534q
            r2 = r2[r1]
            r8[r1] = r2
            int r1 = r1 + 1
            goto L76
        L9c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.d.k(f2.t[], boolean[], c2.e1[], boolean[], long):long");
    }

    @Override // c2.b0
    public final void l(a0 a0Var, long j10) {
        this.f2533p = a0Var;
        this.f2532o.l(this, j10);
    }

    @Override // c2.g1
    public final long m() {
        long m10 = this.f2532o.m();
        if (m10 != Long.MIN_VALUE) {
            long j10 = this.f2537t;
            if (j10 == Long.MIN_VALUE || m10 < j10) {
                return m10;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // c2.b0
    public final void n() {
        g gVar = this.f2538u;
        if (gVar != null) {
            throw gVar;
        }
        this.f2532o.n();
    }

    @Override // c2.b0
    public final long p(long j10) {
        this.f2535r = -9223372036854775807L;
        for (c cVar : this.f2534q) {
            if (cVar != null) {
                cVar.f2530p = false;
            }
        }
        long p10 = this.f2532o.p(j10);
        long j11 = this.f2536s;
        long j12 = this.f2537t;
        long max = Math.max(p10, j11);
        return j12 != Long.MIN_VALUE ? Math.min(max, j12) : max;
    }

    @Override // c2.b0
    public final void r(long j10) {
        this.f2532o.r(j10);
    }

    @Override // c2.g1
    public final boolean s(s1.k0 k0Var) {
        return this.f2532o.s(k0Var);
    }

    @Override // c2.g1
    public final void v(long j10) {
        this.f2532o.v(j10);
    }
}
