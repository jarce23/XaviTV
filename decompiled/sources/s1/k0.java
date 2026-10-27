package s1;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f11365a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11366b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11367c;

    public k0(j0 j0Var) {
        this.f11365a = j0Var.f11362a;
        this.f11366b = j0Var.f11363b;
        this.f11367c = j0Var.f11364c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return this.f11365a == k0Var.f11365a && this.f11366b == k0Var.f11366b && this.f11367c == k0Var.f11367c;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f11365a), Float.valueOf(this.f11366b), Long.valueOf(this.f11367c));
    }
}
