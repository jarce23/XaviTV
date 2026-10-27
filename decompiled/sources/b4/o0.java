package b4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public android.support.v4.media.session.a0 f2357a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f2358b;

    /* renamed from: c, reason: collision with root package name */
    public final j5.g f2359c;

    /* renamed from: d, reason: collision with root package name */
    public final j5.g f2360d;

    /* renamed from: e, reason: collision with root package name */
    public y f2361e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2362f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f2363h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2364i;

    /* renamed from: j, reason: collision with root package name */
    public int f2365j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2366k;

    /* renamed from: l, reason: collision with root package name */
    public int f2367l;

    /* renamed from: m, reason: collision with root package name */
    public int f2368m;

    /* renamed from: n, reason: collision with root package name */
    public int f2369n;

    /* renamed from: o, reason: collision with root package name */
    public int f2370o;

    public o0() {
        m0 m0Var = new m0(this, 0);
        m0 m0Var2 = new m0(this, 1);
        this.f2359c = new j5.g(m0Var);
        this.f2360d = new j5.g(m0Var2);
        this.f2362f = false;
        this.g = false;
        this.f2363h = true;
        this.f2364i = true;
    }

    public static int D(View view) {
        Rect rect = ((p0) view.getLayoutParams()).f2382b;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public static int E(View view) {
        Rect rect = ((p0) view.getLayoutParams()).f2382b;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public static int N(View view) {
        return ((p0) view.getLayoutParams()).f2381a.c();
    }

    public static n0 O(Context context, AttributeSet attributeSet, int i10, int i11) {
        n0 n0Var = new n0();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a4.a.f29a, i10, i11);
        n0Var.f2346a = obtainStyledAttributes.getInt(0, 1);
        n0Var.f2347b = obtainStyledAttributes.getInt(10, 1);
        n0Var.f2348c = obtainStyledAttributes.getBoolean(9, false);
        n0Var.f2349d = obtainStyledAttributes.getBoolean(11, false);
        obtainStyledAttributes.recycle();
        return n0Var;
    }

    public static boolean T(int i10, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (i12 > 0 && i10 != i12) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i10;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i10;
        }
        return true;
    }

    public static void U(View view, int i10, int i11, int i12, int i13) {
        p0 p0Var = (p0) view.getLayoutParams();
        Rect rect = p0Var.f2382b;
        view.layout(i10 + rect.left + ((ViewGroup.MarginLayoutParams) p0Var).leftMargin, i11 + rect.top + ((ViewGroup.MarginLayoutParams) p0Var).topMargin, (i12 - rect.right) - ((ViewGroup.MarginLayoutParams) p0Var).rightMargin, (i13 - rect.bottom) - ((ViewGroup.MarginLayoutParams) p0Var).bottomMargin);
    }

    public static int h(int i10, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i11, i12) : size : Math.min(size, Math.max(i11, i12));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        if (r6 == 1073741824) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int y(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            int r5 = r5 - r7
            r7 = 0
            int r5 = java.lang.Math.max(r7, r5)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L1d
            if (r8 < 0) goto L12
        L10:
            r6 = r3
            goto L30
        L12:
            if (r8 != r1) goto L1a
            if (r6 == r2) goto L22
            if (r6 == 0) goto L1a
            if (r6 == r3) goto L22
        L1a:
            r6 = r7
            r8 = r6
            goto L30
        L1d:
            if (r8 < 0) goto L20
            goto L10
        L20:
            if (r8 != r1) goto L24
        L22:
            r8 = r5
            goto L30
        L24:
            if (r8 != r0) goto L1a
            if (r6 == r2) goto L2e
            if (r6 != r3) goto L2b
            goto L2e
        L2b:
            r8 = r5
            r6 = r7
            goto L30
        L2e:
            r8 = r5
            r6 = r2
        L30:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.o0.y(boolean, int, int, int, int):int");
    }

    public int A(View view) {
        return view.getBottom() + ((p0) view.getLayoutParams()).f2382b.bottom;
    }

    public boolean A0(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
        return B0(recyclerView, view, rect, z10, false);
    }

    public void B(View view, Rect rect) {
        int[] iArr = RecyclerView.O0;
        p0 p0Var = (p0) view.getLayoutParams();
        Rect rect2 = p0Var.f2382b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) p0Var).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) p0Var).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) p0Var).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) p0Var).bottomMargin);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ab, code lost:
    
        if ((r5.bottom - r10) > r2) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean B0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.K()
            int r1 = r8.M()
            int r2 = r8.f2369n
            int r3 = r8.L()
            int r2 = r2 - r3
            int r3 = r8.f2370o
            int r4 = r8.J()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            int r3 = r8.I()
            r7 = 1
            if (r3 != r7) goto L5c
            if (r2 == 0) goto L57
            goto L64
        L57:
            int r2 = java.lang.Math.max(r6, r10)
            goto L64
        L5c:
            if (r6 == 0) goto L5f
            goto L63
        L5f:
            int r6 = java.lang.Math.min(r4, r2)
        L63:
            r2 = r6
        L64:
            if (r1 == 0) goto L67
            goto L6b
        L67:
            int r1 = java.lang.Math.min(r5, r11)
        L6b:
            int[] r10 = new int[]{r2, r1}
            r11 = r10[r0]
            r10 = r10[r7]
            if (r13 == 0) goto Lae
            android.view.View r13 = r9.getFocusedChild()
            if (r13 != 0) goto L7c
            goto Lb3
        L7c:
            int r1 = r8.K()
            int r2 = r8.M()
            int r3 = r8.f2369n
            int r4 = r8.L()
            int r3 = r3 - r4
            int r4 = r8.f2370o
            int r5 = r8.J()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.f2358b
            android.graphics.Rect r5 = r5.f1490x
            r8.B(r13, r5)
            int r13 = r5.left
            int r13 = r13 - r11
            if (r13 >= r3) goto Lb3
            int r13 = r5.right
            int r13 = r13 - r11
            if (r13 <= r1) goto Lb3
            int r13 = r5.top
            int r13 = r13 - r10
            if (r13 >= r4) goto Lb3
            int r13 = r5.bottom
            int r13 = r13 - r10
            if (r13 > r2) goto Lae
            goto Lb3
        Lae:
            if (r11 != 0) goto Lb4
            if (r10 == 0) goto Lb3
            goto Lb4
        Lb3:
            return r0
        Lb4:
            if (r12 == 0) goto Lba
            r9.scrollBy(r11, r10)
            return r7
        Lba:
            r9.g0(r11, r10, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.o0.B0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public int C(View view) {
        return view.getLeft() - ((p0) view.getLayoutParams()).f2382b.left;
    }

    public final void C0() {
        RecyclerView recyclerView = this.f2358b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public final void D0(u0 u0Var, int i10, View view) {
        f1 J = RecyclerView.J(view);
        if (J.p()) {
            return;
        }
        if (J.g() && !J.i() && !this.f2358b.A.f2229b) {
            z0(i10);
            u0Var.j(J);
        } else {
            w(i10);
            this.f2357a.E(i10);
            u0Var.k(view);
            this.f2358b.f1484u.b0(J);
        }
    }

    public abstract int E0(int i10, u0 u0Var, b1 b1Var);

    public int F(View view) {
        return view.getRight() + ((p0) view.getLayoutParams()).f2382b.right;
    }

    public abstract void F0(int i10);

    public int G(View view) {
        return view.getTop() - ((p0) view.getLayoutParams()).f2382b.top;
    }

    public abstract int G0(int i10, u0 u0Var, b1 b1Var);

    public final int H() {
        RecyclerView recyclerView = this.f2358b;
        f0 adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.a();
        }
        return 0;
    }

    public final void H0(RecyclerView recyclerView) {
        I0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public final int I() {
        RecyclerView recyclerView = this.f2358b;
        WeakHashMap weakHashMap = m0.k0.f8683a;
        return recyclerView.getLayoutDirection();
    }

    public final void I0(int i10, int i11) {
        this.f2369n = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        this.f2367l = mode;
        if (mode == 0 && !RecyclerView.Q0) {
            this.f2369n = 0;
        }
        this.f2370o = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        this.f2368m = mode2;
        if (mode2 != 0 || RecyclerView.Q0) {
            return;
        }
        this.f2370o = 0;
    }

    public final int J() {
        RecyclerView recyclerView = this.f2358b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public void J0(Rect rect, int i10, int i11) {
        int L = L() + K() + rect.width();
        int J = J() + M() + rect.height();
        RecyclerView recyclerView = this.f2358b;
        WeakHashMap weakHashMap = m0.k0.f8683a;
        this.f2358b.setMeasuredDimension(h(i10, L, recyclerView.getMinimumWidth()), h(i11, J, this.f2358b.getMinimumHeight()));
    }

    public final int K() {
        RecyclerView recyclerView = this.f2358b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final void K0(int i10, int i11) {
        int x6 = x();
        if (x6 == 0) {
            this.f2358b.o(i10, i11);
            return;
        }
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MAX_VALUE;
        int i14 = Integer.MIN_VALUE;
        int i15 = Integer.MAX_VALUE;
        for (int i16 = 0; i16 < x6; i16++) {
            View w10 = w(i16);
            Rect rect = this.f2358b.f1490x;
            B(w10, rect);
            int i17 = rect.left;
            if (i17 < i15) {
                i15 = i17;
            }
            int i18 = rect.right;
            if (i18 > i12) {
                i12 = i18;
            }
            int i19 = rect.top;
            if (i19 < i13) {
                i13 = i19;
            }
            int i20 = rect.bottom;
            if (i20 > i14) {
                i14 = i20;
            }
        }
        this.f2358b.f1490x.set(i15, i13, i12, i14);
        J0(this.f2358b.f1490x, i10, i11);
    }

    public final int L() {
        RecyclerView recyclerView = this.f2358b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final void L0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f2358b = null;
            this.f2357a = null;
            this.f2369n = 0;
            this.f2370o = 0;
        } else {
            this.f2358b = recyclerView;
            this.f2357a = recyclerView.f1482t;
            this.f2369n = recyclerView.getWidth();
            this.f2370o = recyclerView.getHeight();
        }
        this.f2367l = 1073741824;
        this.f2368m = 1073741824;
    }

    public final int M() {
        RecyclerView recyclerView = this.f2358b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public final boolean M0(View view, int i10, int i11, p0 p0Var) {
        return (!view.isLayoutRequested() && this.f2363h && T(view.getWidth(), i10, ((ViewGroup.MarginLayoutParams) p0Var).width) && T(view.getHeight(), i11, ((ViewGroup.MarginLayoutParams) p0Var).height)) ? false : true;
    }

    public boolean N0() {
        return false;
    }

    public final boolean O0(View view, int i10, int i11, p0 p0Var) {
        return (this.f2363h && T(view.getMeasuredWidth(), i10, ((ViewGroup.MarginLayoutParams) p0Var).width) && T(view.getMeasuredHeight(), i11, ((ViewGroup.MarginLayoutParams) p0Var).height)) ? false : true;
    }

    public int P(u0 u0Var, b1 b1Var) {
        return -1;
    }

    public abstract void P0(RecyclerView recyclerView, int i10);

    public final void Q(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((p0) view.getLayoutParams()).f2382b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.f2358b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.f2358b.f1494z;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public void Q0(y yVar) {
        y yVar2 = this.f2361e;
        if (yVar2 != null && yVar != yVar2 && yVar2.f2454e) {
            yVar2.j();
        }
        this.f2361e = yVar;
        RecyclerView recyclerView = this.f2358b;
        e1 e1Var = recyclerView.f1481s0;
        e1Var.f2221u.removeCallbacks(e1Var);
        e1Var.f2217q.abortAnimation();
        if (yVar.f2456h) {
            Log.w("RecyclerView", "An instance of " + yVar.getClass().getSimpleName() + " was started more than once. Each instance of" + yVar.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        yVar.f2451b = recyclerView;
        yVar.f2452c = this;
        int i10 = yVar.f2450a;
        if (i10 == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.f1487v0.f2185a = i10;
        yVar.f2454e = true;
        yVar.f2453d = true;
        yVar.f2455f = recyclerView.B.s(i10);
        yVar.f2451b.f1481s0.b();
        yVar.f2456h = true;
    }

    public final boolean R() {
        RecyclerView recyclerView = this.f2358b;
        return recyclerView != null && recyclerView.hasFocus();
    }

    public boolean R0() {
        return this instanceof androidx.leanback.widget.p;
    }

    public boolean S() {
        return false;
    }

    public void V(int i10) {
        RecyclerView recyclerView = this.f2358b;
        if (recyclerView != null) {
            int I = recyclerView.f1482t.I();
            for (int i11 = 0; i11 < I; i11++) {
                recyclerView.f1482t.H(i11).offsetLeftAndRight(i10);
            }
        }
    }

    public void W(int i10) {
        RecyclerView recyclerView = this.f2358b;
        if (recyclerView != null) {
            int I = recyclerView.f1482t.I();
            for (int i11 = 0; i11 < I; i11++) {
                recyclerView.f1482t.H(i11).offsetTopAndBottom(i10);
            }
        }
    }

    public boolean Y(RecyclerView recyclerView, ArrayList arrayList, int i10, int i11) {
        return false;
    }

    public final void b(View view, int i10, boolean z10) {
        f1 J = RecyclerView.J(view);
        if (z10 || J.i()) {
            p.i iVar = (p.i) this.f2358b.f1484u.f13537p;
            p1 p1Var = (p1) iVar.get(J);
            if (p1Var == null) {
                p1Var = p1.a();
                iVar.put(J, p1Var);
            }
            p1Var.f2386a |= 1;
        } else {
            this.f2358b.f1484u.b0(J);
        }
        p0 p0Var = (p0) view.getLayoutParams();
        if (J.q() || J.j()) {
            if (J.j()) {
                J.f2244n.m(J);
            } else {
                J.f2240j &= -33;
            }
            this.f2357a.z(view, i10, view.getLayoutParams(), false);
        } else {
            if (view.getParent() == this.f2358b) {
                int R = this.f2357a.R(view);
                if (i10 == -1) {
                    i10 = this.f2357a.I();
                }
                if (R == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f2358b.indexOfChild(view) + this.f2358b.z());
                }
                if (R != i10) {
                    o0 o0Var = this.f2358b.B;
                    View w10 = o0Var.w(R);
                    if (w10 == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + R + o0Var.f2358b.toString());
                    }
                    o0Var.w(R);
                    o0Var.f2357a.E(R);
                    p0 p0Var2 = (p0) w10.getLayoutParams();
                    f1 J2 = RecyclerView.J(w10);
                    if (J2.i()) {
                        p.i iVar2 = (p.i) o0Var.f2358b.f1484u.f13537p;
                        p1 p1Var2 = (p1) iVar2.get(J2);
                        if (p1Var2 == null) {
                            p1Var2 = p1.a();
                            iVar2.put(J2, p1Var2);
                        }
                        p1Var2.f2386a = 1 | p1Var2.f2386a;
                    } else {
                        o0Var.f2358b.f1484u.b0(J2);
                    }
                    o0Var.f2357a.z(w10, i10, p0Var2, J2.i());
                }
            } else {
                this.f2357a.x(view, i10, false);
                p0Var.f2383c = true;
                y yVar = this.f2361e;
                if (yVar != null && yVar.f2454e) {
                    yVar.f2451b.getClass();
                    f1 J3 = RecyclerView.J(view);
                    if ((J3 != null ? J3.c() : -1) == yVar.f2450a) {
                        yVar.f2455f = view;
                    }
                }
            }
        }
        if (p0Var.f2384d) {
            J.f2232a.invalidate();
            p0Var.f2384d = false;
        }
    }

    public View b0(View view, int i10, u0 u0Var, b1 b1Var) {
        return null;
    }

    public void c(String str) {
        RecyclerView recyclerView = this.f2358b;
        if (recyclerView != null) {
            recyclerView.i(str);
        }
    }

    public void c0(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f2358b;
        u0 u0Var = recyclerView.f1476q;
        if (accessibilityEvent == null) {
            return;
        }
        boolean z10 = true;
        if (!recyclerView.canScrollVertically(1) && !this.f2358b.canScrollVertically(-1) && !this.f2358b.canScrollHorizontally(-1) && !this.f2358b.canScrollHorizontally(1)) {
            z10 = false;
        }
        accessibilityEvent.setScrollable(z10);
        f0 f0Var = this.f2358b.A;
        if (f0Var != null) {
            accessibilityEvent.setItemCount(f0Var.a());
        }
    }

    public final void d(View view, Rect rect) {
        RecyclerView recyclerView = this.f2358b;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.K(view));
        }
    }

    public void d0(u0 u0Var, b1 b1Var, n0.g gVar) {
        if (this.f2358b.canScrollVertically(-1) || this.f2358b.canScrollHorizontally(-1)) {
            gVar.a(8192);
            gVar.l(true);
        }
        if (this.f2358b.canScrollVertically(1) || this.f2358b.canScrollHorizontally(1)) {
            gVar.a(4096);
            gVar.l(true);
        }
        gVar.f9111a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(P(u0Var, b1Var), z(u0Var, b1Var), false, 0));
    }

    public abstract boolean e();

    public final void e0(View view, n0.g gVar) {
        f1 J = RecyclerView.J(view);
        if (J == null || J.i()) {
            return;
        }
        android.support.v4.media.session.a0 a0Var = this.f2357a;
        if (((ArrayList) a0Var.f232r).contains(J.f2232a)) {
            return;
        }
        RecyclerView recyclerView = this.f2358b;
        f0(recyclerView.f1476q, recyclerView.f1487v0, view, gVar);
    }

    public abstract boolean f();

    public boolean g(p0 p0Var) {
        return p0Var != null;
    }

    public View g0(View view, int i10) {
        return null;
    }

    public int k(b1 b1Var) {
        return 0;
    }

    public int l(b1 b1Var) {
        return 0;
    }

    public int m(b1 b1Var) {
        return 0;
    }

    public void m0(RecyclerView recyclerView, int i10, int i11) {
        l0(i10, i11);
    }

    public int n(b1 b1Var) {
        return 0;
    }

    public abstract void n0(u0 u0Var, b1 b1Var);

    public int o(b1 b1Var) {
        return 0;
    }

    public abstract void o0(b1 b1Var);

    public int p(b1 b1Var) {
        return 0;
    }

    public void p0(u0 u0Var, b1 b1Var, int i10, int i11) {
        this.f2358b.o(i10, i11);
    }

    public final void q(u0 u0Var) {
        for (int x6 = x() - 1; x6 >= 0; x6--) {
            D0(u0Var, x6, w(x6));
        }
    }

    public boolean q0(RecyclerView recyclerView, View view, View view2) {
        y yVar = this.f2361e;
        return (yVar != null && yVar.f2454e) || recyclerView.N();
    }

    public final View r(View view) {
        View B;
        RecyclerView recyclerView = this.f2358b;
        if (recyclerView == null || (B = recyclerView.B(view)) == null || ((ArrayList) this.f2357a.f232r).contains(B)) {
            return null;
        }
        return B;
    }

    public View s(int i10) {
        int x6 = x();
        for (int i11 = 0; i11 < x6; i11++) {
            View w10 = w(i11);
            f1 J = RecyclerView.J(w10);
            if (J != null && J.c() == i10 && !J.p() && (this.f2358b.f1487v0.g || !J.i())) {
                return w10;
            }
        }
        return null;
    }

    public Parcelable s0() {
        return null;
    }

    public abstract p0 t();

    public p0 u(Context context, AttributeSet attributeSet) {
        return new p0(context, attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008e A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean u0(int r4, b4.u0 r5, b4.b1 r6) {
        /*
            r3 = this;
            androidx.recyclerview.widget.RecyclerView r5 = r3.f2358b
            r6 = 0
            if (r5 != 0) goto L7
            goto L90
        L7:
            int r5 = r3.f2370o
            int r0 = r3.f2369n
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            androidx.recyclerview.widget.RecyclerView r2 = r3.f2358b
            android.graphics.Matrix r2 = r2.getMatrix()
            boolean r2 = r2.isIdentity()
            if (r2 == 0) goto L2c
            androidx.recyclerview.widget.RecyclerView r2 = r3.f2358b
            boolean r2 = r2.getGlobalVisibleRect(r1)
            if (r2 == 0) goto L2c
            int r5 = r1.height()
            int r0 = r1.width()
        L2c:
            r1 = 4096(0x1000, float:5.74E-42)
            r2 = 1
            if (r4 == r1) goto L64
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r4 == r1) goto L38
            r4 = r6
            r5 = r4
            goto L8c
        L38:
            androidx.recyclerview.widget.RecyclerView r4 = r3.f2358b
            r1 = -1
            boolean r4 = r4.canScrollVertically(r1)
            if (r4 == 0) goto L4d
            int r4 = r3.M()
            int r5 = r5 - r4
            int r4 = r3.J()
            int r5 = r5 - r4
            int r4 = -r5
            goto L4e
        L4d:
            r4 = r6
        L4e:
            androidx.recyclerview.widget.RecyclerView r5 = r3.f2358b
            boolean r5 = r5.canScrollHorizontally(r1)
            if (r5 == 0) goto L62
            int r5 = r3.K()
            int r0 = r0 - r5
            int r5 = r3.L()
            int r0 = r0 - r5
            int r5 = -r0
            goto L8c
        L62:
            r5 = r6
            goto L8c
        L64:
            androidx.recyclerview.widget.RecyclerView r4 = r3.f2358b
            boolean r4 = r4.canScrollVertically(r2)
            if (r4 == 0) goto L78
            int r4 = r3.M()
            int r5 = r5 - r4
            int r4 = r3.J()
            int r5 = r5 - r4
            r4 = r5
            goto L79
        L78:
            r4 = r6
        L79:
            androidx.recyclerview.widget.RecyclerView r5 = r3.f2358b
            boolean r5 = r5.canScrollHorizontally(r2)
            if (r5 == 0) goto L62
            int r5 = r3.K()
            int r0 = r0 - r5
            int r5 = r3.L()
            int r5 = r0 - r5
        L8c:
            if (r4 != 0) goto L91
            if (r5 != 0) goto L91
        L90:
            return r6
        L91:
            androidx.recyclerview.widget.RecyclerView r6 = r3.f2358b
            r6.g0(r5, r4, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.o0.u0(int, b4.u0, b4.b1):boolean");
    }

    public p0 v(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof p0 ? new p0((p0) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p0((ViewGroup.MarginLayoutParams) layoutParams) : new p0(layoutParams);
    }

    public void v0(u0 u0Var) {
        for (int x6 = x() - 1; x6 >= 0; x6--) {
            if (!RecyclerView.J(w(x6)).p()) {
                y0(x6, u0Var);
            }
        }
    }

    public final View w(int i10) {
        android.support.v4.media.session.a0 a0Var = this.f2357a;
        if (a0Var != null) {
            return a0Var.H(i10);
        }
        return null;
    }

    public final void w0(u0 u0Var) {
        ArrayList arrayList = u0Var.f2423a;
        int size = arrayList.size();
        for (int i10 = size - 1; i10 >= 0; i10--) {
            View view = ((f1) arrayList.get(i10)).f2232a;
            f1 J = RecyclerView.J(view);
            if (!J.p()) {
                J.o(false);
                if (J.k()) {
                    this.f2358b.removeDetachedView(view, false);
                }
                k0 k0Var = this.f2358b.f1462d0;
                if (k0Var != null) {
                    k0Var.d(J);
                }
                J.o(true);
                f1 J2 = RecyclerView.J(view);
                J2.f2244n = null;
                J2.f2245o = false;
                J2.f2240j &= -33;
                u0Var.j(J2);
            }
        }
        arrayList.clear();
        ArrayList arrayList2 = u0Var.f2424b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.f2358b.invalidate();
        }
    }

    public final int x() {
        android.support.v4.media.session.a0 a0Var = this.f2357a;
        if (a0Var != null) {
            return a0Var.I();
        }
        return 0;
    }

    public final void x0(View view, u0 u0Var) {
        android.support.v4.media.session.a0 a0Var = this.f2357a;
        e0 e0Var = (e0) a0Var.f230p;
        int indexOfChild = e0Var.f2214a.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (((c) a0Var.f231q).y(indexOfChild)) {
                a0Var.d0(view);
            }
            e0Var.h(indexOfChild);
        }
        u0Var.i(view);
    }

    public final void y0(int i10, u0 u0Var) {
        View w10 = w(i10);
        z0(i10);
        u0Var.i(w10);
    }

    public int z(u0 u0Var, b1 b1Var) {
        return -1;
    }

    public final void z0(int i10) {
        if (w(i10) != null) {
            android.support.v4.media.session.a0 a0Var = this.f2357a;
            int N = a0Var.N(i10);
            e0 e0Var = (e0) a0Var.f230p;
            View childAt = e0Var.f2214a.getChildAt(N);
            if (childAt == null) {
                return;
            }
            if (((c) a0Var.f231q).y(N)) {
                a0Var.d0(childAt);
            }
            e0Var.h(N);
        }
    }

    public void i0() {
    }

    public void X(f0 f0Var) {
    }

    public void Z(RecyclerView recyclerView) {
    }

    public void a0(RecyclerView recyclerView) {
    }

    public void r0(Parcelable parcelable) {
    }

    public void t0(int i10) {
    }

    public void h0(int i10, int i11) {
    }

    public void j(int i10, p pVar) {
    }

    public void j0(int i10, int i11) {
    }

    public void k0(int i10, int i11) {
    }

    public void l0(int i10, int i11) {
    }

    public void f0(u0 u0Var, b1 b1Var, View view, n0.g gVar) {
    }

    public void i(int i10, int i11, b1 b1Var, p pVar) {
    }
}
