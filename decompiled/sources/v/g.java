package v;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: m, reason: collision with root package name */
    public int f12609m;

    public g(o oVar) {
        super(oVar);
        if (oVar instanceof k) {
            this.f12602e = 2;
        } else {
            this.f12602e = 3;
        }
    }

    @Override // v.f
    public final void d(int i10) {
        if (this.f12606j) {
            return;
        }
        this.f12606j = true;
        this.g = i10;
        ArrayList arrayList = this.f12607k;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            d dVar = (d) obj;
            dVar.a(dVar);
        }
    }
}
