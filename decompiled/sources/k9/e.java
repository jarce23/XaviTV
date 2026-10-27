package k9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements f {

    /* renamed from: q, reason: collision with root package name */
    public static final Object f7845q = new Object();

    /* renamed from: o, reason: collision with root package name */
    public volatile f f7846o;

    /* renamed from: p, reason: collision with root package name */
    public volatile Object f7847p = f7845q;

    public e(f fVar) {
        this.f7846o = fVar;
    }

    public static e a(f fVar) {
        return fVar instanceof e ? (e) fVar : new e(fVar);
    }

    @Override // k9.f
    public final Object c() {
        Object obj = this.f7847p;
        Object obj2 = f7845q;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            try {
                Object obj3 = this.f7847p;
                if (obj3 != obj2) {
                    return obj3;
                }
                Object c10 = this.f7846o.c();
                Object obj4 = this.f7847p;
                if (obj4 != obj2 && obj4 != c10) {
                    throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + c10 + ". This is likely due to a circular dependency.");
                }
                this.f7847p = c10;
                this.f7846o = null;
                return c10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
