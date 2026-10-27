package o4;

import ib.l0;
import ib.s0;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements s9.b {

    /* renamed from: o, reason: collision with root package name */
    public final z4.j f9503o = new z4.j();

    public j(s0 s0Var) {
        s0Var.C(false, true, new l0(new kb.q(1, this)));
    }

    @Override // s9.b
    public final void a(Runnable runnable, Executor executor) {
        this.f9503o.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        return this.f9503o.cancel(z10);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f9503o.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f9503o.f14111o instanceof z4.a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f9503o.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) {
        return this.f9503o.get(j10, timeUnit);
    }
}
