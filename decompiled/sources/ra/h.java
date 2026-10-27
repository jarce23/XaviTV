package ra;

import za.n;
import za.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class h extends c implements za.f {

    /* renamed from: o, reason: collision with root package name */
    public final int f10988o;

    public h(int i10, pa.d dVar) {
        super(dVar);
        this.f10988o = i10;
    }

    @Override // za.f
    public final int a() {
        return this.f10988o;
    }

    @Override // ra.a
    public final String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        n.f14178a.getClass();
        String a10 = o.a(this);
        za.h.d("renderLambdaToString(...)", a10);
        return a10;
    }
}
