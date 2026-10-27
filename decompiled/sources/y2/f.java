package y2;

import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends j {

    /* renamed from: b, reason: collision with root package name */
    public final String f13782b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13783c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13784d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f13785e;

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f13782b = str;
        this.f13783c = str2;
        this.f13784d = str3;
        this.f13785e = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (Objects.equals(this.f13782b, fVar.f13782b) && Objects.equals(this.f13783c, fVar.f13783c) && Objects.equals(this.f13784d, fVar.f13784d) && Arrays.equals(this.f13785e, fVar.f13785e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f13782b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13783c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f13784d;
        return Arrays.hashCode(this.f13785e) + ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @Override // y2.j
    public final String toString() {
        return this.f13791a + ": mimeType=" + this.f13782b + ", filename=" + this.f13783c + ", description=" + this.f13784d;
    }
}
