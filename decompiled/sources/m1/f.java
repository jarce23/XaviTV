package m1;

import i1.c0;
import i1.e0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f8760a;

    /* renamed from: b, reason: collision with root package name */
    public final float f8761b;

    public f(float f10, float f11) {
        l1.d.a("Invalid latitude or longitude", f10 >= -90.0f && f10 <= 90.0f && f11 >= -180.0f && f11 <= 180.0f);
        this.f8760a = f10;
        this.f8761b = f11;
    }

    @Override // i1.e0
    public final /* synthetic */ i1.p a() {
        return null;
    }

    @Override // i1.e0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f8760a == fVar.f8760a && this.f8761b == fVar.f8761b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.valueOf(this.f8761b).hashCode() + ((Float.valueOf(this.f8760a).hashCode() + 527) * 31);
    }

    public final String toString() {
        return "xyz: latitude=" + this.f8760a + ", longitude=" + this.f8761b;
    }

    @Override // i1.e0
    public final /* synthetic */ void c(c0 c0Var) {
    }
}
