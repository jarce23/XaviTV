package j0;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements l0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6920a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6921b;

    public /* synthetic */ f(int i10, Object obj) {
        this.f6920a = i10;
        this.f6921b = obj;
    }

    @Override // l0.a
    public final void accept(Object obj) {
        switch (this.f6920a) {
            case 0:
                g gVar = (g) obj;
                if (gVar == null) {
                    gVar = new g(-3);
                }
                ((x4.c) this.f6921b).W(gVar);
                return;
            default:
                g gVar2 = (g) obj;
                synchronized (h.f6926c) {
                    try {
                        p.i iVar = h.f6927d;
                        ArrayList arrayList = (ArrayList) iVar.get((String) this.f6921b);
                        if (arrayList == null) {
                            return;
                        }
                        iVar.remove((String) this.f6921b);
                        for (int i10 = 0; i10 < arrayList.size(); i10++) {
                            ((l0.a) arrayList.get(i10)).accept(gVar2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
