package g9;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends q {

    /* renamed from: e, reason: collision with root package name */
    public final int f5334e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5335f;
    public final TimeInterpolator g;

    /* renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f5336h;

    /* renamed from: i, reason: collision with root package name */
    public EditText f5337i;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.mediarouter.app.b f5338j;

    /* renamed from: k, reason: collision with root package name */
    public final a f5339k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f5340l;

    /* renamed from: m, reason: collision with root package name */
    public ValueAnimator f5341m;

    public d(p pVar) {
        super(pVar);
        this.f5338j = new androidx.mediarouter.app.b(3, this);
        this.f5339k = new a(this, 0);
        this.f5334e = w7.b.u(pVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f5335f = w7.b.u(pVar.getContext(), R.attr.motionDurationShort3, 150);
        this.g = w7.b.v(pVar.getContext(), R.attr.motionEasingLinearInterpolator, k8.a.f7830a);
        this.f5336h = w7.b.v(pVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, k8.a.f7833d);
    }

    @Override // g9.q
    public final void a() {
        if (this.f5379b.D != null) {
            return;
        }
        s(t());
    }

    @Override // g9.q
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // g9.q
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // g9.q
    public final View.OnFocusChangeListener e() {
        return this.f5339k;
    }

    @Override // g9.q
    public final View.OnClickListener f() {
        return this.f5338j;
    }

    @Override // g9.q
    public final View.OnFocusChangeListener g() {
        return this.f5339k;
    }

    @Override // g9.q
    public final void l(EditText editText) {
        this.f5337i = editText;
        this.f5378a.setEndIconVisible(t());
    }

    @Override // g9.q
    public final void o(boolean z10) {
        if (this.f5379b.D == null) {
            return;
        }
        s(z10);
    }

    @Override // g9.q
    public final void q() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.f5336h);
        ofFloat.setDuration(this.f5335f);
        final int i10 = 1;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: g9.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f5329b;

            {
                this.f5329b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i10) {
                    case 0:
                        d dVar = this.f5329b;
                        dVar.getClass();
                        dVar.f5381d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        d dVar2 = this.f5329b;
                        dVar2.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = dVar2.f5381d;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        break;
                }
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        ofFloat2.setInterpolator(timeInterpolator);
        int i11 = this.f5334e;
        ofFloat2.setDuration(i11);
        final int i12 = 0;
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: g9.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f5329b;

            {
                this.f5329b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i12) {
                    case 0:
                        d dVar = this.f5329b;
                        dVar.getClass();
                        dVar.f5381d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        d dVar2 = this.f5329b;
                        dVar2.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = dVar2.f5381d;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f5340l = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.f5340l.addListener(new c(this, i12));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(i11);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: g9.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f5329b;

            {
                this.f5329b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i12) {
                    case 0:
                        d dVar = this.f5329b;
                        dVar.getClass();
                        dVar.f5381d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        d dVar2 = this.f5329b;
                        dVar2.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = dVar2.f5381d;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        break;
                }
            }
        });
        this.f5341m = ofFloat3;
        ofFloat3.addListener(new c(this, i10));
    }

    @Override // g9.q
    public final void r() {
        EditText editText = this.f5337i;
        if (editText != null) {
            editText.post(new androidx.activity.d(10, this));
        }
    }

    public final void s(boolean z10) {
        boolean z11 = this.f5379b.d() == z10;
        if (z10 && !this.f5340l.isRunning()) {
            this.f5341m.cancel();
            this.f5340l.start();
            if (z11) {
                this.f5340l.end();
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        this.f5340l.cancel();
        this.f5341m.start();
        if (z11) {
            this.f5341m.end();
        }
    }

    public final boolean t() {
        EditText editText = this.f5337i;
        if (editText != null) {
            return (editText.hasFocus() || this.f5381d.hasFocus()) && this.f5337i.getText().length() > 0;
        }
        return false;
    }
}
