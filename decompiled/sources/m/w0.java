package m;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class w0 extends TextView implements p0.l {

    /* renamed from: o, reason: collision with root package name */
    public final b4.b f8586o;

    /* renamed from: p, reason: collision with root package name */
    public final s0 f8587p;

    /* renamed from: q, reason: collision with root package name */
    public final y f8588q;

    /* renamed from: r, reason: collision with root package name */
    public t f8589r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8590s;

    /* renamed from: t, reason: collision with root package name */
    public h5.i f8591t;

    /* renamed from: u, reason: collision with root package name */
    public Future f8592u;

    public w0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private t getEmojiTextViewHelper() {
        if (this.f8589r == null) {
            this.f8589r = new t(this);
        }
        return this.f8589r;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b4.b bVar = this.f8586o;
        if (bVar != null) {
            bVar.b();
        }
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (h3.f8435c) {
            return super.getAutoSizeMaxTextSize();
        }
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            return Math.round(s0Var.f8549i.f8366e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (h3.f8435c) {
            return super.getAutoSizeMinTextSize();
        }
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            return Math.round(s0Var.f8549i.f8365d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (h3.f8435c) {
            return super.getAutoSizeStepGranularity();
        }
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            return Math.round(s0Var.f8549i.f8364c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (h3.f8435c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        s0 s0Var = this.f8587p;
        return s0Var != null ? s0Var.f8549i.f8367f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (h3.f8435c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            return s0Var.f8549i.f8362a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return com.bumptech.glide.d.K(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public t0 getSuperCaller() {
        if (this.f8591t == null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 34) {
                this.f8591t = new v0(this);
            } else if (i10 >= 28) {
                this.f8591t = new u0(this);
            } else if (i10 >= 26) {
                this.f8591t = new h5.i(17, this);
            }
        }
        return this.f8591t;
    }

    public ColorStateList getSupportBackgroundTintList() {
        b4.b bVar = this.f8586o;
        if (bVar != null) {
            return bVar.j();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b4.b bVar = this.f8586o;
        if (bVar != null) {
            return bVar.k();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8587p.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8587p.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future future = this.f8592u;
        if (future != null) {
            try {
                this.f8592u = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                com.bumptech.glide.d.v(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        y yVar;
        if (Build.VERSION.SDK_INT >= 28 || (yVar = this.f8588q) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) yVar.f8601c;
        return textClassifier == null ? m0.a((TextView) yVar.f8600b) : textClassifier;
    }

    public k0.d getTextMetricsParamsCompat() {
        return com.bumptech.glide.d.v(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f8587p.getClass();
        s0.h(editorInfo, onCreateInputConnection, this);
        j1.c.l(editorInfo, onCreateInputConnection, this);
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 30 || i10 >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        s0 s0Var = this.f8587p;
        if (s0Var == null || h3.f8435c) {
            return;
        }
        s0Var.f8549i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        Future future = this.f8592u;
        if (future != null) {
            try {
                this.f8592u = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                com.bumptech.glide.d.v(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            b1 b1Var = s0Var.f8549i;
            if (h3.f8435c || !b1Var.f()) {
                return;
            }
            b1Var.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) {
        if (h3.f8435c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            s0Var.i(i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) {
        if (h3.f8435c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            s0Var.j(iArr, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (h3.f8435c) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            s0Var.k(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b4.b bVar = this.f8586o;
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b4.b bVar = this.f8586o;
        if (bVar != null) {
            bVar.p(i10);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(com.bumptech.glide.d.M(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().t(i10);
        } else {
            com.bumptech.glide.d.C(this, i10);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().j(i10);
        } else {
            com.bumptech.glide.d.D(this, i10);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i10) {
        com.bumptech.glide.d.E(this, i10);
    }

    public void setPrecomputedText(k0.e eVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        com.bumptech.glide.d.v(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b4.b bVar = this.f8586o;
        if (bVar != null) {
            bVar.w(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b4.b bVar = this.f8586o;
        if (bVar != null) {
            bVar.x(mode);
        }
    }

    @Override // p0.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        s0 s0Var = this.f8587p;
        s0Var.l(colorStateList);
        s0Var.b();
    }

    @Override // p0.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        s0 s0Var = this.f8587p;
        s0Var.m(mode);
        s0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            s0Var.g(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        y yVar;
        if (Build.VERSION.SDK_INT >= 28 || (yVar = this.f8588q) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            yVar.f8601c = textClassifier;
        }
    }

    public void setTextFuture(Future<k0.e> future) {
        this.f8592u = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(k0.d dVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = dVar.f7590b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i10 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i10 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i10 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i10 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i10 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i10 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i10 = 7;
            }
        }
        setTextDirection(i10);
        getPaint().set(dVar.f7589a);
        setBreakStrategy(dVar.f7591c);
        setHyphenationFrequency(dVar.f7592d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i10, float f10) {
        boolean z10 = h3.f8435c;
        if (z10) {
            super.setTextSize(i10, f10);
            return;
        }
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            b1 b1Var = s0Var.f8549i;
            if (z10 || b1Var.f()) {
                return;
            }
            b1Var.g(i10, f10);
        }
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i10) {
        Typeface typeface2;
        if (this.f8590s) {
            return;
        }
        if (typeface == null || i10 <= 0) {
            typeface2 = null;
        } else {
            Context context = getContext();
            w7.b bVar = e0.f.f4392a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typeface2 = Typeface.create(typeface, i10);
        }
        this.f8590s = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i10);
        } finally {
            this.f8590s = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        o2.a(context);
        this.f8590s = false;
        this.f8591t = null;
        n2.a(this, getContext());
        b4.b bVar = new b4.b(this);
        this.f8586o = bVar;
        bVar.m(attributeSet, i10);
        s0 s0Var = new s0(this);
        this.f8587p = s0Var;
        s0Var.f(attributeSet, i10);
        s0Var.b();
        y yVar = new y();
        yVar.f8600b = this;
        this.f8588q = yVar;
        getEmojiTextViewHelper().b(attributeSet, i10);
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i10, float f10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            getSuperCaller().v(i10, f10);
        } else if (i11 >= 34) {
            m0.t.h(this, i10, f10);
        } else {
            com.bumptech.glide.d.E(this, Math.round(TypedValue.applyDimension(i10, f10, getResources().getDisplayMetrics())));
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i10 != 0 ? n4.a.o(context, i10) : null, i11 != 0 ? n4.a.o(context, i11) : null, i12 != 0 ? n4.a.o(context, i12) : null, i13 != 0 ? n4.a.o(context, i13) : null);
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i10 != 0 ? n4.a.o(context, i10) : null, i11 != 0 ? n4.a.o(context, i11) : null, i12 != 0 ? n4.a.o(context, i12) : null, i13 != 0 ? n4.a.o(context, i13) : null);
        s0 s0Var = this.f8587p;
        if (s0Var != null) {
            s0Var.b();
        }
    }
}
