package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import g7.b;
import g7.l;
import g7.s;
import g7.t;
import g7.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.internal.url._UrlKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s7.a;
import y7.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MediaInfo extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<MediaInfo> CREATOR;
    public final long A;
    public final String B;
    public final String C;
    public final String D;
    public final String E;
    public final JSONObject F;

    /* renamed from: o, reason: collision with root package name */
    public final String f3146o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3147p;

    /* renamed from: q, reason: collision with root package name */
    public final String f3148q;

    /* renamed from: r, reason: collision with root package name */
    public final l f3149r;

    /* renamed from: s, reason: collision with root package name */
    public final long f3150s;

    /* renamed from: t, reason: collision with root package name */
    public final List f3151t;

    /* renamed from: u, reason: collision with root package name */
    public final s f3152u;

    /* renamed from: v, reason: collision with root package name */
    public String f3153v;

    /* renamed from: w, reason: collision with root package name */
    public List f3154w;

    /* renamed from: x, reason: collision with root package name */
    public List f3155x;

    /* renamed from: y, reason: collision with root package name */
    public final String f3156y;

    /* renamed from: z, reason: collision with root package name */
    public final t f3157z;

    static {
        Pattern pattern = l7.a.f8269a;
        CREATOR = new v(7);
    }

    public MediaInfo(String str, int i10, String str2, l lVar, long j10, ArrayList arrayList, s sVar, String str3, ArrayList arrayList2, ArrayList arrayList3, String str4, t tVar, long j11, String str5, String str6, String str7, String str8) {
        this.f3146o = str;
        this.f3147p = i10;
        this.f3148q = str2;
        this.f3149r = lVar;
        this.f3150s = j10;
        this.f3151t = arrayList;
        this.f3152u = sVar;
        this.f3153v = str3;
        if (str3 != null) {
            try {
                this.F = new JSONObject(this.f3153v);
            } catch (JSONException unused) {
                this.F = null;
                this.f3153v = null;
            }
        } else {
            this.F = null;
        }
        this.f3154w = arrayList2;
        this.f3155x = arrayList3;
        this.f3156y = str4;
        this.f3157z = tVar;
        this.A = j11;
        this.B = str5;
        this.C = str6;
        this.D = str7;
        this.E = str8;
        if (this.f3146o == null && str6 == null && str4 == null) {
            throw new IllegalArgumentException("Either contentID or contentUrl or entity should be set");
        }
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.f3146o);
            jSONObject.putOpt("contentUrl", this.C);
            int i10 = this.f3147p;
            jSONObject.put("streamType", i10 != 1 ? i10 != 2 ? "NONE" : "LIVE" : "BUFFERED");
            String str = this.f3148q;
            if (str != null) {
                jSONObject.put("contentType", str);
            }
            l lVar = this.f3149r;
            if (lVar != null) {
                jSONObject.put("metadata", lVar.c());
            }
            long j10 = this.f3150s;
            if (j10 <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                Pattern pattern = l7.a.f8269a;
                jSONObject.put("duration", j10 / 1000.0d);
            }
            List list = this.f3151t;
            if (list != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((MediaTrack) it.next()).b());
                }
                jSONObject.put("tracks", jSONArray);
            }
            s sVar = this.f3152u;
            if (sVar != null) {
                jSONObject.put("textTrackStyle", sVar.b());
            }
            JSONObject jSONObject2 = this.F;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str2 = this.f3156y;
            if (str2 != null) {
                jSONObject.put("entity", str2);
            }
            if (this.f3154w != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator it2 = this.f3154w.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(((b) it2.next()).b());
                }
                jSONObject.put("breaks", jSONArray2);
            }
            if (this.f3155x != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator it3 = this.f3155x.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(((g7.a) it3.next()).b());
                }
                jSONObject.put("breakClips", jSONArray3);
            }
            t tVar = this.f3157z;
            if (tVar != null) {
                jSONObject.put("vmapAdsRequest", tVar.b());
            }
            long j11 = this.A;
            if (j11 != -1) {
                Pattern pattern2 = l7.a.f8269a;
                jSONObject.put("startAbsoluteTime", j11 / 1000.0d);
            }
            jSONObject.putOpt("atvEntity", this.B);
            String str3 = this.D;
            if (str3 != null) {
                jSONObject.put("hlsSegmentFormat", str3);
            }
            String str4 = this.E;
            if (str4 != null) {
                jSONObject.put("hlsVideoSegmentFormat", str4);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00b9 A[LOOP:0: B:4:0x0024->B:11:0x00b9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01b2 A[LOOP:1: B:18:0x00e7->B:24:0x01b2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(org.json.JSONObject r43) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaInfo.c(org.json.JSONObject):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        JSONObject jSONObject = this.F;
        boolean z10 = jSONObject == null;
        JSONObject jSONObject2 = mediaInfo.F;
        if (z10 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || v7.a.a(jSONObject, jSONObject2)) && l7.a.d(this.f3146o, mediaInfo.f3146o) && this.f3147p == mediaInfo.f3147p && l7.a.d(this.f3148q, mediaInfo.f3148q) && l7.a.d(this.f3149r, mediaInfo.f3149r) && this.f3150s == mediaInfo.f3150s && l7.a.d(this.f3151t, mediaInfo.f3151t) && l7.a.d(this.f3152u, mediaInfo.f3152u) && l7.a.d(this.f3154w, mediaInfo.f3154w) && l7.a.d(this.f3155x, mediaInfo.f3155x) && l7.a.d(this.f3156y, mediaInfo.f3156y) && l7.a.d(this.f3157z, mediaInfo.f3157z) && this.A == mediaInfo.A && l7.a.d(this.B, mediaInfo.B) && l7.a.d(this.C, mediaInfo.C) && l7.a.d(this.D, mediaInfo.D) && l7.a.d(this.E, mediaInfo.E);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3146o, Integer.valueOf(this.f3147p), this.f3148q, this.f3149r, Long.valueOf(this.f3150s), String.valueOf(this.F), this.f3151t, this.f3152u, this.f3154w, this.f3155x, this.f3156y, this.f3157z, Long.valueOf(this.A), this.B, this.D, this.E});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.F;
        this.f3153v = jSONObject == null ? null : jSONObject.toString();
        int E = d.E(parcel, 20293);
        String str = this.f3146o;
        if (str == null) {
            str = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        d.w(parcel, 2, str);
        d.D(parcel, 3, 4);
        parcel.writeInt(this.f3147p);
        d.w(parcel, 4, this.f3148q);
        d.v(parcel, 5, this.f3149r, i10);
        d.D(parcel, 6, 8);
        parcel.writeLong(this.f3150s);
        d.z(parcel, 7, this.f3151t);
        d.v(parcel, 8, this.f3152u, i10);
        d.w(parcel, 9, this.f3153v);
        List list = this.f3154w;
        d.z(parcel, 10, list == null ? null : Collections.unmodifiableList(list));
        List list2 = this.f3155x;
        d.z(parcel, 11, list2 != null ? Collections.unmodifiableList(list2) : null);
        d.w(parcel, 12, this.f3156y);
        d.v(parcel, 13, this.f3157z, i10);
        d.D(parcel, 14, 8);
        parcel.writeLong(this.A);
        d.w(parcel, 15, this.B);
        d.w(parcel, 16, this.C);
        d.w(parcel, 17, this.D);
        d.w(parcel, 18, this.E);
        d.G(parcel, E);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0311  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MediaInfo(org.json.JSONObject r46) {
        /*
            Method dump skipped, instructions count: 968
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaInfo.<init>(org.json.JSONObject):void");
    }
}
