package o1;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f9428a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9429b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9430c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f9431d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f9432e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9433f;
    public final long g;

    /* renamed from: h, reason: collision with root package name */
    public final String f9434h;

    /* renamed from: i, reason: collision with root package name */
    public final int f9435i;

    static {
        i1.b0.a("media3.datasource");
    }

    public l(Uri uri, long j10, int i10, byte[] bArr, Map map, long j11, long j12, String str, int i11) {
        l1.d.b(j10 + j11 >= 0);
        l1.d.b(j11 >= 0);
        l1.d.b(j12 > 0 || j12 == -1);
        uri.getClass();
        this.f9428a = uri;
        this.f9429b = j10;
        this.f9430c = i10;
        this.f9431d = (bArr == null || bArr.length == 0) ? null : bArr;
        this.f9432e = Collections.unmodifiableMap(new HashMap(map));
        this.f9433f = j11;
        this.g = j12;
        this.f9434h = str;
        this.f9435i = i11;
    }

    public static String b(int i10) {
        if (i10 == 1) {
            return "GET";
        }
        if (i10 == 2) {
            return "POST";
        }
        if (i10 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public final k a() {
        k kVar = new k();
        kVar.f9420a = this.f9428a;
        kVar.f9421b = this.f9429b;
        kVar.f9422c = this.f9430c;
        kVar.f9423d = this.f9431d;
        kVar.f9424e = this.f9432e;
        kVar.f9425f = this.f9433f;
        kVar.g = this.g;
        kVar.f9426h = this.f9434h;
        kVar.f9427i = this.f9435i;
        return kVar;
    }

    public final l c(long j10, long j11) {
        if (j10 == 0 && this.g == j11) {
            return this;
        }
        return new l(this.f9428a, this.f9429b, this.f9430c, this.f9431d, this.f9432e, this.f9433f + j10, j11, this.f9434h, this.f9435i);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DataSpec[");
        sb2.append(b(this.f9430c));
        sb2.append(" ");
        sb2.append(this.f9428a);
        sb2.append(", ");
        sb2.append(this.f9433f);
        sb2.append(", ");
        sb2.append(this.g);
        sb2.append(", ");
        sb2.append(this.f9434h);
        sb2.append(", ");
        return r.a.d(sb2, this.f9435i, "]");
    }
}
