package h8;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.List;
import o7.j;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends s7.a implements j {
    public static final Parcelable.Creator<d> CREATOR = new android.support.v4.media.a(24);

    /* renamed from: o, reason: collision with root package name */
    public final List f5759o;

    /* renamed from: p, reason: collision with root package name */
    public final String f5760p;

    public d(String str, ArrayList arrayList) {
        this.f5759o = arrayList;
        this.f5760p = str;
    }

    @Override // o7.j
    public final Status a() {
        return this.f5760p != null ? Status.f3190s : Status.f3192u;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.x(parcel, 1, this.f5759o);
        y7.d.w(parcel, 2, this.f5760p);
        y7.d.G(parcel, E);
    }
}
