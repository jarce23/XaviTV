package s1;

import android.os.SystemClock;
import c2.n1;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: u, reason: collision with root package name */
    public static final c2.d0 f11492u = new c2.d0(new Object());

    /* renamed from: a, reason: collision with root package name */
    public final i1.t0 f11493a;

    /* renamed from: b, reason: collision with root package name */
    public final c2.d0 f11494b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11495c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11496d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11497e;

    /* renamed from: f, reason: collision with root package name */
    public final l f11498f;
    public final boolean g;

    /* renamed from: h, reason: collision with root package name */
    public final n1 f11499h;

    /* renamed from: i, reason: collision with root package name */
    public final f2.x f11500i;

    /* renamed from: j, reason: collision with root package name */
    public final List f11501j;

    /* renamed from: k, reason: collision with root package name */
    public final c2.d0 f11502k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f11503l;

    /* renamed from: m, reason: collision with root package name */
    public final int f11504m;

    /* renamed from: n, reason: collision with root package name */
    public final int f11505n;

    /* renamed from: o, reason: collision with root package name */
    public final i1.j0 f11506o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f11507p;

    /* renamed from: q, reason: collision with root package name */
    public volatile long f11508q;

    /* renamed from: r, reason: collision with root package name */
    public volatile long f11509r;

    /* renamed from: s, reason: collision with root package name */
    public volatile long f11510s;

    /* renamed from: t, reason: collision with root package name */
    public volatile long f11511t;

    public y0(i1.t0 t0Var, c2.d0 d0Var, long j10, long j11, int i10, l lVar, boolean z10, n1 n1Var, f2.x xVar, List list, c2.d0 d0Var2, boolean z11, int i11, int i12, i1.j0 j0Var, long j12, long j13, long j14, long j15, boolean z12) {
        this.f11493a = t0Var;
        this.f11494b = d0Var;
        this.f11495c = j10;
        this.f11496d = j11;
        this.f11497e = i10;
        this.f11498f = lVar;
        this.g = z10;
        this.f11499h = n1Var;
        this.f11500i = xVar;
        this.f11501j = list;
        this.f11502k = d0Var2;
        this.f11503l = z11;
        this.f11504m = i11;
        this.f11505n = i12;
        this.f11506o = j0Var;
        this.f11508q = j12;
        this.f11509r = j13;
        this.f11510s = j14;
        this.f11511t = j15;
        this.f11507p = z12;
    }

    public static y0 k(f2.x xVar) {
        i1.q0 q0Var = i1.t0.f6037a;
        n1 n1Var = n1.f2659d;
        o9.w0 w0Var = o9.w0.f9686s;
        i1.j0 j0Var = i1.j0.f5905d;
        c2.d0 d0Var = f11492u;
        return new y0(q0Var, d0Var, -9223372036854775807L, 0L, 1, null, false, n1Var, xVar, w0Var, d0Var, false, 1, 0, j0Var, 0L, 0L, 0L, 0L, false);
    }

    public final y0 a() {
        return new y0(this.f11493a, this.f11494b, this.f11495c, this.f11496d, this.f11497e, this.f11498f, this.g, this.f11499h, this.f11500i, this.f11501j, this.f11502k, this.f11503l, this.f11504m, this.f11505n, this.f11506o, this.f11508q, this.f11509r, l(), SystemClock.elapsedRealtime(), this.f11507p);
    }

    public final y0 b(boolean z10) {
        return new y0(this.f11493a, this.f11494b, this.f11495c, this.f11496d, this.f11497e, this.f11498f, z10, this.f11499h, this.f11500i, this.f11501j, this.f11502k, this.f11503l, this.f11504m, this.f11505n, this.f11506o, this.f11508q, this.f11509r, this.f11510s, this.f11511t, this.f11507p);
    }

    public final y0 c(c2.d0 d0Var) {
        return new y0(this.f11493a, this.f11494b, this.f11495c, this.f11496d, this.f11497e, this.f11498f, this.g, this.f11499h, this.f11500i, this.f11501j, d0Var, this.f11503l, this.f11504m, this.f11505n, this.f11506o, this.f11508q, this.f11509r, this.f11510s, this.f11511t, this.f11507p);
    }

    public final y0 d(c2.d0 d0Var, long j10, long j11, long j12, long j13, n1 n1Var, f2.x xVar, List list) {
        return new y0(this.f11493a, d0Var, j11, j12, this.f11497e, this.f11498f, this.g, n1Var, xVar, list, this.f11502k, this.f11503l, this.f11504m, this.f11505n, this.f11506o, this.f11508q, j13, j10, SystemClock.elapsedRealtime(), this.f11507p);
    }

    public final y0 e(int i10, int i11, boolean z10) {
        return new y0(this.f11493a, this.f11494b, this.f11495c, this.f11496d, this.f11497e, this.f11498f, this.g, this.f11499h, this.f11500i, this.f11501j, this.f11502k, z10, i10, i11, this.f11506o, this.f11508q, this.f11509r, this.f11510s, this.f11511t, this.f11507p);
    }

    public final y0 f(l lVar) {
        return new y0(this.f11493a, this.f11494b, this.f11495c, this.f11496d, this.f11497e, lVar, this.g, this.f11499h, this.f11500i, this.f11501j, this.f11502k, this.f11503l, this.f11504m, this.f11505n, this.f11506o, this.f11508q, this.f11509r, this.f11510s, this.f11511t, this.f11507p);
    }

    public final y0 g(i1.j0 j0Var) {
        return new y0(this.f11493a, this.f11494b, this.f11495c, this.f11496d, this.f11497e, this.f11498f, this.g, this.f11499h, this.f11500i, this.f11501j, this.f11502k, this.f11503l, this.f11504m, this.f11505n, j0Var, this.f11508q, this.f11509r, this.f11510s, this.f11511t, this.f11507p);
    }

    public final y0 h(int i10) {
        return new y0(this.f11493a, this.f11494b, this.f11495c, this.f11496d, i10, this.f11498f, this.g, this.f11499h, this.f11500i, this.f11501j, this.f11502k, this.f11503l, this.f11504m, this.f11505n, this.f11506o, this.f11508q, this.f11509r, this.f11510s, this.f11511t, this.f11507p);
    }

    public final y0 i(boolean z10) {
        return new y0(this.f11493a, this.f11494b, this.f11495c, this.f11496d, this.f11497e, this.f11498f, this.g, this.f11499h, this.f11500i, this.f11501j, this.f11502k, this.f11503l, this.f11504m, this.f11505n, this.f11506o, this.f11508q, this.f11509r, this.f11510s, this.f11511t, z10);
    }

    public final y0 j(i1.t0 t0Var) {
        return new y0(t0Var, this.f11494b, this.f11495c, this.f11496d, this.f11497e, this.f11498f, this.g, this.f11499h, this.f11500i, this.f11501j, this.f11502k, this.f11503l, this.f11504m, this.f11505n, this.f11506o, this.f11508q, this.f11509r, this.f11510s, this.f11511t, this.f11507p);
    }

    public final long l() {
        long j10;
        long j11;
        if (!m()) {
            return this.f11510s;
        }
        do {
            j10 = this.f11511t;
            j11 = this.f11510s;
        } while (j10 != this.f11511t);
        return l1.a0.O(l1.a0.Z(j11) + ((long) ((SystemClock.elapsedRealtime() - j10) * this.f11506o.f5906a)));
    }

    public final boolean m() {
        return this.f11497e == 3 && this.f11503l && this.f11505n == 0;
    }
}
