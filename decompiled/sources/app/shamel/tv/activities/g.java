package app.shamel.tv.activities;

import android.os.SystemClock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1888o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ f.j f1889p;

    public /* synthetic */ g(f.j jVar, int i10) {
        this.f1888o = i10;
        this.f1889p = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1888o) {
            case 0:
                CatchUpPlayerActivity catchUpPlayerActivity = (CatchUpPlayerActivity) this.f1889p;
                int i10 = catchUpPlayerActivity.f1583a0;
                if (i10 >= 1) {
                    catchUpPlayerActivity.f1583a0 = i10 - 1;
                    catchUpPlayerActivity.f1592k0.postAtTime(catchUpPlayerActivity.W, SystemClock.uptimeMillis() + 1000);
                    break;
                } else {
                    catchUpPlayerActivity.Z.setVisibility(8);
                    break;
                }
            default:
                SeriesPlayerActivity seriesPlayerActivity = (SeriesPlayerActivity) this.f1889p;
                int i11 = seriesPlayerActivity.f1822g0;
                if (i11 < 1) {
                    seriesPlayerActivity.D(false);
                    seriesPlayerActivity.f1821f0.setVisibility(8);
                    break;
                } else {
                    seriesPlayerActivity.f1822g0 = i11 - 1;
                    seriesPlayerActivity.G0.postAtTime(seriesPlayerActivity.f1817b0, SystemClock.uptimeMillis() + 1000);
                    break;
                }
        }
    }
}
