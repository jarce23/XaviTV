package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o<S> extends u {

    /* renamed from: i0, reason: collision with root package name */
    public int f3779i0;

    /* renamed from: j0, reason: collision with root package name */
    public b f3780j0;

    @Override // androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        if (bundle == null) {
            bundle = this.f811t;
        }
        this.f3779i0 = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.f3780j0 = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(i(), this.f3779i0));
        throw null;
    }

    @Override // androidx.fragment.app.s
    public final void z(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f3779i0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f3780j0);
    }
}
