package okhttp3;

import java.nio.charset.Charset;
import rb.o;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    public static final String basic(String str, String str2) {
        h.e("username", str);
        h.e("password", str2);
        return basic$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            charset = gb.a.f5448d;
        }
        return basic(str, str2, charset);
    }

    public static final String basic(String str, String str2, Charset charset) {
        h.e("username", str);
        h.e("password", str2);
        h.e("charset", charset);
        String str3 = str + ':' + str2;
        o oVar = o.f11048r;
        h.e("<this>", str3);
        byte[] bytes = str3.getBytes(charset);
        h.d("getBytes(...)", bytes);
        return r.a.l("Basic ", new o(bytes).a());
    }
}
