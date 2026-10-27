package k2;

import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final List f7783a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7784b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7785c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7786d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7787e;

    /* renamed from: f, reason: collision with root package name */
    public final int f7788f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final int f7789h;

    /* renamed from: i, reason: collision with root package name */
    public final int f7790i;

    /* renamed from: j, reason: collision with root package name */
    public final int f7791j;

    /* renamed from: k, reason: collision with root package name */
    public final int f7792k;

    /* renamed from: l, reason: collision with root package name */
    public final float f7793l;

    /* renamed from: m, reason: collision with root package name */
    public final int f7794m;

    /* renamed from: n, reason: collision with root package name */
    public final String f7795n;

    /* renamed from: o, reason: collision with root package name */
    public final x4.i f7796o;

    public v(List list, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, float f10, int i20, String str, x4.i iVar) {
        this.f7783a = list;
        this.f7784b = i10;
        this.f7785c = i11;
        this.f7786d = i12;
        this.f7787e = i13;
        this.f7788f = i14;
        this.g = i15;
        this.f7789h = i16;
        this.f7790i = i17;
        this.f7791j = i18;
        this.f7792k = i19;
        this.f7793l = f10;
        this.f7794m = i20;
        this.f7795n = str;
        this.f7796o = iVar;
    }

    public static v a(l1.t tVar, boolean z10, x4.i iVar) {
        boolean z11;
        androidx.leanback.widget.i g;
        int i10;
        int i11 = 4;
        try {
            if (z10) {
                tVar.J(4);
            } else {
                tVar.J(21);
            }
            int w10 = tVar.w() & 3;
            int w11 = tVar.w();
            int i12 = tVar.f8130b;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (true) {
                z11 = true;
                if (i14 >= w11) {
                    break;
                }
                tVar.J(1);
                int C = tVar.C();
                for (int i16 = 0; i16 < C; i16++) {
                    int C2 = tVar.C();
                    i15 += C2 + 4;
                    tVar.J(C2);
                }
                i14++;
            }
            tVar.I(i12);
            byte[] bArr = new byte[i15];
            x4.i iVar2 = iVar;
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            int i20 = -1;
            int i21 = -1;
            int i22 = -1;
            int i23 = -1;
            int i24 = -1;
            int i25 = -1;
            int i26 = -1;
            float f10 = 1.0f;
            String str = null;
            int i27 = 0;
            int i28 = 0;
            while (i27 < w11) {
                int w12 = tVar.w() & 63;
                int C3 = tVar.C();
                int i29 = i13;
                x4.i iVar3 = iVar2;
                while (i29 < C3) {
                    boolean z12 = z11;
                    int C4 = tVar.C();
                    int i30 = w10;
                    System.arraycopy(m1.o.f8813a, i13, bArr, i28, i11);
                    int i31 = i28 + 4;
                    System.arraycopy(tVar.f8129a, tVar.f8130b, bArr, i31, C4);
                    if (w12 == 32 && i29 == 0) {
                        iVar3 = m1.o.i(bArr, i31, i31 + C4);
                    } else {
                        if (w12 == 33 && i29 == 0) {
                            m1.k h10 = m1.o.h(bArr, i31, i31 + C4, iVar3);
                            i17 = h10.f8778a + 1;
                            i18 = h10.g;
                            int i32 = h10.f8784h;
                            i20 = h10.f8780c + 8;
                            i21 = h10.f8781d + 8;
                            int i33 = h10.f8787k;
                            i19 = i32;
                            int i34 = h10.f8788l;
                            int i35 = h10.f8789m;
                            float f11 = h10.f8785i;
                            int i36 = h10.f8786j;
                            m1.i iVar4 = h10.f8779b;
                            if (iVar4 != null) {
                                i10 = i36;
                                str = l1.e.a(iVar4.f8767a, iVar4.f8768b, iVar4.f8769c, iVar4.f8770d, iVar4.f8771e, iVar4.f8772f);
                            } else {
                                i10 = i36;
                            }
                            i26 = i10;
                            f10 = f11;
                            i24 = i35;
                            i23 = i34;
                            i22 = i33;
                        } else if (w12 == 39 && i29 == 0 && (g = m1.o.g(bArr, i31, i31 + C4)) != null && iVar3 != null) {
                            i13 = 0;
                            i25 = g.f1022o == ((m1.h) ((o9.g0) iVar3.f13553p).get(0)).f8766b ? 4 : 5;
                        }
                        i13 = 0;
                    }
                    i28 = i31 + C4;
                    tVar.J(C4);
                    i29++;
                    z11 = z12;
                    w10 = i30;
                    i11 = 4;
                }
                i27++;
                iVar2 = iVar3;
                i11 = 4;
            }
            return new v(i15 == 0 ? Collections.EMPTY_LIST : Collections.singletonList(bArr), w10 + 1, i17, i18, i19, i20, i21, i22, i23, i24, i25, f10, i26, str, iVar2);
        } catch (ArrayIndexOutOfBoundsException e7) {
            throw i1.h0.a(e7, "Error parsing".concat(z10 ? "L-HEVC config" : "HEVC config"));
        }
    }
}
