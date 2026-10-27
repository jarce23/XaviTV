package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m4 extends AtomicReference implements Runnable {

    /* renamed from: q, reason: collision with root package name */
    public static final f4 f3374q = new f4();

    /* renamed from: r, reason: collision with root package name */
    public static final f4 f3375r = new f4();

    /* renamed from: o, reason: collision with root package name */
    public final Callable f3376o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ n4 f3377p;

    public m4(n4 n4Var, Callable callable) {
        this.f3377p = n4Var;
        callable.getClass();
        this.f3376o = callable;
    }

    public final void a(Thread thread) {
        Runnable runnable = (Runnable) get();
        e4 e4Var = null;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            boolean z11 = runnable instanceof e4;
            f4 f4Var = f3375r;
            if (!z11) {
                if (runnable != f4Var) {
                    break;
                }
            } else {
                e4Var = (e4) runnable;
            }
            i10++;
            if (i10 <= 1000) {
                Thread.yield();
            } else if (runnable == f4Var || compareAndSet(runnable, f4Var)) {
                z10 = Thread.interrupted() || z10;
                LockSupport.park(e4Var);
            }
            runnable = (Runnable) get();
        }
        if (z10) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object call;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            n4 n4Var = this.f3377p;
            boolean isDone = n4Var.isDone();
            f4 f4Var = f3374q;
            if (isDone) {
                call = null;
            } else {
                try {
                    call = this.f3376o.call();
                } catch (Throwable th) {
                    try {
                        if (th instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(currentThread, f4Var)) {
                            a(currentThread);
                        }
                        if (b4.f3264u.K(n4Var, null, new u3(th))) {
                            b4.J(n4Var);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        if (!compareAndSet(currentThread, f4Var)) {
                            a(currentThread);
                        }
                        if (b4.f3264u.K(n4Var, null, b4.f3265v)) {
                            b4.J(n4Var);
                        }
                        throw th2;
                    }
                }
            }
            if (!compareAndSet(currentThread, f4Var)) {
                a(currentThread);
            }
            if (isDone) {
                return;
            }
            if (call == null) {
                call = b4.f3265v;
            }
            if (b4.f3264u.K(n4Var, null, call)) {
                b4.J(n4Var);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        Runnable runnable = (Runnable) get();
        return (runnable == f3374q ? "running=[DONE]" : runnable instanceof e4 ? "running=[INTERRUPTED]" : runnable instanceof Thread ? android.support.v4.media.d.q("running=[RUNNING ON ", ((Thread) runnable).getName(), "]") : "running=[NOT STARTED YET]") + ", " + this.f3376o.toString();
    }
}
