package ib;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e0 extends f0 implements y {

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6548t = AtomicReferenceFieldUpdater.newUpdater(e0.class, Object.class, "_queue$volatile");

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6549u = AtomicReferenceFieldUpdater.newUpdater(e0.class, Object.class, "_delayed$volatile");

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6550v = AtomicIntegerFieldUpdater.newUpdater(e0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    @Override // ib.q
    public final void M(pa.i iVar, Runnable runnable) {
        U(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
    
        r6 = R();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        if (java.lang.Thread.currentThread() == r6) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        java.util.concurrent.locks.LockSupport.unpark(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void U(java.lang.Runnable r6) {
        /*
            r5 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ib.e0.f6548t
            java.lang.Object r1 = r0.get(r5)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = ib.e0.f6550v
            int r2 = r2.get(r5)
            if (r2 == 0) goto Lf
            goto L4a
        Lf:
            if (r1 != 0) goto L20
        L11:
            r1 = 0
            boolean r1 = r0.compareAndSet(r5, r1, r6)
            if (r1 == 0) goto L19
            goto L66
        L19:
            java.lang.Object r1 = r0.get(r5)
            if (r1 == 0) goto L11
            goto L0
        L20:
            boolean r2 = r1 instanceof nb.n
            r3 = 1
            if (r2 == 0) goto L46
            r2 = r1
            nb.n r2 = (nb.n) r2
            int r4 = r2.a(r6)
            if (r4 == 0) goto L66
            if (r4 == r3) goto L34
            r0 = 2
            if (r4 == r0) goto L4a
            goto L0
        L34:
            nb.n r2 = r2.c()
        L38:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L3f
            goto L0
        L3f:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L38
            goto L0
        L46:
            androidx.emoji2.text.s r2 = ib.v.f6596b
            if (r1 != r2) goto L50
        L4a:
            ib.w r0 = ib.w.f6606w
            r0.U(r6)
            return
        L50:
            nb.n r2 = new nb.n
            r4 = 8
            r2.<init>(r4, r3)
            r3 = r1
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r2.a(r3)
            r2.a(r6)
        L60:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L74
        L66:
            java.lang.Thread r6 = r5.R()
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            if (r0 == r6) goto L73
            java.util.concurrent.locks.LockSupport.unpark(r6)
        L73:
            return
        L74:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L60
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: ib.e0.U(java.lang.Runnable):void");
    }

    public final long V() {
        ma.h hVar = this.f6558s;
        if (((hVar == null || hVar.isEmpty()) ? Long.MAX_VALUE : 0L) != 0) {
            Object obj = f6548t.get(this);
            if (obj != null) {
                if (obj instanceof nb.n) {
                    long j10 = nb.n.f9335f.get((nb.n) obj);
                    if (((int) (1073741823 & j10)) != ((int) ((j10 & 1152921503533105152L) >> 30))) {
                        return 0L;
                    }
                } else if (obj == v.f6596b) {
                    return Long.MAX_VALUE;
                }
            }
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final boolean W() {
        ma.h hVar = this.f6558s;
        if (hVar != null ? hVar.isEmpty() : true) {
            Object obj = f6548t.get(this);
            if (obj != null) {
                if (obj instanceof nb.n) {
                    long j10 = nb.n.f9335f.get((nb.n) obj);
                    return ((int) (1073741823 & j10)) == ((int) ((j10 & 1152921503533105152L) >> 30));
                }
                if (obj == v.f6596b) {
                }
            }
            return true;
        }
        return false;
    }

    public final long X() {
        Runnable runnable;
        if (T()) {
            return 0L;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6548t;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            runnable = null;
            if (obj == null) {
                break;
            }
            if (!(obj instanceof nb.n)) {
                if (obj != v.f6596b) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    runnable = (Runnable) obj;
                    break loop0;
                }
                break;
            }
            nb.n nVar = (nb.n) obj;
            Object d6 = nVar.d();
            if (d6 != nb.n.g) {
                runnable = (Runnable) d6;
                break;
            }
            nb.n c10 = nVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c10) && atomicReferenceFieldUpdater.get(this) == obj) {
            }
        }
        if (runnable == null) {
            return V();
        }
        runnable.run();
        return 0L;
    }

    @Override // ib.f0
    public void shutdown() {
        f1.f6559a.set(null);
        f6550v.set(this, 1);
        androidx.emoji2.text.s sVar = v.f6596b;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6548t;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null) {
                if (!(obj instanceof nb.n)) {
                    if (obj != sVar) {
                        nb.n nVar = new nb.n(8, true);
                        nVar.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((nb.n) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, sVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (X() <= 0) {
        }
        System.nanoTime();
    }
}
