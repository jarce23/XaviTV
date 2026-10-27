package x1;

import android.net.Uri;
import android.os.SystemClock;
import c2.j0;
import c2.u;
import i1.h0;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l1.a0;
import o1.x;
import o9.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements g2.i {

    /* renamed from: o, reason: collision with root package name */
    public final Uri f13331o;

    /* renamed from: p, reason: collision with root package name */
    public final g2.n f13332p = new g2.n("DefaultHlsPlaylistTracker:MediaPlaylist");

    /* renamed from: q, reason: collision with root package name */
    public final o1.h f13333q;

    /* renamed from: r, reason: collision with root package name */
    public l f13334r;

    /* renamed from: s, reason: collision with root package name */
    public long f13335s;

    /* renamed from: t, reason: collision with root package name */
    public long f13336t;

    /* renamed from: u, reason: collision with root package name */
    public long f13337u;

    /* renamed from: v, reason: collision with root package name */
    public long f13338v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f13339w;

    /* renamed from: x, reason: collision with root package name */
    public IOException f13340x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13341y;

    /* renamed from: z, reason: collision with root package name */
    public final /* synthetic */ c f13342z;

    public b(c cVar, Uri uri) {
        this.f13342z = cVar;
        this.f13331o = uri;
        this.f13333q = ((o1.g) cVar.f13343o.f9953p).d();
    }

    public static boolean a(b bVar, long j10) {
        bVar.f13338v = SystemClock.elapsedRealtime() + j10;
        Uri uri = bVar.f13331o;
        c cVar = bVar.f13342z;
        if (!uri.equals(cVar.f13353y)) {
            return false;
        }
        List list = cVar.f13352x.f13442e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar2 = (b) cVar.f13346r.get(((n) list.get(i10)).f13434a);
            bVar2.getClass();
            if (elapsedRealtime > bVar2.f13338v) {
                Uri uri2 = bVar2.f13331o;
                cVar.f13353y = uri2;
                bVar2.g(cVar.c(uri2));
                return false;
            }
        }
        return true;
    }

    @Override // g2.i
    public final void b(g2.k kVar, long j10, long j11) {
        g2.p pVar = (g2.p) kVar;
        p pVar2 = (p) pVar.f5138f;
        Uri uri = pVar.f5136d.f9390q;
        u uVar = new u(j11);
        if (pVar2 instanceof l) {
            h((l) pVar2, uVar);
            this.f13342z.f13348t.c(uVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        } else {
            h0 b2 = h0.b("Loaded playlist has unexpected type.");
            this.f13340x = b2;
            this.f13342z.f13348t.d(uVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, b2, true);
        }
        this.f13342z.f13345q.getClass();
    }

    public final Uri c() {
        l lVar = this.f13334r;
        Uri uri = this.f13331o;
        if (lVar != null) {
            k kVar = lVar.f13429v;
            if (kVar.f13407a != -9223372036854775807L || kVar.f13411e) {
                Uri.Builder buildUpon = uri.buildUpon();
                l lVar2 = this.f13334r;
                if (lVar2.f13429v.f13411e) {
                    buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(lVar2.f13418k + lVar2.f13425r.size()));
                    l lVar3 = this.f13334r;
                    if (lVar3.f13421n != -9223372036854775807L) {
                        g0 g0Var = lVar3.f13426s;
                        int size = g0Var.size();
                        if (!g0Var.isEmpty() && ((g) o9.q.g(g0Var)).A) {
                            size--;
                        }
                        buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                    }
                }
                k kVar2 = this.f13334r.f13429v;
                if (kVar2.f13407a != -9223372036854775807L) {
                    buildUpon.appendQueryParameter("_HLS_skip", kVar2.f13408b ? "v2" : "YES");
                }
                return buildUpon.build();
            }
        }
        return uri;
    }

    @Override // g2.i
    public final g2.h d(g2.k kVar, long j10, long j11, IOException iOException, int i10) {
        g2.p pVar = (g2.p) kVar;
        long j12 = pVar.f5133a;
        int i11 = pVar.f5135c;
        Uri uri = pVar.f5136d.f9390q;
        u uVar = new u(j11);
        boolean z10 = uri.getQueryParameter("_HLS_msn") != null;
        boolean z11 = iOException instanceof q;
        g2.h hVar = g2.n.f5128e;
        c cVar = this.f13342z;
        if (z10 || z11) {
            int i12 = iOException instanceof x ? ((x) iOException).f9462r : Integer.MAX_VALUE;
            if (z11 || i12 == 400 || i12 == 503) {
                this.f13337u = SystemClock.elapsedRealtime();
                e(false);
                j0 j0Var = cVar.f13348t;
                int i13 = a0.f8067a;
                j0Var.d(uVar, i11, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, true);
                return hVar;
            }
        }
        app.shamel.tv.b bVar = new app.shamel.tv.b(i10, 6, iOException);
        Iterator it = cVar.f13347s.iterator();
        boolean z12 = false;
        while (it.hasNext()) {
            z12 |= !((t) it.next()).c(this.f13331o, bVar, false);
        }
        n7.i iVar = cVar.f13345q;
        if (z12) {
            iVar.getClass();
            long E = n7.i.E(bVar);
            hVar = E != -9223372036854775807L ? new g2.h(0, E, false) : g2.n.f5129f;
        }
        int i14 = hVar.f5115a;
        boolean z13 = i14 == 0 || i14 == 1;
        cVar.f13348t.d(uVar, i11, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, !z13);
        if (!z13) {
            iVar.getClass();
        }
        return hVar;
    }

    public final void e(boolean z10) {
        g(z10 ? c() : this.f13331o);
    }

    public final void f(Uri uri) {
        c cVar = this.f13342z;
        g2.o g = cVar.f13344p.g(cVar.f13352x, this.f13334r);
        Map map = Collections.EMPTY_MAP;
        l1.d.i("The uri must be set.", uri);
        g2.p pVar = new g2.p(this.f13333q, new o1.l(uri, 0L, 1, null, map, 0L, -1L, null, 1), g);
        this.f13332p.d(pVar, this, cVar.f13345q.D(pVar.f5135c));
    }

    public final void g(Uri uri) {
        this.f13338v = 0L;
        if (this.f13339w) {
            return;
        }
        g2.n nVar = this.f13332p;
        if (nVar.b() || nVar.f5132c != null) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.f13337u;
        if (elapsedRealtime >= j10) {
            f(uri);
        } else {
            this.f13339w = true;
            this.f13342z.f13350v.postDelayed(new androidx.fragment.app.d(this, 29, uri), j10 - elapsedRealtime);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(x1.l r73, c2.u r74) {
        /*
            Method dump skipped, instructions count: 658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.b.h(x1.l, c2.u):void");
    }

    @Override // g2.i
    public final void i(g2.k kVar, long j10, long j11, int i10) {
        u uVar;
        g2.p pVar = (g2.p) kVar;
        if (i10 == 0) {
            long j12 = pVar.f5133a;
            uVar = new u(pVar.f5134b);
        } else {
            long j13 = pVar.f5133a;
            Uri uri = pVar.f5136d.f9390q;
            uVar = new u(j11);
        }
        this.f13342z.f13348t.e(uVar, pVar.f5135c, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, i10);
    }

    @Override // g2.i
    public final void u(g2.k kVar, long j10, long j11, boolean z10) {
        g2.p pVar = (g2.p) kVar;
        long j12 = pVar.f5133a;
        Uri uri = pVar.f5136d.f9390q;
        u uVar = new u(j11);
        c cVar = this.f13342z;
        cVar.f13345q.getClass();
        cVar.f13348t.b(uVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
