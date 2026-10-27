package s1;

import android.content.Context;
import android.graphics.Rect;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackSession;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.image.ImageOutput;
import c2.h1;
import c2.n1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import o9.k1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 extends b0.j implements ExoPlayer {
    public final y A;
    public final c4.e B;
    public final k2.j0 C;
    public final k2.j0 D;
    public final long E;
    public final b4.b F;
    public int G;
    public boolean H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public o9.j0 M;
    public final e1 N;
    public final f1 O;
    public h1 P;
    public final o Q;
    public i1.k0 R;
    public i1.d0 S;
    public Object T;
    public Surface U;
    public SurfaceHolder V;
    public j2.k W;
    public boolean X;
    public TextureView Y;
    public final int Z;

    /* renamed from: a0, reason: collision with root package name */
    public l1.u f11183a0;

    /* renamed from: b, reason: collision with root package name */
    public final f2.x f11184b;

    /* renamed from: b0, reason: collision with root package name */
    public i1.d f11185b0;

    /* renamed from: c, reason: collision with root package name */
    public final i1.k0 f11186c;

    /* renamed from: c0, reason: collision with root package name */
    public float f11187c0;

    /* renamed from: d, reason: collision with root package name */
    public final l1.g f11188d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f11189d0;

    /* renamed from: e, reason: collision with root package name */
    public final Context f11190e;

    /* renamed from: e0, reason: collision with root package name */
    public k1.c f11191e0;

    /* renamed from: f, reason: collision with root package name */
    public final a0 f11192f;

    /* renamed from: f0, reason: collision with root package name */
    public final boolean f11193f0;
    public final d[] g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f11194g0;

    /* renamed from: h, reason: collision with root package name */
    public final d[] f11195h;
    public final int h0;

    /* renamed from: i, reason: collision with root package name */
    public final f2.w f11196i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f11197i0;

    /* renamed from: j, reason: collision with root package name */
    public final l1.x f11198j;

    /* renamed from: j0, reason: collision with root package name */
    public i1.f1 f11199j0;

    /* renamed from: k, reason: collision with root package name */
    public final s f11200k;

    /* renamed from: k0, reason: collision with root package name */
    public i1.d0 f11201k0;

    /* renamed from: l, reason: collision with root package name */
    public final h0 f11202l;

    /* renamed from: l0, reason: collision with root package name */
    public y0 f11203l0;

    /* renamed from: m, reason: collision with root package name */
    public final l1.p f11204m;

    /* renamed from: m0, reason: collision with root package name */
    public int f11205m0;

    /* renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArraySet f11206n;

    /* renamed from: n0, reason: collision with root package name */
    public long f11207n0;

    /* renamed from: o, reason: collision with root package name */
    public final i1.r0 f11208o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f11209p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f11210q;

    /* renamed from: r, reason: collision with root package name */
    public final c2.c0 f11211r;

    /* renamed from: s, reason: collision with root package name */
    public final t1.o f11212s;

    /* renamed from: t, reason: collision with root package name */
    public final Looper f11213t;

    /* renamed from: u, reason: collision with root package name */
    public final g2.d f11214u;

    /* renamed from: v, reason: collision with root package name */
    public final long f11215v;

    /* renamed from: w, reason: collision with root package name */
    public final long f11216w;

    /* renamed from: x, reason: collision with root package name */
    public final long f11217x;

    /* renamed from: y, reason: collision with root package name */
    public final l1.v f11218y;

    /* renamed from: z, reason: collision with root package name */
    public final x f11219z;

    static {
        i1.b0.a("media3.exoplayer");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(n nVar) {
        super(2);
        f.j jVar = nVar.f11392a;
        this.f11188d = new l1.g();
        try {
            l1.b.l("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.8.0] [" + l1.a0.f8068b + "]");
            Looper looper = nVar.g;
            l1.v vVar = nVar.f11393b;
            this.f11190e = jVar.getApplicationContext();
            this.f11212s = new t1.o(vVar);
            this.h0 = nVar.f11398h;
            this.f11185b0 = nVar.f11399i;
            this.Z = nVar.f11400j;
            this.f11189d0 = false;
            this.E = nVar.f11409s;
            x xVar = new x(this);
            this.f11219z = xVar;
            this.A = new y();
            d[] a10 = ((j) nVar.f11394c.get()).a(new Handler(looper), xVar, xVar, xVar, xVar);
            this.g = a10;
            l1.d.g(a10.length > 0);
            this.f11195h = new d[a10.length];
            int i10 = 0;
            while (true) {
                d[] dVarArr = this.f11195h;
                if (i10 >= dVarArr.length) {
                    break;
                }
                int i11 = this.g[i10].f11249p;
                dVarArr[i10] = null;
                i10++;
            }
            this.f11196i = (f2.w) nVar.f11396e.get();
            this.f11211r = (c2.c0) nVar.f11395d.get();
            this.f11214u = (g2.d) nVar.f11397f.get();
            this.f11210q = nVar.f11401k;
            this.O = nVar.f11402l;
            this.f11215v = nVar.f11404n;
            this.f11216w = nVar.f11405o;
            this.f11217x = nVar.f11406p;
            this.N = nVar.f11403m;
            this.f11213t = looper;
            this.f11218y = vVar;
            this.f11192f = this;
            this.f11204m = new l1.p(looper, vVar, new h3.b(16, this));
            this.f11206n = new CopyOnWriteArraySet();
            this.f11209p = new ArrayList();
            this.P = new h1();
            this.Q = o.f11422a;
            d[] dVarArr2 = this.g;
            this.f11184b = new f2.x(new d1[dVarArr2.length], new f2.t[dVarArr2.length], i1.b1.f5811b, null);
            this.f11208o = new i1.r0();
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int[] iArr = {1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32};
            for (int i12 = 0; i12 < 20; i12++) {
                int i13 = iArr[i12];
                l1.d.g(!false);
                sparseBooleanArray.append(i13, true);
            }
            this.f11196i.getClass();
            l1.d.g(!false);
            sparseBooleanArray.append(29, true);
            l1.d.g(!false);
            i1.n nVar2 = new i1.n(sparseBooleanArray);
            this.f11186c = new i1.k0(nVar2);
            SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray();
            for (int i14 = 0; i14 < nVar2.f5920a.size(); i14++) {
                int a11 = nVar2.a(i14);
                l1.d.g(!false);
                sparseBooleanArray2.append(a11, true);
            }
            l1.d.g(!false);
            sparseBooleanArray2.append(4, true);
            l1.d.g(!false);
            sparseBooleanArray2.append(10, true);
            l1.d.g(!false);
            this.R = new i1.k0(new i1.n(sparseBooleanArray2));
            this.f11198j = this.f11218y.a(this.f11213t, null);
            s sVar = new s(this);
            this.f11200k = sVar;
            this.f11203l0 = y0.k(this.f11184b);
            this.f11212s.P(this.f11192f, this.f11213t);
            final t1.u uVar = new t1.u(nVar.f11412v);
            h0 h0Var = new h0(this.f11190e, this.g, this.f11195h, this.f11196i, this.f11184b, new i(), this.f11214u, this.G, this.H, this.f11212s, this.O, nVar.f11407q, nVar.f11408r, this.f11213t, this.f11218y, sVar, uVar, this.Q, this.A);
            l1.x xVar2 = h0Var.f11343v;
            this.f11202l = h0Var;
            Looper looper2 = h0Var.f11345x;
            this.f11187c0 = 1.0f;
            this.G = 0;
            i1.d0 d0Var = i1.d0.B;
            this.S = d0Var;
            this.f11201k0 = d0Var;
            this.f11205m0 = -1;
            this.f11191e0 = k1.c.f7641c;
            this.f11193f0 = true;
            t1.o oVar = this.f11212s;
            l1.p pVar = this.f11204m;
            oVar.getClass();
            pVar.a(oVar);
            g2.d dVar = this.f11214u;
            Handler handler = new Handler(this.f11213t);
            t1.o oVar2 = this.f11212s;
            g2.g gVar = (g2.g) dVar;
            gVar.getClass();
            oVar2.getClass();
            a6.n nVar3 = gVar.f5103c;
            nVar3.getClass();
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) nVar3.f74p;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                g2.c cVar = (g2.c) it.next();
                if (cVar.f5085b == oVar2) {
                    cVar.f5086c = true;
                    copyOnWriteArrayList.remove(cVar);
                }
            }
            copyOnWriteArrayList.add(new g2.c(handler, oVar2));
            this.f11206n.add(this.f11219z);
            if (Build.VERSION.SDK_INT >= 31) {
                final Context context = this.f11190e;
                final boolean z10 = nVar.f11410t;
                this.f11218y.a(h0Var.f11345x, null).c(new Runnable() { // from class: s1.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlaybackSession createPlaybackSession;
                        t1.t tVar;
                        LogSessionId sessionId;
                        boolean equals;
                        LogSessionId unused;
                        Context context2 = context;
                        boolean z11 = z10;
                        a0 a0Var = this;
                        t1.u uVar2 = uVar;
                        MediaMetricsManager k10 = a9.e.k(context2.getSystemService("media_metrics"));
                        if (k10 == null) {
                            tVar = null;
                        } else {
                            createPlaybackSession = k10.createPlaybackSession();
                            tVar = new t1.t(context2, createPlaybackSession);
                        }
                        if (tVar == null) {
                            l1.b.q("ExoPlayerImpl", "MediaMetricsService unavailable.");
                            return;
                        }
                        if (z11) {
                            a0Var.q(tVar);
                        }
                        sessionId = tVar.f11848d.getSessionId();
                        synchronized (uVar2) {
                            p4.p pVar2 = uVar2.f11871b;
                            pVar2.getClass();
                            LogSessionId logSessionId = (LogSessionId) pVar2.f9953p;
                            unused = LogSessionId.LOG_SESSION_ID_NONE;
                            equals = logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE);
                            l1.d.g(equals);
                            pVar2.f9953p = sessionId;
                        }
                    }
                });
            }
            b4.b bVar = new b4.b(0, looper2, this.f11213t, this.f11218y, new s(this));
            this.F = bVar;
            bVar.t(new androidx.activity.d(22, this));
            c4.e eVar = new c4.e(jVar, looper2, nVar.g, this.f11219z, this.f11218y);
            this.B = eVar;
            eVar.h();
            this.C = new k2.j0(jVar, looper2, this.f11218y, 2);
            this.D = new k2.j0(jVar, looper2, this.f11218y, 3);
            int i15 = i1.i.f5899c;
            this.f11199j0 = i1.f1.f5878d;
            this.f11183a0 = l1.u.f8132c;
            xVar2.a(38, this.N).b();
            i1.d dVar2 = this.f11185b0;
            xVar2.getClass();
            l1.w b2 = l1.x.b();
            b2.f8136a = xVar2.f8138a.obtainMessage(31, 0, 0, dVar2);
            b2.b();
            R(1, 3, this.f11185b0);
            R(2, 4, Integer.valueOf(this.Z));
            R(2, 5, 0);
            R(1, 9, Boolean.valueOf(this.f11189d0));
            R(6, 8, this.A);
            R(-1, 16, Integer.valueOf(this.h0));
            this.f11188d.f();
        } catch (Throwable th) {
            this.f11188d.f();
            throw th;
        }
    }

    public static long G(y0 y0Var) {
        i1.s0 s0Var = new i1.s0();
        i1.r0 r0Var = new i1.r0();
        y0Var.f11493a.g(y0Var.f11494b.f2539a, r0Var);
        long j10 = y0Var.f11495c;
        return j10 == -9223372036854775807L ? y0Var.f11493a.m(r0Var.f6014c, s0Var, 0L).f6031l : r0Var.f6016e + j10;
    }

    public static y0 J(y0 y0Var, int i10) {
        y0 h10 = y0Var.h(i10);
        return (i10 == 1 || i10 == 4) ? h10.b(false) : h10;
    }

    public final i1.t0 A() {
        f0();
        return this.f11203l0.f11493a;
    }

    public final i1.b1 B() {
        f0();
        return this.f11203l0.f11500i.f4960d;
    }

    public final int C(y0 y0Var) {
        return y0Var.f11493a.p() ? this.f11205m0 : y0Var.f11493a.g(y0Var.f11494b.f2539a, this.f11208o).f6014c;
    }

    public final long D() {
        f0();
        if (!I()) {
            return c();
        }
        y0 y0Var = this.f11203l0;
        c2.d0 d0Var = y0Var.f11494b;
        i1.t0 t0Var = y0Var.f11493a;
        Object obj = d0Var.f2539a;
        i1.r0 r0Var = this.f11208o;
        t0Var.g(obj, r0Var);
        return l1.a0.Z(r0Var.a(d0Var.f2540b, d0Var.f2541c));
    }

    public final boolean E() {
        f0();
        return this.f11203l0.f11503l;
    }

    public final int F() {
        f0();
        return this.f11203l0.f11497e;
    }

    public final i1.z0 H() {
        f0();
        f2.k e7 = ((f2.r) this.f11196i).e();
        if (!this.L) {
            return e7;
        }
        e7.getClass();
        f2.j jVar = new f2.j(e7);
        jVar.k(this.M);
        return new f2.k(jVar);
    }

    public final boolean I() {
        f0();
        return this.f11203l0.f11494b.b();
    }

    public final y0 K(y0 y0Var, i1.t0 t0Var, Pair pair) {
        List list;
        l1.d.b(t0Var.p() || pair != null);
        i1.t0 t0Var2 = y0Var.f11493a;
        long u10 = u(y0Var);
        y0 j10 = y0Var.j(t0Var);
        if (t0Var.p()) {
            c2.d0 d0Var = y0.f11492u;
            long O = l1.a0.O(this.f11207n0);
            y0 c10 = j10.d(d0Var, O, O, O, 0L, n1.f2659d, this.f11184b, o9.w0.f9686s).c(d0Var);
            c10.f11508q = c10.f11510s;
            return c10;
        }
        Object obj = j10.f11494b.f2539a;
        boolean equals = obj.equals(pair.first);
        c2.d0 d0Var2 = !equals ? new c2.d0(pair.first) : j10.f11494b;
        long longValue = ((Long) pair.second).longValue();
        long O2 = l1.a0.O(u10);
        if (!t0Var2.p()) {
            O2 -= t0Var2.g(obj, this.f11208o).f6016e;
        }
        if (!equals || longValue < O2) {
            c2.d0 d0Var3 = d0Var2;
            l1.d.g(!d0Var3.b());
            n1 n1Var = !equals ? n1.f2659d : j10.f11499h;
            f2.x xVar = !equals ? this.f11184b : j10.f11500i;
            if (equals) {
                list = j10.f11501j;
            } else {
                o9.e0 e0Var = o9.g0.f9617p;
                list = o9.w0.f9686s;
            }
            y0 c11 = j10.d(d0Var3, longValue, longValue, longValue, 0L, n1Var, xVar, list).c(d0Var3);
            c11.f11508q = longValue;
            return c11;
        }
        if (longValue != O2) {
            c2.d0 d0Var4 = d0Var2;
            l1.d.g(!d0Var4.b());
            long max = Math.max(0L, j10.f11509r - (longValue - O2));
            long j11 = j10.f11508q;
            if (j10.f11502k.equals(j10.f11494b)) {
                j11 = longValue + max;
            }
            y0 d6 = j10.d(d0Var4, longValue, longValue, longValue, max, j10.f11499h, j10.f11500i, j10.f11501j);
            d6.f11508q = j11;
            return d6;
        }
        int b2 = t0Var.b(j10.f11502k.f2539a);
        if (b2 != -1 && t0Var.f(b2, this.f11208o, false).f6014c == t0Var.g(d0Var2.f2539a, this.f11208o).f6014c) {
            return j10;
        }
        t0Var.g(d0Var2.f2539a, this.f11208o);
        long a10 = d0Var2.b() ? this.f11208o.a(d0Var2.f2540b, d0Var2.f2541c) : this.f11208o.f6015d;
        c2.d0 d0Var5 = d0Var2;
        y0 c12 = j10.d(d0Var5, j10.f11510s, j10.f11510s, j10.f11496d, a10 - j10.f11510s, j10.f11499h, j10.f11500i, j10.f11501j).c(d0Var5);
        c12.f11508q = a10;
        return c12;
    }

    public final Pair L(i1.t0 t0Var, int i10, long j10) {
        if (t0Var.p()) {
            this.f11205m0 = i10;
            if (j10 == -9223372036854775807L) {
                j10 = 0;
            }
            this.f11207n0 = j10;
            return null;
        }
        if (i10 == -1 || i10 >= t0Var.o()) {
            i10 = t0Var.a(this.H);
            j10 = l1.a0.Z(t0Var.m(i10, (i1.s0) this.f2162a, 0L).f6031l);
        }
        return t0Var.i((i1.s0) this.f2162a, this.f11208o, i10, l1.a0.O(j10));
    }

    public final void M(final int i10, final int i11) {
        l1.u uVar = this.f11183a0;
        if (i10 == uVar.f8133a && i11 == uVar.f8134b) {
            return;
        }
        this.f11183a0 = new l1.u(i10, i11);
        this.f11204m.e(24, new l1.m() { // from class: s1.r
            @Override // l1.m
            public final void invoke(Object obj) {
                ((i1.m0) obj).E(i10, i11);
            }
        });
        R(2, 14, new l1.u(i10, i11));
    }

    public final void N() {
        f0();
        y0 y0Var = this.f11203l0;
        if (y0Var.f11497e != 1) {
            return;
        }
        y0 f10 = y0Var.f(null);
        y0 J = J(f10, f10.f11493a.p() ? 4 : 2);
        this.I++;
        l1.x xVar = this.f11202l.f11343v;
        xVar.getClass();
        l1.w b2 = l1.x.b();
        b2.f8136a = xVar.f8138a.obtainMessage(29);
        b2.b();
        d0(J, 1, false, 5, -9223372036854775807L, -1, false);
    }

    public final void O() {
        String str;
        boolean z10;
        StringBuilder sb2 = new StringBuilder("Release ");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" [AndroidXMedia3/1.8.0] [");
        sb2.append(l1.a0.f8068b);
        sb2.append("] [");
        HashSet hashSet = i1.b0.f5809a;
        synchronized (i1.b0.class) {
            str = i1.b0.f5810b;
        }
        sb2.append(str);
        sb2.append("]");
        l1.b.l("ExoPlayerImpl", sb2.toString());
        f0();
        this.B.h();
        this.C.a(false);
        this.D.a(false);
        h0 h0Var = this.f11202l;
        if (h0Var.V || !h0Var.f11345x.getThread().isAlive()) {
            z10 = true;
        } else {
            h0Var.V = true;
            l1.g gVar = new l1.g(h0Var.D);
            h0Var.f11343v.a(7, gVar).b();
            z10 = gVar.d(h0Var.I);
        }
        if (!z10) {
            this.f11204m.e(10, new h3.b(15));
        }
        this.f11204m.d();
        this.f11198j.f8138a.removeCallbacksAndMessages(null);
        g2.d dVar = this.f11214u;
        t1.o oVar = this.f11212s;
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) ((g2.g) dVar).f5103c.f74p;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            g2.c cVar = (g2.c) it.next();
            if (cVar.f5085b == oVar) {
                cVar.f5086c = true;
                copyOnWriteArrayList.remove(cVar);
            }
        }
        y0 y0Var = this.f11203l0;
        if (y0Var.f11507p) {
            this.f11203l0 = y0Var.a();
        }
        y0 J = J(this.f11203l0, 1);
        this.f11203l0 = J;
        y0 c10 = J.c(J.f11494b);
        this.f11203l0 = c10;
        c10.f11508q = c10.f11510s;
        this.f11203l0.f11509r = 0L;
        t1.o oVar2 = this.f11212s;
        l1.x xVar = oVar2.f11829v;
        l1.d.h(xVar);
        xVar.c(new androidx.activity.d(25, oVar2));
        Q();
        Surface surface = this.U;
        if (surface != null) {
            surface.release();
            this.U = null;
        }
        this.f11191e0 = k1.c.f7641c;
        this.f11197i0 = true;
    }

    public final void P(i1.m0 m0Var) {
        f0();
        m0Var.getClass();
        l1.p pVar = this.f11204m;
        pVar.f();
        CopyOnWriteArraySet copyOnWriteArraySet = pVar.f8111d;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            l1.o oVar = (l1.o) it.next();
            if (oVar.f8104a.equals(m0Var)) {
                l1.n nVar = pVar.f8110c;
                oVar.f8107d = true;
                if (oVar.f8106c) {
                    oVar.f8106c = false;
                    nVar.b(oVar.f8104a, oVar.f8105b.b());
                }
                copyOnWriteArraySet.remove(oVar);
            }
        }
    }

    public final void Q() {
        j2.k kVar = this.W;
        x xVar = this.f11219z;
        if (kVar != null) {
            b1 t3 = t(this.A);
            l1.d.g(!t3.f11229f);
            t3.f11226c = 10000;
            l1.d.g(!t3.f11229f);
            t3.f11227d = null;
            t3.b();
            this.W.f7044o.remove(xVar);
            this.W = null;
        }
        TextureView textureView = this.Y;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != xVar) {
                l1.b.q("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.Y.setSurfaceTextureListener(null);
            }
            this.Y = null;
        }
        SurfaceHolder surfaceHolder = this.V;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(xVar);
            this.V = null;
        }
    }

    public final void R(int i10, int i11, Object obj) {
        for (d dVar : this.g) {
            if (i10 == -1 || dVar.f11249p == i10) {
                b1 t3 = t(dVar);
                l1.d.g(!t3.f11229f);
                t3.f11226c = i11;
                l1.d.g(!t3.f11229f);
                t3.f11227d = obj;
                t3.b();
            }
        }
        for (d dVar2 : this.f11195h) {
            if (dVar2 != null && (i10 == -1 || dVar2.f11249p == i10)) {
                b1 t8 = t(dVar2);
                l1.d.g(!t8.f11229f);
                t8.f11226c = i11;
                l1.d.g(!t8.f11229f);
                t8.f11227d = obj;
                t8.b();
            }
        }
    }

    public final void S() {
        i1.d dVar = i1.d.f5843b;
        f0();
        if (this.f11197i0) {
            return;
        }
        boolean equals = Objects.equals(this.f11185b0, dVar);
        l1.p pVar = this.f11204m;
        if (!equals) {
            this.f11185b0 = dVar;
            R(1, 3, dVar);
            pVar.c(20, new h3.b(17));
        }
        i1.d dVar2 = this.f11185b0;
        l1.x xVar = this.f11202l.f11343v;
        xVar.getClass();
        l1.w b2 = l1.x.b();
        b2.f8136a = xVar.f8138a.obtainMessage(31, 1, 0, dVar2);
        b2.b();
        pVar.b();
    }

    public final void T(SurfaceHolder surfaceHolder) {
        this.X = false;
        this.V = surfaceHolder;
        surfaceHolder.addCallback(this.f11219z);
        Surface surface = this.V.getSurface();
        if (surface == null || !surface.isValid()) {
            M(0, 0);
        } else {
            Rect surfaceFrame = this.V.getSurfaceFrame();
            M(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public final void U(boolean z10) {
        f0();
        c0(1, z10);
    }

    public final void V(int i10) {
        f0();
        if (this.G != i10) {
            this.G = i10;
            l1.x xVar = this.f11202l.f11343v;
            xVar.getClass();
            l1.w b2 = l1.x.b();
            b2.f8136a = xVar.f8138a.obtainMessage(11, i10, 0);
            b2.b();
            t tVar = new t(i10, 0);
            l1.p pVar = this.f11204m;
            pVar.c(8, tVar);
            b0();
            pVar.b();
        }
    }

    public final void W(i1.z0 z0Var) {
        i1.z0 z0Var2;
        f0();
        f2.w wVar = this.f11196i;
        wVar.getClass();
        i1.z0 H = H();
        if (this.L) {
            this.M = z0Var.E;
            o9.j0 j0Var = this.N.f11280a;
            i1.y0 a10 = z0Var.a();
            k1 it = j0Var.iterator();
            while (it.hasNext()) {
                a10.j(((Integer) it.next()).intValue(), true);
            }
            z0Var2 = a10.a();
        } else {
            z0Var2 = z0Var;
        }
        if (!z0Var2.equals(((f2.r) wVar).e())) {
            wVar.b(z0Var2);
        }
        if (H.equals(z0Var)) {
            return;
        }
        this.f11204m.e(19, new androidx.fragment.app.v0(20, z0Var));
    }

    public final void X(Object obj) {
        Object obj2 = this.T;
        boolean z10 = true;
        boolean z11 = (obj2 == null || obj2 == obj) ? false : true;
        long j10 = z11 ? this.E : -9223372036854775807L;
        h0 h0Var = this.f11202l;
        if (!h0Var.V && h0Var.f11345x.getThread().isAlive()) {
            l1.g gVar = new l1.g(h0Var.D);
            h0Var.f11343v.a(30, new Pair(obj, gVar)).b();
            if (j10 != -9223372036854775807L) {
                z10 = gVar.d(j10);
            }
        }
        if (z11) {
            Object obj3 = this.T;
            Surface surface = this.U;
            if (obj3 == surface) {
                surface.release();
                this.U = null;
            }
        }
        this.T = obj;
        if (z10) {
            return;
        }
        a0(new l(2, new a6.m0("Detaching surface timed out."), 1003));
    }

    public final void Y(float f10) {
        f0();
        final float h10 = l1.a0.h(f10, 0.0f, 1.0f);
        if (this.f11187c0 == h10) {
            return;
        }
        this.f11187c0 = h10;
        this.f11202l.f11343v.a(32, Float.valueOf(h10)).b();
        this.f11204m.e(22, new l1.m() { // from class: s1.q
            @Override // l1.m
            public final void invoke(Object obj) {
                ((i1.m0) obj).u(h10);
            }
        });
    }

    public final void Z() {
        f0();
        a0(null);
        o9.w0 w0Var = o9.w0.f9686s;
        long j10 = this.f11203l0.f11510s;
        this.f11191e0 = new k1.c(w0Var);
    }

    public final void a0(l lVar) {
        y0 y0Var = this.f11203l0;
        y0 c10 = y0Var.c(y0Var.f11494b);
        c10.f11508q = c10.f11510s;
        c10.f11509r = 0L;
        y0 J = J(c10, 1);
        if (lVar != null) {
            J = J.f(lVar);
        }
        y0 y0Var2 = J;
        this.I++;
        l1.x xVar = this.f11202l.f11343v;
        xVar.getClass();
        l1.w b2 = l1.x.b();
        b2.f8136a = xVar.f8138a.obtainMessage(6);
        b2.b();
        d0(y0Var2, 0, false, 5, -9223372036854775807L, -1, false);
    }

    public final void b0() {
        int k10;
        int e7;
        i1.k0 k0Var = this.R;
        int i10 = l1.a0.f8067a;
        a0 a0Var = this.f11192f;
        boolean I = a0Var.I();
        boolean h10 = a0Var.h();
        i1.t0 A = a0Var.A();
        boolean z10 = false;
        if (A.p()) {
            k10 = -1;
        } else {
            int x6 = a0Var.x();
            a0Var.f0();
            int i11 = a0Var.G;
            if (i11 == 1) {
                i11 = 0;
            }
            a0Var.f0();
            k10 = A.k(x6, i11, a0Var.H);
        }
        boolean z11 = k10 != -1;
        i1.t0 A2 = a0Var.A();
        if (A2.p()) {
            e7 = -1;
        } else {
            int x10 = a0Var.x();
            a0Var.f0();
            int i12 = a0Var.G;
            if (i12 == 1) {
                i12 = 0;
            }
            a0Var.f0();
            e7 = A2.e(x10, i12, a0Var.H);
        }
        boolean z12 = e7 != -1;
        boolean g = a0Var.g();
        boolean f10 = a0Var.f();
        boolean p10 = a0Var.A().p();
        h5.i iVar = new h5.i(3);
        ea.a aVar = (ea.a) iVar.f5610p;
        i1.n nVar = this.f11186c.f5914a;
        aVar.getClass();
        for (int i13 = 0; i13 < nVar.f5920a.size(); i13++) {
            aVar.a(nVar.a(i13));
        }
        boolean z13 = !I;
        iVar.y(4, z13);
        iVar.y(5, h10 && !I);
        iVar.y(6, z11 && !I);
        iVar.y(7, !p10 && (z11 || !g || h10) && !I);
        iVar.y(8, z12 && !I);
        iVar.y(9, !p10 && (z12 || (g && f10)) && !I);
        iVar.y(10, z13);
        iVar.y(11, h10 && !I);
        if (h10 && !I) {
            z10 = true;
        }
        iVar.y(12, z10);
        i1.k0 k0Var2 = new i1.k0(aVar.b());
        this.R = k0Var2;
        if (k0Var2.equals(k0Var)) {
            return;
        }
        this.f11204m.c(13, new s(this));
    }

    public final void c0(int i10, boolean z10) {
        int i11 = this.L ? 4 : (this.f11203l0.f11505n != 1 || z10) ? 0 : 1;
        y0 y0Var = this.f11203l0;
        if (y0Var.f11503l == z10 && y0Var.f11505n == i11 && y0Var.f11504m == i10) {
            return;
        }
        this.I++;
        if (y0Var.f11507p) {
            y0Var = y0Var.a();
        }
        y0 e7 = y0Var.e(i10, i11, z10);
        int i12 = i10 | (i11 << 4);
        l1.x xVar = this.f11202l.f11343v;
        xVar.getClass();
        l1.w b2 = l1.x.b();
        b2.f8136a = xVar.f8138a.obtainMessage(1, z10 ? 1 : 0, i12);
        b2.b();
        d0(e7, 0, false, 5, -9223372036854775807L, -1, false);
    }

    public final void d0(final y0 y0Var, int i10, boolean z10, int i11, long j10, int i12, boolean z11) {
        Pair pair;
        int i13;
        i1.a0 a0Var;
        boolean z12;
        boolean z13;
        boolean z14;
        int i14;
        Object obj;
        i1.a0 a0Var2;
        Object obj2;
        int i15;
        long j11;
        long j12;
        long j13;
        long G;
        Object obj3;
        i1.a0 a0Var3;
        Object obj4;
        int i16;
        y0 y0Var2 = this.f11203l0;
        this.f11203l0 = y0Var;
        boolean equals = y0Var2.f11493a.equals(y0Var.f11493a);
        i1.s0 s0Var = (i1.s0) this.f2162a;
        i1.r0 r0Var = this.f11208o;
        i1.t0 t0Var = y0Var2.f11493a;
        c2.d0 d0Var = y0Var2.f11494b;
        i1.t0 t0Var2 = y0Var.f11493a;
        c2.d0 d0Var2 = y0Var.f11494b;
        if (t0Var2.p() && t0Var.p()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (t0Var2.p() != t0Var.p()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else if (t0Var.m(t0Var.g(d0Var.f2539a, r0Var).f6014c, s0Var, 0L).f6021a.equals(t0Var2.m(t0Var2.g(d0Var2.f2539a, r0Var).f6014c, s0Var, 0L).f6021a)) {
            pair = (z10 && i11 == 0 && d0Var.f2542d < d0Var2.f2542d) ? new Pair(Boolean.TRUE, 0) : (z10 && i11 == 1 && z11) ? new Pair(Boolean.TRUE, 2) : new Pair(Boolean.FALSE, -1);
        } else {
            if (z10 && i11 == 0) {
                i13 = 1;
            } else if (z10 && i11 == 1) {
                i13 = 2;
            } else {
                if (equals) {
                    throw new IllegalStateException();
                }
                i13 = 3;
            }
            pair = new Pair(Boolean.TRUE, Integer.valueOf(i13));
        }
        boolean booleanValue = ((Boolean) pair.first).booleanValue();
        int intValue = ((Integer) pair.second).intValue();
        if (booleanValue) {
            a0Var = !y0Var.f11493a.p() ? y0Var.f11493a.m(y0Var.f11493a.g(y0Var.f11494b.f2539a, this.f11208o).f6014c, (i1.s0) this.f2162a, 0L).f6023c : null;
            this.f11201k0 = i1.d0.B;
        } else {
            a0Var = null;
        }
        if (booleanValue || !y0Var2.f11501j.equals(y0Var.f11501j)) {
            i1.c0 a10 = this.f11201k0.a();
            List list = y0Var.f11501j;
            for (int i17 = 0; i17 < list.size(); i17++) {
                i1.f0 f0Var = (i1.f0) list.get(i17);
                int i18 = 0;
                while (true) {
                    i1.e0[] e0VarArr = f0Var.f5876a;
                    if (i18 < e0VarArr.length) {
                        e0VarArr[i18].c(a10);
                        i18++;
                    }
                }
            }
            this.f11201k0 = new i1.d0(a10);
        }
        i1.d0 r2 = r();
        boolean equals2 = r2.equals(this.S);
        this.S = r2;
        boolean z15 = y0Var2.f11503l != y0Var.f11503l;
        boolean z16 = y0Var2.f11497e != y0Var.f11497e;
        if (z16 || z15) {
            e0();
        }
        boolean z17 = y0Var2.g != y0Var.g;
        if (!equals) {
            this.f11204m.c(0, new c5.a(i10, 2, y0Var));
        }
        if (z10) {
            i1.r0 r0Var2 = new i1.r0();
            if (y0Var2.f11493a.p()) {
                z12 = booleanValue;
                z13 = equals2;
                z14 = z16;
                i14 = i12;
                obj = null;
                a0Var2 = null;
                obj2 = null;
                i15 = -1;
            } else {
                Object obj5 = y0Var2.f11494b.f2539a;
                y0Var2.f11493a.g(obj5, r0Var2);
                int i19 = r0Var2.f6014c;
                int b2 = y0Var2.f11493a.b(obj5);
                z12 = booleanValue;
                z13 = equals2;
                z14 = z16;
                obj = y0Var2.f11493a.m(i19, (i1.s0) this.f2162a, 0L).f6021a;
                a0Var2 = ((i1.s0) this.f2162a).f6023c;
                obj2 = obj5;
                i14 = i19;
                i15 = b2;
            }
            if (i11 == 0) {
                if (y0Var2.f11494b.b()) {
                    c2.d0 d0Var3 = y0Var2.f11494b;
                    j13 = r0Var2.a(d0Var3.f2540b, d0Var3.f2541c);
                    G = G(y0Var2);
                } else if (y0Var2.f11494b.f2543e != -1) {
                    j13 = G(this.f11203l0);
                    G = j13;
                } else {
                    j11 = r0Var2.f6016e;
                    j12 = r0Var2.f6015d;
                    j13 = j11 + j12;
                    G = j13;
                }
            } else if (y0Var2.f11494b.b()) {
                j13 = y0Var2.f11510s;
                G = G(y0Var2);
            } else {
                j11 = r0Var2.f6016e;
                j12 = y0Var2.f11510s;
                j13 = j11 + j12;
                G = j13;
            }
            long Z = l1.a0.Z(j13);
            long Z2 = l1.a0.Z(G);
            c2.d0 d0Var4 = y0Var2.f11494b;
            i1.n0 n0Var = new i1.n0(obj, i14, a0Var2, obj2, i15, Z, Z2, d0Var4.f2540b, d0Var4.f2541c);
            i1.s0 s0Var2 = (i1.s0) this.f2162a;
            int x6 = x();
            if (this.f11203l0.f11493a.p()) {
                obj3 = null;
                a0Var3 = null;
                obj4 = null;
                i16 = -1;
            } else {
                y0 y0Var3 = this.f11203l0;
                Object obj6 = y0Var3.f11494b.f2539a;
                y0Var3.f11493a.g(obj6, this.f11208o);
                int b10 = this.f11203l0.f11493a.b(obj6);
                Object obj7 = this.f11203l0.f11493a.m(x6, s0Var2, 0L).f6021a;
                a0Var3 = s0Var2.f6023c;
                i16 = b10;
                obj4 = obj6;
                obj3 = obj7;
            }
            long Z3 = l1.a0.Z(j10);
            long Z4 = this.f11203l0.f11494b.b() ? l1.a0.Z(G(this.f11203l0)) : Z3;
            c2.d0 d0Var5 = this.f11203l0.f11494b;
            this.f11204m.c(11, new v(i11, n0Var, new i1.n0(obj3, x6, a0Var3, obj4, i16, Z3, Z4, d0Var5.f2540b, d0Var5.f2541c)));
        } else {
            z12 = booleanValue;
            z13 = equals2;
            z14 = z16;
        }
        if (z12) {
            this.f11204m.c(1, new c5.a(intValue, 3, a0Var));
        }
        if (y0Var2.f11498f != y0Var.f11498f) {
            final int i20 = 7;
            this.f11204m.c(10, new l1.m() { // from class: s1.p
                @Override // l1.m
                public final void invoke(Object obj8) {
                    i1.m0 m0Var = (i1.m0) obj8;
                    switch (i20) {
                        case 0:
                            y0 y0Var4 = y0Var;
                            boolean z18 = y0Var4.g;
                            m0Var.getClass();
                            m0Var.j(y0Var4.g);
                            break;
                        case 1:
                            y0 y0Var5 = y0Var;
                            m0Var.r(y0Var5.f11497e, y0Var5.f11503l);
                            break;
                        case 2:
                            m0Var.A(y0Var.f11497e);
                            break;
                        case 3:
                            y0 y0Var6 = y0Var;
                            m0Var.t(y0Var6.f11504m, y0Var6.f11503l);
                            break;
                        case 4:
                            m0Var.b(y0Var.f11505n);
                            break;
                        case 5:
                            m0Var.I(y0Var.m());
                            break;
                        case 6:
                            m0Var.z(y0Var.f11506o);
                            break;
                        case 7:
                            m0Var.v(y0Var.f11498f);
                            break;
                        case 8:
                            m0Var.B(y0Var.f11498f);
                            break;
                        default:
                            m0Var.c(y0Var.f11500i.f4960d);
                            break;
                    }
                }
            });
            if (y0Var.f11498f != null) {
                final int i21 = 8;
                this.f11204m.c(10, new l1.m() { // from class: s1.p
                    @Override // l1.m
                    public final void invoke(Object obj8) {
                        i1.m0 m0Var = (i1.m0) obj8;
                        switch (i21) {
                            case 0:
                                y0 y0Var4 = y0Var;
                                boolean z18 = y0Var4.g;
                                m0Var.getClass();
                                m0Var.j(y0Var4.g);
                                break;
                            case 1:
                                y0 y0Var5 = y0Var;
                                m0Var.r(y0Var5.f11497e, y0Var5.f11503l);
                                break;
                            case 2:
                                m0Var.A(y0Var.f11497e);
                                break;
                            case 3:
                                y0 y0Var6 = y0Var;
                                m0Var.t(y0Var6.f11504m, y0Var6.f11503l);
                                break;
                            case 4:
                                m0Var.b(y0Var.f11505n);
                                break;
                            case 5:
                                m0Var.I(y0Var.m());
                                break;
                            case 6:
                                m0Var.z(y0Var.f11506o);
                                break;
                            case 7:
                                m0Var.v(y0Var.f11498f);
                                break;
                            case 8:
                                m0Var.B(y0Var.f11498f);
                                break;
                            default:
                                m0Var.c(y0Var.f11500i.f4960d);
                                break;
                        }
                    }
                });
            }
        }
        f2.x xVar = y0Var2.f11500i;
        f2.x xVar2 = y0Var.f11500i;
        if (xVar != xVar2) {
            f2.w wVar = this.f11196i;
            Object obj8 = xVar2.f4961e;
            wVar.getClass();
            wVar.f4956c = (f2.v) obj8;
            final int i22 = 9;
            this.f11204m.c(2, new l1.m() { // from class: s1.p
                @Override // l1.m
                public final void invoke(Object obj82) {
                    i1.m0 m0Var = (i1.m0) obj82;
                    switch (i22) {
                        case 0:
                            y0 y0Var4 = y0Var;
                            boolean z18 = y0Var4.g;
                            m0Var.getClass();
                            m0Var.j(y0Var4.g);
                            break;
                        case 1:
                            y0 y0Var5 = y0Var;
                            m0Var.r(y0Var5.f11497e, y0Var5.f11503l);
                            break;
                        case 2:
                            m0Var.A(y0Var.f11497e);
                            break;
                        case 3:
                            y0 y0Var6 = y0Var;
                            m0Var.t(y0Var6.f11504m, y0Var6.f11503l);
                            break;
                        case 4:
                            m0Var.b(y0Var.f11505n);
                            break;
                        case 5:
                            m0Var.I(y0Var.m());
                            break;
                        case 6:
                            m0Var.z(y0Var.f11506o);
                            break;
                        case 7:
                            m0Var.v(y0Var.f11498f);
                            break;
                        case 8:
                            m0Var.B(y0Var.f11498f);
                            break;
                        default:
                            m0Var.c(y0Var.f11500i.f4960d);
                            break;
                    }
                }
            });
        }
        if (!z13) {
            this.f11204m.c(14, new androidx.fragment.app.v0(19, this.S));
        }
        if (z17) {
            final int i23 = 0;
            this.f11204m.c(3, new l1.m() { // from class: s1.p
                @Override // l1.m
                public final void invoke(Object obj82) {
                    i1.m0 m0Var = (i1.m0) obj82;
                    switch (i23) {
                        case 0:
                            y0 y0Var4 = y0Var;
                            boolean z18 = y0Var4.g;
                            m0Var.getClass();
                            m0Var.j(y0Var4.g);
                            break;
                        case 1:
                            y0 y0Var5 = y0Var;
                            m0Var.r(y0Var5.f11497e, y0Var5.f11503l);
                            break;
                        case 2:
                            m0Var.A(y0Var.f11497e);
                            break;
                        case 3:
                            y0 y0Var6 = y0Var;
                            m0Var.t(y0Var6.f11504m, y0Var6.f11503l);
                            break;
                        case 4:
                            m0Var.b(y0Var.f11505n);
                            break;
                        case 5:
                            m0Var.I(y0Var.m());
                            break;
                        case 6:
                            m0Var.z(y0Var.f11506o);
                            break;
                        case 7:
                            m0Var.v(y0Var.f11498f);
                            break;
                        case 8:
                            m0Var.B(y0Var.f11498f);
                            break;
                        default:
                            m0Var.c(y0Var.f11500i.f4960d);
                            break;
                    }
                }
            });
        }
        if (z14 || z15) {
            final int i24 = 1;
            this.f11204m.c(-1, new l1.m() { // from class: s1.p
                @Override // l1.m
                public final void invoke(Object obj82) {
                    i1.m0 m0Var = (i1.m0) obj82;
                    switch (i24) {
                        case 0:
                            y0 y0Var4 = y0Var;
                            boolean z18 = y0Var4.g;
                            m0Var.getClass();
                            m0Var.j(y0Var4.g);
                            break;
                        case 1:
                            y0 y0Var5 = y0Var;
                            m0Var.r(y0Var5.f11497e, y0Var5.f11503l);
                            break;
                        case 2:
                            m0Var.A(y0Var.f11497e);
                            break;
                        case 3:
                            y0 y0Var6 = y0Var;
                            m0Var.t(y0Var6.f11504m, y0Var6.f11503l);
                            break;
                        case 4:
                            m0Var.b(y0Var.f11505n);
                            break;
                        case 5:
                            m0Var.I(y0Var.m());
                            break;
                        case 6:
                            m0Var.z(y0Var.f11506o);
                            break;
                        case 7:
                            m0Var.v(y0Var.f11498f);
                            break;
                        case 8:
                            m0Var.B(y0Var.f11498f);
                            break;
                        default:
                            m0Var.c(y0Var.f11500i.f4960d);
                            break;
                    }
                }
            });
        }
        if (z14) {
            final int i25 = 2;
            this.f11204m.c(4, new l1.m() { // from class: s1.p
                @Override // l1.m
                public final void invoke(Object obj82) {
                    i1.m0 m0Var = (i1.m0) obj82;
                    switch (i25) {
                        case 0:
                            y0 y0Var4 = y0Var;
                            boolean z18 = y0Var4.g;
                            m0Var.getClass();
                            m0Var.j(y0Var4.g);
                            break;
                        case 1:
                            y0 y0Var5 = y0Var;
                            m0Var.r(y0Var5.f11497e, y0Var5.f11503l);
                            break;
                        case 2:
                            m0Var.A(y0Var.f11497e);
                            break;
                        case 3:
                            y0 y0Var6 = y0Var;
                            m0Var.t(y0Var6.f11504m, y0Var6.f11503l);
                            break;
                        case 4:
                            m0Var.b(y0Var.f11505n);
                            break;
                        case 5:
                            m0Var.I(y0Var.m());
                            break;
                        case 6:
                            m0Var.z(y0Var.f11506o);
                            break;
                        case 7:
                            m0Var.v(y0Var.f11498f);
                            break;
                        case 8:
                            m0Var.B(y0Var.f11498f);
                            break;
                        default:
                            m0Var.c(y0Var.f11500i.f4960d);
                            break;
                    }
                }
            });
        }
        if (z15 || y0Var2.f11504m != y0Var.f11504m) {
            final int i26 = 3;
            this.f11204m.c(5, new l1.m() { // from class: s1.p
                @Override // l1.m
                public final void invoke(Object obj82) {
                    i1.m0 m0Var = (i1.m0) obj82;
                    switch (i26) {
                        case 0:
                            y0 y0Var4 = y0Var;
                            boolean z18 = y0Var4.g;
                            m0Var.getClass();
                            m0Var.j(y0Var4.g);
                            break;
                        case 1:
                            y0 y0Var5 = y0Var;
                            m0Var.r(y0Var5.f11497e, y0Var5.f11503l);
                            break;
                        case 2:
                            m0Var.A(y0Var.f11497e);
                            break;
                        case 3:
                            y0 y0Var6 = y0Var;
                            m0Var.t(y0Var6.f11504m, y0Var6.f11503l);
                            break;
                        case 4:
                            m0Var.b(y0Var.f11505n);
                            break;
                        case 5:
                            m0Var.I(y0Var.m());
                            break;
                        case 6:
                            m0Var.z(y0Var.f11506o);
                            break;
                        case 7:
                            m0Var.v(y0Var.f11498f);
                            break;
                        case 8:
                            m0Var.B(y0Var.f11498f);
                            break;
                        default:
                            m0Var.c(y0Var.f11500i.f4960d);
                            break;
                    }
                }
            });
        }
        if (y0Var2.f11505n != y0Var.f11505n) {
            final int i27 = 4;
            this.f11204m.c(6, new l1.m() { // from class: s1.p
                @Override // l1.m
                public final void invoke(Object obj82) {
                    i1.m0 m0Var = (i1.m0) obj82;
                    switch (i27) {
                        case 0:
                            y0 y0Var4 = y0Var;
                            boolean z18 = y0Var4.g;
                            m0Var.getClass();
                            m0Var.j(y0Var4.g);
                            break;
                        case 1:
                            y0 y0Var5 = y0Var;
                            m0Var.r(y0Var5.f11497e, y0Var5.f11503l);
                            break;
                        case 2:
                            m0Var.A(y0Var.f11497e);
                            break;
                        case 3:
                            y0 y0Var6 = y0Var;
                            m0Var.t(y0Var6.f11504m, y0Var6.f11503l);
                            break;
                        case 4:
                            m0Var.b(y0Var.f11505n);
                            break;
                        case 5:
                            m0Var.I(y0Var.m());
                            break;
                        case 6:
                            m0Var.z(y0Var.f11506o);
                            break;
                        case 7:
                            m0Var.v(y0Var.f11498f);
                            break;
                        case 8:
                            m0Var.B(y0Var.f11498f);
                            break;
                        default:
                            m0Var.c(y0Var.f11500i.f4960d);
                            break;
                    }
                }
            });
        }
        if (y0Var2.m() != y0Var.m()) {
            final int i28 = 5;
            this.f11204m.c(7, new l1.m() { // from class: s1.p
                @Override // l1.m
                public final void invoke(Object obj82) {
                    i1.m0 m0Var = (i1.m0) obj82;
                    switch (i28) {
                        case 0:
                            y0 y0Var4 = y0Var;
                            boolean z18 = y0Var4.g;
                            m0Var.getClass();
                            m0Var.j(y0Var4.g);
                            break;
                        case 1:
                            y0 y0Var5 = y0Var;
                            m0Var.r(y0Var5.f11497e, y0Var5.f11503l);
                            break;
                        case 2:
                            m0Var.A(y0Var.f11497e);
                            break;
                        case 3:
                            y0 y0Var6 = y0Var;
                            m0Var.t(y0Var6.f11504m, y0Var6.f11503l);
                            break;
                        case 4:
                            m0Var.b(y0Var.f11505n);
                            break;
                        case 5:
                            m0Var.I(y0Var.m());
                            break;
                        case 6:
                            m0Var.z(y0Var.f11506o);
                            break;
                        case 7:
                            m0Var.v(y0Var.f11498f);
                            break;
                        case 8:
                            m0Var.B(y0Var.f11498f);
                            break;
                        default:
                            m0Var.c(y0Var.f11500i.f4960d);
                            break;
                    }
                }
            });
        }
        if (!y0Var2.f11506o.equals(y0Var.f11506o)) {
            final int i29 = 6;
            this.f11204m.c(12, new l1.m() { // from class: s1.p
                @Override // l1.m
                public final void invoke(Object obj82) {
                    i1.m0 m0Var = (i1.m0) obj82;
                    switch (i29) {
                        case 0:
                            y0 y0Var4 = y0Var;
                            boolean z18 = y0Var4.g;
                            m0Var.getClass();
                            m0Var.j(y0Var4.g);
                            break;
                        case 1:
                            y0 y0Var5 = y0Var;
                            m0Var.r(y0Var5.f11497e, y0Var5.f11503l);
                            break;
                        case 2:
                            m0Var.A(y0Var.f11497e);
                            break;
                        case 3:
                            y0 y0Var6 = y0Var;
                            m0Var.t(y0Var6.f11504m, y0Var6.f11503l);
                            break;
                        case 4:
                            m0Var.b(y0Var.f11505n);
                            break;
                        case 5:
                            m0Var.I(y0Var.m());
                            break;
                        case 6:
                            m0Var.z(y0Var.f11506o);
                            break;
                        case 7:
                            m0Var.v(y0Var.f11498f);
                            break;
                        case 8:
                            m0Var.B(y0Var.f11498f);
                            break;
                        default:
                            m0Var.c(y0Var.f11500i.f4960d);
                            break;
                    }
                }
            });
        }
        b0();
        this.f11204m.b();
        if (y0Var2.f11507p != y0Var.f11507p) {
            Iterator it = this.f11206n.iterator();
            while (it.hasNext()) {
                ((x) it.next()).f11482o.e0();
            }
        }
    }

    public final void e0() {
        int F = F();
        k2.j0 j0Var = this.D;
        k2.j0 j0Var2 = this.C;
        boolean z10 = false;
        if (F != 1) {
            if (F == 2 || F == 3) {
                f0();
                boolean z11 = this.f11203l0.f11507p;
                if (E() && !z11) {
                    z10 = true;
                }
                j0Var2.a(z10);
                j0Var.a(E());
                return;
            }
            if (F != 4) {
                throw new IllegalStateException();
            }
        }
        j0Var2.a(false);
        j0Var.a(false);
    }

    public final void f0() {
        this.f11188d.c();
        Thread currentThread = Thread.currentThread();
        Looper looper = this.f11213t;
        if (currentThread != looper.getThread()) {
            String name = Thread.currentThread().getName();
            String name2 = looper.getThread().getName();
            int i10 = l1.a0.f8067a;
            Locale locale = Locale.US;
            String str = "Player is accessed on the wrong thread.\nCurrent thread: '" + name + "'\nExpected thread: '" + name2 + "'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread";
            if (this.f11193f0) {
                throw new IllegalStateException(str);
            }
            l1.b.r("ExoPlayerImpl", str, this.f11194g0 ? null : new IllegalStateException());
            this.f11194g0 = true;
        }
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final boolean isScrubbingModeEnabled() {
        f0();
        return this.L;
    }

    @Override // b0.j
    public final void k(int i10, long j10, boolean z10) {
        f0();
        if (i10 == -1) {
            return;
        }
        l1.d.b(i10 >= 0);
        i1.t0 t0Var = this.f11203l0.f11493a;
        if (t0Var.p() || i10 < t0Var.o()) {
            t1.o oVar = this.f11212s;
            if (!oVar.f11830w) {
                t1.a J = oVar.J();
                oVar.f11830w = true;
                oVar.O(J, -1, new h3.b(24, J));
            }
            this.I++;
            if (I()) {
                l1.b.q("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                b4.u uVar = new b4.u(this.f11203l0);
                uVar.f(1);
                a0 a0Var = this.f11200k.f11449o;
                a0Var.f11198j.c(new androidx.fragment.app.d(a0Var, 18, uVar));
                return;
            }
            y0 y0Var = this.f11203l0;
            int i11 = y0Var.f11497e;
            if (i11 == 3 || (i11 == 4 && !t0Var.p())) {
                y0Var = this.f11203l0.h(2);
            }
            int x6 = x();
            y0 K = K(y0Var, t0Var, L(t0Var, i10, j10));
            this.f11202l.f11343v.a(3, new g0(t0Var, i10, l1.a0.O(j10))).b();
            d0(K, 0, true, 1, z(K), x6, z10);
        }
    }

    public final void q(t1.b bVar) {
        t1.o oVar = this.f11212s;
        oVar.getClass();
        oVar.f11827t.a(bVar);
    }

    public final i1.d0 r() {
        i1.t0 A = A();
        if (A.p()) {
            return this.f11201k0;
        }
        i1.a0 a0Var = A.m(x(), (i1.s0) this.f2162a, 0L).f6023c;
        i1.c0 a10 = this.f11201k0.a();
        i1.d0 d0Var = a0Var.f5795d;
        if (d0Var != null) {
            o9.g0 g0Var = d0Var.A;
            byte[] bArr = d0Var.f5850f;
            CharSequence charSequence = d0Var.f5845a;
            if (charSequence != null) {
                a10.f5817a = charSequence;
            }
            CharSequence charSequence2 = d0Var.f5846b;
            if (charSequence2 != null) {
                a10.f5818b = charSequence2;
            }
            CharSequence charSequence3 = d0Var.f5847c;
            if (charSequence3 != null) {
                a10.f5819c = charSequence3;
            }
            CharSequence charSequence4 = d0Var.f5848d;
            if (charSequence4 != null) {
                a10.f5820d = charSequence4;
            }
            CharSequence charSequence5 = d0Var.f5849e;
            if (charSequence5 != null) {
                a10.f5821e = charSequence5;
            }
            if (bArr != null) {
                Integer num = d0Var.g;
                a10.f5822f = bArr == null ? null : (byte[]) bArr.clone();
                a10.g = num;
            }
            Integer num2 = d0Var.f5851h;
            if (num2 != null) {
                a10.f5823h = num2;
            }
            Integer num3 = d0Var.f5852i;
            if (num3 != null) {
                a10.f5824i = num3;
            }
            Integer num4 = d0Var.f5853j;
            if (num4 != null) {
                a10.f5825j = num4;
            }
            Boolean bool = d0Var.f5854k;
            if (bool != null) {
                a10.f5826k = bool;
            }
            Integer num5 = d0Var.f5855l;
            if (num5 != null) {
                a10.f5827l = num5;
            }
            Integer num6 = d0Var.f5856m;
            if (num6 != null) {
                a10.f5827l = num6;
            }
            Integer num7 = d0Var.f5857n;
            if (num7 != null) {
                a10.f5828m = num7;
            }
            Integer num8 = d0Var.f5858o;
            if (num8 != null) {
                a10.f5829n = num8;
            }
            Integer num9 = d0Var.f5859p;
            if (num9 != null) {
                a10.f5830o = num9;
            }
            Integer num10 = d0Var.f5860q;
            if (num10 != null) {
                a10.f5831p = num10;
            }
            Integer num11 = d0Var.f5861r;
            if (num11 != null) {
                a10.f5832q = num11;
            }
            CharSequence charSequence6 = d0Var.f5862s;
            if (charSequence6 != null) {
                a10.f5833r = charSequence6;
            }
            CharSequence charSequence7 = d0Var.f5863t;
            if (charSequence7 != null) {
                a10.f5834s = charSequence7;
            }
            CharSequence charSequence8 = d0Var.f5864u;
            if (charSequence8 != null) {
                a10.f5835t = charSequence8;
            }
            Integer num12 = d0Var.f5865v;
            if (num12 != null) {
                a10.f5836u = num12;
            }
            Integer num13 = d0Var.f5866w;
            if (num13 != null) {
                a10.f5837v = num13;
            }
            CharSequence charSequence9 = d0Var.f5867x;
            if (charSequence9 != null) {
                a10.f5838w = charSequence9;
            }
            CharSequence charSequence10 = d0Var.f5868y;
            if (charSequence10 != null) {
                a10.f5839x = charSequence10;
            }
            Integer num14 = d0Var.f5869z;
            if (num14 != null) {
                a10.f5840y = num14;
            }
            if (!g0Var.isEmpty()) {
                a10.f5841z = o9.g0.n(g0Var);
            }
        }
        return new i1.d0(a10);
    }

    public final void s() {
        f0();
        Q();
        X(null);
        M(0, 0);
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void setImageOutput(ImageOutput imageOutput) {
        f0();
        R(4, 15, imageOutput);
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void setScrubbingModeEnabled(boolean z10) {
        i1.z0 z0Var;
        f0();
        if (z10 == this.L) {
            return;
        }
        this.L = z10;
        e1 e1Var = this.N;
        if (!e1Var.f11280a.isEmpty()) {
            f2.w wVar = this.f11196i;
            wVar.getClass();
            f2.k e7 = ((f2.r) wVar).e();
            if (z10) {
                this.M = e7.E;
                o9.j0 j0Var = e1Var.f11280a;
                i1.y0 a10 = e7.a();
                k1 it = j0Var.iterator();
                while (it.hasNext()) {
                    a10.j(((Integer) it.next()).intValue(), true);
                }
                z0Var = a10.a();
            } else {
                e7.getClass();
                f2.j jVar = new f2.j(e7);
                jVar.k(this.M);
                f2.k kVar = new f2.k(jVar);
                this.M = null;
                z0Var = kVar;
            }
            if (!z0Var.equals(e7)) {
                wVar.b(z0Var);
            }
        }
        this.f11202l.f11343v.a(36, Boolean.valueOf(z10)).b();
        y0 y0Var = this.f11203l0;
        c0(y0Var.f11504m, y0Var.f11503l);
    }

    public final b1 t(a1 a1Var) {
        int C = C(this.f11203l0);
        i1.t0 t0Var = this.f11203l0.f11493a;
        if (C == -1) {
            C = 0;
        }
        h0 h0Var = this.f11202l;
        return new b1(h0Var, a1Var, t0Var, C, h0Var.f11345x);
    }

    public final long u(y0 y0Var) {
        c2.d0 d0Var = y0Var.f11494b;
        long j10 = y0Var.f11495c;
        i1.t0 t0Var = y0Var.f11493a;
        if (!d0Var.b()) {
            return l1.a0.Z(z(y0Var));
        }
        Object obj = y0Var.f11494b.f2539a;
        i1.r0 r0Var = this.f11208o;
        t0Var.g(obj, r0Var);
        if (j10 == -9223372036854775807L) {
            return l1.a0.Z(t0Var.m(C(y0Var), (i1.s0) this.f2162a, 0L).f6031l);
        }
        return l1.a0.Z(j10) + l1.a0.Z(r0Var.f6016e);
    }

    public final int v() {
        f0();
        if (I()) {
            return this.f11203l0.f11494b.f2540b;
        }
        return -1;
    }

    public final int w() {
        f0();
        if (I()) {
            return this.f11203l0.f11494b.f2541c;
        }
        return -1;
    }

    public final int x() {
        f0();
        int C = C(this.f11203l0);
        if (C == -1) {
            return 0;
        }
        return C;
    }

    public final long y() {
        f0();
        return l1.a0.Z(z(this.f11203l0));
    }

    public final long z(y0 y0Var) {
        if (y0Var.f11493a.p()) {
            return l1.a0.O(this.f11207n0);
        }
        long l10 = y0Var.f11507p ? y0Var.l() : y0Var.f11510s;
        if (y0Var.f11494b.b()) {
            return l10;
        }
        i1.t0 t0Var = y0Var.f11493a;
        Object obj = y0Var.f11494b.f2539a;
        i1.r0 r0Var = this.f11208o;
        t0Var.g(obj, r0Var);
        return l10 + r0Var.f6016e;
    }
}
