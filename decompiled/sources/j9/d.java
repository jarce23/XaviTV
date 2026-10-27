package j9;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends k9.m {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f7243p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ String f7244q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ i8.d f7245r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ int f7246s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ k f7247t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(k kVar, i8.d dVar, int i10, String str, i8.d dVar2, int i11) {
        super(dVar);
        this.f7243p = i10;
        this.f7244q = str;
        this.f7245r = dVar2;
        this.f7246s = i11;
        this.f7247t = kVar;
    }

    @Override // k9.m
    public final void a() {
        k kVar = this.f7247t;
        try {
            k9.j jVar = kVar.f7323d.f7867m;
            String str = kVar.f7320a;
            int i10 = this.f7243p;
            String str2 = this.f7244q;
            Bundle bundle = new Bundle();
            bundle.putInt("session_id", i10);
            bundle.putString("module_name", str2);
            Bundle g = k.g();
            j jVar2 = new j(kVar, this.f7245r, this.f7243p, this.f7244q, this.f7246s);
            k9.h hVar = (k9.h) jVar;
            Parcel v10 = hVar.v();
            v10.writeString(str);
            int i11 = k9.g.f7848a;
            v10.writeInt(1);
            bundle.writeToParcel(v10, 0);
            v10.writeInt(1);
            g.writeToParcel(v10, 0);
            v10.writeStrongBinder(jVar2);
            hVar.w(v10, 7);
        } catch (RemoteException e7) {
            k.g.g(e7, "notifyModuleCompleted", new Object[0]);
        }
    }
}
