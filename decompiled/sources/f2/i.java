package f2;

import o9.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements Comparable {

    /* renamed from: o, reason: collision with root package name */
    public final boolean f4905o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f4906p;

    public i(i1.p pVar, int i10) {
        this.f4905o = (pVar.f5983e & 1) != 0;
        this.f4906p = r.a.b(i10, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        i iVar = (i) obj;
        return y.f9691a.c(this.f4906p, iVar.f4906p).c(this.f4905o, iVar.f4905o).e();
    }
}
