package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Property;
import android.view.View;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f877a = false;

    /* renamed from: b, reason: collision with root package name */
    public float f878b;

    /* renamed from: c, reason: collision with root package name */
    public final View f879c;

    /* renamed from: d, reason: collision with root package name */
    public final float f880d;

    /* renamed from: e, reason: collision with root package name */
    public final float f881e;

    /* renamed from: f, reason: collision with root package name */
    public final int f882f;
    public final Property g;

    public f(View view, Property property, float f10, float f11, int i10) {
        this.g = property;
        this.f879c = view;
        this.f881e = f10;
        this.f880d = f11;
        this.f882f = i10;
        view.setVisibility(0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        View view = this.f879c;
        view.setTag(R.id.lb_slide_transition_value, new float[]{view.getTranslationX(), view.getTranslationY()});
        this.g.set(view, Float.valueOf(this.f881e));
        this.f877a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        boolean z10 = this.f877a;
        View view = this.f879c;
        if (!z10) {
            this.g.set(view, Float.valueOf(this.f881e));
        }
        view.setVisibility(this.f882f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        Property property = this.g;
        View view = this.f879c;
        this.f878b = ((Float) property.get(view)).floatValue();
        property.set(view, Float.valueOf(this.f880d));
        view.setVisibility(this.f882f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        Float valueOf = Float.valueOf(this.f878b);
        Property property = this.g;
        View view = this.f879c;
        property.set(view, valueOf);
        view.setVisibility(0);
    }
}
