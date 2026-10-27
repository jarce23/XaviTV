package w1;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import c2.c1;
import c2.d0;
import c2.g1;
import c2.j0;
import c2.n1;
import c2.y0;
import c2.z;
import c2.z0;
import i1.f0;
import i1.g0;
import i1.u0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import l1.a0;
import o1.x;
import s1.k0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r implements g2.i, g2.l, g1, k2.p, c1 {

    /* renamed from: m0, reason: collision with root package name */
    public static final Set f12845m0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    public final com.bumptech.glide.manager.t A;
    public final ArrayList B;
    public final List C;
    public final n D;
    public final n E;
    public final Handler F;
    public final ArrayList G;
    public final Map H;
    public d2.a I;
    public q[] J;
    public int[] K;
    public final HashSet L;
    public final SparseIntArray M;
    public p N;
    public int O;
    public int P;
    public boolean Q;
    public boolean R;
    public int S;
    public i1.p T;
    public i1.p U;
    public boolean V;
    public n1 W;
    public Set X;
    public int[] Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f12846a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean[] f12847b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean[] f12848c0;

    /* renamed from: d0, reason: collision with root package name */
    public long f12849d0;

    /* renamed from: e0, reason: collision with root package name */
    public long f12850e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f12851f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f12852g0;
    public boolean h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f12853i0;

    /* renamed from: j0, reason: collision with root package name */
    public long f12854j0;

    /* renamed from: k0, reason: collision with root package name */
    public i1.l f12855k0;

    /* renamed from: l0, reason: collision with root package name */
    public j f12856l0;

    /* renamed from: o, reason: collision with root package name */
    public final String f12857o;

    /* renamed from: p, reason: collision with root package name */
    public final int f12858p;

    /* renamed from: q, reason: collision with root package name */
    public final p4.p f12859q;

    /* renamed from: r, reason: collision with root package name */
    public final i f12860r;

    /* renamed from: s, reason: collision with root package name */
    public final g2.e f12861s;

    /* renamed from: t, reason: collision with root package name */
    public final i1.p f12862t;

    /* renamed from: u, reason: collision with root package name */
    public final v1.f f12863u;

    /* renamed from: v, reason: collision with root package name */
    public final j0 f12864v;

    /* renamed from: w, reason: collision with root package name */
    public final n7.i f12865w;

    /* renamed from: x, reason: collision with root package name */
    public final g2.n f12866x = new g2.n("Loader:HlsSampleStreamWrapper");

    /* renamed from: y, reason: collision with root package name */
    public final j0 f12867y;

    /* renamed from: z, reason: collision with root package name */
    public final int f12868z;

    /* JADX WARN: Type inference failed for: r1v12, types: [w1.n] */
    /* JADX WARN: Type inference failed for: r1v13, types: [w1.n] */
    public r(String str, int i10, p4.p pVar, i iVar, Map map, g2.e eVar, long j10, i1.p pVar2, v1.f fVar, j0 j0Var, n7.i iVar2, j0 j0Var2, int i11) {
        this.f12857o = str;
        this.f12858p = i10;
        this.f12859q = pVar;
        this.f12860r = iVar;
        this.H = map;
        this.f12861s = eVar;
        this.f12862t = pVar2;
        this.f12863u = fVar;
        this.f12864v = j0Var;
        this.f12865w = iVar2;
        this.f12867y = j0Var2;
        this.f12868z = i11;
        com.bumptech.glide.manager.t tVar = new com.bumptech.glide.manager.t(5);
        tVar.f3098c = null;
        final int i12 = 0;
        tVar.f3097b = false;
        tVar.f3099d = null;
        this.A = tVar;
        this.K = new int[0];
        Set set = f12845m0;
        this.L = new HashSet(set.size());
        this.M = new SparseIntArray(set.size());
        this.J = new q[0];
        this.f12848c0 = new boolean[0];
        this.f12847b0 = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.B = arrayList;
        this.C = Collections.unmodifiableList(arrayList);
        this.G = new ArrayList();
        this.D = new Runnable(this) { // from class: w1.n

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ r f12836p;

            {
                this.f12836p = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i12) {
                    case 0:
                        this.f12836p.F();
                        break;
                    default:
                        r rVar = this.f12836p;
                        rVar.Q = true;
                        rVar.F();
                        break;
                }
            }
        };
        final int i13 = 1;
        this.E = new Runnable(this) { // from class: w1.n

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ r f12836p;

            {
                this.f12836p = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i13) {
                    case 0:
                        this.f12836p.F();
                        break;
                    default:
                        r rVar = this.f12836p;
                        rVar.Q = true;
                        rVar.F();
                        break;
                }
            }
        };
        this.F = a0.n(null);
        this.f12849d0 = j10;
        this.f12850e0 = j10;
    }

    public static i1.p A(i1.p pVar, i1.p pVar2, boolean z10) {
        String b2;
        if (pVar == null) {
            return pVar2;
        }
        String str = pVar.f5988k;
        String str2 = pVar2.f5991n;
        int h10 = g0.h(str2);
        if (a0.t(h10, str) == 1) {
            b2 = a0.u(h10, str);
            str2 = g0.d(b2);
        } else {
            b2 = g0.b(str, str2);
        }
        i1.o a10 = pVar2.a();
        a10.f5929a = pVar.f5979a;
        a10.f5930b = pVar.f5980b;
        a10.f5931c = o9.g0.n(pVar.f5981c);
        a10.f5932d = pVar.f5982d;
        a10.f5933e = pVar.f5983e;
        a10.f5934f = pVar.f5984f;
        a10.f5935h = z10 ? pVar.f5985h : -1;
        a10.f5936i = z10 ? pVar.f5986i : -1;
        a10.f5937j = b2;
        if (h10 == 2) {
            a10.f5947t = pVar.f5998u;
            a10.f5948u = pVar.f5999v;
            a10.f5951x = pVar.f6002y;
        }
        if (str2 != null) {
            a10.f5940m = g0.m(str2);
        }
        int i10 = pVar.F;
        if (i10 != -1 && h10 == 1) {
            a10.E = i10;
        }
        f0 f0Var = pVar.f5989l;
        if (f0Var != null) {
            f0 f0Var2 = pVar2.f5989l;
            if (f0Var2 != null) {
                f0Var = f0Var2.b(f0Var);
            }
            a10.f5938k = f0Var;
        }
        return new i1.p(a10);
    }

    public static int D(int i10) {
        if (i10 == 1) {
            return 2;
        }
        if (i10 != 2) {
            return i10 != 3 ? 0 : 1;
        }
        return 3;
    }

    public static k2.m y(int i10, int i11) {
        l1.b.q("HlsSampleStreamWrapper", "Unmapped track with id " + i10 + " of type " + i11);
        return new k2.m();
    }

    public final void B(int i10) {
        ArrayList arrayList;
        boolean z10 = true;
        l1.d.g(!this.f12866x.b());
        int i11 = i10;
        while (true) {
            arrayList = this.B;
            if (i11 >= arrayList.size()) {
                i11 = -1;
                break;
            } else if (x(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 == -1) {
            return;
        }
        long j10 = C().f4002h;
        j jVar = (j) arrayList.get(i11);
        int size = arrayList.size();
        int i12 = a0.f8067a;
        if (i11 < 0 || size > arrayList.size() || i11 > size) {
            throw new IllegalArgumentException();
        }
        if (i11 != size) {
            arrayList.subList(i11, size).clear();
        }
        int i13 = 0;
        while (i13 < this.J.length) {
            int e7 = jVar.e(i13);
            q qVar = this.J[i13];
            z0 z0Var = qVar.f2544a;
            long k10 = qVar.k(e7);
            int i14 = z0Var.f2783b;
            l1.d.b(k10 <= z0Var.g ? z10 : false);
            z0Var.g = k10;
            if (k10 != 0) {
                y0 y0Var = z0Var.f2785d;
                if (k10 != y0Var.f2772o) {
                    while (z0Var.g > y0Var.f2773p) {
                        y0Var = (y0) y0Var.f2775r;
                    }
                    y0 y0Var2 = (y0) y0Var.f2775r;
                    y0Var2.getClass();
                    z0Var.a(y0Var2);
                    y0 y0Var3 = new y0(i14, y0Var.f2773p);
                    y0Var.f2775r = y0Var3;
                    if (z0Var.g == y0Var.f2773p) {
                        y0Var = y0Var3;
                    }
                    z0Var.f2787f = y0Var;
                    if (z0Var.f2786e == y0Var2) {
                        z0Var.f2786e = y0Var3;
                    }
                    i13++;
                    z10 = true;
                }
            }
            z0Var.a(z0Var.f2785d);
            y0 y0Var4 = new y0(i14, z0Var.g);
            z0Var.f2785d = y0Var4;
            z0Var.f2786e = y0Var4;
            z0Var.f2787f = y0Var4;
            i13++;
            z10 = true;
        }
        if (arrayList.isEmpty()) {
            this.f12850e0 = this.f12849d0;
        } else {
            ((j) o9.q.g(arrayList)).J = true;
        }
        this.h0 = false;
        z zVar = new z(1, this.O, null, 3, null, a0.Z(jVar.g), a0.Z(j10));
        j0 j0Var = this.f12867y;
        d0 d0Var = j0Var.f2622b;
        d0Var.getClass();
        j0Var.a(new a7.f(j0Var, d0Var, zVar, 3));
    }

    public final j C() {
        return (j) this.B.get(r0.size() - 1);
    }

    public final boolean E() {
        return this.f12850e0 != -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F() {
        int i10;
        if (!this.V && this.Y == null && this.Q) {
            int i11 = 0;
            for (q qVar : this.J) {
                if (qVar.t() == null) {
                    return;
                }
            }
            n1 n1Var = this.W;
            if (n1Var != null) {
                int i12 = n1Var.f2660a;
                int[] iArr = new int[i12];
                this.Y = iArr;
                Arrays.fill(iArr, -1);
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = 0;
                    while (true) {
                        q[] qVarArr = this.J;
                        if (i14 < qVarArr.length) {
                            i1.p t3 = qVarArr[i14].t();
                            l1.d.h(t3);
                            i1.p pVar = this.W.a(i13).f6042d[0];
                            String str = t3.f5991n;
                            String str2 = pVar.f5991n;
                            int h10 = g0.h(str);
                            if (h10 == 3) {
                                if (Objects.equals(str, str2)) {
                                    if ((!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) || t3.K == pVar.K) {
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                                i14++;
                            } else if (h10 == g0.h(str2)) {
                                break;
                            } else {
                                i14++;
                            }
                        }
                    }
                    this.Y[i13] = i14;
                }
                ArrayList arrayList = this.G;
                int size = arrayList.size();
                while (i11 < size) {
                    Object obj = arrayList.get(i11);
                    i11++;
                    ((m) obj).a();
                }
                return;
            }
            int length = this.J.length;
            int i15 = 0;
            int i16 = -1;
            int i17 = -2;
            while (true) {
                int i18 = 1;
                if (i15 >= length) {
                    break;
                }
                i1.p t8 = this.J[i15].t();
                l1.d.h(t8);
                String str3 = t8.f5991n;
                if (g0.l(str3)) {
                    i18 = 2;
                } else if (!g0.i(str3)) {
                    i18 = g0.k(str3) ? 3 : -2;
                }
                if (D(i18) > D(i17)) {
                    i16 = i15;
                    i17 = i18;
                } else if (i18 == i17 && i16 != -1) {
                    i16 = -1;
                }
                i15++;
            }
            u0 u0Var = this.f12860r.f12780h;
            int i19 = u0Var.f6039a;
            this.Z = -1;
            this.Y = new int[length];
            for (int i20 = 0; i20 < length; i20++) {
                this.Y[i20] = i20;
            }
            u0[] u0VarArr = new u0[length];
            int i21 = 0;
            while (i21 < length) {
                i1.p t10 = this.J[i21].t();
                l1.d.h(t10);
                String str4 = this.f12857o;
                i1.p pVar2 = this.f12862t;
                if (i21 == i16) {
                    i1.p[] pVarArr = new i1.p[i19];
                    for (int i22 = i11; i22 < i19; i22++) {
                        i1.p pVar3 = u0Var.f6042d[i22];
                        if (i17 == 1 && pVar2 != null) {
                            pVar3 = pVar3.d(pVar2);
                        }
                        pVarArr[i22] = i19 == 1 ? t10.d(pVar3) : A(pVar3, t10, true);
                    }
                    u0VarArr[i21] = new u0(str4, pVarArr);
                    this.Z = i21;
                    i10 = 0;
                } else {
                    if (i17 != 2 || !g0.i(t10.f5991n)) {
                        pVar2 = null;
                    }
                    StringBuilder a10 = s.e.a(str4, ":muxed:");
                    a10.append(i21 < i16 ? i21 : i21 - 1);
                    i10 = 0;
                    u0VarArr[i21] = new u0(a10.toString(), A(pVar2, t10, false));
                }
                i21++;
                i11 = i10;
            }
            int i23 = i11;
            this.W = z(u0VarArr);
            l1.d.g(this.X == null ? 1 : i23);
            this.X = Collections.EMPTY_SET;
            this.R = true;
            this.f12859q.k();
        }
    }

    public final void G() {
        g2.n nVar = this.f12866x;
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
        i iVar = this.f12860r;
        c2.b bVar = iVar.f12786n;
        if (bVar != null) {
            throw bVar;
        }
        Uri uri = iVar.f12787o;
        if (uri == null || !uri.equals(iVar.f12788p)) {
            return;
        }
        x1.c cVar = iVar.g;
        x1.b bVar2 = (x1.b) cVar.f13346r.get(iVar.f12787o);
        g2.n nVar2 = bVar2.f13332p;
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
        IOException iOException5 = bVar2.f13340x;
        if (iOException5 != null) {
            throw iOException5;
        }
    }

    public final void H(u0[] u0VarArr, int... iArr) {
        this.W = z(u0VarArr);
        this.X = new HashSet();
        for (int i10 : iArr) {
            this.X.add(this.W.a(i10));
        }
        this.Z = 0;
        this.F.post(new o(0, this.f12859q));
        this.R = true;
    }

    public final void I() {
        for (q qVar : this.J) {
            qVar.z(this.f12851f0);
        }
        this.f12851f0 = false;
    }

    public final boolean J(long j10, boolean z10) {
        j jVar;
        boolean z11;
        boolean C;
        this.f12849d0 = j10;
        if (E()) {
            this.f12850e0 = j10;
            return true;
        }
        boolean z12 = this.f12860r.f12789q;
        ArrayList arrayList = this.B;
        if (z12) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                jVar = (j) arrayList.get(i10);
                if (jVar.g == j10) {
                    break;
                }
            }
        }
        jVar = null;
        if (this.Q && !z10 && !arrayList.isEmpty()) {
            int length = this.J.length;
            for (int i11 = 0; i11 < length; i11++) {
                q qVar = this.J[i11];
                if (jVar != null) {
                    C = qVar.B(jVar.e(i11));
                } else {
                    long e7 = e();
                    C = qVar.C(j10, e7 == Long.MIN_VALUE || j10 < e7);
                }
                if (!C && (this.f12848c0[i11] || !this.f12846a0)) {
                    z11 = false;
                    break;
                }
            }
            z11 = true;
            if (z11) {
                return false;
            }
        }
        this.f12850e0 = j10;
        this.h0 = false;
        arrayList.clear();
        g2.n nVar = this.f12866x;
        if (!nVar.b()) {
            nVar.f5132c = null;
            I();
            return true;
        }
        if (this.Q) {
            for (q qVar2 : this.J) {
                qVar2.j();
            }
        }
        nVar.a();
        return true;
    }

    @Override // c2.g1
    public final boolean a() {
        return this.f12866x.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g2.i
    public final void b(g2.k kVar, long j10, long j11) {
        d2.a aVar = (d2.a) kVar;
        this.I = null;
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            byte[] bArr = eVar.f12763j;
            i iVar = this.f12860r;
            iVar.f12785m = bArr;
            p4.p pVar = iVar.f12782j;
            Uri uri = eVar.f3997b.f9428a;
            byte[] bArr2 = eVar.f12765l;
            bArr2.getClass();
            d dVar = (d) pVar.f9953p;
            uri.getClass();
        }
        long j12 = aVar.f3996a;
        Uri uri2 = aVar.f4003i.f9390q;
        c2.u uVar = new c2.u(j11);
        this.f12865w.getClass();
        this.f12867y.c(uVar, aVar.f3998c, this.f12858p, aVar.f3999d, aVar.f4000e, aVar.f4001f, aVar.g, aVar.f4002h);
        if (this.R) {
            this.f12859q.b(this);
            return;
        }
        s1.j0 j0Var = new s1.j0();
        j0Var.f11362a = this.f12849d0;
        s(new k0(j0Var));
    }

    @Override // g2.l
    public final void c() {
        for (q qVar : this.J) {
            qVar.z(true);
            p4.p pVar = qVar.f2550h;
            if (pVar != null) {
                pVar.m(qVar.f2548e);
                qVar.f2550h = null;
                qVar.g = null;
            }
        }
    }

    @Override // g2.i
    public final g2.h d(g2.k kVar, long j10, long j11, IOException iOException, int i10) {
        boolean z10;
        g2.h hVar;
        int i11;
        d2.a aVar = (d2.a) kVar;
        boolean z11 = aVar instanceof j;
        if (z11 && !((j) aVar).f() && (iOException instanceof x) && ((i11 = ((x) iOException).f9462r) == 410 || i11 == 404)) {
            return g2.n.f5127d;
        }
        long j12 = aVar.f4003i.f9389p;
        Uri uri = aVar.f4003i.f9390q;
        c2.u uVar = new c2.u(j11);
        a0.Z(aVar.g);
        a0.Z(aVar.f4002h);
        app.shamel.tv.b bVar = new app.shamel.tv.b(i10, 6, iOException);
        i iVar = this.f12860r;
        b4.j0 i12 = j1.c.i(iVar.f12790r);
        this.f12865w.getClass();
        g2.h B = n7.i.B(i12, bVar);
        if (B == null || B.f5115a != 2) {
            z10 = false;
        } else {
            long j13 = B.f5116b;
            f2.t tVar = iVar.f12790r;
            z10 = tVar.o(tVar.t(iVar.f12780h.a(aVar.f3999d)), j13);
        }
        if (z10) {
            if (z11 && j12 == 0) {
                ArrayList arrayList = this.B;
                l1.d.g(((j) arrayList.remove(arrayList.size() - 1)) == aVar);
                if (arrayList.isEmpty()) {
                    this.f12850e0 = this.f12849d0;
                } else {
                    ((j) o9.q.g(arrayList)).J = true;
                }
            }
            hVar = g2.n.f5128e;
        } else {
            long E = n7.i.E(bVar);
            hVar = E != -9223372036854775807L ? new g2.h(0, E, false) : g2.n.f5129f;
        }
        g2.h hVar2 = hVar;
        int i13 = hVar2.f5115a;
        boolean z12 = i13 == 0 || i13 == 1;
        this.f12867y.d(uVar, aVar.f3998c, this.f12858p, aVar.f3999d, aVar.f4000e, aVar.f4001f, aVar.g, aVar.f4002h, iOException, !z12);
        if (!z12) {
            this.I = null;
        }
        if (z10) {
            if (!this.R) {
                s1.j0 j0Var = new s1.j0();
                j0Var.f11362a = this.f12849d0;
                s(new k0(j0Var));
                return hVar2;
            }
            this.f12859q.b(this);
        }
        return hVar2;
    }

    @Override // c2.g1
    public final long e() {
        if (E()) {
            return this.f12850e0;
        }
        if (this.h0) {
            return Long.MIN_VALUE;
        }
        return C().f4002h;
    }

    @Override // k2.p
    public final void f() {
        this.f12853i0 = true;
        this.F.post(this.E);
    }

    @Override // g2.i
    public final void i(g2.k kVar, long j10, long j11, int i10) {
        c2.u uVar;
        d2.a aVar = (d2.a) kVar;
        if (i10 == 0) {
            long j12 = aVar.f3996a;
            uVar = new c2.u(aVar.f3997b);
        } else {
            long j13 = aVar.f3996a;
            Uri uri = aVar.f4003i.f9390q;
            uVar = new c2.u(j11);
        }
        c2.u uVar2 = uVar;
        this.f12867y.e(uVar2, aVar.f3998c, this.f12858p, aVar.f3999d, aVar.f4000e, aVar.f4001f, aVar.g, aVar.f4002h, i10);
    }

    @Override // c2.g1
    public final long m() {
        if (this.h0) {
            return Long.MIN_VALUE;
        }
        if (E()) {
            return this.f12850e0;
        }
        long j10 = this.f12849d0;
        j C = C();
        if (!C.H) {
            ArrayList arrayList = this.B;
            C = arrayList.size() > 1 ? (j) arrayList.get(arrayList.size() - 2) : null;
        }
        if (C != null) {
            j10 = Math.max(j10, C.f4002h);
        }
        if (this.Q) {
            for (q qVar : this.J) {
                j10 = Math.max(j10, qVar.n());
            }
        }
        return j10;
    }

    @Override // c2.c1
    public final void o() {
        this.F.post(this.D);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [w1.q[]] */
    /* JADX WARN: Type inference failed for: r1v1, types: [w1.q[]] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [k2.g0] */
    /* JADX WARN: Type inference failed for: r5v4, types: [c2.d1, w1.q] */
    /* JADX WARN: Type inference failed for: r5v6, types: [k2.m] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // k2.p
    public final k2.g0 q(int i10, int i11) {
        Integer valueOf = Integer.valueOf(i11);
        Set set = f12845m0;
        boolean contains = set.contains(valueOf);
        HashSet hashSet = this.L;
        SparseIntArray sparseIntArray = this.M;
        ?? r52 = 0;
        r52 = 0;
        if (contains) {
            l1.d.b(set.contains(Integer.valueOf(i11)));
            int i12 = sparseIntArray.get(i11, -1);
            if (i12 != -1) {
                if (hashSet.add(Integer.valueOf(i11))) {
                    this.K[i12] = i10;
                }
                r52 = this.K[i12] == i10 ? this.J[i12] : y(i10, i11);
            }
        } else {
            int i13 = 0;
            while (true) {
                ?? r12 = this.J;
                if (i13 >= r12.length) {
                    break;
                }
                if (this.K[i13] == i10) {
                    r52 = r12[i13];
                    break;
                }
                i13++;
            }
        }
        if (r52 == 0) {
            if (this.f12853i0) {
                return y(i10, i11);
            }
            int length = this.J.length;
            boolean z10 = i11 == 1 || i11 == 2;
            r52 = new q(this.f12861s, this.f12863u, this.f12864v, this.H);
            r52.f2562t = this.f12849d0;
            if (z10) {
                r52.I = this.f12855k0;
                r52.f2568z = true;
            }
            long j10 = this.f12854j0;
            if (r52.F != j10) {
                r52.F = j10;
                r52.f2568z = true;
            }
            if (this.f12856l0 != null) {
                r52.C = r6.f12792k;
            }
            r52.f2549f = this;
            int i14 = length + 1;
            int[] copyOf = Arrays.copyOf(this.K, i14);
            this.K = copyOf;
            copyOf[length] = i10;
            q[] qVarArr = this.J;
            int i15 = a0.f8067a;
            ?? copyOf2 = Arrays.copyOf(qVarArr, qVarArr.length + 1);
            copyOf2[qVarArr.length] = r52;
            this.J = (q[]) copyOf2;
            boolean[] copyOf3 = Arrays.copyOf(this.f12848c0, i14);
            this.f12848c0 = copyOf3;
            copyOf3[length] = z10;
            this.f12846a0 |= z10;
            hashSet.add(Integer.valueOf(i11));
            sparseIntArray.append(i11, length);
            if (D(i11) > D(this.O)) {
                this.P = length;
                this.O = i11;
            }
            this.f12847b0 = Arrays.copyOf(this.f12847b0, i14);
        }
        if (i11 != 5) {
            return r52;
        }
        if (this.N == null) {
            this.N = new p(r52, this.f12868z);
        }
        return this.N;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02d7  */
    @Override // c2.g1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s(s1.k0 r75) {
        /*
            Method dump skipped, instructions count: 1340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.r.s(s1.k0):boolean");
    }

    @Override // g2.i
    public final void u(g2.k kVar, long j10, long j11, boolean z10) {
        d2.a aVar = (d2.a) kVar;
        this.I = null;
        long j12 = aVar.f3996a;
        Uri uri = aVar.f4003i.f9390q;
        c2.u uVar = new c2.u(j11);
        this.f12865w.getClass();
        this.f12867y.b(uVar, aVar.f3998c, this.f12858p, aVar.f3999d, aVar.f4000e, aVar.f4001f, aVar.g, aVar.f4002h);
        if (z10) {
            return;
        }
        if (E() || this.S == 0) {
            I();
        }
        if (this.S > 0) {
            this.f12859q.b(this);
        }
    }

    @Override // c2.g1
    public final void v(long j10) {
        g2.n nVar = this.f12866x;
        if (nVar.f5132c == null && !E()) {
            boolean b2 = nVar.b();
            i iVar = this.f12860r;
            List list = this.C;
            if (b2) {
                this.I.getClass();
                if (iVar.f12786n != null ? false : iVar.f12790r.c(j10, this.I, list)) {
                    nVar.a();
                    return;
                }
                return;
            }
            int size = list.size();
            while (size > 0 && iVar.b((j) list.get(size - 1)) == 2) {
                size--;
            }
            if (size < list.size()) {
                B(size);
            }
            int size2 = (iVar.f12786n != null || iVar.f12790r.length() < 2) ? list.size() : iVar.f12790r.g(j10, list);
            if (size2 < this.B.size()) {
                B(size2);
            }
        }
    }

    public final void w() {
        l1.d.g(this.R);
        this.W.getClass();
        this.X.getClass();
    }

    public final boolean x(int i10) {
        int i11 = i10;
        while (true) {
            ArrayList arrayList = this.B;
            if (i11 >= arrayList.size()) {
                j jVar = (j) arrayList.get(i10);
                for (int i12 = 0; i12 < this.J.length; i12++) {
                    if (this.J[i12].q() > jVar.e(i12)) {
                        return false;
                    }
                }
                return true;
            }
            if (((j) arrayList.get(i11)).L) {
                return false;
            }
            i11++;
        }
    }

    public final n1 z(u0[] u0VarArr) {
        for (int i10 = 0; i10 < u0VarArr.length; i10++) {
            u0 u0Var = u0VarArr[i10];
            i1.p[] pVarArr = new i1.p[u0Var.f6039a];
            for (int i11 = 0; i11 < u0Var.f6039a; i11++) {
                i1.p pVar = u0Var.f6042d[i11];
                int w10 = this.f12863u.w(pVar);
                i1.o a10 = pVar.a();
                a10.N = w10;
                pVarArr[i11] = new i1.p(a10);
            }
            u0VarArr[i10] = new u0(u0Var.f6040b, pVarArr);
        }
        return new n1(u0VarArr);
    }

    @Override // k2.p
    public final void t(k2.a0 a0Var) {
    }
}
