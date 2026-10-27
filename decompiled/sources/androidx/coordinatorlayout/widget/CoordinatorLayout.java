package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b4.j0;
import b4.o;
import j6.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.WeakHashMap;
import l0.e;
import m0.a0;
import m0.c0;
import m0.k;
import m0.k0;
import m0.l;
import m0.q1;
import org.chromium.net.R;
import x4.i;
import x5.b0;
import y.a;
import z.b;
import z.c;
import z.f;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements k, l {
    public static final String H;
    public static final Class[] I;
    public static final ThreadLocal J;
    public static final o K;
    public static final e L;
    public boolean A;
    public q1 B;
    public boolean C;
    public Drawable D;
    public ViewGroup.OnHierarchyChangeListener E;
    public b0 F;
    public final j0 G;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f507o;

    /* renamed from: p, reason: collision with root package name */
    public final i f508p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f509q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f510r;

    /* renamed from: s, reason: collision with root package name */
    public final int[] f511s;

    /* renamed from: t, reason: collision with root package name */
    public final int[] f512t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f513u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f514v;

    /* renamed from: w, reason: collision with root package name */
    public final int[] f515w;

    /* renamed from: x, reason: collision with root package name */
    public View f516x;

    /* renamed from: y, reason: collision with root package name */
    public View f517y;

    /* renamed from: z, reason: collision with root package name */
    public d f518z;

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        H = r02 != null ? r02.getName() : null;
        K = new o(7);
        I = new Class[]{Context.class, AttributeSet.class};
        J = new ThreadLocal();
        L = new e(12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        this.f507o = new ArrayList();
        this.f508p = new i(18);
        this.f509q = new ArrayList();
        this.f510r = new ArrayList();
        this.f511s = new int[2];
        this.f512t = new int[2];
        this.G = new j0(0 == true ? 1 : 0, 4);
        int[] iArr = a.f13752a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.coordinatorLayoutStyle, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.f515w = intArray;
            float f10 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i10 = 0; i10 < length; i10++) {
                this.f515w[i10] = (int) (r1[i10] * f10);
            }
        }
        this.D = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        w();
        super.setOnHierarchyChangeListener(new c(this));
        WeakHashMap weakHashMap = k0.f8683a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect g() {
        Rect rect = (Rect) L.v();
        return rect == null ? new Rect() : rect;
    }

    public static void l(int i10, Rect rect, Rect rect2, z.d dVar, int i11, int i12) {
        int i13 = dVar.f13934c;
        if (i13 == 0) {
            i13 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i13, i10);
        int i14 = dVar.f13935d;
        if ((i14 & 7) == 0) {
            i14 |= 8388611;
        }
        if ((i14 & 112) == 0) {
            i14 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i14, i10);
        int i15 = absoluteGravity & 7;
        int i16 = absoluteGravity & 112;
        int i17 = absoluteGravity2 & 7;
        int i18 = absoluteGravity2 & 112;
        int width = i17 != 1 ? i17 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i18 != 16 ? i18 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i15 == 1) {
            width -= i11 / 2;
        } else if (i15 != 5) {
            width -= i11;
        }
        if (i16 == 16) {
            height -= i12 / 2;
        } else if (i16 != 80) {
            height -= i12;
        }
        rect2.set(width, height, i11 + width, i12 + height);
    }

    public static z.d n(View view) {
        z.d dVar = (z.d) view.getLayoutParams();
        if (!dVar.f13933b) {
            b bVar = null;
            for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                bVar = (b) cls.getAnnotation(b.class);
                if (bVar != null) {
                    break;
                }
            }
            if (bVar != null) {
                try {
                    z.a aVar = (z.a) bVar.value().getDeclaredConstructor(null).newInstance(null);
                    z.a aVar2 = dVar.f13932a;
                    if (aVar2 != aVar) {
                        if (aVar2 != null) {
                            aVar2.e();
                        }
                        dVar.f13932a = aVar;
                        dVar.f13933b = true;
                        if (aVar != null) {
                            aVar.c(dVar);
                        }
                    }
                } catch (Exception e7) {
                    Log.e("CoordinatorLayout", "Default behavior class " + bVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e7);
                }
            }
            dVar.f13933b = true;
        }
        return dVar;
    }

    public static void u(View view, int i10) {
        z.d dVar = (z.d) view.getLayoutParams();
        int i11 = dVar.f13939i;
        if (i11 != i10) {
            WeakHashMap weakHashMap = k0.f8683a;
            view.offsetLeftAndRight(i10 - i11);
            dVar.f13939i = i10;
        }
    }

    public static void v(View view, int i10) {
        z.d dVar = (z.d) view.getLayoutParams();
        int i11 = dVar.f13940j;
        if (i11 != i10) {
            WeakHashMap weakHashMap = k0.f8683a;
            view.offsetTopAndBottom(i10 - i11);
            dVar.f13940j = i10;
        }
    }

    @Override // m0.k
    public final void a(View view, View view2, int i10, int i11) {
        j0 j0Var = this.G;
        if (i11 == 1) {
            j0Var.f2286c = i10;
        } else {
            j0Var.f2285b = i10;
        }
        this.f517y = view2;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            ((z.d) getChildAt(i12).getLayoutParams()).getClass();
        }
    }

    @Override // m0.k
    public final void b(View view, int i10) {
        j0 j0Var = this.G;
        if (i10 == 1) {
            j0Var.f2286c = 0;
        } else {
            j0Var.f2285b = 0;
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            z.d dVar = (z.d) childAt.getLayoutParams();
            if (dVar.a(i10)) {
                z.a aVar = dVar.f13932a;
                if (aVar != null) {
                    aVar.p(childAt, view, i10);
                }
                if (i10 == 0) {
                    dVar.f13943m = false;
                } else if (i10 == 1) {
                    dVar.f13944n = false;
                }
            }
        }
        this.f517y = null;
    }

    @Override // m0.k
    public final void c(View view, int i10, int i11, int[] iArr, int i12) {
        z.a aVar;
        int childCount = getChildCount();
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                z.d dVar = (z.d) childAt.getLayoutParams();
                if (dVar.a(i12) && (aVar = dVar.f13932a) != null) {
                    int[] iArr2 = this.f511s;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    aVar.j(this, childAt, view, i10, i11, iArr2, i12);
                    i13 = i10 > 0 ? Math.max(i13, iArr2[0]) : Math.min(i13, iArr2[0]);
                    i14 = i11 > 0 ? Math.max(i14, iArr2[1]) : Math.min(i14, iArr2[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = i13;
        iArr[1] = i14;
        if (z10) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof z.d) && super.checkLayoutParams(layoutParams);
    }

    @Override // m0.l
    public final void d(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        z.a aVar;
        int childCount = getChildCount();
        int i15 = 0;
        int i16 = 0;
        boolean z10 = false;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                z.d dVar = (z.d) childAt.getLayoutParams();
                if (dVar.a(i14) && (aVar = dVar.f13932a) != null) {
                    int[] iArr2 = this.f511s;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    aVar.k(this, childAt, i11, i12, i13, iArr2);
                    i15 = i12 > 0 ? Math.max(i15, iArr2[0]) : Math.min(i15, iArr2[0]);
                    i16 = i13 > 0 ? Math.max(i16, iArr2[1]) : Math.min(i16, iArr2[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i15;
        iArr[1] = iArr[1] + i16;
        if (z10) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j10) {
        z.a aVar = ((z.d) view.getLayoutParams()).f13932a;
        if (aVar != null) {
            aVar.getClass();
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.D;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // m0.k
    public final void e(View view, int i10, int i11, int i12, int i13, int i14) {
        d(view, i10, i11, i12, i13, 0, this.f512t);
    }

    @Override // m0.k
    public final boolean f(View view, View view2, int i10, int i11) {
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                z.d dVar = (z.d) childAt.getLayoutParams();
                z.a aVar = dVar.f13932a;
                if (aVar != null) {
                    boolean o2 = aVar.o(childAt, i10, i11);
                    z10 |= o2;
                    if (i11 == 0) {
                        dVar.f13943m = o2;
                    } else if (i11 == 1) {
                        dVar.f13944n = o2;
                    }
                } else if (i11 == 0) {
                    dVar.f13943m = false;
                } else if (i11 == 1) {
                    dVar.f13944n = false;
                }
            }
        }
        return z10;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new z.d();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new z.d(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        s();
        return Collections.unmodifiableList(this.f507o);
    }

    public final q1 getLastWindowInsets() {
        return this.B;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        j0 j0Var = this.G;
        return j0Var.f2286c | j0Var.f2285b;
    }

    public Drawable getStatusBarBackground() {
        return this.D;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final void h(z.d dVar, Rect rect, int i10, int i11) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i10) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i11) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin));
        rect.set(max, max2, i10 + max, i11 + max2);
    }

    public final void i(View view, Rect rect, boolean z10) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z10) {
            k(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList j(View view) {
        p.i iVar = (p.i) this.f508p.f13554q;
        int i10 = iVar.f9781q;
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < i10; i11++) {
            ArrayList arrayList2 = (ArrayList) iVar.j(i11);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(iVar.f(i11));
            }
        }
        ArrayList arrayList3 = this.f510r;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final void k(View view, Rect rect) {
        ThreadLocal threadLocal = f.f13947a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = f.f13947a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        f.a(this, view, matrix);
        ThreadLocal threadLocal3 = f.f13948b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int m(int i10) {
        int[] iArr = this.f515w;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i10);
            return 0;
        }
        if (i10 >= 0 && i10 < iArr.length) {
            return iArr[i10];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i10 + " out of range for " + this);
        return 0;
    }

    public final boolean o(View view, int i10, int i11) {
        e eVar = L;
        Rect g = g();
        k(view, g);
        try {
            return g.contains(i10, i11);
        } finally {
            g.setEmpty();
            eVar.m(g);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        t(false);
        int i10 = 1;
        if (this.A) {
            if (this.f518z == null) {
                this.f518z = new d(i10, this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f518z);
        }
        if (this.B == null) {
            WeakHashMap weakHashMap = k0.f8683a;
            if (getFitsSystemWindows()) {
                a0.c(this);
            }
        }
        this.f514v = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t(false);
        if (this.A && this.f518z != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f518z);
        }
        View view = this.f517y;
        if (view != null) {
            b(view, 0);
        }
        this.f514v = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.C || this.D == null) {
            return;
        }
        q1 q1Var = this.B;
        int d6 = q1Var != null ? q1Var.d() : 0;
        if (d6 > 0) {
            this.D.setBounds(0, 0, getWidth(), d6);
            this.D.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            t(true);
        }
        boolean r2 = r(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return r2;
        }
        t(true);
        return r2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        z.a aVar;
        WeakHashMap weakHashMap = k0.f8683a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.f507o;
        int size = arrayList.size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = (View) arrayList.get(i14);
            if (view.getVisibility() != 8 && ((aVar = ((z.d) view.getLayoutParams()).f13932a) == null || !aVar.g(this, view, layoutDirection))) {
                q(view, layoutDirection);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                z.d dVar = (z.d) childAt.getLayoutParams();
                if (dVar.a(0)) {
                    z.a aVar = dVar.f13932a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f10, float f11) {
        z.a aVar;
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                z.d dVar = (z.d) childAt.getLayoutParams();
                if (dVar.a(0) && (aVar = dVar.f13932a) != null) {
                    z10 |= aVar.i(view);
                }
            }
        }
        return z10;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        c(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        e(view, i10, i11, i12, i13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i10) {
        a(view, view2, i10, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof z.e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        z.e eVar = (z.e) parcelable;
        super.onRestoreInstanceState(eVar.f10407o);
        SparseArray sparseArray = eVar.f13946q;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id = childAt.getId();
            z.a aVar = n(childAt).f13932a;
            if (id != -1 && aVar != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                aVar.m(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable n10;
        z.e eVar = new z.e(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id = childAt.getId();
            z.a aVar = ((z.d) childAt.getLayoutParams()).f13932a;
            if (id != -1 && aVar != null && (n10 = aVar.n(childAt)) != null) {
                sparseArray.append(id, n10);
            }
        }
        eVar.f13946q = sparseArray;
        return eVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i10) {
        return f(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        b(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.f516x
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.r(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2a
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f516x
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            z.d r6 = (z.d) r6
            z.a r6 = r6.f13932a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f516x
            boolean r6 = r6.q(r7, r1)
        L2a:
            android.view.View r7 = r0.f516x
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r9 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r11 = r9
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L53
            goto L54
        L53:
            return r6
        L54:
            r0.t(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0270  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(int r23) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.p(int):void");
    }

    public final void q(View view, int i10) {
        Rect g;
        Rect g6;
        z.d dVar = (z.d) view.getLayoutParams();
        View view2 = dVar.f13941k;
        if (view2 == null && dVar.f13937f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        e eVar = L;
        if (view2 != null) {
            g = g();
            g6 = g();
            try {
                k(view2, g);
                z.d dVar2 = (z.d) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                l(i10, g, g6, dVar2, measuredWidth, measuredHeight);
                h(dVar2, g6, measuredWidth, measuredHeight);
                view.layout(g6.left, g6.top, g6.right, g6.bottom);
                return;
            } finally {
                g.setEmpty();
                eVar.m(g);
                g6.setEmpty();
                eVar.m(g6);
            }
        }
        int i11 = dVar.f13936e;
        if (i11 < 0) {
            z.d dVar3 = (z.d) view.getLayoutParams();
            g = g();
            g.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) dVar3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) dVar3).bottomMargin);
            if (this.B != null) {
                WeakHashMap weakHashMap = k0.f8683a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    g.left = this.B.b() + g.left;
                    g.top = this.B.d() + g.top;
                    g.right -= this.B.c();
                    g.bottom -= this.B.a();
                }
            }
            g6 = g();
            int i12 = dVar3.f13934c;
            if ((i12 & 7) == 0) {
                i12 |= 8388611;
            }
            if ((i12 & 112) == 0) {
                i12 |= 48;
            }
            Gravity.apply(i12, view.getMeasuredWidth(), view.getMeasuredHeight(), g, g6, i10);
            view.layout(g6.left, g6.top, g6.right, g6.bottom);
            return;
        }
        z.d dVar4 = (z.d) view.getLayoutParams();
        int i13 = dVar4.f13934c;
        if (i13 == 0) {
            i13 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i13, i10);
        int i14 = absoluteGravity & 7;
        int i15 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i10 == 1) {
            i11 = width - i11;
        }
        int m10 = m(i11) - measuredWidth2;
        if (i14 == 1) {
            m10 += measuredWidth2 / 2;
        } else if (i14 == 5) {
            m10 += measuredWidth2;
        }
        int i16 = i15 != 16 ? i15 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar4).leftMargin, Math.min(m10, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) dVar4).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar4).topMargin, Math.min(i16, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) dVar4).bottomMargin));
        view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
    }

    public final boolean r(MotionEvent motionEvent, int i10) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f509q;
        arrayList.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            arrayList.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i11) : i11));
        }
        o oVar = K;
        if (oVar != null) {
            Collections.sort(arrayList, oVar);
        }
        int size = arrayList.size();
        MotionEvent motionEvent2 = null;
        boolean z10 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view = (View) arrayList.get(i12);
            z.a aVar = ((z.d) view.getLayoutParams()).f13932a;
            if (z10 && actionMasked != 0) {
                if (aVar != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i10 == 0) {
                        aVar.f(this, view, motionEvent2);
                    } else if (i10 == 1) {
                        aVar.q(view, motionEvent2);
                    }
                }
            } else if (!z10 && aVar != null) {
                if (i10 == 0) {
                    z10 = aVar.f(this, view, motionEvent);
                } else if (i10 == 1) {
                    z10 = aVar.q(view, motionEvent);
                }
                if (z10) {
                    this.f516x = view;
                }
            }
        }
        arrayList.clear();
        return z10;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        z.a aVar = ((z.d) view.getLayoutParams()).f13932a;
        if (aVar != null) {
            aVar.l(this, view);
        }
        return super.requestChildRectangleOnScreen(view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (!z10 || this.f513u) {
            return;
        }
        t(false);
        this.f513u = true;
    }

    public final void s() {
        ArrayList arrayList = this.f507o;
        arrayList.clear();
        i iVar = this.f508p;
        p.i iVar2 = (p.i) iVar.f13554q;
        l0.d dVar = (l0.d) iVar.f13553p;
        p.i iVar3 = (p.i) iVar.f13554q;
        int i10 = iVar2.f9781q;
        for (int i11 = 0; i11 < i10; i11++) {
            ArrayList arrayList2 = (ArrayList) iVar2.j(i11);
            if (arrayList2 != null) {
                arrayList2.clear();
                dVar.m(arrayList2);
            }
        }
        iVar2.clear();
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            z.d n10 = n(childAt);
            int i13 = n10.f13937f;
            if (i13 == -1) {
                n10.f13942l = null;
                n10.f13941k = null;
            } else {
                View view = n10.f13941k;
                if (view != null && view.getId() == i13) {
                    View view2 = n10.f13941k;
                    for (ViewParent parent = view2.getParent(); parent != this; parent = parent.getParent()) {
                        if (parent == null || parent == childAt) {
                            n10.f13942l = null;
                            n10.f13941k = null;
                        } else {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                        }
                    }
                    n10.f13942l = view2;
                }
                View findViewById = findViewById(i13);
                n10.f13941k = findViewById;
                if (findViewById == null) {
                    if (!isInEditMode()) {
                        throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(i13) + " to anchor view " + childAt);
                    }
                    n10.f13942l = null;
                    n10.f13941k = null;
                } else if (findViewById != this) {
                    for (ViewParent parent2 = findViewById.getParent(); parent2 != this && parent2 != null; parent2 = parent2.getParent()) {
                        if (parent2 != childAt) {
                            if (parent2 instanceof View) {
                                findViewById = parent2;
                            }
                        } else {
                            if (!isInEditMode()) {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                            n10.f13942l = null;
                            n10.f13941k = null;
                        }
                    }
                    n10.f13942l = findViewById;
                } else {
                    if (!isInEditMode()) {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                    n10.f13942l = null;
                    n10.f13941k = null;
                }
            }
            if (!iVar3.containsKey(childAt)) {
                iVar3.put(childAt, null);
            }
            for (int i14 = 0; i14 < childCount; i14++) {
                if (i14 != i12) {
                    View childAt2 = getChildAt(i14);
                    if (childAt2 != n10.f13942l) {
                        WeakHashMap weakHashMap = k0.f8683a;
                        int layoutDirection = getLayoutDirection();
                        int absoluteGravity = Gravity.getAbsoluteGravity(((z.d) childAt2.getLayoutParams()).g, layoutDirection);
                        if (absoluteGravity == 0 || (Gravity.getAbsoluteGravity(n10.f13938h, layoutDirection) & absoluteGravity) != absoluteGravity) {
                            z.a aVar = n10.f13932a;
                            if (aVar != null) {
                                aVar.b(childAt);
                            }
                        }
                    }
                    if (!iVar3.containsKey(childAt2) && !iVar3.containsKey(childAt2)) {
                        iVar3.put(childAt2, null);
                    }
                    if (!iVar3.containsKey(childAt2) || !iVar3.containsKey(childAt)) {
                        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                    }
                    ArrayList arrayList3 = (ArrayList) iVar3.get(childAt2);
                    if (arrayList3 == null) {
                        arrayList3 = (ArrayList) dVar.v();
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        iVar3.put(childAt2, arrayList3);
                    }
                    arrayList3.add(childAt);
                }
            }
        }
        ArrayList arrayList4 = (ArrayList) iVar.f13555r;
        arrayList4.clear();
        HashSet hashSet = (HashSet) iVar.f13556s;
        hashSet.clear();
        int i15 = iVar3.f9781q;
        for (int i16 = 0; i16 < i15; i16++) {
            iVar.f(iVar3.f(i16), arrayList4, hashSet);
        }
        arrayList.addAll(arrayList4);
        Collections.reverse(arrayList);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        w();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.E = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.D;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.D = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.D.setState(getDrawableState());
                }
                Drawable drawable3 = this.D;
                WeakHashMap weakHashMap = k0.f8683a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.D.setVisible(getVisibility() == 0, false);
                this.D.setCallback(this);
            }
            WeakHashMap weakHashMap2 = k0.f8683a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i10) {
        setStatusBarBackground(new ColorDrawable(i10));
    }

    public void setStatusBarBackgroundResource(int i10) {
        setStatusBarBackground(i10 != 0 ? getContext().getDrawable(i10) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.D;
        if (drawable == null || drawable.isVisible() == z10) {
            return;
        }
        this.D.setVisible(z10, false);
    }

    public final void t(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            z.a aVar = ((z.d) childAt.getLayoutParams()).f13932a;
            if (aVar != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z10) {
                    aVar.f(this, childAt, obtain);
                } else {
                    aVar.q(childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            ((z.d) getChildAt(i11).getLayoutParams()).getClass();
        }
        this.f516x = null;
        this.f513u = false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.D;
    }

    public final void w() {
        WeakHashMap weakHashMap = k0.f8683a;
        if (!getFitsSystemWindows()) {
            c0.j(this, null);
            return;
        }
        if (this.F == null) {
            this.F = new b0(this);
        }
        c0.j(this, this.F);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof z.d ? new z.d((z.d) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new z.d((ViewGroup.MarginLayoutParams) layoutParams) : new z.d(layoutParams);
    }
}
