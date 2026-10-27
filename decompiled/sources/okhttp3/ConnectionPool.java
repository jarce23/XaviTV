package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.ConnectionListener;
import okhttp3.internal.connection.RealConnectionPool;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class ConnectionPool {
    private final RealConnectionPool delegate;

    public ConnectionPool(RealConnectionPool realConnectionPool) {
        h.e("delegate", realConnectionPool);
        this.delegate = realConnectionPool;
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    public final ConnectionListener getConnectionListener$okhttp() {
        return this.delegate.getConnectionListener$okhttp();
    }

    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    public /* synthetic */ ConnectionPool(int i10, long j10, TimeUnit timeUnit, TaskRunner taskRunner, ConnectionListener connectionListener, int i11, e eVar) {
        this((i11 & 1) != 0 ? 5 : i10, (i11 & 2) != 0 ? 5L : j10, (i11 & 4) != 0 ? TimeUnit.MINUTES : timeUnit, (i11 & 8) != 0 ? TaskRunner.INSTANCE : taskRunner, (i11 & 16) != 0 ? ConnectionListener.Companion.getNONE() : connectionListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i10, long j10, TimeUnit timeUnit, TaskRunner taskRunner, ConnectionListener connectionListener) {
        this(new RealConnectionPool(taskRunner, i10, j10, timeUnit, connectionListener));
        h.e("timeUnit", timeUnit);
        h.e("taskRunner", taskRunner);
        h.e("connectionListener", connectionListener);
    }

    public /* synthetic */ ConnectionPool(int i10, long j10, TimeUnit timeUnit, ConnectionListener connectionListener, int i11, e eVar) {
        this((i11 & 1) != 0 ? 5 : i10, (i11 & 2) != 0 ? 5L : j10, (i11 & 4) != 0 ? TimeUnit.MINUTES : timeUnit, (i11 & 8) != 0 ? ConnectionListener.Companion.getNONE() : connectionListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i10, long j10, TimeUnit timeUnit, ConnectionListener connectionListener) {
        this(i10, j10, timeUnit, TaskRunner.INSTANCE, connectionListener);
        h.e("timeUnit", timeUnit);
        h.e("connectionListener", connectionListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i10, long j10, TimeUnit timeUnit) {
        this(i10, j10, timeUnit, TaskRunner.INSTANCE, ConnectionListener.Companion.getNONE());
        h.e("timeUnit", timeUnit);
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
