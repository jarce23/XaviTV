package d9;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t extends v {

    /* renamed from: h, reason: collision with root package name */
    public static final RectF f4329h = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final float f4330b;

    /* renamed from: c, reason: collision with root package name */
    public final float f4331c;

    /* renamed from: d, reason: collision with root package name */
    public final float f4332d;

    /* renamed from: e, reason: collision with root package name */
    public final float f4333e;

    /* renamed from: f, reason: collision with root package name */
    public float f4334f;
    public float g;

    public t(float f10, float f11, float f12, float f13) {
        this.f4330b = f10;
        this.f4331c = f11;
        this.f4332d = f12;
        this.f4333e = f13;
    }

    @Override // d9.v
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f4337a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        float f10 = this.f4332d;
        float f11 = this.f4333e;
        RectF rectF = f4329h;
        rectF.set(this.f4330b, this.f4331c, f10, f11);
        path.arcTo(rectF, this.f4334f, this.g, false);
        path.transform(matrix);
    }
}
