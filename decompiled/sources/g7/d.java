package g7;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends s7.a {
    public static final Parcelable.Creator<d> CREATOR = new v(17);

    /* renamed from: o, reason: collision with root package name */
    public final String f5192o;

    /* renamed from: p, reason: collision with root package name */
    public final String f5193p;

    /* renamed from: q, reason: collision with root package name */
    public final List f5194q;

    /* renamed from: r, reason: collision with root package name */
    public final String f5195r;

    /* renamed from: s, reason: collision with root package name */
    public final Uri f5196s;

    /* renamed from: t, reason: collision with root package name */
    public final String f5197t;

    /* renamed from: u, reason: collision with root package name */
    public final String f5198u;

    /* renamed from: v, reason: collision with root package name */
    public final Boolean f5199v;

    /* renamed from: w, reason: collision with root package name */
    public final Boolean f5200w;

    public d(String str, String str2, ArrayList arrayList, String str3, Uri uri, String str4, String str5, Boolean bool, Boolean bool2) {
        this.f5192o = str;
        this.f5193p = str2;
        this.f5194q = arrayList;
        this.f5195r = str3;
        this.f5196s = uri;
        this.f5197t = str4;
        this.f5198u = str5;
        this.f5199v = bool;
        this.f5200w = bool2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return l7.a.d(this.f5192o, dVar.f5192o) && l7.a.d(this.f5193p, dVar.f5193p) && l7.a.d(this.f5194q, dVar.f5194q) && l7.a.d(this.f5195r, dVar.f5195r) && l7.a.d(this.f5196s, dVar.f5196s) && l7.a.d(this.f5197t, dVar.f5197t) && l7.a.d(this.f5198u, dVar.f5198u);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5192o, this.f5193p, this.f5194q, this.f5195r, this.f5196s, this.f5197t});
    }

    public final String toString() {
        List list = this.f5194q;
        return "applicationId: " + this.f5192o + ", name: " + this.f5193p + ", namespaces.count: " + (list == null ? 0 : list.size()) + ", senderAppIdentifier: " + this.f5195r + ", senderAppLaunchUrl: " + String.valueOf(this.f5196s) + ", iconUrl: " + this.f5197t + ", type: " + this.f5198u;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.w(parcel, 2, this.f5192o);
        y7.d.w(parcel, 3, this.f5193p);
        y7.d.x(parcel, 5, Collections.unmodifiableList(this.f5194q));
        y7.d.w(parcel, 6, this.f5195r);
        y7.d.v(parcel, 7, this.f5196s, i10);
        y7.d.w(parcel, 8, this.f5197t);
        y7.d.w(parcel, 9, this.f5198u);
        y7.d.p(parcel, 10, this.f5199v);
        y7.d.p(parcel, 11, this.f5200w);
        y7.d.G(parcel, E);
    }
}
