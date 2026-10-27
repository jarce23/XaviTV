package y2;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends j {

    /* renamed from: b, reason: collision with root package name */
    public final String f13779b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13780c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13781d;

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f13779b = str;
        this.f13780c = str2;
        this.f13781d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (Objects.equals(this.f13780c, eVar.f13780c) && Objects.equals(this.f13779b, eVar.f13779b) && Objects.equals(this.f13781d, eVar.f13781d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f13779b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13780c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f13781d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // y2.j
    public final String toString() {
        return this.f13791a + ": language=" + this.f13779b + ", description=" + this.f13780c + ", text=" + this.f13781d;
    }
}
