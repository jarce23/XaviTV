package u1;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements Executor {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f12292o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Handler f12293p;

    public /* synthetic */ x(Handler handler, int i10) {
        this.f12292o = i10;
        this.f12293p = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Handler handler;
        switch (this.f12292o) {
            case 0:
                handler = this.f12293p;
                break;
            default:
                handler = (w3.t) this.f12293p;
                break;
        }
        handler.post(runnable);
    }
}
