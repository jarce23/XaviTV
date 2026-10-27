package w3;

import java.util.Collection;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f13005a;

    public /* synthetic */ s(w wVar) {
        this.f13005a = wVar;
    }

    public void a(l lVar, i iVar, Collection collection) {
        w wVar = this.f13005a;
        if (lVar != wVar.f13051w || iVar == null) {
            if (lVar == wVar.f13049u) {
                if (iVar != null) {
                    wVar.o(wVar.f13048t, iVar);
                }
                wVar.f13048t.n(collection);
                return;
            }
            return;
        }
        y yVar = wVar.f13050v.f13069a;
        String d6 = iVar.d();
        z zVar = new z(yVar, d6, wVar.b(yVar, d6));
        zVar.i(iVar);
        if (wVar.f13048t == zVar) {
            return;
        }
        wVar.h(wVar, zVar, wVar.f13051w, 3, wVar.f13050v, collection);
        wVar.f13050v = null;
        wVar.f13051w = null;
    }
}
