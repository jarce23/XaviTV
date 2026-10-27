package c5;

import android.os.Handler;
import android.widget.SeekBar;
import app.shamel.tv.activities.mobile.MovieMobilePlayer;
import c2.y0;
import s1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ MovieMobilePlayer f2940o;

    public j(MovieMobilePlayer movieMobilePlayer) {
        this.f2940o = movieMobilePlayer;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        MovieMobilePlayer movieMobilePlayer = this.f2940o;
        movieMobilePlayer.f2006z0.removeCallbacks(movieMobilePlayer.L0);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        int i10 = MovieMobilePlayer.M0;
        MovieMobilePlayer movieMobilePlayer = this.f2940o;
        long v10 = movieMobilePlayer.v();
        if (v10 > 0) {
            long progress = (v10 * seekBar.getProgress()) / 1000;
            y0 y0Var = movieMobilePlayer.J0;
            if (y0Var == null || !y0Var.g()) {
                a0 a0Var = movieMobilePlayer.f1988g0;
                if (a0Var != null) {
                    a0Var.l(5, progress);
                }
            } else {
                movieMobilePlayer.J0.h(progress);
            }
        }
        Handler handler = movieMobilePlayer.f2006z0;
        l lVar = movieMobilePlayer.L0;
        handler.removeCallbacks(lVar);
        handler.post(lVar);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
    }
}
