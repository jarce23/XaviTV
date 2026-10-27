package pb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10147w = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl$volatile");
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;

    /* renamed from: o, reason: collision with root package name */
    public final m f10148o;

    /* renamed from: p, reason: collision with root package name */
    public final za.m f10149p;

    /* renamed from: q, reason: collision with root package name */
    public b f10150q;

    /* renamed from: r, reason: collision with root package name */
    public long f10151r;

    /* renamed from: s, reason: collision with root package name */
    public long f10152s;

    /* renamed from: t, reason: collision with root package name */
    public int f10153t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10154u;

    /* renamed from: v, reason: collision with root package name */
    public final /* synthetic */ c f10155v;
    private volatile /* synthetic */ int workerCtl$volatile;

    public a(c cVar, int i10) {
        this.f10155v = cVar;
        setDaemon(true);
        setContextClassLoader(c.class.getClassLoader());
        this.f10148o = new m();
        this.f10149p = new za.m();
        this.f10150q = b.f10159r;
        this.nextParkedWorker = c.f10165y;
        int nanoTime = (int) System.nanoTime();
        this.f10153t = nanoTime == 0 ? 42 : nanoTime;
        f(i10);
    }

    public final i a(boolean z10) {
        i e7;
        i e8;
        long j10;
        b bVar = this.f10150q;
        b bVar2 = b.f10156o;
        c cVar = this.f10155v;
        i iVar = null;
        m mVar = this.f10148o;
        if (bVar != bVar2) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = c.f10163w;
            do {
                j10 = atomicLongFieldUpdater.get(cVar);
                if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                    mVar.getClass();
                    loop1: while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m.f10189b;
                        i iVar2 = (i) atomicReferenceFieldUpdater.get(mVar);
                        if (iVar2 != null && iVar2.f10179p.f1022o == 1) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(mVar, iVar2, null)) {
                                if (atomicReferenceFieldUpdater.get(mVar) != iVar2) {
                                    break;
                                }
                            }
                            iVar = iVar2;
                            break loop1;
                        }
                    }
                    int i10 = m.f10191d.get(mVar);
                    int i11 = m.f10190c.get(mVar);
                    while (true) {
                        if (i10 == i11 || m.f10192e.get(mVar) == 0) {
                            break;
                        }
                        i11--;
                        i c10 = mVar.c(i11, true);
                        if (c10 != null) {
                            iVar = c10;
                            break;
                        }
                    }
                    if (iVar != null) {
                        return iVar;
                    }
                    i iVar3 = (i) cVar.f10171t.d();
                    return iVar3 == null ? i(1) : iVar3;
                }
            } while (!c.f10163w.compareAndSet(cVar, j10, j10 - 4398046511104L));
            this.f10150q = b.f10156o;
        }
        if (z10) {
            boolean z11 = d(cVar.f10166o * 2) == 0;
            if (z11 && (e8 = e()) != null) {
                return e8;
            }
            mVar.getClass();
            i iVar4 = (i) m.f10189b.getAndSet(mVar, null);
            if (iVar4 == null) {
                iVar4 = mVar.b();
            }
            if (iVar4 != null) {
                return iVar4;
            }
            if (!z11 && (e7 = e()) != null) {
                return e7;
            }
        } else {
            i e10 = e();
            if (e10 != null) {
                return e10;
            }
        }
        return i(3);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i10) {
        int i11 = this.f10153t;
        int i12 = i11 ^ (i11 << 13);
        int i13 = i12 ^ (i12 >> 17);
        int i14 = i13 ^ (i13 << 5);
        this.f10153t = i14;
        int i15 = i10 - 1;
        return (i15 & i10) == 0 ? i14 & i15 : (i14 & Integer.MAX_VALUE) % i10;
    }

    public final i e() {
        int d6 = d(2);
        c cVar = this.f10155v;
        if (d6 == 0) {
            i iVar = (i) cVar.f10170s.d();
            return iVar != null ? iVar : (i) cVar.f10171t.d();
        }
        i iVar2 = (i) cVar.f10171t.d();
        return iVar2 != null ? iVar2 : (i) cVar.f10170s.d();
    }

    public final void f(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f10155v.f10169r);
        sb2.append("-worker-");
        sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
        setName(sb2.toString());
        this.indexInArray = i10;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(b bVar) {
        b bVar2 = this.f10150q;
        boolean z10 = bVar2 == b.f10156o;
        if (z10) {
            c.f10163w.addAndGet(this.f10155v, 4398046511104L);
        }
        if (bVar2 != bVar) {
            this.f10150q = bVar;
        }
        return z10;
    }

    public final i i(int i10) {
        long j10;
        i iVar;
        long j11;
        long j12;
        i iVar2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.f10163w;
        c cVar = this.f10155v;
        int i11 = (int) (atomicLongFieldUpdater.get(cVar) & 2097151);
        i iVar3 = null;
        if (i11 < 2) {
            return null;
        }
        int d6 = d(i11);
        int i12 = 0;
        long j13 = Long.MAX_VALUE;
        while (i12 < i11) {
            d6++;
            if (d6 > i11) {
                d6 = 1;
            }
            a aVar = (a) cVar.f10172u.b(d6);
            if (aVar != null && aVar != this) {
                m mVar = aVar.f10148o;
                if (i10 == 3) {
                    iVar = mVar.b();
                    j10 = 0;
                } else {
                    mVar.getClass();
                    int i13 = m.f10191d.get(mVar);
                    int i14 = m.f10190c.get(mVar);
                    boolean z10 = i10 == 1;
                    while (true) {
                        if (i13 == i14) {
                            j10 = 0;
                            break;
                        }
                        j10 = 0;
                        if (!z10 || m.f10192e.get(mVar) != 0) {
                            int i15 = i13 + 1;
                            iVar = mVar.c(i13, z10);
                            if (iVar != null) {
                                break;
                            }
                            i13 = i15;
                        } else {
                            break;
                        }
                    }
                    iVar = iVar3;
                }
                za.m mVar2 = this.f10149p;
                if (iVar != null) {
                    mVar2.f14177o = iVar;
                    iVar2 = iVar3;
                    j12 = -1;
                    j11 = -1;
                } else {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m.f10189b;
                        i iVar4 = (i) atomicReferenceFieldUpdater.get(mVar);
                        if (iVar4 == null) {
                            j11 = -1;
                            break;
                        }
                        j11 = -1;
                        if (((iVar4.f10179p.f1022o == 1 ? 1 : 2) & i10) == 0) {
                            break;
                        }
                        k.f10186f.getClass();
                        m mVar3 = mVar;
                        long nanoTime = System.nanoTime() - iVar4.f10178o;
                        long j14 = k.f10182b;
                        if (nanoTime < j14) {
                            j12 = j14 - nanoTime;
                            iVar2 = null;
                            break;
                        }
                        do {
                            iVar2 = null;
                            if (atomicReferenceFieldUpdater.compareAndSet(mVar3, iVar4, null)) {
                                mVar2.f14177o = iVar4;
                                j12 = -1;
                                break;
                            }
                        } while (atomicReferenceFieldUpdater.get(mVar3) == iVar4);
                        mVar = mVar3;
                        iVar3 = null;
                    }
                    j12 = -2;
                    iVar2 = iVar3;
                }
                if (j12 == j11) {
                    i iVar5 = (i) mVar2.f14177o;
                    mVar2.f14177o = iVar2;
                    return iVar5;
                }
                if (j12 > j10) {
                    j13 = Math.min(j13, j12);
                }
            }
            i12++;
            iVar3 = null;
        }
        if (j13 == Long.MAX_VALUE) {
            j13 = 0;
        }
        this.f10152s = j13;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.a.run():void");
    }
}
