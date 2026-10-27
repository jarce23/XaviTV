package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import androidx.activity.h;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b4.m;
import d9.j;
import d9.n;
import e9.b;
import e9.d;
import io.realm.internal.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import m0.c0;
import m0.k0;
import m0.s0;
import m0.t0;
import m0.u0;
import org.chromium.net.R;
import x4.r;
import x8.l;
import z.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends a {
    public final d A;
    public final ValueAnimator B;
    public final int C;
    public int D;
    public int E;
    public final float F;
    public int G;
    public final float H;
    public boolean I;
    public boolean J;
    public final boolean K;
    public final boolean L;
    public boolean M;
    public int N;
    public s0.d O;
    public boolean P;
    public int Q;
    public boolean R;
    public final float S;
    public int T;
    public int U;
    public int V;
    public WeakReference W;
    public WeakReference X;
    public final ArrayList Y;
    public VelocityTracker Z;

    /* renamed from: a, reason: collision with root package name */
    public final int f3680a;

    /* renamed from: a0, reason: collision with root package name */
    public int f3681a0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3682b;

    /* renamed from: b0, reason: collision with root package name */
    public int f3683b0;

    /* renamed from: c, reason: collision with root package name */
    public final float f3684c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f3685c0;

    /* renamed from: d, reason: collision with root package name */
    public final int f3686d;

    /* renamed from: d0, reason: collision with root package name */
    public HashMap f3687d0;

    /* renamed from: e, reason: collision with root package name */
    public int f3688e;

    /* renamed from: e0, reason: collision with root package name */
    public final SparseIntArray f3689e0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3690f;

    /* renamed from: f0, reason: collision with root package name */
    public final b f3691f0;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3692h;

    /* renamed from: i, reason: collision with root package name */
    public final j f3693i;

    /* renamed from: j, reason: collision with root package name */
    public final ColorStateList f3694j;

    /* renamed from: k, reason: collision with root package name */
    public final int f3695k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3696l;

    /* renamed from: m, reason: collision with root package name */
    public int f3697m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f3698n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f3699o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f3700p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f3701q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f3702r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f3703s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f3704t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f3705u;

    /* renamed from: v, reason: collision with root package name */
    public int f3706v;

    /* renamed from: w, reason: collision with root package name */
    public int f3707w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f3708x;

    /* renamed from: y, reason: collision with root package name */
    public final n f3709y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f3710z;

    public BottomSheetBehavior() {
        this.f3680a = 0;
        this.f3682b = true;
        this.f3695k = -1;
        this.f3696l = -1;
        this.A = new d(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = true;
        this.N = 4;
        this.S = 0.1f;
        this.Y = new ArrayList();
        this.f3683b0 = -1;
        this.f3689e0 = new SparseIntArray();
        this.f3691f0 = new b(this, 1);
    }

    public static View v(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View v10 = v(viewGroup.getChildAt(i10));
            if (v10 != null) {
                return v10;
            }
        }
        return null;
    }

    public static int w(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    public final void A(int i10) {
        if (i10 == -1) {
            if (this.f3690f) {
                return;
            } else {
                this.f3690f = true;
            }
        } else {
            if (!this.f3690f && this.f3688e == i10) {
                return;
            }
            this.f3690f = false;
            this.f3688e = Math.max(0, i10);
        }
        I();
    }

    public final void B(int i10) {
        if (i10 == 1 || i10 == 2) {
            throw new IllegalArgumentException(android.support.v4.media.d.r(new StringBuilder("STATE_"), i10 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.I && i10 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i10);
            return;
        }
        int i11 = (i10 == 6 && this.f3682b && y(i10) <= this.D) ? 3 : i10;
        WeakReference weakReference = this.W;
        if (weakReference == null || weakReference.get() == null) {
            C(i10);
            return;
        }
        View view = (View) this.W.get();
        h hVar = new h(this, view, i11);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            view.post(hVar);
        } else {
            hVar.run();
        }
    }

    public final void C(int i10) {
        if (this.N == i10) {
            return;
        }
        this.N = i10;
        if (i10 != 4 && i10 != 3 && i10 != 6) {
            boolean z10 = this.I;
        }
        WeakReference weakReference = this.W;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i10 == 3) {
            H(true);
        } else if (i10 == 6 || i10 == 5 || i10 == 4) {
            H(false);
        }
        G(i10, true);
        ArrayList arrayList = this.Y;
        if (arrayList.size() > 0) {
            throw android.support.v4.media.d.k(0, arrayList);
        }
        F();
    }

    public final boolean D(View view, float f10) {
        if (this.J) {
            return true;
        }
        if (view.getTop() < this.G) {
            return false;
        }
        return Math.abs(((f10 * this.S) + ((float) view.getTop())) - ((float) this.G)) / ((float) t()) > 0.5f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if (r3 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        if (r1.o(r3.getLeft(), r0) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0032, code lost:
    
        C(2);
        G(r4, true);
        r2.A.c(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            int r0 = r2.y(r4)
            s0.d r1 = r2.O
            if (r1 == 0) goto L40
            if (r5 == 0) goto L15
            int r3 = r3.getLeft()
            boolean r3 = r1.o(r3, r0)
            if (r3 == 0) goto L40
            goto L32
        L15:
            int r5 = r3.getLeft()
            r1.f11176r = r3
            r3 = -1
            r1.f11162c = r3
            r3 = 0
            boolean r3 = r1.h(r5, r0, r3, r3)
            if (r3 != 0) goto L30
            int r5 = r1.f11160a
            if (r5 != 0) goto L30
            android.view.View r5 = r1.f11176r
            if (r5 == 0) goto L30
            r5 = 0
            r1.f11176r = r5
        L30:
            if (r3 == 0) goto L40
        L32:
            r3 = 2
            r2.C(r3)
            r3 = 1
            r2.G(r4, r3)
            e9.d r3 = r2.A
            r3.c(r4)
            return
        L40:
            r2.C(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.E(android.view.View, int, boolean):void");
    }

    public final void F() {
        View view;
        int i10;
        WeakReference weakReference = this.W;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        k0.j(view, 524288);
        k0.h(view, 0);
        k0.j(view, 262144);
        k0.h(view, 0);
        k0.j(view, 1048576);
        k0.h(view, 0);
        SparseIntArray sparseIntArray = this.f3689e0;
        int i11 = sparseIntArray.get(0, -1);
        if (i11 != -1) {
            k0.j(view, i11);
            k0.h(view, 0);
            sparseIntArray.delete(0);
        }
        if (!this.f3682b && this.N != 6) {
            String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            app.shamel.tv.b bVar = new app.shamel.tv.b(r5, 10, this);
            ArrayList f10 = k0.f(view);
            int i12 = 0;
            while (true) {
                if (i12 >= f10.size()) {
                    int i13 = 0;
                    int i14 = -1;
                    while (true) {
                        int[] iArr = k0.f8686d;
                        if (i13 >= 32 || i14 != -1) {
                            break;
                        }
                        int i15 = iArr[i13];
                        boolean z10 = true;
                        for (int i16 = 0; i16 < f10.size(); i16++) {
                            z10 &= ((n0.d) f10.get(i16)).a() != i15;
                        }
                        if (z10) {
                            i14 = i15;
                        }
                        i13++;
                    }
                    i10 = i14;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((n0.d) f10.get(i12)).f9106a).getLabel())) {
                        i10 = ((n0.d) f10.get(i12)).a();
                        break;
                    }
                    i12++;
                }
            }
            if (i10 != -1) {
                n0.d dVar = new n0.d(null, i10, string, bVar, null);
                View.AccessibilityDelegate d6 = k0.d(view);
                m0.b bVar2 = d6 == null ? null : d6 instanceof m0.a ? ((m0.a) d6).f8635a : new m0.b(d6);
                if (bVar2 == null) {
                    bVar2 = new m0.b();
                }
                k0.m(view, bVar2);
                k0.j(view, dVar.a());
                k0.f(view).add(dVar);
                k0.h(view, 0);
            }
            sparseIntArray.put(0, i10);
        }
        if (this.I) {
            int i17 = 5;
            if (this.N != 5) {
                k0.k(view, n0.d.f9101j, new app.shamel.tv.b(i17, 10, this));
            }
        }
        int i18 = this.N;
        int i19 = 4;
        int i20 = 3;
        if (i18 == 3) {
            k0.k(view, n0.d.f9100i, new app.shamel.tv.b(this.f3682b ? 4 : 6, 10, this));
            return;
        }
        if (i18 == 4) {
            k0.k(view, n0.d.f9099h, new app.shamel.tv.b(this.f3682b ? 3 : 6, 10, this));
        } else {
            if (i18 != 6) {
                return;
            }
            k0.k(view, n0.d.f9100i, new app.shamel.tv.b(i19, 10, this));
            k0.k(view, n0.d.f9099h, new app.shamel.tv.b(i20, 10, this));
        }
    }

    public final void G(int i10, boolean z10) {
        j jVar;
        if (i10 == 2) {
            return;
        }
        boolean z11 = this.N == 3 && (this.f3708x || z());
        if (this.f3710z == z11 || (jVar = this.f3693i) == null) {
            return;
        }
        this.f3710z = z11;
        ValueAnimator valueAnimator = this.B;
        if (z10 && valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                valueAnimator.reverse();
                return;
            } else {
                valueAnimator.setFloatValues(jVar.f4277p.f4267j, z11 ? s() : 1.0f);
                valueAnimator.start();
                return;
            }
        }
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        float s10 = this.f3710z ? s() : 1.0f;
        d9.h hVar = jVar.f4277p;
        if (hVar.f4267j != s10) {
            hVar.f4267j = s10;
            jVar.f4281t = true;
            jVar.f4282u = true;
            jVar.invalidateSelf();
        }
    }

    public final void H(boolean z10) {
        WeakReference weakReference = this.W;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                if (this.f3687d0 != null) {
                    return;
                } else {
                    this.f3687d0 = new HashMap(childCount);
                }
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (childAt != this.W.get() && z10) {
                    this.f3687d0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z10) {
                return;
            }
            this.f3687d0 = null;
        }
    }

    public final void I() {
        View view;
        if (this.W != null) {
            r();
            if (this.N != 4 || (view = (View) this.W.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // z.a
    public final void c(z.d dVar) {
        this.W = null;
        this.O = null;
    }

    @Override // z.a
    public final void e() {
        this.W = null;
        this.O = null;
    }

    @Override // z.a
    public final boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i10;
        s0.d dVar;
        if (!view.isShown() || !this.K) {
            this.P = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3681a0 = -1;
            this.f3683b0 = -1;
            VelocityTracker velocityTracker = this.Z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Z = null;
            }
        }
        if (this.Z == null) {
            this.Z = VelocityTracker.obtain();
        }
        this.Z.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x6 = (int) motionEvent.getX();
            int y8 = (int) motionEvent.getY();
            this.f3683b0 = y8;
            if (this.N != 2) {
                WeakReference weakReference = this.X;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.o(view2, x6, y8)) {
                    this.f3681a0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f3685c0 = true;
                }
            }
            this.P = this.f3681a0 == -1 && !coordinatorLayout.o(view, x6, this.f3683b0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f3685c0 = false;
            this.f3681a0 = -1;
            if (this.P) {
                this.P = false;
                return false;
            }
        }
        if (this.P || (dVar = this.O) == null || !dVar.p(motionEvent)) {
            WeakReference weakReference2 = this.X;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.P || this.N == 1 || coordinatorLayout.o(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.O == null || (i10 = this.f3683b0) == -1 || Math.abs(i10 - motionEvent.getY()) <= this.O.f11161b) {
                return false;
            }
        }
        return true;
    }

    @Override // z.a
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i10) {
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.W == null) {
            this.g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            int i11 = Build.VERSION.SDK_INT;
            boolean z10 = (i11 < 29 || this.f3698n || this.f3690f) ? false : true;
            if (this.f3699o || this.f3700p || this.f3701q || this.f3703s || this.f3704t || this.f3705u || z10) {
                ea.a aVar = new ea.a(this, z10);
                int paddingStart = view.getPaddingStart();
                view.getPaddingTop();
                int paddingEnd = view.getPaddingEnd();
                int paddingBottom = view.getPaddingBottom();
                i2.j jVar = new i2.j();
                jVar.f6217a = paddingStart;
                jVar.f6218b = paddingEnd;
                jVar.f6219c = paddingBottom;
                r rVar = new r(aVar, 17, jVar);
                WeakHashMap weakHashMap = k0.f8683a;
                c0.j(view, rVar);
                if (view.isAttachedToWindow()) {
                    view.requestApplyInsets();
                } else {
                    view.addOnAttachStateChangeListener(new l());
                }
            }
            p pVar = new p(view);
            WeakHashMap weakHashMap2 = k0.f8683a;
            if (i11 >= 30) {
                view.setWindowInsetsAnimationCallback(new u0(pVar));
            } else {
                PathInterpolator pathInterpolator = t0.f8717e;
                View.OnApplyWindowInsetsListener s0Var = new s0(view, pVar);
                view.setTag(R.id.tag_window_insets_animation_callback, s0Var);
                if (view.getTag(R.id.tag_compat_insets_dispatch) == null && view.getTag(R.id.tag_on_apply_window_listener) == null) {
                    view.setOnApplyWindowInsetsListener(s0Var);
                }
            }
            this.W = new WeakReference(view);
            new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
            Context context = view.getContext();
            w7.b.u(context, R.attr.motionDurationMedium2, 300);
            w7.b.u(context, R.attr.motionDurationShort3, 150);
            w7.b.u(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
            j jVar2 = this.f3693i;
            if (jVar2 != null) {
                view.setBackground(jVar2);
                float f10 = this.H;
                if (f10 == -1.0f) {
                    f10 = view.getElevation();
                }
                jVar2.m(f10);
            } else {
                ColorStateList colorStateList = this.f3694j;
                if (colorStateList != null) {
                    c0.g(view, colorStateList);
                }
            }
            F();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.O == null) {
            this.O = new s0.d(coordinatorLayout.getContext(), coordinatorLayout, this.f3691f0);
        }
        int top = view.getTop();
        coordinatorLayout.q(view, i10);
        this.U = coordinatorLayout.getWidth();
        this.V = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.T = height;
        int i12 = this.V;
        int i13 = i12 - height;
        int i14 = this.f3707w;
        if (i13 < i14) {
            boolean z11 = this.f3702r;
            int i15 = this.f3696l;
            if (z11) {
                if (i15 != -1) {
                    i12 = Math.min(i12, i15);
                }
                this.T = i12;
            } else {
                int i16 = i12 - i14;
                if (i15 != -1) {
                    i16 = Math.min(i16, i15);
                }
                this.T = i16;
            }
        }
        this.D = Math.max(0, this.V - this.T);
        this.E = (int) ((1.0f - this.F) * this.V);
        r();
        int i17 = this.N;
        if (i17 == 3) {
            int x6 = x();
            WeakHashMap weakHashMap3 = k0.f8683a;
            view.offsetTopAndBottom(x6);
        } else if (i17 == 6) {
            int i18 = this.E;
            WeakHashMap weakHashMap4 = k0.f8683a;
            view.offsetTopAndBottom(i18);
        } else if (this.I && i17 == 5) {
            int i19 = this.V;
            WeakHashMap weakHashMap5 = k0.f8683a;
            view.offsetTopAndBottom(i19);
        } else if (i17 == 4) {
            int i20 = this.G;
            WeakHashMap weakHashMap6 = k0.f8683a;
            view.offsetTopAndBottom(i20);
        } else if (i17 == 1 || i17 == 2) {
            int top2 = top - view.getTop();
            WeakHashMap weakHashMap7 = k0.f8683a;
            view.offsetTopAndBottom(top2);
        }
        G(this.N, false);
        this.X = new WeakReference(v(view));
        ArrayList arrayList = this.Y;
        if (arrayList.size() <= 0) {
            return true;
        }
        throw android.support.v4.media.d.k(0, arrayList);
    }

    @Override // z.a
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(w(i10, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.f3695k, marginLayoutParams.width), w(i12, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.f3696l, marginLayoutParams.height));
        return true;
    }

    @Override // z.a
    public final boolean i(View view) {
        WeakReference weakReference = this.X;
        return (weakReference == null || view != weakReference.get() || this.N == 3 || this.M) ? false : true;
    }

    @Override // z.a
    public final void j(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 1) {
            return;
        }
        WeakReference weakReference = this.X;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != view3) {
            return;
        }
        int top = view.getTop();
        int i13 = top - i11;
        boolean z10 = this.K;
        boolean z11 = this.L;
        if (i11 > 0) {
            if (!this.R && !z11 && view2 == view3 && view2.canScrollVertically(1)) {
                this.M = true;
                return;
            }
            if (i13 < x()) {
                int x6 = top - x();
                iArr[1] = x6;
                WeakHashMap weakHashMap = k0.f8683a;
                view.offsetTopAndBottom(-x6);
                C(3);
            } else {
                if (!z10) {
                    return;
                }
                iArr[1] = i11;
                WeakHashMap weakHashMap2 = k0.f8683a;
                view.offsetTopAndBottom(-i11);
                C(1);
            }
        } else if (i11 < 0) {
            boolean canScrollVertically = view2.canScrollVertically(-1);
            if (!this.R && !z11 && view2 == view3 && canScrollVertically) {
                this.M = true;
                return;
            }
            if (!canScrollVertically) {
                int i14 = this.G;
                if (i13 > i14 && !this.I) {
                    int i15 = top - i14;
                    iArr[1] = i15;
                    WeakHashMap weakHashMap3 = k0.f8683a;
                    view.offsetTopAndBottom(-i15);
                    C(4);
                } else {
                    if (!z10) {
                        return;
                    }
                    iArr[1] = i11;
                    WeakHashMap weakHashMap4 = k0.f8683a;
                    view.offsetTopAndBottom(-i11);
                    C(1);
                }
            }
        }
        u(view.getTop());
        this.Q = i11;
        this.R = true;
        this.M = false;
    }

    @Override // z.a
    public final void m(View view, Parcelable parcelable) {
        o8.a aVar = (o8.a) parcelable;
        int i10 = this.f3680a;
        if (i10 != 0) {
            if (i10 == -1 || (i10 & 1) == 1) {
                this.f3688e = aVar.f9561r;
            }
            if (i10 == -1 || (i10 & 2) == 2) {
                this.f3682b = aVar.f9562s;
            }
            if (i10 == -1 || (i10 & 4) == 4) {
                this.I = aVar.f9563t;
            }
            if (i10 == -1 || (i10 & 8) == 8) {
                this.J = aVar.f9564u;
            }
        }
        int i11 = aVar.f9560q;
        if (i11 == 1 || i11 == 2) {
            this.N = 4;
        } else {
            this.N = i11;
        }
    }

    @Override // z.a
    public final Parcelable n(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new o8.a(this);
    }

    @Override // z.a
    public final boolean o(View view, int i10, int i11) {
        this.Q = 0;
        this.R = false;
        return (i10 & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r4.getTop() <= r3.E) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        if (java.lang.Math.abs(r5 - r3.D) < java.lang.Math.abs(r5 - r3.G)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
    
        if (r5 < java.lang.Math.abs(r5 - r3.G)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0090, code lost:
    
        if (java.lang.Math.abs(r5 - r2) < java.lang.Math.abs(r5 - r3.G)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ac, code lost:
    
        if (java.lang.Math.abs(r5 - r3.E) < java.lang.Math.abs(r5 - r3.G)) goto L50;
     */
    @Override // z.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(android.view.View r4, android.view.View r5, int r6) {
        /*
            r3 = this;
            int r6 = r4.getTop()
            int r0 = r3.x()
            r1 = 3
            if (r6 != r0) goto Lf
            r3.C(r1)
            return
        Lf:
            java.lang.ref.WeakReference r6 = r3.X
            if (r6 == 0) goto Lb5
            java.lang.Object r6 = r6.get()
            if (r5 != r6) goto Lb5
            boolean r5 = r3.R
            if (r5 != 0) goto L1f
            goto Lb5
        L1f:
            int r5 = r3.Q
            r6 = 6
            if (r5 <= 0) goto L34
            boolean r5 = r3.f3682b
            if (r5 == 0) goto L2a
            goto Laf
        L2a:
            int r5 = r4.getTop()
            int r0 = r3.E
            if (r5 <= r0) goto Laf
            goto Lae
        L34:
            boolean r5 = r3.I
            if (r5 == 0) goto L55
            android.view.VelocityTracker r5 = r3.Z
            if (r5 != 0) goto L3e
            r5 = 0
            goto L4d
        L3e:
            r0 = 1000(0x3e8, float:1.401E-42)
            float r2 = r3.f3684c
            r5.computeCurrentVelocity(r0, r2)
            android.view.VelocityTracker r5 = r3.Z
            int r0 = r3.f3681a0
            float r5 = r5.getYVelocity(r0)
        L4d:
            boolean r5 = r3.D(r4, r5)
            if (r5 == 0) goto L55
            r1 = 5
            goto Laf
        L55:
            int r5 = r3.Q
            r0 = 4
            if (r5 != 0) goto L93
            int r5 = r4.getTop()
            boolean r2 = r3.f3682b
            if (r2 == 0) goto L74
            int r6 = r3.D
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r2 = r3.G
            int r5 = r5 - r2
            int r5 = java.lang.Math.abs(r5)
            if (r6 >= r5) goto L97
            goto Laf
        L74:
            int r2 = r3.E
            if (r5 >= r2) goto L83
            int r0 = r3.G
            int r0 = r5 - r0
            int r0 = java.lang.Math.abs(r0)
            if (r5 >= r0) goto Lae
            goto Laf
        L83:
            int r1 = r5 - r2
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.G
            int r5 = r5 - r2
            int r5 = java.lang.Math.abs(r5)
            if (r1 >= r5) goto L97
            goto Lae
        L93:
            boolean r5 = r3.f3682b
            if (r5 == 0) goto L99
        L97:
            r1 = r0
            goto Laf
        L99:
            int r5 = r4.getTop()
            int r1 = r3.E
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.G
            int r5 = r5 - r2
            int r5 = java.lang.Math.abs(r5)
            if (r1 >= r5) goto L97
        Lae:
            r1 = r6
        Laf:
            r5 = 0
            r3.E(r4, r1, r5)
            r3.R = r5
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.p(android.view.View, android.view.View, int):void");
    }

    @Override // z.a
    public final boolean q(View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i10 = this.N;
        if (i10 == 1 && actionMasked == 0) {
            return true;
        }
        s0.d dVar = this.O;
        if (dVar != null && (this.K || i10 == 1)) {
            dVar.j(motionEvent);
        }
        if (actionMasked == 0) {
            this.f3681a0 = -1;
            this.f3683b0 = -1;
            VelocityTracker velocityTracker = this.Z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Z = null;
            }
        }
        if (this.Z == null) {
            this.Z = VelocityTracker.obtain();
        }
        this.Z.addMovement(motionEvent);
        if (this.O != null && ((this.K || this.N == 1) && actionMasked == 2 && !this.P)) {
            float abs = Math.abs(this.f3683b0 - motionEvent.getY());
            s0.d dVar2 = this.O;
            if (abs > dVar2.f11161b) {
                dVar2.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.P;
    }

    public final void r() {
        int t3 = t();
        if (this.f3682b) {
            this.G = Math.max(this.V - t3, this.D);
        } else {
            this.G = this.V - t3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float s() {
        /*
            r5 = this;
            d9.j r0 = r5.f3693i
            r1 = 0
            if (r0 == 0) goto L89
            java.lang.ref.WeakReference r0 = r5.W
            if (r0 == 0) goto L89
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L89
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L89
            java.lang.ref.WeakReference r0 = r5.W
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r5.z()
            if (r2 == 0) goto L89
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L89
            d9.j r2 = r5.f3693i
            float[] r3 = r2.P
            if (r3 == 0) goto L33
            r2 = 3
            r2 = r3[r2]
            goto L41
        L33:
            d9.h r3 = r2.f4277p
            d9.n r3 = r3.f4259a
            d9.d r3 = r3.f4304e
            android.graphics.RectF r2 = r2.g()
            float r2 = r3.a(r2)
        L41:
            android.view.RoundedCorner r3 = a9.e.o(r0)
            if (r3 == 0) goto L56
            int r3 = a9.e.e(r3)
            float r3 = (float) r3
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 <= 0) goto L56
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L56
            float r3 = r3 / r2
            goto L57
        L56:
            r3 = r1
        L57:
            d9.j r2 = r5.f3693i
            float[] r4 = r2.P
            if (r4 == 0) goto L61
            r2 = 0
            r2 = r4[r2]
            goto L6f
        L61:
            d9.h r4 = r2.f4277p
            d9.n r4 = r4.f4259a
            d9.d r4 = r4.f4305f
            android.graphics.RectF r2 = r2.g()
            float r2 = r4.a(r2)
        L6f:
            android.view.RoundedCorner r0 = a9.e.A(r0)
            if (r0 == 0) goto L84
            int r0 = a9.e.e(r0)
            float r0 = (float) r0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L84
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L84
            float r1 = r0 / r2
        L84:
            float r0 = java.lang.Math.max(r3, r1)
            return r0
        L89:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.s():float");
    }

    public final int t() {
        int i10;
        return this.f3690f ? Math.min(Math.max(this.g, this.V - ((this.U * 9) / 16)), this.T) + this.f3706v : (this.f3698n || this.f3699o || (i10 = this.f3697m) <= 0) ? this.f3688e + this.f3706v : Math.max(this.f3688e, i10 + this.f3692h);
    }

    public final void u(int i10) {
        if (((View) this.W.get()) != null) {
            ArrayList arrayList = this.Y;
            if (arrayList.isEmpty()) {
                return;
            }
            int i11 = this.G;
            if (i10 <= i11 && i11 != x()) {
                x();
            }
            if (arrayList.size() > 0) {
                throw android.support.v4.media.d.k(0, arrayList);
            }
        }
    }

    public final int x() {
        if (this.f3682b) {
            return this.D;
        }
        return Math.max(this.C, this.f3702r ? 0 : this.f3707w);
    }

    public final int y(int i10) {
        if (i10 == 3) {
            return x();
        }
        if (i10 == 4) {
            return this.G;
        }
        if (i10 == 5) {
            return this.V;
        }
        if (i10 == 6) {
            return this.E;
        }
        throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Invalid state to get top offset: "));
    }

    public final boolean z() {
        WeakReference weakReference = this.W;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.W.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i10;
        this.f3680a = 0;
        this.f3682b = true;
        this.f3695k = -1;
        this.f3696l = -1;
        this.A = new d(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = true;
        this.N = 4;
        this.S = 0.1f;
        this.Y = new ArrayList();
        this.f3683b0 = -1;
        this.f3689e0 = new SparseIntArray();
        this.f3691f0 = new b(this, 1);
        this.f3692h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j8.a.f7181a);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f3694j = com.bumptech.glide.d.l(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(22)) {
            this.f3709y = n.b(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).a();
        }
        n nVar = this.f3709y;
        if (nVar != null) {
            j jVar = new j(nVar);
            this.f3693i = jVar;
            jVar.k(context);
            ColorStateList colorStateList = this.f3694j;
            if (colorStateList != null) {
                this.f3693i.n(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f3693i.setTint(typedValue.data);
            }
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(s(), 1.0f);
        this.B = ofFloat;
        ofFloat.setDuration(500L);
        this.B.addUpdateListener(new m(2, this));
        this.H = obtainStyledAttributes.getDimension(2, -1.0f);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f3695k = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f3696l = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(10);
        if (peekValue != null && (i10 = peekValue.data) == -1) {
            A(i10);
        } else {
            A(obtainStyledAttributes.getDimensionPixelSize(10, -1));
        }
        boolean z10 = obtainStyledAttributes.getBoolean(9, false);
        if (this.I != z10) {
            this.I = z10;
            if (!z10 && this.N == 5) {
                B(4);
            }
            F();
        }
        this.f3698n = obtainStyledAttributes.getBoolean(14, false);
        boolean z11 = obtainStyledAttributes.getBoolean(7, true);
        if (this.f3682b != z11) {
            this.f3682b = z11;
            if (this.W != null) {
                r();
            }
            C((this.f3682b && this.N == 6) ? 3 : this.N);
            G(this.N, true);
            F();
        }
        this.J = obtainStyledAttributes.getBoolean(13, false);
        this.K = obtainStyledAttributes.getBoolean(4, true);
        this.L = obtainStyledAttributes.getBoolean(5, true);
        this.f3680a = obtainStyledAttributes.getInt(11, 0);
        float f10 = obtainStyledAttributes.getFloat(8, 0.5f);
        if (f10 > 0.0f && f10 < 1.0f) {
            this.F = f10;
            if (this.W != null) {
                this.E = (int) ((1.0f - f10) * this.V);
            }
            TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
            if (peekValue2 != null && peekValue2.type == 16) {
                int i11 = peekValue2.data;
                if (i11 >= 0) {
                    this.C = i11;
                    G(this.N, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
                if (dimensionPixelOffset >= 0) {
                    this.C = dimensionPixelOffset;
                    G(this.N, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.f3686d = obtainStyledAttributes.getInt(12, 500);
            this.f3699o = obtainStyledAttributes.getBoolean(18, false);
            this.f3700p = obtainStyledAttributes.getBoolean(19, false);
            this.f3701q = obtainStyledAttributes.getBoolean(20, false);
            this.f3702r = obtainStyledAttributes.getBoolean(21, true);
            this.f3703s = obtainStyledAttributes.getBoolean(15, false);
            this.f3704t = obtainStyledAttributes.getBoolean(16, false);
            this.f3705u = obtainStyledAttributes.getBoolean(17, false);
            this.f3708x = obtainStyledAttributes.getBoolean(24, true);
            obtainStyledAttributes.recycle();
            this.f3684c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    @Override // z.a
    public final void k(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int[] iArr) {
    }
}
