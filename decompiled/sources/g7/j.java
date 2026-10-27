package g7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends s7.a {

    /* renamed from: o, reason: collision with root package name */
    public final long f5230o;

    /* renamed from: p, reason: collision with root package name */
    public final long f5231p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f5232q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f5233r;

    /* renamed from: s, reason: collision with root package name */
    public static final l7.b f5229s = new l7.b("MediaLiveSeekableRange", null);
    public static final Parcelable.Creator<j> CREATOR = new v(8);

    public j(long j10, long j11, boolean z10, boolean z11) {
        this.f5230o = Math.max(j10, 0L);
        this.f5231p = Math.max(j11, 0L);
        this.f5232q = z10;
        this.f5233r = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f5230o == jVar.f5230o && this.f5231p == jVar.f5231p && this.f5232q == jVar.f5232q && this.f5233r == jVar.f5233r;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f5230o), Long.valueOf(this.f5231p), Boolean.valueOf(this.f5232q), Boolean.valueOf(this.f5233r)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 2, 8);
        parcel.writeLong(this.f5230o);
        y7.d.D(parcel, 3, 8);
        parcel.writeLong(this.f5231p);
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(this.f5232q ? 1 : 0);
        y7.d.D(parcel, 5, 4);
        parcel.writeInt(this.f5233r ? 1 : 0);
        y7.d.G(parcel, E);
    }
}
