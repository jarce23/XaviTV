package a7;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f114a;

    /* renamed from: b, reason: collision with root package name */
    public final s6.i f115b;

    /* renamed from: c, reason: collision with root package name */
    public final s6.h f116c;

    public b(long j10, s6.i iVar, s6.h hVar) {
        this.f114a = j10;
        this.f115b = iVar;
        this.f116c = hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f114a == bVar.f114a && this.f115b.equals(bVar.f115b) && this.f116c.equals(bVar.f116c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f114a;
        return ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f115b.hashCode()) * 1000003) ^ this.f116c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f114a + ", transportContext=" + this.f115b + ", event=" + this.f116c + "}";
    }
}
