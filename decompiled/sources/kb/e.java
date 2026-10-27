package kb;

import ib.i1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class e implements i {

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f7881p = AtomicLongFieldUpdater.newUpdater(e.class, "sendersAndCloseStatus$volatile");

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f7882q = AtomicLongFieldUpdater.newUpdater(e.class, "receivers$volatile");

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f7883r = AtomicLongFieldUpdater.newUpdater(e.class, "bufferEnd$volatile");

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f7884s = AtomicLongFieldUpdater.newUpdater(e.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7885t = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "sendSegment$volatile");

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7886u = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "receiveSegment$volatile");

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7887v = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7888w = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_closeCause$volatile");

    /* renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7889x = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;

    /* renamed from: o, reason: collision with root package name */
    public final int f7890o;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public e(int i10) {
        this.f7890o = i10;
        if (i10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.o("Invalid channel capacity: ", i10, ", should be >=0").toString());
        }
        m mVar = g.f7892a;
        this.bufferEnd$volatile = i10 != 0 ? i10 != Integer.MAX_VALUE ? i10 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = f7883r.get(this);
        m mVar2 = new m(0L, null, this, 3);
        this.sendSegment$volatile = mVar2;
        this.receiveSegment$volatile = mVar2;
        if (v()) {
            mVar2 = g.f7892a;
            za.h.c("null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>", mVar2);
        }
        this.bufferEndSegment$volatile = mVar2;
        this._closeCause$volatile = g.f7909s;
    }

    public static boolean C(Object obj) {
        if (obj instanceof ib.e) {
            return g.a((ib.e) obj, la.i.f8335a, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public static final m a(e eVar, long j10, m mVar) {
        Object a10;
        e eVar2;
        m mVar2 = g.f7892a;
        f fVar = f.f7891w;
        loop0: while (true) {
            a10 = nb.a.a(j10, mVar);
            if (!nb.a.d(a10)) {
                nb.u b2 = nb.a.b(a10);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7885t;
                    nb.u uVar = (nb.u) atomicReferenceFieldUpdater.get(eVar);
                    if (uVar.f9344c >= b2.f9344c) {
                        break loop0;
                    }
                    if (!b2.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(eVar, uVar, b2)) {
                        if (atomicReferenceFieldUpdater.get(eVar) != uVar) {
                            if (b2.e()) {
                                b2.d();
                            }
                        }
                    }
                    if (uVar.e()) {
                        uVar.d();
                    }
                }
            } else {
                break;
            }
        }
        boolean d6 = nb.a.d(a10);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7882q;
        if (d6) {
            eVar.t();
            if (mVar.f9344c * g.f7893b < atomicLongFieldUpdater.get(eVar)) {
                mVar.a();
                return null;
            }
        } else {
            m mVar3 = (m) nb.a.b(a10);
            long j11 = mVar3.f9344c;
            if (j11 <= j10) {
                return mVar3;
            }
            long j12 = g.f7893b * j11;
            while (true) {
                long j13 = f7881p.get(eVar);
                long j14 = 1152921504606846975L & j13;
                if (j14 >= j12) {
                    eVar2 = eVar;
                    break;
                }
                eVar2 = eVar;
                if (f7881p.compareAndSet(eVar2, j13, (((int) (j13 >> 60)) << 60) + j14)) {
                    break;
                }
                eVar = eVar2;
            }
            if (j11 * g.f7893b < atomicLongFieldUpdater.get(eVar2)) {
                mVar3.a();
            }
        }
        return null;
    }

    public static final void e(e eVar, ma.s sVar, ib.f fVar) {
        fVar.resumeWith(com.google.android.gms.internal.cast.n.d(eVar.p()));
    }

    public static final int h(e eVar, m mVar, int i10, Object obj, long j10, Object obj2, boolean z10) {
        mVar.m(i10, obj);
        if (z10) {
            return eVar.E(mVar, i10, obj, j10, obj2, z10);
        }
        Object k10 = mVar.k(i10);
        if (k10 == null) {
            if (eVar.i(j10)) {
                if (mVar.j(null, i10, g.f7895d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (mVar.j(null, i10, obj2)) {
                    return 2;
                }
            }
        } else if (k10 instanceof i1) {
            mVar.m(i10, null);
            if (eVar.B(k10, obj)) {
                mVar.n(i10, g.f7899i);
                return 0;
            }
            androidx.emoji2.text.s sVar = g.f7901k;
            if (mVar.f7917f.getAndSet((i10 * 2) + 1, sVar) == sVar) {
                return 5;
            }
            mVar.l(i10, true);
            return 5;
        }
        return eVar.E(mVar, i10, obj, j10, obj2, z10);
    }

    public static void r(e eVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7884s;
        if ((atomicLongFieldUpdater.addAndGet(eVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(eVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object y(kb.e r13, ra.c r14) {
        /*
            boolean r0 = r14 instanceof kb.c
            if (r0 == 0) goto L14
            r0 = r14
            kb.c r0 = (kb.c) r0
            int r1 = r0.f7877q
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f7877q = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            kb.c r0 = new kb.c
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f7875o
            qa.a r0 = qa.a.f10374o
            int r1 = r6.f7877q
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            com.google.android.gms.internal.cast.n.t(r14)
            kb.l r14 = (kb.l) r14
            java.lang.Object r13 = r14.f7915a
            return r13
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L35:
            com.google.android.gms.internal.cast.n.t(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = kb.e.f7886u
            java.lang.Object r14 = r14.get(r13)
            kb.m r14 = (kb.m) r14
        L40:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kb.e.f7881p
            long r3 = r1.get(r13)
            boolean r1 = r13.s(r3, r2)
            if (r1 == 0) goto L56
            java.lang.Throwable r13 = r13.o()
            kb.j r14 = new kb.j
            r14.<init>(r13)
            return r14
        L56:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kb.e.f7882q
            long r4 = r1.getAndIncrement(r13)
            int r1 = kb.g.f7893b
            long r7 = (long) r1
            long r9 = r4 / r7
            long r7 = r4 % r7
            int r3 = (int) r7
            long r7 = r14.f9344c
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L73
            kb.m r1 = r13.n(r9, r14)
            if (r1 != 0) goto L71
            goto L40
        L71:
            r8 = r1
            goto L74
        L73:
            r8 = r14
        L74:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.D(r8, r9, r10, r12)
            r1 = r7
            androidx.emoji2.text.s r14 = kb.g.f7903m
            if (r13 == r14) goto La6
            androidx.emoji2.text.s r14 = kb.g.f7905o
            if (r13 != r14) goto L93
            long r13 = r1.q()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L90
            r8.a()
        L90:
            r13 = r1
            r14 = r8
            goto L40
        L93:
            androidx.emoji2.text.s r14 = kb.g.f7904n
            if (r13 != r14) goto La2
            r6.f7877q = r2
            r2 = r8
            java.lang.Object r13 = r1.z(r2, r3, r4, r6)
            if (r13 != r0) goto La1
            return r0
        La1:
            return r13
        La2:
            r8.a()
            return r13
        La6:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.e.y(kb.e, ra.c):java.lang.Object");
    }

    public final void A(i1 i1Var, boolean z10) {
        Throwable p10;
        if (i1Var instanceof ib.e) {
            pa.d dVar = (pa.d) i1Var;
            if (z10) {
                p10 = o();
                if (p10 == null) {
                    p10 = new n("Channel was closed");
                }
            } else {
                p10 = p();
            }
            dVar.resumeWith(com.google.android.gms.internal.cast.n.d(p10));
            return;
        }
        if (i1Var instanceof t) {
            ((t) i1Var).f7925o.resumeWith(new l(new j(o())));
            return;
        }
        if (!(i1Var instanceof b)) {
            throw new IllegalStateException(("Unexpected waiter: " + i1Var).toString());
        }
        b bVar = (b) i1Var;
        ib.f fVar = bVar.f7873p;
        za.h.b(fVar);
        bVar.f7873p = null;
        bVar.f7872o = g.f7902l;
        Throwable o2 = bVar.f7874q.o();
        if (o2 == null) {
            fVar.resumeWith(Boolean.FALSE);
        } else {
            fVar.resumeWith(com.google.android.gms.internal.cast.n.d(o2));
        }
    }

    public final boolean B(Object obj, Object obj2) {
        if (obj instanceof t) {
            return g.a(((t) obj).f7925o, new l(obj2), null);
        }
        if (!(obj instanceof b)) {
            if (obj instanceof ib.e) {
                return g.a((ib.e) obj, obj2, null);
            }
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        b bVar = (b) obj;
        ib.f fVar = bVar.f7873p;
        za.h.b(fVar);
        bVar.f7873p = null;
        bVar.f7872o = obj2;
        return g.a(fVar, Boolean.TRUE, null);
    }

    public final Object D(m mVar, int i10, long j10, Object obj) {
        Object k10 = mVar.k(i10);
        AtomicReferenceArray atomicReferenceArray = mVar.f7917f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7881p;
        if (k10 == null) {
            if (j10 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return g.f7904n;
                }
                if (mVar.j(k10, i10, obj)) {
                    m();
                    return g.f7903m;
                }
            }
        } else if (k10 == g.f7895d && mVar.j(k10, i10, g.f7899i)) {
            m();
            Object obj2 = atomicReferenceArray.get(i10 * 2);
            mVar.m(i10, null);
            return obj2;
        }
        while (true) {
            Object k11 = mVar.k(i10);
            if (k11 == null || k11 == g.f7896e) {
                if (j10 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (mVar.j(k11, i10, g.f7898h)) {
                        m();
                        return g.f7905o;
                    }
                } else {
                    if (obj == null) {
                        return g.f7904n;
                    }
                    if (mVar.j(k11, i10, obj)) {
                        m();
                        return g.f7903m;
                    }
                }
            } else if (k11 != g.f7895d) {
                androidx.emoji2.text.s sVar = g.f7900j;
                if (k11 == sVar) {
                    return g.f7905o;
                }
                if (k11 == g.f7898h) {
                    return g.f7905o;
                }
                if (k11 == g.f7902l) {
                    m();
                    return g.f7905o;
                }
                if (k11 != g.g && mVar.j(k11, i10, g.f7897f)) {
                    boolean z10 = k11 instanceof w;
                    if (z10) {
                        k11 = ((w) k11).f7926a;
                    }
                    if (C(k11)) {
                        mVar.n(i10, g.f7899i);
                        m();
                        Object obj3 = atomicReferenceArray.get(i10 * 2);
                        mVar.m(i10, null);
                        return obj3;
                    }
                    mVar.n(i10, sVar);
                    mVar.h();
                    if (z10) {
                        m();
                    }
                    return g.f7905o;
                }
            } else if (mVar.j(k11, i10, g.f7899i)) {
                m();
                Object obj4 = atomicReferenceArray.get(i10 * 2);
                mVar.m(i10, null);
                return obj4;
            }
        }
    }

    public final int E(m mVar, int i10, Object obj, long j10, Object obj2, boolean z10) {
        while (true) {
            Object k10 = mVar.k(i10);
            if (k10 == null) {
                if (!i(j10) || z10) {
                    if (z10) {
                        if (mVar.j(null, i10, g.f7900j)) {
                            mVar.h();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (mVar.j(null, i10, obj2)) {
                            return 2;
                        }
                    }
                } else if (mVar.j(null, i10, g.f7895d)) {
                    break;
                }
            } else {
                if (k10 != g.f7896e) {
                    androidx.emoji2.text.s sVar = g.f7901k;
                    if (k10 == sVar) {
                        mVar.m(i10, null);
                        return 5;
                    }
                    if (k10 == g.f7898h) {
                        mVar.m(i10, null);
                        return 5;
                    }
                    if (k10 == g.f7902l) {
                        mVar.m(i10, null);
                        t();
                        return 4;
                    }
                    mVar.m(i10, null);
                    if (k10 instanceof w) {
                        k10 = ((w) k10).f7926a;
                    }
                    if (B(k10, obj)) {
                        mVar.n(i10, g.f7899i);
                        return 0;
                    }
                    if (mVar.f7917f.getAndSet((i10 * 2) + 1, sVar) != sVar) {
                        mVar.l(i10, true);
                    }
                    return 5;
                }
                if (mVar.j(k10, i10, g.f7895d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void F(long j10) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        e eVar = this;
        if (eVar.v()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = f7883r;
            if (atomicLongFieldUpdater.get(eVar) > j10) {
                break;
            } else {
                eVar = this;
            }
        }
        int i10 = g.f7894c;
        int i11 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f7884s;
            if (i11 < i10) {
                long j11 = atomicLongFieldUpdater.get(eVar);
                if (j11 == (4611686018427387903L & atomicLongFieldUpdater2.get(eVar)) && j11 == atomicLongFieldUpdater.get(eVar)) {
                    return;
                } else {
                    i11++;
                }
            } else {
                while (true) {
                    long j12 = atomicLongFieldUpdater2.get(eVar);
                    if (atomicLongFieldUpdater2.compareAndSet(eVar, j12, (j12 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        eVar = this;
                    }
                }
                while (true) {
                    long j13 = atomicLongFieldUpdater.get(eVar);
                    long j14 = atomicLongFieldUpdater2.get(eVar);
                    long j15 = j14 & 4611686018427387903L;
                    boolean z10 = (j14 & 4611686018427387904L) != 0;
                    if (j13 == j15 && j13 == atomicLongFieldUpdater.get(eVar)) {
                        break;
                    }
                    if (z10) {
                        eVar = this;
                    } else {
                        eVar = this;
                        atomicLongFieldUpdater2.compareAndSet(eVar, j14, 4611686018427387904L + j15);
                    }
                }
                while (true) {
                    long j16 = atomicLongFieldUpdater2.get(eVar);
                    if (atomicLongFieldUpdater2.compareAndSet(eVar, j16, j16 & 4611686018427387903L)) {
                        return;
                    } else {
                        eVar = this;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0189, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00c6, code lost:
    
        e(r1, r4, r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0173 A[RETURN] */
    @Override // kb.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ma.s r24, mb.c r25) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.e.b(ma.s, mb.c):java.lang.Object");
    }

    @Override // kb.u
    public final void c(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        j(cancellationException, true);
    }

    @Override // kb.u
    public final Object d(mb.f fVar) {
        return y(this, fVar);
    }

    @Override // kb.u
    public final Object f() {
        m mVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7882q;
        long j10 = atomicLongFieldUpdater.get(this);
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f7881p;
        long j11 = atomicLongFieldUpdater2.get(this);
        if (s(j11, true)) {
            return new j(o());
        }
        long j12 = j11 & 1152921504606846975L;
        k kVar = l.f7914b;
        if (j10 >= j12) {
            return kVar;
        }
        Object obj = g.f7901k;
        m mVar2 = (m) f7886u.get(this);
        while (!s(atomicLongFieldUpdater2.get(this), true)) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j13 = g.f7893b;
            long j14 = andIncrement / j13;
            int i10 = (int) (andIncrement % j13);
            if (mVar2.f9344c != j14) {
                m n10 = n(j14, mVar2);
                if (n10 == null) {
                    continue;
                } else {
                    mVar = n10;
                }
            } else {
                mVar = mVar2;
            }
            Object D = D(mVar, i10, andIncrement, obj);
            m mVar3 = mVar;
            if (D == g.f7903m) {
                i1 i1Var = obj instanceof i1 ? (i1) obj : null;
                if (i1Var != null) {
                    i1Var.a(mVar3, i10);
                }
                F(andIncrement);
                mVar3.h();
                return kVar;
            }
            if (D != g.f7905o) {
                if (D == g.f7904n) {
                    throw new IllegalStateException("unexpected");
                }
                mVar3.a();
                return D;
            }
            if (andIncrement < q()) {
                mVar3.a();
            }
            mVar2 = mVar3;
        }
        return new j(o());
    }

    @Override // kb.v
    public Object g(Object obj) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f7881p;
        boolean z10 = false;
        long j10 = 1152921504606846975L;
        boolean z11 = s(atomicLongFieldUpdater.get(this), false) ? false : !i(r1 & 1152921504606846975L);
        k kVar = l.f7914b;
        if (z11) {
            return kVar;
        }
        androidx.emoji2.text.r rVar = g.f7900j;
        m mVar = (m) f7885t.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j11 = andIncrement & j10;
            boolean s10 = s(andIncrement, z10);
            int i10 = g.f7893b;
            long j12 = i10;
            long j13 = j11 / j12;
            int i11 = (int) (j11 % j12);
            if (mVar.f9344c != j13) {
                m a10 = a(this, j13, mVar);
                if (a10 != null) {
                    mVar = a10;
                } else {
                    if (s10) {
                        return new j(p());
                    }
                    z10 = false;
                    j10 = 1152921504606846975L;
                }
            }
            int h10 = h(this, mVar, i11, obj, j11, rVar, s10);
            la.i iVar = la.i.f8335a;
            if (h10 == 0) {
                mVar.a();
                return iVar;
            }
            if (h10 == 1) {
                return iVar;
            }
            if (h10 == 2) {
                if (s10) {
                    mVar.h();
                    return new j(p());
                }
                i1 i1Var = rVar instanceof i1 ? (i1) rVar : null;
                if (i1Var != null) {
                    i1Var.a(mVar, i11 + i10);
                }
                mVar.h();
                return kVar;
            }
            if (h10 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (h10 == 4) {
                if (j11 < f7882q.get(this)) {
                    mVar.a();
                }
                return new j(p());
            }
            if (h10 == 5) {
                mVar.a();
            }
            z10 = false;
            j10 = 1152921504606846975L;
        }
    }

    public final boolean i(long j10) {
        return j10 < f7883r.get(this) || j10 < f7882q.get(this) + ((long) this.f7890o);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c A[LOOP:2: B:17:0x003c->B:39:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[LOOP:3: B:22:0x006e->B:30:?, LOOP_LABEL: LOOP:3: B:22:0x006e->B:30:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004c A[LOOP:5: B:40:0x004c->B:48:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j(java.lang.Throwable r13, boolean r14) {
        /*
            r12 = this;
            r0 = 60
            r1 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = kb.e.f7881p
            r9 = 1
            if (r14 == 0) goto L24
        Lc:
            long r5 = r3.get(r12)
            long r7 = r5 >> r0
            int r4 = (int) r7
            if (r4 != 0) goto L24
            long r7 = r5 & r1
            kb.m r4 = kb.g.f7892a
            long r10 = (long) r9
            long r10 = r10 << r0
            long r7 = r7 + r10
            r4 = r12
            boolean r5 = r3.compareAndSet(r4, r5, r7)
            if (r5 == 0) goto Lc
            goto L25
        L24:
            r4 = r12
        L25:
            androidx.emoji2.text.s r5 = kb.g.f7909s
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = kb.e.f7888w
            boolean r7 = r6.compareAndSet(r12, r5, r13)
            if (r7 == 0) goto L31
            r10 = r9
            goto L39
        L31:
            java.lang.Object r6 = r6.get(r12)
            if (r6 == r5) goto L27
            r13 = 0
            r10 = r13
        L39:
            r11 = 3
            if (r14 == 0) goto L4c
        L3c:
            long r5 = r3.get(r12)
            long r13 = r5 & r1
            long r7 = (long) r11
            long r7 = r7 << r0
            long r7 = r7 + r13
            boolean r13 = r3.compareAndSet(r4, r5, r7)
            if (r13 == 0) goto L3c
            goto L69
        L4c:
            long r5 = r3.get(r12)
            long r13 = r5 >> r0
            int r13 = (int) r13
            if (r13 == 0) goto L5e
            if (r13 == r9) goto L58
            goto L69
        L58:
            long r13 = r5 & r1
            long r7 = (long) r11
        L5b:
            long r7 = r7 << r0
            long r7 = r7 + r13
            goto L63
        L5e:
            long r13 = r5 & r1
            r7 = 2
            long r7 = (long) r7
            goto L5b
        L63:
            boolean r13 = r3.compareAndSet(r4, r5, r7)
            if (r13 == 0) goto L4c
        L69:
            r12.t()
            if (r10 == 0) goto L98
        L6e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r13 = kb.e.f7889x
            java.lang.Object r14 = r13.get(r12)
            if (r14 != 0) goto L79
            androidx.emoji2.text.s r0 = kb.g.f7907q
            goto L7b
        L79:
            androidx.emoji2.text.s r0 = kb.g.f7908r
        L7b:
            boolean r1 = r13.compareAndSet(r12, r14, r0)
            if (r1 == 0) goto L91
            if (r14 != 0) goto L84
            goto L98
        L84:
            za.p.b(r9, r14)
            ya.l r14 = (ya.l) r14
            java.lang.Throwable r13 = r12.o()
            r14.invoke(r13)
            return r10
        L91:
            java.lang.Object r1 = r13.get(r12)
            if (r1 == r14) goto L7b
            goto L6e
        L98:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.e.j(java.lang.Throwable, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x008d, code lost:
    
        r1 = (kb.m) ((nb.d) nb.d.f9314b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kb.m k(long r13) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.e.k(long):kb.m");
    }

    public final void l(long j10) {
        m mVar = (m) f7886u.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f7882q;
            long j11 = atomicLongFieldUpdater.get(this);
            if (j10 < Math.max(this.f7890o + j11, f7883r.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j11, 1 + j11)) {
                long j12 = g.f7893b;
                long j13 = j11 / j12;
                int i10 = (int) (j11 % j12);
                if (mVar.f9344c != j13) {
                    m n10 = n(j13, mVar);
                    if (n10 != null) {
                        mVar = n10;
                    }
                }
                m mVar2 = mVar;
                if (D(mVar2, i10, j11, null) != g.f7905o) {
                    mVar2.a();
                } else if (j11 < q()) {
                    mVar2.a();
                }
                mVar = mVar2;
            }
        }
    }

    public final void m() {
        Object a10;
        if (v()) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7887v;
        m mVar = (m) atomicReferenceFieldUpdater.get(this);
        loop0: while (true) {
            long andIncrement = f7883r.getAndIncrement(this);
            long j10 = andIncrement / g.f7893b;
            if (q() <= andIncrement) {
                if (mVar.f9344c < j10 && mVar.b() != null) {
                    w(j10, mVar);
                }
                r(this);
                return;
            }
            if (mVar.f9344c != j10) {
                f fVar = f.f7891w;
                while (true) {
                    a10 = nb.a.a(j10, mVar);
                    if (!nb.a.d(a10)) {
                        nb.u b2 = nb.a.b(a10);
                        while (true) {
                            nb.u uVar = (nb.u) atomicReferenceFieldUpdater.get(this);
                            if (uVar.f9344c >= b2.f9344c) {
                                break;
                            }
                            if (!b2.i()) {
                                break;
                            }
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, uVar, b2)) {
                                if (atomicReferenceFieldUpdater.get(this) != uVar) {
                                    if (b2.e()) {
                                        b2.d();
                                    }
                                }
                            }
                            if (uVar.e()) {
                                uVar.d();
                            }
                        }
                    } else {
                        break;
                    }
                }
                m mVar2 = null;
                if (nb.a.d(a10)) {
                    t();
                    w(j10, mVar);
                    r(this);
                } else {
                    m mVar3 = (m) nb.a.b(a10);
                    long j11 = mVar3.f9344c;
                    if (j11 > j10) {
                        long j12 = j11 * g.f7893b;
                        if (f7883r.compareAndSet(this, 1 + andIncrement, j12)) {
                            AtomicLongFieldUpdater atomicLongFieldUpdater = f7884s;
                            if ((atomicLongFieldUpdater.addAndGet(this, j12 - andIncrement) & 4611686018427387904L) != 0) {
                                while ((atomicLongFieldUpdater.get(this) & 4611686018427387904L) != 0) {
                                }
                            }
                        } else {
                            r(this);
                        }
                    } else {
                        mVar2 = mVar3;
                    }
                }
                if (mVar2 == null) {
                    continue;
                } else {
                    mVar = mVar2;
                }
            }
            int i10 = (int) (andIncrement % g.f7893b);
            Object k10 = mVar.k(i10);
            boolean z10 = k10 instanceof i1;
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f7882q;
            if (!z10 || andIncrement < atomicLongFieldUpdater2.get(this) || !mVar.j(k10, i10, g.g)) {
                while (true) {
                    Object k11 = mVar.k(i10);
                    if (!(k11 instanceof i1)) {
                        if (k11 != g.f7900j) {
                            if (k11 != null) {
                                if (k11 == g.f7895d || k11 == g.f7898h || k11 == g.f7899i || k11 == g.f7901k || k11 == g.f7902l) {
                                    break loop0;
                                }
                                if (k11 != g.f7897f) {
                                    throw new IllegalStateException(("Unexpected cell state: " + k11).toString());
                                }
                            } else if (mVar.j(k11, i10, g.f7896e)) {
                                break loop0;
                            }
                        } else {
                            break;
                        }
                    } else if (andIncrement < atomicLongFieldUpdater2.get(this)) {
                        if (mVar.j(k11, i10, new w((i1) k11))) {
                            break loop0;
                        }
                    } else if (mVar.j(k11, i10, g.g)) {
                        if (C(k11)) {
                            mVar.n(i10, g.f7895d);
                            break;
                        } else {
                            mVar.n(i10, g.f7900j);
                            mVar.h();
                        }
                    }
                }
            } else if (C(k10)) {
                mVar.n(i10, g.f7895d);
                break;
            } else {
                mVar.n(i10, g.f7900j);
                mVar.h();
                r(this);
            }
        }
        r(this);
    }

    public final m n(long j10, m mVar) {
        Object a10;
        long j11;
        m mVar2 = g.f7892a;
        f fVar = f.f7891w;
        loop0: while (true) {
            a10 = nb.a.a(j10, mVar);
            if (!nb.a.d(a10)) {
                nb.u b2 = nb.a.b(a10);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7886u;
                    nb.u uVar = (nb.u) atomicReferenceFieldUpdater.get(this);
                    if (uVar.f9344c >= b2.f9344c) {
                        break loop0;
                    }
                    if (!b2.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, uVar, b2)) {
                        if (atomicReferenceFieldUpdater.get(this) != uVar) {
                            if (b2.e()) {
                                b2.d();
                            }
                        }
                    }
                    if (uVar.e()) {
                        uVar.d();
                    }
                }
            } else {
                break;
            }
        }
        if (nb.a.d(a10)) {
            t();
            if (mVar.f9344c * g.f7893b < q()) {
                mVar.a();
                return null;
            }
        } else {
            m mVar3 = (m) nb.a.b(a10);
            long j12 = mVar3.f9344c;
            if (!v() && j10 <= f7883r.get(this) / g.f7893b) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f7887v;
                    nb.u uVar2 = (nb.u) atomicReferenceFieldUpdater2.get(this);
                    if (uVar2.f9344c >= j12 || !mVar3.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, uVar2, mVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != uVar2) {
                            if (mVar3.e()) {
                                mVar3.d();
                            }
                        }
                    }
                    if (uVar2.e()) {
                        uVar2.d();
                    }
                }
            }
            if (j12 <= j10) {
                return mVar3;
            }
            long j13 = j12 * g.f7893b;
            do {
                j11 = f7882q.get(this);
                if (j11 >= j13) {
                    break;
                }
            } while (!f7882q.compareAndSet(this, j11, j13));
            if (j12 * g.f7893b < q()) {
                mVar3.a();
            }
        }
        return null;
    }

    public final Throwable o() {
        return (Throwable) f7888w.get(this);
    }

    public final Throwable p() {
        Throwable o2 = o();
        return o2 == null ? new i1.q("Channel was closed") : o2;
    }

    public final long q() {
        return f7881p.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x00a2, code lost:
    
        r0 = (kb.m) ((nb.d) nb.d.f9314b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s(long r14, boolean r16) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.e.s(long, boolean):boolean");
    }

    public final boolean t() {
        return s(f7881p.get(this), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b2, code lost:
    
        r16 = r7;
        r3 = (kb.m) r3.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01bb, code lost:
    
        if (r3 != null) goto L91;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.e.toString():java.lang.String");
    }

    public boolean u() {
        return false;
    }

    public final boolean v() {
        long j10 = f7883r.get(this);
        return j10 == 0 || j10 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(long r5, kb.m r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f9344c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            nb.d r0 = r7.b()
            kb.m r0 = (kb.m) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.c()
            if (r5 == 0) goto L22
            nb.d r5 = r7.b()
            kb.m r5 = (kb.m) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kb.e.f7887v
            java.lang.Object r6 = r5.get(r4)
            nb.u r6 = (nb.u) r6
            long r0 = r6.f9344c
            long r2 = r7.f9344c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.i()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r5 = r6.e()
            if (r5 == 0) goto L49
            r6.d()
        L49:
            return
        L4a:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3a
            boolean r5 = r7.e()
            if (r5 == 0) goto L22
            r7.d()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.e.w(long, kb.m):void");
    }

    public final Object x(ma.s sVar, mb.c cVar) {
        ib.f fVar = new ib.f(1, a.a.m(cVar));
        fVar.o();
        fVar.resumeWith(com.google.android.gms.internal.cast.n.d(p()));
        Object n10 = fVar.n();
        return n10 == qa.a.f10374o ? n10 : la.i.f8335a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(kb.m r16, int r17, long r18, ra.c r20) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.e.z(kb.m, int, long, ra.c):java.lang.Object");
    }
}
