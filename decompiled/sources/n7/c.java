package n7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import r7.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends s7.a {
    public static final Parcelable.Creator<c> CREATOR = new l7.d(6);

    /* renamed from: o, reason: collision with root package name */
    public final String f9221o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9222p;

    /* renamed from: q, reason: collision with root package name */
    public final long f9223q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f9224r;

    public c(String str, int i10, long j10, boolean z10) {
        this.f9221o = str;
        this.f9222p = i10;
        this.f9223q = j10;
        this.f9224r = z10;
    }

    public final long b() {
        long j10 = this.f9223q;
        return j10 == -1 ? this.f9222p : j10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (r.h(this.f9221o, cVar.f9221o) && b() == cVar.b() && this.f9224r == cVar.f9224r) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9221o, Long.valueOf(b()), Boolean.valueOf(this.f9224r)});
    }

    public final String toString() {
        x4.r rVar = new x4.r(this);
        rVar.e("name", this.f9221o);
        rVar.e("version", Long.valueOf(b()));
        rVar.e("is_fully_rolled_out", Boolean.valueOf(this.f9224r));
        return rVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.w(parcel, 1, this.f9221o);
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(this.f9222p);
        long b2 = b();
        y7.d.D(parcel, 3, 8);
        parcel.writeLong(b2);
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(this.f9224r ? 1 : 0);
        y7.d.G(parcel, E);
    }

    public c(String str) {
        this(str, -1, 1L, false);
    }
}
