package c5;

import android.os.Handler;
import android.os.SystemClock;
import android.widget.SeekBar;
import android.widget.TextView;
import app.shamel.tv.activities.mobile.MovieMobilePlayer;
import c2.y0;
import s1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2943o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ MovieMobilePlayer f2944p;

    public /* synthetic */ l(MovieMobilePlayer movieMobilePlayer, int i10) {
        this.f2943o = i10;
        this.f2944p = movieMobilePlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long y8;
        int i10 = this.f2943o;
        MovieMobilePlayer movieMobilePlayer = this.f2944p;
        switch (i10) {
            case 0:
                Handler handler = movieMobilePlayer.f2006z0;
                try {
                    int i11 = MovieMobilePlayer.M0;
                    long v10 = movieMobilePlayer.v();
                    y0 y0Var = movieMobilePlayer.J0;
                    if (y0Var == null || !y0Var.g()) {
                        a0 a0Var = movieMobilePlayer.f1988g0;
                        y8 = a0Var != null ? a0Var.y() : 0L;
                    } else {
                        y8 = movieMobilePlayer.J0.b();
                    }
                    if (v10 > 0 && movieMobilePlayer.f1991k0 != null) {
                        TextView textView = movieMobilePlayer.f1996p0;
                        if (textView != null) {
                            textView.setText(k5.j.n(y8));
                        }
                        TextView textView2 = movieMobilePlayer.f1994n0;
                        if (textView2 != null) {
                            textView2.setText(k5.j.n(v10));
                        }
                        if (movieMobilePlayer.f1991k0.getMax() != 1000) {
                            movieMobilePlayer.f1991k0.setMax(1000);
                        }
                        int i12 = (int) ((y8 * 1000) / v10);
                        movieMobilePlayer.f1991k0.setProgress(i12);
                        if (i12 >= 980) {
                            handler.removeCallbacks(this);
                            break;
                        }
                    }
                } catch (Exception unused) {
                    SeekBar seekBar = movieMobilePlayer.f1991k0;
                    if (seekBar != null) {
                        seekBar.setProgress(0);
                    }
                }
                handler.postDelayed(this, 1000L);
                break;
            case 1:
                int i13 = movieMobilePlayer.f1987f0;
                if (i13 >= 1) {
                    movieMobilePlayer.f1987f0 = i13 - 1;
                    movieMobilePlayer.f2006z0.postAtTime(movieMobilePlayer.f1984c0, SystemClock.uptimeMillis() + 1000);
                    break;
                } else {
                    movieMobilePlayer.f1986e0.setVisibility(8);
                    break;
                }
            default:
                int i14 = movieMobilePlayer.I0;
                if (i14 >= 1) {
                    movieMobilePlayer.I0 = i14 - 1;
                    movieMobilePlayer.f2006z0.postAtTime(movieMobilePlayer.H0, SystemClock.uptimeMillis() + 1000);
                    break;
                } else {
                    movieMobilePlayer.G0.setVisibility(8);
                    break;
                }
        }
    }
}
