package z4;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class h implements s9.b {

    /* renamed from: r, reason: collision with root package name */
    public static final boolean f14107r = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: s, reason: collision with root package name */
    public static final Logger f14108s = Logger.getLogger(h.class.getName());

    /* renamed from: t, reason: collision with root package name */
    public static final a.a f14109t;

    /* renamed from: u, reason: collision with root package name */
    public static final Object f14110u;

    /* renamed from: o, reason: collision with root package name */
    public volatile Object f14111o;

    /* renamed from: p, reason: collision with root package name */
    public volatile c f14112p;

    /* renamed from: q, reason: collision with root package name */
    public volatile g f14113q;

    static {
        a.a fVar;
        try {
            fVar = new d(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(h.class, g.class, "q"), AtomicReferenceFieldUpdater.newUpdater(h.class, c.class, "p"), AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "o"));
            th = null;
        } catch (Throwable th) {
            th = th;
            fVar = new f();
        }
        f14109t = fVar;
        if (th != null) {
            f14108s.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f14110u = new Object();
    }

    public static void c(h hVar) {
        c cVar;
        c cVar2;
        c cVar3 = null;
        while (true) {
            g gVar = hVar.f14113q;
            if (f14109t.h(hVar, gVar, g.f14104c)) {
                while (gVar != null) {
                    Thread thread = gVar.f14105a;
                    if (thread != null) {
                        gVar.f14105a = null;
                        LockSupport.unpark(thread);
                    }
                    gVar = gVar.f14106b;
                }
                do {
                    cVar = hVar.f14112p;
                } while (!f14109t.f(hVar, cVar, c.f14093d));
                while (true) {
                    cVar2 = cVar3;
                    cVar3 = cVar;
                    if (cVar3 == null) {
                        break;
                    }
                    cVar = cVar3.f14096c;
                    cVar3.f14096c = cVar2;
                }
                while (cVar2 != null) {
                    cVar3 = cVar2.f14096c;
                    Runnable runnable = cVar2.f14094a;
                    if (runnable instanceof e) {
                        e eVar = (e) runnable;
                        hVar = eVar.f14102o;
                        if (hVar.f14111o == eVar) {
                            if (f14109t.g(hVar, eVar, f(eVar.f14103p))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        d(runnable, cVar2.f14095b);
                    }
                    cVar2 = cVar3;
                }
                return;
            }
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e7) {
            f14108s.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e7);
        }
    }

    public static Object e(Object obj) {
        if (obj instanceof a) {
            Throwable th = ((a) obj).f14090b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof b) {
            throw new ExecutionException(((b) obj).f14092a);
        }
        if (obj == f14110u) {
            return null;
        }
        return obj;
    }

    public static Object f(s9.b bVar) {
        Object obj;
        if (bVar instanceof h) {
            Object obj2 = ((h) bVar).f14111o;
            if (!(obj2 instanceof a)) {
                return obj2;
            }
            a aVar = (a) obj2;
            return aVar.f14089a ? aVar.f14090b != null ? new a(aVar.f14090b, false) : a.f14088d : obj2;
        }
        boolean isCancelled = bVar.isCancelled();
        boolean z10 = true;
        if ((!f14107r) && isCancelled) {
            return a.f14088d;
        }
        boolean z11 = false;
        while (true) {
            try {
                try {
                    obj = bVar.get();
                    break;
                } catch (InterruptedException unused) {
                    z11 = z10;
                } catch (Throwable th) {
                    if (z11) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException e7) {
                if (isCancelled) {
                    return new a(e7, false);
                }
                return new b(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + bVar, e7));
            } catch (ExecutionException e8) {
                return new b(e8.getCause());
            } catch (Throwable th2) {
                return new b(th2);
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
        return obj == null ? f14110u : obj;
    }

    @Override // s9.b
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        c cVar = this.f14112p;
        c cVar2 = c.f14093d;
        if (cVar != cVar2) {
            c cVar3 = new c(runnable, executor);
            do {
                cVar3.f14096c = cVar;
                if (f14109t.f(this, cVar, cVar3)) {
                    return;
                } else {
                    cVar = this.f14112p;
                }
            } while (cVar != cVar2);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb2) {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z10 = true;
                } catch (Throwable th) {
                    if (z10) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb2.append("CANCELLED");
                return;
            } catch (RuntimeException e7) {
                sb2.append("UNKNOWN, cause=[");
                sb2.append(e7.getClass());
                sb2.append(" thrown from get()]");
                return;
            } catch (ExecutionException e8) {
                sb2.append("FAILURE, cause=[");
                sb2.append(e8.getCause());
                sb2.append("]");
                return;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        sb2.append("SUCCESS, result=[");
        sb2.append(obj == this ? "this future" : String.valueOf(obj));
        sb2.append("]");
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f14111o;
        if (!(obj == null) && !(obj instanceof e)) {
            return false;
        }
        a aVar = f14107r ? new a(new CancellationException("Future.cancel() was called."), z10) : z10 ? a.f14087c : a.f14088d;
        h hVar = this;
        boolean z11 = false;
        while (true) {
            if (f14109t.g(hVar, obj, aVar)) {
                c(hVar);
                if (!(obj instanceof e)) {
                    break;
                }
                s9.b bVar = ((e) obj).f14103p;
                if (!(bVar instanceof h)) {
                    bVar.cancel(z10);
                    break;
                }
                hVar = (h) bVar;
                obj = hVar.f14111o;
                if (!(obj == null) && !(obj instanceof e)) {
                    break;
                }
                z11 = true;
            } else {
                obj = hVar.f14111o;
                if (!(obj instanceof e)) {
                    return z11;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String g() {
        Object obj = this.f14111o;
        if (obj instanceof e) {
            StringBuilder sb2 = new StringBuilder("setFuture=[");
            s9.b bVar = ((e) obj).f14103p;
            return android.support.v4.media.d.r(sb2, bVar == this ? "this future" : String.valueOf(bVar), "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00b0 -> B:33:0x0078). Please report as a decompilation issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(long r19, java.util.concurrent.TimeUnit r21) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.h.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    public final void h(g gVar) {
        gVar.f14105a = null;
        while (true) {
            g gVar2 = this.f14113q;
            if (gVar2 == g.f14104c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f14106b;
                if (gVar2.f14105a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f14106b = gVar4;
                    if (gVar3.f14105a == null) {
                        break;
                    }
                } else if (!f14109t.h(this, gVar2, gVar4)) {
                    break;
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f14111o instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof e)) & (this.f14111o != null);
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (this.f14111o instanceof a) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            b(sb2);
        } else {
            try {
                str = g();
            } catch (RuntimeException e7) {
                str = "Exception thrown from implementation: " + e7.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(str);
                sb2.append("]");
            } else if (isDone()) {
                b(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        g gVar = g.f14104c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f14111o;
            if ((obj2 != null) & (!(obj2 instanceof e))) {
                return e(obj2);
            }
            g gVar2 = this.f14113q;
            if (gVar2 != gVar) {
                g gVar3 = new g();
                do {
                    a.a aVar = f14109t;
                    aVar.q(gVar3, gVar2);
                    if (aVar.h(this, gVar2, gVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f14111o;
                            } else {
                                h(gVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof e))));
                        return e(obj);
                    }
                    gVar2 = this.f14113q;
                } while (gVar2 != gVar);
            }
            return e(this.f14111o);
        }
        throw new InterruptedException();
    }
}
