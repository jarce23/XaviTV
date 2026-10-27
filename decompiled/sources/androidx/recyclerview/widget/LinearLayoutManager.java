package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.media.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.emoji2.text.g;
import b4.a1;
import b4.b1;
import b4.f1;
import b4.n0;
import b4.o0;
import b4.p;
import b4.p0;
import b4.u;
import b4.u0;
import b4.v;
import b4.w;
import b4.x;
import b4.y;
import java.util.ArrayList;
import java.util.List;
import k5.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class LinearLayoutManager extends o0 implements a1 {
    public final u A;
    public final v B;
    public final int C;
    public final int[] D;

    /* renamed from: p, reason: collision with root package name */
    public int f1448p;

    /* renamed from: q, reason: collision with root package name */
    public w f1449q;

    /* renamed from: r, reason: collision with root package name */
    public g f1450r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1451s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f1452t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1453u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1454v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f1455w;

    /* renamed from: x, reason: collision with root package name */
    public int f1456x;

    /* renamed from: y, reason: collision with root package name */
    public int f1457y;

    /* renamed from: z, reason: collision with root package name */
    public x f1458z;

    public LinearLayoutManager(int i10) {
        this.f1448p = 1;
        this.f1452t = false;
        this.f1453u = false;
        this.f1454v = false;
        this.f1455w = true;
        this.f1456x = -1;
        this.f1457y = Integer.MIN_VALUE;
        this.f1458z = null;
        this.A = new u();
        this.B = new v();
        this.C = 2;
        this.D = new int[2];
        r1(i10);
        c(null);
        if (this.f1452t) {
            this.f1452t = false;
            C0();
        }
    }

    @Override // b4.o0
    public int E0(int i10, u0 u0Var, b1 b1Var) {
        if (this.f1448p == 1) {
            return 0;
        }
        return q1(i10, u0Var, b1Var);
    }

    @Override // b4.o0
    public final void F0(int i10) {
        this.f1456x = i10;
        this.f1457y = Integer.MIN_VALUE;
        x xVar = this.f1458z;
        if (xVar != null) {
            xVar.f2446o = -1;
        }
        C0();
    }

    @Override // b4.o0
    public int G0(int i10, u0 u0Var, b1 b1Var) {
        if (this.f1448p == 0) {
            return 0;
        }
        return q1(i10, u0Var, b1Var);
    }

    @Override // b4.o0
    public final boolean N0() {
        if (this.f2368m != 1073741824 && this.f2367l != 1073741824) {
            int x6 = x();
            for (int i10 = 0; i10 < x6; i10++) {
                ViewGroup.LayoutParams layoutParams = w(i10).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // b4.o0
    public void P0(RecyclerView recyclerView, int i10) {
        y yVar = new y(recyclerView.getContext());
        yVar.f2450a = i10;
        Q0(yVar);
    }

    @Override // b4.o0
    public boolean R0() {
        return this.f1458z == null && this.f1451s == this.f1454v;
    }

    @Override // b4.o0
    public final boolean S() {
        return true;
    }

    public void S0(b1 b1Var, int[] iArr) {
        int i10;
        int l10 = b1Var.f2185a != -1 ? this.f1450r.l() : 0;
        if (this.f1449q.f2439f == -1) {
            i10 = 0;
        } else {
            i10 = l10;
            l10 = 0;
        }
        iArr[0] = l10;
        iArr[1] = i10;
    }

    public void T0(b1 b1Var, w wVar, p pVar) {
        int i10 = wVar.f2437d;
        if (i10 < 0 || i10 >= b1Var.b()) {
            return;
        }
        pVar.b(i10, Math.max(0, wVar.g));
    }

    public final int U0(b1 b1Var) {
        if (x() == 0) {
            return 0;
        }
        Y0();
        g gVar = this.f1450r;
        boolean z10 = !this.f1455w;
        return a.f(b1Var, gVar, b1(z10), a1(z10), this, this.f1455w);
    }

    public final int V0(b1 b1Var) {
        if (x() == 0) {
            return 0;
        }
        Y0();
        g gVar = this.f1450r;
        boolean z10 = !this.f1455w;
        return a.g(b1Var, gVar, b1(z10), a1(z10), this, this.f1455w, this.f1453u);
    }

    public final int W0(b1 b1Var) {
        if (x() == 0) {
            return 0;
        }
        Y0();
        g gVar = this.f1450r;
        boolean z10 = !this.f1455w;
        return a.h(b1Var, gVar, b1(z10), a1(z10), this, this.f1455w);
    }

    public final int X0(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f1448p == 1) ? 1 : Integer.MIN_VALUE : this.f1448p == 0 ? 1 : Integer.MIN_VALUE : this.f1448p == 1 ? -1 : Integer.MIN_VALUE : this.f1448p == 0 ? -1 : Integer.MIN_VALUE : (this.f1448p != 1 && k1()) ? -1 : 1 : (this.f1448p != 1 && k1()) ? 1 : -1;
    }

    public final void Y0() {
        if (this.f1449q == null) {
            w wVar = new w();
            wVar.f2434a = true;
            wVar.f2440h = 0;
            wVar.f2441i = 0;
            wVar.f2443k = null;
            this.f1449q = wVar;
        }
    }

    public final int Z0(u0 u0Var, w wVar, b1 b1Var, boolean z10) {
        int i10;
        int i11 = wVar.f2436c;
        int i12 = wVar.g;
        if (i12 != Integer.MIN_VALUE) {
            if (i11 < 0) {
                wVar.g = i12 + i11;
            }
            n1(u0Var, wVar);
        }
        int i13 = wVar.f2436c + wVar.f2440h;
        while (true) {
            if ((!wVar.f2444l && i13 <= 0) || (i10 = wVar.f2437d) < 0 || i10 >= b1Var.b()) {
                break;
            }
            v vVar = this.B;
            vVar.f2430a = 0;
            vVar.f2431b = false;
            vVar.f2432c = false;
            vVar.f2433d = false;
            l1(u0Var, b1Var, wVar, vVar);
            if (!vVar.f2431b) {
                int i14 = wVar.f2435b;
                int i15 = vVar.f2430a;
                wVar.f2435b = (wVar.f2439f * i15) + i14;
                if (!vVar.f2432c || wVar.f2443k != null || !b1Var.g) {
                    wVar.f2436c -= i15;
                    i13 -= i15;
                }
                int i16 = wVar.g;
                if (i16 != Integer.MIN_VALUE) {
                    int i17 = i16 + i15;
                    wVar.g = i17;
                    int i18 = wVar.f2436c;
                    if (i18 < 0) {
                        wVar.g = i17 + i18;
                    }
                    n1(u0Var, wVar);
                }
                if (z10 && vVar.f2433d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i11 - wVar.f2436c;
    }

    @Override // b4.a1
    public final PointF a(int i10) {
        if (x() == 0) {
            return null;
        }
        int i11 = (i10 < o0.N(w(0))) != this.f1453u ? -1 : 1;
        return this.f1448p == 0 ? new PointF(i11, 0.0f) : new PointF(0.0f, i11);
    }

    public final View a1(boolean z10) {
        return this.f1453u ? e1(0, x(), z10) : e1(x() - 1, -1, z10);
    }

    @Override // b4.o0
    public View b0(View view, int i10, u0 u0Var, b1 b1Var) {
        int X0;
        p1();
        if (x() != 0 && (X0 = X0(i10)) != Integer.MIN_VALUE) {
            Y0();
            t1(X0, (int) (this.f1450r.l() * 0.33333334f), false, b1Var);
            w wVar = this.f1449q;
            wVar.g = Integer.MIN_VALUE;
            wVar.f2434a = false;
            Z0(u0Var, wVar, b1Var, true);
            View d12 = X0 == -1 ? this.f1453u ? d1(x() - 1, -1) : d1(0, x()) : this.f1453u ? d1(0, x()) : d1(x() - 1, -1);
            View j12 = X0 == -1 ? j1() : i1();
            if (!j12.hasFocusable()) {
                return d12;
            }
            if (d12 != null) {
                return j12;
            }
        }
        return null;
    }

    public final View b1(boolean z10) {
        return this.f1453u ? e1(x() - 1, -1, z10) : e1(0, x(), z10);
    }

    @Override // b4.o0
    public final void c(String str) {
        if (this.f1458z == null) {
            super.c(str);
        }
    }

    @Override // b4.o0
    public final void c0(AccessibilityEvent accessibilityEvent) {
        super.c0(accessibilityEvent);
        if (x() > 0) {
            View e12 = e1(0, x(), false);
            accessibilityEvent.setFromIndex(e12 == null ? -1 : o0.N(e12));
            accessibilityEvent.setToIndex(c1());
        }
    }

    public final int c1() {
        View e12 = e1(x() - 1, -1, false);
        if (e12 == null) {
            return -1;
        }
        return o0.N(e12);
    }

    public final View d1(int i10, int i11) {
        int i12;
        int i13;
        Y0();
        if (i11 <= i10 && i11 >= i10) {
            return w(i10);
        }
        if (this.f1450r.e(w(i10)) < this.f1450r.k()) {
            i12 = 16644;
            i13 = 16388;
        } else {
            i12 = 4161;
            i13 = 4097;
        }
        return this.f1448p == 0 ? this.f2359c.k(i10, i11, i12, i13) : this.f2360d.k(i10, i11, i12, i13);
    }

    @Override // b4.o0
    public final boolean e() {
        return this.f1448p == 0;
    }

    public final View e1(int i10, int i11, boolean z10) {
        Y0();
        int i12 = z10 ? 24579 : 320;
        return this.f1448p == 0 ? this.f2359c.k(i10, i11, i12, 320) : this.f2360d.k(i10, i11, i12, 320);
    }

    @Override // b4.o0
    public final boolean f() {
        return this.f1448p == 1;
    }

    public View f1(u0 u0Var, b1 b1Var, boolean z10, boolean z11) {
        int i10;
        int i11;
        int i12;
        Y0();
        int x6 = x();
        if (z11) {
            i11 = x() - 1;
            i10 = -1;
            i12 = -1;
        } else {
            i10 = x6;
            i11 = 0;
            i12 = 1;
        }
        int b2 = b1Var.b();
        int k10 = this.f1450r.k();
        int g = this.f1450r.g();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i11 != i10) {
            View w10 = w(i11);
            int N = o0.N(w10);
            int e7 = this.f1450r.e(w10);
            int b10 = this.f1450r.b(w10);
            if (N >= 0 && N < b2) {
                if (!((p0) w10.getLayoutParams()).f2381a.i()) {
                    boolean z12 = b10 <= k10 && e7 < k10;
                    boolean z13 = e7 >= g && b10 > g;
                    if (!z12 && !z13) {
                        return w10;
                    }
                    if (z10) {
                        if (!z13) {
                            if (view != null) {
                            }
                            view = w10;
                        }
                        view2 = w10;
                    } else {
                        if (!z12) {
                            if (view != null) {
                            }
                            view = w10;
                        }
                        view2 = w10;
                    }
                } else if (view3 == null) {
                    view3 = w10;
                }
            }
            i11 += i12;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    public final int g1(int i10, u0 u0Var, b1 b1Var, boolean z10) {
        int g;
        int g6 = this.f1450r.g() - i10;
        if (g6 <= 0) {
            return 0;
        }
        int i11 = -q1(-g6, u0Var, b1Var);
        int i12 = i10 + i11;
        if (!z10 || (g = this.f1450r.g() - i12) <= 0) {
            return i11;
        }
        this.f1450r.o(g);
        return g + i11;
    }

    public final int h1(int i10, u0 u0Var, b1 b1Var, boolean z10) {
        int k10;
        int k11 = i10 - this.f1450r.k();
        if (k11 <= 0) {
            return 0;
        }
        int i11 = -q1(k11, u0Var, b1Var);
        int i12 = i10 + i11;
        if (!z10 || (k10 = i12 - this.f1450r.k()) <= 0) {
            return i11;
        }
        this.f1450r.o(-k10);
        return i11 - k10;
    }

    @Override // b4.o0
    public final void i(int i10, int i11, b1 b1Var, p pVar) {
        if (this.f1448p != 0) {
            i10 = i11;
        }
        if (x() == 0 || i10 == 0) {
            return;
        }
        Y0();
        t1(i10 > 0 ? 1 : -1, Math.abs(i10), true, b1Var);
        T0(b1Var, this.f1449q, pVar);
    }

    public final View i1() {
        return w(this.f1453u ? 0 : x() - 1);
    }

    @Override // b4.o0
    public final void j(int i10, p pVar) {
        boolean z10;
        int i11;
        x xVar = this.f1458z;
        if (xVar == null || (i11 = xVar.f2446o) < 0) {
            p1();
            z10 = this.f1453u;
            i11 = this.f1456x;
            if (i11 == -1) {
                i11 = z10 ? i10 - 1 : 0;
            }
        } else {
            z10 = xVar.f2448q;
        }
        int i12 = z10 ? -1 : 1;
        for (int i13 = 0; i13 < this.C && i11 >= 0 && i11 < i10; i13++) {
            pVar.b(i11, 0);
            i11 += i12;
        }
    }

    public final View j1() {
        return w(this.f1453u ? x() - 1 : 0);
    }

    @Override // b4.o0
    public final int k(b1 b1Var) {
        return U0(b1Var);
    }

    public final boolean k1() {
        return I() == 1;
    }

    @Override // b4.o0
    public int l(b1 b1Var) {
        return V0(b1Var);
    }

    public void l1(u0 u0Var, b1 b1Var, w wVar, v vVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        View b2 = wVar.b(u0Var);
        if (b2 == null) {
            vVar.f2431b = true;
            return;
        }
        p0 p0Var = (p0) b2.getLayoutParams();
        if (wVar.f2443k == null) {
            if (this.f1453u == (wVar.f2439f == -1)) {
                b(b2, -1, false);
            } else {
                b(b2, 0, false);
            }
        } else {
            if (this.f1453u == (wVar.f2439f == -1)) {
                b(b2, -1, true);
            } else {
                b(b2, 0, true);
            }
        }
        p0 p0Var2 = (p0) b2.getLayoutParams();
        Rect K = this.f2358b.K(b2);
        int i14 = K.left + K.right;
        int i15 = K.top + K.bottom;
        int y8 = o0.y(e(), this.f2369n, this.f2367l, L() + K() + ((ViewGroup.MarginLayoutParams) p0Var2).leftMargin + ((ViewGroup.MarginLayoutParams) p0Var2).rightMargin + i14, ((ViewGroup.MarginLayoutParams) p0Var2).width);
        int y10 = o0.y(f(), this.f2370o, this.f2368m, J() + M() + ((ViewGroup.MarginLayoutParams) p0Var2).topMargin + ((ViewGroup.MarginLayoutParams) p0Var2).bottomMargin + i15, ((ViewGroup.MarginLayoutParams) p0Var2).height);
        if (M0(b2, y8, y10, p0Var2)) {
            b2.measure(y8, y10);
        }
        vVar.f2430a = this.f1450r.c(b2);
        if (this.f1448p == 1) {
            if (k1()) {
                i13 = this.f2369n - L();
                i10 = i13 - this.f1450r.d(b2);
            } else {
                i10 = K();
                i13 = this.f1450r.d(b2) + i10;
            }
            if (wVar.f2439f == -1) {
                i11 = wVar.f2435b;
                i12 = i11 - vVar.f2430a;
            } else {
                i12 = wVar.f2435b;
                i11 = vVar.f2430a + i12;
            }
        } else {
            int M = M();
            int d6 = this.f1450r.d(b2) + M;
            if (wVar.f2439f == -1) {
                int i16 = wVar.f2435b;
                int i17 = i16 - vVar.f2430a;
                i13 = i16;
                i11 = d6;
                i10 = i17;
                i12 = M;
            } else {
                int i18 = wVar.f2435b;
                int i19 = vVar.f2430a + i18;
                i10 = i18;
                i11 = d6;
                i12 = M;
                i13 = i19;
            }
        }
        o0.U(b2, i10, i12, i13, i11);
        if (p0Var.f2381a.i() || p0Var.f2381a.l()) {
            vVar.f2432c = true;
        }
        vVar.f2433d = b2.hasFocusable();
    }

    @Override // b4.o0
    public int m(b1 b1Var) {
        return W0(b1Var);
    }

    @Override // b4.o0
    public final int n(b1 b1Var) {
        return U0(b1Var);
    }

    @Override // b4.o0
    public void n0(u0 u0Var, b1 b1Var) {
        View view;
        View view2;
        View f12;
        int i10;
        int e7;
        int i11;
        int i12;
        List list;
        int i13;
        int i14;
        int g12;
        int i15;
        View s10;
        int e8;
        int i16;
        int i17;
        int i18 = -1;
        if (!(this.f1458z == null && this.f1456x == -1) && b1Var.b() == 0) {
            v0(u0Var);
            return;
        }
        x xVar = this.f1458z;
        if (xVar != null && (i17 = xVar.f2446o) >= 0) {
            this.f1456x = i17;
        }
        Y0();
        this.f1449q.f2434a = false;
        p1();
        RecyclerView recyclerView = this.f2358b;
        if (recyclerView == null || (view = recyclerView.getFocusedChild()) == null || ((ArrayList) this.f2357a.f232r).contains(view)) {
            view = null;
        }
        u uVar = this.A;
        if (!uVar.f2420d || this.f1456x != -1 || this.f1458z != null) {
            uVar.g();
            uVar.f2419c = this.f1453u ^ this.f1454v;
            if (!b1Var.g && (i10 = this.f1456x) != -1) {
                if (i10 < 0 || i10 >= b1Var.b()) {
                    this.f1456x = -1;
                    this.f1457y = Integer.MIN_VALUE;
                } else {
                    int i19 = this.f1456x;
                    uVar.f2418b = i19;
                    x xVar2 = this.f1458z;
                    if (xVar2 != null && xVar2.f2446o >= 0) {
                        boolean z10 = xVar2.f2448q;
                        uVar.f2419c = z10;
                        if (z10) {
                            uVar.f2421e = this.f1450r.g() - this.f1458z.f2447p;
                        } else {
                            uVar.f2421e = this.f1450r.k() + this.f1458z.f2447p;
                        }
                    } else if (this.f1457y == Integer.MIN_VALUE) {
                        View s11 = s(i19);
                        if (s11 == null) {
                            if (x() > 0) {
                                uVar.f2419c = (this.f1456x < o0.N(w(0))) == this.f1453u;
                            }
                            uVar.b();
                        } else if (this.f1450r.c(s11) > this.f1450r.l()) {
                            uVar.b();
                        } else if (this.f1450r.e(s11) - this.f1450r.k() < 0) {
                            uVar.f2421e = this.f1450r.k();
                            uVar.f2419c = false;
                        } else if (this.f1450r.g() - this.f1450r.b(s11) < 0) {
                            uVar.f2421e = this.f1450r.g();
                            uVar.f2419c = true;
                        } else {
                            if (uVar.f2419c) {
                                int b2 = this.f1450r.b(s11);
                                g gVar = this.f1450r;
                                e7 = (Integer.MIN_VALUE == gVar.f569a ? 0 : gVar.l() - gVar.f569a) + b2;
                            } else {
                                e7 = this.f1450r.e(s11);
                            }
                            uVar.f2421e = e7;
                        }
                    } else {
                        boolean z11 = this.f1453u;
                        uVar.f2419c = z11;
                        if (z11) {
                            uVar.f2421e = this.f1450r.g() - this.f1457y;
                        } else {
                            uVar.f2421e = this.f1450r.k() + this.f1457y;
                        }
                    }
                    uVar.f2420d = true;
                }
            }
            if (x() != 0) {
                RecyclerView recyclerView2 = this.f2358b;
                if (recyclerView2 == null || (view2 = recyclerView2.getFocusedChild()) == null || ((ArrayList) this.f2357a.f232r).contains(view2)) {
                    view2 = null;
                }
                if (view2 != null) {
                    p0 p0Var = (p0) view2.getLayoutParams();
                    if (!p0Var.f2381a.i() && p0Var.f2381a.c() >= 0 && p0Var.f2381a.c() < b1Var.b()) {
                        uVar.d(view2, o0.N(view2));
                        uVar.f2420d = true;
                    }
                }
                boolean z12 = this.f1451s;
                boolean z13 = this.f1454v;
                if (z12 == z13 && (f12 = f1(u0Var, b1Var, uVar.f2419c, z13)) != null) {
                    uVar.c(f12, o0.N(f12));
                    if (!b1Var.g && R0()) {
                        int e10 = this.f1450r.e(f12);
                        int b10 = this.f1450r.b(f12);
                        int k10 = this.f1450r.k();
                        int g = this.f1450r.g();
                        boolean z14 = b10 <= k10 && e10 < k10;
                        boolean z15 = e10 >= g && b10 > g;
                        if (z14 || z15) {
                            if (uVar.f2419c) {
                                k10 = g;
                            }
                            uVar.f2421e = k10;
                        }
                    }
                    uVar.f2420d = true;
                }
            }
            uVar.b();
            uVar.f2418b = this.f1454v ? b1Var.b() - 1 : 0;
            uVar.f2420d = true;
        } else if (view != null && (this.f1450r.e(view) >= this.f1450r.g() || this.f1450r.b(view) <= this.f1450r.k())) {
            uVar.d(view, o0.N(view));
        }
        w wVar = this.f1449q;
        wVar.f2439f = wVar.f2442j >= 0 ? 1 : -1;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        S0(b1Var, iArr);
        int k11 = this.f1450r.k() + Math.max(0, iArr[0]);
        int h10 = this.f1450r.h() + Math.max(0, iArr[1]);
        if (b1Var.g && (i15 = this.f1456x) != -1 && this.f1457y != Integer.MIN_VALUE && (s10 = s(i15)) != null) {
            if (this.f1453u) {
                i16 = this.f1450r.g() - this.f1450r.b(s10);
                e8 = this.f1457y;
            } else {
                e8 = this.f1450r.e(s10) - this.f1450r.k();
                i16 = this.f1457y;
            }
            int i20 = i16 - e8;
            if (i20 > 0) {
                k11 += i20;
            } else {
                h10 -= i20;
            }
        }
        if (!uVar.f2419c ? !this.f1453u : this.f1453u) {
            i18 = 1;
        }
        m1(u0Var, b1Var, uVar, i18);
        q(u0Var);
        this.f1449q.f2444l = this.f1450r.i() == 0 && this.f1450r.f() == 0;
        this.f1449q.getClass();
        this.f1449q.f2441i = 0;
        if (uVar.f2419c) {
            v1(uVar.f2418b, uVar.f2421e);
            w wVar2 = this.f1449q;
            wVar2.f2440h = k11;
            Z0(u0Var, wVar2, b1Var, false);
            w wVar3 = this.f1449q;
            i12 = wVar3.f2435b;
            int i21 = wVar3.f2437d;
            int i22 = wVar3.f2436c;
            if (i22 > 0) {
                h10 += i22;
            }
            u1(uVar.f2418b, uVar.f2421e);
            w wVar4 = this.f1449q;
            wVar4.f2440h = h10;
            wVar4.f2437d += wVar4.f2438e;
            Z0(u0Var, wVar4, b1Var, false);
            w wVar5 = this.f1449q;
            i11 = wVar5.f2435b;
            int i23 = wVar5.f2436c;
            if (i23 > 0) {
                v1(i21, i12);
                w wVar6 = this.f1449q;
                wVar6.f2440h = i23;
                Z0(u0Var, wVar6, b1Var, false);
                i12 = this.f1449q.f2435b;
            }
        } else {
            u1(uVar.f2418b, uVar.f2421e);
            w wVar7 = this.f1449q;
            wVar7.f2440h = h10;
            Z0(u0Var, wVar7, b1Var, false);
            w wVar8 = this.f1449q;
            i11 = wVar8.f2435b;
            int i24 = wVar8.f2437d;
            int i25 = wVar8.f2436c;
            if (i25 > 0) {
                k11 += i25;
            }
            v1(uVar.f2418b, uVar.f2421e);
            w wVar9 = this.f1449q;
            wVar9.f2440h = k11;
            wVar9.f2437d += wVar9.f2438e;
            Z0(u0Var, wVar9, b1Var, false);
            w wVar10 = this.f1449q;
            int i26 = wVar10.f2435b;
            int i27 = wVar10.f2436c;
            if (i27 > 0) {
                u1(i24, i11);
                w wVar11 = this.f1449q;
                wVar11.f2440h = i27;
                Z0(u0Var, wVar11, b1Var, false);
                i11 = this.f1449q.f2435b;
            }
            i12 = i26;
        }
        if (x() > 0) {
            if (this.f1453u ^ this.f1454v) {
                int g13 = g1(i11, u0Var, b1Var, true);
                i13 = i12 + g13;
                i14 = i11 + g13;
                g12 = h1(i13, u0Var, b1Var, false);
            } else {
                int h1 = h1(i12, u0Var, b1Var, true);
                i13 = i12 + h1;
                i14 = i11 + h1;
                g12 = g1(i14, u0Var, b1Var, false);
            }
            i12 = i13 + g12;
            i11 = i14 + g12;
        }
        if (b1Var.f2194k && x() != 0 && !b1Var.g && R0()) {
            List list2 = u0Var.f2426d;
            int size = list2.size();
            int N = o0.N(w(0));
            int i28 = 0;
            int i29 = 0;
            for (int i30 = 0; i30 < size; i30++) {
                f1 f1Var = (f1) list2.get(i30);
                boolean i31 = f1Var.i();
                View view3 = f1Var.f2232a;
                if (!i31) {
                    if ((f1Var.c() < N) != this.f1453u) {
                        i28 += this.f1450r.c(view3);
                    } else {
                        i29 += this.f1450r.c(view3);
                    }
                }
            }
            this.f1449q.f2443k = list2;
            if (i28 > 0) {
                v1(o0.N(j1()), i12);
                w wVar12 = this.f1449q;
                wVar12.f2440h = i28;
                wVar12.f2436c = 0;
                wVar12.a(null);
                Z0(u0Var, this.f1449q, b1Var, false);
            }
            if (i29 > 0) {
                u1(o0.N(i1()), i11);
                w wVar13 = this.f1449q;
                wVar13.f2440h = i29;
                wVar13.f2436c = 0;
                list = null;
                wVar13.a(null);
                Z0(u0Var, this.f1449q, b1Var, false);
            } else {
                list = null;
            }
            this.f1449q.f2443k = list;
        }
        if (b1Var.g) {
            uVar.g();
        } else {
            g gVar2 = this.f1450r;
            gVar2.f569a = gVar2.l();
        }
        this.f1451s = this.f1454v;
    }

    public final void n1(u0 u0Var, w wVar) {
        if (!wVar.f2434a || wVar.f2444l) {
            return;
        }
        int i10 = wVar.g;
        int i11 = wVar.f2441i;
        if (wVar.f2439f == -1) {
            int x6 = x();
            if (i10 < 0) {
                return;
            }
            int f10 = (this.f1450r.f() - i10) + i11;
            if (this.f1453u) {
                for (int i12 = 0; i12 < x6; i12++) {
                    View w10 = w(i12);
                    if (this.f1450r.e(w10) < f10 || this.f1450r.n(w10) < f10) {
                        o1(u0Var, 0, i12);
                        return;
                    }
                }
                return;
            }
            int i13 = x6 - 1;
            for (int i14 = i13; i14 >= 0; i14--) {
                View w11 = w(i14);
                if (this.f1450r.e(w11) < f10 || this.f1450r.n(w11) < f10) {
                    o1(u0Var, i13, i14);
                    return;
                }
            }
            return;
        }
        if (i10 < 0) {
            return;
        }
        int i15 = i10 - i11;
        int x10 = x();
        if (!this.f1453u) {
            for (int i16 = 0; i16 < x10; i16++) {
                View w12 = w(i16);
                if (this.f1450r.b(w12) > i15 || this.f1450r.m(w12) > i15) {
                    o1(u0Var, 0, i16);
                    return;
                }
            }
            return;
        }
        int i17 = x10 - 1;
        for (int i18 = i17; i18 >= 0; i18--) {
            View w13 = w(i18);
            if (this.f1450r.b(w13) > i15 || this.f1450r.m(w13) > i15) {
                o1(u0Var, i17, i18);
                return;
            }
        }
    }

    @Override // b4.o0
    public int o(b1 b1Var) {
        return V0(b1Var);
    }

    @Override // b4.o0
    public void o0(b1 b1Var) {
        this.f1458z = null;
        this.f1456x = -1;
        this.f1457y = Integer.MIN_VALUE;
        this.A.g();
    }

    public final void o1(u0 u0Var, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        if (i11 <= i10) {
            while (i10 > i11) {
                y0(i10, u0Var);
                i10--;
            }
        } else {
            for (int i12 = i11 - 1; i12 >= i10; i12--) {
                y0(i12, u0Var);
            }
        }
    }

    @Override // b4.o0
    public int p(b1 b1Var) {
        return W0(b1Var);
    }

    public final void p1() {
        if (this.f1448p == 1 || !k1()) {
            this.f1453u = this.f1452t;
        } else {
            this.f1453u = !this.f1452t;
        }
    }

    public final int q1(int i10, u0 u0Var, b1 b1Var) {
        if (x() != 0 && i10 != 0) {
            Y0();
            this.f1449q.f2434a = true;
            int i11 = i10 > 0 ? 1 : -1;
            int abs = Math.abs(i10);
            t1(i11, abs, true, b1Var);
            w wVar = this.f1449q;
            int Z0 = Z0(u0Var, wVar, b1Var, false) + wVar.g;
            if (Z0 >= 0) {
                if (abs > Z0) {
                    i10 = i11 * Z0;
                }
                this.f1450r.o(-i10);
                this.f1449q.f2442j = i10;
                return i10;
            }
        }
        return 0;
    }

    @Override // b4.o0
    public final void r0(Parcelable parcelable) {
        if (parcelable instanceof x) {
            x xVar = (x) parcelable;
            this.f1458z = xVar;
            if (this.f1456x != -1) {
                xVar.f2446o = -1;
            }
            C0();
        }
    }

    public final void r1(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException(d.m(i10, "invalid orientation:"));
        }
        c(null);
        if (i10 != this.f1448p || this.f1450r == null) {
            g a10 = g.a(this, i10);
            this.f1450r = a10;
            this.A.f2422f = a10;
            this.f1448p = i10;
            C0();
        }
    }

    @Override // b4.o0
    public final View s(int i10) {
        int x6 = x();
        if (x6 == 0) {
            return null;
        }
        int N = i10 - o0.N(w(0));
        if (N >= 0 && N < x6) {
            View w10 = w(N);
            if (o0.N(w10) == i10) {
                return w10;
            }
        }
        return super.s(i10);
    }

    @Override // b4.o0
    public final Parcelable s0() {
        x xVar = this.f1458z;
        if (xVar != null) {
            x xVar2 = new x();
            xVar2.f2446o = xVar.f2446o;
            xVar2.f2447p = xVar.f2447p;
            xVar2.f2448q = xVar.f2448q;
            return xVar2;
        }
        x xVar3 = new x();
        if (x() <= 0) {
            xVar3.f2446o = -1;
            return xVar3;
        }
        Y0();
        boolean z10 = this.f1451s ^ this.f1453u;
        xVar3.f2448q = z10;
        if (z10) {
            View i12 = i1();
            xVar3.f2447p = this.f1450r.g() - this.f1450r.b(i12);
            xVar3.f2446o = o0.N(i12);
            return xVar3;
        }
        View j12 = j1();
        xVar3.f2446o = o0.N(j12);
        xVar3.f2447p = this.f1450r.e(j12) - this.f1450r.k();
        return xVar3;
    }

    public void s1(boolean z10) {
        c(null);
        if (this.f1454v == z10) {
            return;
        }
        this.f1454v = z10;
        C0();
    }

    @Override // b4.o0
    public p0 t() {
        return new p0(-2, -2);
    }

    public final void t1(int i10, int i11, boolean z10, b1 b1Var) {
        int k10;
        this.f1449q.f2444l = this.f1450r.i() == 0 && this.f1450r.f() == 0;
        this.f1449q.f2439f = i10;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        S0(b1Var, iArr);
        int max = Math.max(0, iArr[0]);
        int max2 = Math.max(0, iArr[1]);
        boolean z11 = i10 == 1;
        w wVar = this.f1449q;
        int i12 = z11 ? max2 : max;
        wVar.f2440h = i12;
        if (!z11) {
            max = max2;
        }
        wVar.f2441i = max;
        if (z11) {
            wVar.f2440h = this.f1450r.h() + i12;
            View i13 = i1();
            w wVar2 = this.f1449q;
            wVar2.f2438e = this.f1453u ? -1 : 1;
            int N = o0.N(i13);
            w wVar3 = this.f1449q;
            wVar2.f2437d = N + wVar3.f2438e;
            wVar3.f2435b = this.f1450r.b(i13);
            k10 = this.f1450r.b(i13) - this.f1450r.g();
        } else {
            View j12 = j1();
            w wVar4 = this.f1449q;
            wVar4.f2440h = this.f1450r.k() + wVar4.f2440h;
            w wVar5 = this.f1449q;
            wVar5.f2438e = this.f1453u ? 1 : -1;
            int N2 = o0.N(j12);
            w wVar6 = this.f1449q;
            wVar5.f2437d = N2 + wVar6.f2438e;
            wVar6.f2435b = this.f1450r.e(j12);
            k10 = (-this.f1450r.e(j12)) + this.f1450r.k();
        }
        w wVar7 = this.f1449q;
        wVar7.f2436c = i11;
        if (z10) {
            wVar7.f2436c = i11 - k10;
        }
        wVar7.g = k10;
    }

    public final void u1(int i10, int i11) {
        this.f1449q.f2436c = this.f1450r.g() - i11;
        w wVar = this.f1449q;
        wVar.f2438e = this.f1453u ? -1 : 1;
        wVar.f2437d = i10;
        wVar.f2439f = 1;
        wVar.f2435b = i11;
        wVar.g = Integer.MIN_VALUE;
    }

    public final void v1(int i10, int i11) {
        this.f1449q.f2436c = i11 - this.f1450r.k();
        w wVar = this.f1449q;
        wVar.f2437d = i10;
        wVar.f2438e = this.f1453u ? 1 : -1;
        wVar.f2439f = -1;
        wVar.f2435b = i11;
        wVar.g = Integer.MIN_VALUE;
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f1448p = 1;
        this.f1452t = false;
        this.f1453u = false;
        this.f1454v = false;
        this.f1455w = true;
        this.f1456x = -1;
        this.f1457y = Integer.MIN_VALUE;
        this.f1458z = null;
        this.A = new u();
        this.B = new v();
        this.C = 2;
        this.D = new int[2];
        n0 O = o0.O(context, attributeSet, i10, i11);
        r1(O.f2346a);
        boolean z10 = O.f2348c;
        c(null);
        if (z10 != this.f1452t) {
            this.f1452t = z10;
            C0();
        }
        s1(O.f2349d);
    }

    @Override // b4.o0
    public final void a0(RecyclerView recyclerView) {
    }

    public void m1(u0 u0Var, b1 b1Var, u uVar, int i10) {
    }
}
