package o9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c1 extends j0 {

    /* renamed from: w, reason: collision with root package name */
    public static final Object[] f9591w;

    /* renamed from: x, reason: collision with root package name */
    public static final c1 f9592x;

    /* renamed from: r, reason: collision with root package name */
    public final transient Object[] f9593r;

    /* renamed from: s, reason: collision with root package name */
    public final transient int f9594s;

    /* renamed from: t, reason: collision with root package name */
    public final transient Object[] f9595t;

    /* renamed from: u, reason: collision with root package name */
    public final transient int f9596u;

    /* renamed from: v, reason: collision with root package name */
    public final transient int f9597v;

    static {
        Object[] objArr = new Object[0];
        f9591w = objArr;
        f9592x = new c1(0, 0, 0, objArr, objArr);
    }

    public c1(int i10, int i11, int i12, Object[] objArr, Object[] objArr2) {
        this.f9593r = objArr;
        this.f9594s = i10;
        this.f9595t = objArr2;
        this.f9596u = i11;
        this.f9597v = i12;
    }

    @Override // o9.b0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f9595t;
            if (objArr.length != 0) {
                int n10 = q.n(obj);
                while (true) {
                    int i10 = n10 & this.f9596u;
                    Object obj2 = objArr[i10];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    n10 = i10 + 1;
                }
            }
        }
        return false;
    }

    @Override // o9.b0
    public final int g(int i10, Object[] objArr) {
        Object[] objArr2 = this.f9593r;
        int i11 = this.f9597v;
        System.arraycopy(objArr2, 0, objArr, i10, i11);
        return i10 + i11;
    }

    @Override // o9.b0
    public final Object[] h() {
        return this.f9593r;
    }

    @Override // o9.j0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f9594s;
    }

    @Override // o9.b0
    public final int i() {
        return this.f9597v;
    }

    @Override // o9.b0
    public final int j() {
        return 0;
    }

    @Override // o9.b0
    public final boolean k() {
        return false;
    }

    @Override // o9.j0
    public final g0 o() {
        return g0.l(this.f9597v, this.f9593r);
    }

    @Override // o9.j0
    /* renamed from: p */
    public final k1 iterator() {
        return f().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f9597v;
    }
}
