package pb;

import androidx.emoji2.text.s;
import ib.v;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Executor, Closeable {

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f10162v = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f10163w = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");

    /* renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10164x = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");

    /* renamed from: y, reason: collision with root package name */
    public static final s f10165y = new s("NOT_IN_STACK", false, 6);
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: o, reason: collision with root package name */
    public final int f10166o;

    /* renamed from: p, reason: collision with root package name */
    public final int f10167p;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* renamed from: q, reason: collision with root package name */
    public final long f10168q;

    /* renamed from: r, reason: collision with root package name */
    public final String f10169r;

    /* renamed from: s, reason: collision with root package name */
    public final f f10170s;

    /* renamed from: t, reason: collision with root package name */
    public final f f10171t;

    /* renamed from: u, reason: collision with root package name */
    public final nb.s f10172u;

    public c(int i10, int i11, long j10, String str) {
        this.f10166o = i10;
        this.f10167p = i11;
        this.f10168q = j10;
        this.f10169r = str;
        if (i10 < 1) {
            throw new IllegalArgumentException(android.support.v4.media.d.o("Core pool size ", i10, " should be at least 1").toString());
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(android.support.v4.media.d.p("Max pool size ", " should be greater than or equals to core pool size ", i11, i10).toString());
        }
        if (i11 > 2097150) {
            throw new IllegalArgumentException(android.support.v4.media.d.o("Max pool size ", i11, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j10 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
        }
        this.f10170s = new f();
        this.f10171t = new f();
        this.f10172u = new nb.s((i10 + 1) * 2);
        this.controlState$volatile = i10 << 42;
        this._isTerminated$volatile = 0;
    }

    public static /* synthetic */ void n(c cVar, Runnable runnable, int i10) {
        cVar.c(runnable, k.g, (i10 & 4) == 0);
    }

    public final boolean K() {
        s sVar;
        int i10;
        while (true) {
            long j10 = f10162v.get(this);
            a aVar = (a) this.f10172u.b((int) (2097151 & j10));
            if (aVar == null) {
                aVar = null;
            } else {
                long j11 = (2097152 + j10) & (-2097152);
                Object c10 = aVar.c();
                while (true) {
                    sVar = f10165y;
                    if (c10 == sVar) {
                        i10 = -1;
                        break;
                    }
                    if (c10 == null) {
                        i10 = 0;
                        break;
                    }
                    a aVar2 = (a) c10;
                    i10 = aVar2.b();
                    if (i10 != 0) {
                        break;
                    }
                    c10 = aVar2.c();
                }
                if (i10 >= 0) {
                    if (f10162v.compareAndSet(this, j10, i10 | j11)) {
                        aVar.g(sVar);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f10147w.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    public final int a() {
        synchronized (this.f10172u) {
            try {
                if (f10164x.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f10163w;
                long j10 = atomicLongFieldUpdater.get(this);
                int i10 = (int) (j10 & 2097151);
                int i11 = i10 - ((int) ((j10 & 4398044413952L) >> 21));
                if (i11 < 0) {
                    i11 = 0;
                }
                if (i11 >= this.f10166o) {
                    return 0;
                }
                if (i10 >= this.f10167p) {
                    return 0;
                }
                int i12 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i12 <= 0 || this.f10172u.b(i12) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i12);
                this.f10172u.c(i12, aVar);
                if (i12 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i13 = i11 + 1;
                aVar.start();
                return i13;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Runnable runnable, androidx.leanback.widget.i iVar, boolean z10) {
        i jVar;
        b bVar;
        k.f10186f.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof i) {
            jVar = (i) runnable;
            jVar.f10178o = nanoTime;
            jVar.f10179p = iVar;
        } else {
            jVar = new j(runnable, nanoTime, iVar);
        }
        boolean z11 = false;
        boolean z12 = jVar.f10179p.f1022o == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f10163w;
        long addAndGet = z12 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread currentThread = Thread.currentThread();
        a aVar = currentThread instanceof a ? (a) currentThread : null;
        if (aVar == null || !za.h.a(aVar.f10155v, this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f10150q) != b.f10160s && (jVar.f10179p.f1022o != 0 || bVar != b.f10157p)) {
            aVar.f10154u = true;
            m mVar = aVar.f10148o;
            if (z10) {
                jVar = mVar.a(jVar);
            } else {
                mVar.getClass();
                i iVar2 = (i) m.f10189b.getAndSet(mVar, jVar);
                jVar = iVar2 == null ? null : mVar.a(iVar2);
            }
        }
        if (jVar != null) {
            if (!(jVar.f10179p.f1022o == 1 ? this.f10171t.a(jVar) : this.f10170s.a(jVar))) {
                throw new RejectedExecutionException(android.support.v4.media.d.r(new StringBuilder(), this.f10169r, " was terminated"));
            }
        }
        if (z10 && aVar != null) {
            z11 = true;
        }
        if (z12) {
            if (z11 || K() || x(addAndGet)) {
                return;
            }
            K();
            return;
        }
        if (z11 || K() || x(atomicLongFieldUpdater.get(this))) {
            return;
        }
        K();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        if (r1 == null) goto L39;
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = pb.c.f10164x
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof pb.a
            r3 = 0
            if (r1 == 0) goto L17
            pb.a r0 = (pb.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            pb.c r1 = r0.f10155v
            boolean r1 = za.h.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            nb.s r1 = r8.f10172u
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = pb.c.f10163w     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            nb.s r5 = r8.f10172u
            java.lang.Object r5 = r5.b(r1)
            za.h.b(r5)
            pb.a r5 = (pb.a) r5
            if (r5 == r0) goto L73
        L43:
            java.lang.Thread$State r6 = r5.getState()
            java.lang.Thread$State r7 = java.lang.Thread.State.TERMINATED
            if (r6 == r7) goto L54
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L43
        L54:
            pb.m r5 = r5.f10148o
            pb.f r6 = r8.f10171t
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = pb.m.f10189b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            pb.i r7 = (pb.i) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            pb.i r7 = r5.b()
            if (r7 != 0) goto L6f
            goto L73
        L6f:
            r6.a(r7)
            goto L68
        L73:
            if (r1 == r4) goto L78
            int r1 = r1 + 1
            goto L36
        L78:
            pb.f r1 = r8.f10171t
            r1.b()
            pb.f r1 = r8.f10170s
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            pb.i r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            pb.f r1 = r8.f10170s
            java.lang.Object r1 = r1.d()
            pb.i r1 = (pb.i) r1
            if (r1 != 0) goto Lb2
            pb.f r1 = r8.f10171t
            java.lang.Object r1 = r1.d()
            pb.i r1 = (pb.i) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            pb.b r1 = pb.b.f10160s
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = pb.c.f10162v
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = pb.c.f10163w
            r0.set(r8, r1)
            return
        Lb2:
            r1.run()     // Catch: java.lang.Throwable -> Lb6
            goto L82
        Lb6:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L82
        Lc3:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.c.close():void");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        n(this, runnable, 6);
    }

    public final void s(a aVar, int i10, int i11) {
        while (true) {
            long j10 = f10162v.get(this);
            int i12 = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & (-2097152);
            if (i12 == i10) {
                if (i11 == 0) {
                    Object c10 = aVar.c();
                    while (true) {
                        if (c10 == f10165y) {
                            i12 = -1;
                            break;
                        }
                        if (c10 == null) {
                            i12 = 0;
                            break;
                        }
                        a aVar2 = (a) c10;
                        int b2 = aVar2.b();
                        if (b2 != 0) {
                            i12 = b2;
                            break;
                        }
                        c10 = aVar2.c();
                    }
                } else {
                    i12 = i11;
                }
            }
            if (i12 >= 0) {
                if (f10162v.compareAndSet(this, j10, i12 | j11)) {
                    return;
                }
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        nb.s sVar = this.f10172u;
        int a10 = sVar.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < a10; i15++) {
            a aVar = (a) sVar.b(i15);
            if (aVar != null) {
                m mVar = aVar.f10148o;
                mVar.getClass();
                int i16 = m.f10189b.get(mVar) != null ? (m.f10190c.get(mVar) - m.f10191d.get(mVar)) + 1 : m.f10190c.get(mVar) - m.f10191d.get(mVar);
                int ordinal = aVar.f10150q.ordinal();
                if (ordinal == 0) {
                    i10++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i16);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (ordinal == 1) {
                    i11++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i16);
                    sb3.append('b');
                    arrayList.add(sb3.toString());
                } else if (ordinal == 2) {
                    i12++;
                } else if (ordinal == 3) {
                    i13++;
                    if (i16 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(i16);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else if (ordinal == 4) {
                    i14++;
                }
            }
        }
        long j10 = f10163w.get(this);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f10169r);
        sb5.append('@');
        sb5.append(v.b(this));
        sb5.append("[Pool Size {core = ");
        int i17 = this.f10166o;
        sb5.append(i17);
        sb5.append(", max = ");
        sb5.append(this.f10167p);
        sb5.append("}, Worker States {CPU = ");
        sb5.append(i10);
        sb5.append(", blocking = ");
        sb5.append(i11);
        sb5.append(", parked = ");
        sb5.append(i12);
        sb5.append(", dormant = ");
        sb5.append(i13);
        sb5.append(", terminated = ");
        sb5.append(i14);
        sb5.append("}, running workers queues = ");
        sb5.append(arrayList);
        sb5.append(", global CPU queue size = ");
        sb5.append(this.f10170s.c());
        sb5.append(", global blocking queue size = ");
        sb5.append(this.f10171t.c());
        sb5.append(", Control State {created workers= ");
        sb5.append((int) (2097151 & j10));
        sb5.append(", blocking tasks = ");
        sb5.append((int) ((4398044413952L & j10) >> 21));
        sb5.append(", CPUs acquired = ");
        sb5.append(i17 - ((int) ((j10 & 9223367638808264704L) >> 42)));
        sb5.append("}]");
        return sb5.toString();
    }

    public final boolean x(long j10) {
        int i10 = ((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21));
        if (i10 < 0) {
            i10 = 0;
        }
        int i11 = this.f10166o;
        if (i10 < i11) {
            int a10 = a();
            if (a10 == 1 && i11 > 1) {
                a();
            }
            if (a10 > 0) {
                return true;
            }
        }
        return false;
    }
}
