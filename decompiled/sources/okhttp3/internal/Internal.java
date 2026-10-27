package okhttp3.internal;

import java.nio.charset.Charset;
import javax.net.ssl.SSLSocket;
import la.d;
import okhttp3.Cache;
import okhttp3.CipherSuite;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.ConnectionListener;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str) {
        h.e("builder", builder);
        h.e("line", str);
        return builder.addLenient$okhttp(str);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z10) {
        h.e("connectionSpec", connectionSpec);
        h.e("sslSocket", sSLSocket);
        connectionSpec.apply$okhttp(sSLSocket, z10);
    }

    public static final ConnectionPool buildConnectionPool(ConnectionListener connectionListener, TaskRunner taskRunner) {
        h.e("connectionListener", connectionListener);
        h.e("taskRunner", taskRunner);
        return new ConnectionPool(0, 0L, null, taskRunner, connectionListener, 7, null);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        h.e("cache", cache);
        h.e("request", request);
        return cache.get$okhttp(request);
    }

    public static final Charset charsetOrUtf8(MediaType mediaType) {
        Charset charset$default;
        return (mediaType == null || (charset$default = MediaType.charset$default(mediaType, null, 1, null)) == null) ? gb.a.f5445a : charset$default;
    }

    public static final d chooseCharset(MediaType mediaType) {
        Charset charset = gb.a.f5445a;
        if (mediaType != null) {
            Charset charset$default = MediaType.charset$default(mediaType, null, 1, null);
            if (charset$default == null) {
                mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset$default;
            }
        }
        return new d(charset, mediaType);
    }

    public static final String cookieToString(Cookie cookie, boolean z10) {
        h.e("cookie", cookie);
        return cookie.toString$okhttp(z10);
    }

    public static final String[] effectiveCipherSuites(ConnectionSpec connectionSpec, String[] strArr) {
        h.e("<this>", connectionSpec);
        h.e("socketEnabledCipherSuites", strArr);
        return connectionSpec.getCipherSuitesAsString$okhttp() != null ? _UtilCommonKt.intersect(connectionSpec.getCipherSuitesAsString$okhttp(), strArr, CipherSuite.Companion.getORDER_BY_NAME$okhttp()) : strArr;
    }

    public static final RealConnection getConnection(Response response) {
        h.e("<this>", response);
        Exchange exchange = response.exchange();
        h.b(exchange);
        return exchange.getConnection$okhttp();
    }

    public static final Cookie parseCookie(long j10, HttpUrl httpUrl, String str) {
        h.e("url", httpUrl);
        h.e("setCookie", str);
        return Cookie.Companion.parse$okhttp(j10, httpUrl, str);
    }

    public static final OkHttpClient.Builder taskRunnerInternal(OkHttpClient.Builder builder, TaskRunner taskRunner) {
        h.e("<this>", builder);
        h.e("taskRunner", taskRunner);
        return builder.taskRunner$okhttp(taskRunner);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str, String str2) {
        h.e("builder", builder);
        h.e("name", str);
        h.e("value", str2);
        return builder.addLenient$okhttp(str, str2);
    }
}
