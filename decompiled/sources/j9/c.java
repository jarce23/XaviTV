package j9;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends k9.m {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f7233p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f7234q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ String f7235r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ String f7236s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ int f7237t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ i8.d f7238u;

    /* renamed from: v, reason: collision with root package name */
    public final /* synthetic */ k f7239v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(k kVar, i8.d dVar, int i10, String str, String str2, int i11, i8.d dVar2, int i12) {
        super(dVar);
        this.f7233p = i12;
        this.f7234q = i10;
        this.f7235r = str;
        this.f7236s = str2;
        this.f7237t = i11;
        this.f7238u = dVar2;
        this.f7239v = kVar;
    }

    @Override // k9.m
    public final void a() {
        char c10;
        k9.j jVar;
        String str;
        int i10 = this.f7233p;
        k kVar = this.f7239v;
        int i11 = this.f7234q;
        String str2 = this.f7235r;
        String str3 = this.f7236s;
        int i12 = this.f7237t;
        i8.d dVar = this.f7238u;
        int i13 = 1;
        switch (i10) {
            case 0:
                int i14 = 2;
                try {
                    k9.j jVar2 = kVar.f7323d.f7867m;
                    String str4 = kVar.f7320a;
                    Bundle bundle = new Bundle();
                    bundle.putInt("session_id", i11);
                    bundle.putString("module_name", str2);
                    bundle.putString("slice_id", str3);
                    bundle.putInt("chunk_number", i12);
                    Bundle g = k.g();
                    h hVar = new h(kVar, dVar, i14);
                    k9.h hVar2 = (k9.h) jVar2;
                    Parcel v10 = hVar2.v();
                    v10.writeString(str4);
                    int i15 = k9.g.f7848a;
                    v10.writeInt(1);
                    bundle.writeToParcel(v10, 0);
                    v10.writeInt(1);
                    g.writeToParcel(v10, 0);
                    v10.writeStrongBinder(hVar);
                    hVar2.w(v10, 6);
                    break;
                } catch (RemoteException e7) {
                    k.g.g(e7, "notifyChunkTransferred", new Object[0]);
                }
            default:
                try {
                    jVar = kVar.f7323d.f7867m;
                    str = kVar.f7320a;
                    c10 = 2;
                } catch (RemoteException e8) {
                    e = e8;
                    c10 = 2;
                }
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("session_id", i11);
                    bundle2.putString("module_name", str2);
                    bundle2.putString("slice_id", str3);
                    bundle2.putInt("chunk_number", i12);
                    Bundle g6 = k.g();
                    h hVar3 = new h(kVar, dVar, i13);
                    k9.h hVar4 = (k9.h) jVar;
                    Parcel v11 = hVar4.v();
                    v11.writeString(str);
                    int i16 = k9.g.f7848a;
                    v11.writeInt(1);
                    bundle2.writeToParcel(v11, 0);
                    v11.writeInt(1);
                    g6.writeToParcel(v11, 0);
                    v11.writeStrongBinder(hVar3);
                    hVar4.w(v11, 11);
                    break;
                } catch (RemoteException e10) {
                    e = e10;
                    androidx.emoji2.text.s sVar = k.g;
                    Integer valueOf = Integer.valueOf(i12);
                    Integer valueOf2 = Integer.valueOf(i11);
                    Object[] objArr = new Object[4];
                    objArr[0] = str2;
                    objArr[1] = str3;
                    objArr[c10] = valueOf;
                    objArr[3] = valueOf2;
                    sVar.f("getChunkFileDescriptor(%s, %s, %d, session=%d)", objArr);
                    dVar.c(new RuntimeException(e));
                    return;
                }
        }
    }
}
