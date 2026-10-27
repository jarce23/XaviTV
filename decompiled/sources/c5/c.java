package c5;

import android.os.SystemClock;
import app.shamel.tv.activities.mobile.LiveChannelMobileActivity;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2927o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ LiveChannelMobileActivity f2928p;

    public /* synthetic */ c(LiveChannelMobileActivity liveChannelMobileActivity, int i10) {
        this.f2927o = i10;
        this.f2928p = liveChannelMobileActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2927o) {
            case 0:
                LiveChannelMobileActivity liveChannelMobileActivity = this.f2928p;
                int i10 = liveChannelMobileActivity.f1927g1;
                if (i10 >= 1) {
                    liveChannelMobileActivity.f1927g1 = i10 - 1;
                    liveChannelMobileActivity.W0.postAtTime(liveChannelMobileActivity.f1925f1, SystemClock.uptimeMillis() + 1000);
                    break;
                } else {
                    liveChannelMobileActivity.f1923e1.setVisibility(8);
                    break;
                }
            default:
                LiveChannelMobileActivity liveChannelMobileActivity2 = this.f2928p;
                if (liveChannelMobileActivity2.f1935o0 == 0 && liveChannelMobileActivity2.f1937q0.getVisibility() == 0) {
                    liveChannelMobileActivity2.f1937q0.setVisibility(8);
                }
                liveChannelMobileActivity2.f1935o0--;
                liveChannelMobileActivity2.W0.postAtTime(liveChannelMobileActivity2.f1932l0, SystemClock.uptimeMillis() + 1000);
                break;
        }
    }
}
