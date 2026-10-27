package p8;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.fragment.app.v0;
import com.google.android.material.button.MaterialButton;
import d9.b0;
import d9.h;
import d9.j;
import d9.n;
import d9.y;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f10119a;

    /* renamed from: b, reason: collision with root package name */
    public n f10120b;

    /* renamed from: c, reason: collision with root package name */
    public b0 f10121c;

    /* renamed from: d, reason: collision with root package name */
    public t0.f f10122d;

    /* renamed from: e, reason: collision with root package name */
    public v0 f10123e;

    /* renamed from: f, reason: collision with root package name */
    public int f10124f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public int f10125h;

    /* renamed from: i, reason: collision with root package name */
    public int f10126i;

    /* renamed from: j, reason: collision with root package name */
    public int f10127j;

    /* renamed from: k, reason: collision with root package name */
    public int f10128k;

    /* renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f10129l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f10130m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f10131n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f10132o;

    /* renamed from: p, reason: collision with root package name */
    public j f10133p;

    /* renamed from: t, reason: collision with root package name */
    public boolean f10137t;

    /* renamed from: v, reason: collision with root package name */
    public RippleDrawable f10139v;

    /* renamed from: w, reason: collision with root package name */
    public int f10140w;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10134q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10135r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f10136s = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10138u = true;

    public f(MaterialButton materialButton, n nVar) {
        this.f10119a = materialButton;
        this.f10120b = nVar;
    }

    public final j a(boolean z10) {
        RippleDrawable rippleDrawable = this.f10139v;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (j) ((LayerDrawable) ((InsetDrawable) this.f10139v.getDrawable(0)).getDrawable()).getDrawable(!z10 ? 1 : 0);
    }

    public final void b(int i10, int i11) {
        MaterialButton materialButton = this.f10119a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i12 = this.f10125h;
        int i13 = this.f10126i;
        this.f10126i = i11;
        this.f10125h = i10;
        if (!this.f10135r) {
            c();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i10) - i12, paddingEnd, (paddingBottom + i11) - i13);
    }

    public final void c() {
        j jVar = new j(this.f10120b);
        b0 b0Var = this.f10121c;
        if (b0Var != null) {
            jVar.o(b0Var);
        }
        t0.f fVar = this.f10122d;
        if (fVar != null) {
            jVar.l(fVar);
        }
        v0 v0Var = this.f10123e;
        if (v0Var != null) {
            jVar.R = v0Var;
        }
        MaterialButton materialButton = this.f10119a;
        jVar.k(materialButton.getContext());
        jVar.setTintList(this.f10130m);
        PorterDuff.Mode mode = this.f10129l;
        if (mode != null) {
            jVar.setTintMode(mode);
        }
        float f10 = this.f10128k;
        ColorStateList colorStateList = this.f10131n;
        jVar.f4277p.f4268k = f10;
        jVar.invalidateSelf();
        h hVar = jVar.f4277p;
        if (hVar.f4263e != colorStateList) {
            hVar.f4263e = colorStateList;
            jVar.onStateChange(jVar.getState());
        }
        j jVar2 = new j(this.f10120b);
        b0 b0Var2 = this.f10121c;
        if (b0Var2 != null) {
            jVar2.o(b0Var2);
        }
        t0.f fVar2 = this.f10122d;
        if (fVar2 != null) {
            jVar2.l(fVar2);
        }
        jVar2.setTint(0);
        float f11 = this.f10128k;
        int l10 = this.f10134q ? com.bumptech.glide.e.l(materialButton, R.attr.colorSurface) : 0;
        jVar2.f4277p.f4268k = f11;
        jVar2.invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(l10);
        h hVar2 = jVar2.f4277p;
        if (hVar2.f4263e != valueOf) {
            hVar2.f4263e = valueOf;
            jVar2.onStateChange(jVar2.getState());
        }
        j jVar3 = new j(this.f10120b);
        this.f10133p = jVar3;
        b0 b0Var3 = this.f10121c;
        if (b0Var3 != null) {
            jVar3.o(b0Var3);
        }
        t0.f fVar3 = this.f10122d;
        if (fVar3 != null) {
            this.f10133p.l(fVar3);
        }
        this.f10133p.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(b9.a.a(this.f10132o), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{jVar2, jVar}), this.f10124f, this.f10125h, this.g, this.f10126i), this.f10133p);
        this.f10139v = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        j a10 = a(false);
        if (a10 != null) {
            a10.m(this.f10140w);
            a10.setState(materialButton.getDrawableState());
        }
    }

    public final void d() {
        j a10 = a(false);
        if (a10 != null) {
            b0 b0Var = this.f10121c;
            if (b0Var != null) {
                a10.o(b0Var);
            } else {
                a10.setShapeAppearanceModel(this.f10120b);
            }
            t0.f fVar = this.f10122d;
            if (fVar != null) {
                a10.l(fVar);
            }
        }
        j a11 = a(true);
        if (a11 != null) {
            b0 b0Var2 = this.f10121c;
            if (b0Var2 != null) {
                a11.o(b0Var2);
            } else {
                a11.setShapeAppearanceModel(this.f10120b);
            }
            t0.f fVar2 = this.f10122d;
            if (fVar2 != null) {
                a11.l(fVar2);
            }
        }
        RippleDrawable rippleDrawable = this.f10139v;
        y yVar = (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) ? null : this.f10139v.getNumberOfLayers() > 2 ? (y) this.f10139v.getDrawable(2) : (y) this.f10139v.getDrawable(1);
        if (yVar != null) {
            yVar.setShapeAppearanceModel(this.f10120b);
            if (yVar instanceof j) {
                j jVar = (j) yVar;
                b0 b0Var3 = this.f10121c;
                if (b0Var3 != null) {
                    jVar.o(b0Var3);
                }
                t0.f fVar3 = this.f10122d;
                if (fVar3 != null) {
                    jVar.l(fVar3);
                }
            }
        }
    }

    public final void e() {
        j a10 = a(false);
        j a11 = a(true);
        if (a10 != null) {
            float f10 = this.f10128k;
            ColorStateList colorStateList = this.f10131n;
            a10.f4277p.f4268k = f10;
            a10.invalidateSelf();
            h hVar = a10.f4277p;
            if (hVar.f4263e != colorStateList) {
                hVar.f4263e = colorStateList;
                a10.onStateChange(a10.getState());
            }
            if (a11 != null) {
                float f11 = this.f10128k;
                int l10 = this.f10134q ? com.bumptech.glide.e.l(this.f10119a, R.attr.colorSurface) : 0;
                a11.f4277p.f4268k = f11;
                a11.invalidateSelf();
                ColorStateList valueOf = ColorStateList.valueOf(l10);
                h hVar2 = a11.f4277p;
                if (hVar2.f4263e != valueOf) {
                    hVar2.f4263e = valueOf;
                    a11.onStateChange(a11.getState());
                }
            }
        }
    }
}
