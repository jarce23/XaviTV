package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k0 implements Parcelable {
    public static final Parcelable.Creator<k0> CREATOR = new android.support.v4.media.a(9);

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f723o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f724p;

    /* renamed from: q, reason: collision with root package name */
    public b[] f725q;

    /* renamed from: r, reason: collision with root package name */
    public int f726r;

    /* renamed from: s, reason: collision with root package name */
    public String f727s;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList f728t;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList f729u;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f730v;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f723o);
        parcel.writeStringList(this.f724p);
        parcel.writeTypedArray(this.f725q, i10);
        parcel.writeInt(this.f726r);
        parcel.writeString(this.f727s);
        parcel.writeStringList(this.f728t);
        parcel.writeTypedList(this.f729u);
        parcel.writeTypedList(this.f730v);
    }
}
