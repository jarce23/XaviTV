package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.v4.media.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.o0;
import g9.l;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.chromium.net.R;
import w7.b;
import z.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@Deprecated
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends a {

    /* renamed from: b, reason: collision with root package name */
    public int f3655b;

    /* renamed from: c, reason: collision with root package name */
    public int f3656c;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f3657d;

    /* renamed from: e, reason: collision with root package name */
    public TimeInterpolator f3658e;
    public AccessibilityManager g;

    /* renamed from: h, reason: collision with root package name */
    public m8.a f3660h;

    /* renamed from: k, reason: collision with root package name */
    public ViewPropertyAnimator f3663k;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f3654a = new LinkedHashSet();

    /* renamed from: f, reason: collision with root package name */
    public int f3659f = 0;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3661i = true;

    /* renamed from: j, reason: collision with root package name */
    public int f3662j = 2;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // z.a
    public boolean g(CoordinatorLayout coordinatorLayout, View view, int i10) {
        this.f3659f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f3655b = b.u(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f3656c = b.u(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.f3657d = b.v(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, k8.a.f7833d);
        this.f3658e = b.v(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, k8.a.f7832c);
        if (this.g == null) {
            this.g = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.g;
        if (accessibilityManager == null || this.f3660h != null) {
            return false;
        }
        m8.a aVar = new m8.a(this, view, 0);
        this.f3660h = aVar;
        accessibilityManager.addTouchExplorationStateChangeListener(aVar);
        view.addOnAttachStateChangeListener(new o0(4, this));
        return false;
    }

    @Override // z.a
    public final void k(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i10 <= 0) {
            if (i10 < 0) {
                r(view);
                return;
            }
            return;
        }
        if (this.f3662j == 1) {
            return;
        }
        if (this.f3661i && (accessibilityManager = this.g) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f3663k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f3662j = 1;
        Iterator it = this.f3654a.iterator();
        if (it.hasNext()) {
            throw d.l(it);
        }
        this.f3663k = view.animate().translationY(this.f3659f).setInterpolator(this.f3658e).setDuration(this.f3656c).setListener(new l(4, this));
    }

    @Override // z.a
    public boolean o(View view, int i10, int i11) {
        return i10 == 2;
    }

    public final void r(View view) {
        if (this.f3662j == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f3663k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f3662j = 2;
        Iterator it = this.f3654a.iterator();
        if (it.hasNext()) {
            throw d.l(it);
        }
        this.f3663k = view.animate().translationY(0).setInterpolator(this.f3657d).setDuration(this.f3655b).setListener(new l(4, this));
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
