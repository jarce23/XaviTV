package x4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f13557a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13558b;

    public j(String str, int i10) {
        za.h.e("workSpecId", str);
        this.f13557a = str;
        this.f13558b = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return za.h.a(this.f13557a, jVar.f13557a) && this.f13558b == jVar.f13558b;
    }

    public final int hashCode() {
        return (this.f13557a.hashCode() * 31) + this.f13558b;
    }

    public final String toString() {
        return "WorkGenerationalId(workSpecId=" + this.f13557a + ", generation=" + this.f13558b + ')';
    }
}
