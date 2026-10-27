package okhttp3;

import android.support.v4.media.d;
import gb.p;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import ma.k;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.EmptyTags;
import okhttp3.internal.IsProbablyUtf8Kt;
import okhttp3.internal.Tags;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http.GzipRequestBody;
import okhttp3.internal.http.HttpMethod;
import rb.l;
import za.e;
import za.h;
import za.n;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Request {
    private final RequestBody body;
    private final HttpUrl cacheUrlOverride;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Tags tags;
    private final HttpUrl url;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static class Builder {
        private RequestBody body;
        private HttpUrl cacheUrlOverride;
        private Headers.Builder headers;
        private String method;
        private Tags tags;
        private HttpUrl url;

        public Builder() {
            this.tags = EmptyTags.INSTANCE;
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        private final String canonicalUrl(String str) {
            if (p.Y(str, "ws:", true)) {
                String substring = str.substring(3);
                h.d("substring(...)", substring);
                return "http:".concat(substring);
            }
            if (!p.Y(str, "wss:", true)) {
                return str;
            }
            String substring2 = str.substring(4);
            h.d("substring(...)", substring2);
            return "https:".concat(substring2);
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i10 & 1) != 0) {
                requestBody = RequestBody.EMPTY;
            }
            return builder.delete(requestBody);
        }

        public Builder addHeader(String str, String str2) {
            h.e("name", str);
            h.e("value", str2);
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder cacheControl(CacheControl cacheControl) {
            h.e("cacheControl", cacheControl);
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", cacheControl2);
        }

        public final Builder cacheUrlOverride(HttpUrl httpUrl) {
            this.cacheUrlOverride = httpUrl;
            return this;
        }

        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        public Builder get() {
            return method("GET", null);
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final HttpUrl getCacheUrlOverride$okhttp() {
            return this.cacheUrlOverride;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Tags getTags$okhttp() {
            return this.tags;
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public final Builder gzip() {
            RequestBody requestBody = this.body;
            if (requestBody == null) {
                throw new IllegalStateException("cannot gzip a request that has no body");
            }
            String str = this.headers.get("Content-Encoding");
            if (str != null) {
                throw new IllegalStateException(r.a.l("Content-Encoding already set: ", str).toString());
            }
            this.headers.add("Content-Encoding", "gzip");
            this.body = new GzipRequestBody(requestBody);
            return this;
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String str, String str2) {
            h.e("name", str);
            h.e("value", str2);
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            h.e("headers", headers);
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            h.e("method", str);
            if (str.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (requestBody == null) {
                if (HttpMethod.requiresRequestBody(str)) {
                    throw new IllegalArgumentException(d.q("method ", str, " must have a request body.").toString());
                }
            } else if (!HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException(d.q("method ", str, " must not have a request body.").toString());
            }
            this.method = str;
            this.body = requestBody;
            return this;
        }

        public Builder patch(RequestBody requestBody) {
            h.e("body", requestBody);
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            h.e("body", requestBody);
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            h.e("body", requestBody);
            return method("PUT", requestBody);
        }

        public Builder query(RequestBody requestBody) {
            h.e("body", requestBody);
            return method("QUERY", requestBody);
        }

        public final <T> Builder reifiedTag(T t3) {
            throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
        }

        public Builder removeHeader(String str) {
            h.e("name", str);
            this.headers.removeAll(str);
            return this;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setCacheUrlOverride$okhttp(HttpUrl httpUrl) {
            this.cacheUrlOverride = httpUrl;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            h.e("<set-?>", builder);
            this.headers = builder;
        }

        public final void setMethod$okhttp(String str) {
            h.e("<set-?>", str);
            this.method = str;
        }

        public final void setTags$okhttp(Tags tags) {
            h.e("<set-?>", tags);
            this.tags = tags;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public <T> Builder tag(Class<? super T> cls, T t3) {
            h.e("type", cls);
            return tag((eb.b) n.a(cls), (za.d) t3);
        }

        public Builder url(HttpUrl httpUrl) {
            h.e("url", httpUrl);
            this.url = httpUrl;
            return this;
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder url(String str) {
            h.e("url", str);
            return url(HttpUrl.Companion.get(canonicalUrl(str)));
        }

        public final <T> Builder tag(eb.b bVar, T t3) {
            h.e("type", bVar);
            this.tags = this.tags.plus(bVar, t3);
            return this;
        }

        public Builder url(URL url) {
            h.e("url", url);
            HttpUrl.Companion companion = HttpUrl.Companion;
            String url2 = url.toString();
            h.d("toString(...)", url2);
            return url(companion.get(url2));
        }

        public Builder tag(Object obj) {
            return tag((eb.b) n.a(Object.class), (za.d) obj);
        }

        public Builder(Request request) {
            h.e("request", request);
            this.tags = EmptyTags.INSTANCE;
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            this.tags = request.getTags$okhttp();
            this.headers = request.headers().newBuilder();
            this.cacheUrlOverride = request.cacheUrlOverride();
        }
    }

    public Request(Builder builder) {
        h.e("builder", builder);
        HttpUrl url$okhttp = builder.getUrl$okhttp();
        if (url$okhttp == null) {
            throw new IllegalStateException("url == null");
        }
        this.url = url$okhttp;
        this.method = builder.getMethod$okhttp();
        this.headers = builder.getHeaders$okhttp().build();
        this.body = builder.getBody$okhttp();
        this.cacheUrlOverride = builder.getCacheUrlOverride$okhttp();
        this.tags = builder.getTags$okhttp();
    }

    private final String shellEscape(String str) {
        return "'" + p.W(str, "'", "'\\''") + '\'';
    }

    public static /* synthetic */ String toCurl$default(Request request, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return request.toCurl(z10);
    }

    /* renamed from: -deprecated_body, reason: not valid java name */
    public final RequestBody m122deprecated_body() {
        return this.body;
    }

    /* renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m123deprecated_cacheControl() {
        return cacheControl();
    }

    /* renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m124deprecated_headers() {
        return this.headers;
    }

    /* renamed from: -deprecated_method, reason: not valid java name */
    public final String m125deprecated_method() {
        return this.method;
    }

    /* renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m126deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = parse;
        return parse;
    }

    public final HttpUrl cacheUrlOverride() {
        return this.cacheUrlOverride;
    }

    public final Tags getTags$okhttp() {
        return this.tags;
    }

    public final String header(String str) {
        h.e("name", str);
        return this.headers.get(str);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final <T> T reifiedTag() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public final <T> T tag(Class<? extends T> cls) {
        h.e("type", cls);
        return (T) tag(n.a(cls));
    }

    public final String toCurl() {
        return toCurl$default(this, false, 1, null);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Request{method=");
        sb2.append(this.method);
        sb2.append(", url=");
        sb2.append(this.url);
        if (this.headers.size() != 0) {
            sb2.append(", headers=[");
            int i10 = 0;
            for (la.d dVar : this.headers) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    k.y();
                    throw null;
                }
                la.d dVar2 = dVar;
                String str = (String) dVar2.f8328o;
                String str2 = (String) dVar2.f8329p;
                if (i10 > 0) {
                    sb2.append(", ");
                }
                sb2.append(str);
                sb2.append(':');
                if (_UtilCommonKt.isSensitiveHeader(str)) {
                    str2 = "██";
                }
                sb2.append(str2);
                i10 = i11;
            }
            sb2.append(']');
        }
        if (!h.a(this.tags, EmptyTags.INSTANCE)) {
            sb2.append(", tags=");
            sb2.append(this.tags);
        }
        sb2.append('}');
        return sb2.toString();
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final List<String> headers(String str) {
        h.e("name", str);
        return this.headers.values(str);
    }

    public final String toCurl(boolean z10) {
        RequestBody requestBody;
        MediaType contentType;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("curl " + shellEscape(this.url.toString()));
        RequestBody requestBody2 = this.body;
        String mediaType = (requestBody2 == null || (contentType = requestBody2.contentType()) == null) ? null : contentType.toString();
        if (!h.a(this.method, (!z10 || this.body == null) ? "GET" : "POST")) {
            sb2.append(" \\\n  -X " + shellEscape(this.method));
        }
        Iterator<la.d> it = this.headers.iterator();
        while (it.hasNext()) {
            la.d next = it.next();
            String str = (String) next.f8328o;
            String str2 = (String) next.f8329p;
            if (mediaType == null || !p.S(str, "Content-Type")) {
                StringBuilder sb3 = new StringBuilder(" \\\n  -H ");
                sb3.append(shellEscape(str + ": " + str2));
                sb2.append(sb3.toString());
            }
        }
        if (mediaType != null) {
            sb2.append(" \\\n  -H " + shellEscape("Content-Type: ".concat(mediaType)));
        }
        if (z10 && (requestBody = this.body) != null) {
            l lVar = new l();
            requestBody.writeTo(lVar);
            if (IsProbablyUtf8Kt.isProbablyUtf8$default(lVar, 0L, 1, null)) {
                sb2.append(" \\\n  --data " + shellEscape(lVar.S()));
            } else {
                sb2.append(" \\\n  --data-binary " + shellEscape(lVar.i(lVar.f11035p).e()));
            }
        }
        return sb2.toString();
    }

    public final <T> T tag(eb.b bVar) {
        h.e("type", bVar);
        return (T) k5.a.o(bVar).cast(this.tags.get(bVar));
    }

    public final Object tag() {
        return tag(n.a(Object.class));
    }

    public /* synthetic */ Request(HttpUrl httpUrl, Headers headers, String str, RequestBody requestBody, int i10, e eVar) {
        this(httpUrl, (i10 & 2) != 0 ? Headers.Companion.of(new String[0]) : headers, (i10 & 4) != 0 ? "\u0000" : str, (i10 & 8) != 0 ? null : requestBody);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Request(okhttp3.HttpUrl r2, okhttp3.Headers r3, java.lang.String r4, okhttp3.RequestBody r5) {
        /*
            r1 = this;
            java.lang.String r0 = "url"
            za.h.e(r0, r2)
            java.lang.String r0 = "headers"
            za.h.e(r0, r3)
            java.lang.String r0 = "method"
            za.h.e(r0, r4)
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder
            r0.<init>()
            okhttp3.Request$Builder r2 = r0.url(r2)
            okhttp3.Request$Builder r2 = r2.headers(r3)
            java.lang.String r3 = "\u0000"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L25
            goto L2c
        L25:
            if (r5 == 0) goto L2a
            java.lang.String r4 = "POST"
            goto L2c
        L2a:
            java.lang.String r4 = "GET"
        L2c:
            okhttp3.Request$Builder r2 = r2.method(r4, r5)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Request.<init>(okhttp3.HttpUrl, okhttp3.Headers, java.lang.String, okhttp3.RequestBody):void");
    }
}
