package rb;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class v0 {
    public static final u0 Companion = new u0();
    public static final v0 NONE = new t0();
    private volatile Object cancelMark;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public void awaitSignal(Condition condition) {
        za.h.e("condition", condition);
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            if (!hasDeadline && timeoutNanos == 0) {
                condition.await();
                return;
            }
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - System.nanoTime());
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - System.nanoTime();
            }
            if (timeoutNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object obj = this.cancelMark;
            if (condition.awaitNanos(timeoutNanos) <= 0 && this.cancelMark == obj) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public void cancel() {
        this.cancelMark = new Object();
    }

    public v0 clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public v0 clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final v0 deadline(long j10, TimeUnit timeUnit) {
        za.h.e("unit", timeUnit);
        if (j10 <= 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "duration <= 0: ").toString());
        }
        return deadlineNanoTime(timeUnit.toNanos(j10) + System.nanoTime());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(v0 v0Var, ya.a aVar) {
        za.h.e("other", v0Var);
        za.h.e("block", aVar);
        long timeoutNanos = timeoutNanos();
        u0 u0Var = Companion;
        long timeoutNanos2 = v0Var.timeoutNanos();
        long timeoutNanos3 = timeoutNanos();
        u0Var.getClass();
        if (timeoutNanos2 == 0 || (timeoutNanos3 != 0 && timeoutNanos2 >= timeoutNanos3)) {
            timeoutNanos2 = timeoutNanos3;
        }
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(timeoutNanos2, timeUnit);
        if (!hasDeadline()) {
            if (v0Var.hasDeadline()) {
                deadlineNanoTime(v0Var.deadlineNanoTime());
            }
            try {
                T t3 = (T) aVar.invoke();
                timeout(timeoutNanos, timeUnit);
                if (v0Var.hasDeadline()) {
                    clearDeadline();
                }
                return t3;
            } catch (Throwable th) {
                timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (v0Var.hasDeadline()) {
                    clearDeadline();
                }
                throw th;
            }
        }
        long deadlineNanoTime = deadlineNanoTime();
        if (v0Var.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), v0Var.deadlineNanoTime()));
        }
        try {
            T t8 = (T) aVar.invoke();
            timeout(timeoutNanos, timeUnit);
            if (v0Var.hasDeadline()) {
                deadlineNanoTime(deadlineNanoTime);
            }
            return t8;
        } catch (Throwable th2) {
            timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (v0Var.hasDeadline()) {
                deadlineNanoTime(deadlineNanoTime);
            }
            throw th2;
        }
    }

    public void throwIfReached() {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public v0 timeout(long j10, TimeUnit timeUnit) {
        za.h.e("unit", timeUnit);
        if (j10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "timeout < 0: ").toString());
        }
        this.timeoutNanos = timeUnit.toNanos(j10);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public void waitUntilNotified(Object obj) {
        za.h.e("monitor", obj);
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            if (!hasDeadline && timeoutNanos == 0) {
                obj.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object obj2 = this.cancelMark;
            long j10 = timeoutNanos / 1000000;
            Long.signum(j10);
            obj.wait(j10, (int) (timeoutNanos - (1000000 * j10)));
            if (System.nanoTime() - nanoTime >= timeoutNanos && this.cancelMark == obj2) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public v0 deadlineNanoTime(long j10) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j10;
        return this;
    }
}
