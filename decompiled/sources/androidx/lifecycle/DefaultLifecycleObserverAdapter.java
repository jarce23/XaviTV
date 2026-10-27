package androidx.lifecycle;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements p {

    /* renamed from: o, reason: collision with root package name */
    public final d f1103o;

    /* renamed from: p, reason: collision with root package name */
    public final p f1104p;

    public DefaultLifecycleObserverAdapter(d dVar, p pVar) {
        this.f1103o = dVar;
        this.f1104p = pVar;
    }

    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) {
        int i10 = e.f1125a[lVar.ordinal()];
        if (i10 == 3) {
            this.f1103o.b();
        } else if (i10 == 7) {
            throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        p pVar = this.f1104p;
        if (pVar != null) {
            pVar.a(rVar, lVar);
        }
    }
}
