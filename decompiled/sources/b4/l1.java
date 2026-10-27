package b4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l1 implements Parcelable {
    public static final Parcelable.Creator<l1> CREATOR = new android.support.v4.media.a(14);

    /* renamed from: o, reason: collision with root package name */
    public int f2303o;

    /* renamed from: p, reason: collision with root package name */
    public int f2304p;

    /* renamed from: q, reason: collision with root package name */
    public int[] f2305q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2306r;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f2303o + ", mGapDir=" + this.f2304p + ", mHasUnwantedGapAfter=" + this.f2306r + ", mGapPerSpan=" + Arrays.toString(this.f2305q) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2303o);
        parcel.writeInt(this.f2304p);
        parcel.writeInt(this.f2306r ? 1 : 0);
        int[] iArr = this.f2305q;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f2305q);
        }
    }
}
