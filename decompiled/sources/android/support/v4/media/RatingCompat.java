package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a(3);

    /* renamed from: o, reason: collision with root package name */
    public final int f193o;

    /* renamed from: p, reason: collision with root package name */
    public final float f194p;

    public RatingCompat(int i10, float f10) {
        this.f193o = i10;
        this.f194p = f10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f193o;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Rating:style=");
        sb2.append(this.f193o);
        sb2.append(" rating=");
        float f10 = this.f194p;
        sb2.append(f10 < 0.0f ? "unrated" : String.valueOf(f10));
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f193o);
        parcel.writeFloat(this.f194p);
    }
}
