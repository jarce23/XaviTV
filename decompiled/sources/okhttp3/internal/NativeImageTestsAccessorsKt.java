package okhttp3.internal;

import okhttp3.Cache;
import okhttp3.Dispatcher;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import rb.i0;
import rb.u;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class NativeImageTestsAccessorsKt {
    public static final Cache buildCache(i0 i0Var, long j10, u uVar) {
        h.e("file", i0Var);
        h.e("fileSystem", uVar);
        return new Cache(uVar, i0Var, j10);
    }

    public static final void finishedAccessor(Dispatcher dispatcher, RealCall.AsyncCall asyncCall) {
        h.e("<this>", dispatcher);
        h.e("call", asyncCall);
        dispatcher.finished$okhttp(asyncCall);
    }

    public static final RealConnection getConnectionAccessor(Exchange exchange) {
        h.e("<this>", exchange);
        return exchange.getConnection$okhttp();
    }

    public static final Exchange getExchangeAccessor(Response response) {
        h.e("<this>", response);
        return response.exchange();
    }

    public static final long getIdleAtNsAccessor(RealConnection realConnection) {
        h.e("<this>", realConnection);
        return realConnection.getIdleAtNs();
    }

    public static final void setIdleAtNsAccessor(RealConnection realConnection, long j10) {
        h.e("<this>", realConnection);
        realConnection.setIdleAtNs(j10);
    }
}
