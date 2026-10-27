package o4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s extends n4.a {

    /* renamed from: t, reason: collision with root package name */
    public final Throwable f9517t;

    public s(Throwable th) {
        super(10);
        this.f9517t = th;
    }

    @Override // n4.a
    public final String toString() {
        return "FAILURE (" + this.f9517t.getMessage() + ")";
    }
}
