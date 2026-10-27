package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import h5.i;
import m0.k0;
import m8.c;
import s0.d;
import z.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends a {

    /* renamed from: a, reason: collision with root package name */
    public d f3674a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3675b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3676c;

    /* renamed from: d, reason: collision with root package name */
    public int f3677d = 2;

    /* renamed from: e, reason: collision with root package name */
    public float f3678e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f3679f = 0.5f;
    public final c g = new c(this);

    @Override // z.a
    public boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z10 = this.f3675b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z10 = coordinatorLayout.o(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f3675b = z10;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f3675b = false;
        }
        if (z10) {
            if (this.f3674a == null) {
                this.f3674a = new d(coordinatorLayout.getContext(), coordinatorLayout, this.g);
            }
            if (!this.f3676c && this.f3674a.p(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // z.a
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i10) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            k0.j(view, 1048576);
            k0.h(view, 0);
            if (r(view)) {
                k0.k(view, n0.d.f9101j, new i(21, this));
            }
        }
        return false;
    }

    @Override // z.a
    public final boolean q(View view, MotionEvent motionEvent) {
        if (this.f3674a == null) {
            return false;
        }
        if (this.f3676c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f3674a.j(motionEvent);
        return true;
    }

    public boolean r(View view) {
        return true;
    }
}
