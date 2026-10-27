package r3;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import c2.j1;
import i1.h0;
import j9.v1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 implements k2.n {

    /* renamed from: a, reason: collision with root package name */
    public final int f10456a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10457b;

    /* renamed from: c, reason: collision with root package name */
    public final List f10458c;

    /* renamed from: d, reason: collision with root package name */
    public final l1.t f10459d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseIntArray f10460e;

    /* renamed from: f, reason: collision with root package name */
    public final j0.i f10461f;
    public final h3.i g;

    /* renamed from: h, reason: collision with root package name */
    public final SparseArray f10462h;

    /* renamed from: i, reason: collision with root package name */
    public final SparseBooleanArray f10463i;

    /* renamed from: j, reason: collision with root package name */
    public final SparseBooleanArray f10464j;

    /* renamed from: k, reason: collision with root package name */
    public final x f10465k;

    /* renamed from: l, reason: collision with root package name */
    public p2.a f10466l;

    /* renamed from: m, reason: collision with root package name */
    public k2.p f10467m;

    /* renamed from: n, reason: collision with root package name */
    public int f10468n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f10469o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10470p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10471q;

    /* renamed from: r, reason: collision with root package name */
    public f0 f10472r;

    /* renamed from: s, reason: collision with root package name */
    public int f10473s;

    /* renamed from: t, reason: collision with root package name */
    public int f10474t;

    public c0(int i10, int i11, h3.i iVar, l1.y yVar, j0.i iVar2) {
        this.f10461f = iVar2;
        this.f10456a = i10;
        this.f10457b = i11;
        this.g = iVar;
        if (i10 == 1 || i10 == 2) {
            this.f10458c = Collections.singletonList(yVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f10458c = arrayList;
            arrayList.add(yVar);
        }
        this.f10459d = new l1.t(0, new byte[9400]);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.f10463i = sparseBooleanArray;
        this.f10464j = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.f10462h = sparseArray;
        this.f10460e = new SparseIntArray();
        this.f10465k = new x(1);
        this.f10467m = k2.p.f7764e;
        this.f10474t = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i12 = 0; i12 < size; i12++) {
            sparseArray.put(sparseArray2.keyAt(i12), (f0) sparseArray2.valueAt(i12));
        }
        x4.l lVar = new x4.l();
        lVar.f13562p = this;
        lVar.f13561o = new i3.f(4, new byte[4]);
        sparseArray.put(0, new b0(lVar));
        this.f10472r = null;
    }

    @Override // k2.n
    public final void c(k2.p pVar) {
        if ((this.f10457b & 1) == 0) {
            pVar = new c4.e(pVar, this.g);
        }
        this.f10467m = pVar;
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        p2.a aVar;
        l1.d.g(this.f10456a != 2);
        List list = this.f10458c;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            l1.y yVar = (l1.y) list.get(i10);
            boolean z10 = yVar.e() == -9223372036854775807L;
            if (!z10) {
                long d6 = yVar.d();
                z10 = (d6 == -9223372036854775807L || d6 == 0 || d6 == j11) ? false : true;
            }
            if (z10) {
                yVar.g(j11);
            }
        }
        if (j11 != 0 && (aVar = this.f10466l) != null) {
            aVar.d(j11);
        }
        this.f10459d.F(0);
        this.f10460e.clear();
        int i11 = 0;
        while (true) {
            SparseArray sparseArray = this.f10462h;
            if (i11 >= sparseArray.size()) {
                this.f10473s = 0;
                return;
            } else {
                ((f0) sparseArray.valueAt(i11)).a();
                i11++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    @Override // k2.n
    public final int f(k2.o oVar, i1.s sVar) {
        k2.o oVar2;
        ?? r12;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z10;
        long c10 = oVar.c();
        int i14 = this.f10456a;
        boolean z11 = i14 == 2;
        if (this.f10469o) {
            long j10 = -9223372036854775807L;
            x xVar = this.f10465k;
            if (c10 != -1 && !z11 && !xVar.f10724d) {
                int i15 = this.f10474t;
                l1.y yVar = xVar.f10722b;
                l1.t tVar = xVar.f10723c;
                if (i15 <= 0) {
                    xVar.a(oVar);
                    return 0;
                }
                if (xVar.f10726f) {
                    if (xVar.f10727h == -9223372036854775807L) {
                        xVar.a(oVar);
                        return 0;
                    }
                    if (xVar.f10725e) {
                        long j11 = xVar.g;
                        if (j11 == -9223372036854775807L) {
                            xVar.a(oVar);
                            return 0;
                        }
                        xVar.f10728i = yVar.c(xVar.f10727h) - yVar.b(j11);
                        xVar.a(oVar);
                        return 0;
                    }
                    int min = (int) Math.min(112800, oVar.c());
                    long j12 = 0;
                    if (oVar.getPosition() != j12) {
                        sVar.f6018a = j12;
                        return 1;
                    }
                    tVar.F(min);
                    oVar.h();
                    oVar.o(tVar.f8129a, 0, min);
                    int i16 = tVar.f8130b;
                    int i17 = tVar.f8131c;
                    while (true) {
                        if (i16 >= i17) {
                            break;
                        }
                        if (tVar.f8129a[i16] == 71) {
                            long t3 = com.bumptech.glide.e.t(tVar, i16, i15);
                            if (t3 != -9223372036854775807L) {
                                j10 = t3;
                                break;
                            }
                        }
                        i16++;
                    }
                    xVar.g = j10;
                    xVar.f10725e = true;
                    return 0;
                }
                long c11 = oVar.c();
                int min2 = (int) Math.min(112800, c11);
                long j13 = c11 - min2;
                if (oVar.getPosition() != j13) {
                    sVar.f6018a = j13;
                    return 1;
                }
                tVar.F(min2);
                oVar.h();
                oVar.o(tVar.f8129a, 0, min2);
                int i18 = tVar.f8130b;
                int i19 = tVar.f8131c;
                int i20 = i19 - 188;
                while (true) {
                    if (i20 < i18) {
                        break;
                    }
                    byte[] bArr = tVar.f8129a;
                    int i21 = -4;
                    int i22 = 0;
                    while (true) {
                        if (i21 > 4) {
                            break;
                        }
                        int i23 = (i21 * 188) + i20;
                        if (i23 < i18 || i23 >= i19 || bArr[i23] != 71) {
                            i22 = 0;
                        } else {
                            i22++;
                            if (i22 == 5) {
                                long t8 = com.bumptech.glide.e.t(tVar, i20, i15);
                                if (t8 != -9223372036854775807L) {
                                    j10 = t8;
                                    break;
                                }
                            }
                        }
                        i21++;
                    }
                    i20--;
                }
                xVar.f10727h = j10;
                xVar.f10726f = true;
                return 0;
            }
            if (this.f10470p) {
                i10 = 1;
                z10 = false;
                i11 = i14;
            } else {
                this.f10470p = true;
                long j14 = xVar.f10728i;
                if (j14 != -9223372036854775807L) {
                    i10 = 1;
                    z10 = false;
                    i11 = i14;
                    p2.a aVar = new p2.a(new v1(1), new j1(this.f10474t, xVar.f10722b), j14, 1 + j14, 0L, c10, 188L, 940);
                    this.f10466l = aVar;
                    this.f10467m.t(aVar.f9876a);
                } else {
                    i10 = 1;
                    z10 = false;
                    i11 = i14;
                    this.f10467m.t(new k2.r(j14));
                }
            }
            if (this.f10471q) {
                this.f10471q = z10;
                e(0L, 0L);
                if (oVar.getPosition() != 0) {
                    sVar.f6018a = 0L;
                    return i10;
                }
            }
            p2.a aVar2 = this.f10466l;
            if (aVar2 != null && aVar2.f9878c != null) {
                return aVar2.b(oVar, sVar);
            }
            oVar2 = oVar;
            r12 = z10;
        } else {
            oVar2 = oVar;
            r12 = 0;
            i10 = 1;
            i11 = i14;
        }
        l1.t tVar2 = this.f10459d;
        byte[] bArr2 = tVar2.f8129a;
        if (9400 - tVar2.f8130b < 188) {
            int a10 = tVar2.a();
            if (a10 > 0) {
                System.arraycopy(bArr2, tVar2.f8130b, bArr2, r12, a10);
            }
            tVar2.G(a10, bArr2);
        }
        while (true) {
            int a11 = tVar2.a();
            SparseArray sparseArray = this.f10462h;
            if (a11 >= 188) {
                int i24 = tVar2.f8130b;
                int i25 = tVar2.f8131c;
                byte[] bArr3 = tVar2.f8129a;
                int i26 = i24;
                while (i26 < i25 && bArr3[i26] != 71) {
                    i26++;
                }
                tVar2.I(i26);
                int i27 = i26 + 188;
                if (i27 > i25) {
                    int i28 = (i26 - i24) + this.f10473s;
                    this.f10473s = i28;
                    i12 = i11;
                    i13 = 2;
                    if (i12 == 2 && i28 > 376) {
                        throw h0.a(null, "Cannot find sync byte. Most likely not a Transport Stream.");
                    }
                } else {
                    i12 = i11;
                    i13 = 2;
                    this.f10473s = r12;
                }
                int i29 = tVar2.f8131c;
                if (i27 > i29) {
                    return r12;
                }
                int j15 = tVar2.j();
                if ((8388608 & j15) != 0) {
                    tVar2.I(i27);
                    return r12;
                }
                int i30 = (4194304 & j15) != 0 ? 1 : r12;
                int i31 = (2096896 & j15) >> 8;
                boolean z12 = (j15 & 32) != 0 ? true : r12;
                f0 f0Var = (j15 & 16) != 0 ? (f0) sparseArray.get(i31) : null;
                if (f0Var == null) {
                    tVar2.I(i27);
                    return r12;
                }
                if (i12 != i13) {
                    int i32 = j15 & 15;
                    SparseIntArray sparseIntArray = this.f10460e;
                    int i33 = sparseIntArray.get(i31, i32 - 1);
                    sparseIntArray.put(i31, i32);
                    if (i33 == i32) {
                        tVar2.I(i27);
                        return r12;
                    }
                    if (i32 != ((i33 + 1) & 15)) {
                        f0Var.a();
                    }
                }
                if (z12) {
                    int w10 = tVar2.w();
                    i30 |= (tVar2.w() & 64) != 0 ? i13 : r12;
                    tVar2.J(w10 - 1);
                }
                boolean z13 = this.f10469o;
                if (i12 == i13 || z13 || !this.f10464j.get(i31, r12)) {
                    tVar2.H(i27);
                    f0Var.b(i30, tVar2);
                    tVar2.H(i29);
                }
                if (i12 != i13 && !z13 && this.f10469o && c10 != -1) {
                    this.f10471q = true;
                }
                tVar2.I(i27);
                return r12;
            }
            int i34 = tVar2.f8131c;
            int read = oVar2.read(bArr2, i34, 9400 - i34);
            if (read == -1) {
                int i35 = r12;
                while (i35 < sparseArray.size()) {
                    f0 f0Var2 = (f0) sparseArray.valueAt(i35);
                    if (f0Var2 instanceof w) {
                        w wVar = (w) f0Var2;
                        int i36 = (!z11 || wVar.e()) ? i10 : r12;
                        if (wVar.f10712c == 3 && wVar.f10718j == -1 && ((!z11 || !(wVar.f10710a instanceof j)) && i36 != 0)) {
                            wVar.b(i10, new l1.t());
                        }
                    }
                    i35++;
                    i10 = 1;
                }
                return -1;
            }
            tVar2.H(i34 + read);
            i10 = 1;
        }
    }

    @Override // k2.n
    public final List g() {
        o9.e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        r2 = r2 + 1;
     */
    @Override // k2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(k2.o r7) {
        /*
            r6 = this;
            l1.t r0 = r6.f10459d
            byte[] r0 = r0.f8129a
            k2.k r7 = (k2.k) r7
            r1 = 0
            r2 = 940(0x3ac, float:1.317E-42)
            r7.m(r0, r1, r2, r1)
            r2 = r1
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r2 >= r3) goto L29
            r3 = r1
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r2
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r2 = r2 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.k(r2, r1)
            r7 = 1
            return r7
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.c0.m(k2.o):boolean");
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final k2.n b() {
        return this;
    }
}
