package g7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w extends s7.a {
    public static final Parcelable.Creator<w> CREATOR = new v(2);

    /* renamed from: o, reason: collision with root package name */
    public final float f5310o;

    /* renamed from: p, reason: collision with root package name */
    public final float f5311p;

    /* renamed from: q, reason: collision with root package name */
    public final float f5312q;

    public w(float f10, float f11, float f12) {
        this.f5310o = f10;
        this.f5311p = f11;
        this.f5312q = f12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f5310o == wVar.f5310o && this.f5311p == wVar.f5311p && this.f5312q == wVar.f5312q;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5310o), Float.valueOf(this.f5311p), Float.valueOf(this.f5312q)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 2, 4);
        parcel.writeFloat(this.f5310o);
        y7.d.D(parcel, 3, 4);
        parcel.writeFloat(this.f5311p);
        y7.d.D(parcel, 4, 4);
        parcel.writeFloat(this.f5312q);
        y7.d.G(parcel, E);
    }
}
