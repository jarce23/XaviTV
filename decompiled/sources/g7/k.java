package g7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.MediaInfo;
import java.util.Arrays;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends s7.a {
    public static final l7.b B = new l7.b("MediaLoadRequestData", null);
    public static final Parcelable.Creator<k> CREATOR = new v(10);
    public final long A;

    /* renamed from: o, reason: collision with root package name */
    public final MediaInfo f5234o;

    /* renamed from: p, reason: collision with root package name */
    public final n f5235p;

    /* renamed from: q, reason: collision with root package name */
    public final Boolean f5236q;

    /* renamed from: r, reason: collision with root package name */
    public final long f5237r;

    /* renamed from: s, reason: collision with root package name */
    public final double f5238s;

    /* renamed from: t, reason: collision with root package name */
    public final long[] f5239t;

    /* renamed from: u, reason: collision with root package name */
    public String f5240u;

    /* renamed from: v, reason: collision with root package name */
    public final JSONObject f5241v;

    /* renamed from: w, reason: collision with root package name */
    public final String f5242w;

    /* renamed from: x, reason: collision with root package name */
    public final String f5243x;

    /* renamed from: y, reason: collision with root package name */
    public final String f5244y;

    /* renamed from: z, reason: collision with root package name */
    public final String f5245z;

    public k(MediaInfo mediaInfo, n nVar, Boolean bool, long j10, double d6, long[] jArr, JSONObject jSONObject, String str, String str2, String str3, String str4, long j11) {
        this.f5234o = mediaInfo;
        this.f5235p = nVar;
        this.f5236q = bool;
        this.f5237r = j10;
        this.f5238s = d6;
        this.f5239t = jArr;
        this.f5241v = jSONObject;
        this.f5242w = str;
        this.f5243x = str2;
        this.f5244y = str3;
        this.f5245z = str4;
        this.A = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return v7.a.a(this.f5241v, kVar.f5241v) && r7.r.h(this.f5234o, kVar.f5234o) && r7.r.h(this.f5235p, kVar.f5235p) && r7.r.h(this.f5236q, kVar.f5236q) && this.f5237r == kVar.f5237r && this.f5238s == kVar.f5238s && Arrays.equals(this.f5239t, kVar.f5239t) && r7.r.h(this.f5242w, kVar.f5242w) && r7.r.h(this.f5243x, kVar.f5243x) && r7.r.h(this.f5244y, kVar.f5244y) && r7.r.h(this.f5245z, kVar.f5245z) && this.A == kVar.A;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5234o, this.f5235p, this.f5236q, Long.valueOf(this.f5237r), Double.valueOf(this.f5238s), this.f5239t, String.valueOf(this.f5241v), this.f5242w, this.f5243x, this.f5244y, this.f5245z, Long.valueOf(this.A)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.f5241v;
        this.f5240u = jSONObject == null ? null : jSONObject.toString();
        int E = y7.d.E(parcel, 20293);
        y7.d.v(parcel, 2, this.f5234o, i10);
        y7.d.v(parcel, 3, this.f5235p, i10);
        y7.d.p(parcel, 4, this.f5236q);
        y7.d.D(parcel, 5, 8);
        parcel.writeLong(this.f5237r);
        y7.d.D(parcel, 6, 8);
        parcel.writeDouble(this.f5238s);
        y7.d.u(parcel, 7, this.f5239t);
        y7.d.w(parcel, 8, this.f5240u);
        y7.d.w(parcel, 9, this.f5242w);
        y7.d.w(parcel, 10, this.f5243x);
        y7.d.w(parcel, 11, this.f5244y);
        y7.d.w(parcel, 12, this.f5245z);
        y7.d.D(parcel, 13, 8);
        parcel.writeLong(this.A);
        y7.d.G(parcel, E);
    }
}
