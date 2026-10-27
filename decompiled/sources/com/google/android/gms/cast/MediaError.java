package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import g7.v;
import org.json.JSONObject;
import s7.a;
import y7.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MediaError extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<MediaError> CREATOR = new v(6);

    /* renamed from: o, reason: collision with root package name */
    public final String f3140o;

    /* renamed from: p, reason: collision with root package name */
    public final long f3141p;

    /* renamed from: q, reason: collision with root package name */
    public final Integer f3142q;

    /* renamed from: r, reason: collision with root package name */
    public final String f3143r;

    /* renamed from: s, reason: collision with root package name */
    public String f3144s;

    /* renamed from: t, reason: collision with root package name */
    public final JSONObject f3145t;

    public MediaError(String str, long j10, Integer num, String str2, JSONObject jSONObject) {
        this.f3140o = str;
        this.f3141p = j10;
        this.f3142q = num;
        this.f3143r = str2;
        this.f3145t = jSONObject;
    }

    public static MediaError b(JSONObject jSONObject) {
        return new MediaError(jSONObject.optString("type", "ERROR"), jSONObject.optLong("requestId"), jSONObject.has("detailedErrorCode") ? Integer.valueOf(jSONObject.optInt("detailedErrorCode")) : null, l7.a.a(jSONObject, "reason"), jSONObject.has("customData") ? jSONObject.optJSONObject("customData") : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.f3145t;
        this.f3144s = jSONObject == null ? null : jSONObject.toString();
        int E = d.E(parcel, 20293);
        d.w(parcel, 2, this.f3140o);
        d.D(parcel, 3, 8);
        parcel.writeLong(this.f3141p);
        d.t(parcel, 4, this.f3142q);
        d.w(parcel, 5, this.f3143r);
        d.w(parcel, 6, this.f3144s);
        d.G(parcel, E);
    }
}
