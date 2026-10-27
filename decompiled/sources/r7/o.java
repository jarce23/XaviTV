package r7;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o extends s7.a {
    public static final Parcelable.Creator<o> CREATOR = new l7.d(15);

    /* renamed from: o, reason: collision with root package name */
    public final int f10939o;

    /* renamed from: p, reason: collision with root package name */
    public final IBinder f10940p;

    /* renamed from: q, reason: collision with root package name */
    public final n7.a f10941q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f10942r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f10943s;

    public o(int i10, IBinder iBinder, n7.a aVar, boolean z10, boolean z11) {
        this.f10939o = i10;
        this.f10940p = iBinder;
        this.f10941q = aVar;
        this.f10942r = z10;
        this.f10943s = z11;
    }

    public final boolean equals(Object obj) {
        Object e0Var;
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            if (!(obj instanceof o)) {
                return false;
            }
            o oVar = (o) obj;
            if (!this.f10941q.equals(oVar.f10941q)) {
                return false;
            }
            Object obj2 = null;
            IBinder iBinder = this.f10940p;
            if (iBinder == null) {
                e0Var = null;
            } else {
                int i10 = a.f10868c;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                e0Var = queryLocalInterface instanceof e ? (e) queryLocalInterface : new e0(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            IBinder iBinder2 = oVar.f10940p;
            if (iBinder2 != null) {
                int i11 = a.f10868c;
                IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                obj2 = queryLocalInterface2 instanceof e ? (e) queryLocalInterface2 : new e0(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            if (!r.h(e0Var, obj2)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(this.f10939o);
        y7.d.r(parcel, 2, this.f10940p);
        y7.d.v(parcel, 3, this.f10941q, i10);
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(this.f10942r ? 1 : 0);
        y7.d.D(parcel, 5, 4);
        parcel.writeInt(this.f10943s ? 1 : 0);
        y7.d.G(parcel, E);
    }
}
