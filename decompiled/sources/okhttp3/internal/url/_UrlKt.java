package okhttp3.internal.url;

import gb.a;
import gb.i;
import java.nio.charset.Charset;
import okhttp3.internal._UtilCommonKt;
import rb.l;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class _UrlKt {
    public static final String FORM_ENCODE_SET = " !\"#$&'()+,/:;<=>?@[\\]^`{|}~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    public static final String canonicalize(String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13) {
        h.e("<this>", str);
        h.e("encodeSet", str2);
        return canonicalizeWithCharset$default(str, i10, i11, str2, z10, z11, z12, z13, null, 128, null);
    }

    public static /* synthetic */ String canonicalize$default(String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 8) != 0) {
            z10 = false;
        }
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        if ((i12 & 32) != 0) {
            z12 = false;
        }
        if ((i12 & 64) != 0) {
            z13 = false;
        }
        return canonicalize(str, i10, i11, str2, z10, z11, z12, z13);
    }

    public static final String canonicalizeWithCharset(String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        h.e("<this>", str);
        h.e("encodeSet", str2);
        int i12 = i10;
        while (i12 < i11) {
            int codePointAt = str.codePointAt(i12);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && !z13) || i.a0(str2, (char) codePointAt) || ((codePointAt == 37 && (!z10 || (z11 && !isPercentEncoded(str, i12, i11)))) || (codePointAt == 43 && z12)))) {
                l lVar = new l();
                lVar.f0(str, i10, i12);
                writeCanonicalized(lVar, str, i12, i11, str2, z10, z11, z12, z13, charset);
                return lVar.S();
            }
            i12 += Character.charCount(codePointAt);
        }
        String substring = str.substring(i10, i11);
        h.d("substring(...)", substring);
        return substring;
    }

    public static /* synthetic */ String canonicalizeWithCharset$default(String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 8) != 0) {
            z10 = false;
        }
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        if ((i12 & 32) != 0) {
            z12 = false;
        }
        if ((i12 & 64) != 0) {
            z13 = false;
        }
        if ((i12 & 128) != 0) {
            charset = null;
        }
        return canonicalizeWithCharset(str, i10, i11, str2, z10, z11, z12, z13, charset);
    }

    public static final char[] getHEX_DIGITS() {
        return HEX_DIGITS;
    }

    public static final boolean isPercentEncoded(String str, int i10, int i11) {
        h.e("<this>", str);
        int i12 = i10 + 2;
        return i12 < i11 && str.charAt(i10) == '%' && _UtilCommonKt.parseHexDigit(str.charAt(i10 + 1)) != -1 && _UtilCommonKt.parseHexDigit(str.charAt(i12)) != -1;
    }

    public static final String percentDecode(String str, int i10, int i11, boolean z10) {
        h.e("<this>", str);
        for (int i12 = i10; i12 < i11; i12++) {
            char charAt = str.charAt(i12);
            if (charAt == '%' || (charAt == '+' && z10)) {
                l lVar = new l();
                lVar.f0(str, i10, i12);
                writePercentDecoded(lVar, str, i12, i11, z10);
                return lVar.S();
            }
        }
        String substring = str.substring(i10, i11);
        h.d("substring(...)", substring);
        return substring;
    }

    public static /* synthetic */ String percentDecode$default(String str, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return percentDecode(str, i10, i11, z10);
    }

    public static final void writeCanonicalized(l lVar, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        h.e("<this>", lVar);
        h.e("input", str);
        h.e("encodeSet", str2);
        l lVar2 = null;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (!z10 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 32 && str2 == FORM_ENCODE_SET) {
                    lVar.e0("+");
                } else if (codePointAt == 43 && z12) {
                    lVar.e0(z10 ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && !z13) || i.a0(str2, (char) codePointAt) || (codePointAt == 37 && (!z10 || (z11 && !isPercentEncoded(str, i10, i11)))))) {
                    if (lVar2 == null) {
                        lVar2 = new l();
                    }
                    if (charset == null || charset.equals(a.f5445a)) {
                        lVar2.g0(codePointAt);
                    } else {
                        lVar2.d0(str, i10, Character.charCount(codePointAt) + i10, charset);
                    }
                    while (!lVar2.t()) {
                        byte readByte = lVar2.readByte();
                        lVar.X(37);
                        char[] cArr = HEX_DIGITS;
                        lVar.X(cArr[((readByte & 255) >> 4) & 15]);
                        lVar.X(cArr[readByte & 15]);
                    }
                } else {
                    lVar.g0(codePointAt);
                }
            }
            i10 += Character.charCount(codePointAt);
        }
    }

    public static final void writePercentDecoded(l lVar, String str, int i10, int i11, boolean z10) {
        int i12;
        h.e("<this>", lVar);
        h.e("encoded", str);
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt != 37 || (i12 = i10 + 2) >= i11) {
                if (codePointAt == 43 && z10) {
                    lVar.X(32);
                    i10++;
                }
                lVar.g0(codePointAt);
                i10 += Character.charCount(codePointAt);
            } else {
                int parseHexDigit = _UtilCommonKt.parseHexDigit(str.charAt(i10 + 1));
                int parseHexDigit2 = _UtilCommonKt.parseHexDigit(str.charAt(i12));
                if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                    lVar.X((parseHexDigit << 4) + parseHexDigit2);
                    i10 = Character.charCount(codePointAt) + i12;
                }
                lVar.g0(codePointAt);
                i10 += Character.charCount(codePointAt);
            }
        }
    }
}
