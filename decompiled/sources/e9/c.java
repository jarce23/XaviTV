package e9;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import b4.x0;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends r0.b {
    public static final Parcelable.Creator<c> CREATOR = new x0(1);

    /* renamed from: q, reason: collision with root package name */
    public final int f4673q;

    public c(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f4673q = parcel.readInt();
    }

    @Override // r0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f4673q);
    }

    public c(SideSheetBehavior sideSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.f4673q = sideSheetBehavior.f3822h;
    }
}
