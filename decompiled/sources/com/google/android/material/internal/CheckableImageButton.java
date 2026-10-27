package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.datepicker.j;
import m.u;
import m0.k0;
import x8.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CheckableImageButton extends u implements Checkable {

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f3810u = {R.attr.state_checked};

    /* renamed from: r, reason: collision with root package name */
    public boolean f3811r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3812s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3813t;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, org.chromium.net.R.attr.imageButtonStyle);
        this.f3812s = true;
        this.f3813t = true;
        k0.m(this, new j(2, this));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f3811r;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        return this.f3811r ? View.mergeDrawableStates(super.onCreateDrawableState(i10 + 1), f3810u) : super.onCreateDrawableState(i10);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.f10407o);
        setChecked(aVar.f13687q);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f13687q = this.f3811r;
        return aVar;
    }

    public void setCheckable(boolean z10) {
        if (this.f3812s != z10) {
            this.f3812s = z10;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (!this.f3812s || this.f3811r == z10) {
            return;
        }
        this.f3811r = z10;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z10) {
        this.f3813t = z10;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        if (this.f3813t) {
            super.setPressed(z10);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f3811r);
    }
}
