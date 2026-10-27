package m;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c3 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: y, reason: collision with root package name */
    public static c3 f8384y;

    /* renamed from: z, reason: collision with root package name */
    public static c3 f8385z;

    /* renamed from: o, reason: collision with root package name */
    public final View f8386o;

    /* renamed from: p, reason: collision with root package name */
    public final CharSequence f8387p;

    /* renamed from: q, reason: collision with root package name */
    public final int f8388q;

    /* renamed from: r, reason: collision with root package name */
    public final b3 f8389r;

    /* renamed from: s, reason: collision with root package name */
    public final b3 f8390s;

    /* renamed from: t, reason: collision with root package name */
    public int f8391t;

    /* renamed from: u, reason: collision with root package name */
    public int f8392u;

    /* renamed from: v, reason: collision with root package name */
    public d3 f8393v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8394w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8395x;

    /* JADX WARN: Type inference failed for: r0v0, types: [m.b3] */
    /* JADX WARN: Type inference failed for: r0v1, types: [m.b3] */
    public c3(View view, CharSequence charSequence) {
        final int i10 = 0;
        this.f8389r = new Runnable(this) { // from class: m.b3

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ c3 f8373p;

            {
                this.f8373p = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i10) {
                    case 0:
                        this.f8373p.c(false);
                        break;
                    default:
                        this.f8373p.a();
                        break;
                }
            }
        };
        final int i11 = 1;
        this.f8390s = new Runnable(this) { // from class: m.b3

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ c3 f8373p;

            {
                this.f8373p = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i11) {
                    case 0:
                        this.f8373p.c(false);
                        break;
                    default:
                        this.f8373p.a();
                        break;
                }
            }
        };
        this.f8386o = view;
        this.f8387p = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = m0.l0.f8690a;
        this.f8388q = Build.VERSION.SDK_INT >= 28 ? c0.b.k(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.f8395x = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(c3 c3Var) {
        c3 c3Var2 = f8384y;
        if (c3Var2 != null) {
            c3Var2.f8386o.removeCallbacks(c3Var2.f8389r);
        }
        f8384y = c3Var;
        if (c3Var != null) {
            c3Var.f8386o.postDelayed(c3Var.f8389r, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        c3 c3Var = f8385z;
        View view = this.f8386o;
        if (c3Var == this) {
            f8385z = null;
            d3 d3Var = this.f8393v;
            if (d3Var != null) {
                View view2 = (View) d3Var.f8399p;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) d3Var.f8398o).getSystemService("window")).removeView(view2);
                }
                this.f8393v = null;
                this.f8395x = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f8384y == this) {
            b(null);
        }
        view.removeCallbacks(this.f8390s);
    }

    public final void c(boolean z10) {
        int height;
        int i10;
        int i11;
        boolean z11;
        int i12;
        int i13;
        long longPressTimeout;
        long j10;
        long j11;
        View view = this.f8386o;
        if (view.isAttachedToWindow()) {
            b(null);
            c3 c3Var = f8385z;
            if (c3Var != null) {
                c3Var.a();
            }
            f8385z = this;
            this.f8394w = z10;
            Context context = view.getContext();
            d3 d3Var = new d3();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            d3Var.f8401r = layoutParams;
            d3Var.f8402s = new Rect();
            d3Var.f8403t = new int[2];
            d3Var.f8404u = new int[2];
            d3Var.f8398o = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
            d3Var.f8399p = inflate;
            d3Var.f8400q = (TextView) inflate.findViewById(R.id.message);
            layoutParams.setTitle(d3.class.getSimpleName());
            layoutParams.packageName = context.getPackageName();
            layoutParams.type = 1002;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
            layoutParams.flags = 24;
            View view2 = (View) d3Var.f8399p;
            Context context2 = (Context) d3Var.f8398o;
            this.f8393v = d3Var;
            int i14 = this.f8391t;
            int i15 = this.f8392u;
            boolean z12 = this.f8394w;
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) d3Var.f8401r;
            if (view2.getParent() != null && view2.getParent() != null) {
                ((WindowManager) context2.getSystemService("window")).removeView(view2);
            }
            ((TextView) d3Var.f8400q).setText(this.f8387p);
            int[] iArr = (int[]) d3Var.f8404u;
            int[] iArr2 = (int[]) d3Var.f8403t;
            Rect rect = (Rect) d3Var.f8402s;
            layoutParams2.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                i14 = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                height = i15 + dimensionPixelOffset2;
                i10 = i15 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i10 = 0;
            }
            layoutParams2.gravity = 49;
            int dimensionPixelOffset3 = context2.getResources().getDimensionPixelOffset(z12 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams3 = rootView.getLayoutParams();
            int i16 = i14;
            if (!(layoutParams3 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams3).type != 2) {
                Context context3 = view.getContext();
                while (true) {
                    if (!(context3 instanceof ContextWrapper)) {
                        break;
                    }
                    if (context3 instanceof Activity) {
                        rootView = ((Activity) context3).getWindow().getDecorView();
                        break;
                    }
                    context3 = ((ContextWrapper) context3).getBaseContext();
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
                i13 = 1;
            } else {
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i11 = i10;
                    z11 = z12;
                    i12 = 0;
                    i13 = 1;
                } else {
                    Resources resources = context2.getResources();
                    i13 = 1;
                    i11 = i10;
                    z11 = z12;
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i12 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(iArr);
                view.getLocationOnScreen(iArr2);
                int i17 = iArr2[i12] - iArr[i12];
                iArr2[i12] = i17;
                iArr2[i13] = iArr2[i13] - iArr[i13];
                layoutParams2.x = (i17 + i16) - (rootView.getWidth() / 2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, i12);
                view2.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i18 = iArr2[i13];
                int i19 = ((i18 + i11) - dimensionPixelOffset3) - measuredHeight;
                int i20 = i18 + height + dimensionPixelOffset3;
                if (z11) {
                    if (i19 >= 0) {
                        layoutParams2.y = i19;
                    } else {
                        layoutParams2.y = i20;
                    }
                } else if (measuredHeight + i20 <= rect.height()) {
                    layoutParams2.y = i20;
                } else {
                    layoutParams2.y = i19;
                }
            }
            ((WindowManager) context2.getSystemService("window")).addView(view2, layoutParams2);
            view.addOnAttachStateChangeListener(this);
            if (this.f8394w) {
                j11 = 2500;
            } else {
                WeakHashMap weakHashMap = m0.k0.f8683a;
                if ((view.getWindowSystemUiVisibility() & 1) == i13) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j10 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j10 = 15000;
                }
                j11 = j10 - longPressTimeout;
            }
            b3 b3Var = this.f8390s;
            view.removeCallbacks(b3Var);
            view.postDelayed(b3Var, j11);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        if (java.lang.Math.abs(r5 - r3.f8392u) <= r2) goto L30;
     */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            m.d3 r4 = r3.f8393v
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.f8394w
            if (r4 == 0) goto La
            goto L6f
        La:
            android.view.View r4 = r3.f8386o
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            goto L6f
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.f8395x = r4
            r3.a()
            return r0
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            m.d3 r4 = r3.f8393v
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.f8395x
            if (r1 != 0) goto L66
            int r1 = r3.f8391t
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f8388q
            if (r1 > r2) goto L66
            int r1 = r3.f8392u
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.f8391t = r4
            r3.f8392u = r5
            r3.f8395x = r0
            b(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m.c3.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f8391t = view.getWidth() / 2;
        this.f8392u = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
