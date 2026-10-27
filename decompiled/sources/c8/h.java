package c8;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p7.m;
import p7.v;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class h extends Binder implements IInterface {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2970b;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i10 = this.f2970b;
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        switch (this.f2970b) {
            case 0:
                if (i10 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i10, parcel, parcel2, i11)) {
                    return true;
                }
                return x0(i10, parcel, parcel2);
            case 1:
                if (i10 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i10, parcel, parcel2, i11)) {
                    return true;
                }
                return x0(i10, parcel, parcel2);
            case 2:
                if (i10 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i10, parcel, parcel2, i11)) {
                    return true;
                }
                switch (i10) {
                    case 3:
                        b8.b.b(parcel);
                        break;
                    case 4:
                        b8.b.b(parcel);
                        break;
                    case 5:
                    default:
                        return false;
                    case 6:
                        b8.b.b(parcel);
                        break;
                    case 7:
                        b8.b.b(parcel);
                        break;
                    case 8:
                        h8.e eVar = (h8.e) b8.b.a(parcel, h8.e.CREATOR);
                        b8.b.b(parcel);
                        v vVar = (v) this;
                        vVar.f10095d.post(new m(vVar, 1, eVar));
                        break;
                    case 9:
                        b8.b.b(parcel);
                        break;
                }
                parcel2.writeNoException();
                return true;
            default:
                if (i10 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i10, parcel, parcel2, i11)) {
                    return true;
                }
                return w0(parcel, i10);
        }
    }

    public abstract boolean w0(Parcel parcel, int i10);

    public boolean x0(int i10, Parcel parcel, Parcel parcel2) {
        return false;
    }

    public h(String str, int i10) {
        this.f2970b = i10;
        switch (i10) {
            case 1:
                attachInterface(this, str);
                break;
            case 2:
            default:
                attachInterface(this, str);
                break;
            case 3:
                attachInterface(this, str);
                break;
        }
    }
}
