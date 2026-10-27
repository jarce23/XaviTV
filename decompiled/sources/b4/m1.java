package b4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m1 implements Parcelable {
    public static final Parcelable.Creator<m1> CREATOR = new android.support.v4.media.a(15);

    /* renamed from: o, reason: collision with root package name */
    public int f2311o;

    /* renamed from: p, reason: collision with root package name */
    public int f2312p;

    /* renamed from: q, reason: collision with root package name */
    public int f2313q;

    /* renamed from: r, reason: collision with root package name */
    public int[] f2314r;

    /* renamed from: s, reason: collision with root package name */
    public int f2315s;

    /* renamed from: t, reason: collision with root package name */
    public int[] f2316t;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList f2317u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2318v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2319w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2320x;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2311o);
        parcel.writeInt(this.f2312p);
        parcel.writeInt(this.f2313q);
        if (this.f2313q > 0) {
            parcel.writeIntArray(this.f2314r);
        }
        parcel.writeInt(this.f2315s);
        if (this.f2315s > 0) {
            parcel.writeIntArray(this.f2316t);
        }
        parcel.writeInt(this.f2318v ? 1 : 0);
        parcel.writeInt(this.f2319w ? 1 : 0);
        parcel.writeInt(this.f2320x ? 1 : 0);
        parcel.writeList(this.f2317u);
    }
}
