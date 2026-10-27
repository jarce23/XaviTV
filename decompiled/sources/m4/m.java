package m4;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import c2.j1;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: p, reason: collision with root package name */
    public static final Matrix f8914p = new Matrix();

    /* renamed from: a, reason: collision with root package name */
    public final Path f8915a;

    /* renamed from: b, reason: collision with root package name */
    public final Path f8916b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f8917c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f8918d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f8919e;

    /* renamed from: f, reason: collision with root package name */
    public PathMeasure f8920f;
    public final j g;

    /* renamed from: h, reason: collision with root package name */
    public float f8921h;

    /* renamed from: i, reason: collision with root package name */
    public float f8922i;

    /* renamed from: j, reason: collision with root package name */
    public float f8923j;

    /* renamed from: k, reason: collision with root package name */
    public float f8924k;

    /* renamed from: l, reason: collision with root package name */
    public int f8925l;

    /* renamed from: m, reason: collision with root package name */
    public String f8926m;

    /* renamed from: n, reason: collision with root package name */
    public Boolean f8927n;

    /* renamed from: o, reason: collision with root package name */
    public final p.e f8928o;

    public m() {
        this.f8917c = new Matrix();
        this.f8921h = 0.0f;
        this.f8922i = 0.0f;
        this.f8923j = 0.0f;
        this.f8924k = 0.0f;
        this.f8925l = 255;
        this.f8926m = null;
        this.f8927n = null;
        this.f8928o = new p.e(0);
        this.g = new j();
        this.f8915a = new Path();
        this.f8916b = new Path();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(j jVar, Matrix matrix, Canvas canvas, int i10, int i11) {
        int i12;
        float f10;
        int i13;
        float f11;
        Matrix matrix2 = jVar.f8901a;
        ArrayList arrayList = jVar.f8902b;
        matrix2.set(matrix);
        Matrix matrix3 = jVar.f8901a;
        matrix3.preConcat(jVar.f8909j);
        canvas.save();
        char c10 = 0;
        int i14 = 0;
        while (i14 < arrayList.size()) {
            k kVar = (k) arrayList.get(i14);
            if (kVar instanceof j) {
                a((j) kVar, matrix3, canvas, i10, i11);
            } else if (kVar instanceof l) {
                l lVar = (l) kVar;
                float f12 = i10 / this.f8923j;
                float f13 = i11 / this.f8924k;
                float min = Math.min(f12, f13);
                Matrix matrix4 = this.f8917c;
                matrix4.set(matrix3);
                matrix4.postScale(f12, f13);
                float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                matrix3.mapVectors(fArr);
                float hypot = (float) Math.hypot(fArr[c10], fArr[1]);
                boolean z10 = c10;
                i12 = i14;
                float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                float f14 = (fArr[z10 ? 1 : 0] * fArr[3]) - (fArr[1] * fArr[2]);
                float max = Math.max(hypot, hypot2);
                float abs = max > 0.0f ? Math.abs(f14) / max : 0.0f;
                if (abs != 0.0f) {
                    Path path = this.f8915a;
                    path.reset();
                    e0.e[] eVarArr = lVar.f8911a;
                    if (eVarArr != null) {
                        e0.e.b(eVarArr, path);
                    }
                    Path path2 = this.f8916b;
                    path2.reset();
                    if (lVar instanceof h) {
                        path2.setFillType(lVar.f8913c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                        path2.addPath(path, matrix4);
                        canvas.clipPath(path2);
                    } else {
                        i iVar = (i) lVar;
                        float f15 = iVar.f8895i;
                        if (f15 != 0.0f || iVar.f8896j != 1.0f) {
                            float f16 = iVar.f8897k;
                            float f17 = (f15 + f16) % 1.0f;
                            float f18 = (iVar.f8896j + f16) % 1.0f;
                            if (this.f8920f == null) {
                                this.f8920f = new PathMeasure();
                            }
                            this.f8920f.setPath(path, z10);
                            float length = this.f8920f.getLength();
                            float f19 = f17 * length;
                            float f20 = f18 * length;
                            path.reset();
                            if (f19 > f20) {
                                this.f8920f.getSegment(f19, length, path, true);
                                f10 = 0.0f;
                                this.f8920f.getSegment(0.0f, f20, path, true);
                            } else {
                                f10 = 0.0f;
                                this.f8920f.getSegment(f19, f20, path, true);
                            }
                            path.rLineTo(f10, f10);
                        }
                        path2.addPath(path, matrix4);
                        j1 j1Var = iVar.f8893f;
                        if (((Shader) j1Var.f2626q) == null && j1Var.f2625p == 0) {
                            f11 = 255.0f;
                            i13 = 16777215;
                        } else {
                            if (this.f8919e == null) {
                                i13 = 16777215;
                                Paint paint = new Paint(1);
                                this.f8919e = paint;
                                paint.setStyle(Paint.Style.FILL);
                            } else {
                                i13 = 16777215;
                            }
                            Paint paint2 = this.f8919e;
                            Shader shader = (Shader) j1Var.f2626q;
                            if (shader != null) {
                                shader.setLocalMatrix(matrix4);
                                paint2.setShader(shader);
                                paint2.setAlpha(Math.round(iVar.f8894h * 255.0f));
                                f11 = 255.0f;
                            } else {
                                paint2.setShader(null);
                                paint2.setAlpha(255);
                                int i15 = j1Var.f2625p;
                                float f21 = iVar.f8894h;
                                PorterDuff.Mode mode = p.f8941x;
                                f11 = 255.0f;
                                paint2.setColor((i15 & i13) | (((int) (Color.alpha(i15) * f21)) << 24));
                            }
                            paint2.setColorFilter(null);
                            path2.setFillType(iVar.f8913c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            canvas.drawPath(path2, paint2);
                        }
                        j1 j1Var2 = iVar.f8891d;
                        if (((Shader) j1Var2.f2626q) != null || j1Var2.f2625p != 0) {
                            if (this.f8918d == null) {
                                Paint paint3 = new Paint(1);
                                this.f8918d = paint3;
                                paint3.setStyle(Paint.Style.STROKE);
                            }
                            Paint paint4 = this.f8918d;
                            Paint.Join join = iVar.f8899m;
                            if (join != null) {
                                paint4.setStrokeJoin(join);
                            }
                            Paint.Cap cap = iVar.f8898l;
                            if (cap != null) {
                                paint4.setStrokeCap(cap);
                            }
                            paint4.setStrokeMiter(iVar.f8900n);
                            Shader shader2 = (Shader) j1Var2.f2626q;
                            if (shader2 != null) {
                                shader2.setLocalMatrix(matrix4);
                                paint4.setShader(shader2);
                                paint4.setAlpha(Math.round(iVar.g * f11));
                            } else {
                                paint4.setShader(null);
                                paint4.setAlpha(255);
                                int i16 = j1Var2.f2625p;
                                float f22 = iVar.g;
                                PorterDuff.Mode mode2 = p.f8941x;
                                paint4.setColor((i16 & i13) | (((int) (Color.alpha(i16) * f22)) << 24));
                            }
                            paint4.setColorFilter(null);
                            paint4.setStrokeWidth(iVar.f8892e * min * abs);
                            canvas.drawPath(path2, paint4);
                        }
                    }
                }
                i14 = i12 + 1;
                c10 = 0;
            }
            i12 = i14;
            i14 = i12 + 1;
            c10 = 0;
        }
        canvas.restore();
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f8925l;
    }

    public void setAlpha(float f10) {
        setRootAlpha((int) (f10 * 255.0f));
    }

    public void setRootAlpha(int i10) {
        this.f8925l = i10;
    }

    public m(m mVar) {
        this.f8917c = new Matrix();
        this.f8921h = 0.0f;
        this.f8922i = 0.0f;
        this.f8923j = 0.0f;
        this.f8924k = 0.0f;
        this.f8925l = 255;
        this.f8926m = null;
        this.f8927n = null;
        p.e eVar = new p.e(0);
        this.f8928o = eVar;
        this.g = new j(mVar.g, eVar);
        this.f8915a = new Path(mVar.f8915a);
        this.f8916b = new Path(mVar.f8916b);
        this.f8921h = mVar.f8921h;
        this.f8922i = mVar.f8922i;
        this.f8923j = mVar.f8923j;
        this.f8924k = mVar.f8924k;
        this.f8925l = mVar.f8925l;
        this.f8926m = mVar.f8926m;
        String str = mVar.f8926m;
        if (str != null) {
            eVar.put(str, this);
        }
        this.f8927n = mVar.f8927n;
    }
}
