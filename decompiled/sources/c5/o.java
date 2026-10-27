package c5;

import android.os.Handler;
import android.os.SystemClock;
import android.widget.SeekBar;
import app.shamel.tv.activities.mobile.SeriesMobilePlayer;
import s1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2949o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ SeriesMobilePlayer f2950p;

    public /* synthetic */ o(SeriesMobilePlayer seriesMobilePlayer, int i10) {
        this.f2949o = i10;
        this.f2950p = seriesMobilePlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long y8;
        int i10 = this.f2949o;
        SeriesMobilePlayer seriesMobilePlayer = this.f2950p;
        switch (i10) {
            case 0:
                Handler handler = seriesMobilePlayer.E0;
                try {
                    int i11 = SeriesMobilePlayer.K0;
                    long w10 = seriesMobilePlayer.w();
                    if (seriesMobilePlayer.y()) {
                        y8 = seriesMobilePlayer.G0.b();
                    } else {
                        a0 a0Var = seriesMobilePlayer.Z;
                        y8 = a0Var != null ? a0Var.y() : 0L;
                    }
                    if (seriesMobilePlayer.y()) {
                        seriesMobilePlayer.H0 = y8;
                    }
                    if (w10 > 0 && seriesMobilePlayer.f2015j0 != null) {
                        seriesMobilePlayer.f2012f0.setText(k5.j.n(y8));
                        seriesMobilePlayer.f2013g0.setText(k5.j.n(w10));
                        int k10 = k5.j.k(y8, w10);
                        seriesMobilePlayer.f2015j0.setProgress(k10);
                        if (k10 > 98) {
                            handler.removeCallbacks(this);
                            break;
                        }
                    }
                } catch (Exception unused) {
                    SeekBar seekBar = seriesMobilePlayer.f2015j0;
                    if (seekBar != null) {
                        seekBar.setProgress(0);
                    }
                }
                handler.postDelayed(this, 1000L);
                break;
            case 1:
                int i12 = seriesMobilePlayer.C0;
                if (i12 >= 1) {
                    seriesMobilePlayer.C0 = i12 - 1;
                    seriesMobilePlayer.E0.postAtTime(seriesMobilePlayer.A0, SystemClock.uptimeMillis() + 1000);
                    break;
                } else {
                    seriesMobilePlayer.f2011e0.setVisibility(8);
                    break;
                }
            default:
                int i13 = seriesMobilePlayer.D0;
                if (i13 >= 1) {
                    seriesMobilePlayer.D0 = i13 - 1;
                    seriesMobilePlayer.E0.postAtTime(seriesMobilePlayer.B0, SystemClock.uptimeMillis() + 1000);
                    break;
                } else {
                    seriesMobilePlayer.f2014i0.setVisibility(8);
                    break;
                }
        }
    }
}
