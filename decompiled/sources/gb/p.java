package gb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class p extends o {
    public static boolean R(String str, String str2, boolean z10) {
        za.h.e("<this>", str);
        za.h.e("suffix", str2);
        return !z10 ? str.endsWith(str2) : U(str.length() - str2.length(), 0, str2.length(), str, str2, true);
    }

    public static boolean S(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static void T() {
        za.h.d("CASE_INSENSITIVE_ORDER", String.CASE_INSENSITIVE_ORDER);
    }

    public static boolean U(int i10, int i11, int i12, String str, String str2, boolean z10) {
        za.h.e("<this>", str);
        za.h.e("other", str2);
        return !z10 ? str.regionMatches(i10, str2, i11, i12) : str.regionMatches(z10, i10, str2, i11, i12);
    }

    public static String V(String str, char c10, char c11) {
        za.h.e("<this>", str);
        String replace = str.replace(c10, c11);
        za.h.d("replace(...)", replace);
        return replace;
    }

    public static String W(String str, String str2, String str3) {
        za.h.e("<this>", str);
        int d02 = i.d0(str, str2, 0, false);
        if (d02 < 0) {
            return str;
        }
        int length = str2.length();
        int i10 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        int i11 = 0;
        do {
            sb2.append((CharSequence) str, i11, d02);
            sb2.append(str3);
            i11 = d02 + length;
            if (d02 >= str.length()) {
                break;
            }
            d02 = i.d0(str, str2, d02 + i10, false);
        } while (d02 > 0);
        sb2.append((CharSequence) str, i11, str.length());
        String sb3 = sb2.toString();
        za.h.d("toString(...)", sb3);
        return sb3;
    }

    public static boolean X(int i10, String str, String str2, boolean z10) {
        za.h.e("<this>", str);
        return !z10 ? str.startsWith(str2, i10) : U(i10, 0, str2.length(), str, str2, z10);
    }

    public static boolean Y(String str, String str2, boolean z10) {
        za.h.e("<this>", str);
        za.h.e("prefix", str2);
        return !z10 ? str.startsWith(str2) : U(0, 0, str2.length(), str, str2, z10);
    }

    public static Integer Z(String str) {
        boolean z10;
        int i10;
        int i11;
        com.bumptech.glide.c.h(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char charAt = str.charAt(0);
        int i13 = -2147483647;
        if (za.h.f(charAt, 48) < 0) {
            i10 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z10 = false;
            } else {
                if (charAt != '-') {
                    return null;
                }
                i13 = Integer.MIN_VALUE;
                z10 = true;
            }
        } else {
            z10 = false;
            i10 = 0;
        }
        int i14 = -59652323;
        while (i10 < length) {
            int digit = Character.digit((int) str.charAt(i10), 10);
            if (digit < 0) {
                return null;
            }
            if ((i12 < i14 && (i14 != -59652323 || i12 < (i14 = i13 / 10))) || (i11 = i12 * 10) < i13 + digit) {
                return null;
            }
            i12 = i11 - digit;
            i10++;
        }
        return z10 ? Integer.valueOf(i12) : Integer.valueOf(-i12);
    }
}
