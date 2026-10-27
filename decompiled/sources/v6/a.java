package v6;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements ka.a, u6.a {

    /* renamed from: q, reason: collision with root package name */
    public static final Object f12686q = new Object();

    /* renamed from: o, reason: collision with root package name */
    public volatile b f12687o;

    /* renamed from: p, reason: collision with root package name */
    public volatile Object f12688p = f12686q;

    public a(b bVar) {
        this.f12687o = bVar;
    }

    public static ka.a a(b bVar) {
        return bVar instanceof a ? bVar : new a(bVar);
    }

    @Override // ka.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f12688p;
        Object obj3 = f12686q;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f12688p;
                if (obj == obj3) {
                    obj = this.f12687o.get();
                    Object obj4 = this.f12688p;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f12688p = obj;
                    this.f12687o = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
