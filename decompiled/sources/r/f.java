package r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends com.bumptech.glide.c {
    @Override // com.bumptech.glide.c
    public final boolean e(h hVar, d dVar, d dVar2) {
        synchronized (hVar) {
            try {
                if (hVar.f10397p != dVar) {
                    return false;
                }
                hVar.f10397p = dVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.c
    public final boolean f(h hVar, Object obj, Object obj2) {
        synchronized (hVar) {
            try {
                if (hVar.f10396o != obj) {
                    return false;
                }
                hVar.f10396o = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.c
    public final boolean g(h hVar, g gVar, g gVar2) {
        synchronized (hVar) {
            try {
                if (hVar.f10398q != gVar) {
                    return false;
                }
                hVar.f10398q = gVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.c
    public final void t(g gVar, g gVar2) {
        gVar.f10391b = gVar2;
    }

    @Override // com.bumptech.glide.c
    public final void u(g gVar, Thread thread) {
        gVar.f10390a = thread;
    }
}
