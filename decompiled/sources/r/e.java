package r;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f10384p;

    /* renamed from: q, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f10385q;

    /* renamed from: r, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f10386r;

    /* renamed from: s, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f10387s;

    /* renamed from: t, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f10388t;

    public e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f10384p = atomicReferenceFieldUpdater;
        this.f10385q = atomicReferenceFieldUpdater2;
        this.f10386r = atomicReferenceFieldUpdater3;
        this.f10387s = atomicReferenceFieldUpdater4;
        this.f10388t = atomicReferenceFieldUpdater5;
    }

    @Override // com.bumptech.glide.c
    public final boolean e(h hVar, d dVar, d dVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f10387s;
            if (atomicReferenceFieldUpdater.compareAndSet(hVar, dVar, dVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(hVar) == dVar);
        return false;
    }

    @Override // com.bumptech.glide.c
    public final boolean f(h hVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f10388t;
            if (atomicReferenceFieldUpdater.compareAndSet(hVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(hVar) == obj);
        return false;
    }

    @Override // com.bumptech.glide.c
    public final boolean g(h hVar, g gVar, g gVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f10386r;
            if (atomicReferenceFieldUpdater.compareAndSet(hVar, gVar, gVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(hVar) == gVar);
        return false;
    }

    @Override // com.bumptech.glide.c
    public final void t(g gVar, g gVar2) {
        this.f10385q.lazySet(gVar, gVar2);
    }

    @Override // com.bumptech.glide.c
    public final void u(g gVar, Thread thread) {
        this.f10384p.lazySet(gVar, thread);
    }
}
