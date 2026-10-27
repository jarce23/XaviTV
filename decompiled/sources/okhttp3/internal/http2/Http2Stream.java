package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.http2.flowcontrol.WindowCounter;
import rb.l;
import rb.n;
import rb.q0;
import rb.r0;
import rb.s0;
import rb.v0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Http2Stream implements Lockable, r0 {
    public static final Companion Companion = new Companion(null);
    public static final long EMIT_BUFFER_SIZE = 16384;
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private final WindowCounter readBytes;
    private final StreamTimeout readTimeout;
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(za.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class FramingSource implements s0 {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private Headers trailers;
        private final l receiveBuffer = new l();
        private final l readBuffer = new l();

        public FramingSource(long j10, boolean z10) {
            this.maxByteCount = j10;
            this.finished = z10;
        }

        private final void updateConnectionFlowControl(long j10) {
            Http2Stream http2Stream = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                Http2Stream.this.getConnection().updateConnectionFlowControl$okhttp(j10);
                return;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long j10;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                this.closed = true;
                l lVar = this.readBuffer;
                j10 = lVar.f11035p;
                lVar.a();
                za.h.c("null cannot be cast to non-null type java.lang.Object", http2Stream);
                http2Stream.notifyAll();
            }
            if (j10 > 0) {
                updateConnectionFlowControl(j10);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final l getReadBuffer() {
            return this.readBuffer;
        }

        public final l getReceiveBuffer() {
            return this.receiveBuffer;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        @Override // rb.s0
        public long read(l lVar, long j10) {
            IOException iOException;
            boolean z10;
            long j11;
            za.h.e("sink", lVar);
            if (j10 < 0) {
                throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount < 0: ").toString());
            }
            do {
                Http2Stream http2Stream = Http2Stream.this;
                synchronized (http2Stream) {
                    boolean doReadTimeout = http2Stream.doReadTimeout();
                    if (doReadTimeout) {
                        http2Stream.getReadTimeout$okhttp().enter();
                    }
                    try {
                        if (http2Stream.getErrorCode$okhttp() == null || this.finished) {
                            iOException = null;
                        } else {
                            iOException = http2Stream.getErrorException$okhttp();
                            if (iOException == null) {
                                ErrorCode errorCode$okhttp = http2Stream.getErrorCode$okhttp();
                                za.h.b(errorCode$okhttp);
                                iOException = new StreamResetException(errorCode$okhttp);
                            }
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        l lVar2 = this.readBuffer;
                        long j12 = lVar2.f11035p;
                        z10 = false;
                        if (j12 > 0) {
                            j11 = lVar2.read(lVar, Math.min(j10, j12));
                            WindowCounter.update$default(http2Stream.getReadBytes(), j11, 0L, 2, null);
                            long unacknowledged = http2Stream.getReadBytes().getUnacknowledged();
                            if (iOException == null && unacknowledged >= http2Stream.getConnection().getOkHttpSettings().getInitialWindowSize() / 2) {
                                http2Stream.getConnection().writeWindowUpdateLater$okhttp(http2Stream.getId(), unacknowledged);
                                WindowCounter.update$default(http2Stream.getReadBytes(), 0L, unacknowledged, 1, null);
                            }
                        } else {
                            if (!this.finished && iOException == null) {
                                http2Stream.waitForIo$okhttp();
                                z10 = true;
                            }
                            j11 = -1;
                        }
                        if (doReadTimeout) {
                            http2Stream.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                        }
                    } finally {
                    }
                }
                Http2Stream.this.getConnection().getFlowControlListener$okhttp().receivingStreamWindowChanged(Http2Stream.this.getId(), Http2Stream.this.getReadBytes(), this.readBuffer.f11035p);
            } while (z10);
            if (j11 != -1) {
                return j11;
            }
            if (iOException == null) {
                return -1L;
            }
            throw iOException;
        }

        public final void receive$okhttp(n nVar, long j10) {
            boolean z10;
            boolean z11;
            za.h.e("source", nVar);
            Http2Stream http2Stream = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            long j11 = j10;
            while (j11 > 0) {
                synchronized (Http2Stream.this) {
                    z10 = this.finished;
                    z11 = this.readBuffer.f11035p + j11 > this.maxByteCount;
                }
                if (z11) {
                    nVar.skip(j11);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z10) {
                    nVar.skip(j11);
                    return;
                }
                long read = nVar.read(this.receiveBuffer, j11);
                if (read == -1) {
                    throw new EOFException();
                }
                j11 -= read;
                Http2Stream http2Stream2 = Http2Stream.this;
                synchronized (http2Stream2) {
                    try {
                        if (this.closed) {
                            this.receiveBuffer.a();
                        } else {
                            l lVar = this.readBuffer;
                            boolean z12 = lVar.f11035p == 0;
                            lVar.d(this.receiveBuffer);
                            if (z12) {
                                za.h.c("null cannot be cast to non-null type java.lang.Object", http2Stream2);
                                http2Stream2.notifyAll();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            updateConnectionFlowControl(j10);
            Http2Stream.this.getConnection().getFlowControlListener$okhttp().receivingStreamWindowChanged(Http2Stream.this.getId(), Http2Stream.this.getReadBytes(), this.readBuffer.f11035p);
        }

        public final void setClosed$okhttp(boolean z10) {
            this.closed = z10;
        }

        public final void setFinished$okhttp(boolean z10) {
            this.finished = z10;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // rb.s0
        public v0 timeout() {
            return Http2Stream.this.getReadTimeout$okhttp();
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class StreamTimeout extends rb.g {
        public StreamTimeout() {
        }

        public final void exitAndThrowIfTimedOut() {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // rb.g
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // rb.g
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    public Http2Stream(int i10, Http2Connection http2Connection, boolean z10, boolean z11, Headers headers) {
        za.h.e("connection", http2Connection);
        this.id = i10;
        this.connection = http2Connection;
        this.readBytes = new WindowCounter(i10);
        this.writeBytesMaximum = http2Connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(http2Connection.getOkHttpSettings().getInitialWindowSize(), z11);
        this.sink = new FramingSink(z10);
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (headers == null) {
            if (!isLocallyInitiated()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (isLocallyInitiated()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(headers);
        }
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException iOException) {
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (getErrorCode$okhttp() != null) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = iOException;
            notifyAll();
            if (getSource().getFinished$okhttp()) {
                if (getSink().getFinished()) {
                    return false;
                }
            }
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doReadTimeout() {
        return !this.connection.getClient$okhttp() || getSink().getClosed() || getSink().getFinished();
    }

    public static /* synthetic */ Headers takeHeaders$default(Http2Stream http2Stream, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return http2Stream.takeHeaders(z10);
    }

    public final void addBytesToWriteWindow(long j10) {
        this.writeBytesMaximum += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    @Override // rb.r0
    public void cancel() {
        closeLater(ErrorCode.CANCEL);
    }

    public final void cancelStreamIfNecessary$okhttp() {
        boolean z10;
        boolean isOpen;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (getSource().getFinished$okhttp() || !getSource().getClosed$okhttp() || (!getSink().getFinished() && !getSink().getClosed())) {
                    z10 = false;
                    isOpen = isOpen();
                }
                z10 = true;
                isOpen = isOpen();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            close(ErrorCode.CANCEL, null);
        } else {
            if (isOpen) {
                return;
            }
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() {
        if (getSink().getClosed()) {
            throw new IOException("stream closed");
        }
        if (getSink().getFinished()) {
            throw new IOException("stream finished");
        }
        if (getErrorCode$okhttp() != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode$okhttp = getErrorCode$okhttp();
            za.h.b(errorCode$okhttp);
            throw new StreamResetException(errorCode$okhttp);
        }
    }

    public final void close(ErrorCode errorCode, IOException iOException) {
        za.h.e("rstStatusCode", errorCode);
        if (closeInternal(errorCode, iOException)) {
            this.connection.writeSynReset$okhttp(this.id, errorCode);
        }
    }

    public final void closeLater(ErrorCode errorCode) {
        za.h.e("errorCode", errorCode);
        if (closeInternal(errorCode, null)) {
            this.connection.writeSynResetLater$okhttp(this.id, errorCode);
        }
    }

    public final void enqueueTrailers(Headers headers) {
        za.h.e("trailers", headers);
        synchronized (this) {
            if (getSink().getFinished()) {
                throw new IllegalStateException("already finished");
            }
            if (headers.size() == 0) {
                throw new IllegalArgumentException("trailers.size() == 0");
            }
            getSink().setTrailers(headers);
        }
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final ErrorCode getErrorCode$okhttp() {
        ErrorCode errorCode;
        synchronized (this) {
            errorCode = this.errorCode;
        }
        return errorCode;
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final WindowCounter getReadBytes() {
        return this.readBytes;
    }

    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.getClient$okhttp() == ((this.id & 1) == 1);
    }

    public final boolean isOpen() {
        synchronized (this) {
            try {
                if (getErrorCode$okhttp() != null) {
                    return false;
                }
                if (!getSource().getFinished$okhttp()) {
                    if (getSource().getClosed$okhttp()) {
                    }
                    return true;
                }
                if (getSink().getFinished() || getSink().getClosed()) {
                    if (this.hasResponseHeaders) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isSourceComplete() {
        boolean z10;
        synchronized (this) {
            if (getSource().getFinished$okhttp()) {
                z10 = getSource().getReadBuffer().t();
            }
        }
        return z10;
    }

    public final Headers peekTrailers() {
        synchronized (this) {
            if (getSource().getFinished$okhttp() && getSource().getReceiveBuffer().t() && getSource().getReadBuffer().t()) {
                Headers trailers = getSource().getTrailers();
                if (trailers == null) {
                    trailers = Headers.EMPTY;
                }
                return trailers;
            }
            if (getErrorCode$okhttp() == null) {
                return null;
            }
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode$okhttp = getErrorCode$okhttp();
            za.h.b(errorCode$okhttp);
            throw new StreamResetException(errorCode$okhttp);
        }
    }

    public final v0 readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(n nVar, int i10) {
        za.h.e("source", nVar);
        if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(this)) {
            getSource().receive$okhttp(nVar, i10);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:10:0x0035, B:12:0x003a, B:14:0x0042, B:17:0x004b, B:19:0x005e, B:20:0x0065, B:27:0x0055), top: B:9:0x0035 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void receiveHeaders(okhttp3.Headers r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            za.h.e(r0, r3)
            boolean r0 = okhttp3.internal._UtilJvmKt.assertionsEnabled
            if (r0 == 0) goto L34
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L10
            goto L34
        L10:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "Thread "
            r4.<init>(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L34:
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L53
            r1 = 1
            if (r0 == 0) goto L55
            java.lang.String r0 = ":status"
            java.lang.String r0 = r3.get(r0)     // Catch: java.lang.Throwable -> L53
            if (r0 != 0) goto L55
            java.lang.String r0 = ":method"
            java.lang.String r0 = r3.get(r0)     // Catch: java.lang.Throwable -> L53
            if (r0 == 0) goto L4b
            goto L55
        L4b:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.getSource()     // Catch: java.lang.Throwable -> L53
            r0.setTrailers(r3)     // Catch: java.lang.Throwable -> L53
            goto L5c
        L53:
            r3 = move-exception
            goto L77
        L55:
            r2.hasResponseHeaders = r1     // Catch: java.lang.Throwable -> L53
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch: java.lang.Throwable -> L53
            r0.add(r3)     // Catch: java.lang.Throwable -> L53
        L5c:
            if (r4 == 0) goto L65
            okhttp3.internal.http2.Http2Stream$FramingSource r3 = r2.getSource()     // Catch: java.lang.Throwable -> L53
            r3.setFinished$okhttp(r1)     // Catch: java.lang.Throwable -> L53
        L65:
            boolean r3 = r2.isOpen()     // Catch: java.lang.Throwable -> L53
            r2.notifyAll()     // Catch: java.lang.Throwable -> L53
            monitor-exit(r2)
            if (r3 != 0) goto L76
            okhttp3.internal.http2.Http2Connection r3 = r2.connection
            int r4 = r2.id
            r3.removeStream$okhttp(r4)
        L76:
            return
        L77:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.receiveHeaders(okhttp3.Headers, boolean):void");
    }

    public final void receiveRstStream(ErrorCode errorCode) {
        za.h.e("errorCode", errorCode);
        synchronized (this) {
            if (getErrorCode$okhttp() == null) {
                this.errorCode = errorCode;
                notifyAll();
            }
        }
    }

    public final void setErrorCode$okhttp(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(IOException iOException) {
        this.errorException = iOException;
    }

    public final void setWriteBytesMaximum$okhttp(long j10) {
        this.writeBytesMaximum = j10;
    }

    public final void setWriteBytesTotal$okhttp(long j10) {
        this.writeBytesTotal = j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #0 {all -> 0x001a, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0011, B:13:0x001f, B:18:0x0029, B:25:0x0032, B:26:0x0037, B:30:0x0038, B:32:0x0040, B:35:0x004f, B:40:0x0060, B:39:0x0054, B:15:0x0024), top: B:2:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0001 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Headers takeHeaders(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
        L1:
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch: java.lang.Throwable -> L1a
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L38
            okhttp3.internal.http2.ErrorCode r0 = r2.getErrorCode$okhttp()     // Catch: java.lang.Throwable -> L1a
            if (r0 != 0) goto L38
            if (r3 != 0) goto L1c
            boolean r0 = r2.doReadTimeout()     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L18
            goto L1c
        L18:
            r0 = 0
            goto L1d
        L1a:
            r3 = move-exception
            goto L61
        L1c:
            r0 = 1
        L1d:
            if (r0 == 0) goto L24
            okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r2.readTimeout     // Catch: java.lang.Throwable -> L1a
            r1.enter()     // Catch: java.lang.Throwable -> L1a
        L24:
            r2.waitForIo$okhttp()     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L1
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.readTimeout     // Catch: java.lang.Throwable -> L1a
            r0.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> L1a
            goto L1
        L2f:
            r3 = move-exception
            if (r0 == 0) goto L37
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.readTimeout     // Catch: java.lang.Throwable -> L1a
            r0.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> L1a
        L37:
            throw r3     // Catch: java.lang.Throwable -> L1a
        L38:
            java.util.ArrayDeque<okhttp3.Headers> r3 = r2.headersQueue     // Catch: java.lang.Throwable -> L1a
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L4f
            java.util.ArrayDeque<okhttp3.Headers> r3 = r2.headersQueue     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r3 = r3.removeFirst()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r0 = "removeFirst(...)"
            za.h.d(r0, r3)     // Catch: java.lang.Throwable -> L1a
            okhttp3.Headers r3 = (okhttp3.Headers) r3     // Catch: java.lang.Throwable -> L1a
            monitor-exit(r2)
            return r3
        L4f:
            java.io.IOException r3 = r2.errorException     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L54
            goto L60
        L54:
            okhttp3.internal.http2.StreamResetException r3 = new okhttp3.internal.http2.StreamResetException     // Catch: java.lang.Throwable -> L1a
            okhttp3.internal.http2.ErrorCode r0 = r2.getErrorCode$okhttp()     // Catch: java.lang.Throwable -> L1a
            za.h.b(r0)     // Catch: java.lang.Throwable -> L1a
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L1a
        L60:
            throw r3     // Catch: java.lang.Throwable -> L1a
        L61:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.takeHeaders(boolean):okhttp3.Headers");
    }

    public final void waitForIo$okhttp() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(List<Header> list, boolean z10, boolean z11) {
        za.h.e("responseHeaders", list);
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (z10) {
                getSink().setFinished(true);
                notifyAll();
            }
        }
        if (!z11) {
            synchronized (this) {
                z11 = this.connection.getWriteBytesTotal() >= this.connection.getWriteBytesMaximum();
            }
        }
        this.connection.writeHeaders$okhttp(this.id, z10, list);
        if (z11) {
            this.connection.flush();
        }
    }

    public final v0 writeTimeout() {
        return this.writeTimeout;
    }

    @Override // rb.r0
    public FramingSink getSink() {
        return this.sink;
    }

    @Override // rb.r0
    public FramingSource getSource() {
        return this.source;
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class FramingSink implements q0 {
        private boolean closed;
        private boolean finished;
        private final l sendBuffer;
        private Headers trailers;

        public FramingSink(boolean z10) {
            this.finished = z10;
            this.sendBuffer = new l();
        }

        /* JADX WARN: Finally extract failed */
        private final void emitFrame(boolean z10) {
            long min;
            boolean z11;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                http2Stream.getWriteTimeout$okhttp().enter();
                while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !this.finished && !this.closed && http2Stream.getErrorCode$okhttp() == null) {
                    try {
                        http2Stream.waitForIo$okhttp();
                    } catch (Throwable th) {
                        http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                http2Stream.checkOutNotClosed$okhttp();
                min = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.sendBuffer.f11035p);
                http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + min);
                z11 = z10 && min == this.sendBuffer.f11035p;
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z11, this.sendBuffer, min);
            } finally {
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            }
        }

        @Override // rb.q0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Http2Stream http2Stream = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                if (this.closed) {
                    return;
                }
                boolean z10 = http2Stream2.getErrorCode$okhttp() == null;
                if (!Http2Stream.this.getSink().finished) {
                    boolean z11 = this.sendBuffer.f11035p > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.f11035p > 0) {
                            emitFrame(false);
                        }
                        Http2Connection connection = Http2Stream.this.getConnection();
                        int id = Http2Stream.this.getId();
                        Headers headers = this.trailers;
                        za.h.b(headers);
                        connection.writeHeaders$okhttp(id, z10, _UtilJvmKt.toHeaderList(headers));
                    } else if (z11) {
                        while (this.sendBuffer.f11035p > 0) {
                            emitFrame(true);
                        }
                    } else if (z10) {
                        Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                    }
                }
                Http2Stream http2Stream3 = Http2Stream.this;
                synchronized (http2Stream3) {
                    this.closed = true;
                    za.h.c("null cannot be cast to non-null type java.lang.Object", http2Stream3);
                    http2Stream3.notifyAll();
                }
                Http2Stream.this.getConnection().flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        @Override // rb.q0, java.io.Flushable
        public void flush() {
            Http2Stream http2Stream = Http2Stream.this;
            if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                http2Stream2.checkOutNotClosed$okhttp();
            }
            while (this.sendBuffer.f11035p > 0) {
                emitFrame(false);
                Http2Stream.this.getConnection().flush();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z10) {
            this.closed = z10;
        }

        public final void setFinished(boolean z10) {
            this.finished = z10;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // rb.q0
        public v0 timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override // rb.q0
        public void write(l lVar, long j10) {
            za.h.e("source", lVar);
            Http2Stream http2Stream = Http2Stream.this;
            if (!_UtilJvmKt.assertionsEnabled || !Thread.holdsLock(http2Stream)) {
                this.sendBuffer.write(lVar, j10);
                while (this.sendBuffer.f11035p >= Http2Stream.EMIT_BUFFER_SIZE) {
                    emitFrame(false);
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
        }

        public /* synthetic */ FramingSink(Http2Stream http2Stream, boolean z10, int i10, za.e eVar) {
            this((i10 & 1) != 0 ? false : z10);
        }
    }
}
