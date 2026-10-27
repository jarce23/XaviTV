package app.shamel.tv.activities;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w0 implements h5.t, h5.p0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2068o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ SeriesPlayerActivity f2069p;

    public /* synthetic */ w0(SeriesPlayerActivity seriesPlayerActivity, int i10) {
        this.f2068o = i10;
        this.f2069p = seriesPlayerActivity;
    }

    @Override // h5.t
    public final void a() {
        switch (this.f2068o) {
            case 0:
                SeriesPlayerActivity seriesPlayerActivity = this.f2069p;
                seriesPlayerActivity.f1816a0.J(false, false);
                seriesPlayerActivity.A();
                seriesPlayerActivity.finish();
                break;
            case 1:
                this.f2069p.finish();
                break;
            default:
                SeriesPlayerActivity seriesPlayerActivity2 = this.f2069p;
                seriesPlayerActivity2.f1827m0.J(false, false);
                seriesPlayerActivity2.f1821f0.setVisibility(0);
                seriesPlayerActivity2.f1825k0.setFocusable(false);
                seriesPlayerActivity2.R.requestFocus();
                seriesPlayerActivity2.z(seriesPlayerActivity2.D0, seriesPlayerActivity2.A0);
                seriesPlayerActivity2.G0.removeCallbacks(seriesPlayerActivity2.f1817b0);
                seriesPlayerActivity2.x();
                break;
        }
    }

    @Override // h5.t
    public final void e() {
        switch (this.f2068o) {
            case 0:
                SeriesPlayerActivity seriesPlayerActivity = this.f2069p;
                seriesPlayerActivity.G0.removeCallbacks(seriesPlayerActivity.f1817b0);
                seriesPlayerActivity.f1821f0.setVisibility(0);
                seriesPlayerActivity.x();
                seriesPlayerActivity.R.requestFocus();
                break;
            case 1:
                SeriesPlayerActivity seriesPlayerActivity2 = this.f2069p;
                if (seriesPlayerActivity2.Z < seriesPlayerActivity2.Y.size() - 1) {
                    seriesPlayerActivity2.Z++;
                    seriesPlayerActivity2.A();
                    seriesPlayerActivity2.y(seriesPlayerActivity2.Z);
                    break;
                }
                break;
            default:
                SeriesPlayerActivity seriesPlayerActivity3 = this.f2069p;
                seriesPlayerActivity3.f1821f0.setVisibility(0);
                seriesPlayerActivity3.z(0L, seriesPlayerActivity3.A0);
                seriesPlayerActivity3.G0.removeCallbacks(seriesPlayerActivity3.f1817b0);
                seriesPlayerActivity3.x();
                seriesPlayerActivity3.f1825k0.setFocusable(false);
                seriesPlayerActivity3.R.requestFocus();
                break;
        }
    }
}
