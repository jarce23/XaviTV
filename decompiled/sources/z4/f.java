package z4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends a.a {
    @Override // a.a
    public final boolean f(h hVar, c cVar, c cVar2) {
        synchronized (hVar) {
            try {
                if (hVar.f14112p != cVar) {
                    return false;
                }
                hVar.f14112p = cVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.a
    public final boolean g(h hVar, Object obj, Object obj2) {
        synchronized (hVar) {
            try {
                if (hVar.f14111o != obj) {
                    return false;
                }
                hVar.f14111o = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.a
    public final boolean h(h hVar, g gVar, g gVar2) {
        synchronized (hVar) {
            try {
                if (hVar.f14113q != gVar) {
                    return false;
                }
                hVar.f14113q = gVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.a
    public final void q(g gVar, g gVar2) {
        gVar.f14106b = gVar2;
    }

    @Override // a.a
    public final void r(g gVar, Thread thread) {
        gVar.f14105a = thread;
    }
}
