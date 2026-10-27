package kb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final k f7914b = new k();

    /* renamed from: a, reason: collision with root package name */
    public final Object f7915a;

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return za.h.a(this.f7915a, ((l) obj).f7915a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f7915a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f7915a;
        if (obj instanceof j) {
            return ((j) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
