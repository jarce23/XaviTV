package kb;

import ib.q0;
import ib.w0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends ib.a implements s, i {

    /* renamed from: r, reason: collision with root package name */
    public final e f7924r;

    public r(pa.i iVar, e eVar) {
        super(iVar, true);
        this.f7924r = eVar;
    }

    @Override // ib.a
    public final void N(Throwable th, boolean z10) {
        if (this.f7924r.j(th, false) || z10) {
            return;
        }
        ib.v.d(this.f6540q, th);
    }

    @Override // ib.a
    public final void O(Object obj) {
        x4.f.i(this.f7924r);
    }

    public final void Q(q qVar) {
        e eVar = this.f7924r;
        eVar.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e.f7889x;
        while (!atomicReferenceFieldUpdater.compareAndSet(eVar, null, qVar)) {
            if (atomicReferenceFieldUpdater.get(eVar) != null) {
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(eVar);
                    androidx.emoji2.text.s sVar = g.f7907q;
                    if (obj != sVar) {
                        if (obj == g.f7908r) {
                            throw new IllegalStateException("Another handler was already registered and successfully invoked");
                        }
                        throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                    }
                    androidx.emoji2.text.s sVar2 = g.f7908r;
                    while (!atomicReferenceFieldUpdater.compareAndSet(eVar, sVar, sVar2)) {
                        if (atomicReferenceFieldUpdater.get(eVar) != sVar) {
                            break;
                        }
                    }
                    qVar.invoke(eVar.o());
                    return;
                }
            }
        }
    }

    @Override // kb.v
    public final Object b(ma.s sVar, mb.c cVar) {
        return this.f7924r.b(sVar, cVar);
    }

    @Override // ib.y0, ib.p0
    public final void c(CancellationException cancellationException) {
        Object y8 = y();
        if (y8 instanceof ib.l) {
            return;
        }
        if ((y8 instanceof w0) && ((w0) y8).d()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new q0(o(), null, this);
        }
        l(cancellationException);
    }

    @Override // kb.u
    public final Object d(mb.f fVar) {
        e eVar = this.f7924r;
        eVar.getClass();
        Object y8 = e.y(eVar, fVar);
        qa.a aVar = qa.a.f10374o;
        return y8;
    }

    @Override // kb.u
    public final Object f() {
        return this.f7924r.f();
    }

    @Override // kb.v
    public final Object g(Object obj) {
        return this.f7924r.g(obj);
    }

    @Override // ib.y0
    public final void l(CancellationException cancellationException) {
        this.f7924r.j(cancellationException, true);
        k(cancellationException);
    }
}
