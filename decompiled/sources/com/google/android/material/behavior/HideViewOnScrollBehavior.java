package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.o0;
import com.bumptech.glide.c;
import g9.l;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.chromium.net.R;
import w7.b;
import z.a;
import z.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends a {

    /* renamed from: a, reason: collision with root package name */
    public c f3664a;

    /* renamed from: b, reason: collision with root package name */
    public AccessibilityManager f3665b;

    /* renamed from: c, reason: collision with root package name */
    public m8.a f3666c;

    /* renamed from: e, reason: collision with root package name */
    public int f3668e;

    /* renamed from: f, reason: collision with root package name */
    public int f3669f;
    public TimeInterpolator g;

    /* renamed from: h, reason: collision with root package name */
    public TimeInterpolator f3670h;

    /* renamed from: k, reason: collision with root package name */
    public ViewPropertyAnimator f3673k;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f3667d = new LinkedHashSet();

    /* renamed from: i, reason: collision with root package name */
    public int f3671i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f3672j = 2;

    public HideViewOnScrollBehavior() {
    }

    @Override // z.a
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i10) {
        if (this.f3665b == null) {
            this.f3665b = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f3665b;
        if (accessibilityManager != null && this.f3666c == null) {
            m8.a aVar = new m8.a(this, view, 1);
            this.f3666c = aVar;
            accessibilityManager.addTouchExplorationStateChangeListener(aVar);
            view.addOnAttachStateChangeListener(new o0(5, this));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i11 = ((d) view.getLayoutParams()).f13934c;
        if (i11 == 80 || i11 == 81) {
            r(1);
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i11, i10);
            r((absoluteGravity == 3 || absoluteGravity == 19) ? 2 : 0);
        }
        this.f3671i = this.f3664a.m(view, marginLayoutParams);
        this.f3668e = b.u(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f3669f = b.u(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.g = b.v(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, k8.a.f7833d);
        this.f3670h = b.v(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, k8.a.f7832c);
        return false;
    }

    @Override // z.a
    public final void k(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int[] iArr) {
        if (i10 <= 0) {
            if (i10 < 0) {
                s(view);
                return;
            }
            return;
        }
        if (this.f3672j == 1) {
            return;
        }
        AccessibilityManager accessibilityManager = this.f3665b;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            ViewPropertyAnimator viewPropertyAnimator = this.f3673k;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.f3672j = 1;
            Iterator it = this.f3667d.iterator();
            if (it.hasNext()) {
                throw android.support.v4.media.d.l(it);
            }
            this.f3673k = this.f3664a.p(view, this.f3671i).setInterpolator(this.f3670h).setDuration(this.f3669f).setListener(new l(5, this));
        }
    }

    @Override // z.a
    public final boolean o(View view, int i10, int i11) {
        return i10 == 2;
    }

    public final void r(int i10) {
        c cVar = this.f3664a;
        if (cVar == null || cVar.o() != i10) {
            if (i10 == 0) {
                this.f3664a = new m8.b(2);
            } else if (i10 == 1) {
                this.f3664a = new m8.b(0);
            } else {
                if (i10 != 2) {
                    throw new IllegalArgumentException(android.support.v4.media.d.o("Invalid view edge position value: ", i10, ". Must be 0, 1 or 2."));
                }
                this.f3664a = new m8.b(1);
            }
        }
    }

    public final void s(View view) {
        if (this.f3672j == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f3673k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f3672j = 2;
        Iterator it = this.f3667d.iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.d.l(it);
        }
        this.f3664a.getClass();
        this.f3673k = this.f3664a.p(view, 0).setInterpolator(this.g).setDuration(this.f3668e).setListener(new l(5, this));
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
