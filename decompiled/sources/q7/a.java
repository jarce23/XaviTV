package q7;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Locale;
import l7.d;
import r7.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends s7.a {
    public static final Parcelable.Creator<a> CREATOR = new d(10);

    /* renamed from: o, reason: collision with root package name */
    public final int f10358o;

    /* renamed from: p, reason: collision with root package name */
    public final Uri f10359p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10360q;

    /* renamed from: r, reason: collision with root package name */
    public final int f10361r;

    public a(int i10, Uri uri, int i11, int i12) {
        this.f10358o = i10;
        this.f10359p = uri;
        this.f10360q = i11;
        this.f10361r = i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (r.h(this.f10359p, aVar.f10359p) && this.f10360q == aVar.f10360q && this.f10361r == aVar.f10361r) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10359p, Integer.valueOf(this.f10360q), Integer.valueOf(this.f10361r)});
    }

    public final String toString() {
        Locale locale = Locale.US;
        String uri = this.f10359p.toString();
        StringBuilder g = r.a.g("Image ", this.f10360q, "x", this.f10361r, " ");
        g.append(uri);
        return g.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(this.f10358o);
        y7.d.v(parcel, 2, this.f10359p, i10);
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(this.f10360q);
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(this.f10361r);
        y7.d.G(parcel, E);
    }

    public a(Uri uri, int i10, int i11) {
        this(1, uri, i10, i11);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(org.json.JSONObject r5) {
        /*
            r4 = this;
            android.net.Uri r0 = android.net.Uri.EMPTY
            java.lang.String r1 = "url"
            boolean r2 = r5.has(r1)
            if (r2 == 0) goto L12
            java.lang.String r1 = r5.getString(r1)     // Catch: org.json.JSONException -> L12
            android.net.Uri r0 = android.net.Uri.parse(r1)     // Catch: org.json.JSONException -> L12
        L12:
            java.lang.String r1 = "width"
            r2 = 0
            int r1 = r5.optInt(r1, r2)
            java.lang.String r3 = "height"
            int r5 = r5.optInt(r3, r2)
            r4.<init>(r0, r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.a.<init>(org.json.JSONObject):void");
    }
}
