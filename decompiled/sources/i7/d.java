package i7;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends s7.a {
    public static final Parcelable.Creator<d> CREATOR = new android.support.v4.media.a(29);

    /* renamed from: o, reason: collision with root package name */
    public final String f6481o;

    /* renamed from: p, reason: collision with root package name */
    public final int f6482p;

    /* renamed from: q, reason: collision with root package name */
    public final String f6483q;

    public d(String str, int i10, String str2) {
        this.f6481o = str;
        this.f6482p = i10;
        this.f6483q = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.w(parcel, 2, this.f6481o);
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(this.f6482p);
        y7.d.w(parcel, 4, this.f6483q);
        y7.d.G(parcel, E);
    }
}
