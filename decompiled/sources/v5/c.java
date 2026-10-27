package v5;

import m6.j;
import t5.k;
import t5.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public k f12678d;

    @Override // m6.j
    public final int b(Object obj) {
        y yVar = (y) obj;
        if (yVar == null) {
            return 1;
        }
        return yVar.c();
    }

    @Override // m6.j
    public final void c(Object obj, Object obj2) {
        y yVar = (y) obj2;
        k kVar = this.f12678d;
        if (kVar == null || yVar == null) {
            return;
        }
        kVar.f11957e.g(yVar, true);
    }

    public final void g(int i10) {
        long j10;
        if (i10 >= 40) {
            f(0L);
        } else if (i10 >= 20 || i10 == 15) {
            synchronized (this) {
                j10 = this.f9019a;
            }
            f(j10 / 2);
        }
    }
}
