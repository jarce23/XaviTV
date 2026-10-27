package ib;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x0 extends nb.b {

    /* renamed from: b, reason: collision with root package name */
    public final u0 f6613b;

    /* renamed from: c, reason: collision with root package name */
    public z0 f6614c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ y0 f6615d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j0 f6616e;

    public x0(u0 u0Var, y0 y0Var, j0 j0Var) {
        this.f6615d = y0Var;
        this.f6616e = j0Var;
        this.f6613b = u0Var;
    }

    @Override // nb.b
    public final void b(Object obj, Object obj2) {
        nb.k kVar = (nb.k) obj;
        boolean z10 = obj2 == null;
        nb.k kVar2 = this.f6613b;
        nb.k kVar3 = z10 ? kVar2 : this.f6614c;
        if (kVar3 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = nb.k.f9329a;
            while (!atomicReferenceFieldUpdater.compareAndSet(kVar, this, kVar3)) {
                if (atomicReferenceFieldUpdater.get(kVar) != this) {
                    return;
                }
            }
            if (z10) {
                nb.k kVar4 = this.f6614c;
                za.h.b(kVar4);
                kVar2.g(kVar4);
            }
        }
    }

    @Override // nb.b
    public final androidx.emoji2.text.s c(Object obj) {
        if (this.f6615d.y() == this.f6616e) {
            return null;
        }
        return nb.a.f9309e;
    }
}
