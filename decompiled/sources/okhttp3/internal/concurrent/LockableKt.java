package okhttp3.internal.concurrent;

import okhttp3.internal._UtilJvmKt;
import ya.a;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class LockableKt {
    public static final void assertLockHeld(Lockable lockable) {
        h.e("<this>", lockable);
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(lockable)) {
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + lockable);
    }

    public static final void assertLockNotHeld(Lockable lockable) {
        h.e("<this>", lockable);
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(lockable)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + lockable);
        }
    }

    public static final void awaitNanos(Lockable lockable, long j10) {
        h.e("<this>", lockable);
        long j11 = j10 / 1000000;
        long j12 = j10 - (1000000 * j11);
        if (j11 > 0 || j10 > 0) {
            lockable.wait(j11, (int) j12);
        }
    }

    public static final void notify(Lockable lockable) {
        h.e("<this>", lockable);
        lockable.notify();
    }

    public static final void notifyAll(Lockable lockable) {
        h.e("<this>", lockable);
        lockable.notifyAll();
    }

    public static final void wait(Lockable lockable) {
        h.e("<this>", lockable);
        lockable.wait();
    }

    public static final <T> T withLock(Lockable lockable, a aVar) {
        T t3;
        h.e("<this>", lockable);
        h.e("action", aVar);
        synchronized (lockable) {
            t3 = (T) aVar.invoke();
        }
        return t3;
    }
}
