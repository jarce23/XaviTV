package d9;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends w {

    /* renamed from: c, reason: collision with root package name */
    public final t f4325c;

    public r(t tVar) {
        this.f4325c = tVar;
    }

    @Override // d9.w
    public final void a(Matrix matrix, c9.a aVar, int i10, Canvas canvas) {
        float f10;
        t tVar = this.f4325c;
        float f11 = tVar.f4334f;
        float f12 = tVar.g;
        RectF rectF = new RectF(tVar.f4330b, tVar.f4331c, tVar.f4332d, tVar.f4333e);
        Paint paint = aVar.f2976b;
        boolean z10 = f12 < 0.0f;
        Path path = aVar.g;
        int[] iArr = c9.a.f2973k;
        if (z10) {
            iArr[0] = 0;
            iArr[1] = aVar.f2980f;
            iArr[2] = aVar.f2979e;
            iArr[3] = aVar.f2978d;
            f10 = 0.0f;
        } else {
            path.rewind();
            f10 = 0.0f;
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f11, f12);
            path.close();
            float f13 = -i10;
            rectF.inset(f13, f13);
            iArr[0] = 0;
            iArr[1] = aVar.f2978d;
            iArr[2] = aVar.f2979e;
            iArr[3] = aVar.f2980f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= f10) {
            return;
        }
        float f14 = 1.0f - (i10 / width);
        float[] fArr = c9.a.f2974l;
        fArr[1] = f14;
        fArr[2] = ((1.0f - f14) / 2.0f) + f14;
        paint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, iArr, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z10) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, aVar.f2981h);
        }
        canvas.drawArc(rectF, f11, f12, true, paint);
        canvas.restore();
    }
}
