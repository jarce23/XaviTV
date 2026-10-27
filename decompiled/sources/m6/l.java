package m6;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public Class f9023a;

    /* renamed from: b, reason: collision with root package name */
    public Class f9024b;

    /* renamed from: c, reason: collision with root package name */
    public Class f9025c;

    public l(Class cls, Class cls2, Class cls3) {
        this.f9023a = cls;
        this.f9024b = cls2;
        this.f9025c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f9023a.equals(lVar.f9023a) && this.f9024b.equals(lVar.f9024b) && n.b(this.f9025c, lVar.f9025c);
    }

    public final int hashCode() {
        int hashCode = (this.f9024b.hashCode() + (this.f9023a.hashCode() * 31)) * 31;
        Class cls = this.f9025c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f9023a + ", second=" + this.f9024b + '}';
    }
}
