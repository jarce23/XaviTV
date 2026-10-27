package j9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d1 implements k9.f {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f7253o;

    /* renamed from: p, reason: collision with root package name */
    public k9.e f7254p;

    public /* synthetic */ d1() {
        this.f7253o = 2;
    }

    @Override // k9.f
    public final Object c() {
        switch (this.f7253o) {
            case 0:
                return new c1((p) this.f7254p.c());
            case 1:
                return new s1((p) this.f7254p.c());
            default:
                k9.e eVar = this.f7254p;
                if (eVar != null) {
                    return eVar.c();
                }
                throw new IllegalStateException();
        }
    }

    public /* synthetic */ d1(k9.e eVar, int i10) {
        this.f7253o = i10;
        this.f7254p = eVar;
    }
}
