package g7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends s7.a {

    /* renamed from: o, reason: collision with root package name */
    public final long f5183o;

    /* renamed from: p, reason: collision with root package name */
    public final long f5184p;

    /* renamed from: q, reason: collision with root package name */
    public final String f5185q;

    /* renamed from: r, reason: collision with root package name */
    public final String f5186r;

    /* renamed from: s, reason: collision with root package name */
    public final long f5187s;

    /* renamed from: t, reason: collision with root package name */
    public static final l7.b f5182t = new l7.b("AdBreakStatus", null);
    public static final Parcelable.Creator<c> CREATOR = new v(9);

    public c(long j10, long j11, String str, String str2, long j12) {
        this.f5183o = j10;
        this.f5184p = j11;
        this.f5185q = str;
        this.f5186r = str2;
        this.f5187s = j12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f5183o == cVar.f5183o && this.f5184p == cVar.f5184p && l7.a.d(this.f5185q, cVar.f5185q) && l7.a.d(this.f5186r, cVar.f5186r) && this.f5187s == cVar.f5187s;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f5183o), Long.valueOf(this.f5184p), this.f5185q, this.f5186r, Long.valueOf(this.f5187s)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 2, 8);
        parcel.writeLong(this.f5183o);
        y7.d.D(parcel, 3, 8);
        parcel.writeLong(this.f5184p);
        y7.d.w(parcel, 4, this.f5185q);
        y7.d.w(parcel, 5, this.f5186r);
        y7.d.D(parcel, 6, 8);
        parcel.writeLong(this.f5187s);
        y7.d.G(parcel, E);
    }
}
