package l7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y extends s7.a {
    public static final Parcelable.Creator<y> CREATOR = new d(0);

    /* renamed from: o, reason: collision with root package name */
    public final int f8322o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f8323p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f8324q;

    public y(int i10, boolean z10, boolean z11) {
        this.f8322o = i10;
        this.f8323p = z10;
        this.f8324q = z11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f8322o == yVar.f8322o && this.f8323p == yVar.f8323p && this.f8324q == yVar.f8324q;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8322o), Boolean.valueOf(this.f8323p), Boolean.valueOf(this.f8324q)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(this.f8322o);
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(this.f8323p ? 1 : 0);
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(this.f8324q ? 1 : 0);
        y7.d.G(parcel, E);
    }
}
