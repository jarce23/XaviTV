package x1;

import java.util.List;
import java.util.Map;
import o9.b1;
import o9.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends p {

    /* renamed from: d, reason: collision with root package name */
    public final int f13412d;

    /* renamed from: e, reason: collision with root package name */
    public final long f13413e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f13414f;
    public final boolean g;

    /* renamed from: h, reason: collision with root package name */
    public final long f13415h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f13416i;

    /* renamed from: j, reason: collision with root package name */
    public final int f13417j;

    /* renamed from: k, reason: collision with root package name */
    public final long f13418k;

    /* renamed from: l, reason: collision with root package name */
    public final int f13419l;

    /* renamed from: m, reason: collision with root package name */
    public final long f13420m;

    /* renamed from: n, reason: collision with root package name */
    public final long f13421n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f13422o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f13423p;

    /* renamed from: q, reason: collision with root package name */
    public final i1.l f13424q;

    /* renamed from: r, reason: collision with root package name */
    public final g0 f13425r;

    /* renamed from: s, reason: collision with root package name */
    public final g0 f13426s;

    /* renamed from: t, reason: collision with root package name */
    public final b1 f13427t;

    /* renamed from: u, reason: collision with root package name */
    public final long f13428u;

    /* renamed from: v, reason: collision with root package name */
    public final k f13429v;

    /* renamed from: w, reason: collision with root package name */
    public final g0 f13430w;

    public l(int i10, String str, List list, long j10, boolean z10, long j11, boolean z11, int i11, long j12, int i12, long j13, long j14, boolean z12, boolean z13, boolean z14, i1.l lVar, List list2, List list3, k kVar, Map map, List list4) {
        super(str, list, z12);
        this.f13412d = i10;
        this.f13415h = j11;
        this.g = z10;
        this.f13416i = z11;
        this.f13417j = i11;
        this.f13418k = j12;
        this.f13419l = i12;
        this.f13420m = j13;
        this.f13421n = j14;
        this.f13422o = z13;
        this.f13423p = z14;
        this.f13424q = lVar;
        this.f13425r = g0.n(list2);
        this.f13426s = g0.n(list3);
        this.f13427t = b1.a(map);
        this.f13430w = g0.n(list4);
        if (!list3.isEmpty()) {
            g gVar = (g) o9.q.g(list3);
            this.f13428u = gVar.f13400s + gVar.f13398q;
        } else if (list2.isEmpty()) {
            this.f13428u = 0L;
        } else {
            i iVar = (i) o9.q.g(list2);
            this.f13428u = iVar.f13400s + iVar.f13398q;
        }
        this.f13413e = j10 != -9223372036854775807L ? j10 >= 0 ? Math.min(this.f13428u, j10) : Math.max(0L, this.f13428u + j10) : -9223372036854775807L;
        this.f13414f = j10 >= 0;
        this.f13429v = kVar;
    }

    @Override // x1.p
    public final Object a(List list) {
        return this;
    }
}
