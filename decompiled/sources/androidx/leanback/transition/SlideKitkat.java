package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
class SlideKitkat extends Visibility {

    /* renamed from: p, reason: collision with root package name */
    public static final DecelerateInterpolator f864p = new DecelerateInterpolator();

    /* renamed from: q, reason: collision with root package name */
    public static final AccelerateInterpolator f865q = new AccelerateInterpolator();

    /* renamed from: r, reason: collision with root package name */
    public static final c f866r = new c(0);

    /* renamed from: s, reason: collision with root package name */
    public static final d f867s = new d(0);

    /* renamed from: t, reason: collision with root package name */
    public static final c f868t = new c(1);

    /* renamed from: u, reason: collision with root package name */
    public static final d f869u = new d(1);

    /* renamed from: v, reason: collision with root package name */
    public static final c f870v = new c(2);

    /* renamed from: w, reason: collision with root package name */
    public static final c f871w = new c(3);

    /* renamed from: o, reason: collision with root package name */
    public final e f872o;

    public SlideKitkat(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a1.a.f15h);
        int i10 = obtainStyledAttributes.getInt(3, 80);
        if (i10 == 3) {
            this.f872o = f866r;
        } else if (i10 == 5) {
            this.f872o = f868t;
        } else if (i10 == 48) {
            this.f872o = f867s;
        } else if (i10 == 80) {
            this.f872o = f869u;
        } else if (i10 == 8388611) {
            this.f872o = f870v;
        } else {
            if (i10 != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.f872o = f871w;
        }
        long j10 = obtainStyledAttributes.getInt(1, -1);
        if (j10 >= 0) {
            setDuration(j10);
        }
        long j11 = obtainStyledAttributes.getInt(2, -1);
        if (j11 > 0) {
            setStartDelay(j11);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
    }

    public static ObjectAnimator a(View view, Property property, float f10, float f11, float f12, TimeInterpolator timeInterpolator, int i10) {
        float[] fArr = (float[]) view.getTag(R.id.lb_slide_transition_value);
        if (fArr != null) {
            f10 = View.TRANSLATION_Y == property ? fArr[1] : fArr[0];
            view.setTag(R.id.lb_slide_transition_value, null);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, f10, f11);
        f fVar = new f(view, property, f12, f11, i10);
        ofFloat.addListener(fVar);
        ofFloat.addPauseListener(fVar);
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }

    @Override // android.transition.Visibility
    public final Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i10, TransitionValues transitionValues2, int i11) {
        View view = transitionValues2 != null ? transitionValues2.view : null;
        if (view == null) {
            return null;
        }
        float c10 = this.f872o.c(view);
        return a(view, this.f872o.d(), this.f872o.b(view), c10, c10, f864p, 0);
    }

    @Override // android.transition.Visibility
    public final Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i10, TransitionValues transitionValues2, int i11) {
        View view = transitionValues != null ? transitionValues.view : null;
        if (view == null) {
            return null;
        }
        float c10 = this.f872o.c(view);
        return a(view, this.f872o.d(), c10, this.f872o.b(view), c10, f865q, 4);
    }
}
