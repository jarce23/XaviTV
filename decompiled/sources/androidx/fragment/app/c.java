package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new android.support.v4.media.a(7);

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f662o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f663p;

    public c(Parcel parcel) {
        this.f662o = parcel.createStringArrayList();
        this.f663p = parcel.createTypedArrayList(b.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f662o);
        parcel.writeTypedList(this.f663p);
    }
}
