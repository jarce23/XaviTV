package g7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.MediaInfo;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o extends s7.a {
    public static final Parcelable.Creator<o> CREATOR = new v(14);

    /* renamed from: o, reason: collision with root package name */
    public MediaInfo f5266o;

    /* renamed from: p, reason: collision with root package name */
    public int f5267p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5268q;

    /* renamed from: r, reason: collision with root package name */
    public double f5269r;

    /* renamed from: s, reason: collision with root package name */
    public double f5270s;

    /* renamed from: t, reason: collision with root package name */
    public double f5271t;

    /* renamed from: u, reason: collision with root package name */
    public long[] f5272u;

    /* renamed from: v, reason: collision with root package name */
    public String f5273v;

    /* renamed from: w, reason: collision with root package name */
    public JSONObject f5274w;

    public o(MediaInfo mediaInfo, int i10, boolean z10, double d6, double d10, double d11, long[] jArr, String str) {
        this.f5266o = mediaInfo;
        this.f5267p = i10;
        this.f5268q = z10;
        this.f5269r = d6;
        this.f5270s = d10;
        this.f5271t = d11;
        this.f5272u = jArr;
        this.f5273v = str;
        if (str == null) {
            this.f5274w = null;
            return;
        }
        try {
            this.f5274w = new JSONObject(this.f5273v);
        } catch (JSONException unused) {
            this.f5274w = null;
            this.f5273v = null;
        }
    }

    public final boolean b(JSONObject jSONObject) {
        boolean z10;
        long[] jArr;
        boolean z11;
        int i10;
        boolean z12 = false;
        if (jSONObject.has("media")) {
            this.f5266o = new MediaInfo(jSONObject.getJSONObject("media"));
            z10 = true;
        } else {
            z10 = false;
        }
        if (jSONObject.has("itemId") && this.f5267p != (i10 = jSONObject.getInt("itemId"))) {
            this.f5267p = i10;
            z10 = true;
        }
        if (jSONObject.has("autoplay") && this.f5268q != (z11 = jSONObject.getBoolean("autoplay"))) {
            this.f5268q = z11;
            z10 = true;
        }
        double optDouble = jSONObject.optDouble("startTime");
        if (Double.isNaN(optDouble) != Double.isNaN(this.f5269r) || (!Double.isNaN(optDouble) && Math.abs(optDouble - this.f5269r) > 1.0E-7d)) {
            this.f5269r = optDouble;
            z10 = true;
        }
        if (jSONObject.has("playbackDuration")) {
            double d6 = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d6 - this.f5270s) > 1.0E-7d) {
                this.f5270s = d6;
                z10 = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            double d10 = jSONObject.getDouble("preloadTime");
            if (Math.abs(d10 - this.f5271t) > 1.0E-7d) {
                this.f5271t = d10;
                z10 = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            jArr = new long[length];
            for (int i11 = 0; i11 < length; i11++) {
                jArr[i11] = jSONArray.getLong(i11);
            }
            long[] jArr2 = this.f5272u;
            if (jArr2 != null && jArr2.length == length) {
                for (int i12 = 0; i12 < length; i12++) {
                    if (this.f5272u[i12] == jArr[i12]) {
                    }
                }
            }
            z12 = true;
            break;
        } else {
            jArr = null;
        }
        if (z12) {
            this.f5272u = jArr;
            z10 = true;
        }
        if (!jSONObject.has("customData")) {
            return z10;
        }
        this.f5274w = jSONObject.getJSONObject("customData");
        return true;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            MediaInfo mediaInfo = this.f5266o;
            if (mediaInfo != null) {
                jSONObject.put("media", mediaInfo.b());
            }
            int i10 = this.f5267p;
            if (i10 != 0) {
                jSONObject.put("itemId", i10);
            }
            jSONObject.put("autoplay", this.f5268q);
            if (!Double.isNaN(this.f5269r)) {
                jSONObject.put("startTime", this.f5269r);
            }
            double d6 = this.f5270s;
            if (d6 != Double.POSITIVE_INFINITY) {
                jSONObject.put("playbackDuration", d6);
            }
            jSONObject.put("preloadTime", this.f5271t);
            if (this.f5272u != null) {
                JSONArray jSONArray = new JSONArray();
                for (long j10 : this.f5272u) {
                    jSONArray.put(j10);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            JSONObject jSONObject2 = this.f5274w;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        JSONObject jSONObject = this.f5274w;
        boolean z10 = jSONObject == null;
        JSONObject jSONObject2 = oVar.f5274w;
        if (z10 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || v7.a.a(jSONObject, jSONObject2)) && l7.a.d(this.f5266o, oVar.f5266o) && this.f5267p == oVar.f5267p && this.f5268q == oVar.f5268q && ((Double.isNaN(this.f5269r) && Double.isNaN(oVar.f5269r)) || this.f5269r == oVar.f5269r) && this.f5270s == oVar.f5270s && this.f5271t == oVar.f5271t && Arrays.equals(this.f5272u, oVar.f5272u);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5266o, Integer.valueOf(this.f5267p), Boolean.valueOf(this.f5268q), Double.valueOf(this.f5269r), Double.valueOf(this.f5270s), Double.valueOf(this.f5271t), Integer.valueOf(Arrays.hashCode(this.f5272u)), String.valueOf(this.f5274w)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.f5274w;
        this.f5273v = jSONObject == null ? null : jSONObject.toString();
        int E = y7.d.E(parcel, 20293);
        y7.d.v(parcel, 2, this.f5266o, i10);
        int i11 = this.f5267p;
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(i11);
        boolean z10 = this.f5268q;
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(z10 ? 1 : 0);
        double d6 = this.f5269r;
        y7.d.D(parcel, 5, 8);
        parcel.writeDouble(d6);
        double d10 = this.f5270s;
        y7.d.D(parcel, 6, 8);
        parcel.writeDouble(d10);
        double d11 = this.f5271t;
        y7.d.D(parcel, 7, 8);
        parcel.writeDouble(d11);
        y7.d.u(parcel, 8, this.f5272u);
        y7.d.w(parcel, 9, this.f5273v);
        y7.d.G(parcel, E);
    }

    public o(JSONObject jSONObject) {
        this(null, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, null, null);
        b(jSONObject);
    }
}
