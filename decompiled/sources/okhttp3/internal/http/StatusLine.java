package okhttp3.internal.http;

import gb.p;
import java.net.ProtocolException;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.internal.url._UrlKt;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class StatusLine {
    public static final Companion Companion = new Companion(null);
    public final int code;
    public final String message;
    public final Protocol protocol;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final StatusLine get(Response response) {
            h.e("response", response);
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String str) {
            Protocol protocol;
            int i10;
            String str2;
            h.e("statusLine", str);
            if (p.Y(str, "HTTP/1.", false)) {
                i10 = 9;
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (charAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(str));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else if (p.Y(str, "ICY ", false)) {
                protocol = Protocol.HTTP_1_0;
                i10 = 4;
            } else {
                if (!p.Y(str, "SOURCETABLE ", false)) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                protocol = Protocol.HTTP_1_1;
                i10 = 12;
            }
            int i11 = i10 + 3;
            if (str.length() < i11) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            String substring = str.substring(i10, i11);
            h.d("substring(...)", substring);
            Integer Z = p.Z(substring);
            if (Z == null) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int intValue = Z.intValue();
            if (str.length() <= i11) {
                str2 = _UrlKt.FRAGMENT_ENCODE_SET;
            } else {
                if (str.charAt(i11) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                str2 = str.substring(i10 + 4);
                h.d("substring(...)", str2);
            }
            return new StatusLine(protocol, intValue, str2);
        }

        private Companion() {
        }
    }

    public StatusLine(Protocol protocol, int i10, String str) {
        h.e("protocol", protocol);
        h.e("message", str);
        this.protocol = protocol;
        this.code = i10;
        this.message = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb2.append("HTTP/1.0");
        } else {
            sb2.append("HTTP/1.1");
        }
        sb2.append(' ');
        sb2.append(this.code);
        sb2.append(' ');
        sb2.append(this.message);
        return sb2.toString();
    }
}
