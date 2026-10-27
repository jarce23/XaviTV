package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import h5.i;
import j9.w1;
import l.k;
import l.l;
import l.z;
import m.g;
import m.h3;
import m.j;
import m.m;
import m.n;
import m.s1;
import m.s2;
import m.t1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ActionMenuView extends t1 implements k, z {
    public l D;
    public Context E;
    public int F;
    public boolean G;
    public m.k H;
    public s2 I;
    public boolean J;
    public int K;
    public final int L;
    public final int M;
    public n N;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.L = (int) (56.0f * f10);
        this.M = (int) (f10 * 4.0f);
        this.E = context;
        this.F = 0;
    }

    public static m j() {
        m mVar = new m(-2, -2);
        mVar.f8475a = false;
        ((LinearLayout.LayoutParams) mVar).gravity = 16;
        return mVar;
    }

    public static m k(ViewGroup.LayoutParams layoutParams) {
        m mVar;
        if (layoutParams == null) {
            return j();
        }
        if (layoutParams instanceof m) {
            m mVar2 = (m) layoutParams;
            mVar = new m(mVar2);
            mVar.f8475a = mVar2.f8475a;
        } else {
            mVar = new m(layoutParams);
        }
        if (((LinearLayout.LayoutParams) mVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) mVar).gravity = 16;
        }
        return mVar;
    }

    @Override // l.z
    public final void a(l lVar) {
        this.D = lVar;
    }

    @Override // l.k
    public final boolean c(l.n nVar) {
        return this.D.q(nVar, null, 0);
    }

    @Override // m.t1, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof m;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // m.t1
    /* renamed from: f */
    public final /* bridge */ /* synthetic */ s1 generateDefaultLayoutParams() {
        return j();
    }

    @Override // m.t1
    /* renamed from: g */
    public final s1 generateLayoutParams(AttributeSet attributeSet) {
        return new m(getContext(), attributeSet);
    }

    @Override // m.t1, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return j();
    }

    @Override // m.t1, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return k(layoutParams);
    }

    public Menu getMenu() {
        if (this.D == null) {
            Context context = getContext();
            l lVar = new l(context);
            this.D = lVar;
            lVar.f7992e = new i(16, this);
            m.k kVar = new m.k(context);
            this.H = kVar;
            kVar.f8461z = true;
            kVar.A = true;
            kVar.f8454s = new w1(4);
            this.D.b(kVar, this.E);
            m.k kVar2 = this.H;
            kVar2.f8457v = this;
            this.D = kVar2.f8452q;
        }
        return this.D;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        m.k kVar = this.H;
        j jVar = kVar.f8458w;
        if (jVar != null) {
            return jVar.getDrawable();
        }
        if (kVar.f8460y) {
            return kVar.f8459x;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.F;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // m.t1
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ s1 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return k(layoutParams);
    }

    public final boolean l(int i10) {
        boolean z10 = false;
        if (i10 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i10 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof m.l)) {
            z10 = ((m.l) childAt).a();
        }
        return (i10 <= 0 || !(childAt2 instanceof m.l)) ? z10 : ((m.l) childAt2).c() | z10;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m.k kVar = this.H;
        if (kVar != null) {
            kVar.b();
            if (this.H.f()) {
                this.H.c();
                this.H.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m.k kVar = this.H;
        if (kVar != null) {
            kVar.c();
            g gVar = kVar.H;
            if (gVar == null || !gVar.b()) {
                return;
            }
            gVar.f8057i.dismiss();
        }
    }

    @Override // m.t1, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int width;
        int i14;
        if (!this.J) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i15 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i16 = i12 - i10;
        int paddingRight = (i16 - getPaddingRight()) - getPaddingLeft();
        boolean z11 = h3.f8433a;
        boolean z12 = getLayoutDirection() == 1;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                m mVar = (m) childAt.getLayoutParams();
                if (mVar.f8475a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (l(i19)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z12) {
                        i14 = getPaddingLeft() + ((LinearLayout.LayoutParams) mVar).leftMargin;
                        width = i14 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) mVar).rightMargin;
                        i14 = width - measuredWidth;
                    }
                    int i20 = i15 - (measuredHeight / 2);
                    childAt.layout(i14, i20, width, measuredHeight + i20);
                    paddingRight -= measuredWidth;
                    i17 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) mVar).leftMargin) + ((LinearLayout.LayoutParams) mVar).rightMargin;
                    l(i19);
                    i18++;
                }
            }
        }
        if (childCount == 1 && i17 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i21 = (i16 / 2) - (measuredWidth2 / 2);
            int i22 = i15 - (measuredHeight2 / 2);
            childAt2.layout(i21, i22, measuredWidth2 + i21, measuredHeight2 + i22);
            return;
        }
        int i23 = i18 - (i17 ^ 1);
        int max = Math.max(0, i23 > 0 ? paddingRight / i23 : 0);
        if (z12) {
            int width2 = getWidth() - getPaddingRight();
            for (int i24 = 0; i24 < childCount; i24++) {
                View childAt3 = getChildAt(i24);
                m mVar2 = (m) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !mVar2.f8475a) {
                    int i25 = width2 - ((LinearLayout.LayoutParams) mVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i26 = i15 - (measuredHeight3 / 2);
                    childAt3.layout(i25 - measuredWidth3, i26, i25, measuredHeight3 + i26);
                    width2 = i25 - ((measuredWidth3 + ((LinearLayout.LayoutParams) mVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt4 = getChildAt(i27);
            m mVar3 = (m) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !mVar3.f8475a) {
                int i28 = paddingLeft + ((LinearLayout.LayoutParams) mVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i29 = i15 - (measuredHeight4 / 2);
                childAt4.layout(i28, i29, i28 + measuredWidth4, measuredHeight4 + i29);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) mVar3).rightMargin + max + i28;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // m.t1, android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        ?? r11;
        int i14;
        int i15;
        l lVar;
        boolean z10 = this.J;
        boolean z11 = View.MeasureSpec.getMode(i10) == 1073741824;
        this.J = z11;
        if (z10 != z11) {
            this.K = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (this.J && (lVar = this.D) != null && size != this.K) {
            this.K = size;
            lVar.p(true);
        }
        int childCount = getChildCount();
        if (!this.J || childCount <= 0) {
            for (int i16 = 0; i16 < childCount; i16++) {
                m mVar = (m) getChildAt(i16).getLayoutParams();
                ((LinearLayout.LayoutParams) mVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) mVar).leftMargin = 0;
            }
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i10);
        int size3 = View.MeasureSpec.getSize(i11);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingBottom, -2);
        int i17 = size2 - paddingRight;
        int i18 = this.L;
        int i19 = i17 / i18;
        int i20 = i17 % i18;
        if (i19 == 0) {
            setMeasuredDimension(i17, 0);
            return;
        }
        int i21 = (i20 / i19) + i18;
        int childCount2 = getChildCount();
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        boolean z12 = false;
        int i26 = 0;
        long j10 = 0;
        while (true) {
            i12 = this.M;
            if (i25 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i25);
            int i27 = size3;
            int i28 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i14 = i21;
            } else {
                boolean z13 = childAt instanceof ActionMenuItemView;
                i23++;
                if (z13) {
                    childAt.setPadding(i12, 0, i12, 0);
                }
                m mVar2 = (m) childAt.getLayoutParams();
                mVar2.f8480f = false;
                mVar2.f8477c = 0;
                mVar2.f8476b = 0;
                mVar2.f8478d = false;
                ((LinearLayout.LayoutParams) mVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) mVar2).rightMargin = 0;
                mVar2.f8479e = z13 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i29 = mVar2.f8475a ? 1 : i19;
                m mVar3 = (m) childAt.getLayoutParams();
                int i30 = i19;
                i14 = i21;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i28, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z13 ? (ActionMenuItemView) childAt : null;
                boolean z14 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z15 = z14;
                if (i29 <= 0 || (z14 && i29 < 2)) {
                    i15 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i14 * i29, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i15 = measuredWidth / i14;
                    if (measuredWidth % i14 != 0) {
                        i15++;
                    }
                    if (z15 && i15 < 2) {
                        i15 = 2;
                    }
                }
                mVar3.f8478d = !mVar3.f8475a && z15;
                mVar3.f8476b = i15;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i15 * i14, 1073741824), makeMeasureSpec);
                i24 = Math.max(i24, i15);
                if (mVar2.f8478d) {
                    i26++;
                }
                if (mVar2.f8475a) {
                    z12 = true;
                }
                i19 = i30 - i15;
                i22 = Math.max(i22, childAt.getMeasuredHeight());
                if (i15 == 1) {
                    j10 |= 1 << i25;
                }
            }
            i25++;
            size3 = i27;
            paddingBottom = i28;
            i21 = i14;
        }
        int i31 = size3;
        int i32 = i19;
        int i33 = i21;
        boolean z16 = z12 && i23 == 2;
        int i34 = i32;
        boolean z17 = false;
        while (i26 > 0 && i34 > 0) {
            int i35 = Integer.MAX_VALUE;
            long j11 = 0;
            int i36 = 0;
            int i37 = 0;
            while (i37 < childCount2) {
                int i38 = i22;
                m mVar4 = (m) getChildAt(i37).getLayoutParams();
                boolean z18 = z16;
                if (mVar4.f8478d) {
                    int i39 = mVar4.f8476b;
                    if (i39 < i35) {
                        j11 = 1 << i37;
                        i35 = i39;
                        i36 = 1;
                    } else if (i39 == i35) {
                        j11 |= 1 << i37;
                        i36++;
                    }
                }
                i37++;
                z16 = z18;
                i22 = i38;
            }
            i13 = i22;
            boolean z19 = z16;
            j10 |= j11;
            if (i36 > i34) {
                break;
            }
            int i40 = i35 + 1;
            int i41 = 0;
            while (i41 < childCount2) {
                View childAt2 = getChildAt(i41);
                m mVar5 = (m) childAt2.getLayoutParams();
                boolean z20 = z12;
                long j12 = 1 << i41;
                if ((j11 & j12) != 0) {
                    if (z19 && mVar5.f8479e) {
                        r11 = 1;
                        r11 = 1;
                        if (i34 == 1) {
                            childAt2.setPadding(i12 + i33, 0, i12, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    mVar5.f8476b += r11;
                    mVar5.f8480f = r11;
                    i34--;
                } else if (mVar5.f8476b == i40) {
                    j10 |= j12;
                }
                i41++;
                z12 = z20;
            }
            z16 = z19;
            i22 = i13;
            z17 = true;
        }
        i13 = i22;
        boolean z21 = !z12 && i23 == 1;
        if (i34 > 0 && j10 != 0 && (i34 < i23 - 1 || z21 || i24 > 1)) {
            float bitCount = Long.bitCount(j10);
            if (!z21) {
                if ((j10 & 1) != 0 && !((m) getChildAt(0).getLayoutParams()).f8479e) {
                    bitCount -= 0.5f;
                }
                int i42 = childCount2 - 1;
                if ((j10 & (1 << i42)) != 0 && !((m) getChildAt(i42).getLayoutParams()).f8479e) {
                    bitCount -= 0.5f;
                }
            }
            int i43 = bitCount > 0.0f ? (int) ((i34 * i33) / bitCount) : 0;
            boolean z22 = z17;
            for (int i44 = 0; i44 < childCount2; i44++) {
                if ((j10 & (1 << i44)) != 0) {
                    View childAt3 = getChildAt(i44);
                    m mVar6 = (m) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        mVar6.f8477c = i43;
                        mVar6.f8480f = true;
                        if (i44 == 0 && !mVar6.f8479e) {
                            ((LinearLayout.LayoutParams) mVar6).leftMargin = (-i43) / 2;
                        }
                        z22 = true;
                    } else if (mVar6.f8475a) {
                        mVar6.f8477c = i43;
                        mVar6.f8480f = true;
                        ((LinearLayout.LayoutParams) mVar6).rightMargin = (-i43) / 2;
                        z22 = true;
                    } else {
                        if (i44 != 0) {
                            ((LinearLayout.LayoutParams) mVar6).leftMargin = i43 / 2;
                        }
                        if (i44 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) mVar6).rightMargin = i43 / 2;
                        }
                    }
                }
            }
            z17 = z22;
        }
        if (z17) {
            for (int i45 = 0; i45 < childCount2; i45++) {
                View childAt4 = getChildAt(i45);
                m mVar7 = (m) childAt4.getLayoutParams();
                if (mVar7.f8480f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((mVar7.f8476b * i33) + mVar7.f8477c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i17, mode != 1073741824 ? i13 : i31);
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.H.E = z10;
    }

    public void setOnMenuItemClickListener(n nVar) {
        this.N = nVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        m.k kVar = this.H;
        j jVar = kVar.f8458w;
        if (jVar != null) {
            jVar.setImageDrawable(drawable);
        } else {
            kVar.f8460y = true;
            kVar.f8459x = drawable;
        }
    }

    public void setOverflowReserved(boolean z10) {
        this.G = z10;
    }

    public void setPopupTheme(int i10) {
        if (this.F != i10) {
            this.F = i10;
            if (i10 == 0) {
                this.E = getContext();
            } else {
                this.E = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPresenter(m.k kVar) {
        this.H = kVar;
        kVar.f8457v = this;
        this.D = kVar.f8452q;
    }

    @Override // m.t1, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new m(getContext(), attributeSet);
    }
}
