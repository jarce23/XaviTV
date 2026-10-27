package rb;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y extends v0 {

    /* renamed from: a, reason: collision with root package name */
    public v0 f11077a;

    public y(v0 v0Var) {
        za.h.e("delegate", v0Var);
        this.f11077a = v0Var;
    }

    @Override // rb.v0
    public final void awaitSignal(Condition condition) {
        za.h.e("condition", condition);
        this.f11077a.awaitSignal(condition);
    }

    @Override // rb.v0
    public final v0 clearDeadline() {
        return this.f11077a.clearDeadline();
    }

    @Override // rb.v0
    public final v0 clearTimeout() {
        return this.f11077a.clearTimeout();
    }

    @Override // rb.v0
    public final long deadlineNanoTime() {
        return this.f11077a.deadlineNanoTime();
    }

    @Override // rb.v0
    public final boolean hasDeadline() {
        return this.f11077a.hasDeadline();
    }

    @Override // rb.v0
    public final void throwIfReached() {
        this.f11077a.throwIfReached();
    }

    @Override // rb.v0
    public final v0 timeout(long j10, TimeUnit timeUnit) {
        za.h.e("unit", timeUnit);
        return this.f11077a.timeout(j10, timeUnit);
    }

    @Override // rb.v0
    public final long timeoutNanos() {
        return this.f11077a.timeoutNanos();
    }

    @Override // rb.v0
    public final void waitUntilNotified(Object obj) {
        za.h.e("monitor", obj);
        this.f11077a.waitUntilNotified(obj);
    }

    @Override // rb.v0
    public final v0 deadlineNanoTime(long j10) {
        return this.f11077a.deadlineNanoTime(j10);
    }
}
