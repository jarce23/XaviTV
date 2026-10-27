package m;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x2 extends r0.b {
    public static final Parcelable.Creator<x2> CREATOR = new b4.x0(3);

    /* renamed from: q, reason: collision with root package name */
    public int f8596q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8597r;

    public x2(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f8596q = parcel.readInt();
        this.f8597r = parcel.readInt() != 0;
    }

    @Override // r0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f8596q);
        parcel.writeInt(this.f8597r ? 1 : 0);
    }
}
