package o;

import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends e implements Iterator {

    /* renamed from: o, reason: collision with root package name */
    public c f9355o;

    /* renamed from: p, reason: collision with root package name */
    public c f9356p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f9357q;

    public b(c cVar, c cVar2, int i10) {
        this.f9357q = i10;
        this.f9355o = cVar2;
        this.f9356p = cVar;
    }

    @Override // o.e
    public final void a(c cVar) {
        c cVar2;
        c cVar3 = null;
        if (this.f9355o == cVar && cVar == this.f9356p) {
            this.f9356p = null;
            this.f9355o = null;
        }
        c cVar4 = this.f9355o;
        if (cVar4 == cVar) {
            switch (this.f9357q) {
                case 0:
                    cVar2 = cVar4.f9361r;
                    break;
                default:
                    cVar2 = cVar4.f9360q;
                    break;
            }
            this.f9355o = cVar2;
        }
        c cVar5 = this.f9356p;
        if (cVar5 == cVar) {
            c cVar6 = this.f9355o;
            if (cVar5 != cVar6 && cVar6 != null) {
                cVar3 = b(cVar5);
            }
            this.f9356p = cVar3;
        }
    }

    public final c b(c cVar) {
        switch (this.f9357q) {
            case 0:
                return cVar.f9360q;
            default:
                return cVar.f9361r;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9356p != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar = this.f9356p;
        c cVar2 = this.f9355o;
        this.f9356p = (cVar == cVar2 || cVar2 == null) ? null : b(cVar);
        return cVar;
    }
}
