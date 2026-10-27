package h8;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import o7.j;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends s7.a implements j {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.a(23);

    /* renamed from: o, reason: collision with root package name */
    public final int f5756o;

    /* renamed from: p, reason: collision with root package name */
    public final int f5757p;

    /* renamed from: q, reason: collision with root package name */
    public final Intent f5758q;

    public b(int i10, int i11, Intent intent) {
        this.f5756o = i10;
        this.f5757p = i11;
        this.f5758q = intent;
    }

    @Override // o7.j
    public final Status a() {
        return this.f5757p == 0 ? Status.f3190s : Status.f3192u;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(this.f5756o);
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(this.f5757p);
        y7.d.v(parcel, 3, this.f5758q, i10);
        y7.d.G(parcel, E);
    }
}
