package kb;

import ib.i1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements i1 {

    /* renamed from: o, reason: collision with root package name */
    public Object f7872o = g.f7906p;

    /* renamed from: p, reason: collision with root package name */
    public ib.f f7873p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ e f7874q;

    public b(e eVar) {
        this.f7874q = eVar;
    }

    @Override // ib.i1
    public final void a(nb.u uVar, int i10) {
        ib.f fVar = this.f7873p;
        if (fVar != null) {
            fVar.a(uVar, i10);
        }
    }

    public final Object b(lb.h hVar) {
        m mVar;
        Boolean bool;
        m mVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e.f7886u;
        e eVar = this.f7874q;
        m mVar3 = (m) atomicReferenceFieldUpdater.get(eVar);
        while (!eVar.s(e.f7881p.get(eVar), true)) {
            long andIncrement = e.f7882q.getAndIncrement(eVar);
            long j10 = g.f7893b;
            long j11 = andIncrement / j10;
            int i10 = (int) (andIncrement % j10);
            if (mVar3.f9344c != j11) {
                mVar = eVar.n(j11, mVar3);
                if (mVar == null) {
                    continue;
                }
            } else {
                mVar = mVar3;
            }
            Object D = eVar.D(mVar, i10, andIncrement, null);
            androidx.emoji2.text.s sVar = g.f7903m;
            if (D == sVar) {
                throw new IllegalStateException("unreachable");
            }
            androidx.emoji2.text.s sVar2 = g.f7905o;
            if (D != sVar2) {
                if (D != g.f7904n) {
                    mVar.a();
                    this.f7872o = D;
                    return Boolean.TRUE;
                }
                ib.f c10 = ib.v.c(a.a.m(hVar));
                try {
                    this.f7873p = c10;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    Object D2 = eVar.D(mVar, i10, andIncrement, this);
                    if (D2 == sVar) {
                        a(mVar, i10);
                    } else {
                        if (D2 == sVar2) {
                            if (andIncrement < eVar.q()) {
                                mVar.a();
                            }
                            m mVar4 = (m) e.f7886u.get(eVar);
                            while (true) {
                                if (eVar.s(e.f7881p.get(eVar), true)) {
                                    ib.f fVar = this.f7873p;
                                    za.h.b(fVar);
                                    this.f7873p = null;
                                    this.f7872o = g.f7902l;
                                    Throwable o2 = eVar.o();
                                    if (o2 == null) {
                                        fVar.resumeWith(Boolean.FALSE);
                                    } else {
                                        fVar.resumeWith(com.google.android.gms.internal.cast.n.d(o2));
                                    }
                                } else {
                                    long andIncrement2 = e.f7882q.getAndIncrement(eVar);
                                    long j12 = g.f7893b;
                                    long j13 = andIncrement2 / j12;
                                    int i11 = (int) (andIncrement2 % j12);
                                    if (mVar4.f9344c != j13) {
                                        mVar2 = eVar.n(j13, mVar4);
                                        if (mVar2 == null) {
                                        }
                                    } else {
                                        mVar2 = mVar4;
                                    }
                                    Object D3 = eVar.D(mVar2, i11, andIncrement2, this);
                                    if (D3 == g.f7903m) {
                                        a(mVar2, i11);
                                        break;
                                    }
                                    if (D3 == g.f7905o) {
                                        if (andIncrement2 < eVar.q()) {
                                            mVar2.a();
                                        }
                                        mVar4 = mVar2;
                                    } else {
                                        if (D3 == g.f7904n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        mVar2.a();
                                        this.f7872o = D3;
                                        this.f7873p = null;
                                        bool = Boolean.TRUE;
                                    }
                                }
                            }
                        } else {
                            mVar.a();
                            this.f7872o = D2;
                            this.f7873p = null;
                            bool = Boolean.TRUE;
                        }
                        c10.u(bool, c10.f6619q, null);
                    }
                    Object n10 = c10.n();
                    qa.a aVar = qa.a.f10374o;
                    return n10;
                } catch (Throwable th2) {
                    th = th2;
                    c10.t();
                    throw th;
                }
            }
            if (andIncrement < eVar.q()) {
                mVar.a();
            }
            mVar3 = mVar;
        }
        this.f7872o = g.f7902l;
        Throwable o6 = eVar.o();
        if (o6 == null) {
            return Boolean.FALSE;
        }
        int i12 = nb.v.f9345a;
        throw o6;
    }
}
