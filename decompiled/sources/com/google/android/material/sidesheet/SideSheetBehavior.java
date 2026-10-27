package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bumptech.glide.d;
import d9.j;
import d9.m;
import d9.n;
import e9.b;
import e9.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import m0.c0;
import m0.k0;
import org.chromium.net.R;
import z.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends a {

    /* renamed from: a, reason: collision with root package name */
    public d f3816a;

    /* renamed from: b, reason: collision with root package name */
    public final j f3817b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f3818c;

    /* renamed from: d, reason: collision with root package name */
    public final n f3819d;

    /* renamed from: e, reason: collision with root package name */
    public final e9.d f3820e;

    /* renamed from: f, reason: collision with root package name */
    public final float f3821f;
    public final boolean g;

    /* renamed from: h, reason: collision with root package name */
    public int f3822h;

    /* renamed from: i, reason: collision with root package name */
    public s0.d f3823i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3824j;

    /* renamed from: k, reason: collision with root package name */
    public final float f3825k;

    /* renamed from: l, reason: collision with root package name */
    public int f3826l;

    /* renamed from: m, reason: collision with root package name */
    public int f3827m;

    /* renamed from: n, reason: collision with root package name */
    public int f3828n;

    /* renamed from: o, reason: collision with root package name */
    public int f3829o;

    /* renamed from: p, reason: collision with root package name */
    public WeakReference f3830p;

    /* renamed from: q, reason: collision with root package name */
    public WeakReference f3831q;

    /* renamed from: r, reason: collision with root package name */
    public final int f3832r;

    /* renamed from: s, reason: collision with root package name */
    public VelocityTracker f3833s;

    /* renamed from: t, reason: collision with root package name */
    public int f3834t;

    /* renamed from: u, reason: collision with root package name */
    public final LinkedHashSet f3835u;

    /* renamed from: v, reason: collision with root package name */
    public final b f3836v;

    public SideSheetBehavior() {
        this.f3820e = new e9.d(this);
        this.g = true;
        this.f3822h = 5;
        this.f3825k = 0.1f;
        this.f3832r = -1;
        this.f3835u = new LinkedHashSet();
        this.f3836v = new b(this, 0);
    }

    @Override // z.a
    public final void c(z.d dVar) {
        this.f3830p = null;
        this.f3823i = null;
    }

    @Override // z.a
    public final void e() {
        this.f3830p = null;
        this.f3823i = null;
    }

    @Override // z.a
    public final boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        s0.d dVar;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && k0.e(view) == null) || !this.g) {
            this.f3824j = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.f3833s) != null) {
            velocityTracker.recycle();
            this.f3833s = null;
        }
        if (this.f3833s == null) {
            this.f3833s = VelocityTracker.obtain();
        }
        this.f3833s.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f3834t = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f3824j) {
            this.f3824j = false;
            return false;
        }
        return (this.f3824j || (dVar = this.f3823i) == null || !dVar.p(motionEvent)) ? false : true;
    }

    @Override // z.a
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i10) {
        View view2;
        View view3;
        int i11;
        View findViewById;
        int i12 = 1;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        WeakReference weakReference = this.f3830p;
        j jVar = this.f3817b;
        int i13 = 0;
        if (weakReference == null) {
            this.f3830p = new WeakReference(view);
            new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
            Context context = view.getContext();
            w7.b.u(context, R.attr.motionDurationMedium2, 300);
            w7.b.u(context, R.attr.motionDurationShort3, 150);
            w7.b.u(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
            if (jVar != null) {
                view.setBackground(jVar);
                float f10 = this.f3821f;
                if (f10 == -1.0f) {
                    f10 = view.getElevation();
                }
                jVar.m(f10);
            } else {
                ColorStateList colorStateList = this.f3818c;
                if (colorStateList != null) {
                    WeakHashMap weakHashMap = k0.f8683a;
                    c0.g(view, colorStateList);
                }
            }
            int i14 = this.f3822h == 5 ? 4 : 0;
            if (view.getVisibility() != i14) {
                view.setVisibility(i14);
            }
            u();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (k0.e(view) == null) {
                k0.n(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        int i15 = Gravity.getAbsoluteGravity(((z.d) view.getLayoutParams()).f13934c, i10) == 3 ? 1 : 0;
        d dVar = this.f3816a;
        if (dVar == null || dVar.u() != i15) {
            z.d dVar2 = null;
            n nVar = this.f3819d;
            if (i15 == 0) {
                this.f3816a = new e9.a(this, i12);
                if (nVar != null) {
                    WeakReference weakReference2 = this.f3830p;
                    if (weakReference2 != null && (view3 = (View) weakReference2.get()) != null && (view3.getLayoutParams() instanceof z.d)) {
                        dVar2 = (z.d) view3.getLayoutParams();
                    }
                    if (dVar2 == null || ((ViewGroup.MarginLayoutParams) dVar2).rightMargin <= 0) {
                        m f11 = nVar.f();
                        f11.f4294f = new d9.a(0.0f);
                        f11.g = new d9.a(0.0f);
                        n a10 = f11.a();
                        if (jVar != null) {
                            jVar.setShapeAppearanceModel(a10);
                        }
                    }
                }
            } else {
                if (i15 != 1) {
                    throw new IllegalArgumentException(android.support.v4.media.d.o("Invalid sheet edge position value: ", i15, ". Must be 0 or 1."));
                }
                this.f3816a = new e9.a(this, i13);
                if (nVar != null) {
                    WeakReference weakReference3 = this.f3830p;
                    if (weakReference3 != null && (view2 = (View) weakReference3.get()) != null && (view2.getLayoutParams() instanceof z.d)) {
                        dVar2 = (z.d) view2.getLayoutParams();
                    }
                    if (dVar2 == null || ((ViewGroup.MarginLayoutParams) dVar2).leftMargin <= 0) {
                        m f12 = nVar.f();
                        f12.f4293e = new d9.a(0.0f);
                        f12.f4295h = new d9.a(0.0f);
                        n a11 = f12.a();
                        if (jVar != null) {
                            jVar.setShapeAppearanceModel(a11);
                        }
                    }
                }
            }
        }
        if (this.f3823i == null) {
            this.f3823i = new s0.d(coordinatorLayout.getContext(), coordinatorLayout, this.f3836v);
        }
        int s10 = this.f3816a.s(view);
        coordinatorLayout.q(view, i10);
        this.f3827m = coordinatorLayout.getWidth();
        this.f3828n = this.f3816a.t(coordinatorLayout);
        this.f3826l = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f3829o = marginLayoutParams != null ? this.f3816a.d(marginLayoutParams) : 0;
        int i16 = this.f3822h;
        if (i16 == 1 || i16 == 2) {
            i13 = s10 - this.f3816a.s(view);
        } else if (i16 != 3) {
            if (i16 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.f3822h);
            }
            i13 = this.f3816a.p();
        }
        WeakHashMap weakHashMap2 = k0.f8683a;
        view.offsetLeftAndRight(i13);
        if (this.f3831q == null && (i11 = this.f3832r) != -1 && (findViewById = coordinatorLayout.findViewById(i11)) != null) {
            this.f3831q = new WeakReference(findViewById);
        }
        Iterator it = this.f3835u.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
        return true;
    }

    @Override // z.a
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i10, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // z.a
    public final void m(View view, Parcelable parcelable) {
        int i10 = ((c) parcelable).f4673q;
        if (i10 == 1 || i10 == 2) {
            i10 = 5;
        }
        this.f3822h = i10;
    }

    @Override // z.a
    public final Parcelable n(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new c(this);
    }

    @Override // z.a
    public final boolean q(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3822h == 1 && actionMasked == 0) {
            return true;
        }
        if (s()) {
            this.f3823i.j(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f3833s) != null) {
            velocityTracker.recycle();
            this.f3833s = null;
        }
        if (this.f3833s == null) {
            this.f3833s = VelocityTracker.obtain();
        }
        this.f3833s.addMovement(motionEvent);
        if (s() && actionMasked == 2 && !this.f3824j && s()) {
            float abs = Math.abs(this.f3834t - motionEvent.getX());
            s0.d dVar = this.f3823i;
            if (abs > dVar.f11161b) {
                dVar.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f3824j;
    }

    public final void r(int i10) {
        View view;
        if (this.f3822h == i10) {
            return;
        }
        this.f3822h = i10;
        WeakReference weakReference = this.f3830p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i11 = this.f3822h == 5 ? 4 : 0;
        if (view.getVisibility() != i11) {
            view.setVisibility(i11);
        }
        Iterator it = this.f3835u.iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.d.l(it);
        }
        u();
    }

    public final boolean s() {
        if (this.f3823i != null) {
            return this.g || this.f3822h == 1;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
    
        if (r1.o(r0, r3.getTop()) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004d, code lost:
    
        r(2);
        r2.f3820e.c(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        if (r3 != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            r0 = 3
            if (r4 == r0) goto L19
            r0 = 5
            if (r4 != r0) goto Ld
            com.bumptech.glide.d r0 = r2.f3816a
            int r0 = r0.p()
            goto L1f
        Ld:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Invalid state to get outer edge offset: "
            java.lang.String r4 = android.support.v4.media.d.m(r4, r5)
            r3.<init>(r4)
            throw r3
        L19:
            com.bumptech.glide.d r0 = r2.f3816a
            int r0 = r0.o()
        L1f:
            s0.d r1 = r2.f3823i
            if (r1 == 0) goto L57
            if (r5 == 0) goto L30
            int r3 = r3.getTop()
            boolean r3 = r1.o(r0, r3)
            if (r3 == 0) goto L57
            goto L4d
        L30:
            int r5 = r3.getTop()
            r1.f11176r = r3
            r3 = -1
            r1.f11162c = r3
            r3 = 0
            boolean r3 = r1.h(r0, r5, r3, r3)
            if (r3 != 0) goto L4b
            int r5 = r1.f11160a
            if (r5 != 0) goto L4b
            android.view.View r5 = r1.f11176r
            if (r5 == 0) goto L4b
            r5 = 0
            r1.f11176r = r5
        L4b:
            if (r3 == 0) goto L57
        L4d:
            r3 = 2
            r2.r(r3)
            e9.d r3 = r2.f3820e
            r3.c(r4)
            return
        L57:
            r2.r(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.t(android.view.View, int, boolean):void");
    }

    public final void u() {
        View view;
        WeakReference weakReference = this.f3830p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        k0.j(view, 262144);
        k0.h(view, 0);
        k0.j(view, 1048576);
        k0.h(view, 0);
        int i10 = 5;
        if (this.f3822h != 5) {
            k0.k(view, n0.d.f9101j, new c5.a(i10, 1, this));
        }
        int i11 = 3;
        if (this.f3822h != 3) {
            k0.k(view, n0.d.f9099h, new c5.a(i11, 1, this));
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.f3820e = new e9.d(this);
        this.g = true;
        this.f3822h = 5;
        this.f3825k = 0.1f;
        this.f3832r = -1;
        this.f3835u = new LinkedHashSet();
        this.f3836v = new b(this, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j8.a.f7205z);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f3818c = d.l(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.f3819d = n.b(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).a();
        }
        if (obtainStyledAttributes.hasValue(5)) {
            int resourceId = obtainStyledAttributes.getResourceId(5, -1);
            this.f3832r = resourceId;
            WeakReference weakReference = this.f3831q;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f3831q = null;
            WeakReference weakReference2 = this.f3830p;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1 && view.isLaidOut()) {
                    view.requestLayout();
                }
            }
        }
        n nVar = this.f3819d;
        if (nVar != null) {
            j jVar = new j(nVar);
            this.f3817b = jVar;
            jVar.k(context);
            ColorStateList colorStateList = this.f3818c;
            if (colorStateList != null) {
                this.f3817b.n(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f3817b.setTint(typedValue.data);
            }
        }
        this.f3821f = obtainStyledAttributes.getDimension(2, -1.0f);
        this.g = obtainStyledAttributes.getBoolean(4, true);
        obtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
