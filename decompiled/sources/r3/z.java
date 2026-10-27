package r3;

import android.util.SparseArray;
import j9.v1;
import java.util.List;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z implements k2.n {

    /* renamed from: e, reason: collision with root package name */
    public boolean f10739e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10740f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public long f10741h;

    /* renamed from: i, reason: collision with root package name */
    public p2.a f10742i;

    /* renamed from: j, reason: collision with root package name */
    public k2.p f10743j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10744k;

    /* renamed from: a, reason: collision with root package name */
    public final l1.y f10735a = new l1.y(0);

    /* renamed from: c, reason: collision with root package name */
    public final l1.t f10737c = new l1.t(4096);

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f10736b = new SparseArray();

    /* renamed from: d, reason: collision with root package name */
    public final x f10738d = new x(0);

    @Override // k2.n
    public final void c(k2.p pVar) {
        this.f10743j = pVar;
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        l1.y yVar = this.f10735a;
        boolean z10 = yVar.e() == -9223372036854775807L;
        if (!z10) {
            long d6 = yVar.d();
            z10 = (d6 == -9223372036854775807L || d6 == 0 || d6 == j11) ? false : true;
        }
        if (z10) {
            yVar.g(j11);
        }
        p2.a aVar = this.f10742i;
        if (aVar != null) {
            aVar.d(j11);
        }
        int i10 = 0;
        while (true) {
            SparseArray sparseArray = this.f10736b;
            if (i10 >= sparseArray.size()) {
                return;
            }
            y yVar2 = (y) sparseArray.valueAt(i10);
            yVar2.f10734f = false;
            yVar2.f10729a.a();
            i10++;
        }
    }

    @Override // k2.n
    public final int f(k2.o oVar, i1.s sVar) {
        int i10;
        int i11;
        long j10;
        h hVar;
        long j11;
        l1.d.h(this.f10743j);
        long c10 = oVar.c();
        int i12 = (c10 > (-1L) ? 1 : (c10 == (-1L) ? 0 : -1));
        long j12 = -9223372036854775807L;
        x xVar = this.f10738d;
        if (i12 != 0 && !xVar.f10724d) {
            l1.y yVar = xVar.f10722b;
            l1.t tVar = xVar.f10723c;
            if (!xVar.f10726f) {
                long c11 = oVar.c();
                int min = (int) Math.min(20000L, c11);
                long j13 = c11 - min;
                if (oVar.getPosition() != j13) {
                    sVar.f6018a = j13;
                    return 1;
                }
                tVar.F(min);
                oVar.h();
                oVar.o(tVar.f8129a, 0, min);
                int i13 = tVar.f8130b;
                int i14 = tVar.f8131c - 4;
                while (true) {
                    if (i14 < i13) {
                        break;
                    }
                    if (x.b(i14, tVar.f8129a) == 442) {
                        tVar.I(i14 + 4);
                        long c12 = x.c(tVar);
                        if (c12 != -9223372036854775807L) {
                            j12 = c12;
                            break;
                        }
                    }
                    i14--;
                }
                xVar.f10727h = j12;
                xVar.f10726f = true;
                return 0;
            }
            if (xVar.f10727h == -9223372036854775807L) {
                xVar.a(oVar);
                return 0;
            }
            if (xVar.f10725e) {
                long j14 = xVar.g;
                if (j14 == -9223372036854775807L) {
                    xVar.a(oVar);
                    return 0;
                }
                xVar.f10728i = yVar.c(xVar.f10727h) - yVar.b(j14);
                xVar.a(oVar);
                return 0;
            }
            int min2 = (int) Math.min(20000L, oVar.c());
            long j15 = 0;
            if (oVar.getPosition() != j15) {
                sVar.f6018a = j15;
                return 1;
            }
            tVar.F(min2);
            oVar.h();
            oVar.o(tVar.f8129a, 0, min2);
            int i15 = tVar.f8130b;
            int i16 = tVar.f8131c;
            while (true) {
                if (i15 >= i16 - 3) {
                    j11 = -9223372036854775807L;
                    break;
                }
                if (x.b(i15, tVar.f8129a) == 442) {
                    tVar.I(i15 + 4);
                    long c13 = x.c(tVar);
                    if (c13 != -9223372036854775807L) {
                        j11 = c13;
                        break;
                    }
                }
                i15++;
            }
            xVar.g = j11;
            xVar.f10725e = true;
            return 0;
        }
        if (this.f10744k) {
            i10 = i12;
            i11 = 4;
        } else {
            this.f10744k = true;
            long j16 = xVar.f10728i;
            if (j16 != -9223372036854775807L) {
                i10 = i12;
                i11 = 4;
                p2.a aVar = new p2.a(new v1(1), new x4.e(xVar.f10722b), j16, j16 + 1, 0L, c10, 188L, 1000);
                this.f10742i = aVar;
                this.f10743j.t(aVar.f9876a);
            } else {
                i10 = i12;
                i11 = 4;
                this.f10743j.t(new k2.r(j16));
            }
        }
        p2.a aVar2 = this.f10742i;
        if (aVar2 != null && aVar2.f9878c != null) {
            return aVar2.b(oVar, sVar);
        }
        oVar.h();
        long n10 = i10 != 0 ? c10 - oVar.n() : -1L;
        if (n10 != -1 && n10 < 4) {
            return -1;
        }
        l1.t tVar2 = this.f10737c;
        if (!oVar.m(tVar2.f8129a, 0, i11, true)) {
            return -1;
        }
        tVar2.I(0);
        int j17 = tVar2.j();
        if (j17 == 441) {
            return -1;
        }
        if (j17 == 442) {
            oVar.o(tVar2.f8129a, 0, 10);
            tVar2.I(9);
            oVar.i((tVar2.w() & 7) + 14);
            return 0;
        }
        if (j17 == 443) {
            oVar.o(tVar2.f8129a, 0, 2);
            tVar2.I(0);
            oVar.i(tVar2.C() + 6);
            return 0;
        }
        if (((j17 & (-256)) >> 8) != 1) {
            oVar.i(1);
            return 0;
        }
        int i17 = j17 & 255;
        SparseArray sparseArray = this.f10736b;
        y yVar2 = (y) sparseArray.get(i17);
        if (!this.f10739e) {
            if (yVar2 == null) {
                if (i17 == 189) {
                    hVar = new b("video/mp2p");
                    this.f10740f = true;
                    this.f10741h = oVar.getPosition();
                } else if ((j17 & 224) == 192) {
                    hVar = new t(null, 0, "video/mp2p");
                    this.f10740f = true;
                    this.f10741h = oVar.getPosition();
                } else if ((j17 & 240) == 224) {
                    hVar = new j(null, "video/mp2p");
                    this.g = true;
                    this.f10741h = oVar.getPosition();
                } else {
                    hVar = null;
                }
                if (hVar != null) {
                    hVar.e(this.f10743j, new e0(i17, 256));
                    yVar2 = new y(hVar, this.f10735a);
                    sparseArray.put(i17, yVar2);
                }
            }
            if (oVar.getPosition() > ((this.f10740f && this.g) ? this.f10741h + 8192 : 1048576L)) {
                this.f10739e = true;
                this.f10743j.f();
            }
        }
        oVar.o(tVar2.f8129a, 0, 2);
        tVar2.I(0);
        int C = tVar2.C() + 6;
        if (yVar2 == null) {
            oVar.i(C);
            return 0;
        }
        tVar2.F(C);
        oVar.readFully(tVar2.f8129a, 0, C);
        tVar2.I(6);
        h hVar2 = yVar2.f10729a;
        i3.f fVar = yVar2.f10731c;
        tVar2.h(fVar.f6375b, 0, 3);
        fVar.q(0);
        fVar.t(8);
        yVar2.f10732d = fVar.h();
        yVar2.f10733e = fVar.h();
        fVar.t(6);
        tVar2.h(fVar.f6375b, 0, fVar.i(8));
        fVar.q(0);
        l1.y yVar3 = yVar2.f10730b;
        yVar2.g = 0L;
        if (yVar2.f10732d) {
            fVar.t(4);
            fVar.t(1);
            fVar.t(1);
            long i18 = (fVar.i(3) << 30) | (fVar.i(15) << 15) | fVar.i(15);
            fVar.t(1);
            if (yVar2.f10734f || !yVar2.f10733e) {
                j10 = i18;
            } else {
                fVar.t(4);
                fVar.t(1);
                fVar.t(1);
                fVar.t(1);
                yVar3.b((fVar.i(15) << 15) | (fVar.i(3) << 30) | fVar.i(15));
                yVar2.f10734f = true;
                j10 = i18;
            }
            yVar2.g = yVar3.b(j10);
        }
        hVar2.d(4, yVar2.g);
        hVar2.b(tVar2);
        hVar2.c(false);
        tVar2.H(tVar2.f8129a.length);
        return 0;
    }

    @Override // k2.n
    public final List g() {
        o9.e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    @Override // k2.n
    public final boolean m(k2.o oVar) {
        byte[] bArr = new byte[14];
        k2.k kVar = (k2.k) oVar;
        kVar.m(bArr, 0, 14, false);
        if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            kVar.f(bArr[13] & 7, false);
            kVar.m(bArr, 0, 3, false);
            if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
                return true;
            }
        }
        return false;
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final k2.n b() {
        return this;
    }
}
