package com.google.android.gms.cast.framework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.d;
import com.google.android.gms.internal.cast.f;
import com.google.android.gms.internal.cast.u;
import h7.e;
import h7.i;
import h7.l;
import h7.s;
import h7.t;
import h7.v;
import h7.z;
import l7.b;
import r7.r;
import x7.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ReconnectionService extends Service {

    /* renamed from: p, reason: collision with root package name */
    public static final b f3168p = new b("ReconnectionService", null);

    /* renamed from: o, reason: collision with root package name */
    public v f3169o;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        v vVar = this.f3169o;
        if (vVar != null) {
            try {
                t tVar = (t) vVar;
                Parcel w02 = tVar.w0();
                u.c(w02, intent);
                Parcel x02 = tVar.x0(w02, 3);
                IBinder readStrongBinder = x02.readStrongBinder();
                x02.recycle();
                return readStrongBinder;
            } catch (RemoteException e7) {
                f3168p.a(e7, "Unable to call %s on %s.", "onBind", v.class.getSimpleName());
            }
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        a aVar;
        a aVar2;
        h7.b a10 = h7.b.a(this);
        a10.getClass();
        r.b();
        i iVar = a10.f5702c;
        iVar.getClass();
        v vVar = null;
        try {
            z zVar = iVar.f5747a;
            Parcel x02 = zVar.x0(zVar.w0(), 7);
            aVar = x7.b.y0(x02.readStrongBinder());
            x02.recycle();
        } catch (RemoteException e7) {
            i.f5746c.a(e7, "Unable to call %s on %s.", "getWrappedThis", z.class.getSimpleName());
            aVar = null;
        }
        r.b();
        l lVar = a10.f5703d;
        lVar.getClass();
        try {
            s sVar = lVar.f5751a;
            Parcel x03 = sVar.x0(sVar.w0(), 5);
            aVar2 = x7.b.y0(x03.readStrongBinder());
            x03.recycle();
        } catch (RemoteException e8) {
            l.f5750b.a(e8, "Unable to call %s on %s.", "getWrappedThis", s.class.getSimpleName());
            aVar2 = null;
        }
        b bVar = d.f3291a;
        if (aVar != null && aVar2 != null) {
            try {
                vVar = d.b(getApplicationContext()).B0(new x7.b(this), aVar, aVar2);
            } catch (RemoteException | e e10) {
                d.f3291a.a(e10, "Unable to call %s on %s.", "newReconnectionServiceImpl", f.class.getSimpleName());
            }
        }
        this.f3169o = vVar;
        if (vVar != null) {
            try {
                t tVar = (t) vVar;
                tVar.y0(tVar.w0(), 1);
            } catch (RemoteException e11) {
                f3168p.a(e11, "Unable to call %s on %s.", "onCreate", v.class.getSimpleName());
            }
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        v vVar = this.f3169o;
        if (vVar != null) {
            try {
                t tVar = (t) vVar;
                tVar.y0(tVar.w0(), 4);
            } catch (RemoteException e7) {
                f3168p.a(e7, "Unable to call %s on %s.", "onDestroy", v.class.getSimpleName());
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        v vVar = this.f3169o;
        if (vVar != null) {
            try {
                t tVar = (t) vVar;
                Parcel w02 = tVar.w0();
                u.c(w02, intent);
                w02.writeInt(i10);
                w02.writeInt(i11);
                Parcel x02 = tVar.x0(w02, 2);
                int readInt = x02.readInt();
                x02.recycle();
                return readInt;
            } catch (RemoteException e7) {
                f3168p.a(e7, "Unable to call %s on %s.", "onStartCommand", v.class.getSimpleName());
            }
        }
        return 2;
    }
}
