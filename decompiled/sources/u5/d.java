package u5;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements h {

    /* renamed from: a, reason: collision with root package name */
    public final e f12529a;

    /* renamed from: b, reason: collision with root package name */
    public int f12530b;

    /* renamed from: c, reason: collision with root package name */
    public Class f12531c;

    public d(e eVar) {
        this.f12529a = eVar;
    }

    @Override // u5.h
    public final void a() {
        this.f12529a.i(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f12530b == dVar.f12530b && this.f12531c == dVar.f12531c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.f12530b * 31;
        Class cls = this.f12531c;
        return i10 + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "Key{size=" + this.f12530b + "array=" + this.f12531c + '}';
    }
}
