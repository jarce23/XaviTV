package j9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final int f7441a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7442b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7443c;

    /* renamed from: d, reason: collision with root package name */
    public final long f7444d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7445e;

    public t(int i10, String str, long j10, long j11, int i11) {
        this.f7441a = i10;
        this.f7442b = str;
        this.f7443c = j10;
        this.f7444d = j11;
        this.f7445e = i11;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            String str2 = tVar.f7442b;
            if (this.f7441a == tVar.f7441a && ((str = this.f7442b) != null ? str.equals(str2) : str2 == null) && this.f7443c == tVar.f7443c && this.f7444d == tVar.f7444d && this.f7445e == tVar.f7445e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f7442b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f7444d;
        long j11 = j10 ^ (j10 >>> 32);
        long j12 = this.f7443c;
        return ((((((hashCode ^ ((this.f7441a ^ 1000003) * 1000003)) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ ((int) j11)) * 1000003) ^ this.f7445e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SliceCheckpoint{fileExtractionStatus=");
        sb2.append(this.f7441a);
        sb2.append(", filePath=");
        sb2.append(this.f7442b);
        sb2.append(", fileOffset=");
        sb2.append(this.f7443c);
        sb2.append(", remainingBytes=");
        sb2.append(this.f7444d);
        sb2.append(", previousChunk=");
        return r.a.d(sb2, this.f7445e, "}");
    }
}
