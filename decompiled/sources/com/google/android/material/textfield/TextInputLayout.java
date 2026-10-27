package com.google.android.material.textfield;

import a6.a0;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.v0;
import com.bumptech.glide.c;
import com.bumptech.glide.d;
import com.bumptech.glide.e;
import com.google.android.material.internal.CheckableImageButton;
import d9.f;
import d9.h;
import d9.j;
import d9.l;
import d9.m;
import d9.n;
import g9.b0;
import g9.c0;
import g9.o;
import g9.p;
import g9.s;
import g9.t;
import g9.w;
import g9.y;
import g9.z;
import i9.a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import l4.g;
import l4.q;
import m.i1;
import m.r;
import m.w0;
import m0.k0;
import okhttp3.internal.url._UrlKt;
import x8.b;
import x8.k;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int[][] R0 = {new int[]{R.attr.state_pressed}, new int[0]};
    public int A;
    public int A0;
    public boolean B;
    public int B0;
    public b0 C;
    public ColorStateList C0;
    public w0 D;
    public int D0;
    public int E;
    public int E0;
    public int F;
    public int F0;
    public CharSequence G;
    public int G0;
    public boolean H;
    public int H0;
    public w0 I;
    public int I0;
    public ColorStateList J;
    public boolean J0;
    public int K;
    public final b K0;
    public g L;
    public boolean L0;
    public g M;
    public boolean M0;
    public ColorStateList N;
    public ValueAnimator N0;
    public ColorStateList O;
    public boolean O0;
    public ColorStateList P;
    public boolean P0;
    public ColorStateList Q;
    public boolean Q0;
    public boolean R;
    public CharSequence S;
    public boolean T;
    public j U;
    public j V;
    public StateListDrawable W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f3843a0;

    /* renamed from: b0, reason: collision with root package name */
    public j f3844b0;

    /* renamed from: c0, reason: collision with root package name */
    public j f3845c0;

    /* renamed from: d0, reason: collision with root package name */
    public n f3846d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f3847e0;

    /* renamed from: f0, reason: collision with root package name */
    public final int f3848f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f3849g0;
    public int h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f3850i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f3851j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f3852k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f3853l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f3854m0;

    /* renamed from: n0, reason: collision with root package name */
    public final Rect f3855n0;

    /* renamed from: o, reason: collision with root package name */
    public final FrameLayout f3856o;

    /* renamed from: o0, reason: collision with root package name */
    public final Rect f3857o0;

    /* renamed from: p, reason: collision with root package name */
    public final y f3858p;

    /* renamed from: p0, reason: collision with root package name */
    public final RectF f3859p0;

    /* renamed from: q, reason: collision with root package name */
    public final p f3860q;

    /* renamed from: q0, reason: collision with root package name */
    public Typeface f3861q0;

    /* renamed from: r, reason: collision with root package name */
    public final int f3862r;

    /* renamed from: r0, reason: collision with root package name */
    public ColorDrawable f3863r0;

    /* renamed from: s, reason: collision with root package name */
    public EditText f3864s;

    /* renamed from: s0, reason: collision with root package name */
    public int f3865s0;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f3866t;

    /* renamed from: t0, reason: collision with root package name */
    public final LinkedHashSet f3867t0;

    /* renamed from: u, reason: collision with root package name */
    public int f3868u;

    /* renamed from: u0, reason: collision with root package name */
    public ColorDrawable f3869u0;

    /* renamed from: v, reason: collision with root package name */
    public int f3870v;

    /* renamed from: v0, reason: collision with root package name */
    public int f3871v0;

    /* renamed from: w, reason: collision with root package name */
    public int f3872w;

    /* renamed from: w0, reason: collision with root package name */
    public Drawable f3873w0;

    /* renamed from: x, reason: collision with root package name */
    public int f3874x;

    /* renamed from: x0, reason: collision with root package name */
    public ColorStateList f3875x0;

    /* renamed from: y, reason: collision with root package name */
    public final t f3876y;

    /* renamed from: y0, reason: collision with root package name */
    public ColorStateList f3877y0;

    /* renamed from: z, reason: collision with root package name */
    public boolean f3878z;

    /* renamed from: z0, reason: collision with root package name */
    public int f3879z0;

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, org.chromium.net.R.attr.textInputStyle, org.chromium.net.R.style.Widget_Design_TextInputLayout), attributeSet, org.chromium.net.R.attr.textInputStyle);
        this.f3868u = -1;
        this.f3870v = -1;
        this.f3872w = -1;
        this.f3874x = -1;
        this.f3876y = new t(this);
        this.C = new a0(27);
        this.f3855n0 = new Rect();
        this.f3857o0 = new Rect();
        this.f3859p0 = new RectF();
        this.f3867t0 = new LinkedHashSet();
        b bVar = new b(this);
        this.K0 = bVar;
        this.Q0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f3856o = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = k8.a.f7830a;
        bVar.R = linearInterpolator;
        bVar.j(false);
        bVar.Q = linearInterpolator;
        bVar.j(false);
        if (bVar.g != 8388659) {
            bVar.g = 8388659;
            bVar.j(false);
        }
        k.a(context2, attributeSet, org.chromium.net.R.attr.textInputStyle, org.chromium.net.R.style.Widget_Design_TextInputLayout);
        int[] iArr = j8.a.D;
        k.b(context2, attributeSet, iArr, org.chromium.net.R.attr.textInputStyle, org.chromium.net.R.style.Widget_Design_TextInputLayout, 22, 20, 40, 45, 50);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, org.chromium.net.R.attr.textInputStyle, org.chromium.net.R.style.Widget_Design_TextInputLayout);
        android.support.v4.media.session.a0 a0Var = new android.support.v4.media.session.a0(context2, obtainStyledAttributes);
        y yVar = new y(this, a0Var);
        this.f3858p = yVar;
        this.R = obtainStyledAttributes.getBoolean(48, true);
        setHint(obtainStyledAttributes.getText(4));
        this.M0 = obtainStyledAttributes.getBoolean(47, true);
        this.L0 = obtainStyledAttributes.getBoolean(42, true);
        if (obtainStyledAttributes.hasValue(6)) {
            setMinEms(obtainStyledAttributes.getInt(6, -1));
        } else if (obtainStyledAttributes.hasValue(3)) {
            setMinWidth(obtainStyledAttributes.getDimensionPixelSize(3, -1));
        }
        if (obtainStyledAttributes.hasValue(5)) {
            setMaxEms(obtainStyledAttributes.getInt(5, -1));
        } else if (obtainStyledAttributes.hasValue(2)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(2, -1));
        }
        this.f3846d0 = n.b(context2, attributeSet, org.chromium.net.R.attr.textInputStyle, org.chromium.net.R.style.Widget_Design_TextInputLayout).a();
        this.f3848f0 = context2.getResources().getDimensionPixelOffset(org.chromium.net.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.h0 = obtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.f3862r = getResources().getDimensionPixelSize(org.chromium.net.R.dimen.m3_multiline_hint_filled_text_extra_space);
        this.f3851j0 = obtainStyledAttributes.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(org.chromium.net.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.f3852k0 = obtainStyledAttributes.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(org.chromium.net.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.f3850i0 = this.f3851j0;
        float dimension = obtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = obtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = obtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = obtainStyledAttributes.getDimension(11, -1.0f);
        m f10 = this.f3846d0.f();
        if (dimension >= 0.0f) {
            f10.f4293e = new d9.a(dimension);
        }
        if (dimension2 >= 0.0f) {
            f10.f4294f = new d9.a(dimension2);
        }
        if (dimension3 >= 0.0f) {
            f10.g = new d9.a(dimension3);
        }
        if (dimension4 >= 0.0f) {
            f10.f4295h = new d9.a(dimension4);
        }
        this.f3846d0 = f10.a();
        ColorStateList m10 = d.m(context2, a0Var, 7);
        if (m10 != null) {
            int defaultColor = m10.getDefaultColor();
            this.D0 = defaultColor;
            this.f3854m0 = defaultColor;
            if (m10.isStateful()) {
                this.E0 = m10.getColorForState(new int[]{-16842910}, -1);
                this.F0 = m10.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.G0 = m10.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.F0 = this.D0;
                ColorStateList n10 = n4.a.n(context2, org.chromium.net.R.color.mtrl_filled_background_color);
                this.E0 = n10.getColorForState(new int[]{-16842910}, -1);
                this.G0 = n10.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f3854m0 = 0;
            this.D0 = 0;
            this.E0 = 0;
            this.F0 = 0;
            this.G0 = 0;
        }
        if (obtainStyledAttributes.hasValue(1)) {
            ColorStateList J = a0Var.J(1);
            this.f3877y0 = J;
            this.f3875x0 = J;
        }
        ColorStateList m11 = d.m(context2, a0Var, 14);
        this.B0 = obtainStyledAttributes.getColor(14, 0);
        this.f3879z0 = context2.getColor(org.chromium.net.R.color.mtrl_textinput_default_box_stroke_color);
        this.H0 = context2.getColor(org.chromium.net.R.color.mtrl_textinput_disabled_color);
        this.A0 = context2.getColor(org.chromium.net.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (m11 != null) {
            setBoxStrokeColorStateList(m11);
        }
        if (obtainStyledAttributes.hasValue(15)) {
            setBoxStrokeErrorColor(d.m(context2, a0Var, 15));
        }
        if (obtainStyledAttributes.getResourceId(50, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(50, 0));
        }
        this.P = a0Var.J(24);
        this.Q = a0Var.J(25);
        int resourceId = obtainStyledAttributes.getResourceId(40, 0);
        CharSequence text = obtainStyledAttributes.getText(35);
        int i10 = obtainStyledAttributes.getInt(34, 1);
        boolean z10 = obtainStyledAttributes.getBoolean(36, false);
        int resourceId2 = obtainStyledAttributes.getResourceId(45, 0);
        boolean z11 = obtainStyledAttributes.getBoolean(44, false);
        CharSequence text2 = obtainStyledAttributes.getText(43);
        int resourceId3 = obtainStyledAttributes.getResourceId(58, 0);
        CharSequence text3 = obtainStyledAttributes.getText(57);
        boolean z12 = obtainStyledAttributes.getBoolean(18, false);
        setCounterMaxLength(obtainStyledAttributes.getInt(19, -1));
        this.F = obtainStyledAttributes.getResourceId(22, 0);
        this.E = obtainStyledAttributes.getResourceId(20, 0);
        setBoxBackgroundMode(obtainStyledAttributes.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i10);
        setCounterOverflowTextAppearance(this.E);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.F);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (obtainStyledAttributes.hasValue(41)) {
            setErrorTextColor(a0Var.J(41));
        }
        if (obtainStyledAttributes.hasValue(46)) {
            setHelperTextColor(a0Var.J(46));
        }
        if (obtainStyledAttributes.hasValue(51)) {
            setHintTextColor(a0Var.J(51));
        }
        if (obtainStyledAttributes.hasValue(23)) {
            setCounterTextColor(a0Var.J(23));
        }
        if (obtainStyledAttributes.hasValue(21)) {
            setCounterOverflowTextColor(a0Var.J(21));
        }
        if (obtainStyledAttributes.hasValue(59)) {
            setPlaceholderTextColor(a0Var.J(59));
        }
        p pVar = new p(this, a0Var);
        this.f3860q = pVar;
        boolean z13 = obtainStyledAttributes.getBoolean(0, true);
        setHintMaxLines(obtainStyledAttributes.getInt(49, 1));
        a0Var.U();
        setImportantForAccessibility(2);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
        frameLayout.addView(yVar);
        frameLayout.addView(pVar);
        addView(frameLayout);
        setEnabled(z13);
        setHelperTextEnabled(z11);
        setErrorEnabled(z10);
        setCounterEnabled(z12);
        setHelperText(text2);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f3864s;
        if (!(editText instanceof AutoCompleteTextView) || editText.getInputType() != 0) {
            return this.U;
        }
        int l10 = e.l(this.f3864s, org.chromium.net.R.attr.colorControlHighlight);
        int i10 = this.f3849g0;
        int[][] iArr = R0;
        if (i10 != 2) {
            if (i10 != 1) {
                return null;
            }
            j jVar = this.U;
            int i11 = this.f3854m0;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{e.p(0.1f, l10, i11), i11}), jVar, jVar);
        }
        Context context = getContext();
        j jVar2 = this.U;
        TypedValue z10 = c.z(org.chromium.net.R.attr.colorSurface, context, "TextInputLayout");
        int i12 = z10.resourceId;
        int color = i12 != 0 ? context.getColor(i12) : z10.data;
        j jVar3 = new j(jVar2.f4277p.f4259a);
        int p10 = e.p(0.1f, l10, color);
        jVar3.n(new ColorStateList(iArr, new int[]{p10, 0}));
        jVar3.setTint(color);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{p10, color});
        j jVar4 = new j(jVar2.f4277p.f4259a);
        jVar4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, jVar3, jVar4), jVar2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.W == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.W = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.W.addState(new int[0], h(false));
        }
        return this.W;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.V == null) {
            this.V = h(true);
        }
        return this.V;
    }

    public static void m(ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                m((ViewGroup) childAt, z10);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f3864s != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f3864s = editText;
        int i10 = this.f3868u;
        if (i10 != -1) {
            setMinEms(i10);
        } else {
            setMinWidth(this.f3872w);
        }
        int i11 = this.f3870v;
        if (i11 != -1) {
            setMaxEms(i11);
        } else {
            setMaxWidth(this.f3874x);
        }
        this.f3843a0 = false;
        k();
        setTextInputAccessibilityDelegate(new g9.a0(this));
        Typeface typeface = this.f3864s.getTypeface();
        b bVar = this.K0;
        bVar.n(typeface);
        float textSize = this.f3864s.getTextSize();
        if (bVar.f13701h != textSize) {
            bVar.f13701h = textSize;
            bVar.j(false);
        }
        float letterSpacing = this.f3864s.getLetterSpacing();
        if (bVar.X != letterSpacing) {
            bVar.X = letterSpacing;
            bVar.j(false);
        }
        int gravity = this.f3864s.getGravity();
        int i12 = (gravity & (-113)) | 48;
        if (bVar.g != i12) {
            bVar.g = i12;
            bVar.j(false);
        }
        if (bVar.f13698f != gravity) {
            bVar.f13698f = gravity;
            bVar.j(false);
        }
        this.I0 = editText.getMinimumHeight();
        this.f3864s.addTextChangedListener(new z(this, editText));
        if (this.f3875x0 == null) {
            this.f3875x0 = this.f3864s.getHintTextColors();
        }
        if (this.R) {
            if (TextUtils.isEmpty(this.S)) {
                CharSequence hint = this.f3864s.getHint();
                this.f3866t = hint;
                setHint(hint);
                this.f3864s.setHint((CharSequence) null);
            }
            this.T = true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            r();
        }
        if (this.D != null) {
            p(this.f3864s.getText());
        }
        t();
        this.f3876y.b();
        this.f3858p.bringToFront();
        p pVar = this.f3860q;
        pVar.bringToFront();
        Iterator it = this.f3867t0.iterator();
        while (it.hasNext()) {
            ((o) it.next()).a(this);
        }
        pVar.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        w(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.S)) {
            return;
        }
        this.S = charSequence;
        b bVar = this.K0;
        if (charSequence == null || !TextUtils.equals(bVar.B, charSequence)) {
            bVar.B = charSequence;
            bVar.C = null;
            bVar.j(false);
        }
        if (this.J0) {
            return;
        }
        l();
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.H == z10) {
            return;
        }
        if (z10) {
            w0 w0Var = this.I;
            if (w0Var != null) {
                this.f3856o.addView(w0Var);
                this.I.setVisibility(0);
            }
        } else {
            w0 w0Var2 = this.I;
            if (w0Var2 != null) {
                w0Var2.setVisibility(8);
            }
            this.I = null;
        }
        this.H = z10;
    }

    public final void a() {
        if (this.f3864s == null || this.f3849g0 != 1) {
            return;
        }
        if (getHintMaxLines() != 1) {
            EditText editText = this.f3864s;
            editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.K0.f() + this.f3862r), this.f3864s.getPaddingEnd(), getResources().getDimensionPixelSize(org.chromium.net.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        } else if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
            EditText editText2 = this.f3864s;
            editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(org.chromium.net.R.dimen.material_filled_edittext_font_2_0_padding_top), this.f3864s.getPaddingEnd(), getResources().getDimensionPixelSize(org.chromium.net.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (d.y(getContext())) {
            EditText editText3 = this.f3864s;
            editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(org.chromium.net.R.dimen.material_filled_edittext_font_1_3_padding_top), this.f3864s.getPaddingEnd(), getResources().getDimensionPixelSize(org.chromium.net.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i10, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f3856o;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        v();
        setEditText((EditText) view);
    }

    public final void b(float f10) {
        b bVar = this.K0;
        if (bVar.f13690b == f10) {
            return;
        }
        int i10 = 1;
        if (this.N0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.N0 = valueAnimator;
            valueAnimator.setInterpolator(w7.b.v(getContext(), org.chromium.net.R.attr.motionEasingEmphasizedInterpolator, k8.a.f7831b));
            this.N0.setDuration(w7.b.u(getContext(), org.chromium.net.R.attr.motionDurationMedium4, 167));
            this.N0.addUpdateListener(new b4.m(i10, this));
        }
        this.N0.setFloatValues(bVar.f13690b, f10);
        this.N0.start();
    }

    public final void c() {
        int i10;
        int i11;
        j jVar = this.U;
        if (jVar == null) {
            return;
        }
        n nVar = jVar.f4277p.f4259a;
        n nVar2 = this.f3846d0;
        if (nVar != nVar2) {
            jVar.setShapeAppearanceModel(nVar2);
        }
        if (this.f3849g0 == 2 && (i10 = this.f3850i0) > -1 && (i11 = this.f3853l0) != 0) {
            j jVar2 = this.U;
            jVar2.f4277p.f4268k = i10;
            jVar2.invalidateSelf();
            ColorStateList valueOf = ColorStateList.valueOf(i11);
            h hVar = jVar2.f4277p;
            if (hVar.f4263e != valueOf) {
                hVar.f4263e = valueOf;
                jVar2.onStateChange(jVar2.getState());
            }
        }
        int i12 = this.f3854m0;
        if (this.f3849g0 == 1) {
            i12 = e0.a.f(this.f3854m0, e.k(getContext(), org.chromium.net.R.attr.colorSurface, 0));
        }
        this.f3854m0 = i12;
        this.U.n(ColorStateList.valueOf(i12));
        j jVar3 = this.f3844b0;
        if (jVar3 != null && this.f3845c0 != null) {
            if (this.f3850i0 > -1 && this.f3853l0 != 0) {
                jVar3.n(this.f3864s.isFocused() ? ColorStateList.valueOf(this.f3879z0) : ColorStateList.valueOf(this.f3853l0));
                this.f3845c0.n(ColorStateList.valueOf(this.f3853l0));
            }
            invalidate();
        }
        u();
    }

    public final Rect d(Rect rect) {
        if (this.f3864s == null) {
            throw new IllegalStateException();
        }
        boolean z10 = getLayoutDirection() == 1;
        int i10 = rect.bottom;
        Rect rect2 = this.f3857o0;
        rect2.bottom = i10;
        int i11 = this.f3849g0;
        if (i11 == 1) {
            rect2.left = i(rect.left, z10);
            rect2.top = rect.top + this.h0;
            rect2.right = j(rect.right, z10);
            return rect2;
        }
        if (i11 != 2) {
            rect2.left = i(rect.left, z10);
            rect2.top = getPaddingTop();
            rect2.right = j(rect.right, z10);
            return rect2;
        }
        rect2.left = this.f3864s.getPaddingLeft() + rect.left;
        rect2.top = rect.top - e();
        rect2.right = rect.right - this.f3864s.getPaddingRight();
        return rect2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i10) {
        EditText editText = this.f3864s;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.f3866t != null) {
            boolean z10 = this.T;
            this.T = false;
            CharSequence hint = editText.getHint();
            this.f3864s.setHint(this.f3866t);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i10);
                return;
            } finally {
                this.f3864s.setHint(hint);
                this.T = z10;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i10);
        onProvideAutofillVirtualStructure(viewStructure, i10);
        FrameLayout frameLayout = this.f3856o;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i11 = 0; i11 < frameLayout.getChildCount(); i11++) {
            View childAt = frameLayout.getChildAt(i11);
            ViewStructure newChild = viewStructure.newChild(i11);
            childAt.dispatchProvideAutofillStructure(newChild, i10);
            if (childAt == this.f3864s) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.P0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.P0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        j jVar;
        Canvas canvas2 = canvas;
        super.draw(canvas);
        boolean z10 = this.R;
        b bVar = this.K0;
        if (z10) {
            TextPaint textPaint = bVar.O;
            RectF rectF = bVar.f13696e;
            int save = canvas2.save();
            if (bVar.C != null && rectF.width() > 0.0f && rectF.height() > 0.0f) {
                textPaint.setTextSize(bVar.G);
                float f10 = bVar.f13713q;
                float f11 = bVar.f13714r;
                float f12 = bVar.F;
                if (f12 != 1.0f) {
                    canvas2.scale(f12, f12, f10, f11);
                }
                if ((bVar.f13697e0 > 1 || bVar.f13699f0 > 1) && !bVar.D && bVar.o()) {
                    float lineStart = bVar.f13713q - bVar.Z.getLineStart(0);
                    int alpha = textPaint.getAlpha();
                    canvas2.translate(lineStart, f11);
                    float f13 = alpha;
                    textPaint.setAlpha((int) (bVar.f13693c0 * f13));
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 31) {
                        float f14 = bVar.H;
                        float f15 = bVar.I;
                        float f16 = bVar.J;
                        int i11 = bVar.K;
                        textPaint.setShadowLayer(f14, f15, f16, e0.a.h(i11, (textPaint.getAlpha() * Color.alpha(i11)) / 255));
                    }
                    bVar.Z.draw(canvas2);
                    textPaint.setAlpha((int) (bVar.f13691b0 * f13));
                    if (i10 >= 31) {
                        float f17 = bVar.H;
                        float f18 = bVar.I;
                        float f19 = bVar.J;
                        int i12 = bVar.K;
                        textPaint.setShadowLayer(f17, f18, f19, e0.a.h(i12, (Color.alpha(i12) * textPaint.getAlpha()) / 255));
                    }
                    int lineBaseline = bVar.Z.getLineBaseline(0);
                    CharSequence charSequence = bVar.f13695d0;
                    float f20 = lineBaseline;
                    canvas2.drawText(charSequence, 0, charSequence.length(), 0.0f, f20, textPaint);
                    if (i10 >= 31) {
                        textPaint.setShadowLayer(bVar.H, bVar.I, bVar.J, bVar.K);
                    }
                    String trim = bVar.f13695d0.toString().trim();
                    if (trim.endsWith("…")) {
                        trim = trim.substring(0, trim.length() - 1);
                    }
                    String str = trim;
                    textPaint.setAlpha(alpha);
                    canvas2 = canvas;
                    canvas2.drawText(str, 0, Math.min(bVar.Z.getLineEnd(0), str.length()), 0.0f, f20, (Paint) textPaint);
                } else {
                    canvas2.translate(f10, f11);
                    bVar.Z.draw(canvas2);
                }
                canvas2.restoreToCount(save);
            }
        }
        if (this.f3845c0 == null || (jVar = this.f3844b0) == null) {
            return;
        }
        jVar.draw(canvas2);
        if (this.f3864s.isFocused()) {
            Rect bounds = this.f3845c0.getBounds();
            Rect bounds2 = this.f3844b0.getBounds();
            float f21 = bVar.f13690b;
            int centerX = bounds2.centerX();
            bounds.left = k8.a.c(f21, centerX, bounds2.left);
            bounds.right = k8.a.c(f21, centerX, bounds2.right);
            this.f3845c0.draw(canvas2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.O0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.O0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            x8.b r3 = r4.K0
            if (r3 == 0) goto L2f
            r3.M = r1
            android.content.res.ColorStateList r1 = r3.f13706k
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f13704j
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.j(r2)
            r1 = r0
            goto L30
        L2f:
            r1 = r2
        L30:
            android.widget.EditText r3 = r4.f3864s
            if (r3 == 0) goto L45
            boolean r3 = r4.isLaidOut()
            if (r3 == 0) goto L41
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L41
            goto L42
        L41:
            r0 = r2
        L42:
            r4.w(r0, r2)
        L45:
            r4.t()
            r4.z()
            if (r1 == 0) goto L50
            r4.invalidate()
        L50:
            r4.O0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final int e() {
        if (this.R) {
            int i10 = this.f3849g0;
            b bVar = this.K0;
            if (i10 == 0) {
                return (int) bVar.f();
            }
            if (i10 == 2) {
                if (getHintMaxLines() == 1) {
                    return (int) (bVar.f() / 2.0f);
                }
                float f10 = bVar.f();
                TextPaint textPaint = bVar.P;
                textPaint.setTextSize(bVar.f13702i);
                textPaint.setTypeface(bVar.f13715s);
                textPaint.setLetterSpacing(bVar.W);
                return Math.max(0, (int) (f10 - ((-textPaint.ascent()) / 2.0f)));
            }
        }
        return 0;
    }

    public final g f() {
        g gVar = new g();
        gVar.f8237q = w7.b.u(getContext(), org.chromium.net.R.attr.motionDurationShort2, 87);
        gVar.f8238r = w7.b.v(getContext(), org.chromium.net.R.attr.motionEasingLinearInterpolator, k8.a.f7830a);
        return gVar;
    }

    public final boolean g() {
        return this.R && !TextUtils.isEmpty(this.S) && (this.U instanceof g9.g);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f3864s;
        if (editText == null) {
            return super.getBaseline();
        }
        return e() + getPaddingTop() + editText.getBaseline();
    }

    public j getBoxBackground() {
        int i10 = this.f3849g0;
        if (i10 == 1 || i10 == 2) {
            return this.U;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f3854m0;
    }

    public int getBoxBackgroundMode() {
        return this.f3849g0;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.h0;
    }

    public float getBoxCornerRadiusBottomEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f3859p0;
        return layoutDirection == 1 ? this.f3846d0.f4306h.a(rectF) : this.f3846d0.g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f3859p0;
        return layoutDirection == 1 ? this.f3846d0.g.a(rectF) : this.f3846d0.f4306h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f3859p0;
        return layoutDirection == 1 ? this.f3846d0.f4304e.a(rectF) : this.f3846d0.f4305f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f3859p0;
        return layoutDirection == 1 ? this.f3846d0.f4305f.a(rectF) : this.f3846d0.f4304e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.B0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.C0;
    }

    public int getBoxStrokeWidth() {
        return this.f3851j0;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f3852k0;
    }

    public int getCounterMaxLength() {
        return this.A;
    }

    public CharSequence getCounterOverflowDescription() {
        w0 w0Var;
        if (this.f3878z && this.B && (w0Var = this.D) != null) {
            return w0Var.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.O;
    }

    public ColorStateList getCounterTextColor() {
        return this.N;
    }

    public ColorStateList getCursorColor() {
        return this.P;
    }

    public ColorStateList getCursorErrorColor() {
        return this.Q;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f3875x0;
    }

    public EditText getEditText() {
        return this.f3864s;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f3860q.f5372u.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f3860q.f5372u.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f3860q.A;
    }

    public int getEndIconMode() {
        return this.f3860q.f5374w;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f3860q.B;
    }

    public CheckableImageButton getEndIconView() {
        return this.f3860q.f5372u;
    }

    public CharSequence getError() {
        t tVar = this.f3876y;
        if (tVar.f5404q) {
            return tVar.f5403p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f3876y.f5407t;
    }

    public CharSequence getErrorContentDescription() {
        return this.f3876y.f5406s;
    }

    public int getErrorCurrentTextColors() {
        w0 w0Var = this.f3876y.f5405r;
        if (w0Var != null) {
            return w0Var.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f3860q.f5368q.getDrawable();
    }

    public CharSequence getHelperText() {
        t tVar = this.f3876y;
        if (tVar.f5411x) {
            return tVar.f5410w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        w0 w0Var = this.f3876y.f5412y;
        if (w0Var != null) {
            return w0Var.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.R) {
            return this.S;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.K0.f();
    }

    public final int getHintCurrentCollapsedTextColor() {
        b bVar = this.K0;
        return bVar.g(bVar.f13706k);
    }

    public int getHintMaxLines() {
        return this.K0.f13697e0;
    }

    public ColorStateList getHintTextColor() {
        return this.f3877y0;
    }

    public b0 getLengthCounter() {
        return this.C;
    }

    public int getMaxEms() {
        return this.f3870v;
    }

    public int getMaxWidth() {
        return this.f3874x;
    }

    public int getMinEms() {
        return this.f3868u;
    }

    public int getMinWidth() {
        return this.f3872w;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f3860q.f5372u.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f3860q.f5372u.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.H) {
            return this.G;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.K;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.J;
    }

    public CharSequence getPrefixText() {
        return this.f3858p.f5431q;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f3858p.f5430p.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f3858p.f5430p;
    }

    public n getShapeAppearanceModel() {
        return this.f3846d0;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f3858p.f5432r.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f3858p.f5432r.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f3858p.f5435u;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f3858p.f5436v;
    }

    public CharSequence getSuffixText() {
        return this.f3860q.D;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f3860q.E.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f3860q.E;
    }

    public Typeface getTypeface() {
        return this.f3861q0;
    }

    public final j h(boolean z10) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(org.chromium.net.R.dimen.mtrl_shape_corner_size_small_component);
        float f10 = z10 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f3864s;
        float popupElevation = editText instanceof w ? ((w) editText).getPopupElevation() : getResources().getDimensionPixelOffset(org.chromium.net.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(org.chromium.net.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        l lVar = new l();
        l lVar2 = new l();
        l lVar3 = new l();
        l lVar4 = new l();
        int i10 = 0;
        f fVar = new f(i10);
        f fVar2 = new f(i10);
        f fVar3 = new f(i10);
        f fVar4 = new f(i10);
        d9.a aVar = new d9.a(f10);
        d9.a aVar2 = new d9.a(f10);
        d9.a aVar3 = new d9.a(dimensionPixelOffset);
        d9.a aVar4 = new d9.a(dimensionPixelOffset);
        n nVar = new n();
        nVar.f4300a = lVar;
        nVar.f4301b = lVar2;
        nVar.f4302c = lVar3;
        nVar.f4303d = lVar4;
        nVar.f4304e = aVar;
        nVar.f4305f = aVar2;
        nVar.g = aVar4;
        nVar.f4306h = aVar3;
        nVar.f4307i = fVar;
        nVar.f4308j = fVar2;
        nVar.f4309k = fVar3;
        nVar.f4310l = fVar4;
        EditText editText2 = this.f3864s;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof w ? ((w) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = j.S;
            TypedValue z11 = c.z(org.chromium.net.R.attr.colorSurface, context, j.class.getSimpleName());
            int i11 = z11.resourceId;
            dropDownBackgroundTintList = ColorStateList.valueOf(i11 != 0 ? context.getColor(i11) : z11.data);
        }
        j jVar = new j();
        jVar.k(context);
        jVar.n(dropDownBackgroundTintList);
        jVar.m(popupElevation);
        jVar.setShapeAppearanceModel(nVar);
        h hVar = jVar.f4277p;
        if (hVar.f4265h == null) {
            hVar.f4265h = new Rect();
        }
        jVar.f4277p.f4265h.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        jVar.invalidateSelf();
        return jVar;
    }

    public final int i(int i10, boolean z10) {
        return ((z10 || getPrefixText() == null) ? (!z10 || getSuffixText() == null) ? this.f3864s.getCompoundPaddingLeft() : this.f3860q.c() : this.f3858p.a()) + i10;
    }

    public final int j(int i10, boolean z10) {
        return i10 - ((z10 || getSuffixText() == null) ? (!z10 || getPrefixText() == null) ? this.f3864s.getCompoundPaddingRight() : this.f3858p.a() : this.f3860q.c());
    }

    public final void k() {
        int i10 = this.f3849g0;
        if (i10 == 0) {
            this.U = null;
            this.f3844b0 = null;
            this.f3845c0 = null;
        } else if (i10 == 1) {
            this.U = new j(this.f3846d0);
            this.f3844b0 = new j();
            this.f3845c0 = new j();
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException(r.a.d(new StringBuilder(), this.f3849g0, " is illegal; only @BoxBackgroundMode constants are supported."));
            }
            if (!this.R || (this.U instanceof g9.g)) {
                this.U = new j(this.f3846d0);
            } else {
                n nVar = this.f3846d0;
                int i11 = g9.g.V;
                if (nVar == null) {
                    nVar = new n();
                }
                g9.f fVar = new g9.f(nVar, new RectF());
                g9.g gVar = new g9.g(fVar);
                gVar.U = fVar;
                this.U = gVar;
            }
            this.f3844b0 = null;
            this.f3845c0 = null;
        }
        u();
        z();
        if (this.f3849g0 == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.h0 = getResources().getDimensionPixelSize(org.chromium.net.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (d.y(getContext())) {
                this.h0 = getResources().getDimensionPixelSize(org.chromium.net.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        a();
        if (this.f3849g0 != 0) {
            v();
        }
        EditText editText = this.f3864s;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i12 = this.f3849g0;
                if (i12 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i12 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.l():void");
    }

    public final void n(w0 w0Var, int i10) {
        try {
            w0Var.setTextAppearance(i10);
            if (w0Var.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        w0Var.setTextAppearance(org.chromium.net.R.style.TextAppearance_AppCompat_Caption);
        w0Var.setTextColor(getContext().getColor(org.chromium.net.R.color.design_error));
    }

    public final boolean o() {
        t tVar = this.f3876y;
        return (tVar.f5402o != 1 || tVar.f5405r == null || TextUtils.isEmpty(tVar.f5403p)) ? false : true;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.K0.i(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int max;
        p pVar = this.f3860q;
        pVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z10 = false;
        this.Q0 = false;
        if (this.f3864s != null && this.f3864s.getMeasuredHeight() < (max = Math.max(pVar.getMeasuredHeight(), this.f3858p.getMeasuredHeight()))) {
            this.f3864s.setMinimumHeight(max);
            z10 = true;
        }
        boolean s10 = s();
        if (z10 || s10) {
            this.f3864s.post(new androidx.activity.d(12, this));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        float descent;
        int i14;
        int compoundPaddingTop;
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText = this.f3864s;
        if (editText != null) {
            Rect rect = this.f3855n0;
            x8.c.a(this, editText, rect);
            j jVar = this.f3844b0;
            if (jVar != null) {
                int i15 = rect.bottom;
                jVar.setBounds(rect.left, i15 - this.f3851j0, rect.right, i15);
            }
            j jVar2 = this.f3845c0;
            if (jVar2 != null) {
                int i16 = rect.bottom;
                jVar2.setBounds(rect.left, i16 - this.f3852k0, rect.right, i16);
            }
            if (this.R) {
                float textSize = this.f3864s.getTextSize();
                b bVar = this.K0;
                float f10 = bVar.f13701h;
                TextPaint textPaint = bVar.P;
                if (f10 != textSize) {
                    bVar.f13701h = textSize;
                    bVar.j(false);
                }
                int gravity = this.f3864s.getGravity();
                int i17 = (gravity & (-113)) | 48;
                if (bVar.g != i17) {
                    bVar.g = i17;
                    bVar.j(false);
                }
                if (bVar.f13698f != gravity) {
                    bVar.f13698f = gravity;
                    bVar.j(false);
                }
                Rect d6 = d(rect);
                int i18 = d6.left;
                int i19 = d6.top;
                int i20 = d6.right;
                int i21 = d6.bottom;
                Rect rect2 = bVar.f13694d;
                if (rect2.left != i18 || rect2.top != i19 || rect2.right != i20 || rect2.bottom != i21) {
                    rect2.set(i18, i19, i20, i21);
                    bVar.N = true;
                }
                if (this.f3864s == null) {
                    throw new IllegalStateException();
                }
                if (getHintMaxLines() == 1) {
                    textPaint.setTextSize(bVar.f13701h);
                    textPaint.setTypeface(bVar.f13718v);
                    textPaint.setLetterSpacing(bVar.X);
                    descent = -textPaint.ascent();
                } else {
                    textPaint.setTextSize(bVar.f13701h);
                    textPaint.setTypeface(bVar.f13718v);
                    textPaint.setLetterSpacing(bVar.X);
                    descent = bVar.f13708l * (textPaint.descent() + (-textPaint.ascent()));
                }
                int compoundPaddingLeft = this.f3864s.getCompoundPaddingLeft() + rect.left;
                Rect rect3 = this.f3857o0;
                rect3.left = compoundPaddingLeft;
                if (this.f3849g0 != 1 || this.f3864s.getMinLines() > 1) {
                    if (this.f3849g0 != 0 || getHintMaxLines() == 1) {
                        i14 = 0;
                    } else {
                        textPaint.setTextSize(bVar.f13701h);
                        textPaint.setTypeface(bVar.f13718v);
                        textPaint.setLetterSpacing(bVar.X);
                        i14 = (int) ((-textPaint.ascent()) / 2.0f);
                    }
                    compoundPaddingTop = (this.f3864s.getCompoundPaddingTop() + rect.top) - i14;
                } else {
                    compoundPaddingTop = (int) (rect.centerY() - (descent / 2.0f));
                }
                rect3.top = compoundPaddingTop;
                rect3.right = rect.right - this.f3864s.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.f3849g0 != 1 || this.f3864s.getMinLines() > 1) ? rect.bottom - this.f3864s.getCompoundPaddingBottom() : (int) (rect3.top + descent);
                rect3.bottom = compoundPaddingBottom;
                int i22 = rect3.left;
                int i23 = rect3.top;
                int i24 = rect3.right;
                Rect rect4 = bVar.f13692c;
                if (rect4.left != i22 || rect4.top != i23 || rect4.right != i24 || rect4.bottom != compoundPaddingBottom || true != bVar.f13707k0) {
                    rect4.set(i22, i23, i24, compoundPaddingBottom);
                    bVar.N = true;
                    bVar.f13707k0 = true;
                }
                bVar.j(false);
                if (!g() || this.J0) {
                    return;
                }
                l();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        float f10;
        EditText editText;
        super.onMeasure(i10, i11);
        boolean z10 = this.Q0;
        p pVar = this.f3860q;
        if (!z10) {
            pVar.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.Q0 = true;
        }
        if (this.I != null && (editText = this.f3864s) != null) {
            this.I.setGravity(editText.getGravity());
            this.I.setPadding(this.f3864s.getCompoundPaddingLeft(), this.f3864s.getCompoundPaddingTop(), this.f3864s.getCompoundPaddingRight(), this.f3864s.getCompoundPaddingBottom());
        }
        pVar.m();
        if (getHintMaxLines() == 1) {
            return;
        }
        int measuredWidth = (this.f3864s.getMeasuredWidth() - this.f3864s.getCompoundPaddingLeft()) - this.f3864s.getCompoundPaddingRight();
        b bVar = this.K0;
        TextPaint textPaint = bVar.P;
        textPaint.setTextSize(bVar.f13702i);
        textPaint.setTypeface(bVar.f13715s);
        textPaint.setLetterSpacing(bVar.W);
        float f11 = measuredWidth;
        bVar.f13703i0 = bVar.e(bVar.f13699f0, textPaint, bVar.B, (bVar.f13702i / bVar.f13701h) * f11, bVar.D).getHeight();
        textPaint.setTextSize(bVar.f13701h);
        textPaint.setTypeface(bVar.f13718v);
        textPaint.setLetterSpacing(bVar.X);
        bVar.f13705j0 = bVar.e(bVar.f13697e0, textPaint, bVar.B, f11, bVar.D).getHeight();
        EditText editText2 = this.f3864s;
        Rect rect = this.f3855n0;
        x8.c.a(this, editText2, rect);
        Rect d6 = d(rect);
        int i12 = d6.left;
        int i13 = d6.top;
        int i14 = d6.right;
        int i15 = d6.bottom;
        Rect rect2 = bVar.f13694d;
        if (rect2.left != i12 || rect2.top != i13 || rect2.right != i14 || rect2.bottom != i15) {
            rect2.set(i12, i13, i14, i15);
            bVar.N = true;
        }
        v();
        a();
        if (this.f3864s == null) {
            return;
        }
        int i16 = bVar.f13705j0;
        if (i16 != -1) {
            f10 = i16;
        } else {
            TextPaint textPaint2 = bVar.P;
            textPaint2.setTextSize(bVar.f13701h);
            textPaint2.setTypeface(bVar.f13718v);
            textPaint2.setLetterSpacing(bVar.X);
            f10 = -textPaint2.ascent();
        }
        if (this.G != null) {
            TextPaint textPaint3 = new TextPaint(129);
            textPaint3.set(this.I.getPaint());
            textPaint3.setTextSize(this.I.getTextSize());
            textPaint3.setTypeface(this.I.getTypeface());
            textPaint3.setLetterSpacing(this.I.getLetterSpacing());
            x8.g gVar = new x8.g(this.G, textPaint3, measuredWidth);
            gVar.f13734k = getLayoutDirection() == 1;
            gVar.f13733j = true;
            float lineSpacingExtra = this.I.getLineSpacingExtra();
            float lineSpacingMultiplier = this.I.getLineSpacingMultiplier();
            gVar.g = lineSpacingExtra;
            gVar.f13731h = lineSpacingMultiplier;
            gVar.f13736m = new v0(7, this);
            r3 = (this.f3849g0 == 1 ? bVar.f() + this.h0 + this.f3862r : 0.0f) + gVar.a().getHeight();
        }
        float max = Math.max(f10, r3);
        if (this.f3864s.getMeasuredHeight() < max) {
            this.f3864s.setMinimumHeight(Math.round(max));
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c0 c0Var = (c0) parcelable;
        super.onRestoreInstanceState(c0Var.f10407o);
        setError(c0Var.f5332q);
        if (c0Var.f5333r) {
            post(new androidx.activity.j(16, this));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z10 = i10 == 1;
        if (z10 != this.f3847e0) {
            d9.d dVar = this.f3846d0.f4304e;
            RectF rectF = this.f3859p0;
            float a10 = dVar.a(rectF);
            float a11 = this.f3846d0.f4305f.a(rectF);
            float a12 = this.f3846d0.f4306h.a(rectF);
            float a13 = this.f3846d0.g.a(rectF);
            n nVar = this.f3846d0;
            i7.e eVar = nVar.f4300a;
            i7.e eVar2 = nVar.f4301b;
            i7.e eVar3 = nVar.f4303d;
            i7.e eVar4 = nVar.f4302c;
            f fVar = new f(0);
            f fVar2 = new f(0);
            f fVar3 = new f(0);
            f fVar4 = new f(0);
            d9.a aVar = new d9.a(a11);
            d9.a aVar2 = new d9.a(a10);
            d9.a aVar3 = new d9.a(a13);
            d9.a aVar4 = new d9.a(a12);
            n nVar2 = new n();
            nVar2.f4300a = eVar2;
            nVar2.f4301b = eVar;
            nVar2.f4302c = eVar3;
            nVar2.f4303d = eVar4;
            nVar2.f4304e = aVar;
            nVar2.f4305f = aVar2;
            nVar2.g = aVar4;
            nVar2.f4306h = aVar3;
            nVar2.f4307i = fVar;
            nVar2.f4308j = fVar2;
            nVar2.f4309k = fVar3;
            nVar2.f4310l = fVar4;
            this.f3847e0 = z10;
            setShapeAppearanceModel(nVar2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        c0 c0Var = new c0(super.onSaveInstanceState());
        if (o()) {
            c0Var.f5332q = getError();
        }
        p pVar = this.f3860q;
        c0Var.f5333r = pVar.f5374w != 0 && pVar.f5372u.f3811r;
        return c0Var;
    }

    public final void p(Editable editable) {
        ((a0) this.C).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z10 = this.B;
        int i10 = this.A;
        if (i10 == -1) {
            this.D.setText(String.valueOf(length));
            this.D.setContentDescription(null);
            this.B = false;
        } else {
            this.B = length > i10;
            Context context = getContext();
            this.D.setContentDescription(context.getString(this.B ? org.chromium.net.R.string.character_counter_overflowed_content_description : org.chromium.net.R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.A)));
            if (z10 != this.B) {
                q();
            }
            String str = k0.b.f7584b;
            k0.b bVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? k0.b.f7587e : k0.b.f7586d;
            w0 w0Var = this.D;
            String string = getContext().getString(org.chromium.net.R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.A));
            bVar.getClass();
            ea.a aVar = k0.g.f7594a;
            w0Var.setText(string != null ? bVar.c(string).toString() : null);
        }
        if (this.f3864s == null || z10 == this.B) {
            return;
        }
        w(false, false);
        z();
        t();
    }

    public final void q() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        w0 w0Var = this.D;
        if (w0Var != null) {
            n(w0Var, this.B ? this.E : this.F);
            if (!this.B && (colorStateList2 = this.N) != null) {
                this.D.setTextColor(colorStateList2);
            }
            if (!this.B || (colorStateList = this.O) == null) {
                return;
            }
            this.D.setTextColor(colorStateList);
        }
    }

    public final void r() {
        Drawable textCursorDrawable;
        Drawable textCursorDrawable2;
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.P;
        if (colorStateList2 == null) {
            Context context = getContext();
            TypedValue x6 = c.x(context, org.chromium.net.R.attr.colorControlActivated);
            if (x6 != null) {
                int i10 = x6.resourceId;
                if (i10 != 0) {
                    colorStateList2 = n4.a.n(context, i10);
                } else {
                    int i11 = x6.data;
                    if (i11 != 0) {
                        colorStateList2 = ColorStateList.valueOf(i11);
                    }
                }
            }
            colorStateList2 = null;
        }
        EditText editText = this.f3864s;
        if (editText != null) {
            textCursorDrawable = editText.getTextCursorDrawable();
            if (textCursorDrawable == null) {
                return;
            }
            textCursorDrawable2 = this.f3864s.getTextCursorDrawable();
            Drawable mutate = textCursorDrawable2.mutate();
            if ((o() || (this.D != null && this.B)) && (colorStateList = this.Q) != null) {
                colorStateList2 = colorStateList;
            }
            mutate.setTintList(colorStateList2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s() {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.s():boolean");
    }

    public void setBoxBackgroundColor(int i10) {
        if (this.f3854m0 != i10) {
            this.f3854m0 = i10;
            this.D0 = i10;
            this.F0 = i10;
            this.G0 = i10;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i10) {
        setBoxBackgroundColor(getContext().getColor(i10));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.D0 = defaultColor;
        this.f3854m0 = defaultColor;
        this.E0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.F0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.G0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 == this.f3849g0) {
            return;
        }
        this.f3849g0 = i10;
        if (this.f3864s != null) {
            k();
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.h0 = i10;
    }

    public void setBoxCornerFamily(int i10) {
        m f10 = this.f3846d0.f();
        d9.d dVar = this.f3846d0.f4304e;
        f10.f4289a = j1.c.h(i10);
        f10.f4293e = dVar;
        d9.d dVar2 = this.f3846d0.f4305f;
        f10.f4290b = j1.c.h(i10);
        f10.f4294f = dVar2;
        d9.d dVar3 = this.f3846d0.f4306h;
        f10.f4292d = j1.c.h(i10);
        f10.f4295h = dVar3;
        d9.d dVar4 = this.f3846d0.g;
        f10.f4291c = j1.c.h(i10);
        f10.g = dVar4;
        this.f3846d0 = f10.a();
        c();
    }

    public void setBoxStrokeColor(int i10) {
        if (this.B0 != i10) {
            this.B0 = i10;
            z();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f3879z0 = colorStateList.getDefaultColor();
            this.H0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.A0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.B0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.B0 != colorStateList.getDefaultColor()) {
            this.B0 = colorStateList.getDefaultColor();
        }
        z();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.C0 != colorStateList) {
            this.C0 = colorStateList;
            z();
        }
    }

    public void setBoxStrokeWidth(int i10) {
        this.f3851j0 = i10;
        z();
    }

    public void setBoxStrokeWidthFocused(int i10) {
        this.f3852k0 = i10;
        z();
    }

    public void setBoxStrokeWidthFocusedResource(int i10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(int i10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.f3878z != z10) {
            t tVar = this.f3876y;
            if (z10) {
                w0 w0Var = new w0(getContext(), null);
                this.D = w0Var;
                w0Var.setId(org.chromium.net.R.id.textinput_counter);
                Typeface typeface = this.f3861q0;
                if (typeface != null) {
                    this.D.setTypeface(typeface);
                }
                this.D.setMaxLines(1);
                tVar.a(this.D, 2);
                ((ViewGroup.MarginLayoutParams) this.D.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(org.chromium.net.R.dimen.mtrl_textinput_counter_margin_start));
                q();
                if (this.D != null) {
                    EditText editText = this.f3864s;
                    p(editText != null ? editText.getText() : null);
                }
            } else {
                tVar.g(this.D, 2);
                this.D = null;
            }
            this.f3878z = z10;
        }
    }

    public void setCounterMaxLength(int i10) {
        if (this.A != i10) {
            if (i10 > 0) {
                this.A = i10;
            } else {
                this.A = -1;
            }
            if (!this.f3878z || this.D == null) {
                return;
            }
            EditText editText = this.f3864s;
            p(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.E != i10) {
            this.E = i10;
            q();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.O != colorStateList) {
            this.O = colorStateList;
            q();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.F != i10) {
            this.F = i10;
            q();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.N != colorStateList) {
            this.N = colorStateList;
            q();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            r();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.Q != colorStateList) {
            this.Q = colorStateList;
            if (o() || (this.D != null && this.B)) {
                r();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f3875x0 = colorStateList;
        this.f3877y0 = colorStateList;
        if (this.f3864s != null) {
            w(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        m(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f3860q.f5372u.setActivated(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f3860q.f5372u.setCheckable(z10);
    }

    public void setEndIconContentDescription(int i10) {
        p pVar = this.f3860q;
        CharSequence text = i10 != 0 ? pVar.getResources().getText(i10) : null;
        CheckableImageButton checkableImageButton = pVar.f5372u;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i10) {
        p pVar = this.f3860q;
        Drawable o2 = i10 != 0 ? n4.a.o(pVar.getContext(), i10) : null;
        TextInputLayout textInputLayout = pVar.f5366o;
        CheckableImageButton checkableImageButton = pVar.f5372u;
        checkableImageButton.setImageDrawable(o2);
        if (o2 != null) {
            a.a.a(textInputLayout, checkableImageButton, pVar.f5376y, pVar.f5377z);
            a.a.s(textInputLayout, checkableImageButton, pVar.f5376y);
        }
    }

    public void setEndIconMinSize(int i10) {
        p pVar = this.f3860q;
        if (i10 < 0) {
            pVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i10 != pVar.A) {
            pVar.A = i10;
            CheckableImageButton checkableImageButton = pVar.f5372u;
            checkableImageButton.setMinimumWidth(i10);
            checkableImageButton.setMinimumHeight(i10);
            CheckableImageButton checkableImageButton2 = pVar.f5368q;
            checkableImageButton2.setMinimumWidth(i10);
            checkableImageButton2.setMinimumHeight(i10);
        }
    }

    public void setEndIconMode(int i10) {
        this.f3860q.g(i10);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        p pVar = this.f3860q;
        CheckableImageButton checkableImageButton = pVar.f5372u;
        View.OnLongClickListener onLongClickListener = pVar.C;
        checkableImageButton.setOnClickListener(onClickListener);
        a.a.t(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        p pVar = this.f3860q;
        pVar.C = onLongClickListener;
        CheckableImageButton checkableImageButton = pVar.f5372u;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        a.a.t(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        p pVar = this.f3860q;
        pVar.B = scaleType;
        pVar.f5372u.setScaleType(scaleType);
        pVar.f5368q.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        p pVar = this.f3860q;
        if (pVar.f5376y != colorStateList) {
            pVar.f5376y = colorStateList;
            a.a.a(pVar.f5366o, pVar.f5372u, colorStateList, pVar.f5377z);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        p pVar = this.f3860q;
        if (pVar.f5377z != mode) {
            pVar.f5377z = mode;
            a.a.a(pVar.f5366o, pVar.f5372u, pVar.f5376y, mode);
        }
    }

    public void setEndIconVisible(boolean z10) {
        this.f3860q.h(z10);
    }

    public void setError(CharSequence charSequence) {
        t tVar = this.f3876y;
        if (!tVar.f5404q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            tVar.f();
            return;
        }
        tVar.c();
        tVar.f5403p = charSequence;
        tVar.f5405r.setText(charSequence);
        int i10 = tVar.f5401n;
        if (i10 != 1) {
            tVar.f5402o = 1;
        }
        tVar.i(i10, tVar.f5402o, tVar.h(tVar.f5405r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i10) {
        t tVar = this.f3876y;
        tVar.f5407t = i10;
        w0 w0Var = tVar.f5405r;
        if (w0Var != null) {
            w0Var.setAccessibilityLiveRegion(i10);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        t tVar = this.f3876y;
        tVar.f5406s = charSequence;
        w0 w0Var = tVar.f5405r;
        if (w0Var != null) {
            w0Var.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z10) {
        t tVar = this.f3876y;
        TextInputLayout textInputLayout = tVar.f5395h;
        if (tVar.f5404q == z10) {
            return;
        }
        tVar.c();
        if (z10) {
            w0 w0Var = new w0(tVar.g, null);
            tVar.f5405r = w0Var;
            w0Var.setId(org.chromium.net.R.id.textinput_error);
            tVar.f5405r.setTextAlignment(5);
            Typeface typeface = tVar.B;
            if (typeface != null) {
                tVar.f5405r.setTypeface(typeface);
            }
            int i10 = tVar.f5408u;
            tVar.f5408u = i10;
            w0 w0Var2 = tVar.f5405r;
            if (w0Var2 != null) {
                tVar.f5395h.n(w0Var2, i10);
            }
            ColorStateList colorStateList = tVar.f5409v;
            tVar.f5409v = colorStateList;
            w0 w0Var3 = tVar.f5405r;
            if (w0Var3 != null && colorStateList != null) {
                w0Var3.setTextColor(colorStateList);
            }
            CharSequence charSequence = tVar.f5406s;
            tVar.f5406s = charSequence;
            w0 w0Var4 = tVar.f5405r;
            if (w0Var4 != null) {
                w0Var4.setContentDescription(charSequence);
            }
            int i11 = tVar.f5407t;
            tVar.f5407t = i11;
            w0 w0Var5 = tVar.f5405r;
            if (w0Var5 != null) {
                w0Var5.setAccessibilityLiveRegion(i11);
            }
            tVar.f5405r.setVisibility(4);
            tVar.a(tVar.f5405r, 0);
        } else {
            tVar.f();
            tVar.g(tVar.f5405r, 0);
            tVar.f5405r = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        tVar.f5404q = z10;
    }

    public void setErrorIconDrawable(int i10) {
        p pVar = this.f3860q;
        pVar.i(i10 != 0 ? n4.a.o(pVar.getContext(), i10) : null);
        a.a.s(pVar.f5366o, pVar.f5368q, pVar.f5369r);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        p pVar = this.f3860q;
        CheckableImageButton checkableImageButton = pVar.f5368q;
        View.OnLongClickListener onLongClickListener = pVar.f5371t;
        checkableImageButton.setOnClickListener(onClickListener);
        a.a.t(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        p pVar = this.f3860q;
        pVar.f5371t = onLongClickListener;
        CheckableImageButton checkableImageButton = pVar.f5368q;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        a.a.t(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        p pVar = this.f3860q;
        if (pVar.f5369r != colorStateList) {
            pVar.f5369r = colorStateList;
            a.a.a(pVar.f5366o, pVar.f5368q, colorStateList, pVar.f5370s);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        p pVar = this.f3860q;
        if (pVar.f5370s != mode) {
            pVar.f5370s = mode;
            a.a.a(pVar.f5366o, pVar.f5368q, pVar.f5369r, mode);
        }
    }

    public void setErrorTextAppearance(int i10) {
        t tVar = this.f3876y;
        tVar.f5408u = i10;
        w0 w0Var = tVar.f5405r;
        if (w0Var != null) {
            tVar.f5395h.n(w0Var, i10);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        t tVar = this.f3876y;
        tVar.f5409v = colorStateList;
        w0 w0Var = tVar.f5405r;
        if (w0Var == null || colorStateList == null) {
            return;
        }
        w0Var.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.L0 != z10) {
            this.L0 = z10;
            w(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        t tVar = this.f3876y;
        if (isEmpty) {
            if (tVar.f5411x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!tVar.f5411x) {
            setHelperTextEnabled(true);
        }
        tVar.c();
        tVar.f5410w = charSequence;
        tVar.f5412y.setText(charSequence);
        int i10 = tVar.f5401n;
        if (i10 != 2) {
            tVar.f5402o = 2;
        }
        tVar.i(i10, tVar.f5402o, tVar.h(tVar.f5412y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        t tVar = this.f3876y;
        tVar.A = colorStateList;
        w0 w0Var = tVar.f5412y;
        if (w0Var == null || colorStateList == null) {
            return;
        }
        w0Var.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        t tVar = this.f3876y;
        TextInputLayout textInputLayout = tVar.f5395h;
        if (tVar.f5411x == z10) {
            return;
        }
        tVar.c();
        if (z10) {
            w0 w0Var = new w0(tVar.g, null);
            tVar.f5412y = w0Var;
            w0Var.setId(org.chromium.net.R.id.textinput_helper_text);
            tVar.f5412y.setTextAlignment(5);
            Typeface typeface = tVar.B;
            if (typeface != null) {
                tVar.f5412y.setTypeface(typeface);
            }
            tVar.f5412y.setVisibility(4);
            tVar.f5412y.setAccessibilityLiveRegion(1);
            int i10 = tVar.f5413z;
            tVar.f5413z = i10;
            w0 w0Var2 = tVar.f5412y;
            if (w0Var2 != null) {
                w0Var2.setTextAppearance(i10);
            }
            ColorStateList colorStateList = tVar.A;
            tVar.A = colorStateList;
            w0 w0Var3 = tVar.f5412y;
            if (w0Var3 != null && colorStateList != null) {
                w0Var3.setTextColor(colorStateList);
            }
            tVar.a(tVar.f5412y, 1);
            tVar.f5412y.setAccessibilityDelegate(new s(0, tVar));
        } else {
            tVar.c();
            int i11 = tVar.f5401n;
            if (i11 == 2) {
                tVar.f5402o = 0;
            }
            tVar.i(i11, tVar.f5402o, tVar.h(tVar.f5412y, _UrlKt.FRAGMENT_ENCODE_SET));
            tVar.g(tVar.f5412y, 1);
            tVar.f5412y = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        tVar.f5411x = z10;
    }

    public void setHelperTextTextAppearance(int i10) {
        t tVar = this.f3876y;
        tVar.f5413z = i10;
        w0 w0Var = tVar.f5412y;
        if (w0Var != null) {
            w0Var.setTextAppearance(i10);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.R) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.M0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.R) {
            this.R = z10;
            if (z10) {
                CharSequence hint = this.f3864s.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.S)) {
                        setHint(hint);
                    }
                    this.f3864s.setHint((CharSequence) null);
                }
                this.T = true;
            } else {
                this.T = false;
                if (!TextUtils.isEmpty(this.S) && TextUtils.isEmpty(this.f3864s.getHint())) {
                    this.f3864s.setHint(this.S);
                }
                setHintInternal(null);
            }
            if (this.f3864s != null) {
                v();
            }
        }
    }

    public void setHintMaxLines(int i10) {
        b bVar = this.K0;
        if (i10 != bVar.f13699f0) {
            bVar.f13699f0 = i10;
            bVar.j(false);
        }
        if (i10 != bVar.f13697e0) {
            bVar.f13697e0 = i10;
            bVar.j(false);
        }
        requestLayout();
    }

    public void setHintTextAppearance(int i10) {
        b bVar = this.K0;
        TextInputLayout textInputLayout = bVar.f13688a;
        a9.d dVar = new a9.d(textInputLayout.getContext(), i10);
        ColorStateList colorStateList = dVar.f169k;
        if (colorStateList != null) {
            bVar.f13706k = colorStateList;
        }
        float f10 = dVar.f170l;
        if (f10 != 0.0f) {
            bVar.f13702i = f10;
        }
        ColorStateList colorStateList2 = dVar.f160a;
        if (colorStateList2 != null) {
            bVar.V = colorStateList2;
        }
        bVar.T = dVar.f165f;
        bVar.U = dVar.g;
        bVar.S = dVar.f166h;
        bVar.W = dVar.f168j;
        a9.a aVar = bVar.f13722z;
        if (aVar != null) {
            aVar.f153e = true;
        }
        x5.b0 b0Var = new x5.b0(bVar);
        dVar.a();
        bVar.f13722z = new a9.a(b0Var, dVar.f174p);
        dVar.b(textInputLayout.getContext(), bVar.f13722z);
        bVar.j(false);
        this.f3877y0 = bVar.f13706k;
        if (this.f3864s != null) {
            w(false, false);
            v();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f3877y0 != colorStateList) {
            if (this.f3875x0 == null) {
                b bVar = this.K0;
                if (bVar.f13706k != colorStateList) {
                    bVar.f13706k = colorStateList;
                    bVar.j(false);
                }
            }
            this.f3877y0 = colorStateList;
            if (this.f3864s != null) {
                w(false, false);
            }
        }
    }

    public void setLengthCounter(b0 b0Var) {
        this.C = b0Var;
    }

    public void setMaxEms(int i10) {
        this.f3870v = i10;
        EditText editText = this.f3864s;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxEms(i10);
    }

    public void setMaxWidth(int i10) {
        this.f3874x = i10;
        EditText editText = this.f3864s;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxWidth(i10);
    }

    public void setMaxWidthResource(int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinEms(int i10) {
        this.f3868u = i10;
        EditText editText = this.f3864s;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinEms(i10);
    }

    public void setMinWidth(int i10) {
        this.f3872w = i10;
        EditText editText = this.f3864s;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinWidth(i10);
    }

    public void setMinWidthResource(int i10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i10) {
        p pVar = this.f3860q;
        pVar.f5372u.setContentDescription(i10 != 0 ? pVar.getResources().getText(i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i10) {
        p pVar = this.f3860q;
        pVar.f5372u.setImageDrawable(i10 != 0 ? n4.a.o(pVar.getContext(), i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        p pVar = this.f3860q;
        if (z10 && pVar.f5374w != 1) {
            pVar.g(1);
        } else if (z10) {
            pVar.getClass();
        } else {
            pVar.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        p pVar = this.f3860q;
        pVar.f5376y = colorStateList;
        a.a.a(pVar.f5366o, pVar.f5372u, colorStateList, pVar.f5377z);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        p pVar = this.f3860q;
        pVar.f5377z = mode;
        a.a.a(pVar.f5366o, pVar.f5372u, pVar.f5376y, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.I == null) {
            w0 w0Var = new w0(getContext(), null);
            this.I = w0Var;
            w0Var.setId(org.chromium.net.R.id.textinput_placeholder);
            this.I.setImportantForAccessibility(1);
            this.I.setAccessibilityLiveRegion(1);
            g f10 = f();
            this.L = f10;
            f10.f8236p = 67L;
            this.M = f();
            setPlaceholderTextAppearance(this.K);
            setPlaceholderTextColor(this.J);
            k0.m(this.I, new com.google.android.material.datepicker.g(3));
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.H) {
                setPlaceholderTextEnabled(true);
            }
            this.G = charSequence;
        }
        EditText editText = this.f3864s;
        x(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(int i10) {
        this.K = i10;
        w0 w0Var = this.I;
        if (w0Var != null) {
            w0Var.setTextAppearance(i10);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.J != colorStateList) {
            this.J = colorStateList;
            w0 w0Var = this.I;
            if (w0Var == null || colorStateList == null) {
                return;
            }
            w0Var.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        y yVar = this.f3858p;
        yVar.getClass();
        yVar.f5431q = TextUtils.isEmpty(charSequence) ? null : charSequence;
        yVar.f5430p.setText(charSequence);
        yVar.e();
    }

    public void setPrefixTextAppearance(int i10) {
        this.f3858p.f5430p.setTextAppearance(i10);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f3858p.f5430p.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(n nVar) {
        j jVar = this.U;
        if (jVar == null || jVar.f4277p.f4259a == nVar) {
            return;
        }
        this.f3846d0 = nVar;
        c();
    }

    public void setStartIconCheckable(boolean z10) {
        this.f3858p.f5432r.setCheckable(z10);
    }

    public void setStartIconContentDescription(int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconDrawable(int i10) {
        setStartIconDrawable(i10 != 0 ? n4.a.o(getContext(), i10) : null);
    }

    public void setStartIconMinSize(int i10) {
        y yVar = this.f3858p;
        if (i10 < 0) {
            yVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i10 != yVar.f5435u) {
            yVar.f5435u = i10;
            CheckableImageButton checkableImageButton = yVar.f5432r;
            checkableImageButton.setMinimumWidth(i10);
            checkableImageButton.setMinimumHeight(i10);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        y yVar = this.f3858p;
        CheckableImageButton checkableImageButton = yVar.f5432r;
        View.OnLongClickListener onLongClickListener = yVar.f5437w;
        checkableImageButton.setOnClickListener(onClickListener);
        a.a.t(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        y yVar = this.f3858p;
        yVar.f5437w = onLongClickListener;
        CheckableImageButton checkableImageButton = yVar.f5432r;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        a.a.t(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        y yVar = this.f3858p;
        yVar.f5436v = scaleType;
        yVar.f5432r.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        y yVar = this.f3858p;
        if (yVar.f5433s != colorStateList) {
            yVar.f5433s = colorStateList;
            a.a.a(yVar.f5429o, yVar.f5432r, colorStateList, yVar.f5434t);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        y yVar = this.f3858p;
        if (yVar.f5434t != mode) {
            yVar.f5434t = mode;
            a.a.a(yVar.f5429o, yVar.f5432r, yVar.f5433s, mode);
        }
    }

    public void setStartIconVisible(boolean z10) {
        this.f3858p.c(z10);
    }

    public void setSuffixText(CharSequence charSequence) {
        p pVar = this.f3860q;
        pVar.getClass();
        pVar.D = TextUtils.isEmpty(charSequence) ? null : charSequence;
        pVar.E.setText(charSequence);
        pVar.n();
    }

    public void setSuffixTextAppearance(int i10) {
        this.f3860q.E.setTextAppearance(i10);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f3860q.E.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(g9.a0 a0Var) {
        EditText editText = this.f3864s;
        if (editText != null) {
            k0.m(editText, a0Var);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f3861q0) {
            this.f3861q0 = typeface;
            this.K0.n(typeface);
            t tVar = this.f3876y;
            if (typeface != tVar.B) {
                tVar.B = typeface;
                w0 w0Var = tVar.f5405r;
                if (w0Var != null) {
                    w0Var.setTypeface(typeface);
                }
                w0 w0Var2 = tVar.f5412y;
                if (w0Var2 != null) {
                    w0Var2.setTypeface(typeface);
                }
            }
            w0 w0Var3 = this.D;
            if (w0Var3 != null) {
                w0Var3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        Drawable background;
        w0 w0Var;
        EditText editText = this.f3864s;
        if (editText == null || this.f3849g0 != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = i1.f8438a;
        Drawable mutate = background.mutate();
        if (o()) {
            mutate.setColorFilter(r.c(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.B && (w0Var = this.D) != null) {
            mutate.setColorFilter(r.c(w0Var.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            mutate.clearColorFilter();
            this.f3864s.refreshDrawableState();
        }
    }

    public final void u() {
        EditText editText = this.f3864s;
        if (editText == null || this.U == null) {
            return;
        }
        if ((this.f3843a0 || editText.getBackground() == null) && this.f3849g0 != 0) {
            this.f3864s.setBackground(getEditTextBoxBackground());
            this.f3843a0 = true;
        }
    }

    public final void v() {
        if (this.f3849g0 != 1) {
            FrameLayout frameLayout = this.f3856o;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int e7 = e();
            if (e7 != layoutParams.topMargin) {
                layoutParams.topMargin = e7;
                frameLayout.requestLayout();
            }
        }
    }

    public final void w(boolean z10, boolean z11) {
        ColorStateList colorStateList;
        w0 w0Var;
        boolean isEnabled = isEnabled();
        EditText editText = this.f3864s;
        boolean z12 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f3864s;
        boolean z13 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.f3875x0;
        b bVar = this.K0;
        if (colorStateList2 != null) {
            bVar.k(colorStateList2);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f3875x0;
            bVar.k(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.H0) : this.H0));
        } else if (o()) {
            w0 w0Var2 = this.f3876y.f5405r;
            bVar.k(w0Var2 != null ? w0Var2.getTextColors() : null);
        } else if (this.B && (w0Var = this.D) != null) {
            bVar.k(w0Var.getTextColors());
        } else if (z13 && (colorStateList = this.f3877y0) != null && bVar.f13706k != colorStateList) {
            bVar.f13706k = colorStateList;
            bVar.j(false);
        }
        p pVar = this.f3860q;
        y yVar = this.f3858p;
        if (z12 || !this.L0 || (isEnabled() && z13)) {
            if (z11 || this.J0) {
                ValueAnimator valueAnimator = this.N0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.N0.cancel();
                }
                if (z10 && this.M0) {
                    b(1.0f);
                } else {
                    bVar.m(1.0f);
                }
                this.J0 = false;
                if (g()) {
                    l();
                }
                EditText editText3 = this.f3864s;
                x(editText3 != null ? editText3.getText() : null);
                yVar.f5438x = false;
                yVar.e();
                pVar.F = false;
                pVar.n();
                return;
            }
            return;
        }
        if (z11 || !this.J0) {
            ValueAnimator valueAnimator2 = this.N0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.N0.cancel();
            }
            if (z10 && this.M0) {
                b(0.0f);
            } else {
                bVar.m(0.0f);
            }
            if (g() && !((g9.g) this.U).U.f5343r.isEmpty() && g()) {
                ((g9.g) this.U).t(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.J0 = true;
            w0 w0Var3 = this.I;
            if (w0Var3 != null && this.H) {
                w0Var3.setText((CharSequence) null);
                q.a(this.f3856o, this.M);
                this.I.setVisibility(4);
            }
            yVar.f5438x = true;
            yVar.e();
            pVar.F = true;
            pVar.n();
        }
    }

    public final void x(Editable editable) {
        ((a0) this.C).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.f3856o;
        if (length != 0 || this.J0) {
            w0 w0Var = this.I;
            if (w0Var == null || !this.H) {
                return;
            }
            w0Var.setText((CharSequence) null);
            q.a(frameLayout, this.M);
            this.I.setVisibility(4);
            return;
        }
        if (this.I == null || !this.H || TextUtils.isEmpty(this.G)) {
            return;
        }
        this.I.setText(this.G);
        q.a(frameLayout, this.L);
        this.I.setVisibility(0);
        this.I.bringToFront();
    }

    public final void y(boolean z10, boolean z11) {
        int defaultColor = this.C0.getDefaultColor();
        int colorForState = this.C0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.C0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z10) {
            this.f3853l0 = colorForState2;
        } else if (z11) {
            this.f3853l0 = colorForState;
        } else {
            this.f3853l0 = defaultColor;
        }
    }

    public final void z() {
        w0 w0Var;
        EditText editText;
        EditText editText2;
        if (this.U == null || this.f3849g0 == 0) {
            return;
        }
        boolean z10 = false;
        boolean z11 = isFocused() || ((editText2 = this.f3864s) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f3864s) != null && editText.isHovered())) {
            z10 = true;
        }
        if (!isEnabled()) {
            this.f3853l0 = this.H0;
        } else if (o()) {
            if (this.C0 != null) {
                y(z11, z10);
            } else {
                this.f3853l0 = getErrorCurrentTextColors();
            }
        } else if (!this.B || (w0Var = this.D) == null) {
            if (z11) {
                this.f3853l0 = this.B0;
            } else if (z10) {
                this.f3853l0 = this.A0;
            } else {
                this.f3853l0 = this.f3879z0;
            }
        } else if (this.C0 != null) {
            y(z11, z10);
        } else {
            this.f3853l0 = w0Var.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            r();
        }
        p pVar = this.f3860q;
        TextInputLayout textInputLayout = pVar.f5366o;
        CheckableImageButton checkableImageButton = pVar.f5372u;
        TextInputLayout textInputLayout2 = pVar.f5366o;
        pVar.l();
        a.a.s(textInputLayout2, pVar.f5368q, pVar.f5369r);
        a.a.s(textInputLayout2, checkableImageButton, pVar.f5376y);
        if (pVar.b() instanceof g9.m) {
            if (!textInputLayout.o() || checkableImageButton.getDrawable() == null) {
                a.a.a(textInputLayout, checkableImageButton, pVar.f5376y, pVar.f5377z);
            } else {
                Drawable mutate = checkableImageButton.getDrawable().mutate();
                mutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton.setImageDrawable(mutate);
            }
        }
        y yVar = this.f3858p;
        a.a.s(yVar.f5429o, yVar.f5432r, yVar.f5433s);
        if (this.f3849g0 == 2) {
            int i10 = this.f3850i0;
            if (z11 && isEnabled()) {
                this.f3850i0 = this.f3852k0;
            } else {
                this.f3850i0 = this.f3851j0;
            }
            if (this.f3850i0 != i10 && g() && !this.J0) {
                if (g()) {
                    ((g9.g) this.U).t(0.0f, 0.0f, 0.0f, 0.0f);
                }
                l();
            }
        }
        if (this.f3849g0 == 1) {
            if (!isEnabled()) {
                this.f3854m0 = this.E0;
            } else if (z10 && !z11) {
                this.f3854m0 = this.G0;
            } else if (z11) {
                this.f3854m0 = this.F0;
            } else {
                this.f3854m0 = this.D0;
            }
        }
        c();
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f3858p.f5432r;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f3858p.b(drawable);
    }

    public void setHint(int i10) {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f3860q.f5372u.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f3860q.f5372u.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f3860q.i(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f3860q.f5372u;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        p pVar = this.f3860q;
        TextInputLayout textInputLayout = pVar.f5366o;
        CheckableImageButton checkableImageButton = pVar.f5372u;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            a.a.a(textInputLayout, checkableImageButton, pVar.f5376y, pVar.f5377z);
            a.a.s(textInputLayout, checkableImageButton, pVar.f5376y);
        }
    }
}
