package r7;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x extends p {
    public final IBinder g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f10961h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(com.google.android.gms.common.internal.a aVar, int i10, IBinder iBinder, Bundle bundle) {
        super(aVar, i10, bundle);
        this.f10961h = aVar;
        this.g = iBinder;
    }

    @Override // r7.p
    public final boolean a() {
        IBinder iBinder = this.g;
        try {
            r.e(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            com.google.android.gms.common.internal.a aVar = this.f10961h;
            String k10 = aVar.k();
            g gVar = aVar.f3222o;
            if (!k10.equals(interfaceDescriptor)) {
                String k11 = aVar.k();
                StringBuilder sb2 = new StringBuilder(k11.length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb2.append("service descriptor mismatch: ");
                sb2.append(k11);
                sb2.append(" vs. ");
                sb2.append(interfaceDescriptor);
                Log.w("GmsClient", sb2.toString());
                return false;
            }
            IInterface c10 = aVar.c(iBinder);
            if (c10 == null || !(aVar.s(2, 4, c10) || aVar.s(3, 4, c10))) {
                return false;
            }
            aVar.f3228u = null;
            aVar.g();
            if (gVar == null) {
                return true;
            }
            ((o7.g) gVar.f10916a).G();
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    @Override // r7.p
    public final void b(n7.a aVar) {
        com.google.android.gms.common.internal.a aVar2 = this.f10961h;
        g gVar = aVar2.f3223p;
        if (gVar != null) {
            ((o7.h) gVar.f10916a).w(aVar);
        }
        aVar2.p(aVar);
    }
}
