package j9;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends k9.m {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f7263p = 0;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f7264q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f7265r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(k kVar, i8.d dVar, i8.d dVar2) {
        super(dVar);
        this.f7264q = dVar2;
        this.f7265r = kVar;
    }

    @Override // k9.m
    public final void a() {
        k9.j hVar;
        int i10 = this.f7263p;
        Object obj = this.f7264q;
        Object obj2 = this.f7265r;
        int i11 = 0;
        switch (i10) {
            case 0:
                k kVar = (k) obj2;
                try {
                    k9.j jVar = kVar.f7324e.f7867m;
                    String str = kVar.f7320a;
                    Bundle g = k.g();
                    i iVar = new i(kVar, (i8.d) obj, 1);
                    k9.h hVar2 = (k9.h) jVar;
                    Parcel v10 = hVar2.v();
                    v10.writeString(str);
                    int i12 = k9.g.f7848a;
                    v10.writeInt(1);
                    g.writeToParcel(v10, 0);
                    v10.writeStrongBinder(iVar);
                    hVar2.w(v10, 10);
                    break;
                } catch (RemoteException e7) {
                    k.g.g(e7, "keepAlive", new Object[0]);
                    return;
                }
            default:
                k9.q qVar = ((k9.p) obj2).f7854a;
                IBinder iBinder = (IBinder) obj;
                int i13 = k9.i.f7849c;
                if (iBinder == null) {
                    hVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
                    hVar = queryLocalInterface instanceof k9.j ? (k9.j) queryLocalInterface : new k9.h(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService", 3);
                }
                qVar.f7867m = hVar;
                androidx.emoji2.text.s sVar = qVar.f7857b;
                sVar.h("linkToDeath", new Object[0]);
                try {
                    ((b8.a) qVar.f7867m).f2477c.linkToDeath(qVar.f7864j, 0);
                } catch (RemoteException e8) {
                    sVar.g(e8, "linkToDeath failed", new Object[0]);
                }
                qVar.g = false;
                ArrayList arrayList = qVar.f7859d;
                int size = arrayList.size();
                while (i11 < size) {
                    Object obj3 = arrayList.get(i11);
                    i11++;
                    ((Runnable) obj3).run();
                }
                qVar.f7859d.clear();
                break;
        }
    }

    public f(k9.p pVar, IBinder iBinder) {
        this.f7264q = iBinder;
        this.f7265r = pVar;
    }
}
