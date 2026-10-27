package t6;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f12018a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12019b;

    public a(int i10, long j10) {
        if (i10 == 0) {
            throw new NullPointerException("Null status");
        }
        this.f12018a = i10;
        this.f12019b = j10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        int i10 = aVar.f12018a;
        int i11 = this.f12018a;
        if (i11 != 0) {
            return (i11 == i10) && this.f12019b == aVar.f12019b;
        }
        throw null;
    }

    public final int hashCode() {
        int b2 = (s.e.b(this.f12018a) ^ 1000003) * 1000003;
        long j10 = this.f12019b;
        return b2 ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BackendResponse{status=");
        int i10 = this.f12018a;
        sb2.append(i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "null" : "INVALID_PAYLOAD" : "FATAL_ERROR" : "TRANSIENT_ERROR" : "OK");
        sb2.append(", nextRequestWaitMillis=");
        sb2.append(this.f12019b);
        sb2.append("}");
        return sb2.toString();
    }
}
