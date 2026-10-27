package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l1 implements b0, a0 {

    /* renamed from: o, reason: collision with root package name */
    public final b0 f2638o;

    /* renamed from: p, reason: collision with root package name */
    public final long f2639p;

    /* renamed from: q, reason: collision with root package name */
    public a0 f2640q;

    public l1(b0 b0Var, long j10) {
        this.f2638o = b0Var;
        this.f2639p = j10;
    }

    @Override // c2.g1
    public final boolean a() {
        return this.f2638o.a();
    }

    @Override // c2.f1
    public final void b(g1 g1Var) {
        a0 a0Var = this.f2640q;
        a0Var.getClass();
        a0Var.b(this);
    }

    @Override // c2.a0
    public final void c(b0 b0Var) {
        a0 a0Var = this.f2640q;
        a0Var.getClass();
        a0Var.c(this);
    }

    @Override // c2.g1
    public final long e() {
        long e7 = this.f2638o.e();
        if (e7 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return e7 + this.f2639p;
    }

    @Override // c2.b0
    public final long g() {
        long g = this.f2638o.g();
        if (g == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return g + this.f2639p;
    }

    @Override // c2.b0
    public final long h(long j10, s1.f1 f1Var) {
        long j11 = this.f2639p;
        return this.f2638o.h(j10 - j11, f1Var) + j11;
    }

    @Override // c2.b0
    public final n1 j() {
        return this.f2638o.j();
    }

    @Override // c2.b0
    public final long k(f2.t[] tVarArr, boolean[] zArr, e1[] e1VarArr, boolean[] zArr2, long j10) {
        e1[] e1VarArr2 = new e1[e1VarArr.length];
        int i10 = 0;
        while (true) {
            e1 e1Var = null;
            if (i10 >= e1VarArr.length) {
                break;
            }
            k1 k1Var = (k1) e1VarArr[i10];
            if (k1Var != null) {
                e1Var = k1Var.f2631o;
            }
            e1VarArr2[i10] = e1Var;
            i10++;
        }
        b0 b0Var = this.f2638o;
        long j11 = this.f2639p;
        long k10 = b0Var.k(tVarArr, zArr, e1VarArr2, zArr2, j10 - j11);
        for (int i11 = 0; i11 < e1VarArr.length; i11++) {
            e1 e1Var2 = e1VarArr2[i11];
            if (e1Var2 == null) {
                e1VarArr[i11] = null;
            } else {
                e1 e1Var3 = e1VarArr[i11];
                if (e1Var3 == null || ((k1) e1Var3).f2631o != e1Var2) {
                    e1VarArr[i11] = new k1(e1Var2, j11);
                }
            }
        }
        return k10 + j11;
    }

    @Override // c2.b0
    public final void l(a0 a0Var, long j10) {
        this.f2640q = a0Var;
        this.f2638o.l(this, j10 - this.f2639p);
    }

    @Override // c2.g1
    public final long m() {
        long m10 = this.f2638o.m();
        if (m10 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return m10 + this.f2639p;
    }

    @Override // c2.b0
    public final void n() {
        this.f2638o.n();
    }

    @Override // c2.b0
    public final long p(long j10) {
        long j11 = this.f2639p;
        return this.f2638o.p(j10 - j11) + j11;
    }

    @Override // c2.b0
    public final void r(long j10) {
        this.f2638o.r(j10 - this.f2639p);
    }

    @Override // c2.g1
    public final boolean s(s1.k0 k0Var) {
        s1.j0 j0Var = new s1.j0();
        long j10 = k0Var.f11365a;
        j0Var.f11363b = k0Var.f11366b;
        j0Var.f11364c = k0Var.f11367c;
        j0Var.f11362a = j10 - this.f2639p;
        return this.f2638o.s(new s1.k0(j0Var));
    }

    @Override // c2.g1
    public final void v(long j10) {
        this.f2638o.v(j10 - this.f2639p);
    }
}
