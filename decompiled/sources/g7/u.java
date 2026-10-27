package g7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u extends s7.a {

    /* renamed from: o, reason: collision with root package name */
    public final int f5306o;

    /* renamed from: p, reason: collision with root package name */
    public final int f5307p;

    /* renamed from: q, reason: collision with root package name */
    public final int f5308q;

    /* renamed from: r, reason: collision with root package name */
    public static final l7.b f5305r = new l7.b("VideoInfo", null);
    public static final Parcelable.Creator<u> CREATOR = new v(21);

    public u(int i10, int i11, int i12) {
        this.f5306o = i10;
        this.f5307p = i11;
        this.f5308q = i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f5307p == uVar.f5307p && this.f5306o == uVar.f5306o && this.f5308q == uVar.f5308q;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5307p), Integer.valueOf(this.f5306o), Integer.valueOf(this.f5308q)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(this.f5306o);
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(this.f5307p);
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(this.f5308q);
        y7.d.G(parcel, E);
    }
}
