package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class p extends CheckBox implements p0.k, p0.l {

    /* renamed from: o, reason: collision with root package name */
    public final f4.d f8513o;

    /* renamed from: p, reason: collision with root package name */
    public final b4.b f8514p;

    /* renamed from: q, reason: collision with root package name */
    public final s0 f8515q;

    /* renamed from: r, reason: collision with root package name */
    public t f8516r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        o2.a(context);
        n2.a(this, getContext());
        f4.d dVar = new f4.d(this);
        this.f8513o = dVar;
        dVar.d(attributeSet, i10);
        b4.b bVar = new b4.b(this);
        this.f8514p = bVar;
        bVar.m(attributeSet, i10);
        s0 s0Var = new s0(this);
        this.f8515q = s0Var;
        s0Var.f(attributeSet, i10);
        getEmojiTextViewHelper().b(attributeSet, i10);
    }

    private t getEmojiTextViewHelper() {
        if (this.f8516r == null) {
            this.f8516r = new t(this);
        }
        return this.f8516r;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        b4.b bVar = this.f8514p;
        if (bVar != null) {
            bVar.b();
        }
        s0 s0Var = this.f8515q;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        b4.b bVar = this.f8514p;
        if (bVar != null) {
            return bVar.j();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b4.b bVar = this.f8514p;
        if (bVar != null) {
            return bVar.k();
        }
        return null;
    }

    @Override // p0.k
    public ColorStateList getSupportButtonTintList() {
        f4.d dVar = this.f8513o;
        if (dVar != null) {
            return (ColorStateList) dVar.f5021e;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        f4.d dVar = this.f8513o;
        if (dVar != null) {
            return (PorterDuff.Mode) dVar.f5022f;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8515q.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8515q.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b4.b bVar = this.f8514p;
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b4.b bVar = this.f8514p;
        if (bVar != null) {
            bVar.p(i10);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        f4.d dVar = this.f8513o;
        if (dVar != null) {
            if (dVar.f5019c) {
                dVar.f5019c = false;
            } else {
                dVar.f5019c = true;
                dVar.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f8515q;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        s0 s0Var = this.f8515q;
        if (s0Var != null) {
            s0Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b4.b bVar = this.f8514p;
        if (bVar != null) {
            bVar.w(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b4.b bVar = this.f8514p;
        if (bVar != null) {
            bVar.x(mode);
        }
    }

    @Override // p0.k
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        f4.d dVar = this.f8513o;
        if (dVar != null) {
            dVar.f5021e = colorStateList;
            dVar.f5017a = true;
            dVar.a();
        }
    }

    @Override // p0.k
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        f4.d dVar = this.f8513o;
        if (dVar != null) {
            dVar.f5022f = mode;
            dVar.f5018b = true;
            dVar.a();
        }
    }

    @Override // p0.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        s0 s0Var = this.f8515q;
        s0Var.l(colorStateList);
        s0Var.b();
    }

    @Override // p0.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        s0 s0Var = this.f8515q;
        s0Var.m(mode);
        s0Var.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(n4.a.o(getContext(), i10));
    }
}
