package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.leanback.widget.g0;
import l.l;
import l.z;
import m.a;
import m.g;
import m.h3;
import m.k;
import m0.k0;
import m0.p0;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {
    public View A;
    public LinearLayout B;
    public TextView C;
    public TextView D;
    public final int E;
    public final int F;
    public boolean G;
    public final int H;

    /* renamed from: o, reason: collision with root package name */
    public final a f398o;

    /* renamed from: p, reason: collision with root package name */
    public final Context f399p;

    /* renamed from: q, reason: collision with root package name */
    public ActionMenuView f400q;

    /* renamed from: r, reason: collision with root package name */
    public k f401r;

    /* renamed from: s, reason: collision with root package name */
    public int f402s;

    /* renamed from: t, reason: collision with root package name */
    public p0 f403t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f404u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f405v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f406w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f407x;

    /* renamed from: y, reason: collision with root package name */
    public View f408y;

    /* renamed from: z, reason: collision with root package name */
    public View f409z;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.actionModeStyle);
        int resourceId;
        this.f398o = new a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f399p = context;
        } else {
            this.f399p = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.a.f4361d, R.attr.actionModeStyle, 0);
        setBackground((!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) ? obtainStyledAttributes.getDrawable(0) : n4.a.o(context, resourceId));
        this.E = obtainStyledAttributes.getResourceId(5, 0);
        this.F = obtainStyledAttributes.getResourceId(4, 0);
        this.f402s = obtainStyledAttributes.getLayoutDimension(3, 0);
        this.H = obtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    public static int f(View view, int i10, int i11) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, i10 - view.getMeasuredWidth());
    }

    public static int g(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = ((i12 - measuredHeight) / 2) + i11;
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public final void c(k.a aVar) {
        View view = this.f408y;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.H, (ViewGroup) this, false);
            this.f408y = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f408y);
        }
        View findViewById = this.f408y.findViewById(R.id.action_mode_close_button);
        this.f409z = findViewById;
        findViewById.setOnClickListener(new g0(15, aVar));
        l c10 = aVar.c();
        k kVar = this.f401r;
        if (kVar != null) {
            kVar.c();
            g gVar = kVar.H;
            if (gVar != null && gVar.b()) {
                gVar.f8057i.dismiss();
            }
        }
        k kVar2 = new k(getContext());
        this.f401r = kVar2;
        kVar2.f8461z = true;
        kVar2.A = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        c10.b(this.f401r, this.f399p);
        k kVar3 = this.f401r;
        z zVar = kVar3.f8457v;
        if (zVar == null) {
            z zVar2 = (z) kVar3.f8453r.inflate(kVar3.f8455t, (ViewGroup) this, false);
            kVar3.f8457v = zVar2;
            zVar2.a(kVar3.f8452q);
            kVar3.b();
        }
        z zVar3 = kVar3.f8457v;
        if (zVar != zVar3) {
            ((ActionMenuView) zVar3).setPresenter(kVar3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) zVar3;
        this.f400q = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f400q, layoutParams);
    }

    public final void d() {
        if (this.B == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.B = linearLayout;
            this.C = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.D = (TextView) this.B.findViewById(R.id.action_bar_subtitle);
            int i10 = this.E;
            if (i10 != 0) {
                this.C.setTextAppearance(getContext(), i10);
            }
            int i11 = this.F;
            if (i11 != 0) {
                this.D.setTextAppearance(getContext(), i11);
            }
        }
        this.C.setText(this.f406w);
        this.D.setText(this.f407x);
        boolean isEmpty = TextUtils.isEmpty(this.f406w);
        boolean isEmpty2 = TextUtils.isEmpty(this.f407x);
        this.D.setVisibility(!isEmpty2 ? 0 : 8);
        this.B.setVisibility((isEmpty && isEmpty2) ? 8 : 0);
        if (this.B.getParent() == null) {
            addView(this.B);
        }
    }

    public final void e() {
        removeAllViews();
        this.A = null;
        this.f400q = null;
        this.f401r = null;
        View view = this.f409z;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.f403t != null ? this.f398o.f8356p : getVisibility();
    }

    public int getContentHeight() {
        return this.f402s;
    }

    public CharSequence getSubtitle() {
        return this.f407x;
    }

    public CharSequence getTitle() {
        return this.f406w;
    }

    @Override // android.view.View
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            p0 p0Var = this.f403t;
            if (p0Var != null) {
                p0Var.b();
            }
            super.setVisibility(i10);
        }
    }

    public final p0 i(int i10, long j10) {
        p0 p0Var = this.f403t;
        if (p0Var != null) {
            p0Var.b();
        }
        a aVar = this.f398o;
        if (i10 != 0) {
            p0 a10 = k0.a(this);
            a10.a(0.0f);
            a10.c(j10);
            aVar.f8357q.f403t = a10;
            aVar.f8356p = i10;
            a10.d(aVar);
            return a10;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        p0 a11 = k0.a(this);
        a11.a(1.0f);
        a11.c(j10);
        aVar.f8357q.f403t = a11;
        aVar.f8356p = i10;
        a11.d(aVar);
        return a11;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, e.a.f4358a, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        k kVar = this.f401r;
        if (kVar != null) {
            Configuration configuration2 = kVar.f8451p.getResources().getConfiguration();
            int i10 = configuration2.screenWidthDp;
            int i11 = configuration2.screenHeightDp;
            kVar.D = (configuration2.smallestScreenWidthDp > 600 || i10 > 600 || (i10 > 960 && i11 > 720) || (i10 > 720 && i11 > 960)) ? 5 : (i10 >= 500 || (i10 > 640 && i11 > 480) || (i10 > 480 && i11 > 640)) ? 4 : i10 >= 360 ? 3 : 2;
            l lVar = kVar.f8452q;
            if (lVar != null) {
                lVar.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k kVar = this.f401r;
        if (kVar != null) {
            kVar.c();
            g gVar = this.f401r.H;
            if (gVar == null || !gVar.b()) {
                return;
            }
            gVar.f8057i.dismiss();
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f405v = false;
        }
        if (!this.f405v) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f405v = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f405v = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11 = h3.f8433a;
        boolean z12 = getLayoutDirection() == 1;
        int paddingRight = z12 ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f408y;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f408y.getLayoutParams();
            int i14 = z12 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = z12 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i16 = z12 ? paddingRight - i14 : paddingRight + i14;
            int g = g(this.f408y, i16, paddingTop, paddingTop2, z12) + i16;
            paddingRight = z12 ? g - i15 : g + i15;
        }
        LinearLayout linearLayout = this.B;
        if (linearLayout != null && this.A == null && linearLayout.getVisibility() != 8) {
            paddingRight += g(this.B, paddingRight, paddingTop, paddingTop2, z12);
        }
        View view2 = this.A;
        if (view2 != null) {
            g(view2, paddingRight, paddingTop, paddingTop2, z12);
        }
        int paddingLeft = z12 ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f400q;
        if (actionMenuView != null) {
            g(actionMenuView, paddingLeft, paddingTop, paddingTop2, !z12);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i11) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i10);
        int i12 = this.f402s;
        if (i12 <= 0) {
            i12 = View.MeasureSpec.getSize(i11);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i13 = i12 - paddingBottom;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE);
        View view = this.f408y;
        if (view != null) {
            int f10 = f(view, paddingLeft, makeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f408y.getLayoutParams();
            paddingLeft = f10 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f400q;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.f400q, paddingLeft, makeMeasureSpec);
        }
        LinearLayout linearLayout = this.B;
        if (linearLayout != null && this.A == null) {
            if (this.G) {
                this.B.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.B.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.B.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, makeMeasureSpec);
            }
        }
        View view2 = this.A;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i14 = layoutParams.width;
            int i15 = i14 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i14 >= 0) {
                paddingLeft = Math.min(i14, paddingLeft);
            }
            int i16 = layoutParams.height;
            int i17 = i16 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i16 >= 0) {
                i13 = Math.min(i16, i13);
            }
            this.A.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i15), View.MeasureSpec.makeMeasureSpec(i13, i17));
        }
        if (this.f402s > 0) {
            setMeasuredDimension(size, i12);
            return;
        }
        int childCount = getChildCount();
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            int measuredHeight = getChildAt(i19).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i18) {
                i18 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i18);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f404u = false;
        }
        if (!this.f404u) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f404u = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f404u = false;
        return true;
    }

    public void setContentHeight(int i10) {
        this.f402s = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.A;
        if (view2 != null) {
            removeView(view2);
        }
        this.A = view;
        if (view != null && (linearLayout = this.B) != null) {
            removeView(linearLayout);
            this.B = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f407x = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f406w = charSequence;
        d();
        k0.n(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.G) {
            requestLayout();
        }
        this.G = z10;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
