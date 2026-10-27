package x1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class j implements Comparable {

    /* renamed from: o, reason: collision with root package name */
    public final String f13396o;

    /* renamed from: p, reason: collision with root package name */
    public final i f13397p;

    /* renamed from: q, reason: collision with root package name */
    public final long f13398q;

    /* renamed from: r, reason: collision with root package name */
    public final int f13399r;

    /* renamed from: s, reason: collision with root package name */
    public final long f13400s;

    /* renamed from: t, reason: collision with root package name */
    public final i1.l f13401t;

    /* renamed from: u, reason: collision with root package name */
    public final String f13402u;

    /* renamed from: v, reason: collision with root package name */
    public final String f13403v;

    /* renamed from: w, reason: collision with root package name */
    public final long f13404w;

    /* renamed from: x, reason: collision with root package name */
    public final long f13405x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f13406y;

    public j(String str, i iVar, long j10, int i10, long j11, i1.l lVar, String str2, String str3, long j12, long j13, boolean z10) {
        this.f13396o = str;
        this.f13397p = iVar;
        this.f13398q = j10;
        this.f13399r = i10;
        this.f13400s = j11;
        this.f13401t = lVar;
        this.f13402u = str2;
        this.f13403v = str3;
        this.f13404w = j12;
        this.f13405x = j13;
        this.f13406y = z10;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        Long l10 = (Long) obj;
        long longValue = l10.longValue();
        long j10 = this.f13400s;
        if (j10 > longValue) {
            return 1;
        }
        return j10 < l10.longValue() ? -1 : 0;
    }
}
