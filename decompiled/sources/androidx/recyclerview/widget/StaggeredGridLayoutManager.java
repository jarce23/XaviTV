package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.activity.j;
import androidx.emoji2.text.g;
import b4.a1;
import b4.b1;
import b4.f0;
import b4.j1;
import b4.k1;
import b4.m1;
import b4.n0;
import b4.n1;
import b4.o0;
import b4.p;
import b4.p0;
import b4.t;
import b4.u0;
import b4.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;
import k5.a;
import m0.k0;
import x4.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends o0 implements a1 {
    public final r B;
    public final int C;
    public boolean D;
    public boolean E;
    public m1 F;
    public final Rect G;
    public final j1 H;
    public final boolean I;
    public int[] J;
    public final j K;

    /* renamed from: p, reason: collision with root package name */
    public final int f1496p;

    /* renamed from: q, reason: collision with root package name */
    public final n1[] f1497q;

    /* renamed from: r, reason: collision with root package name */
    public final g f1498r;

    /* renamed from: s, reason: collision with root package name */
    public final g f1499s;

    /* renamed from: t, reason: collision with root package name */
    public final int f1500t;

    /* renamed from: u, reason: collision with root package name */
    public int f1501u;

    /* renamed from: v, reason: collision with root package name */
    public final t f1502v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1503w;

    /* renamed from: y, reason: collision with root package name */
    public final BitSet f1505y;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1504x = false;

    /* renamed from: z, reason: collision with root package name */
    public int f1506z = -1;
    public int A = Integer.MIN_VALUE;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f1496p = -1;
        this.f1503w = false;
        r rVar = new r(3);
        this.B = rVar;
        this.C = 2;
        this.G = new Rect();
        this.H = new j1(this);
        this.I = true;
        this.K = new j(10, this);
        n0 O = o0.O(context, attributeSet, i10, i11);
        int i12 = O.f2346a;
        if (i12 != 0 && i12 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        c(null);
        if (i12 != this.f1500t) {
            this.f1500t = i12;
            g gVar = this.f1498r;
            this.f1498r = this.f1499s;
            this.f1499s = gVar;
            C0();
        }
        int i13 = O.f2347b;
        c(null);
        if (i13 != this.f1496p) {
            rVar.g();
            C0();
            this.f1496p = i13;
            this.f1505y = new BitSet(this.f1496p);
            this.f1497q = new n1[this.f1496p];
            for (int i14 = 0; i14 < this.f1496p; i14++) {
                this.f1497q[i14] = new n1(this, i14);
            }
            C0();
        }
        boolean z10 = O.f2348c;
        c(null);
        m1 m1Var = this.F;
        if (m1Var != null && m1Var.f2318v != z10) {
            m1Var.f2318v = z10;
        }
        this.f1503w = z10;
        C0();
        t tVar = new t();
        tVar.f2406a = true;
        tVar.f2411f = 0;
        tVar.g = 0;
        this.f1502v = tVar;
        this.f1498r = g.a(this, this.f1500t);
        this.f1499s = g.a(this, 1 - this.f1500t);
    }

    public static int s1(int i10, int i11, int i12) {
        int mode;
        return (!(i11 == 0 && i12 == 0) && ((mode = View.MeasureSpec.getMode(i10)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode) : i10;
    }

    @Override // b4.o0
    public final int E0(int i10, u0 u0Var, b1 b1Var) {
        return o1(i10, u0Var, b1Var);
    }

    @Override // b4.o0
    public final void F0(int i10) {
        m1 m1Var = this.F;
        if (m1Var != null && m1Var.f2311o != i10) {
            m1Var.f2314r = null;
            m1Var.f2313q = 0;
            m1Var.f2311o = -1;
            m1Var.f2312p = -1;
        }
        this.f1506z = i10;
        this.A = Integer.MIN_VALUE;
        C0();
    }

    @Override // b4.o0
    public final int G0(int i10, u0 u0Var, b1 b1Var) {
        return o1(i10, u0Var, b1Var);
    }

    @Override // b4.o0
    public final void J0(Rect rect, int i10, int i11) {
        int h10;
        int h11;
        int L = L() + K();
        int J = J() + M();
        int i12 = this.f1500t;
        int i13 = this.f1496p;
        if (i12 == 1) {
            int height = rect.height() + J;
            RecyclerView recyclerView = this.f2358b;
            WeakHashMap weakHashMap = k0.f8683a;
            h11 = o0.h(i11, height, recyclerView.getMinimumHeight());
            h10 = o0.h(i10, (this.f1501u * i13) + L, this.f2358b.getMinimumWidth());
        } else {
            int width = rect.width() + L;
            RecyclerView recyclerView2 = this.f2358b;
            WeakHashMap weakHashMap2 = k0.f8683a;
            h10 = o0.h(i10, width, recyclerView2.getMinimumWidth());
            h11 = o0.h(i11, (this.f1501u * i13) + J, this.f2358b.getMinimumHeight());
        }
        this.f2358b.setMeasuredDimension(h10, h11);
    }

    @Override // b4.o0
    public final void P0(RecyclerView recyclerView, int i10) {
        y yVar = new y(recyclerView.getContext());
        yVar.f2450a = i10;
        Q0(yVar);
    }

    @Override // b4.o0
    public final boolean R0() {
        return this.F == null;
    }

    @Override // b4.o0
    public final boolean S() {
        return this.C != 0;
    }

    public final boolean S0() {
        int Z0;
        if (x() != 0 && this.C != 0 && this.g) {
            if (this.f1504x) {
                Z0 = a1();
                Z0();
            } else {
                Z0 = Z0();
                a1();
            }
            if (Z0 == 0 && e1() != null) {
                this.B.g();
                this.f2362f = true;
                C0();
                return true;
            }
        }
        return false;
    }

    public final int T0(b1 b1Var) {
        if (x() == 0) {
            return 0;
        }
        boolean z10 = !this.I;
        return a.g(b1Var, this.f1498r, W0(z10), V0(z10), this, this.I, this.f1504x);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0267, code lost:
    
        k1(r20, r3);
     */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int U0(b4.u0 r20, b4.t r21, b4.b1 r22) {
        /*
            Method dump skipped, instructions count: 671
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.U0(b4.u0, b4.t, b4.b1):int");
    }

    @Override // b4.o0
    public final void V(int i10) {
        super.V(i10);
        for (int i11 = 0; i11 < this.f1496p; i11++) {
            n1 n1Var = this.f1497q[i11];
            int i12 = n1Var.f2351b;
            if (i12 != Integer.MIN_VALUE) {
                n1Var.f2351b = i12 + i10;
            }
            int i13 = n1Var.f2352c;
            if (i13 != Integer.MIN_VALUE) {
                n1Var.f2352c = i13 + i10;
            }
        }
    }

    public final View V0(boolean z10) {
        int k10 = this.f1498r.k();
        int g = this.f1498r.g();
        View view = null;
        for (int x6 = x() - 1; x6 >= 0; x6--) {
            View w10 = w(x6);
            int e7 = this.f1498r.e(w10);
            int b2 = this.f1498r.b(w10);
            if (b2 > k10 && e7 < g) {
                if (b2 <= g || !z10) {
                    return w10;
                }
                if (view == null) {
                    view = w10;
                }
            }
        }
        return view;
    }

    @Override // b4.o0
    public final void W(int i10) {
        super.W(i10);
        for (int i11 = 0; i11 < this.f1496p; i11++) {
            n1 n1Var = this.f1497q[i11];
            int i12 = n1Var.f2351b;
            if (i12 != Integer.MIN_VALUE) {
                n1Var.f2351b = i12 + i10;
            }
            int i13 = n1Var.f2352c;
            if (i13 != Integer.MIN_VALUE) {
                n1Var.f2352c = i13 + i10;
            }
        }
    }

    public final View W0(boolean z10) {
        int k10 = this.f1498r.k();
        int g = this.f1498r.g();
        int x6 = x();
        View view = null;
        for (int i10 = 0; i10 < x6; i10++) {
            View w10 = w(i10);
            int e7 = this.f1498r.e(w10);
            if (this.f1498r.b(w10) > k10 && e7 < g) {
                if (e7 >= k10 || !z10) {
                    return w10;
                }
                if (view == null) {
                    view = w10;
                }
            }
        }
        return view;
    }

    @Override // b4.o0
    public final void X(f0 f0Var) {
        this.B.g();
        for (int i10 = 0; i10 < this.f1496p; i10++) {
            this.f1497q[i10].b();
        }
    }

    public final void X0(u0 u0Var, b1 b1Var, boolean z10) {
        int g;
        int b12 = b1(Integer.MIN_VALUE);
        if (b12 != Integer.MIN_VALUE && (g = this.f1498r.g() - b12) > 0) {
            int i10 = g - (-o1(-g, u0Var, b1Var));
            if (!z10 || i10 <= 0) {
                return;
            }
            this.f1498r.o(i10);
        }
    }

    public final void Y0(u0 u0Var, b1 b1Var, boolean z10) {
        int k10;
        int c12 = c1(Integer.MAX_VALUE);
        if (c12 != Integer.MAX_VALUE && (k10 = c12 - this.f1498r.k()) > 0) {
            int o12 = k10 - o1(k10, u0Var, b1Var);
            if (!z10 || o12 <= 0) {
                return;
            }
            this.f1498r.o(-o12);
        }
    }

    public final int Z0() {
        if (x() == 0) {
            return 0;
        }
        return o0.N(w(0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0019, code lost:
    
        if ((r4 < Z0()) != r3.f1504x) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r3.f1504x != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r1 = 1;
     */
    @Override // b4.a1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.PointF a(int r4) {
        /*
            r3 = this;
            int r0 = r3.x()
            r1 = -1
            r2 = 1
            if (r0 != 0) goto Le
            boolean r4 = r3.f1504x
            if (r4 == 0) goto L1b
        Lc:
            r1 = r2
            goto L1b
        Le:
            int r0 = r3.Z0()
            if (r4 >= r0) goto L16
            r4 = r2
            goto L17
        L16:
            r4 = 0
        L17:
            boolean r0 = r3.f1504x
            if (r4 == r0) goto Lc
        L1b:
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>()
            if (r1 != 0) goto L24
            r4 = 0
            return r4
        L24:
            int r0 = r3.f1500t
            r2 = 0
            if (r0 != 0) goto L2f
            float r0 = (float) r1
            r4.x = r0
            r4.y = r2
            return r4
        L2f:
            r4.x = r2
            float r0 = (float) r1
            r4.y = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(int):android.graphics.PointF");
    }

    @Override // b4.o0
    public final void a0(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2358b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.K);
        }
        for (int i10 = 0; i10 < this.f1496p; i10++) {
            this.f1497q[i10].b();
        }
        recyclerView.requestLayout();
    }

    public final int a1() {
        int x6 = x();
        if (x6 == 0) {
            return 0;
        }
        return o0.N(w(x6 - 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x003b, code lost:
    
        if (r7.f1500t == 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0041, code lost:
    
        if (r7.f1500t == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x004d, code lost:
    
        if (f1() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0059, code lost:
    
        if (f1() == false) goto L29;
     */
    @Override // b4.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View b0(android.view.View r8, int r9, b4.u0 r10, b4.b1 r11) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b0(android.view.View, int, b4.u0, b4.b1):android.view.View");
    }

    public final int b1(int i10) {
        int g = this.f1497q[0].g(i10);
        for (int i11 = 1; i11 < this.f1496p; i11++) {
            int g6 = this.f1497q[i11].g(i10);
            if (g6 > g) {
                g = g6;
            }
        }
        return g;
    }

    @Override // b4.o0
    public final void c(String str) {
        if (this.F == null) {
            super.c(str);
        }
    }

    @Override // b4.o0
    public final void c0(AccessibilityEvent accessibilityEvent) {
        super.c0(accessibilityEvent);
        if (x() > 0) {
            View W0 = W0(false);
            View V0 = V0(false);
            if (W0 == null || V0 == null) {
                return;
            }
            int N = o0.N(W0);
            int N2 = o0.N(V0);
            if (N < N2) {
                accessibilityEvent.setFromIndex(N);
                accessibilityEvent.setToIndex(N2);
            } else {
                accessibilityEvent.setFromIndex(N2);
                accessibilityEvent.setToIndex(N);
            }
        }
    }

    public final int c1(int i10) {
        int i11 = this.f1497q[0].i(i10);
        for (int i12 = 1; i12 < this.f1496p; i12++) {
            int i13 = this.f1497q[i12].i(i10);
            if (i13 < i11) {
                i11 = i13;
            }
        }
        return i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d1(int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.d1(int, int, int):void");
    }

    @Override // b4.o0
    public final boolean e() {
        return this.f1500t == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x002c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View e1() {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.e1():android.view.View");
    }

    @Override // b4.o0
    public final boolean f() {
        return this.f1500t == 1;
    }

    public final boolean f1() {
        return I() == 1;
    }

    @Override // b4.o0
    public final boolean g(p0 p0Var) {
        return p0Var instanceof k1;
    }

    public final void g1(View view, int i10, int i11) {
        Rect rect = this.G;
        d(view, rect);
        k1 k1Var = (k1) view.getLayoutParams();
        int s12 = s1(i10, ((ViewGroup.MarginLayoutParams) k1Var).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) k1Var).rightMargin + rect.right);
        int s13 = s1(i11, ((ViewGroup.MarginLayoutParams) k1Var).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) k1Var).bottomMargin + rect.bottom);
        if (M0(view, s12, s13, k1Var)) {
            view.measure(s12, s13);
        }
    }

    @Override // b4.o0
    public final void h0(int i10, int i11) {
        d1(i10, i11, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01aa, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01a6, code lost:
    
        if ((r11 < Z0()) != r16.f1504x) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0416, code lost:
    
        if (S0() != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0198, code lost:
    
        if (r16.f1504x != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a8, code lost:
    
        r11 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h1(b4.u0 r17, b4.b1 r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1076
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.h1(b4.u0, b4.b1, boolean):void");
    }

    @Override // b4.o0
    public final void i(int i10, int i11, b1 b1Var, p pVar) {
        t tVar;
        int g;
        int i12;
        if (this.f1500t != 0) {
            i10 = i11;
        }
        if (x() == 0 || i10 == 0) {
            return;
        }
        j1(i10, b1Var);
        int[] iArr = this.J;
        if (iArr == null || iArr.length < this.f1496p) {
            this.J = new int[this.f1496p];
        }
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = this.f1496p;
            tVar = this.f1502v;
            if (i13 >= i15) {
                break;
            }
            if (tVar.f2409d == -1) {
                g = tVar.f2411f;
                i12 = this.f1497q[i13].i(g);
            } else {
                g = this.f1497q[i13].g(tVar.g);
                i12 = tVar.g;
            }
            int i16 = g - i12;
            if (i16 >= 0) {
                this.J[i14] = i16;
                i14++;
            }
            i13++;
        }
        Arrays.sort(this.J, 0, i14);
        for (int i17 = 0; i17 < i14; i17++) {
            int i18 = tVar.f2408c;
            if (i18 < 0 || i18 >= b1Var.b()) {
                return;
            }
            pVar.b(tVar.f2408c, this.J[i17]);
            tVar.f2408c += tVar.f2409d;
        }
    }

    @Override // b4.o0
    public final void i0() {
        this.B.g();
        C0();
    }

    public final boolean i1(int i10) {
        if (this.f1500t == 0) {
            return (i10 == -1) != this.f1504x;
        }
        return ((i10 == -1) == this.f1504x) == f1();
    }

    @Override // b4.o0
    public final void j0(int i10, int i11) {
        d1(i10, i11, 8);
    }

    public final void j1(int i10, b1 b1Var) {
        int Z0;
        int i11;
        if (i10 > 0) {
            Z0 = a1();
            i11 = 1;
        } else {
            Z0 = Z0();
            i11 = -1;
        }
        t tVar = this.f1502v;
        tVar.f2406a = true;
        q1(Z0, b1Var);
        p1(i11);
        tVar.f2408c = Z0 + tVar.f2409d;
        tVar.f2407b = Math.abs(i10);
    }

    @Override // b4.o0
    public final int k(b1 b1Var) {
        if (x() == 0) {
            return 0;
        }
        boolean z10 = !this.I;
        return a.f(b1Var, this.f1498r, W0(z10), V0(z10), this, this.I);
    }

    @Override // b4.o0
    public final void k0(int i10, int i11) {
        d1(i10, i11, 2);
    }

    public final void k1(u0 u0Var, t tVar) {
        if (!tVar.f2406a || tVar.f2413i) {
            return;
        }
        if (tVar.f2407b == 0) {
            if (tVar.f2410e == -1) {
                l1(tVar.g, u0Var);
                return;
            } else {
                m1(tVar.f2411f, u0Var);
                return;
            }
        }
        int i10 = 1;
        if (tVar.f2410e == -1) {
            int i11 = tVar.f2411f;
            int i12 = this.f1497q[0].i(i11);
            while (i10 < this.f1496p) {
                int i13 = this.f1497q[i10].i(i11);
                if (i13 > i12) {
                    i12 = i13;
                }
                i10++;
            }
            int i14 = i11 - i12;
            l1(i14 < 0 ? tVar.g : tVar.g - Math.min(i14, tVar.f2407b), u0Var);
            return;
        }
        int i15 = tVar.g;
        int g = this.f1497q[0].g(i15);
        while (i10 < this.f1496p) {
            int g6 = this.f1497q[i10].g(i15);
            if (g6 < g) {
                g = g6;
            }
            i10++;
        }
        int i16 = g - tVar.g;
        m1(i16 < 0 ? tVar.f2411f : Math.min(i16, tVar.f2407b) + tVar.f2411f, u0Var);
    }

    @Override // b4.o0
    public final int l(b1 b1Var) {
        return T0(b1Var);
    }

    public final void l1(int i10, u0 u0Var) {
        for (int x6 = x() - 1; x6 >= 0; x6--) {
            View w10 = w(x6);
            if (this.f1498r.e(w10) < i10 || this.f1498r.n(w10) < i10) {
                return;
            }
            k1 k1Var = (k1) w10.getLayoutParams();
            k1Var.getClass();
            if (((ArrayList) k1Var.f2300e.f2355f).size() == 1) {
                return;
            }
            n1 n1Var = k1Var.f2300e;
            ArrayList arrayList = (ArrayList) n1Var.f2355f;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            k1 k1Var2 = (k1) view.getLayoutParams();
            k1Var2.f2300e = null;
            if (k1Var2.f2381a.i() || k1Var2.f2381a.l()) {
                n1Var.f2353d -= ((StaggeredGridLayoutManager) n1Var.g).f1498r.c(view);
            }
            if (size == 1) {
                n1Var.f2351b = Integer.MIN_VALUE;
            }
            n1Var.f2352c = Integer.MIN_VALUE;
            x0(w10, u0Var);
        }
    }

    @Override // b4.o0
    public final int m(b1 b1Var) {
        if (x() == 0) {
            return 0;
        }
        boolean z10 = !this.I;
        return a.h(b1Var, this.f1498r, W0(z10), V0(z10), this, this.I);
    }

    @Override // b4.o0
    public final void m0(RecyclerView recyclerView, int i10, int i11) {
        d1(i10, i11, 4);
    }

    public final void m1(int i10, u0 u0Var) {
        while (x() > 0) {
            View w10 = w(0);
            if (this.f1498r.b(w10) > i10 || this.f1498r.m(w10) > i10) {
                return;
            }
            k1 k1Var = (k1) w10.getLayoutParams();
            k1Var.getClass();
            if (((ArrayList) k1Var.f2300e.f2355f).size() == 1) {
                return;
            }
            n1 n1Var = k1Var.f2300e;
            ArrayList arrayList = (ArrayList) n1Var.f2355f;
            View view = (View) arrayList.remove(0);
            k1 k1Var2 = (k1) view.getLayoutParams();
            k1Var2.f2300e = null;
            if (arrayList.size() == 0) {
                n1Var.f2352c = Integer.MIN_VALUE;
            }
            if (k1Var2.f2381a.i() || k1Var2.f2381a.l()) {
                n1Var.f2353d -= ((StaggeredGridLayoutManager) n1Var.g).f1498r.c(view);
            }
            n1Var.f2351b = Integer.MIN_VALUE;
            x0(w10, u0Var);
        }
    }

    @Override // b4.o0
    public final int n(b1 b1Var) {
        if (x() == 0) {
            return 0;
        }
        boolean z10 = !this.I;
        return a.f(b1Var, this.f1498r, W0(z10), V0(z10), this, this.I);
    }

    @Override // b4.o0
    public final void n0(u0 u0Var, b1 b1Var) {
        h1(u0Var, b1Var, true);
    }

    public final void n1() {
        if (this.f1500t == 1 || !f1()) {
            this.f1504x = this.f1503w;
        } else {
            this.f1504x = !this.f1503w;
        }
    }

    @Override // b4.o0
    public final int o(b1 b1Var) {
        return T0(b1Var);
    }

    @Override // b4.o0
    public final void o0(b1 b1Var) {
        this.f1506z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.H.a();
    }

    public final int o1(int i10, u0 u0Var, b1 b1Var) {
        if (x() == 0 || i10 == 0) {
            return 0;
        }
        j1(i10, b1Var);
        t tVar = this.f1502v;
        int U0 = U0(u0Var, tVar, b1Var);
        if (tVar.f2407b >= U0) {
            i10 = i10 < 0 ? -U0 : U0;
        }
        this.f1498r.o(-i10);
        this.D = this.f1504x;
        tVar.f2407b = 0;
        k1(u0Var, tVar);
        return i10;
    }

    @Override // b4.o0
    public final int p(b1 b1Var) {
        if (x() == 0) {
            return 0;
        }
        boolean z10 = !this.I;
        return a.h(b1Var, this.f1498r, W0(z10), V0(z10), this, this.I);
    }

    public final void p1(int i10) {
        t tVar = this.f1502v;
        tVar.f2410e = i10;
        tVar.f2409d = this.f1504x != (i10 == -1) ? -1 : 1;
    }

    public final void q1(int i10, b1 b1Var) {
        int i11;
        int i12;
        int i13;
        t tVar = this.f1502v;
        boolean z10 = false;
        tVar.f2407b = 0;
        tVar.f2408c = i10;
        y yVar = this.f2361e;
        if (yVar == null || !yVar.f2454e || (i13 = b1Var.f2185a) == -1) {
            i11 = 0;
            i12 = 0;
        } else {
            if (this.f1504x == (i13 < i10)) {
                i11 = this.f1498r.l();
                i12 = 0;
            } else {
                i12 = this.f1498r.l();
                i11 = 0;
            }
        }
        RecyclerView recyclerView = this.f2358b;
        if (recyclerView == null || !recyclerView.f1486v) {
            tVar.g = this.f1498r.f() + i11;
            tVar.f2411f = -i12;
        } else {
            tVar.f2411f = this.f1498r.k() - i12;
            tVar.g = this.f1498r.g() + i11;
        }
        tVar.f2412h = false;
        tVar.f2406a = true;
        if (this.f1498r.i() == 0 && this.f1498r.f() == 0) {
            z10 = true;
        }
        tVar.f2413i = z10;
    }

    @Override // b4.o0
    public final void r0(Parcelable parcelable) {
        if (parcelable instanceof m1) {
            m1 m1Var = (m1) parcelable;
            this.F = m1Var;
            if (this.f1506z != -1) {
                m1Var.f2311o = -1;
                m1Var.f2312p = -1;
                m1Var.f2314r = null;
                m1Var.f2313q = 0;
                m1Var.f2315s = 0;
                m1Var.f2316t = null;
                m1Var.f2317u = null;
            }
            C0();
        }
    }

    public final void r1(n1 n1Var, int i10, int i11) {
        int i12 = n1Var.f2353d;
        int i13 = n1Var.f2354e;
        if (i10 != -1) {
            int i14 = n1Var.f2352c;
            if (i14 == Integer.MIN_VALUE) {
                n1Var.a();
                i14 = n1Var.f2352c;
            }
            if (i14 - i12 >= i11) {
                this.f1505y.set(i13, false);
                return;
            }
            return;
        }
        int i15 = n1Var.f2351b;
        if (i15 == Integer.MIN_VALUE) {
            View view = (View) ((ArrayList) n1Var.f2355f).get(0);
            k1 k1Var = (k1) view.getLayoutParams();
            n1Var.f2351b = ((StaggeredGridLayoutManager) n1Var.g).f1498r.e(view);
            k1Var.getClass();
            i15 = n1Var.f2351b;
        }
        if (i15 + i12 <= i11) {
            this.f1505y.set(i13, false);
        }
    }

    @Override // b4.o0
    public final Parcelable s0() {
        int i10;
        int k10;
        int[] iArr;
        m1 m1Var = this.F;
        if (m1Var != null) {
            m1 m1Var2 = new m1();
            m1Var2.f2313q = m1Var.f2313q;
            m1Var2.f2311o = m1Var.f2311o;
            m1Var2.f2312p = m1Var.f2312p;
            m1Var2.f2314r = m1Var.f2314r;
            m1Var2.f2315s = m1Var.f2315s;
            m1Var2.f2316t = m1Var.f2316t;
            m1Var2.f2318v = m1Var.f2318v;
            m1Var2.f2319w = m1Var.f2319w;
            m1Var2.f2320x = m1Var.f2320x;
            m1Var2.f2317u = m1Var.f2317u;
            return m1Var2;
        }
        m1 m1Var3 = new m1();
        m1Var3.f2318v = this.f1503w;
        m1Var3.f2319w = this.D;
        m1Var3.f2320x = this.E;
        r rVar = this.B;
        if (rVar == null || (iArr = (int[]) rVar.f13607p) == null) {
            m1Var3.f2315s = 0;
        } else {
            m1Var3.f2316t = iArr;
            m1Var3.f2315s = iArr.length;
            m1Var3.f2317u = (ArrayList) rVar.f13608q;
        }
        if (x() <= 0) {
            m1Var3.f2311o = -1;
            m1Var3.f2312p = -1;
            m1Var3.f2313q = 0;
            return m1Var3;
        }
        m1Var3.f2311o = this.D ? a1() : Z0();
        View V0 = this.f1504x ? V0(true) : W0(true);
        m1Var3.f2312p = V0 != null ? o0.N(V0) : -1;
        int i11 = this.f1496p;
        m1Var3.f2313q = i11;
        m1Var3.f2314r = new int[i11];
        for (int i12 = 0; i12 < this.f1496p; i12++) {
            if (this.D) {
                i10 = this.f1497q[i12].g(Integer.MIN_VALUE);
                if (i10 != Integer.MIN_VALUE) {
                    k10 = this.f1498r.g();
                    i10 -= k10;
                    m1Var3.f2314r[i12] = i10;
                } else {
                    m1Var3.f2314r[i12] = i10;
                }
            } else {
                i10 = this.f1497q[i12].i(Integer.MIN_VALUE);
                if (i10 != Integer.MIN_VALUE) {
                    k10 = this.f1498r.k();
                    i10 -= k10;
                    m1Var3.f2314r[i12] = i10;
                } else {
                    m1Var3.f2314r[i12] = i10;
                }
            }
        }
        return m1Var3;
    }

    @Override // b4.o0
    public final p0 t() {
        return this.f1500t == 0 ? new k1(-2, -1) : new k1(-1, -2);
    }

    @Override // b4.o0
    public final void t0(int i10) {
        if (i10 == 0) {
            S0();
        }
    }

    @Override // b4.o0
    public final p0 u(Context context, AttributeSet attributeSet) {
        return new k1(context, attributeSet);
    }

    @Override // b4.o0
    public final p0 v(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new k1((ViewGroup.MarginLayoutParams) layoutParams) : new k1(layoutParams);
    }
}
