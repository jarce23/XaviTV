package s1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d implements a1 {
    public boolean B;
    public boolean C;
    public c2.d0 E;
    public f2.r F;

    /* renamed from: p, reason: collision with root package name */
    public final int f11249p;

    /* renamed from: r, reason: collision with root package name */
    public d1 f11251r;

    /* renamed from: s, reason: collision with root package name */
    public int f11252s;

    /* renamed from: t, reason: collision with root package name */
    public t1.u f11253t;

    /* renamed from: u, reason: collision with root package name */
    public l1.v f11254u;

    /* renamed from: v, reason: collision with root package name */
    public int f11255v;

    /* renamed from: w, reason: collision with root package name */
    public c2.e1 f11256w;

    /* renamed from: x, reason: collision with root package name */
    public i1.p[] f11257x;

    /* renamed from: y, reason: collision with root package name */
    public long f11258y;

    /* renamed from: z, reason: collision with root package name */
    public long f11259z;

    /* renamed from: o, reason: collision with root package name */
    public final Object f11248o = new Object();

    /* renamed from: q, reason: collision with root package name */
    public final x4.e f11250q = new x4.e(16, false);
    public long A = Long.MIN_VALUE;
    public i1.t0 D = i1.t0.f6037a;

    public d(int i10) {
        this.f11249p = i10;
    }

    public int A() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final s1.l f(java.lang.Exception r12, i1.p r13, boolean r14, int r15) {
        /*
            r11 = this;
            r0 = 4
            if (r13 == 0) goto L1a
            boolean r1 = r11.C
            if (r1 != 0) goto L1a
            r1 = 1
            r11.C = r1
            r1 = 0
            int r2 = r11.z(r13)     // Catch: java.lang.Throwable -> L14 s1.l -> L18
            r2 = r2 & 7
            r11.C = r1
            goto L1b
        L14:
            r0 = move-exception
            r11.C = r1
            throw r0
        L18:
            r11.C = r1
        L1a:
            r2 = r0
        L1b:
            java.lang.String r5 = r11.j()
            int r6 = r11.f11252s
            c2.d0 r9 = r11.E
            s1.l r1 = new s1.l
            if (r13 != 0) goto L29
            r8 = r0
            goto L2a
        L29:
            r8 = r2
        L2a:
            r2 = 1
            r3 = r12
            r7 = r13
            r10 = r14
            r4 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.d.f(java.lang.Exception, i1.p, boolean, int):s1.l");
    }

    public long h(long j10, long j11) {
        if (this.f11255v == 1) {
            return (m() || l()) ? 1000000L : 10000L;
        }
        return 10000L;
    }

    public l0 i() {
        return null;
    }

    public abstract String j();

    public final boolean k() {
        return this.A == Long.MIN_VALUE;
    }

    public abstract boolean l();

    public abstract boolean m();

    public abstract void n();

    public abstract void p(long j10, boolean z10);

    public final int v(x4.e eVar, r1.e eVar2, int i10) {
        c2.e1 e1Var = this.f11256w;
        e1Var.getClass();
        int f10 = e1Var.f(eVar, eVar2, i10);
        if (f10 == -4) {
            if (eVar2.d(4)) {
                this.A = Long.MIN_VALUE;
                return this.B ? -4 : -3;
            }
            long j10 = eVar2.f10412u + this.f11258y;
            eVar2.f10412u = j10;
            this.A = Math.max(this.A, j10);
            return f10;
        }
        if (f10 == -5) {
            i1.p pVar = (i1.p) eVar.f13543q;
            pVar.getClass();
            long j11 = pVar.f5996s;
            if (j11 != Long.MAX_VALUE) {
                i1.o a10 = pVar.a();
                a10.f5945r = j11 + this.f11258y;
                eVar.f13543q = new i1.p(a10);
            }
        }
        return f10;
    }

    public abstract void w(long j10, long j11);

    public final void x(i1.p[] pVarArr, c2.e1 e1Var, long j10, long j11, c2.d0 d0Var) {
        l1.d.g(!this.B);
        this.f11256w = e1Var;
        this.E = d0Var;
        if (this.A == Long.MIN_VALUE) {
            this.A = j10;
        }
        this.f11257x = pVarArr;
        this.f11258y = j11;
        u(pVarArr, j10, j11, d0Var);
    }

    public abstract int z(i1.p pVar);

    public void g() {
    }

    public void q() {
    }

    public void r() {
    }

    public void s() {
    }

    public void t() {
    }

    @Override // s1.a1
    public void c(int i10, Object obj) {
    }

    public void o(boolean z10, boolean z11) {
    }

    public void y(float f10, float f11) {
    }

    public void u(i1.p[] pVarArr, long j10, long j11, c2.d0 d0Var) {
    }
}
