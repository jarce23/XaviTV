package x1;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import c2.j0;
import c2.u;
import i1.g0;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import l1.a0;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements g2.i {
    public static final t1.k C = new t1.k(7);
    public boolean A;

    /* renamed from: o, reason: collision with root package name */
    public final p4.p f13343o;

    /* renamed from: p, reason: collision with root package name */
    public final s f13344p;

    /* renamed from: q, reason: collision with root package name */
    public final n7.i f13345q;

    /* renamed from: t, reason: collision with root package name */
    public j0 f13348t;

    /* renamed from: u, reason: collision with root package name */
    public g2.n f13349u;

    /* renamed from: v, reason: collision with root package name */
    public Handler f13350v;

    /* renamed from: w, reason: collision with root package name */
    public w1.l f13351w;

    /* renamed from: x, reason: collision with root package name */
    public o f13352x;

    /* renamed from: y, reason: collision with root package name */
    public Uri f13353y;

    /* renamed from: z, reason: collision with root package name */
    public l f13354z;

    /* renamed from: s, reason: collision with root package name */
    public final CopyOnWriteArrayList f13347s = new CopyOnWriteArrayList();

    /* renamed from: r, reason: collision with root package name */
    public final HashMap f13346r = new HashMap();
    public long B = -9223372036854775807L;

    public c(p4.p pVar, n7.i iVar, s sVar) {
        this.f13343o = pVar;
        this.f13344p = sVar;
        this.f13345q = iVar;
    }

    public final l a(Uri uri, boolean z10) {
        HashMap hashMap = this.f13346r;
        l lVar = ((b) hashMap.get(uri)).f13334r;
        if (lVar != null && z10) {
            if (!uri.equals(this.f13353y)) {
                List list = this.f13352x.f13442e;
                int i10 = 0;
                while (true) {
                    if (i10 >= list.size()) {
                        break;
                    }
                    if (uri.equals(((n) list.get(i10)).f13434a)) {
                        l lVar2 = this.f13354z;
                        if (lVar2 == null || !lVar2.f13422o) {
                            this.f13353y = uri;
                            b bVar = (b) hashMap.get(uri);
                            l lVar3 = bVar.f13334r;
                            if (lVar3 == null || !lVar3.f13422o) {
                                bVar.g(c(uri));
                            } else {
                                this.f13354z = lVar3;
                                this.f13351w.t(lVar3);
                            }
                        }
                    } else {
                        i10++;
                    }
                }
            }
            b bVar2 = (b) hashMap.get(uri);
            l lVar4 = bVar2.f13334r;
            if (!bVar2.f13341y) {
                bVar2.f13341y = true;
                if (lVar4 != null && !lVar4.f13422o) {
                    bVar2.e(true);
                }
            }
        }
        return lVar;
    }

    @Override // g2.i
    public final void b(g2.k kVar, long j10, long j11) {
        o oVar;
        g2.p pVar = (g2.p) kVar;
        p pVar2 = (p) pVar.f5138f;
        boolean z10 = pVar2 instanceof l;
        if (z10) {
            String str = pVar2.f13450a;
            o oVar2 = o.f13440n;
            Uri parse = Uri.parse(str);
            i1.o oVar3 = new i1.o();
            oVar3.f5929a = "0";
            oVar3.f5939l = g0.m("application/x-mpegURL");
            List singletonList = Collections.singletonList(new n(parse, new i1.p(oVar3), null, null, null, null));
            List list = Collections.EMPTY_LIST;
            oVar = new o(_UrlKt.FRAGMENT_ENCODE_SET, list, singletonList, list, list, list, list, null, null, false, Collections.EMPTY_MAP, list);
        } else {
            oVar = (o) pVar2;
        }
        this.f13352x = oVar;
        this.f13353y = ((n) oVar.f13442e.get(0)).f13434a;
        this.f13347s.add(new a(this));
        List list2 = oVar.f13441d;
        int size = list2.size();
        for (int i10 = 0; i10 < size; i10++) {
            Uri uri = (Uri) list2.get(i10);
            this.f13346r.put(uri, new b(this, uri));
        }
        Uri uri2 = pVar.f5136d.f9390q;
        u uVar = new u(j11);
        b bVar = (b) this.f13346r.get(this.f13353y);
        if (z10) {
            bVar.h((l) pVar2, uVar);
        } else {
            bVar.e(false);
        }
        this.f13345q.getClass();
        this.f13348t.c(uVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public final Uri c(Uri uri) {
        h hVar;
        l lVar = this.f13354z;
        if (lVar == null || !lVar.f13429v.f13411e || (hVar = (h) lVar.f13427t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(hVar.f13393b));
        int i10 = hVar.f13394c;
        if (i10 != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i10));
        }
        return buildUpon.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    @Override // g2.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final g2.h d(g2.k r18, long r19, long r21, java.io.IOException r23, int r24) {
        /*
            r17 = this;
            r0 = r17
            r12 = r23
            r1 = r18
            g2.p r1 = (g2.p) r1
            c2.u r2 = new c2.u
            long r3 = r1.f5133a
            o1.c0 r3 = r1.f5136d
            android.net.Uri r3 = r3.f9390q
            r3 = r21
            r2.<init>(r3)
            int r3 = r1.f5135c
            n7.i r1 = r0.f13345q
            r1.getClass()
            boolean r1 = r12 instanceof i1.h0
            r4 = 1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L57
            boolean r1 = r12 instanceof java.io.FileNotFoundException
            if (r1 != 0) goto L57
            boolean r1 = r12 instanceof o1.t
            if (r1 != 0) goto L57
            boolean r1 = r12 instanceof g2.m
            if (r1 != 0) goto L57
            int r1 = o1.i.f9413p
            r1 = r12
        L35:
            if (r1 == 0) goto L4a
            boolean r7 = r1 instanceof o1.i
            if (r7 == 0) goto L45
            r7 = r1
            o1.i r7 = (o1.i) r7
            int r7 = r7.f9414o
            r8 = 2008(0x7d8, float:2.814E-42)
            if (r7 != r8) goto L45
            goto L57
        L45:
            java.lang.Throwable r1 = r1.getCause()
            goto L35
        L4a:
            int r1 = r24 + (-1)
            int r1 = r1 * 1000
            r7 = 5000(0x1388, float:7.006E-42)
            int r1 = java.lang.Math.min(r1, r7)
            long r7 = (long) r1
            r14 = r7
            goto L58
        L57:
            r14 = r5
        L58:
            int r1 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            r5 = 0
            if (r1 != 0) goto L5f
            r13 = r4
            goto L60
        L5f:
            r13 = r5
        L60:
            c2.j0 r1 = r0.f13348t
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4 = -1
            r6 = r5
            r5 = 0
            r7 = r6
            r6 = 0
            r16 = r7
            r7 = 0
            r0 = r16
            r1.d(r2, r3, r4, r5, r6, r7, r8, r10, r12, r13)
            if (r13 == 0) goto L7e
            g2.h r0 = g2.n.f5129f
            return r0
        L7e:
            g2.h r1 = new g2.h
            r1.<init>(r0, r14, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.c.d(g2.k, long, long, java.io.IOException, int):g2.h");
    }

    public final boolean e(Uri uri) {
        int i10;
        b bVar = (b) this.f13346r.get(uri);
        if (bVar.f13334r == null) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long max = Math.max(30000L, a0.Z(bVar.f13334r.f13428u));
        l lVar = bVar.f13334r;
        return lVar.f13422o || (i10 = lVar.f13412d) == 2 || i10 == 1 || bVar.f13335s + max > elapsedRealtime;
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
        this.f13348t.e(uVar, pVar.f5135c, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, i10);
    }

    @Override // g2.i
    public final void u(g2.k kVar, long j10, long j11, boolean z10) {
        g2.p pVar = (g2.p) kVar;
        long j12 = pVar.f5133a;
        Uri uri = pVar.f5136d.f9390q;
        u uVar = new u(j11);
        this.f13345q.getClass();
        this.f13348t.b(uVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
