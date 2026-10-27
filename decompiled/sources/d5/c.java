package d5;

import android.view.View;
import app.shamel.tv.activities.MovieActivity;
import app.shamel.tv.activities.MovieSecondActivity;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements View.OnLongClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4076o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f4077p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Serializable f4078q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ b4.f0 f4079r;

    public /* synthetic */ c(b4.f0 f0Var, Serializable serializable, int i10, int i11) {
        this.f4076o = i11;
        this.f4079r = f0Var;
        this.f4078q = serializable;
        this.f4077p = i10;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        switch (this.f4076o) {
            case 0:
                ((app.shamel.tv.activities.a) ((e) this.f4079r).g).d((String) this.f4078q, Integer.valueOf(this.f4077p), Boolean.FALSE, Boolean.TRUE);
                break;
            case 1:
                ((ya.r) ((e) this.f4079r).g).d((EPGChannel) this.f4078q, Integer.valueOf(this.f4077p), Boolean.FALSE, Boolean.TRUE);
                break;
            case 2:
                x0 x0Var = (x0) this.f4079r;
                SeriesModel seriesModel = (SeriesModel) this.f4078q;
                boolean is_favorite = seriesModel.is_favorite();
                final int i10 = this.f4077p;
                if (!is_favorite) {
                    final a6.n nVar = (a6.n) x0Var.f4220k;
                    switch (nVar.f73o) {
                        case 11:
                            final int i11 = 1;
                            a6.n.K().j(seriesModel.getName(), true, new app.shamel.tv.helper.s() { // from class: app.shamel.tv.activities.t0
                                @Override // app.shamel.tv.helper.s
                                public final void j() {
                                    switch (i11) {
                                        case 0:
                                            SeriesActivity seriesActivity = (SeriesActivity) nVar.f74p;
                                            seriesActivity.U.e(i10);
                                            seriesActivity.R.Z(a6.n.K().v());
                                            break;
                                        default:
                                            SeriesActivity seriesActivity2 = (SeriesActivity) nVar.f74p;
                                            seriesActivity2.U.e(i10);
                                            seriesActivity2.R.Z(a6.n.K().v());
                                            break;
                                    }
                                }
                            });
                            break;
                        default:
                            final int i12 = 0;
                            a6.n.K().j(seriesModel.getName(), true, new app.shamel.tv.helper.s() { // from class: app.shamel.tv.activities.x0
                                @Override // app.shamel.tv.helper.s
                                public final void j() {
                                    switch (i12) {
                                        case 0:
                                            SeriesSecondActivity seriesSecondActivity = (SeriesSecondActivity) nVar.f74p;
                                            seriesSecondActivity.Q.e(i10);
                                            seriesSecondActivity.O.Z(a6.n.K().v());
                                            break;
                                        default:
                                            SeriesSecondActivity seriesSecondActivity2 = (SeriesSecondActivity) nVar.f74p;
                                            seriesSecondActivity2.Q.e(i10);
                                            seriesSecondActivity2.O.Z(a6.n.K().v());
                                            break;
                                    }
                                }
                            });
                            break;
                    }
                } else {
                    final a6.n nVar2 = (a6.n) x0Var.f4220k;
                    switch (nVar2.f73o) {
                        case 11:
                            final int i13 = 0;
                            a6.n.K().j(seriesModel.getName(), false, new app.shamel.tv.helper.s() { // from class: app.shamel.tv.activities.t0
                                @Override // app.shamel.tv.helper.s
                                public final void j() {
                                    switch (i13) {
                                        case 0:
                                            SeriesActivity seriesActivity = (SeriesActivity) nVar2.f74p;
                                            seriesActivity.U.e(i10);
                                            seriesActivity.R.Z(a6.n.K().v());
                                            break;
                                        default:
                                            SeriesActivity seriesActivity2 = (SeriesActivity) nVar2.f74p;
                                            seriesActivity2.U.e(i10);
                                            seriesActivity2.R.Z(a6.n.K().v());
                                            break;
                                    }
                                }
                            });
                            break;
                        default:
                            final int i14 = 1;
                            a6.n.K().j(seriesModel.getName(), false, new app.shamel.tv.helper.s() { // from class: app.shamel.tv.activities.x0
                                @Override // app.shamel.tv.helper.s
                                public final void j() {
                                    switch (i14) {
                                        case 0:
                                            SeriesSecondActivity seriesSecondActivity = (SeriesSecondActivity) nVar2.f74p;
                                            seriesSecondActivity.Q.e(i10);
                                            seriesSecondActivity.O.Z(a6.n.K().v());
                                            break;
                                        default:
                                            SeriesSecondActivity seriesSecondActivity2 = (SeriesSecondActivity) nVar2.f74p;
                                            seriesSecondActivity2.Q.e(i10);
                                            seriesSecondActivity2.O.Z(a6.n.K().v());
                                            break;
                                    }
                                }
                            });
                            break;
                    }
                }
            default:
                x0 x0Var2 = (x0) this.f4079r;
                MovieModel movieModel = (MovieModel) this.f4078q;
                boolean isIs_favorite = movieModel.isIs_favorite();
                final int i15 = this.f4077p;
                if (!isIs_favorite) {
                    final a6.n nVar3 = (a6.n) x0Var2.f4220k;
                    switch (nVar3.f73o) {
                        case 9:
                            ArrayList arrayList = e5.l.f4607b;
                            MovieActivity movieActivity = (MovieActivity) nVar3.f74p;
                            if (!arrayList.contains(((CategoryModel) movieActivity.N.get(movieActivity.f1729g0)).getId())) {
                                final int i16 = 0;
                                a6.n.K().i(movieModel.getName(), true, new app.shamel.tv.helper.s() { // from class: app.shamel.tv.activities.g0
                                    @Override // app.shamel.tv.helper.s
                                    public final void j() {
                                        switch (i16) {
                                            case 0:
                                                MovieActivity movieActivity2 = (MovieActivity) nVar3.f74p;
                                                movieActivity2.f1726d0.e(i15);
                                                movieActivity2.S.d0(a6.n.K().u());
                                                break;
                                            default:
                                                MovieActivity movieActivity3 = (MovieActivity) nVar3.f74p;
                                                movieActivity3.f1726d0.e(i15);
                                                movieActivity3.S.d0(a6.n.K().u());
                                                break;
                                        }
                                    }
                                });
                                break;
                            }
                            break;
                        default:
                            ArrayList arrayList2 = e5.l.f4607b;
                            MovieSecondActivity movieSecondActivity = (MovieSecondActivity) nVar3.f74p;
                            if (!arrayList2.contains(((CategoryModel) movieSecondActivity.M.get(movieSecondActivity.f1781b0)).getId())) {
                                final int i17 = 0;
                                a6.n.K().i(movieModel.getName(), true, new app.shamel.tv.helper.s() { // from class: app.shamel.tv.activities.o0
                                    @Override // app.shamel.tv.helper.s
                                    public final void j() {
                                        switch (i17) {
                                            case 0:
                                                MovieSecondActivity movieSecondActivity2 = (MovieSecondActivity) nVar3.f74p;
                                                movieSecondActivity2.Y.e(i15);
                                                movieSecondActivity2.P.d0(a6.n.K().u());
                                                break;
                                            default:
                                                MovieSecondActivity movieSecondActivity3 = (MovieSecondActivity) nVar3.f74p;
                                                movieSecondActivity3.Y.e(i15);
                                                movieSecondActivity3.P.d0(a6.n.K().u());
                                                break;
                                        }
                                    }
                                });
                                break;
                            }
                            break;
                    }
                } else {
                    final a6.n nVar4 = (a6.n) x0Var2.f4220k;
                    switch (nVar4.f73o) {
                        case 9:
                            final int i18 = 1;
                            a6.n.K().i(movieModel.getName(), false, new app.shamel.tv.helper.s() { // from class: app.shamel.tv.activities.g0
                                @Override // app.shamel.tv.helper.s
                                public final void j() {
                                    switch (i18) {
                                        case 0:
                                            MovieActivity movieActivity2 = (MovieActivity) nVar4.f74p;
                                            movieActivity2.f1726d0.e(i15);
                                            movieActivity2.S.d0(a6.n.K().u());
                                            break;
                                        default:
                                            MovieActivity movieActivity3 = (MovieActivity) nVar4.f74p;
                                            movieActivity3.f1726d0.e(i15);
                                            movieActivity3.S.d0(a6.n.K().u());
                                            break;
                                    }
                                }
                            });
                            break;
                        default:
                            final int i19 = 1;
                            a6.n.K().i(movieModel.getName(), false, new app.shamel.tv.helper.s() { // from class: app.shamel.tv.activities.o0
                                @Override // app.shamel.tv.helper.s
                                public final void j() {
                                    switch (i19) {
                                        case 0:
                                            MovieSecondActivity movieSecondActivity2 = (MovieSecondActivity) nVar4.f74p;
                                            movieSecondActivity2.Y.e(i15);
                                            movieSecondActivity2.P.d0(a6.n.K().u());
                                            break;
                                        default:
                                            MovieSecondActivity movieSecondActivity3 = (MovieSecondActivity) nVar4.f74p;
                                            movieSecondActivity3.Y.e(i15);
                                            movieSecondActivity3.P.d0(a6.n.K().u());
                                            break;
                                    }
                                }
                            });
                            break;
                    }
                }
        }
        return true;
    }
}
