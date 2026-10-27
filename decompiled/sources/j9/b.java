package j9;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends k9.m {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f7220p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ i8.d f7221q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f7222r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Object f7223s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(k kVar, i8.d dVar, Object obj, i8.d dVar2, int i10) {
        super(dVar);
        this.f7220p = i10;
        this.f7223s = obj;
        this.f7221q = dVar2;
        this.f7222r = kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k9.m
    public final void a() {
        boolean z10 = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        switch (this.f7220p) {
            case 0:
                k kVar = (k) this.f7222r;
                List<String> list = (List) this.f7223s;
                ArrayList arrayList = new ArrayList(list.size());
                for (String str : list) {
                    Bundle bundle = new Bundle();
                    bundle.putString("module_name", str);
                    arrayList.add(bundle);
                }
                try {
                    k9.j jVar = kVar.f7323d.f7867m;
                    String str2 = kVar.f7320a;
                    Bundle g = k.g();
                    h hVar = new h(kVar, this.f7221q, objArr == true ? 1 : 0);
                    k9.h hVar2 = (k9.h) jVar;
                    Parcel v10 = hVar2.v();
                    v10.writeString(str2);
                    v10.writeTypedList(arrayList);
                    int i10 = k9.g.f7848a;
                    v10.writeInt(1);
                    g.writeToParcel(v10, 0);
                    v10.writeStrongBinder(hVar);
                    hVar2.w(v10, 14);
                    return;
                } catch (RemoteException e7) {
                    k.g.g(e7, "cancelDownloads(%s)", list);
                    return;
                }
            case 1:
                i8.d dVar = this.f7221q;
                k kVar2 = (k) this.f7222r;
                try {
                    k9.j jVar2 = kVar2.f7323d.f7867m;
                    String str3 = kVar2.f7320a;
                    Bundle i11 = k.i((HashMap) this.f7223s);
                    i iVar = new i(kVar2, dVar, objArr2 == true ? 1 : 0);
                    k9.h hVar3 = (k9.h) jVar2;
                    Parcel v11 = hVar3.v();
                    v11.writeString(str3);
                    int i12 = k9.g.f7848a;
                    v11.writeInt(1);
                    i11.writeToParcel(v11, 0);
                    v11.writeStrongBinder(iVar);
                    hVar3.w(v11, 5);
                    return;
                } catch (RemoteException e8) {
                    k.g.g(e8, "syncPacks", new Object[0]);
                    dVar.c(new RuntimeException(e8));
                    return;
                }
            default:
                synchronized (((k9.q) this.f7222r).f7861f) {
                    try {
                        k9.q qVar = (k9.q) this.f7222r;
                        i8.d dVar2 = this.f7221q;
                        qVar.f7860e.add(dVar2);
                        dVar2.f6520a.i(new x4.l(qVar, dVar2, z10));
                        if (((k9.q) this.f7222r).f7865k.getAndIncrement() > 0) {
                            ((k9.q) this.f7222r).f7857b.h("Already connected to the service.", new Object[0]);
                        }
                        k9.q.b((k9.q) this.f7222r, (k9.m) this.f7223s);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(k9.q qVar, i8.d dVar, i8.d dVar2, k9.m mVar) {
        super(dVar);
        this.f7220p = 2;
        this.f7221q = dVar2;
        this.f7223s = mVar;
        this.f7222r = qVar;
    }
}
