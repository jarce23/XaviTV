package t1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements l1.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11791o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ a f11792p;

    public /* synthetic */ d(a aVar) {
        this.f11791o = 0;
        i1.d dVar = i1.d.f5843b;
        this.f11792p = aVar;
    }

    @Override // l1.m
    public final void invoke(Object obj) {
        int i10 = this.f11791o;
        a aVar = this.f11792p;
        switch (i10) {
            case 0:
                i1.d dVar = i1.d.f5843b;
                ((b) obj).i(aVar);
                break;
            case 1:
                ((b) obj).H(aVar);
                break;
            case 2:
                ((b) obj).z(aVar);
                break;
            default:
                ((b) obj).a(aVar);
                break;
        }
    }

    public /* synthetic */ d(a aVar, s1.e eVar, int i10) {
        this.f11791o = i10;
        this.f11792p = aVar;
    }
}
