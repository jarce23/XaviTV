package x4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f13539a;

    /* renamed from: b, reason: collision with root package name */
    public final Long f13540b;

    public d(String str, Long l10) {
        this.f13539a = str;
        this.f13540b = l10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return za.h.a(this.f13539a, dVar.f13539a) && za.h.a(this.f13540b, dVar.f13540b);
    }

    public final int hashCode() {
        int hashCode = this.f13539a.hashCode() * 31;
        Long l10 = this.f13540b;
        return hashCode + (l10 == null ? 0 : l10.hashCode());
    }

    public final String toString() {
        return "Preference(key=" + this.f13539a + ", value=" + this.f13540b + ')';
    }
}
