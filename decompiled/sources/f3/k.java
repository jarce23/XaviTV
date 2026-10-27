package f3;

import i1.f0;
import i1.h0;
import i1.o;
import i1.p;
import java.util.ArrayList;
import java.util.Arrays;
import k2.i0;
import k2.j0;
import k2.y;
import l1.t;
import o9.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends i {

    /* renamed from: n, reason: collision with root package name */
    public j f5011n;

    /* renamed from: o, reason: collision with root package name */
    public int f5012o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f5013p;

    /* renamed from: q, reason: collision with root package name */
    public y f5014q;

    /* renamed from: r, reason: collision with root package name */
    public i0 f5015r;

    @Override // f3.i
    public final void a(long j10) {
        this.g = j10;
        this.f5013p = j10 != 0;
        y yVar = this.f5014q;
        this.f5012o = yVar != null ? yVar.f7805e : 0;
    }

    @Override // f3.i
    public final long b(t tVar) {
        byte b2 = tVar.f8129a[0];
        if ((b2 & 1) == 1) {
            return -1L;
        }
        j jVar = this.f5011n;
        l1.d.h(jVar);
        int i10 = jVar.f5006o;
        y yVar = (y) jVar.f5007p;
        int i11 = !((j0[]) jVar.f5010s)[(b2 >> 1) & (255 >>> (8 - i10))].f7749b ? yVar.f7805e : yVar.f7806f;
        long j10 = this.f5013p ? (this.f5012o + i11) / 4 : 0;
        byte[] bArr = tVar.f8129a;
        int length = bArr.length;
        int i12 = tVar.f8131c + 4;
        if (length < i12) {
            byte[] copyOf = Arrays.copyOf(bArr, i12);
            tVar.G(copyOf.length, copyOf);
        } else {
            tVar.H(i12);
        }
        byte[] bArr2 = tVar.f8129a;
        int i13 = tVar.f8131c;
        bArr2[i13 - 4] = (byte) (j10 & 255);
        bArr2[i13 - 3] = (byte) ((j10 >>> 8) & 255);
        bArr2[i13 - 2] = (byte) ((j10 >>> 16) & 255);
        bArr2[i13 - 1] = (byte) ((j10 >>> 24) & 255);
        this.f5013p = true;
        this.f5012o = i11;
        return j10;
    }

    /* JADX WARN: Type inference failed for: r1v59, types: [byte[], java.io.Serializable] */
    @Override // f3.i
    public final boolean c(t tVar, long j10, x4.e eVar) {
        j jVar;
        int i10;
        int i11;
        if (this.f5011n != null) {
            ((p) eVar.f13542p).getClass();
            return false;
        }
        y yVar = this.f5014q;
        int i12 = 4;
        if (yVar == null) {
            k2.b.x(1, tVar, false);
            tVar.o();
            int w10 = tVar.w();
            int o2 = tVar.o();
            int l10 = tVar.l();
            if (l10 <= 0) {
                l10 = -1;
            }
            int l11 = tVar.l();
            int i13 = l11 <= 0 ? -1 : l11;
            tVar.l();
            int w11 = tVar.w();
            int pow = (int) Math.pow(2.0d, w11 & 15);
            int pow2 = (int) Math.pow(2.0d, (w11 & 240) >> 4);
            tVar.w();
            ?? copyOf = Arrays.copyOf(tVar.f8129a, tVar.f8131c);
            y yVar2 = new y();
            yVar2.f7801a = w10;
            yVar2.f7802b = o2;
            yVar2.f7803c = l10;
            yVar2.f7804d = i13;
            yVar2.f7805e = pow;
            yVar2.f7806f = pow2;
            yVar2.g = copyOf;
            this.f5014q = yVar2;
        } else {
            i0 i0Var = this.f5015r;
            if (i0Var == null) {
                this.f5015r = k2.b.v(tVar, true, true);
            } else {
                int i14 = tVar.f8131c;
                byte[] bArr = new byte[i14];
                System.arraycopy(tVar.f8129a, 0, bArr, 0, i14);
                int i15 = yVar.f7801a;
                int i16 = 5;
                k2.b.x(5, tVar, false);
                int w12 = tVar.w() + 1;
                i3.f fVar = new i3.f(tVar.f8129a);
                int i17 = 8;
                fVar.t(tVar.f8130b * 8);
                int i18 = 0;
                while (true) {
                    int i19 = 16;
                    if (i18 < w12) {
                        int i20 = i17;
                        if (fVar.i(24) != 5653314) {
                            throw h0.a(null, "expected code book to start with [0x56, 0x43, 0x42] at " + ((fVar.f6377d * 8) + fVar.f6378e));
                        }
                        int i21 = fVar.i(16);
                        int i22 = fVar.i(24);
                        if (fVar.h()) {
                            fVar.t(i16);
                            int i23 = 0;
                            while (i23 < i22) {
                                int i24 = 0;
                                for (int i25 = i22 - i23; i25 > 0; i25 >>>= 1) {
                                    i24++;
                                }
                                i23 += fVar.i(i24);
                            }
                        } else {
                            boolean h10 = fVar.h();
                            for (int i26 = 0; i26 < i22; i26++) {
                                if (!h10) {
                                    fVar.t(i16);
                                } else if (fVar.h()) {
                                    fVar.t(i16);
                                }
                            }
                        }
                        int i27 = fVar.i(4);
                        if (i27 > 2) {
                            throw h0.a(null, "lookup type greater than 2 not decodable: " + i27);
                        }
                        if (i27 == 1 || i27 == 2) {
                            fVar.t(32);
                            fVar.t(32);
                            int i28 = fVar.i(4) + 1;
                            fVar.t(1);
                            fVar.t((int) ((i27 == 1 ? i21 != 0 ? (long) Math.floor(Math.pow(i22, 1.0d / i21)) : 0L : i21 * i22) * i28));
                        }
                        i18++;
                        i17 = i20;
                        i16 = 5;
                    } else {
                        int i29 = i17;
                        int i30 = 6;
                        int i31 = fVar.i(6) + 1;
                        for (int i32 = 0; i32 < i31; i32++) {
                            if (fVar.i(16) != 0) {
                                throw h0.a(null, "placeholder of time domain transforms not zeroed out");
                            }
                        }
                        int i33 = 1;
                        int i34 = fVar.i(6) + 1;
                        int i35 = 0;
                        while (true) {
                            int i36 = 3;
                            if (i35 < i34) {
                                int i37 = fVar.i(i19);
                                if (i37 == 0) {
                                    int i38 = i29;
                                    fVar.t(i38);
                                    fVar.t(16);
                                    fVar.t(16);
                                    fVar.t(6);
                                    fVar.t(i38);
                                    int i39 = fVar.i(4) + 1;
                                    int i40 = 0;
                                    while (i40 < i39) {
                                        fVar.t(i38);
                                        i40++;
                                        i38 = 8;
                                    }
                                } else {
                                    if (i37 != i33) {
                                        throw h0.a(null, "floor type greater than 1 not decodable: " + i37);
                                    }
                                    int i41 = fVar.i(5);
                                    int[] iArr = new int[i41];
                                    int i42 = -1;
                                    for (int i43 = 0; i43 < i41; i43++) {
                                        int i44 = fVar.i(i12);
                                        iArr[i43] = i44;
                                        if (i44 > i42) {
                                            i42 = i44;
                                        }
                                    }
                                    int i45 = i42 + 1;
                                    int[] iArr2 = new int[i45];
                                    int i46 = 0;
                                    while (i46 < i45) {
                                        iArr2[i46] = fVar.i(i36) + 1;
                                        int i47 = fVar.i(2);
                                        int i48 = i29;
                                        if (i47 > 0) {
                                            fVar.t(i48);
                                        }
                                        int[] iArr3 = iArr2;
                                        int i49 = 0;
                                        for (int i50 = 1; i49 < (i50 << i47); i50 = 1) {
                                            fVar.t(i48);
                                            i49++;
                                            i48 = 8;
                                        }
                                        i46++;
                                        iArr2 = iArr3;
                                        i29 = 8;
                                        i36 = 3;
                                    }
                                    int[] iArr4 = iArr2;
                                    fVar.t(2);
                                    int i51 = fVar.i(4);
                                    int i52 = 0;
                                    int i53 = 0;
                                    for (int i54 = 0; i54 < i41; i54++) {
                                        i52 += iArr4[iArr[i54]];
                                        while (i53 < i52) {
                                            fVar.t(i51);
                                            i53++;
                                        }
                                    }
                                }
                                i35++;
                                i29 = 8;
                                i30 = 6;
                                i12 = 4;
                                i19 = 16;
                                i33 = 1;
                            } else {
                                int i55 = 1;
                                int i56 = fVar.i(i30) + 1;
                                int i57 = 0;
                                while (i57 < i56) {
                                    if (fVar.i(16) > 2) {
                                        throw h0.a(null, "residueType greater than 2 is not decodable");
                                    }
                                    fVar.t(24);
                                    fVar.t(24);
                                    fVar.t(24);
                                    int i58 = fVar.i(i30) + i55;
                                    int i59 = 8;
                                    fVar.t(8);
                                    int[] iArr5 = new int[i58];
                                    for (int i60 = 0; i60 < i58; i60++) {
                                        iArr5[i60] = ((fVar.h() ? fVar.i(5) : 0) * 8) + fVar.i(3);
                                    }
                                    int i61 = 0;
                                    while (i61 < i58) {
                                        int i62 = 0;
                                        while (i62 < i59) {
                                            if ((iArr5[i61] & (1 << i62)) != 0) {
                                                fVar.t(i59);
                                            }
                                            i62++;
                                            i59 = 8;
                                        }
                                        i61++;
                                        i59 = 8;
                                    }
                                    i57++;
                                    i30 = 6;
                                    i55 = 1;
                                }
                                int i63 = fVar.i(i30) + 1;
                                for (int i64 = 0; i64 < i63; i64++) {
                                    int i65 = fVar.i(16);
                                    if (i65 != 0) {
                                        l1.b.g("VorbisUtil", "mapping type other than 0 not supported: " + i65);
                                    } else {
                                        if (fVar.h()) {
                                            i10 = 1;
                                            i11 = fVar.i(4) + 1;
                                        } else {
                                            i10 = 1;
                                            i11 = 1;
                                        }
                                        if (fVar.h()) {
                                            int i66 = fVar.i(8) + i10;
                                            for (int i67 = 0; i67 < i66; i67++) {
                                                int i68 = i15 - 1;
                                                int i69 = 0;
                                                for (int i70 = i68; i70 > 0; i70 >>>= 1) {
                                                    i69++;
                                                }
                                                fVar.t(i69);
                                                int i71 = 0;
                                                while (i68 > 0) {
                                                    i71++;
                                                    i68 >>>= 1;
                                                }
                                                fVar.t(i71);
                                            }
                                        }
                                        if (fVar.i(2) != 0) {
                                            throw h0.a(null, "to reserved bits must be zero after mapping coupling steps");
                                        }
                                        if (i11 > 1) {
                                            for (int i72 = 0; i72 < i15; i72++) {
                                                fVar.t(4);
                                            }
                                        }
                                        for (int i73 = 0; i73 < i11; i73++) {
                                            fVar.t(8);
                                            fVar.t(8);
                                            fVar.t(8);
                                        }
                                    }
                                }
                                int i74 = fVar.i(6);
                                int i75 = i74 + 1;
                                j0[] j0VarArr = new j0[i75];
                                for (int i76 = 0; i76 < i75; i76++) {
                                    boolean h11 = fVar.h();
                                    fVar.i(16);
                                    fVar.i(16);
                                    fVar.i(8);
                                    j0VarArr[i76] = new j0(h11);
                                }
                                if (!fVar.h()) {
                                    throw h0.a(null, "framing bit after modes not set as expected");
                                }
                                int i77 = 0;
                                while (i74 > 0) {
                                    i77++;
                                    i74 >>>= 1;
                                }
                                jVar = new j();
                                jVar.f5007p = yVar;
                                jVar.f5008q = i0Var;
                                jVar.f5009r = bArr;
                                jVar.f5010s = j0VarArr;
                                jVar.f5006o = i77;
                            }
                        }
                    }
                }
            }
        }
        jVar = null;
        this.f5011n = jVar;
        if (jVar == null) {
            return true;
        }
        y yVar3 = (y) jVar.f5007p;
        ArrayList arrayList = new ArrayList();
        arrayList.add((byte[]) yVar3.g);
        arrayList.add((byte[]) jVar.f5009r);
        f0 r2 = k2.b.r(g0.o(((i0) jVar.f5008q).f7741p));
        o oVar = new o();
        oVar.f5939l = i1.g0.m("audio/ogg");
        oVar.f5940m = i1.g0.m("audio/vorbis");
        oVar.f5935h = yVar3.f7804d;
        oVar.f5936i = yVar3.f7803c;
        oVar.E = yVar3.f7801a;
        oVar.F = yVar3.f7802b;
        oVar.f5943p = arrayList;
        oVar.f5938k = r2;
        eVar.f13542p = new p(oVar);
        return true;
    }

    @Override // f3.i
    public final void d(boolean z10) {
        super.d(z10);
        if (z10) {
            this.f5011n = null;
            this.f5014q = null;
            this.f5015r = null;
        }
        this.f5012o = 0;
        this.f5013p = false;
    }
}
