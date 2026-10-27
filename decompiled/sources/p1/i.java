package p1;

import java.io.File;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i implements Comparable {

    /* renamed from: o, reason: collision with root package name */
    public final String f9841o;

    /* renamed from: p, reason: collision with root package name */
    public final long f9842p;

    /* renamed from: q, reason: collision with root package name */
    public final long f9843q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f9844r;

    /* renamed from: s, reason: collision with root package name */
    public final File f9845s;

    /* renamed from: t, reason: collision with root package name */
    public final long f9846t;

    public i(String str, long j10, long j11, long j12, File file) {
        this.f9841o = str;
        this.f9842p = j10;
        this.f9843q = j11;
        this.f9844r = file != null;
        this.f9845s = file;
        this.f9846t = j12;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        i iVar = (i) obj;
        String str = iVar.f9841o;
        String str2 = this.f9841o;
        if (!str2.equals(str)) {
            return str2.compareTo(iVar.f9841o);
        }
        long j10 = this.f9842p - iVar.f9842p;
        if (j10 == 0) {
            return 0;
        }
        return j10 < 0 ? -1 : 1;
    }

    public final String toString() {
        return "[" + this.f9842p + ", " + this.f9843q + "]";
    }
}
