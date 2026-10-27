package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends b8.a {
    public final h7.r A0(h7.c cVar, x7.a aVar, h7.a0 a0Var) {
        h7.r pVar;
        Parcel w02 = w0();
        u.c(w02, cVar);
        u.d(w02, aVar);
        u.d(w02, a0Var);
        Parcel x02 = x0(w02, 3);
        IBinder readStrongBinder = x02.readStrongBinder();
        int i10 = h7.q.f5753c;
        if (readStrongBinder == null) {
            pVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ICastSession");
            pVar = queryLocalInterface instanceof h7.r ? (h7.r) queryLocalInterface : new h7.p(readStrongBinder, "com.google.android.gms.cast.framework.ICastSession", 2);
        }
        x02.recycle();
        return pVar;
    }

    public final h7.v B0(x7.b bVar, x7.a aVar, x7.a aVar2) {
        h7.v tVar;
        Parcel w02 = w0();
        u.d(w02, bVar);
        u.d(w02, aVar);
        u.d(w02, aVar2);
        Parcel x02 = x0(w02, 5);
        IBinder readStrongBinder = x02.readStrongBinder();
        int i10 = h7.u.f5754c;
        if (readStrongBinder == null) {
            tVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.IReconnectionService");
            tVar = queryLocalInterface instanceof h7.v ? (h7.v) queryLocalInterface : new h7.t(readStrongBinder, "com.google.android.gms.cast.framework.IReconnectionService", 2);
        }
        x02.recycle();
        return tVar;
    }

    public final h7.y C0(String str, String str2, h7.a0 a0Var) {
        h7.y wVar;
        Parcel w02 = w0();
        w02.writeString(str);
        w02.writeString(str2);
        u.d(w02, a0Var);
        Parcel x02 = x0(w02, 2);
        IBinder readStrongBinder = x02.readStrongBinder();
        int i10 = h7.x.f5755c;
        if (readStrongBinder == null) {
            wVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ISession");
            wVar = queryLocalInterface instanceof h7.y ? (h7.y) queryLocalInterface : new h7.w(readStrongBinder, "com.google.android.gms.cast.framework.ISession", 2);
        }
        x02.recycle();
        return wVar;
    }

    public final j7.e D0(x7.b bVar, h7.a0 a0Var, int i10, int i11) {
        j7.e cVar;
        Parcel w02 = w0();
        u.d(w02, bVar);
        u.d(w02, a0Var);
        w02.writeInt(i10);
        w02.writeInt(i11);
        w02.writeInt(0);
        w02.writeLong(2097152L);
        w02.writeInt(5);
        w02.writeInt(333);
        w02.writeInt(10000);
        Parcel x02 = x0(w02, 6);
        IBinder readStrongBinder = x02.readStrongBinder();
        int i12 = j7.d.f7129c;
        if (readStrongBinder == null) {
            cVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask");
            cVar = queryLocalInterface instanceof j7.e ? (j7.e) queryLocalInterface : new j7.c(readStrongBinder, "com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask", 2);
        }
        x02.recycle();
        return cVar;
    }

    public final j7.e E0(x7.b bVar, x7.b bVar2, h7.a0 a0Var, int i10, int i11) {
        j7.e cVar;
        Parcel w02 = w0();
        u.d(w02, bVar);
        u.d(w02, bVar2);
        u.d(w02, a0Var);
        w02.writeInt(i10);
        w02.writeInt(i11);
        w02.writeInt(0);
        w02.writeLong(2097152L);
        w02.writeInt(5);
        w02.writeInt(333);
        w02.writeInt(10000);
        Parcel x02 = x0(w02, 7);
        IBinder readStrongBinder = x02.readStrongBinder();
        int i12 = j7.d.f7129c;
        if (readStrongBinder == null) {
            cVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask");
            cVar = queryLocalInterface instanceof j7.e ? (j7.e) queryLocalInterface : new j7.c(readStrongBinder, "com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask", 2);
        }
        x02.recycle();
        return cVar;
    }
}
