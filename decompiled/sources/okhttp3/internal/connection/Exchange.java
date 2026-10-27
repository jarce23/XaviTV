package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import rb.b;
import rb.l;
import rb.q0;
import rb.r0;
import rb.s0;
import rb.w;
import rb.x;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class RequestBodySink extends w {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        private final boolean isSocket;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange exchange, q0 q0Var, long j10, boolean z10) {
            super(q0Var);
            h.e("delegate", q0Var);
            this.this$0 = exchange;
            this.contentLength = j10;
            this.isSocket = z10;
            this.invokeStartEvent = z10;
        }

        private final IOException complete(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            return Exchange.bodyComplete$default(this.this$0, this.bytesReceived, this.isSocket, false, true, iOException, 4, null);
        }

        @Override // rb.w, rb.q0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j10 = this.contentLength;
            if (j10 != -1 && this.bytesReceived != j10) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e7) {
                IOException complete = complete(e7);
                h.b(complete);
                throw complete;
            }
        }

        @Override // rb.w, rb.q0, java.io.Flushable
        public void flush() {
            try {
                super.flush();
            } catch (IOException e7) {
                IOException complete = complete(e7);
                h.b(complete);
                throw complete;
            }
        }

        @Override // rb.w, rb.q0
        public void write(l lVar, long j10) {
            h.e("source", lVar);
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.contentLength;
            if (j11 != -1 && this.bytesReceived + j10 > j11) {
                throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j10));
            }
            try {
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().requestBodyStart(this.this$0.getCall$okhttp());
                }
                super.write(lVar, j10);
                this.bytesReceived += j10;
            } catch (IOException e7) {
                IOException complete = complete(e7);
                h.b(complete);
                throw complete;
            }
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class ResponseBodySource extends x {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        private final boolean isSocket;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange exchange, s0 s0Var, long j10, boolean z10) {
            super(s0Var);
            h.e("delegate", s0Var);
            this.this$0 = exchange;
            this.contentLength = j10;
            this.isSocket = z10;
            this.invokeStartEvent = true;
            if (j10 == 0) {
                complete(null);
            }
        }

        @Override // rb.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e7) {
                IOException complete = complete(e7);
                h.b(complete);
                throw complete;
            }
        }

        public final IOException complete(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            if (iOException == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
            }
            return Exchange.bodyComplete$default(this.this$0, this.bytesReceived, this.isSocket, true, false, iOException, 8, null);
        }

        @Override // rb.x, rb.s0
        public long read(l lVar, long j10) {
            h.e("sink", lVar);
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            try {
                long read = delegate().read(lVar, j10);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                }
                if (read == -1) {
                    complete(null);
                    return -1L;
                }
                long j11 = this.bytesReceived + read;
                long j12 = this.contentLength;
                if (j12 != -1 && j11 > j12) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j11);
                }
                this.bytesReceived = j11;
                if (this.this$0.codec.isResponseComplete()) {
                    complete(null);
                }
                return read;
            } catch (IOException e7) {
                IOException complete = complete(e7);
                h.b(complete);
                throw complete;
            }
        }
    }

    public Exchange(RealCall realCall, EventListener eventListener, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        h.e("call", realCall);
        h.e("eventListener", eventListener);
        h.e("finder", exchangeFinder);
        h.e("codec", exchangeCodec);
        this.call = realCall;
        this.eventListener = eventListener;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
    }

    public static /* synthetic */ IOException bodyComplete$default(Exchange exchange, long j10, boolean z10, boolean z11, boolean z12, IOException iOException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = -1;
        }
        return exchange.bodyComplete(j10, z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, iOException);
    }

    private final void trackFailure(IOException iOException) {
        this.hasFailure = true;
        this.codec.getCarrier().trackFailure(this.call, iOException);
    }

    public final IOException bodyComplete(long j10, boolean z10, boolean z11, boolean z12, IOException iOException) {
        if (iOException != null) {
            trackFailure(iOException);
        }
        if (z12) {
            if (iOException != null) {
                this.eventListener.requestFailed(this.call, iOException);
            } else {
                this.eventListener.requestBodyEnd(this.call, j10);
            }
        }
        if (z11) {
            if (iOException != null) {
                this.eventListener.responseFailed(this.call, iOException);
            } else {
                this.eventListener.responseBodyEnd(this.call, j10);
            }
        }
        return this.call.messageDone$okhttp(this, z12 && !z10, z11 && !z10, z11 && z10, z12 && z10, iOException);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final q0 createRequestBody(Request request, boolean z10) {
        h.e("request", request);
        this.isDuplex = z10;
        RequestBody body = request.body();
        h.b(body);
        long contentLength = body.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request, contentLength), contentLength, false);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, true, true, null);
    }

    public final void finishRequest() {
        try {
            this.codec.finishRequest();
        } catch (IOException e7) {
            this.eventListener.requestFailed(this.call, e7);
            trackFailure(e7);
            throw e7;
        }
    }

    public final void flushRequest() {
        try {
            this.codec.flushRequest();
        } catch (IOException e7) {
            this.eventListener.requestFailed(this.call, e7);
            trackFailure(e7);
            throw e7;
        }
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final RealConnection getConnection$okhttp() {
        ExchangeCodec.Carrier carrier = this.codec.getCarrier();
        RealConnection realConnection = carrier instanceof RealConnection ? (RealConnection) carrier : null;
        if (realConnection != null) {
            return realConnection;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels");
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !h.a(this.finder.getRoutePlanner().getAddress().url().host(), this.codec.getCarrier().getRoute().address().url().host());
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getCarrier().noNewExchanges();
    }

    public final void noRequestBody() {
        RealCall.messageDone$okhttp$default(this.call, this, true, false, false, false, null, 28, null);
    }

    public final ResponseBody openResponseBody(Response response) {
        Exchange exchange;
        h.e("response", response);
        try {
            String header$default = Response.header$default(response, "Content-Type", null, 2, null);
            long reportedContentLength = this.codec.reportedContentLength(response);
            exchange = this;
            try {
                return new RealResponseBody(header$default, reportedContentLength, b.c(new ResponseBodySource(exchange, this.codec.openResponseBodySource(response), reportedContentLength, false)));
            } catch (IOException e7) {
                e = e7;
                IOException iOException = e;
                exchange.eventListener.responseFailed(exchange.call, iOException);
                trackFailure(iOException);
                throw iOException;
            }
        } catch (IOException e8) {
            e = e8;
            exchange = this;
        }
    }

    public final Headers peekTrailers() {
        return this.codec.peekTrailers();
    }

    public final Response.Builder readResponseHeaders(boolean z10) {
        try {
            Response.Builder readResponseHeaders = this.codec.readResponseHeaders(z10);
            if (readResponseHeaders == null) {
                return readResponseHeaders;
            }
            readResponseHeaders.initExchange$okhttp(this);
            return readResponseHeaders;
        } catch (IOException e7) {
            this.eventListener.responseFailed(this.call, e7);
            trackFailure(e7);
            throw e7;
        }
    }

    public final void responseHeadersEnd(Response response) {
        h.e("response", response);
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final r0 upgradeToSocket() {
        this.call.upgradeToSocket();
        ExchangeCodec.Carrier carrier = this.codec.getCarrier();
        h.c("null cannot be cast to non-null type okhttp3.internal.connection.RealConnection", carrier);
        ((RealConnection) carrier).useAsSocket$okhttp();
        return new r0() { // from class: okhttp3.internal.connection.Exchange$upgradeToSocket$1
            private final Exchange.RequestBodySink sink;
            private final Exchange.ResponseBodySource source;

            {
                this.sink = new Exchange.RequestBodySink(Exchange.this, Exchange.this.codec.getSocket().getSink(), -1L, true);
                this.source = new Exchange.ResponseBodySource(Exchange.this, Exchange.this.codec.getSocket().getSource(), -1L, true);
            }

            @Override // rb.r0
            public void cancel() {
                Exchange.this.cancel();
            }

            @Override // rb.r0
            public Exchange.RequestBodySink getSink() {
                return this.sink;
            }

            @Override // rb.r0
            public Exchange.ResponseBodySource getSource() {
                return this.source;
            }
        };
    }

    public final void writeRequestHeaders(Request request) {
        h.e("request", request);
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e7) {
            this.eventListener.requestFailed(this.call, e7);
            trackFailure(e7);
            throw e7;
        }
    }
}
