package e5;

import app.shamel.tv.models.ResumeModel;
import io.realm.n0;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements i5.c {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4577o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k f4578p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ n0 f4579q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ List f4580r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ List f4581s;

    public /* synthetic */ a(k kVar, n0 n0Var, List list, List list2, int i10) {
        this.f4577o = i10;
        this.f4578p = kVar;
        this.f4579q = n0Var;
        this.f4580r = list;
        this.f4581s = list2;
    }

    @Override // i5.c
    public final void c(Object obj) {
        List list = (List) obj;
        switch (this.f4577o) {
            case 0:
                int size = this.f4579q.size();
                int size2 = list.size();
                k kVar = this.f4578p;
                if (size != size2) {
                    kVar.U.P(new c(0, list));
                    List list2 = this.f4580r;
                    if (list2 != null && !list2.isEmpty()) {
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            kVar.U.P(new com.google.gson.internal.b((String) it.next(), 6));
                        }
                    }
                    List list3 = this.f4581s;
                    if (list3 != null && !list3.isEmpty()) {
                        Iterator it2 = list3.iterator();
                        while (it2.hasNext()) {
                            kVar.U.P(new d((ResumeModel) it2.next(), 0));
                        }
                    }
                }
                if (!kVar.Y) {
                    kVar.B(list);
                    break;
                }
                break;
            default:
                int size3 = this.f4579q.size();
                int size4 = list.size();
                k kVar2 = this.f4578p;
                if (size3 != size4) {
                    kVar2.U.P(new c(2, list));
                    List list4 = this.f4580r;
                    if (list4 != null && !list4.isEmpty()) {
                        Iterator it3 = list4.iterator();
                        while (it3.hasNext()) {
                            kVar2.U.P(new com.google.gson.internal.b((String) it3.next(), 8));
                        }
                    }
                    List list5 = this.f4581s;
                    if (list5 != null && !list5.isEmpty()) {
                        Iterator it4 = list5.iterator();
                        while (it4.hasNext()) {
                            kVar2.U.P(new com.google.gson.internal.b((String) it4.next(), 9));
                        }
                    }
                }
                if (!kVar2.Y) {
                    kVar2.z(list);
                    break;
                }
                break;
        }
    }
}
