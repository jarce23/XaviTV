package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 implements Parcelable {
    public static final Parcelable.Creator<n0> CREATOR = new android.support.v4.media.a(10);
    public final int A;
    public final boolean B;

    /* renamed from: o, reason: collision with root package name */
    public final String f740o;

    /* renamed from: p, reason: collision with root package name */
    public final String f741p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f742q;

    /* renamed from: r, reason: collision with root package name */
    public final int f743r;

    /* renamed from: s, reason: collision with root package name */
    public final int f744s;

    /* renamed from: t, reason: collision with root package name */
    public final String f745t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f746u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f747v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f748w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f749x;

    /* renamed from: y, reason: collision with root package name */
    public final int f750y;

    /* renamed from: z, reason: collision with root package name */
    public final String f751z;

    public n0(s sVar) {
        this.f740o = sVar.getClass().getName();
        this.f741p = sVar.f810s;
        this.f742q = sVar.A;
        this.f743r = sVar.J;
        this.f744s = sVar.K;
        this.f745t = sVar.L;
        this.f746u = sVar.O;
        this.f747v = sVar.f817z;
        this.f748w = sVar.N;
        this.f749x = sVar.M;
        this.f750y = sVar.Z.ordinal();
        this.f751z = sVar.f813v;
        this.A = sVar.f814w;
        this.B = sVar.U;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f740o);
        sb2.append(" (");
        sb2.append(this.f741p);
        sb2.append(")}:");
        if (this.f742q) {
            sb2.append(" fromLayout");
        }
        int i10 = this.f744s;
        if (i10 != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(i10));
        }
        String str = this.f745t;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(str);
        }
        if (this.f746u) {
            sb2.append(" retainInstance");
        }
        if (this.f747v) {
            sb2.append(" removing");
        }
        if (this.f748w) {
            sb2.append(" detached");
        }
        if (this.f749x) {
            sb2.append(" hidden");
        }
        String str2 = this.f751z;
        if (str2 != null) {
            sb2.append(" targetWho=");
            sb2.append(str2);
            sb2.append(" targetRequestCode=");
            sb2.append(this.A);
        }
        if (this.B) {
            sb2.append(" userVisibleHint");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f740o);
        parcel.writeString(this.f741p);
        parcel.writeInt(this.f742q ? 1 : 0);
        parcel.writeInt(this.f743r);
        parcel.writeInt(this.f744s);
        parcel.writeString(this.f745t);
        parcel.writeInt(this.f746u ? 1 : 0);
        parcel.writeInt(this.f747v ? 1 : 0);
        parcel.writeInt(this.f748w ? 1 : 0);
        parcel.writeInt(this.f749x ? 1 : 0);
        parcel.writeInt(this.f750y);
        parcel.writeString(this.f751z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B ? 1 : 0);
    }

    public n0(Parcel parcel) {
        this.f740o = parcel.readString();
        this.f741p = parcel.readString();
        this.f742q = parcel.readInt() != 0;
        this.f743r = parcel.readInt();
        this.f744s = parcel.readInt();
        this.f745t = parcel.readString();
        this.f746u = parcel.readInt() != 0;
        this.f747v = parcel.readInt() != 0;
        this.f748w = parcel.readInt() != 0;
        this.f749x = parcel.readInt() != 0;
        this.f750y = parcel.readInt();
        this.f751z = parcel.readString();
        this.A = parcel.readInt();
        this.B = parcel.readInt() != 0;
    }
}
