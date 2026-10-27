package app.shamel.tv.activities;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import app.shamel.tv.models.CategoryModel;
import m.o1;
import m.z1;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 implements AdapterView.OnItemSelectedListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1886o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f1887p;

    public /* synthetic */ f0(int i10, Object obj) {
        this.f1886o = i10;
        this.f1887p = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
        o1 o1Var;
        switch (this.f1886o) {
            case 0:
                MovieActivity movieActivity = (MovieActivity) this.f1887p;
                if (movieActivity.h0 != i10) {
                    movieActivity.h0 = i10;
                    SharedPreferences.Editor edit = movieActivity.S.f2098b.edit();
                    edit.putInt("vod_order", i10);
                    edit.apply();
                    movieActivity.f1726d0.p(a6.n.K().A((CategoryModel) movieActivity.N.get(movieActivity.f1729g0), _UrlKt.FRAGMENT_ENCODE_SET, movieActivity.S.g(), movieActivity.h0));
                    movieActivity.U.e0(0);
                    break;
                }
                break;
            case 1:
                MovieSecondActivity movieSecondActivity = (MovieSecondActivity) this.f1887p;
                if (movieSecondActivity.f1782c0 != i10) {
                    movieSecondActivity.f1782c0 = i10;
                    SharedPreferences.Editor edit2 = movieSecondActivity.P.f2098b.edit();
                    edit2.putInt("vod_order", i10);
                    edit2.apply();
                    movieSecondActivity.Y.p(a6.n.K().A((CategoryModel) movieSecondActivity.M.get(movieSecondActivity.f1781b0), _UrlKt.FRAGMENT_ENCODE_SET, movieSecondActivity.P.g(), movieSecondActivity.f1782c0));
                    movieSecondActivity.Q.setSelectedPosition(0);
                    break;
                }
                break;
            case 2:
                SeriesActivity seriesActivity = (SeriesActivity) this.f1887p;
                if (seriesActivity.h0 != i10) {
                    seriesActivity.h0 = i10;
                    SharedPreferences.Editor edit3 = seriesActivity.R.f2098b.edit();
                    edit3.putInt("series_order", i10);
                    edit3.apply();
                    io.realm.n0 D = a6.n.K().D((CategoryModel) seriesActivity.N.get(seriesActivity.f1802g0), _UrlKt.FRAGMENT_ENCODE_SET, seriesActivity.R.g(), seriesActivity.h0);
                    seriesActivity.V = D;
                    seriesActivity.U.p(D);
                    seriesActivity.T.setSelectedPosition(0);
                    break;
                }
                break;
            case 3:
                SeriesSecondActivity seriesSecondActivity = (SeriesSecondActivity) this.f1887p;
                if (seriesSecondActivity.f1843c0 != i10) {
                    seriesSecondActivity.f1843c0 = i10;
                    SharedPreferences.Editor edit4 = seriesSecondActivity.O.f2098b.edit();
                    edit4.putInt("series_order", i10);
                    edit4.apply();
                    io.realm.n0 D2 = a6.n.K().D((CategoryModel) seriesSecondActivity.M.get(seriesSecondActivity.f1842b0), _UrlKt.FRAGMENT_ENCODE_SET, seriesSecondActivity.O.g(), seriesSecondActivity.f1843c0);
                    seriesSecondActivity.R = D2;
                    seriesSecondActivity.Q.p(D2);
                    seriesSecondActivity.P.setSelectedPosition(0);
                    break;
                }
                break;
            default:
                if (i10 != -1 && (o1Var = ((z1) this.f1887p).f8611q) != null) {
                    o1Var.setListSelectionHidden(false);
                    break;
                }
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i10 = this.f1886o;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }

    private final void c(AdapterView adapterView) {
    }

    private final void d(AdapterView adapterView) {
    }

    private final void e(AdapterView adapterView) {
    }
}
