package j0;

import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f6904a;

    /* renamed from: b, reason: collision with root package name */
    public String f6905b;

    /* renamed from: c, reason: collision with root package name */
    public List f6906c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f6904a, bVar.f6904a) && Objects.equals(this.f6905b, bVar.f6905b) && Objects.equals(this.f6906c, bVar.f6906c);
    }

    public final int hashCode() {
        return Objects.hash(this.f6904a, this.f6905b, this.f6906c);
    }
}
