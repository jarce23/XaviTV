package sb;

import rb.n0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f11666a;

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f11667b;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(gb.a.f5445a);
        za.h.d("getBytes(...)", bytes);
        f11666a = bytes;
        f11667b = new long[]{-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L, 9999999999999999L, 99999999999999999L, 999999999999999999L, Long.MAX_VALUE};
    }

    public static final long a(rb.l lVar, rb.o oVar, long j10, long j11, int i10) {
        n0 n0Var;
        byte[] bArr;
        long j12 = j10;
        long j13 = j11;
        za.h.e("bytes", oVar);
        long j14 = i10;
        rb.b.e(oVar.d(), 0, j14);
        if (i10 <= 0) {
            throw new IllegalArgumentException("byteCount == 0");
        }
        long j15 = 0;
        if (j12 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j12, "fromIndex < 0: ").toString());
        }
        if (j12 > j13) {
            throw new IllegalArgumentException(("fromIndex > toIndex: " + j12 + " > " + j13).toString());
        }
        long j16 = lVar.f11035p;
        if (j13 > j16) {
            j13 = j16;
        }
        if (j12 == j13 || (n0Var = lVar.f11034o) == null) {
            return -1L;
        }
        if (j16 - j12 >= j12) {
            while (true) {
                long j17 = (n0Var.f11044c - n0Var.f11043b) + j15;
                if (j17 > j12) {
                    break;
                }
                n0Var = n0Var.f11047f;
                za.h.b(n0Var);
                j15 = j17;
            }
            byte[] h10 = oVar.h();
            byte b2 = h10[0];
            long min = Math.min(j13, (lVar.f11035p - j14) + 1);
            while (j15 < min) {
                byte[] bArr2 = n0Var.f11042a;
                int min2 = (int) Math.min(n0Var.f11044c, (n0Var.f11043b + min) - j15);
                for (int i11 = (int) ((n0Var.f11043b + j12) - j15); i11 < min2; i11++) {
                    if (bArr2[i11] == b2 && b(n0Var, i11 + 1, h10, 1, i10)) {
                        return (i11 - n0Var.f11043b) + j15;
                    }
                }
                j15 += n0Var.f11044c - n0Var.f11043b;
                n0Var = n0Var.f11047f;
                za.h.b(n0Var);
                j12 = j15;
            }
            return -1L;
        }
        while (j16 > j12) {
            n0Var = n0Var.g;
            za.h.b(n0Var);
            j16 -= n0Var.f11044c - n0Var.f11043b;
        }
        byte[] h11 = oVar.h();
        byte b10 = h11[0];
        byte[] bArr3 = h11;
        long min3 = Math.min(j13, (lVar.f11035p - j14) + 1);
        while (j16 < min3) {
            byte[] bArr4 = n0Var.f11042a;
            int min4 = (int) Math.min(n0Var.f11044c, (n0Var.f11043b + min3) - j16);
            int i12 = (int) ((n0Var.f11043b + j12) - j16);
            while (i12 < min4) {
                if (bArr4[i12] == b10) {
                    bArr = bArr3;
                    if (b(n0Var, i12 + 1, bArr, 1, i10)) {
                        return (i12 - n0Var.f11043b) + j16;
                    }
                } else {
                    bArr = bArr3;
                }
                i12++;
                bArr3 = bArr;
            }
            j16 += n0Var.f11044c - n0Var.f11043b;
            n0Var = n0Var.f11047f;
            za.h.b(n0Var);
            j12 = j16;
        }
        return -1L;
    }

    public static final boolean b(n0 n0Var, int i10, byte[] bArr, int i11, int i12) {
        int i13 = n0Var.f11044c;
        byte[] bArr2 = n0Var.f11042a;
        while (i11 < i12) {
            if (i10 == i13) {
                n0Var = n0Var.f11047f;
                za.h.b(n0Var);
                byte[] bArr3 = n0Var.f11042a;
                bArr2 = bArr3;
                i10 = n0Var.f11043b;
                i13 = n0Var.f11044c;
            }
            if (bArr2[i10] != bArr[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public static final String c(rb.l lVar, long j10) {
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (lVar.x(j11) == 13) {
                String R = lVar.R(j11, gb.a.f5445a);
                lVar.skip(2L);
                return R;
            }
        }
        String R2 = lVar.R(j10, gb.a.f5445a);
        lVar.skip(1L);
        return R2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
    
        if (r18 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005e, code lost:
    
        return -2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int d(rb.l r16, rb.h0 r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 173
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sb.a.d(rb.l, rb.h0, boolean):int");
    }
}
