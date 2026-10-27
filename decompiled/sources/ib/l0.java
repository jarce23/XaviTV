package ib;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 implements m0 {

    /* renamed from: a, reason: collision with root package name */
    public final ya.l f6576a;

    public l0(ya.l lVar) {
        this.f6576a = lVar;
    }

    @Override // ib.m0
    public final void d(Throwable th) {
        this.f6576a.invoke(th);
    }

    public final String toString() {
        return "InternalCompletionHandler.UserSupplied[" + this.f6576a.getClass().getSimpleName() + '@' + v.b(this) + ']';
    }
}
