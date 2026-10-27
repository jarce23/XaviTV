package t4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final int f11875a;

    public b(int i10) {
        this.f11875a = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f11875a == ((b) obj).f11875a;
    }

    public final int hashCode() {
        return this.f11875a;
    }

    public final String toString() {
        return "ConstraintsNotMet(reason=" + this.f11875a + ')';
    }
}
