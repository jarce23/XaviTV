package com.google.android.material.datepicker;

import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.leanback.widget.g0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b4.b0;
import b4.i1;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import m0.k0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l<S> extends u {

    /* renamed from: i0, reason: collision with root package name */
    public int f3758i0;

    /* renamed from: j0, reason: collision with root package name */
    public b f3759j0;

    /* renamed from: k0, reason: collision with root package name */
    public p f3760k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f3761l0;

    /* renamed from: m0, reason: collision with root package name */
    public c f3762m0;

    /* renamed from: n0, reason: collision with root package name */
    public RecyclerView f3763n0;

    /* renamed from: o0, reason: collision with root package name */
    public RecyclerView f3764o0;

    /* renamed from: p0, reason: collision with root package name */
    public View f3765p0;

    /* renamed from: q0, reason: collision with root package name */
    public View f3766q0;

    /* renamed from: r0, reason: collision with root package name */
    public View f3767r0;

    /* renamed from: s0, reason: collision with root package name */
    public View f3768s0;

    /* renamed from: t0, reason: collision with root package name */
    public MaterialButton f3769t0;

    /* renamed from: u0, reason: collision with root package name */
    public AccessibilityManager f3770u0;

    public final void J(p pVar) {
        t tVar = (t) this.f3764o0.getAdapter();
        int d6 = tVar.f3797d.f3736o.d(pVar);
        AccessibilityManager accessibilityManager = this.f3770u0;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            int d10 = d6 - tVar.f3797d.f3736o.d(this.f3760k0);
            boolean z10 = Math.abs(d10) > 3;
            boolean z11 = d10 > 0;
            this.f3760k0 = pVar;
            if (z10 && z11) {
                this.f3764o0.e0(d6 - 3);
                this.f3764o0.post(new androidx.emoji2.text.j(d6, 2, this));
            } else if (z10) {
                this.f3764o0.e0(d6 + 3);
                this.f3764o0.post(new androidx.emoji2.text.j(d6, 2, this));
            } else {
                this.f3764o0.post(new androidx.emoji2.text.j(d6, 2, this));
            }
        } else {
            this.f3760k0 = pVar;
            this.f3764o0.e0(d6);
        }
        L(d6);
    }

    public final void K(int i10) {
        this.f3761l0 = i10;
        if (i10 == 2) {
            this.f3763n0.getLayoutManager().F0(this.f3760k0.f3783q - ((z) this.f3763n0.getAdapter()).f3802d.f3759j0.f3736o.f3783q);
            this.f3767r0.setVisibility(0);
            this.f3768s0.setVisibility(8);
            this.f3765p0.setVisibility(8);
            this.f3766q0.setVisibility(8);
            return;
        }
        if (i10 == 1) {
            this.f3767r0.setVisibility(8);
            this.f3768s0.setVisibility(0);
            this.f3765p0.setVisibility(0);
            this.f3766q0.setVisibility(0);
            J(this.f3760k0);
        }
    }

    public final void L(int i10) {
        this.f3766q0.setEnabled(i10 + 1 < this.f3764o0.getAdapter().a());
        this.f3765p0.setEnabled(i10 - 1 >= 0);
    }

    @Override // androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        if (bundle == null) {
            bundle = this.f811t;
        }
        this.f3758i0 = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("GRID_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.f3759j0 = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.f3760k0 = (p) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i10;
        int i11;
        b0 b0Var;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(i(), this.f3758i0);
        this.f3762m0 = new c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.f3770u0 = (AccessibilityManager) E().getSystemService("accessibility");
        p pVar = this.f3759j0.f3736o;
        if (n.P(contextThemeWrapper, R.attr.windowFullscreen)) {
            i10 = org.chromium.net.R.layout.mtrl_calendar_vertical;
            i11 = 1;
        } else {
            i10 = org.chromium.net.R.layout.mtrl_calendar_horizontal;
            i11 = 0;
        }
        View inflate = cloneInContext.inflate(i10, viewGroup, false);
        Resources resources = E().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(org.chromium.net.R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(org.chromium.net.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(org.chromium.net.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(org.chromium.net.R.dimen.mtrl_calendar_days_of_week_height);
        int i12 = q.f3788r;
        inflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(org.chromium.net.R.dimen.mtrl_calendar_month_vertical_padding) * (i12 - 1)) + (resources.getDimensionPixelSize(org.chromium.net.R.dimen.mtrl_calendar_day_height) * i12) + resources.getDimensionPixelOffset(org.chromium.net.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) inflate.findViewById(org.chromium.net.R.id.mtrl_calendar_days_of_week);
        k0.m(gridView, new g(0));
        int i13 = this.f3759j0.f3740s;
        gridView.setAdapter((ListAdapter) (i13 > 0 ? new e(i13) : new e()));
        gridView.setNumColumns(pVar.f3784r);
        gridView.setEnabled(false);
        this.f3764o0 = (RecyclerView) inflate.findViewById(org.chromium.net.R.id.mtrl_calendar_months);
        this.f3764o0.setLayoutManager(new h(this, i11, i11));
        this.f3764o0.setTag("MONTHS_VIEW_GROUP_TAG");
        t tVar = new t(contextThemeWrapper, this.f3759j0, new a6.n(17, this));
        this.f3764o0.setAdapter(tVar);
        int integer = contextThemeWrapper.getResources().getInteger(org.chromium.net.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(org.chromium.net.R.id.mtrl_calendar_year_selector_frame);
        this.f3763n0 = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.f3763n0.setLayoutManager(new GridLayoutManager(integer, 0));
            this.f3763n0.setAdapter(new z(this));
            RecyclerView recyclerView4 = this.f3763n0;
            i iVar = new i();
            x.c(null);
            x.c(null);
            recyclerView4.g(iVar);
        }
        View findViewById = inflate.findViewById(org.chromium.net.R.id.month_navigation_fragment_toggle);
        b bVar = tVar.f3797d;
        if (findViewById != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(org.chromium.net.R.id.month_navigation_fragment_toggle);
            this.f3769t0 = materialButton;
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            k0.m(this.f3769t0, new j(0, this));
            View findViewById2 = inflate.findViewById(org.chromium.net.R.id.month_navigation_previous);
            this.f3765p0 = findViewById2;
            findViewById2.setTag("NAVIGATION_PREV_TAG");
            View findViewById3 = inflate.findViewById(org.chromium.net.R.id.month_navigation_next);
            this.f3766q0 = findViewById3;
            findViewById3.setTag("NAVIGATION_NEXT_TAG");
            this.f3767r0 = inflate.findViewById(org.chromium.net.R.id.mtrl_calendar_year_selector_frame);
            this.f3768s0 = inflate.findViewById(org.chromium.net.R.id.mtrl_calendar_day_selector_frame);
            K(1);
            this.f3769t0.setText(this.f3760k0.c());
            this.f3764o0.h(new k(this, tVar));
            this.f3769t0.setOnClickListener(new g0(7, this));
            this.f3766q0.setOnClickListener(new f(this, tVar, 1));
            this.f3765p0.setOnClickListener(new f(this, tVar, 0));
            L(bVar.f3736o.d(this.f3760k0));
        }
        if (!n.P(contextThemeWrapper, R.attr.windowFullscreen) && (recyclerView2 = (b0Var = new b0()).f2181a) != (recyclerView = this.f3764o0)) {
            i1 i1Var = b0Var.f2182b;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.f1491x0;
                if (arrayList != null) {
                    arrayList.remove(i1Var);
                }
                b0Var.f2181a.setOnFlingListener(null);
            }
            b0Var.f2181a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() != null) {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
                b0Var.f2181a.h(i1Var);
                b0Var.f2181a.setOnFlingListener(b0Var);
                new Scroller(b0Var.f2181a.getContext(), new DecelerateInterpolator());
                b0Var.f();
            }
        }
        this.f3764o0.e0(bVar.f3736o.d(this.f3760k0));
        k0.m(this.f3764o0, new g(1));
        return inflate;
    }

    @Override // androidx.fragment.app.s
    public final void z(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f3758i0);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f3759j0);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f3760k0);
    }
}
