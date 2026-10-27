package d9;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s extends w {

    /* renamed from: c, reason: collision with root package name */
    public final u f4326c;

    /* renamed from: d, reason: collision with root package name */
    public final float f4327d;

    /* renamed from: e, reason: collision with root package name */
    public final float f4328e;

    public s(u uVar, float f10, float f11) {
        this.f4326c = uVar;
        this.f4327d = f10;
        this.f4328e = f11;
    }

    @Override // d9.w
    public final void a(Matrix matrix, c9.a aVar, int i10, Canvas canvas) {
        u uVar = this.f4326c;
        float f10 = uVar.f4336c;
        float f11 = this.f4328e;
        float f12 = uVar.f4335b;
        float f13 = this.f4327d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f10 - f11, f12 - f13), 0.0f);
        Matrix matrix2 = this.f4339a;
        matrix2.set(matrix);
        matrix2.preTranslate(f13, f11);
        matrix2.preRotate(b());
        aVar.getClass();
        rectF.bottom += i10;
        rectF.offset(0.0f, -i10);
        int i11 = aVar.f2980f;
        int[] iArr = c9.a.f2971i;
        iArr[0] = i11;
        iArr[1] = aVar.f2979e;
        iArr[2] = aVar.f2978d;
        Paint paint = aVar.f2977c;
        float f14 = rectF.left;
        paint.setShader(new LinearGradient(f14, rectF.top, f14, rectF.bottom, iArr, c9.a.f2972j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        u uVar = this.f4326c;
        return (float) Math.toDegrees(Math.atan((uVar.f4336c - this.f4328e) / (uVar.f4335b - this.f4327d)));
    }
}
