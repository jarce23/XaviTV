package x8;

import android.os.Parcel;
import android.os.Parcelable;
import b4.x0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends r0.b {
    public static final Parcelable.Creator<a> CREATOR = new x0(7);

    /* renamed from: q, reason: collision with root package name */
    public boolean f13687q;

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f13687q = parcel.readInt() == 1;
    }

    @Override // r0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f13687q ? 1 : 0);
    }
}
