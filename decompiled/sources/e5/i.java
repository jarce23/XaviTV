package e5;

import app.shamel.tv.models.ResumeModel;
import app.shamel.tv.models.ResumeSeriesModel;
import java.util.Iterator;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements Callback {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4596o;

    /* renamed from: p, reason: collision with root package name */
    public final List f4597p;

    /* renamed from: q, reason: collision with root package name */
    public final List f4598q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ k f4599r;

    public /* synthetic */ i(k kVar, List list, List list2, int i10) {
        this.f4596o = i10;
        this.f4599r = kVar;
        this.f4597p = list;
        this.f4598q = list2;
    }

    @Override // retrofit2.Callback
    public final void onFailure(Call call, Throwable th) {
        switch (this.f4596o) {
            case 0:
                k kVar = this.f4599r;
                if (!kVar.Y) {
                    int i10 = kVar.Z;
                    if (i10 < 2) {
                        kVar.Z = i10 + 1;
                        kVar.A();
                        break;
                    } else {
                        kVar.D();
                        break;
                    }
                }
                break;
            case 1:
                k kVar2 = this.f4599r;
                if (!kVar2.Y) {
                    int i11 = kVar2.Z;
                    if (i11 < 2) {
                        kVar2.Z = i11 + 1;
                        kVar2.F();
                        break;
                    } else {
                        kVar2.E();
                        break;
                    }
                }
                break;
            default:
                k kVar3 = this.f4599r;
                if (!kVar3.Y) {
                    int i12 = kVar3.Z;
                    if (i12 < 2) {
                        kVar3.Z = i12 + 1;
                        kVar3.I();
                        break;
                    } else {
                        kVar3.w(true);
                        break;
                    }
                }
                break;
        }
    }

    @Override // retrofit2.Callback
    public final void onResponse(Call call, Response response) {
        switch (this.f4596o) {
            case 0:
                Object body = response.body();
                k kVar = this.f4599r;
                if (body != null) {
                    kVar.Z = 0;
                    if (((List) response.body()).size() > 0) {
                        kVar.U.P(new g(response, 0));
                        List list = this.f4597p;
                        if (!list.isEmpty()) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                kVar.U.P(new h(it, 0));
                            }
                        }
                        List list2 = this.f4598q;
                        if (!list2.isEmpty()) {
                            Iterator it2 = list2.iterator();
                            while (it2.hasNext()) {
                                kVar.U.P(new h(it2, 1));
                            }
                        }
                        if (!kVar.Y) {
                            kVar.K();
                            break;
                        }
                    } else {
                        kVar.D();
                        break;
                    }
                } else if (!kVar.Y) {
                    kVar.D();
                    break;
                }
                break;
            case 1:
                Object body2 = response.body();
                k kVar2 = this.f4599r;
                if (body2 != null) {
                    kVar2.Z = 0;
                    kVar2.U.P(new g(response, 2));
                    List list3 = this.f4597p;
                    if (!list3.isEmpty()) {
                        Iterator it3 = list3.iterator();
                        while (it3.hasNext()) {
                            kVar2.U.P(new h(it3, 4));
                        }
                    }
                    List list4 = this.f4598q;
                    if (!list4.isEmpty()) {
                        Iterator it4 = list4.iterator();
                        while (it4.hasNext()) {
                            kVar2.U.P(new d((ResumeModel) it4.next(), 1));
                        }
                    }
                }
                if (!kVar2.Y) {
                    kVar2.E();
                    break;
                }
                break;
            default:
                Object body3 = response.body();
                k kVar3 = this.f4599r;
                if (body3 != null) {
                    kVar3.U.P(new g(response, 4));
                    List list5 = this.f4597p;
                    if (!list5.isEmpty()) {
                        Iterator it5 = list5.iterator();
                        while (it5.hasNext()) {
                            kVar3.U.P(new h(it5, 6));
                        }
                    }
                    List list6 = this.f4598q;
                    if (!list6.isEmpty()) {
                        Iterator it6 = list6.iterator();
                        while (it6.hasNext()) {
                            kVar3.U.Q(new e((ResumeSeriesModel) it6.next(), 2), null);
                        }
                    }
                }
                if (!kVar3.Y) {
                    kVar3.w(true);
                    break;
                }
                break;
        }
    }
}
