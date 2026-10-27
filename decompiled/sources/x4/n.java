package x4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public String f13567a;

    /* renamed from: b, reason: collision with root package name */
    public int f13568b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return za.h.a(this.f13567a, nVar.f13567a) && this.f13568b == nVar.f13568b;
    }

    public final int hashCode() {
        return s.e.b(this.f13568b) + (this.f13567a.hashCode() * 31);
    }

    public final String toString() {
        return "IdAndState(id=" + this.f13567a + ", state=" + android.support.v4.media.d.D(this.f13568b) + ')';
    }
}
