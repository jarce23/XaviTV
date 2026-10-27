package l4;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o extends n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p.e f8247a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f8248b;

    public o(p pVar, p.e eVar) {
        this.f8248b = pVar;
        this.f8247a = eVar;
    }

    @Override // l4.k
    public final void g(m mVar) {
        ((ArrayList) this.f8247a.get(this.f8248b.f8250p)).remove(mVar);
        mVar.w(this);
    }
}
