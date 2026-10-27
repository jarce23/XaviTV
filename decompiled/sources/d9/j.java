package d9;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import androidx.fragment.app.v0;
import java.util.BitSet;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class j extends Drawable implements y {
    public static final Paint S;
    public static final i[] T;
    public final Region A;
    public final Region B;
    public final Paint C;
    public final Paint D;
    public final c9.a E;
    public final g F;
    public final p G;
    public PorterDuffColorFilter H;
    public PorterDuffColorFilter I;
    public final RectF J;
    public final boolean K;
    public boolean L;
    public n M;
    public t0.f N;
    public final t0.e[] O;
    public float[] P;
    public float[] Q;
    public v0 R;

    /* renamed from: o, reason: collision with root package name */
    public final g f4276o;

    /* renamed from: p, reason: collision with root package name */
    public h f4277p;

    /* renamed from: q, reason: collision with root package name */
    public final w[] f4278q;

    /* renamed from: r, reason: collision with root package name */
    public final w[] f4279r;

    /* renamed from: s, reason: collision with root package name */
    public final BitSet f4280s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4281t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4282u;

    /* renamed from: v, reason: collision with root package name */
    public final Matrix f4283v;

    /* renamed from: w, reason: collision with root package name */
    public final Path f4284w;

    /* renamed from: x, reason: collision with root package name */
    public final Path f4285x;

    /* renamed from: y, reason: collision with root package name */
    public final RectF f4286y;

    /* renamed from: z, reason: collision with root package name */
    public final RectF f4287z;

    static {
        Paint paint = new Paint(1);
        S = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        T = new i[4];
        int i10 = 0;
        while (true) {
            i[] iVarArr = T;
            if (i10 >= iVarArr.length) {
                return;
            }
            iVarArr[i10] = new i(i10);
            i10++;
        }
    }

    public j() {
        this(new n());
    }

    public static float b(RectF rectF, n nVar, float[] fArr) {
        if (fArr == null) {
            if (nVar.e(rectF)) {
                return nVar.f4304e.a(rectF);
            }
            return -1.0f;
        }
        if (fArr.length > 1) {
            float f10 = fArr[0];
            for (int i10 = 1; i10 < fArr.length; i10++) {
                if (fArr[i10] != f10) {
                    return -1.0f;
                }
            }
        }
        if (nVar.d()) {
            return fArr[0];
        }
        return -1.0f;
    }

    public final void a(RectF rectF, Path path) {
        h hVar = this.f4277p;
        this.G.b(hVar.f4259a, this.P, hVar.f4267j, rectF, this.F, path);
        if (this.f4277p.f4266i != 1.0f) {
            Matrix matrix = this.f4283v;
            matrix.reset();
            float f10 = this.f4277p.f4266i;
            matrix.setScale(f10, f10, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.J, true);
    }

    public final int c(int i10) {
        int i11;
        h hVar = this.f4277p;
        float f10 = hVar.f4271n + 0.0f + hVar.f4270m;
        w8.a aVar = hVar.f4261c;
        if (aVar == null || !aVar.f13142a || e0.a.h(i10, 255) != aVar.f13145d) {
            return i10;
        }
        float min = (aVar.f13146e <= 0.0f || f10 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f10 / r4)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int alpha = Color.alpha(i10);
        int p10 = com.bumptech.glide.e.p(min, e0.a.h(i10, 255), aVar.f13143b);
        if (min > 0.0f && (i11 = aVar.f13144c) != 0) {
            p10 = e0.a.f(e0.a.h(i11, w8.a.f13141f), p10);
        }
        return e0.a.h(p10, alpha);
    }

    public final void d(Canvas canvas) {
        if (this.f4280s.cardinality() > 0) {
            Log.w("j", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i10 = this.f4277p.f4273p;
        Path path = this.f4284w;
        c9.a aVar = this.E;
        if (i10 != 0) {
            canvas.drawPath(path, aVar.f2975a);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            w wVar = this.f4278q[i11];
            int i12 = this.f4277p.f4272o;
            Matrix matrix = w.f4338b;
            wVar.a(matrix, aVar, i12, canvas);
            this.f4279r[i11].a(matrix, aVar, this.f4277p.f4272o, canvas);
        }
        if (this.K) {
            double d6 = 0;
            int sin = (int) (Math.sin(Math.toRadians(d6)) * this.f4277p.f4273p);
            int cos = (int) (Math.cos(Math.toRadians(d6)) * this.f4277p.f4273p);
            canvas.translate(-sin, -cos);
            canvas.drawPath(path, S);
            canvas.translate(sin, cos);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
    
        if (r19.f4277p.f4259a.d() != false) goto L43;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d9.j.draw(android.graphics.Canvas):void");
    }

    public final void e(Canvas canvas, Paint paint, Path path, n nVar, float[] fArr, RectF rectF) {
        float b2 = b(rectF, nVar, fArr);
        if (b2 < 0.0f) {
            canvas.drawPath(path, paint);
        } else {
            float f10 = b2 * this.f4277p.f4267j;
            canvas.drawRoundRect(rectF, f10, f10, paint);
        }
    }

    public void f(Canvas canvas) {
        n nVar = this.M;
        float[] fArr = this.Q;
        RectF g = g();
        RectF rectF = this.f4287z;
        rectF.set(g);
        float i10 = i();
        rectF.inset(i10, i10);
        e(canvas, this.D, this.f4285x, nVar, fArr, rectF);
    }

    public final RectF g() {
        Rect bounds = getBounds();
        RectF rectF = this.f4286y;
        rectF.set(bounds);
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f4277p.f4269l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f4277p;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f4277p.getClass();
        RectF g = g();
        if (g.isEmpty()) {
            return;
        }
        float b2 = b(g, this.f4277p.f4259a, this.P);
        if (b2 >= 0.0f) {
            outline.setRoundRect(getBounds(), b2 * this.f4277p.f4267j);
            return;
        }
        boolean z10 = this.f4281t;
        Path path = this.f4284w;
        if (z10) {
            a(g, path);
            this.f4281t = false;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            v8.c.a(outline, path);
            return;
        }
        if (i10 >= 29) {
            try {
                v8.b.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            v8.b.a(outline, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f4277p.f4265h;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.A;
        region.set(bounds);
        RectF g = g();
        Path path = this.f4284w;
        a(g, path);
        Region region2 = this.B;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final float h() {
        float[] fArr = this.P;
        if (fArr != null) {
            return (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
        }
        RectF g = g();
        n nVar = this.f4277p.f4259a;
        p pVar = this.G;
        pVar.getClass();
        float a10 = nVar.f4304e.a(g);
        n nVar2 = this.f4277p.f4259a;
        pVar.getClass();
        float a11 = nVar2.f4306h.a(g) + a10;
        n nVar3 = this.f4277p.f4259a;
        pVar.getClass();
        float a12 = a11 - nVar3.g.a(g);
        n nVar4 = this.f4277p.f4259a;
        pVar.getClass();
        return (a12 - nVar4.f4305f.a(g)) / 2.0f;
    }

    public final float i() {
        if (j()) {
            return this.D.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f4281t = true;
        this.f4282u = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f4277p.f4264f;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f4277p.getClass();
        ColorStateList colorStateList2 = this.f4277p.f4263e;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f4277p.f4262d;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        b0 b0Var = this.f4277p.f4260b;
        return b0Var != null && b0Var.d();
    }

    public final boolean j() {
        Paint.Style style = this.f4277p.f4274q;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.D.getStrokeWidth() > 0.0f;
    }

    public final void k(Context context) {
        this.f4277p.f4261c = new w8.a(context);
        s();
    }

    public final void l(t0.f fVar) {
        if (this.N == fVar) {
            return;
        }
        this.N = fVar;
        int i10 = 0;
        while (true) {
            t0.e[] eVarArr = this.O;
            if (i10 >= eVarArr.length) {
                q(true, getState());
                invalidateSelf();
                return;
            }
            if (eVarArr[i10] == null) {
                eVarArr[i10] = new t0.e(this, T[i10]);
            }
            t0.e eVar = eVarArr[i10];
            t0.f fVar2 = new t0.f();
            float f10 = (float) fVar.f11772b;
            if (f10 < 0.0f) {
                throw new IllegalArgumentException("Damping ratio must be non-negative");
            }
            fVar2.f11772b = f10;
            fVar2.f11773c = false;
            double d6 = fVar.f11771a;
            float f11 = (float) (d6 * d6);
            if (f11 <= 0.0f) {
                throw new IllegalArgumentException("Spring stiffness constant must be positive.");
            }
            fVar2.f11771a = Math.sqrt(f11);
            fVar2.f11773c = false;
            eVar.f11768j = fVar2;
            i10++;
        }
    }

    public final void m(float f10) {
        h hVar = this.f4277p;
        if (hVar.f4271n != f10) {
            hVar.f4271n = f10;
            s();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f4277p = new h(this.f4277p);
        return this;
    }

    public final void n(ColorStateList colorStateList) {
        h hVar = this.f4277p;
        if (hVar.f4262d != colorStateList) {
            hVar.f4262d = colorStateList;
            onStateChange(getState());
        }
    }

    public final void o(b0 b0Var) {
        h hVar = this.f4277p;
        if (hVar.f4260b != b0Var) {
            hVar.f4260b = b0Var;
            q(true, getState());
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f4281t = true;
        this.f4282u = true;
        super.onBoundsChange(rect);
        if (this.f4277p.f4260b != null && !rect.isEmpty()) {
            q(this.L, getState());
        }
        this.L = rect.isEmpty();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f4277p.f4260b != null) {
            q(false, iArr);
        }
        boolean z10 = p(iArr) || r();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    public final boolean p(int[] iArr) {
        boolean z10;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f4277p.f4262d == null || color2 == (colorForState2 = this.f4277p.f4262d.getColorForState(iArr, (color2 = (paint2 = this.C).getColor())))) {
            z10 = false;
        } else {
            paint2.setColor(colorForState2);
            z10 = true;
        }
        if (this.f4277p.f4263e == null || color == (colorForState = this.f4277p.f4263e.getColorForState(iArr, (color = (paint = this.D).getColor())))) {
            return z10;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final void q(boolean z10, int[] iArr) {
        n a10;
        int i10;
        RectF g = g();
        if (this.f4277p.f4260b == null || g.isEmpty()) {
            return;
        }
        boolean z11 = z10 | (this.N == null);
        if (this.P == null) {
            this.P = new float[4];
        }
        b0 b0Var = this.f4277p.f4260b;
        n[] nVarArr = b0Var.f4246d;
        int i11 = b0Var.f4243a;
        int[][] iArr2 = b0Var.f4245c;
        z zVar = b0Var.f4249h;
        z zVar2 = b0Var.g;
        z zVar3 = b0Var.f4248f;
        z zVar4 = b0Var.f4247e;
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                i12 = -1;
                break;
            } else if (StateSet.stateSetMatches(iArr2[i12], iArr)) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int i13 = 0;
            while (true) {
                if (i13 >= i11) {
                    i10 = -1;
                    break;
                } else {
                    if (StateSet.stateSetMatches(iArr2[i13], iArr3)) {
                        i10 = i13;
                        break;
                    }
                    i13++;
                }
            }
            i12 = i10;
        }
        if (zVar4 == null && zVar3 == null && zVar2 == null && zVar == null) {
            a10 = nVarArr[i12];
        } else {
            m f10 = nVarArr[i12].f();
            if (zVar4 != null) {
                f10.f4293e = zVar4.c(iArr);
            }
            if (zVar3 != null) {
                f10.f4294f = zVar3.c(iArr);
            }
            if (zVar2 != null) {
                f10.f4295h = zVar2.c(iArr);
            }
            if (zVar != null) {
                f10.g = zVar.c(iArr);
            }
            a10 = f10.a();
        }
        int i14 = 0;
        while (i14 < 4) {
            this.G.getClass();
            float a11 = (i14 != 1 ? i14 != 2 ? i14 != 3 ? a10.f4305f : a10.f4304e : a10.f4306h : a10.g).a(g);
            if (z11) {
                this.P[i14] = a11;
            }
            t0.e[] eVarArr = this.O;
            t0.e eVar = eVarArr[i14];
            if (eVar != null) {
                eVar.a(a11);
                if (z11) {
                    eVarArr[i14].d();
                }
            }
            i14++;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    public final boolean r() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.H;
        PorterDuffColorFilter porterDuffColorFilter3 = this.I;
        h hVar = this.f4277p;
        ColorStateList colorStateList = hVar.f4264f;
        PorterDuff.Mode mode = hVar.g;
        if (colorStateList == null || mode == null) {
            int color = this.C.getColor();
            int c10 = c(color);
            porterDuffColorFilter = c10 != color ? new PorterDuffColorFilter(c10, PorterDuff.Mode.SRC_IN) : null;
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(c(colorStateList.getColorForState(getState(), 0)), mode);
        }
        this.H = porterDuffColorFilter;
        this.f4277p.getClass();
        this.I = null;
        this.f4277p.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.H) && Objects.equals(porterDuffColorFilter3, this.I)) ? false : true;
    }

    public final void s() {
        h hVar = this.f4277p;
        float f10 = hVar.f4271n + 0.0f;
        hVar.f4272o = (int) Math.ceil(0.75f * f10);
        this.f4277p.f4273p = (int) Math.ceil(f10 * 0.25f);
        r();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        h hVar = this.f4277p;
        if (hVar.f4269l != i10) {
            hVar.f4269l = i10;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4277p.getClass();
        super.invalidateSelf();
    }

    @Override // d9.y
    public final void setShapeAppearanceModel(n nVar) {
        h hVar = this.f4277p;
        hVar.f4259a = nVar;
        hVar.f4260b = null;
        this.P = null;
        this.Q = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f4277p.f4264f = colorStateList;
        r();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        h hVar = this.f4277p;
        if (hVar.g != mode) {
            hVar.g = mode;
            r();
            super.invalidateSelf();
        }
    }

    public j(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(n.b(context, attributeSet, i10, i11).a());
    }

    public j(n nVar) {
        this(new h(nVar));
    }

    public j(h hVar) {
        p pVar;
        this.f4276o = new g(this);
        this.f4278q = new w[4];
        this.f4279r = new w[4];
        this.f4280s = new BitSet(8);
        this.f4283v = new Matrix();
        this.f4284w = new Path();
        this.f4285x = new Path();
        this.f4286y = new RectF();
        this.f4287z = new RectF();
        this.A = new Region();
        this.B = new Region();
        Paint paint = new Paint(1);
        this.C = paint;
        Paint paint2 = new Paint(1);
        this.D = paint2;
        this.E = new c9.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            pVar = o.f4311a;
        } else {
            pVar = new p();
        }
        this.G = pVar;
        this.J = new RectF();
        this.K = true;
        this.L = true;
        this.O = new t0.e[4];
        this.f4277p = hVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        r();
        p(getState());
        this.F = new g(this);
    }
}
