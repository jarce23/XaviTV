package c5;

import app.shamel.tv.activities.mobile.SeriesMobilePlayer;
import c2.y0;
import h5.p0;
import h5.t;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n implements t, h7.j, p0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2947o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ SeriesMobilePlayer f2948p;

    public /* synthetic */ n(SeriesMobilePlayer seriesMobilePlayer, int i10) {
        this.f2947o = i10;
        this.f2948p = seriesMobilePlayer;
    }

    @Override // h5.t
    public void a() {
        switch (this.f2947o) {
            case 0:
                SeriesMobilePlayer seriesMobilePlayer = this.f2948p;
                seriesMobilePlayer.f2027v0.J(false, false);
                seriesMobilePlayer.f2011e0.setVisibility(0);
                seriesMobilePlayer.U.requestFocus();
                if (seriesMobilePlayer.y()) {
                    seriesMobilePlayer.v(seriesMobilePlayer.f2030y0, seriesMobilePlayer.f2019n0);
                } else {
                    seriesMobilePlayer.B(seriesMobilePlayer.f2030y0, seriesMobilePlayer.f2019n0);
                }
                seriesMobilePlayer.E0.removeCallbacks(seriesMobilePlayer.A0);
                seriesMobilePlayer.z();
                break;
            case 1:
            default:
                this.f2948p.finish();
                break;
            case 2:
                SeriesMobilePlayer seriesMobilePlayer2 = this.f2948p;
                seriesMobilePlayer2.f2026u0.J(false, false);
                seriesMobilePlayer2.C();
                y0 y0Var = seriesMobilePlayer2.G0;
                if (y0Var != null) {
                    y0Var.i();
                }
                seriesMobilePlayer2.finish();
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
        switch (this.f2947o) {
            case 0:
                SeriesMobilePlayer seriesMobilePlayer = this.f2948p;
                seriesMobilePlayer.f2011e0.setVisibility(0);
                seriesMobilePlayer.U.requestFocus();
                if (seriesMobilePlayer.y()) {
                    seriesMobilePlayer.v(0L, seriesMobilePlayer.f2019n0);
                } else {
                    seriesMobilePlayer.B(0L, seriesMobilePlayer.f2019n0);
                }
                seriesMobilePlayer.E0.removeCallbacks(seriesMobilePlayer.A0);
                seriesMobilePlayer.z();
                break;
            case 1:
            default:
                SeriesMobilePlayer seriesMobilePlayer2 = this.f2948p;
                if (seriesMobilePlayer2.f2017l0 != null && seriesMobilePlayer2.f2018m0 < r1.size() - 1) {
                    seriesMobilePlayer2.f2018m0++;
                    seriesMobilePlayer2.C();
                    seriesMobilePlayer2.A(seriesMobilePlayer2.f2018m0);
                    break;
                }
                break;
            case 2:
                SeriesMobilePlayer seriesMobilePlayer3 = this.f2948p;
                seriesMobilePlayer3.E0.removeCallbacks(seriesMobilePlayer3.A0);
                seriesMobilePlayer3.f2011e0.setVisibility(0);
                seriesMobilePlayer3.z();
                seriesMobilePlayer3.U.requestFocus();
                break;
        }
    }

    @Override // h7.j
    public /* bridge */ /* synthetic */ void f(h7.h hVar, int i10) {
    }

    @Override // h7.j
    public void g(h7.h hVar, boolean z10) {
        SeriesMobilePlayer.u(this.f2948p);
    }

    @Override // h7.j
    public void h(h7.h hVar, int i10) {
        SeriesMobilePlayer seriesMobilePlayer = this.f2948p;
        seriesMobilePlayer.U.setImageResource(R.drawable.ic_pause);
        seriesMobilePlayer.V.setEnabled(true);
        seriesMobilePlayer.Q.setEnabled(true);
        seriesMobilePlayer.X.setEnabled(true);
        seriesMobilePlayer.O.setEnabled(true);
        seriesMobilePlayer.V.setAlpha(1.0f);
        seriesMobilePlayer.Q.setAlpha(1.0f);
        seriesMobilePlayer.X.setAlpha(1.0f);
        seriesMobilePlayer.O.setAlpha(1.0f);
        long j10 = seriesMobilePlayer.H0;
        if (j10 <= 0) {
            y0 y0Var = seriesMobilePlayer.G0;
            j10 = y0Var != null ? y0Var.b() : 0L;
        }
        seriesMobilePlayer.H0 = 0L;
        if (seriesMobilePlayer.isFinishing() || seriesMobilePlayer.isDestroyed()) {
            return;
        }
        try {
            String str = seriesMobilePlayer.f2019n0;
            if (str == null || str.trim().isEmpty()) {
                return;
            }
            seriesMobilePlayer.B(j10 > 0 ? j10 : 0L, seriesMobilePlayer.f2019n0);
        } catch (Exception e7) {
            l1.b.g("CAST_BACK_ERROR", "فشل الرجوع للجوال: " + e7.getMessage());
        }
    }

    @Override // h7.j
    public void i(h7.h hVar, String str) {
        SeriesMobilePlayer seriesMobilePlayer = this.f2948p;
        seriesMobilePlayer.U.setImageResource(R.drawable.ic_pause);
        seriesMobilePlayer.V.setEnabled(false);
        seriesMobilePlayer.Q.setEnabled(false);
        seriesMobilePlayer.X.setEnabled(false);
        seriesMobilePlayer.O.setEnabled(false);
        seriesMobilePlayer.V.setAlpha(0.3f);
        seriesMobilePlayer.Q.setAlpha(0.3f);
        seriesMobilePlayer.X.setAlpha(0.3f);
        seriesMobilePlayer.O.setAlpha(0.3f);
        SeriesMobilePlayer.u(seriesMobilePlayer);
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
}
