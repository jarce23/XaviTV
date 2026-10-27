package d9;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final d f4241a;

    /* renamed from: b, reason: collision with root package name */
    public final float f4242b;

    public b(float f10, d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f4241a;
            f10 += ((b) dVar).f4242b;
        }
        this.f4241a = dVar;
        this.f4242b = f10;
    }

    @Override // d9.d
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f4241a.a(rectF) + this.f4242b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4241a.equals(bVar.f4241a) && this.f4242b == bVar.f4242b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4241a, Float.valueOf(this.f4242b)});
    }
}
