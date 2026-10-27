package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.android.material.datepicker.j;
import d0.l;
import k5.a;
import l.n;
import l.y;
import m.s1;
import m0.k0;
import x8.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class NavigationMenuItemView extends d implements y {
    public static final int[] U = {R.attr.state_checked};
    public int J;
    public boolean K;
    public boolean L;
    public final boolean M;
    public final CheckedTextView N;
    public FrameLayout O;
    public n P;
    public ColorStateList Q;
    public boolean R;
    public Drawable S;
    public final j T;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = true;
        j jVar = new j(3, this);
        this.T = jVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(org.chromium.net.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(org.chromium.net.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(org.chromium.net.R.id.design_menu_item_text);
        this.N = checkedTextView;
        k0.m(checkedTextView, jVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.O == null) {
                this.O = (FrameLayout) ((ViewStub) findViewById(org.chromium.net.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.O.removeAllViews();
            this.O.addView(view);
        }
    }

    @Override // l.y
    public final void b(n nVar) {
        StateListDrawable stateListDrawable;
        this.P = nVar;
        int i10 = nVar.f8014a;
        if (i10 > 0) {
            setId(i10);
        }
        setVisibility(nVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(org.chromium.net.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(U, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackground(stateListDrawable);
        }
        setCheckable(nVar.isCheckable());
        setChecked(nVar.isChecked());
        setEnabled(nVar.isEnabled());
        setTitle(nVar.f8018e);
        setIcon(nVar.getIcon());
        setActionView(nVar.getActionView());
        setContentDescription(nVar.f8029q);
        a.w(this, nVar.f8030r);
        n nVar2 = this.P;
        CharSequence charSequence = nVar2.f8018e;
        CheckedTextView checkedTextView = this.N;
        if (charSequence == null && nVar2.getIcon() == null && this.P.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.O;
            if (frameLayout != null) {
                s1 s1Var = (s1) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) s1Var).width = -1;
                this.O.setLayoutParams(s1Var);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.O;
        if (frameLayout2 != null) {
            s1 s1Var2 = (s1) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) s1Var2).width = -2;
            this.O.setLayoutParams(s1Var2);
        }
    }

    @Override // l.y
    public n getItemData() {
        return this.P;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        n nVar = this.P;
        if (nVar != null && nVar.isCheckable() && this.P.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, U);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.L != z10) {
            this.L = z10;
            this.T.h(this.N, 2048);
        }
    }

    public void setChecked(boolean z10) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.N;
        checkedTextView.setChecked(z10);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z10 && this.M) ? 1 : 0);
    }

    public void setHorizontalPadding(int i10) {
        setPadding(i10, getPaddingTop(), i10, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.R) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                drawable.setTintList(this.Q);
            }
            int i10 = this.J;
            drawable.setBounds(0, 0, i10, i10);
        } else if (this.K) {
            if (this.S == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = l.f3981a;
                Drawable drawable2 = resources.getDrawable(org.chromium.net.R.drawable.navigation_empty_icon, theme);
                this.S = drawable2;
                if (drawable2 != null) {
                    int i11 = this.J;
                    drawable2.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.S;
        }
        this.N.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i10) {
        this.N.setCompoundDrawablePadding(i10);
    }

    public void setIconSize(int i10) {
        this.J = i10;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.Q = colorStateList;
        this.R = colorStateList != null;
        n nVar = this.P;
        if (nVar != null) {
            setIcon(nVar.getIcon());
        }
    }

    public void setMaxLines(int i10) {
        this.N.setMaxLines(i10);
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.K = z10;
    }

    public void setTextAppearance(int i10) {
        this.N.setTextAppearance(i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.N.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.N.setText(charSequence);
    }
}
