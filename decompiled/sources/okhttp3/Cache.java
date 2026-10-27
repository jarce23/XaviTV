package okhttp3;

import com.bumptech.glide.f;
import gb.i;
import gb.p;
import j9.w1;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import ma.r;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import rb.i0;
import rb.j;
import rb.l;
import rb.l0;
import rb.m;
import rb.m0;
import rb.n;
import rb.o;
import rb.q0;
import rb.s0;
import rb.u;
import rb.w;
import rb.x;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class CacheResponseBody extends ResponseBody {
        private final n bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            h.e("snapshot", snapshot);
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = rb.b.c(new x(snapshot.getSource(1)) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // rb.x, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    this.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return _UtilCommonKt.toLongOrDefault(str, -1L);
            }
            return -1L;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        public n source() {
            return this.bodySource;
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i10 = 0; i10 < size; i10++) {
                if ("Vary".equalsIgnoreCase(headers.name(i10))) {
                    String value = headers.value(i10);
                    if (treeSet == null) {
                        p.T();
                        treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                    }
                    Iterator it = i.l0(value, new char[]{','}).iterator();
                    while (it.hasNext()) {
                        treeSet.add(i.o0((String) it.next()).toString());
                    }
                }
            }
            return treeSet == null ? r.f9053o : treeSet;
        }

        public final boolean hasVaryAll(Response response) {
            h.e("<this>", response);
            return varyFields(response.headers()).contains("*");
        }

        public final String key(HttpUrl httpUrl) {
            h.e("url", httpUrl);
            o oVar = o.f11048r;
            return w1.F(httpUrl.toString()).c("MD5").e();
        }

        public final int readInt$okhttp(n nVar) {
            h.e("source", nVar);
            try {
                long w10 = nVar.w();
                String p10 = nVar.p();
                if (w10 >= 0 && w10 <= 2147483647L && p10.length() <= 0) {
                    return (int) w10;
                }
                throw new IOException("expected an int but was \"" + w10 + p10 + '\"');
            } catch (NumberFormatException e7) {
                throw new IOException(e7.getMessage());
            }
        }

        public final Headers varyHeaders(Response response) {
            h.e("<this>", response);
            Response networkResponse = response.networkResponse();
            h.b(networkResponse);
            return varyHeaders(networkResponse.request().headers(), response.headers());
        }

        public final boolean varyMatches(Response response, Headers headers, Request request) {
            h.e("cachedResponse", response);
            h.e("cachedRequest", headers);
            h.e("newRequest", request);
            Set<String> varyFields = varyFields(response.headers());
            if (varyFields != null && varyFields.isEmpty()) {
                return true;
            }
            for (String str : varyFields) {
                if (!h.a(headers.values(str), request.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        private Companion() {
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> varyFields = varyFields(headers2);
            if (varyFields.isEmpty()) {
                return Headers.EMPTY;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                String name = headers.name(i10);
                if (varyFields.contains(name)) {
                    builder.add(name, headers.value(i10));
                }
            }
            return builder.build();
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class RealCacheRequest implements CacheRequest {
        private final q0 body;
        private final q0 cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(final Cache cache, DiskLruCache.Editor editor) {
            h.e("editor", editor);
            this.this$0 = cache;
            this.editor = editor;
            q0 newSink = editor.newSink(1);
            this.cacheOut = newSink;
            this.body = new w(newSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // rb.w, rb.q0, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Cache cache2 = Cache.this;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache2) {
                        if (realCacheRequest.getDone()) {
                            return;
                        }
                        realCacheRequest.setDone(true);
                        cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount$okhttp() + 1);
                        super.close();
                        this.editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache cache = this.this$0;
            synchronized (cache) {
                if (this.done) {
                    return;
                }
                this.done = true;
                cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                _UtilCommonKt.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public q0 body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z10) {
            this.done = z10;
        }
    }

    public Cache(i0 i0Var, long j10, u uVar, TaskRunner taskRunner) {
        h.e("directory", i0Var);
        h.e("fileSystem", uVar);
        h.e("taskRunner", taskRunner);
        this.cache = new DiskLruCache(uVar, i0Var, VERSION, 2, j10, taskRunner);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static final String key(HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    /* renamed from: -deprecated_directory, reason: not valid java name */
    public final File m12deprecated_directory() {
        return this.cache.getDirectory().toFile();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cache.close();
    }

    public final void delete() {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory().toFile();
    }

    public final i0 directoryPath() {
        return this.cache.getDirectory();
    }

    public final void evictAll() {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() {
        this.cache.flush();
    }

    public final Response get$okhttp(Request request) {
        h.e("request", request);
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                _UtilCommonKt.closeQuietly(response.body());
                return null;
            } catch (IOException unused) {
                _UtilCommonKt.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final CacheRequest put$okhttp(Response response) {
        DiskLruCache.Editor editor;
        h.e("response", response);
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!h.a(method, "GET")) {
            return null;
        }
        Companion companion = Companion;
        if (companion.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            editor = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0L, 2, null);
            if (editor == null) {
                return null;
            }
            try {
                entry.writeTo(editor);
                return new RealCacheRequest(this, editor);
            } catch (IOException unused2) {
                abortQuietly(editor);
                return null;
            }
        } catch (IOException unused3) {
            editor = null;
        }
    }

    public final void remove$okhttp(Request request) {
        h.e("request", request);
        this.cache.remove(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i10) {
        this.writeAbortCount = i10;
    }

    public final void setWriteSuccessCount$okhttp(int i10) {
        this.writeSuccessCount = i10;
    }

    public final long size() {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        try {
            h.e("cacheStrategy", cacheStrategy);
            this.requestCount++;
            if (cacheStrategy.getNetworkRequest() != null) {
                this.networkCount++;
            } else if (cacheStrategy.getCacheResponse() != null) {
                this.hitCount++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void update$okhttp(Response response, Response response2) {
        DiskLruCache.Editor editor;
        h.e("cached", response);
        h.e("network", response2);
        Entry entry = new Entry(response2);
        ResponseBody body = response.body();
        h.c("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody", body);
        try {
            editor = ((CacheResponseBody) body).getSnapshot().edit();
            if (editor == null) {
                return;
            }
            try {
                entry.writeTo(editor);
                editor.commit();
            } catch (IOException unused) {
                abortQuietly(editor);
            }
        } catch (IOException unused2) {
            editor = null;
        }
    }

    public final Iterator<String> urls() {
        return new Cache$urls$1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(u uVar, i0 i0Var, long j10) {
        this(i0Var, j10, uVar, TaskRunner.INSTANCE);
        h.e("fileSystem", uVar);
        h.e("directory", i0Var);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Cache(java.io.File r3, long r4) {
        /*
            r2 = this;
            java.lang.String r0 = "directory"
            za.h.e(r0, r3)
            rb.u r0 = rb.u.SYSTEM
            java.lang.String r1 = rb.i0.f11020p
            rb.i0 r3 = j9.v1.v(r3)
            r2.<init>(r0, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.<init>(java.io.File, long):void");
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Entry {
        public static final Companion Companion = new Companion(null);
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final HttpUrl url;
        private final Headers varyHeaders;

        /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            private Companion() {
            }
        }

        static {
            StringBuilder sb2 = new StringBuilder();
            Platform.Companion companion = Platform.Companion;
            sb2.append(companion.get().getPrefix());
            sb2.append("-Sent-Millis");
            SENT_MILLIS = sb2.toString();
            RECEIVED_MILLIS = companion.get().getPrefix() + "-Received-Millis";
        }

        public Entry(s0 s0Var) {
            h.e("rawSource", s0Var);
            try {
                m0 c10 = rb.b.c(s0Var);
                String y8 = c10.y(Long.MAX_VALUE);
                HttpUrl parse = HttpUrl.Companion.parse(y8);
                if (parse == null) {
                    IOException iOException = new IOException("Cache corruption for ".concat(y8));
                    Platform.Companion.get().log("cache corruption", 5, iOException);
                    throw iOException;
                }
                this.url = parse;
                this.requestMethod = c10.y(Long.MAX_VALUE);
                Headers.Builder builder = new Headers.Builder();
                int readInt$okhttp = Cache.Companion.readInt$okhttp(c10);
                for (int i10 = 0; i10 < readInt$okhttp; i10++) {
                    builder.addLenient$okhttp(c10.y(Long.MAX_VALUE));
                }
                this.varyHeaders = builder.build();
                StatusLine parse2 = StatusLine.Companion.parse(c10.y(Long.MAX_VALUE));
                this.protocol = parse2.protocol;
                this.code = parse2.code;
                this.message = parse2.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt$okhttp2 = Cache.Companion.readInt$okhttp(c10);
                for (int i11 = 0; i11 < readInt$okhttp2; i11++) {
                    builder2.addLenient$okhttp(c10.y(Long.MAX_VALUE));
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (this.url.isHttps()) {
                    String y10 = c10.y(Long.MAX_VALUE);
                    if (y10.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + y10 + '\"');
                    }
                    this.handshake = Handshake.Companion.get(!c10.t() ? TlsVersion.Companion.forJavaName(c10.y(Long.MAX_VALUE)) : TlsVersion.SSL_3_0, CipherSuite.Companion.forJavaName(c10.y(Long.MAX_VALUE)), readCertificateList(c10), readCertificateList(c10));
                } else {
                    this.handshake = null;
                }
                s0Var.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    f.d(s0Var, th);
                    throw th2;
                }
            }
        }

        private final List<Certificate> readCertificateList(n nVar) {
            int readInt$okhttp = Cache.Companion.readInt$okhttp(nVar);
            if (readInt$okhttp == -1) {
                return ma.p.f9051o;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt$okhttp);
                for (int i10 = 0; i10 < readInt$okhttp; i10++) {
                    String p10 = nVar.p();
                    l lVar = new l();
                    o oVar = o.f11048r;
                    o D = w1.D(p10);
                    if (D == null) {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                    lVar.W(D);
                    arrayList.add(certificateFactory.generateCertificate(new j(lVar, 0)));
                }
                return arrayList;
            } catch (CertificateException e7) {
                throw new IOException(e7.getMessage());
            }
        }

        private final void writeCertList(m mVar, List<? extends Certificate> list) {
            try {
                mVar.F(list.size()).writeByte(10);
                Iterator<? extends Certificate> it = list.iterator();
                while (it.hasNext()) {
                    byte[] encoded = it.next().getEncoded();
                    o oVar = o.f11048r;
                    h.b(encoded);
                    mVar.E(w1.J(encoded).a()).writeByte(10);
                }
            } catch (CertificateEncodingException e7) {
                throw new IOException(e7.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            h.e("request", request);
            h.e("response", response);
            return h.a(this.url, request.url()) && h.a(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            h.e("snapshot", snapshot);
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request(this.url, this.varyHeaders, this.requestMethod, null, 8, null)).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(DiskLruCache.Editor editor) {
            h.e("editor", editor);
            l0 b2 = rb.b.b(editor.newSink(0));
            try {
                b2.E(this.url.toString());
                b2.writeByte(10);
                b2.E(this.requestMethod);
                b2.writeByte(10);
                b2.F(this.varyHeaders.size());
                b2.writeByte(10);
                int size = this.varyHeaders.size();
                for (int i10 = 0; i10 < size; i10++) {
                    b2.E(this.varyHeaders.name(i10));
                    b2.E(": ");
                    b2.E(this.varyHeaders.value(i10));
                    b2.writeByte(10);
                }
                b2.E(new StatusLine(this.protocol, this.code, this.message).toString());
                b2.writeByte(10);
                b2.F(this.responseHeaders.size() + 2);
                b2.writeByte(10);
                int size2 = this.responseHeaders.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    b2.E(this.responseHeaders.name(i11));
                    b2.E(": ");
                    b2.E(this.responseHeaders.value(i11));
                    b2.writeByte(10);
                }
                b2.E(SENT_MILLIS);
                b2.E(": ");
                b2.F(this.sentRequestMillis);
                b2.writeByte(10);
                b2.E(RECEIVED_MILLIS);
                b2.E(": ");
                b2.F(this.receivedResponseMillis);
                b2.writeByte(10);
                if (this.url.isHttps()) {
                    b2.writeByte(10);
                    Handshake handshake = this.handshake;
                    h.b(handshake);
                    b2.E(handshake.cipherSuite().javaName());
                    b2.writeByte(10);
                    writeCertList(b2, this.handshake.peerCertificates());
                    writeCertList(b2, this.handshake.localCertificates());
                    b2.E(this.handshake.tlsVersion().javaName());
                    b2.writeByte(10);
                }
                b2.close();
            } finally {
            }
        }

        public Entry(Response response) {
            h.e("response", response);
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
