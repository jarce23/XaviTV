package okhttp3.internal.connection;

import eb.b;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ma.j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Tags;
import okhttp3.internal.TagsKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.url._UrlKt;
import rb.g;
import rb.v0;
import za.h;
import za.n;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class RealCall implements Call, Cloneable, Lockable {
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private final Request originalRequest;
    private final CopyOnWriteArrayList<RoutePlanner.Plan> plansToCancel;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private boolean socketSinkOpen;
    private boolean socketSourceOpen;
    private final AtomicReference<Tags> tags;
    private final RealCall$timeout$1 timeout;
    private boolean timeoutEarlyExit;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall realCall, Callback callback) {
            h.e("responseCallback", callback);
            this.this$0 = realCall;
            this.responseCallback = callback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public static /* synthetic */ void failRejected$okhttp$default(AsyncCall asyncCall, RejectedExecutionException rejectedExecutionException, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                rejectedExecutionException = null;
            }
            asyncCall.failRejected$okhttp(rejectedExecutionException);
        }

        public final void executeOn(ExecutorService executorService) {
            h.e("executorService", executorService);
            _UtilJvmKt.assertLockNotHeld(this.this$0.getClient().dispatcher());
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e7) {
                    failRejected$okhttp(e7);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                }
            } catch (Throwable th) {
                this.this$0.getClient().dispatcher().finished$okhttp(this);
                throw th;
            }
        }

        public final void failRejected$okhttp(RejectedExecutionException rejectedExecutionException) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
            interruptedIOException.initCause(rejectedExecutionException);
            this.this$0.noMoreExchanges$okhttp(interruptedIOException);
            this.responseCallback.onFailure(this.this$0, interruptedIOException);
        }

        public final RealCall getCall() {
            return this.this$0;
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            h.e("other", asyncCall);
            this.callsPerHost = asyncCall.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            OkHttpClient client;
            String str = "OkHttp " + this.this$0.redactedUrl$okhttp();
            RealCall realCall = this.this$0;
            Thread currentThread = Thread.currentThread();
            String name = currentThread.getName();
            currentThread.setName(str);
            try {
                realCall.timeout.enter();
                boolean z10 = false;
                try {
                    try {
                        try {
                            this.responseCallback.onResponse(realCall, realCall.getResponseWithInterceptorChain$okhttp());
                            client = realCall.getClient();
                        } catch (IOException e7) {
                            e = e7;
                            z10 = true;
                            if (z10) {
                                Platform.Companion.get().log("Callback failure for " + realCall.toLoggableString(), 4, e);
                            } else {
                                this.responseCallback.onFailure(realCall, e);
                            }
                            client = realCall.getClient();
                            client.dispatcher().finished$okhttp(this);
                        } catch (Throwable th) {
                            th = th;
                            z10 = true;
                            realCall.cancel();
                            if (!z10) {
                                IOException iOException = new IOException("canceled due to " + th);
                                iOException.initCause(th);
                                this.responseCallback.onFailure(realCall, iOException);
                            }
                            if (!(th instanceof InterruptedException)) {
                                throw th;
                            }
                            Thread.currentThread().interrupt();
                            client = realCall.getClient();
                            client.dispatcher().finished$okhttp(this);
                        }
                    } catch (Throwable th2) {
                        realCall.getClient().dispatcher().finished$okhttp(this);
                        throw th2;
                    }
                } catch (IOException e8) {
                    e = e8;
                } catch (Throwable th3) {
                    th = th3;
                }
                client.dispatcher().finished$okhttp(this);
            } finally {
                currentThread.setName(name);
            }
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(RealCall realCall, Object obj) {
            super(realCall);
            h.e("referent", realCall);
            this.callStackTrace = obj;
        }

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [okhttp3.internal.connection.RealCall$timeout$1, rb.v0] */
    public RealCall(OkHttpClient okHttpClient, Request request, boolean z10) {
        h.e("client", okHttpClient);
        h.e("originalRequest", request);
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z10;
        this.connectionPool = okHttpClient.connectionPool().getDelegate$okhttp();
        this.eventListener = okHttpClient.eventListenerFactory().create(this);
        ?? r52 = new g() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            @Override // rb.g
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        r52.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = r52;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
        this.plansToCancel = new CopyOnWriteArrayList<>();
        this.tags = new AtomicReference<>(request.getTags$okhttp());
    }

    private final IOException callDone(IOException iOException) {
        Socket releaseConnectionNoEvents$okhttp;
        boolean z10 = _UtilJvmKt.assertionsEnabled;
        if (z10 && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            if (z10 && Thread.holdsLock(realConnection)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + realConnection);
            }
            synchronized (realConnection) {
                releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (releaseConnectionNoEvents$okhttp != null) {
                    _UtilJvmKt.closeQuietly(releaseConnectionNoEvents$okhttp);
                }
                this.eventListener.connectionReleased(this, realConnection);
                realConnection.getConnectionListener$okhttp().connectionReleased(realConnection, this);
                if (releaseConnectionNoEvents$okhttp != null) {
                    realConnection.getConnectionListener$okhttp().connectionClosed(realConnection);
                }
            } else if (releaseConnectionNoEvents$okhttp != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        IOException timeoutExit = timeoutExit(iOException);
        if (iOException == null) {
            this.eventListener.callEnd(this);
            return timeoutExit;
        }
        EventListener eventListener = this.eventListener;
        h.b(timeoutExit);
        eventListener.callFailed(this, timeoutExit);
        return timeoutExit;
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    public static /* synthetic */ IOException messageDone$okhttp$default(RealCall realCall, Exchange exchange, boolean z10, boolean z11, boolean z12, boolean z13, IOException iOException, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        if ((i10 & 8) != 0) {
            z12 = false;
        }
        if ((i10 & 16) != 0) {
            z13 = false;
        }
        return realCall.messageDone$okhttp(exchange, z10, z11, z12, z13, iOException);
    }

    private final IOException timeoutExit(IOException iOException) {
        if (this.timeoutEarlyExit || !exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toLoggableString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isCanceled() ? "canceled " : _UrlKt.FRAGMENT_ENCODE_SET);
        sb2.append(this.forWebSocket ? "web socket" : "call");
        sb2.append(" to ");
        sb2.append(redactedUrl$okhttp());
        return sb2.toString();
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        h.e("connection", realConnection);
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(realConnection)) {
            if (this.connection != null) {
                throw new IllegalStateException("Check failed.");
            }
            this.connection = realConnection;
            realConnection.getCalls().add(new CallReference(this, this.callStackTrace));
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    @Override // okhttp3.Call
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.cancel();
        }
        Iterator<RoutePlanner.Plan> it = this.plansToCancel.iterator();
        h.d("iterator(...)", it);
        while (it.hasNext()) {
            it.next().mo145cancel();
        }
        this.eventListener.canceled(this);
    }

    @Override // okhttp3.Call
    public void enqueue(Callback callback) {
        h.e("responseCallback", callback);
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, callback));
    }

    public final void enterNetworkInterceptorExchange(Request request, boolean z10, RealInterceptorChain realInterceptorChain) {
        h.e("request", request);
        h.e("chain", realInterceptorChain);
        if (this.interceptorScopedExchange != null) {
            throw new IllegalStateException("Check failed.");
        }
        synchronized (this) {
            if (this.responseBodyOpen) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
            if (this.requestBodyOpen || this.socketSourceOpen || this.socketSinkOpen) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (z10) {
            RealRoutePlanner realRoutePlanner = new RealRoutePlanner(this.client.getTaskRunner$okhttp(), this.connectionPool, this.client.readTimeoutMillis(), this.client.writeTimeoutMillis(), realInterceptorChain.getConnectTimeoutMillis$okhttp(), realInterceptorChain.getReadTimeoutMillis$okhttp(), this.client.pingIntervalMillis(), this.client.retryOnConnectionFailure(), this.client.fastFallback(), this.client.address(request.url()), this.client.getRouteDatabase$okhttp(), this, request);
            this.exchangeFinder = this.client.fastFallback() ? new FastFallbackExchangeFinder(realRoutePlanner, this.client.getTaskRunner$okhttp()) : new SequentialExchangeFinder(realRoutePlanner);
        }
    }

    @Override // okhttp3.Call
    public Response execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        enter();
        callStart();
        try {
            this.client.dispatcher().executed$okhttp(this);
            return getResponseWithInterceptorChain$okhttp();
        } finally {
            this.client.dispatcher().finished$okhttp(this);
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z10) {
        Exchange exchange;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
        }
        if (z10 && (exchange = this.exchange) != null) {
            exchange.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    public final CopyOnWriteArrayList<RoutePlanner.Plan> getPlansToCancel$okhttp() {
        return this.plansToCancel;
    }

    public final Response getResponseWithInterceptorChain$okhttp() {
        ArrayList arrayList = new ArrayList();
        j.B(arrayList, this.client.interceptors());
        arrayList.add(new RetryAndFollowUpInterceptor(this.client));
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.cache()));
        arrayList.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            j.B(arrayList, this.client.networkInterceptors());
        }
        arrayList.add(CallServerInterceptor.INSTANCE);
        try {
            try {
                Response proceed = new RealInterceptorChain(this, arrayList, 0, null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
                if (isCanceled()) {
                    _UtilCommonKt.closeQuietly(proceed);
                    throw new IOException("Canceled");
                }
                noMoreExchanges$okhttp(null);
                return proceed;
            } catch (IOException e7) {
                IOException noMoreExchanges$okhttp = noMoreExchanges$okhttp(e7);
                h.c("null cannot be cast to non-null type kotlin.Throwable", noMoreExchanges$okhttp);
                throw noMoreExchanges$okhttp;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                noMoreExchanges$okhttp(null);
            }
            throw th;
        }
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain realInterceptorChain) {
        h.e("chain", realInterceptorChain);
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
            if (this.responseBodyOpen || this.requestBodyOpen || this.socketSourceOpen || this.socketSinkOpen) {
                throw new IllegalStateException("Check failed.");
            }
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        h.b(exchangeFinder);
        Exchange exchange = new Exchange(this, this.eventListener, exchangeFinder, exchangeFinder.find().newCodec$okhttp(this.client, realInterceptorChain));
        this.interceptorScopedExchange = exchange;
        this.exchange = exchange;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
        }
        if (this.canceled) {
            throw new IOException("Canceled");
        }
        return exchange;
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override // okhttp3.Call
    public boolean isExecuted() {
        return this.executed.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:53:0x0013, B:10:0x002e, B:12:0x0032, B:14:0x0036, B:16:0x003a, B:17:0x003c, B:19:0x0041, B:21:0x0045, B:23:0x0049, B:27:0x0052, B:7:0x001c, B:46:0x0022, B:49:0x0028), top: B:52:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:53:0x0013, B:10:0x002e, B:12:0x0032, B:14:0x0036, B:16:0x003a, B:17:0x003c, B:19:0x0041, B:21:0x0045, B:23:0x0049, B:27:0x0052, B:7:0x001c, B:46:0x0022, B:49:0x0028), top: B:52:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:53:0x0013, B:10:0x002e, B:12:0x0032, B:14:0x0036, B:16:0x003a, B:17:0x003c, B:19:0x0041, B:21:0x0045, B:23:0x0049, B:27:0x0052, B:7:0x001c, B:46:0x0022, B:49:0x0028), top: B:52:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:53:0x0013, B:10:0x002e, B:12:0x0032, B:14:0x0036, B:16:0x003a, B:17:0x003c, B:19:0x0041, B:21:0x0045, B:23:0x0049, B:27:0x0052, B:7:0x001c, B:46:0x0022, B:49:0x0028), top: B:52:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052 A[Catch: all -> 0x0018, TRY_LEAVE, TryCatch #0 {all -> 0x0018, blocks: (B:53:0x0013, B:10:0x002e, B:12:0x0032, B:14:0x0036, B:16:0x003a, B:17:0x003c, B:19:0x0041, B:21:0x0045, B:23:0x0049, B:27:0x0052, B:7:0x001c, B:46:0x0022, B:49:0x0028), top: B:52:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.IOException messageDone$okhttp(okhttp3.internal.connection.Exchange r3, boolean r4, boolean r5, boolean r6, boolean r7, java.io.IOException r8) {
        /*
            r2 = this;
            java.lang.String r0 = "exchange"
            za.h.e(r0, r3)
            okhttp3.internal.connection.Exchange r0 = r2.exchange
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto Lf
            goto L72
        Lf:
            monitor-enter(r2)
            r3 = 0
            if (r4 == 0) goto L1a
            boolean r0 = r2.requestBodyOpen     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L2c
            goto L1a
        L18:
            r3 = move-exception
            goto L5b
        L1a:
            if (r5 == 0) goto L20
            boolean r0 = r2.responseBodyOpen     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L2c
        L20:
            if (r7 == 0) goto L26
            boolean r0 = r2.socketSinkOpen     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L2c
        L26:
            if (r6 == 0) goto L5d
            boolean r0 = r2.socketSourceOpen     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L5d
        L2c:
            if (r4 == 0) goto L30
            r2.requestBodyOpen = r3     // Catch: java.lang.Throwable -> L18
        L30:
            if (r5 == 0) goto L34
            r2.responseBodyOpen = r3     // Catch: java.lang.Throwable -> L18
        L34:
            if (r7 == 0) goto L38
            r2.socketSinkOpen = r3     // Catch: java.lang.Throwable -> L18
        L38:
            if (r6 == 0) goto L3c
            r2.socketSourceOpen = r3     // Catch: java.lang.Throwable -> L18
        L3c:
            boolean r4 = r2.requestBodyOpen     // Catch: java.lang.Throwable -> L18
            r5 = 1
            if (r4 != 0) goto L4f
            boolean r4 = r2.responseBodyOpen     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L4f
            boolean r4 = r2.socketSinkOpen     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L4f
            boolean r4 = r2.socketSourceOpen     // Catch: java.lang.Throwable -> L18
            if (r4 != 0) goto L4f
            r4 = r5
            goto L50
        L4f:
            r4 = r3
        L50:
            if (r4 == 0) goto L57
            boolean r6 = r2.expectMoreExchanges     // Catch: java.lang.Throwable -> L18
            if (r6 != 0) goto L57
            r3 = r5
        L57:
            r1 = r4
            r4 = r3
            r3 = r1
            goto L5e
        L5b:
            monitor-exit(r2)
            throw r3
        L5d:
            r4 = r3
        L5e:
            monitor-exit(r2)
            if (r3 == 0) goto L6b
            r3 = 0
            r2.exchange = r3
            okhttp3.internal.connection.RealConnection r3 = r2.connection
            if (r3 == 0) goto L6b
            r3.incrementSuccessCount$okhttp()
        L6b:
            if (r4 == 0) goto L72
            java.io.IOException r3 = r2.callDone(r8)
            return r3
        L72:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.messageDone$okhttp(okhttp3.internal.connection.Exchange, boolean, boolean, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        boolean z10;
        synchronized (this) {
            z10 = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen && !this.socketSinkOpen) {
                    if (!this.socketSourceOpen) {
                        z10 = true;
                    }
                }
            }
        }
        return z10 ? callDone(iOException) : iOException;
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        h.b(realConnection);
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        Iterator<Reference<RealCall>> it = calls.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (h.a(it.next().get(), this)) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            throw new IllegalStateException("Check failed.");
        }
        calls.remove(i10);
        this.connection = null;
        if (calls.isEmpty()) {
            realConnection.setIdleAtNs(System.nanoTime());
            if (this.connectionPool.connectionBecameIdle(realConnection)) {
                return realConnection.socket();
            }
        }
        return null;
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        Exchange exchange = this.exchange;
        if (exchange == null || !exchange.getHasFailure$okhttp()) {
            return false;
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        h.b(exchangeFinder);
        RoutePlanner routePlanner = exchangeFinder.getRoutePlanner();
        Exchange exchange2 = this.exchange;
        return routePlanner.hasNext(exchange2 != null ? exchange2.getConnection$okhttp() : null);
    }

    @Override // okhttp3.Call
    public <T> T tag(Class<? extends T> cls) {
        h.e("type", cls);
        return (T) tag(n.a(cls));
    }

    @Override // okhttp3.Call
    public v0 timeout() {
        return this.timeout;
    }

    public final void timeoutEarlyExit() {
        if (this.timeoutEarlyExit) {
            throw new IllegalStateException("Check failed.");
        }
        this.timeoutEarlyExit = true;
        exit();
    }

    public final void upgradeToSocket() {
        timeoutEarlyExit();
        synchronized (this) {
            if (this.exchange == null) {
                throw new IllegalStateException("Check failed.");
            }
            if (this.socketSinkOpen || this.socketSourceOpen) {
                throw new IllegalStateException("Check failed.");
            }
            if (this.requestBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            if (!this.responseBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            this.responseBodyOpen = false;
            this.socketSinkOpen = true;
            this.socketSourceOpen = true;
        }
    }

    @Override // okhttp3.Call
    public Call clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    @Override // okhttp3.Call
    public <T> T tag(b bVar) {
        h.e("type", bVar);
        return (T) k5.a.o(bVar).cast(this.tags.get().get(bVar));
    }

    @Override // okhttp3.Call
    public <T> T tag(b bVar, ya.a aVar) {
        h.e("type", bVar);
        h.e("computeIfAbsent", aVar);
        return (T) TagsKt.computeIfAbsent(this.tags, bVar, aVar);
    }

    @Override // okhttp3.Call
    public <T> T tag(Class<T> cls, ya.a aVar) {
        h.e("type", cls);
        h.e("computeIfAbsent", aVar);
        return (T) TagsKt.computeIfAbsent(this.tags, n.a(cls), aVar);
    }
}
