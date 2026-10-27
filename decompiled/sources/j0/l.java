package j0;

import java.util.concurrent.ThreadFactory;
import s6.n;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6937a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f6937a) {
            case 0:
                return new k(runnable);
            case 1:
                return new Thread(runnable, "UpdateListenerExecutor");
            case 2:
                return new Thread(runnable, "AssetPackBackgroundExecutor");
            default:
                return new Thread(new n(runnable, 1), "glide-active-resources");
        }
    }
}
