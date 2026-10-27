package m5;

import android.os.Handler;
import android.os.Looper;
import j9.o0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f8986a;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f8987b;

    /* renamed from: c, reason: collision with root package name */
    public final PriorityBlockingQueue f8988c;

    /* renamed from: d, reason: collision with root package name */
    public final PriorityBlockingQueue f8989d;

    /* renamed from: e, reason: collision with root package name */
    public final o0 f8990e;

    /* renamed from: f, reason: collision with root package name */
    public final x4.c f8991f;
    public final h5.i g;

    /* renamed from: h, reason: collision with root package name */
    public final f[] f8992h;

    /* renamed from: i, reason: collision with root package name */
    public c f8993i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f8994j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f8995k;

    public j(o0 o0Var, x4.c cVar) {
        h5.i iVar = new h5.i(new Handler(Looper.getMainLooper()));
        this.f8986a = new AtomicInteger();
        this.f8987b = new HashSet();
        this.f8988c = new PriorityBlockingQueue();
        this.f8989d = new PriorityBlockingQueue();
        this.f8994j = new ArrayList();
        this.f8995k = new ArrayList();
        this.f8990e = o0Var;
        this.f8991f = cVar;
        this.f8992h = new f[4];
        this.g = iVar;
    }

    public final void a(i iVar) {
        iVar.f8981v = this;
        synchronized (this.f8987b) {
            this.f8987b.add(iVar);
        }
        iVar.f8980u = Integer.valueOf(this.f8986a.incrementAndGet());
        iVar.a("add-to-queue");
        b();
        if (iVar.f8982w) {
            this.f8988c.add(iVar);
        } else {
            this.f8989d.add(iVar);
        }
    }

    public final void b() {
        synchronized (this.f8995k) {
            try {
                Iterator it = this.f8995k.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
