package i1;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p0 implements Comparable, Parcelable {
    public static final Parcelable.Creator<p0> CREATOR = new j(2);

    /* renamed from: o, reason: collision with root package name */
    public final int f6004o;

    /* renamed from: p, reason: collision with root package name */
    public final int f6005p;

    /* renamed from: q, reason: collision with root package name */
    public final int f6006q;

    static {
        l1.a0.J(0);
        l1.a0.J(1);
        l1.a0.J(2);
    }

    public p0(Parcel parcel) {
        this.f6004o = parcel.readInt();
        this.f6005p = parcel.readInt();
        this.f6006q = parcel.readInt();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        p0 p0Var = (p0) obj;
        int i10 = this.f6004o - p0Var.f6004o;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.f6005p - p0Var.f6005p;
        return i11 == 0 ? this.f6006q - p0Var.f6006q : i11;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && p0.class == obj.getClass()) {
            p0 p0Var = (p0) obj;
            if (this.f6004o == p0Var.f6004o && this.f6005p == p0Var.f6005p && this.f6006q == p0Var.f6006q) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f6004o * 31) + this.f6005p) * 31) + this.f6006q;
    }

    public final String toString() {
        return this.f6004o + "." + this.f6005p + "." + this.f6006q;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f6004o);
        parcel.writeInt(this.f6005p);
        parcel.writeInt(this.f6006q);
    }
}
