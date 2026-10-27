package j9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i0 implements k9.f {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f7305o;

    /* renamed from: p, reason: collision with root package name */
    public final k9.e f7306p;

    /* renamed from: q, reason: collision with root package name */
    public final k9.e f7307q;

    /* renamed from: r, reason: collision with root package name */
    public final k9.e f7308r;

    public /* synthetic */ i0(k9.e eVar, k9.e eVar2, k9.e eVar3, int i10) {
        this.f7305o = i10;
        this.f7306p = eVar;
        this.f7307q = eVar2;
        this.f7308r = eVar3;
    }

    @Override // k9.f
    public final /* bridge */ /* synthetic */ Object c() {
        switch (this.f7305o) {
            case 0:
                return new h0((u0) this.f7306p.c(), (l0) this.f7307q.c(), (h1) this.f7308r.c());
            default:
                return new w0((u0) this.f7306p.c(), (p) this.f7307q.c(), (w) this.f7308r.c());
        }
    }
}
