package r7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends s7.a {
    public static final Parcelable.Creator<i> CREATOR = new l7.d(11);

    /* renamed from: o, reason: collision with root package name */
    public final int f10922o;

    /* renamed from: p, reason: collision with root package name */
    public List f10923p;

    public i(int i10, List list) {
        this.f10922o = i10;
        this.f10923p = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(this.f10922o);
        y7.d.z(parcel, 2, this.f10923p);
        y7.d.G(parcel, E);
    }
}
