package androidx.work;

import android.content.Context;
import app.shamel.tv.activities.y;
import o4.g;
import o4.n;
import o4.o;
import s9.b;
import z4.j;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class Worker extends o {

    /* renamed from: s, reason: collision with root package name */
    public j f1517s;

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // o4.o
    public final b a() {
        j jVar = new j();
        this.f9507p.f1520c.execute(new y(this, 27, jVar));
        return jVar;
    }

    @Override // o4.o
    public final j c() {
        this.f1517s = new j();
        this.f9507p.f1520c.execute(new androidx.activity.j(28, this));
        return this.f1517s;
    }

    public abstract n f();

    public g g() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
    }
}
