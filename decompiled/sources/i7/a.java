package i7;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends s7.a {

    /* renamed from: o, reason: collision with root package name */
    public final String f6460o;

    /* renamed from: p, reason: collision with root package name */
    public final String f6461p;

    /* renamed from: q, reason: collision with root package name */
    public final k f6462q;

    /* renamed from: r, reason: collision with root package name */
    public final f f6463r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f6464s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f6465t;

    /* renamed from: u, reason: collision with root package name */
    public static final l7.b f6459u = new l7.b("CastMediaOptions", null);
    public static final Parcelable.Creator<a> CREATOR = new android.support.v4.media.a(26);

    public a(String str, String str2, IBinder iBinder, f fVar, boolean z10, boolean z11) {
        k kVar;
        this.f6460o = str;
        this.f6461p = str2;
        if (iBinder == null) {
            kVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.IImagePicker");
            kVar = queryLocalInterface instanceof k ? (k) queryLocalInterface : new k(iBinder, "com.google.android.gms.cast.framework.media.IImagePicker", 2);
        }
        this.f6462q = kVar;
        this.f6463r = fVar;
        this.f6464s = z10;
        this.f6465t = z11;
    }

    public final void b() {
        k kVar = this.f6462q;
        if (kVar != null) {
            try {
                Parcel x02 = kVar.x0(kVar.w0(), 2);
                x7.a y02 = x7.b.y0(x02.readStrongBinder());
                x02.recycle();
                if (x7.b.z0(y02) == null) {
                } else {
                    throw new ClassCastException();
                }
            } catch (RemoteException e7) {
                f6459u.a(e7, "Unable to call %s on %s.", "getWrappedClientObject", k.class.getSimpleName());
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.w(parcel, 2, this.f6460o);
        y7.d.w(parcel, 3, this.f6461p);
        k kVar = this.f6462q;
        y7.d.r(parcel, 4, kVar == null ? null : kVar.f2477c);
        y7.d.v(parcel, 5, this.f6463r, i10);
        y7.d.D(parcel, 6, 4);
        parcel.writeInt(this.f6464s ? 1 : 0);
        y7.d.D(parcel, 7, 4);
        parcel.writeInt(this.f6465t ? 1 : 0);
        y7.d.G(parcel, E);
    }
}
