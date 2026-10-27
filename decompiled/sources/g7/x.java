package g7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x extends s7.a {
    public static final Parcelable.Creator<x> CREATOR = new v(3);

    /* renamed from: o, reason: collision with root package name */
    public final w f5313o;

    /* renamed from: p, reason: collision with root package name */
    public final w f5314p;

    public x(w wVar, w wVar2) {
        this.f5313o = wVar;
        this.f5314p = wVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return l7.a.d(this.f5313o, xVar.f5313o) && l7.a.d(this.f5314p, xVar.f5314p);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5313o, this.f5314p});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.v(parcel, 2, this.f5313o, i10);
        y7.d.v(parcel, 3, this.f5314p, i10);
        y7.d.G(parcel, E);
    }
}
