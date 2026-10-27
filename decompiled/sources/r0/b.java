package r0;

import android.os.Parcel;
import android.os.Parcelable;
import b4.x0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b implements Parcelable {

    /* renamed from: o, reason: collision with root package name */
    public final Parcelable f10407o;

    /* renamed from: p, reason: collision with root package name */
    public static final a f10406p = new a();
    public static final Parcelable.Creator<b> CREATOR = new x0(6);

    public b() {
        this.f10407o = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f10407o, i10);
    }

    public b(Parcelable parcelable) {
        if (parcelable != null) {
            this.f10407o = parcelable == f10406p ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public b(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f10407o = readParcelable == null ? f10406p : readParcelable;
    }
}
