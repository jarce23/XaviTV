package app.shamel.tv.activities;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2065o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ SeriesPlayerActivity f2066p;

    public /* synthetic */ v0(SeriesPlayerActivity seriesPlayerActivity, int i10) {
        this.f2065o = i10;
        this.f2066p = seriesPlayerActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2065o) {
            case 0:
                SeriesPlayerActivity seriesPlayerActivity = this.f2066p;
                Handler handler = seriesPlayerActivity.G0;
                try {
                    s1.a0 a0Var = seriesPlayerActivity.h0;
                    if (a0Var != null) {
                        long D = a0Var.D();
                        long y8 = seriesPlayerActivity.h0.y();
                        seriesPlayerActivity.f1838x0.setText(k5.j.n(y8));
                        seriesPlayerActivity.f1834t0.setText(k5.j.n(D));
                        int k10 = k5.j.k(y8, D);
                        seriesPlayerActivity.f1830p0.setProgress(k10);
                        if (k10 > 98) {
                            handler.removeCallbacks(seriesPlayerActivity.J0);
                            break;
                        }
                    }
                } catch (Exception unused) {
                    seriesPlayerActivity.f1830p0.setProgress(0);
                }
                handler.postDelayed(this, 1000L);
                break;
            default:
                SeriesPlayerActivity seriesPlayerActivity2 = this.f2066p;
                int i10 = seriesPlayerActivity2.f1826l0;
                if (i10 >= 1) {
                    seriesPlayerActivity2.f1826l0 = i10 - 1;
                    seriesPlayerActivity2.G0.postAtTime(seriesPlayerActivity2.f1818c0, SystemClock.uptimeMillis() + 1000);
                    break;
                } else {
                    seriesPlayerActivity2.f1836v0.setVisibility(8);
                    break;
                }
        }
    }
}
