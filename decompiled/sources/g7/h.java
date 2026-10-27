package g7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends s7.a {
    public static final Parcelable.Creator<h> CREATOR = new v(1);

    /* renamed from: o, reason: collision with root package name */
    public final String f5223o;

    /* renamed from: p, reason: collision with root package name */
    public final String f5224p;

    public h(String str, String str2) {
        this.f5223o = str;
        this.f5224p = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return r7.r.h(this.f5223o, hVar.f5223o) && r7.r.h(this.f5224p, hVar.f5224p);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5223o, this.f5224p});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.w(parcel, 1, this.f5223o);
        y7.d.w(parcel, 2, this.f5224p);
        y7.d.G(parcel, E);
    }
}
