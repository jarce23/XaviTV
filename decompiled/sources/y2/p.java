package y2;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p extends j {

    /* renamed from: b, reason: collision with root package name */
    public final String f13805b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13806c;

    public p(String str, String str2, String str3) {
        super(str);
        this.f13805b = str2;
        this.f13806c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && p.class == obj.getClass()) {
            p pVar = (p) obj;
            if (this.f13791a.equals(pVar.f13791a) && Objects.equals(this.f13805b, pVar.f13805b) && Objects.equals(this.f13806c, pVar.f13806c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int g = android.support.v4.media.d.g(this.f13791a, 527, 31);
        String str = this.f13805b;
        int hashCode = (g + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13806c;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // y2.j
    public final String toString() {
        return this.f13791a + ": url=" + this.f13806c;
    }
}
