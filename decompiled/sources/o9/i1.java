package o9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i1 extends j0 {

    /* renamed from: r, reason: collision with root package name */
    public final transient Object f9623r;

    public i1(Object obj) {
        obj.getClass();
        this.f9623r = obj;
    }

    @Override // o9.b0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f9623r.equals(obj);
    }

    @Override // o9.j0, o9.b0
    public final g0 f() {
        return g0.r(this.f9623r);
    }

    @Override // o9.b0
    public final int g(int i10, Object[] objArr) {
        objArr[i10] = this.f9623r;
        return i10 + 1;
    }

    @Override // o9.j0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f9623r.hashCode();
    }

    @Override // o9.b0
    public final boolean k() {
        return false;
    }

    @Override // o9.j0
    /* renamed from: p */
    public final k1 iterator() {
        return new m0(this.f9623r);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.f9623r.toString() + ']';
    }
}
