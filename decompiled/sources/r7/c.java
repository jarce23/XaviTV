package r7;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends s7.a {
    public static final Parcelable.Creator<c> CREATOR = new l7.d(19);

    /* renamed from: o, reason: collision with root package name */
    public final h f10878o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f10879p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f10880q;

    /* renamed from: r, reason: collision with root package name */
    public final int[] f10881r;

    /* renamed from: s, reason: collision with root package name */
    public final int f10882s;

    /* renamed from: t, reason: collision with root package name */
    public final int[] f10883t;

    public c(h hVar, boolean z10, boolean z11, int[] iArr, int i10, int[] iArr2) {
        this.f10878o = hVar;
        this.f10879p = z10;
        this.f10880q = z11;
        this.f10881r = iArr;
        this.f10882s = i10;
        this.f10883t = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.v(parcel, 1, this.f10878o, i10);
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(this.f10879p ? 1 : 0);
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(this.f10880q ? 1 : 0);
        y7.d.s(parcel, 4, this.f10881r);
        y7.d.D(parcel, 5, 4);
        parcel.writeInt(this.f10882s);
        y7.d.s(parcel, 6, this.f10883t);
        y7.d.G(parcel, E);
    }
}
