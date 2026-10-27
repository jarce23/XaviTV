package l7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends s7.a {
    public static final Parcelable.Creator<e> CREATOR = new d(1);

    /* renamed from: o, reason: collision with root package name */
    public double f8276o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8277p;

    /* renamed from: q, reason: collision with root package name */
    public int f8278q;

    /* renamed from: r, reason: collision with root package name */
    public g7.d f8279r;

    /* renamed from: s, reason: collision with root package name */
    public int f8280s;

    /* renamed from: t, reason: collision with root package name */
    public g7.x f8281t;

    /* renamed from: u, reason: collision with root package name */
    public double f8282u;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f8276o == eVar.f8276o && this.f8277p == eVar.f8277p && this.f8278q == eVar.f8278q && a.d(this.f8279r, eVar.f8279r) && this.f8280s == eVar.f8280s) {
            g7.x xVar = this.f8281t;
            if (a.d(xVar, xVar) && this.f8282u == eVar.f8282u) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Double.valueOf(this.f8276o), Boolean.valueOf(this.f8277p), Integer.valueOf(this.f8278q), this.f8279r, Integer.valueOf(this.f8280s), this.f8281t, Double.valueOf(this.f8282u)});
    }

    public final String toString() {
        return String.format(Locale.ROOT, "volume=%f", Double.valueOf(this.f8276o));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        double d6 = this.f8276o;
        y7.d.D(parcel, 2, 8);
        parcel.writeDouble(d6);
        boolean z10 = this.f8277p;
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(z10 ? 1 : 0);
        int i11 = this.f8278q;
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(i11);
        y7.d.v(parcel, 5, this.f8279r, i10);
        int i12 = this.f8280s;
        y7.d.D(parcel, 6, 4);
        parcel.writeInt(i12);
        y7.d.v(parcel, 7, this.f8281t, i10);
        double d10 = this.f8282u;
        y7.d.D(parcel, 8, 8);
        parcel.writeDouble(d10);
        y7.d.G(parcel, E);
    }
}
