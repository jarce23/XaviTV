package t1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements l1.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11793o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f11794p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ boolean f11795q;

    public /* synthetic */ e(Object obj, boolean z10, int i10) {
        this.f11793o = i10;
        this.f11794p = obj;
        this.f11795q = z10;
    }

    @Override // l1.m
    public void invoke(Object obj) {
        switch (this.f11793o) {
            case 0:
                ((b) obj).L((a) this.f11794p, this.f11795q);
                break;
            case 1:
                ((b) obj).n((a) this.f11794p, this.f11795q);
                break;
            case 2:
                ((b) obj).u((a) this.f11794p, this.f11795q);
                break;
            default:
                a aVar = (a) this.f11794p;
                b bVar = (b) obj;
                bVar.getClass();
                bVar.m(aVar, this.f11795q);
                break;
        }
    }
}
