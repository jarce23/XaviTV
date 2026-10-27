package rb;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class g extends v0 {
    private static final c Companion = new c();
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int STATE_CANCELED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_QUEUE = 1;
    private static final int STATE_TIMED_OUT = 2;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static final Condition condition;
    private static g idleSentinel;
    private static final ReentrantLock lock;
    private static final k0 queue;
    public int index = -1;
    private int state;
    private long timeoutAt;

    static {
        k0 k0Var = new k0();
        k0Var.f11033b = new g[8];
        queue = k0Var;
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        za.h.d("newCondition(...)", newCondition);
        condition = newCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    @Override // rb.v0
    public void cancel() {
        super.cancel();
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (this.state == 1) {
                queue.b(this);
                this.state = 3;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void enter() {
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            ReentrantLock reentrantLock = lock;
            reentrantLock.lock();
            try {
                if (this.state != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.state = 1;
                c.a(Companion, this, timeoutNanos, hasDeadline);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final boolean exit() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            int i10 = this.state;
            this.state = 0;
            if (i10 != 1) {
                return i10 == 2;
            }
            queue.b(this);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long remainingNanos$okio(long j10) {
        return this.timeoutAt - j10;
    }

    public final q0 sink(q0 q0Var) {
        za.h.e("sink", q0Var);
        return new e(this, 0, q0Var);
    }

    public final s0 source(s0 s0Var) {
        za.h.e("source", s0Var);
        return new f(this, s0Var);
    }

    public final <T> T withTimeout(ya.a aVar) {
        za.h.e("block", aVar);
        enter();
        try {
            T t3 = (T) aVar.invoke();
            if (exit()) {
                throw access$newTimeoutException(null);
            }
            return t3;
        } catch (IOException e7) {
            if (exit()) {
                throw access$newTimeoutException(e7);
            }
            throw e7;
        } finally {
            exit();
        }
    }

    public void timedOut() {
    }
}
