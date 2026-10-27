package za;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Class f14174a;

    public j(Class cls) {
        this.f14174a = cls;
    }

    @Override // za.c
    public final Class a() {
        return this.f14174a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return h.a(this.f14174a, ((j) obj).f14174a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f14174a.hashCode();
    }

    public final String toString() {
        return this.f14174a.toString() + " (Kotlin reflection is not available)";
    }
}
