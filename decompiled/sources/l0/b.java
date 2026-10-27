package l0;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8060a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8061b;

    public b(Object obj, Object obj2) {
        this.f8060a = obj;
        this.f8061b = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(bVar.f8060a, this.f8060a) && Objects.equals(bVar.f8061b, this.f8061b);
    }

    public final int hashCode() {
        Object obj = this.f8060a;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f8061b;
        return (obj2 != null ? obj2.hashCode() : 0) ^ hashCode;
    }

    public final String toString() {
        return "Pair{" + this.f8060a + " " + this.f8061b + "}";
    }
}
