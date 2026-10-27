package i0;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements Executor {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5781o;

    /* renamed from: p, reason: collision with root package name */
    public final Handler f5782p;

    public /* synthetic */ d(Handler handler, int i10) {
        this.f5781o = i10;
        this.f5782p = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f5781o) {
            case 0:
                runnable.getClass();
                Handler handler = this.f5782p;
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            case 1:
                runnable.getClass();
                Handler handler2 = this.f5782p;
                if (handler2.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler2 + " is shutting down");
            case 2:
                this.f5782p.post(runnable);
                return;
            default:
                this.f5782p.post(runnable);
                return;
        }
    }
}
