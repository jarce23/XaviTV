package i7;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends s7.a {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.a(28);

    /* renamed from: o, reason: collision with root package name */
    public final int f6466o;

    /* renamed from: p, reason: collision with root package name */
    public final int f6467p;

    /* renamed from: q, reason: collision with root package name */
    public final int f6468q;

    public b(int i10, int i11, int i12) {
        this.f6466o = i10;
        this.f6467p = i11;
        this.f6468q = i12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(this.f6466o);
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(this.f6467p);
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(this.f6468q);
        y7.d.G(parcel, E);
    }
}
