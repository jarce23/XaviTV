package r3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final h f10710a;

    /* renamed from: b, reason: collision with root package name */
    public final i3.f f10711b = new i3.f(10, new byte[10]);

    /* renamed from: c, reason: collision with root package name */
    public int f10712c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f10713d;

    /* renamed from: e, reason: collision with root package name */
    public l1.y f10714e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10715f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10716h;

    /* renamed from: i, reason: collision with root package name */
    public int f10717i;

    /* renamed from: j, reason: collision with root package name */
    public int f10718j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10719k;

    /* renamed from: l, reason: collision with root package name */
    public long f10720l;

    public w(h hVar) {
        this.f10710a = hVar;
    }

    @Override // r3.f0
    public final void a() {
        this.f10712c = 0;
        this.f10713d = 0;
        this.f10716h = false;
        this.f10710a.a();
    }

    @Override // r3.f0
    public final void b(int i10, l1.t tVar) {
        l1.d.h(this.f10714e);
        int i11 = i10 & 1;
        int i12 = -1;
        int i13 = 2;
        h hVar = this.f10710a;
        if (i11 != 0) {
            int i14 = this.f10712c;
            if (i14 != 0 && i14 != 1) {
                if (i14 == 2) {
                    l1.b.q("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i14 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f10718j != -1) {
                        l1.b.q("PesReader", "Unexpected start indicator: expected " + this.f10718j + " more bytes");
                    }
                    hVar.c(tVar.f8131c == 0);
                }
            }
            this.f10712c = 1;
            this.f10713d = 0;
        }
        int i15 = i10;
        while (tVar.a() > 0) {
            int i16 = this.f10712c;
            if (i16 != 0) {
                i3.f fVar = this.f10711b;
                if (i16 != 1) {
                    if (i16 == i13) {
                        if (c(tVar, fVar.f6375b, Math.min(10, this.f10717i)) && c(tVar, null, this.f10717i)) {
                            fVar.q(0);
                            this.f10720l = -9223372036854775807L;
                            if (this.f10715f) {
                                fVar.t(4);
                                fVar.t(1);
                                fVar.t(1);
                                long i17 = (fVar.i(15) << 15) | (fVar.i(3) << 30) | fVar.i(15);
                                fVar.t(1);
                                if (!this.f10716h && this.g) {
                                    fVar.t(4);
                                    fVar.t(1);
                                    fVar.t(1);
                                    fVar.t(1);
                                    this.f10714e.b((fVar.i(3) << 30) | (fVar.i(15) << 15) | fVar.i(15));
                                    this.f10716h = true;
                                }
                                this.f10720l = this.f10714e.b(i17);
                            }
                            i15 |= this.f10719k ? 4 : 0;
                            hVar.d(i15, this.f10720l);
                            this.f10712c = 3;
                            this.f10713d = 0;
                        }
                    } else {
                        if (i16 != 3) {
                            throw new IllegalStateException();
                        }
                        int a10 = tVar.a();
                        int i18 = this.f10718j;
                        int i19 = i18 == i12 ? 0 : a10 - i18;
                        if (i19 > 0) {
                            a10 -= i19;
                            tVar.H(tVar.f8130b + a10);
                        }
                        hVar.b(tVar);
                        int i20 = this.f10718j;
                        if (i20 != i12) {
                            int i21 = i20 - a10;
                            this.f10718j = i21;
                            if (i21 == 0) {
                                hVar.c(false);
                                this.f10712c = 1;
                                this.f10713d = 0;
                            }
                        }
                    }
                } else if (c(tVar, fVar.f6375b, 9)) {
                    this.f10712c = e() ? 2 : 0;
                    this.f10713d = 0;
                }
            } else {
                tVar.J(tVar.a());
            }
            i12 = -1;
            i13 = 2;
        }
    }

    public final boolean c(l1.t tVar, byte[] bArr, int i10) {
        int min = Math.min(tVar.a(), i10 - this.f10713d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            tVar.J(min);
        } else {
            tVar.h(bArr, this.f10713d, min);
        }
        int i11 = this.f10713d + min;
        this.f10713d = i11;
        return i11 == i10;
    }

    @Override // r3.f0
    public final void d(l1.y yVar, k2.p pVar, e0 e0Var) {
        this.f10714e = yVar;
        this.f10710a.e(pVar, e0Var);
    }

    public final boolean e() {
        i3.f fVar = this.f10711b;
        fVar.q(0);
        int i10 = fVar.i(24);
        if (i10 != 1) {
            android.support.v4.media.d.x("Unexpected start code prefix: ", i10, "PesReader");
            this.f10718j = -1;
            return false;
        }
        fVar.t(8);
        int i11 = fVar.i(16);
        fVar.t(5);
        this.f10719k = fVar.h();
        fVar.t(2);
        this.f10715f = fVar.h();
        this.g = fVar.h();
        fVar.t(6);
        int i12 = fVar.i(8);
        this.f10717i = i12;
        if (i11 == 0) {
            this.f10718j = -1;
        } else {
            int i13 = (i11 - 3) - i12;
            this.f10718j = i13;
            if (i13 < 0) {
                l1.b.q("PesReader", "Found negative packet payload size: " + this.f10718j);
                this.f10718j = -1;
            }
        }
        return true;
    }
}
