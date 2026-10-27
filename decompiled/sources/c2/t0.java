package c2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2715a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2716b;

    public t0(int i10, boolean z10) {
        this.f2715a = i10;
        this.f2716b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t0.class != obj.getClass()) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return this.f2715a == t0Var.f2715a && this.f2716b == t0Var.f2716b;
    }

    public final int hashCode() {
        return (this.f2715a * 31) + (this.f2716b ? 1 : 0);
    }
}
