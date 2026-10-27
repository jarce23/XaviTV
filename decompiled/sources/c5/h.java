package c5;

import android.os.SystemClock;
import app.shamel.tv.activities.mobile.LiveMobileActivity;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2936o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ LiveMobileActivity f2937p;

    public /* synthetic */ h(LiveMobileActivity liveMobileActivity, int i10) {
        this.f2936o = i10;
        this.f2937p = liveMobileActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2936o) {
            case 0:
                LiveMobileActivity liveMobileActivity = this.f2937p;
                int i10 = liveMobileActivity.h1;
                if (i10 >= 1) {
                    liveMobileActivity.h1 = i10 - 1;
                    liveMobileActivity.X0.postAtTime(liveMobileActivity.f1961g1, SystemClock.uptimeMillis() + 1000);
                    break;
                } else {
                    liveMobileActivity.f1959f1.setVisibility(8);
                    break;
                }
            default:
                LiveMobileActivity liveMobileActivity2 = this.f2937p;
                if (liveMobileActivity2.f1971p0 == 0 && liveMobileActivity2.f1973r0.getVisibility() == 0) {
                    liveMobileActivity2.f1973r0.setVisibility(8);
                }
                liveMobileActivity2.f1971p0--;
                liveMobileActivity2.X0.postAtTime(liveMobileActivity2.f1970o0, SystemClock.uptimeMillis() + 1000);
                break;
        }
    }
}
