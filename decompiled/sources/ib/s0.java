package ib;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s0 extends y0 {

    /* renamed from: q, reason: collision with root package name */
    public final boolean f6590q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0() {
        super(true);
        boolean z10 = true;
        B(null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = y0.f6618p;
        i iVar = (i) atomicReferenceFieldUpdater.get(this);
        j jVar = iVar instanceof j ? (j) iVar : null;
        if (jVar != null) {
            y0 k10 = jVar.k();
            while (!k10.v()) {
                i iVar2 = (i) atomicReferenceFieldUpdater.get(k10);
                j jVar2 = iVar2 instanceof j ? (j) iVar2 : null;
                if (jVar2 != null) {
                    k10 = jVar2.k();
                }
            }
            this.f6590q = z10;
        }
        z10 = false;
        this.f6590q = z10;
    }

    @Override // ib.y0
    public final boolean v() {
        return this.f6590q;
    }
}
