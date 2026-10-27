package r3;

import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements h {

    /* renamed from: a, reason: collision with root package name */
    public final x4.m f10614a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10615b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10616c;
    public long g;

    /* renamed from: i, reason: collision with root package name */
    public String f10621i;

    /* renamed from: j, reason: collision with root package name */
    public g0 f10622j;

    /* renamed from: k, reason: collision with root package name */
    public o f10623k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10624l;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10626n;

    /* renamed from: h, reason: collision with root package name */
    public final boolean[] f10620h = new boolean[3];

    /* renamed from: d, reason: collision with root package name */
    public final b4.u f10617d = new b4.u(7);

    /* renamed from: e, reason: collision with root package name */
    public final b4.u f10618e = new b4.u(8);

    /* renamed from: f, reason: collision with root package name */
    public final b4.u f10619f = new b4.u(6);

    /* renamed from: m, reason: collision with root package name */
    public long f10625m = -9223372036854775807L;

    /* renamed from: o, reason: collision with root package name */
    public final l1.t f10627o = new l1.t();

    public p(x4.m mVar, boolean z10, boolean z11) {
        this.f10614a = mVar;
        this.f10615b = z10;
        this.f10616c = z11;
    }

    @Override // r3.h
    public final void a() {
        this.g = 0L;
        this.f10626n = false;
        this.f10625m = -9223372036854775807L;
        m1.o.a(this.f10620h);
        this.f10617d.g();
        this.f10618e.g();
        this.f10619f.g();
        ((b4.b) this.f10614a.f13566r).i(0);
        o oVar = this.f10623k;
        if (oVar != null) {
            oVar.f10605k = false;
            oVar.f10609o = false;
            n nVar = oVar.f10608n;
            nVar.f10582b = false;
            nVar.f10581a = false;
        }
    }

    @Override // r3.h
    public final void b(l1.t tVar) {
        int i10;
        l1.d.h(this.f10622j);
        int i11 = l1.a0.f8067a;
        int i12 = tVar.f8130b;
        int i13 = tVar.f8131c;
        byte[] bArr = tVar.f8129a;
        this.g += tVar.a();
        this.f10622j.c(tVar.a(), tVar);
        while (true) {
            int b2 = m1.o.b(bArr, i12, i13, this.f10620h);
            if (b2 == i13) {
                g(bArr, i12, i13);
                return;
            }
            int i14 = bArr[b2 + 3] & 31;
            if (b2 <= 0 || bArr[b2 - 1] != 0) {
                i10 = 3;
            } else {
                b2--;
                i10 = 4;
            }
            int i15 = b2 - i12;
            if (i15 > 0) {
                g(bArr, i12, b2);
            }
            int i16 = i13 - b2;
            long j10 = this.g - i16;
            f(i16, i15 < 0 ? -i15 : 0, j10, this.f10625m);
            h(i14, j10, this.f10625m);
            i12 = b2 + i10;
        }
    }

    @Override // r3.h
    public final void c(boolean z10) {
        l1.d.h(this.f10622j);
        int i10 = l1.a0.f8067a;
        if (z10) {
            ((b4.b) this.f10614a.f13566r).i(0);
            f(0, 0, this.g, this.f10625m);
            h(9, this.g, this.f10625m);
            f(0, 0, this.g, this.f10625m);
        }
    }

    @Override // r3.h
    public final void d(int i10, long j10) {
        this.f10625m = j10;
        this.f10626n = ((i10 & 2) != 0) | this.f10626n;
    }

    @Override // r3.h
    public final void e(k2.p pVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.f10621i = e0Var.f10512e;
        e0Var.b();
        g0 q10 = pVar.q(e0Var.f10511d, 2);
        this.f10622j = q10;
        this.f10623k = new o(q10, this.f10615b, this.f10616c);
        this.f10614a.v(pVar, e0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x01cd, code lost:
    
        if (r3.f10589j == r4.f10589j) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x01d7, code lost:
    
        if (r8 != 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01e9, code lost:
    
        if (r3.f10593n == r4.f10593n) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01fa, code lost:
    
        if (r3.f10595p == r4.f10595p) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0208, code lost:
    
        if (r3.f10591l == r4.f10591l) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0265, code lost:
    
        if (r3 == 1) goto L98;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(int r26, int r27, long r28, long r30) {
        /*
            Method dump skipped, instructions count: 633
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.p.f(int, int, long, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.p.g(byte[], int, int):void");
    }

    public final void h(int i10, long j10, long j11) {
        if (!this.f10624l || this.f10623k.f10598c) {
            this.f10617d.h(i10);
            this.f10618e.h(i10);
        }
        this.f10619f.h(i10);
        o oVar = this.f10623k;
        boolean z10 = this.f10626n;
        oVar.f10603i = i10;
        oVar.f10606l = j11;
        oVar.f10604j = j10;
        oVar.f10613s = z10;
        if (!oVar.f10597b || i10 != 1) {
            if (!oVar.f10598c) {
                return;
            }
            if (i10 != 5 && i10 != 1 && i10 != 2) {
                return;
            }
        }
        n nVar = oVar.f10607m;
        oVar.f10607m = oVar.f10608n;
        oVar.f10608n = nVar;
        nVar.f10582b = false;
        nVar.f10581a = false;
        oVar.f10602h = 0;
        oVar.f10605k = true;
    }
}
