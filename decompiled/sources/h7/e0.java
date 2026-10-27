package h7;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 extends s7.a {
    public static final Parcelable.Creator<e0> CREATOR = new android.support.v4.media.a(21);

    /* renamed from: o, reason: collision with root package name */
    public final int f5737o;

    public e0(int i10) {
        this.f5737o = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(this.f5737o);
        y7.d.G(parcel, E);
    }
}
