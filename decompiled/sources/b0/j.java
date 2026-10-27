package b0;

import c2.h1;
import i1.o0;
import i1.s0;
import i1.t0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;
import o9.g0;
import o9.w0;
import s1.a0;
import s1.c1;
import s1.e0;
import s1.x0;
import s1.y0;
import s1.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class j implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public Object f2162a;

    public j(int i10) {
        switch (i10) {
            case 2:
                this.f2162a = new s0();
                break;
            case 3:
            default:
                this.f2162a = new LinkedHashMap();
                break;
            case 4:
                char[] cArr = m6.n.f9027a;
                this.f2162a = new ArrayDeque(20);
                break;
        }
    }

    public abstract void a(x4.m mVar);

    public String b() {
        return null;
    }

    public long c() {
        a0 a0Var = (a0) this;
        t0 A = a0Var.A();
        if (A.p()) {
            return -9223372036854775807L;
        }
        return l1.a0.Z(A.m(a0Var.x(), (s0) this.f2162a, 0L).f6032m);
    }

    public void d() {
        ((a0) this).f0();
    }

    public boolean e(int i10) {
        a0 a0Var = (a0) this;
        a0Var.f0();
        return a0Var.R.f5914a.f5920a.get(i10);
    }

    public boolean f() {
        a0 a0Var = (a0) this;
        t0 A = a0Var.A();
        return !A.p() && A.m(a0Var.x(), (s0) this.f2162a, 0L).f6028i;
    }

    public boolean g() {
        a0 a0Var = (a0) this;
        t0 A = a0Var.A();
        return !A.p() && A.m(a0Var.x(), (s0) this.f2162a, 0L).a();
    }

    public boolean h() {
        a0 a0Var = (a0) this;
        t0 A = a0Var.A();
        return !A.p() && A.m(a0Var.x(), (s0) this.f2162a, 0L).f6027h;
    }

    public void i(u5.h hVar) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f2162a;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(hVar);
        }
    }

    public void j() {
        ((a0) this).U(true);
    }

    public abstract void k(int i10, long j10, boolean z10);

    public void l(int i10, long j10) {
        k(((a0) this).x(), j10, false);
    }

    public void m() {
        int e7;
        int e8;
        a0 a0Var = (a0) this;
        if (a0Var.A().p() || a0Var.I()) {
            d();
            return;
        }
        t0 A = a0Var.A();
        if (A.p()) {
            e7 = -1;
        } else {
            int x6 = a0Var.x();
            a0Var.f0();
            int i10 = a0Var.G;
            if (i10 == 1) {
                i10 = 0;
            }
            a0Var.f0();
            e7 = A.e(x6, i10, a0Var.H);
        }
        if (!(e7 != -1)) {
            if (g() && f()) {
                k(a0Var.x(), -9223372036854775807L, false);
                return;
            } else {
                d();
                return;
            }
        }
        t0 A2 = a0Var.A();
        if (A2.p()) {
            e8 = -1;
        } else {
            int x10 = a0Var.x();
            a0Var.f0();
            int i11 = a0Var.G;
            if (i11 == 1) {
                i11 = 0;
            }
            a0Var.f0();
            e8 = A2.e(x10, i11, a0Var.H);
        }
        if (e8 == -1) {
            d();
        } else if (e8 == a0Var.x()) {
            k(a0Var.x(), -9223372036854775807L, true);
        } else {
            k(e8, -9223372036854775807L, false);
        }
    }

    public void n(int i10, long j10) {
        a0 a0Var = (a0) this;
        long y8 = a0Var.y() + j10;
        long D = a0Var.D();
        if (D != -9223372036854775807L) {
            y8 = Math.min(y8, D);
        }
        l(i10, Math.max(y8, 0L));
    }

    public void o() {
        int k10;
        int k11;
        int k12;
        a0 a0Var = (a0) this;
        if (a0Var.A().p() || a0Var.I()) {
            d();
            return;
        }
        t0 A = a0Var.A();
        if (A.p()) {
            k10 = -1;
        } else {
            int x6 = a0Var.x();
            a0Var.f0();
            int i10 = a0Var.G;
            if (i10 == 1) {
                i10 = 0;
            }
            a0Var.f0();
            k10 = A.k(x6, i10, a0Var.H);
        }
        boolean z10 = k10 != -1;
        if (g() && !h()) {
            if (!z10) {
                d();
                return;
            }
            t0 A2 = a0Var.A();
            if (A2.p()) {
                k12 = -1;
            } else {
                int x10 = a0Var.x();
                a0Var.f0();
                int i11 = a0Var.G;
                if (i11 == 1) {
                    i11 = 0;
                }
                a0Var.f0();
                k12 = A2.k(x10, i11, a0Var.H);
            }
            if (k12 == -1) {
                d();
                return;
            } else if (k12 == a0Var.x()) {
                k(a0Var.x(), -9223372036854775807L, true);
                return;
            } else {
                k(k12, -9223372036854775807L, false);
                return;
            }
        }
        if (z10) {
            long y8 = a0Var.y();
            a0Var.f0();
            if (y8 <= a0Var.f11217x) {
                t0 A3 = a0Var.A();
                if (A3.p()) {
                    k11 = -1;
                } else {
                    int x11 = a0Var.x();
                    a0Var.f0();
                    int i12 = a0Var.G;
                    if (i12 == 1) {
                        i12 = 0;
                    }
                    a0Var.f0();
                    k11 = A3.k(x11, i12, a0Var.H);
                }
                if (k11 == -1) {
                    d();
                    return;
                } else if (k11 == a0Var.x()) {
                    k(a0Var.x(), -9223372036854775807L, true);
                    return;
                } else {
                    k(k11, -9223372036854775807L, false);
                    return;
                }
            }
        }
        l(7, 0L);
    }

    public void p(i1.a0 a0Var) {
        w0 r2 = g0.r(a0Var);
        a0 a0Var2 = (a0) this;
        a0Var2.f0();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < r2.f9688r; i10++) {
            arrayList.add(a0Var2.f11211r.d((i1.a0) r2.get(i10)));
        }
        a0Var2.f0();
        a0Var2.C(a0Var2.f11203l0);
        a0Var2.y();
        a0Var2.I++;
        ArrayList arrayList2 = a0Var2.f11209p;
        if (!arrayList2.isEmpty()) {
            int size = arrayList2.size();
            for (int i11 = size - 1; i11 >= 0; i11--) {
                arrayList2.remove(i11);
            }
            h1 h1Var = a0Var2.P;
            int[] iArr = h1Var.f2599b;
            int[] iArr2 = new int[iArr.length - size];
            int i12 = 0;
            for (int i13 = 0; i13 < iArr.length; i13++) {
                int i14 = iArr[i13];
                if (i14 < 0 || i14 >= size) {
                    int i15 = i13 - i12;
                    if (i14 >= 0) {
                        i14 -= size;
                    }
                    iArr2[i15] = i14;
                } else {
                    i12++;
                }
            }
            a0Var2.P = new h1(iArr2, new Random(h1Var.f2598a.nextLong()));
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            x0 x0Var = new x0((c2.a) arrayList.get(i16), a0Var2.f11210q);
            arrayList3.add(x0Var);
            arrayList2.add(i16, new z(x0Var.f11484b, x0Var.f11483a));
        }
        a0Var2.P = a0Var2.P.a(arrayList3.size());
        c1 c1Var = new c1(arrayList2, a0Var2.P);
        boolean p10 = c1Var.p();
        int i17 = c1Var.f11242d;
        if (!p10 && -1 >= i17) {
            throw new i1.q();
        }
        int a10 = c1Var.a(a0Var2.H);
        y0 K = a0Var2.K(a0Var2.f11203l0, c1Var, a0Var2.L(c1Var, a10, -9223372036854775807L));
        int i18 = K.f11497e;
        if (a10 != -1 && i18 != 1) {
            i18 = (c1Var.p() || a10 >= i17) ? 4 : 2;
        }
        y0 J = a0.J(K, i18);
        a0Var2.f11202l.f11343v.a(17, new e0(arrayList3, a0Var2.P, a10, l1.a0.O(-9223372036854775807L))).b();
        a0Var2.d0(J, 0, (a0Var2.f11203l0.f11494b.f2539a.equals(J.f11494b.f2539a) || a0Var2.f11203l0.f11493a.p()) ? false : true, 4, a0Var2.z(J), -1, false);
    }

    public j(k2.g0 g0Var) {
        this.f2162a = g0Var;
    }
}
