package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.activity.d;
import androidx.work.WorkerParameters;
import b5.a;
import o4.o;
import o4.p;
import t4.b;
import t4.c;
import t4.e;
import z4.j;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class ConstraintTrackingWorker extends o implements e {

    /* renamed from: s, reason: collision with root package name */
    public final WorkerParameters f1556s;

    /* renamed from: t, reason: collision with root package name */
    public final Object f1557t;

    /* renamed from: u, reason: collision with root package name */
    public volatile boolean f1558u;

    /* renamed from: v, reason: collision with root package name */
    public final j f1559v;

    /* renamed from: w, reason: collision with root package name */
    public o f1560w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        h.e("appContext", context);
        h.e("workerParameters", workerParameters);
        this.f1556s = workerParameters;
        this.f1557t = new Object();
        this.f1559v = new j();
    }

    @Override // o4.o
    public final void b() {
        o oVar = this.f1560w;
        if (oVar == null || oVar.f9508q != -256) {
            return;
        }
        oVar.d(Build.VERSION.SDK_INT >= 31 ? this.f9508q : 0);
    }

    @Override // o4.o
    public final j c() {
        this.f9507p.f1520c.execute(new d(7, this));
        j jVar = this.f1559v;
        h.d("future", jVar);
        return jVar;
    }

    @Override // t4.e
    public final void e(x4.o oVar, c cVar) {
        h.e("state", cVar);
        p.d().a(a.f2473a, "Constraints changed for " + oVar);
        if (cVar instanceof b) {
            synchronized (this.f1557t) {
                this.f1558u = true;
            }
        }
    }
}
