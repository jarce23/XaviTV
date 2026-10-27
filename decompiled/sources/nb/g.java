package nb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends RuntimeException {

    /* renamed from: o, reason: collision with root package name */
    public final transient pa.i f9317o;

    public g(pa.i iVar) {
        this.f9317o = iVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f9317o.toString();
    }
}
