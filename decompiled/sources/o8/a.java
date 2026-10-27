package o8;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import b4.x0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import r0.b;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new x0(4);

    /* renamed from: q, reason: collision with root package name */
    public final int f9560q;

    /* renamed from: r, reason: collision with root package name */
    public final int f9561r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f9562s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f9563t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f9564u;

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f9560q = parcel.readInt();
        this.f9561r = parcel.readInt();
        this.f9562s = parcel.readInt() == 1;
        this.f9563t = parcel.readInt() == 1;
        this.f9564u = parcel.readInt() == 1;
    }

    @Override // r0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f9560q);
        parcel.writeInt(this.f9561r);
        parcel.writeInt(this.f9562s ? 1 : 0);
        parcel.writeInt(this.f9563t ? 1 : 0);
        parcel.writeInt(this.f9564u ? 1 : 0);
    }

    public a(BottomSheetBehavior bottomSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.f9560q = bottomSheetBehavior.N;
        this.f9561r = bottomSheetBehavior.f3688e;
        this.f9562s = bottomSheetBehavior.f3682b;
        this.f9563t = bottomSheetBehavior.I;
        this.f9564u = bottomSheetBehavior.J;
    }
}
