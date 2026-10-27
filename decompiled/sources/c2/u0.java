package c2;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u0 implements b0, k2.p, g2.i, g2.l, c1 {

    /* renamed from: d0, reason: collision with root package name */
    public static final Map f2719d0;

    /* renamed from: e0, reason: collision with root package name */
    public static final i1.p f2720e0;
    public final x4.m A;
    public final l1.g B;
    public final p0 C;
    public final p0 D;
    public final Handler E;
    public a0 F;
    public x2.b G;
    public d1[] H;
    public t0[] I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public x4.i N;
    public k2.a0 O;
    public long P;
    public boolean Q;
    public int R;
    public boolean S;
    public boolean T;
    public boolean U;
    public int V;
    public boolean W;
    public long X;
    public long Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f2721a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f2722b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f2723c0;

    /* renamed from: o, reason: collision with root package name */
    public final Uri f2724o;

    /* renamed from: p, reason: collision with root package name */
    public final o1.h f2725p;

    /* renamed from: q, reason: collision with root package name */
    public final v1.f f2726q;

    /* renamed from: r, reason: collision with root package name */
    public final n7.i f2727r;

    /* renamed from: s, reason: collision with root package name */
    public final j0 f2728s;

    /* renamed from: t, reason: collision with root package name */
    public final j0 f2729t;

    /* renamed from: u, reason: collision with root package name */
    public final x0 f2730u;

    /* renamed from: v, reason: collision with root package name */
    public final g2.e f2731v;

    /* renamed from: w, reason: collision with root package name */
    public final long f2732w;

    /* renamed from: x, reason: collision with root package name */
    public final i1.p f2733x;

    /* renamed from: y, reason: collision with root package name */
    public final long f2734y;

    /* renamed from: z, reason: collision with root package name */
    public final g2.n f2735z;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        f2719d0 = Collections.unmodifiableMap(hashMap);
        i1.o oVar = new i1.o();
        oVar.f5929a = "icy";
        oVar.f5940m = i1.g0.m("application/x-icy");
        f2720e0 = new i1.p(oVar);
    }

    public u0(Uri uri, o1.h hVar, x4.m mVar, v1.f fVar, j0 j0Var, n7.i iVar, j0 j0Var2, x0 x0Var, g2.e eVar, int i10, i1.p pVar, long j10, h2.b bVar) {
        this.f2724o = uri;
        this.f2725p = hVar;
        this.f2726q = fVar;
        this.f2729t = j0Var;
        this.f2727r = iVar;
        this.f2728s = j0Var2;
        this.f2730u = x0Var;
        this.f2731v = eVar;
        this.f2732w = i10;
        this.f2733x = pVar;
        this.f2735z = bVar != null ? new g2.n(bVar) : new g2.n("ProgressiveMediaPeriod");
        this.A = mVar;
        this.f2734y = j10;
        this.B = new l1.g();
        this.C = new p0(this, 1);
        this.D = new p0(this, 2);
        this.E = l1.a0.n(null);
        this.I = new t0[0];
        this.H = new d1[0];
        this.Y = -9223372036854775807L;
        this.R = 1;
    }

    public final void A() {
        long j10;
        if (this.f2723c0 || this.K || !this.J || this.O == null) {
            return;
        }
        for (d1 d1Var : this.H) {
            if (d1Var.t() == null) {
                return;
            }
        }
        this.B.e();
        int length = this.H.length;
        i1.u0[] u0VarArr = new i1.u0[length];
        boolean[] zArr = new boolean[length];
        int i10 = 0;
        while (true) {
            j10 = this.f2734y;
            if (i10 >= length) {
                break;
            }
            i1.p t3 = this.H[i10].t();
            t3.getClass();
            String str = t3.f5991n;
            boolean i11 = i1.g0.i(str);
            boolean z10 = i11 || i1.g0.l(str);
            zArr[i10] = z10;
            this.L = z10 | this.L;
            this.M = j10 != -9223372036854775807L && length == 1 && i1.g0.j(str);
            x2.b bVar = this.G;
            if (bVar != null) {
                int i12 = bVar.f13493a;
                if (i11 || this.I[i10].f2716b) {
                    i1.f0 f0Var = t3.f5989l;
                    i1.f0 f0Var2 = f0Var == null ? new i1.f0(bVar) : f0Var.a(bVar);
                    i1.o a10 = t3.a();
                    a10.f5938k = f0Var2;
                    t3 = new i1.p(a10);
                }
                if (i11 && t3.f5985h == -1 && t3.f5986i == -1 && i12 != -1) {
                    i1.o a11 = t3.a();
                    a11.f5935h = i12;
                    t3 = new i1.p(a11);
                }
            }
            int w10 = this.f2726q.w(t3);
            i1.o a12 = t3.a();
            a12.N = w10;
            i1.p pVar = new i1.p(a12);
            u0VarArr[i10] = new i1.u0(Integer.toString(i10), pVar);
            this.U = pVar.f5997t | this.U;
            i10++;
        }
        this.N = new x4.i(new n1(u0VarArr), zArr);
        if (this.M && this.P == -9223372036854775807L) {
            this.P = j10;
            this.O = new q0(this, this.O);
        }
        this.f2730u.t(this.P, this.O, this.Q);
        this.K = true;
        a0 a0Var = this.F;
        a0Var.getClass();
        a0Var.c(this);
    }

    public final void B(int i10) {
        w();
        x4.i iVar = this.N;
        boolean[] zArr = (boolean[]) iVar.f13556s;
        if (zArr[i10]) {
            return;
        }
        i1.p pVar = ((n1) iVar.f13553p).a(i10).f6042d[0];
        z zVar = new z(1, i1.g0.h(pVar.f5991n), pVar, 0, null, l1.a0.Z(this.X), -9223372036854775807L);
        j0 j0Var = this.f2728s;
        j0Var.a(new a7.g(j0Var, 3, zVar));
        zArr[i10] = true;
    }

    public final void C(int i10) {
        w();
        if (this.Z) {
            if ((!this.L || ((boolean[]) this.N.f13554q)[i10]) && !this.H[i10].u(false)) {
                this.Y = 0L;
                this.Z = false;
                this.T = true;
                this.X = 0L;
                this.f2721a0 = 0;
                for (d1 d1Var : this.H) {
                    d1Var.z(false);
                }
                a0 a0Var = this.F;
                a0Var.getClass();
                a0Var.b(this);
            }
        }
    }

    public final k2.g0 D(t0 t0Var) {
        int length = this.H.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (t0Var.equals(this.I[i10])) {
                return this.H[i10];
            }
        }
        if (this.J) {
            l1.b.q("ProgressiveMediaPeriod", "Extractor added new track (id=" + t0Var.f2715a + ") after finishing tracks.");
            return new k2.m();
        }
        v1.f fVar = this.f2726q;
        fVar.getClass();
        d1 d1Var = new d1(this.f2731v, fVar, this.f2729t);
        d1Var.f2549f = this;
        int i11 = length + 1;
        t0[] t0VarArr = (t0[]) Arrays.copyOf(this.I, i11);
        t0VarArr[length] = t0Var;
        int i12 = l1.a0.f8067a;
        this.I = t0VarArr;
        d1[] d1VarArr = (d1[]) Arrays.copyOf(this.H, i11);
        d1VarArr[length] = d1Var;
        this.H = d1VarArr;
        return d1Var;
    }

    public final void E(k2.a0 a0Var) {
        this.O = this.G == null ? a0Var : new k2.r(-9223372036854775807L);
        this.P = a0Var.l();
        boolean z10 = !this.W && a0Var.l() == -9223372036854775807L;
        this.Q = z10;
        this.R = z10 ? 7 : 1;
        if (this.K) {
            this.f2730u.t(this.P, a0Var, z10);
        } else {
            A();
        }
    }

    public final void F() {
        r0 r0Var = new r0(this, this.f2724o, this.f2725p, this.A, this, this.B);
        if (this.K) {
            l1.d.g(z());
            long j10 = this.P;
            if (j10 != -9223372036854775807L && this.Y > j10) {
                this.f2722b0 = true;
                this.Y = -9223372036854775807L;
                return;
            }
            k2.a0 a0Var = this.O;
            a0Var.getClass();
            long j11 = a0Var.j(this.Y).f7807a.f7689b;
            long j12 = this.Y;
            r0Var.f2700f.f6018a = j11;
            r0Var.f2702i = j12;
            r0Var.f2701h = true;
            r0Var.f2705l = false;
            for (d1 d1Var : this.H) {
                d1Var.f2562t = this.Y;
            }
            this.Y = -9223372036854775807L;
        }
        this.f2721a0 = x();
        this.f2735z.d(r0Var, this, this.f2727r.D(this.R));
    }

    public final boolean G() {
        return this.T || z();
    }

    @Override // c2.g1
    public final boolean a() {
        boolean z10;
        if (!this.f2735z.b()) {
            return false;
        }
        l1.g gVar = this.B;
        synchronized (gVar) {
            z10 = gVar.f8091b;
        }
        return z10;
    }

    @Override // g2.i
    public final void b(g2.k kVar, long j10, long j11) {
        r0 r0Var = (r0) kVar;
        if (this.P == -9223372036854775807L && this.O != null) {
            long y8 = y(true);
            long j12 = y8 == Long.MIN_VALUE ? 0L : y8 + 10000;
            this.P = j12;
            this.f2730u.t(j12, this.O, this.Q);
        }
        Uri uri = r0Var.f2696b.f9390q;
        u uVar = new u(j11);
        this.f2727r.getClass();
        this.f2728s.c(uVar, 1, -1, null, 0, null, r0Var.f2702i, this.P);
        this.f2722b0 = true;
        a0 a0Var = this.F;
        a0Var.getClass();
        a0Var.b(this);
    }

    @Override // g2.l
    public final void c() {
        for (d1 d1Var : this.H) {
            d1Var.z(true);
            p4.p pVar = d1Var.f2550h;
            if (pVar != null) {
                pVar.m(d1Var.f2548e);
                d1Var.f2550h = null;
                d1Var.g = null;
            }
        }
        x4.m mVar = this.A;
        k2.n nVar = (k2.n) mVar.f13565q;
        if (nVar != null) {
            nVar.a();
            mVar.f13565q = null;
        }
        mVar.f13566r = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    @Override // g2.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final g2.h d(g2.k r15, long r16, long r18, java.io.IOException r20, int r21) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.u0.d(g2.k, long, long, java.io.IOException, int):g2.h");
    }

    @Override // c2.g1
    public final long e() {
        return m();
    }

    @Override // k2.p
    public final void f() {
        this.J = true;
        this.E.post(this.C);
    }

    @Override // c2.b0
    public final long g() {
        if (this.U) {
            this.U = false;
            return this.X;
        }
        if (!this.T) {
            return -9223372036854775807L;
        }
        if (!this.f2722b0 && x() <= this.f2721a0) {
            return -9223372036854775807L;
        }
        this.T = false;
        return this.X;
    }

    @Override // c2.b0
    public final long h(long j10, s1.f1 f1Var) {
        w();
        if (!this.O.h()) {
            return 0L;
        }
        k2.z j11 = this.O.j(j10);
        return f1Var.a(j10, j11.f7807a.f7688a, j11.f7808b.f7688a);
    }

    @Override // g2.i
    public final void i(g2.k kVar, long j10, long j11, int i10) {
        u uVar;
        r0 r0Var = (r0) kVar;
        o1.c0 c0Var = r0Var.f2696b;
        if (i10 == 0) {
            uVar = new u(r0Var.f2703j);
        } else {
            Uri uri = c0Var.f9390q;
            uVar = new u(j11);
        }
        this.f2728s.e(uVar, 1, -1, null, 0, null, r0Var.f2702i, this.P, i10);
    }

    @Override // c2.b0
    public final n1 j() {
        w();
        return (n1) this.N.f13553p;
    }

    @Override // c2.b0
    public final long k(f2.t[] tVarArr, boolean[] zArr, e1[] e1VarArr, boolean[] zArr2, long j10) {
        f2.t tVar;
        w();
        x4.i iVar = this.N;
        n1 n1Var = (n1) iVar.f13553p;
        boolean[] zArr3 = (boolean[]) iVar.f13555r;
        int i10 = this.V;
        int i11 = 0;
        for (int i12 = 0; i12 < tVarArr.length; i12++) {
            e1 e1Var = e1VarArr[i12];
            if (e1Var != null && (tVarArr[i12] == null || !zArr[i12])) {
                int i13 = ((s0) e1Var).f2708o;
                l1.d.g(zArr3[i13]);
                this.V--;
                zArr3[i13] = false;
                e1VarArr[i12] = null;
            }
        }
        boolean z10 = !this.S ? j10 == 0 || this.M : i10 != 0;
        for (int i14 = 0; i14 < tVarArr.length; i14++) {
            if (e1VarArr[i14] == null && (tVar = tVarArr[i14]) != null) {
                l1.d.g(tVar.length() == 1);
                l1.d.g(tVar.f(0) == 0);
                int b2 = n1Var.b(tVar.k());
                l1.d.g(!zArr3[b2]);
                this.V++;
                zArr3[b2] = true;
                this.U = tVar.l().f5997t | this.U;
                e1VarArr[i14] = new s0(this, b2);
                zArr2[i14] = true;
                if (!z10) {
                    d1 d1Var = this.H[b2];
                    z10 = (d1Var.q() == 0 || d1Var.C(j10, true)) ? false : true;
                }
            }
        }
        if (this.V == 0) {
            this.Z = false;
            this.T = false;
            this.U = false;
            g2.n nVar = this.f2735z;
            if (nVar.b()) {
                d1[] d1VarArr = this.H;
                int length = d1VarArr.length;
                while (i11 < length) {
                    d1VarArr[i11].j();
                    i11++;
                }
                nVar.a();
            } else {
                this.f2722b0 = false;
                for (d1 d1Var2 : this.H) {
                    d1Var2.z(false);
                }
            }
        } else if (z10) {
            j10 = p(j10);
            while (i11 < e1VarArr.length) {
                if (e1VarArr[i11] != null) {
                    zArr2[i11] = true;
                }
                i11++;
            }
        }
        this.S = true;
        return j10;
    }

    @Override // c2.b0
    public final void l(a0 a0Var, long j10) {
        this.F = a0Var;
        i1.p pVar = this.f2733x;
        if (pVar == null) {
            this.B.f();
            F();
        } else {
            q(0, 3).a(pVar);
            E(new k2.x(-9223372036854775807L, new long[]{0}, new long[]{0}));
            f();
            this.Y = j10;
        }
    }

    @Override // c2.g1
    public final long m() {
        long j10;
        boolean z10;
        w();
        if (this.f2722b0 || this.V == 0) {
            return Long.MIN_VALUE;
        }
        if (z()) {
            return this.Y;
        }
        if (this.L) {
            int length = this.H.length;
            j10 = Long.MAX_VALUE;
            for (int i10 = 0; i10 < length; i10++) {
                x4.i iVar = this.N;
                if (((boolean[]) iVar.f13554q)[i10] && ((boolean[]) iVar.f13555r)[i10]) {
                    d1 d1Var = this.H[i10];
                    synchronized (d1Var) {
                        z10 = d1Var.f2565w;
                    }
                    if (!z10) {
                        j10 = Math.min(j10, this.H[i10].n());
                    }
                }
            }
        } else {
            j10 = Long.MAX_VALUE;
        }
        if (j10 == Long.MAX_VALUE) {
            j10 = y(false);
        }
        return j10 == Long.MIN_VALUE ? this.X : j10;
    }

    @Override // c2.b0
    public final void n() {
        int D = this.f2727r.D(this.R);
        g2.n nVar = this.f2735z;
        IOException iOException = nVar.f5132c;
        if (iOException != null) {
            throw iOException;
        }
        g2.j jVar = nVar.f5131b;
        if (jVar != null) {
            if (D == Integer.MIN_VALUE) {
                D = jVar.f5117o;
            }
            IOException iOException2 = jVar.f5121s;
            if (iOException2 != null && jVar.f5122t > D) {
                throw iOException2;
            }
        }
        if (this.f2722b0 && !this.K) {
            throw i1.h0.a(null, "Loading finished before preparation is complete.");
        }
    }

    @Override // c2.c1
    public final void o() {
        this.E.post(this.C);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
    
        if (r3 != false) goto L49;
     */
    @Override // c2.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long p(long r10) {
        /*
            r9 = this;
            r9.w()
            x4.i r0 = r9.N
            java.lang.Object r0 = r0.f13554q
            boolean[] r0 = (boolean[]) r0
            k2.a0 r1 = r9.O
            boolean r1 = r1.h()
            if (r1 == 0) goto L12
            goto L14
        L12:
            r10 = 0
        L14:
            r1 = 0
            r9.T = r1
            long r2 = r9.X
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            r3 = 1
            if (r2 != 0) goto L20
            r2 = r3
            goto L21
        L20:
            r2 = r1
        L21:
            r9.X = r10
            boolean r4 = r9.z()
            if (r4 == 0) goto L2c
            r9.Y = r10
            return r10
        L2c:
            int r4 = r9.R
            r5 = 7
            g2.n r6 = r9.f2735z
            if (r4 == r5) goto L73
            boolean r4 = r9.f2722b0
            if (r4 != 0) goto L3d
            boolean r4 = r6.b()
            if (r4 == 0) goto L73
        L3d:
            c2.d1[] r4 = r9.H
            int r4 = r4.length
            r5 = r1
        L41:
            if (r5 >= r4) goto L70
            c2.d1[] r7 = r9.H
            r7 = r7[r5]
            int r8 = r7.q()
            if (r8 != 0) goto L50
            if (r2 == 0) goto L50
            goto L6d
        L50:
            boolean r8 = r9.M
            if (r8 == 0) goto L5b
            int r8 = r7.f2559q
            boolean r7 = r7.B(r8)
            goto L61
        L5b:
            boolean r8 = r9.f2722b0
            boolean r7 = r7.C(r10, r8)
        L61:
            if (r7 != 0) goto L6d
            boolean r7 = r0[r5]
            if (r7 != 0) goto L6b
            boolean r7 = r9.L
            if (r7 != 0) goto L6d
        L6b:
            r3 = r1
            goto L70
        L6d:
            int r5 = r5 + 1
            goto L41
        L70:
            if (r3 == 0) goto L73
            goto La3
        L73:
            r9.Z = r1
            r9.Y = r10
            r9.f2722b0 = r1
            r9.U = r1
            boolean r0 = r6.b()
            if (r0 == 0) goto L92
            c2.d1[] r0 = r9.H
            int r2 = r0.length
        L84:
            if (r1 >= r2) goto L8e
            r3 = r0[r1]
            r3.j()
            int r1 = r1 + 1
            goto L84
        L8e:
            r6.a()
            return r10
        L92:
            r0 = 0
            r6.f5132c = r0
            c2.d1[] r0 = r9.H
            int r2 = r0.length
            r3 = r1
        L99:
            if (r3 >= r2) goto La3
            r4 = r0[r3]
            r4.z(r1)
            int r3 = r3 + 1
            goto L99
        La3:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.u0.p(long):long");
    }

    @Override // k2.p
    public final k2.g0 q(int i10, int i11) {
        return D(new t0(i10, false));
    }

    @Override // c2.b0
    public final void r(long j10) {
        if (this.M) {
            return;
        }
        w();
        if (z()) {
            return;
        }
        boolean[] zArr = (boolean[]) this.N.f13555r;
        int length = this.H.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.H[i10].i(j10, zArr[i10]);
        }
    }

    @Override // c2.g1
    public final boolean s(s1.k0 k0Var) {
        if (this.f2722b0) {
            return false;
        }
        g2.n nVar = this.f2735z;
        if (nVar.f5132c != null || this.Z) {
            return false;
        }
        if ((this.K || this.f2733x != null) && this.V == 0) {
            return false;
        }
        boolean f10 = this.B.f();
        if (nVar.b()) {
            return f10;
        }
        F();
        return true;
    }

    @Override // k2.p
    public final void t(k2.a0 a0Var) {
        this.E.post(new androidx.fragment.app.d(this, 3, a0Var));
    }

    @Override // g2.i
    public final void u(g2.k kVar, long j10, long j11, boolean z10) {
        r0 r0Var = (r0) kVar;
        Uri uri = r0Var.f2696b.f9390q;
        u uVar = new u(j11);
        this.f2727r.getClass();
        this.f2728s.b(uVar, 1, -1, null, 0, null, r0Var.f2702i, this.P);
        if (z10) {
            return;
        }
        for (d1 d1Var : this.H) {
            d1Var.z(false);
        }
        if (this.V > 0) {
            a0 a0Var = this.F;
            a0Var.getClass();
            a0Var.b(this);
        }
    }

    public final void w() {
        l1.d.g(this.K);
        this.N.getClass();
        this.O.getClass();
    }

    public final int x() {
        int i10 = 0;
        for (d1 d1Var : this.H) {
            i10 += d1Var.f2559q + d1Var.f2558p;
        }
        return i10;
    }

    public final long y(boolean z10) {
        int i10;
        long j10 = Long.MIN_VALUE;
        while (i10 < this.H.length) {
            if (!z10) {
                x4.i iVar = this.N;
                iVar.getClass();
                i10 = ((boolean[]) iVar.f13555r)[i10] ? 0 : i10 + 1;
            }
            j10 = Math.max(j10, this.H[i10].n());
        }
        return j10;
    }

    public final boolean z() {
        return this.Y != -9223372036854775807L;
    }

    @Override // c2.g1
    public final void v(long j10) {
    }
}
