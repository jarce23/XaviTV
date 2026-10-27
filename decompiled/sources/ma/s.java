package ma;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final int f9054a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9055b;

    public s(int i10, Object obj) {
        this.f9054a = i10;
        this.f9055b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f9054a == sVar.f9054a && za.h.a(this.f9055b, sVar.f9055b);
    }

    public final int hashCode() {
        int i10 = this.f9054a * 31;
        Object obj = this.f9055b;
        return i10 + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f9054a + ", value=" + this.f9055b + ')';
    }
}
