package okhttp3.internal.http1;

import android.support.v4.media.d;
import gb.i;
import gb.p;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.BufferedSocket;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import r.a;
import rb.l;
import rb.m;
import rb.q0;
import rb.s0;
import rb.v0;
import rb.y;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final ExchangeCodec.Carrier carrier;
    private final OkHttpClient client;
    private final HeadersReader headersReader;
    private final BufferedSocket socket;
    private int state;
    private Headers trailers;
    public static final Companion Companion = new Companion(null);
    private static final Headers TRAILERS_RESPONSE_BODY_TRUNCATED = Headers.Companion.of("OkHttp-Response-Body", "Truncated");

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public abstract class AbstractSource implements s0 {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;
        private final y timeout;
        private final HttpUrl url;

        public AbstractSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl) {
            h.e("url", httpUrl);
            this.this$0 = http1ExchangeCodec;
            this.url = httpUrl;
            this.timeout = new y(http1ExchangeCodec.getSocket().getSource().timeout());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public abstract /* synthetic */ void close();

        public final boolean getClosed() {
            return this.closed;
        }

        public final y getTimeout() {
            return this.timeout;
        }

        public final HttpUrl getUrl() {
            return this.url;
        }

        @Override // rb.s0
        public long read(l lVar, long j10) {
            h.e("sink", lVar);
            try {
                return this.this$0.getSocket().getSource().read(lVar, j10);
            } catch (IOException e7) {
                this.this$0.getCarrier().noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                throw e7;
            }
        }

        public final void responseBodyComplete(Headers headers) {
            OkHttpClient okHttpClient;
            CookieJar cookieJar;
            h.e("trailers", headers);
            if (this.this$0.state == 6) {
                return;
            }
            if (this.this$0.state != 5) {
                throw new IllegalStateException("state: " + this.this$0.state);
            }
            this.this$0.detachTimeout(this.timeout);
            this.this$0.trailers = headers;
            this.this$0.state = 6;
            if (headers.size() <= 0 || (okHttpClient = this.this$0.client) == null || (cookieJar = okHttpClient.cookieJar()) == null) {
                return;
            }
            HttpHeaders.receiveHeaders(cookieJar, this.url, headers);
        }

        public final void setClosed(boolean z10) {
            this.closed = z10;
        }

        @Override // rb.s0
        public v0 timeout() {
            return this.timeout;
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class ChunkedSink implements q0 {
        private boolean closed;
        private final y timeout;

        public ChunkedSink() {
            this.timeout = new y(Http1ExchangeCodec.this.getSocket().getSink().timeout());
        }

        @Override // rb.q0, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.getSocket().getSink().E("0\r\n\r\n");
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // rb.q0, java.io.Flushable
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.getSocket().getSink().flush();
        }

        @Override // rb.q0
        public v0 timeout() {
            return this.timeout;
        }

        @Override // rb.q0
        public void write(l lVar, long j10) {
            h.e("source", lVar);
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j10 == 0) {
                return;
            }
            m sink = Http1ExchangeCodec.this.getSocket().getSink();
            sink.g(j10);
            sink.E("\r\n");
            sink.write(lVar, j10);
            sink.E("\r\n");
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl) {
            super(http1ExchangeCodec, httpUrl);
            h.e("url", httpUrl);
            this.this$0 = http1ExchangeCodec;
            this.bytesRemainingInChunk = Http1ExchangeCodec.NO_CHUNK_YET;
            this.hasMoreChunks = true;
        }

        private final void readChunkSize() {
            if (this.bytesRemainingInChunk != Http1ExchangeCodec.NO_CHUNK_YET) {
                this.this$0.getSocket().getSource().p();
            }
            try {
                this.bytesRemainingInChunk = this.this$0.getSocket().getSource().H();
                String obj = i.o0(this.this$0.getSocket().getSource().p()).toString();
                if (this.bytesRemainingInChunk < 0 || (obj.length() > 0 && !p.Y(obj, ";", false))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + obj + '\"');
                }
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    responseBodyComplete(this.this$0.headersReader.readHeaders());
                }
            } catch (NumberFormatException e7) {
                throw new ProtocolException(e7.getMessage());
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getCarrier().noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, rb.s0
        public long read(l lVar, long j10) {
            h.e("sink", lVar);
            if (j10 < 0) {
                throw new IllegalArgumentException(d.n(j10, "byteCount < 0: ").toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed");
            }
            if (!this.hasMoreChunks) {
                return Http1ExchangeCodec.NO_CHUNK_YET;
            }
            long j11 = this.bytesRemainingInChunk;
            if (j11 == 0 || j11 == Http1ExchangeCodec.NO_CHUNK_YET) {
                readChunkSize();
                if (!this.hasMoreChunks) {
                    return Http1ExchangeCodec.NO_CHUNK_YET;
                }
            }
            long read = super.read(lVar, Math.min(j10, this.bytesRemainingInChunk));
            if (read != Http1ExchangeCodec.NO_CHUNK_YET) {
                this.bytesRemainingInChunk -= read;
                return read;
            }
            this.this$0.getCarrier().noNewExchanges();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            throw protocolException;
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FixedLengthSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl, long j10) {
            super(http1ExchangeCodec, httpUrl);
            h.e("url", httpUrl);
            this.this$0 = http1ExchangeCodec;
            this.bytesRemaining = j10;
            if (j10 == 0) {
                responseBodyComplete(Headers.EMPTY);
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getCarrier().noNewExchanges();
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, rb.s0
        public long read(l lVar, long j10) {
            h.e("sink", lVar);
            if (j10 < 0) {
                throw new IllegalArgumentException(d.n(j10, "byteCount < 0: ").toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.bytesRemaining;
            if (j11 == 0) {
                return Http1ExchangeCodec.NO_CHUNK_YET;
            }
            long read = super.read(lVar, Math.min(j11, j10));
            if (read == Http1ExchangeCodec.NO_CHUNK_YET) {
                this.this$0.getCarrier().noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
                throw protocolException;
            }
            long j12 = this.bytesRemaining - read;
            this.bytesRemaining = j12;
            if (j12 == 0) {
                responseBodyComplete(Headers.EMPTY);
            }
            return read;
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class KnownLengthSink implements q0 {
        private boolean closed;
        private final y timeout;

        public KnownLengthSink() {
            this.timeout = new y(Http1ExchangeCodec.this.getSocket().getSink().timeout());
        }

        @Override // rb.q0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // rb.q0, java.io.Flushable
        public void flush() {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.getSocket().getSink().flush();
        }

        @Override // rb.q0
        public v0 timeout() {
            return this.timeout;
        }

        @Override // rb.q0
        public void write(l lVar, long j10) {
            h.e("source", lVar);
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            _UtilCommonKt.checkOffsetAndCount(lVar.f11035p, 0L, j10);
            Http1ExchangeCodec.this.getSocket().getSink().write(lVar, j10);
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownLengthSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl) {
            super(http1ExchangeCodec, httpUrl);
            h.e("url", httpUrl);
            this.this$0 = http1ExchangeCodec;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete(Http1ExchangeCodec.TRAILERS_RESPONSE_BODY_TRUNCATED);
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, rb.s0
        public long read(l lVar, long j10) {
            h.e("sink", lVar);
            if (j10 < 0) {
                throw new IllegalArgumentException(d.n(j10, "byteCount < 0: ").toString());
            }
            if (getClosed()) {
                throw new IllegalStateException("closed");
            }
            if (this.inputExhausted) {
                return Http1ExchangeCodec.NO_CHUNK_YET;
            }
            long read = super.read(lVar, j10);
            if (read != Http1ExchangeCodec.NO_CHUNK_YET) {
                return read;
            }
            this.inputExhausted = true;
            responseBodyComplete(Headers.EMPTY);
            return Http1ExchangeCodec.NO_CHUNK_YET;
        }
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, ExchangeCodec.Carrier carrier, BufferedSocket bufferedSocket) {
        h.e("carrier", carrier);
        h.e("socket", bufferedSocket);
        this.client = okHttpClient;
        this.carrier = carrier;
        this.socket = bufferedSocket;
        this.headersReader = new HeadersReader(getSocket().getSource());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detachTimeout(y yVar) {
        v0 v0Var = yVar.f11077a;
        v0 v0Var2 = v0.NONE;
        h.e("delegate", v0Var2);
        yVar.f11077a = v0Var2;
        v0Var.clearDeadline();
        v0Var.clearTimeout();
    }

    private final boolean isChunked(Response response) {
        return "chunked".equalsIgnoreCase(Response.header$default(response, "Transfer-Encoding", null, 2, null));
    }

    private final q0 newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final s0 newChunkedSource(HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(this, httpUrl);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final s0 newFixedLengthSource(HttpUrl httpUrl, long j10) {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(this, httpUrl, j10);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final q0 newKnownLengthSink() {
        if (this.state == 1) {
            this.state = 2;
            return new KnownLengthSink();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final s0 newUnknownLengthSource(HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            getCarrier().noNewExchanges();
            return new UnknownLengthSource(this, httpUrl);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        getCarrier().mo145cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public q0 createRequestBody(Request request, long j10) {
        h.e("request", request);
        RequestBody body = request.body();
        if (body != null && body.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (isChunked(request)) {
            return newChunkedSink();
        }
        if (j10 != NO_CHUNK_YET) {
            return newKnownLengthSink();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        getSocket().getSink().flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        getSocket().getSink().flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public ExchangeCodec.Carrier getCarrier() {
        return this.carrier;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public boolean isResponseComplete() {
        return this.state == 6;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public s0 openResponseBodySource(Response response) {
        h.e("response", response);
        if (!HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(response.request().url(), 0L);
        }
        if (isChunked(response)) {
            return newChunkedSource(response.request().url());
        }
        long headersContentLength = _UtilJvmKt.headersContentLength(response);
        return headersContentLength != NO_CHUNK_YET ? newFixedLengthSource(response.request().url(), headersContentLength) : newUnknownLengthSource(response.request().url());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Headers peekTrailers() {
        Headers headers = this.trailers;
        if (headers == TRAILERS_RESPONSE_BODY_TRUNCATED) {
            throw new IOException("Trailers cannot be read because the response body was truncated");
        }
        int i10 = this.state;
        if (i10 == 5 || i10 == 6) {
            return headers;
        }
        throw new IllegalStateException(("Trailers cannot be read because the state is " + this.state).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean z10) {
        int i10 = this.state;
        if (i10 != 0 && i10 != 1 && i10 != 2 && i10 != 3) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        try {
            StatusLine parse = StatusLine.Companion.parse(this.headersReader.readLine());
            Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(this.headersReader.readHeaders());
            if (z10 && parse.code == 100) {
                return null;
            }
            int i11 = parse.code;
            if (i11 == 100) {
                this.state = 3;
                return headers;
            }
            if (102 > i11 || i11 >= 200) {
                this.state = 4;
                return headers;
            }
            this.state = 3;
            return headers;
        } catch (EOFException e7) {
            throw new IOException(a.l("unexpected end of stream on ", getCarrier().getRoute().address().url().redact()), e7);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response response) {
        h.e("response", response);
        if (HttpHeaders.promisesBody(response)) {
            return isChunked(response) ? NO_CHUNK_YET : _UtilJvmKt.headersContentLength(response);
        }
        return 0L;
    }

    public final void skipConnectBody(Response response) {
        h.e("response", response);
        long headersContentLength = _UtilJvmKt.headersContentLength(response);
        if (headersContentLength == NO_CHUNK_YET) {
            return;
        }
        s0 newFixedLengthSource = newFixedLengthSource(response.request().url(), headersContentLength);
        _UtilJvmKt.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        newFixedLengthSource.close();
    }

    public final void writeRequest(Headers headers, String str) {
        h.e("headers", headers);
        h.e("requestLine", str);
        if (this.state != 0) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        getSocket().getSink().E(str).E("\r\n");
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            getSocket().getSink().E(headers.name(i10)).E(": ").E(headers.value(i10)).E("\r\n");
        }
        getSocket().getSink().E("\r\n");
        this.state = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request request) {
        h.e("request", request);
        RequestLine requestLine = RequestLine.INSTANCE;
        Proxy.Type type = getCarrier().getRoute().proxy().type();
        h.d("type(...)", type);
        writeRequest(request.headers(), requestLine.get(request, type));
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public BufferedSocket getSocket() {
        return this.socket;
    }

    private final boolean isChunked(Request request) {
        return "chunked".equalsIgnoreCase(request.header("Transfer-Encoding"));
    }
}
