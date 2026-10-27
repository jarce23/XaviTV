package s6;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final p6.b f11619a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f11620b;

    public k(p6.b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f11619a = bVar;
        this.f11620b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f11619a.equals(kVar.f11619a)) {
            return Arrays.equals(this.f11620b, kVar.f11620b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f11619a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f11620b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f11619a + ", bytes=[...]}";
    }
}
