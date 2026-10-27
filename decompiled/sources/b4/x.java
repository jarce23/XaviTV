package b4;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x implements Parcelable {
    public static final Parcelable.Creator<x> CREATOR = new android.support.v4.media.a(13);

    /* renamed from: o, reason: collision with root package name */
    public int f2446o;

    /* renamed from: p, reason: collision with root package name */
    public int f2447p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2448q;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2446o);
        parcel.writeInt(this.f2447p);
        parcel.writeInt(this.f2448q ? 1 : 0);
    }
}
