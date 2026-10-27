package okhttp3.internal.http2;

import gb.p;
import j9.w1;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.url._UrlKt;
import rb.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Http2 {
    private static final String[] BINARY;
    public static final o CONNECTION_PREFACE;
    private static final String[] FLAGS;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final Http2 INSTANCE = new Http2();
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    static {
        o oVar = o.f11048r;
        CONNECTION_PREFACE = w1.F("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        String[] strArr = new String[256];
        for (int i10 = 0; i10 < 256; i10++) {
            String binaryString = Integer.toBinaryString(i10);
            za.h.d("toBinaryString(...)", binaryString);
            strArr[i10] = p.V(_UtilJvmKt.format("%8s", binaryString), ' ', '0');
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = _UrlKt.FRAGMENT_ENCODE_SET;
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i11 = iArr[0];
        strArr2[i11 | 8] = android.support.v4.media.d.r(new StringBuilder(), strArr2[i11], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i12 = 0; i12 < 3; i12++) {
            int i13 = iArr2[i12];
            int i14 = iArr[0];
            String[] strArr3 = FLAGS;
            int i15 = i14 | i13;
            strArr3[i15] = strArr3[i14] + '|' + strArr3[i13];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr3[i14]);
            sb2.append('|');
            strArr3[i15 | 8] = android.support.v4.media.d.r(sb2, strArr3[i13], "|PADDED");
        }
        int length = FLAGS.length;
        for (int i16 = 0; i16 < length; i16++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i16] == null) {
                strArr4[i16] = BINARY[i16];
            }
        }
    }

    private Http2() {
    }

    public final String formatFlags(int i10, int i11) {
        String str;
        if (i11 == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        if (i10 != 2 && i10 != 3) {
            if (i10 == 4 || i10 == 6) {
                return i11 == 1 ? "ACK" : BINARY[i11];
            }
            if (i10 != 7 && i10 != 8) {
                String[] strArr = FLAGS;
                if (i11 < strArr.length) {
                    str = strArr[i11];
                    za.h.b(str);
                } else {
                    str = BINARY[i11];
                }
                return (i10 != 5 || (i11 & 4) == 0) ? (i10 != 0 || (i11 & 32) == 0) ? str : p.W(str, "PRIORITY", "COMPRESSED") : p.W(str, "HEADERS", "PUSH_PROMISE");
            }
        }
        return BINARY[i11];
    }

    public final String formattedType$okhttp(int i10) {
        String[] strArr = FRAME_NAMES;
        return i10 < strArr.length ? strArr[i10] : _UtilJvmKt.format("0x%02x", Integer.valueOf(i10));
    }

    public final String frameLog(boolean z10, int i10, int i11, int i12, int i13) {
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %s", z10 ? "<<" : ">>", Integer.valueOf(i10), Integer.valueOf(i11), formattedType$okhttp(i12), formatFlags(i12, i13));
    }

    public final String frameLogWindowUpdate(boolean z10, int i10, int i11, long j10) {
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %d", z10 ? "<<" : ">>", Integer.valueOf(i10), Integer.valueOf(i11), formattedType$okhttp(8), Long.valueOf(j10));
    }
}
