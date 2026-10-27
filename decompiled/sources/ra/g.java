package ra;

import pa.i;
import pa.j;
import za.n;
import za.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g extends a implements za.f {

    /* renamed from: o, reason: collision with root package name */
    public final int f10987o;

    public g(pa.d dVar) {
        super(dVar);
        if (dVar != null && dVar.getContext() != j.f10146o) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
        this.f10987o = 2;
    }

    @Override // za.f
    public final int a() {
        return this.f10987o;
    }

    @Override // pa.d
    public final i getContext() {
        return j.f10146o;
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
