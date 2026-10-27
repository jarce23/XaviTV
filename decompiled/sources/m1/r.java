package m1;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r implements Comparable {

    /* renamed from: p, reason: collision with root package name */
    public long f8820p = -9223372036854775807L;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f8819o = new ArrayList();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f8820p, ((r) obj).f8820p);
    }
}
