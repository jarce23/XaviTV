package c4;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements IInterface {

    /* renamed from: b, reason: collision with root package name */
    public IBinder f2874b;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f2874b;
    }

    public final void v(String[] strArr) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
            obtain.writeStringArray(strArr);
            this.f2874b.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
