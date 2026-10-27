package c2;

import android.util.SparseArray;
import java.io.EOFException;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class d1 implements k2.g0 {
    public i1.p A;
    public i1.p B;
    public long C;
    public boolean E;
    public long F;
    public boolean G;

    /* renamed from: a, reason: collision with root package name */
    public final z0 f2544a;

    /* renamed from: d, reason: collision with root package name */
    public final v1.f f2547d;

    /* renamed from: e, reason: collision with root package name */
    public final j0 f2548e;

    /* renamed from: f, reason: collision with root package name */
    public Object f2549f;
    public i1.p g;

    /* renamed from: h, reason: collision with root package name */
    public p4.p f2550h;

    /* renamed from: p, reason: collision with root package name */
    public int f2558p;

    /* renamed from: q, reason: collision with root package name */
    public int f2559q;

    /* renamed from: r, reason: collision with root package name */
    public int f2560r;

    /* renamed from: s, reason: collision with root package name */
    public int f2561s;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2565w;

    /* renamed from: z, reason: collision with root package name */
    public boolean f2568z;

    /* renamed from: b, reason: collision with root package name */
    public final a1 f2545b = new a1();

    /* renamed from: i, reason: collision with root package name */
    public int f2551i = 1000;

    /* renamed from: j, reason: collision with root package name */
    public long[] f2552j = new long[1000];

    /* renamed from: k, reason: collision with root package name */
    public long[] f2553k = new long[1000];

    /* renamed from: n, reason: collision with root package name */
    public long[] f2556n = new long[1000];

    /* renamed from: m, reason: collision with root package name */
    public int[] f2555m = new int[1000];

    /* renamed from: l, reason: collision with root package name */
    public int[] f2554l = new int[1000];

    /* renamed from: o, reason: collision with root package name */
    public k2.f0[] f2557o = new k2.f0[1000];

    /* renamed from: c, reason: collision with root package name */
    public final j1 f2546c = new j1(new a6.a0(8));

    /* renamed from: t, reason: collision with root package name */
    public long f2562t = Long.MIN_VALUE;

    /* renamed from: u, reason: collision with root package name */
    public long f2563u = Long.MIN_VALUE;

    /* renamed from: v, reason: collision with root package name */
    public long f2564v = Long.MIN_VALUE;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2567y = true;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2566x = true;
    public boolean D = true;

    public d1(g2.e eVar, v1.f fVar, j0 j0Var) {
        this.f2547d = fVar;
        this.f2548e = j0Var;
        this.f2544a = new z0(eVar);
    }

    public final synchronized void A() {
        this.f2561s = 0;
        z0 z0Var = this.f2544a;
        z0Var.f2786e = z0Var.f2785d;
    }

    public final synchronized boolean B(int i10) {
        A();
        int i11 = this.f2559q;
        if (i10 >= i11 && i10 <= this.f2558p + i11) {
            this.f2562t = Long.MIN_VALUE;
            this.f2561s = i10 - i11;
            return true;
        }
        return false;
    }

    public final synchronized boolean C(long j10, boolean z10) {
        Throwable th;
        d1 d1Var;
        long j11;
        int l10;
        try {
            try {
                A();
                int r2 = r(this.f2561s);
                int i10 = this.f2561s;
                int i11 = this.f2558p;
                if (!(i10 != i11) || j10 < this.f2556n[r2] || (j10 > this.f2564v && !z10)) {
                    return false;
                }
                if (this.D) {
                    int i12 = i11 - i10;
                    int i13 = 0;
                    while (true) {
                        if (i13 < i12) {
                            try {
                                if (this.f2556n[r2] >= j10) {
                                    i12 = i13;
                                    break;
                                }
                                r2++;
                                if (r2 == this.f2551i) {
                                    r2 = 0;
                                }
                                i13++;
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        } else if (!z10) {
                            i12 = -1;
                        }
                    }
                    j11 = j10;
                    l10 = i12;
                    d1Var = this;
                } else {
                    int i14 = i11 - i10;
                    d1Var = this;
                    j11 = j10;
                    l10 = d1Var.l(true, r2, i14, j11);
                }
                if (l10 == -1) {
                    return false;
                }
                d1Var.f2562t = j11;
                d1Var.f2561s += l10;
                return true;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final synchronized void D(int i10) {
        boolean z10;
        if (i10 >= 0) {
            try {
                if (this.f2561s + i10 <= this.f2558p) {
                    z10 = true;
                    l1.d.b(z10);
                    this.f2561s += i10;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z10 = false;
        l1.d.b(z10);
        this.f2561s += i10;
    }

    /* JADX WARN: Type inference failed for: r5v26, types: [c2.c1, java.lang.Object] */
    @Override // k2.g0
    public final void a(i1.p pVar) {
        i1.p m10 = m(pVar);
        boolean z10 = false;
        this.f2568z = false;
        this.A = pVar;
        synchronized (this) {
            try {
                this.f2567y = false;
                if (!Objects.equals(m10, this.B)) {
                    if (!(((SparseArray) this.f2546c.f2626q).size() == 0)) {
                        SparseArray sparseArray = (SparseArray) this.f2546c.f2626q;
                        if (((b1) sparseArray.valueAt(sparseArray.size() - 1)).f2527a.equals(m10)) {
                            SparseArray sparseArray2 = (SparseArray) this.f2546c.f2626q;
                            this.B = ((b1) sparseArray2.valueAt(sparseArray2.size() - 1)).f2527a;
                            boolean z11 = this.D;
                            i1.p pVar2 = this.B;
                            this.D = z11 & i1.g0.a(pVar2.f5991n, pVar2.f5988k);
                            this.E = false;
                            z10 = true;
                        }
                    }
                    this.B = m10;
                    boolean z112 = this.D;
                    i1.p pVar22 = this.B;
                    this.D = z112 & i1.g0.a(pVar22.f5991n, pVar22.f5988k);
                    this.E = false;
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ?? r52 = this.f2549f;
        if (r52 == 0 || !z10) {
            return;
        }
        r52.o();
    }

    @Override // k2.g0
    public final int b(i1.h hVar, int i10, boolean z10) {
        z0 z0Var = this.f2544a;
        int c10 = z0Var.c(i10);
        y0 y0Var = z0Var.f2787f;
        g2.a aVar = (g2.a) y0Var.f2774q;
        int read = hVar.read(aVar.f5077a, ((int) (z0Var.g - y0Var.f2772o)) + aVar.f5078b, c10);
        if (read == -1) {
            if (z10) {
                return -1;
            }
            throw new EOFException();
        }
        long j10 = z0Var.g + read;
        z0Var.g = j10;
        y0 y0Var2 = z0Var.f2787f;
        if (j10 == y0Var2.f2773p) {
            z0Var.f2787f = (y0) y0Var2.f2775r;
        }
        return read;
    }

    @Override // k2.g0
    public final void c(int i10, l1.t tVar) {
        d(tVar, i10, 0);
    }

    @Override // k2.g0
    public final void d(l1.t tVar, int i10, int i11) {
        while (true) {
            z0 z0Var = this.f2544a;
            if (i10 <= 0) {
                z0Var.getClass();
                return;
            }
            int c10 = z0Var.c(i10);
            y0 y0Var = z0Var.f2787f;
            g2.a aVar = (g2.a) y0Var.f2774q;
            tVar.h(aVar.f5077a, ((int) (z0Var.g - y0Var.f2772o)) + aVar.f5078b, c10);
            i10 -= c10;
            long j10 = z0Var.g + c10;
            z0Var.g = j10;
            y0 y0Var2 = z0Var.f2787f;
            if (j10 == y0Var2.f2773p) {
                z0Var.f2787f = (y0) y0Var2.f2775r;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    @Override // k2.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(long r14, int r16, int r17, int r18, k2.f0 r19) {
        /*
            Method dump skipped, instructions count: 184
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.d1.e(long, int, int, int, k2.f0):void");
    }

    @Override // k2.g0
    public final int f(i1.h hVar, int i10, boolean z10) {
        return b(hVar, i10, z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
    
        if (((c2.b1) r9.valueAt(r9.size() - 1)).f2527a.equals(r8.B) == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void g(long r9, int r11, long r12, int r14, k2.f0 r15) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.d1.g(long, int, long, int, k2.f0):void");
    }

    public final long h(int i10) {
        this.f2563u = Math.max(this.f2563u, p(i10));
        this.f2558p -= i10;
        int i11 = this.f2559q + i10;
        this.f2559q = i11;
        int i12 = this.f2560r + i10;
        this.f2560r = i12;
        int i13 = this.f2551i;
        if (i12 >= i13) {
            this.f2560r = i12 - i13;
        }
        int i14 = this.f2561s - i10;
        this.f2561s = i14;
        int i15 = 0;
        if (i14 < 0) {
            this.f2561s = 0;
        }
        j1 j1Var = this.f2546c;
        SparseArray sparseArray = (SparseArray) j1Var.f2626q;
        while (i15 < sparseArray.size() - 1) {
            int i16 = i15 + 1;
            if (i11 < sparseArray.keyAt(i16)) {
                break;
            }
            ((a6.a0) j1Var.f2627r).accept(sparseArray.valueAt(i15));
            sparseArray.removeAt(i15);
            int i17 = j1Var.f2625p;
            if (i17 > 0) {
                j1Var.f2625p = i17 - 1;
            }
            i15 = i16;
        }
        if (this.f2558p != 0) {
            return this.f2553k[this.f2560r];
        }
        int i18 = this.f2560r;
        if (i18 == 0) {
            i18 = this.f2551i;
        }
        return this.f2553k[i18 - 1] + this.f2554l[r7];
    }

    public final void i(long j10, boolean z10) {
        Throwable th;
        z0 z0Var = this.f2544a;
        synchronized (this) {
            try {
                try {
                    int i10 = this.f2558p;
                    long j11 = -1;
                    if (i10 != 0) {
                        long[] jArr = this.f2556n;
                        int i11 = this.f2560r;
                        if (j10 >= jArr[i11]) {
                            if (z10) {
                                try {
                                    int i12 = this.f2561s;
                                    if (i12 != i10) {
                                        i10 = i12 + 1;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                            int l10 = l(false, i11, i10, j10);
                            if (l10 != -1) {
                                j11 = h(l10);
                            }
                            z0Var.b(j11);
                        }
                    }
                    z0Var.b(j11);
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    public final void j() {
        long h10;
        z0 z0Var = this.f2544a;
        synchronized (this) {
            int i10 = this.f2558p;
            h10 = i10 == 0 ? -1L : h(i10);
        }
        z0Var.b(h10);
    }

    public final long k(int i10) {
        int i11 = this.f2559q;
        int i12 = this.f2558p;
        int i13 = (i11 + i12) - i10;
        boolean z10 = false;
        l1.d.b(i13 >= 0 && i13 <= i12 - this.f2561s);
        int i14 = this.f2558p - i13;
        this.f2558p = i14;
        this.f2564v = Math.max(this.f2563u, p(i14));
        if (i13 == 0 && this.f2565w) {
            z10 = true;
        }
        this.f2565w = z10;
        j1 j1Var = this.f2546c;
        SparseArray sparseArray = (SparseArray) j1Var.f2626q;
        for (int size = sparseArray.size() - 1; size >= 0 && i10 < sparseArray.keyAt(size); size--) {
            ((a6.a0) j1Var.f2627r).accept(sparseArray.valueAt(size));
            sparseArray.removeAt(size);
        }
        j1Var.f2625p = sparseArray.size() > 0 ? Math.min(j1Var.f2625p, sparseArray.size() - 1) : -1;
        int i15 = this.f2558p;
        if (i15 == 0) {
            return 0L;
        }
        return this.f2553k[r(i15 - 1)] + this.f2554l[r9];
    }

    public final int l(boolean z10, int i10, int i11, long j10) {
        int i12 = -1;
        for (int i13 = 0; i13 < i11; i13++) {
            long j11 = this.f2556n[i10];
            if (j11 > j10) {
                break;
            }
            if (!z10 || (this.f2555m[i10] & 1) != 0) {
                if (j11 == j10) {
                    return i13;
                }
                i12 = i13;
            }
            i10++;
            if (i10 == this.f2551i) {
                i10 = 0;
            }
        }
        return i12;
    }

    public i1.p m(i1.p pVar) {
        if (this.F == 0 || pVar.f5996s == Long.MAX_VALUE) {
            return pVar;
        }
        i1.o a10 = pVar.a();
        a10.f5945r = pVar.f5996s + this.F;
        return new i1.p(a10);
    }

    public final synchronized long n() {
        return this.f2564v;
    }

    public final synchronized long o() {
        return Math.max(this.f2563u, p(this.f2561s));
    }

    public final long p(int i10) {
        long j10 = Long.MIN_VALUE;
        if (i10 == 0) {
            return Long.MIN_VALUE;
        }
        int r2 = r(i10 - 1);
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = Math.max(j10, this.f2556n[r2]);
            if ((this.f2555m[r2] & 1) != 0) {
                return j10;
            }
            r2--;
            if (r2 == -1) {
                r2 = this.f2551i - 1;
            }
        }
        return j10;
    }

    public final int q() {
        return this.f2559q + this.f2561s;
    }

    public final int r(int i10) {
        int i11 = this.f2560r + i10;
        int i12 = this.f2551i;
        return i11 < i12 ? i11 : i11 - i12;
    }

    public final synchronized int s(long j10, boolean z10) {
        try {
            try {
                int r2 = r(this.f2561s);
                int i10 = this.f2561s;
                int i11 = this.f2558p;
                if (!(i10 != i11) || j10 < this.f2556n[r2]) {
                    return 0;
                }
                if (j10 > this.f2564v && z10) {
                    return i11 - i10;
                }
                int l10 = l(true, r2, i11 - i10, j10);
                if (l10 == -1) {
                    return 0;
                }
                return l10;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized i1.p t() {
        return this.f2567y ? null : this.B;
    }

    public final synchronized boolean u(boolean z10) {
        i1.p pVar;
        boolean z11 = false;
        if (this.f2561s != this.f2558p) {
            if (((b1) this.f2546c.h(q())).f2527a != this.g) {
                return true;
            }
            return v(r(this.f2561s));
        }
        if (z10 || this.f2565w || ((pVar = this.B) != null && pVar != this.g)) {
            z11 = true;
        }
        return z11;
    }

    public final boolean v(int i10) {
        p4.p pVar = this.f2550h;
        if (pVar == null || pVar.h() == 4) {
            return true;
        }
        if ((this.f2555m[i10] & 1073741824) != 0) {
            return false;
        }
        this.f2550h.getClass();
        return false;
    }

    public final void w(i1.p pVar, x4.e eVar) {
        i1.p pVar2;
        i1.p pVar3 = this.g;
        boolean z10 = pVar3 == null;
        i1.l lVar = pVar3 == null ? null : pVar3.f5995r;
        this.g = pVar;
        i1.l lVar2 = pVar.f5995r;
        v1.f fVar = this.f2547d;
        if (fVar != null) {
            int w10 = fVar.w(pVar);
            i1.o a10 = pVar.a();
            a10.N = w10;
            pVar2 = new i1.p(a10);
        } else {
            pVar2 = pVar;
        }
        eVar.f13543q = pVar2;
        eVar.f13542p = this.f2550h;
        if (fVar == null) {
            return;
        }
        if (z10 || !Objects.equals(lVar, lVar2)) {
            p4.p pVar4 = this.f2550h;
            j0 j0Var = this.f2548e;
            p4.p A = fVar.A(j0Var, pVar);
            this.f2550h = A;
            eVar.f13542p = A;
            if (pVar4 != null) {
                pVar4.m(j0Var);
            }
        }
    }

    public final synchronized long x() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return this.f2561s != this.f2558p ? this.f2552j[r(this.f2561s)] : this.C;
    }

    public final int y(x4.e eVar, r1.e eVar2, int i10, boolean z10) {
        int i11;
        boolean z11 = (i10 & 2) != 0;
        a1 a1Var = this.f2545b;
        synchronized (this) {
            try {
                eVar2.f10411t = false;
                i11 = -3;
                if (this.f2561s != this.f2558p) {
                    i1.p pVar = ((b1) this.f2546c.h(q())).f2527a;
                    if (!z11 && pVar == this.g) {
                        int r2 = r(this.f2561s);
                        if (v(r2)) {
                            eVar2.f8759p = this.f2555m[r2];
                            if (this.f2561s == this.f2558p - 1 && (z10 || this.f2565w)) {
                                eVar2.b(536870912);
                            }
                            eVar2.f10412u = this.f2556n[r2];
                            a1Var.f2524a = this.f2554l[r2];
                            a1Var.f2525b = this.f2553k[r2];
                            a1Var.f2526c = this.f2557o[r2];
                            i11 = -4;
                        } else {
                            eVar2.f10411t = true;
                        }
                    }
                    w(pVar, eVar);
                    i11 = -5;
                } else {
                    if (!z10 && !this.f2565w) {
                        i1.p pVar2 = this.B;
                        if (pVar2 == null || (!z11 && pVar2 == this.g)) {
                        }
                        w(pVar2, eVar);
                        i11 = -5;
                    }
                    eVar2.f8759p = 4;
                    eVar2.f10412u = Long.MIN_VALUE;
                    i11 = -4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i11 == -4 && !eVar2.d(4)) {
            boolean z12 = (i10 & 1) != 0;
            if ((i10 & 4) == 0) {
                if (z12) {
                    z0 z0Var = this.f2544a;
                    z0.f(z0Var.f2786e, eVar2, this.f2545b, z0Var.f2784c);
                } else {
                    z0 z0Var2 = this.f2544a;
                    z0Var2.f2786e = z0.f(z0Var2.f2786e, eVar2, this.f2545b, z0Var2.f2784c);
                }
            }
            if (!z12) {
                this.f2561s++;
            }
        }
        return i11;
    }

    public final void z(boolean z10) {
        z0 z0Var = this.f2544a;
        z0Var.a(z0Var.f2785d);
        y0 y0Var = z0Var.f2785d;
        int i10 = z0Var.f2783b;
        l1.d.g(((g2.a) y0Var.f2774q) == null);
        y0Var.f2772o = 0L;
        y0Var.f2773p = i10;
        y0 y0Var2 = z0Var.f2785d;
        z0Var.f2786e = y0Var2;
        z0Var.f2787f = y0Var2;
        z0Var.g = 0L;
        z0Var.f2782a.b();
        this.f2558p = 0;
        this.f2559q = 0;
        this.f2560r = 0;
        this.f2561s = 0;
        this.f2566x = true;
        this.f2562t = Long.MIN_VALUE;
        this.f2563u = Long.MIN_VALUE;
        this.f2564v = Long.MIN_VALUE;
        this.f2565w = false;
        j1 j1Var = this.f2546c;
        SparseArray sparseArray = (SparseArray) j1Var.f2626q;
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            ((a6.a0) j1Var.f2627r).accept(sparseArray.valueAt(i11));
        }
        j1Var.f2625p = -1;
        sparseArray.clear();
        if (z10) {
            this.A = null;
            this.B = null;
            this.f2567y = true;
            this.D = true;
        }
    }
}
