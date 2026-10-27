package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import g7.v;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s7.a;
import y7.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class MediaTrack extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<MediaTrack> CREATOR = new v(16);

    /* renamed from: o, reason: collision with root package name */
    public final long f3158o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3159p;

    /* renamed from: q, reason: collision with root package name */
    public final String f3160q;

    /* renamed from: r, reason: collision with root package name */
    public final String f3161r;

    /* renamed from: s, reason: collision with root package name */
    public final String f3162s;

    /* renamed from: t, reason: collision with root package name */
    public final String f3163t;

    /* renamed from: u, reason: collision with root package name */
    public final int f3164u;

    /* renamed from: v, reason: collision with root package name */
    public final List f3165v;

    /* renamed from: w, reason: collision with root package name */
    public String f3166w;

    /* renamed from: x, reason: collision with root package name */
    public final JSONObject f3167x;

    public MediaTrack(long j10, int i10, String str, String str2, String str3, String str4, int i11, List list, JSONObject jSONObject) {
        this.f3158o = j10;
        this.f3159p = i10;
        this.f3160q = str;
        this.f3161r = str2;
        this.f3162s = str3;
        this.f3163t = str4;
        this.f3164u = i11;
        this.f3165v = list;
        this.f3167x = jSONObject;
    }

    public final JSONObject b() {
        String str = this.f3163t;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.f3158o);
            int i10 = this.f3159p;
            if (i10 == 1) {
                jSONObject.put("type", "TEXT");
            } else if (i10 == 2) {
                jSONObject.put("type", "AUDIO");
            } else if (i10 == 3) {
                jSONObject.put("type", "VIDEO");
            }
            String str2 = this.f3160q;
            if (str2 != null) {
                jSONObject.put("trackContentId", str2);
            }
            String str3 = this.f3161r;
            if (str3 != null) {
                jSONObject.put("trackContentType", str3);
            }
            String str4 = this.f3162s;
            if (str4 != null) {
                jSONObject.put("name", str4);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("language", str);
            }
            int i11 = this.f3164u;
            if (i11 == 1) {
                jSONObject.put("subtype", "SUBTITLES");
            } else if (i11 == 2) {
                jSONObject.put("subtype", "CAPTIONS");
            } else if (i11 == 3) {
                jSONObject.put("subtype", "DESCRIPTIONS");
            } else if (i11 == 4) {
                jSONObject.put("subtype", "CHAPTERS");
            } else if (i11 == 5) {
                jSONObject.put("subtype", "METADATA");
            }
            List list = this.f3165v;
            if (list != null) {
                jSONObject.put("roles", new JSONArray((Collection) list));
            }
            JSONObject jSONObject2 = this.f3167x;
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
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        JSONObject jSONObject = this.f3167x;
        boolean z10 = jSONObject == null;
        JSONObject jSONObject2 = mediaTrack.f3167x;
        if (z10 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || v7.a.a(jSONObject, jSONObject2)) && this.f3158o == mediaTrack.f3158o && this.f3159p == mediaTrack.f3159p && l7.a.d(this.f3160q, mediaTrack.f3160q) && l7.a.d(this.f3161r, mediaTrack.f3161r) && l7.a.d(this.f3162s, mediaTrack.f3162s) && l7.a.d(this.f3163t, mediaTrack.f3163t) && this.f3164u == mediaTrack.f3164u && l7.a.d(this.f3165v, mediaTrack.f3165v);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f3158o), Integer.valueOf(this.f3159p), this.f3160q, this.f3161r, this.f3162s, this.f3163t, Integer.valueOf(this.f3164u), this.f3165v, String.valueOf(this.f3167x)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.f3167x;
        this.f3166w = jSONObject == null ? null : jSONObject.toString();
        int E = d.E(parcel, 20293);
        d.D(parcel, 2, 8);
        parcel.writeLong(this.f3158o);
        d.D(parcel, 3, 4);
        parcel.writeInt(this.f3159p);
        d.w(parcel, 4, this.f3160q);
        d.w(parcel, 5, this.f3161r);
        d.w(parcel, 6, this.f3162s);
        d.w(parcel, 7, this.f3163t);
        d.D(parcel, 8, 4);
        parcel.writeInt(this.f3164u);
        d.x(parcel, 9, this.f3165v);
        d.w(parcel, 10, this.f3166w);
        d.G(parcel, E);
    }
}
