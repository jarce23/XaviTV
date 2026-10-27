package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.support.v4.media.d;
import android.support.v4.media.session.a0;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import b4.a;
import b4.b;
import b4.b1;
import b4.c0;
import b4.c1;
import b4.d0;
import b4.d1;
import b4.e0;
import b4.e1;
import b4.f0;
import b4.f1;
import b4.h0;
import b4.h1;
import b4.i0;
import b4.j0;
import b4.k0;
import b4.l0;
import b4.n;
import b4.o0;
import b4.p;
import b4.p0;
import b4.p1;
import b4.q0;
import b4.r;
import b4.r0;
import b4.s0;
import b4.t0;
import b4.u0;
import b4.v0;
import b4.w0;
import b4.y;
import b4.y0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.j;
import ma.k;
import okhttp3.internal.url._UrlKt;
import p.g;
import p.i;
import s.e;
import x4.c;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup {
    public static final int[] O0 = {R.attr.nestedScrollingEnabled};
    public static final float P0 = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final boolean Q0 = true;
    public static final boolean R0 = true;
    public static final boolean S0 = true;
    public static final Class[] T0;
    public static final d0 U0;
    public static final c1 V0;
    public f0 A;
    public final e0 A0;
    public o0 B;
    public boolean B0;
    public v0 C;
    public h1 C0;
    public final ArrayList D;
    public final int[] D0;
    public final ArrayList E;
    public j E0;
    public final ArrayList F;
    public final int[] F0;
    public n G;
    public final int[] G0;
    public boolean H;
    public final int[] H0;
    public boolean I;
    public final ArrayList I0;
    public boolean J;
    public final c0 J0;
    public int K;
    public boolean K0;
    public boolean L;
    public int L0;
    public boolean M;
    public int M0;
    public boolean N;
    public final e0 N0;
    public int O;
    public boolean P;
    public final AccessibilityManager Q;
    public boolean R;
    public boolean S;
    public int T;
    public int U;
    public i0 V;
    public EdgeEffect W;

    /* renamed from: a0, reason: collision with root package name */
    public EdgeEffect f1459a0;

    /* renamed from: b0, reason: collision with root package name */
    public EdgeEffect f1460b0;

    /* renamed from: c0, reason: collision with root package name */
    public EdgeEffect f1461c0;

    /* renamed from: d0, reason: collision with root package name */
    public k0 f1462d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f1463e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f1464f0;

    /* renamed from: g0, reason: collision with root package name */
    public VelocityTracker f1465g0;
    public int h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f1466i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f1467j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f1468k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f1469l0;

    /* renamed from: m0, reason: collision with root package name */
    public q0 f1470m0;

    /* renamed from: n0, reason: collision with root package name */
    public final int f1471n0;

    /* renamed from: o, reason: collision with root package name */
    public final float f1472o;

    /* renamed from: o0, reason: collision with root package name */
    public final int f1473o0;

    /* renamed from: p, reason: collision with root package name */
    public final w0 f1474p;

    /* renamed from: p0, reason: collision with root package name */
    public final float f1475p0;

    /* renamed from: q, reason: collision with root package name */
    public final u0 f1476q;

    /* renamed from: q0, reason: collision with root package name */
    public final float f1477q0;

    /* renamed from: r, reason: collision with root package name */
    public y0 f1478r;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f1479r0;

    /* renamed from: s, reason: collision with root package name */
    public final b f1480s;

    /* renamed from: s0, reason: collision with root package name */
    public final e1 f1481s0;

    /* renamed from: t, reason: collision with root package name */
    public final a0 f1482t;

    /* renamed from: t0, reason: collision with root package name */
    public r f1483t0;

    /* renamed from: u, reason: collision with root package name */
    public final c f1484u;

    /* renamed from: u0, reason: collision with root package name */
    public final p f1485u0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1486v;

    /* renamed from: v0, reason: collision with root package name */
    public final b1 f1487v0;

    /* renamed from: w, reason: collision with root package name */
    public final c0 f1488w;

    /* renamed from: w0, reason: collision with root package name */
    public r0 f1489w0;

    /* renamed from: x, reason: collision with root package name */
    public final Rect f1490x;

    /* renamed from: x0, reason: collision with root package name */
    public ArrayList f1491x0;

    /* renamed from: y, reason: collision with root package name */
    public final Rect f1492y;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f1493y0;

    /* renamed from: z, reason: collision with root package name */
    public final RectF f1494z;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f1495z0;

    static {
        Class cls = Integer.TYPE;
        T0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        U0 = new d0(0);
        V0 = new c1();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, org.chromium.net.R.attr.recyclerViewStyle);
    }

    public static RecyclerView E(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView E = E(viewGroup.getChildAt(i10));
            if (E != null) {
                return E;
            }
        }
        return null;
    }

    public static f1 J(View view) {
        if (view == null) {
            return null;
        }
        return ((p0) view.getLayoutParams()).f2381a;
    }

    private j getScrollingChildHelper() {
        if (this.E0 == null) {
            this.E0 = new j(this);
        }
        return this.E0;
    }

    public static void j(f1 f1Var) {
        WeakReference weakReference = f1Var.f2233b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == f1Var.f2232a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            f1Var.f2233b = null;
        }
    }

    public static int m(int i10, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i11) {
        if (i10 > 0 && edgeEffect != null && com.bumptech.glide.c.l(edgeEffect) != 0.0f) {
            int round = Math.round(com.bumptech.glide.c.r(edgeEffect, ((-i10) * 4.0f) / i11, 0.5f) * ((-i11) / 4.0f));
            if (round != i10) {
                edgeEffect.finish();
            }
            return i10 - round;
        }
        if (i10 >= 0 || edgeEffect2 == null || com.bumptech.glide.c.l(edgeEffect2) == 0.0f) {
            return i10;
        }
        float f10 = i11;
        int round2 = Math.round(com.bumptech.glide.c.r(edgeEffect2, (i10 * 4.0f) / f10, 0.5f) * (f10 / 4.0f));
        if (round2 != i10) {
            edgeEffect2.finish();
        }
        return i10 - round2;
    }

    public final void A(b1 b1Var) {
        if (getScrollState() != 2) {
            b1Var.f2198o = 0;
            b1Var.f2199p = 0;
        } else {
            OverScroller overScroller = this.f1481s0.f2217q;
            b1Var.f2198o = overScroller.getFinalX() - overScroller.getCurrX();
            b1Var.f2199p = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View B(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            return r3
        L17:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.B(android.view.View):android.view.View");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getAction()
            java.util.ArrayList r1 = r11.F
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        Lc:
            if (r4 >= r2) goto L64
            java.lang.Object r5 = r1.get(r4)
            b4.n r5 = (b4.n) r5
            int r6 = r5.f2341v
            r7 = 1
            r8 = 2
            if (r6 != r7) goto L59
            float r6 = r12.getX()
            float r9 = r12.getY()
            boolean r6 = r5.d(r6, r9)
            float r9 = r12.getX()
            float r10 = r12.getY()
            boolean r9 = r5.c(r9, r10)
            int r10 = r12.getAction()
            if (r10 != 0) goto L61
            if (r6 != 0) goto L3c
            if (r9 == 0) goto L61
        L3c:
            if (r9 == 0) goto L49
            r5.f2342w = r7
            float r6 = r12.getX()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.f2335p = r6
            goto L55
        L49:
            if (r6 == 0) goto L55
            r5.f2342w = r8
            float r6 = r12.getY()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.f2332m = r6
        L55:
            r5.f(r8)
            goto L5b
        L59:
            if (r6 != r8) goto L61
        L5b:
            r6 = 3
            if (r0 == r6) goto L61
            r11.G = r5
            return r7
        L61:
            int r4 = r4 + 1
            goto Lc
        L64:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C(android.view.MotionEvent):boolean");
    }

    public final void D(int[] iArr) {
        int I = this.f1482t.I();
        if (I == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < I; i12++) {
            f1 J = J(this.f1482t.H(i12));
            if (!J.p()) {
                int c10 = J.c();
                if (c10 < i10) {
                    i10 = c10;
                }
                if (c10 > i11) {
                    i11 = c10;
                }
            }
        }
        iArr[0] = i10;
        iArr[1] = i11;
    }

    public final f1 F(int i10) {
        f1 f1Var = null;
        if (this.R) {
            return null;
        }
        int P = this.f1482t.P();
        for (int i11 = 0; i11 < P; i11++) {
            f1 J = J(this.f1482t.O(i11));
            if (J != null && !J.i() && G(J) == i10) {
                if (!((ArrayList) this.f1482t.f232r).contains(J.f2232a)) {
                    return J;
                }
                f1Var = J;
            }
        }
        return f1Var;
    }

    public final int G(f1 f1Var) {
        if ((f1Var.f2240j & 524) == 0 && f1Var.f()) {
            int i10 = f1Var.f2234c;
            ArrayList arrayList = (ArrayList) this.f1480s.f2177c;
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = (a) arrayList.get(i11);
                int i12 = aVar.f2169a;
                if (i12 != 1) {
                    if (i12 == 2) {
                        int i13 = aVar.f2170b;
                        if (i13 <= i10) {
                            int i14 = aVar.f2172d;
                            if (i13 + i14 <= i10) {
                                i10 -= i14;
                            }
                        } else {
                            continue;
                        }
                    } else if (i12 == 8) {
                        int i15 = aVar.f2170b;
                        if (i15 == i10) {
                            i10 = aVar.f2172d;
                        } else {
                            if (i15 < i10) {
                                i10--;
                            }
                            if (aVar.f2172d <= i10) {
                                i10++;
                            }
                        }
                    }
                } else if (aVar.f2170b <= i10) {
                    i10 += aVar.f2172d;
                }
            }
            return i10;
        }
        return -1;
    }

    public final long H(f1 f1Var) {
        return this.A.f2229b ? f1Var.f2236e : f1Var.f2234c;
    }

    public final f1 I(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return J(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect K(View view) {
        p0 p0Var = (p0) view.getLayoutParams();
        boolean z10 = p0Var.f2383c;
        Rect rect = p0Var.f2382b;
        if (!z10 || (this.f1487v0.g && (p0Var.f2381a.l() || p0Var.f2381a.g()))) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.E;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Rect rect2 = this.f1490x;
            rect2.set(0, 0, 0, 0);
            ((l0) arrayList.get(i10)).getClass();
            ((p0) view.getLayoutParams()).f2381a.getClass();
            rect2.set(0, 0, 0, 0);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        p0Var.f2383c = false;
        return rect;
    }

    public final boolean L() {
        return !this.J || this.R || this.f1480s.l();
    }

    public boolean M() {
        return isChildrenDrawingOrderEnabled();
    }

    public final boolean N() {
        return this.T > 0;
    }

    public final void O(int i10) {
        if (this.B == null) {
            return;
        }
        setScrollState(2);
        this.B.F0(i10);
        awakenScrollBars();
    }

    public final void P() {
        int P = this.f1482t.P();
        for (int i10 = 0; i10 < P; i10++) {
            ((p0) this.f1482t.O(i10).getLayoutParams()).f2383c = true;
        }
        ArrayList arrayList = this.f1476q.f2425c;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            p0 p0Var = (p0) ((f1) arrayList.get(i11)).f2232a.getLayoutParams();
            if (p0Var != null) {
                p0Var.f2383c = true;
            }
        }
    }

    public final void Q(int i10, int i11, boolean z10) {
        int i12 = i10 + i11;
        int P = this.f1482t.P();
        for (int i13 = 0; i13 < P; i13++) {
            f1 J = J(this.f1482t.O(i13));
            if (J != null && !J.p()) {
                int i14 = J.f2234c;
                b1 b1Var = this.f1487v0;
                if (i14 >= i12) {
                    J.m(-i11, z10);
                    b1Var.f2190f = true;
                } else if (i14 >= i10) {
                    J.a(8);
                    J.m(-i11, z10);
                    J.f2234c = i10 - 1;
                    b1Var.f2190f = true;
                }
            }
        }
        u0 u0Var = this.f1476q;
        ArrayList arrayList = u0Var.f2425c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            f1 f1Var = (f1) arrayList.get(size);
            if (f1Var != null) {
                int i15 = f1Var.f2234c;
                if (i15 >= i12) {
                    f1Var.m(-i11, z10);
                } else if (i15 >= i10) {
                    f1Var.a(8);
                    u0Var.h(size);
                }
            }
        }
        requestLayout();
    }

    public final void R() {
        this.T++;
    }

    public final void S(boolean z10) {
        int i10;
        AccessibilityManager accessibilityManager;
        int i11 = this.T - 1;
        this.T = i11;
        if (i11 < 1) {
            this.T = 0;
            if (z10) {
                int i12 = this.O;
                this.O = 0;
                if (i12 != 0 && (accessibilityManager = this.Q) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    obtain.setEventType(2048);
                    obtain.setContentChangeTypes(i12);
                    sendAccessibilityEventUnchecked(obtain);
                }
                ArrayList arrayList = this.I0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    f1 f1Var = (f1) arrayList.get(size);
                    if (f1Var.f2232a.getParent() == this && !f1Var.p() && (i10 = f1Var.f2247q) != -1) {
                        View view = f1Var.f2232a;
                        WeakHashMap weakHashMap = m0.k0.f8683a;
                        view.setImportantForAccessibility(i10);
                        f1Var.f2247q = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void T(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1464f0) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f1464f0 = motionEvent.getPointerId(i10);
            int x6 = (int) (motionEvent.getX(i10) + 0.5f);
            this.f1467j0 = x6;
            this.h0 = x6;
            int y8 = (int) (motionEvent.getY(i10) + 0.5f);
            this.f1468k0 = y8;
            this.f1466i0 = y8;
        }
    }

    public final void U() {
        if (this.B0 || !this.H) {
            return;
        }
        WeakHashMap weakHashMap = m0.k0.f8683a;
        postOnAnimation(this.J0);
        this.B0 = true;
    }

    public final void V() {
        boolean z10;
        boolean z11 = false;
        if (this.R) {
            b bVar = this.f1480s;
            bVar.s((ArrayList) bVar.f2177c);
            bVar.s((ArrayList) bVar.f2178d);
            bVar.f2175a = 0;
            if (this.S) {
                this.B.i0();
            }
        }
        if (this.f1462d0 == null || !this.B.R0()) {
            this.f1480s.e();
        } else {
            this.f1480s.r();
        }
        boolean z12 = this.f1493y0 || this.f1495z0;
        boolean z13 = this.J && this.f1462d0 != null && ((z10 = this.R) || z12 || this.B.f2362f) && (!z10 || this.A.f2229b);
        b1 b1Var = this.f1487v0;
        b1Var.f2193j = z13;
        if (z13 && z12 && !this.R && this.f1462d0 != null && this.B.R0()) {
            z11 = true;
        }
        b1Var.f2194k = z11;
    }

    public final void W(boolean z10) {
        this.S = z10 | this.S;
        this.R = true;
        int P = this.f1482t.P();
        for (int i10 = 0; i10 < P; i10++) {
            f1 J = J(this.f1482t.O(i10));
            if (J != null && !J.p()) {
                J.a(6);
            }
        }
        P();
        u0 u0Var = this.f1476q;
        ArrayList arrayList = u0Var.f2425c;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            f1 f1Var = (f1) arrayList.get(i11);
            if (f1Var != null) {
                f1Var.a(6);
                f1Var.a(1024);
            }
        }
        f0 f0Var = u0Var.f2429h.A;
        if (f0Var == null || !f0Var.f2229b) {
            u0Var.g();
        }
    }

    public final void X(f1 f1Var, j0 j0Var) {
        f1Var.f2240j &= -8193;
        boolean z10 = this.f1487v0.f2191h;
        c cVar = this.f1484u;
        if (z10 && f1Var.l() && !f1Var.i() && !f1Var.p()) {
            ((g) cVar.f13538q).g(H(f1Var), f1Var);
        }
        i iVar = (i) cVar.f13537p;
        p1 p1Var = (p1) iVar.get(f1Var);
        if (p1Var == null) {
            p1Var = p1.a();
            iVar.put(f1Var, p1Var);
        }
        p1Var.f2387b = j0Var;
        p1Var.f2386a |= 4;
    }

    public final int Y(int i10, float f10) {
        float height = f10 / getHeight();
        float width = i10 / getWidth();
        EdgeEffect edgeEffect = this.W;
        float f11 = 0.0f;
        if (edgeEffect == null || com.bumptech.glide.c.l(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.f1460b0;
            if (edgeEffect2 != null && com.bumptech.glide.c.l(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.f1460b0.onRelease();
                } else {
                    float r2 = com.bumptech.glide.c.r(this.f1460b0, width, height);
                    if (com.bumptech.glide.c.l(this.f1460b0) == 0.0f) {
                        this.f1460b0.onRelease();
                    }
                    f11 = r2;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.W.onRelease();
            } else {
                float f12 = -com.bumptech.glide.c.r(this.W, -width, 1.0f - height);
                if (com.bumptech.glide.c.l(this.W) == 0.0f) {
                    this.W.onRelease();
                }
                f11 = f12;
            }
            invalidate();
        }
        return Math.round(f11 * getWidth());
    }

    public final int Z(int i10, float f10) {
        float width = f10 / getWidth();
        float height = i10 / getHeight();
        EdgeEffect edgeEffect = this.f1459a0;
        float f11 = 0.0f;
        if (edgeEffect == null || com.bumptech.glide.c.l(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.f1461c0;
            if (edgeEffect2 != null && com.bumptech.glide.c.l(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.f1461c0.onRelease();
                } else {
                    float r2 = com.bumptech.glide.c.r(this.f1461c0, height, 1.0f - width);
                    if (com.bumptech.glide.c.l(this.f1461c0) == 0.0f) {
                        this.f1461c0.onRelease();
                    }
                    f11 = r2;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.f1459a0.onRelease();
            } else {
                float f12 = -com.bumptech.glide.c.r(this.f1459a0, -height, width);
                if (com.bumptech.glide.c.l(this.f1459a0) == 0.0f) {
                    this.f1459a0.onRelease();
                }
                f11 = f12;
            }
            invalidate();
        }
        return Math.round(f11 * getHeight());
    }

    public final void a0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f1490x;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p0) {
            p0 p0Var = (p0) layoutParams;
            if (!p0Var.f2383c) {
                Rect rect2 = p0Var.f2382b;
                rect.left -= rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.B.B0(this, view, this.f1490x, !this.J, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i10, int i11) {
        o0 o0Var = this.B;
        if (o0Var == null || !o0Var.Y(this, arrayList, i10, i11)) {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    public final void b0() {
        VelocityTracker velocityTracker = this.f1465g0;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z10 = false;
        k0(0);
        EdgeEffect edgeEffect = this.W;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z10 = this.W.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f1459a0;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z10 |= this.f1459a0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f1460b0;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z10 |= this.f1460b0.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1461c0;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z10 |= this.f1461c0.isFinished();
        }
        if (z10) {
            WeakHashMap weakHashMap = m0.k0.f8683a;
            postInvalidateOnAnimation();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c0(int r18, int r19, android.view.MotionEvent r20, int r21) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.c0(int, int, android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p0) && this.B.g((p0) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        o0 o0Var = this.B;
        if (o0Var != null && o0Var.e()) {
            return this.B.k(this.f1487v0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        o0 o0Var = this.B;
        if (o0Var != null && o0Var.e()) {
            return this.B.l(this.f1487v0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        o0 o0Var = this.B;
        if (o0Var != null && o0Var.e()) {
            return this.B.m(this.f1487v0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        o0 o0Var = this.B;
        if (o0Var != null && o0Var.f()) {
            return this.B.n(this.f1487v0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        o0 o0Var = this.B;
        if (o0Var != null && o0Var.f()) {
            return this.B.o(this.f1487v0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        o0 o0Var = this.B;
        if (o0Var != null && o0Var.f()) {
            return this.B.p(this.f1487v0);
        }
        return 0;
    }

    public final void d0(int i10, int i11, int[] iArr) {
        f1 f1Var;
        i0();
        R();
        int i12 = i0.j.f5790a;
        Trace.beginSection("RV Scroll");
        b1 b1Var = this.f1487v0;
        A(b1Var);
        u0 u0Var = this.f1476q;
        int E0 = i10 != 0 ? this.B.E0(i10, u0Var, b1Var) : 0;
        int G0 = i11 != 0 ? this.B.G0(i11, u0Var, b1Var) : 0;
        Trace.endSection();
        a0 a0Var = this.f1482t;
        int I = a0Var.I();
        for (int i13 = 0; i13 < I; i13++) {
            View H = a0Var.H(i13);
            f1 I2 = I(H);
            if (I2 != null && (f1Var = I2.f2239i) != null) {
                View view = f1Var.f2232a;
                int left = H.getLeft();
                int top = H.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        S(true);
        j0(false);
        if (iArr != null) {
            iArr[0] = E0;
            iArr[1] = G0;
        }
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return getScrollingChildHelper().a(f10, f11, z10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f10, float f11) {
        return getScrollingChildHelper().b(f10, f11);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i10, i11, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return getScrollingChildHelper().d(i10, i11, i12, i13, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z10;
        super.draw(canvas);
        ArrayList arrayList = this.E;
        int size = arrayList.size();
        boolean z11 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ((l0) arrayList.get(i10)).b(canvas, this);
        }
        EdgeEffect edgeEffect = this.W;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f1486v ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.W;
            z10 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.f1459a0;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f1486v) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f1459a0;
            z10 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.f1460b0;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f1486v ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f1460b0;
            z10 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.f1461c0;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f1486v) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f1461c0;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(save4);
        }
        if ((z10 || this.f1462d0 == null || arrayList.size() <= 0 || !this.f1462d0.f()) ? z10 : true) {
            WeakHashMap weakHashMap = m0.k0.f8683a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    public void e0(int i10) {
        if (this.M) {
            return;
        }
        l0();
        o0 o0Var = this.B;
        if (o0Var == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            o0Var.F0(i10);
            awakenScrollBars();
        }
    }

    public final void f(f1 f1Var) {
        View view = f1Var.f2232a;
        boolean z10 = view.getParent() == this;
        this.f1476q.m(I(view));
        if (f1Var.k()) {
            this.f1482t.z(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z10) {
            this.f1482t.x(view, -1, true);
            return;
        }
        a0 a0Var = this.f1482t;
        int indexOfChild = ((e0) a0Var.f230p).f2214a.indexOfChild(view);
        if (indexOfChild >= 0) {
            ((b4.c) a0Var.f231q).A(indexOfChild);
            a0Var.Q(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final boolean f0(EdgeEffect edgeEffect, int i10, int i11) {
        if (i10 > 0) {
            return true;
        }
        float l10 = com.bumptech.glide.c.l(edgeEffect) * i11;
        float abs = Math.abs(-i10) * 0.35f;
        float f10 = this.f1472o * 0.015f;
        double log = Math.log(abs / f10);
        double d6 = P0;
        return ((float) (Math.exp((d6 / (d6 - 1.0d)) * log) * ((double) f10))) < l10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0184, code lost:
    
        if (r5 > 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0187, code lost:
    
        if (r7 < 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x018a, code lost:
    
        if (r5 < 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0192, code lost:
    
        if ((r5 * r6) <= 0) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x019a, code lost:
    
        if ((r5 * r6) >= 0) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0164, code lost:
    
        if (r7 > 0) goto L139;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00df  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r17, int r18) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g(l0 l0Var) {
        o0 o0Var = this.B;
        if (o0Var != null) {
            o0Var.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.E;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(l0Var);
        P();
        requestLayout();
    }

    public final void g0(int i10, int i11, boolean z10) {
        o0 o0Var = this.B;
        if (o0Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.M) {
            return;
        }
        if (!o0Var.e()) {
            i10 = 0;
        }
        if (!this.B.f()) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        if (z10) {
            int i12 = i10 != 0 ? 1 : 0;
            if (i11 != 0) {
                i12 |= 2;
            }
            getScrollingChildHelper().g(i12, 1);
        }
        this.f1481s0.c(i10, i11, Integer.MIN_VALUE, null);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o0 o0Var = this.B;
        if (o0Var != null) {
            return o0Var.t();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + z());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o0 o0Var = this.B;
        if (o0Var != null) {
            return o0Var.u(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + z());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public f0 getAdapter() {
        return this.A;
    }

    @Override // android.view.View
    public int getBaseline() {
        o0 o0Var = this.B;
        if (o0Var == null) {
            return super.getBaseline();
        }
        o0Var.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        return super.getChildDrawingOrder(i10, i11);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f1486v;
    }

    public h1 getCompatAccessibilityDelegate() {
        return this.C0;
    }

    public i0 getEdgeEffectFactory() {
        return this.V;
    }

    public k0 getItemAnimator() {
        return this.f1462d0;
    }

    public int getItemDecorationCount() {
        return this.E.size();
    }

    public o0 getLayoutManager() {
        return this.B;
    }

    public int getMaxFlingVelocity() {
        return this.f1473o0;
    }

    public int getMinFlingVelocity() {
        return this.f1471n0;
    }

    public long getNanoTime() {
        if (S0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public q0 getOnFlingListener() {
        return this.f1470m0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f1479r0;
    }

    public t0 getRecycledViewPool() {
        return this.f1476q.c();
    }

    public int getScrollState() {
        return this.f1463e0;
    }

    public final void h(r0 r0Var) {
        if (this.f1491x0 == null) {
            this.f1491x0 = new ArrayList();
        }
        this.f1491x0.add(r0Var);
    }

    public void h0(int i10) {
        if (this.M) {
            return;
        }
        o0 o0Var = this.B;
        if (o0Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            o0Var.P0(this, i10);
        }
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    public final void i(String str) {
        if (N()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + z());
        }
        if (this.U > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(_UrlKt.FRAGMENT_ENCODE_SET + z()));
        }
    }

    public final void i0() {
        int i10 = this.K + 1;
        this.K = i10;
        if (i10 != 1 || this.M) {
            return;
        }
        this.L = false;
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.H;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.M;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f8674d;
    }

    public final void j0(boolean z10) {
        if (this.K < 1) {
            this.K = 1;
        }
        if (!z10 && !this.M) {
            this.L = false;
        }
        if (this.K == 1) {
            if (z10 && this.L && !this.M && this.B != null && this.A != null) {
                p();
            }
            if (!this.M) {
                this.L = false;
            }
        }
        this.K--;
    }

    public final void k() {
        int P = this.f1482t.P();
        for (int i10 = 0; i10 < P; i10++) {
            f1 J = J(this.f1482t.O(i10));
            if (!J.p()) {
                J.f2235d = -1;
                J.g = -1;
            }
        }
        u0 u0Var = this.f1476q;
        ArrayList arrayList = u0Var.f2423a;
        ArrayList arrayList2 = u0Var.f2425c;
        int size = arrayList2.size();
        for (int i11 = 0; i11 < size; i11++) {
            f1 f1Var = (f1) arrayList2.get(i11);
            f1Var.f2235d = -1;
            f1Var.g = -1;
        }
        int size2 = arrayList.size();
        for (int i12 = 0; i12 < size2; i12++) {
            f1 f1Var2 = (f1) arrayList.get(i12);
            f1Var2.f2235d = -1;
            f1Var2.g = -1;
        }
        ArrayList arrayList3 = u0Var.f2424b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i13 = 0; i13 < size3; i13++) {
                f1 f1Var3 = (f1) u0Var.f2424b.get(i13);
                f1Var3.f2235d = -1;
                f1Var3.g = -1;
            }
        }
    }

    public final void k0(int i10) {
        getScrollingChildHelper().h(i10);
    }

    public final void l(int i10, int i11) {
        boolean z10;
        EdgeEffect edgeEffect = this.W;
        if (edgeEffect == null || edgeEffect.isFinished() || i10 <= 0) {
            z10 = false;
        } else {
            this.W.onRelease();
            z10 = this.W.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f1460b0;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i10 < 0) {
            this.f1460b0.onRelease();
            z10 |= this.f1460b0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f1459a0;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i11 > 0) {
            this.f1459a0.onRelease();
            z10 |= this.f1459a0.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1461c0;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i11 < 0) {
            this.f1461c0.onRelease();
            z10 |= this.f1461c0.isFinished();
        }
        if (z10) {
            WeakHashMap weakHashMap = m0.k0.f8683a;
            postInvalidateOnAnimation();
        }
    }

    public final void l0() {
        y yVar;
        setScrollState(0);
        e1 e1Var = this.f1481s0;
        e1Var.f2221u.removeCallbacks(e1Var);
        e1Var.f2217q.abortAnimation();
        o0 o0Var = this.B;
        if (o0Var == null || (yVar = o0Var.f2361e) == null) {
            return;
        }
        yVar.j();
    }

    public final void n() {
        if (!this.J || this.R) {
            int i10 = i0.j.f5790a;
            Trace.beginSection("RV FullInvalidate");
            p();
            Trace.endSection();
            return;
        }
        b bVar = this.f1480s;
        if (bVar.l()) {
            int i11 = bVar.f2175a;
            if ((i11 & 4) == 0 || (i11 & 11) != 0) {
                if (bVar.l()) {
                    int i12 = i0.j.f5790a;
                    Trace.beginSection("RV FullInvalidate");
                    p();
                    Trace.endSection();
                    return;
                }
                return;
            }
            int i13 = i0.j.f5790a;
            Trace.beginSection("RV PartialInvalidate");
            i0();
            R();
            bVar.r();
            if (!this.L) {
                a0 a0Var = this.f1482t;
                int I = a0Var.I();
                int i14 = 0;
                while (true) {
                    if (i14 < I) {
                        f1 J = J(a0Var.H(i14));
                        if (J != null && !J.p() && J.l()) {
                            p();
                            break;
                        }
                        i14++;
                    } else {
                        bVar.d();
                        break;
                    }
                }
            }
            j0(true);
            S(true);
            Trace.endSection();
        }
    }

    public final void o(int i10, int i11) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = m0.k0.f8683a;
        setMeasuredDimension(o0.h(i10, paddingRight, getMinimumWidth()), o0.h(i11, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        if (r1 >= 30.0f) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.T = r0
            r1 = 1
            r5.H = r1
            boolean r2 = r5.J
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = r1
            goto L16
        L15:
            r2 = r0
        L16:
            r5.J = r2
            b4.u0 r2 = r5.f1476q
            r2.e()
            b4.o0 r2 = r5.B
            if (r2 == 0) goto L26
            r2.g = r1
            r2.Z(r5)
        L26:
            r5.B0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.S0
            if (r0 == 0) goto L7b
            java.lang.ThreadLocal r0 = b4.r.f2394s
            java.lang.Object r1 = r0.get()
            b4.r r1 = (b4.r) r1
            r5.f1483t0 = r1
            if (r1 != 0) goto L74
            b4.r r1 = new b4.r
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f2396o = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f2399r = r2
            r5.f1483t0 = r1
            java.util.WeakHashMap r1 = m0.k0.f8683a
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L66
            if (r1 == 0) goto L66
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L66
            goto L68
        L66:
            r1 = 1114636288(0x42700000, float:60.0)
        L68:
            b4.r r2 = r5.f1483t0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f2398q = r3
            r0.set(r2)
        L74:
            b4.r r0 = r5.f1483t0
            java.util.ArrayList r0 = r0.f2396o
            r0.add(r5)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        r rVar;
        super.onDetachedFromWindow();
        k0 k0Var = this.f1462d0;
        if (k0Var != null) {
            k0Var.e();
        }
        l0();
        int i10 = 0;
        this.H = false;
        o0 o0Var = this.B;
        if (o0Var != null) {
            o0Var.g = false;
            o0Var.a0(this);
        }
        this.I0.clear();
        removeCallbacks(this.J0);
        this.f1484u.getClass();
        while (p1.f2385d.v() != null) {
        }
        u0 u0Var = this.f1476q;
        ArrayList arrayList = u0Var.f2425c;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            j1.c.d(((f1) arrayList.get(i11)).f2232a);
        }
        u0Var.f(u0Var.f2429h.A, false);
        while (i10 < getChildCount()) {
            int i12 = i10 + 1;
            View childAt = getChildAt(i10);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            q0.a aVar = (q0.a) childAt.getTag(org.chromium.net.R.id.pooling_container_listener_holder_tag);
            if (aVar == null) {
                aVar = new q0.a();
                childAt.setTag(org.chromium.net.R.id.pooling_container_listener_holder_tag, aVar);
            }
            ArrayList arrayList2 = aVar.f10218a;
            int w10 = k.w(arrayList2);
            if (-1 < w10) {
                throw d.k(w10, arrayList2);
            }
            i10 = i12;
        }
        if (!S0 || (rVar = this.f1483t0) == null) {
            return;
        }
        rVar.f2396o.remove(this);
        this.f1483t0 = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.E;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((l0) arrayList.get(i10)).a(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        if (!this.M) {
            this.G = null;
            if (C(motionEvent)) {
                b0();
                setScrollState(0);
                return true;
            }
            o0 o0Var = this.B;
            if (o0Var != null) {
                boolean e7 = o0Var.e();
                boolean f10 = this.B.f();
                if (this.f1465g0 == null) {
                    this.f1465g0 = VelocityTracker.obtain();
                }
                this.f1465g0.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.N) {
                        this.N = false;
                    }
                    this.f1464f0 = motionEvent.getPointerId(0);
                    int x6 = (int) (motionEvent.getX() + 0.5f);
                    this.f1467j0 = x6;
                    this.h0 = x6;
                    int y8 = (int) (motionEvent.getY() + 0.5f);
                    this.f1468k0 = y8;
                    this.f1466i0 = y8;
                    EdgeEffect edgeEffect = this.W;
                    if (edgeEffect == null || com.bumptech.glide.c.l(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                        z10 = false;
                    } else {
                        com.bumptech.glide.c.r(this.W, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
                        z10 = true;
                    }
                    EdgeEffect edgeEffect2 = this.f1460b0;
                    boolean z12 = z10;
                    if (edgeEffect2 != null) {
                        z12 = z10;
                        if (com.bumptech.glide.c.l(edgeEffect2) != 0.0f) {
                            z12 = z10;
                            if (!canScrollHorizontally(1)) {
                                com.bumptech.glide.c.r(this.f1460b0, 0.0f, motionEvent.getY() / getHeight());
                                z12 = true;
                            }
                        }
                    }
                    EdgeEffect edgeEffect3 = this.f1459a0;
                    boolean z13 = z12;
                    if (edgeEffect3 != null) {
                        z13 = z12;
                        if (com.bumptech.glide.c.l(edgeEffect3) != 0.0f) {
                            z13 = z12;
                            if (!canScrollVertically(-1)) {
                                com.bumptech.glide.c.r(this.f1459a0, 0.0f, motionEvent.getX() / getWidth());
                                z13 = true;
                            }
                        }
                    }
                    EdgeEffect edgeEffect4 = this.f1461c0;
                    boolean z14 = z13;
                    if (edgeEffect4 != null) {
                        z14 = z13;
                        if (com.bumptech.glide.c.l(edgeEffect4) != 0.0f) {
                            z14 = z13;
                            if (!canScrollVertically(1)) {
                                com.bumptech.glide.c.r(this.f1461c0, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
                                z14 = true;
                            }
                        }
                    }
                    if (z14 || this.f1463e0 == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        k0(1);
                    }
                    int[] iArr = this.G0;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i10 = e7;
                    if (f10) {
                        i10 = (e7 ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().g(i10, 0);
                } else if (actionMasked == 1) {
                    this.f1465g0.clear();
                    k0(0);
                } else if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f1464f0);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f1464f0 + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x10 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y10 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.f1463e0 != 1) {
                        int i11 = x10 - this.h0;
                        int i12 = y10 - this.f1466i0;
                        if (e7 == 0 || Math.abs(i11) <= this.f1469l0) {
                            z11 = false;
                        } else {
                            this.f1467j0 = x10;
                            z11 = true;
                        }
                        if (f10 && Math.abs(i12) > this.f1469l0) {
                            this.f1468k0 = y10;
                            z11 = true;
                        }
                        if (z11) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    b0();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.f1464f0 = motionEvent.getPointerId(actionIndex);
                    int x11 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.f1467j0 = x11;
                    this.h0 = x11;
                    int y11 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.f1468k0 = y11;
                    this.f1466i0 = y11;
                } else if (actionMasked == 6) {
                    T(motionEvent);
                }
                if (this.f1463e0 == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14 = i0.j.f5790a;
        Trace.beginSection("RV OnLayout");
        p();
        Trace.endSection();
        this.J = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        o0 o0Var = this.B;
        if (o0Var == null) {
            o(i10, i11);
            return;
        }
        boolean S = o0Var.S();
        u0 u0Var = this.f1476q;
        boolean z10 = false;
        b1 b1Var = this.f1487v0;
        if (S) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.B.p0(u0Var, b1Var, i10, i11);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            this.K0 = z10;
            if (z10 || this.A == null) {
                return;
            }
            if (b1Var.f2188d == 1) {
                q();
            }
            this.B.I0(i10, i11);
            b1Var.f2192i = true;
            r();
            this.B.K0(i10, i11);
            if (this.B.N0()) {
                this.B.I0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                b1Var.f2192i = true;
                r();
                this.B.K0(i10, i11);
            }
            this.L0 = getMeasuredWidth();
            this.M0 = getMeasuredHeight();
            return;
        }
        if (this.I) {
            this.B.p0(u0Var, b1Var, i10, i11);
            return;
        }
        if (this.P) {
            i0();
            R();
            V();
            S(true);
            if (b1Var.f2194k) {
                b1Var.g = true;
            } else {
                this.f1480s.e();
                b1Var.g = false;
            }
            this.P = false;
            j0(false);
        } else if (b1Var.f2194k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        f0 f0Var = this.A;
        if (f0Var != null) {
            b1Var.f2189e = f0Var.a();
        } else {
            b1Var.f2189e = 0;
        }
        i0();
        this.B.p0(u0Var, b1Var, i10, i11);
        j0(false);
        b1Var.g = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (N()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof y0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y0 y0Var = (y0) parcelable;
        this.f1478r = y0Var;
        super.onRestoreInstanceState(y0Var.f10407o);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        y0 y0Var = new y0(super.onSaveInstanceState());
        y0 y0Var2 = this.f1478r;
        if (y0Var2 != null) {
            y0Var.f2465q = y0Var2.f2465q;
            return y0Var;
        }
        o0 o0Var = this.B;
        if (o0Var != null) {
            y0Var.f2465q = o0Var.s0();
            return y0Var;
        }
        y0Var.f2465q = null;
        return y0Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 == i12 && i11 == i13) {
            return;
        }
        this.f1461c0 = null;
        this.f1459a0 = null;
        this.f1460b0 = null;
        this.W = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x03ac, code lost:
    
        if (r3 == 0) goto L306;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x04cc, code lost:
    
        if (r2 < r5) goto L239;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0390 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0211  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r25) {
        /*
            Method dump skipped, instructions count: 1343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x0356, code lost:
    
        if (((java.util.ArrayList) r21.f1482t.f232r).contains(getFocusedChild()) == false) goto L225;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0402  */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [int] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            Method dump skipped, instructions count: 1056
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x009e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0082 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q() {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.q():void");
    }

    public final void r() {
        i0();
        R();
        b1 b1Var = this.f1487v0;
        b1Var.a(6);
        this.f1480s.e();
        b1Var.f2189e = this.A.a();
        b1Var.f2187c = 0;
        if (this.f1478r != null) {
            f0 f0Var = this.A;
            int b2 = e.b(f0Var.f2230c);
            if (b2 == 1 ? f0Var.a() > 0 : b2 != 2) {
                Parcelable parcelable = this.f1478r.f2465q;
                if (parcelable != null) {
                    this.B.r0(parcelable);
                }
                this.f1478r = null;
            }
        }
        b1Var.g = false;
        this.B.n0(this.f1476q, b1Var);
        b1Var.f2190f = false;
        b1Var.f2193j = b1Var.f2193j && this.f1462d0 != null;
        b1Var.f2188d = 4;
        S(true);
        j0(false);
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z10) {
        f1 J = J(view);
        if (J != null) {
            if (J.k()) {
                J.f2240j &= -257;
            } else if (!J.p()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + J + z());
            }
        }
        view.clearAnimation();
        J(view);
        super.removeDetachedView(view, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (!this.B.q0(this, view, view2) && view2 != null) {
            a0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.B.A0(this, view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z10) {
        ArrayList arrayList = this.F;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) arrayList.get(i10)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.K != 0 || this.M) {
            this.L = true;
        } else {
            super.requestLayout();
        }
    }

    public final boolean s(int i10, int i11, int i12, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i10, i11, i12, iArr, iArr2);
    }

    @Override // android.view.View
    public final void scrollBy(int i10, int i11) {
        o0 o0Var = this.B;
        if (o0Var == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.M) {
            return;
        }
        boolean e7 = o0Var.e();
        boolean f10 = this.B.f();
        if (e7 || f10) {
            if (!e7) {
                i10 = 0;
            }
            if (!f10) {
                i11 = 0;
            }
            c0(i10, i11, null, 0);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i10, int i11) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!N()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.O |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    public void setAccessibilityDelegateCompat(h1 h1Var) {
        this.C0 = h1Var;
        m0.k0.m(this, h1Var);
    }

    public void setAdapter(f0 f0Var) {
        setLayoutFrozen(false);
        f0 f0Var2 = this.A;
        w0 w0Var = this.f1474p;
        if (f0Var2 != null) {
            f0Var2.f2228a.unregisterObserver(w0Var);
            this.A.i();
        }
        k0 k0Var = this.f1462d0;
        if (k0Var != null) {
            k0Var.e();
        }
        o0 o0Var = this.B;
        u0 u0Var = this.f1476q;
        if (o0Var != null) {
            o0Var.v0(u0Var);
            this.B.w0(u0Var);
        }
        u0Var.f2423a.clear();
        u0Var.g();
        b bVar = this.f1480s;
        bVar.s((ArrayList) bVar.f2177c);
        bVar.s((ArrayList) bVar.f2178d);
        bVar.f2175a = 0;
        f0 f0Var3 = this.A;
        this.A = f0Var;
        if (f0Var != null) {
            f0Var.f2228a.registerObserver(w0Var);
            f0Var.f();
        }
        o0 o0Var2 = this.B;
        if (o0Var2 != null) {
            o0Var2.X(f0Var3);
        }
        f0 f0Var4 = this.A;
        u0Var.f2423a.clear();
        u0Var.g();
        u0Var.f(f0Var3, true);
        t0 c10 = u0Var.c();
        if (f0Var3 != null) {
            c10.f2415b--;
        }
        if (c10.f2415b == 0) {
            SparseArray sparseArray = c10.f2414a;
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                s0 s0Var = (s0) sparseArray.valueAt(i10);
                ArrayList arrayList = s0Var.f2402a;
                int size = arrayList.size();
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayList.get(i11);
                    i11++;
                    j1.c.d(((f1) obj).f2232a);
                }
                s0Var.f2402a.clear();
            }
        }
        if (f0Var4 != null) {
            c10.f2415b++;
        }
        u0Var.e();
        this.f1487v0.f2190f = true;
        W(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(h0 h0Var) {
        if (h0Var == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z10) {
        if (z10 != this.f1486v) {
            this.f1461c0 = null;
            this.f1459a0 = null;
            this.f1460b0 = null;
            this.W = null;
        }
        this.f1486v = z10;
        super.setClipToPadding(z10);
        if (this.J) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(i0 i0Var) {
        i0Var.getClass();
        this.V = i0Var;
        this.f1461c0 = null;
        this.f1459a0 = null;
        this.f1460b0 = null;
        this.W = null;
    }

    public void setHasFixedSize(boolean z10) {
        this.I = z10;
    }

    public void setItemAnimator(k0 k0Var) {
        k0 k0Var2 = this.f1462d0;
        if (k0Var2 != null) {
            k0Var2.e();
            this.f1462d0.f2294a = null;
        }
        this.f1462d0 = k0Var;
        if (k0Var != null) {
            k0Var.f2294a = this.A0;
        }
    }

    public void setItemViewCacheSize(int i10) {
        u0 u0Var = this.f1476q;
        u0Var.f2427e = i10;
        u0Var.n();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z10) {
        suppressLayout(z10);
    }

    public void setLayoutManager(o0 o0Var) {
        if (o0Var == this.B) {
            return;
        }
        l0();
        o0 o0Var2 = this.B;
        u0 u0Var = this.f1476q;
        if (o0Var2 != null) {
            k0 k0Var = this.f1462d0;
            if (k0Var != null) {
                k0Var.e();
            }
            this.B.v0(u0Var);
            this.B.w0(u0Var);
            u0Var.f2423a.clear();
            u0Var.g();
            if (this.H) {
                o0 o0Var3 = this.B;
                o0Var3.g = false;
                o0Var3.a0(this);
            }
            this.B.L0(null);
            this.B = null;
        } else {
            u0Var.f2423a.clear();
            u0Var.g();
        }
        a0 a0Var = this.f1482t;
        RecyclerView recyclerView = ((e0) a0Var.f230p).f2214a;
        ((b4.c) a0Var.f231q).z();
        ArrayList arrayList = (ArrayList) a0Var.f232r;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            f1 J = J((View) arrayList.get(size));
            if (J != null) {
                int i10 = J.f2246p;
                if (recyclerView.N()) {
                    J.f2247q = i10;
                    recyclerView.I0.add(J);
                } else {
                    View view = J.f2232a;
                    WeakHashMap weakHashMap = m0.k0.f8683a;
                    view.setImportantForAccessibility(i10);
                }
                J.f2246p = 0;
            }
            arrayList.remove(size);
        }
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            J(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.B = o0Var;
        if (o0Var != null) {
            if (o0Var.f2358b != null) {
                throw new IllegalArgumentException("LayoutManager " + o0Var + " is already attached to a RecyclerView:" + o0Var.f2358b.z());
            }
            o0Var.L0(this);
            if (this.H) {
                o0 o0Var4 = this.B;
                o0Var4.g = true;
                o0Var4.Z(this);
            }
        }
        u0Var.n();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        j scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f8674d) {
            ViewGroup viewGroup = scrollingChildHelper.f8673c;
            WeakHashMap weakHashMap = m0.k0.f8683a;
            m0.c0.l(viewGroup);
        }
        scrollingChildHelper.f8674d = z10;
    }

    public void setOnFlingListener(q0 q0Var) {
        this.f1470m0 = q0Var;
    }

    @Deprecated
    public void setOnScrollListener(r0 r0Var) {
        this.f1489w0 = r0Var;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.f1479r0 = z10;
    }

    public void setRecycledViewPool(t0 t0Var) {
        u0 u0Var = this.f1476q;
        RecyclerView recyclerView = u0Var.f2429h;
        u0Var.f(recyclerView.A, false);
        if (u0Var.g != null) {
            r2.f2415b--;
        }
        u0Var.g = t0Var;
        if (t0Var != null && recyclerView.getAdapter() != null) {
            u0Var.g.f2415b++;
        }
        u0Var.e();
    }

    @Deprecated
    public void setRecyclerListener(v0 v0Var) {
        this.C = v0Var;
    }

    public void setScrollState(int i10) {
        y yVar;
        if (i10 == this.f1463e0) {
            return;
        }
        this.f1463e0 = i10;
        if (i10 != 2) {
            e1 e1Var = this.f1481s0;
            e1Var.f2221u.removeCallbacks(e1Var);
            e1Var.f2217q.abortAnimation();
            o0 o0Var = this.B;
            if (o0Var != null && (yVar = o0Var.f2361e) != null) {
                yVar.j();
            }
        }
        o0 o0Var2 = this.B;
        if (o0Var2 != null) {
            o0Var2.t0(i10);
        }
        r0 r0Var = this.f1489w0;
        if (r0Var != null) {
            r0Var.a(i10);
        }
        ArrayList arrayList = this.f1491x0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((r0) this.f1491x0.get(size)).a(i10);
            }
        }
    }

    public void setScrollingTouchSlop(int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 == 1) {
                this.f1469l0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i10 + "; using default value");
        }
        this.f1469l0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(d1 d1Var) {
        this.f1476q.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().g(i10, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z10) {
        if (z10 != this.M) {
            i("Do not suppressLayout in layout or scroll");
            if (z10) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.M = true;
                this.N = true;
                l0();
                return;
            }
            this.M = false;
            if (this.L && this.B != null && this.A != null) {
                requestLayout();
            }
            this.L = false;
        }
    }

    public final void t(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        getScrollingChildHelper().d(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public final void u(int i10, int i11) {
        this.U++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i10, scrollY - i11);
        r0 r0Var = this.f1489w0;
        if (r0Var != null) {
            r0Var.b(this, i10, i11);
        }
        ArrayList arrayList = this.f1491x0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((r0) this.f1491x0.get(size)).b(this, i10, i11);
            }
        }
        this.U--;
    }

    public final void v() {
        if (this.f1461c0 != null) {
            return;
        }
        ((c1) this.V).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1461c0 = edgeEffect;
        if (this.f1486v) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void w() {
        if (this.W != null) {
            return;
        }
        ((c1) this.V).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.W = edgeEffect;
        if (this.f1486v) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void x() {
        if (this.f1460b0 != null) {
            return;
        }
        ((c1) this.V).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1460b0 = edgeEffect;
        if (this.f1486v) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void y() {
        if (this.f1459a0 != null) {
            return;
        }
        ((c1) this.V).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1459a0 = edgeEffect;
        if (this.f1486v) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String z() {
        return " " + super.toString() + ", adapter:" + this.A + ", layout:" + this.B + ", context:" + getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    public RecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        float a10;
        char c10;
        TypedArray typedArray;
        boolean z10;
        char c11;
        AttributeSet attributeSet2;
        int i11;
        Constructor constructor;
        this.f1474p = new w0(this);
        this.f1476q = new u0(this);
        this.f1484u = new c(4);
        int i12 = 0;
        this.f1488w = new c0(this, i12);
        this.f1490x = new Rect();
        this.f1492y = new Rect();
        this.f1494z = new RectF();
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.K = 0;
        this.R = false;
        this.S = false;
        this.T = 0;
        this.U = 0;
        this.V = V0;
        b4.j jVar = new b4.j();
        Object[] objArr = null;
        jVar.f2294a = null;
        jVar.f2295b = new ArrayList();
        jVar.f2296c = 120L;
        jVar.f2297d = 120L;
        jVar.f2298e = 250L;
        jVar.f2299f = 250L;
        int i13 = 1;
        jVar.g = true;
        jVar.f2273h = new ArrayList();
        jVar.f2274i = new ArrayList();
        jVar.f2275j = new ArrayList();
        jVar.f2276k = new ArrayList();
        jVar.f2277l = new ArrayList();
        jVar.f2278m = new ArrayList();
        jVar.f2279n = new ArrayList();
        jVar.f2280o = new ArrayList();
        jVar.f2281p = new ArrayList();
        jVar.f2282q = new ArrayList();
        jVar.f2283r = new ArrayList();
        this.f1462d0 = jVar;
        this.f1463e0 = 0;
        this.f1464f0 = -1;
        this.f1475p0 = Float.MIN_VALUE;
        this.f1477q0 = Float.MIN_VALUE;
        this.f1479r0 = true;
        this.f1481s0 = new e1(this);
        this.f1485u0 = S0 ? new p(i12) : null;
        b1 b1Var = new b1();
        b1Var.f2185a = -1;
        b1Var.f2186b = 0;
        b1Var.f2187c = 0;
        b1Var.f2188d = 1;
        b1Var.f2189e = 0;
        b1Var.f2190f = false;
        b1Var.g = false;
        b1Var.f2191h = false;
        b1Var.f2192i = false;
        b1Var.f2193j = false;
        b1Var.f2194k = false;
        this.f1487v0 = b1Var;
        this.f1493y0 = false;
        this.f1495z0 = false;
        e0 e0Var = new e0(this);
        this.A0 = e0Var;
        this.B0 = false;
        this.D0 = new int[2];
        this.F0 = new int[2];
        this.G0 = new int[2];
        this.H0 = new int[2];
        this.I0 = new ArrayList();
        this.J0 = new c0(this, i13);
        this.L0 = 0;
        this.M0 = 0;
        this.N0 = new e0(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1469l0 = viewConfiguration.getScaledTouchSlop();
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 26) {
            Method method = m0.l0.f8690a;
            a10 = c0.a.b(viewConfiguration);
        } else {
            a10 = m0.l0.a(viewConfiguration, context);
        }
        this.f1475p0 = a10;
        this.f1477q0 = i14 >= 26 ? c0.a.c(viewConfiguration) : m0.l0.a(viewConfiguration, context);
        this.f1471n0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1473o0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1472o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.f1462d0.f2294a = e0Var;
        this.f1480s = new b(new e0(this));
        this.f1482t = new a0(new e0(this));
        WeakHashMap weakHashMap = m0.k0.f8683a;
        if ((i14 >= 26 ? m0.e0.a(this) : 0) == 0 && i14 >= 26) {
            m0.e0.b(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.Q = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new h1(this));
        int[] iArr = a4.a.f29a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        m0.k0.l(this, context, iArr, attributeSet, obtainStyledAttributes, i10);
        String string = obtainStyledAttributes.getString(8);
        if (obtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f1486v = obtainStyledAttributes.getBoolean(1, true);
        if (obtainStyledAttributes.getBoolean(3, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes.getDrawable(6);
            Drawable drawable = obtainStyledAttributes.getDrawable(7);
            StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes.getDrawable(4);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(5);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + z());
            }
            Resources resources = getContext().getResources();
            c11 = 2;
            z10 = 1;
            attributeSet2 = attributeSet;
            typedArray = obtainStyledAttributes;
            c10 = 3;
            i11 = i10;
            new n(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(org.chromium.net.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(org.chromium.net.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(org.chromium.net.R.dimen.fastscroll_margin));
        } else {
            c10 = 3;
            typedArray = obtainStyledAttributes;
            z10 = 1;
            c11 = 2;
            attributeSet2 = attributeSet;
            i11 = i10;
        }
        typedArray.recycle();
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    trim = context.getPackageName() + trim;
                } else if (!trim.contains(".")) {
                    trim = RecyclerView.class.getPackage().getName() + '.' + trim;
                }
                String str = trim;
                try {
                    Class asSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o0.class);
                    try {
                        constructor = asSubclass.getConstructor(T0);
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = context;
                        objArr2[z10] = attributeSet2;
                        objArr2[c11] = Integer.valueOf(i11);
                        objArr2[c10] = 0;
                        objArr = objArr2;
                    } catch (NoSuchMethodException e7) {
                        try {
                            constructor = asSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e8) {
                            e8.initCause(e7);
                            throw new IllegalStateException(attributeSet2.getPositionDescription() + ": Error creating LayoutManager " + str, e8);
                        }
                    }
                    constructor.setAccessible(z10);
                    setLayoutManager((o0) constructor.newInstance(objArr));
                } catch (ClassCastException e10) {
                    throw new IllegalStateException(attributeSet2.getPositionDescription() + ": Class is not a LayoutManager " + str, e10);
                } catch (ClassNotFoundException e11) {
                    throw new IllegalStateException(attributeSet2.getPositionDescription() + ": Unable to find LayoutManager " + str, e11);
                } catch (IllegalAccessException e12) {
                    throw new IllegalStateException(attributeSet2.getPositionDescription() + ": Cannot access non-public constructor " + str, e12);
                } catch (InstantiationException e13) {
                    throw new IllegalStateException(attributeSet2.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e13);
                } catch (InvocationTargetException e14) {
                    throw new IllegalStateException(attributeSet2.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e14);
                }
            }
        }
        int[] iArr2 = O0;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet2, iArr2, i11, 0);
        m0.k0.l(this, context, iArr2, attributeSet2, obtainStyledAttributes2, i11);
        boolean z11 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z11);
        setTag(org.chromium.net.R.id.is_pooling_container_tag, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o0 o0Var = this.B;
        if (o0Var != null) {
            return o0Var.v(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + z());
    }
}
