package r5;

import java.security.MessageDigest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements e {

    /* renamed from: b, reason: collision with root package name */
    public final m6.c f10795b = new m6.c(0);

    @Override // r5.e
    public final void b(MessageDigest messageDigest) {
        int i10 = 0;
        while (true) {
            m6.c cVar = this.f10795b;
            if (i10 >= cVar.f9781q) {
                return;
            }
            g gVar = (g) cVar.f(i10);
            Object j10 = this.f10795b.j(i10);
            f fVar = gVar.f10792b;
            if (gVar.f10794d == null) {
                gVar.f10794d = gVar.f10793c.getBytes(e.f10789a);
            }
            fVar.d(gVar.f10794d, j10, messageDigest);
            i10++;
        }
    }

    public final Object c(g gVar) {
        m6.c cVar = this.f10795b;
        return cVar.containsKey(gVar) ? cVar.get(gVar) : gVar.f10791a;
    }

    @Override // r5.e
    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f10795b.equals(((h) obj).f10795b);
        }
        return false;
    }

    @Override // r5.e
    public final int hashCode() {
        return this.f10795b.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.f10795b + '}';
    }
}
