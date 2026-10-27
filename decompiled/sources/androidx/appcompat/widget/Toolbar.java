package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.media.session.a0;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.j;
import androidx.fragment.app.b0;
import androidx.leanback.widget.g0;
import e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import k.h;
import l.l;
import l.n;
import m.f1;
import m.h3;
import m.j2;
import m.k;
import m.r2;
import m.s2;
import m.t2;
import m.u;
import m.u2;
import m.v;
import m.v2;
import m.w0;
import m.w2;
import m.x2;
import m.y2;
import m.z2;
import m0.k0;
import org.chromium.net.R;
import x4.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public int A;
    public final int B;
    public final int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public j2 H;
    public int I;
    public int J;
    public final int K;
    public CharSequence L;
    public CharSequence M;
    public ColorStateList N;
    public ColorStateList O;
    public boolean P;
    public boolean Q;
    public final ArrayList R;
    public final ArrayList S;
    public final int[] T;
    public final m U;
    public ArrayList V;
    public final s2 W;

    /* renamed from: a0, reason: collision with root package name */
    public z2 f468a0;

    /* renamed from: b0, reason: collision with root package name */
    public k f469b0;

    /* renamed from: c0, reason: collision with root package name */
    public u2 f470c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f471d0;

    /* renamed from: e0, reason: collision with root package name */
    public OnBackInvokedCallback f472e0;

    /* renamed from: f0, reason: collision with root package name */
    public OnBackInvokedDispatcher f473f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f474g0;
    public final j h0;

    /* renamed from: o, reason: collision with root package name */
    public ActionMenuView f475o;

    /* renamed from: p, reason: collision with root package name */
    public w0 f476p;

    /* renamed from: q, reason: collision with root package name */
    public w0 f477q;

    /* renamed from: r, reason: collision with root package name */
    public u f478r;

    /* renamed from: s, reason: collision with root package name */
    public v f479s;

    /* renamed from: t, reason: collision with root package name */
    public final Drawable f480t;

    /* renamed from: u, reason: collision with root package name */
    public final CharSequence f481u;

    /* renamed from: v, reason: collision with root package name */
    public u f482v;

    /* renamed from: w, reason: collision with root package name */
    public View f483w;

    /* renamed from: x, reason: collision with root package name */
    public Context f484x;

    /* renamed from: y, reason: collision with root package name */
    public int f485y;

    /* renamed from: z, reason: collision with root package name */
    public int f486z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i10 = 0; i10 < menu.size(); i10++) {
            arrayList.add(menu.getItem(i10));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new h(getContext());
    }

    public static v2 h() {
        v2 v2Var = new v2(-2, -2);
        v2Var.f8581b = 0;
        v2Var.f8580a = 8388627;
        return v2Var;
    }

    public static v2 i(ViewGroup.LayoutParams layoutParams) {
        boolean z10 = layoutParams instanceof v2;
        if (z10) {
            v2 v2Var = (v2) layoutParams;
            v2 v2Var2 = new v2(v2Var);
            v2Var2.f8581b = 0;
            v2Var2.f8581b = v2Var.f8581b;
            return v2Var2;
        }
        if (z10) {
            v2 v2Var3 = new v2((v2) layoutParams);
            v2Var3.f8581b = 0;
            return v2Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            v2 v2Var4 = new v2(layoutParams);
            v2Var4.f8581b = 0;
            return v2Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        v2 v2Var5 = new v2(marginLayoutParams);
        v2Var5.f8581b = 0;
        ((ViewGroup.MarginLayoutParams) v2Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) v2Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) v2Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) v2Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return v2Var5;
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i10, ArrayList arrayList) {
        boolean z10 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i10, getLayoutDirection());
        arrayList.clear();
        if (!z10) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                v2 v2Var = (v2) childAt.getLayoutParams();
                if (v2Var.f8581b == 0 && s(childAt)) {
                    int i12 = v2Var.f8580a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i12, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i13 = childCount - 1; i13 >= 0; i13--) {
            View childAt2 = getChildAt(i13);
            v2 v2Var2 = (v2) childAt2.getLayoutParams();
            if (v2Var2.f8581b == 0 && s(childAt2)) {
                int i14 = v2Var2.f8580a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i14, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        v2 h10 = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (v2) layoutParams;
        h10.f8581b = 1;
        if (!z10 || this.f483w == null) {
            addView(view, h10);
        } else {
            view.setLayoutParams(h10);
            this.S.add(view);
        }
    }

    public final void c() {
        if (this.f482v == null) {
            u uVar = new u(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f482v = uVar;
            uVar.setImageDrawable(this.f480t);
            this.f482v.setContentDescription(this.f481u);
            v2 h10 = h();
            h10.f8580a = (this.B & 112) | 8388611;
            h10.f8581b = 2;
            this.f482v.setLayoutParams(h10);
            this.f482v.setOnClickListener(new g0(16, this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof v2);
    }

    public final void d() {
        if (this.H == null) {
            j2 j2Var = new j2();
            j2Var.f8443a = 0;
            j2Var.f8444b = 0;
            j2Var.f8445c = Integer.MIN_VALUE;
            j2Var.f8446d = Integer.MIN_VALUE;
            j2Var.f8447e = 0;
            j2Var.f8448f = 0;
            j2Var.g = false;
            j2Var.f8449h = false;
            this.H = j2Var;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f475o;
        if (actionMenuView.D == null) {
            l lVar = (l) actionMenuView.getMenu();
            if (this.f470c0 == null) {
                this.f470c0 = new u2(this);
            }
            this.f475o.setExpandedActionViewsExclusive(true);
            lVar.b(this.f470c0, this.f484x);
            t();
        }
    }

    public final void f() {
        if (this.f475o == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f475o = actionMenuView;
            actionMenuView.setPopupTheme(this.f485y);
            this.f475o.setOnMenuItemClickListener(this.W);
            ActionMenuView actionMenuView2 = this.f475o;
            s2 s2Var = new s2(this);
            actionMenuView2.getClass();
            actionMenuView2.I = s2Var;
            v2 h10 = h();
            h10.f8580a = (this.B & 112) | 8388613;
            this.f475o.setLayoutParams(h10);
            b(this.f475o, false);
        }
    }

    public final void g() {
        if (this.f478r == null) {
            this.f478r = new u(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            v2 h10 = h();
            h10.f8580a = (this.B & 112) | 8388611;
            this.f478r.setLayoutParams(h10);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        u uVar = this.f482v;
        if (uVar != null) {
            return uVar.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        u uVar = this.f482v;
        if (uVar != null) {
            return uVar.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        j2 j2Var = this.H;
        if (j2Var != null) {
            return j2Var.g ? j2Var.f8443a : j2Var.f8444b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i10 = this.J;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        j2 j2Var = this.H;
        if (j2Var != null) {
            return j2Var.f8443a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        j2 j2Var = this.H;
        if (j2Var != null) {
            return j2Var.f8444b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        j2 j2Var = this.H;
        if (j2Var != null) {
            return j2Var.g ? j2Var.f8444b : j2Var.f8443a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i10 = this.I;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        l lVar;
        ActionMenuView actionMenuView = this.f475o;
        return (actionMenuView == null || (lVar = actionMenuView.D) == null || !lVar.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.J, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.I, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        v vVar = this.f479s;
        if (vVar != null) {
            return vVar.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        v vVar = this.f479s;
        if (vVar != null) {
            return vVar.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f475o.getMenu();
    }

    public View getNavButtonView() {
        return this.f478r;
    }

    public CharSequence getNavigationContentDescription() {
        u uVar = this.f478r;
        if (uVar != null) {
            return uVar.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        u uVar = this.f478r;
        if (uVar != null) {
            return uVar.getDrawable();
        }
        return null;
    }

    public k getOuterActionMenuPresenter() {
        return this.f469b0;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f475o.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f484x;
    }

    public int getPopupTheme() {
        return this.f485y;
    }

    public CharSequence getSubtitle() {
        return this.M;
    }

    public final TextView getSubtitleTextView() {
        return this.f477q;
    }

    public CharSequence getTitle() {
        return this.L;
    }

    public int getTitleMarginBottom() {
        return this.G;
    }

    public int getTitleMarginEnd() {
        return this.E;
    }

    public int getTitleMarginStart() {
        return this.D;
    }

    public int getTitleMarginTop() {
        return this.F;
    }

    public final TextView getTitleTextView() {
        return this.f476p;
    }

    public f1 getWrapper() {
        Drawable drawable;
        if (this.f468a0 == null) {
            z2 z2Var = new z2();
            z2Var.f8633n = 0;
            z2Var.f8621a = this;
            z2Var.f8627h = getTitle();
            z2Var.f8628i = getSubtitle();
            z2Var.g = z2Var.f8627h != null;
            z2Var.f8626f = getNavigationIcon();
            a0 T = a0.T(getContext(), null, a.f4358a, R.attr.actionBarStyle);
            TypedArray typedArray = (TypedArray) T.f231q;
            z2Var.f8634o = T.K(15);
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                z2Var.g = true;
                z2Var.f8627h = text;
                if ((z2Var.f8622b & 8) != 0) {
                    setTitle(text);
                    if (z2Var.g) {
                        k0.n(getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                z2Var.f8628i = text2;
                if ((z2Var.f8622b & 8) != 0) {
                    setSubtitle(text2);
                }
            }
            Drawable K = T.K(20);
            if (K != null) {
                z2Var.f8625e = K;
                z2Var.c();
            }
            Drawable K2 = T.K(17);
            if (K2 != null) {
                z2Var.f8624d = K2;
                z2Var.c();
            }
            if (z2Var.f8626f == null && (drawable = z2Var.f8634o) != null) {
                z2Var.f8626f = drawable;
                if ((z2Var.f8622b & 4) != 0) {
                    setNavigationIcon(drawable);
                } else {
                    setNavigationIcon((Drawable) null);
                }
            }
            z2Var.a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
                View view = z2Var.f8623c;
                if (view != null && (z2Var.f8622b & 16) != 0) {
                    removeView(view);
                }
                z2Var.f8623c = inflate;
                if (inflate != null && (z2Var.f8622b & 16) != 0) {
                    addView(inflate);
                }
                z2Var.a(z2Var.f8622b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = layoutDimension;
                setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int max = Math.max(dimensionPixelOffset, 0);
                int max2 = Math.max(dimensionPixelOffset2, 0);
                d();
                this.H.a(max, max2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = getContext();
                this.f486z = resourceId2;
                w0 w0Var = this.f476p;
                if (w0Var != null) {
                    w0Var.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = getContext();
                this.A = resourceId3;
                w0 w0Var2 = this.f477q;
                if (w0Var2 != null) {
                    w0Var2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                setPopupTheme(resourceId4);
            }
            T.U();
            if (R.string.abc_action_bar_up_description != z2Var.f8633n) {
                z2Var.f8633n = R.string.abc_action_bar_up_description;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i10 = z2Var.f8633n;
                    z2Var.f8629j = i10 != 0 ? getContext().getString(i10) : null;
                    z2Var.b();
                }
            }
            z2Var.f8629j = getNavigationContentDescription();
            setNavigationOnClickListener(new y2(z2Var));
            this.f468a0 = z2Var;
        }
        return this.f468a0;
    }

    public final int j(View view, int i10) {
        v2 v2Var = (v2) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i10 > 0 ? (measuredHeight - i10) / 2 : 0;
        int i12 = v2Var.f8580a & 112;
        if (i12 != 16 && i12 != 48 && i12 != 80) {
            i12 = this.K & 112;
        }
        if (i12 == 48) {
            return getPaddingTop() - i11;
        }
        if (i12 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) v2Var).bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i13 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i14 = ((ViewGroup.MarginLayoutParams) v2Var).topMargin;
        if (i13 < i14) {
            i13 = i14;
        } else {
            int i15 = (((height - paddingBottom) - measuredHeight) - i13) - paddingTop;
            int i16 = ((ViewGroup.MarginLayoutParams) v2Var).bottomMargin;
            if (i15 < i16) {
                i13 = Math.max(0, i13 - (i16 - i15));
            }
        }
        return paddingTop + i13;
    }

    public final void m() {
        ArrayList arrayList = this.V;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            getMenu().removeItem(((MenuItem) obj).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.U.f13565q).iterator();
        while (it.hasNext()) {
            ((b0) it.next()).f661a.j();
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.V = currentMenuItems2;
    }

    public final boolean n(View view) {
        return view.getParent() == this || this.S.contains(view);
    }

    public final int o(View view, int i10, int i11, int[] iArr) {
        v2 v2Var = (v2) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) v2Var).leftMargin - iArr[0];
        int max = Math.max(0, i12) + i10;
        iArr[0] = Math.max(0, -i12);
        int j10 = j(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, j10, max + measuredWidth, view.getMeasuredHeight() + j10);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) v2Var).rightMargin + max;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        t();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.h0);
        t();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.Q = false;
        }
        if (!this.Q) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.Q = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.Q = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x028f A[LOOP:0: B:39:0x028d->B:40:0x028f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02a7 A[LOOP:1: B:43:0x02a5->B:44:0x02a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02c7 A[LOOP:2: B:47:0x02c5->B:48:0x02c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x031a A[LOOP:3: B:56:0x0318->B:57:0x031a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0218  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        char c10;
        Object[] objArr;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z10 = h3.f8433a;
        int i19 = 0;
        if (getLayoutDirection() == 1) {
            objArr = true;
            c10 = 0;
        } else {
            c10 = 1;
            objArr = false;
        }
        if (s(this.f478r)) {
            r(this.f478r, i10, 0, i11, this.C);
            i12 = k(this.f478r) + this.f478r.getMeasuredWidth();
            i13 = Math.max(0, l(this.f478r) + this.f478r.getMeasuredHeight());
            i14 = View.combineMeasuredStates(0, this.f478r.getMeasuredState());
        } else {
            i12 = 0;
            i13 = 0;
            i14 = 0;
        }
        if (s(this.f482v)) {
            r(this.f482v, i10, 0, i11, this.C);
            i12 = k(this.f482v) + this.f482v.getMeasuredWidth();
            i13 = Math.max(i13, l(this.f482v) + this.f482v.getMeasuredHeight());
            i14 = View.combineMeasuredStates(i14, this.f482v.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i12);
        int max2 = Math.max(0, currentContentInsetStart - i12);
        Object[] objArr2 = objArr;
        int[] iArr = this.T;
        iArr[objArr2 == true ? 1 : 0] = max2;
        if (s(this.f475o)) {
            r(this.f475o, i10, max, i11, this.C);
            i15 = k(this.f475o) + this.f475o.getMeasuredWidth();
            i13 = Math.max(i13, l(this.f475o) + this.f475o.getMeasuredHeight());
            i14 = View.combineMeasuredStates(i14, this.f475o.getMeasuredState());
        } else {
            i15 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max + Math.max(currentContentInsetEnd, i15);
        iArr[c10] = Math.max(0, currentContentInsetEnd - i15);
        if (s(this.f483w)) {
            max3 += q(this.f483w, i10, max3, i11, 0, iArr);
            i13 = Math.max(i13, l(this.f483w) + this.f483w.getMeasuredHeight());
            i14 = View.combineMeasuredStates(i14, this.f483w.getMeasuredState());
        }
        if (s(this.f479s)) {
            max3 += q(this.f479s, i10, max3, i11, 0, iArr);
            i13 = Math.max(i13, l(this.f479s) + this.f479s.getMeasuredHeight());
            i14 = View.combineMeasuredStates(i14, this.f479s.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (((v2) childAt.getLayoutParams()).f8581b == 0 && s(childAt)) {
                max3 += q(childAt, i10, max3, i11, 0, iArr);
                int max4 = Math.max(i13, l(childAt) + childAt.getMeasuredHeight());
                i14 = View.combineMeasuredStates(i14, childAt.getMeasuredState());
                i13 = max4;
            } else {
                max3 = max3;
            }
        }
        int i21 = max3;
        int i22 = this.F + this.G;
        int i23 = this.D + this.E;
        if (s(this.f476p)) {
            q(this.f476p, i10, i21 + i23, i11, i22, iArr);
            int k10 = k(this.f476p) + this.f476p.getMeasuredWidth();
            i16 = l(this.f476p) + this.f476p.getMeasuredHeight();
            i17 = View.combineMeasuredStates(i14, this.f476p.getMeasuredState());
            i18 = k10;
        } else {
            i16 = 0;
            i17 = i14;
            i18 = 0;
        }
        if (s(this.f477q)) {
            i18 = Math.max(i18, q(this.f477q, i10, i21 + i23, i11, i22 + i16, iArr));
            i16 += l(this.f477q) + this.f477q.getMeasuredHeight();
            i17 = View.combineMeasuredStates(i17, this.f477q.getMeasuredState());
        }
        int max5 = Math.max(i13, i16);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i21 + i18;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max5;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i10, (-16777216) & i17);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i11, i17 << 16);
        if (this.f471d0) {
            int childCount2 = getChildCount();
            for (int i24 = 0; i24 < childCount2; i24++) {
                View childAt2 = getChildAt(i24);
                if (!s(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                }
            }
            setMeasuredDimension(resolveSizeAndState, i19);
        }
        i19 = resolveSizeAndState2;
        setMeasuredDimension(resolveSizeAndState, i19);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof x2)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x2 x2Var = (x2) parcelable;
        super.onRestoreInstanceState(x2Var.f10407o);
        ActionMenuView actionMenuView = this.f475o;
        l lVar = actionMenuView != null ? actionMenuView.D : null;
        int i10 = x2Var.f8596q;
        if (i10 != 0 && this.f470c0 != null && lVar != null && (findItem = lVar.findItem(i10)) != null) {
            findItem.expandActionView();
        }
        if (x2Var.f8597r) {
            j jVar = this.h0;
            removeCallbacks(jVar);
            post(jVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        d();
        j2 j2Var = this.H;
        boolean z10 = i10 == 1;
        if (z10 == j2Var.g) {
            return;
        }
        j2Var.g = z10;
        if (!j2Var.f8449h) {
            j2Var.f8443a = j2Var.f8447e;
            j2Var.f8444b = j2Var.f8448f;
            return;
        }
        if (z10) {
            int i11 = j2Var.f8446d;
            if (i11 == Integer.MIN_VALUE) {
                i11 = j2Var.f8447e;
            }
            j2Var.f8443a = i11;
            int i12 = j2Var.f8445c;
            if (i12 == Integer.MIN_VALUE) {
                i12 = j2Var.f8448f;
            }
            j2Var.f8444b = i12;
            return;
        }
        int i13 = j2Var.f8445c;
        if (i13 == Integer.MIN_VALUE) {
            i13 = j2Var.f8447e;
        }
        j2Var.f8443a = i13;
        int i14 = j2Var.f8446d;
        if (i14 == Integer.MIN_VALUE) {
            i14 = j2Var.f8448f;
        }
        j2Var.f8444b = i14;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        k kVar;
        n nVar;
        x2 x2Var = new x2(super.onSaveInstanceState());
        u2 u2Var = this.f470c0;
        if (u2Var != null && (nVar = u2Var.f8574p) != null) {
            x2Var.f8596q = nVar.f8014a;
        }
        ActionMenuView actionMenuView = this.f475o;
        x2Var.f8597r = (actionMenuView == null || (kVar = actionMenuView.H) == null || !kVar.f()) ? false : true;
        return x2Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.P = false;
        }
        if (!this.P) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.P = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.P = false;
        return true;
    }

    public final int p(View view, int i10, int i11, int[] iArr) {
        v2 v2Var = (v2) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) v2Var).rightMargin - iArr[1];
        int max = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int j10 = j(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, j10, max, view.getMeasuredHeight() + j10);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) v2Var).leftMargin);
    }

    public final int q(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i15) + Math.max(0, i14);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + max + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final void r(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i13 >= 0) {
            if (mode != 0) {
                i13 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i13);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean s(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void setBackInvokedCallbackEnabled(boolean z10) {
        if (this.f474g0 != z10) {
            this.f474g0 = z10;
            t();
        }
    }

    public void setCollapseContentDescription(int i10) {
        setCollapseContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setCollapseIcon(int i10) {
        setCollapseIcon(n4.a.o(getContext(), i10));
    }

    public void setCollapsible(boolean z10) {
        this.f471d0 = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.J) {
            this.J = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.I) {
            this.I = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i10) {
        setLogo(n4.a.o(getContext(), i10));
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(n4.a.o(getContext(), i10));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f478r.setOnClickListener(onClickListener);
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f475o.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f485y != i10) {
            this.f485y = i10;
            if (i10 == 0) {
                this.f484x = getContext();
            } else {
                this.f484x = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitleTextColor(int i10) {
        setSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitleMarginBottom(int i10) {
        this.G = i10;
        requestLayout();
    }

    public void setTitleMarginEnd(int i10) {
        this.E = i10;
        requestLayout();
    }

    public void setTitleMarginStart(int i10) {
        this.D = i10;
        requestLayout();
    }

    public void setTitleMarginTop(int i10) {
        this.F = i10;
        requestLayout();
    }

    public void setTitleTextColor(int i10) {
        setTitleTextColor(ColorStateList.valueOf(i10));
    }

    public final void t() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a10 = t2.a(this);
            u2 u2Var = this.f470c0;
            boolean z10 = (u2Var == null || u2Var.f8574p == null || a10 == null || !isAttachedToWindow() || !this.f474g0) ? false : true;
            if (z10 && this.f473f0 == null) {
                if (this.f472e0 == null) {
                    this.f472e0 = t2.b(new r2(this, 0));
                }
                t2.c(a10, this.f472e0);
                this.f473f0 = a10;
                return;
            }
            if (z10 || (onBackInvokedDispatcher = this.f473f0) == null) {
                return;
            }
            t2.d(onBackInvokedDispatcher, this.f472e0);
            this.f473f0 = null;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.K = 8388627;
        this.R = new ArrayList();
        this.S = new ArrayList();
        this.T = new int[2];
        this.U = new m(new r2(this, 1));
        this.V = new ArrayList();
        this.W = new s2(this);
        this.h0 = new j(27, this);
        Context context2 = getContext();
        int[] iArr = a.f4380x;
        a0 T = a0.T(context2, attributeSet, iArr, R.attr.toolbarStyle);
        k0.l(this, context, iArr, attributeSet, (TypedArray) T.f231q, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) T.f231q;
        this.f486z = typedArray.getResourceId(28, 0);
        this.A = typedArray.getResourceId(19, 0);
        this.K = typedArray.getInteger(0, 8388627);
        this.B = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.G = dimensionPixelOffset;
        this.F = dimensionPixelOffset;
        this.E = dimensionPixelOffset;
        this.D = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.D = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.E = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.F = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.G = dimensionPixelOffset5;
        }
        this.C = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        d();
        j2 j2Var = this.H;
        j2Var.f8449h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            j2Var.f8447e = dimensionPixelSize;
            j2Var.f8443a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            j2Var.f8448f = dimensionPixelSize2;
            j2Var.f8444b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            j2Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.I = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.J = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f480t = T.K(4);
        this.f481u = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f484x = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable K = T.K(16);
        if (K != null) {
            setNavigationIcon(K);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable K2 = T.K(11);
        if (K2 != null) {
            setLogo(K2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(T.J(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(T.J(20));
        }
        if (typedArray.hasValue(14)) {
            getMenuInflater().inflate(typedArray.getResourceId(14, 0), getMenu());
        }
        T.U();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        v2 v2Var = new v2(context, attributeSet);
        v2Var.f8580a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f4359b);
        v2Var.f8580a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        v2Var.f8581b = 0;
        return v2Var;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        u uVar = this.f482v;
        if (uVar != null) {
            uVar.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f482v.setImageDrawable(drawable);
        } else {
            u uVar = this.f482v;
            if (uVar != null) {
                uVar.setImageDrawable(this.f480t);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f479s == null) {
                this.f479s = new v(getContext(), null, 0);
            }
            if (!n(this.f479s)) {
                b(this.f479s, true);
            }
        } else {
            v vVar = this.f479s;
            if (vVar != null && n(vVar)) {
                removeView(this.f479s);
                this.S.remove(this.f479s);
            }
        }
        v vVar2 = this.f479s;
        if (vVar2 != null) {
            vVar2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f479s == null) {
            this.f479s = new v(getContext(), null, 0);
        }
        v vVar = this.f479s;
        if (vVar != null) {
            vVar.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        u uVar = this.f478r;
        if (uVar != null) {
            uVar.setContentDescription(charSequence);
            k5.a.w(this.f478r, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!n(this.f478r)) {
                b(this.f478r, true);
            }
        } else {
            u uVar = this.f478r;
            if (uVar != null && n(uVar)) {
                removeView(this.f478r);
                this.S.remove(this.f478r);
            }
        }
        u uVar2 = this.f478r;
        if (uVar2 != null) {
            uVar2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            w0 w0Var = this.f477q;
            if (w0Var != null && n(w0Var)) {
                removeView(this.f477q);
                this.S.remove(this.f477q);
            }
        } else {
            if (this.f477q == null) {
                Context context = getContext();
                w0 w0Var2 = new w0(context, null);
                this.f477q = w0Var2;
                w0Var2.setSingleLine();
                this.f477q.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.A;
                if (i10 != 0) {
                    this.f477q.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.O;
                if (colorStateList != null) {
                    this.f477q.setTextColor(colorStateList);
                }
            }
            if (!n(this.f477q)) {
                b(this.f477q, true);
            }
        }
        w0 w0Var3 = this.f477q;
        if (w0Var3 != null) {
            w0Var3.setText(charSequence);
        }
        this.M = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.O = colorStateList;
        w0 w0Var = this.f477q;
        if (w0Var != null) {
            w0Var.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            w0 w0Var = this.f476p;
            if (w0Var != null && n(w0Var)) {
                removeView(this.f476p);
                this.S.remove(this.f476p);
            }
        } else {
            if (this.f476p == null) {
                Context context = getContext();
                w0 w0Var2 = new w0(context, null);
                this.f476p = w0Var2;
                w0Var2.setSingleLine();
                this.f476p.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f486z;
                if (i10 != 0) {
                    this.f476p.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.N;
                if (colorStateList != null) {
                    this.f476p.setTextColor(colorStateList);
                }
            }
            if (!n(this.f476p)) {
                b(this.f476p, true);
            }
        }
        w0 w0Var3 = this.f476p;
        if (w0Var3 != null) {
            w0Var3.setText(charSequence);
        }
        this.L = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.N = colorStateList;
        w0 w0Var = this.f476p;
        if (w0Var != null) {
            w0Var.setTextColor(colorStateList);
        }
    }

    public void setOnMenuItemClickListener(w2 w2Var) {
    }
}
