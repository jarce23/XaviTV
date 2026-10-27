package r7;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends s7.a {
    public static final Parcelable.Creator<f> CREATOR = new l7.d(13);

    /* renamed from: o, reason: collision with root package name */
    public final int f10905o;

    /* renamed from: p, reason: collision with root package name */
    public final int f10906p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10907q;

    /* renamed from: r, reason: collision with root package name */
    public final long f10908r;

    /* renamed from: s, reason: collision with root package name */
    public final long f10909s;

    /* renamed from: t, reason: collision with root package name */
    public final String f10910t;

    /* renamed from: u, reason: collision with root package name */
    public final String f10911u;

    /* renamed from: v, reason: collision with root package name */
    public final int f10912v;

    /* renamed from: w, reason: collision with root package name */
    public final int f10913w;

    public f(int i10, int i11, int i12, long j10, long j11, String str, String str2, int i13, int i14) {
        this.f10905o = i10;
        this.f10906p = i11;
        this.f10907q = i12;
        this.f10908r = j10;
        this.f10909s = j11;
        this.f10910t = str;
        this.f10911u = str2;
        this.f10912v = i13;
        this.f10913w = i14;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(this.f10905o);
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(this.f10906p);
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(this.f10907q);
        y7.d.D(parcel, 4, 8);
        parcel.writeLong(this.f10908r);
        y7.d.D(parcel, 5, 8);
        parcel.writeLong(this.f10909s);
        y7.d.w(parcel, 6, this.f10910t);
        y7.d.w(parcel, 7, this.f10911u);
        y7.d.D(parcel, 8, 4);
        parcel.writeInt(this.f10912v);
        y7.d.D(parcel, 9, 4);
        parcel.writeInt(this.f10913w);
        y7.d.G(parcel, E);
    }
}
