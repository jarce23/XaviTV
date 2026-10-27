package ib;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends r0 {

    /* renamed from: e, reason: collision with root package name */
    public final f f6562e;

    public h(f fVar) {
        this.f6562e = fVar;
    }

    @Override // ib.m0
    public final void d(Throwable th) {
        CancellationException u10 = k().u();
        f fVar = this.f6562e;
        if (fVar.r()) {
            pa.d dVar = fVar.f6554r;
            za.h.c("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>", dVar);
            nb.h hVar = (nb.h) dVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = nb.h.f9318v;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(hVar);
                androidx.emoji2.text.s sVar = nb.a.f9308d;
                if (!za.h.a(obj, sVar)) {
                    if (!(obj instanceof Throwable)) {
                        while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, null)) {
                            if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    return;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(hVar, sVar, u10)) {
                    if (atomicReferenceFieldUpdater.get(hVar) != sVar) {
                        break;
                    }
                }
                return;
            }
        }
        fVar.k(u10);
        if (fVar.r()) {
            return;
        }
        fVar.l();
    }
}
