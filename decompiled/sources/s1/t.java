package s1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements l1.m, n9.d {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11455o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f11456p;

    public /* synthetic */ t(int i10, int i11) {
        this.f11455o = i11;
        this.f11456p = i10;
    }

    @Override // n9.d
    public Object apply(Object obj) {
        return Integer.valueOf(this.f11456p);
    }

    @Override // l1.m
    public void invoke(Object obj) {
        switch (this.f11455o) {
            case 0:
                ((i1.m0) obj).h(this.f11456p);
                break;
            default:
                ((i1.m0) obj).y(this.f11456p);
                break;
        }
    }
}
