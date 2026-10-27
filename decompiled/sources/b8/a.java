package b8;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a implements IInterface {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2476b;

    /* renamed from: c, reason: collision with root package name */
    public final IBinder f2477c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2478d;

    public /* synthetic */ a(IBinder iBinder, String str, int i10) {
        this.f2476b = i10;
        this.f2477c = iBinder;
        this.f2478d = str;
    }

    public Parcel G(Parcel parcel, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f2477c.transact(i10, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e7) {
                obtain.recycle();
                throw e7;
            }
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        switch (this.f2476b) {
        }
        return this.f2477c;
    }

    public Parcel v() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f2478d);
        return obtain;
    }

    public void w(Parcel parcel, int i10) {
        try {
            this.f2477c.transact(i10, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public Parcel w0() {
        switch (this.f2476b) {
            case 1:
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.f2478d);
                return obtain;
            default:
                Parcel obtain2 = Parcel.obtain();
                obtain2.writeInterfaceToken(this.f2478d);
                return obtain2;
        }
    }

    public Parcel x0(Parcel parcel, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f2477c.transact(i10, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e7) {
                obtain.recycle();
                throw e7;
            }
        } finally {
            parcel.recycle();
        }
    }

    public void y0(Parcel parcel, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f2477c.transact(i10, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public void z0(Parcel parcel, int i10) {
        try {
            this.f2477c.transact(i10, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
