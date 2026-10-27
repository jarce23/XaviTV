package g7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends s7.a {
    public static final Parcelable.Creator<r> CREATOR = new v(18);

    /* renamed from: o, reason: collision with root package name */
    public final k f5288o;

    /* renamed from: p, reason: collision with root package name */
    public String f5289p;

    /* renamed from: q, reason: collision with root package name */
    public final JSONObject f5290q;

    public r(k kVar, JSONObject jSONObject) {
        this.f5288o = kVar;
        this.f5290q = jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (v7.a.a(this.f5290q, rVar.f5290q)) {
            return r7.r.h(this.f5288o, rVar.f5288o);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5288o, String.valueOf(this.f5290q)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.f5290q;
        this.f5289p = jSONObject == null ? null : jSONObject.toString();
        int E = y7.d.E(parcel, 20293);
        y7.d.v(parcel, 2, this.f5288o, i10);
        y7.d.w(parcel, 3, this.f5289p);
        y7.d.G(parcel, E);
    }
}
