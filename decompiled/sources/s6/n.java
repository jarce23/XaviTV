package s6;

import android.os.Process;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11623o;

    /* renamed from: p, reason: collision with root package name */
    public final Runnable f11624p;

    public /* synthetic */ n(Runnable runnable, int i10) {
        this.f11623o = i10;
        this.f11624p = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11623o) {
            case 0:
                try {
                    this.f11624p.run();
                    break;
                } catch (Exception e7) {
                    Log.e("TransportRuntime.".concat("Executor"), "Background execution failure.", e7);
                    return;
                }
            default:
                Process.setThreadPriority(10);
                this.f11624p.run();
                break;
        }
    }
}
