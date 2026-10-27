package y2;

import i1.f0;
import i1.g0;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import l1.a0;
import l1.t;
import o9.d0;
import o9.w0;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends com.bumptech.glide.d {

    /* renamed from: e, reason: collision with root package name */
    public static final t1.k f13789e = new t1.k(8);

    /* renamed from: d, reason: collision with root package name */
    public final g f13790d;

    public i(g gVar) {
        this.f13790d = gVar;
    }

    public static a R(t tVar, int i10, int i11) {
        int j02;
        String concat;
        int w10 = tVar.w();
        Charset g02 = g0(w10);
        int i12 = i10 - 1;
        byte[] bArr = new byte[i12];
        tVar.h(bArr, 0, i12);
        if (i11 == 2) {
            concat = "image/" + com.bumptech.glide.c.C(new String(bArr, 0, 3, StandardCharsets.ISO_8859_1));
            if ("image/jpg".equals(concat)) {
                concat = "image/jpeg";
            }
            j02 = 2;
        } else {
            j02 = j0(0, bArr);
            String C = com.bumptech.glide.c.C(new String(bArr, 0, j02, StandardCharsets.ISO_8859_1));
            concat = C.indexOf(47) == -1 ? "image/".concat(C) : C;
        }
        int i13 = bArr[j02 + 1] & 255;
        int i14 = j02 + 2;
        int i02 = i0(bArr, i14, w10);
        String str = new String(bArr, i14, i02 - i14, g02);
        int f02 = f0(w10) + i02;
        return new a(concat, str, i13, i12 <= f02 ? a0.f8069c : Arrays.copyOfRange(bArr, f02, i12));
    }

    public static c S(t tVar, int i10, int i11, boolean z10, int i12, g gVar) {
        int i13 = tVar.f8130b;
        int j02 = j0(i13, tVar.f8129a);
        String str = new String(tVar.f8129a, i13, j02 - i13, StandardCharsets.ISO_8859_1);
        tVar.I(j02 + 1);
        int j10 = tVar.j();
        int j11 = tVar.j();
        long y8 = tVar.y();
        if (y8 == 4294967295L) {
            y8 = -1;
        }
        long y10 = tVar.y();
        long j12 = y10 == 4294967295L ? -1L : y10;
        ArrayList arrayList = new ArrayList();
        int i14 = i13 + i10;
        while (tVar.f8130b < i14) {
            j V = V(i11, tVar, z10, i12, gVar);
            if (V != null) {
                arrayList.add(V);
            }
        }
        return new c(str, j10, j11, y8, j12, (j[]) arrayList.toArray(new j[0]));
    }

    public static d T(t tVar, int i10, int i11, boolean z10, int i12, g gVar) {
        int i13 = tVar.f8130b;
        int j02 = j0(i13, tVar.f8129a);
        String str = new String(tVar.f8129a, i13, j02 - i13, StandardCharsets.ISO_8859_1);
        tVar.I(j02 + 1);
        int w10 = tVar.w();
        boolean z11 = (w10 & 2) != 0;
        boolean z12 = (w10 & 1) != 0;
        int w11 = tVar.w();
        String[] strArr = new String[w11];
        for (int i14 = 0; i14 < w11; i14++) {
            int i15 = tVar.f8130b;
            int j03 = j0(i15, tVar.f8129a);
            strArr[i14] = new String(tVar.f8129a, i15, j03 - i15, StandardCharsets.ISO_8859_1);
            tVar.I(j03 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i16 = i13 + i10;
        while (tVar.f8130b < i16) {
            j V = V(i11, tVar, z10, i12, gVar);
            if (V != null) {
                arrayList.add(V);
            }
        }
        return new d(str, z11, z12, strArr, (j[]) arrayList.toArray(new j[0]));
    }

    public static e U(int i10, t tVar) {
        if (i10 < 4) {
            return null;
        }
        int w10 = tVar.w();
        Charset g02 = g0(w10);
        byte[] bArr = new byte[3];
        tVar.h(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i11 = i10 - 4;
        byte[] bArr2 = new byte[i11];
        tVar.h(bArr2, 0, i11);
        int i02 = i0(bArr2, 0, w10);
        String str2 = new String(bArr2, 0, i02, g02);
        int f02 = f0(w10) + i02;
        return new e(str, str2, Z(bArr2, f02, i0(bArr2, f02, w10), g02));
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x01b2, code lost:
    
        if (r5 == 67) goto L142;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0251  */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [y2.j] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28, types: [l1.t] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static y2.j V(int r19, l1.t r20, boolean r21, int r22, y2.g r23) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.i.V(int, l1.t, boolean, int, y2.g):y2.j");
    }

    public static f W(int i10, t tVar) {
        int w10 = tVar.w();
        Charset g02 = g0(w10);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        tVar.h(bArr, 0, i11);
        int j02 = j0(0, bArr);
        String m10 = g0.m(new String(bArr, 0, j02, StandardCharsets.ISO_8859_1));
        int i12 = j02 + 1;
        int i02 = i0(bArr, i12, w10);
        String Z = Z(bArr, i12, i02, g02);
        int f02 = f0(w10) + i02;
        int i03 = i0(bArr, f02, w10);
        String Z2 = Z(bArr, f02, i03, g02);
        int f03 = f0(w10) + i03;
        return new f(m10, Z, Z2, i11 <= f03 ? a0.f8069c : Arrays.copyOfRange(bArr, f03, i11));
    }

    public static m X(int i10, t tVar) {
        int C = tVar.C();
        int z10 = tVar.z();
        int z11 = tVar.z();
        int w10 = tVar.w();
        int w11 = tVar.w();
        i3.f fVar = new i3.f();
        fVar.p(tVar);
        int i11 = ((i10 - 10) * 8) / (w10 + w11);
        int[] iArr = new int[i11];
        int[] iArr2 = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = fVar.i(w10);
            int i14 = fVar.i(w11);
            iArr[i12] = i13;
            iArr2[i12] = i14;
        }
        return new m(C, z10, z11, iArr, iArr2);
    }

    public static n Y(int i10, t tVar) {
        byte[] bArr = new byte[i10];
        tVar.h(bArr, 0, i10);
        int j02 = j0(0, bArr);
        String str = new String(bArr, 0, j02, StandardCharsets.ISO_8859_1);
        int i11 = j02 + 1;
        return new n(str, i10 <= i11 ? a0.f8069c : Arrays.copyOfRange(bArr, i11, i10));
    }

    public static String Z(byte[] bArr, int i10, int i11, Charset charset) {
        return (i11 <= i10 || i11 > bArr.length) ? _UrlKt.FRAGMENT_ENCODE_SET : new String(bArr, i10, i11 - i10, charset);
    }

    public static o a0(int i10, String str, t tVar) {
        if (i10 < 1) {
            return null;
        }
        int w10 = tVar.w();
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        tVar.h(bArr, 0, i11);
        return new o(str, null, b0(bArr, w10, 0));
    }

    public static w0 b0(byte[] bArr, int i10, int i11) {
        if (i11 >= bArr.length) {
            return o9.g0.r(_UrlKt.FRAGMENT_ENCODE_SET);
        }
        d0 m10 = o9.g0.m();
        int i02 = i0(bArr, i11, i10);
        while (i11 < i02) {
            m10.a(new String(bArr, i11, i02 - i11, g0(i10)));
            i11 = f0(i10) + i02;
            i02 = i0(bArr, i11, i10);
        }
        w0 f10 = m10.f();
        return f10.isEmpty() ? o9.g0.r(_UrlKt.FRAGMENT_ENCODE_SET) : f10;
    }

    public static o c0(int i10, t tVar) {
        if (i10 < 1) {
            return null;
        }
        int w10 = tVar.w();
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        tVar.h(bArr, 0, i11);
        int i02 = i0(bArr, 0, w10);
        return new o("TXXX", new String(bArr, 0, i02, g0(w10)), b0(bArr, w10, f0(w10) + i02));
    }

    public static p d0(int i10, String str, t tVar) {
        byte[] bArr = new byte[i10];
        tVar.h(bArr, 0, i10);
        return new p(str, null, new String(bArr, 0, j0(0, bArr), StandardCharsets.ISO_8859_1));
    }

    public static p e0(int i10, t tVar) {
        if (i10 < 1) {
            return null;
        }
        int w10 = tVar.w();
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        tVar.h(bArr, 0, i11);
        int i02 = i0(bArr, 0, w10);
        String str = new String(bArr, 0, i02, g0(w10));
        int f02 = f0(w10) + i02;
        return new p("WXXX", str, Z(bArr, f02, j0(f02, bArr), StandardCharsets.ISO_8859_1));
    }

    public static int f0(int i10) {
        return (i10 == 0 || i10 == 3) ? 1 : 2;
    }

    public static Charset g0(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8 : StandardCharsets.UTF_16BE : StandardCharsets.UTF_16;
    }

    public static String h0(int i10, int i11, int i12, int i13, int i14) {
        return i10 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14));
    }

    public static int i0(byte[] bArr, int i10, int i11) {
        int j02 = j0(i10, bArr);
        if (i11 == 0 || i11 == 3) {
            return j02;
        }
        while (j02 < bArr.length - 1) {
            if ((j02 - i10) % 2 == 0 && bArr[j02 + 1] == 0) {
                return j02;
            }
            j02 = j0(j02 + 1, bArr);
        }
        return bArr.length;
    }

    public static int j0(int i10, byte[] bArr) {
        while (i10 < bArr.length) {
            if (bArr[i10] == 0) {
                return i10;
            }
            i10++;
        }
        return bArr.length;
    }

    public static int k0(int i10, t tVar) {
        byte[] bArr = tVar.f8129a;
        int i11 = tVar.f8130b;
        int i12 = i11;
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= i11 + i10) {
                return i10;
            }
            if ((bArr[i12] & 255) == 255 && bArr[i13] == 0) {
                System.arraycopy(bArr, i12 + 2, bArr, i13, (i10 - (i12 - i11)) - 2);
                i10--;
            }
            i12 = i13;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
    
        if ((r10 & 1) != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0087, code lost:
    
        if ((r10 & 128) != 0) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean l0(l1.t r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.f8130b
        L6:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L20
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lac
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L23
            int r7 = r1.j()     // Catch: java.lang.Throwable -> L20
            long r8 = r1.y()     // Catch: java.lang.Throwable -> L20
            int r10 = r1.C()     // Catch: java.lang.Throwable -> L20
            goto L2d
        L20:
            r0 = move-exception
            goto Lb0
        L23:
            int r7 = r1.z()     // Catch: java.lang.Throwable -> L20
            int r8 = r1.z()     // Catch: java.lang.Throwable -> L20
            long r8 = (long) r8
            r10 = r6
        L2d:
            r11 = 0
            if (r7 != 0) goto L3b
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3b
            if (r10 != 0) goto L3b
            r1.I(r2)
            return r4
        L3b:
            r7 = 4
            if (r0 != r7) goto L6c
            if (r21 != 0) goto L6c
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4c
            r1.I(r2)
            return r6
        L4c:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6c:
            if (r0 != r7) goto L7c
            r3 = r10 & 64
            if (r3 == 0) goto L74
            r3 = r4
            goto L75
        L74:
            r3 = r6
        L75:
            r7 = r10 & 1
            if (r7 == 0) goto L7a
            goto L8c
        L7a:
            r4 = r6
            goto L8c
        L7c:
            if (r0 != r3) goto L8a
            r3 = r10 & 32
            if (r3 == 0) goto L84
            r3 = r4
            goto L85
        L84:
            r3 = r6
        L85:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L7a
            goto L8c
        L8a:
            r3 = r6
            r4 = r3
        L8c:
            if (r4 == 0) goto L90
            int r3 = r3 + 4
        L90:
            long r3 = (long) r3
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L99
            r1.I(r2)
            return r6
        L99:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L20
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto La6
            r1.I(r2)
            return r6
        La6:
            int r3 = (int) r8
            r1.J(r3)     // Catch: java.lang.Throwable -> L20
            goto L6
        Lac:
            r1.I(r2)
            return r4
        Lb0:
            r1.I(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.i.l0(l1.t, int, int, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final i1.f0 Q(int r13, byte[] r14) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.i.Q(int, byte[]):i1.f0");
    }

    @Override // com.bumptech.glide.d
    public final f0 j(t2.a aVar, ByteBuffer byteBuffer) {
        return Q(byteBuffer.limit(), byteBuffer.array());
    }
}
