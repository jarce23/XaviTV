package r7;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z extends s7.a {
    public static final Parcelable.Creator<z> CREATOR = new l7.d(18);

    /* renamed from: o, reason: collision with root package name */
    public Bundle f10962o;

    /* renamed from: p, reason: collision with root package name */
    public n7.c[] f10963p;

    /* renamed from: q, reason: collision with root package name */
    public int f10964q;

    /* renamed from: r, reason: collision with root package name */
    public c f10965r;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.q(parcel, 1, this.f10962o);
        y7.d.y(parcel, 2, this.f10963p, i10);
        int i11 = this.f10964q;
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(i11);
        y7.d.v(parcel, 4, this.f10965r, i10);
        y7.d.G(parcel, E);
    }
}
