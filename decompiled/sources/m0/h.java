package m0;

import android.view.DisplayCutout;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f8670a;

    public h(DisplayCutout displayCutout) {
        this.f8670a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f8670a, ((h) obj).f8670a);
    }

    public final int hashCode() {
        int hashCode;
        hashCode = this.f8670a.hashCode();
        return hashCode;
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f8670a + "}";
    }
}
