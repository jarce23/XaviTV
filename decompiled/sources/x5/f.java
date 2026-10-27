package x5;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13628a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13629b;

    public f(int i10) {
        this.f13628a = i10;
        switch (i10) {
            case 1:
                this.f13629b = new p4.p(29);
                break;
            default:
                this.f13629b = new c(3);
                break;
        }
    }

    @Override // x5.u
    public final t a(z zVar) {
        switch (this.f13628a) {
            case 0:
                return new d(1, (c) this.f13629b);
            default:
                return new y5.a((p4.p) this.f13629b);
        }
    }
}
