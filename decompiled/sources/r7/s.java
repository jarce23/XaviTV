package r7;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s extends Exception {

    /* renamed from: o, reason: collision with root package name */
    public final n7.a f10954o;

    public s(n7.a aVar) {
        if (!((aVar.f9214p == 0 || aVar.f9215q == null) ? false : true)) {
            throw new IllegalArgumentException("ResolvableConnectionException can only be created with a connection result containing a resolution.");
        }
        this.f10954o = aVar;
    }
}
