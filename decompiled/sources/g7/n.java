package g7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends s7.a {
    public static final Parcelable.Creator<n> CREATOR = new v(13);

    /* renamed from: o, reason: collision with root package name */
    public String f5256o;

    /* renamed from: p, reason: collision with root package name */
    public String f5257p;

    /* renamed from: q, reason: collision with root package name */
    public int f5258q;

    /* renamed from: r, reason: collision with root package name */
    public String f5259r;

    /* renamed from: s, reason: collision with root package name */
    public m f5260s;

    /* renamed from: t, reason: collision with root package name */
    public int f5261t;

    /* renamed from: u, reason: collision with root package name */
    public List f5262u;

    /* renamed from: v, reason: collision with root package name */
    public int f5263v;

    /* renamed from: w, reason: collision with root package name */
    public long f5264w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f5265x;

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a3 A[Catch: JSONException -> 0x00fa, TryCatch #0 {JSONException -> 0x00fa, blocks: (B:3:0x0005, B:5:0x000d, B:6:0x0014, B:8:0x001c, B:9:0x0023, B:12:0x002b, B:13:0x0031, B:14:0x0037, B:15:0x003d, B:16:0x0043, B:17:0x0049, B:18:0x004f, B:19:0x0055, B:20:0x005b, B:21:0x0060, B:23:0x0068, B:24:0x006f, B:26:0x0073, B:27:0x007c, B:32:0x00a3, B:33:0x00a8, B:35:0x00ac, B:37:0x00b2, B:38:0x00bd, B:40:0x00c3, B:42:0x00d1, B:43:0x00d6, B:45:0x00e5, B:46:0x00f3, B:50:0x0085), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3 A[Catch: JSONException -> 0x00fa, LOOP:0: B:38:0x00bd->B:40:0x00c3, LOOP_END, TryCatch #0 {JSONException -> 0x00fa, blocks: (B:3:0x0005, B:5:0x000d, B:6:0x0014, B:8:0x001c, B:9:0x0023, B:12:0x002b, B:13:0x0031, B:14:0x0037, B:15:0x003d, B:16:0x0043, B:17:0x0049, B:18:0x004f, B:19:0x0055, B:20:0x005b, B:21:0x0060, B:23:0x0068, B:24:0x006f, B:26:0x0073, B:27:0x007c, B:32:0x00a3, B:33:0x00a8, B:35:0x00ac, B:37:0x00b2, B:38:0x00bd, B:40:0x00c3, B:42:0x00d1, B:43:0x00d6, B:45:0x00e5, B:46:0x00f3, B:50:0x0085), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e5 A[Catch: JSONException -> 0x00fa, TryCatch #0 {JSONException -> 0x00fa, blocks: (B:3:0x0005, B:5:0x000d, B:6:0x0014, B:8:0x001c, B:9:0x0023, B:12:0x002b, B:13:0x0031, B:14:0x0037, B:15:0x003d, B:16:0x0043, B:17:0x0049, B:18:0x004f, B:19:0x0055, B:20:0x005b, B:21:0x0060, B:23:0x0068, B:24:0x006f, B:26:0x0073, B:27:0x007c, B:32:0x00a3, B:33:0x00a8, B:35:0x00ac, B:37:0x00b2, B:38:0x00bd, B:40:0x00c3, B:42:0x00d1, B:43:0x00d6, B:45:0x00e5, B:46:0x00f3, B:50:0x0085), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject b() {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.n.b():org.json.JSONObject");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return TextUtils.equals(this.f5256o, nVar.f5256o) && TextUtils.equals(this.f5257p, nVar.f5257p) && this.f5258q == nVar.f5258q && TextUtils.equals(this.f5259r, nVar.f5259r) && r7.r.h(this.f5260s, nVar.f5260s) && this.f5261t == nVar.f5261t && r7.r.h(this.f5262u, nVar.f5262u) && this.f5263v == nVar.f5263v && this.f5264w == nVar.f5264w && this.f5265x == nVar.f5265x;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5256o, this.f5257p, Integer.valueOf(this.f5258q), this.f5259r, this.f5260s, Integer.valueOf(this.f5261t), this.f5262u, Integer.valueOf(this.f5263v), Long.valueOf(this.f5264w), Boolean.valueOf(this.f5265x)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.w(parcel, 2, this.f5256o);
        y7.d.w(parcel, 3, this.f5257p);
        int i11 = this.f5258q;
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(i11);
        y7.d.w(parcel, 5, this.f5259r);
        y7.d.v(parcel, 6, this.f5260s, i10);
        int i12 = this.f5261t;
        y7.d.D(parcel, 7, 4);
        parcel.writeInt(i12);
        List list = this.f5262u;
        y7.d.z(parcel, 8, list == null ? null : Collections.unmodifiableList(list));
        int i13 = this.f5263v;
        y7.d.D(parcel, 9, 4);
        parcel.writeInt(i13);
        long j10 = this.f5264w;
        y7.d.D(parcel, 10, 8);
        parcel.writeLong(j10);
        boolean z10 = this.f5265x;
        y7.d.D(parcel, 11, 4);
        parcel.writeInt(z10 ? 1 : 0);
        y7.d.G(parcel, E);
    }
}
