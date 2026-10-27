package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import b4.j0;
import f.m0;
import java.util.WeakHashMap;
import k.j;
import l.w;
import m.c;
import m.d;
import m.e;
import m.e1;
import m.f;
import m.f1;
import m.u2;
import m.z2;
import m0.a0;
import m0.a1;
import m0.b1;
import m0.c0;
import m0.c1;
import m0.d1;
import m0.k;
import m0.k0;
import m0.l;
import m0.n1;
import m0.q1;
import m0.y0;
import n4.a;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements e1, k, l {
    public static final int[] Q = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public static final q1 R;
    public static final Rect S;
    public final Rect A;
    public final Rect B;
    public final Rect C;
    public final Rect D;
    public q1 E;
    public q1 F;
    public q1 G;
    public q1 H;
    public d I;
    public OverScroller J;
    public ViewPropertyAnimator K;
    public final g9.l L;
    public final c M;
    public final c N;
    public final j0 O;
    public final f P;

    /* renamed from: o, reason: collision with root package name */
    public int f410o;

    /* renamed from: p, reason: collision with root package name */
    public int f411p;

    /* renamed from: q, reason: collision with root package name */
    public ContentFrameLayout f412q;

    /* renamed from: r, reason: collision with root package name */
    public ActionBarContainer f413r;

    /* renamed from: s, reason: collision with root package name */
    public f1 f414s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f415t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f416u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f417v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f418w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f419x;

    /* renamed from: y, reason: collision with root package name */
    public int f420y;

    /* renamed from: z, reason: collision with root package name */
    public int f421z;

    static {
        int i10 = Build.VERSION.SDK_INT;
        m0.e1 d1Var = i10 >= 34 ? new d1() : i10 >= 31 ? new c1() : i10 >= 30 ? new b1() : i10 >= 29 ? new a1() : new y0();
        d1Var.g(e0.c.b(0, 1, 0, 1));
        R = d1Var.b();
        S = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f411p = 0;
        this.A = new Rect();
        this.B = new Rect();
        this.C = new Rect();
        this.D = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        q1 q1Var = q1.f8705b;
        this.E = q1Var;
        this.F = q1Var;
        this.G = q1Var;
        this.H = q1Var;
        this.L = new g9.l(2, this);
        this.M = new c(this, 0);
        this.N = new c(this, 1);
        i(context);
        this.O = new j0((byte) 0, 4);
        f fVar = new f(context);
        fVar.setWillNotDraw(true);
        this.P = fVar;
        addView(fVar);
    }

    public static boolean g(View view, Rect rect, boolean z10) {
        boolean z11;
        e eVar = (e) view.getLayoutParams();
        int i10 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
        int i11 = rect.left;
        if (i10 != i11) {
            ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i11;
            z11 = true;
        } else {
            z11 = false;
        }
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        int i13 = rect.top;
        if (i12 != i13) {
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = i13;
            z11 = true;
        }
        int i14 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
        int i15 = rect.right;
        if (i14 != i15) {
            ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i15;
            z11 = true;
        }
        if (z10) {
            int i16 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            int i17 = rect.bottom;
            if (i16 != i17) {
                ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i17;
                return true;
            }
        }
        return z11;
    }

    @Override // m0.k
    public final void a(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // m0.k
    public final void b(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // m0.l
    public final void d(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        e(view, i10, i11, i12, i13, i14);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i10;
        super.draw(canvas);
        if (this.f415t != null) {
            if (this.f413r.getVisibility() == 0) {
                i10 = (int) (this.f413r.getTranslationY() + this.f413r.getBottom() + 0.5f);
            } else {
                i10 = 0;
            }
            this.f415t.setBounds(0, i10, getWidth(), this.f415t.getIntrinsicHeight() + i10);
            this.f415t.draw(canvas);
        }
    }

    @Override // m0.k
    public final void e(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    @Override // m0.k
    public final boolean f(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f413r;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        j0 j0Var = this.O;
        return j0Var.f2286c | j0Var.f2285b;
    }

    public CharSequence getTitle() {
        k();
        return ((z2) this.f414s).f8621a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.M);
        removeCallbacks(this.N);
        ViewPropertyAnimator viewPropertyAnimator = this.K;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void i(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(Q);
        this.f410o = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f415t = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.J = new OverScroller(context);
    }

    public final void j(int i10) {
        k();
        if (i10 == 2) {
            ((z2) this.f414s).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i10 == 5) {
            ((z2) this.f414s).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i10 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public final void k() {
        f1 wrapper;
        if (this.f412q == null) {
            this.f412q = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f413r = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback findViewById = findViewById(R.id.action_bar);
            if (findViewById instanceof f1) {
                wrapper = (f1) findViewById;
            } else {
                if (!(findViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) findViewById).getWrapper();
            }
            this.f414s = wrapper;
        }
    }

    public final void l(Menu menu, w wVar) {
        k();
        z2 z2Var = (z2) this.f414s;
        Toolbar toolbar = z2Var.f8621a;
        if (z2Var.f8632m == null) {
            z2Var.f8632m = new m.k(toolbar.getContext());
        }
        m.k kVar = z2Var.f8632m;
        kVar.f8454s = wVar;
        l.l lVar = (l.l) menu;
        if (lVar == null && toolbar.f475o == null) {
            return;
        }
        toolbar.f();
        l.l lVar2 = toolbar.f475o.D;
        if (lVar2 == lVar) {
            return;
        }
        if (lVar2 != null) {
            lVar2.r(toolbar.f469b0);
            lVar2.r(toolbar.f470c0);
        }
        if (toolbar.f470c0 == null) {
            toolbar.f470c0 = new u2(toolbar);
        }
        kVar.E = true;
        if (lVar != null) {
            lVar.b(kVar, toolbar.f484x);
            lVar.b(toolbar.f470c0, toolbar.f484x);
        } else {
            kVar.h(toolbar.f484x, null);
            toolbar.f470c0.h(toolbar.f484x, null);
            kVar.b();
            toolbar.f470c0.b();
        }
        toolbar.f475o.setPopupTheme(toolbar.f485y);
        toolbar.f475o.setPresenter(kVar);
        toolbar.f469b0 = kVar;
        toolbar.t();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        q1 g = q1.g(this, windowInsets);
        boolean g6 = g(this.f413r, new Rect(g.b(), g.d(), g.c(), g.a()), false);
        WeakHashMap weakHashMap = k0.f8683a;
        Rect rect = this.A;
        c0.b(this, g, rect);
        int i10 = rect.left;
        int i11 = rect.top;
        int i12 = rect.right;
        int i13 = rect.bottom;
        n1 n1Var = g.f8706a;
        q1 l10 = n1Var.l(i10, i11, i12, i13);
        this.E = l10;
        boolean z10 = true;
        if (!this.F.equals(l10)) {
            this.F = this.E;
            g6 = true;
        }
        Rect rect2 = this.B;
        if (rect2.equals(rect)) {
            z10 = g6;
        } else {
            rect2.set(rect);
        }
        if (z10) {
            requestLayout();
        }
        return n1Var.a().f8706a.c().f8706a.b().f();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        WeakHashMap weakHashMap = k0.f8683a;
        a0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0110  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r13, int r14) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f418w || !z10) {
            return false;
        }
        this.J.fling(0, 0, 0, (int) f11, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.J.getFinalY() > this.f413r.getHeight()) {
            h();
            this.N.run();
        } else {
            h();
            this.M.run();
        }
        this.f419x = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f420y + i11;
        this.f420y = i14;
        setActionBarHideOffset(i14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i10) {
        m0 m0Var;
        j jVar;
        this.O.f2285b = i10;
        this.f420y = getActionBarHideOffset();
        h();
        d dVar = this.I;
        if (dVar == null || (jVar = (m0Var = (m0) dVar).f4824u) == null) {
            return;
        }
        jVar.a();
        m0Var.f4824u = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f413r.getVisibility() != 0) {
            return false;
        }
        return this.f418w;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f418w || this.f419x) {
            return;
        }
        if (this.f420y <= this.f413r.getHeight()) {
            h();
            postDelayed(this.M, 600L);
        } else {
            h();
            postDelayed(this.N, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i10) {
        super.onWindowSystemUiVisibilityChanged(i10);
        k();
        int i11 = this.f421z ^ i10;
        this.f421z = i10;
        boolean z10 = (i10 & 4) == 0;
        boolean z11 = (i10 & 256) != 0;
        d dVar = this.I;
        if (dVar != null) {
            m0 m0Var = (m0) dVar;
            m0Var.f4820q = !z11;
            if (z10 || !z11) {
                if (m0Var.f4821r) {
                    m0Var.f4821r = false;
                    m0Var.G(true);
                }
            } else if (!m0Var.f4821r) {
                m0Var.f4821r = true;
                m0Var.G(true);
            }
        }
        if ((i11 & 256) == 0 || this.I == null) {
            return;
        }
        WeakHashMap weakHashMap = k0.f8683a;
        a0.c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f411p = i10;
        d dVar = this.I;
        if (dVar != null) {
            ((m0) dVar).f4819p = i10;
        }
    }

    public void setActionBarHideOffset(int i10) {
        h();
        this.f413r.setTranslationY(-Math.max(0, Math.min(i10, this.f413r.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.I = dVar;
        if (getWindowToken() != null) {
            ((m0) this.I).f4819p = this.f411p;
            int i10 = this.f421z;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                WeakHashMap weakHashMap = k0.f8683a;
                a0.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f417v = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f418w) {
            this.f418w = z10;
            if (z10) {
                return;
            }
            h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i10) {
        k();
        z2 z2Var = (z2) this.f414s;
        z2Var.f8624d = i10 != 0 ? a.o(z2Var.f8621a.getContext(), i10) : null;
        z2Var.c();
    }

    public void setLogo(int i10) {
        k();
        z2 z2Var = (z2) this.f414s;
        z2Var.f8625e = i10 != 0 ? a.o(z2Var.f8621a.getContext(), i10) : null;
        z2Var.c();
    }

    public void setOverlayMode(boolean z10) {
        this.f416u = z10;
    }

    @Override // m.e1
    public void setWindowCallback(Window.Callback callback) {
        k();
        ((z2) this.f414s).f8630k = callback;
    }

    @Override // m.e1
    public void setWindowTitle(CharSequence charSequence) {
        k();
        z2 z2Var = (z2) this.f414s;
        if (z2Var.g) {
            return;
        }
        Toolbar toolbar = z2Var.f8621a;
        z2Var.f8627h = charSequence;
        if ((z2Var.f8622b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (z2Var.g) {
                k0.n(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        k();
        z2 z2Var = (z2) this.f414s;
        z2Var.f8624d = drawable;
        z2Var.c();
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    @Override // m0.k
    public final void c(View view, int i10, int i11, int[] iArr, int i12) {
    }
}
