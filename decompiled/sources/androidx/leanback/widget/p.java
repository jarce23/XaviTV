package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import b4.b1;
import b4.f1;
import b4.n1;
import j9.w1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p extends b4.o0 {

    /* renamed from: c0, reason: collision with root package name */
    public static final Rect f1050c0 = new Rect();

    /* renamed from: d0, reason: collision with root package name */
    public static final int[] f1051d0 = new int[2];
    public l C;
    public n D;
    public int F;
    public int G;
    public int H;
    public int I;
    public int[] J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int Q;
    public j S;
    public int W;
    public int X;
    public final w0 Z;

    /* renamed from: a0, reason: collision with root package name */
    public final androidx.activity.j f1052a0;

    /* renamed from: b0, reason: collision with root package name */
    public final a6.n f1053b0;

    /* renamed from: q, reason: collision with root package name */
    public final f f1055q;

    /* renamed from: t, reason: collision with root package name */
    public b1 f1058t;

    /* renamed from: u, reason: collision with root package name */
    public int f1059u;

    /* renamed from: v, reason: collision with root package name */
    public int f1060v;

    /* renamed from: x, reason: collision with root package name */
    public int[] f1062x;

    /* renamed from: y, reason: collision with root package name */
    public b4.u0 f1063y;

    /* renamed from: p, reason: collision with root package name */
    public final int f1054p = 10;

    /* renamed from: r, reason: collision with root package name */
    public int f1056r = 0;

    /* renamed from: s, reason: collision with root package name */
    public androidx.emoji2.text.g f1057s = new b4.z(this, 0);

    /* renamed from: w, reason: collision with root package name */
    public final SparseIntArray f1061w = new SparseIntArray();

    /* renamed from: z, reason: collision with root package name */
    public int f1064z = 221696;
    public ArrayList A = null;
    public int B = -1;
    public int E = 0;
    public int P = 8388659;
    public int R = 1;
    public int T = 0;
    public final x4.i U = new x4.i(4);
    public final android.support.v4.media.session.a0 V = new android.support.v4.media.session.a0(3);
    public final int[] Y = new int[2];

    public p(f fVar) {
        w0 w0Var = new w0();
        w0Var.f1087o = 0;
        w0Var.f1088p = 100;
        this.Z = w0Var;
        int i10 = 4;
        this.f1052a0 = new androidx.activity.j(i10, this);
        this.f1053b0 = new a6.n(i10, this);
        this.f1055q = fVar;
        this.F = -1;
        if (this.f2364i) {
            this.f2364i = false;
            this.f2365j = 0;
            RecyclerView recyclerView = this.f2358b;
            if (recyclerView != null) {
                recyclerView.f1476q.n();
            }
        }
    }

    public static int V0(View view) {
        m mVar;
        if (view == null || (mVar = (m) view.getLayoutParams()) == null || mVar.f2381a.i()) {
            return -1;
        }
        return mVar.f2381a.b();
    }

    public static int W0(View view) {
        m mVar = (m) view.getLayoutParams();
        return b4.o0.D(view) + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
    }

    public static int X0(View view) {
        m mVar = (m) view.getLayoutParams();
        return b4.o0.E(view) + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
    }

    @Override // b4.o0
    public final int A(View view) {
        return super.A(view) - ((m) view.getLayoutParams()).f1038h;
    }

    @Override // b4.o0
    public final boolean A0(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
        return false;
    }

    public final void A1() {
        int i10 = (this.f1064z & (-1025)) | (k1(false) ? 1024 : 0);
        this.f1064z = i10;
        if ((i10 & 1024) != 0) {
            WeakHashMap weakHashMap = m0.k0.f8683a;
            this.f1055q.postOnAnimation(this.f1052a0);
        }
    }

    @Override // b4.o0
    public final void B(View view, Rect rect) {
        super.B(view, rect);
        m mVar = (m) view.getLayoutParams();
        rect.left += mVar.f1036e;
        rect.top += mVar.f1037f;
        rect.right -= mVar.g;
        rect.bottom -= mVar.f1038h;
    }

    public final void B1() {
        int b2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int top;
        int i15;
        int top2;
        int i16;
        if (this.f1058t.b() == 0) {
            return;
        }
        if ((this.f1064z & 262144) == 0) {
            i10 = this.S.g;
            int b10 = this.f1058t.b() - 1;
            i11 = this.S.f1028f;
            i12 = b10;
            b2 = 0;
        } else {
            j jVar = this.S;
            int i17 = jVar.f1028f;
            int i18 = jVar.g;
            b2 = this.f1058t.b() - 1;
            i10 = i17;
            i11 = i18;
            i12 = 0;
        }
        if (i10 < 0 || i11 < 0) {
            return;
        }
        boolean z10 = i10 == i12;
        boolean z11 = i11 == b2;
        int i19 = Integer.MIN_VALUE;
        int i20 = Integer.MAX_VALUE;
        x4.i iVar = this.U;
        if (!z10) {
            x0 x0Var = (x0) iVar.f13555r;
            if (x0Var.f1090a == Integer.MAX_VALUE && !z11 && x0Var.f1091b == Integer.MIN_VALUE) {
                return;
            }
        }
        int[] iArr = f1051d0;
        if (z10) {
            i20 = this.S.g(true, iArr);
            View s10 = s(iArr[1]);
            if (this.f1056r == 0) {
                m mVar = (m) s10.getLayoutParams();
                mVar.getClass();
                top2 = s10.getLeft() + mVar.f1036e;
                i16 = mVar.f1039i;
            } else {
                m mVar2 = (m) s10.getLayoutParams();
                mVar2.getClass();
                top2 = s10.getTop() + mVar2.f1037f;
                i16 = mVar2.f1040j;
            }
            i13 = top2 + i16;
            ((m) s10.getLayoutParams()).getClass();
        } else {
            i13 = Integer.MAX_VALUE;
        }
        if (z11) {
            i19 = this.S.i(false, iArr);
            View s11 = s(iArr[1]);
            if (this.f1056r == 0) {
                m mVar3 = (m) s11.getLayoutParams();
                mVar3.getClass();
                top = s11.getLeft() + mVar3.f1036e;
                i15 = mVar3.f1039i;
            } else {
                m mVar4 = (m) s11.getLayoutParams();
                mVar4.getClass();
                top = s11.getTop() + mVar4.f1037f;
                i15 = mVar4.f1040j;
            }
            i14 = top + i15;
        } else {
            i14 = Integer.MIN_VALUE;
        }
        ((x0) iVar.f13555r).c(i19, i20, i14, i13);
    }

    @Override // b4.o0
    public final int C(View view) {
        return super.C(view) + ((m) view.getLayoutParams()).f1036e;
    }

    public final void C1() {
        x0 x0Var = (x0) this.U.f13556s;
        int i10 = x0Var.f1098j - this.G;
        int c12 = c1() + i10;
        x0Var.c(i10, c12, i10, c12);
    }

    @Override // b4.o0
    public final int E0(int i10, b4.u0 u0Var, b1 b1Var) {
        if ((this.f1064z & 512) == 0 || this.S == null) {
            return 0;
        }
        o1(u0Var, b1Var);
        this.f1064z = (this.f1064z & (-4)) | 2;
        int p12 = this.f1056r == 0 ? p1(i10) : q1(i10);
        g1();
        this.f1064z &= -4;
        return p12;
    }

    @Override // b4.o0
    public final int F(View view) {
        return super.F(view) - ((m) view.getLayoutParams()).g;
    }

    @Override // b4.o0
    public final void F0(int i10) {
        w1(i10, false);
    }

    @Override // b4.o0
    public final int G(View view) {
        return super.G(view) + ((m) view.getLayoutParams()).f1037f;
    }

    @Override // b4.o0
    public final int G0(int i10, b4.u0 u0Var, b1 b1Var) {
        int i11 = this.f1064z;
        if ((i11 & 512) == 0 || this.S == null) {
            return 0;
        }
        this.f1064z = (i11 & (-4)) | 2;
        o1(u0Var, b1Var);
        int p12 = this.f1056r == 1 ? p1(i10) : q1(i10);
        g1();
        this.f1064z &= -4;
        return p12;
    }

    @Override // b4.o0
    public final int P(b4.u0 u0Var, b1 b1Var) {
        j jVar;
        if (this.f1056r != 0 || (jVar = this.S) == null) {
            return -1;
        }
        return jVar.f1027e;
    }

    @Override // b4.o0
    public final void P0(RecyclerView recyclerView, int i10) {
        w1(i10, true);
    }

    @Override // b4.o0
    public final void Q0(b4.y yVar) {
        l lVar = this.C;
        if (lVar != null) {
            lVar.f1032q = true;
        }
        super.Q0(yVar);
        if (!yVar.f2454e || !(yVar instanceof l)) {
            this.C = null;
            this.D = null;
            return;
        }
        l lVar2 = (l) yVar;
        this.C = lVar2;
        if (lVar2 instanceof n) {
            this.D = (n) lVar2;
        } else {
            this.D = null;
        }
    }

    public final void S0() {
        this.S.b((this.f1064z & 262144) != 0 ? (-this.X) - this.f1060v : this.W + this.X + this.f1060v, false);
    }

    public final void T0() {
        ArrayList arrayList = this.A;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int i10 = this.B;
        View s10 = i10 == -1 ? null : s(i10);
        f fVar = this.f1055q;
        if (s10 != null) {
            f1 I = fVar.I(s10);
            int i11 = this.B;
            ArrayList arrayList2 = this.A;
            if (arrayList2 != null) {
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    ((y) this.A.get(size)).a(fVar, I, i11);
                }
            }
        } else {
            ArrayList arrayList3 = this.A;
            if (arrayList3 != null) {
                for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                    ((y) this.A.get(size2)).a(fVar, null, -1);
                }
            }
        }
        if ((this.f1064z & 3) == 1 || fVar.isLayoutRequested()) {
            return;
        }
        int x6 = x();
        for (int i12 = 0; i12 < x6; i12++) {
            if (w(i12).isLayoutRequested()) {
                WeakHashMap weakHashMap = m0.k0.f8683a;
                fVar.postOnAnimation(this.f1052a0);
                return;
            }
        }
    }

    public final void U0() {
        ArrayList arrayList = this.A;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int i10 = this.B;
        View s10 = i10 == -1 ? null : s(i10);
        if (s10 == null) {
            ArrayList arrayList2 = this.A;
            if (arrayList2 == null) {
                return;
            }
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                ((y) this.A.get(size)).getClass();
            }
            return;
        }
        this.f1055q.I(s10);
        ArrayList arrayList3 = this.A;
        if (arrayList3 == null) {
            return;
        }
        for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
            ((y) this.A.get(size2)).getClass();
        }
    }

    @Override // b4.o0
    public final void X(b4.f0 f0Var) {
        if (f0Var != null) {
            this.S = null;
            this.J = null;
            this.f1064z &= -1025;
            this.B = -1;
            this.E = 0;
            n1 n1Var = (n1) this.Z.f1089q;
            if (n1Var != null) {
                n1Var.n(-1);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d7  */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6, types: [boolean] */
    @Override // b4.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Y(androidx.recyclerview.widget.RecyclerView r19, java.util.ArrayList r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.p.Y(androidx.recyclerview.widget.RecyclerView, java.util.ArrayList, int, int):boolean");
    }

    public final int Y0(int i10) {
        int i11 = this.f1056r;
        if (i11 != 0) {
            if (i11 == 1) {
                if (i10 == 17) {
                    return (this.f1064z & 524288) == 0 ? 2 : 3;
                }
                if (i10 == 33) {
                    return 0;
                }
                if (i10 == 66) {
                    return (this.f1064z & 524288) == 0 ? 3 : 2;
                }
                if (i10 == 130) {
                    return 1;
                }
            }
        }
        if (i10 != 17) {
            if (i10 == 33) {
                return 2;
            }
            if (i10 != 66) {
                return i10 != 130 ? 17 : 3;
            }
            if ((this.f1064z & 262144) != 0) {
                return 0;
            }
        } else if ((this.f1064z & 262144) == 0) {
            return 0;
        }
        return 1;
    }

    public final int Z0(int i10) {
        int i11 = this.I;
        if (i11 != 0) {
            return i11;
        }
        int[] iArr = this.J;
        if (iArr == null) {
            return 0;
        }
        return iArr[i10];
    }

    public final int a1(int i10) {
        int i11 = 0;
        if ((this.f1064z & 524288) != 0) {
            for (int i12 = this.Q - 1; i12 > i10; i12--) {
                i11 += Z0(i12) + this.O;
            }
            return i11;
        }
        int i13 = 0;
        while (i11 < i10) {
            i13 += Z0(i11) + this.O;
            i11++;
        }
        return i13;
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0137, code lost:
    
        if (r3 != null) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b1(android.view.View r13, android.view.View r14, int[] r15) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.p.b1(android.view.View, android.view.View, int[]):boolean");
    }

    public final int c1() {
        int i10 = (this.f1064z & 524288) != 0 ? 0 : this.Q - 1;
        return Z0(i10) + a1(i10);
    }

    @Override // b4.o0
    public final void d0(b4.u0 u0Var, b1 b1Var, n0.g gVar) {
        o1(u0Var, b1Var);
        int b2 = b1Var.b();
        boolean z10 = (this.f1064z & 262144) != 0;
        if (b2 > 1 && !e1(0)) {
            if (this.f1056r == 0) {
                gVar.b(z10 ? n0.d.f9105n : n0.d.f9103l);
            } else {
                gVar.b(n0.d.f9102k);
            }
            gVar.l(true);
        }
        if (b2 > 1 && !e1(b2 - 1)) {
            if (this.f1056r == 0) {
                gVar.b(z10 ? n0.d.f9103l : n0.d.f9105n);
            } else {
                gVar.b(n0.d.f9104m);
            }
            gVar.l(true);
        }
        gVar.f9111a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(P(u0Var, b1Var), z(u0Var, b1Var), false, 0));
        g1();
    }

    public final boolean d1() {
        int H = H();
        return H == 0 || this.f1055q.F(H - 1) != null;
    }

    @Override // b4.o0
    public final boolean e() {
        return this.f1056r == 0 || this.Q > 1;
    }

    public final boolean e1(int i10) {
        f fVar = this.f1055q;
        f1 F = fVar.F(i10);
        if (F == null) {
            return false;
        }
        View view = F.f2232a;
        return view.getLeft() >= 0 && view.getRight() <= fVar.getWidth() && view.getTop() >= 0 && view.getBottom() <= fVar.getHeight();
    }

    @Override // b4.o0
    public final boolean f() {
        return this.f1056r == 1 || this.Q > 1;
    }

    @Override // b4.o0
    public final void f0(b4.u0 u0Var, b1 b1Var, View view, n0.g gVar) {
        i k10;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.S == null || !(layoutParams instanceof m)) {
            return;
        }
        int b2 = ((m) layoutParams).f2381a.b();
        int i10 = -1;
        if (b2 >= 0 && (k10 = this.S.k(b2)) != null) {
            i10 = k10.f1022o;
        }
        if (i10 < 0) {
            return;
        }
        int i11 = b2 / this.S.f1027e;
        if (this.f1056r == 0) {
            gVar.k(d.a.a(false, i10, 1, i11, 1));
        } else {
            gVar.k(d.a.a(false, i11, 1, i10, 1));
        }
    }

    public final void f1(View view, int i10, int i11, int i12, int i13) {
        int Z0;
        int i14;
        int W0 = this.f1056r == 0 ? W0(view) : X0(view);
        int i15 = this.I;
        if (i15 > 0) {
            W0 = Math.min(W0, i15);
        }
        int i16 = this.P;
        int i17 = i16 & 112;
        int absoluteGravity = (this.f1064z & 786432) != 0 ? Gravity.getAbsoluteGravity(i16 & 8388615, 1) : i16 & 7;
        int i18 = this.f1056r;
        if ((i18 != 0 || i17 != 48) && (i18 != 1 || absoluteGravity != 3)) {
            if ((i18 == 0 && i17 == 80) || (i18 == 1 && absoluteGravity == 5)) {
                Z0 = Z0(i10) - W0;
            } else if ((i18 == 0 && i17 == 16) || (i18 == 1 && absoluteGravity == 1)) {
                Z0 = (Z0(i10) - W0) / 2;
            }
            i13 += Z0;
        }
        if (this.f1056r == 0) {
            i14 = W0 + i13;
        } else {
            int i19 = W0 + i13;
            int i20 = i13;
            i13 = i11;
            i11 = i20;
            i14 = i12;
            i12 = i19;
        }
        m mVar = (m) view.getLayoutParams();
        b4.o0.U(view, i11, i13, i12, i14);
        Rect rect = f1050c0;
        super.B(view, rect);
        int i21 = i11 - rect.left;
        int i22 = i13 - rect.top;
        int i23 = rect.right - i12;
        int i24 = rect.bottom - i14;
        mVar.f1036e = i21;
        mVar.f1037f = i22;
        mVar.g = i23;
        mVar.f1038h = i24;
        y1(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c9  */
    @Override // b4.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View g0(android.view.View r9, int r10) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.p.g0(android.view.View, int):android.view.View");
    }

    public final void g1() {
        this.f1063y = null;
        this.f1058t = null;
        this.f1059u = 0;
        this.f1060v = 0;
    }

    @Override // b4.o0
    public final void h0(int i10, int i11) {
        j jVar;
        int i12;
        int i13 = this.B;
        if (i13 != -1 && (jVar = this.S) != null && jVar.f1028f >= 0 && (i12 = this.E) != Integer.MIN_VALUE && i10 <= i13 + i12) {
            this.E = i12 + i11;
        }
        n1 n1Var = (n1) this.Z.f1089q;
        if (n1Var != null) {
            n1Var.n(-1);
        }
    }

    public final void h1(View view) {
        int childMeasureSpec;
        int i10;
        m mVar = (m) view.getLayoutParams();
        Rect rect = f1050c0;
        d(view, rect);
        int i11 = ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin + rect.left + rect.right;
        int i12 = ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin + rect.top + rect.bottom;
        int makeMeasureSpec = this.H == -2 ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(this.I, 1073741824);
        if (this.f1056r == 0) {
            childMeasureSpec = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i11, ((ViewGroup.MarginLayoutParams) mVar).width);
            i10 = ViewGroup.getChildMeasureSpec(makeMeasureSpec, i12, ((ViewGroup.MarginLayoutParams) mVar).height);
        } else {
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i12, ((ViewGroup.MarginLayoutParams) mVar).height);
            childMeasureSpec = ViewGroup.getChildMeasureSpec(makeMeasureSpec, i11, ((ViewGroup.MarginLayoutParams) mVar).width);
            i10 = childMeasureSpec2;
        }
        view.measure(childMeasureSpec, i10);
    }

    @Override // b4.o0
    public final void i(int i10, int i11, b1 b1Var, b4.p pVar) {
        try {
            o1(null, b1Var);
            if (this.f1056r != 0) {
                i10 = i11;
            }
            if (x() != 0 && i10 != 0) {
                this.S.e(i10 < 0 ? -this.X : this.W + this.X, i10, pVar);
                g1();
            }
        } finally {
            g1();
        }
    }

    @Override // b4.o0
    public final void i0() {
        this.E = 0;
        n1 n1Var = (n1) this.Z.f1089q;
        if (n1Var != null) {
            n1Var.n(-1);
        }
    }

    public final void i1() {
        this.S.m((this.f1064z & 262144) != 0 ? this.W + this.X + this.f1060v : (-this.X) - this.f1060v, false);
    }

    @Override // b4.o0
    public final void j(int i10, b4.p pVar) {
        int i11 = this.f1055q.f1017b1;
        if (i10 == 0 || i11 == 0) {
            return;
        }
        int max = Math.max(0, Math.min(this.B - ((i11 - 1) / 2), i10 - i11));
        for (int i12 = max; i12 < i10 && i12 < max + i11; i12++) {
            pVar.b(i12, 0);
        }
    }

    @Override // b4.o0
    public final void j0(int i10, int i11) {
        int i12;
        int i13 = this.B;
        if (i13 != -1 && (i12 = this.E) != Integer.MIN_VALUE) {
            int i14 = i13 + i12;
            if (i10 <= i14 && i14 < i10 + 1) {
                this.E = (i11 - i10) + i12;
            } else if (i10 < i14 && i11 > i14 - 1) {
                this.E = i12 - 1;
            } else if (i10 > i14 && i11 < i14) {
                this.E = i12 + 1;
            }
        }
        n1 n1Var = (n1) this.Z.f1089q;
        if (n1Var != null) {
            n1Var.n(-1);
        }
    }

    public final void j1(boolean z10) {
        f fVar = this.f1055q;
        if (z10) {
            if (d1()) {
                return;
            }
        } else if (H() == 0 || fVar.F(0) != null) {
            return;
        }
        n nVar = this.D;
        if (nVar == null) {
            fVar.l0();
            n nVar2 = new n(this, z10 ? 1 : -1, this.Q > 1);
            this.E = 0;
            Q0(nVar2);
            return;
        }
        p pVar = nVar.f1046u;
        if (z10) {
            int i10 = nVar.f1045t;
            if (i10 < pVar.f1054p) {
                nVar.f1045t = i10 + 1;
                return;
            }
            return;
        }
        int i11 = nVar.f1045t;
        if (i11 > (-pVar.f1054p)) {
            nVar.f1045t = i11 - 1;
        }
    }

    @Override // b4.o0
    public final void k0(int i10, int i11) {
        j jVar;
        int i12;
        int i13;
        int i14 = this.B;
        if (i14 != -1 && (jVar = this.S) != null && jVar.f1028f >= 0 && (i12 = this.E) != Integer.MIN_VALUE && i10 <= (i13 = i14 + i12)) {
            if (i10 + i11 > i13) {
                this.B = (i10 - i13) + i12 + i14;
                this.E = Integer.MIN_VALUE;
            } else {
                this.E = i12 - i11;
            }
        }
        n1 n1Var = (n1) this.Z.f1089q;
        if (n1Var != null) {
            n1Var.n(-1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k1(boolean r18) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.p.k1(boolean):boolean");
    }

    @Override // b4.o0
    public final void l0(int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            w0 w0Var = this.Z;
            n1 n1Var = (n1) w0Var.f1089q;
            if (n1Var != null && n1Var.m() != 0) {
                ((n1) w0Var.f1089q).l(Integer.toString(i10));
            }
            i10++;
        }
    }

    public final int l1(int i10, boolean z10) {
        i k10;
        j jVar = this.S;
        if (jVar == null) {
            return i10;
        }
        int i11 = this.B;
        int i12 = (i11 == -1 || (k10 = jVar.k(i11)) == null) ? -1 : k10.f1022o;
        int x6 = x();
        View view = null;
        for (int i13 = 0; i13 < x6 && i10 != 0; i13++) {
            int i14 = i10 > 0 ? i13 : (x6 - 1) - i13;
            View w10 = w(i14);
            if (w10.getVisibility() == 0 && (!R() || w10.hasFocusable())) {
                int V0 = V0(w(i14));
                i k11 = this.S.k(V0);
                int i15 = k11 == null ? -1 : k11.f1022o;
                if (i12 == -1) {
                    i11 = V0;
                    view = w10;
                    i12 = i15;
                } else if (i15 == i12 && ((i10 > 0 && V0 > i11) || (i10 < 0 && V0 < i11))) {
                    i10 = i10 > 0 ? i10 - 1 : i10 + 1;
                    i11 = V0;
                    view = w10;
                }
            }
        }
        if (view != null) {
            if (z10) {
                if (R()) {
                    this.f1064z |= 32;
                    view.requestFocus();
                    this.f1064z &= -33;
                }
                this.B = i11;
                return i10;
            }
            t1(view, true);
        }
        return i10;
    }

    public final void m1() {
        int i10 = this.f1064z;
        if ((65600 & i10) == 65536) {
            j jVar = this.S;
            int i11 = this.B;
            int i12 = (i10 & 262144) != 0 ? -this.X : this.W + this.X;
            while (true) {
                int i13 = jVar.g;
                if (i13 < jVar.f1028f || i13 <= i11) {
                    break;
                }
                if (!jVar.f1025c) {
                    if (jVar.f1024b.r(i13) < i12) {
                        break;
                    }
                    jVar.f1024b.J(jVar.g);
                    jVar.g--;
                } else {
                    if (jVar.f1024b.r(i13) > i12) {
                        break;
                    }
                    jVar.f1024b.J(jVar.g);
                    jVar.g--;
                }
            }
            if (jVar.g < jVar.f1028f) {
                jVar.g = -1;
                jVar.f1028f = -1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:243:0x060c, code lost:
    
        if (r2 < 0) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x060e, code lost:
    
        r1 = r1 + r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x063b, code lost:
    
        if (r2 < 0) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0346, code lost:
    
        if (((r2 & 262144) != 0 ? r18 : 0) != r3.f1025c) goto L162;
     */
    @Override // b4.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n0(b4.u0 r26, b4.b1 r27) {
        /*
            Method dump skipped, instructions count: 1611
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.p.n0(b4.u0, b4.b1):void");
    }

    public final void n1() {
        int i10 = this.f1064z;
        if ((65600 & i10) == 65536) {
            j jVar = this.S;
            int i11 = this.B;
            int i12 = (i10 & 262144) != 0 ? this.W + this.X : -this.X;
            while (true) {
                int i13 = jVar.g;
                int i14 = jVar.f1028f;
                if (i13 < i14 || i14 >= i11) {
                    break;
                }
                int E = jVar.f1024b.E(i14);
                if (!jVar.f1025c) {
                    if (jVar.f1024b.r(jVar.f1028f) + E > i12) {
                        break;
                    }
                    jVar.f1024b.J(jVar.f1028f);
                    jVar.f1028f++;
                } else {
                    if (jVar.f1024b.r(jVar.f1028f) - E < i12) {
                        break;
                    }
                    jVar.f1024b.J(jVar.f1028f);
                    jVar.f1028f++;
                }
            }
            if (jVar.g < jVar.f1028f) {
                jVar.g = -1;
                jVar.f1028f = -1;
            }
        }
    }

    public final void o1(b4.u0 u0Var, b1 b1Var) {
        if (this.f1063y != null || this.f1058t != null) {
            Log.e("GridLayoutManager", "Recycler information was not released, bug!");
        }
        this.f1063y = u0Var;
        this.f1058t = b1Var;
        this.f1059u = 0;
        this.f1060v = 0;
    }

    @Override // b4.o0
    public final void p0(b4.u0 u0Var, b1 b1Var, int i10, int i11) {
        int size;
        int size2;
        int mode;
        int K;
        int L;
        int i12;
        o1(u0Var, b1Var);
        if (this.f1056r == 0) {
            size2 = View.MeasureSpec.getSize(i10);
            size = View.MeasureSpec.getSize(i11);
            mode = View.MeasureSpec.getMode(i11);
            K = M();
            L = J();
        } else {
            size = View.MeasureSpec.getSize(i10);
            size2 = View.MeasureSpec.getSize(i11);
            mode = View.MeasureSpec.getMode(i10);
            K = K();
            L = L();
        }
        int i13 = L + K;
        this.K = size;
        int i14 = this.H;
        if (i14 == -2) {
            int i15 = this.R;
            if (i15 == 0) {
                i15 = 1;
            }
            this.Q = i15;
            this.I = 0;
            int[] iArr = this.J;
            if (iArr == null || iArr.length != i15) {
                this.J = new int[i15];
            }
            if (this.f1058t.g) {
                z1();
            }
            k1(true);
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(c1() + i13, this.K);
            } else if (mode == 0) {
                i12 = c1();
                size = i12 + i13;
            } else {
                if (mode != 1073741824) {
                    throw new IllegalStateException("wrong spec");
                }
                size = this.K;
            }
        } else {
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    if (i14 == 0) {
                        i14 = size - i13;
                    }
                    this.I = i14;
                    int i16 = this.R;
                    if (i16 == 0) {
                        i16 = 1;
                    }
                    this.Q = i16;
                    i12 = ((i16 - 1) * this.O) + (i14 * i16);
                    size = i12 + i13;
                } else if (mode != 1073741824) {
                    throw new IllegalStateException("wrong spec");
                }
            }
            int i17 = this.R;
            if (i17 == 0 && i14 == 0) {
                this.Q = 1;
                this.I = size - i13;
            } else if (i17 == 0) {
                this.I = i14;
                int i18 = this.O;
                this.Q = (size + i18) / (i14 + i18);
            } else if (i14 == 0) {
                this.Q = i17;
                this.I = ((size - i13) - ((i17 - 1) * this.O)) / i17;
            } else {
                this.Q = i17;
                this.I = i14;
            }
            if (mode == Integer.MIN_VALUE) {
                int i19 = this.I;
                int i20 = this.Q;
                int i21 = ((i20 - 1) * this.O) + (i19 * i20) + i13;
                if (i21 < size) {
                    size = i21;
                }
            }
        }
        if (this.f1056r == 0) {
            this.f2358b.setMeasuredDimension(size2, size);
        } else {
            this.f2358b.setMeasuredDimension(size, size2);
        }
        g1();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r7 <= r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if (r7 >= r0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int p1(int r7) {
        /*
            r6 = this;
            int r0 = r6.f1064z
            r1 = r0 & 64
            r2 = 1
            if (r1 != 0) goto L32
            r0 = r0 & 3
            if (r0 == r2) goto L32
            x4.i r0 = r6.U
            if (r7 <= 0) goto L20
            java.lang.Object r0 = r0.f13555r
            androidx.leanback.widget.x0 r0 = (androidx.leanback.widget.x0) r0
            int r1 = r0.f1090a
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r3) goto L1b
            goto L32
        L1b:
            int r0 = r0.f1092c
            if (r7 <= r0) goto L32
            goto L31
        L20:
            if (r7 >= 0) goto L32
            java.lang.Object r0 = r0.f13555r
            androidx.leanback.widget.x0 r0 = (androidx.leanback.widget.x0) r0
            int r1 = r0.f1091b
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r3) goto L2d
            goto L32
        L2d:
            int r0 = r0.f1093d
            if (r7 >= r0) goto L32
        L31:
            r7 = r0
        L32:
            r0 = 0
            if (r7 != 0) goto L36
            return r0
        L36:
            int r1 = -r7
            int r3 = r6.x()
            int r4 = r6.f1056r
            if (r4 != r2) goto L4c
            r4 = r0
        L40:
            if (r4 >= r3) goto L59
            android.view.View r5 = r6.w(r4)
            r5.offsetTopAndBottom(r1)
            int r4 = r4 + 1
            goto L40
        L4c:
            r4 = r0
        L4d:
            if (r4 >= r3) goto L59
            android.view.View r5 = r6.w(r4)
            r5.offsetLeftAndRight(r1)
            int r4 = r4 + 1
            goto L4d
        L59:
            int r1 = r6.f1064z
            r1 = r1 & 3
            if (r1 != r2) goto L63
            r6.B1()
            return r7
        L63:
            int r1 = r6.x()
            int r3 = r6.f1064z
            r4 = 262144(0x40000, float:3.67342E-40)
            r3 = r3 & r4
            if (r3 == 0) goto L71
            if (r7 <= 0) goto L77
            goto L73
        L71:
            if (r7 >= 0) goto L77
        L73:
            r6.i1()
            goto L7a
        L77:
            r6.S0()
        L7a:
            int r3 = r6.x()
            if (r3 <= r1) goto L82
            r1 = r2
            goto L83
        L82:
            r1 = r0
        L83:
            int r3 = r6.x()
            int r5 = r6.f1064z
            r4 = r4 & r5
            if (r4 == 0) goto L8f
            if (r7 <= 0) goto L95
            goto L91
        L8f:
            if (r7 >= 0) goto L95
        L91:
            r6.m1()
            goto L98
        L95:
            r6.n1()
        L98:
            int r4 = r6.x()
            if (r4 >= r3) goto L9f
            goto La0
        L9f:
            r2 = r0
        La0:
            r0 = r1 | r2
            if (r0 == 0) goto La7
            r6.A1()
        La7:
            androidx.leanback.widget.f r0 = r6.f1055q
            r0.invalidate()
            r6.B1()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.p.p1(int):int");
    }

    @Override // b4.o0
    public final boolean q0(RecyclerView recyclerView, View view, View view2) {
        if ((this.f1064z & 32768) == 0 && V0(view) != -1 && (this.f1064z & 35) == 0) {
            s1(view, view2, true, 0, 0);
        }
        return true;
    }

    public final int q1(int i10) {
        int i11 = 0;
        if (i10 == 0) {
            return 0;
        }
        int i12 = -i10;
        int x6 = x();
        if (this.f1056r == 0) {
            while (i11 < x6) {
                w(i11).offsetTopAndBottom(i12);
                i11++;
            }
        } else {
            while (i11 < x6) {
                w(i11).offsetLeftAndRight(i12);
                i11++;
            }
        }
        this.G += i10;
        C1();
        this.f1055q.invalidate();
        return i10;
    }

    @Override // b4.o0
    public final void r0(Parcelable parcelable) {
        if (parcelable instanceof o) {
            o oVar = (o) parcelable;
            this.B = oVar.f1047o;
            this.E = 0;
            Bundle bundle = oVar.f1048p;
            w0 w0Var = this.Z;
            n1 n1Var = (n1) w0Var.f1089q;
            if (n1Var != null && bundle != null) {
                n1Var.n(-1);
                for (String str : bundle.keySet()) {
                    ((n1) w0Var.f1089q).k(str, bundle.getSparseParcelableArray(str));
                }
            }
            this.f1064z |= 256;
            C0();
        }
    }

    public final void r1(int i10, boolean z10) {
        View s10 = s(i10);
        b4.y yVar = this.f2361e;
        boolean z11 = yVar != null && yVar.f2454e;
        f fVar = this.f1055q;
        if (!z11 && !fVar.isLayoutRequested() && s10 != null && V0(s10) == i10) {
            this.f1064z |= 32;
            t1(s10, z10);
            this.f1064z &= -33;
            return;
        }
        int i11 = this.f1064z;
        if ((i11 & 512) == 0 || (i11 & 64) != 0) {
            this.B = i10;
            this.E = Integer.MIN_VALUE;
            return;
        }
        if (z10 && !fVar.isLayoutRequested()) {
            this.B = i10;
            this.E = Integer.MIN_VALUE;
            if (this.S == null) {
                Log.w("GridLayoutManager:" + fVar.getId(), "setSelectionSmooth should not be called before first layout pass");
                return;
            }
            k kVar = new k(this);
            kVar.f2450a = i10;
            Q0(kVar);
            int i12 = kVar.f2450a;
            if (i12 != this.B) {
                this.B = i12;
                return;
            }
            return;
        }
        if (z11) {
            l lVar = this.C;
            if (lVar != null) {
                lVar.f1032q = true;
            }
            fVar.l0();
        }
        if (!fVar.isLayoutRequested() && s10 != null && V0(s10) == i10) {
            this.f1064z |= 32;
            t1(s10, z10);
            this.f1064z &= -33;
        } else {
            this.B = i10;
            this.E = Integer.MIN_VALUE;
            this.f1064z |= 256;
            C0();
        }
    }

    @Override // b4.o0
    public final Parcelable s0() {
        Bundle bundle;
        o oVar = new o();
        oVar.f1048p = Bundle.EMPTY;
        oVar.f1047o = this.B;
        w0 w0Var = this.Z;
        n1 n1Var = (n1) w0Var.f1089q;
        if (n1Var == null || n1Var.m() == 0) {
            bundle = null;
        } else {
            n1 n1Var2 = (n1) w0Var.f1089q;
            n1Var2.getClass();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            synchronized (((w1) n1Var2.g)) {
                Set<Map.Entry> entrySet = ((c4.k) n1Var2.f2355f).f2908a.entrySet();
                za.h.d("map.entries", entrySet);
                for (Map.Entry entry : entrySet) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            bundle = new Bundle();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                bundle.putSparseParcelableArray((String) entry2.getKey(), (SparseArray) entry2.getValue());
            }
        }
        int x6 = x();
        for (int i10 = 0; i10 < x6; i10++) {
            View w10 = w(i10);
            int V0 = V0(w10);
            if (V0 != -1 && this.Z.f1087o != 0) {
                String num = Integer.toString(V0);
                SparseArray<Parcelable> sparseArray = new SparseArray<>();
                w10.saveHierarchyState(sparseArray);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray(num, sparseArray);
            }
        }
        oVar.f1048p = bundle;
        return oVar;
    }

    public final void s1(View view, View view2, boolean z10, int i10, int i11) {
        if ((this.f1064z & 64) != 0) {
            return;
        }
        int V0 = V0(view);
        if (view != null && view2 != null) {
            ((m) view.getLayoutParams()).getClass();
        }
        int i12 = this.B;
        f fVar = this.f1055q;
        if (V0 != i12) {
            this.B = V0;
            this.E = 0;
            if ((this.f1064z & 3) != 1) {
                T0();
            }
            if (fVar.M()) {
                fVar.invalidate();
            }
        }
        if (view == null) {
            return;
        }
        if (!view.hasFocus() && fVar.hasFocus()) {
            view.requestFocus();
        }
        if ((this.f1064z & 131072) == 0 && z10) {
            return;
        }
        int[] iArr = f1051d0;
        if (!b1(view, view2, iArr) && i10 == 0 && i11 == 0) {
            return;
        }
        int i13 = iArr[0] + i10;
        int i14 = iArr[1] + i11;
        if ((this.f1064z & 3) == 1) {
            p1(i13);
            q1(i14);
            return;
        }
        if (this.f1056r != 0) {
            i14 = i13;
            i13 = i14;
        }
        if (z10) {
            fVar.g0(i13, i14, false);
        } else {
            fVar.scrollBy(i13, i14);
            U0();
        }
    }

    @Override // b4.o0
    public final b4.p0 t() {
        return new m(-2, -2);
    }

    public final void t1(View view, boolean z10) {
        s1(view, view.findFocus(), z10, 0, 0);
    }

    @Override // b4.o0
    public final b4.p0 u(Context context, AttributeSet attributeSet) {
        return new m(context, attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r6 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        r5 = 4096;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        if (r6 != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        if (r5 == n0.d.f9104m.a()) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    @Override // b4.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean u0(int r5, b4.u0 r6, b4.b1 r7) {
        /*
            r4 = this;
            int r0 = r4.f1064z
            r1 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r1
            r1 = 1
            if (r0 == 0) goto L5d
            r4.o1(r6, r7)
            int r6 = r4.f1064z
            r7 = 262144(0x40000, float:3.67342E-40)
            r6 = r6 & r7
            r7 = 0
            if (r6 == 0) goto L15
            r6 = r1
            goto L16
        L15:
            r6 = r7
        L16:
            int r0 = r4.f1056r
            r2 = 8192(0x2000, float:1.14794E-41)
            r3 = 4096(0x1000, float:5.74E-42)
            if (r0 != 0) goto L34
            n0.d r0 = n0.d.f9103l
            int r0 = r0.a()
            if (r5 != r0) goto L29
            if (r6 == 0) goto L3c
            goto L46
        L29:
            n0.d r0 = n0.d.f9105n
            int r0 = r0.a()
            if (r5 != r0) goto L47
            if (r6 == 0) goto L46
            goto L3c
        L34:
            n0.d r6 = n0.d.f9102k
            int r6 = r6.a()
            if (r5 != r6) goto L3e
        L3c:
            r5 = r2
            goto L47
        L3e:
            n0.d r6 = n0.d.f9104m
            int r6 = r6.a()
            if (r5 != r6) goto L47
        L46:
            r5 = r3
        L47:
            if (r5 == r3) goto L54
            if (r5 == r2) goto L4c
            goto L5a
        L4c:
            r4.j1(r7)
            r5 = -1
            r4.l1(r5, r7)
            goto L5a
        L54:
            r4.j1(r1)
            r4.l1(r1, r7)
        L5a:
            r4.g1()
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.p.u0(int, b4.u0, b4.b1):boolean");
    }

    public final void u1(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.f1056r = i10;
            this.f1057s = androidx.emoji2.text.g.a(this, i10);
            x4.i iVar = this.U;
            x0 x0Var = (x0) iVar.f13553p;
            x0 x0Var2 = (x0) iVar.f13554q;
            if (i10 == 0) {
                iVar.f13555r = x0Var2;
                iVar.f13556s = x0Var;
            } else {
                iVar.f13555r = x0Var;
                iVar.f13556s = x0Var2;
            }
            android.support.v4.media.session.a0 a0Var = this.V;
            a0Var.getClass();
            if (i10 == 0) {
                a0Var.f232r = (t) a0Var.f231q;
            } else {
                a0Var.f232r = (t) a0Var.f230p;
            }
            this.f1064z |= 256;
        }
    }

    @Override // b4.o0
    public final b4.p0 v(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof m ? new m((m) layoutParams) : layoutParams instanceof b4.p0 ? new m((b4.p0) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new m((ViewGroup.MarginLayoutParams) layoutParams) : new m(layoutParams);
    }

    @Override // b4.o0
    public final void v0(b4.u0 u0Var) {
        for (int x6 = x() - 1; x6 >= 0; x6--) {
            y0(x6, u0Var);
        }
    }

    public final void v1(int i10) {
        if (i10 < 0 && i10 != -2) {
            throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Invalid row height: "));
        }
        this.H = i10;
    }

    public final void w1(int i10, boolean z10) {
        if (this.B == i10 || i10 == -1) {
            return;
        }
        r1(i10, z10);
    }

    public final void x1() {
        int x6 = x();
        for (int i10 = 0; i10 < x6; i10++) {
            y1(w(i10));
        }
    }

    public final void y1(View view) {
        m mVar = (m) view.getLayoutParams();
        mVar.getClass();
        android.support.v4.media.session.a0 a0Var = this.V;
        t tVar = (t) a0Var.f231q;
        mVar.f1039i = u.a(view, tVar, tVar.f1078e);
        t tVar2 = (t) a0Var.f230p;
        mVar.f1040j = u.a(view, tVar2, tVar2.f1078e);
    }

    @Override // b4.o0
    public final int z(b4.u0 u0Var, b1 b1Var) {
        j jVar;
        if (this.f1056r != 1 || (jVar = this.S) == null) {
            return -1;
        }
        return jVar.f1027e;
    }

    public final void z1() {
        if (x() <= 0) {
            this.f1059u = 0;
        } else {
            this.f1059u = this.S.f1028f - ((m) w(0).getLayoutParams()).f2381a.c();
        }
    }

    @Override // b4.o0
    public final void o0(b1 b1Var) {
    }
}
