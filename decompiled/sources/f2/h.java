package f2;

import i1.u0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends p implements Comparable {

    /* renamed from: s, reason: collision with root package name */
    public final int f4903s;

    /* renamed from: t, reason: collision with root package name */
    public final int f4904t;

    public h(int i10, u0 u0Var, int i11, k kVar, int i12) {
        super(i10, u0Var, i11);
        int i13;
        this.f4903s = r.a.b(i12, kVar.f4913t0) ? 1 : 0;
        i1.p pVar = this.f4929r;
        int i14 = pVar.f5998u;
        int i15 = -1;
        if (i14 != -1 && (i13 = pVar.f5999v) != -1) {
            i15 = i14 * i13;
        }
        this.f4904t = i15;
    }

    @Override // f2.p
    public final int a() {
        return this.f4903s;
    }

    @Override // f2.p
    public final /* bridge */ /* synthetic */ boolean b(p pVar) {
        return false;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Integer.compare(this.f4904t, ((h) obj).f4904t);
    }
}
