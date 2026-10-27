package g7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends s7.a {
    public static final Parcelable.Creator<b> CREATOR = new v(4);

    /* renamed from: o, reason: collision with root package name */
    public final long f5172o;

    /* renamed from: p, reason: collision with root package name */
    public final String f5173p;

    /* renamed from: q, reason: collision with root package name */
    public final long f5174q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f5175r;

    /* renamed from: s, reason: collision with root package name */
    public final String[] f5176s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f5177t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f5178u;

    public b(long j10, String str, long j11, boolean z10, String[] strArr, boolean z11, boolean z12) {
        this.f5172o = j10;
        this.f5173p = str;
        this.f5174q = j11;
        this.f5175r = z10;
        this.f5176s = strArr;
        this.f5177t = z11;
        this.f5178u = z12;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f5173p);
            long j10 = this.f5172o;
            Pattern pattern = l7.a.f8269a;
            jSONObject.put("position", j10 / 1000.0d);
            jSONObject.put("isWatched", this.f5175r);
            jSONObject.put("isEmbedded", this.f5177t);
            jSONObject.put("duration", this.f5174q / 1000.0d);
            jSONObject.put("expanded", this.f5178u);
            String[] strArr = this.f5176s;
            if (strArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : strArr) {
                    jSONArray.put(str);
                }
                jSONObject.put("breakClipIds", jSONArray);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return l7.a.d(this.f5173p, bVar.f5173p) && this.f5172o == bVar.f5172o && this.f5174q == bVar.f5174q && this.f5175r == bVar.f5175r && Arrays.equals(this.f5176s, bVar.f5176s) && this.f5177t == bVar.f5177t && this.f5178u == bVar.f5178u;
    }

    public final int hashCode() {
        return this.f5173p.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 2, 8);
        parcel.writeLong(this.f5172o);
        y7.d.w(parcel, 3, this.f5173p);
        y7.d.D(parcel, 4, 8);
        parcel.writeLong(this.f5174q);
        y7.d.D(parcel, 5, 4);
        parcel.writeInt(this.f5175r ? 1 : 0);
        String[] strArr = this.f5176s;
        if (strArr != null) {
            int E2 = y7.d.E(parcel, 6);
            parcel.writeStringArray(strArr);
            y7.d.G(parcel, E2);
        }
        y7.d.D(parcel, 7, 4);
        parcel.writeInt(this.f5177t ? 1 : 0);
        y7.d.D(parcel, 8, 4);
        parcel.writeInt(this.f5178u ? 1 : 0);
        y7.d.G(parcel, E);
    }
}
