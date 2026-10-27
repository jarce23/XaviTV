package okhttp3.internal.ws;

import android.support.v4.media.d;
import j9.w1;
import rb.i;
import rb.l;
import rb.o;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String str) {
        h.e("key", str);
        o oVar = o.f11048r;
        return w1.F(str.concat(ACCEPT_MAGIC)).c("SHA-1").a();
    }

    public final String closeCodeExceptionMessage(int i10) {
        if (i10 < 1000 || i10 >= 5000) {
            return d.m(i10, "Code must be in range [1000,5000): ");
        }
        if ((1004 > i10 || i10 >= 1007) && (1015 > i10 || i10 >= 3000)) {
            return null;
        }
        return d.o("Code ", i10, " is reserved and may not be used.");
    }

    public final void toggleMask(i iVar, byte[] bArr) {
        long j10;
        h.e("cursor", iVar);
        h.e("key", bArr);
        int length = bArr.length;
        int i10 = 0;
        do {
            byte[] bArr2 = iVar.f11017s;
            int i11 = iVar.f11018t;
            int i12 = iVar.f11019u;
            if (bArr2 != null) {
                while (i11 < i12) {
                    int i13 = i10 % length;
                    bArr2[i11] = (byte) (bArr2[i11] ^ bArr[i13]);
                    i11++;
                    i10 = i13 + 1;
                }
            }
            long j11 = iVar.f11016r;
            l lVar = iVar.f11013o;
            h.b(lVar);
            if (j11 == lVar.f11035p) {
                throw new IllegalStateException("no more bytes");
            }
            j10 = iVar.f11016r;
        } while (iVar.c(j10 == -1 ? 0L : j10 + (iVar.f11019u - iVar.f11018t)) != -1);
    }

    public final void validateCloseCode(int i10) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i10);
        if (closeCodeExceptionMessage == null) {
            return;
        }
        h.b(closeCodeExceptionMessage);
        throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
    }
}
