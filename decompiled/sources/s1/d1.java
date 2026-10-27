package s1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d1 {

    /* renamed from: c, reason: collision with root package name */
    public static final d1 f11261c = new d1(0, false);

    /* renamed from: a, reason: collision with root package name */
    public final int f11262a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11263b;

    public d1(int i10, boolean z10) {
        this.f11262a = i10;
        this.f11263b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d1.class == obj.getClass()) {
            d1 d1Var = (d1) obj;
            if (this.f11262a == d1Var.f11262a && this.f11263b == d1Var.f11263b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f11262a << 1) + (this.f11263b ? 1 : 0);
    }
}
