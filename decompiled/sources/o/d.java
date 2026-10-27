package o;

import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends e implements Iterator {

    /* renamed from: o, reason: collision with root package name */
    public c f9362o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9363p = true;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ f f9364q;

    public d(f fVar) {
        this.f9364q = fVar;
    }

    @Override // o.e
    public final void a(c cVar) {
        c cVar2 = this.f9362o;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f9361r;
            this.f9362o = cVar3;
            this.f9363p = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f9363p) {
            return this.f9364q.f9365o != null;
        }
        c cVar = this.f9362o;
        return (cVar == null || cVar.f9360q == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f9363p) {
            this.f9363p = false;
            this.f9362o = this.f9364q.f9365o;
        } else {
            c cVar = this.f9362o;
            this.f9362o = cVar != null ? cVar.f9360q : null;
        }
        return this.f9362o;
    }
}
