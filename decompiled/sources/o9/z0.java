package o9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z0 extends j0 {

    /* renamed from: r, reason: collision with root package name */
    public final transient b1 f9698r;

    /* renamed from: s, reason: collision with root package name */
    public final transient a1 f9699s;

    public z0(b1 b1Var, a1 a1Var) {
        this.f9698r = b1Var;
        this.f9699s = a1Var;
    }

    @Override // o9.b0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f9698r.get(obj) != null;
    }

    @Override // o9.j0, o9.b0
    public final g0 f() {
        return this.f9699s;
    }

    @Override // o9.b0
    public final int g(int i10, Object[] objArr) {
        return this.f9699s.g(i10, objArr);
    }

    @Override // o9.b0
    public final boolean k() {
        return true;
    }

    @Override // o9.j0
    /* renamed from: p */
    public final k1 iterator() {
        return this.f9699s.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f9698r.f9584t;
    }
}
