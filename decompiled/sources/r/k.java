package r;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements s9.b {

    /* renamed from: o, reason: collision with root package name */
    public final WeakReference f10404o;

    /* renamed from: p, reason: collision with root package name */
    public final j f10405p = new j(this);

    public k(i iVar) {
        this.f10404o = new WeakReference(iVar);
    }

    @Override // s9.b
    public final void a(Runnable runnable, Executor executor) {
        this.f10405p.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        i iVar = (i) this.f10404o.get();
        boolean cancel = this.f10405p.cancel(z10);
        if (cancel && iVar != null) {
            iVar.f10399a = null;
            iVar.f10400b = null;
            iVar.f10401c.i(null);
        }
        return cancel;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f10405p.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f10405p.f10396o instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f10405p.isDone();
    }

    public final String toString() {
        return this.f10405p.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) {
        return this.f10405p.get(j10, timeUnit);
    }
}
