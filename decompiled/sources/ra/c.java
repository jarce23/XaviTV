package ra;

import ib.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import pa.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class c extends a {
    private final i _context;
    private transient pa.d<Object> intercepted;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(pa.d dVar) {
        super(dVar);
        i context = dVar != null ? dVar.getContext() : null;
        this._context = context;
    }

    @Override // pa.d
    public i getContext() {
        i iVar = this._context;
        za.h.b(iVar);
        return iVar;
    }

    public final pa.d<Object> intercepted() {
        pa.d<Object> dVar = this.intercepted;
        if (dVar != null) {
            return dVar;
        }
        pa.f fVar = (pa.f) getContext().s(pa.e.f10145o);
        pa.d<Object> hVar = fVar != null ? new nb.h((q) fVar, this) : this;
        this.intercepted = hVar;
        return hVar;
    }

    @Override // ra.a
    public void releaseIntercepted() {
        pa.d<Object> dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            pa.g s10 = getContext().s(pa.e.f10145o);
            za.h.b(s10);
            nb.h hVar = (nb.h) dVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = nb.h.f9318v;
            while (atomicReferenceFieldUpdater.get(hVar) == nb.a.f9308d) {
            }
            Object obj = atomicReferenceFieldUpdater.get(hVar);
            ib.f fVar = obj instanceof ib.f ? (ib.f) obj : null;
            if (fVar != null) {
                fVar.l();
            }
        }
        this.intercepted = b.f10984o;
    }
}
