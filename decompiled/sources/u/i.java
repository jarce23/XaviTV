package u;

import java.util.ArrayList;
import v.n;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i extends d {

    /* renamed from: p0, reason: collision with root package name */
    public d[] f12143p0 = new d[4];

    /* renamed from: q0, reason: collision with root package name */
    public int f12144q0 = 0;

    public final void M(int i10, ArrayList arrayList, n nVar) {
        for (int i11 = 0; i11 < this.f12144q0; i11++) {
            d dVar = this.f12143p0[i11];
            ArrayList arrayList2 = nVar.f12617a;
            if (!arrayList2.contains(dVar)) {
                arrayList2.add(dVar);
            }
        }
        for (int i12 = 0; i12 < this.f12144q0; i12++) {
            v.h.b(this.f12143p0[i12], i10, arrayList, nVar);
        }
    }

    public void N() {
    }
}
