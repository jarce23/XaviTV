package r7;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends s7.a {
    public static final Parcelable.Creator<k> CREATOR = new l7.d(12);

    /* renamed from: o, reason: collision with root package name */
    public final int f10925o;

    /* renamed from: p, reason: collision with root package name */
    public final String f10926p;

    /* renamed from: q, reason: collision with root package name */
    public final long f10927q;

    /* renamed from: r, reason: collision with root package name */
    public final int f10928r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f10929s;

    public k(int i10, String str, long j10, int i11, boolean z10) {
        this.f10925o = i10;
        this.f10926p = str;
        this.f10927q = j10;
        this.f10928r = i11;
        this.f10929s = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(this.f10925o);
        y7.d.w(parcel, 2, this.f10926p);
        y7.d.D(parcel, 3, 8);
        parcel.writeLong(this.f10927q);
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(this.f10928r);
        y7.d.D(parcel, 5, 4);
        parcel.writeInt(this.f10929s ? 1 : 0);
        y7.d.G(parcel, E);
    }
}
