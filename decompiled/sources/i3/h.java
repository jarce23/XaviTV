package i3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends h3.h implements Comparable {

    /* renamed from: y, reason: collision with root package name */
    public long f6389y;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        h hVar = (h) obj;
        if (d(4) != hVar.d(4)) {
            return d(4) ? 1 : -1;
        }
        long j10 = this.f10412u - hVar.f10412u;
        if (j10 == 0) {
            j10 = this.f6389y - hVar.f6389y;
            if (j10 == 0) {
                return 0;
            }
        }
        return j10 > 0 ? 1 : -1;
    }
}
