package okhttp3.internal.ws;

import com.bumptech.glide.f;
import j9.w1;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import la.i;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.BufferedSocket;
import okhttp3.internal.connection.BufferedSocketKt;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http2.b;
import okhttp3.internal.ws.WebSocketReader;
import r.a;
import rb.o;
import rb.q0;
import rb.r0;
import rb.s0;
import za.e;
import za.h;
import za.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback, Lockable {
    public static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<o> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private r0 socket;
    private TaskQueue taskQueue;
    private final long webSocketCloseTimeout;
    private WebSocketWriter writer;
    private Task writerTask;
    public static final Companion Companion = new Companion(null);
    private static final List<Protocol> ONLY_HTTP1 = f.t(Protocol.HTTP_1_1);

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final o reason;

        public Close(int i10, o oVar, long j10) {
            this.code = i10;
            this.reason = oVar;
            this.cancelAfterCloseMillis = j10;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        public final o getReason() {
            return this.reason;
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
    public static final class Message {
        private final o data;
        private final int formatOpcode;

        public Message(int i10, o oVar) {
            h.e("data", oVar);
            this.formatOpcode = i10;
            this.data = oVar;
        }

        public final o getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                return RealWebSocket.this.writeOneFrame$okhttp() ? 0L : -1L;
            } catch (IOException e7) {
                RealWebSocket.failWebSocket$default(RealWebSocket.this, e7, null, true, 2, null);
                return -1L;
            }
        }
    }

    public RealWebSocket(TaskRunner taskRunner, Request request, WebSocketListener webSocketListener, Random random, long j10, WebSocketExtensions webSocketExtensions, long j11, long j12) {
        h.e("taskRunner", taskRunner);
        h.e("originalRequest", request);
        h.e("listener", webSocketListener);
        h.e("random", random);
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random;
        this.pingIntervalMillis = j10;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j11;
        this.webSocketCloseTimeout = j12;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (!"GET".equals(request.method())) {
            throw new IllegalArgumentException(("Request must be GET: " + request.method()).toString());
        }
        o oVar = o.f11048r;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = w1.J(bArr).a();
    }

    public static /* synthetic */ void failWebSocket$default(RealWebSocket realWebSocket, Exception exc, Response response, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            response = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        realWebSocket.failWebSocket(exc, response, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i failWebSocket$lambda$0$0(m mVar) {
        _UtilCommonKt.closeQuietly((Closeable) mVar.f14177o);
        return i.f8335a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i finishReader$lambda$0$0(WebSocketWriter webSocketWriter) {
        _UtilCommonKt.closeQuietly(webSocketWriter);
        return i.f8335a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long initReaderAndWriter$lambda$0$0(RealWebSocket realWebSocket, long j10) {
        realWebSocket.writePingFrame$okhttp();
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        Integer num = webSocketExtensions.serverMaxWindowBits;
        if (num == null) {
            return true;
        }
        int intValue = num.intValue();
        return 8 <= intValue && intValue < 16;
    }

    private final void runWriter() {
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0L, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i writeOneFrame$lambda$0$0(RealWebSocket realWebSocket) {
        realWebSocket.cancel();
        return i.f8335a;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call = this.call;
        h.b(call);
        call.cancel();
    }

    public final r0 checkUpgradeSuccess$okhttp(Response response) {
        h.e("response", response);
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
        String header$default = Response.header$default(response, "Connection", null, 2, null);
        if (!"Upgrade".equalsIgnoreCase(header$default)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + '\'');
        }
        String header$default2 = Response.header$default(response, "Upgrade", null, 2, null);
        if (!"websocket".equalsIgnoreCase(header$default2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + '\'');
        }
        String header$default3 = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
        o oVar = o.f11048r;
        String a10 = w1.F(this.key + WebSocketProtocol.ACCEPT_MAGIC).c("SHA-1").a();
        if (h.a(a10, header$default3)) {
            r0 socket = response.socket();
            if (socket != null) {
                return socket;
            }
            throw new ProtocolException("Web Socket socket missing: bad interceptor?");
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + a10 + "' but was '" + header$default3 + '\'');
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i10, String str) {
        return close(i10, str, this.webSocketCloseTimeout);
    }

    public final void connect(OkHttpClient okHttpClient) {
        h.e("client", okHttpClient);
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            failWebSocket$default(this, new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null, false, 6, null);
            return;
        }
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        RealCall realCall = new RealCall(build, build2, true);
        this.call = realCall;
        realCall.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket$connect$1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                h.e("call", call);
                h.e("e", iOException);
                RealWebSocket.failWebSocket$default(RealWebSocket.this, iOException, null, false, 6, null);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                s0 source;
                q0 sink;
                boolean isValid;
                ArrayDeque arrayDeque;
                h.e("call", call);
                h.e("response", response);
                try {
                    r0 checkUpgradeSuccess$okhttp = RealWebSocket.this.checkUpgradeSuccess$okhttp(response);
                    WebSocketExtensions parse = WebSocketExtensions.Companion.parse(response.headers());
                    RealWebSocket.this.extensions = parse;
                    isValid = RealWebSocket.this.isValid(parse);
                    if (!isValid) {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        synchronized (realWebSocket) {
                            arrayDeque = realWebSocket.messageAndCloseQueue;
                            arrayDeque.clear();
                            realWebSocket.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    RealWebSocket.this.initReaderAndWriter(_UtilJvmKt.okHttpName + " WebSocket " + build2.url().redact(), BufferedSocketKt.asBufferedSocket(checkUpgradeSuccess$okhttp), true);
                    RealWebSocket.this.loopReader(response);
                } catch (IOException e7) {
                    RealWebSocket.failWebSocket$default(RealWebSocket.this, e7, response, false, 4, null);
                    _UtilCommonKt.closeQuietly(response);
                    r0 socket = response.socket();
                    if (socket != null && (sink = socket.getSink()) != null) {
                        _UtilCommonKt.closeQuietly(sink);
                    }
                    r0 socket2 = response.socket();
                    if (socket2 == null || (source = socket2.getSource()) == null) {
                        return;
                    }
                    _UtilCommonKt.closeQuietly(source);
                }
            }
        });
    }

    public final void failWebSocket(Exception exc, Response response, boolean z10) {
        WebSocketWriter webSocketWriter;
        h.e("e", exc);
        m mVar = new m();
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                this.failed = true;
                r0 r0Var = this.socket;
                WebSocketWriter webSocketWriter2 = this.writer;
                mVar.f14177o = webSocketWriter2;
                this.writer = null;
                if (!z10 && webSocketWriter2 != null) {
                    TaskQueue.execute$default(this.taskQueue, this.name + " writer close", 0L, false, new androidx.activity.e(7, mVar), 2, null);
                }
                this.taskQueue.shutdown();
                try {
                    this.listener.onFailure(this, exc, response);
                    if (r0Var != null) {
                        r0Var.cancel();
                    }
                    if (!z10 || (webSocketWriter = (WebSocketWriter) mVar.f14177o) == null) {
                        return;
                    }
                    _UtilCommonKt.closeQuietly(webSocketWriter);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finishReader() {
        int i10;
        String str;
        WebSocketReader webSocketReader;
        boolean z10;
        synchronized (this) {
            try {
                i10 = this.receivedCloseCode;
                str = this.receivedCloseReason;
                webSocketReader = this.reader;
                this.reader = null;
                if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                    WebSocketWriter webSocketWriter = this.writer;
                    if (webSocketWriter != null) {
                        this.writer = null;
                        TaskQueue.execute$default(this.taskQueue, this.name + " writer close", 0L, false, new androidx.activity.e(6, webSocketWriter), 2, null);
                    }
                    this.taskQueue.shutdown();
                }
                if (!this.failed && this.writer == null) {
                    z10 = this.receivedCloseCode != -1;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            WebSocketListener webSocketListener = this.listener;
            h.b(str);
            webSocketListener.onClosed(this, i10, str);
        }
        if (webSocketReader != null) {
            _UtilCommonKt.closeQuietly(webSocketReader);
        }
    }

    public final Call getCall$okhttp() {
        return this.call;
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(String str, BufferedSocket bufferedSocket, boolean z10) {
        h.e("name", str);
        h.e("socket", bufferedSocket);
        WebSocketExtensions webSocketExtensions = this.extensions;
        h.b(webSocketExtensions);
        synchronized (this) {
            try {
                this.name = str;
                this.socket = bufferedSocket;
                this.writer = new WebSocketWriter(z10, bufferedSocket.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(z10), this.minimumDeflateSize);
                this.writerTask = new WriterTask();
                long j10 = this.pingIntervalMillis;
                if (j10 != 0) {
                    long nanos = TimeUnit.MILLISECONDS.toNanos(j10);
                    this.taskQueue.schedule(str.concat(" ping"), nanos, new b(this, nanos, 1));
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.reader = new WebSocketReader(z10, bufferedSocket.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!z10));
    }

    public final void loopReader(Response response) {
        h.e("response", response);
        try {
            try {
                this.listener.onOpen(this, response);
                while (this.receivedCloseCode == -1) {
                    WebSocketReader webSocketReader = this.reader;
                    h.b(webSocketReader);
                    webSocketReader.processNextFrame();
                }
            } catch (Exception e7) {
                failWebSocket$default(this, e7, null, false, 6, null);
                finishReader();
            }
        } finally {
            finishReader();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i10, String str) {
        h.e("reason", str);
        if (i10 == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                throw new IllegalStateException("already closed");
            }
            this.receivedCloseCode = i10;
            this.receivedCloseReason = str;
        }
        this.listener.onClosing(this, i10, str);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) {
        h.e("text", str);
        this.listener.onMessage(this, str);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(o oVar) {
        try {
            h.e("payload", oVar);
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(oVar);
                runWriter();
                this.receivedPingCount++;
            }
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(o oVar) {
        h.e("payload", oVar);
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean pong(o oVar) {
        try {
            h.e("payload", oVar);
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(oVar);
                runWriter();
                return true;
            }
            return false;
        } finally {
        }
    }

    public final boolean processNextFrame() {
        try {
            WebSocketReader webSocketReader = this.reader;
            h.b(webSocketReader);
            webSocketReader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e7) {
            failWebSocket$default(this, e7, null, false, 6, null);
            return false;
        }
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String str) {
        h.e("text", str);
        o oVar = o.f11048r;
        return send(w1.F(str), 1);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void setCall$okhttp(Call call) {
        this.call = call;
    }

    public final void tearDown() {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v5 */
    public final boolean writeOneFrame$okhttp() {
        String str;
        int i10;
        WebSocketWriter webSocketWriter;
        synchronized (this) {
            try {
                boolean z10 = false;
                if (this.failed) {
                    return false;
                }
                WebSocketWriter webSocketWriter2 = this.writer;
                o poll = this.pongQueue.poll();
                Message message = 0;
                if (poll == null) {
                    Object poll2 = this.messageAndCloseQueue.poll();
                    if (poll2 instanceof Close) {
                        i10 = this.receivedCloseCode;
                        str = this.receivedCloseReason;
                        if (i10 != -1) {
                            webSocketWriter = this.writer;
                            this.writer = null;
                            if (webSocketWriter != null && this.reader == null) {
                                z10 = true;
                            }
                            this.taskQueue.shutdown();
                        } else {
                            long cancelAfterCloseMillis = ((Close) poll2).getCancelAfterCloseMillis();
                            TaskQueue.execute$default(this.taskQueue, this.name + " cancel", TimeUnit.MILLISECONDS.toNanos(cancelAfterCloseMillis), false, new androidx.activity.e(5, this), 4, null);
                            webSocketWriter = null;
                        }
                    } else {
                        if (poll2 == null) {
                            return false;
                        }
                        str = null;
                        i10 = -1;
                        webSocketWriter = null;
                    }
                    message = poll2;
                } else {
                    str = null;
                    i10 = -1;
                    webSocketWriter = null;
                }
                try {
                    if (poll != null) {
                        h.b(webSocketWriter2);
                        webSocketWriter2.writePong(poll);
                    } else if (message instanceof Message) {
                        h.b(webSocketWriter2);
                        webSocketWriter2.writeMessageFrame(message.getFormatOpcode(), message.getData());
                        synchronized (this) {
                            this.queueSize -= message.getData().d();
                        }
                    } else {
                        if (!(message instanceof Close)) {
                            throw new AssertionError();
                        }
                        h.b(webSocketWriter2);
                        webSocketWriter2.writeClose(message.getCode(), ((Close) message).getReason());
                        if (z10) {
                            WebSocketListener webSocketListener = this.listener;
                            h.b(str);
                            webSocketListener.onClosed(this, i10, str);
                        }
                    }
                    return true;
                } finally {
                    if (webSocketWriter != null) {
                        _UtilCommonKt.closeQuietly(webSocketWriter);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void writePingFrame$okhttp() {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.writer;
                if (webSocketWriter == null) {
                    return;
                }
                int i10 = this.awaitingPong ? this.sentPingCount : -1;
                this.sentPingCount++;
                this.awaitingPong = true;
                if (i10 != -1) {
                    StringBuilder sb2 = new StringBuilder("sent ping but didn't receive pong within ");
                    sb2.append(this.pingIntervalMillis);
                    sb2.append("ms (after ");
                    failWebSocket$default(this, new SocketTimeoutException(a.d(sb2, i10 - 1, " successful ping/pongs)")), null, true, 2, null);
                    return;
                }
                try {
                    webSocketWriter.writePing(o.f11048r);
                } catch (IOException e7) {
                    failWebSocket$default(this, e7, null, true, 2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean close(int i10, String str, long j10) {
        o oVar;
        try {
            WebSocketProtocol.INSTANCE.validateCloseCode(i10);
            if (str != null) {
                o oVar2 = o.f11048r;
                oVar = w1.F(str);
                if (oVar.f11049o.length > 123) {
                    throw new IllegalArgumentException("reason.size() > 123: ".concat(str).toString());
                }
            } else {
                oVar = null;
            }
            if (!this.failed && !this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i10, oVar, j10));
                runWriter();
                return true;
            }
            return false;
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(o oVar) {
        h.e("bytes", oVar);
        this.listener.onMessage(this, oVar);
    }

    @Override // okhttp3.WebSocket
    public boolean send(o oVar) {
        h.e("bytes", oVar);
        return send(oVar, 2);
    }

    private final synchronized boolean send(o oVar, int i10) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + oVar.d() > MAX_QUEUE_SIZE) {
                close(WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, null);
                return false;
            }
            this.queueSize += oVar.d();
            this.messageAndCloseQueue.add(new Message(i10, oVar));
            runWriter();
            return true;
        }
        return false;
    }
}
