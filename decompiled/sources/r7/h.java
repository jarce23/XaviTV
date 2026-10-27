package r7;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends s7.a {
    public static final Parcelable.Creator<h> CREATOR = new l7.d(16);

    /* renamed from: o, reason: collision with root package name */
    public final int f10917o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f10918p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f10919q;

    /* renamed from: r, reason: collision with root package name */
    public final int f10920r;

    /* renamed from: s, reason: collision with root package name */
    public final int f10921s;

    public h(int i10, boolean z10, boolean z11, int i11, int i12) {
        this.f10917o = i10;
        this.f10918p = z10;
        this.f10919q = z11;
        this.f10920r = i11;
        this.f10921s = i12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(this.f10917o);
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(this.f10918p ? 1 : 0);
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(this.f10919q ? 1 : 0);
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(this.f10920r);
        y7.d.D(parcel, 5, 4);
        parcel.writeInt(this.f10921s);
        y7.d.G(parcel, E);
    }
}
