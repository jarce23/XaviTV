package d0;

import android.content.res.Resources;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f3976a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f3977b;

    public i(Resources resources, Resources.Theme theme) {
        this.f3976a = resources;
        this.f3977b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f3976a.equals(iVar.f3976a) && Objects.equals(this.f3977b, iVar.f3977b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f3976a, this.f3977b);
    }
}
