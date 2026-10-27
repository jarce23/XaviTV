package i1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final n f5919a;

    public l0(n nVar) {
        this.f5919a = nVar;
    }

    public final boolean a(int... iArr) {
        for (int i10 : iArr) {
            if (this.f5919a.f5920a.get(i10)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l0) {
            return this.f5919a.equals(((l0) obj).f5919a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5919a.hashCode();
    }
}
