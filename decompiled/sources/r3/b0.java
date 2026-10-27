package r3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final a0 f10447a;

    /* renamed from: b, reason: collision with root package name */
    public final l1.t f10448b = new l1.t(32);

    /* renamed from: c, reason: collision with root package name */
    public int f10449c;

    /* renamed from: d, reason: collision with root package name */
    public int f10450d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10451e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10452f;

    public b0(a0 a0Var) {
        this.f10447a = a0Var;
    }

    @Override // r3.f0
    public final void a() {
        this.f10452f = true;
    }

    @Override // r3.f0
    public final void b(int i10, l1.t tVar) {
        boolean z10 = (i10 & 1) != 0;
        int w10 = z10 ? tVar.f8130b + tVar.w() : -1;
        if (this.f10452f) {
            if (!z10) {
                return;
            }
            this.f10452f = false;
            tVar.I(w10);
            this.f10450d = 0;
        }
        while (tVar.a() > 0) {
            int i11 = this.f10450d;
            l1.t tVar2 = this.f10448b;
            if (i11 < 3) {
                if (i11 == 0) {
                    int w11 = tVar.w();
                    tVar.I(tVar.f8130b - 1);
                    if (w11 == 255) {
                        this.f10452f = true;
                        return;
                    }
                }
                int min = Math.min(tVar.a(), 3 - this.f10450d);
                tVar.h(tVar2.f8129a, this.f10450d, min);
                int i12 = this.f10450d + min;
                this.f10450d = i12;
                if (i12 == 3) {
                    tVar2.I(0);
                    tVar2.H(3);
                    tVar2.J(1);
                    int w12 = tVar2.w();
                    int w13 = tVar2.w();
                    this.f10451e = (w12 & 128) != 0;
                    int i13 = (((w12 & 15) << 8) | w13) + 3;
                    this.f10449c = i13;
                    byte[] bArr = tVar2.f8129a;
                    if (bArr.length < i13) {
                        tVar2.c(Math.min(4098, Math.max(i13, bArr.length * 2)));
                    }
                }
            } else {
                int min2 = Math.min(tVar.a(), this.f10449c - this.f10450d);
                tVar.h(tVar2.f8129a, this.f10450d, min2);
                int i14 = this.f10450d + min2;
                this.f10450d = i14;
                int i15 = this.f10449c;
                if (i14 != i15) {
                    continue;
                } else {
                    if (!this.f10451e) {
                        tVar2.H(i15);
                    } else {
                        if (l1.a0.m(0, i15, -1, tVar2.f8129a) != 0) {
                            this.f10452f = true;
                            return;
                        }
                        tVar2.H(this.f10449c - 4);
                    }
                    tVar2.I(0);
                    this.f10447a.b(tVar2);
                    this.f10450d = 0;
                }
            }
        }
    }

    @Override // r3.f0
    public final void d(l1.y yVar, k2.p pVar, e0 e0Var) {
        this.f10447a.d(yVar, pVar, e0Var);
        this.f10452f = true;
    }
}
