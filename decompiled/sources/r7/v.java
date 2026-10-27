package r7;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v extends c8.h {

    /* renamed from: c, reason: collision with root package name */
    public com.google.android.gms.common.internal.a f10957c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10958d;

    public v(com.google.android.gms.common.internal.a aVar, int i10) {
        super("com.google.android.gms.common.internal.IGmsCallbacks", 0);
        this.f10957c = aVar;
        this.f10958d = i10;
    }

    @Override // c8.h
    public final boolean x0(int i10, Parcel parcel, Parcel parcel2) {
        if (i10 == 1) {
            int readInt = parcel.readInt();
            IBinder readStrongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) c8.i.a(parcel, Bundle.CREATOR);
            c8.i.c(parcel);
            r.f("onPostInitComplete can be called only once per call to getRemoteService", this.f10957c);
            this.f10957c.q(readInt, readStrongBinder, bundle, this.f10958d);
            this.f10957c = null;
        } else if (i10 == 2) {
            parcel.readInt();
            c8.i.c(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i10 != 3) {
                return false;
            }
            int readInt2 = parcel.readInt();
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            z zVar = (z) c8.i.a(parcel, z.CREATOR);
            c8.i.c(parcel);
            com.google.android.gms.common.internal.a aVar = this.f10957c;
            r.f("onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService", aVar);
            r.e(zVar);
            aVar.f3230w = zVar;
            if (aVar.r()) {
                c cVar = zVar.f10965r;
                g b2 = g.b();
                h hVar = cVar == null ? null : cVar.f10878o;
                synchronized (b2) {
                    if (hVar == null) {
                        hVar = g.f10915c;
                    } else {
                        h hVar2 = (h) b2.f10916a;
                        if (hVar2 != null) {
                            if (hVar2.f10917o < hVar.f10917o) {
                            }
                        }
                    }
                    b2.f10916a = hVar;
                }
            }
            Bundle bundle2 = zVar.f10962o;
            r.f("onPostInitComplete can be called only once per call to getRemoteService", this.f10957c);
            this.f10957c.q(readInt2, readStrongBinder2, bundle2, this.f10958d);
            this.f10957c = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
