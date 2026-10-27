package app.shamel.tv.activities;

import android.os.SystemClock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class k0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1903o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ MoviePlayerActivity f1904p;

    public /* synthetic */ k0(MoviePlayerActivity moviePlayerActivity, int i10) {
        this.f1903o = i10;
        this.f1904p = moviePlayerActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1903o) {
            case 0:
                MoviePlayerActivity moviePlayerActivity = this.f1904p;
                int i10 = moviePlayerActivity.f1762j0;
                if (i10 >= 1) {
                    moviePlayerActivity.f1762j0 = i10 - 1;
                    moviePlayerActivity.f1778z0.postAtTime(moviePlayerActivity.Z, SystemClock.uptimeMillis() + 1000);
                    break;
                } else {
                    moviePlayerActivity.f1770r0.setVisibility(8);
                    break;
                }
            default:
                MoviePlayerActivity moviePlayerActivity2 = this.f1904p;
                int i11 = moviePlayerActivity2.f1758e0;
                if (i11 >= 1) {
                    moviePlayerActivity2.f1758e0 = i11 - 1;
                    moviePlayerActivity2.f1778z0.postAtTime(moviePlayerActivity2.Y, SystemClock.uptimeMillis() + 1000);
                    break;
                } else {
                    moviePlayerActivity2.f1757d0.setVisibility(8);
                    break;
                }
        }
    }
}
