package m1;

import i1.g0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f8813a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f8814b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c, reason: collision with root package name */
    public static final Object f8815c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static int[] f8816d = new int[10];

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int b(byte[] bArr, int i10, int i11, boolean[] zArr) {
        int i12 = i11 - i10;
        l1.d.g(i12 >= 0);
        if (i12 == 0) {
            return i11;
        }
        if (zArr[0]) {
            a(zArr);
            return i10 - 3;
        }
        if (i12 > 1 && zArr[1] && bArr[i10] == 1) {
            a(zArr);
            return i10 - 2;
        }
        if (i12 > 2 && zArr[2] && bArr[i10] == 0 && bArr[i10 + 1] == 1) {
            a(zArr);
            return i10 - 1;
        }
        int i13 = i11 - 1;
        int i14 = i10 + 2;
        while (i14 < i13) {
            byte b2 = bArr[i14];
            if ((b2 & 254) == 0) {
                int i15 = i14 - 2;
                if (bArr[i15] == 0 && bArr[i14 - 1] == 0 && b2 == 1) {
                    a(zArr);
                    return i15;
                }
                i14 -= 2;
            }
            i14 += 3;
        }
        zArr[0] = i12 <= 2 ? !(i12 != 2 ? !(zArr[1] && bArr[i13] == 1) : !(zArr[2] && bArr[i11 + (-2)] == 0 && bArr[i13] == 1)) : bArr[i11 + (-3)] == 0 && bArr[i11 + (-2)] == 0 && bArr[i13] == 1;
        zArr[1] = i12 <= 1 ? zArr[2] && bArr[i13] == 0 : bArr[i11 + (-2)] == 0 && bArr[i13] == 0;
        zArr[2] = bArr[i13] == 0;
        return i11;
    }

    public static boolean c(byte[] bArr, int i10, i1.p pVar) {
        int i11;
        if (Objects.equals(pVar.f5991n, "video/avc")) {
            byte b2 = bArr[4];
            if (((b2 & 96) >> 5) == 0 && ((i11 = b2 & 31) == 1 || i11 == 9 || i11 == 14)) {
                return false;
            }
        } else if (Objects.equals(pVar.f5991n, "video/hevc")) {
            i2.j e7 = e(new i3.f(bArr, 4, i10 + 4));
            int i12 = e7.f6217a;
            if (i12 == 35) {
                return false;
            }
            if (i12 <= 14 && i12 % 2 == 0 && e7.f6219c == pVar.E - 1) {
                return false;
            }
        }
        return true;
    }

    public static int d(i1.p pVar) {
        if (Objects.equals(pVar.f5991n, "video/avc")) {
            return 1;
        }
        return (Objects.equals(pVar.f5991n, "video/hevc") || g0.b(pVar.f5988k, "video/hevc") != null) ? 2 : 0;
    }

    public static i2.j e(i3.f fVar) {
        fVar.s();
        return new i2.j(fVar.i(6), fVar.i(6), fVar.i(3) - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static m1.i f(i3.f r19, boolean r20, int r21, m1.i r22) {
        /*
            r0 = r19
            r1 = r21
            r2 = r22
            r3 = 6
            int[] r4 = new int[r3]
            r5 = 2
            r6 = 8
            r7 = 0
            if (r20 == 0) goto L42
            int r2 = r0.i(r5)
            boolean r8 = r0.h()
            r9 = 5
            int r9 = r0.i(r9)
            r10 = r7
            r11 = r10
        L1e:
            r12 = 32
            if (r10 >= r12) goto L2e
            boolean r12 = r0.h()
            if (r12 == 0) goto L2b
            r12 = 1
            int r12 = r12 << r10
            r11 = r11 | r12
        L2b:
            int r10 = r10 + 1
            goto L1e
        L2e:
            r10 = r7
        L2f:
            if (r10 >= r3) goto L3a
            int r12 = r0.i(r6)
            r4[r10] = r12
            int r10 = r10 + 1
            goto L2f
        L3a:
            r13 = r2
        L3b:
            r17 = r4
            r14 = r8
            r15 = r9
            r16 = r11
            goto L57
        L42:
            if (r2 == 0) goto L50
            int r3 = r2.f8767a
            boolean r8 = r2.f8768b
            int r9 = r2.f8769c
            int r11 = r2.f8770d
            int[] r4 = r2.f8771e
            r13 = r3
            goto L3b
        L50:
            r17 = r4
            r13 = r7
            r14 = r13
            r15 = r14
            r16 = r15
        L57:
            int r18 = r0.i(r6)
            r2 = r7
        L5c:
            if (r7 >= r1) goto L71
            boolean r3 = r0.h()
            if (r3 == 0) goto L66
            int r2 = r2 + 88
        L66:
            boolean r3 = r0.h()
            if (r3 == 0) goto L6e
            int r2 = r2 + 8
        L6e:
            int r7 = r7 + 1
            goto L5c
        L71:
            r0.t(r2)
            if (r1 <= 0) goto L7b
            int r6 = r6 - r1
            int r6 = r6 * r5
            r0.t(r6)
        L7b:
            m1.i r12 = new m1.i
            r12.<init>(r13, r14, r15, r16, r17, r18)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.o.f(i3.f, boolean, int, m1.i):m1.i");
    }

    public static androidx.leanback.widget.i g(byte[] bArr, int i10, int i11) {
        byte b2;
        int i12 = i10 + 2;
        do {
            i11--;
            b2 = bArr[i11];
            if (b2 != 0) {
                break;
            }
        } while (i11 > i12);
        if (b2 == 0 || i11 <= i12) {
            return null;
        }
        i3.f fVar = new i3.f(bArr, i12, i11 + 1);
        while (fVar.d(16)) {
            int i13 = fVar.i(8);
            int i14 = 0;
            while (i13 == 255) {
                i14 += 255;
                i13 = fVar.i(8);
            }
            int i15 = i14 + i13;
            int i16 = fVar.i(8);
            int i17 = 0;
            while (i16 == 255) {
                i17 += 255;
                i16 = fVar.i(8);
            }
            int i18 = i17 + i16;
            if (i18 == 0 || !fVar.d(i18)) {
                return null;
            }
            if (i15 == 176) {
                int m10 = fVar.m();
                boolean h10 = fVar.h();
                int m11 = h10 ? fVar.m() : 0;
                int m12 = fVar.m();
                int i19 = -1;
                for (int i20 = 0; i20 <= m12; i20++) {
                    i19 = fVar.m();
                    fVar.m();
                    int i21 = fVar.i(6);
                    if (i21 == 63) {
                        return null;
                    }
                    fVar.i(i21 == 0 ? Math.max(0, m10 - 30) : Math.max(0, (i21 + m10) - 31));
                    if (h10) {
                        int i22 = fVar.i(6);
                        if (i22 == 63) {
                            return null;
                        }
                        fVar.i(i22 == 0 ? Math.max(0, m11 - 30) : Math.max(0, (i22 + m11) - 31));
                    }
                    if (fVar.h()) {
                        fVar.t(10);
                    }
                }
                return new androidx.leanback.widget.i(i19);
            }
            fVar.t(i18 * 8);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static m1.k h(byte[] r32, int r33, int r34, x4.i r35) {
        /*
            Method dump skipped, instructions count: 1011
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.o.h(byte[], int, int, x4.i):m1.k");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static x4.i i(byte[] r40, int r41, int r42) {
        /*
            Method dump skipped, instructions count: 2150
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.o.i(byte[], int, int):x4.i");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static m1.n j(byte[] r30, int r31, int r32) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.o.j(byte[], int, int):m1.n");
    }

    public static void k(i3.f fVar) {
        int m10 = fVar.m() + 1;
        fVar.t(8);
        for (int i10 = 0; i10 < m10; i10++) {
            fVar.m();
            fVar.m();
            fVar.s();
        }
        fVar.t(20);
    }

    public static ArrayList l(ByteBuffer byteBuffer) {
        int remaining;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        ArrayList arrayList = new ArrayList();
        while (asReadOnlyBuffer.hasRemaining()) {
            byte b2 = asReadOnlyBuffer.get();
            int i10 = (b2 >> 3) & 15;
            if (((b2 >> 2) & 1) != 0) {
                asReadOnlyBuffer.get();
            }
            if (((b2 >> 1) & 1) != 0) {
                remaining = 0;
                for (int i11 = 0; i11 < 8; i11++) {
                    byte b10 = asReadOnlyBuffer.get();
                    remaining |= (b10 & Byte.MAX_VALUE) << (i11 * 7);
                    if ((b10 & 128) == 0) {
                        break;
                    }
                }
            } else {
                remaining = asReadOnlyBuffer.remaining();
            }
            ByteBuffer duplicate = asReadOnlyBuffer.duplicate();
            duplicate.limit(asReadOnlyBuffer.position() + remaining);
            arrayList.add(new q(i10, duplicate));
            asReadOnlyBuffer.position(asReadOnlyBuffer.position() + remaining);
        }
        return arrayList;
    }

    public static int m(int i10, byte[] bArr) {
        int i11;
        synchronized (f8815c) {
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10) {
                while (true) {
                    if (i12 >= i10 - 2) {
                        i12 = i10;
                        break;
                    }
                    try {
                        if (bArr[i12] == 0 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 3) {
                            break;
                        }
                        i12++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i12 < i10) {
                    int[] iArr = f8816d;
                    if (iArr.length <= i13) {
                        f8816d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    f8816d[i13] = i12;
                    i12 += 3;
                    i13++;
                }
            }
            i11 = i10 - i13;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < i13; i16++) {
                int i17 = f8816d[i16] - i15;
                System.arraycopy(bArr, i15, bArr, i14, i17);
                int i18 = i14 + i17;
                int i19 = i18 + 1;
                bArr[i18] = 0;
                i14 = i18 + 2;
                bArr[i19] = 0;
                i15 += i17 + 3;
            }
            System.arraycopy(bArr, i15, bArr, i14, i11 - i14);
        }
        return i11;
    }
}
