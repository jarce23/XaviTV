package com.google.android.gms.internal.cast;

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
public abstract class b4 extends com.bumptech.glide.c implements s9.b {

    /* renamed from: s, reason: collision with root package name */
    public static final boolean f3262s;

    /* renamed from: t, reason: collision with root package name */
    public static final Logger f3263t;

    /* renamed from: u, reason: collision with root package name */
    public static final y7.d f3264u;

    /* renamed from: v, reason: collision with root package name */
    public static final Object f3265v;

    /* renamed from: p, reason: collision with root package name */
    public volatile Object f3266p;

    /* renamed from: q, reason: collision with root package name */
    public volatile v3 f3267q;

    /* renamed from: r, reason: collision with root package name */
    public volatile a4 f3268r;

    static {
        boolean z10;
        y7.d x3Var;
        Throwable th;
        Throwable th2;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        f3262s = z10;
        f3263t = Logger.getLogger(b4.class.getName());
        try {
            x3Var = new z3();
            th = null;
            th2 = null;
        } catch (Error | RuntimeException e7) {
            try {
                th = null;
                th2 = e7;
                x3Var = new w3(AtomicReferenceFieldUpdater.newUpdater(a4.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(a4.class, a4.class, "b"), AtomicReferenceFieldUpdater.newUpdater(b4.class, a4.class, "r"), AtomicReferenceFieldUpdater.newUpdater(b4.class, v3.class, "q"), AtomicReferenceFieldUpdater.newUpdater(b4.class, Object.class, "p"));
            } catch (Error | RuntimeException e8) {
                x3Var = new x3();
                th = e8;
                th2 = e7;
            }
        }
        f3264u = x3Var;
        if (th != null) {
            Logger logger = f3263t;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        f3265v = new Object();
    }

    public static Object H(b4 b4Var) {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = b4Var.get();
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

    public static void J(b4 b4Var) {
        for (a4 F = f3264u.F(b4Var); F != null; F = F.f3252b) {
            Thread thread = F.f3251a;
            if (thread != null) {
                F.f3251a = null;
                LockSupport.unpark(thread);
            }
        }
        b4Var.G();
        v3 B = f3264u.B(b4Var);
        v3 v3Var = null;
        while (B != null) {
            v3 v3Var2 = B.f3531c;
            B.f3531c = v3Var;
            v3Var = B;
            B = v3Var2;
        }
        while (v3Var != null) {
            Runnable runnable = v3Var.f3529a;
            v3 v3Var3 = v3Var.f3531c;
            runnable.getClass();
            Executor executor = v3Var.f3530b;
            executor.getClass();
            K(runnable, executor);
            v3Var = v3Var3;
        }
    }

    public static void K(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e7) {
            f3263t.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e7);
        }
    }

    public static final Object M(Object obj) {
        if (obj instanceof s3) {
            Throwable th = ((s3) obj).f3450b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof u3) {
            throw new ExecutionException(((u3) obj).f3488a);
        }
        if (obj == f3265v) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String F() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void I(StringBuilder sb2) {
        try {
            Object H = H(this);
            sb2.append("SUCCESS, result=[");
            if (H == null) {
                sb2.append("null");
            } else if (H == this) {
                sb2.append("this future");
            } else {
                sb2.append(H.getClass().getName());
                sb2.append("@");
                sb2.append(Integer.toHexString(System.identityHashCode(H)));
            }
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

    public final void L(a4 a4Var) {
        a4Var.f3251a = null;
        while (true) {
            a4 a4Var2 = this.f3268r;
            if (a4Var2 != a4.f3250c) {
                a4 a4Var3 = null;
                while (a4Var2 != null) {
                    a4 a4Var4 = a4Var2.f3252b;
                    if (a4Var2.f3251a != null) {
                        a4Var3 = a4Var2;
                    } else if (a4Var3 != null) {
                        a4Var3.f3252b = a4Var4;
                        if (a4Var3.f3251a == null) {
                            break;
                        }
                    } else if (!f3264u.L(this, a4Var2, a4Var4)) {
                        break;
                    }
                    a4Var2 = a4Var4;
                }
                return;
            }
            return;
        }
    }

    @Override // s9.b
    public final void a(Runnable runnable, Executor executor) {
        v3 v3Var;
        v3 v3Var2 = v3.f3528d;
        if (executor == null) {
            throw new NullPointerException("Executor was null.");
        }
        if (!isDone() && (v3Var = this.f3267q) != v3Var2) {
            v3 v3Var3 = new v3(runnable, executor);
            do {
                v3Var3.f3531c = v3Var;
                if (f3264u.J(this, v3Var, v3Var3)) {
                    return;
                } else {
                    v3Var = this.f3267q;
                }
            } while (v3Var != v3Var2);
        }
        K(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        s3 s3Var;
        Object obj = this.f3266p;
        if (obj != null) {
            return false;
        }
        if (f3262s) {
            s3Var = new s3(new CancellationException("Future.cancel() was called."), z10);
        } else {
            s3Var = z10 ? s3.f3447c : s3.f3448d;
            s3Var.getClass();
        }
        if (!f3264u.K(this, obj, s3Var)) {
            return false;
        }
        J(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        a4 a4Var = a4.f3250c;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f3266p;
        if (obj2 != null) {
            return M(obj2);
        }
        a4 a4Var2 = this.f3268r;
        if (a4Var2 != a4Var) {
            a4 a4Var3 = new a4();
            do {
                y7.d dVar = f3264u;
                dVar.H(a4Var3, a4Var2);
                if (dVar.L(this, a4Var2, a4Var3)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            L(a4Var3);
                            throw new InterruptedException();
                        }
                        obj = this.f3266p;
                    } while (obj == null);
                    return M(obj);
                }
                a4Var2 = this.f3268r;
            } while (a4Var2 != a4Var);
        }
        Object obj3 = this.f3266p;
        obj3.getClass();
        return M(obj3);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f3266p instanceof s3;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f3266p != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006e, code lost:
    
        if (r3.isEmpty() != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class r1 = r5.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "com.google.common.util.concurrent."
            boolean r1 = r1.startsWith(r2)
            if (r1 == 0) goto L21
            java.lang.Class r1 = r5.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            goto L2c
        L21:
            java.lang.Class r1 = r5.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
        L2c:
            r1 = 64
            r0.append(r1)
            int r1 = java.lang.System.identityHashCode(r5)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            java.lang.String r1 = "[status="
            r0.append(r1)
            java.lang.Object r1 = r5.f3266p
            boolean r1 = r1 instanceof com.google.android.gms.internal.cast.s3
            java.lang.String r2 = "]"
            if (r1 == 0) goto L4f
            java.lang.String r1 = "CANCELLED"
            r0.append(r1)
            goto La0
        L4f:
            boolean r1 = r5.isDone()
            if (r1 == 0) goto L59
            r5.I(r0)
            goto La0
        L59:
            int r1 = r0.length()
            java.lang.String r3 = "PENDING"
            r0.append(r3)
            java.lang.String r3 = r5.F()     // Catch: java.lang.StackOverflowError -> L72 java.lang.RuntimeException -> L74
            int r4 = com.google.android.gms.internal.cast.y.f3585a     // Catch: java.lang.StackOverflowError -> L72 java.lang.RuntimeException -> L74
            if (r3 == 0) goto L70
            boolean r4 = r3.isEmpty()     // Catch: java.lang.StackOverflowError -> L72 java.lang.RuntimeException -> L74
            if (r4 == 0) goto L83
        L70:
            r3 = 0
            goto L83
        L72:
            r3 = move-exception
            goto L75
        L74:
            r3 = move-exception
        L75:
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Exception thrown from implementation: "
            java.lang.String r3 = r4.concat(r3)
        L83:
            if (r3 == 0) goto L90
            java.lang.String r4 = ", info=["
            r0.append(r4)
            r0.append(r3)
            r0.append(r2)
        L90:
            boolean r3 = r5.isDone()
            if (r3 == 0) goto La0
            int r3 = r0.length()
            r0.delete(r1, r3)
            r5.I(r0)
        La0:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.b4.toString():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ab  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x009e -> B:28:0x006b). Please report as a decompilation issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(long r18, java.util.concurrent.TimeUnit r20) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.b4.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    public void G() {
    }
}
