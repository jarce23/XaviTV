package t1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements l1.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11796o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ a f11797p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ String f11798q;

    public /* synthetic */ f(a aVar, String str, int i10) {
        this.f11796o = i10;
        this.f11797p = aVar;
        this.f11798q = str;
    }

    @Override // l1.m
    public final void invoke(Object obj) {
        switch (this.f11796o) {
            case 0:
                b bVar = (b) obj;
                bVar.getClass();
                bVar.e(this.f11797p, this.f11798q);
                break;
            case 1:
                ((b) obj).O(this.f11797p, this.f11798q);
                break;
            case 2:
                b bVar2 = (b) obj;
                bVar2.getClass();
                bVar2.E(this.f11797p, this.f11798q);
                break;
            default:
                ((b) obj).G(this.f11797p, this.f11798q);
                break;
        }
    }

    public /* synthetic */ f(a aVar, String str, long j10, long j11, int i10) {
        this.f11796o = i10;
        this.f11797p = aVar;
        this.f11798q = str;
    }
}
