package d9;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f4288a;

    public k(float f10) {
        this.f4288a = f10;
    }

    @Override // d9.d
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f4288a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && this.f4288a == ((k) obj).f4288a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4288a)});
    }

    public final String toString() {
        return r.a.d(new StringBuilder(), (int) (this.f4288a * 100.0f), "%");
    }
}
