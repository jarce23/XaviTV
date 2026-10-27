package r7;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final int f10959a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f10960b;

    public w(com.google.android.gms.common.internal.a aVar, int i10) {
        this.f10960b = aVar;
        this.f10959a = i10;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.common.internal.a aVar = this.f10960b;
        if (iBinder == null) {
            aVar.t();
            return;
        }
        synchronized (aVar.f3215h) {
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                aVar.f3216i = (queryLocalInterface == null || !(queryLocalInterface instanceof q)) ? new q(iBinder) : (q) queryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.common.internal.a aVar2 = this.f10960b;
        int i10 = this.f10959a;
        aVar2.getClass();
        y yVar = new y(aVar2, 0, null);
        u uVar = aVar2.f3214f;
        uVar.sendMessage(uVar.obtainMessage(7, i10, -1, yVar));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.common.internal.a aVar = this.f10960b;
        synchronized (aVar.f3215h) {
            aVar.f3216i = null;
        }
        com.google.android.gms.common.internal.a aVar2 = this.f10960b;
        int i10 = this.f10959a;
        u uVar = aVar2.f3214f;
        uVar.sendMessage(uVar.obtainMessage(6, i10, 1));
    }
}
