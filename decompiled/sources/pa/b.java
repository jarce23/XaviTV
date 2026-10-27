package pa;

import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements p {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f10142o;

    public /* synthetic */ b(int i10) {
        this.f10142o = i10;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        c cVar;
        switch (this.f10142o) {
            case 0:
                String str = (String) obj;
                g gVar = (g) obj2;
                za.h.e("acc", str);
                za.h.e("element", gVar);
                if (str.length() == 0) {
                    return gVar.toString();
                }
                return str + ", " + gVar;
            default:
                i iVar = (i) obj;
                g gVar2 = (g) obj2;
                za.h.e("acc", iVar);
                za.h.e("element", gVar2);
                i n10 = iVar.n(gVar2.getKey());
                j jVar = j.f10146o;
                if (n10 == jVar) {
                    return gVar2;
                }
                e eVar = e.f10145o;
                f fVar = (f) n10.s(eVar);
                if (fVar == null) {
                    cVar = new c(gVar2, n10);
                } else {
                    i n11 = n10.n(eVar);
                    if (n11 == jVar) {
                        return new c(fVar, gVar2);
                    }
                    cVar = new c(fVar, new c(gVar2, n11));
                }
                return cVar;
        }
    }
}
