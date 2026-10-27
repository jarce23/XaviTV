package m;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class z1 implements l.b0 {
    public static final Method O;
    public static final Method P;
    public static final Method Q;
    public x1 B;
    public View C;
    public AdapterView.OnItemClickListener D;
    public AdapterView.OnItemSelectedListener E;
    public final Handler J;
    public Rect L;
    public boolean M;
    public final x N;

    /* renamed from: o, reason: collision with root package name */
    public final Context f8609o;

    /* renamed from: p, reason: collision with root package name */
    public ListAdapter f8610p;

    /* renamed from: q, reason: collision with root package name */
    public o1 f8611q;

    /* renamed from: t, reason: collision with root package name */
    public int f8614t;

    /* renamed from: u, reason: collision with root package name */
    public int f8615u;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8617w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8618x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f8619y;

    /* renamed from: r, reason: collision with root package name */
    public final int f8612r = -2;

    /* renamed from: s, reason: collision with root package name */
    public int f8613s = -2;

    /* renamed from: v, reason: collision with root package name */
    public final int f8616v = 1002;

    /* renamed from: z, reason: collision with root package name */
    public int f8620z = 0;
    public final int A = Integer.MAX_VALUE;
    public final w1 F = new w1(this, 1);
    public final h5.q G = new h5.q(2, this);
    public final y1 H = new y1(this);
    public final w1 I = new w1(this, 0);
    public final Rect K = new Rect();

    static {
        int i10 = Build.VERSION.SDK_INT;
        Class cls = Boolean.TYPE;
        if (i10 <= 28) {
            try {
                O = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", cls);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                Q = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                P = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, cls);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public z1(Context context, AttributeSet attributeSet, int i10, int i11) {
        int resourceId;
        this.f8609o = context;
        this.J = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.a.f4371o, i10, 0);
        this.f8614t = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f8615u = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f8617w = true;
        }
        obtainStyledAttributes.recycle();
        x xVar = new x(context, attributeSet, i10, 0);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, e.a.f4375s, i10, 0);
        if (obtainStyledAttributes2.hasValue(2)) {
            xVar.setOverlapAnchor(obtainStyledAttributes2.getBoolean(2, false));
        }
        xVar.setBackgroundDrawable((!obtainStyledAttributes2.hasValue(0) || (resourceId = obtainStyledAttributes2.getResourceId(0, 0)) == 0) ? obtainStyledAttributes2.getDrawable(0) : n4.a.o(context, resourceId));
        obtainStyledAttributes2.recycle();
        this.N = xVar;
        xVar.setInputMethodMode(1);
    }

    @Override // l.b0
    public final boolean a() {
        return this.N.isShowing();
    }

    public final int b() {
        return this.f8614t;
    }

    @Override // l.b0
    public final void c() {
        int i10;
        int a10;
        int paddingBottom;
        o1 o1Var;
        o1 o1Var2 = this.f8611q;
        Context context = this.f8609o;
        x xVar = this.N;
        if (o1Var2 == null) {
            o1 p10 = p(context, !this.M);
            this.f8611q = p10;
            p10.setAdapter(this.f8610p);
            this.f8611q.setOnItemClickListener(this.D);
            this.f8611q.setFocusable(true);
            this.f8611q.setFocusableInTouchMode(true);
            this.f8611q.setOnItemSelectedListener(new app.shamel.tv.activities.f0(4, this));
            this.f8611q.setOnScrollListener(this.H);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.E;
            if (onItemSelectedListener != null) {
                this.f8611q.setOnItemSelectedListener(onItemSelectedListener);
            }
            xVar.setContentView(this.f8611q);
        }
        Drawable background = xVar.getBackground();
        Rect rect = this.K;
        if (background != null) {
            background.getPadding(rect);
            int i11 = rect.top;
            i10 = rect.bottom + i11;
            if (!this.f8617w) {
                this.f8615u = -i11;
            }
        } else {
            rect.setEmpty();
            i10 = 0;
        }
        boolean z10 = xVar.getInputMethodMode() == 2;
        View view = this.C;
        int i12 = this.f8615u;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = P;
            if (method != null) {
                try {
                    a10 = ((Integer) method.invoke(xVar, view, Integer.valueOf(i12), Boolean.valueOf(z10))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            a10 = xVar.getMaxAvailableHeight(view, i12);
        } else {
            a10 = u1.a(xVar, view, i12, z10);
        }
        int i13 = this.f8612r;
        if (i13 == -1) {
            paddingBottom = a10 + i10;
        } else {
            int i14 = this.f8613s;
            int a11 = this.f8611q.a(i14 != -2 ? i14 != -1 ? View.MeasureSpec.makeMeasureSpec(i14, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), a10);
            paddingBottom = a11 + (a11 > 0 ? this.f8611q.getPaddingBottom() + this.f8611q.getPaddingTop() + i10 : 0);
        }
        boolean z11 = xVar.getInputMethodMode() == 2;
        xVar.setWindowLayoutType(this.f8616v);
        if (xVar.isShowing()) {
            if (this.C.isAttachedToWindow()) {
                int i15 = this.f8613s;
                if (i15 == -1) {
                    i15 = -1;
                } else if (i15 == -2) {
                    i15 = this.C.getWidth();
                }
                if (i13 == -1) {
                    i13 = z11 ? paddingBottom : -1;
                    if (z11) {
                        xVar.setWidth(this.f8613s == -1 ? -1 : 0);
                        xVar.setHeight(0);
                    } else {
                        xVar.setWidth(this.f8613s == -1 ? -1 : 0);
                        xVar.setHeight(-1);
                    }
                } else if (i13 == -2) {
                    i13 = paddingBottom;
                }
                xVar.setOutsideTouchable(true);
                int i16 = i15;
                View view2 = this.C;
                int i17 = this.f8614t;
                int i18 = this.f8615u;
                int i19 = i16 < 0 ? -1 : i16;
                if (i13 < 0) {
                    i13 = -1;
                }
                xVar.update(view2, i17, i18, i19, i13);
                return;
            }
            return;
        }
        int i20 = this.f8613s;
        if (i20 == -1) {
            i20 = -1;
        } else if (i20 == -2) {
            i20 = this.C.getWidth();
        }
        if (i13 == -1) {
            i13 = -1;
        } else if (i13 == -2) {
            i13 = paddingBottom;
        }
        xVar.setWidth(i20);
        xVar.setHeight(i13);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = O;
            if (method2 != null) {
                try {
                    method2.invoke(xVar, Boolean.TRUE);
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            v1.b(xVar, true);
        }
        xVar.setOutsideTouchable(true);
        xVar.setTouchInterceptor(this.G);
        if (this.f8619y) {
            xVar.setOverlapAnchor(this.f8618x);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = Q;
            if (method3 != null) {
                try {
                    method3.invoke(xVar, this.L);
                } catch (Exception e7) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e7);
                }
            }
        } else {
            v1.a(xVar, this.L);
        }
        xVar.showAsDropDown(this.C, this.f8614t, this.f8615u, this.f8620z);
        this.f8611q.setSelection(-1);
        if ((!this.M || this.f8611q.isInTouchMode()) && (o1Var = this.f8611q) != null) {
            o1Var.setListSelectionHidden(true);
            o1Var.requestLayout();
        }
        if (this.M) {
            return;
        }
        this.J.post(this.I);
    }

    public final Drawable d() {
        return this.N.getBackground();
    }

    @Override // l.b0
    public final void dismiss() {
        x xVar = this.N;
        xVar.dismiss();
        xVar.setContentView(null);
        this.f8611q = null;
        this.J.removeCallbacks(this.F);
    }

    @Override // l.b0
    public final o1 f() {
        return this.f8611q;
    }

    public final void g(Drawable drawable) {
        this.N.setBackgroundDrawable(drawable);
    }

    public final void h(int i10) {
        this.f8615u = i10;
        this.f8617w = true;
    }

    public final void j(int i10) {
        this.f8614t = i10;
    }

    public final int l() {
        if (this.f8617w) {
            return this.f8615u;
        }
        return 0;
    }

    public void o(ListAdapter listAdapter) {
        x1 x1Var = this.B;
        if (x1Var == null) {
            this.B = new x1(this);
        } else {
            ListAdapter listAdapter2 = this.f8610p;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(x1Var);
            }
        }
        this.f8610p = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.B);
        }
        o1 o1Var = this.f8611q;
        if (o1Var != null) {
            o1Var.setAdapter(this.f8610p);
        }
    }

    public o1 p(Context context, boolean z10) {
        return new o1(context, z10);
    }

    public final void r(int i10) {
        Drawable background = this.N.getBackground();
        if (background == null) {
            this.f8613s = i10;
            return;
        }
        Rect rect = this.K;
        background.getPadding(rect);
        this.f8613s = rect.left + rect.right + i10;
    }
}
