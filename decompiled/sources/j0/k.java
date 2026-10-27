package j0;

import android.os.Process;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends Thread {

    /* renamed from: o, reason: collision with root package name */
    public final int f6936o;

    public k(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.f6936o = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f6936o);
        super.run();
    }
}
