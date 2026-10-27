package w1;

import android.net.Uri;
import android.util.Pair;
import i1.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import l1.a0;
import o1.e0;
import o9.g0;
import o9.w0;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final c f12774a;

    /* renamed from: b, reason: collision with root package name */
    public final o1.h f12775b;

    /* renamed from: c, reason: collision with root package name */
    public final o1.h f12776c;

    /* renamed from: d, reason: collision with root package name */
    public final p4.p f12777d;

    /* renamed from: e, reason: collision with root package name */
    public final Uri[] f12778e;

    /* renamed from: f, reason: collision with root package name */
    public final i1.p[] f12779f;
    public final x1.c g;

    /* renamed from: h, reason: collision with root package name */
    public final u0 f12780h;

    /* renamed from: i, reason: collision with root package name */
    public final List f12781i;

    /* renamed from: k, reason: collision with root package name */
    public final t1.u f12783k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12784l;

    /* renamed from: n, reason: collision with root package name */
    public c2.b f12786n;

    /* renamed from: o, reason: collision with root package name */
    public Uri f12787o;

    /* renamed from: p, reason: collision with root package name */
    public Uri f12788p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12789q;

    /* renamed from: r, reason: collision with root package name */
    public f2.t f12790r;

    /* renamed from: j, reason: collision with root package name */
    public final p4.p f12782j = new p4.p(23);

    /* renamed from: m, reason: collision with root package name */
    public byte[] f12785m = a0.f8069c;

    /* renamed from: s, reason: collision with root package name */
    public long f12791s = -9223372036854775807L;

    public i(c cVar, x1.c cVar2, Uri[] uriArr, i1.p[] pVarArr, p4.p pVar, e0 e0Var, p4.p pVar2, List list, t1.u uVar) {
        this.f12774a = cVar;
        this.g = cVar2;
        this.f12778e = uriArr;
        this.f12779f = pVarArr;
        this.f12777d = pVar2;
        this.f12781i = list;
        this.f12783k = uVar;
        o1.h d6 = ((o1.g) pVar.f9953p).d();
        this.f12775b = d6;
        if (e0Var != null) {
            d6.g(e0Var);
        }
        this.f12776c = ((o1.g) pVar.f9953p).d();
        this.f12780h = new u0(_UrlKt.FRAGMENT_ENCODE_SET, pVarArr);
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (int i11 = 0; i11 < uriArr.length; i11++) {
            if ((pVarArr[i11].f5984f & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        u0 u0Var = this.f12780h;
        int[] u10 = com.google.android.gms.internal.cast.n.u(arrayList);
        g gVar = new g(u0Var, u10);
        i1.p pVar3 = u0Var.f6042d[u10[0]];
        while (true) {
            if (i10 >= gVar.f4884b) {
                i10 = -1;
                break;
            } else if (gVar.f4886d[i10] == pVar3) {
                break;
            } else {
                i10++;
            }
        }
        gVar.g = i10;
        this.f12790r = gVar;
    }

    public static h d(x1.l lVar, long j10, int i10) {
        long j11 = lVar.f13418k;
        g0 g0Var = lVar.f13426s;
        int i11 = (int) (j10 - j11);
        g0 g0Var2 = lVar.f13425r;
        if (i11 == g0Var2.size()) {
            if (i10 == -1) {
                i10 = 0;
            }
            if (i10 < g0Var.size()) {
                return new h((x1.j) g0Var.get(i10), j10, i10);
            }
            return null;
        }
        x1.i iVar = (x1.i) g0Var2.get(i11);
        if (i10 == -1) {
            return new h(iVar, j10, -1);
        }
        if (i10 < iVar.A.size()) {
            return new h((x1.j) iVar.A.get(i10), j10, i10);
        }
        int i12 = i11 + 1;
        if (i12 < g0Var2.size()) {
            return new h((x1.j) g0Var2.get(i12), j10 + 1, -1);
        }
        if (g0Var.isEmpty()) {
            return null;
        }
        return new h((x1.j) g0Var.get(0), j10 + 1, 0);
    }

    public final d2.c[] a(j jVar, long j10) {
        List list;
        i iVar = this;
        j jVar2 = jVar;
        int a10 = jVar2 == null ? -1 : iVar.f12780h.a(jVar2.f3999d);
        int length = iVar.f12790r.length();
        d2.c[] cVarArr = new d2.c[length];
        boolean z10 = false;
        int i10 = 0;
        while (i10 < length) {
            int f10 = iVar.f12790r.f(i10);
            Uri uri = iVar.f12778e[f10];
            x1.c cVar = iVar.g;
            if (cVar.e(uri)) {
                x1.l a11 = cVar.a(uri, z10);
                a11.getClass();
                long j11 = a11.f13415h - cVar.B;
                Pair c10 = iVar.c(jVar2, f10 != a10 ? true : z10, a11, j11, j10);
                long longValue = ((Long) c10.first).longValue();
                int intValue = ((Integer) c10.second).intValue();
                long j12 = a11.f13418k;
                g0 g0Var = a11.f13426s;
                g0 g0Var2 = a11.f13425r;
                int i11 = (int) (longValue - j12);
                if (i11 < 0 || g0Var2.size() < i11) {
                    o9.e0 e0Var = g0.f9617p;
                    list = w0.f9686s;
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (i11 < g0Var2.size()) {
                        if (intValue != -1) {
                            x1.i iVar2 = (x1.i) g0Var2.get(i11);
                            if (intValue == 0) {
                                arrayList.add(iVar2);
                            } else if (intValue < iVar2.A.size()) {
                                g0 g0Var3 = iVar2.A;
                                arrayList.addAll(g0Var3.subList(intValue, g0Var3.size()));
                            }
                            i11++;
                        }
                        arrayList.addAll(g0Var2.subList(i11, g0Var2.size()));
                        intValue = 0;
                    }
                    if (a11.f13421n != -9223372036854775807L) {
                        if (intValue == -1) {
                            intValue = 0;
                        }
                        if (intValue < g0Var.size()) {
                            arrayList.addAll(g0Var.subList(intValue, g0Var.size()));
                        }
                    }
                    list = Collections.unmodifiableList(arrayList);
                }
                cVarArr[i10] = new f(j11, list);
            } else {
                cVarArr[i10] = d2.c.f4005a;
            }
            i10++;
            iVar = this;
            jVar2 = jVar;
            z10 = false;
        }
        return cVarArr;
    }

    public final int b(j jVar) {
        int i10 = jVar.f12796o;
        if (i10 == -1) {
            return 1;
        }
        x1.l a10 = this.g.a(this.f12778e[this.f12780h.a(jVar.f3999d)], false);
        a10.getClass();
        g0 g0Var = a10.f13425r;
        int i11 = (int) (jVar.f4004j - a10.f13418k);
        if (i11 < 0) {
            return 1;
        }
        g0 g0Var2 = i11 < g0Var.size() ? ((x1.i) g0Var.get(i11)).A : a10.f13426s;
        if (i10 >= g0Var2.size()) {
            return 2;
        }
        x1.g gVar = (x1.g) g0Var2.get(i10);
        if (gVar.A) {
            return 0;
        }
        return Objects.equals(Uri.parse(l1.b.o(a10.f13450a, gVar.f13396o)), jVar.f3997b.f9428a) ? 1 : 2;
    }

    public final Pair c(j jVar, boolean z10, x1.l lVar, long j10, long j11) {
        int i10;
        boolean z11 = true;
        if (jVar != null) {
            long j12 = jVar.f4004j;
            int i11 = jVar.f12796o;
            if (!z10) {
                if (!jVar.H) {
                    return new Pair(Long.valueOf(j12), Integer.valueOf(i11));
                }
                if (i11 == -1) {
                    j12 = j12 != -1 ? j12 + 1 : -1L;
                }
                return new Pair(Long.valueOf(j12), Integer.valueOf(i11 != -1 ? i11 + 1 : -1));
            }
        }
        long j13 = lVar.f13428u;
        g0 g0Var = lVar.f13426s;
        long j14 = lVar.f13418k;
        g0 g0Var2 = lVar.f13425r;
        long j15 = j10 + j13;
        long j16 = (jVar == null || this.f12789q) ? j11 : jVar.g;
        if (!lVar.f13422o && j16 >= j15) {
            return new Pair(Long.valueOf(j14 + g0Var2.size()), -1);
        }
        long j17 = j16 - j10;
        Long valueOf = Long.valueOf(j17);
        int i12 = 0;
        if (this.g.A && jVar != null) {
            z11 = false;
        }
        int c10 = a0.c(g0Var2, valueOf, z11);
        long j18 = c10 + j14;
        if (c10 >= 0) {
            x1.i iVar = (x1.i) g0Var2.get(c10);
            g0 g0Var3 = j17 < iVar.f13400s + iVar.f13398q ? iVar.A : g0Var;
            while (true) {
                if (i12 >= g0Var3.size()) {
                    break;
                }
                x1.g gVar = (x1.g) g0Var3.get(i12);
                if (j17 >= gVar.f13400s + gVar.f13398q) {
                    i12++;
                } else if (gVar.f13391z) {
                    j18 += g0Var3 == g0Var ? 1L : 0L;
                    i10 = i12;
                }
            }
        }
        i10 = -1;
        return new Pair(Long.valueOf(j18), Integer.valueOf(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e e(Uri uri, int i10, boolean z10) {
        if (uri == null) {
            return null;
        }
        p4.p pVar = this.f12782j;
        byte[] bArr = (byte[]) ((d) pVar.f9953p).remove(uri);
        if (bArr != null) {
            return null;
        }
        o1.l lVar = new o1.l(uri, 0L, 1, null, Collections.EMPTY_MAP, 0L, -1L, null, 1);
        i1.p pVar2 = this.f12779f[i10];
        int m10 = this.f12790r.m();
        Object q10 = this.f12790r.q();
        byte[] bArr2 = this.f12785m;
        e eVar = new e(this.f12776c, lVar, 3, pVar2, m10, q10, -9223372036854775807L, -9223372036854775807L);
        if (bArr2 == null) {
            bArr2 = a0.f8069c;
        }
        eVar.f12763j = bArr2;
        return eVar;
    }
}
