package rb;

import java.io.InputStream;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final i f10995a = new i();

    public static final boolean a(int i10, int i11, int i12, byte[] bArr, byte[] bArr2) {
        za.h.e("a", bArr);
        za.h.e("b", bArr2);
        for (int i13 = 0; i13 < i12; i13++) {
            if (bArr[i13 + i10] != bArr2[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static final l0 b(q0 q0Var) {
        za.h.e("<this>", q0Var);
        return new l0(q0Var);
    }

    public static final m0 c(s0 s0Var) {
        za.h.e("<this>", s0Var);
        return new m0(s0Var);
    }

    public static void d(long j10, l lVar, int i10, ArrayList arrayList, int i11, int i12, ArrayList arrayList2) {
        int i13;
        int i14;
        ArrayList arrayList3;
        long j11;
        int i15;
        int i16 = i10;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i11 >= i12) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i17 = i11; i17 < i12; i17++) {
            if (((o) arrayList4.get(i17)).d() < i16) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        o oVar = (o) arrayList.get(i11);
        o oVar2 = (o) arrayList4.get(i12 - 1);
        if (i16 == oVar.d()) {
            int intValue = ((Number) arrayList5.get(i11)).intValue();
            int i18 = i11 + 1;
            o oVar3 = (o) arrayList4.get(i18);
            i13 = i18;
            i14 = intValue;
            oVar = oVar3;
        } else {
            i13 = i11;
            i14 = -1;
        }
        if (oVar.i(i16) == oVar2.i(i16)) {
            int min = Math.min(oVar.d(), oVar2.d());
            int i19 = 0;
            for (int i20 = i16; i20 < min && oVar.i(i20) == oVar2.i(i20); i20++) {
                i19++;
            }
            long j12 = 4;
            long j13 = (lVar.f11035p / j12) + j10 + 2 + i19 + 1;
            lVar.a0(-i19);
            lVar.a0(i14);
            int i21 = i16 + i19;
            while (i16 < i21) {
                lVar.a0(oVar.i(i16) & 255);
                i16++;
            }
            if (i13 + 1 == i12) {
                if (i21 != ((o) arrayList4.get(i13)).d()) {
                    throw new IllegalStateException("Check failed.");
                }
                lVar.a0(((Number) arrayList5.get(i13)).intValue());
                return;
            } else {
                l lVar2 = new l();
                lVar.a0(((int) ((lVar2.f11035p / j12) + j13)) * (-1));
                d(j13, lVar2, i21, arrayList4, i13, i12, arrayList5);
                lVar.d(lVar2);
                return;
            }
        }
        int i22 = 1;
        for (int i23 = i13 + 1; i23 < i12; i23++) {
            if (((o) arrayList4.get(i23 - 1)).i(i16) != ((o) arrayList4.get(i23)).i(i16)) {
                i22++;
            }
        }
        long j14 = 4;
        long j15 = (lVar.f11035p / j14) + j10 + 2 + (i22 * 2);
        lVar.a0(i22);
        lVar.a0(i14);
        for (int i24 = i13; i24 < i12; i24++) {
            int i25 = ((o) arrayList4.get(i24)).i(i16);
            if (i24 == i13 || i25 != ((o) arrayList4.get(i24 - 1)).i(i16)) {
                lVar.a0(i25 & 255);
            }
        }
        l lVar3 = new l();
        int i26 = i13;
        while (i26 < i12) {
            byte i27 = ((o) arrayList4.get(i26)).i(i16);
            int i28 = i26 + 1;
            int i29 = i28;
            while (true) {
                if (i29 >= i12) {
                    i29 = i12;
                    break;
                } else if (i27 != ((o) arrayList4.get(i29)).i(i16)) {
                    break;
                } else {
                    i29++;
                }
            }
            if (i28 == i29 && i16 + 1 == ((o) arrayList4.get(i26)).d()) {
                lVar.a0(((Number) arrayList5.get(i26)).intValue());
                arrayList3 = arrayList5;
                j11 = j15;
                i15 = i29;
            } else {
                lVar.a0(((int) ((lVar3.f11035p / j14) + j15)) * (-1));
                arrayList3 = arrayList5;
                j11 = j15;
                i15 = i29;
                d(j11, lVar3, i16 + 1, arrayList, i26, i15, arrayList3);
                arrayList4 = arrayList;
            }
            j15 = j11;
            i26 = i15;
            arrayList5 = arrayList3;
        }
        lVar.d(lVar3);
    }

    public static final void e(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x012e, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static rb.h0 f(rb.o... r14) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.b.f(rb.o[]):rb.h0");
    }

    public static final int g(int i10) {
        return ((i10 & 255) << 24) | (((-16777216) & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    public static final f h(InputStream inputStream) {
        return new f(inputStream, new v0());
    }

    public static final String i(byte b2) {
        char[] cArr = sb.b.f11668a;
        return new String(new char[]{cArr[(b2 >> 4) & 15], cArr[b2 & 15]});
    }

    public static final String j(int i10) {
        if (i10 == 0) {
            return "0";
        }
        char[] cArr = sb.b.f11668a;
        int i11 = 0;
        char[] cArr2 = {cArr[(i10 >> 28) & 15], cArr[(i10 >> 24) & 15], cArr[(i10 >> 20) & 15], cArr[(i10 >> 16) & 15], cArr[(i10 >> 12) & 15], cArr[(i10 >> 8) & 15], cArr[(i10 >> 4) & 15], cArr[i10 & 15]};
        while (i11 < 8 && cArr2[i11] == '0') {
            i11++;
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.o("startIndex: ", i11, ", endIndex: 8, size: 8"));
        }
        if (i11 <= 8) {
            return new String(cArr2, i11, 8 - i11);
        }
        throw new IllegalArgumentException(android.support.v4.media.d.o("startIndex: ", i11, " > endIndex: 8"));
    }
}
