package l1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8104a;

    /* renamed from: b, reason: collision with root package name */
    public ea.a f8105b = new ea.a(1);

    /* renamed from: c, reason: collision with root package name */
    public boolean f8106c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8107d;

    public o(Object obj) {
        this.f8104a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        return this.f8104a.equals(((o) obj).f8104a);
    }

    public final int hashCode() {
        return this.f8104a.hashCode();
    }
}
