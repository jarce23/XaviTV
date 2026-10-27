package g7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends s7.a {
    public static final Parcelable.Creator<a> CREATOR = new v(0);
    public final JSONObject A;

    /* renamed from: o, reason: collision with root package name */
    public final String f5159o;

    /* renamed from: p, reason: collision with root package name */
    public final String f5160p;

    /* renamed from: q, reason: collision with root package name */
    public final long f5161q;

    /* renamed from: r, reason: collision with root package name */
    public final String f5162r;

    /* renamed from: s, reason: collision with root package name */
    public final String f5163s;

    /* renamed from: t, reason: collision with root package name */
    public final String f5164t;

    /* renamed from: u, reason: collision with root package name */
    public final String f5165u;

    /* renamed from: v, reason: collision with root package name */
    public final String f5166v;

    /* renamed from: w, reason: collision with root package name */
    public final String f5167w;

    /* renamed from: x, reason: collision with root package name */
    public final long f5168x;

    /* renamed from: y, reason: collision with root package name */
    public final String f5169y;

    /* renamed from: z, reason: collision with root package name */
    public final t f5170z;

    public a(String str, String str2, long j10, String str3, String str4, String str5, String str6, String str7, String str8, long j11, String str9, t tVar) {
        this.f5159o = str;
        this.f5160p = str2;
        this.f5161q = j10;
        this.f5162r = str3;
        this.f5163s = str4;
        this.f5164t = str5;
        this.f5165u = str6;
        this.f5166v = str7;
        this.f5167w = str8;
        this.f5168x = j11;
        this.f5169y = str9;
        this.f5170z = tVar;
        if (TextUtils.isEmpty(str6)) {
            this.A = new JSONObject();
            return;
        }
        try {
            this.A = new JSONObject(str6);
        } catch (JSONException e7) {
            Locale locale = Locale.ROOT;
            Log.w("AdBreakClipInfo", "Error creating AdBreakClipInfo: " + e7.getMessage());
            this.f5165u = null;
            this.A = new JSONObject();
        }
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f5159o);
            long j10 = this.f5161q;
            Pattern pattern = l7.a.f8269a;
            jSONObject.put("duration", j10 / 1000.0d);
            long j11 = this.f5168x;
            if (j11 != -1) {
                jSONObject.put("whenSkippable", j11 / 1000.0d);
            }
            String str = this.f5166v;
            if (str != null) {
                jSONObject.put("contentId", str);
            }
            String str2 = this.f5163s;
            if (str2 != null) {
                jSONObject.put("contentType", str2);
            }
            String str3 = this.f5160p;
            if (str3 != null) {
                jSONObject.put("title", str3);
            }
            String str4 = this.f5162r;
            if (str4 != null) {
                jSONObject.put("contentUrl", str4);
            }
            String str5 = this.f5164t;
            if (str5 != null) {
                jSONObject.put("clickThroughUrl", str5);
            }
            JSONObject jSONObject2 = this.A;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str6 = this.f5167w;
            if (str6 != null) {
                jSONObject.put("posterUrl", str6);
            }
            String str7 = this.f5169y;
            if (str7 != null) {
                jSONObject.put("hlsSegmentFormat", str7);
            }
            t tVar = this.f5170z;
            if (tVar != null) {
                jSONObject.put("vastAdsRequest", tVar.b());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return l7.a.d(this.f5159o, aVar.f5159o) && l7.a.d(this.f5160p, aVar.f5160p) && this.f5161q == aVar.f5161q && l7.a.d(this.f5162r, aVar.f5162r) && l7.a.d(this.f5163s, aVar.f5163s) && l7.a.d(this.f5164t, aVar.f5164t) && l7.a.d(this.f5165u, aVar.f5165u) && l7.a.d(this.f5166v, aVar.f5166v) && l7.a.d(this.f5167w, aVar.f5167w) && this.f5168x == aVar.f5168x && l7.a.d(this.f5169y, aVar.f5169y) && l7.a.d(this.f5170z, aVar.f5170z);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5159o, this.f5160p, Long.valueOf(this.f5161q), this.f5162r, this.f5163s, this.f5164t, this.f5165u, this.f5166v, this.f5167w, Long.valueOf(this.f5168x), this.f5169y, this.f5170z});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.w(parcel, 2, this.f5159o);
        y7.d.w(parcel, 3, this.f5160p);
        y7.d.D(parcel, 4, 8);
        parcel.writeLong(this.f5161q);
        y7.d.w(parcel, 5, this.f5162r);
        y7.d.w(parcel, 6, this.f5163s);
        y7.d.w(parcel, 7, this.f5164t);
        y7.d.w(parcel, 8, this.f5165u);
        y7.d.w(parcel, 9, this.f5166v);
        y7.d.w(parcel, 10, this.f5167w);
        y7.d.D(parcel, 11, 8);
        parcel.writeLong(this.f5168x);
        y7.d.w(parcel, 12, this.f5169y);
        y7.d.v(parcel, 13, this.f5170z, i10);
        y7.d.G(parcel, E);
    }
}
