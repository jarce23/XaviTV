package h4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends RuntimeException {

    /* renamed from: o, reason: collision with root package name */
    public final int f5557o;

    /* renamed from: p, reason: collision with root package name */
    public final Throwable f5558p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i10, Throwable th) {
        super(th);
        r.a.h(i10, "callbackName");
        this.f5557o = i10;
        this.f5558p = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f5558p;
    }
}
