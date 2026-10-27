package h7;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 extends s7.a {
    public static final Parcelable.Creator<d0> CREATOR = new android.support.v4.media.a(20);

    /* renamed from: o, reason: collision with root package name */
    public final boolean f5736o;

    public d0(boolean z10) {
        this.f5736o = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(this.f5736o ? 1 : 0);
        y7.d.G(parcel, E);
    }
}
