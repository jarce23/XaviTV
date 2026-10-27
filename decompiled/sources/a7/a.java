package a7;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f108f = new a(10485760, 200, 10000, 604800000, 81920);

    /* renamed from: a, reason: collision with root package name */
    public final long f109a;

    /* renamed from: b, reason: collision with root package name */
    public final int f110b;

    /* renamed from: c, reason: collision with root package name */
    public final int f111c;

    /* renamed from: d, reason: collision with root package name */
    public final long f112d;

    /* renamed from: e, reason: collision with root package name */
    public final int f113e;

    public a(long j10, int i10, int i11, long j11, int i12) {
        this.f109a = j10;
        this.f110b = i10;
        this.f111c = i11;
        this.f112d = j11;
        this.f113e = i12;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f109a == aVar.f109a && this.f110b == aVar.f110b && this.f111c == aVar.f111c && this.f112d == aVar.f112d && this.f113e == aVar.f113e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f109a;
        int i10 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f110b) * 1000003) ^ this.f111c) * 1000003;
        long j11 = this.f112d;
        return ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f113e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb2.append(this.f109a);
        sb2.append(", loadBatchSize=");
        sb2.append(this.f110b);
        sb2.append(", criticalSectionEnterTimeoutMs=");
        sb2.append(this.f111c);
        sb2.append(", eventCleanUpAge=");
        sb2.append(this.f112d);
        sb2.append(", maxBlobByteSizePerRow=");
        return r.a.d(sb2, this.f113e, "}");
    }
}
