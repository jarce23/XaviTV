package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u0 f714a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f715b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f716c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f717d;

    public j(u0 u0Var, k kVar, View view, f fVar) {
        this.f714a = u0Var;
        this.f715b = kVar;
        this.f716c = view;
        this.f717d = fVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        za.h.e("animation", animation);
        k kVar = this.f715b;
        kVar.f718a.post(new androidx.emoji2.text.m(kVar, this.f716c, this.f717d, 1));
        if (i0.F(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f714a + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        za.h.e("animation", animation);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        za.h.e("animation", animation);
        if (i0.F(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f714a + " has reached onAnimationStart.");
        }
    }
}
