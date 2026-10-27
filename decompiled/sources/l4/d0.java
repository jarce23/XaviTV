package l4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 extends AnimatorListenerAdapter implements k {

    /* renamed from: a, reason: collision with root package name */
    public final View f8203a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8204b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f8205c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8207e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8208f = false;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8206d = true;

    public d0(View view, int i10) {
        this.f8203a = view;
        this.f8204b = i10;
        this.f8205c = (ViewGroup) view.getParent();
        h(true);
    }

    @Override // l4.k
    public final void a(m mVar) {
        throw null;
    }

    @Override // l4.k
    public final void b() {
        h(false);
        if (this.f8208f) {
            return;
        }
        w.b(this.f8203a, this.f8204b);
    }

    @Override // l4.k
    public final void c(m mVar) {
        mVar.w(this);
    }

    @Override // l4.k
    public final void e() {
        h(true);
        if (this.f8208f) {
            return;
        }
        w.b(this.f8203a, 0);
    }

    @Override // l4.k
    public final void g(m mVar) {
        mVar.w(this);
    }

    public final void h(boolean z10) {
        ViewGroup viewGroup;
        if (!this.f8206d || this.f8207e == z10 || (viewGroup = this.f8205c) == null) {
            return;
        }
        this.f8207e = z10;
        com.bumptech.glide.c.B(viewGroup, z10);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f8208f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f8208f) {
            w.b(this.f8203a, this.f8204b);
            ViewGroup viewGroup = this.f8205c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        h(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z10) {
        if (z10) {
            w.b(this.f8203a, 0);
            ViewGroup viewGroup = this.f8205c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z10) {
        if (z10) {
            return;
        }
        if (!this.f8208f) {
            w.b(this.f8203a, this.f8204b);
            ViewGroup viewGroup = this.f8205c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        h(false);
    }

    @Override // l4.k
    public final void d(m mVar) {
    }

    @Override // l4.k
    public final void f(m mVar) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }
}
