package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.media.d;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import b4.b1;
import b4.o0;
import b4.p;
import b4.p0;
import b4.s;
import b4.u;
import b4.u0;
import b4.w;
import d.a;
import java.util.WeakHashMap;
import m0.k0;
import n0.g;
import x4.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean E;
    public int F;
    public int[] G;
    public View[] H;
    public final SparseIntArray I;
    public final SparseIntArray J;
    public final l K;
    public final Rect L;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new l(3);
        this.L = new Rect();
        D1(o0.O(context, attributeSet, i10, i11).f2347b);
    }

    public final int A1(int i10, u0 u0Var, b1 b1Var) {
        boolean z10 = b1Var.g;
        l lVar = this.K;
        if (!z10) {
            int i11 = this.F;
            lVar.getClass();
            return i10 % i11;
        }
        int i12 = this.J.get(i10, -1);
        if (i12 != -1) {
            return i12;
        }
        int b2 = u0Var.b(i10);
        if (b2 != -1) {
            int i13 = this.F;
            lVar.getClass();
            return b2 % i13;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
        return 0;
    }

    public final int B1(int i10, u0 u0Var, b1 b1Var) {
        boolean z10 = b1Var.g;
        l lVar = this.K;
        if (!z10) {
            lVar.getClass();
            return 1;
        }
        int i11 = this.I.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        if (u0Var.b(i10) != -1) {
            lVar.getClass();
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
        return 1;
    }

    public final void C1(View view, int i10, boolean z10) {
        int i11;
        int i12;
        s sVar = (s) view.getLayoutParams();
        Rect rect = sVar.f2382b;
        int i13 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) sVar).topMargin + ((ViewGroup.MarginLayoutParams) sVar).bottomMargin;
        int i14 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) sVar).leftMargin + ((ViewGroup.MarginLayoutParams) sVar).rightMargin;
        int y12 = y1(sVar.f2400e, sVar.f2401f);
        if (this.f1448p == 1) {
            i12 = o0.y(false, y12, i10, i14, ((ViewGroup.MarginLayoutParams) sVar).width);
            i11 = o0.y(true, this.f1450r.l(), this.f2368m, i13, ((ViewGroup.MarginLayoutParams) sVar).height);
        } else {
            int y8 = o0.y(false, y12, i10, i13, ((ViewGroup.MarginLayoutParams) sVar).height);
            int y10 = o0.y(true, this.f1450r.l(), this.f2367l, i14, ((ViewGroup.MarginLayoutParams) sVar).width);
            i11 = y8;
            i12 = y10;
        }
        p0 p0Var = (p0) view.getLayoutParams();
        if (z10 ? O0(view, i12, i11, p0Var) : M0(view, i12, i11, p0Var)) {
            view.measure(i12, i11);
        }
    }

    public final void D1(int i10) {
        if (i10 == this.F) {
            return;
        }
        this.E = true;
        if (i10 < 1) {
            throw new IllegalArgumentException(d.m(i10, "Span count should be at least 1. Provided "));
        }
        this.F = i10;
        this.K.l();
        C0();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, b4.o0
    public final int E0(int i10, u0 u0Var, b1 b1Var) {
        E1();
        x1();
        return super.E0(i10, u0Var, b1Var);
    }

    public final void E1() {
        int J;
        int M;
        if (this.f1448p == 1) {
            J = this.f2369n - L();
            M = K();
        } else {
            J = this.f2370o - J();
            M = M();
        }
        w1(J - M);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, b4.o0
    public final int G0(int i10, u0 u0Var, b1 b1Var) {
        E1();
        x1();
        return super.G0(i10, u0Var, b1Var);
    }

    @Override // b4.o0
    public final void J0(Rect rect, int i10, int i11) {
        int h10;
        int h11;
        if (this.G == null) {
            super.J0(rect, i10, i11);
        }
        int L = L() + K();
        int J = J() + M();
        if (this.f1448p == 1) {
            int height = rect.height() + J;
            RecyclerView recyclerView = this.f2358b;
            WeakHashMap weakHashMap = k0.f8683a;
            h11 = o0.h(i11, height, recyclerView.getMinimumHeight());
            int[] iArr = this.G;
            h10 = o0.h(i10, iArr[iArr.length - 1] + L, this.f2358b.getMinimumWidth());
        } else {
            int width = rect.width() + L;
            RecyclerView recyclerView2 = this.f2358b;
            WeakHashMap weakHashMap2 = k0.f8683a;
            h10 = o0.h(i10, width, recyclerView2.getMinimumWidth());
            int[] iArr2 = this.G;
            h11 = o0.h(i11, iArr2[iArr2.length - 1] + J, this.f2358b.getMinimumHeight());
        }
        this.f2358b.setMeasuredDimension(h10, h11);
    }

    @Override // b4.o0
    public final int P(u0 u0Var, b1 b1Var) {
        if (this.f1448p == 0) {
            return this.F;
        }
        if (b1Var.b() < 1) {
            return 0;
        }
        return z1(b1Var.b() - 1, u0Var, b1Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, b4.o0
    public final boolean R0() {
        return this.f1458z == null && !this.E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void T0(b1 b1Var, w wVar, p pVar) {
        int i10;
        int i11 = this.F;
        for (int i12 = 0; i12 < this.F && (i10 = wVar.f2437d) >= 0 && i10 < b1Var.b() && i11 > 0; i12++) {
            pVar.b(wVar.f2437d, Math.max(0, wVar.g));
            this.K.getClass();
            i11--;
            wVar.f2437d += wVar.f2438e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c9, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ee, code lost:
    
        if (r13 == (r2 > r8)) goto L70;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, b4.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View b0(android.view.View r23, int r24, b4.u0 r25, b4.b1 r26) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.b0(android.view.View, int, b4.u0, b4.b1):android.view.View");
    }

    @Override // b4.o0
    public final void d0(u0 u0Var, b1 b1Var, g gVar) {
        super.d0(u0Var, b1Var, gVar);
        gVar.i(GridView.class.getName());
    }

    @Override // b4.o0
    public final void f0(u0 u0Var, b1 b1Var, View view, g gVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof s)) {
            e0(view, gVar);
            return;
        }
        s sVar = (s) layoutParams;
        int z12 = z1(sVar.f2381a.c(), u0Var, b1Var);
        if (this.f1448p == 0) {
            gVar.k(a.a(false, sVar.f2400e, sVar.f2401f, z12, 1));
        } else {
            gVar.k(a.a(false, z12, 1, sVar.f2400e, sVar.f2401f));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View f1(u0 u0Var, b1 b1Var, boolean z10, boolean z11) {
        int i10;
        int i11;
        int x6 = x();
        int i12 = 1;
        if (z11) {
            i11 = x() - 1;
            i10 = -1;
            i12 = -1;
        } else {
            i10 = x6;
            i11 = 0;
        }
        int b2 = b1Var.b();
        Y0();
        int k10 = this.f1450r.k();
        int g = this.f1450r.g();
        View view = null;
        View view2 = null;
        while (i11 != i10) {
            View w10 = w(i11);
            int N = o0.N(w10);
            if (N >= 0 && N < b2 && A1(N, u0Var, b1Var) == 0) {
                if (((p0) w10.getLayoutParams()).f2381a.i()) {
                    if (view2 == null) {
                        view2 = w10;
                    }
                } else {
                    if (this.f1450r.e(w10) < g && this.f1450r.b(w10) >= k10) {
                        return w10;
                    }
                    if (view == null) {
                        view = w10;
                    }
                }
            }
            i11 += i12;
        }
        return view != null ? view : view2;
    }

    @Override // b4.o0
    public final boolean g(p0 p0Var) {
        return p0Var instanceof s;
    }

    @Override // b4.o0
    public final void h0(int i10, int i11) {
        l lVar = this.K;
        lVar.l();
        ((SparseIntArray) lVar.f13562p).clear();
    }

    @Override // b4.o0
    public final void i0() {
        l lVar = this.K;
        lVar.l();
        ((SparseIntArray) lVar.f13562p).clear();
    }

    @Override // b4.o0
    public final void j0(int i10, int i11) {
        l lVar = this.K;
        lVar.l();
        ((SparseIntArray) lVar.f13562p).clear();
    }

    @Override // b4.o0
    public final void k0(int i10, int i11) {
        l lVar = this.K;
        lVar.l();
        ((SparseIntArray) lVar.f13562p).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, b4.o0
    public final int l(b1 b1Var) {
        return V0(b1Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
    
        r22.f2431b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l1(b4.u0 r19, b4.b1 r20, b4.w r21, b4.v r22) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.l1(b4.u0, b4.b1, b4.w, b4.v):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, b4.o0
    public final int m(b1 b1Var) {
        return W0(b1Var);
    }

    @Override // b4.o0
    public final void m0(RecyclerView recyclerView, int i10, int i11) {
        l lVar = this.K;
        lVar.l();
        ((SparseIntArray) lVar.f13562p).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void m1(u0 u0Var, b1 b1Var, u uVar, int i10) {
        E1();
        if (b1Var.b() > 0 && !b1Var.g) {
            boolean z10 = i10 == 1;
            int A1 = A1(uVar.f2418b, u0Var, b1Var);
            if (z10) {
                while (A1 > 0) {
                    int i11 = uVar.f2418b;
                    if (i11 <= 0) {
                        break;
                    }
                    int i12 = i11 - 1;
                    uVar.f2418b = i12;
                    A1 = A1(i12, u0Var, b1Var);
                }
            } else {
                int b2 = b1Var.b() - 1;
                int i13 = uVar.f2418b;
                while (i13 < b2) {
                    int i14 = i13 + 1;
                    int A12 = A1(i14, u0Var, b1Var);
                    if (A12 <= A1) {
                        break;
                    }
                    i13 = i14;
                    A1 = A12;
                }
                uVar.f2418b = i13;
            }
        }
        x1();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, b4.o0
    public final void n0(u0 u0Var, b1 b1Var) {
        boolean z10 = b1Var.g;
        SparseIntArray sparseIntArray = this.J;
        SparseIntArray sparseIntArray2 = this.I;
        if (z10) {
            int x6 = x();
            for (int i10 = 0; i10 < x6; i10++) {
                s sVar = (s) w(i10).getLayoutParams();
                int c10 = sVar.f2381a.c();
                sparseIntArray2.put(c10, sVar.f2401f);
                sparseIntArray.put(c10, sVar.f2400e);
            }
        }
        super.n0(u0Var, b1Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, b4.o0
    public final int o(b1 b1Var) {
        return V0(b1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, b4.o0
    public final void o0(b1 b1Var) {
        super.o0(b1Var);
        this.E = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, b4.o0
    public final int p(b1 b1Var) {
        return W0(b1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void s1(boolean z10) {
        if (z10) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.s1(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, b4.o0
    public final p0 t() {
        return this.f1448p == 0 ? new s(-2, -1) : new s(-1, -2);
    }

    @Override // b4.o0
    public final p0 u(Context context, AttributeSet attributeSet) {
        s sVar = new s(context, attributeSet);
        sVar.f2400e = -1;
        sVar.f2401f = 0;
        return sVar;
    }

    @Override // b4.o0
    public final p0 v(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            s sVar = new s((ViewGroup.MarginLayoutParams) layoutParams);
            sVar.f2400e = -1;
            sVar.f2401f = 0;
            return sVar;
        }
        s sVar2 = new s(layoutParams);
        sVar2.f2400e = -1;
        sVar2.f2401f = 0;
        return sVar2;
    }

    public final void w1(int i10) {
        int i11;
        int[] iArr = this.G;
        int i12 = this.F;
        if (iArr == null || iArr.length != i12 + 1 || iArr[iArr.length - 1] != i10) {
            iArr = new int[i12 + 1];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i10 / i12;
        int i15 = i10 % i12;
        int i16 = 0;
        for (int i17 = 1; i17 <= i12; i17++) {
            i13 += i15;
            if (i13 <= 0 || i12 - i13 >= i15) {
                i11 = i14;
            } else {
                i11 = i14 + 1;
                i13 -= i12;
            }
            i16 += i11;
            iArr[i17] = i16;
        }
        this.G = iArr;
    }

    public final void x1() {
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
    }

    public final int y1(int i10, int i11) {
        if (this.f1448p != 1 || !k1()) {
            int[] iArr = this.G;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.G;
        int i12 = this.F;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    @Override // b4.o0
    public final int z(u0 u0Var, b1 b1Var) {
        if (this.f1448p == 1) {
            return this.F;
        }
        if (b1Var.b() < 1) {
            return 0;
        }
        return z1(b1Var.b() - 1, u0Var, b1Var) + 1;
    }

    public final int z1(int i10, u0 u0Var, b1 b1Var) {
        boolean z10 = b1Var.g;
        l lVar = this.K;
        if (!z10) {
            int i11 = this.F;
            lVar.getClass();
            return l.j(i10, i11);
        }
        int b2 = u0Var.b(i10);
        if (b2 != -1) {
            int i12 = this.F;
            lVar.getClass();
            return l.j(b2, i12);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i10);
        return 0;
    }

    public GridLayoutManager(int i10, int i11) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new l(3);
        this.L = new Rect();
        D1(i10);
    }

    public GridLayoutManager(int i10) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new l(3);
        this.L = new Rect();
        D1(i10);
    }
}
