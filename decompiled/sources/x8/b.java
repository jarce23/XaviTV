package x8;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {
    public CharSequence B;
    public CharSequence C;
    public boolean D;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public int K;
    public int L;
    public int[] M;
    public boolean N;
    public final TextPaint O;
    public final TextPaint P;
    public TimeInterpolator Q;
    public TimeInterpolator R;
    public float S;
    public float T;
    public float U;
    public ColorStateList V;
    public float W;
    public float X;
    public float Y;
    public StaticLayout Z;

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f13688a;

    /* renamed from: a0, reason: collision with root package name */
    public float f13689a0;

    /* renamed from: b, reason: collision with root package name */
    public float f13690b;

    /* renamed from: b0, reason: collision with root package name */
    public float f13691b0;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f13692c;

    /* renamed from: c0, reason: collision with root package name */
    public float f13693c0;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f13694d;

    /* renamed from: d0, reason: collision with root package name */
    public CharSequence f13695d0;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f13696e;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f13704j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f13706k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f13707k0;

    /* renamed from: l, reason: collision with root package name */
    public int f13708l;

    /* renamed from: m, reason: collision with root package name */
    public float f13709m;

    /* renamed from: n, reason: collision with root package name */
    public float f13710n;

    /* renamed from: o, reason: collision with root package name */
    public float f13711o;

    /* renamed from: p, reason: collision with root package name */
    public float f13712p;

    /* renamed from: q, reason: collision with root package name */
    public float f13713q;

    /* renamed from: r, reason: collision with root package name */
    public float f13714r;

    /* renamed from: s, reason: collision with root package name */
    public Typeface f13715s;

    /* renamed from: t, reason: collision with root package name */
    public Typeface f13716t;

    /* renamed from: u, reason: collision with root package name */
    public Typeface f13717u;

    /* renamed from: v, reason: collision with root package name */
    public Typeface f13718v;

    /* renamed from: w, reason: collision with root package name */
    public Typeface f13719w;

    /* renamed from: x, reason: collision with root package name */
    public Typeface f13720x;

    /* renamed from: y, reason: collision with root package name */
    public Typeface f13721y;

    /* renamed from: z, reason: collision with root package name */
    public a9.a f13722z;

    /* renamed from: f, reason: collision with root package name */
    public int f13698f = 16;
    public int g = 16;

    /* renamed from: h, reason: collision with root package name */
    public float f13701h = 15.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f13702i = 15.0f;
    public final TextUtils.TruncateAt A = TextUtils.TruncateAt.END;
    public final boolean E = true;

    /* renamed from: e0, reason: collision with root package name */
    public int f13697e0 = 1;

    /* renamed from: f0, reason: collision with root package name */
    public int f13699f0 = 1;

    /* renamed from: g0, reason: collision with root package name */
    public final float f13700g0 = 1.0f;
    public final int h0 = 1;

    /* renamed from: i0, reason: collision with root package name */
    public int f13703i0 = -1;

    /* renamed from: j0, reason: collision with root package name */
    public int f13705j0 = -1;

    public b(TextInputLayout textInputLayout) {
        this.f13688a = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.O = textPaint;
        this.P = new TextPaint(textPaint);
        this.f13694d = new Rect();
        this.f13692c = new Rect();
        this.f13696e = new RectF();
        i(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int a(float f10, int i10, int i11) {
        float f11 = 1.0f - f10;
        return Color.argb(Math.round((Color.alpha(i11) * f10) + (Color.alpha(i10) * f11)), Math.round((Color.red(i11) * f10) + (Color.red(i10) * f11)), Math.round((Color.green(i11) * f10) + (Color.green(i10) * f11)), Math.round((Color.blue(i11) * f10) + (Color.blue(i10) * f11)));
    }

    public static float h(float f10, float f11, float f12, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return k8.a.a(f10, f11, f12);
    }

    public final void b() {
        float f10 = this.f13690b;
        float f11 = this.f13692c.left;
        Rect rect = this.f13694d;
        float h10 = h(f11, rect.left, f10, this.Q);
        RectF rectF = this.f13696e;
        rectF.left = h10;
        rectF.top = h(this.f13709m, this.f13710n, f10, this.Q);
        rectF.right = h(r1.right, rect.right, f10, this.Q);
        rectF.bottom = h(r1.bottom, rect.bottom, f10, this.Q);
        this.f13713q = h(this.f13711o, this.f13712p, f10, this.Q);
        this.f13714r = h(this.f13709m, this.f13710n, f10, this.Q);
        d(f10, false);
        TextInputLayout textInputLayout = this.f13688a;
        textInputLayout.postInvalidateOnAnimation();
        z0.a aVar = k8.a.f7831b;
        this.f13691b0 = 1.0f - h(0.0f, 1.0f, 1.0f - f10, aVar);
        textInputLayout.postInvalidateOnAnimation();
        this.f13693c0 = h(1.0f, 0.0f, f10, aVar);
        textInputLayout.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.f13706k;
        ColorStateList colorStateList2 = this.f13704j;
        TextPaint textPaint = this.O;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(f10, g(colorStateList2), g(this.f13706k)));
        } else {
            textPaint.setColor(g(colorStateList));
        }
        float f12 = this.W;
        float f13 = this.X;
        if (f12 != f13) {
            textPaint.setLetterSpacing(h(f13, f12, f10, aVar));
        } else {
            textPaint.setLetterSpacing(f12);
        }
        this.H = k8.a.a(0.0f, this.S, f10);
        this.I = k8.a.a(0.0f, this.T, f10);
        this.J = k8.a.a(0.0f, this.U, f10);
        int a10 = a(f10, 0, g(this.V));
        this.K = a10;
        textPaint.setShadowLayer(this.H, this.I, this.J, a10);
        textInputLayout.postInvalidateOnAnimation();
    }

    public final boolean c(CharSequence charSequence) {
        boolean z10 = this.f13688a.getLayoutDirection() == 1;
        if (this.E) {
            return (z10 ? k0.g.f7597d : k0.g.f7596c).f(charSequence, charSequence.length());
        }
        return z10;
    }

    public final void d(float f10, boolean z10) {
        float f11;
        Typeface typeface;
        float f12;
        if (this.B == null) {
            return;
        }
        float width = this.f13694d.width();
        float width2 = this.f13692c.width();
        if (Math.abs(f10 - 1.0f) < 1.0E-5f) {
            f11 = o() ? this.f13702i : this.f13701h;
            f12 = o() ? this.W : this.X;
            this.F = o() ? 1.0f : h(this.f13701h, this.f13702i, f10, this.R) / this.f13701h;
            if (!o()) {
                width = width2;
            }
            typeface = this.f13715s;
            width2 = width;
        } else {
            f11 = this.f13701h;
            float f13 = this.X;
            typeface = this.f13718v;
            if (Math.abs(f10 - 0.0f) < 1.0E-5f) {
                this.F = 1.0f;
            } else {
                this.F = h(this.f13701h, this.f13702i, f10, this.R) / this.f13701h;
            }
            float f14 = this.f13702i / this.f13701h;
            float f15 = width2 * f14;
            if (!z10 && f15 > width && o()) {
                width2 = Math.min(width / f14, width2);
            }
            f12 = f13;
        }
        int i10 = f10 < 0.5f ? this.f13697e0 : this.f13699f0;
        TextPaint textPaint = this.O;
        if (width2 > 0.0f) {
            boolean z11 = this.G != f11;
            boolean z12 = this.Y != f12;
            boolean z13 = this.f13721y != typeface;
            StaticLayout staticLayout = this.Z;
            boolean z14 = z11 || z12 || (staticLayout != null && (width2 > ((float) staticLayout.getWidth()) ? 1 : (width2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z13 || (this.L != i10) || this.N;
            this.G = f11;
            this.Y = f12;
            this.f13721y = typeface;
            this.N = false;
            this.L = i10;
            textPaint.setLinearText(this.F != 1.0f);
            r7 = z14;
        }
        if (this.C == null || r7) {
            textPaint.setTextSize(this.G);
            textPaint.setTypeface(this.f13721y);
            textPaint.setLetterSpacing(this.Y);
            boolean c10 = c(this.B);
            this.D = c10;
            StaticLayout e7 = e(((this.f13697e0 > 1 || this.f13699f0 > 1) && !c10) ? i10 : 1, textPaint, this.B, width2 * (o() ? 1.0f : this.F), this.D);
            this.Z = e7;
            this.C = e7.getText();
        }
    }

    public final StaticLayout e(int i10, TextPaint textPaint, CharSequence charSequence, float f10, boolean z10) {
        Layout.Alignment alignment;
        if (i10 == 1) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(this.f13698f, this.D ? 1 : 0) & 7;
            alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.D ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.D ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
        }
        g gVar = new g(charSequence, textPaint, (int) f10);
        gVar.f13735l = this.A;
        gVar.f13734k = z10;
        gVar.f13729e = alignment;
        gVar.f13733j = false;
        gVar.f13730f = i10;
        float f11 = this.f13700g0;
        gVar.g = 0.0f;
        gVar.f13731h = f11;
        gVar.f13732i = this.h0;
        gVar.f13736m = null;
        StaticLayout a10 = gVar.a();
        a10.getClass();
        return a10;
    }

    public final float f() {
        int i10 = this.f13703i0;
        if (i10 != -1) {
            return i10;
        }
        float f10 = this.f13702i;
        TextPaint textPaint = this.P;
        textPaint.setTextSize(f10);
        textPaint.setTypeface(this.f13715s);
        textPaint.setLetterSpacing(this.W);
        return -textPaint.ascent();
    }

    public final int g(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.M;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void i(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f13717u;
            if (typeface != null) {
                this.f13716t = com.bumptech.glide.f.u(configuration, typeface);
            }
            Typeface typeface2 = this.f13720x;
            if (typeface2 != null) {
                this.f13719w = com.bumptech.glide.f.u(configuration, typeface2);
            }
            Typeface typeface3 = this.f13716t;
            if (typeface3 == null) {
                typeface3 = this.f13717u;
            }
            this.f13715s = typeface3;
            Typeface typeface4 = this.f13719w;
            if (typeface4 == null) {
                typeface4 = this.f13720x;
            }
            this.f13718v = typeface4;
            j(true);
        }
    }

    public final void j(boolean z10) {
        float measureText;
        TextInputLayout textInputLayout = this.f13688a;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z10) {
            return;
        }
        d(1.0f, z10);
        CharSequence charSequence = this.C;
        TextPaint textPaint = this.O;
        if (charSequence != null && this.Z != null) {
            this.f13695d0 = o() ? TextUtils.ellipsize(this.C, textPaint, this.Z.getWidth(), this.A) : this.C;
        }
        CharSequence charSequence2 = this.f13695d0;
        if (charSequence2 != null) {
            this.f13689a0 = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f13689a0 = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.g, this.D ? 1 : 0);
        int i10 = absoluteGravity & 112;
        Rect rect = this.f13694d;
        if (i10 == 48) {
            this.f13710n = rect.top;
        } else if (i10 != 80) {
            this.f13710n = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f13710n = textPaint.ascent() + rect.bottom;
        }
        int i11 = absoluteGravity & 8388615;
        if (i11 == 1) {
            this.f13712p = rect.centerX() - (this.f13689a0 / 2.0f);
        } else if (i11 != 5) {
            this.f13712p = rect.left;
        } else {
            this.f13712p = rect.right - this.f13689a0;
        }
        if (this.f13689a0 <= rect.width()) {
            float f10 = this.f13712p;
            float max = Math.max(0.0f, rect.left - f10) + f10;
            this.f13712p = max;
            this.f13712p = Math.min(0.0f, rect.right - (this.f13689a0 + max)) + max;
        }
        float f11 = this.f13702i;
        TextPaint textPaint2 = this.P;
        textPaint2.setTextSize(f11);
        textPaint2.setTypeface(this.f13715s);
        textPaint2.setLetterSpacing(this.W);
        if (textPaint2.descent() + (-textPaint2.ascent()) <= rect.height()) {
            float f12 = this.f13710n;
            float max2 = Math.max(0.0f, rect.top - f12) + f12;
            this.f13710n = max2;
            this.f13710n = Math.min(0.0f, rect.bottom - (f() + max2)) + max2;
        }
        d(0.0f, z10);
        float height = this.Z != null ? r15.getHeight() : 0.0f;
        StaticLayout staticLayout = this.Z;
        if (staticLayout == null || this.f13697e0 <= 1) {
            CharSequence charSequence3 = this.C;
            measureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            measureText = staticLayout.getWidth();
        }
        StaticLayout staticLayout2 = this.Z;
        this.f13708l = staticLayout2 != null ? staticLayout2.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f13698f, this.D ? 1 : 0);
        int i12 = absoluteGravity2 & 112;
        Rect rect2 = this.f13692c;
        if (i12 == 48) {
            this.f13709m = rect2.top;
        } else if (i12 != 80) {
            this.f13709m = rect2.centerY() - (height / 2.0f);
        } else {
            this.f13709m = (rect2.bottom - height) + (this.f13707k0 ? textPaint.descent() : 0.0f);
        }
        int i13 = absoluteGravity2 & 8388615;
        if (i13 == 1) {
            this.f13711o = rect2.centerX() - (measureText / 2.0f);
        } else if (i13 != 5) {
            this.f13711o = rect2.left;
        } else {
            this.f13711o = rect2.right - measureText;
        }
        d(this.f13690b, false);
        textInputLayout.postInvalidateOnAnimation();
        b();
    }

    public final void k(ColorStateList colorStateList) {
        if (this.f13706k == colorStateList && this.f13704j == colorStateList) {
            return;
        }
        this.f13706k = colorStateList;
        this.f13704j = colorStateList;
        j(false);
    }

    public final boolean l(Typeface typeface) {
        a9.a aVar = this.f13722z;
        if (aVar != null) {
            aVar.f153e = true;
        }
        if (this.f13717u == typeface) {
            return false;
        }
        this.f13717u = typeface;
        Typeface u10 = com.bumptech.glide.f.u(this.f13688a.getContext().getResources().getConfiguration(), typeface);
        this.f13716t = u10;
        if (u10 == null) {
            u10 = this.f13717u;
        }
        this.f13715s = u10;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x000b, code lost:
    
        if (r3 > 1.0f) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(float r3) {
        /*
            r2 = this;
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto L7
        L5:
            r3 = r0
            goto Le
        L7:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto Le
            goto L5
        Le:
            float r0 = r2.f13690b
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 == 0) goto L19
            r2.f13690b = r3
            r2.b()
        L19:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x8.b.m(float):void");
    }

    public final void n(Typeface typeface) {
        boolean z10;
        boolean l10 = l(typeface);
        if (this.f13720x != typeface) {
            this.f13720x = typeface;
            Typeface u10 = com.bumptech.glide.f.u(this.f13688a.getContext().getResources().getConfiguration(), typeface);
            this.f13719w = u10;
            if (u10 == null) {
                u10 = this.f13720x;
            }
            this.f13718v = u10;
            z10 = true;
        } else {
            z10 = false;
        }
        if (l10 || z10) {
            j(false);
        }
    }

    public final boolean o() {
        return this.f13699f0 == 1;
    }
}
