package d9;

import android.graphics.Matrix;
import android.graphics.Path;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u extends v {

    /* renamed from: b, reason: collision with root package name */
    public float f4335b;

    /* renamed from: c, reason: collision with root package name */
    public float f4336c;

    @Override // d9.v
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f4337a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f4335b, this.f4336c);
        path.transform(matrix);
    }
}
