package gb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f5461a;

    /* renamed from: b, reason: collision with root package name */
    public final db.c f5462b;

    public d(String str, db.c cVar) {
        this.f5461a = str;
        this.f5462b = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return za.h.a(this.f5461a, dVar.f5461a) && za.h.a(this.f5462b, dVar.f5462b);
    }

    public final int hashCode() {
        return this.f5462b.hashCode() + (this.f5461a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.f5461a + ", range=" + this.f5462b + ')';
    }
}
