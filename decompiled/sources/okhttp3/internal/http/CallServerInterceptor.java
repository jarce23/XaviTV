package okhttp3.internal.http;

import okhttp3.Interceptor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class CallServerInterceptor implements Interceptor {
    public static final CallServerInterceptor INSTANCE = new CallServerInterceptor();

    private CallServerInterceptor() {
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int i10) {
        if (i10 == 100) {
            return true;
        }
        return 102 <= i10 && i10 < 200;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0100 A[Catch: IOException -> 0x010d, TryCatch #1 {IOException -> 0x010d, blocks: (B:28:0x00fa, B:30:0x0100, B:32:0x0109, B:34:0x0110, B:37:0x0137, B:41:0x0143, B:44:0x014e, B:45:0x0155, B:49:0x0159, B:54:0x016a, B:55:0x01ad, B:57:0x01bb, B:64:0x01d0, B:66:0x01df, B:67:0x0205, B:68:0x01c5, B:69:0x0194), top: B:27:0x00fa }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r19) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
