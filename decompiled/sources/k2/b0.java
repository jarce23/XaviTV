package k2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: c, reason: collision with root package name */
    public static final b0 f7687c = new b0(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f7688a;

    /* renamed from: b, reason: collision with root package name */
    public final long f7689b;

    public b0(long j10, long j11) {
        this.f7688a = j10;
        this.f7689b = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b0.class == obj.getClass()) {
            b0 b0Var = (b0) obj;
            if (this.f7688a == b0Var.f7688a && this.f7689b == b0Var.f7689b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f7688a) * 31) + ((int) this.f7689b);
    }

    public final String toString() {
        return "[timeUs=" + this.f7688a + ", position=" + this.f7689b + "]";
    }
}
