package app.shamel.tv.activities;

import android.os.Handler;
import android.os.SystemClock;
import android.widget.Toast;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2080o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ LiveActivity f2081p;

    public /* synthetic */ z(LiveActivity liveActivity, int i10) {
        this.f2080o = i10;
        this.f2081p = liveActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2080o) {
            case 0:
                LiveActivity liveActivity = this.f2081p;
                if (liveActivity.f1652d0 == 0 && liveActivity.f1675q0.getVisibility() == 0) {
                    liveActivity.f1675q0.setVisibility(8);
                    liveActivity.f1673o1 = 2;
                    liveActivity.P(false);
                }
                liveActivity.f1652d0--;
                liveActivity.f1667l1.postAtTime(liveActivity.f1650c0, SystemClock.uptimeMillis() + 1000);
                break;
            default:
                LiveActivity liveActivity2 = this.f2081p;
                Handler handler = liveActivity2.f1667l1;
                handler.removeCallbacks(liveActivity2.f1678t0);
                if (liveActivity2.f1679u0 == 0) {
                    for (int i10 = 0; i10 < liveActivity2.X.size(); i10++) {
                        if (Integer.parseInt(((EPGChannel) liveActivity2.X.get(i10)).getNum()) == liveActivity2.f1659g1) {
                            liveActivity2.f1670n0 = (EPGChannel) liveActivity2.X.get(i10);
                            liveActivity2.f1653d1 = i10;
                        }
                    }
                    if (liveActivity2.f1670n0 == null) {
                        liveActivity2.f1663j1 = _UrlKt.FRAGMENT_ENCODE_SET;
                        liveActivity2.V0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
                        liveActivity2.V0.setVisibility(8);
                        Toast.makeText(liveActivity2, liveActivity2.f1649b1.getNo_channels(), 0).show();
                    } else {
                        liveActivity2.f1663j1 = _UrlKt.FRAGMENT_ENCODE_SET;
                        liveActivity2.V0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
                        liveActivity2.V0.setVisibility(8);
                        if (((CategoryModel) liveActivity2.Q.get(liveActivity2.f1651c1)).getId().equalsIgnoreCase("all_id") && liveActivity2.D(liveActivity2.f1670n0.getCategory_id(), liveActivity2.f1670n0.getCategory_name())) {
                            liveActivity2.Q(liveActivity2.f1670n0, liveActivity2.f1653d1, 2);
                        } else {
                            liveActivity2.H(liveActivity2.f1670n0);
                            liveActivity2.f1684z0.setSelectedPosition(liveActivity2.f1653d1);
                            handler.removeCallbacks(liveActivity2.Z);
                            liveActivity2.A(liveActivity2.f1661i1);
                            liveActivity2.v(liveActivity2.f1653d1);
                            if (liveActivity2.f1675q0.getVisibility() == 8 && liveActivity2.f1665k1) {
                                liveActivity2.f1675q0.setVisibility(0);
                            }
                            handler.removeCallbacks(liveActivity2.f1650c0);
                            liveActivity2.E();
                        }
                    }
                }
                liveActivity2.f1679u0--;
                handler.postAtTime(liveActivity2.f1678t0, SystemClock.uptimeMillis() + 1000);
                break;
        }
    }
}
