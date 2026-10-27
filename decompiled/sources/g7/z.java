package g7;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class z implements p7.h {

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ z f5320p = new z(0);

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ z f5321q = new z(1);

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5322o;

    public /* synthetic */ z(int i10) {
        this.f5322o = i10;
    }

    @Override // p7.h
    public final void accept(Object obj, Object obj2) {
        l7.x xVar = (l7.x) obj;
        i8.d dVar = (i8.d) obj2;
        switch (this.f5322o) {
            case 0:
                l7.b bVar = e0.G;
                ((l7.g) xVar.j()).A0();
                dVar.b(null);
                break;
            default:
                l7.b bVar2 = e0.G;
                l7.g gVar = (l7.g) xVar.j();
                gVar.z0(gVar.w0(), 19);
                dVar.b(Boolean.TRUE);
                break;
        }
    }
}
