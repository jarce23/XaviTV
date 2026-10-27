package ib;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 extends g0 implements y {

    /* renamed from: q, reason: collision with root package name */
    public final f.o f6563q;

    public h0(f.o oVar) {
        this.f6563q = oVar;
        Method method = nb.c.f9312a;
    }

    @Override // ib.q
    public final void M(pa.i iVar, Runnable runnable) {
        try {
            this.f6563q.execute(runnable);
        } catch (RejectedExecutionException e7) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e7);
            p0 p0Var = (p0) iVar.s(r.f6589p);
            if (p0Var != null) {
                p0Var.c(cancellationException);
            }
            a0.f6542b.M(iVar, runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f6563q;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof h0) && ((h0) obj).f6563q == this.f6563q;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f6563q);
    }

    @Override // ib.q
    public final String toString() {
        return this.f6563q.toString();
    }
}
