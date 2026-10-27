package m;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w extends MultiAutoCompleteTextView implements p0.l {

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f8582r = {R.attr.popupBackground};

    /* renamed from: o, reason: collision with root package name */
    public final b4.b f8583o;

    /* renamed from: p, reason: collision with root package name */
    public final s0 f8584p;

    /* renamed from: q, reason: collision with root package name */
    public final y f8585q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, org.chromium.net.R.attr.autoCompleteTextViewStyle);
        o2.a(context);
        n2.a(this, getContext());
        android.support.v4.media.session.a0 T = android.support.v4.media.session.a0.T(getContext(), attributeSet, f8582r, org.chromium.net.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) T.f231q).hasValue(0)) {
            setDropDownBackgroundDrawable(T.K(0));
        }
        T.U();
        b4.b bVar = new b4.b(this);
        this.f8583o = bVar;
        bVar.m(attributeSet, org.chromium.net.R.attr.autoCompleteTextViewStyle);
        s0 s0Var = new s0(this);
        this.f8584p = s0Var;
        s0Var.f(attributeSet, org.chromium.net.R.attr.autoCompleteTextViewStyle);
        s0Var.b();
        y yVar = new y(this);
        this.f8585q = yVar;
        yVar.b(attributeSet, org.chromium.net.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean isFocusable = isFocusable();
        boolean isClickable = isClickable();
        boolean isLongClickable = isLongClickable();
        int inputType = getInputType();
        KeyListener a10 = yVar.a(keyListener);
        if (a10 == keyListener) {
            return;
        }
        super.setKeyListener(a10);
        setRawInputType(inputType);
        setFocusable(isFocusable);
        setClickable(isClickable);
        setLongClickable(isLongClickable);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b4.b bVar = this.f8583o;
        if (bVar != null) {
            bVar.b();
        }
        s0 s0Var = this.f8584p;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        b4.b bVar = this.f8583o;
        if (bVar != null) {
            return bVar.j();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b4.b bVar = this.f8583o;
        if (bVar != null) {
            return bVar.k();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8584p.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8584p.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        j1.c.l(editorInfo, onCreateInputConnection, this);
        return this.f8585q.c(onCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b4.b bVar = this.f8583o;
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b4.b bVar = this.f8583o;
        if (bVar != null) {
            bVar.p(i10);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f8584p;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f8584p;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i10) {
        setDropDownBackgroundDrawable(n4.a.o(getContext(), i10));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f8585q.d(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f8585q.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b4.b bVar = this.f8583o;
        if (bVar != null) {
            bVar.w(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b4.b bVar = this.f8583o;
        if (bVar != null) {
            bVar.x(mode);
        }
    }

    @Override // p0.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        s0 s0Var = this.f8584p;
        s0Var.l(colorStateList);
        s0Var.b();
    }

    @Override // p0.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        s0 s0Var = this.f8584p;
        s0Var.m(mode);
        s0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        s0 s0Var = this.f8584p;
        if (s0Var != null) {
            s0Var.g(context, i10);
        }
    }
}
