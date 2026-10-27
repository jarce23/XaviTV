package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n4 extends b4 implements RunnableFuture {

    /* renamed from: w, reason: collision with root package name */
    public volatile m4 f3395w;

    public n4(Callable callable) {
        this.f3395w = new m4(this, callable);
    }

    @Override // com.google.android.gms.internal.cast.b4
    public final String F() {
        m4 m4Var = this.f3395w;
        return m4Var != null ? android.support.v4.media.d.q("task=[", m4Var.toString(), "]") : super.F();
    }

    @Override // com.google.android.gms.internal.cast.b4
    public final void G() {
        m4 m4Var;
        Object obj = this.f3266p;
        if ((obj instanceof s3) && ((s3) obj).f3449a && (m4Var = this.f3395w) != null) {
            f4 f4Var = m4.f3375r;
            f4 f4Var2 = m4.f3374q;
            Runnable runnable = (Runnable) m4Var.get();
            if (runnable instanceof Thread) {
                e4 e4Var = new e4(m4Var);
                e4Var.setExclusiveOwnerThread(Thread.currentThread());
                if (m4Var.compareAndSet(runnable, e4Var)) {
                    try {
                        Thread thread = (Thread) runnable;
                        thread.interrupt();
                        if (((Runnable) m4Var.getAndSet(f4Var2)) == f4Var) {
                            LockSupport.unpark(thread);
                        }
                    } catch (Throwable th) {
                        if (((Runnable) m4Var.getAndSet(f4Var2)) == f4Var) {
                            LockSupport.unpark((Thread) runnable);
                        }
                        throw th;
                    }
                }
            }
        }
        this.f3395w = null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        m4 m4Var = this.f3395w;
        if (m4Var != null) {
            m4Var.run();
        }
        this.f3395w = null;
    }
}
