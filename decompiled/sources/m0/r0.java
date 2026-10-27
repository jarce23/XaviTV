package m0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Collections;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x0 f8708a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q1 f8709b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q1 f8710c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f8711d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f8712e;

    public r0(x0 x0Var, q1 q1Var, q1 q1Var2, int i10, View view) {
        this.f8708a = x0Var;
        this.f8709b = q1Var;
        this.f8710c = q1Var2;
        this.f8711d = i10;
        this.f8712e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        x0 x0Var = this.f8708a;
        w0 w0Var = x0Var.f8738a;
        w0Var.d(animatedFraction);
        q1 q1Var = this.f8709b;
        n1 n1Var = q1Var.f8706a;
        float b2 = w0Var.b();
        PathInterpolator pathInterpolator = t0.f8717e;
        int i10 = Build.VERSION.SDK_INT;
        e1 d1Var = i10 >= 34 ? new d1(q1Var) : i10 >= 31 ? new c1(q1Var) : i10 >= 30 ? new b1(q1Var) : i10 >= 29 ? new a1(q1Var) : new y0(q1Var);
        for (int i11 = 1; i11 <= 512; i11 <<= 1) {
            if ((this.f8711d & i11) == 0) {
                d1Var.c(i11, n1Var.f(i11));
            } else {
                e0.c f10 = n1Var.f(i11);
                e0.c f11 = this.f8710c.f8706a.f(i11);
                float f12 = 1.0f - b2;
                d1Var.c(i11, q1.e(f10, (int) (((f10.f4385a - f11.f4385a) * f12) + 0.5d), (int) (((f10.f4386b - f11.f4386b) * f12) + 0.5d), (int) (((f10.f4387c - f11.f4387c) * f12) + 0.5d), (int) (((f10.f4388d - f11.f4388d) * f12) + 0.5d)));
            }
        }
        t0.g(this.f8712e, d1Var.b(), Collections.singletonList(x0Var));
    }
}
