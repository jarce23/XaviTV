package j9;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final String f7451a;

    /* renamed from: b, reason: collision with root package name */
    public final long f7452b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7453c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7454d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f7455e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f7456f;

    public u(String str, long j10, int i10, boolean z10, boolean z11, byte[] bArr) {
        this.f7451a = str;
        this.f7452b = j10;
        this.f7453c = i10;
        this.f7454d = z10;
        this.f7455e = z11;
        this.f7456f = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        String str = uVar.f7451a;
        String str2 = this.f7451a;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        return this.f7452b == uVar.f7452b && this.f7453c == uVar.f7453c && this.f7454d == uVar.f7454d && this.f7455e == uVar.f7455e && Arrays.equals(this.f7456f, uVar.f7456f);
    }

    public final int hashCode() {
        String str = this.f7451a;
        int hashCode = str == null ? 0 : str.hashCode();
        int i10 = true != this.f7454d ? 1237 : 1231;
        long j10 = this.f7452b;
        return ((((((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ this.f7453c) * 1000003) ^ i10) * 1000003) ^ (true != this.f7455e ? 1237 : 1231)) * 1000003) ^ Arrays.hashCode(this.f7456f);
    }

    public final String toString() {
        return "ZipEntry{name=" + this.f7451a + ", size=" + this.f7452b + ", compressionMethod=" + this.f7453c + ", isPartial=" + this.f7454d + ", isEndOfArchive=" + this.f7455e + ", headerBytes=" + Arrays.toString(this.f7456f) + "}";
    }
}
