package t4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11876a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11877b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11878c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11879d;

    public d(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f11876a = z10;
        this.f11877b = z11;
        this.f11878c = z12;
        this.f11879d = z13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f11876a == dVar.f11876a && this.f11877b == dVar.f11877b && this.f11878c == dVar.f11878c && this.f11879d == dVar.f11879d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        boolean z10 = this.f11876a;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = i10 * 31;
        boolean z11 = this.f11877b;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z12 = this.f11878c;
        int i14 = z12;
        if (z12 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z13 = this.f11879d;
        return i15 + (z13 ? 1 : z13 ? 1 : 0);
    }

    public final String toString() {
        return "NetworkState(isConnected=" + this.f11876a + ", isValidated=" + this.f11877b + ", isMetered=" + this.f11878c + ", isNotRoaming=" + this.f11879d + ')';
    }
}
