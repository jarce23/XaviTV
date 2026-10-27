package r;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class h implements s9.b {

    /* renamed from: r, reason: collision with root package name */
    public static final boolean f10392r = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: s, reason: collision with root package name */
    public static final Logger f10393s = Logger.getLogger(h.class.getName());

    /* renamed from: t, reason: collision with root package name */
    public static final com.bumptech.glide.c f10394t;

    /* renamed from: u, reason: collision with root package name */
    public static final Object f10395u;

    /* renamed from: o, reason: collision with root package name */
    public volatile Object f10396o;

    /* renamed from: p, reason: collision with root package name */
    public volatile d f10397p;

    /* renamed from: q, reason: collision with root package name */
    public volatile g f10398q;

    static {
        com.bumptech.glide.c fVar;
        try {
            fVar = new e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(h.class, g.class, "q"), AtomicReferenceFieldUpdater.newUpdater(h.class, d.class, "p"), AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "o"));
            th = null;
        } catch (Throwable th) {
            th = th;
            fVar = new f();
        }
        f10394t = fVar;
        if (th != null) {
            f10393s.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f10395u = new Object();
    }

    public static void c(h hVar) {
        g gVar;
        d dVar;
        d dVar2;
        d dVar3;
        do {
            gVar = hVar.f10398q;
        } while (!f10394t.g(hVar, gVar, g.f10389c));
        while (true) {
            dVar = null;
            if (gVar == null) {
                break;
            }
            Thread thread = gVar.f10390a;
            if (thread != null) {
                gVar.f10390a = null;
                LockSupport.unpark(thread);
            }
            gVar = gVar.f10391b;
        }
        do {
            dVar2 = hVar.f10397p;
        } while (!f10394t.e(hVar, dVar2, d.f10380d));
        while (true) {
            dVar3 = dVar;
            dVar = dVar2;
            if (dVar == null) {
                break;
            }
            dVar2 = dVar.f10383c;
            dVar.f10383c = dVar3;
        }
        while (dVar3 != null) {
            d dVar4 = dVar3.f10383c;
            d(dVar3.f10381a, dVar3.f10382b);
            dVar3 = dVar4;
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e7) {
            f10393s.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e7);
        }
    }

    public static Object e(Object obj) {
        if (obj instanceof b) {
            Throwable th = ((b) obj).f10378a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f10379a);
        }
        if (obj == f10395u) {
            return null;
        }
        return obj;
    }

    public static Object f(h hVar) {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = hVar.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    @Override // s9.b
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        d dVar = this.f10397p;
        d dVar2 = d.f10380d;
        if (dVar != dVar2) {
            d dVar3 = new d(runnable, executor);
            do {
                dVar3.f10383c = dVar;
                if (f10394t.e(this, dVar, dVar3)) {
                    return;
                } else {
                    dVar = this.f10397p;
                }
            } while (dVar != dVar2);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb2) {
        try {
            Object f10 = f(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(f10 == this ? "this future" : String.valueOf(f10));
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e7) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e7.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e8) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e8.getCause());
            sb2.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f10396o;
        if (obj != null) {
            return false;
        }
        if (!f10394t.f(this, obj, f10392r ? new b(new CancellationException("Future.cancel() was called."), z10) : z10 ? b.f10376b : b.f10377c)) {
            return false;
        }
        c(this);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String g() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) {
        g gVar = g.f10389c;
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f10396o;
        if (obj != null) {
            return e(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            g gVar2 = this.f10398q;
            if (gVar2 != gVar) {
                g gVar3 = new g();
                do {
                    com.bumptech.glide.c cVar = f10394t;
                    cVar.t(gVar3, gVar2);
                    if (cVar.g(this, gVar2, gVar3)) {
                        while (true) {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                h(gVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f10396o;
                            if (obj2 != null) {
                                return e(obj2);
                            }
                            long nanoTime2 = nanoTime - System.nanoTime();
                            if (nanoTime2 < 1000) {
                                h(gVar3);
                                nanos = nanoTime2;
                                break;
                            }
                            nanos = nanoTime2;
                        }
                    } else {
                        gVar2 = this.f10398q;
                    }
                } while (gVar2 != gVar);
            }
            return e(this.f10396o);
        }
        while (nanos > 0) {
            Object obj3 = this.f10396o;
            if (obj3 != null) {
                return e(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String hVar = toString();
        String obj4 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj4.toLowerCase(locale);
        String str = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String c10 = a.c(str, " (plus ");
            long j11 = -nanos;
            long convert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(convert);
            boolean z10 = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str2 = c10 + convert + " " + lowerCase;
                if (z10) {
                    str2 = a.c(str2, ",");
                }
                c10 = a.c(str2, " ");
            }
            if (z10) {
                c10 = c10 + nanos2 + " nanoseconds ";
            }
            str = a.c(c10, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(a.c(str, " but future completed as timeout expired"));
        }
        throw new TimeoutException(str + " for " + hVar);
    }

    public final void h(g gVar) {
        gVar.f10390a = null;
        while (true) {
            g gVar2 = this.f10398q;
            if (gVar2 == g.f10389c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f10391b;
                if (gVar2.f10390a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f10391b = gVar4;
                    if (gVar3.f10390a == null) {
                        break;
                    }
                } else if (!f10394t.g(this, gVar2, gVar4)) {
                    break;
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f10396o instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f10396o != null;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (this.f10396o instanceof b) {
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
        g gVar = g.f10389c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f10396o;
            if (obj2 != null) {
                return e(obj2);
            }
            g gVar2 = this.f10398q;
            if (gVar2 != gVar) {
                g gVar3 = new g();
                do {
                    com.bumptech.glide.c cVar = f10394t;
                    cVar.t(gVar3, gVar2);
                    if (cVar.g(this, gVar2, gVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f10396o;
                            } else {
                                h(gVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return e(obj);
                    }
                    gVar2 = this.f10398q;
                } while (gVar2 != gVar);
            }
            return e(this.f10396o);
        }
        throw new InterruptedException();
    }
}
