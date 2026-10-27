package ib;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w extends e0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: w, reason: collision with root package name */
    public static final w f6606w;

    /* renamed from: x, reason: collision with root package name */
    public static final long f6607x;

    static {
        Long l10;
        w wVar = new w();
        f6606w = wVar;
        wVar.S(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f6607x = timeUnit.toNanos(l10.longValue());
    }

    @Override // ib.f0
    public final Thread R() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(w.class.getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // ib.e0
    public final void U(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.U(runnable);
    }

    public final synchronized void Y() {
        int i10 = debugStatus;
        if (i10 == 2 || i10 == 3) {
            debugStatus = 3;
            e0.f6548t.set(this, null);
            e0.f6549u.set(this, null);
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean W;
        f1.f6559a.set(this);
        try {
            synchronized (this) {
                int i10 = debugStatus;
                if (i10 == 2 || i10 == 3) {
                    if (W) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j10 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long X = X();
                    if (X == Long.MAX_VALUE) {
                        long nanoTime = System.nanoTime();
                        if (j10 == Long.MAX_VALUE) {
                            j10 = f6607x + nanoTime;
                        }
                        long j11 = j10 - nanoTime;
                        if (j11 <= 0) {
                            _thread = null;
                            Y();
                            if (W()) {
                                return;
                            }
                            R();
                            return;
                        }
                        if (X > j11) {
                            X = j11;
                        }
                    } else {
                        j10 = Long.MAX_VALUE;
                    }
                    if (X > 0) {
                        int i11 = debugStatus;
                        if (i11 == 2 || i11 == 3) {
                            _thread = null;
                            Y();
                            if (W()) {
                                return;
                            }
                            R();
                            return;
                        }
                        LockSupport.parkNanos(this, X);
                    }
                }
            }
        } finally {
            _thread = null;
            Y();
            if (!W()) {
                R();
            }
        }
    }

    @Override // ib.e0, ib.f0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
