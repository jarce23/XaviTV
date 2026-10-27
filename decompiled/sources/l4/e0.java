package l4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 extends AnimatorListenerAdapter implements k {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f8209a;

    /* renamed from: b, reason: collision with root package name */
    public final View f8210b;

    /* renamed from: c, reason: collision with root package name */
    public final View f8211c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8212d = true;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g f8213e;

    public e0(g gVar, ViewGroup viewGroup, View view, View view2) {
        this.f8213e = gVar;
        this.f8209a = viewGroup;
        this.f8210b = view;
        this.f8211c = view2;
    }

    @Override // l4.k
    public final void a(m mVar) {
        throw null;
    }

    @Override // l4.k
    public final void c(m mVar) {
        mVar.w(this);
    }

    @Override // l4.k
    public final void f(m mVar) {
        if (this.f8212d) {
            h();
        }
    }

    @Override // l4.k
    public final void g(m mVar) {
        mVar.w(this);
    }

    public final void h() {
        this.f8211c.setTag(R.id.save_overlay_view, null);
        this.f8209a.getOverlay().remove(this.f8210b);
        this.f8212d = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        h();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        this.f8209a.getOverlay().remove(this.f8210b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        View view = this.f8210b;
        if (view.getParent() == null) {
            this.f8209a.getOverlay().add(view);
        } else {
            this.f8213e.cancel();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z10) {
        if (z10) {
            View view = this.f8211c;
            View view2 = this.f8210b;
            view.setTag(R.id.save_overlay_view, view2);
            this.f8209a.getOverlay().add(view2);
            this.f8212d = true;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z10) {
        if (z10) {
            return;
        }
        h();
    }

    @Override // l4.k
    public final void b() {
    }

    @Override // l4.k
    public final void e() {
    }

    @Override // l4.k
    public final void d(m mVar) {
    }
}
