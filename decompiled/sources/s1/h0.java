package s1;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import c2.h1;
import c2.n1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 implements Handler.Callback, c2.a0, z0, i2.y {

    /* renamed from: s0, reason: collision with root package name */
    public static final long f11318s0 = l1.a0.Z(10000);
    public final long A;
    public final i2.o B;
    public final ArrayList C;
    public final l1.v D;
    public final s E;
    public final o0 F;
    public final d9.p G;
    public final g H;
    public final long I;
    public final t1.u J;
    public final t1.o K;
    public final l1.x L;
    public final boolean M;
    public final c N;
    public f1 O;
    public boolean Q;
    public boolean R;
    public g0 S;
    public y0 T;
    public b4.u U;
    public boolean V;
    public boolean X;
    public boolean Y;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f11319a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f11320b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f11321c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f11322d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f11323e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f11324f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f11325g0;
    public g0 h0;

    /* renamed from: i0, reason: collision with root package name */
    public long f11326i0;

    /* renamed from: j0, reason: collision with root package name */
    public long f11327j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f11328k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f11329l0;

    /* renamed from: m0, reason: collision with root package name */
    public l f11330m0;

    /* renamed from: o, reason: collision with root package name */
    public final l4.f0[] f11332o;

    /* renamed from: o0, reason: collision with root package name */
    public o f11333o0;

    /* renamed from: p, reason: collision with root package name */
    public final d[] f11334p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean[] f11336q;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f11337q0;

    /* renamed from: r, reason: collision with root package name */
    public final f2.w f11338r;

    /* renamed from: s, reason: collision with root package name */
    public final f2.x f11340s;

    /* renamed from: t, reason: collision with root package name */
    public final i f11341t;

    /* renamed from: u, reason: collision with root package name */
    public final g2.d f11342u;

    /* renamed from: v, reason: collision with root package name */
    public final l1.x f11343v;

    /* renamed from: w, reason: collision with root package name */
    public final com.google.android.gms.internal.cast.v f11344w;

    /* renamed from: x, reason: collision with root package name */
    public final Looper f11345x;

    /* renamed from: y, reason: collision with root package name */
    public final i1.s0 f11346y;

    /* renamed from: z, reason: collision with root package name */
    public final i1.r0 f11347z;

    /* renamed from: p0, reason: collision with root package name */
    public long f11335p0 = -9223372036854775807L;
    public boolean W = false;

    /* renamed from: r0, reason: collision with root package name */
    public float f11339r0 = 1.0f;
    public e1 P = e1.f11279b;

    /* renamed from: n0, reason: collision with root package name */
    public long f11331n0 = -9223372036854775807L;
    public long Z = -9223372036854775807L;

    public h0(Context context, d[] dVarArr, d[] dVarArr2, f2.w wVar, f2.x xVar, i iVar, g2.d dVar, int i10, boolean z10, t1.o oVar, f1 f1Var, g gVar, long j10, Looper looper, l1.v vVar, s sVar, t1.u uVar, o oVar2, final i2.y yVar) {
        this.E = sVar;
        this.f11338r = wVar;
        this.f11340s = xVar;
        this.f11341t = iVar;
        this.f11342u = dVar;
        this.f11320b0 = i10;
        this.f11321c0 = z10;
        this.O = f1Var;
        this.H = gVar;
        this.I = j10;
        this.D = vVar;
        this.J = uVar;
        this.f11333o0 = oVar2;
        this.K = oVar;
        this.A = iVar.g;
        i1.q0 q0Var = i1.t0.f6037a;
        y0 k10 = y0.k(xVar);
        this.T = k10;
        this.U = new b4.u(k10);
        this.f11334p = new d[dVarArr.length];
        this.f11336q = new boolean[dVarArr.length];
        f2.r rVar = (f2.r) wVar;
        rVar.getClass();
        this.f11332o = new l4.f0[dVarArr.length];
        boolean z11 = false;
        for (int i11 = 0; i11 < dVarArr.length; i11++) {
            d dVar2 = dVarArr[i11];
            dVar2.f11252s = i11;
            dVar2.f11253t = uVar;
            dVar2.f11254u = vVar;
            this.f11334p[i11] = dVar2;
            d dVar3 = this.f11334p[i11];
            synchronized (dVar3.f11248o) {
                dVar3.F = rVar;
            }
            d dVar4 = dVarArr2[i11];
            if (dVar4 != null) {
                dVar4.f11252s = i11;
                dVar4.f11253t = uVar;
                dVar4.f11254u = vVar;
                z11 = true;
            }
            l4.f0[] f0VarArr = this.f11332o;
            d dVar5 = dVarArr[i11];
            l4.f0 f0Var = new l4.f0();
            f0Var.f8220e = dVar5;
            f0Var.f8216a = i11;
            f0Var.f8221f = dVar4;
            f0Var.f8217b = 0;
            f0Var.f8218c = false;
            f0Var.f8219d = false;
            f0VarArr[i11] = f0Var;
        }
        this.M = z11;
        this.B = new i2.o(this, vVar);
        this.C = new ArrayList();
        this.f11346y = new i1.s0();
        this.f11347z = new i1.r0();
        l1.d.g(wVar.f4954a == null);
        wVar.f4954a = this;
        wVar.f4955b = dVar;
        this.f11329l0 = true;
        l1.x a10 = vVar.a(looper, null);
        this.L = a10;
        this.F = new o0(oVar, a10, new androidx.fragment.app.v0(25, this), oVar2);
        this.G = new d9.p(this, oVar, a10, uVar);
        com.google.android.gms.internal.cast.v vVar2 = new com.google.android.gms.internal.cast.v();
        this.f11344w = vVar2;
        Looper b2 = vVar2.b();
        this.f11345x = b2;
        l1.x a11 = vVar.a(b2, this);
        this.f11343v = a11;
        this.N = new c(context, b2, this);
        a11.a(35, new i2.y() { // from class: s1.c0
            @Override // i2.y
            public final void d(long j11, long j12, i1.p pVar, MediaFormat mediaFormat) {
                h0 h0Var = h0.this;
                h0Var.getClass();
                yVar.d(j11, j12, pVar, mediaFormat);
                h0Var.d(j11, j12, pVar, mediaFormat);
            }
        }).b();
    }

    public static Pair S(i1.t0 t0Var, g0 g0Var, boolean z10, int i10, boolean z11, i1.s0 s0Var, i1.r0 r0Var) {
        int T;
        i1.t0 t0Var2 = g0Var.f11308a;
        if (t0Var.p()) {
            return null;
        }
        i1.t0 t0Var3 = t0Var2.p() ? t0Var : t0Var2;
        try {
            Pair i11 = t0Var3.i(s0Var, r0Var, g0Var.f11309b, g0Var.f11310c);
            if (!t0Var.equals(t0Var3)) {
                if (t0Var.b(i11.first) == -1) {
                    if (!z10 || (T = T(s0Var, r0Var, i10, z11, i11.first, t0Var3, t0Var)) == -1) {
                        return null;
                    }
                    return t0Var.i(s0Var, r0Var, T, -9223372036854775807L);
                }
                if (t0Var3.g(i11.first, r0Var).f6017f && t0Var3.m(r0Var.f6014c, s0Var, 0L).f6033n == t0Var3.b(i11.first)) {
                    return t0Var.i(s0Var, r0Var, t0Var.g(i11.first, r0Var).f6014c, g0Var.f11310c);
                }
            }
            return i11;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static int T(i1.s0 s0Var, i1.r0 r0Var, int i10, boolean z10, Object obj, i1.t0 t0Var, i1.t0 t0Var2) {
        i1.s0 s0Var2 = s0Var;
        i1.t0 t0Var3 = t0Var;
        Object obj2 = t0Var3.m(t0Var3.g(obj, r0Var).f6014c, s0Var, 0L).f6021a;
        for (int i11 = 0; i11 < t0Var2.o(); i11++) {
            if (t0Var2.m(i11, s0Var, 0L).f6021a.equals(obj2)) {
                return i11;
            }
        }
        int b2 = t0Var3.b(obj);
        int h10 = t0Var3.h();
        int i12 = -1;
        int i13 = 0;
        while (i13 < h10 && i12 == -1) {
            i1.t0 t0Var4 = t0Var3;
            int d6 = t0Var4.d(b2, r0Var, s0Var2, i10, z10);
            if (d6 == -1) {
                break;
            }
            i12 = t0Var2.b(t0Var4.l(d6));
            i13++;
            t0Var3 = t0Var4;
            b2 = d6;
            s0Var2 = s0Var;
        }
        if (i12 == -1) {
            return -1;
        }
        return t0Var2.f(i12, r0Var, false).f6014c;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [c2.b0, c2.g1, java.lang.Object] */
    public static boolean z(m0 m0Var) {
        if (m0Var != null) {
            try {
                ?? r12 = m0Var.f11377a;
                if (m0Var.f11381e) {
                    for (c2.e1 e1Var : m0Var.f11379c) {
                        if (e1Var != null) {
                            e1Var.r();
                        }
                    }
                } else {
                    r12.n();
                }
                if ((!m0Var.f11381e ? 0L : r12.e()) != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public final boolean A(int i10, c2.d0 d0Var) {
        o0 o0Var = this.F;
        m0 m0Var = o0Var.f11432k;
        if (m0Var != null && m0Var.g.f11413a.equals(d0Var)) {
            l4.f0 f0Var = this.f11332o[i10];
            m0 m0Var2 = o0Var.f11432k;
            int i11 = f0Var.f8217b;
            boolean z10 = (i11 == 2 || i11 == 4) && f0Var.d(m0Var2) == ((d) f0Var.f8220e);
            boolean z11 = f0Var.f8217b == 3 && f0Var.d(m0Var2) == ((d) f0Var.f8221f);
            if (z10 || z11) {
                return true;
            }
        }
        return false;
    }

    public final void A0(i1.t0 t0Var, c2.d0 d0Var, i1.t0 t0Var2, c2.d0 d0Var2, long j10, boolean z10) {
        boolean r02 = r0(t0Var, d0Var);
        Object obj = d0Var.f2539a;
        if (!r02) {
            i1.j0 j0Var = d0Var.b() ? i1.j0.f5905d : this.T.f11506o;
            i2.o oVar = this.B;
            if (oVar.d().equals(j0Var)) {
                return;
            }
            this.f11343v.d(16);
            oVar.a(j0Var);
            x(this.T.f11506o, j0Var.f5906a, false, false);
            return;
        }
        i1.r0 r0Var = this.f11347z;
        int i10 = t0Var.g(obj, r0Var).f6014c;
        i1.s0 s0Var = this.f11346y;
        t0Var.n(i10, s0Var);
        i1.w wVar = s0Var.f6029j;
        g gVar = this.H;
        gVar.getClass();
        gVar.f11297c = l1.a0.O(wVar.f6053a);
        gVar.f11300f = l1.a0.O(wVar.f6054b);
        gVar.g = l1.a0.O(wVar.f6055c);
        float f10 = wVar.f6056d;
        if (f10 == -3.4028235E38f) {
            f10 = 0.97f;
        }
        gVar.f11303j = f10;
        float f11 = wVar.f6057e;
        if (f11 == -3.4028235E38f) {
            f11 = 1.03f;
        }
        gVar.f11302i = f11;
        if (f10 == 1.0f && f11 == 1.0f) {
            gVar.f11297c = -9223372036854775807L;
        }
        gVar.a();
        if (j10 != -9223372036854775807L) {
            gVar.f11298d = m(t0Var, obj, j10);
            gVar.a();
            return;
        }
        if (!Objects.equals(!t0Var2.p() ? t0Var2.m(t0Var2.g(d0Var2.f2539a, r0Var).f6014c, s0Var, 0L).f6021a : null, s0Var.f6021a) || z10) {
            gVar.f11298d = -9223372036854775807L;
            gVar.a();
        }
    }

    public final boolean B() {
        m0 m0Var = this.F.f11430i;
        long j10 = m0Var.g.f11417e;
        if (m0Var.f11381e) {
            return j10 == -9223372036854775807L || this.T.f11510s < j10 || !q0();
        }
        return false;
    }

    public final void B0(boolean z10, boolean z11) {
        long j10;
        this.Y = z10;
        if (!z10 || z11) {
            j10 = -9223372036854775807L;
        } else {
            this.D.getClass();
            j10 = SystemClock.elapsedRealtime();
        }
        this.Z = j10;
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [c2.b0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v23, types: [c2.g1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [c2.g1, java.lang.Object] */
    public final void C() {
        boolean c10;
        if (z(this.F.f11433l)) {
            m0 m0Var = this.F.f11433l;
            long p10 = p(!m0Var.f11381e ? 0L : m0Var.f11377a.e());
            m0 m0Var2 = this.F.f11430i;
            long j10 = r0(this.T.f11493a, m0Var.g.f11413a) ? this.H.f11301h : -9223372036854775807L;
            t1.u uVar = this.J;
            i1.t0 t0Var = this.T.f11493a;
            float f10 = this.B.d().f5906a;
            boolean z10 = this.T.f11503l;
            i0 i0Var = new i0(uVar, p10, f10, this.Y, j10);
            c10 = this.f11341t.c(i0Var);
            m0 m0Var3 = this.F.f11430i;
            if (!c10 && m0Var3.f11381e && p10 < 500000 && this.A > 0) {
                m0Var3.f11377a.r(this.T.f11510s);
                c10 = this.f11341t.c(i0Var);
            }
        } else {
            c10 = false;
        }
        this.f11319a0 = c10;
        if (c10) {
            m0 m0Var4 = this.F.f11433l;
            m0Var4.getClass();
            j0 j0Var = new j0();
            j0Var.f11362a = this.f11326i0 - m0Var4.f11391p;
            float f11 = this.B.d().f5906a;
            l1.d.b(f11 > 0.0f || f11 == -3.4028235E38f);
            j0Var.f11363b = f11;
            long j11 = this.Z;
            l1.d.b(j11 >= 0 || j11 == -9223372036854775807L);
            j0Var.f11364c = j11;
            k0 k0Var = new k0(j0Var);
            l1.d.g(m0Var4.f11388m == null);
            m0Var4.f11377a.s(k0Var);
        }
        v0();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [c2.b0, c2.g1, java.lang.Object] */
    public final void D() {
        o0 o0Var = this.F;
        o0Var.k();
        m0 m0Var = o0Var.f11434m;
        if (m0Var != null) {
            ?? r12 = m0Var.f11377a;
            if ((!m0Var.f11380d || m0Var.f11381e) && !r12.a()) {
                i1.t0 t0Var = this.T.f11493a;
                if (m0Var.f11381e) {
                    r12.m();
                }
                Iterator it = this.f11341t.f11354h.values().iterator();
                while (it.hasNext()) {
                    if (((h) it.next()).f11316a) {
                        return;
                    }
                }
                if (!m0Var.f11380d) {
                    long j10 = m0Var.g.f11414b;
                    m0Var.f11380d = true;
                    r12.l(this, j10);
                    return;
                }
                j0 j0Var = new j0();
                j0Var.f11362a = this.f11326i0 - m0Var.f11391p;
                float f10 = this.B.d().f5906a;
                l1.d.b(f10 > 0.0f || f10 == -3.4028235E38f);
                j0Var.f11363b = f10;
                long j11 = this.Z;
                l1.d.b(j11 >= 0 || j11 == -9223372036854775807L);
                j0Var.f11364c = j11;
                k0 k0Var = new k0(j0Var);
                l1.d.g(m0Var.f11388m == null);
                r12.s(k0Var);
            }
        }
    }

    public final void E() {
        b4.u uVar = this.U;
        y0 y0Var = this.T;
        boolean z10 = uVar.f2419c | (((y0) uVar.f2422f) != y0Var);
        uVar.f2419c = z10;
        uVar.f2422f = y0Var;
        if (z10) {
            a0 a0Var = this.E.f11449o;
            a0Var.f11198j.c(new androidx.fragment.app.d(a0Var, 18, uVar));
            this.U = new b4.u(this.T);
        }
    }

    public final void F(int i10) {
        l4.f0 f0Var = this.f11332o[i10];
        try {
            m0 m0Var = this.F.f11430i;
            m0Var.getClass();
            d d6 = f0Var.d(m0Var);
            d6.getClass();
            c2.e1 e1Var = d6.f11256w;
            e1Var.getClass();
            e1Var.r();
        } catch (IOException | RuntimeException e7) {
            int i11 = ((d) f0Var.f8220e).f11249p;
            if (i11 != 3 && i11 != 5) {
                throw e7;
            }
            f2.x xVar = this.F.f11430i.f11390o;
            l1.b.h("ExoPlayerImplInternal", "Disabling track due to error: " + i1.p.c(xVar.f4959c[i10].l()), e7);
            f2.x xVar2 = new f2.x((d1[]) xVar.f4958b.clone(), (f2.t[]) xVar.f4959c.clone(), xVar.f4960d, xVar.f4961e);
            xVar2.f4958b[i10] = null;
            xVar2.f4959c[i10] = null;
            i(i10);
            m0 m0Var2 = this.F.f11430i;
            m0Var2.a(xVar2, this.T.f11510s, false, new boolean[m0Var2.f11385j.length]);
        }
    }

    public final void G(final int i10, final boolean z10) {
        boolean[] zArr = this.f11336q;
        if (zArr[i10] != z10) {
            zArr[i10] = z10;
            this.L.c(new Runnable() { // from class: s1.b0
                @Override // java.lang.Runnable
                public final void run() {
                    h0 h0Var = h0.this;
                    t1.o oVar = h0Var.K;
                    l4.f0[] f0VarArr = h0Var.f11332o;
                    int i11 = i10;
                    int i12 = ((d) f0VarArr[i11].f8220e).f11249p;
                    t1.a N = oVar.N();
                    oVar.O(N, 1033, new app.shamel.tv.helper.u(N, i11, i12, z10));
                }
            });
        }
    }

    public final void H() {
        v(this.G.c(), true);
    }

    public final void I() {
        this.U.f(1);
        throw null;
    }

    public final void J() {
        this.U.f(1);
        O(false, false, false, true);
        i iVar = this.f11341t;
        HashMap hashMap = iVar.f11354h;
        long id = Thread.currentThread().getId();
        long j10 = iVar.f11355i;
        l1.d.f("Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).", j10 == -1 || j10 == id);
        iVar.f11355i = id;
        t1.u uVar = this.J;
        if (!hashMap.containsKey(uVar)) {
            hashMap.put(uVar, new h());
        }
        h hVar = (h) hashMap.get(uVar);
        hVar.getClass();
        int i10 = iVar.f11353f;
        if (i10 == -1) {
            i10 = 13107200;
        }
        hVar.f11317b = i10;
        hVar.f11316a = false;
        m0(this.T.f11493a.p() ? 4 : 2);
        y0 y0Var = this.T;
        boolean z10 = y0Var.f11503l;
        y0(this.N.d(y0Var.f11497e, z10), y0Var.f11505n, y0Var.f11504m, z10);
        g2.g gVar = (g2.g) this.f11342u;
        gVar.getClass();
        d9.p pVar = this.G;
        ArrayList arrayList = (ArrayList) pVar.f4314c;
        l1.d.g(!pVar.f4312a);
        pVar.f4322l = gVar;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            x0 x0Var = (x0) arrayList.get(i11);
            pVar.g(x0Var);
            ((HashSet) pVar.f4318h).add(x0Var);
        }
        pVar.f4312a = true;
        this.f11343v.e(2);
    }

    public final void K(l1.g gVar) {
        com.google.android.gms.internal.cast.v vVar = this.f11344w;
        l1.x xVar = this.f11343v;
        try {
            O(true, false, true, false);
            L();
            i iVar = this.f11341t;
            if (iVar.f11354h.remove(this.J) != null) {
                iVar.d();
            }
            if (iVar.f11354h.isEmpty()) {
                iVar.f11355i = -1L;
            }
            c cVar = this.N;
            cVar.f11232c = null;
            cVar.a();
            cVar.c(0);
            this.f11338r.a();
            m0(1);
        } finally {
            xVar.f8138a.removeCallbacksAndMessages(null);
            vVar.c();
            gVar.f();
        }
    }

    public final void L() {
        for (int i10 = 0; i10 < this.f11332o.length; i10++) {
            d dVar = this.f11334p[i10];
            synchronized (dVar.f11248o) {
                dVar.F = null;
            }
            l4.f0 f0Var = this.f11332o[i10];
            d dVar2 = (d) f0Var.f8220e;
            l1.d.g(dVar2.f11255v == 0);
            dVar2.q();
            f0Var.f8218c = false;
            d dVar3 = (d) f0Var.f8221f;
            if (dVar3 != null) {
                l1.d.g(dVar3.f11255v == 0);
                dVar3.q();
                f0Var.f8219d = false;
            }
        }
    }

    public final void M(int i10, int i11, h1 h1Var) {
        this.U.f(1);
        d9.p pVar = this.G;
        pVar.getClass();
        l1.d.b(i10 >= 0 && i10 <= i11 && i11 <= ((ArrayList) pVar.f4314c).size());
        pVar.f4321k = h1Var;
        pVar.i(i10, i11);
        v(pVar.c(), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N() {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.h0.N():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(boolean r36, boolean r37, boolean r38, boolean r39) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.h0.O(boolean, boolean, boolean, boolean):void");
    }

    public final void P() {
        m0 m0Var = this.F.f11430i;
        this.X = m0Var != null && m0Var.g.f11420i && this.W;
    }

    public final void Q(long j10) {
        m0 m0Var = this.F.f11430i;
        long j11 = j10 + (m0Var == null ? 1000000000000L : m0Var.f11391p);
        this.f11326i0 = j11;
        ((g1) this.B.f6267q).c(j11);
        for (l4.f0 f0Var : this.f11332o) {
            long j12 = this.f11326i0;
            d d6 = f0Var.d(m0Var);
            if (d6 != null) {
                d6.B = false;
                d6.f11259z = j12;
                d6.A = j12;
                d6.p(j12, false);
            }
        }
        for (m0 m0Var2 = r0.f11430i; m0Var2 != null; m0Var2 = m0Var2.f11388m) {
            for (f2.t tVar : m0Var2.f11390o.f4959c) {
                if (tVar != null) {
                    tVar.r();
                }
            }
        }
    }

    public final void R(i1.t0 t0Var, i1.t0 t0Var2) {
        if (t0Var.p() && t0Var2.p()) {
            return;
        }
        ArrayList arrayList = this.C;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
        } else {
            r.a.j(arrayList.get(size));
            throw null;
        }
    }

    public final void U(long j10) {
        boolean z10 = this.Q;
        long j11 = f11318s0;
        if (z10) {
            this.P.getClass();
            r2 = this.T.f11497e != 3 ? j11 : 1000L;
            for (l4.f0 f0Var : this.f11332o) {
                long j12 = this.f11326i0;
                long j13 = this.f11327j0;
                d dVar = (d) f0Var.f8221f;
                d dVar2 = (d) f0Var.f8220e;
                long h10 = l4.f0.h(dVar2) ? dVar2.h(j12, j13) : Long.MAX_VALUE;
                if (dVar != null && dVar.f11255v != 0) {
                    h10 = Math.min(h10, dVar.h(j12, j13));
                }
                r2 = Math.min(r2, l1.a0.Z(h10));
            }
            if (this.T.m()) {
                m0 m0Var = this.F.f11430i;
                if ((m0Var != null ? m0Var.f11388m : null) != null) {
                    if ((l1.a0.O(r2) * this.T.f11506o.f5906a) + this.f11326i0 >= r1.e()) {
                        r2 = Math.min(r2, j11);
                    }
                }
            }
        } else if (this.T.f11497e != 3 || q0()) {
            r2 = j11;
        }
        this.f11343v.f8138a.sendEmptyMessageAtTime(2, j10 + r2);
    }

    public final void V(boolean z10) {
        c2.d0 d0Var = this.F.f11430i.g.f11413a;
        long X = X(d0Var, this.T.f11510s, true, false);
        if (X != this.T.f11510s) {
            y0 y0Var = this.T;
            this.T = y(d0Var, X, y0Var.f11495c, y0Var.f11496d, z10, 5);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:25|(20:(8:27|(1:92)(3:33|(1:37)|38)|39|(1:48)|46|47|17|18)(1:93)|53|54|(1:56)(1:85)|57|58|(1:60)(1:83)|61|62|63|64|65|66|67|68|69|70|16|17|18)|49|50|(1:52)(1:89)) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0173, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a7 A[Catch: all -> 0x00aa, TRY_ENTER, TryCatch #4 {all -> 0x00aa, blocks: (B:14:0x00a7, B:21:0x00b4, B:23:0x00ba, B:24:0x00bd, B:27:0x00d0, B:29:0x00d6, B:33:0x00de, B:37:0x00ec, B:38:0x00f1, B:39:0x00f9, B:41:0x010a, B:46:0x0118), top: B:12:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b1  */
    /* JADX WARN: Type inference failed for: r0v30, types: [c2.b0, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W(s1.g0 r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.h0.W(s1.g0, boolean):void");
    }

    /* JADX WARN: Type inference failed for: r10v8, types: [c2.b0, java.lang.Object] */
    public final long X(c2.d0 d0Var, long j10, boolean z10, boolean z11) {
        l4.f0[] f0VarArr;
        u0();
        B0(false, true);
        if (z11 || this.T.f11497e == 3) {
            m0(2);
        }
        o0 o0Var = this.F;
        m0 m0Var = o0Var.f11430i;
        m0 m0Var2 = m0Var;
        while (m0Var2 != null && !d0Var.equals(m0Var2.g.f11413a)) {
            m0Var2 = m0Var2.f11388m;
        }
        if (z10 || m0Var != m0Var2 || (m0Var2 != null && m0Var2.f11391p + j10 < 0)) {
            int i10 = 0;
            while (true) {
                f0VarArr = this.f11332o;
                if (i10 >= f0VarArr.length) {
                    break;
                }
                i(i10);
                i10++;
            }
            this.f11335p0 = -9223372036854775807L;
            if (m0Var2 != null) {
                while (o0Var.f11430i != m0Var2) {
                    o0Var.a();
                }
                o0Var.n(m0Var2);
                m0Var2.f11391p = 1000000000000L;
                l(new boolean[f0VarArr.length], o0Var.f11431j.e());
                m0Var2.f11383h = true;
            }
        }
        h();
        if (m0Var2 != null) {
            ?? r10 = m0Var2.f11377a;
            o0Var.n(m0Var2);
            if (!m0Var2.f11381e) {
                m0Var2.g = m0Var2.g.b(j10);
            } else if (m0Var2.f11382f) {
                j10 = r10.p(j10);
                r10.r(j10 - this.A);
            }
            Q(j10);
            C();
        } else {
            o0Var.b();
            Q(j10);
        }
        u(false);
        this.f11343v.e(2);
        return j10;
    }

    public final void Y(b1 b1Var) {
        b1Var.getClass();
        l1.x xVar = this.f11343v;
        if (b1Var.f11228e != this.f11345x) {
            xVar.a(15, b1Var).b();
            return;
        }
        synchronized (b1Var) {
        }
        try {
            b1Var.f11224a.c(b1Var.f11226c, b1Var.f11227d);
            b1Var.a(true);
            int i10 = this.T.f11497e;
            if (i10 == 3 || i10 == 2) {
                xVar.e(2);
            }
        } catch (Throwable th) {
            b1Var.a(true);
            throw th;
        }
    }

    public final void Z(b1 b1Var) {
        Looper looper = b1Var.f11228e;
        if (looper.getThread().isAlive()) {
            this.D.a(looper, null).c(new androidx.activity.d(this, b1Var));
        } else {
            l1.b.q("TAG", "Trying to send message on a dead thread.");
            b1Var.a(false);
        }
    }

    public final void a(e0 e0Var, int i10) {
        this.U.f(1);
        d9.p pVar = this.G;
        if (i10 == -1) {
            i10 = ((ArrayList) pVar.f4314c).size();
        }
        v(pVar.a(i10, e0Var.f11275a, e0Var.f11276b), false);
    }

    public final void a0(i1.d dVar, boolean z10) {
        f2.r rVar = (f2.r) this.f11338r;
        if (!rVar.f4944j.equals(dVar)) {
            rVar.f4944j = dVar;
            rVar.f();
        }
        if (!z10) {
            dVar = null;
        }
        c cVar = this.N;
        if (!Objects.equals(cVar.f11233d, dVar)) {
            cVar.f11233d = dVar;
            int i10 = dVar == null ? 0 : 1;
            cVar.f11235f = i10;
            l1.d.a("Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.", i10 == 1 || i10 == 0);
        }
        y0 y0Var = this.T;
        boolean z11 = y0Var.f11503l;
        y0(cVar.d(y0Var.f11497e, z11), y0Var.f11505n, y0Var.f11504m, z11);
    }

    @Override // c2.f1
    public final void b(c2.g1 g1Var) {
        this.f11343v.a(9, (c2.b0) g1Var).b();
    }

    public final void b0(boolean z10, l1.g gVar) {
        if (this.f11322d0 != z10) {
            this.f11322d0 = z10;
            if (!z10) {
                for (l4.f0 f0Var : this.f11332o) {
                    f0Var.k();
                }
            }
        }
        if (gVar != null) {
            gVar.f();
        }
    }

    @Override // c2.a0
    public final void c(c2.b0 b0Var) {
        this.f11343v.a(8, b0Var).b();
    }

    public final void c0(e0 e0Var) {
        this.U.f(1);
        int i10 = e0Var.f11277c;
        h1 h1Var = e0Var.f11276b;
        ArrayList arrayList = e0Var.f11275a;
        if (i10 != -1) {
            this.h0 = new g0(new c1(arrayList, h1Var), e0Var.f11277c, e0Var.f11278d);
        }
        d9.p pVar = this.G;
        ArrayList arrayList2 = (ArrayList) pVar.f4314c;
        pVar.i(0, arrayList2.size());
        v(pVar.a(arrayList2.size(), arrayList, h1Var), false);
    }

    @Override // i2.y
    public final void d(long j10, long j11, i1.p pVar, MediaFormat mediaFormat) {
        if (this.R) {
            l1.x xVar = this.f11343v;
            xVar.getClass();
            l1.w b2 = l1.x.b();
            b2.f8136a = xVar.f8138a.obtainMessage(37);
            b2.b();
        }
    }

    public final void d0(boolean z10) {
        this.W = z10;
        P();
        if (this.X) {
            o0 o0Var = this.F;
            if (o0Var.f11431j != o0Var.f11430i) {
                V(true);
                u(false);
            }
        }
    }

    public final void e() {
        for (l4.f0 f0Var : this.f11332o) {
            e1 e1Var = this.Q ? this.P : null;
            ((d) f0Var.f8220e).c(18, e1Var);
            d dVar = (d) f0Var.f8221f;
            if (dVar != null) {
                dVar.c(18, e1Var);
            }
        }
    }

    public final void e0(i1.j0 j0Var) {
        this.f11343v.d(16);
        i2.o oVar = this.B;
        oVar.a(j0Var);
        i1.j0 d6 = oVar.d();
        x(d6, d6.f5906a, true, true);
    }

    public final boolean f() {
        if (!this.M) {
            return false;
        }
        for (l4.f0 f0Var : this.f11332o) {
            if (f0Var.f()) {
                return true;
            }
        }
        return false;
    }

    public final void f0(o oVar) {
        this.f11333o0 = oVar;
        i1.t0 t0Var = this.T.f11493a;
        o0 o0Var = this.F;
        o0Var.getClass();
        oVar.getClass();
        if (o0Var.f11438q.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < o0Var.f11438q.size(); i10++) {
            ((m0) o0Var.f11438q.get(i10)).i();
        }
        o0Var.f11438q = arrayList;
        o0Var.f11434m = null;
        o0Var.k();
    }

    public final void g() {
        N();
        V(true);
    }

    public final void g0(int i10) {
        this.f11320b0 = i10;
        i1.t0 t0Var = this.T.f11493a;
        o0 o0Var = this.F;
        o0Var.g = i10;
        int r2 = o0Var.r(t0Var);
        if ((r2 & 1) != 0) {
            V(true);
        } else if ((r2 & 2) != 0) {
            h();
        }
        u(false);
    }

    public final void h() {
        d dVar;
        if (this.M && f()) {
            for (l4.f0 f0Var : this.f11332o) {
                int c10 = f0Var.c();
                if (f0Var.f()) {
                    int i10 = f0Var.f8217b;
                    boolean z10 = i10 == 4 || i10 == 2;
                    int i11 = i10 != 4 ? 0 : 1;
                    if (z10) {
                        dVar = (d) f0Var.f8220e;
                    } else {
                        dVar = (d) f0Var.f8221f;
                        dVar.getClass();
                    }
                    f0Var.a(dVar, this.B);
                    f0Var.i(z10);
                    f0Var.f8217b = i11;
                }
                this.f11325g0 -= c10 - f0Var.c();
            }
            this.f11335p0 = -9223372036854775807L;
        }
    }

    public final void h0(boolean z10) {
        if (!z10) {
            this.R = false;
            this.f11343v.d(37);
            g0 g0Var = this.S;
            if (g0Var != null) {
                W(g0Var, false);
                this.S = null;
            }
        }
        this.Q = z10;
        e();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10;
        m0 m0Var;
        c2.d0 d0Var;
        m0 m0Var2;
        int i11;
        try {
            switch (message.what) {
                case 1:
                    boolean z10 = message.arg1 != 0;
                    int i12 = message.arg2;
                    this.U.f(1);
                    y0(this.N.d(this.T.f11497e, z10), i12 >> 4, i12 & 15, z10);
                    break;
                case 2:
                    j();
                    break;
                case 3:
                    W((g0) message.obj, true);
                    break;
                case 4:
                    e0((i1.j0) message.obj);
                    break;
                case 5:
                    j0((f1) message.obj);
                    break;
                case 6:
                    t0(false, true);
                    break;
                case 7:
                    K((l1.g) message.obj);
                    return true;
                case 8:
                    w((c2.b0) message.obj);
                    break;
                case 9:
                    s((c2.b0) message.obj);
                    break;
                case 10:
                    N();
                    break;
                case 11:
                    g0(message.arg1);
                    break;
                case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                    k0(message.arg1 != 0);
                    break;
                case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                    b0(message.arg1 != 0, (l1.g) message.obj);
                    break;
                case UrlRequest.Status.READING_RESPONSE /* 14 */:
                    Y((b1) message.obj);
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    Z((b1) message.obj);
                    break;
                case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                    i1.j0 j0Var = (i1.j0) message.obj;
                    x(j0Var, j0Var.f5906a, true, false);
                    break;
                case 17:
                    c0((e0) message.obj);
                    break;
                case 18:
                    a((e0) message.obj, message.arg1);
                    break;
                case 19:
                    r.a.j(message.obj);
                    I();
                    throw null;
                case 20:
                    M(message.arg1, message.arg2, (h1) message.obj);
                    break;
                case 21:
                    l0((h1) message.obj);
                    break;
                case 22:
                    H();
                    break;
                case 23:
                    d0(message.arg1 != 0);
                    break;
                case 24:
                default:
                    return false;
                case 25:
                    g();
                    break;
                case 26:
                    N();
                    V(true);
                    break;
                case 27:
                    x0(message.arg1, message.arg2, (List) message.obj);
                    break;
                case 28:
                    f0((o) message.obj);
                    break;
                case 29:
                    J();
                    break;
                case 30:
                    Pair pair = (Pair) message.obj;
                    o0(pair.first, (l1.g) pair.second);
                    break;
                case 31:
                    a0((i1.d) message.obj, message.arg1 != 0);
                    break;
                case 32:
                    p0(((Float) message.obj).floatValue());
                    break;
                case 33:
                    q(message.arg1);
                    break;
                case 34:
                    r();
                    break;
                case 35:
                    n0((i2.y) message.obj);
                    break;
                case 36:
                    h0(((Boolean) message.obj).booleanValue());
                    break;
                case 37:
                    this.R = false;
                    g0 g0Var = this.S;
                    if (g0Var != null) {
                        W(g0Var, false);
                        this.S = null;
                        break;
                    }
                    break;
                case 38:
                    i0((e1) message.obj);
                    break;
            }
        } catch (c2.b e7) {
            t(e7, 1002);
        } catch (i1.h0 e8) {
            boolean z11 = e8.f5897o;
            int i13 = e8.f5898p;
            if (i13 == 1) {
                i11 = z11 ? 3001 : 3003;
            } else {
                if (i13 == 4) {
                    i11 = z11 ? 3002 : 3004;
                }
                t(e8, r3);
            }
            r3 = i11;
            t(e8, r3);
        } catch (o1.i e10) {
            t(e10, e10.f9414o);
        } catch (l e11) {
            e = e11;
            int i14 = e.f11368q;
            o0 o0Var = this.F;
            if (i14 == 1 && (m0Var2 = o0Var.f11431j) != null && e.f11373v == null) {
                e = e.a(m0Var2.g.f11413a);
            }
            int i15 = e.f11368q;
            l1.x xVar = this.f11343v;
            if (i15 == 1 && (d0Var = e.f11373v) != null && A(e.f11370s, d0Var)) {
                this.f11337q0 = true;
                h();
                m0 g = o0Var.g();
                m0 m0Var3 = o0Var.f11430i;
                if (m0Var3 != g) {
                    while (m0Var3 != null) {
                        m0 m0Var4 = m0Var3.f11388m;
                        if (m0Var4 == g) {
                            break;
                        }
                        m0Var3 = m0Var4;
                    }
                }
                o0Var.n(m0Var3);
                if (this.T.f11497e != 4) {
                    C();
                    xVar.e(2);
                }
            } else {
                l lVar = this.f11330m0;
                if (lVar != null) {
                    lVar.addSuppressed(e);
                    e = this.f11330m0;
                }
                if (e.f11368q == 1 && o0Var.f11430i != o0Var.f11431j) {
                    while (true) {
                        m0Var = o0Var.f11430i;
                        if (m0Var == o0Var.f11431j) {
                            break;
                        }
                        o0Var.a();
                    }
                    l1.d.e(m0Var);
                    E();
                    n0 n0Var = m0Var.g;
                    c2.d0 d0Var2 = n0Var.f11413a;
                    long j10 = n0Var.f11414b;
                    this.T = y(d0Var2, j10, n0Var.f11415c, j10, true, 0);
                }
                if (e.f11374w && (this.f11330m0 == null || (i10 = e.f5902o) == 5004 || i10 == 5003)) {
                    l1.b.r("ExoPlayerImplInternal", "Recoverable renderer error", e);
                    if (this.f11330m0 == null) {
                        this.f11330m0 = e;
                    }
                    l1.w a10 = xVar.a(25, e);
                    Handler handler = xVar.f8138a;
                    Message message2 = a10.f8136a;
                    message2.getClass();
                    handler.sendMessageAtFrontOfQueue(message2);
                    a10.a();
                } else {
                    l1.b.h("ExoPlayerImplInternal", "Playback error", e);
                    t0(true, false);
                    this.T = this.T.f(e);
                }
            }
        } catch (v1.b e12) {
            t(e12, e12.f12650o);
        } catch (IOException e13) {
            t(e13, 2000);
        } catch (RuntimeException e14) {
            l lVar2 = new l(2, e14, ((e14 instanceof IllegalStateException) || (e14 instanceof IllegalArgumentException)) ? 1004 : 1000);
            l1.b.h("ExoPlayerImplInternal", "Playback error", lVar2);
            t0(true, false);
            this.T = this.T.f(lVar2);
        }
        E();
        return true;
    }

    public final void i(int i10) {
        l4.f0[] f0VarArr = this.f11332o;
        int c10 = f0VarArr[i10].c();
        l4.f0 f0Var = f0VarArr[i10];
        d dVar = (d) f0Var.f8220e;
        i2.o oVar = this.B;
        f0Var.a(dVar, oVar);
        d dVar2 = (d) f0Var.f8221f;
        if (dVar2 != null) {
            boolean z10 = (dVar2.f11255v == 0 || f0Var.f8217b == 3) ? false : true;
            f0Var.a(dVar2, oVar);
            f0Var.i(false);
            if (z10) {
                d dVar3 = (d) f0Var.f8220e;
                dVar2.getClass();
                dVar2.c(17, dVar3);
            }
        }
        f0Var.f8217b = 0;
        G(i10, false);
        this.f11325g0 -= c10;
    }

    public final void i0(e1 e1Var) {
        this.P = e1Var;
        e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:509:0x07b3, code lost:
    
        if (r5 >= r2.b()) goto L458;
     */
    /* JADX WARN: Removed duplicated region for block: B:198:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x06ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0841  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x087e  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x08ab  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x08b8  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x08c6  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x08d1  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x0881  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0800  */
    /* JADX WARN: Type inference failed for: r2v3, types: [c2.b0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v57, types: [c2.b0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v96, types: [c2.b0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v28, types: [c2.b0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v87, types: [c2.b0, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 2292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.h0.j():void");
    }

    public final void j0(f1 f1Var) {
        this.O = f1Var;
    }

    public final void k(m0 m0Var, int i10, boolean z10, long j10) {
        l4.f0 f0Var = this.f11332o[i10];
        boolean g = f0Var.g();
        d dVar = (d) f0Var.f8220e;
        if (g) {
            return;
        }
        boolean z11 = m0Var == this.F.f11430i;
        f2.x xVar = m0Var.f11390o;
        d1 d1Var = xVar.f4958b[i10];
        f2.t tVar = xVar.f4959c[i10];
        boolean z12 = q0() && this.T.f11497e == 3;
        boolean z13 = !z10 && z12;
        this.f11325g0++;
        c2.e1 e1Var = m0Var.f11379c[i10];
        long j11 = m0Var.f11391p;
        c2.d0 d0Var = m0Var.g.f11413a;
        d dVar2 = (d) f0Var.f8221f;
        int length = tVar != null ? tVar.length() : 0;
        i1.p[] pVarArr = new i1.p[length];
        for (int i11 = 0; i11 < length; i11++) {
            tVar.getClass();
            pVarArr[i11] = tVar.d(i11);
        }
        int i12 = f0Var.f8217b;
        i2.o oVar = this.B;
        if (i12 == 0 || i12 == 2 || i12 == 4) {
            f0Var.f8218c = true;
            l1.d.g(dVar.f11255v == 0);
            dVar.f11251r = d1Var;
            dVar.E = d0Var;
            dVar.f11255v = 1;
            dVar.o(z13, z11);
            dVar.x(pVarArr, e1Var, j10, j11, d0Var);
            dVar.B = false;
            dVar.f11259z = j10;
            dVar.A = j10;
            dVar.p(j10, z13);
            oVar.c(dVar);
        } else {
            f0Var.f8219d = true;
            dVar2.getClass();
            l1.d.g(dVar2.f11255v == 0);
            dVar2.f11251r = d1Var;
            dVar2.E = d0Var;
            dVar2.f11255v = 1;
            dVar2.o(z13, z11);
            dVar2.x(pVarArr, e1Var, j10, j11, d0Var);
            dVar2.B = false;
            dVar2.f11259z = j10;
            dVar2.A = j10;
            dVar2.p(j10, z13);
            oVar.c(dVar2);
        }
        d0 d0Var2 = new d0(this);
        d d6 = f0Var.d(m0Var);
        d6.getClass();
        d6.c(11, d0Var2);
        if (z12 && z11) {
            f0Var.m();
        }
    }

    public final void k0(boolean z10) {
        this.f11321c0 = z10;
        i1.t0 t0Var = this.T.f11493a;
        o0 o0Var = this.F;
        o0Var.f11429h = z10;
        int r2 = o0Var.r(t0Var);
        if ((r2 & 1) != 0) {
            V(true);
        } else if ((r2 & 2) != 0) {
            h();
        }
        u(false);
    }

    public final void l(boolean[] zArr, long j10) {
        l4.f0[] f0VarArr;
        long j11;
        m0 m0Var = this.F.f11431j;
        f2.x xVar = m0Var.f11390o;
        int i10 = 0;
        while (true) {
            f0VarArr = this.f11332o;
            if (i10 >= f0VarArr.length) {
                break;
            }
            if (!xVar.b(i10)) {
                f0VarArr[i10].k();
            }
            i10++;
        }
        int i11 = 0;
        while (i11 < f0VarArr.length) {
            if (xVar.b(i11) && f0VarArr[i11].d(m0Var) == null) {
                j11 = j10;
                k(m0Var, i11, zArr[i11], j11);
            } else {
                j11 = j10;
            }
            i11++;
            j10 = j11;
        }
    }

    public final void l0(h1 h1Var) {
        this.U.f(1);
        d9.p pVar = this.G;
        int size = ((ArrayList) pVar.f4314c).size();
        if (h1Var.f2599b.length != size) {
            h1Var = new h1(new Random(h1Var.f2598a.nextLong())).a(size);
        }
        pVar.f4321k = h1Var;
        v(pVar.c(), false);
    }

    public final long m(i1.t0 t0Var, Object obj, long j10) {
        i1.r0 r0Var = this.f11347z;
        int i10 = t0Var.g(obj, r0Var).f6014c;
        i1.s0 s0Var = this.f11346y;
        t0Var.n(i10, s0Var);
        if (s0Var.f6026f == -9223372036854775807L || !s0Var.a() || !s0Var.f6028i) {
            return -9223372036854775807L;
        }
        long j11 = s0Var.g;
        return l1.a0.O((j11 == -9223372036854775807L ? System.currentTimeMillis() : j11 + SystemClock.elapsedRealtime()) - s0Var.f6026f) - (j10 + r0Var.f6016e);
    }

    public final void m0(int i10) {
        y0 y0Var = this.T;
        if (y0Var.f11497e != i10) {
            if (i10 != 2) {
                this.f11331n0 = -9223372036854775807L;
            }
            if (i10 != 3 && y0Var.f11507p) {
                this.T = y0Var.i(false);
            }
            this.T = this.T.h(i10);
        }
    }

    public final long n(m0 m0Var) {
        if (m0Var == null) {
            return 0L;
        }
        long j10 = m0Var.f11391p;
        if (!m0Var.f11381e) {
            return j10;
        }
        int i10 = 0;
        while (true) {
            l4.f0[] f0VarArr = this.f11332o;
            if (i10 >= f0VarArr.length) {
                return j10;
            }
            if (f0VarArr[i10].d(m0Var) != null) {
                d d6 = f0VarArr[i10].d(m0Var);
                Objects.requireNonNull(d6);
                long j11 = d6.A;
                if (j11 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j10 = Math.max(j11, j10);
            }
            i10++;
        }
    }

    public final void n0(i2.y yVar) {
        for (l4.f0 f0Var : this.f11332o) {
            d dVar = (d) f0Var.f8220e;
            if (dVar.f11249p == 2) {
                dVar.c(7, yVar);
                d dVar2 = (d) f0Var.f8221f;
                if (dVar2 != null) {
                    dVar2.c(7, yVar);
                }
            }
        }
    }

    public final Pair o(i1.t0 t0Var) {
        long j10 = 0;
        if (t0Var.p()) {
            return Pair.create(y0.f11492u, 0L);
        }
        int a10 = t0Var.a(this.f11321c0);
        Pair i10 = t0Var.i(this.f11346y, this.f11347z, a10, -9223372036854775807L);
        c2.d0 p10 = this.F.p(t0Var, i10.first, 0L);
        long longValue = ((Long) i10.second).longValue();
        if (p10.b()) {
            Object obj = p10.f2539a;
            i1.r0 r0Var = this.f11347z;
            t0Var.g(obj, r0Var);
            if (p10.f2541c == r0Var.e(p10.f2540b)) {
                r0Var.g.getClass();
            }
        } else {
            j10 = longValue;
        }
        return Pair.create(p10, Long.valueOf(j10));
    }

    public final void o0(Object obj, l1.g gVar) {
        for (l4.f0 f0Var : this.f11332o) {
            d dVar = (d) f0Var.f8220e;
            if (dVar.f11249p == 2) {
                int i10 = f0Var.f8217b;
                if (i10 == 4 || i10 == 1) {
                    d dVar2 = (d) f0Var.f8221f;
                    dVar2.getClass();
                    dVar2.c(1, obj);
                } else {
                    dVar.c(1, obj);
                }
            }
        }
        int i11 = this.T.f11497e;
        if (i11 == 3 || i11 == 2) {
            this.f11343v.e(2);
        }
        if (gVar != null) {
            gVar.f();
        }
    }

    public final long p(long j10) {
        m0 m0Var = this.F.f11433l;
        if (m0Var == null) {
            return 0L;
        }
        return Math.max(0L, j10 - (this.f11326i0 - m0Var.f11391p));
    }

    public final void p0(float f10) {
        this.f11339r0 = f10;
        float f11 = f10 * this.N.g;
        for (l4.f0 f0Var : this.f11332o) {
            d dVar = (d) f0Var.f8220e;
            if (dVar.f11249p == 1) {
                dVar.c(2, Float.valueOf(f11));
                d dVar2 = (d) f0Var.f8221f;
                if (dVar2 != null) {
                    dVar2.c(2, Float.valueOf(f11));
                }
            }
        }
    }

    public final void q(int i10) {
        y0 y0Var = this.T;
        y0(i10, y0Var.f11505n, y0Var.f11504m, y0Var.f11503l);
    }

    public final boolean q0() {
        y0 y0Var = this.T;
        return y0Var.f11503l && y0Var.f11505n == 0;
    }

    public final void r() {
        p0(this.f11339r0);
    }

    public final boolean r0(i1.t0 t0Var, c2.d0 d0Var) {
        if (d0Var.b() || t0Var.p()) {
            return false;
        }
        int i10 = t0Var.g(d0Var.f2539a, this.f11347z).f6014c;
        i1.s0 s0Var = this.f11346y;
        t0Var.n(i10, s0Var);
        return s0Var.a() && s0Var.f6028i && s0Var.f6026f != -9223372036854775807L;
    }

    public final void s(c2.b0 b0Var) {
        o0 o0Var = this.F;
        m0 m0Var = o0Var.f11433l;
        if (m0Var != null && m0Var.f11377a == b0Var) {
            o0Var.m(this.f11326i0);
            C();
            return;
        }
        m0 m0Var2 = o0Var.f11434m;
        if (m0Var2 == null || m0Var2.f11377a != b0Var) {
            return;
        }
        D();
    }

    public final void s0() {
        m0 m0Var = this.F.f11430i;
        if (m0Var == null) {
            return;
        }
        f2.x xVar = m0Var.f11390o;
        int i10 = 0;
        while (true) {
            l4.f0[] f0VarArr = this.f11332o;
            if (i10 >= f0VarArr.length) {
                return;
            }
            if (xVar.b(i10)) {
                f0VarArr[i10].m();
            }
            i10++;
        }
    }

    public final void t(IOException iOException, int i10) {
        l lVar = new l(0, iOException, i10);
        m0 m0Var = this.F.f11430i;
        if (m0Var != null) {
            lVar = lVar.a(m0Var.g.f11413a);
        }
        l1.b.h("ExoPlayerImplInternal", "Playback error", lVar);
        t0(false, false);
        this.T = this.T.f(lVar);
    }

    public final void t0(boolean z10, boolean z11) {
        O(z10 || !this.f11322d0, false, true, false);
        this.U.f(z11 ? 1 : 0);
        i iVar = this.f11341t;
        if (iVar.f11354h.remove(this.J) != null) {
            iVar.d();
        }
        this.N.d(1, this.T.f11503l);
        m0(1);
    }

    public final void u(boolean z10) {
        m0 m0Var = this.F.f11433l;
        c2.d0 d0Var = m0Var == null ? this.T.f11494b : m0Var.g.f11413a;
        boolean equals = this.T.f11502k.equals(d0Var);
        if (!equals) {
            this.T = this.T.c(d0Var);
        }
        y0 y0Var = this.T;
        y0Var.f11508q = m0Var == null ? y0Var.f11510s : m0Var.d();
        y0 y0Var2 = this.T;
        y0Var2.f11509r = p(y0Var2.f11508q);
        if ((!equals || z10) && m0Var != null && m0Var.f11381e) {
            w0(m0Var.f11390o);
        }
    }

    public final void u0() {
        i2.o oVar = this.B;
        oVar.f6266p = false;
        g1 g1Var = (g1) oVar.f6267q;
        if (g1Var.f11313q) {
            g1Var.c(g1Var.e());
            g1Var.f11313q = false;
        }
        for (l4.f0 f0Var : this.f11332o) {
            d dVar = (d) f0Var.f8221f;
            d dVar2 = (d) f0Var.f8220e;
            if (l4.f0.h(dVar2)) {
                l4.f0.b(dVar2);
            }
            if (dVar != null && dVar.f11255v != 0) {
                l4.f0.b(dVar);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(4:115|116|(1:118)(1:154)|119)|(8:(11:124|125|126|127|128|129|130|131|132|133|(2:135|136)(2:137|(1:139)))|128|129|130|131|132|133|(0)(0))|152|125|126|127) */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02f5, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02f6, code lost:
    
        r8 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02f8, code lost:
    
        r20 = r3;
        r8 = r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02e2 A[Catch: all -> 0x02dd, TryCatch #7 {all -> 0x02dd, blocks: (B:136:0x02d9, B:137:0x02e2, B:139:0x02e5, B:31:0x02fe, B:63:0x030a, B:65:0x0310, B:67:0x031a, B:69:0x0327), top: B:29:0x02a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r25v0, types: [c2.d0] */
    /* JADX WARN: Type inference failed for: r2v35, types: [s1.o0] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v25, types: [i1.t0] */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(i1.t0 r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 1091
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.h0.v(i1.t0, boolean):void");
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [c2.g1, java.lang.Object] */
    public final void v0() {
        m0 m0Var = this.F.f11433l;
        boolean z10 = this.f11319a0 || (m0Var != null && m0Var.f11377a.a());
        y0 y0Var = this.T;
        if (z10 != y0Var.g) {
            this.T = y0Var.b(z10);
        }
    }

    public final void w(c2.b0 b0Var) {
        m0 m0Var;
        o0 o0Var = this.F;
        m0 m0Var2 = o0Var.f11433l;
        i2.o oVar = this.B;
        if (m0Var2 != null && m0Var2.f11377a == b0Var) {
            m0Var2.getClass();
            if (!m0Var2.f11381e) {
                float f10 = oVar.d().f5906a;
                y0 y0Var = this.T;
                m0Var2.f(f10, y0Var.f11493a, y0Var.f11503l);
            }
            w0(m0Var2.f11390o);
            if (m0Var2 == o0Var.f11430i) {
                Q(m0Var2.g.f11414b);
                l(new boolean[this.f11332o.length], o0Var.f11431j.e());
                m0Var2.f11383h = true;
                y0 y0Var2 = this.T;
                c2.d0 d0Var = y0Var2.f11494b;
                long j10 = m0Var2.g.f11414b;
                this.T = y(d0Var, j10, y0Var2.f11495c, j10, false, 5);
            }
            C();
            return;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= o0Var.f11438q.size()) {
                m0Var = null;
                break;
            }
            m0Var = (m0) o0Var.f11438q.get(i10);
            if (m0Var.f11377a == b0Var) {
                break;
            } else {
                i10++;
            }
        }
        if (m0Var != null) {
            l1.d.g(true ^ m0Var.f11381e);
            float f11 = oVar.d().f5906a;
            y0 y0Var3 = this.T;
            m0Var.f(f11, y0Var3.f11493a, y0Var3.f11503l);
            m0 m0Var3 = o0Var.f11434m;
            if (m0Var3 == null || m0Var3.f11377a != b0Var) {
                return;
            }
            D();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void w0(f2.x xVar) {
        m0 m0Var = this.F.f11433l;
        m0Var.getClass();
        p(m0Var.d());
        if (r0(this.T.f11493a, m0Var.g.f11413a)) {
            long j10 = this.H.f11301h;
        }
        i1.t0 t0Var = this.T.f11493a;
        float f10 = this.B.d().f5906a;
        boolean z10 = this.T.f11503l;
        f2.t[] tVarArr = xVar.f4959c;
        i iVar = this.f11341t;
        h hVar = (h) iVar.f11354h.get(this.J);
        hVar.getClass();
        int i10 = iVar.f11353f;
        if (i10 == -1) {
            int length = tVarArr.length;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = 13107200;
                if (i11 < length) {
                    f2.t tVar = tVarArr[i11];
                    if (tVar != null) {
                        switch (tVar.k().f6041c) {
                            case -2:
                                i13 = 0;
                                i12 += i13;
                                break;
                            case -1:
                            case 1:
                                i12 += i13;
                                break;
                            case 0:
                                i13 = 144310272;
                                i12 += i13;
                                break;
                            case 2:
                                i13 = 131072000;
                                i12 += i13;
                                break;
                            case 3:
                            case 5:
                            case 6:
                                i13 = 131072;
                                i12 += i13;
                                break;
                            case 4:
                                i13 = 26214400;
                                i12 += i13;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    }
                    i11++;
                } else {
                    i10 = Math.max(13107200, i12);
                }
            }
        }
        hVar.f11317b = i10;
        iVar.d();
    }

    public final void x(i1.j0 j0Var, float f10, boolean z10, boolean z11) {
        int i10;
        if (z10) {
            if (z11) {
                this.U.f(1);
            }
            this.T = this.T.g(j0Var);
        }
        float f11 = j0Var.f5906a;
        m0 m0Var = this.F.f11430i;
        while (true) {
            i10 = 0;
            if (m0Var == null) {
                break;
            }
            f2.t[] tVarArr = m0Var.f11390o.f4959c;
            int length = tVarArr.length;
            while (i10 < length) {
                f2.t tVar = tVarArr[i10];
                if (tVar != null) {
                    tVar.p(f11);
                }
                i10++;
            }
            m0Var = m0Var.f11388m;
        }
        l4.f0[] f0VarArr = this.f11332o;
        int length2 = f0VarArr.length;
        while (i10 < length2) {
            l4.f0 f0Var = f0VarArr[i10];
            float f12 = j0Var.f5906a;
            ((d) f0Var.f8220e).y(f10, f12);
            d dVar = (d) f0Var.f8221f;
            if (dVar != null) {
                dVar.y(f10, f12);
            }
            i10++;
        }
    }

    public final void x0(int i10, int i11, List list) {
        this.U.f(1);
        d9.p pVar = this.G;
        pVar.getClass();
        ArrayList arrayList = (ArrayList) pVar.f4314c;
        l1.d.b(i10 >= 0 && i10 <= i11 && i11 <= arrayList.size());
        l1.d.b(list.size() == i11 - i10);
        for (int i12 = i10; i12 < i11; i12++) {
            ((x0) arrayList.get(i12)).f11483a.r((i1.a0) list.get(i12 - i10));
        }
        v(pVar.c(), false);
    }

    public final y0 y(c2.d0 d0Var, long j10, long j11, long j12, boolean z10, int i10) {
        o9.w0 w0Var;
        boolean z11;
        this.f11329l0 = (!this.f11329l0 && j10 == this.T.f11510s && d0Var.equals(this.T.f11494b)) ? false : true;
        P();
        y0 y0Var = this.T;
        n1 n1Var = y0Var.f11499h;
        f2.x xVar = y0Var.f11500i;
        List list = y0Var.f11501j;
        if (this.G.f4312a) {
            m0 m0Var = this.F.f11430i;
            n1Var = m0Var == null ? n1.f2659d : m0Var.f11389n;
            xVar = m0Var == null ? this.f11340s : m0Var.f11390o;
            f2.t[] tVarArr = xVar.f4959c;
            o9.d0 d0Var2 = new o9.d0(4);
            boolean z12 = false;
            for (f2.t tVar : tVarArr) {
                if (tVar != null) {
                    i1.f0 f0Var = tVar.d(0).f5989l;
                    if (f0Var == null) {
                        d0Var2.a(new i1.f0(new i1.e0[0]));
                    } else {
                        d0Var2.a(f0Var);
                        z12 = true;
                    }
                }
            }
            if (z12) {
                w0Var = d0Var2.f();
            } else {
                o9.e0 e0Var = o9.g0.f9617p;
                w0Var = o9.w0.f9686s;
            }
            list = w0Var;
            if (m0Var != null) {
                n0 n0Var = m0Var.g;
                if (n0Var.f11415c != j11) {
                    m0Var.g = n0Var.a(j11);
                }
            }
            l4.f0[] f0VarArr = this.f11332o;
            o0 o0Var = this.F;
            m0 m0Var2 = o0Var.f11430i;
            if (m0Var2 == o0Var.f11431j && m0Var2 != null) {
                f2.x xVar2 = m0Var2.f11390o;
                int i11 = 0;
                boolean z13 = false;
                while (true) {
                    if (i11 >= f0VarArr.length) {
                        z11 = true;
                        break;
                    }
                    if (xVar2.b(i11)) {
                        if (((d) f0VarArr[i11].f8220e).f11249p != 1) {
                            z11 = false;
                            break;
                        }
                        if (xVar2.f4958b[i11].f11262a != 0) {
                            z13 = true;
                        }
                    }
                    i11++;
                }
                boolean z14 = z13 && z11;
                if (z14 != this.f11324f0) {
                    this.f11324f0 = z14;
                    if (!z14 && this.T.f11507p) {
                        this.f11343v.e(2);
                    }
                }
            }
        } else if (!d0Var.equals(y0Var.f11494b)) {
            n1Var = n1.f2659d;
            xVar = this.f11340s;
            list = o9.w0.f9686s;
        }
        n1 n1Var2 = n1Var;
        f2.x xVar3 = xVar;
        List list2 = list;
        if (z10) {
            b4.u uVar = this.U;
            if (!uVar.f2420d || uVar.f2421e == 5) {
                uVar.f2419c = true;
                uVar.f2420d = true;
                uVar.f2421e = i10;
            } else {
                l1.d.b(i10 == 5);
            }
        }
        y0 y0Var2 = this.T;
        return y0Var2.d(d0Var, j10, j11, j12, p(y0Var2.f11508q), n1Var2, xVar3, list2);
    }

    public final void y0(int i10, int i11, int i12, boolean z10) {
        boolean z11 = z10 && i10 != -1;
        if (i10 == -1) {
            i12 = 2;
        } else if (i12 == 2) {
            i12 = 1;
        }
        if (i10 == 0) {
            i11 = 1;
        } else if (i11 == 1) {
            i11 = 0;
        }
        y0 y0Var = this.T;
        if (y0Var.f11503l == z11 && y0Var.f11505n == i11 && y0Var.f11504m == i12) {
            return;
        }
        this.T = y0Var.e(i12, i11, z11);
        B0(false, false);
        o0 o0Var = this.F;
        for (m0 m0Var = o0Var.f11430i; m0Var != null; m0Var = m0Var.f11388m) {
            for (f2.t tVar : m0Var.f11390o.f4959c) {
                if (tVar != null) {
                    tVar.a(z11);
                }
            }
        }
        if (!q0()) {
            u0();
            z0();
            y0 y0Var2 = this.T;
            if (y0Var2.f11507p) {
                this.T = y0Var2.i(false);
            }
            o0Var.m(this.f11326i0);
            return;
        }
        int i13 = this.T.f11497e;
        l1.x xVar = this.f11343v;
        if (i13 != 3) {
            if (i13 == 2) {
                xVar.e(2);
            }
        } else {
            i2.o oVar = this.B;
            oVar.f6266p = true;
            ((g1) oVar.f6267q).f();
            s0();
            xVar.e(2);
        }
    }

    /* JADX WARN: Type inference failed for: r2v21, types: [c2.b0, java.lang.Object] */
    public final void z0() {
        long j10;
        float f10;
        m0 m0Var = this.F.f11430i;
        if (m0Var == null) {
            return;
        }
        long g = m0Var.f11381e ? m0Var.f11377a.g() : -9223372036854775807L;
        if (g != -9223372036854775807L) {
            if (!m0Var.g()) {
                this.F.n(m0Var);
                u(false);
                C();
            }
            Q(g);
            if (g != this.T.f11510s) {
                y0 y0Var = this.T;
                this.T = y(y0Var.f11494b, g, y0Var.f11495c, g, true, 5);
            }
        } else {
            i2.o oVar = this.B;
            boolean z10 = m0Var != this.F.f11431j;
            g1 g1Var = (g1) oVar.f6267q;
            d dVar = (d) oVar.f6269s;
            if (dVar == null || dVar.l() || ((z10 && ((d) oVar.f6269s).f11255v != 2) || (!((d) oVar.f6269s).m() && (z10 || ((d) oVar.f6269s).k())))) {
                oVar.f6265o = true;
                if (oVar.f6266p) {
                    g1Var.f();
                }
            } else {
                l0 l0Var = (l0) oVar.f6270t;
                l0Var.getClass();
                long e7 = l0Var.e();
                if (oVar.f6265o) {
                    if (e7 >= g1Var.e()) {
                        oVar.f6265o = false;
                        if (oVar.f6266p) {
                            g1Var.f();
                        }
                    } else if (g1Var.f11313q) {
                        g1Var.c(g1Var.e());
                        g1Var.f11313q = false;
                    }
                }
                g1Var.c(e7);
                i1.j0 d6 = l0Var.d();
                if (!d6.equals((i1.j0) g1Var.f11315s)) {
                    g1Var.a(d6);
                    ((h0) oVar.f6268r).f11343v.a(16, d6).b();
                }
            }
            long e8 = oVar.e();
            this.f11326i0 = e8;
            long j11 = e8 - m0Var.f11391p;
            long j12 = this.T.f11510s;
            if (!this.C.isEmpty() && !this.T.f11494b.b()) {
                if (this.f11329l0) {
                    this.f11329l0 = false;
                }
                y0 y0Var2 = this.T;
                y0Var2.f11493a.b(y0Var2.f11494b.f2539a);
                int min = Math.min(this.f11328k0, this.C.size());
                if (min > 0 && this.C.get(min - 1) != null) {
                    throw new ClassCastException();
                }
                if (min < this.C.size() && this.C.get(min) != null) {
                    throw new ClassCastException();
                }
                this.f11328k0 = min;
            }
            if (this.B.b()) {
                boolean z11 = !this.U.f2420d;
                y0 y0Var3 = this.T;
                this.T = y(y0Var3.f11494b, j11, y0Var3.f11495c, j11, z11, 6);
            } else {
                y0 y0Var4 = this.T;
                y0Var4.f11510s = j11;
                y0Var4.f11511t = SystemClock.elapsedRealtime();
            }
        }
        this.T.f11508q = this.F.f11433l.d();
        y0 y0Var5 = this.T;
        y0Var5.f11509r = p(y0Var5.f11508q);
        y0 y0Var6 = this.T;
        if (y0Var6.f11503l && y0Var6.f11497e == 3 && r0(y0Var6.f11493a, y0Var6.f11494b)) {
            y0 y0Var7 = this.T;
            float f11 = 1.0f;
            if (y0Var7.f11506o.f5906a == 1.0f) {
                g gVar = this.H;
                long m10 = m(y0Var7.f11493a, y0Var7.f11494b.f2539a, y0Var7.f11510s);
                long j13 = this.T.f11509r;
                if (gVar.f11297c != -9223372036854775807L) {
                    long j14 = m10 - j13;
                    long j15 = gVar.f11306m;
                    if (j15 == -9223372036854775807L) {
                        gVar.f11306m = j14;
                        gVar.f11307n = 0L;
                    } else {
                        gVar.f11306m = Math.max(j14, (long) ((j14 * 9.999871E-4f) + (j15 * 0.999f)));
                        gVar.f11307n = (long) ((9.999871E-4f * Math.abs(j14 - r9)) + (gVar.f11307n * 0.999f));
                    }
                    if (gVar.f11305l != -9223372036854775807L) {
                        j10 = 1000;
                        if (SystemClock.elapsedRealtime() - gVar.f11305l < 1000) {
                            f11 = gVar.f11304k;
                        }
                    } else {
                        j10 = 1000;
                    }
                    gVar.f11305l = SystemClock.elapsedRealtime();
                    long j16 = (gVar.f11307n * 3) + gVar.f11306m;
                    if (gVar.f11301h > j16) {
                        float O = l1.a0.O(j10);
                        f10 = 1.0E-7f;
                        long[] jArr = {j16, gVar.f11299e, gVar.f11301h - (((long) ((gVar.f11304k - 1.0f) * O)) + ((long) ((gVar.f11302i - 1.0f) * O)))};
                        long j17 = jArr[0];
                        for (int i10 = 1; i10 < 3; i10++) {
                            long j18 = jArr[i10];
                            if (j18 > j17) {
                                j17 = j18;
                            }
                        }
                        gVar.f11301h = j17;
                    } else {
                        f10 = 1.0E-7f;
                        long j19 = l1.a0.j(m10 - ((long) (Math.max(0.0f, gVar.f11304k - 1.0f) / 1.0E-7f)), gVar.f11301h, j16);
                        gVar.f11301h = j19;
                        long j20 = gVar.g;
                        if (j20 != -9223372036854775807L && j19 > j20) {
                            gVar.f11301h = j20;
                        }
                    }
                    long j21 = m10 - gVar.f11301h;
                    if (Math.abs(j21) < gVar.f11295a) {
                        gVar.f11304k = 1.0f;
                    } else {
                        gVar.f11304k = l1.a0.h((f10 * j21) + 1.0f, gVar.f11303j, gVar.f11302i);
                    }
                    f11 = gVar.f11304k;
                }
                if (this.B.d().f5906a != f11) {
                    i1.j0 j0Var = new i1.j0(f11, this.T.f11506o.f5907b);
                    this.f11343v.d(16);
                    this.B.a(j0Var);
                    x(this.T.f11506o, this.B.d().f5906a, false, false);
                }
            }
        }
    }
}
