package okhttp3.internal.connection;

import okhttp3.internal.ws.RealWebSocket;
import za.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class AddressPolicy {
    public final long backoffDelayMillis;
    public final int backoffJitterMillis;
    public final int minimumConcurrentCalls;

    public AddressPolicy() {
        this(0, 0L, 0, 7, null);
    }

    public AddressPolicy(int i10, long j10, int i11) {
        this.minimumConcurrentCalls = i10;
        this.backoffDelayMillis = j10;
        this.backoffJitterMillis = i11;
    }

    public /* synthetic */ AddressPolicy(int i10, long j10, int i11, int i12, e eVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS : j10, (i12 & 4) != 0 ? 100 : i11);
    }
}
