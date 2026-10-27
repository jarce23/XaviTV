package y2;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends j {

    /* renamed from: b, reason: collision with root package name */
    public final String f13793b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13794c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13795d;

    public l(String str, String str2, String str3) {
        super("----");
        this.f13793b = str;
        this.f13794c = str2;
        this.f13795d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (Objects.equals(this.f13794c, lVar.f13794c) && Objects.equals(this.f13793b, lVar.f13793b) && Objects.equals(this.f13795d, lVar.f13795d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f13793b;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f13794c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f13795d;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // y2.j
    public final String toString() {
        return this.f13791a + ": domain=" + this.f13793b + ", description=" + this.f13794c;
    }
}
