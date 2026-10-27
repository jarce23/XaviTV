package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import r7.r;
import s7.a;
import y7.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@Deprecated
/* loaded from: classes.dex */
public class GoogleSignInAccount extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new android.support.v4.media.a(19);

    /* renamed from: o, reason: collision with root package name */
    public final String f3116o;

    /* renamed from: p, reason: collision with root package name */
    public final String f3117p;

    /* renamed from: q, reason: collision with root package name */
    public final String f3118q;

    /* renamed from: r, reason: collision with root package name */
    public final String f3119r;

    /* renamed from: s, reason: collision with root package name */
    public final Uri f3120s;

    /* renamed from: t, reason: collision with root package name */
    public String f3121t;

    /* renamed from: u, reason: collision with root package name */
    public final long f3122u;

    /* renamed from: v, reason: collision with root package name */
    public final String f3123v;

    /* renamed from: w, reason: collision with root package name */
    public final List f3124w;

    /* renamed from: x, reason: collision with root package name */
    public final String f3125x;

    /* renamed from: y, reason: collision with root package name */
    public final String f3126y;

    /* renamed from: z, reason: collision with root package name */
    public final HashSet f3127z = new HashSet();

    public GoogleSignInAccount(String str, String str2, String str3, String str4, Uri uri, String str5, long j10, String str6, ArrayList arrayList, String str7, String str8) {
        this.f3116o = str;
        this.f3117p = str2;
        this.f3118q = str3;
        this.f3119r = str4;
        this.f3120s = uri;
        this.f3121t = str5;
        this.f3122u = j10;
        this.f3123v = str6;
        this.f3124w = arrayList;
        this.f3125x = str7;
        this.f3126y = str8;
    }

    public static GoogleSignInAccount b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            hashSet.add(new Scope(1, jSONArray.getString(i10)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String optString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String optString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String optString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String optString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        r.c(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(optString2, optString3, optString4, optString5, parse, null, parseLong, string, new ArrayList(hashSet), optString6, optString7);
        googleSignInAccount.f3121t = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.f3123v.equals(this.f3123v)) {
            return false;
        }
        HashSet hashSet = new HashSet(googleSignInAccount.f3124w);
        hashSet.addAll(googleSignInAccount.f3127z);
        HashSet hashSet2 = new HashSet(this.f3124w);
        hashSet2.addAll(this.f3127z);
        return hashSet.equals(hashSet2);
    }

    public final int hashCode() {
        int hashCode = this.f3123v.hashCode() + 527;
        HashSet hashSet = new HashSet(this.f3124w);
        hashSet.addAll(this.f3127z);
        return (hashCode * 31) + hashSet.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = d.E(parcel, 20293);
        d.w(parcel, 2, this.f3116o);
        d.w(parcel, 3, this.f3117p);
        d.w(parcel, 4, this.f3118q);
        d.w(parcel, 5, this.f3119r);
        d.v(parcel, 6, this.f3120s, i10);
        d.w(parcel, 7, this.f3121t);
        d.D(parcel, 8, 8);
        parcel.writeLong(this.f3122u);
        d.w(parcel, 9, this.f3123v);
        d.z(parcel, 10, this.f3124w);
        d.w(parcel, 11, this.f3125x);
        d.w(parcel, 12, this.f3126y);
        d.G(parcel, E);
    }
}
