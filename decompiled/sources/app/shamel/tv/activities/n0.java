package app.shamel.tv.activities;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 implements h5.t, h5.p0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2033o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ MoviePlayerActivity f2034p;

    public /* synthetic */ n0(MoviePlayerActivity moviePlayerActivity, int i10) {
        this.f2033o = i10;
        this.f2034p = moviePlayerActivity;
    }

    @Override // h5.t
    public final void a() {
        switch (this.f2033o) {
            case 0:
                MoviePlayerActivity moviePlayerActivity = this.f2034p;
                moviePlayerActivity.X.J(false, false);
                moviePlayerActivity.w();
                moviePlayerActivity.finish();
                break;
            default:
                this.f2034p.finish();
                break;
        }
    }

    @Override // h5.t
    public final void e() {
        switch (this.f2033o) {
            case 0:
                MoviePlayerActivity moviePlayerActivity = this.f2034p;
                moviePlayerActivity.f1778z0.removeCallbacks(moviePlayerActivity.Y);
                moviePlayerActivity.f1757d0.setVisibility(0);
                moviePlayerActivity.Q.requestFocus();
                moviePlayerActivity.u();
                break;
        }
    }

    private final void b() {
    }
}
