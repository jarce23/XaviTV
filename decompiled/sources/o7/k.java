package o7;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends UnsupportedOperationException {

    /* renamed from: o, reason: collision with root package name */
    public final n7.c f9559o;

    public k(n7.c cVar) {
        this.f9559o = cVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.f9559o));
    }
}
