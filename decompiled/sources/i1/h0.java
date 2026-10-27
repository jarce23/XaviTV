package i1;

import java.io.IOException;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class h0 extends IOException {

    /* renamed from: o, reason: collision with root package name */
    public final boolean f5897o;

    /* renamed from: p, reason: collision with root package name */
    public final int f5898p;

    public h0(String str, Throwable th, boolean z10, int i10) {
        super(str, th);
        this.f5897o = z10;
        this.f5898p = i10;
    }

    public static h0 a(RuntimeException runtimeException, String str) {
        return new h0(str, runtimeException, true, 1);
    }

    public static h0 b(String str) {
        return new h0(str, null, true, 4);
    }

    public static h0 c(String str) {
        return new h0(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String message = super.getMessage();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(message != null ? message.concat(" ") : _UrlKt.FRAGMENT_ENCODE_SET);
        sb2.append("{contentIsMalformed=");
        sb2.append(this.f5897o);
        sb2.append(", dataType=");
        return r.a.d(sb2, this.f5898p, "}");
    }
}
