package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.ConnectionShutdownException;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        h.e("client", okHttpClient);
        this.client = okHttpClient;
    }

    private final Request buildRedirectRequest(Response response, String str) {
        String header$default;
        HttpUrl resolve;
        if (!this.client.followRedirects() || (header$default = Response.header$default(response, "Location", null, 2, null)) == null || (resolve = response.request().url().resolve(header$default)) == null) {
            return null;
        }
        if (!h.a(resolve.scheme(), response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(str)) {
            int code = response.code();
            HttpMethod httpMethod = HttpMethod.INSTANCE;
            boolean z10 = httpMethod.redirectsWithBody(str) || code == 308 || code == 307;
            if (!httpMethod.redirectsToGet(str) || code == 308 || code == 307) {
                newBuilder.method(str, z10 ? response.request().body() : null);
            } else {
                newBuilder.method("GET", null);
            }
            if (!z10) {
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!_UtilJvmKt.canReuseConnectionFor(response.request().url(), resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    private final Request followUpRequest(Response response, Exchange exchange) {
        RealConnection connection$okhttp;
        Route route = (exchange == null || (connection$okhttp = exchange.getConnection$okhttp()) == null) ? null : connection$okhttp.route();
        int code = response.code();
        String method = response.request().method();
        if (code != 307 && code != 308) {
            if (code == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (code == 421) {
                RequestBody body = response.request().body();
                if ((body != null && body.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                return response.request();
            }
            if (code == 503) {
                Response priorResponse = response.priorResponse();
                if ((priorResponse == null || priorResponse.code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            }
            if (code == 407) {
                h.b(route);
                if (route.proxy().type() == Proxy.Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (code == 408) {
                if (!this.client.retryOnConnectionFailure()) {
                    return null;
                }
                RequestBody body2 = response.request().body();
                if (body2 != null && body2.isOneShot()) {
                    return null;
                }
                Response priorResponse2 = response.priorResponse();
                if ((priorResponse2 == null || priorResponse2.code() != 408) && retryAfter(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
            switch (code) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return buildRedirectRequest(response, method);
    }

    private final boolean isRecoverable(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z10 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request) {
        boolean z10 = iOException instanceof ConnectionShutdownException;
        boolean z11 = !z10;
        if (this.client.retryOnConnectionFailure()) {
            return (z10 || !requestIsOneShot(iOException, request)) && isRecoverable(iOException, z11) && realCall.retryAfterFailure();
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody body = request.body();
        return (body != null && body.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final int retryAfter(Response response, int i10) {
        String header$default = Response.header$default(response, "Retry-After", null, 2, null);
        if (header$default == null) {
            return i10;
        }
        Pattern compile = Pattern.compile("\\d+");
        h.d("compile(...)", compile);
        if (!compile.matcher(header$default).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(header$default);
        h.d("valueOf(...)", valueOf);
        return valueOf.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        r0 = r12.proceed(r0).newBuilder().request(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        if (r7 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        r6 = okhttp3.internal.UnreadableResponseBodyKt.stripBody(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        r7 = r0.priorResponse(r6).build();
        r0 = r1.getInterceptorScopedExchange$okhttp();
        r6 = followUpRequest(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        if (r6 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        r0 = r6.body();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
    
        if (r0 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (r0.isOneShot() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006f, code lost:
    
        r1.getEventListener$okhttp().followUpDecision(r1, r7, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007a, code lost:
    
        okhttp3.internal._UtilCommonKt.closeQuietly(r7.body());
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0085, code lost:
    
        if (r8 > okhttp3.internal.http.RetryAndFollowUpInterceptor.MAX_FOLLOW_UPS) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0087, code lost:
    
        r1.getEventListener$okhttp().followUpDecision(r1, r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0093, code lost:
    
        r1.getEventListener$okhttp().followUpDecision(r1, r7, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b0, code lost:
    
        throw new java.net.ProtocolException("Too many follow-up requests: " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0050, code lost:
    
        if (r0.isDuplex$okhttp() == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0052, code lost:
    
        r1.timeoutEarlyExit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0055, code lost:
    
        r1.getEventListener$okhttp().followUpDecision(r1, r7, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005c, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005f, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0060, code lost:
    
        r12 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e8, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00eb, code lost:
    
        throw r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0037, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r12) {
        /*
            r11 = this;
            java.lang.String r0 = "chain"
            za.h.e(r0, r12)
            okhttp3.internal.http.RealInterceptorChain r12 = (okhttp3.internal.http.RealInterceptorChain) r12
            okhttp3.Request r0 = r12.getRequest$okhttp()
            okhttp3.internal.connection.RealCall r1 = r12.getCall$okhttp()
            r2 = 0
            r3 = 0
            r4 = 1
            ma.p r5 = ma.p.f9051o
            r8 = r2
            r7 = r3
        L16:
            r6 = r4
        L17:
            r1.enterNetworkInterceptorExchange(r0, r6, r12)
            boolean r6 = r1.isCanceled()     // Catch: java.lang.Throwable -> L33
            if (r6 != 0) goto Le0
            okhttp3.Response r6 = r12.proceed(r0)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> Lb1
            okhttp3.Response$Builder r6 = r6.newBuilder()     // Catch: java.lang.Throwable -> L33
            okhttp3.Response$Builder r0 = r6.request(r0)     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L37
            okhttp3.Response r6 = okhttp3.internal.UnreadableResponseBodyKt.stripBody(r7)     // Catch: java.lang.Throwable -> L33
            goto L38
        L33:
            r12 = move-exception
            r2 = r4
            goto Le8
        L37:
            r6 = r3
        L38:
            okhttp3.Response$Builder r0 = r0.priorResponse(r6)     // Catch: java.lang.Throwable -> L33
            okhttp3.Response r7 = r0.build()     // Catch: java.lang.Throwable -> L33
            okhttp3.internal.connection.Exchange r0 = r1.getInterceptorScopedExchange$okhttp()     // Catch: java.lang.Throwable -> L33
            okhttp3.Request r6 = r11.followUpRequest(r7, r0)     // Catch: java.lang.Throwable -> L33
            if (r6 != 0) goto L63
            if (r0 == 0) goto L55
            boolean r12 = r0.isDuplex$okhttp()     // Catch: java.lang.Throwable -> L33
            if (r12 == 0) goto L55
            r1.timeoutEarlyExit()     // Catch: java.lang.Throwable -> L33
        L55:
            okhttp3.EventListener r12 = r1.getEventListener$okhttp()     // Catch: java.lang.Throwable -> L60
            r12.followUpDecision(r1, r7, r3)     // Catch: java.lang.Throwable -> L60
            r1.exitNetworkInterceptorExchange$okhttp(r2)
            return r7
        L60:
            r12 = move-exception
            goto Le8
        L63:
            okhttp3.RequestBody r0 = r6.body()     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L7a
            boolean r0 = r0.isOneShot()     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L7a
            okhttp3.EventListener r12 = r1.getEventListener$okhttp()     // Catch: java.lang.Throwable -> L60
            r12.followUpDecision(r1, r7, r3)     // Catch: java.lang.Throwable -> L60
            r1.exitNetworkInterceptorExchange$okhttp(r2)
            return r7
        L7a:
            okhttp3.ResponseBody r0 = r7.body()     // Catch: java.lang.Throwable -> L33
            okhttp3.internal._UtilCommonKt.closeQuietly(r0)     // Catch: java.lang.Throwable -> L33
            int r8 = r8 + 1
            r0 = 20
            if (r8 > r0) goto L93
            okhttp3.EventListener r0 = r1.getEventListener$okhttp()     // Catch: java.lang.Throwable -> L33
            r0.followUpDecision(r1, r7, r6)     // Catch: java.lang.Throwable -> L33
            r1.exitNetworkInterceptorExchange$okhttp(r4)
            r0 = r6
            goto L16
        L93:
            okhttp3.EventListener r12 = r1.getEventListener$okhttp()     // Catch: java.lang.Throwable -> L33
            r12.followUpDecision(r1, r7, r3)     // Catch: java.lang.Throwable -> L33
            java.net.ProtocolException r12 = new java.net.ProtocolException     // Catch: java.lang.Throwable -> L33
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33
            r0.<init>()     // Catch: java.lang.Throwable -> L33
            java.lang.String r2 = "Too many follow-up requests: "
            r0.append(r2)     // Catch: java.lang.Throwable -> L33
            r0.append(r8)     // Catch: java.lang.Throwable -> L33
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L33
            r12.<init>(r0)     // Catch: java.lang.Throwable -> L33
            throw r12     // Catch: java.lang.Throwable -> L33
        Lb1:
            r6 = move-exception
            boolean r9 = r11.recover(r6, r1, r0)     // Catch: java.lang.Throwable -> L33
            okhttp3.EventListener r10 = r1.getEventListener$okhttp()     // Catch: java.lang.Throwable -> L33
            r10.retryDecision(r1, r6, r9)     // Catch: java.lang.Throwable -> L33
            if (r9 == 0) goto Ldb
            java.lang.String r9 = "<this>"
            za.h.e(r9, r5)     // Catch: java.lang.Throwable -> L33
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L33
            int r10 = r5.size()     // Catch: java.lang.Throwable -> L33
            int r10 = r10 + r4
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L33
            r9.addAll(r5)     // Catch: java.lang.Throwable -> L33
            r9.add(r6)     // Catch: java.lang.Throwable -> L33
            r1.exitNetworkInterceptorExchange$okhttp(r4)
            r6 = r2
            r5 = r9
            goto L17
        Ldb:
            java.lang.Throwable r12 = okhttp3.internal._UtilCommonKt.withSuppressed(r6, r5)     // Catch: java.lang.Throwable -> L33
            throw r12     // Catch: java.lang.Throwable -> L33
        Le0:
            java.io.IOException r12 = new java.io.IOException     // Catch: java.lang.Throwable -> L33
            java.lang.String r0 = "Canceled"
            r12.<init>(r0)     // Catch: java.lang.Throwable -> L33
            throw r12     // Catch: java.lang.Throwable -> L33
        Le8:
            r1.exitNetworkInterceptorExchange$okhttp(r2)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
