package m5;

import android.os.Process;
import app.shamel.tv.activities.y;
import j9.o0;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends Thread {

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f8957u = p.f9002a;

    /* renamed from: o, reason: collision with root package name */
    public final BlockingQueue f8958o;

    /* renamed from: p, reason: collision with root package name */
    public final BlockingQueue f8959p;

    /* renamed from: q, reason: collision with root package name */
    public final o0 f8960q;

    /* renamed from: r, reason: collision with root package name */
    public final h5.i f8961r;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f8962s = false;

    /* renamed from: t, reason: collision with root package name */
    public final x4.i f8963t;

    public c(PriorityBlockingQueue priorityBlockingQueue, PriorityBlockingQueue priorityBlockingQueue2, o0 o0Var, h5.i iVar) {
        this.f8958o = priorityBlockingQueue;
        this.f8959p = priorityBlockingQueue2;
        this.f8960q = o0Var;
        this.f8961r = iVar;
        this.f8963t = new x4.i(this, priorityBlockingQueue2, iVar);
    }

    private void a() {
        i iVar = (i) this.f8958o.take();
        iVar.a("cache-queue-take");
        iVar.m();
        try {
            iVar.i();
            b a10 = this.f8960q.a(iVar.f());
            if (a10 == null) {
                iVar.a("cache-miss");
                if (!this.f8963t.r(iVar)) {
                    this.f8959p.put(iVar);
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (a10.f8954e < currentTimeMillis) {
                iVar.a("cache-hit-expired");
                iVar.f8985z = a10;
                if (!this.f8963t.r(iVar)) {
                    this.f8959p.put(iVar);
                }
                return;
            }
            iVar.a("cache-hit");
            c4.e l10 = iVar.l(new c4.e(a10.f8950a, a10.g));
            iVar.a("cache-hit-parsed");
            if (((m) l10.f2878r) == null) {
                if (a10.f8955f < currentTimeMillis) {
                    iVar.a("cache-hit-refresh-needed");
                    iVar.f8985z = a10;
                    l10.f2875o = true;
                    if (this.f8963t.r(iVar)) {
                        this.f8961r.H(iVar, l10, null);
                    } else {
                        this.f8961r.H(iVar, l10, new y(this, 24, iVar));
                    }
                } else {
                    this.f8961r.H(iVar, l10, null);
                }
                return;
            }
            iVar.a("cache-parsing-failed");
            o0 o0Var = this.f8960q;
            String f10 = iVar.f();
            synchronized (o0Var) {
                b a11 = o0Var.a(f10);
                if (a11 != null) {
                    a11.f8955f = 0L;
                    a11.f8954e = 0L;
                    o0Var.g(f10, a11);
                }
            }
            iVar.f8985z = null;
            if (!this.f8963t.r(iVar)) {
                this.f8959p.put(iVar);
            }
        } finally {
            iVar.m();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (f8957u) {
            p.d("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f8960q.e();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f8962s) {
                    Thread.currentThread().interrupt();
                    return;
                }
                p.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
