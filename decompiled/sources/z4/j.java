package z4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends h {
    public final boolean i(Object obj) {
        if (obj == null) {
            obj = h.f14110u;
        }
        if (!h.f14109t.g(this, null, obj)) {
            return false;
        }
        h.c(this);
        return true;
    }

    public final boolean j(Throwable th) {
        if (!h.f14109t.g(this, null, new b(th))) {
            return false;
        }
        h.c(this);
        return true;
    }

    public final boolean k(s9.b bVar) {
        b bVar2;
        bVar.getClass();
        Object obj = this.f14111o;
        if (obj == null) {
            if (bVar.isDone()) {
                if (h.f14109t.g(this, null, h.f(bVar))) {
                    h.c(this);
                    return true;
                }
                return false;
            }
            e eVar = new e(this, bVar);
            if (h.f14109t.g(this, null, eVar)) {
                try {
                    bVar.a(eVar, i.f14114o);
                    return true;
                } catch (Throwable th) {
                    try {
                        bVar2 = new b(th);
                    } catch (Throwable unused) {
                        bVar2 = b.f14091b;
                    }
                    h.f14109t.g(this, eVar, bVar2);
                    return true;
                }
            }
            obj = this.f14111o;
        }
        if (obj instanceof a) {
            bVar.cancel(((a) obj).f14089a);
        }
        return false;
    }
}
