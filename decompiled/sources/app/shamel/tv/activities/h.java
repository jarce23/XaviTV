package app.shamel.tv.activities;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements h5.t, h5.p0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1893o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ CatchUpPlayerActivity f1894p;

    public /* synthetic */ h(CatchUpPlayerActivity catchUpPlayerActivity, int i10) {
        this.f1893o = i10;
        this.f1894p = catchUpPlayerActivity;
    }

    @Override // h5.t
    public final void a() {
        switch (this.f1893o) {
            case 0:
                CatchUpPlayerActivity catchUpPlayerActivity = this.f1894p;
                catchUpPlayerActivity.V.J(false, false);
                catchUpPlayerActivity.x();
                catchUpPlayerActivity.finish();
                break;
            default:
                this.f1894p.finish();
                break;
        }
    }

    @Override // h5.t
    public final void e() {
        switch (this.f1893o) {
            case 0:
                break;
            default:
                CatchUpPlayerActivity catchUpPlayerActivity = this.f1894p;
                if (catchUpPlayerActivity.f1593l0 < catchUpPlayerActivity.S.size() - 1) {
                    int i10 = catchUpPlayerActivity.f1593l0 + 1;
                    catchUpPlayerActivity.f1593l0 = i10;
                    catchUpPlayerActivity.v(i10);
                    break;
                }
                break;
        }
    }

    private final void b() {
    }
}
