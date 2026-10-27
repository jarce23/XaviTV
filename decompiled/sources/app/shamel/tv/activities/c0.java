package app.shamel.tv.activities;

import android.os.Handler;
import android.os.SystemClock;
import android.widget.Toast;
import app.shamel.tv.models.EPGChannel;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1875o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ LiveChannelActivity f1876p;

    public /* synthetic */ c0(LiveChannelActivity liveChannelActivity, int i10) {
        this.f1875o = i10;
        this.f1876p = liveChannelActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1875o) {
            case 0:
                LiveChannelActivity liveChannelActivity = this.f1876p;
                if (liveChannelActivity.f1690c0 == 0 && liveChannelActivity.f1711p0.getVisibility() == 0) {
                    liveChannelActivity.f1711p0.setVisibility(8);
                    liveChannelActivity.f1707l1 = 2;
                    liveChannelActivity.L(false);
                }
                liveChannelActivity.f1690c0--;
                liveChannelActivity.f1701i1.postAtTime(liveChannelActivity.f1688b0, SystemClock.uptimeMillis() + 1000);
                break;
            default:
                LiveChannelActivity liveChannelActivity2 = this.f1876p;
                Handler handler = liveChannelActivity2.f1701i1;
                handler.removeCallbacks(liveChannelActivity2.f1714s0);
                if (liveChannelActivity2.f1715t0 == 0) {
                    for (int i10 = 0; i10 < liveChannelActivity2.W.size(); i10++) {
                        if (Integer.parseInt(((EPGChannel) liveChannelActivity2.W.get(i10)).getNum()) == liveChannelActivity2.f1693d1) {
                            liveChannelActivity2.f1708m0 = (EPGChannel) liveChannelActivity2.W.get(i10);
                            liveChannelActivity2.f1689b1 = i10;
                        }
                    }
                    if (liveChannelActivity2.f1708m0 == null) {
                        liveChannelActivity2.f1699g1 = _UrlKt.FRAGMENT_ENCODE_SET;
                        liveChannelActivity2.T0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
                        liveChannelActivity2.T0.setVisibility(8);
                        Toast.makeText(liveChannelActivity2, liveChannelActivity2.Z0.getNo_channels(), 0).show();
                    } else {
                        liveChannelActivity2.f1699g1 = _UrlKt.FRAGMENT_ENCODE_SET;
                        liveChannelActivity2.T0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
                        liveChannelActivity2.T0.setVisibility(8);
                        if (liveChannelActivity2.A(liveChannelActivity2.f1708m0.getCategory_id(), liveChannelActivity2.f1708m0.getCategory_name())) {
                            liveChannelActivity2.M(liveChannelActivity2.f1708m0, liveChannelActivity2.f1689b1, 2);
                        } else {
                            liveChannelActivity2.E(liveChannelActivity2.f1708m0);
                            liveChannelActivity2.f1719x0.setSelectedPosition(liveChannelActivity2.f1689b1);
                            handler.removeCallbacks(liveChannelActivity2.Y);
                            liveChannelActivity2.z(liveChannelActivity2.f1697f1);
                            liveChannelActivity2.u(liveChannelActivity2.f1689b1);
                            if (liveChannelActivity2.f1711p0.getVisibility() == 8 && liveChannelActivity2.h1) {
                                liveChannelActivity2.f1711p0.setVisibility(0);
                            }
                            handler.removeCallbacks(liveChannelActivity2.f1688b0);
                            liveChannelActivity2.B();
                        }
                    }
                }
                liveChannelActivity2.f1715t0--;
                handler.postAtTime(liveChannelActivity2.f1714s0, SystemClock.uptimeMillis() + 1000);
                break;
        }
    }
}
