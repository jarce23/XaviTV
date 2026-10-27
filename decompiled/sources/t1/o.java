package t1;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import c2.d0;
import c2.f0;
import c2.k0;
import c2.z;
import i1.f1;
import i1.i0;
import i1.j0;
import i1.l0;
import i1.m0;
import i1.n0;
import i1.o0;
import i1.r0;
import i1.s0;
import i1.t0;
import i1.z0;
import j9.g1;
import java.io.IOException;
import java.util.List;
import l1.a0;
import l1.v;
import l1.x;
import o9.b1;
import o9.e0;
import o9.g0;
import o9.w0;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements m0, k0, v1.d {

    /* renamed from: o, reason: collision with root package name */
    public final v f11822o;

    /* renamed from: p, reason: collision with root package name */
    public final r0 f11823p;

    /* renamed from: q, reason: collision with root package name */
    public final s0 f11824q;

    /* renamed from: r, reason: collision with root package name */
    public final g1 f11825r;

    /* renamed from: s, reason: collision with root package name */
    public final SparseArray f11826s;

    /* renamed from: t, reason: collision with root package name */
    public l1.p f11827t;

    /* renamed from: u, reason: collision with root package name */
    public o0 f11828u;

    /* renamed from: v, reason: collision with root package name */
    public x f11829v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f11830w;

    public o(v vVar) {
        vVar.getClass();
        this.f11822o = vVar;
        int i10 = a0.f8067a;
        Looper myLooper = Looper.myLooper();
        this.f11827t = new l1.p(myLooper == null ? Looper.getMainLooper() : myLooper, vVar, new h3.b(23));
        r0 r0Var = new r0();
        this.f11823p = r0Var;
        this.f11824q = new s0();
        g1 g1Var = new g1();
        g1Var.f7290o = r0Var;
        e0 e0Var = g0.f9617p;
        g1Var.f7291p = w0.f9686s;
        g1Var.f7292q = b1.f9578u;
        this.f11825r = g1Var;
        this.f11826s = new SparseArray();
    }

    @Override // i1.m0
    public final void A(int i10) {
        a J = J();
        O(J, 4, new g(J, i10, 1));
    }

    @Override // i1.m0
    public final void B(i0 i0Var) {
        d0 d0Var;
        a J = (!(i0Var instanceof s1.l) || (d0Var = ((s1.l) i0Var).f11373v) == null) ? J() : K(d0Var);
        O(J, 10, new a7.g(J, 9, i0Var));
    }

    @Override // i1.m0
    public final void C(boolean z10) {
        a J = J();
        O(J, 9, new e(J, z10, 1));
    }

    @Override // i1.m0
    public final void D() {
        i1.d dVar = i1.d.f5843b;
        a N = N();
        O(N, 20, new d(N));
    }

    @Override // i1.m0
    public final void E(final int i10, final int i11) {
        final a N = N();
        O(N, 24, new l1.m() { // from class: t1.i
            @Override // l1.m
            public final void invoke(Object obj) {
                ((b) obj).D(a.this, i10, i11);
            }
        });
    }

    @Override // c2.k0
    public final void F(int i10, d0 d0Var, z zVar) {
        a M = M(i10, d0Var);
        O(M, 1004, new j(M, zVar, 0));
    }

    @Override // c2.k0
    public final void G(int i10, d0 d0Var, z zVar) {
        a M = M(i10, d0Var);
        O(M, WebSocketProtocol.CLOSE_NO_STATUS_CODE, new j(M, zVar, 1));
    }

    @Override // i1.m0
    public final void H(z0 z0Var) {
        a J = J();
        O(J, 19, new k(J, z0Var, 3));
    }

    @Override // i1.m0
    public final void I(boolean z10) {
        a J = J();
        O(J, 7, new e(J, z10, 0));
    }

    public final a J() {
        return K((d0) this.f11825r.f7293r);
    }

    public final a K(d0 d0Var) {
        this.f11828u.getClass();
        t0 t0Var = d0Var == null ? null : (t0) ((b1) this.f11825r.f7292q).get(d0Var);
        if (d0Var != null && t0Var != null) {
            return L(t0Var, t0Var.g(d0Var.f2539a, this.f11823p).f6014c, d0Var);
        }
        int x6 = ((s1.a0) this.f11828u).x();
        t0 A = ((s1.a0) this.f11828u).A();
        if (x6 >= A.o()) {
            A = t0.f6037a;
        }
        return L(A, x6, null);
    }

    public final a L(t0 t0Var, int i10, d0 d0Var) {
        d0 d0Var2 = t0Var.p() ? null : d0Var;
        this.f11822o.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z10 = t0Var.equals(((s1.a0) this.f11828u).A()) && i10 == ((s1.a0) this.f11828u).x();
        long j10 = 0;
        if (d0Var2 == null || !d0Var2.b()) {
            if (z10) {
                s1.a0 a0Var = (s1.a0) this.f11828u;
                a0Var.f0();
                j10 = a0Var.u(a0Var.f11203l0);
            } else if (!t0Var.p()) {
                j10 = a0.Z(t0Var.m(i10, this.f11824q, 0L).f6031l);
            }
        } else if (z10 && ((s1.a0) this.f11828u).v() == d0Var2.f2540b && ((s1.a0) this.f11828u).w() == d0Var2.f2541c) {
            j10 = ((s1.a0) this.f11828u).y();
        }
        d0 d0Var3 = (d0) this.f11825r.f7293r;
        t0 A = ((s1.a0) this.f11828u).A();
        int x6 = ((s1.a0) this.f11828u).x();
        long y8 = ((s1.a0) this.f11828u).y();
        s1.a0 a0Var2 = (s1.a0) this.f11828u;
        a0Var2.f0();
        return new a(elapsedRealtime, t0Var, i10, d0Var2, j10, A, x6, d0Var3, y8, a0.Z(a0Var2.f11203l0.f11509r));
    }

    public final a M(int i10, d0 d0Var) {
        this.f11828u.getClass();
        if (d0Var != null) {
            return ((t0) ((b1) this.f11825r.f7292q).get(d0Var)) != null ? K(d0Var) : L(t0.f6037a, i10, d0Var);
        }
        t0 A = ((s1.a0) this.f11828u).A();
        if (i10 >= A.o()) {
            A = t0.f6037a;
        }
        return L(A, i10, null);
    }

    public final a N() {
        return K((d0) this.f11825r.f7295t);
    }

    public final void O(a aVar, int i10, l1.m mVar) {
        this.f11826s.put(i10, aVar);
        this.f11827t.e(i10, mVar);
    }

    public final void P(s1.a0 a0Var, Looper looper) {
        l1.d.g(this.f11828u == null || ((g0) this.f11825r.f7291p).isEmpty());
        a0Var.getClass();
        this.f11828u = a0Var;
        this.f11829v = this.f11822o.a(looper, null);
        l1.p pVar = this.f11827t;
        this.f11827t = new l1.p(pVar.f8111d, looper, pVar.f8108a, new a7.g(this, 6, a0Var), pVar.f8115i);
    }

    @Override // i1.m0
    public final void a(f1 f1Var) {
        a N = N();
        O(N, 25, new a7.g(N, 11, f1Var));
    }

    @Override // i1.m0
    public final void b(int i10) {
        a J = J();
        O(J, 6, new g(J, i10, 0));
    }

    @Override // i1.m0
    public final void c(i1.b1 b1Var) {
        a J = J();
        O(J, 2, new a7.g(J, 8, b1Var));
    }

    @Override // i1.m0
    public final void e(int i10) {
        o0 o0Var = this.f11828u;
        o0Var.getClass();
        g1 g1Var = this.f11825r;
        g1Var.f7293r = g1.i(o0Var, (g0) g1Var.f7291p, (d0) g1Var.f7294s, (r0) g1Var.f7290o);
        g1Var.s(((s1.a0) o0Var).A());
        a J = J();
        O(J, 0, new g(J, i10, 5));
    }

    @Override // i1.m0
    public final void f(i1.d0 d0Var) {
        a J = J();
        O(J, 14, new h3.b(J, d0Var, 29));
    }

    @Override // c2.k0
    public final void g(int i10, d0 d0Var, c2.u uVar, z zVar, int i11) {
        a M = M(i10, d0Var);
        O(M, 1000, new h3.b(M, uVar, zVar, i11));
    }

    @Override // i1.m0
    public final void h(int i10) {
        a J = J();
        O(J, 8, new g(J, i10, 2));
    }

    @Override // c2.k0
    public final void i(int i10, d0 d0Var, c2.u uVar, z zVar) {
        a M = M(i10, d0Var);
        O(M, 1002, new k(M, uVar, zVar, 1));
    }

    @Override // i1.m0
    public final void j(boolean z10) {
        a J = J();
        O(J, 3, new e(J, z10, 3));
    }

    @Override // c2.k0
    public final void l(int i10, d0 d0Var, c2.u uVar, z zVar) {
        a M = M(i10, d0Var);
        O(M, WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, new k(M, uVar, zVar, 2));
    }

    @Override // i1.m0
    public final void m(boolean z10) {
        a N = N();
        O(N, 23, new e(N, z10, 2));
    }

    @Override // i1.m0
    public final void n(int i10, n0 n0Var, n0 n0Var2) {
        if (i10 == 1) {
            this.f11830w = false;
        }
        o0 o0Var = this.f11828u;
        o0Var.getClass();
        g1 g1Var = this.f11825r;
        g1Var.f7293r = g1.i(o0Var, (g0) g1Var.f7291p, (d0) g1Var.f7294s, (r0) g1Var.f7290o);
        a J = J();
        O(J, 11, new f0(i10, n0Var, n0Var2, J));
    }

    @Override // i1.m0
    public final void o(List list) {
        a J = J();
        O(J, 27, new e5.c(J, list));
    }

    @Override // c2.k0
    public final void p(int i10, d0 d0Var, c2.u uVar, z zVar, IOException iOException, boolean z10) {
        a M = M(i10, d0Var);
        O(M, 1003, new a7.f(M, uVar, zVar, iOException, z10));
    }

    @Override // i1.m0
    public final void q(i1.k0 k0Var) {
        a J = J();
        O(J, 13, new k(J, k0Var, 5));
    }

    @Override // i1.m0
    public final void r(int i10, boolean z10) {
        a J = J();
        O(J, -1, new h3.b(J, z10, i10));
    }

    @Override // i1.m0
    public final void s(i1.a0 a0Var, int i10) {
        a J = J();
        O(J, 1, new g(J, a0Var, i10));
    }

    @Override // i1.m0
    public final void t(final int i10, final boolean z10) {
        final a J = J();
        O(J, 5, new l1.m() { // from class: t1.h
            @Override // l1.m
            public final void invoke(Object obj) {
                ((b) obj).B(a.this, z10, i10);
            }
        });
    }

    @Override // i1.m0
    public final void u(final float f10) {
        final a N = N();
        O(N, 22, new l1.m() { // from class: t1.c
            @Override // l1.m
            public final void invoke(Object obj) {
                ((b) obj).p(a.this, f10);
            }
        });
    }

    @Override // i1.m0
    public final void v(i0 i0Var) {
        d0 d0Var;
        a J = (!(i0Var instanceof s1.l) || (d0Var = ((s1.l) i0Var).f11373v) == null) ? J() : K(d0Var);
        O(J, 10, new h3.b(J, i0Var, 22));
    }

    @Override // i1.m0
    public final void w(k1.c cVar) {
        a J = J();
        O(J, 27, new h3.b(J, cVar, 25));
    }

    @Override // i1.m0
    public final void x(i1.f0 f0Var) {
        a J = J();
        O(J, 28, new a7.g(J, 7, f0Var));
    }

    @Override // i1.m0
    public final void y(int i10) {
        a N = N();
        O(N, 21, new g(N, i10, 4));
    }

    @Override // i1.m0
    public final void z(j0 j0Var) {
        a J = J();
        O(J, 12, new a7.g(J, 5, j0Var));
    }

    @Override // i1.m0
    public final void k() {
    }

    @Override // i1.m0
    public final void d(l0 l0Var) {
    }
}
