package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new z(3);

    /* renamed from: o, reason: collision with root package name */
    public int f204o;

    /* renamed from: p, reason: collision with root package name */
    public int f205p;

    /* renamed from: q, reason: collision with root package name */
    public int f206q;

    /* renamed from: r, reason: collision with root package name */
    public int f207r;

    /* renamed from: s, reason: collision with root package name */
    public int f208s;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f204o);
        parcel.writeInt(this.f206q);
        parcel.writeInt(this.f207r);
        parcel.writeInt(this.f208s);
        parcel.writeInt(this.f205p);
    }
}
