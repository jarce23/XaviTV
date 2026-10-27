package o4;

import android.content.Context;
import androidx.work.WorkerParameters;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: o, reason: collision with root package name */
    public final Context f9506o;

    /* renamed from: p, reason: collision with root package name */
    public final WorkerParameters f9507p;

    /* renamed from: q, reason: collision with root package name */
    public volatile int f9508q = -256;

    /* renamed from: r, reason: collision with root package name */
    public boolean f9509r;

    public o(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.f9506o = context;
        this.f9507p = workerParameters;
    }

    public s9.b a() {
        z4.j jVar = new z4.j();
        jVar.j(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return jVar;
    }

    public abstract z4.j c();

    public final void d(int i10) {
        this.f9508q = i10;
        b();
    }

    public void b() {
    }
}
