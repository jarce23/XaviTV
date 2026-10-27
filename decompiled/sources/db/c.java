package db;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: r, reason: collision with root package name */
    public static final c f4357r = new c(1, 0, 1);

    @Override // db.a
    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (isEmpty() && ((c) obj).isEmpty()) {
            return true;
        }
        c cVar = (c) obj;
        return this.f4350o == cVar.f4350o && this.f4351p == cVar.f4351p;
    }

    @Override // db.a
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f4350o * 31) + this.f4351p;
    }

    @Override // db.a
    public final boolean isEmpty() {
        return this.f4350o > this.f4351p;
    }

    @Override // db.a
    public final String toString() {
        return this.f4350o + ".." + this.f4351p;
    }
}
