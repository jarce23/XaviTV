package p2;

import androidx.fragment.app.v0;
import c2.j1;
import i1.f0;
import i1.h0;
import i3.f;
import java.util.Arrays;
import java.util.List;
import k2.a0;
import k2.g0;
import k2.k;
import k2.n;
import k2.o;
import k2.p;
import k2.r;
import k2.s;
import l1.t;
import o9.e0;
import o9.w0;
import x4.c;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements n {

    /* renamed from: e, reason: collision with root package name */
    public p f9884e;

    /* renamed from: f, reason: collision with root package name */
    public g0 f9885f;

    /* renamed from: h, reason: collision with root package name */
    public f0 f9886h;

    /* renamed from: i, reason: collision with root package name */
    public s f9887i;

    /* renamed from: j, reason: collision with root package name */
    public int f9888j;

    /* renamed from: k, reason: collision with root package name */
    public int f9889k;

    /* renamed from: l, reason: collision with root package name */
    public a f9890l;

    /* renamed from: m, reason: collision with root package name */
    public int f9891m;

    /* renamed from: n, reason: collision with root package name */
    public long f9892n;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f9880a = new byte[42];

    /* renamed from: b, reason: collision with root package name */
    public final t f9881b = new t(0, new byte[32768]);

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9882c = false;

    /* renamed from: d, reason: collision with root package name */
    public final i1.s f9883d = new i1.s();
    public int g = 0;

    @Override // k2.n
    public final void c(p pVar) {
        this.f9884e = pVar;
        this.f9885f = pVar.q(0, 1);
        pVar.f();
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        if (j10 == 0) {
            this.g = 0;
        } else {
            a aVar = this.f9890l;
            if (aVar != null) {
                aVar.d(j11);
            }
        }
        this.f9892n = j11 != 0 ? -1L : 0L;
        this.f9891m = 0;
        this.f9881b.F(0);
    }

    @Override // k2.n
    public final int f(o oVar, i1.s sVar) {
        s sVar2;
        int i10;
        a0 rVar;
        long j10;
        long j11;
        boolean z10;
        int i11 = this.g;
        if (i11 == 0) {
            boolean z11 = !this.f9882c;
            oVar.h();
            long n10 = oVar.n();
            f0 s10 = k2.b.s(oVar, z11);
            oVar.i((int) (oVar.n() - n10));
            this.f9886h = s10;
            this.g = 1;
            return 0;
        }
        byte[] bArr = this.f9880a;
        if (i11 == 1) {
            oVar.o(bArr, 0, bArr.length);
            oVar.h();
            this.g = 2;
            return 0;
        }
        int i12 = 4;
        int i13 = 3;
        if (i11 == 2) {
            t tVar = new t(4);
            oVar.readFully(tVar.f8129a, 0, 4);
            if (tVar.y() != 1716281667) {
                throw h0.a(null, "Failed to read FLAC stream marker.");
            }
            this.g = 3;
            return 0;
        }
        int i14 = 6;
        if (i11 == 3) {
            int i15 = 0;
            s sVar3 = this.f9887i;
            boolean z12 = false;
            while (!z12) {
                oVar.h();
                byte[] bArr2 = new byte[i12];
                f fVar = new f(i12, bArr2);
                int i16 = i15;
                oVar.o(bArr2, i16, i12);
                boolean h10 = fVar.h();
                int i17 = fVar.i(r10);
                int i18 = fVar.i(24) + i12;
                if (i17 == 0) {
                    byte[] bArr3 = new byte[38];
                    oVar.readFully(bArr3, i16, 38);
                    sVar3 = new s(i12, bArr3);
                } else {
                    if (sVar3 == null) {
                        throw new IllegalArgumentException();
                    }
                    f0 f0Var = sVar3.f7778l;
                    if (i17 == i13) {
                        t tVar2 = new t(i18);
                        oVar.readFully(tVar2.f8129a, i16, i18);
                        sVar3 = new s(sVar3.f7768a, sVar3.f7769b, sVar3.f7770c, sVar3.f7771d, sVar3.f7772e, sVar3.g, sVar3.f7774h, sVar3.f7776j, k2.b.u(tVar2), sVar3.f7778l);
                    } else {
                        if (i17 == i12) {
                            t tVar3 = new t(i18);
                            oVar.readFully(tVar3.f8129a, 0, i18);
                            tVar3.J(i12);
                            f0 r2 = k2.b.r(Arrays.asList(k2.b.v(tVar3, false, false).f7741p));
                            if (f0Var != null) {
                                r2 = f0Var.b(r2);
                            }
                            sVar2 = new s(sVar3.f7768a, sVar3.f7769b, sVar3.f7770c, sVar3.f7771d, sVar3.f7772e, sVar3.g, sVar3.f7774h, sVar3.f7776j, sVar3.f7777k, r2);
                        } else if (i17 == i14) {
                            t tVar4 = new t(i18);
                            oVar.readFully(tVar4.f8129a, 0, i18);
                            tVar4.J(4);
                            f0 f0Var2 = new f0(o9.g0.r(w2.a.d(tVar4)));
                            if (f0Var != null) {
                                f0Var2 = f0Var.b(f0Var2);
                            }
                            sVar2 = new s(sVar3.f7768a, sVar3.f7769b, sVar3.f7770c, sVar3.f7771d, sVar3.f7772e, sVar3.g, sVar3.f7774h, sVar3.f7776j, sVar3.f7777k, f0Var2);
                        } else {
                            oVar.i(i18);
                        }
                        sVar3 = sVar2;
                    }
                }
                int i19 = l1.a0.f8067a;
                this.f9887i = sVar3;
                z12 = h10;
                i12 = 4;
                i13 = 3;
                r10 = 7;
                i14 = 6;
                i15 = 0;
            }
            this.f9887i.getClass();
            this.f9888j = Math.max(this.f9887i.f7770c, 6);
            i1.p c10 = this.f9887i.c(bArr, this.f9886h);
            g0 g0Var = this.f9885f;
            i1.o a10 = c10.a();
            a10.f5939l = i1.g0.m("audio/flac");
            r.a.i(a10, g0Var);
            g0 g0Var2 = this.f9885f;
            this.f9887i.b();
            g0Var2.getClass();
            this.g = 4;
            return 0;
        }
        long j12 = 0;
        if (i11 == 4) {
            oVar.h();
            t tVar5 = new t(2);
            oVar.o(tVar5.f8129a, 0, 2);
            int C = tVar5.C();
            if ((C >> 2) != 16382) {
                oVar.h();
                throw h0.a(null, "First frame does not start with sync code.");
            }
            oVar.h();
            this.f9889k = C;
            p pVar = this.f9884e;
            int i20 = l1.a0.f8067a;
            long position = oVar.getPosition();
            long c11 = oVar.c();
            this.f9887i.getClass();
            s sVar4 = this.f9887i;
            c cVar = sVar4.f7777k;
            if (cVar != null && ((long[]) cVar.f13537p).length > 0) {
                rVar = new r(0, position, sVar4);
                i10 = 0;
            } else if (c11 == -1 || sVar4.f7776j <= 0) {
                i10 = 0;
                rVar = new r(sVar4.b());
            } else {
                int i21 = this.f9889k;
                int i22 = sVar4.f7770c;
                v0 v0Var = new v0(13, sVar4);
                j1 j1Var = new j1(sVar4, i21);
                long b2 = sVar4.b();
                long j13 = sVar4.f7776j;
                int i23 = sVar4.f7771d;
                if (i23 > 0) {
                    i10 = 0;
                    j10 = ((i23 + i22) / 2) + 1;
                } else {
                    i10 = 0;
                    int i24 = sVar4.f7768a;
                    j10 = 64 + (((((i24 != sVar4.f7769b || i24 <= 0) ? 4096L : i24) * sVar4.g) * sVar4.f7774h) / 8);
                }
                a aVar = new a(v0Var, j1Var, b2, j13, position, c11, j10, Math.max(6, i22));
                this.f9890l = aVar;
                rVar = aVar.f9876a;
            }
            pVar.t(rVar);
            this.g = 5;
            return i10;
        }
        if (i11 != 5) {
            throw new IllegalStateException();
        }
        this.f9885f.getClass();
        this.f9887i.getClass();
        a aVar2 = this.f9890l;
        if (aVar2 != null && aVar2.f9878c != null) {
            return aVar2.b(oVar, sVar);
        }
        if (this.f9892n == -1) {
            s sVar5 = this.f9887i;
            oVar.h();
            oVar.p(1);
            byte[] bArr4 = new byte[1];
            oVar.o(bArr4, 0, 1);
            boolean z13 = (bArr4[0] & 1) == 1;
            oVar.p(2);
            r10 = z13 ? 7 : 6;
            t tVar6 = new t(r10);
            byte[] bArr5 = tVar6.f8129a;
            int i25 = 0;
            while (i25 < r10) {
                int d6 = oVar.d(bArr5, i25, r10 - i25);
                if (d6 == -1) {
                    break;
                }
                i25 += d6;
            }
            tVar6.H(i25);
            oVar.h();
            try {
                long D = tVar6.D();
                if (!z13) {
                    D *= sVar5.f7769b;
                }
                j12 = D;
            } catch (NumberFormatException unused) {
                r3 = false;
            }
            if (!r3) {
                throw h0.a(null, null);
            }
            this.f9892n = j12;
        } else {
            t tVar7 = this.f9881b;
            int i26 = tVar7.f8131c;
            if (i26 < 32768) {
                int read = oVar.read(tVar7.f8129a, i26, 32768 - i26);
                r3 = read == -1;
                if (!r3) {
                    tVar7.H(i26 + read);
                } else if (tVar7.a() == 0) {
                    long j14 = this.f9892n * 1000000;
                    s sVar6 = this.f9887i;
                    int i27 = l1.a0.f8067a;
                    this.f9885f.e(j14 / sVar6.f7772e, 1, this.f9891m, 0, null);
                    return -1;
                }
            } else {
                r3 = false;
            }
            int i28 = tVar7.f8130b;
            int i29 = this.f9891m;
            int i30 = this.f9888j;
            if (i29 < i30) {
                tVar7.J(Math.min(i30 - i29, tVar7.a()));
            }
            this.f9887i.getClass();
            int i31 = tVar7.f8130b;
            while (true) {
                int i32 = tVar7.f8131c - 16;
                i1.s sVar7 = this.f9883d;
                if (i31 <= i32) {
                    tVar7.I(i31);
                    if (k2.b.b(tVar7, this.f9887i, this.f9889k, sVar7)) {
                        tVar7.I(i31);
                        j11 = sVar7.f6018a;
                        break;
                    }
                    i31++;
                } else {
                    if (r3) {
                        while (true) {
                            int i33 = tVar7.f8131c;
                            if (i31 > i33 - this.f9888j) {
                                tVar7.I(i33);
                                break;
                            }
                            tVar7.I(i31);
                            try {
                                z10 = k2.b.b(tVar7, this.f9887i, this.f9889k, sVar7);
                            } catch (IndexOutOfBoundsException unused2) {
                                z10 = false;
                            }
                            if (tVar7.f8130b > tVar7.f8131c) {
                                z10 = false;
                            }
                            if (z10) {
                                tVar7.I(i31);
                                j11 = sVar7.f6018a;
                                break;
                            }
                            i31++;
                        }
                    } else {
                        tVar7.I(i31);
                    }
                    j11 = -1;
                }
            }
            int i34 = tVar7.f8130b - i28;
            tVar7.I(i28);
            this.f9885f.c(i34, tVar7);
            int i35 = this.f9891m + i34;
            this.f9891m = i35;
            if (j11 != -1) {
                long j15 = this.f9892n * 1000000;
                s sVar8 = this.f9887i;
                int i36 = l1.a0.f8067a;
                this.f9885f.e(j15 / sVar8.f7772e, 1, i35, 0, null);
                this.f9891m = 0;
                this.f9892n = j11;
            }
            int length = tVar7.f8129a.length - tVar7.f8131c;
            if (tVar7.a() < 16 && length < 16) {
                int a11 = tVar7.a();
                byte[] bArr6 = tVar7.f8129a;
                System.arraycopy(bArr6, tVar7.f8130b, bArr6, 0, a11);
                tVar7.I(0);
                tVar7.H(a11);
            }
        }
        return 0;
    }

    @Override // k2.n
    public final List g() {
        e0 e0Var = o9.g0.f9617p;
        return w0.f9686s;
    }

    @Override // k2.n
    public final boolean m(o oVar) {
        k2.b.s(oVar, false);
        t tVar = new t(4);
        ((k) oVar).m(tVar.f8129a, 0, 4, false);
        return tVar.y() == 1716281667;
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final n b() {
        return this;
    }
}
