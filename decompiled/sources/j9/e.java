package j9;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends k9.m {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f7255p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ i8.d f7256q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ k f7257r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(k kVar, i8.d dVar, int i10, i8.d dVar2) {
        super(dVar);
        this.f7255p = i10;
        this.f7256q = dVar2;
        this.f7257r = kVar;
    }

    @Override // k9.m
    public final void a() {
        k kVar = this.f7257r;
        try {
            k9.j jVar = kVar.f7323d.f7867m;
            String str = kVar.f7320a;
            int i10 = this.f7255p;
            Bundle bundle = new Bundle();
            bundle.putInt("session_id", i10);
            Bundle g = k.g();
            h hVar = new h(kVar, this.f7256q, 3);
            k9.h hVar2 = (k9.h) jVar;
            Parcel v10 = hVar2.v();
            v10.writeString(str);
            int i11 = k9.g.f7848a;
            v10.writeInt(1);
            bundle.writeToParcel(v10, 0);
            v10.writeInt(1);
            g.writeToParcel(v10, 0);
            v10.writeStrongBinder(hVar);
            hVar2.w(v10, 9);
        } catch (RemoteException e7) {
            k.g.g(e7, "notifySessionFailed", new Object[0]);
        }
    }
}
