package c5;

import android.util.Log;
import app.shamel.tv.activities.mobile.MovieMobilePlayer;
import c2.y0;
import h5.p0;
import h5.t;
import org.chromium.net.R;
import s1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements h7.j, t, p0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2941o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ MovieMobilePlayer f2942p;

    public /* synthetic */ k(MovieMobilePlayer movieMobilePlayer, int i10) {
        this.f2941o = i10;
        this.f2942p = movieMobilePlayer;
    }

    @Override // h5.t
    public void a() {
        switch (this.f2941o) {
            case 1:
                MovieMobilePlayer movieMobilePlayer = this.f2942p;
                movieMobilePlayer.f1983b0.J(false, false);
                y0 y0Var = movieMobilePlayer.J0;
                if (y0Var == null || !y0Var.g()) {
                    movieMobilePlayer.y();
                } else {
                    movieMobilePlayer.z(movieMobilePlayer.J0.b(), movieMobilePlayer.J0.c());
                    movieMobilePlayer.J0.i();
                    a0 a0Var = movieMobilePlayer.f1988g0;
                    if (a0Var != null) {
                        a0Var.Z();
                        movieMobilePlayer.f1988g0.O();
                        movieMobilePlayer.f1988g0 = null;
                        movieMobilePlayer.h0.setPlayer(null);
                    }
                }
                movieMobilePlayer.finish();
                break;
            default:
                this.f2942p.finish();
                break;
        }
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void b(h7.h hVar, int i10) {
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void d(h7.h hVar, String str) {
    }

    @Override // h5.t
    public void e() {
        switch (this.f2941o) {
            case 1:
                MovieMobilePlayer movieMobilePlayer = this.f2942p;
                movieMobilePlayer.f2006z0.removeCallbacks(movieMobilePlayer.f1984c0);
                movieMobilePlayer.f1986e0.setVisibility(0);
                movieMobilePlayer.T.requestFocus();
                movieMobilePlayer.w();
                break;
        }
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void f(h7.h hVar, int i10) {
    }

    @Override // h7.j
    public void g(h7.h hVar, boolean z10) {
        MovieMobilePlayer.u(this.f2942p);
    }

    @Override // h7.j
    public void h(h7.h hVar, int i10) {
        MovieMobilePlayer movieMobilePlayer = this.f2942p;
        movieMobilePlayer.T.setImageResource(R.drawable.ic_pause);
        movieMobilePlayer.U.setEnabled(true);
        movieMobilePlayer.O.setEnabled(true);
        movieMobilePlayer.X.setEnabled(true);
        movieMobilePlayer.f1998r0.setEnabled(true);
        movieMobilePlayer.U.setAlpha(1.0f);
        movieMobilePlayer.O.setAlpha(1.0f);
        movieMobilePlayer.X.setAlpha(1.0f);
        movieMobilePlayer.f1998r0.setAlpha(1.0f);
        y0 y0Var = movieMobilePlayer.J0;
        long b2 = y0Var != null ? y0Var.b() : 0L;
        a0 a0Var = movieMobilePlayer.f1988g0;
        if (a0Var == null) {
            movieMobilePlayer.f2004x0 = b2;
            return;
        }
        try {
            if (a0Var.A().o() == 0) {
                movieMobilePlayer.x(b2, movieMobilePlayer.f1999s0);
                return;
            }
            movieMobilePlayer.f1988g0.U(false);
            if (b2 > 0) {
                movieMobilePlayer.f1988g0.l(5, b2);
            }
            movieMobilePlayer.f1988g0.U(true);
        } catch (Exception e7) {
            Log.e("MovieMobilePlayer", "Error restoring playback from cast: " + e7.getMessage());
        }
    }

    @Override // h7.j
    public void i(h7.h hVar, String str) {
        MovieMobilePlayer movieMobilePlayer = this.f2942p;
        movieMobilePlayer.T.setImageResource(R.drawable.ic_pause);
        movieMobilePlayer.U.setEnabled(false);
        movieMobilePlayer.O.setEnabled(false);
        movieMobilePlayer.X.setEnabled(false);
        movieMobilePlayer.f1998r0.setEnabled(false);
        movieMobilePlayer.U.setAlpha(0.3f);
        movieMobilePlayer.O.setAlpha(0.3f);
        movieMobilePlayer.X.setAlpha(0.3f);
        movieMobilePlayer.f1998r0.setAlpha(0.3f);
        MovieMobilePlayer.u(movieMobilePlayer);
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void k(h7.h hVar) {
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void m(h7.h hVar, int i10) {
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void n(h7.h hVar) {
    }

    private final void c() {
    }
}
