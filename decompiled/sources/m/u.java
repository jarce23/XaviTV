package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class u extends ImageButton {

    /* renamed from: o, reason: collision with root package name */
    public final b4.b f8569o;

    /* renamed from: p, reason: collision with root package name */
    public final c2.j1 f8570p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8571q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        o2.a(context);
        this.f8571q = false;
        n2.a(this, getContext());
        b4.b bVar = new b4.b(this);
        this.f8569o = bVar;
        bVar.m(attributeSet, i10);
        c2.j1 j1Var = new c2.j1(this);
        this.f8570p = j1Var;
        j1Var.k(attributeSet, i10);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b4.b bVar = this.f8569o;
        if (bVar != null) {
            bVar.b();
        }
        c2.j1 j1Var = this.f8570p;
        if (j1Var != null) {
            j1Var.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        b4.b bVar = this.f8569o;
        if (bVar != null) {
            return bVar.j();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b4.b bVar = this.f8569o;
        if (bVar != null) {
            return bVar.k();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        p2 p2Var;
        c2.j1 j1Var = this.f8570p;
        if (j1Var == null || (p2Var = (p2) j1Var.f2627r) == null) {
            return null;
        }
        return p2Var.f8517a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        p2 p2Var;
        c2.j1 j1Var = this.f8570p;
        if (j1Var == null || (p2Var = (p2) j1Var.f2627r) == null) {
            return null;
        }
        return p2Var.f8518b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.f8570p.f2626q).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b4.b bVar = this.f8569o;
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b4.b bVar = this.f8569o;
        if (bVar != null) {
            bVar.p(i10);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        c2.j1 j1Var = this.f8570p;
        if (j1Var != null) {
            j1Var.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        c2.j1 j1Var = this.f8570p;
        if (j1Var != null && drawable != null && !this.f8571q) {
            j1Var.f2625p = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (j1Var != null) {
            j1Var.a();
            if (this.f8571q) {
                return;
            }
            ImageView imageView = (ImageView) j1Var.f2626q;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(j1Var.f2625p);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.f8571q = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        c2.j1 j1Var = this.f8570p;
        ImageView imageView = (ImageView) j1Var.f2626q;
        if (i10 != 0) {
            Drawable o2 = n4.a.o(imageView.getContext(), i10);
            if (o2 != null) {
                i1.a(o2);
            }
            imageView.setImageDrawable(o2);
        } else {
            imageView.setImageDrawable(null);
        }
        j1Var.a();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        c2.j1 j1Var = this.f8570p;
        if (j1Var != null) {
            j1Var.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b4.b bVar = this.f8569o;
        if (bVar != null) {
            bVar.w(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b4.b bVar = this.f8569o;
        if (bVar != null) {
            bVar.x(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        c2.j1 j1Var = this.f8570p;
        if (j1Var != null) {
            if (((p2) j1Var.f2627r) == null) {
                j1Var.f2627r = new p2();
            }
            p2 p2Var = (p2) j1Var.f2627r;
            p2Var.f8517a = colorStateList;
            p2Var.f8520d = true;
            j1Var.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        c2.j1 j1Var = this.f8570p;
        if (j1Var != null) {
            if (((p2) j1Var.f2627r) == null) {
                j1Var.f2627r = new p2();
            }
            p2 p2Var = (p2) j1Var.f2627r;
            p2Var.f8518b = mode;
            p2Var.f8519c = true;
            j1Var.a();
        }
    }
}
