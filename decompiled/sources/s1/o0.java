package s1;

import android.util.Pair;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: c, reason: collision with root package name */
    public final t1.o f11425c;

    /* renamed from: d, reason: collision with root package name */
    public final l1.x f11426d;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.fragment.app.v0 f11427e;

    /* renamed from: f, reason: collision with root package name */
    public long f11428f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11429h;

    /* renamed from: i, reason: collision with root package name */
    public m0 f11430i;

    /* renamed from: j, reason: collision with root package name */
    public m0 f11431j;

    /* renamed from: k, reason: collision with root package name */
    public m0 f11432k;

    /* renamed from: l, reason: collision with root package name */
    public m0 f11433l;

    /* renamed from: m, reason: collision with root package name */
    public m0 f11434m;

    /* renamed from: n, reason: collision with root package name */
    public int f11435n;

    /* renamed from: o, reason: collision with root package name */
    public Object f11436o;

    /* renamed from: p, reason: collision with root package name */
    public long f11437p;

    /* renamed from: a, reason: collision with root package name */
    public final i1.r0 f11423a = new i1.r0();

    /* renamed from: b, reason: collision with root package name */
    public final i1.s0 f11424b = new i1.s0();

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f11438q = new ArrayList();

    public o0(t1.o oVar, l1.x xVar, androidx.fragment.app.v0 v0Var, o oVar2) {
        this.f11425c = oVar;
        this.f11426d = xVar;
        this.f11427e = v0Var;
    }

    public static c2.d0 o(i1.t0 t0Var, Object obj, long j10, long j11, i1.s0 s0Var, i1.r0 r0Var) {
        t0Var.g(obj, r0Var);
        t0Var.n(r0Var.f6014c, s0Var);
        t0Var.b(obj);
        int i10 = r0Var.g.f5815a;
        if (i10 != 0) {
            if (i10 == 1) {
                r0Var.f(0);
            }
            r0Var.g.getClass();
            r0Var.g(0);
        }
        t0Var.g(obj, r0Var);
        int c10 = r0Var.c(j10);
        return c10 == -1 ? new c2.d0(r0Var.b(j10), j11, obj) : new c2.d0(obj, c10, r0Var.e(c10), j11, -1);
    }

    public final m0 a() {
        m0 m0Var = this.f11430i;
        if (m0Var == null) {
            return null;
        }
        if (m0Var == this.f11431j) {
            this.f11431j = m0Var.f11388m;
        }
        if (m0Var == this.f11432k) {
            this.f11432k = m0Var.f11388m;
        }
        m0Var.i();
        int i10 = this.f11435n - 1;
        this.f11435n = i10;
        if (i10 == 0) {
            this.f11433l = null;
            m0 m0Var2 = this.f11430i;
            this.f11436o = m0Var2.f11378b;
            this.f11437p = m0Var2.g.f11413a.f2542d;
        }
        this.f11430i = this.f11430i.f11388m;
        l();
        return this.f11430i;
    }

    public final void b() {
        if (this.f11435n == 0) {
            return;
        }
        m0 m0Var = this.f11430i;
        l1.d.h(m0Var);
        this.f11436o = m0Var.f11378b;
        this.f11437p = m0Var.g.f11413a.f2542d;
        while (m0Var != null) {
            m0Var.i();
            m0Var = m0Var.f11388m;
        }
        this.f11430i = null;
        this.f11433l = null;
        this.f11431j = null;
        this.f11432k = null;
        this.f11435n = 0;
        l();
    }

    public final n0 c(i1.t0 t0Var, m0 m0Var, long j10) {
        long j11;
        i1.r0 r0Var;
        i1.t0 t0Var2;
        Object obj;
        long j12;
        long j13;
        long j14;
        long q10;
        n0 n0Var = m0Var.g;
        long j15 = (m0Var.f11391p + n0Var.f11417e) - j10;
        if (!n0Var.f11419h) {
            c2.d0 d0Var = n0Var.f11413a;
            Object obj2 = d0Var.f2539a;
            int i10 = d0Var.f2543e;
            i1.r0 r0Var2 = this.f11423a;
            t0Var.g(obj2, r0Var2);
            boolean z10 = n0Var.g;
            if (!d0Var.b()) {
                if (i10 != -1) {
                    r0Var2.f(i10);
                }
                int e7 = r0Var2.e(i10);
                r0Var2.g(i10);
                if (e7 != r0Var2.g.a(i10).f5803a) {
                    return e(t0Var, d0Var.f2539a, d0Var.f2543e, e7, n0Var.f11417e, d0Var.f2542d, z10);
                }
                t0Var.g(obj2, r0Var2);
                r0Var2.d(i10);
                r0Var2.g.a(i10).getClass();
                return f(t0Var, d0Var.f2539a, 0L, n0Var.f11417e, d0Var.f2542d, false);
            }
            int i11 = d0Var.f2540b;
            int i12 = r0Var2.g.a(i11).f5803a;
            if (i12 == -1) {
                return null;
            }
            int a10 = r0Var2.g.a(i11).a(d0Var.f2541c);
            if (a10 < i12) {
                return e(t0Var, d0Var.f2539a, i11, a10, n0Var.f11415c, d0Var.f2542d, z10);
            }
            long j16 = n0Var.f11415c;
            if (j16 == -9223372036854775807L) {
                int i13 = r0Var2.f6014c;
                long max = Math.max(0L, j15);
                j11 = 0;
                Pair j17 = t0Var.j(this.f11424b, r0Var2, i13, -9223372036854775807L, max);
                r0Var = r0Var2;
                t0Var2 = t0Var;
                if (j17 == null) {
                    return null;
                }
                j16 = ((Long) j17.second).longValue();
            } else {
                j11 = 0;
                r0Var = r0Var2;
                t0Var2 = t0Var;
            }
            int i14 = d0Var.f2540b;
            t0Var2.g(obj2, r0Var);
            r0Var.d(i14);
            r0Var.g.a(i14).getClass();
            return f(t0Var, d0Var.f2539a, Math.max(j11, j16), n0Var.f11415c, d0Var.f2542d, z10);
        }
        n0 n0Var2 = m0Var.g;
        c2.d0 d0Var2 = n0Var2.f11413a;
        long j18 = n0Var2.f11415c;
        int d6 = t0Var.d(t0Var.b(d0Var2.f2539a), this.f11423a, this.f11424b, this.g, this.f11429h);
        if (d6 != -1) {
            i1.r0 r0Var3 = this.f11423a;
            int i15 = t0Var.f(d6, r0Var3, true).f6014c;
            Object obj3 = r0Var3.f6013b;
            obj3.getClass();
            long j19 = d0Var2.f2542d;
            if (t0Var.m(i15, this.f11424b, 0L).f6033n == d6) {
                Pair j20 = t0Var.j(this.f11424b, this.f11423a, i15, -9223372036854775807L, Math.max(0L, j15));
                if (j20 != null) {
                    Object obj4 = j20.first;
                    long longValue = ((Long) j20.second).longValue();
                    m0 m0Var2 = m0Var.f11388m;
                    if (m0Var2 == null || !m0Var2.f11378b.equals(obj4)) {
                        q10 = q(obj4);
                        if (q10 == -1) {
                            q10 = this.f11428f;
                            this.f11428f = 1 + q10;
                        }
                    } else {
                        q10 = m0Var2.g.f11413a.f2542d;
                    }
                    obj = obj4;
                    j12 = longValue;
                    j14 = q10;
                    j13 = -9223372036854775807L;
                }
            } else {
                obj = obj3;
                j12 = 0;
                j13 = 0;
                j14 = j19;
            }
            c2.d0 o2 = o(t0Var, obj, j12, j14, this.f11424b, this.f11423a);
            if (j13 != -9223372036854775807L && j18 != -9223372036854775807L) {
                int i16 = t0Var.g(d0Var2.f2539a, r0Var3).g.f5815a;
                r0Var3.g.getClass();
                if (i16 > 0) {
                    r0Var3.g(0);
                }
            }
            return d(t0Var, o2, j13, j12);
        }
        return null;
    }

    public final n0 d(i1.t0 t0Var, c2.d0 d0Var, long j10, long j11) {
        t0Var.g(d0Var.f2539a, this.f11423a);
        return d0Var.b() ? e(t0Var, d0Var.f2539a, d0Var.f2540b, d0Var.f2541c, j10, d0Var.f2542d, false) : f(t0Var, d0Var.f2539a, j11, j10, d0Var.f2542d, false);
    }

    public final n0 e(i1.t0 t0Var, Object obj, int i10, int i11, long j10, long j11, boolean z10) {
        c2.d0 d0Var = new c2.d0(obj, i10, i11, j11, -1);
        i1.r0 r0Var = this.f11423a;
        long a10 = t0Var.g(obj, r0Var).a(i10, i11);
        if (i11 == r0Var.e(i10)) {
            r0Var.g.getClass();
        }
        r0Var.g(i10);
        long j12 = 0;
        if (a10 != -9223372036854775807L && 0 >= a10) {
            j12 = Math.max(0L, a10 - 1);
        }
        return new n0(d0Var, j12, j10, -9223372036854775807L, a10, z10, false, false, false, false);
    }

    public final n0 f(i1.t0 t0Var, Object obj, long j10, long j11, long j12, boolean z10) {
        long j13;
        i1.r0 r0Var = this.f11423a;
        t0Var.g(obj, r0Var);
        int b2 = r0Var.b(j10);
        boolean z11 = false;
        if (b2 != -1) {
            r0Var.g(b2);
        } else if (r0Var.g.f5815a > 0) {
            r0Var.g(0);
        }
        c2.d0 d0Var = new c2.d0(b2, j12, obj);
        if (!d0Var.b() && b2 == -1) {
            z11 = true;
        }
        boolean j14 = j(t0Var, d0Var);
        boolean i10 = i(t0Var, d0Var, z11);
        if (b2 != -1) {
            r0Var.g(b2);
        }
        if (b2 != -1) {
            r0Var.f(b2);
        }
        if (b2 != -1) {
            r0Var.d(b2);
            j13 = 0;
        } else {
            j13 = -9223372036854775807L;
        }
        long j15 = (j13 == -9223372036854775807L || j13 == Long.MIN_VALUE) ? r0Var.f6015d : j13;
        return new n0(d0Var, (j15 == -9223372036854775807L || j10 < j15) ? j10 : Math.max(0L, j15 - 1), j11, j13, j15, z10, false, z11, j14, i10);
    }

    public final m0 g() {
        return this.f11432k;
    }

    public final n0 h(i1.t0 t0Var, n0 n0Var) {
        long j10;
        c2.d0 d0Var = n0Var.f11413a;
        boolean b2 = d0Var.b();
        int i10 = d0Var.f2543e;
        boolean z10 = !b2 && i10 == -1;
        int i11 = d0Var.f2540b;
        boolean j11 = j(t0Var, d0Var);
        boolean i12 = i(t0Var, d0Var, z10);
        Object obj = d0Var.f2539a;
        i1.r0 r0Var = this.f11423a;
        t0Var.g(obj, r0Var);
        if (d0Var.b() || i10 == -1) {
            j10 = -9223372036854775807L;
        } else {
            r0Var.d(i10);
            j10 = 0;
        }
        long a10 = d0Var.b() ? r0Var.a(i11, d0Var.f2541c) : (j10 == -9223372036854775807L || j10 == Long.MIN_VALUE) ? r0Var.f6015d : j10;
        if (d0Var.b()) {
            r0Var.g(i11);
        } else if (i10 != -1) {
            r0Var.g(i10);
        }
        return new n0(d0Var, n0Var.f11414b, n0Var.f11415c, j10, a10, n0Var.f11418f, false, z10, j11, i12);
    }

    public final boolean i(i1.t0 t0Var, c2.d0 d0Var, boolean z10) {
        int b2 = t0Var.b(d0Var.f2539a);
        if (!t0Var.m(t0Var.f(b2, this.f11423a, false).f6014c, this.f11424b, 0L).f6028i) {
            if (t0Var.d(b2, this.f11423a, this.f11424b, this.g, this.f11429h) == -1 && z10) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(i1.t0 t0Var, c2.d0 d0Var) {
        boolean z10 = !d0Var.b() && d0Var.f2543e == -1;
        Object obj = d0Var.f2539a;
        if (z10) {
            if (t0Var.m(t0Var.g(obj, this.f11423a).f6014c, this.f11424b, 0L).f6034o == t0Var.b(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void k() {
        m0 m0Var = this.f11434m;
        if (m0Var == null || m0Var.h()) {
            this.f11434m = null;
            for (int i10 = 0; i10 < this.f11438q.size(); i10++) {
                m0 m0Var2 = (m0) this.f11438q.get(i10);
                if (!m0Var2.h()) {
                    this.f11434m = m0Var2;
                    return;
                }
            }
        }
    }

    public final void l() {
        o9.d0 m10 = o9.g0.m();
        for (m0 m0Var = this.f11430i; m0Var != null; m0Var = m0Var.f11388m) {
            m10.a(m0Var.g.f11413a);
        }
        m0 m0Var2 = this.f11431j;
        this.f11426d.c(new androidx.emoji2.text.m(this, m10, m0Var2 == null ? null : m0Var2.g.f11413a, 4));
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [c2.g1, java.lang.Object] */
    public final void m(long j10) {
        m0 m0Var = this.f11433l;
        if (m0Var != null) {
            l1.d.g(m0Var.f11388m == null);
            if (m0Var.f11381e) {
                m0Var.f11377a.v(j10 - m0Var.f11391p);
            }
        }
    }

    public final int n(m0 m0Var) {
        l1.d.h(m0Var);
        int i10 = 0;
        if (m0Var.equals(this.f11433l)) {
            return 0;
        }
        this.f11433l = m0Var;
        while (true) {
            m0Var = m0Var.f11388m;
            if (m0Var == null) {
                break;
            }
            if (m0Var == this.f11431j) {
                m0 m0Var2 = this.f11430i;
                this.f11431j = m0Var2;
                this.f11432k = m0Var2;
                i10 = 3;
            }
            if (m0Var == this.f11432k) {
                this.f11432k = this.f11431j;
                i10 |= 2;
            }
            m0Var.i();
            this.f11435n--;
        }
        m0 m0Var3 = this.f11433l;
        m0Var3.getClass();
        if (m0Var3.f11388m != null) {
            m0Var3.b();
            m0Var3.f11388m = null;
            m0Var3.c();
        }
        l();
        return i10;
    }

    public final c2.d0 p(i1.t0 t0Var, Object obj, long j10) {
        long q10;
        int b2;
        Object obj2 = obj;
        i1.r0 r0Var = this.f11423a;
        int i10 = t0Var.g(obj2, r0Var).f6014c;
        Object obj3 = this.f11436o;
        if (obj3 == null || (b2 = t0Var.b(obj3)) == -1 || t0Var.f(b2, r0Var, false).f6014c != i10) {
            m0 m0Var = this.f11430i;
            while (true) {
                if (m0Var == null) {
                    m0 m0Var2 = this.f11430i;
                    while (true) {
                        if (m0Var2 != null) {
                            int b10 = t0Var.b(m0Var2.f11378b);
                            if (b10 != -1 && t0Var.f(b10, r0Var, false).f6014c == i10) {
                                q10 = m0Var2.g.f11413a.f2542d;
                                break;
                            }
                            m0Var2 = m0Var2.f11388m;
                        } else {
                            q10 = q(obj2);
                            if (q10 == -1) {
                                q10 = this.f11428f;
                                this.f11428f = 1 + q10;
                                if (this.f11430i == null) {
                                    this.f11436o = obj2;
                                    this.f11437p = q10;
                                }
                            }
                        }
                    }
                } else {
                    if (m0Var.f11378b.equals(obj2)) {
                        q10 = m0Var.g.f11413a.f2542d;
                        break;
                    }
                    m0Var = m0Var.f11388m;
                }
            }
        } else {
            q10 = this.f11437p;
        }
        t0Var.g(obj2, r0Var);
        int i11 = r0Var.f6014c;
        i1.s0 s0Var = this.f11424b;
        t0Var.n(i11, s0Var);
        boolean z10 = false;
        for (int b11 = t0Var.b(obj); b11 >= s0Var.f6033n; b11--) {
            t0Var.f(b11, r0Var, true);
            boolean z11 = r0Var.g.f5815a > 0;
            z10 |= z11;
            if (r0Var.c(r0Var.f6015d) != -1) {
                obj2 = r0Var.f6013b;
                obj2.getClass();
            }
            if (z10 && (!z11 || r0Var.f6015d != 0)) {
                break;
            }
        }
        return o(t0Var, obj2, j10, q10, this.f11424b, this.f11423a);
    }

    public final long q(Object obj) {
        for (int i10 = 0; i10 < this.f11438q.size(); i10++) {
            m0 m0Var = (m0) this.f11438q.get(i10);
            if (m0Var.f11378b.equals(obj)) {
                return m0Var.g.f11413a.f2542d;
            }
        }
        return -1L;
    }

    public final int r(i1.t0 t0Var) {
        i1.t0 t0Var2;
        m0 m0Var;
        m0 m0Var2 = this.f11430i;
        if (m0Var2 == null) {
            return 0;
        }
        int b2 = t0Var.b(m0Var2.f11378b);
        while (true) {
            t0Var2 = t0Var;
            b2 = t0Var2.d(b2, this.f11423a, this.f11424b, this.g, this.f11429h);
            while (true) {
                m0Var2.getClass();
                m0Var = m0Var2.f11388m;
                if (m0Var == null || m0Var2.g.f11419h) {
                    break;
                }
                m0Var2 = m0Var;
            }
            if (b2 == -1 || m0Var == null || t0Var2.b(m0Var.f11378b) != b2) {
                break;
            }
            m0Var2 = m0Var;
            t0Var = t0Var2;
        }
        int n10 = n(m0Var2);
        m0Var2.g = h(t0Var2, m0Var2.g);
        return n10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b4, code lost:
    
        return n(r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a6 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int s(i1.t0 r18, long r19, long r21, long r23) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            s1.m0 r2 = r0.f11430i
            r3 = 0
        L7:
            r4 = 0
            if (r2 == 0) goto Lb5
            s1.n0 r5 = r2.g
            if (r3 != 0) goto L15
            s1.n0 r3 = r0.h(r1, r5)
            r6 = r19
            goto L30
        L15:
            r6 = r19
            s1.n0 r8 = r0.c(r1, r3, r6)
            if (r8 == 0) goto Lb0
            long r9 = r5.f11414b
            long r11 = r8.f11414b
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto Lb0
            c2.d0 r9 = r5.f11413a
            c2.d0 r10 = r8.f11413a
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto Lb0
            r3 = r8
        L30:
            long r8 = r3.f11417e
            long r10 = r5.f11415c
            long r12 = r5.f11417e
            s1.n0 r10 = r3.a(r10)
            r2.g = r10
            int r10 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r10 == 0) goto La7
            r2.k()
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 != 0) goto L52
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L55
        L52:
            long r10 = r2.f11391p
            long r8 = r8 + r10
        L55:
            s1.m0 r1 = r0.f11431j
            r10 = 1
            r14 = -9223372036854775808
            if (r2 != r1) goto L6c
            s1.n0 r1 = r2.g
            boolean r1 = r1.g
            if (r1 != 0) goto L6c
            int r1 = (r21 > r14 ? 1 : (r21 == r14 ? 0 : -1))
            if (r1 == 0) goto L6a
            int r1 = (r21 > r8 ? 1 : (r21 == r8 ? 0 : -1))
            if (r1 < 0) goto L6c
        L6a:
            r1 = r10
            goto L6d
        L6c:
            r1 = r4
        L6d:
            s1.m0 r11 = r0.f11432k
            if (r2 != r11) goto L7b
            int r11 = (r23 > r14 ? 1 : (r23 == r14 ? 0 : -1))
            if (r11 == 0) goto L79
            int r8 = (r23 > r8 ? 1 : (r23 == r8 ? 0 : -1))
            if (r8 < 0) goto L7b
        L79:
            r8 = r10
            goto L7c
        L7b:
            r8 = r4
        L7c:
            int r2 = r0.n(r2)
            if (r2 == 0) goto L83
            return r2
        L83:
            int r2 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r2 != 0) goto L99
            long r11 = r5.f11416d
            int r5 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r5 != 0) goto L99
            long r11 = r3.f11416d
            int r3 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r3 == 0) goto L99
            int r3 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r3 == 0) goto L99
            r3 = r10
            goto L9a
        L99:
            r3 = r4
        L9a:
            if (r1 == 0) goto La1
            if (r2 != 0) goto La0
            if (r3 == 0) goto La1
        La0:
            r4 = r10
        La1:
            if (r8 == 0) goto La6
            r1 = r4 | 2
            return r1
        La6:
            return r4
        La7:
            s1.m0 r3 = r2.f11388m
            r16 = r3
            r3 = r2
            r2 = r16
            goto L7
        Lb0:
            int r1 = r0.n(r3)
            return r1
        Lb5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.o0.s(i1.t0, long, long, long):int");
    }
}
