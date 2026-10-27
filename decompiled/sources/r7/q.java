package r7;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q implements IInterface {

    /* renamed from: b, reason: collision with root package name */
    public final IBinder f10950b;

    public q(IBinder iBinder) {
        this.f10950b = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f10950b;
    }

    public final void v(v vVar, d dVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(vVar);
            obtain.writeInt(1);
            l7.d.a(dVar, obtain, 0);
            this.f10950b.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
