package l4;

import c2.e1;
import s1.m0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public int f8216a;

    /* renamed from: b, reason: collision with root package name */
    public int f8217b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8218c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8219d;

    /* renamed from: e, reason: collision with root package name */
    public Object f8220e;

    /* renamed from: f, reason: collision with root package name */
    public Object f8221f;

    public static void b(s1.d dVar) {
        int i10 = dVar.f11255v;
        if (i10 == 2) {
            l1.d.g(i10 == 2);
            dVar.f11255v = 1;
            dVar.t();
        }
    }

    public static boolean h(s1.d dVar) {
        return dVar.f11255v != 0;
    }

    public static void l(s1.d dVar, long j10) {
        dVar.B = true;
        if (dVar instanceof e2.f) {
            e2.f fVar = (e2.f) dVar;
            l1.d.g(fVar.B);
            fVar.Y = j10;
        }
    }

    public void a(s1.d dVar, i2.o oVar) {
        l1.d.g(((s1.d) this.f8220e) == dVar || ((s1.d) this.f8221f) == dVar);
        if (h(dVar)) {
            if (dVar == ((s1.d) oVar.f6269s)) {
                oVar.f6270t = null;
                oVar.f6269s = null;
                oVar.f6265o = true;
            }
            b(dVar);
            l1.d.g(dVar.f11255v == 1);
            dVar.f11250q.f();
            dVar.f11255v = 0;
            dVar.f11256w = null;
            dVar.f11257x = null;
            dVar.B = false;
            dVar.n();
            dVar.E = null;
        }
    }

    public int c() {
        boolean h10 = h((s1.d) this.f8220e);
        s1.d dVar = (s1.d) this.f8221f;
        return (h10 ? 1 : 0) + ((dVar == null || !h(dVar)) ? 0 : 1);
    }

    public s1.d d(m0 m0Var) {
        e1 e1Var;
        if (m0Var != null && (e1Var = m0Var.f11379c[this.f8216a]) != null) {
            s1.d dVar = (s1.d) this.f8220e;
            if (dVar.f11256w == e1Var) {
                return dVar;
            }
            s1.d dVar2 = (s1.d) this.f8221f;
            if (dVar2 != null && dVar2.f11256w == e1Var) {
                return dVar2;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        if (r9.A >= r2.e()) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(s1.m0 r8, s1.d r9) {
        /*
            r7 = this;
            int r0 = r7.f8216a
            r1 = 1
            if (r9 != 0) goto L6
            goto L49
        L6:
            c2.e1[] r2 = r8.f11379c
            r2 = r2[r0]
            c2.e1 r3 = r9.f11256w
            if (r3 == 0) goto L49
            if (r3 != r2) goto L3a
            if (r2 == 0) goto L49
            boolean r2 = r9.k()
            if (r2 != 0) goto L49
            s1.m0 r2 = r8.f11388m
            s1.n0 r3 = r8.g
            boolean r3 = r3.g
            if (r3 == 0) goto L3a
            if (r2 == 0) goto L3a
            boolean r3 = r2.f11381e
            if (r3 == 0) goto L3a
            boolean r3 = r9 instanceof e2.f
            if (r3 != 0) goto L39
            boolean r3 = r9 instanceof a2.b
            if (r3 != 0) goto L39
            long r3 = r9.A
            long r5 = r2.e()
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 < 0) goto L3a
            goto L49
        L39:
            return r1
        L3a:
            s1.m0 r8 = r8.f11388m
            if (r8 == 0) goto L47
            c2.e1[] r8 = r8.f11379c
            r8 = r8[r0]
            c2.e1 r9 = r9.f11256w
            if (r8 != r9) goto L47
            goto L49
        L47:
            r8 = 0
            return r8
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.f0.e(s1.m0, s1.d):boolean");
    }

    public boolean f() {
        int i10 = this.f8217b;
        return i10 == 2 || i10 == 4 || i10 == 3;
    }

    public boolean g() {
        int i10 = this.f8217b;
        if (i10 == 0 || i10 == 2 || i10 == 4) {
            return h((s1.d) this.f8220e);
        }
        s1.d dVar = (s1.d) this.f8221f;
        dVar.getClass();
        return dVar.f11255v != 0;
    }

    public void i(boolean z10) {
        if (z10) {
            if (this.f8218c) {
                s1.d dVar = (s1.d) this.f8220e;
                l1.d.g(dVar.f11255v == 0);
                dVar.f11250q.f();
                dVar.r();
                this.f8218c = false;
                return;
            }
            return;
        }
        if (this.f8219d) {
            s1.d dVar2 = (s1.d) this.f8221f;
            dVar2.getClass();
            l1.d.g(dVar2.f11255v == 0);
            dVar2.f11250q.f();
            dVar2.r();
            this.f8219d = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int j(s1.d dVar, m0 m0Var, f2.x xVar, i2.o oVar) {
        int i10;
        s1.d dVar2 = (s1.d) this.f8220e;
        int i11 = this.f8216a;
        if (dVar == null || dVar.f11255v == 0 || (dVar == dVar2 && ((i10 = this.f8217b) == 2 || i10 == 4))) {
            return 1;
        }
        if (dVar == ((s1.d) this.f8221f) && this.f8217b == 3) {
            return 1;
        }
        Object[] objArr = dVar.f11256w != m0Var.f11379c[i11];
        boolean b2 = xVar.b(i11);
        if (!b2 || objArr != false) {
            if (!dVar.B) {
                f2.t tVar = xVar.f4959c[i11];
                int length = tVar != null ? tVar.length() : 0;
                i1.p[] pVarArr = new i1.p[length];
                for (int i12 = 0; i12 < length; i12++) {
                    tVar.getClass();
                    pVarArr[i12] = tVar.d(i12);
                }
                e1 e1Var = m0Var.f11379c[i11];
                e1Var.getClass();
                dVar.x(pVarArr, e1Var, m0Var.e(), m0Var.f11391p, m0Var.g.f11413a);
                return 3;
            }
            if (!dVar.l()) {
                return 0;
            }
            a(dVar, oVar);
            if (!b2 || f()) {
                i(dVar == dVar2);
                return 1;
            }
        }
        return 1;
    }

    public void k() {
        if (!h((s1.d) this.f8220e)) {
            i(true);
        }
        s1.d dVar = (s1.d) this.f8221f;
        if (dVar == null || dVar.f11255v != 0) {
            return;
        }
        i(false);
    }

    public void m() {
        int i10;
        s1.d dVar = (s1.d) this.f8220e;
        int i11 = dVar.f11255v;
        if (i11 == 1 && this.f8217b != 4) {
            l1.d.g(i11 == 1);
            dVar.f11255v = 2;
            dVar.s();
            return;
        }
        s1.d dVar2 = (s1.d) this.f8221f;
        if (dVar2 == null || (i10 = dVar2.f11255v) != 1 || this.f8217b == 3) {
            return;
        }
        l1.d.g(i10 == 1);
        dVar2.f11255v = 2;
        dVar2.s();
    }
}
