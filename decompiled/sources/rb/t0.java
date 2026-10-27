package rb;

import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t0 extends v0 {
    @Override // rb.v0
    public final v0 timeout(long j10, TimeUnit timeUnit) {
        za.h.e("unit", timeUnit);
        return this;
    }

    @Override // rb.v0
    public final void throwIfReached() {
    }

    @Override // rb.v0
    public final v0 deadlineNanoTime(long j10) {
        return this;
    }
}
