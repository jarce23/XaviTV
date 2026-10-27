package h8;

import android.os.Parcel;
import android.os.Parcelable;
import r7.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends s7.a {
    public static final Parcelable.Creator<e> CREATOR = new android.support.v4.media.a(25);

    /* renamed from: o, reason: collision with root package name */
    public final int f5761o;

    /* renamed from: p, reason: collision with root package name */
    public final n7.a f5762p;

    /* renamed from: q, reason: collision with root package name */
    public final o f5763q;

    public e(int i10, n7.a aVar, o oVar) {
        this.f5761o = i10;
        this.f5762p = aVar;
        this.f5763q = oVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(this.f5761o);
        y7.d.v(parcel, 2, this.f5762p, i10);
        y7.d.v(parcel, 3, this.f5763q, i10);
        y7.d.G(parcel, E);
    }
}
