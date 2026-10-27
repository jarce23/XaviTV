package m5;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import g7.c0;
import j9.o0;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends Thread {

    /* renamed from: o, reason: collision with root package name */
    public final BlockingQueue f8966o;

    /* renamed from: p, reason: collision with root package name */
    public final x4.c f8967p;

    /* renamed from: q, reason: collision with root package name */
    public final o0 f8968q;

    /* renamed from: r, reason: collision with root package name */
    public final h5.i f8969r;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f8970s = false;

    public f(PriorityBlockingQueue priorityBlockingQueue, x4.c cVar, o0 o0Var, h5.i iVar) {
        this.f8966o = priorityBlockingQueue;
        this.f8967p = cVar;
        this.f8968q = o0Var;
        this.f8969r = iVar;
    }

    private void a() {
        i iVar = (i) this.f8966o.take();
        h5.i iVar2 = this.f8969r;
        SystemClock.elapsedRealtime();
        iVar.m();
        int i10 = 6;
        Object obj = null;
        try {
            try {
                try {
                    iVar.a("network-queue-take");
                    iVar.i();
                    TrafficStats.setThreadStatsTag(iVar.f8977r);
                    c4.e X = this.f8967p.X(iVar);
                    iVar.a("network-http-complete");
                    if (X.f2875o && iVar.h()) {
                        iVar.c("not-modified");
                        iVar.j();
                        return;
                    }
                    c4.e l10 = iVar.l(X);
                    iVar.a("network-parse-complete");
                    if (iVar.f8982w && ((b) l10.f2877q) != null) {
                        this.f8968q.g(iVar.f(), (b) l10.f2877q);
                        iVar.a("network-cache-written");
                    }
                    synchronized (iVar.f8978s) {
                        iVar.f8983x = true;
                    }
                    iVar2.H(iVar, l10, null);
                    iVar.k(l10);
                } catch (m e7) {
                    SystemClock.elapsedRealtime();
                    iVar2.getClass();
                    iVar.a("post-error");
                    ((i0.d) iVar2.f5610p).execute(new c0(iVar, new c4.e(e7), obj, i10));
                    iVar.j();
                }
            } catch (Exception e8) {
                Log.e("Volley", p.a("Unhandled exception %s", e8.toString()), e8);
                m mVar = new m(e8);
                SystemClock.elapsedRealtime();
                iVar2.getClass();
                iVar.a("post-error");
                ((i0.d) iVar2.f5610p).execute(new c0(iVar, new c4.e(mVar), obj, i10));
                iVar.j();
            }
        } finally {
            iVar.m();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f8970s) {
                    Thread.currentThread().interrupt();
                    return;
                }
                p.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
