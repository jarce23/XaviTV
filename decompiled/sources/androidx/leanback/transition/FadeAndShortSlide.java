package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class FadeAndShortSlide extends Visibility {

    /* renamed from: r, reason: collision with root package name */
    public static final DecelerateInterpolator f855r = new DecelerateInterpolator();

    /* renamed from: s, reason: collision with root package name */
    public static final a f856s = new a(0);

    /* renamed from: t, reason: collision with root package name */
    public static final a f857t = new a(1);

    /* renamed from: u, reason: collision with root package name */
    public static final a f858u = new a(2);

    /* renamed from: v, reason: collision with root package name */
    public static final a f859v = new a(3);

    /* renamed from: w, reason: collision with root package name */
    public static final a f860w = new a(4);

    /* renamed from: o, reason: collision with root package name */
    public final y7.d f861o;

    /* renamed from: p, reason: collision with root package name */
    public Visibility f862p;

    /* renamed from: q, reason: collision with root package name */
    public final float f863q;

    public FadeAndShortSlide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f862p = new Fade();
        this.f863q = -1.0f;
        b bVar = new b(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a1.a.f15h);
        int i10 = obtainStyledAttributes.getInt(3, 8388611);
        if (i10 == 48) {
            this.f861o = f860w;
        } else if (i10 == 80) {
            this.f861o = f859v;
        } else if (i10 == 112) {
            this.f861o = bVar;
        } else if (i10 == 8388611) {
            this.f861o = f856s;
        } else if (i10 == 8388613) {
            this.f861o = f857t;
        } else {
            if (i10 != 8388615) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.f861o = f858u;
        }
        obtainStyledAttributes.recycle();
    }

    public final float a(ViewGroup viewGroup) {
        float f10 = this.f863q;
        return f10 >= 0.0f ? f10 : viewGroup.getWidth() / 4;
    }

    @Override // android.transition.Transition
    public final Transition addListener(Transition.TransitionListener transitionListener) {
        this.f862p.addListener(transitionListener);
        return super.addListener(transitionListener);
    }

    public final float b(ViewGroup viewGroup) {
        float f10 = this.f863q;
        return f10 >= 0.0f ? f10 : viewGroup.getHeight() / 4;
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        this.f862p.captureEndValues(transitionValues);
        super.captureEndValues(transitionValues);
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put("android:fadeAndShortSlideTransition:screenPosition", iArr);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        this.f862p.captureStartValues(transitionValues);
        super.captureStartValues(transitionValues);
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put("android:fadeAndShortSlideTransition:screenPosition", iArr);
    }

    @Override // android.transition.Visibility
    public final Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.values.get("android:fadeAndShortSlideTransition:screenPosition");
        int i10 = iArr[0];
        int i11 = iArr[1];
        float translationX = view.getTranslationX();
        ObjectAnimator h10 = com.bumptech.glide.d.h(view, transitionValues2, i10, i11, this.f861o.f(this, viewGroup, view, iArr), this.f861o.g(this, viewGroup, view, iArr), translationX, view.getTranslationY(), f855r, this);
        Animator onAppear = this.f862p.onAppear(viewGroup, view, transitionValues, transitionValues2);
        if (h10 == null) {
            return onAppear;
        }
        if (onAppear == null) {
            return h10;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(h10).with(onAppear);
        return animatorSet;
    }

    @Override // android.transition.Visibility
    public final Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.values.get("android:fadeAndShortSlideTransition:screenPosition");
        ObjectAnimator h10 = com.bumptech.glide.d.h(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f861o.f(this, viewGroup, view, iArr), this.f861o.g(this, viewGroup, view, iArr), f855r, this);
        Animator onDisappear = this.f862p.onDisappear(viewGroup, view, transitionValues, transitionValues2);
        if (h10 == null) {
            return onDisappear;
        }
        if (onDisappear == null) {
            return h10;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(h10).with(onDisappear);
        return animatorSet;
    }

    @Override // android.transition.Transition
    public final Transition removeListener(Transition.TransitionListener transitionListener) {
        this.f862p.removeListener(transitionListener);
        return super.removeListener(transitionListener);
    }

    @Override // android.transition.Transition
    public final void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        this.f862p.setEpicenterCallback(epicenterCallback);
        super.setEpicenterCallback(epicenterCallback);
    }

    @Override // android.transition.Transition
    public final Transition clone() {
        FadeAndShortSlide fadeAndShortSlide = (FadeAndShortSlide) super.clone();
        fadeAndShortSlide.f862p = (Visibility) this.f862p.clone();
        return fadeAndShortSlide;
    }
}
