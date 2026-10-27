package okhttp3.internal;

import db.c;
import gb.h;
import gb.p;
import ma.i;
import okhttp3.internal.idn.IdnaMappingTableInstanceKt;
import okhttp3.internal.idn.Punycode;
import rb.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class _HostnamesCommonKt {
    private static final h VERIFY_AS_IP_ADDRESS = new h("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static final boolean canParseAsIpAddress(String str) {
        za.h.e("<this>", str);
        h hVar = VERIFY_AS_IP_ADDRESS;
        hVar.getClass();
        return hVar.f5467o.matcher(str).matches();
    }

    public static final byte[] canonicalizeInetAddress(byte[] bArr) {
        za.h.e("address", bArr);
        if (!isMappedIpv4Address(bArr)) {
            return bArr;
        }
        c y8 = k5.a.y(12, 16);
        za.h.e("indices", y8);
        return y8.isEmpty() ? new byte[0] : i.G(bArr, y8.f4350o, y8.f4351p + 1);
    }

    public static final boolean containsInvalidHostnameAsciiCodes(String str) {
        za.h.e("<this>", str);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (za.h.f(charAt, 31) <= 0 || za.h.f(charAt, 127) >= 0 || gb.i.e0(" #%/:?@[\\]", charAt, 0, 6) != -1) {
                return true;
            }
        }
        return false;
    }

    public static final boolean containsInvalidLabelLengths(String str) {
        za.h.e("<this>", str);
        int length = str.length();
        if (1 <= length && length < 254) {
            int i10 = 0;
            while (true) {
                int e02 = gb.i.e0(str, '.', i10, 4);
                int length2 = e02 == -1 ? str.length() - i10 : e02 - i10;
                if (1 > length2 || length2 >= 64) {
                    break;
                }
                if (e02 == -1 || e02 == str.length() - 1) {
                    break;
                }
                i10 = e02 + 1;
            }
            return false;
        }
        return true;
    }

    public static final boolean decodeIpv4Suffix(String str, int i10, int i11, byte[] bArr, int i12) {
        za.h.e("input", str);
        za.h.e("address", bArr);
        int i13 = i12;
        while (i10 < i11) {
            if (i13 == bArr.length) {
                return false;
            }
            if (i13 != i12) {
                if (str.charAt(i10) != '.') {
                    return false;
                }
                i10++;
            }
            int i14 = i10;
            int i15 = 0;
            while (i14 < i11) {
                char charAt = str.charAt(i14);
                if (za.h.f(charAt, 48) < 0 || za.h.f(charAt, 57) > 0) {
                    break;
                }
                if ((i15 == 0 && i10 != i14) || (i15 = ((i15 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i14++;
            }
            if (i14 - i10 == 0) {
                return false;
            }
            bArr[i13] = (byte) i15;
            i13++;
            i10 = i14;
        }
        return i13 == i12 + 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final byte[] decodeIpv6(java.lang.String r10, int r11, int r12) {
        /*
            java.lang.String r0 = "input"
            za.h.e(r0, r10)
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = r2
            r5 = r3
            r6 = r5
        Le:
            if (r11 >= r12) goto L7b
            if (r4 != r0) goto L14
            goto L7f
        L14:
            int r7 = r11 + 2
            if (r7 > r12) goto L2c
            java.lang.String r8 = "::"
            boolean r8 = gb.p.X(r11, r10, r8, r2)
            if (r8 == 0) goto L2c
            if (r5 == r3) goto L24
            goto L7f
        L24:
            int r4 = r4 + 2
            r5 = r4
            if (r7 != r12) goto L2a
            goto L7b
        L2a:
            r6 = r7
            goto L4e
        L2c:
            if (r4 == 0) goto L38
            java.lang.String r7 = ":"
            boolean r7 = gb.p.X(r11, r10, r7, r2)
            if (r7 == 0) goto L3a
            int r11 = r11 + 1
        L38:
            r6 = r11
            goto L4e
        L3a:
            java.lang.String r7 = "."
            boolean r11 = gb.p.X(r11, r10, r7, r2)
            if (r11 == 0) goto L7f
            int r11 = r4 + (-2)
            boolean r10 = decodeIpv4Suffix(r10, r6, r12, r1, r11)
            if (r10 != 0) goto L4b
            goto L7f
        L4b:
            int r4 = r4 + 2
            goto L7b
        L4e:
            r7 = r2
            r11 = r6
        L50:
            if (r11 >= r12) goto L62
            char r8 = r10.charAt(r11)
            int r8 = okhttp3.internal._UtilCommonKt.parseHexDigit(r8)
            if (r8 == r3) goto L62
            int r7 = r7 << 4
            int r7 = r7 + r8
            int r11 = r11 + 1
            goto L50
        L62:
            int r8 = r11 - r6
            if (r8 == 0) goto L7f
            r9 = 4
            if (r8 <= r9) goto L6a
            goto L7f
        L6a:
            int r8 = r4 + 1
            int r9 = r7 >>> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r1[r4] = r9
            int r4 = r4 + 2
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r1[r8] = r7
            goto Le
        L7b:
            if (r4 == r0) goto L8d
            if (r5 != r3) goto L81
        L7f:
            r10 = 0
            return r10
        L81:
            int r10 = r4 - r5
            int r10 = 16 - r10
            ma.i.C(r10, r5, r4, r1, r1)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._HostnamesCommonKt.decodeIpv6(java.lang.String, int, int):byte[]");
    }

    public static final String idnToAscii(String str) {
        za.h.e("host", str);
        l lVar = new l();
        lVar.e0(str);
        l lVar2 = new l();
        while (!lVar.t()) {
            if (!IdnaMappingTableInstanceKt.getIDNA_MAPPING_TABLE().map(lVar.T(), lVar2)) {
                return null;
            }
        }
        lVar.e0(_NormalizeJvmKt.normalizeNfc(lVar2.S()));
        Punycode punycode = Punycode.INSTANCE;
        String decode = punycode.decode(lVar.S());
        if (decode != null && decode.equals(_NormalizeJvmKt.normalizeNfc(decode))) {
            return punycode.encode(decode);
        }
        return null;
    }

    public static final String inet4AddressToAscii(byte[] bArr) {
        za.h.e("address", bArr);
        if (bArr.length != 4) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        l lVar = new l();
        lVar.Y(_UtilCommonKt.and(bArr[0], 255));
        lVar.X(46);
        lVar.Y(_UtilCommonKt.and(bArr[1], 255));
        lVar.X(46);
        lVar.Y(_UtilCommonKt.and(bArr[2], 255));
        lVar.X(46);
        lVar.Y(_UtilCommonKt.and(bArr[3], 255));
        return lVar.S();
    }

    public static final String inet6AddressToAscii(byte[] bArr) {
        za.h.e("address", bArr);
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < bArr.length) {
            int i14 = i12;
            while (i14 < 16 && bArr[i14] == 0 && bArr[i14 + 1] == 0) {
                i14 += 2;
            }
            int i15 = i14 - i12;
            if (i15 > i13 && i15 >= 4) {
                i10 = i12;
                i13 = i15;
            }
            i12 = i14 + 2;
        }
        l lVar = new l();
        while (i11 < bArr.length) {
            if (i11 == i10) {
                lVar.X(58);
                i11 += i13;
                if (i11 == 16) {
                    lVar.X(58);
                }
            } else {
                if (i11 > 0) {
                    lVar.X(58);
                }
                lVar.Z((_UtilCommonKt.and(bArr[i11], 255) << 8) | _UtilCommonKt.and(bArr[i11 + 1], 255));
                i11 += 2;
            }
        }
        return lVar.S();
    }

    private static final boolean isMappedIpv4Address(byte[] bArr) {
        if (bArr.length != 16) {
            return false;
        }
        for (int i10 = 0; i10 < 10; i10++) {
            if (bArr[i10] != 0) {
                return false;
            }
        }
        return bArr[10] == -1 && bArr[11] == -1;
    }

    public static final String toCanonicalHost(String str) {
        za.h.e("<this>", str);
        if (gb.i.b0(str, ":")) {
            byte[] decodeIpv6 = (p.Y(str, "[", false) && p.R(str, "]", false)) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
            if (decodeIpv6 != null) {
                byte[] canonicalizeInetAddress = canonicalizeInetAddress(decodeIpv6);
                if (canonicalizeInetAddress.length == 16) {
                    return inet6AddressToAscii(canonicalizeInetAddress);
                }
                if (canonicalizeInetAddress.length == 4) {
                    return inet4AddressToAscii(canonicalizeInetAddress);
                }
                throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
            }
        } else {
            String idnToAscii = idnToAscii(str);
            if (idnToAscii != null && idnToAscii.length() != 0 && !containsInvalidHostnameAsciiCodes(idnToAscii) && !containsInvalidLabelLengths(idnToAscii)) {
                return idnToAscii;
            }
        }
        return null;
    }
}
