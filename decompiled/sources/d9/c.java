package d9;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f4250a;

    public c(float f10) {
        this.f4250a = f10;
    }

    @Override // d9.d
    public final float a(RectF rectF) {
        float min = Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
        float f10 = this.f4250a;
        if (f10 < 0.0f) {
            return 0.0f;
        }
        return f10 > min ? min : f10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f4250a == ((c) obj).f4250a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4250a)});
    }
}
