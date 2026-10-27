package r3;

import java.util.Arrays;
import java.util.Collections;
import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements h {

    /* renamed from: x, reason: collision with root package name */
    public static final byte[] f10485x = {73, 68, 51};

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10486a;

    /* renamed from: d, reason: collision with root package name */
    public final String f10489d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10490e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10491f;
    public String g;

    /* renamed from: h, reason: collision with root package name */
    public g0 f10492h;

    /* renamed from: i, reason: collision with root package name */
    public g0 f10493i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10497m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10498n;

    /* renamed from: q, reason: collision with root package name */
    public int f10501q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10502r;

    /* renamed from: t, reason: collision with root package name */
    public int f10504t;

    /* renamed from: v, reason: collision with root package name */
    public g0 f10506v;

    /* renamed from: w, reason: collision with root package name */
    public long f10507w;

    /* renamed from: b, reason: collision with root package name */
    public final i3.f f10487b = new i3.f(7, new byte[7]);

    /* renamed from: c, reason: collision with root package name */
    public final l1.t f10488c = new l1.t(Arrays.copyOf(f10485x, 10));

    /* renamed from: o, reason: collision with root package name */
    public int f10499o = -1;

    /* renamed from: p, reason: collision with root package name */
    public int f10500p = -1;

    /* renamed from: s, reason: collision with root package name */
    public long f10503s = -9223372036854775807L;

    /* renamed from: u, reason: collision with root package name */
    public long f10505u = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public int f10494j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f10495k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f10496l = 256;

    public e(int i10, String str, String str2, boolean z10) {
        this.f10486a = z10;
        this.f10489d = str;
        this.f10490e = i10;
        this.f10491f = str2;
    }

    @Override // r3.h
    public final void a() {
        this.f10505u = -9223372036854775807L;
        this.f10498n = false;
        this.f10494j = 0;
        this.f10495k = 0;
        this.f10496l = 256;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    @Override // r3.h
    public final void b(l1.t tVar) {
        int i10;
        int i11;
        byte b2;
        char c10;
        ?? r42;
        int i12;
        char c11;
        int i13;
        char c12;
        int i14;
        this.f10492h.getClass();
        int i15 = l1.a0.f8067a;
        while (tVar.a() > 0) {
            int i16 = this.f10494j;
            char c13 = 65535;
            l1.t tVar2 = this.f10488c;
            int i17 = 3;
            i3.f fVar = this.f10487b;
            int i18 = 0;
            int i19 = 4;
            int i20 = 1;
            if (i16 == 0) {
                byte[] bArr = tVar.f8129a;
                int i21 = tVar.f8130b;
                int i22 = tVar.f8131c;
                while (true) {
                    if (i21 >= i22) {
                        tVar.I(i21);
                        break;
                    }
                    i10 = i21 + 1;
                    i11 = i17;
                    b2 = bArr[i21];
                    int i23 = b2 & 255;
                    if (this.f10496l != 512 || (((65280 | ((((byte) i23) & 255) == true ? 1 : 0)) == true ? 1 : 0) & 65526) != 65520) {
                        c10 = c13;
                        r42 = i20;
                    } else {
                        if (this.f10498n) {
                            break;
                        }
                        int i24 = i21 - 1;
                        tVar.I(i21);
                        byte[] bArr2 = fVar.f6375b;
                        if (tVar.a() >= i20) {
                            tVar.h(bArr2, i18, i20);
                            fVar.q(i19);
                            int i25 = fVar.i(i20);
                            int i26 = this.f10499o;
                            if (i26 == -1 || i25 == i26) {
                                if (this.f10500p != -1) {
                                    byte[] bArr3 = fVar.f6375b;
                                    if (tVar.a() < i20) {
                                        break;
                                    }
                                    tVar.h(bArr3, i18, i20);
                                    fVar.q(2);
                                    i14 = 4;
                                    if (fVar.i(4) == this.f10500p) {
                                        tVar.I(i10);
                                    }
                                } else {
                                    i14 = 4;
                                }
                                byte[] bArr4 = fVar.f6375b;
                                if (tVar.a() >= i14) {
                                    tVar.h(bArr4, i18, i14);
                                    fVar.q(14);
                                    int i27 = fVar.i(13);
                                    if (i27 >= 7) {
                                        byte[] bArr5 = tVar.f8129a;
                                        int i28 = tVar.f8131c;
                                        int i29 = i24 + i27;
                                        if (i29 < i28) {
                                            byte b10 = bArr5[i29];
                                            c10 = 65535;
                                            if (b10 != -1) {
                                                if (b10 == 73) {
                                                    int i30 = i29 + 1;
                                                    if (i30 != i28) {
                                                        if (bArr5[i30] == 68) {
                                                            int i31 = i29 + 2;
                                                            if (i31 != i28) {
                                                                if (bArr5[i31] == 51) {
                                                                    break;
                                                                }
                                                            } else {
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                            } else {
                                                int i32 = i29 + 1;
                                                if (i32 != i28) {
                                                    byte b11 = bArr5[i32];
                                                    if ((((65280 | ((b11 & 255) == true ? 1 : 0)) == true ? 1 : 0) & 65526) == 65520 && ((b11 & 8) >> 3) == i25) {
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                c10 = 65535;
                            }
                            r42 = true;
                        }
                        c10 = 65535;
                        r42 = true;
                    }
                    int i33 = this.f10496l;
                    int i34 = i23 | i33;
                    if (i34 == 329) {
                        i12 = 3;
                        c11 = 256;
                        i13 = 0;
                        c12 = 2;
                        this.f10496l = 768;
                    } else if (i34 == 511) {
                        i12 = 3;
                        c11 = 256;
                        i13 = 0;
                        c12 = 2;
                        this.f10496l = 512;
                    } else if (i34 == 836) {
                        i12 = 3;
                        c11 = 256;
                        i13 = 0;
                        c12 = 2;
                        this.f10496l = 1024;
                    } else {
                        if (i34 == 1075) {
                            this.f10494j = 2;
                            this.f10495k = 3;
                            this.f10504t = 0;
                            tVar2.I(0);
                            tVar.I(i10);
                            break;
                        }
                        c11 = 256;
                        if (i33 != 256) {
                            this.f10496l = 256;
                            i12 = 3;
                            i13 = 0;
                            c12 = 2;
                            i20 = r42;
                            c13 = c10;
                            i19 = 4;
                            i18 = i13;
                            i17 = i12;
                        } else {
                            i12 = 3;
                            i13 = 0;
                            c12 = 2;
                        }
                    }
                    i21 = i10;
                    i20 = r42;
                    c13 = c10;
                    i19 = 4;
                    i18 = i13;
                    i17 = i12;
                }
                this.f10501q = (b2 & 8) >> 3;
                this.f10497m = (b2 & 1) == 0;
                if (this.f10498n) {
                    this.f10494j = i11;
                    this.f10495k = 0;
                } else {
                    this.f10494j = 1;
                    this.f10495k = 0;
                }
                tVar.I(i10);
            } else if (i16 != 1) {
                if (i16 == 2) {
                    byte[] bArr6 = tVar2.f8129a;
                    int min = Math.min(tVar.a(), 10 - this.f10495k);
                    tVar.h(bArr6, this.f10495k, min);
                    int i35 = this.f10495k + min;
                    this.f10495k = i35;
                    if (i35 == 10) {
                        this.f10493i.c(10, tVar2);
                        tVar2.I(6);
                        g0 g0Var = this.f10493i;
                        int v10 = tVar2.v() + 10;
                        this.f10494j = 4;
                        this.f10495k = 10;
                        this.f10506v = g0Var;
                        this.f10507w = 0L;
                        this.f10504t = v10;
                    }
                } else if (i16 == 3) {
                    int i36 = this.f10497m ? 7 : 5;
                    byte[] bArr7 = fVar.f6375b;
                    int min2 = Math.min(tVar.a(), i36 - this.f10495k);
                    tVar.h(bArr7, this.f10495k, min2);
                    int i37 = this.f10495k + min2;
                    this.f10495k = i37;
                    if (i37 == i36) {
                        fVar.q(0);
                        if (this.f10502r) {
                            fVar.t(10);
                        } else {
                            int i38 = fVar.i(2) + 1;
                            if (i38 != 2) {
                                l1.b.q("AdtsReader", "Detected audio object type: " + i38 + ", but assuming AAC LC.");
                                i38 = 2;
                            }
                            fVar.t(5);
                            int i39 = fVar.i(3);
                            int i40 = this.f10500p;
                            byte[] bArr8 = {(byte) (((i38 << 3) & 248) | ((i40 >> 1) & 7)), (byte) (((i39 << 3) & 120) | ((i40 << 7) & 128))};
                            k2.a n10 = k2.b.n(new i3.f(2, bArr8), false);
                            i1.o oVar = new i1.o();
                            oVar.f5929a = this.g;
                            oVar.f5939l = i1.g0.m(this.f10491f);
                            oVar.f5940m = i1.g0.m("audio/mp4a-latm");
                            oVar.f5937j = n10.f7660a;
                            oVar.E = n10.f7662c;
                            oVar.F = n10.f7661b;
                            oVar.f5943p = Collections.singletonList(bArr8);
                            oVar.f5932d = this.f10489d;
                            oVar.f5934f = this.f10490e;
                            i1.p pVar = new i1.p(oVar);
                            this.f10503s = 1024000000 / pVar.G;
                            this.f10492h.a(pVar);
                            this.f10502r = true;
                        }
                        fVar.t(4);
                        int i41 = fVar.i(13);
                        int i42 = i41 - 7;
                        if (this.f10497m) {
                            i42 = i41 - 9;
                        }
                        g0 g0Var2 = this.f10492h;
                        long j10 = this.f10503s;
                        this.f10494j = 4;
                        this.f10495k = 0;
                        this.f10506v = g0Var2;
                        this.f10507w = j10;
                        this.f10504t = i42;
                    }
                } else {
                    if (i16 != 4) {
                        throw new IllegalStateException();
                    }
                    int min3 = Math.min(tVar.a(), this.f10504t - this.f10495k);
                    this.f10506v.c(min3, tVar);
                    int i43 = this.f10495k + min3;
                    this.f10495k = i43;
                    if (i43 == this.f10504t) {
                        l1.d.g(this.f10505u != -9223372036854775807L);
                        this.f10506v.e(this.f10505u, 1, this.f10504t, 0, null);
                        this.f10505u += this.f10507w;
                        this.f10494j = 0;
                        this.f10495k = 0;
                        this.f10496l = 256;
                    }
                }
            } else if (tVar.a() != 0) {
                fVar.f6375b[0] = tVar.f8129a[tVar.f8130b];
                fVar.q(2);
                int i44 = fVar.i(4);
                int i45 = this.f10500p;
                if (i45 == -1 || i44 == i45) {
                    if (!this.f10498n) {
                        this.f10498n = true;
                        this.f10499o = this.f10501q;
                        this.f10500p = i44;
                    }
                    this.f10494j = 3;
                    this.f10495k = 0;
                } else {
                    this.f10498n = false;
                    this.f10494j = 0;
                    this.f10495k = 0;
                    this.f10496l = 256;
                }
            }
        }
    }

    @Override // r3.h
    public final void d(int i10, long j10) {
        this.f10505u = j10;
    }

    @Override // r3.h
    public final void e(k2.p pVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.g = e0Var.f10512e;
        e0Var.b();
        g0 q10 = pVar.q(e0Var.f10511d, 1);
        this.f10492h = q10;
        this.f10506v = q10;
        if (!this.f10486a) {
            this.f10493i = new k2.m();
            return;
        }
        e0Var.a();
        e0Var.b();
        g0 q11 = pVar.q(e0Var.f10511d, 5);
        this.f10493i = q11;
        i1.o oVar = new i1.o();
        e0Var.b();
        oVar.f5929a = e0Var.f10512e;
        oVar.f5939l = i1.g0.m(this.f10491f);
        oVar.f5940m = i1.g0.m("application/id3");
        r.a.i(oVar, q11);
    }

    @Override // r3.h
    public final void c(boolean z10) {
    }
}
