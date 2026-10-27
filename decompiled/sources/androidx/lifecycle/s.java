package androidx.lifecycle;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public m f1154a;

    /* renamed from: b, reason: collision with root package name */
    public p f1155b;

    public final void a(r rVar, l lVar) {
        m a10 = lVar.a();
        m mVar = this.f1154a;
        za.h.e("state1", mVar);
        if (a10.compareTo(mVar) < 0) {
            mVar = a10;
        }
        this.f1154a = mVar;
        this.f1155b.a(rVar, lVar);
        this.f1154a = a10;
    }
}
