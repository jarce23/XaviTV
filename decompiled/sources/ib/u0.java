package ib;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class u0 extends nb.k implements m0, b0, j0 {

    /* renamed from: d, reason: collision with root package name */
    public y0 f6594d;

    @Override // ib.j0
    public final boolean a() {
        return true;
    }

    @Override // ib.b0
    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        y0 k10 = k();
        while (true) {
            Object y8 = k10.y();
            if (y8 instanceof u0) {
                if (y8 != this) {
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = y0.f6617o;
                c0 c0Var = v.f6602i;
                while (!atomicReferenceFieldUpdater2.compareAndSet(k10, y8, c0Var)) {
                    if (atomicReferenceFieldUpdater2.get(k10) != y8) {
                        break;
                    }
                }
                return;
            }
            if (!(y8 instanceof j0) || ((j0) y8).e() == null) {
                return;
            }
            while (true) {
                Object h10 = h();
                if (h10 instanceof nb.r) {
                    return;
                }
                if (h10 == this) {
                    return;
                }
                za.h.c("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }", h10);
                nb.k kVar = (nb.k) h10;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = nb.k.f9331c;
                nb.r rVar = (nb.r) atomicReferenceFieldUpdater3.get(kVar);
                if (rVar == null) {
                    rVar = new nb.r(kVar);
                    atomicReferenceFieldUpdater3.set(kVar, rVar);
                }
                do {
                    atomicReferenceFieldUpdater = nb.k.f9329a;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, h10, rVar)) {
                        kVar.f();
                        return;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == h10);
            }
        }
    }

    @Override // ib.j0
    public final z0 e() {
        return null;
    }

    public final y0 k() {
        y0 y0Var = this.f6594d;
        if (y0Var != null) {
            return y0Var;
        }
        za.h.h("job");
        throw null;
    }

    @Override // nb.k
    public final String toString() {
        return getClass().getSimpleName() + '@' + v.b(this) + "[job@" + v.b(k()) + ']';
    }
}
