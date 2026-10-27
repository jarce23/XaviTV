package m;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j0 extends View.BaseSavedState {
    public static final Parcelable.Creator<j0> CREATOR = new l7.d(3);

    /* renamed from: o, reason: collision with root package name */
    public boolean f8442o;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeByte(this.f8442o ? (byte) 1 : (byte) 0);
    }
}
