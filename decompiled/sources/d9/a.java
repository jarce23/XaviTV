package d9;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f4233a;

    public a(float f10) {
        this.f4233a = f10;
    }

    @Override // d9.d
    public final float a(RectF rectF) {
        return this.f4233a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f4233a == ((a) obj).f4233a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4233a)});
    }

    public final String toString() {
        return this.f4233a + "px";
    }
}
