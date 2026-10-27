package okhttp3.internal.connection;

import android.support.v4.media.d;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class RealConnectionPool {
    public static final Companion Companion = new Companion(null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConnectionListener connectionListener;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            h.e("connectionPool", connectionPool);
            return connectionPool.getDelegate$okhttp();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner taskRunner, int i10, long j10, TimeUnit timeUnit, ConnectionListener connectionListener) {
        h.e("taskRunner", taskRunner);
        h.e("timeUnit", timeUnit);
        h.e("connectionListener", connectionListener);
        this.maxIdleConnections = i10;
        this.connectionListener = connectionListener;
        this.keepAliveDurationNs = timeUnit.toNanos(j10);
        this.cleanupQueue = taskRunner.newQueue();
        final String r2 = d.r(new StringBuilder(), _UtilJvmKt.okHttpName, " ConnectionPool connection closer");
        this.cleanupTask = new Task(r2) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return RealConnectionPool.this.closeConnections(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (j10 <= 0) {
            throw new IllegalArgumentException(d.n(j10, "keepAliveDuration <= 0: ").toString());
        }
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j10) {
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        int i10 = 0;
        while (i10 < calls.size()) {
            Reference<RealCall> reference = calls.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i10);
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs(j10 - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return calls.size();
    }

    public final RealConnection callAcquirePooledConnection$okhttp(boolean z10, Address address, RealCall realCall, List<Route> list, boolean z11) {
        boolean z12;
        boolean noNewExchanges;
        Socket releaseConnectionNoEvents$okhttp;
        h.e("address", address);
        h.e("call", realCall);
        Iterator<RealConnection> it = this.connections.iterator();
        h.d("iterator(...)", it);
        while (it.hasNext()) {
            RealConnection next = it.next();
            h.b(next);
            synchronized (next) {
                z12 = false;
                if (z11) {
                    try {
                        if (!next.isMultiplexed$okhttp()) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (next.isEligible$okhttp(address, list)) {
                    realCall.acquireConnectionNoEvents(next);
                    z12 = true;
                }
            }
            if (z12) {
                if (next.isHealthy(z10)) {
                    return next;
                }
                synchronized (next) {
                    noNewExchanges = next.getNoNewExchanges();
                    next.setNoNewExchanges(true);
                    releaseConnectionNoEvents$okhttp = realCall.releaseConnectionNoEvents$okhttp();
                }
                if (releaseConnectionNoEvents$okhttp != null) {
                    _UtilJvmKt.closeQuietly(releaseConnectionNoEvents$okhttp);
                    this.connectionListener.connectionClosed(next);
                } else if (!noNewExchanges) {
                    this.connectionListener.noNewExchanges(next);
                }
            }
        }
        return null;
    }

    public final long closeConnections(long j10) {
        long j11 = (j10 - this.keepAliveDurationNs) + 1;
        Iterator<RealConnection> it = this.connections.iterator();
        h.d("iterator(...)", it);
        RealConnection realConnection = null;
        long j12 = Long.MAX_VALUE;
        int i10 = 0;
        RealConnection realConnection2 = null;
        RealConnection realConnection3 = null;
        int i11 = 0;
        while (it.hasNext()) {
            RealConnection next = it.next();
            h.b(next);
            synchronized (next) {
                if (pruneAndGetAllocationCount(next, j10) > 0) {
                    i11++;
                } else {
                    long idleAtNs = next.getIdleAtNs();
                    if (idleAtNs < j11) {
                        realConnection2 = next;
                        j11 = idleAtNs;
                    }
                    i10++;
                    if (idleAtNs < j12) {
                        realConnection3 = next;
                        j12 = idleAtNs;
                    }
                }
            }
        }
        if (realConnection2 != null) {
            realConnection = realConnection2;
        } else if (i10 > this.maxIdleConnections) {
            j11 = j12;
            realConnection = realConnection3;
        } else {
            j11 = -1;
        }
        if (realConnection == null) {
            if (realConnection3 != null) {
                return (j12 + this.keepAliveDurationNs) - j10;
            }
            if (i11 > 0) {
                return this.keepAliveDurationNs;
            }
            return -1L;
        }
        synchronized (realConnection) {
            if (!realConnection.getCalls().isEmpty()) {
                return 0L;
            }
            if (realConnection.getIdleAtNs() != j11) {
                return 0L;
            }
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            _UtilJvmKt.closeQuietly(realConnection.socket());
            this.connectionListener.connectionClosed(realConnection);
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return 0L;
        }
    }

    public final boolean connectionBecameIdle(RealConnection realConnection) {
        h.e("connection", realConnection);
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        if (!realConnection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            scheduleCloser();
            return false;
        }
        realConnection.setNoNewExchanges(true);
        this.connections.remove(realConnection);
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
        return true;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it = this.connections.iterator();
        h.d("iterator(...)", it);
        while (it.hasNext()) {
            RealConnection next = it.next();
            h.b(next);
            synchronized (next) {
                if (next.getCalls().isEmpty()) {
                    it.remove();
                    next.setNoNewExchanges(true);
                    socket = next.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                _UtilJvmKt.closeQuietly(socket);
                this.connectionListener.connectionClosed(next);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final ConnectionListener getConnectionListener$okhttp() {
        return this.connectionListener;
    }

    public final long getKeepAliveDurationNs$okhttp() {
        return this.keepAliveDurationNs;
    }

    public final int idleConnectionCount() {
        boolean isEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i10 = 0;
        if (concurrentLinkedQueue != null && concurrentLinkedQueue.isEmpty()) {
            return 0;
        }
        for (RealConnection realConnection : concurrentLinkedQueue) {
            h.b(realConnection);
            synchronized (realConnection) {
                isEmpty = realConnection.getCalls().isEmpty();
            }
            if (isEmpty && (i10 = i10 + 1) < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i10;
    }

    public final void put(RealConnection realConnection) {
        h.e("connection", realConnection);
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(realConnection)) {
            this.connections.add(realConnection);
            scheduleCloser();
        } else {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
    }

    public final void scheduleCloser() {
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }
}
