package x4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f13548a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13549b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13550c;

    public g(String str, int i10, int i11) {
        za.h.e("workSpecId", str);
        this.f13548a = str;
        this.f13549b = i10;
        this.f13550c = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return za.h.a(this.f13548a, gVar.f13548a) && this.f13549b == gVar.f13549b && this.f13550c == gVar.f13550c;
    }

    public final int hashCode() {
        return (((this.f13548a.hashCode() * 31) + this.f13549b) * 31) + this.f13550c;
    }

    public final String toString() {
        return "SystemIdInfo(workSpecId=" + this.f13548a + ", generation=" + this.f13549b + ", systemId=" + this.f13550c + ')';
    }
}
