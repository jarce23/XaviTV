package okhttp3.internal.idn;

import db.a;
import gb.i;
import gb.p;
import j9.w1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import rb.l;
import rb.o;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Punycode {
    private static final int BASE = 36;
    private static final int DAMP = 700;
    private static final int INITIAL_BIAS = 72;
    private static final int INITIAL_N = 128;
    private static final o PREFIX;
    private static final int SKEW = 38;
    private static final int TMAX = 26;
    private static final int TMIN = 1;
    public static final Punycode INSTANCE = new Punycode();
    private static final String PREFIX_STRING = "xn--";

    static {
        o oVar = o.f11048r;
        PREFIX = w1.F("xn--");
    }

    private Punycode() {
    }

    private final int adapt(int i10, int i11, boolean z10) {
        int i12 = z10 ? i10 / DAMP : i10 / 2;
        int i13 = (i12 / i11) + i12;
        int i14 = 0;
        while (i13 > 455) {
            i13 /= 35;
            i14 += BASE;
        }
        return ((i13 * BASE) / (i13 + SKEW)) + i14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [char] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    private final List<Integer> codePoints(String str, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        while (i10 < i11) {
            int charAt = str.charAt(i10);
            if (55296 <= charAt && charAt < 57344) {
                int i12 = i10 + 1;
                char charAt2 = i12 < i11 ? str.charAt(i12) : (char) 0;
                if (Character.isLowSurrogate(charAt) || !Character.isLowSurrogate(charAt2)) {
                    charAt = 63;
                } else {
                    charAt = 65536 + (((charAt & 1023) << 10) | (charAt2 & 1023));
                    i10 = i12;
                }
            }
            arrayList.add(Integer.valueOf(charAt));
            i10++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean decodeLabel(String str, int i10, int i11, l lVar) {
        int i12;
        int i13;
        int i14 = 1;
        if (!p.U(i10, 0, 4, str, PREFIX_STRING, true)) {
            lVar.f0(str, i10, i11);
            return true;
        }
        int i15 = i10 + 4;
        ArrayList arrayList = new ArrayList();
        int i02 = i.i0(str, '-', i11, 4);
        char c10 = '0';
        char c11 = '[';
        char c12 = '{';
        if (i02 >= i15) {
            while (i15 < i02) {
                int i16 = i15 + 1;
                char charAt = str.charAt(i15);
                if (('a' > charAt || charAt >= '{') && (('A' > charAt || charAt >= '[') && (('0' > charAt || charAt >= ':') && charAt != '-'))) {
                    return false;
                }
                arrayList.add(Integer.valueOf(charAt));
                i15 = i16;
            }
            i15++;
        }
        int i17 = 128;
        int i18 = INITIAL_BIAS;
        int i19 = 0;
        loop1: while (i15 < i11) {
            int i20 = i14;
            a x6 = k5.a.x(k5.a.y(BASE, Integer.MAX_VALUE), BASE);
            int i21 = x6.f4350o;
            int i22 = x6.f4351p;
            int i23 = x6.f4352q;
            if ((i23 > 0 && i21 <= i22) || (i23 < 0 && i22 <= i21)) {
                i12 = i19;
                int i24 = i20;
                while (i15 != i11) {
                    int i25 = i15 + 1;
                    char charAt2 = str.charAt(i15);
                    if ('a' <= charAt2 && charAt2 < c12) {
                        i13 = charAt2 - 'a';
                    } else if ('A' <= charAt2 && charAt2 < c11) {
                        i13 = charAt2 - 'A';
                    } else {
                        if (c10 > charAt2 || charAt2 >= ':') {
                            break loop1;
                        }
                        i13 = charAt2 - 22;
                    }
                    int i26 = i24;
                    int i27 = i13 * i26;
                    int i28 = i12;
                    if (i28 > Integer.MAX_VALUE - i27) {
                        break loop1;
                    }
                    i12 = i28 + i27;
                    int i29 = i21 <= i18 ? i20 : i21 >= i18 + TMAX ? TMAX : i21 - i18;
                    if (i13 >= i29) {
                        int i30 = 36 - i29;
                        if (i26 > Integer.MAX_VALUE / i30) {
                            break loop1;
                        }
                        i24 = i26 * i30;
                        if (i21 != i22) {
                            i21 += i23;
                            i15 = i25;
                            c10 = '0';
                            c11 = '[';
                            c12 = '{';
                        }
                    }
                    i15 = i25;
                }
                return false;
            }
            i12 = i19;
            i18 = adapt(i12 - i19, arrayList.size() + 1, i19 == 0 ? i20 : false);
            int size = i12 / (arrayList.size() + 1);
            if (i17 > Integer.MAX_VALUE - size) {
                return false;
            }
            i17 += size;
            int size2 = i12 % (arrayList.size() + 1);
            if (i17 > 1114111) {
                return false;
            }
            arrayList.add(size2, Integer.valueOf(i17));
            i19 = size2 + 1;
            i14 = i20;
            c10 = '0';
            c11 = '[';
            c12 = '{';
        }
        boolean z10 = i14;
        int size3 = arrayList.size();
        int i31 = 0;
        while (i31 < size3) {
            Object obj = arrayList.get(i31);
            i31++;
            lVar.g0(((Number) obj).intValue());
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean encodeLabel(String str, int i10, int i11, l lVar) {
        int i12;
        int i13;
        int i14;
        int i15 = 1;
        if (!requiresEncode(str, i10, i11)) {
            lVar.f0(str, i10, i11);
            return true;
        }
        lVar.W(PREFIX);
        List<Integer> codePoints = codePoints(str, i10, i11);
        Iterator<Integer> it = codePoints.iterator();
        int i16 = 0;
        while (true) {
            i12 = 128;
            if (!it.hasNext()) {
                break;
            }
            int intValue = it.next().intValue();
            if (intValue < 128) {
                lVar.X(intValue);
                i16++;
            }
        }
        if (i16 > 0) {
            lVar.X(45);
        }
        int i17 = INITIAL_BIAS;
        int i18 = 0;
        int i19 = i16;
        while (i19 < codePoints.size()) {
            Iterator<T> it2 = codePoints.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it2.next();
            if (it2.hasNext()) {
                int intValue2 = ((Number) next).intValue();
                if (intValue2 < i12) {
                    intValue2 = Integer.MAX_VALUE;
                }
                do {
                    Object next2 = it2.next();
                    int intValue3 = ((Number) next2).intValue();
                    if (intValue3 < i12) {
                        intValue3 = Integer.MAX_VALUE;
                    }
                    if (intValue2 > intValue3) {
                        next = next2;
                        intValue2 = intValue3;
                    }
                } while (it2.hasNext());
            }
            int intValue4 = ((Number) next).intValue();
            int i20 = (i19 + 1) * (intValue4 - i12);
            if (i18 <= Integer.MAX_VALUE - i20) {
                int i21 = i18 + i20;
                Iterator<Integer> it3 = codePoints.iterator();
                while (it3.hasNext()) {
                    int intValue5 = it3.next().intValue();
                    if (intValue5 < intValue4) {
                        if (i21 != Integer.MAX_VALUE) {
                            i21++;
                        }
                    } else if (intValue5 == intValue4) {
                        a x6 = k5.a.x(k5.a.y(BASE, Integer.MAX_VALUE), BASE);
                        int i22 = x6.f4350o;
                        int i23 = x6.f4351p;
                        int i24 = x6.f4352q;
                        if ((i24 > 0 && i22 <= i23) || (i24 < 0 && i23 <= i22)) {
                            i14 = i21;
                            while (true) {
                                if (i22 <= i17) {
                                    i13 = i15;
                                } else {
                                    i13 = i15;
                                    i15 = i22 >= i17 + TMAX ? TMAX : i22 - i17;
                                }
                                if (i14 < i15) {
                                    break;
                                }
                                int i25 = i14 - i15;
                                int i26 = 36 - i15;
                                lVar.X(getPunycodeDigit((i25 % i26) + i15));
                                i14 = i25 / i26;
                                if (i22 == i23) {
                                    break;
                                }
                                i22 += i24;
                                i15 = i13;
                            }
                        } else {
                            i13 = i15;
                            i14 = i21;
                        }
                        lVar.X(getPunycodeDigit(i14));
                        int i27 = i19 + 1;
                        i17 = adapt(i21, i27, i19 == i16 ? i13 : false);
                        i19 = i27;
                        i21 = 0;
                        i15 = i13;
                    }
                }
                i18 = i21 + 1;
                i12 = intValue4 + 1;
            }
            return false;
        }
        return i15;
    }

    private final int getPunycodeDigit(int i10) {
        if (i10 < TMAX) {
            return i10 + 97;
        }
        if (i10 < BASE) {
            return i10 + 22;
        }
        throw new IllegalStateException(("unexpected digit: " + i10).toString());
    }

    private final boolean requiresEncode(String str, int i10, int i11) {
        while (i10 < i11) {
            if (str.charAt(i10) >= 128) {
                return true;
            }
            i10++;
        }
        return false;
    }

    public final String decode(String str) {
        int e02;
        h.e("string", str);
        int length = str.length();
        l lVar = new l();
        for (int i10 = 0; i10 < length; i10 = e02 + 1) {
            e02 = i.e0(str, '.', i10, 4);
            if (e02 == -1) {
                e02 = length;
            }
            if (!decodeLabel(str, i10, e02, lVar)) {
                return null;
            }
            if (e02 >= length) {
                break;
            }
            lVar.X(46);
        }
        return lVar.S();
    }

    public final String encode(String str) {
        int e02;
        h.e("string", str);
        int length = str.length();
        l lVar = new l();
        for (int i10 = 0; i10 < length; i10 = e02 + 1) {
            e02 = i.e0(str, '.', i10, 4);
            if (e02 == -1) {
                e02 = length;
            }
            if (!encodeLabel(str, i10, e02, lVar)) {
                return null;
            }
            if (e02 >= length) {
                break;
            }
            lVar.X(46);
        }
        return lVar.S();
    }

    public final o getPREFIX() {
        return PREFIX;
    }

    public final String getPREFIX_STRING() {
        return PREFIX_STRING;
    }
}
