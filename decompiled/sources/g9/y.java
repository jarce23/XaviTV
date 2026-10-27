package g9;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import m.w0;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y extends LinearLayout {

    /* renamed from: o, reason: collision with root package name */
    public final TextInputLayout f5429o;

    /* renamed from: p, reason: collision with root package name */
    public final w0 f5430p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f5431q;

    /* renamed from: r, reason: collision with root package name */
    public final CheckableImageButton f5432r;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f5433s;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f5434t;

    /* renamed from: u, reason: collision with root package name */
    public int f5435u;

    /* renamed from: v, reason: collision with root package name */
    public ImageView.ScaleType f5436v;

    /* renamed from: w, reason: collision with root package name */
    public View.OnLongClickListener f5437w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f5438x;

    public y(TextInputLayout textInputLayout, android.support.v4.media.session.a0 a0Var) {
        super(textInputLayout.getContext());
        CharSequence text;
        this.f5429o = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f5432r = checkableImageButton;
        w0 w0Var = new w0(getContext(), null);
        this.f5430p = w0Var;
        if (com.bumptech.glide.d.y(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.f5437w;
        checkableImageButton.setOnClickListener(null);
        a.a.t(checkableImageButton, onLongClickListener);
        this.f5437w = null;
        checkableImageButton.setOnLongClickListener(null);
        a.a.t(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) a0Var.f231q;
        if (typedArray.hasValue(70)) {
            this.f5433s = com.bumptech.glide.d.m(getContext(), a0Var, 70);
        }
        if (typedArray.hasValue(71)) {
            this.f5434t = x8.k.f(typedArray.getInt(71, -1), null);
        }
        if (typedArray.hasValue(67)) {
            b(a0Var.K(67));
            if (typedArray.hasValue(66) && checkableImageButton.getContentDescription() != (text = typedArray.getText(66))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(65, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(68, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f5435u) {
            this.f5435u = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(69)) {
            ImageView.ScaleType i10 = a.a.i(typedArray.getInt(69, -1));
            this.f5436v = i10;
            checkableImageButton.setScaleType(i10);
        }
        w0Var.setVisibility(8);
        w0Var.setId(R.id.textinput_prefix_text);
        w0Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        w0Var.setAccessibilityLiveRegion(1);
        w0Var.setTextAppearance(typedArray.getResourceId(61, 0));
        if (typedArray.hasValue(62)) {
            w0Var.setTextColor(a0Var.J(62));
        }
        CharSequence text2 = typedArray.getText(60);
        this.f5431q = TextUtils.isEmpty(text2) ? null : text2;
        w0Var.setText(text2);
        e();
        addView(checkableImageButton);
        addView(w0Var);
    }

    public final int a() {
        int i10;
        CheckableImageButton checkableImageButton = this.f5432r;
        if (checkableImageButton.getVisibility() == 0) {
            i10 = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            i10 = 0;
        }
        return this.f5430p.getPaddingStart() + getPaddingStart() + i10;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f5432r;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f5433s;
            PorterDuff.Mode mode = this.f5434t;
            TextInputLayout textInputLayout = this.f5429o;
            a.a.a(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            a.a.s(textInputLayout, checkableImageButton, this.f5433s);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.f5437w;
        checkableImageButton.setOnClickListener(null);
        a.a.t(checkableImageButton, onLongClickListener);
        this.f5437w = null;
        checkableImageButton.setOnLongClickListener(null);
        a.a.t(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z10) {
        CheckableImageButton checkableImageButton = this.f5432r;
        if ((checkableImageButton.getVisibility() == 0) != z10) {
            checkableImageButton.setVisibility(z10 ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        EditText editText = this.f5429o.f3864s;
        if (editText == null) {
            return;
        }
        this.f5430p.setPaddingRelative(this.f5432r.getVisibility() == 0 ? 0 : editText.getPaddingStart(), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void e() {
        int i10 = (this.f5431q == null || this.f5438x) ? 8 : 0;
        setVisibility((this.f5432r.getVisibility() == 0 || i10 == 0) ? 0 : 8);
        this.f5430p.setVisibility(i10);
        this.f5429o.s();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        d();
    }
}
