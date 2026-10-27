package fb;

import java.util.Iterator;
import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5069a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5070b;

    public /* synthetic */ i(int i10, Object obj) {
        this.f5069a = i10;
        this.f5070b = obj;
    }

    @Override // fb.f
    public final Iterator iterator() {
        switch (this.f5069a) {
            case 0:
                ra.g gVar = (ra.g) this.f5070b;
                g gVar2 = new g();
                gVar2.f5068r = gVar.create(gVar2, gVar2);
                return gVar2;
            case 1:
                return (Iterator) this.f5070b;
            default:
                return ((Iterable) this.f5070b).iterator();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(p pVar) {
        this.f5069a = 0;
        this.f5070b = (ra.g) pVar;
    }
}
