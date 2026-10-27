package i2;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Executor {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f6136o;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f6136o) {
            case 0:
                break;
            case 1:
                n.a.w().f9089b.f9092c.execute(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }

    private final void a(Runnable runnable) {
    }
}
