package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import b4.b;
import com.bumptech.glide.d;
import m.b1;
import m.h3;
import m.n2;
import m.o2;
import m.s0;
import m.t;
import org.chromium.net.R;
import p0.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class AppCompatButton extends Button implements l {

    /* renamed from: o, reason: collision with root package name */
    public final b f423o;

    /* renamed from: p, reason: collision with root package name */
    public final s0 f424p;

    /* renamed from: q, reason: collision with root package name */
    public t f425q;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    private t getEmojiTextViewHelper() {
        if (this.f425q == null) {
            this.f425q = new t(this);
        }
        return this.f425q;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b bVar = this.f423o;
        if (bVar != null) {
            bVar.b();
        }
        s0 s0Var = this.f424p;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (h3.f8435c) {
            return super.getAutoSizeMaxTextSize();
        }
        s0 s0Var = this.f424p;
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
        s0 s0Var = this.f424p;
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
        s0 s0Var = this.f424p;
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
        s0 s0Var = this.f424p;
        return s0Var != null ? s0Var.f8549i.f8367f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (h3.f8435c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        s0 s0Var = this.f424p;
        if (s0Var != null) {
            return s0Var.f8549i.f8362a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return d.K(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        b bVar = this.f423o;
        if (bVar != null) {
            return bVar.j();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b bVar = this.f423o;
        if (bVar != null) {
            return bVar.k();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f424p.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f424p.e();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        s0 s0Var = this.f424p;
        if (s0Var == null || h3.f8435c) {
            return;
        }
        s0Var.f8549i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        s0 s0Var = this.f424p;
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
        s0 s0Var = this.f424p;
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
        s0 s0Var = this.f424p;
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
        s0 s0Var = this.f424p;
        if (s0Var != null) {
            s0Var.k(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b bVar = this.f423o;
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b bVar = this.f423o;
        if (bVar != null) {
            bVar.p(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d.M(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z10) {
        s0 s0Var = this.f424p;
        if (s0Var != null) {
            s0Var.f8542a.setAllCaps(z10);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b bVar = this.f423o;
        if (bVar != null) {
            bVar.w(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b bVar = this.f423o;
        if (bVar != null) {
            bVar.x(mode);
        }
    }

    @Override // p0.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        s0 s0Var = this.f424p;
        s0Var.l(colorStateList);
        s0Var.b();
    }

    @Override // p0.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        s0 s0Var = this.f424p;
        s0Var.m(mode);
        s0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        s0 s0Var = this.f424p;
        if (s0Var != null) {
            s0Var.g(context, i10);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i10, float f10) {
        boolean z10 = h3.f8435c;
        if (z10) {
            super.setTextSize(i10, f10);
            return;
        }
        s0 s0Var = this.f424p;
        if (s0Var != null) {
            b1 b1Var = s0Var.f8549i;
            if (z10 || b1Var.f()) {
                return;
            }
            b1Var.g(i10, f10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        o2.a(context);
        n2.a(this, getContext());
        b bVar = new b(this);
        this.f423o = bVar;
        bVar.m(attributeSet, i10);
        s0 s0Var = new s0(this);
        this.f424p = s0Var;
        s0Var.f(attributeSet, i10);
        s0Var.b();
        getEmojiTextViewHelper().b(attributeSet, i10);
    }
}
