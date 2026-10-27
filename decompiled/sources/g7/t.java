package g7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t extends s7.a {
    public static final Parcelable.Creator<t> CREATOR = new v(20);

    /* renamed from: o, reason: collision with root package name */
    public final String f5303o;

    /* renamed from: p, reason: collision with root package name */
    public final String f5304p;

    public t(String str, String str2) {
        this.f5303o = str;
        this.f5304p = str2;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f5303o;
            if (str != null) {
                jSONObject.put("adTagUrl", str);
            }
            String str2 = this.f5304p;
            if (str2 != null) {
                jSONObject.put("adsResponse", str2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return l7.a.d(this.f5303o, tVar.f5303o) && l7.a.d(this.f5304p, tVar.f5304p);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5303o, this.f5304p});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.w(parcel, 2, this.f5303o);
        y7.d.w(parcel, 3, this.f5304p);
        y7.d.G(parcel, E);
    }
}
