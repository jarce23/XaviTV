package b4;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y0 extends r0.b {
    public static final Parcelable.Creator<y0> CREATOR = new x0(0);

    /* renamed from: q, reason: collision with root package name */
    public Parcelable f2465q;

    public y0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f2465q = parcel.readParcelable(classLoader == null ? o0.class.getClassLoader() : classLoader);
    }

    @Override // r0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelable(this.f2465q, 0);
    }
}
