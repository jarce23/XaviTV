package r6;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends q {

    /* renamed from: a, reason: collision with root package name */
    public final h f10844a;

    public j(h hVar) {
        this.f10844a = hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        Object obj2 = p.f10860o;
        if (obj2.equals(obj2)) {
            return this.f10844a.equals(((j) qVar).f10844a);
        }
        return false;
    }

    public final int hashCode() {
        return ((p.f10860o.hashCode() ^ 1000003) * 1000003) ^ this.f10844a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + p.f10860o + ", androidClientInfo=" + this.f10844a + "}";
    }
}
