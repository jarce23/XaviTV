package g9;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import m.w0;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {
    public ColorStateList A;
    public Typeface B;

    /* renamed from: a, reason: collision with root package name */
    public final int f5389a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5390b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5391c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f5392d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f5393e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f5394f;
    public final Context g;

    /* renamed from: h, reason: collision with root package name */
    public final TextInputLayout f5395h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f5396i;

    /* renamed from: j, reason: collision with root package name */
    public int f5397j;

    /* renamed from: k, reason: collision with root package name */
    public FrameLayout f5398k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f5399l;

    /* renamed from: m, reason: collision with root package name */
    public final float f5400m;

    /* renamed from: n, reason: collision with root package name */
    public int f5401n;

    /* renamed from: o, reason: collision with root package name */
    public int f5402o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f5403p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5404q;

    /* renamed from: r, reason: collision with root package name */
    public w0 f5405r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f5406s;

    /* renamed from: t, reason: collision with root package name */
    public int f5407t;

    /* renamed from: u, reason: collision with root package name */
    public int f5408u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f5409v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f5410w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f5411x;

    /* renamed from: y, reason: collision with root package name */
    public w0 f5412y;

    /* renamed from: z, reason: collision with root package name */
    public int f5413z;

    public t(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.g = context;
        this.f5395h = textInputLayout;
        this.f5400m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f5389a = w7.b.u(context, R.attr.motionDurationShort4, 217);
        this.f5390b = w7.b.u(context, R.attr.motionDurationMedium4, 167);
        this.f5391c = w7.b.u(context, R.attr.motionDurationShort4, 167);
        this.f5392d = w7.b.v(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, k8.a.f7833d);
        LinearInterpolator linearInterpolator = k8.a.f7830a;
        this.f5393e = w7.b.v(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f5394f = w7.b.v(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(w0 w0Var, int i10) {
        if (this.f5396i == null && this.f5398k == null) {
            Context context = this.g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f5396i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f5396i;
            TextInputLayout textInputLayout = this.f5395h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f5398k = new FrameLayout(context);
            this.f5396i.addView(this.f5398k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i10 == 0 || i10 == 1) {
            this.f5398k.setVisibility(0);
            this.f5398k.addView(w0Var);
        } else {
            this.f5396i.addView(w0Var, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f5396i.setVisibility(0);
        this.f5397j++;
    }

    public final void b() {
        if (this.f5396i != null) {
            TextInputLayout textInputLayout = this.f5395h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.g;
                boolean y8 = com.bumptech.glide.d.y(context);
                LinearLayout linearLayout = this.f5396i;
                int paddingStart = editText.getPaddingStart();
                if (y8) {
                    paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (y8) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int paddingEnd = editText.getPaddingEnd();
                if (y8) {
                    paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void c() {
        AnimatorSet animatorSet = this.f5399l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z10, w0 w0Var, int i10, int i11, int i12) {
        if (w0Var == null || !z10) {
            return;
        }
        if (i10 == i12 || i10 == i11) {
            boolean z11 = i12 == i10;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(w0Var, (Property<w0, Float>) View.ALPHA, z11 ? 1.0f : 0.0f);
            int i13 = this.f5391c;
            ofFloat.setDuration(z11 ? this.f5390b : i13);
            ofFloat.setInterpolator(z11 ? this.f5393e : this.f5394f);
            if (i10 == i12 && i11 != 0) {
                ofFloat.setStartDelay(i13);
            }
            arrayList.add(ofFloat);
            if (i12 != i10 || i11 == 0) {
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(w0Var, (Property<w0, Float>) View.TRANSLATION_Y, -this.f5400m, 0.0f);
            ofFloat2.setDuration(this.f5389a);
            ofFloat2.setInterpolator(this.f5392d);
            ofFloat2.setStartDelay(i13);
            arrayList.add(ofFloat2);
        }
    }

    public final TextView e(int i10) {
        if (i10 == 1) {
            return this.f5405r;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f5412y;
    }

    public final void f() {
        this.f5403p = null;
        c();
        if (this.f5401n == 1) {
            if (!this.f5411x || TextUtils.isEmpty(this.f5410w)) {
                this.f5402o = 0;
            } else {
                this.f5402o = 2;
            }
        }
        i(this.f5401n, this.f5402o, h(this.f5405r, _UrlKt.FRAGMENT_ENCODE_SET));
    }

    public final void g(w0 w0Var, int i10) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f5396i;
        if (linearLayout == null) {
            return;
        }
        if ((i10 == 0 || i10 == 1) && (frameLayout = this.f5398k) != null) {
            frameLayout.removeView(w0Var);
        } else {
            linearLayout.removeView(w0Var);
        }
        int i11 = this.f5397j - 1;
        this.f5397j = i11;
        LinearLayout linearLayout2 = this.f5396i;
        if (i11 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(w0 w0Var, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.f5395h;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled()) {
            return (this.f5402o == this.f5401n && w0Var != null && TextUtils.equals(w0Var.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void i(int i10, int i11, boolean z10) {
        TextView e7;
        TextView e8;
        t tVar = this;
        if (i10 == i11) {
            return;
        }
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            tVar.f5399l = animatorSet;
            ArrayList arrayList = new ArrayList();
            tVar.d(arrayList, tVar.f5411x, tVar.f5412y, 2, i10, i11);
            tVar.d(arrayList, tVar.f5404q, tVar.f5405r, 1, i10, i11);
            int size = arrayList.size();
            long j10 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Animator animator = (Animator) arrayList.get(i12);
                j10 = Math.max(j10, animator.getDuration() + animator.getStartDelay());
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
            ofInt.setDuration(j10);
            arrayList.add(0, ofInt);
            animatorSet.playTogether(arrayList);
            r rVar = new r(this, i11, e(i10), i10, tVar.e(i11));
            tVar = this;
            animatorSet.addListener(rVar);
            animatorSet.start();
        } else if (i10 != i11) {
            if (i11 != 0 && (e8 = tVar.e(i11)) != null) {
                e8.setVisibility(0);
                e8.setAlpha(1.0f);
            }
            if (i10 != 0 && (e7 = e(i10)) != null) {
                e7.setVisibility(4);
                if (i10 == 1) {
                    e7.setText((CharSequence) null);
                }
            }
            tVar.f5401n = i11;
        }
        TextInputLayout textInputLayout = tVar.f5395h;
        textInputLayout.t();
        textInputLayout.w(z10, false);
        textInputLayout.z();
    }
}
