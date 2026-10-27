package z4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends a.a {

    /* renamed from: r, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f14097r;

    /* renamed from: s, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f14098s;

    /* renamed from: t, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f14099t;

    /* renamed from: u, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f14100u;

    /* renamed from: v, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f14101v;

    public d(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f14097r = atomicReferenceFieldUpdater;
        this.f14098s = atomicReferenceFieldUpdater2;
        this.f14099t = atomicReferenceFieldUpdater3;
        this.f14100u = atomicReferenceFieldUpdater4;
        this.f14101v = atomicReferenceFieldUpdater5;
    }

    @Override // a.a
    public final boolean f(h hVar, c cVar, c cVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f14100u;
            if (atomicReferenceFieldUpdater.compareAndSet(hVar, cVar, cVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(hVar) == cVar);
        return false;
    }

    @Override // a.a
    public final boolean g(h hVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f14101v;
            if (atomicReferenceFieldUpdater.compareAndSet(hVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(hVar) == obj);
        return false;
    }

    @Override // a.a
    public final boolean h(h hVar, g gVar, g gVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f14099t;
            if (atomicReferenceFieldUpdater.compareAndSet(hVar, gVar, gVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(hVar) == gVar);
        return false;
    }

    @Override // a.a
    public final void q(g gVar, g gVar2) {
        this.f14098s.lazySet(gVar, gVar2);
    }

    @Override // a.a
    public final void r(g gVar, Thread thread) {
        this.f14097r.lazySet(gVar, thread);
    }
}
