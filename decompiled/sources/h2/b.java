package h2;

import a6.a0;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements Executor {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Executor f5519o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ a0 f5520p;

    public b(ExecutorService executorService, a0 a0Var) {
        this.f5519o = executorService;
        this.f5520p = a0Var;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f5519o.execute(runnable);
    }
}
