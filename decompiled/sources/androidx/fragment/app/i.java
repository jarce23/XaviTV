package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f684a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f685b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f686c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u0 f687d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f f688e;

    public i(k kVar, View view, boolean z10, u0 u0Var, f fVar) {
        this.f684a = kVar;
        this.f685b = view;
        this.f686c = z10;
        this.f687d = u0Var;
        this.f688e = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        za.h.e("anim", animator);
        ViewGroup viewGroup = this.f684a.f718a;
        View view = this.f685b;
        viewGroup.endViewTransition(view);
        boolean z10 = this.f686c;
        u0 u0Var = this.f687d;
        if (z10) {
            int i10 = u0Var.f830a;
            za.h.d("viewToAnimate", view);
            android.support.v4.media.d.b(view, i10);
        }
        this.f688e.d();
        if (i0.F(2)) {
            Log.v("FragmentManager", "Animator from operation " + u0Var + " has ended.");
        }
    }
}
