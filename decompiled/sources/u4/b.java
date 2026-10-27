package u4;

import za.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends i implements ya.a {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ d f12515p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ c f12516q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, c cVar) {
        super(0);
        this.f12515p = dVar;
        this.f12516q = cVar;
    }

    @Override // ya.a
    public final Object invoke() {
        v4.f fVar = this.f12515p.f12519a;
        c cVar = this.f12516q;
        fVar.getClass();
        synchronized (fVar.f12669c) {
            if (fVar.f12670d.remove(cVar) && fVar.f12670d.isEmpty()) {
                fVar.d();
            }
        }
        return la.i.f8335a;
    }
}
