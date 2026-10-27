package f2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f4866a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4867b;

    public a(long j10, long j11) {
        this.f4866a = j10;
        this.f4867b = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f4866a == aVar.f4866a && this.f4867b == aVar.f4867b;
    }

    public final int hashCode() {
        return (((int) this.f4866a) * 31) + ((int) this.f4867b);
    }
}
