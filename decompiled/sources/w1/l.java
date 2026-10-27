package w1;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import c2.d0;
import c2.i1;
import c2.j0;
import i1.a0;
import i1.b0;
import i1.v;
import i1.w;
import i1.x;
import j9.v1;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o1.e0;
import o9.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends c2.a {

    /* renamed from: h, reason: collision with root package name */
    public final c f12820h;

    /* renamed from: i, reason: collision with root package name */
    public final p4.p f12821i;

    /* renamed from: j, reason: collision with root package name */
    public final d9.f f12822j;

    /* renamed from: k, reason: collision with root package name */
    public final v1.f f12823k;

    /* renamed from: l, reason: collision with root package name */
    public final n7.i f12824l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f12825m;

    /* renamed from: n, reason: collision with root package name */
    public final int f12826n;

    /* renamed from: o, reason: collision with root package name */
    public final x1.c f12827o;

    /* renamed from: p, reason: collision with root package name */
    public final long f12828p;

    /* renamed from: q, reason: collision with root package name */
    public w f12829q;

    /* renamed from: r, reason: collision with root package name */
    public e0 f12830r;

    /* renamed from: s, reason: collision with root package name */
    public a0 f12831s;

    static {
        b0.a("media3.exoplayer.hls");
    }

    public l(a0 a0Var, p4.p pVar, c cVar, d9.f fVar, v1.f fVar2, n7.i iVar, x1.c cVar2, long j10, boolean z10, int i10) {
        this.f12831s = a0Var;
        this.f12829q = a0Var.f5794c;
        this.f12821i = pVar;
        this.f12820h = cVar;
        this.f12822j = fVar;
        this.f12823k = fVar2;
        this.f12824l = iVar;
        this.f12827o = cVar2;
        this.f12828p = j10;
        this.f12825m = z10;
        this.f12826n = i10;
    }

    public static x1.g s(long j10, List list) {
        x1.g gVar = null;
        for (int i10 = 0; i10 < list.size(); i10++) {
            x1.g gVar2 = (x1.g) list.get(i10);
            long j11 = gVar2.f13400s;
            if (j11 > j10 || !gVar2.f13391z) {
                if (j11 > j10) {
                    break;
                }
            } else {
                gVar = gVar2;
            }
        }
        return gVar;
    }

    @Override // c2.a
    public final c2.b0 a(d0 d0Var, g2.e eVar, long j10) {
        j0 j0Var = new j0(this.f2520c.f2623c, 0, d0Var);
        j0 j0Var2 = new j0(this.f2521d.f2623c, 0, d0Var);
        e0 e0Var = this.f12830r;
        t1.u uVar = this.g;
        l1.d.h(uVar);
        return new k(this.f12820h, this.f12827o, this.f12821i, e0Var, this.f12823k, j0Var2, this.f12824l, j0Var, eVar, this.f12822j, this.f12825m, this.f12826n, uVar);
    }

    @Override // c2.a
    public final synchronized a0 g() {
        return this.f12831s;
    }

    @Override // c2.a
    public final void i() {
        x1.c cVar = this.f12827o;
        g2.n nVar = cVar.f13349u;
        if (nVar != null) {
            IOException iOException = nVar.f5132c;
            if (iOException != null) {
                throw iOException;
            }
            g2.j jVar = nVar.f5131b;
            if (jVar != null) {
                int i10 = jVar.f5117o;
                IOException iOException2 = jVar.f5121s;
                if (iOException2 != null && jVar.f5122t > i10) {
                    throw iOException2;
                }
            }
        }
        Uri uri = cVar.f13353y;
        if (uri != null) {
            x1.b bVar = (x1.b) cVar.f13346r.get(uri);
            g2.n nVar2 = bVar.f13332p;
            IOException iOException3 = nVar2.f5132c;
            if (iOException3 != null) {
                throw iOException3;
            }
            g2.j jVar2 = nVar2.f5131b;
            if (jVar2 != null) {
                int i11 = jVar2.f5117o;
                IOException iOException4 = jVar2.f5121s;
                if (iOException4 != null && jVar2.f5122t > i11) {
                    throw iOException4;
                }
            }
            IOException iOException5 = bVar.f13340x;
            if (iOException5 != null) {
                throw iOException5;
            }
        }
    }

    @Override // c2.a
    public final void k(e0 e0Var) {
        this.f12830r = e0Var;
        Looper myLooper = Looper.myLooper();
        myLooper.getClass();
        t1.u uVar = this.g;
        l1.d.h(uVar);
        v1.f fVar = this.f12823k;
        fVar.n(myLooper, uVar);
        fVar.b();
        j0 j0Var = new j0(this.f2520c.f2623c, 0, null);
        x xVar = g().f5793b;
        xVar.getClass();
        Uri uri = xVar.f6061a;
        x1.c cVar = this.f12827o;
        cVar.getClass();
        cVar.f13350v = l1.a0.n(null);
        cVar.f13348t = j0Var;
        cVar.f13351w = this;
        Map map = Collections.EMPTY_MAP;
        l1.d.i("The uri must be set.", uri);
        g2.p pVar = new g2.p(((o1.g) cVar.f13343o.f9953p).d(), new o1.l(uri, 0L, 1, null, map, 0L, -1L, null, 1), cVar.f13344p.v());
        l1.d.g(cVar.f13349u == null);
        g2.n nVar = new g2.n("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        cVar.f13349u = nVar;
        nVar.d(pVar, cVar, cVar.f13345q.D(pVar.f5135c));
    }

    @Override // c2.a
    public final void m(c2.b0 b0Var) {
        k kVar = (k) b0Var;
        kVar.f12809p.f13347s.remove(kVar);
        for (r rVar : kVar.H) {
            if (rVar.R) {
                for (q qVar : rVar.J) {
                    qVar.j();
                    p4.p pVar = qVar.f2550h;
                    if (pVar != null) {
                        pVar.m(qVar.f2548e);
                        qVar.f2550h = null;
                        qVar.g = null;
                    }
                }
            }
            i iVar = rVar.f12860r;
            x1.b bVar = (x1.b) iVar.g.f13346r.get(iVar.f12778e[iVar.f12790r.j()]);
            if (bVar != null) {
                bVar.f13341y = false;
            }
            iVar.f12786n = null;
            rVar.f12866x.c(rVar);
            rVar.F.removeCallbacksAndMessages(null);
            rVar.V = true;
            rVar.G.clear();
        }
        kVar.E = null;
    }

    @Override // c2.a
    public final void o() {
        x1.c cVar = this.f12827o;
        cVar.f13353y = null;
        cVar.f13354z = null;
        cVar.f13352x = null;
        cVar.B = -9223372036854775807L;
        cVar.f13349u.c(null);
        cVar.f13349u = null;
        HashMap hashMap = cVar.f13346r;
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            ((x1.b) it.next()).f13332p.c(null);
        }
        cVar.f13350v.removeCallbacksAndMessages(null);
        cVar.f13350v = null;
        hashMap.clear();
        this.f12823k.a();
    }

    @Override // c2.a
    public final synchronized void r(a0 a0Var) {
        this.f12831s = a0Var;
    }

    public final void t(x1.l lVar) {
        long j10;
        i1 i1Var;
        boolean z10;
        long j11;
        long j12;
        long j13;
        long j14;
        boolean z11 = lVar.f13423p;
        boolean z12 = lVar.g;
        g0 g0Var = lVar.f13425r;
        long j15 = lVar.f13428u;
        long j16 = lVar.f13413e;
        int i10 = lVar.f13412d;
        long j17 = lVar.f13415h;
        long Z = z11 ? l1.a0.Z(j17) : -9223372036854775807L;
        long j18 = (i10 == 2 || i10 == 1) ? Z : -9223372036854775807L;
        x1.c cVar = this.f12827o;
        cVar.f13352x.getClass();
        v1 v1Var = new v1(24);
        long j19 = 0;
        if (cVar.A) {
            x1.k kVar = lVar.f13429v;
            long j20 = j17 - cVar.B;
            boolean z13 = lVar.f13422o;
            long j21 = z13 ? j20 + j15 : -9223372036854775807L;
            if (lVar.f13423p) {
                int i11 = l1.a0.f8067a;
                z10 = z12;
                long j22 = this.f12828p;
                j11 = l1.a0.O(j22 == -9223372036854775807L ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + j22) - (j17 + j15);
            } else {
                z10 = z12;
                j11 = 0;
            }
            long j23 = this.f12829q.f6053a;
            if (j23 != -9223372036854775807L) {
                j13 = l1.a0.O(j23);
            } else {
                if (j16 != -9223372036854775807L) {
                    j12 = j15 - j16;
                } else {
                    j12 = kVar.f13410d;
                    if (j12 == -9223372036854775807L || lVar.f13421n == -9223372036854775807L) {
                        j12 = kVar.f13409c;
                        if (j12 == -9223372036854775807L) {
                            j12 = 3 * lVar.f13420m;
                        }
                    }
                }
                j13 = j12 + j11;
            }
            long j24 = j15 + j11;
            long j25 = l1.a0.j(j13, j11, j24);
            w wVar = g().f5794c;
            boolean z14 = wVar.f6056d == -3.4028235E38f && wVar.f6057e == -3.4028235E38f && kVar.f13409c == -9223372036854775807L && kVar.f13410d == -9223372036854775807L;
            v vVar = new v();
            vVar.f6044a = l1.a0.Z(j25);
            vVar.f6047d = z14 ? 1.0f : this.f12829q.f6056d;
            vVar.f6048e = z14 ? 1.0f : this.f12829q.f6057e;
            w wVar2 = new w(vVar);
            this.f12829q = wVar2;
            if (j16 == -9223372036854775807L) {
                j16 = j24 - l1.a0.O(wVar2.f6053a);
            }
            if (z10) {
                j19 = j16;
            } else {
                x1.g s10 = s(j16, lVar.f13426s);
                if (s10 != null) {
                    j14 = s10.f13400s;
                } else if (!g0Var.isEmpty()) {
                    x1.i iVar = (x1.i) g0Var.get(l1.a0.c(g0Var, Long.valueOf(j16), true));
                    x1.g s11 = s(j16, iVar.A);
                    j14 = s11 != null ? s11.f13400s : iVar.f13400s;
                }
                j19 = j14;
            }
            i1Var = new i1(j18, Z, j21, lVar.f13428u, j20, j19, true, !z13, i10 == 2 && lVar.f13414f, v1Var, g(), this.f12829q);
        } else {
            if (j16 == -9223372036854775807L || g0Var.isEmpty()) {
                j10 = 0;
            } else {
                if (!z12 && j16 != j15) {
                    j16 = ((x1.i) g0Var.get(l1.a0.c(g0Var, Long.valueOf(j16), true))).f13400s;
                }
                j10 = j16;
            }
            long j26 = lVar.f13428u;
            i1Var = new i1(j18, Z, j26, j26, 0L, j10, true, false, true, v1Var, g(), null);
        }
        l(i1Var);
    }
}
