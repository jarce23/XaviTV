package pl.droidsonroids.gif;

import java.lang.Thread;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final c f10215o;

    public f(c cVar) {
        this.f10215o = cVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        try {
            GifInfoHandle gifInfoHandle = this.f10215o.f10208u;
            synchronized (gifInfoHandle) {
                z10 = gifInfoHandle.f10198a == 0;
            }
            if (z10) {
                return;
            }
            a();
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
