package ib;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements pa.h {

    /* renamed from: o, reason: collision with root package name */
    public final za.i f6584o;

    /* renamed from: p, reason: collision with root package name */
    public final pa.h f6585p;

    /* JADX WARN: Multi-variable type inference failed */
    public p(pa.h hVar, ya.l lVar) {
        za.h.e("baseKey", hVar);
        this.f6584o = (za.i) lVar;
        this.f6585p = hVar instanceof p ? ((p) hVar).f6585p : hVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [ya.l, za.i] */
    public final pa.g a(q qVar) {
        return (pa.g) this.f6584o.invoke(qVar);
    }
}
