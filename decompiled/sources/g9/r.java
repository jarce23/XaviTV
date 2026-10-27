package g9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import m.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5382a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f5383b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5384c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextView f5385d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ t f5386e;

    public r(t tVar, int i10, TextView textView, int i11, TextView textView2) {
        this.f5386e = tVar;
        this.f5382a = i10;
        this.f5383b = textView;
        this.f5384c = i11;
        this.f5385d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        w0 w0Var;
        int i10 = this.f5382a;
        t tVar = this.f5386e;
        tVar.f5401n = i10;
        tVar.f5399l = null;
        TextView textView = this.f5383b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f5384c == 1 && (w0Var = tVar.f5405r) != null) {
                w0Var.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f5385d;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f5385d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setAlpha(0.0f);
        }
    }
}
