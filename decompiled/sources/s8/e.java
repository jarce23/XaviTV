package s8;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.chip.Chip;
import d9.g;
import d9.j;
import d9.m;
import d9.n;
import d9.p;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import okhttp3.internal.url._UrlKt;
import x8.h;
import x8.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends j implements Drawable.Callback, h {

    /* renamed from: c1, reason: collision with root package name */
    public static final int[] f11634c1 = {R.attr.state_enabled};

    /* renamed from: d1, reason: collision with root package name */
    public static final ShapeDrawable f11635d1 = new ShapeDrawable(new OvalShape());
    public float A0;
    public final Context B0;
    public final Paint C0;
    public final Paint.FontMetrics D0;
    public final RectF E0;
    public final PointF F0;
    public final Path G0;
    public final i H0;
    public int I0;
    public int J0;
    public int K0;
    public int L0;
    public int M0;
    public int N0;
    public boolean O0;
    public int P0;
    public int Q0;
    public ColorFilter R0;
    public PorterDuffColorFilter S0;
    public ColorStateList T0;
    public ColorStateList U;
    public PorterDuff.Mode U0;
    public ColorStateList V;
    public int[] V0;
    public float W;
    public ColorStateList W0;
    public float X;
    public WeakReference X0;
    public ColorStateList Y;
    public TextUtils.TruncateAt Y0;
    public float Z;
    public boolean Z0;

    /* renamed from: a0, reason: collision with root package name */
    public ColorStateList f11636a0;

    /* renamed from: a1, reason: collision with root package name */
    public int f11637a1;

    /* renamed from: b0, reason: collision with root package name */
    public CharSequence f11638b0;

    /* renamed from: b1, reason: collision with root package name */
    public boolean f11639b1;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f11640c0;

    /* renamed from: d0, reason: collision with root package name */
    public Drawable f11641d0;

    /* renamed from: e0, reason: collision with root package name */
    public ColorStateList f11642e0;

    /* renamed from: f0, reason: collision with root package name */
    public float f11643f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f11644g0;
    public boolean h0;

    /* renamed from: i0, reason: collision with root package name */
    public Drawable f11645i0;

    /* renamed from: j0, reason: collision with root package name */
    public RippleDrawable f11646j0;

    /* renamed from: k0, reason: collision with root package name */
    public ColorStateList f11647k0;

    /* renamed from: l0, reason: collision with root package name */
    public float f11648l0;

    /* renamed from: m0, reason: collision with root package name */
    public SpannableStringBuilder f11649m0;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f11650n0;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f11651o0;

    /* renamed from: p0, reason: collision with root package name */
    public Drawable f11652p0;

    /* renamed from: q0, reason: collision with root package name */
    public ColorStateList f11653q0;

    /* renamed from: r0, reason: collision with root package name */
    public k8.b f11654r0;

    /* renamed from: s0, reason: collision with root package name */
    public k8.b f11655s0;

    /* renamed from: t0, reason: collision with root package name */
    public float f11656t0;

    /* renamed from: u0, reason: collision with root package name */
    public float f11657u0;

    /* renamed from: v0, reason: collision with root package name */
    public float f11658v0;

    /* renamed from: w0, reason: collision with root package name */
    public float f11659w0;

    /* renamed from: x0, reason: collision with root package name */
    public float f11660x0;

    /* renamed from: y0, reason: collision with root package name */
    public float f11661y0;

    /* renamed from: z0, reason: collision with root package name */
    public float f11662z0;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, org.chromium.net.R.attr.chipStyle, org.chromium.net.R.style.Widget_MaterialComponents_Chip_Action);
        this.X = -1.0f;
        this.C0 = new Paint(1);
        this.D0 = new Paint.FontMetrics();
        this.E0 = new RectF();
        this.F0 = new PointF();
        this.G0 = new Path();
        this.Q0 = 255;
        this.U0 = PorterDuff.Mode.SRC_IN;
        this.X0 = new WeakReference(null);
        k(context);
        this.B0 = context;
        i iVar = new i(this);
        this.H0 = iVar;
        this.f11638b0 = _UrlKt.FRAGMENT_ENCODE_SET;
        iVar.f13737a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = f11634c1;
        setState(iArr);
        R(iArr);
        this.Z0 = true;
        f11635d1.setTint(-1);
    }

    public static void b0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean y(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean z(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A() {
        d dVar = (d) this.X0.get();
        if (dVar != null) {
            Chip chip = (Chip) dVar;
            chip.b(chip.D);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B(int[] r10, int[] r11) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.e.B(int[], int[]):boolean");
    }

    public final void C(boolean z10) {
        if (this.f11650n0 != z10) {
            this.f11650n0 = z10;
            float v10 = v();
            if (!z10 && this.O0) {
                this.O0 = false;
            }
            float v11 = v();
            invalidateSelf();
            if (v10 != v11) {
                A();
            }
        }
    }

    public final void D(Drawable drawable) {
        if (this.f11652p0 != drawable) {
            float v10 = v();
            this.f11652p0 = drawable;
            float v11 = v();
            b0(this.f11652p0);
            t(this.f11652p0);
            invalidateSelf();
            if (v10 != v11) {
                A();
            }
        }
    }

    public final void E(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f11653q0 != colorStateList) {
            this.f11653q0 = colorStateList;
            if (this.f11651o0 && (drawable = this.f11652p0) != null && this.f11650n0) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void F(boolean z10) {
        if (this.f11651o0 != z10) {
            boolean Y = Y();
            this.f11651o0 = z10;
            boolean Y2 = Y();
            if (Y != Y2) {
                if (Y2) {
                    t(this.f11652p0);
                } else {
                    b0(this.f11652p0);
                }
                invalidateSelf();
                A();
            }
        }
    }

    public final void G(float f10) {
        if (this.X != f10) {
            this.X = f10;
            m f11 = this.f4277p.f4259a.f();
            f11.f4293e = new d9.a(f10);
            f11.f4294f = new d9.a(f10);
            f11.g = new d9.a(f10);
            f11.f4295h = new d9.a(f10);
            setShapeAppearanceModel(f11.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f11641d0;
        if (drawable3 != 0) {
            boolean z10 = drawable3 instanceof f0.a;
            drawable2 = drawable3;
            if (z10) {
                drawable2 = null;
            }
        } else {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float v10 = v();
            this.f11641d0 = drawable != null ? drawable.mutate() : null;
            float v11 = v();
            b0(drawable2);
            if (Z()) {
                t(this.f11641d0);
            }
            invalidateSelf();
            if (v10 != v11) {
                A();
            }
        }
    }

    public final void I(float f10) {
        if (this.f11643f0 != f10) {
            float v10 = v();
            this.f11643f0 = f10;
            float v11 = v();
            invalidateSelf();
            if (v10 != v11) {
                A();
            }
        }
    }

    public final void J(ColorStateList colorStateList) {
        this.f11644g0 = true;
        if (this.f11642e0 != colorStateList) {
            this.f11642e0 = colorStateList;
            if (Z()) {
                this.f11641d0.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void K(boolean z10) {
        if (this.f11640c0 != z10) {
            boolean Z = Z();
            this.f11640c0 = z10;
            boolean Z2 = Z();
            if (Z != Z2) {
                if (Z2) {
                    t(this.f11641d0);
                } else {
                    b0(this.f11641d0);
                }
                invalidateSelf();
                A();
            }
        }
    }

    public final void L(ColorStateList colorStateList) {
        if (this.Y != colorStateList) {
            this.Y = colorStateList;
            if (this.f11639b1) {
                d9.h hVar = this.f4277p;
                if (hVar.f4263e != colorStateList) {
                    hVar.f4263e = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void M(float f10) {
        if (this.Z != f10) {
            this.Z = f10;
            this.C0.setStrokeWidth(f10);
            if (this.f11639b1) {
                this.f4277p.f4268k = f10;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f11645i0;
        if (drawable3 != 0) {
            boolean z10 = drawable3 instanceof f0.a;
            drawable2 = drawable3;
            if (z10) {
                drawable2 = null;
            }
        } else {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float w10 = w();
            this.f11645i0 = drawable != null ? drawable.mutate() : null;
            this.f11646j0 = new RippleDrawable(b9.a.a(this.f11636a0), this.f11645i0, f11635d1);
            float w11 = w();
            b0(drawable2);
            if (a0()) {
                t(this.f11645i0);
            }
            invalidateSelf();
            if (w10 != w11) {
                A();
            }
        }
    }

    public final void O(float f10) {
        if (this.f11662z0 != f10) {
            this.f11662z0 = f10;
            invalidateSelf();
            if (a0()) {
                A();
            }
        }
    }

    public final void P(float f10) {
        if (this.f11648l0 != f10) {
            this.f11648l0 = f10;
            invalidateSelf();
            if (a0()) {
                A();
            }
        }
    }

    public final void Q(float f10) {
        if (this.f11661y0 != f10) {
            this.f11661y0 = f10;
            invalidateSelf();
            if (a0()) {
                A();
            }
        }
    }

    public final boolean R(int[] iArr) {
        if (Arrays.equals(this.V0, iArr)) {
            return false;
        }
        this.V0 = iArr;
        if (a0()) {
            return B(getState(), iArr);
        }
        return false;
    }

    public final void S(ColorStateList colorStateList) {
        if (this.f11647k0 != colorStateList) {
            this.f11647k0 = colorStateList;
            if (a0()) {
                this.f11645i0.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void T(boolean z10) {
        if (this.h0 != z10) {
            boolean a02 = a0();
            this.h0 = z10;
            boolean a03 = a0();
            if (a02 != a03) {
                if (a03) {
                    t(this.f11645i0);
                } else {
                    b0(this.f11645i0);
                }
                invalidateSelf();
                A();
            }
        }
    }

    public final void U(float f10) {
        if (this.f11658v0 != f10) {
            float v10 = v();
            this.f11658v0 = f10;
            float v11 = v();
            invalidateSelf();
            if (v10 != v11) {
                A();
            }
        }
    }

    public final void V(float f10) {
        if (this.f11657u0 != f10) {
            float v10 = v();
            this.f11657u0 = f10;
            float v11 = v();
            invalidateSelf();
            if (v10 != v11) {
                A();
            }
        }
    }

    public final void W(ColorStateList colorStateList) {
        if (this.f11636a0 != colorStateList) {
            this.f11636a0 = colorStateList;
            this.W0 = null;
            onStateChange(getState());
        }
    }

    public final void X(a9.d dVar) {
        i iVar = this.H0;
        b bVar = iVar.f13738b;
        TextPaint textPaint = iVar.f13737a;
        if (iVar.f13742f != dVar) {
            iVar.f13742f = dVar;
            if (dVar != null) {
                Context context = this.B0;
                dVar.e(context, textPaint, bVar);
                h hVar = (h) iVar.f13741e.get();
                if (hVar != null) {
                    textPaint.drawableState = hVar.getState();
                }
                dVar.d(context, textPaint, bVar);
                iVar.f13740d = true;
            }
            h hVar2 = (h) iVar.f13741e.get();
            if (hVar2 != null) {
                e eVar = (e) hVar2;
                eVar.A();
                eVar.invalidateSelf();
                eVar.onStateChange(hVar2.getState());
            }
        }
    }

    public final boolean Y() {
        return this.f11651o0 && this.f11652p0 != null && this.O0;
    }

    public final boolean Z() {
        return this.f11640c0 && this.f11641d0 != null;
    }

    public final boolean a0() {
        return this.h0 && this.f11645i0 != null;
    }

    @Override // d9.j, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i10;
        Canvas canvas2;
        int i11;
        float f10;
        int i12;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i10 = this.Q0) == 0) {
            return;
        }
        if (i10 < 255) {
            canvas2 = canvas;
            i11 = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i10);
        } else {
            canvas2 = canvas;
            i11 = 0;
        }
        boolean z10 = this.f11639b1;
        Paint paint = this.C0;
        RectF rectF = this.E0;
        if (!z10) {
            paint.setColor(this.I0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, x(), x(), paint);
        }
        if (!this.f11639b1) {
            paint.setColor(this.J0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.R0;
            if (colorFilter == null) {
                colorFilter = this.S0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, x(), x(), paint);
        }
        if (this.f11639b1) {
            super.draw(canvas);
        }
        if (this.Z > 0.0f && !this.f11639b1) {
            paint.setColor(this.L0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.f11639b1) {
                ColorFilter colorFilter2 = this.R0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.S0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f11 = bounds.left;
            float f12 = this.Z / 2.0f;
            rectF.set(f11 + f12, bounds.top + f12, bounds.right - f12, bounds.bottom - f12);
            float f13 = this.X - (this.Z / 2.0f);
            canvas2.drawRoundRect(rectF, f13, f13, paint);
        }
        paint.setColor(this.M0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.f11639b1) {
            RectF rectF2 = new RectF(bounds);
            d9.h hVar = this.f4277p;
            n nVar = hVar.f4259a;
            float[] fArr = this.P;
            float f14 = hVar.f4267j;
            g gVar = this.F;
            p pVar = this.G;
            f10 = 2.0f;
            Path path = this.G0;
            pVar.b(nVar, fArr, f14, rectF2, gVar, path);
            e(canvas2, paint, path, this.f4277p.f4259a, this.P, g());
        } else {
            canvas2.drawRoundRect(rectF, x(), x(), paint);
            f10 = 2.0f;
        }
        if (Z()) {
            u(bounds, rectF);
            float f15 = rectF.left;
            float f16 = rectF.top;
            canvas2.translate(f15, f16);
            this.f11641d0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f11641d0.draw(canvas2);
            canvas2.translate(-f15, -f16);
        }
        if (Y()) {
            u(bounds, rectF);
            float f17 = rectF.left;
            float f18 = rectF.top;
            canvas2.translate(f17, f18);
            this.f11652p0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f11652p0.draw(canvas2);
            canvas2.translate(-f17, -f18);
        }
        if (this.Z0 && this.f11638b0 != null) {
            PointF pointF = this.F0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.f11638b0;
            i iVar = this.H0;
            if (charSequence != null) {
                float v10 = v() + this.f11656t0 + this.f11659w0;
                if (getLayoutDirection() == 0) {
                    pointF.x = bounds.left + v10;
                } else {
                    pointF.x = bounds.right - v10;
                    align = Paint.Align.RIGHT;
                }
                float centerY = bounds.centerY();
                TextPaint textPaint = iVar.f13737a;
                Paint.FontMetrics fontMetrics = this.D0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = centerY - ((fontMetrics.descent + fontMetrics.ascent) / f10);
            }
            rectF.setEmpty();
            if (this.f11638b0 != null) {
                float v11 = v() + this.f11656t0 + this.f11659w0;
                float w10 = w() + this.A0 + this.f11660x0;
                if (getLayoutDirection() == 0) {
                    rectF.left = bounds.left + v11;
                    rectF.right = bounds.right - w10;
                } else {
                    rectF.left = bounds.left + w10;
                    rectF.right = bounds.right - v11;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            a9.d dVar = iVar.f13742f;
            TextPaint textPaint2 = iVar.f13737a;
            if (dVar != null) {
                textPaint2.drawableState = getState();
                iVar.f13742f.d(this.B0, textPaint2, iVar.f13738b);
            }
            textPaint2.setTextAlign(align);
            boolean z11 = Math.round(iVar.a(this.f11638b0.toString())) > Math.round(rectF.width());
            if (z11) {
                int save = canvas2.save();
                canvas2.clipRect(rectF);
                i12 = save;
            } else {
                i12 = 0;
            }
            CharSequence charSequence2 = this.f11638b0;
            if (z11 && this.Y0 != null) {
                charSequence2 = TextUtils.ellipsize(charSequence2, textPaint2, rectF.width(), this.Y0);
            }
            canvas.drawText(charSequence2, 0, charSequence2.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z11) {
                canvas2.restoreToCount(i12);
            }
        }
        if (a0()) {
            rectF.setEmpty();
            if (a0()) {
                float f19 = this.A0 + this.f11662z0;
                if (getLayoutDirection() == 0) {
                    float f20 = bounds.right - f19;
                    rectF.right = f20;
                    rectF.left = f20 - this.f11648l0;
                } else {
                    float f21 = bounds.left + f19;
                    rectF.left = f21;
                    rectF.right = f21 + this.f11648l0;
                }
                float exactCenterY = bounds.exactCenterY();
                float f22 = this.f11648l0;
                float f23 = exactCenterY - (f22 / f10);
                rectF.top = f23;
                rectF.bottom = f23 + f22;
            }
            float f24 = rectF.left;
            float f25 = rectF.top;
            canvas2.translate(f24, f25);
            this.f11645i0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f11646j0.setBounds(this.f11645i0.getBounds());
            this.f11646j0.jumpToCurrentState();
            this.f11646j0.draw(canvas2);
            canvas2.translate(-f24, -f25);
        }
        if (this.Q0 < 255) {
            canvas2.restoreToCount(i11);
        }
    }

    @Override // d9.j, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.Q0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.R0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.W;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(w() + this.H0.a(this.f11638b0.toString()) + v() + this.f11656t0 + this.f11659w0 + this.f11660x0 + this.A0), this.f11637a1);
    }

    @Override // d9.j, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // d9.j, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.f11639b1) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.W, this.X);
        } else {
            outline.setRoundRect(bounds, this.X);
            outline2 = outline;
        }
        outline2.setAlpha(this.Q0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // d9.j, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (y(this.U) || y(this.V) || y(this.Y)) {
            return true;
        }
        a9.d dVar = this.H0.f13742f;
        if (dVar == null || (colorStateList = dVar.f169k) == null || !colorStateList.isStateful()) {
            return (this.f11651o0 && this.f11652p0 != null && this.f11650n0) || z(this.f11641d0) || z(this.f11652p0) || y(this.T0);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i10) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i10);
        if (Z()) {
            onLayoutDirectionChanged |= this.f11641d0.setLayoutDirection(i10);
        }
        if (Y()) {
            onLayoutDirectionChanged |= this.f11652p0.setLayoutDirection(i10);
        }
        if (a0()) {
            onLayoutDirectionChanged |= this.f11645i0.setLayoutDirection(i10);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i10) {
        boolean onLevelChange = super.onLevelChange(i10);
        if (Z()) {
            onLevelChange |= this.f11641d0.setLevel(i10);
        }
        if (Y()) {
            onLevelChange |= this.f11652p0.setLevel(i10);
        }
        if (a0()) {
            onLevelChange |= this.f11645i0.setLevel(i10);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // d9.j, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.f11639b1) {
            super.onStateChange(iArr);
        }
        return B(iArr, this.V0);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // d9.j, android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        if (this.Q0 != i10) {
            this.Q0 = i10;
            invalidateSelf();
        }
    }

    @Override // d9.j, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.R0 != colorFilter) {
            this.R0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // d9.j, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.T0 != colorStateList) {
            this.T0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // d9.j, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.U0 != mode) {
            this.U0 = mode;
            ColorStateList colorStateList = this.T0;
            this.S0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (Z()) {
            visible |= this.f11641d0.setVisible(z10, z11);
        }
        if (Y()) {
            visible |= this.f11652p0.setVisible(z10, z11);
        }
        if (a0()) {
            visible |= this.f11645i0.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void t(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f11645i0) {
            if (drawable.isStateful()) {
                drawable.setState(this.V0);
            }
            drawable.setTintList(this.f11647k0);
            return;
        }
        Drawable drawable2 = this.f11641d0;
        if (drawable == drawable2 && this.f11644g0) {
            drawable2.setTintList(this.f11642e0);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void u(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (Z() || Y()) {
            float f10 = this.f11656t0 + this.f11657u0;
            Drawable drawable = this.O0 ? this.f11652p0 : this.f11641d0;
            float f11 = this.f11643f0;
            if (f11 <= 0.0f && drawable != null) {
                f11 = drawable.getIntrinsicWidth();
            }
            if (getLayoutDirection() == 0) {
                float f12 = rect.left + f10;
                rectF.left = f12;
                rectF.right = f12 + f11;
            } else {
                float f13 = rect.right - f10;
                rectF.right = f13;
                rectF.left = f13 - f11;
            }
            Drawable drawable2 = this.O0 ? this.f11652p0 : this.f11641d0;
            float f14 = this.f11643f0;
            if (f14 <= 0.0f && drawable2 != null) {
                f14 = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.B0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= f14) {
                    f14 = drawable2.getIntrinsicHeight();
                }
            }
            float exactCenterY = rect.exactCenterY() - (f14 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + f14;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final float v() {
        if (!Z() && !Y()) {
            return 0.0f;
        }
        float f10 = this.f11657u0;
        Drawable drawable = this.O0 ? this.f11652p0 : this.f11641d0;
        float f11 = this.f11643f0;
        if (f11 <= 0.0f && drawable != null) {
            f11 = drawable.getIntrinsicWidth();
        }
        return f11 + f10 + this.f11658v0;
    }

    public final float w() {
        if (a0()) {
            return this.f11661y0 + this.f11648l0 + this.f11662z0;
        }
        return 0.0f;
    }

    public final float x() {
        if (!this.f11639b1) {
            return this.X;
        }
        float[] fArr = this.P;
        return fArr != null ? fArr[3] : this.f4277p.f4259a.f4304e.a(g());
    }
}
