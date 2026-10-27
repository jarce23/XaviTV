package z6;

import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final c7.a f14123a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f14124b;

    public a(c7.a aVar, HashMap hashMap) {
        this.f14123a = aVar;
        this.f14124b = hashMap;
    }

    public final long a(p6.c cVar, long j10, int i10) {
        long h10 = j10 - this.f14123a.h();
        b bVar = (b) this.f14124b.get(cVar);
        long j11 = bVar.f14125a;
        return Math.min(Math.max((long) (Math.pow(3.0d, i10 - 1) * j11 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j11 > 1 ? j11 : 2L) * r12))), h10), bVar.f14126b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14123a.equals(aVar.f14123a) && this.f14124b.equals(aVar.f14124b);
    }

    public final int hashCode() {
        return ((this.f14123a.hashCode() ^ 1000003) * 1000003) ^ this.f14124b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f14123a + ", values=" + this.f14124b + "}";
    }
}
