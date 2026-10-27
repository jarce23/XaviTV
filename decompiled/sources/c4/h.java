package c4;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.MultiInstanceInvalidationService;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends Binder implements IInterface {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f2891b;

    public h(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f2891b = multiInstanceInvalidationService;
        attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 >= 1 && i10 <= 16777215) {
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
        }
        if (i10 == 1598968902) {
            parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
            return true;
        }
        d dVar = null;
        if (i10 == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                    dVar = new d();
                    dVar.f2874b = readStrongBinder;
                } else {
                    dVar = (d) queryLocalInterface;
                }
            }
            int w10 = w(dVar, parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(w10);
            return true;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            v(parcel.readInt(), parcel.createStringArray());
            return true;
        }
        IBinder readStrongBinder2 = parcel.readStrongBinder();
        if (readStrongBinder2 != null) {
            IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (queryLocalInterface2 == null || !(queryLocalInterface2 instanceof d)) {
                dVar = new d();
                dVar.f2874b = readStrongBinder2;
            } else {
                dVar = (d) queryLocalInterface2;
            }
        }
        int readInt = parcel.readInt();
        za.h.e("callback", dVar);
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f2891b;
        synchronized (multiInstanceInvalidationService.f1509q) {
            multiInstanceInvalidationService.f1509q.unregister(dVar);
        }
        parcel2.writeNoException();
        return true;
    }

    public final void v(int i10, String[] strArr) {
        za.h.e("tables", strArr);
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f2891b;
        synchronized (multiInstanceInvalidationService.f1509q) {
            String str = (String) multiInstanceInvalidationService.f1508p.get(Integer.valueOf(i10));
            if (str == null) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
                return;
            }
            int beginBroadcast = multiInstanceInvalidationService.f1509q.beginBroadcast();
            for (int i11 = 0; i11 < beginBroadcast; i11++) {
                try {
                    Object broadcastCookie = multiInstanceInvalidationService.f1509q.getBroadcastCookie(i11);
                    za.h.c("null cannot be cast to non-null type kotlin.Int", broadcastCookie);
                    Integer num = (Integer) broadcastCookie;
                    int intValue = num.intValue();
                    String str2 = (String) multiInstanceInvalidationService.f1508p.get(num);
                    if (i10 != intValue && str.equals(str2)) {
                        try {
                            ((d) multiInstanceInvalidationService.f1509q.getBroadcastItem(i11)).v(strArr);
                        } catch (RemoteException e7) {
                            Log.w("ROOM", "Error invoking a remote callback", e7);
                        }
                    }
                } finally {
                    multiInstanceInvalidationService.f1509q.finishBroadcast();
                }
            }
        }
    }

    public final int w(d dVar, String str) {
        za.h.e("callback", dVar);
        int i10 = 0;
        if (str == null) {
            return 0;
        }
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f2891b;
        synchronized (multiInstanceInvalidationService.f1509q) {
            try {
                int i11 = multiInstanceInvalidationService.f1507o + 1;
                multiInstanceInvalidationService.f1507o = i11;
                if (multiInstanceInvalidationService.f1509q.register(dVar, Integer.valueOf(i11))) {
                    multiInstanceInvalidationService.f1508p.put(Integer.valueOf(i11), str);
                    i10 = i11;
                } else {
                    multiInstanceInvalidationService.f1507o--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i10;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
