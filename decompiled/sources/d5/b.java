package d5;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import app.shamel.tv.activities.MovieActivity;
import app.shamel.tv.activities.MovieInfoActivity;
import app.shamel.tv.activities.MoviePlayerActivity;
import app.shamel.tv.activities.MovieSecondActivity;
import app.shamel.tv.activities.SeasonActivity;
import app.shamel.tv.activities.SeriesActivity;
import app.shamel.tv.activities.SeriesInfoActivity;
import app.shamel.tv.activities.SeriesSecondActivity;
import app.shamel.tv.activities.mobile.MovieMobilePlayer;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.CatchUpEpg;
import app.shamel.tv.models.CatchupModel;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.MovieCreditModel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import java.io.Serializable;
import java.util.ArrayList;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4062o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f4063p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Serializable f4064q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ b4.f0 f4065r;

    public /* synthetic */ b(b4.f0 f0Var, int i10, Serializable serializable, int i11) {
        this.f4062o = i11;
        this.f4065r = f0Var;
        this.f4063p = i10;
        this.f4064q = serializable;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        String str2;
        boolean z10;
        androidx.fragment.app.a i10;
        androidx.fragment.app.s A;
        switch (this.f4062o) {
            case 0:
                e eVar = (e) this.f4065r;
                int i11 = eVar.f4086e;
                int i12 = this.f4063p;
                eVar.f4086e = i12;
                if (i11 != -1) {
                    eVar.e(i11);
                }
                eVar.e(i12);
                ((app.shamel.tv.activities.a) eVar.g).d((String) this.f4064q, Integer.valueOf(i12), Boolean.TRUE, Boolean.FALSE);
                break;
            case 1:
                g gVar = (g) this.f4065r;
                boolean[] zArr = (boolean[]) gVar.f4101e;
                int i13 = this.f4063p;
                zArr[i13] = !zArr[i13];
                gVar.e(i13);
                ((ya.q) gVar.f4102f).c((EPGChannel) this.f4064q, Integer.valueOf(i13), Boolean.valueOf(((boolean[]) gVar.f4101e)[i13]));
                break;
            case 2:
                e eVar2 = (e) this.f4065r;
                int i14 = eVar2.f4086e;
                int i15 = this.f4063p;
                eVar2.f4086e = i15;
                if (i14 != -1) {
                    eVar2.e(i14);
                }
                eVar2.e(eVar2.f4086e);
                ((app.shamel.tv.activities.f) eVar2.g).c((CatchupModel) this.f4064q, Integer.valueOf(i15), Boolean.TRUE);
                break;
            case 3:
                ((app.shamel.tv.activities.f) ((r) this.f4065r).f4176h).c((EpisodeModel) this.f4064q, Integer.valueOf(this.f4063p), Boolean.TRUE);
                break;
            case 4:
                ((t) this.f4065r).f4188d.c((EpisodeModel) this.f4064q, Integer.valueOf(this.f4063p), Boolean.TRUE);
                break;
            case 5:
                e eVar3 = (e) this.f4065r;
                int i16 = eVar3.f4086e;
                eVar3.f4086e = this.f4063p;
                eVar3.e(i16);
                eVar3.e(eVar3.f4086e);
                ((app.shamel.tv.activities.h0) eVar3.g).f1896p.u((MovieCreditModel) this.f4064q);
                break;
            case 6:
                ((c0) this.f4065r).f4081e.c((String) this.f4064q, Integer.valueOf(this.f4063p), Boolean.TRUE);
                break;
            case 7:
                ((h5.l) ((r) this.f4065r).f4176h).b((EpisodeModel) this.f4064q, Integer.valueOf(this.f4063p));
                break;
            case 8:
                ((app.shamel.tv.activities.b) ((e) this.f4065r).g).c((CatchUpEpg) this.f4064q, Integer.valueOf(this.f4063p), Boolean.TRUE);
                break;
            case 9:
                n0 n0Var = (n0) this.f4065r;
                int i17 = n0Var.f4147l;
                int i18 = this.f4063p;
                n0Var.f4147l = i18;
                n0Var.e(i17);
                n0Var.e(n0Var.f4147l);
                n0Var.f4141e.c((CategoryModel) this.f4064q, Integer.valueOf(i18), Boolean.TRUE);
                break;
            case 10:
                e eVar4 = (e) this.f4065r;
                int i19 = eVar4.f4086e;
                int i20 = this.f4063p;
                eVar4.f4086e = i20;
                eVar4.e(i19);
                eVar4.e(eVar4.f4086e);
                ((ya.r) eVar4.g).d((EPGChannel) this.f4064q, Integer.valueOf(i20), Boolean.TRUE, Boolean.FALSE);
                break;
            case 11:
                ((app.shamel.tv.activities.p0) ((k) this.f4065r).f4124e).c((EPGChannel) this.f4064q, Integer.valueOf(this.f4063p), Boolean.TRUE);
                break;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                ((app.shamel.tv.activities.p0) ((k) this.f4065r).f4124e).c((SeriesModel) this.f4064q, Integer.valueOf(this.f4063p), Boolean.TRUE);
                break;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                t0 t0Var = (t0) this.f4065r;
                int i21 = t0Var.f4198j;
                int i22 = this.f4063p;
                t0Var.f4198j = i22;
                t0Var.e(i21);
                t0Var.e(t0Var.f4198j);
                t0Var.f4194e.c((CategoryModel) this.f4064q, Integer.valueOf(i22), Boolean.TRUE);
                break;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                ((app.shamel.tv.activities.p0) ((k) this.f4065r).f4124e).c((MovieModel) this.f4064q, Integer.valueOf(this.f4063p), Boolean.TRUE);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                x0 x0Var = (x0) this.f4065r;
                int i23 = x0Var.f4219j;
                int i24 = this.f4063p;
                x0Var.f4219j = i24;
                x0Var.e(i23);
                x0Var.e(i24);
                a6.n nVar = (a6.n) x0Var.f4220k;
                SeriesModel seriesModel = (SeriesModel) this.f4064q;
                switch (nVar.f73o) {
                    case 11:
                        SeriesActivity seriesActivity = (SeriesActivity) nVar.f74p;
                        if (!((CategoryModel) seriesActivity.N.get(seriesActivity.f1802g0)).getId().equalsIgnoreCase("resume_id")) {
                            Intent intent = new Intent(seriesActivity, (Class<?>) SeriesInfoActivity.class);
                            intent.putExtra("series_id", seriesModel.getSeries_id());
                            intent.putExtra("name", seriesModel.getName());
                            if (seriesActivity.R.g()) {
                                intent.putExtra("category_name", seriesModel.getCategory_name());
                            } else {
                                String category_id = seriesModel.getCategory_id();
                                ArrayList arrayList = LTVApp.f2088w;
                                int size = arrayList.size();
                                int i25 = 0;
                                while (true) {
                                    if (i25 < size) {
                                        Object obj = arrayList.get(i25);
                                        i25++;
                                        CategoryModel categoryModel = (CategoryModel) obj;
                                        if (category_id.equalsIgnoreCase(categoryModel.getId())) {
                                            str = categoryModel.getName();
                                        }
                                    } else {
                                        str = "UnNamed Category";
                                    }
                                }
                                intent.putExtra("category_name", str);
                            }
                            seriesActivity.startActivity(intent);
                            break;
                        } else {
                            Intent intent2 = new Intent(seriesActivity, (Class<?>) SeasonActivity.class);
                            intent2.putExtra("series_name", seriesModel.getName());
                            intent2.putExtra("series_id", seriesModel.getSeries_id());
                            seriesActivity.startActivity(intent2);
                            break;
                        }
                    default:
                        SeriesSecondActivity seriesSecondActivity = (SeriesSecondActivity) nVar.f74p;
                        if (!((CategoryModel) seriesSecondActivity.M.get(seriesSecondActivity.f1842b0)).getId().equalsIgnoreCase("resume_id")) {
                            Intent intent3 = new Intent(seriesSecondActivity, (Class<?>) SeriesInfoActivity.class);
                            intent3.putExtra("name", seriesModel.getName());
                            intent3.putExtra("series_id", seriesModel.getSeries_id());
                            if (seriesSecondActivity.O.g()) {
                                intent3.putExtra("category_name", seriesModel.getCategory_name());
                            } else {
                                String category_id2 = seriesModel.getCategory_id();
                                ArrayList arrayList2 = LTVApp.f2088w;
                                int size2 = arrayList2.size();
                                int i26 = 0;
                                while (true) {
                                    if (i26 < size2) {
                                        Object obj2 = arrayList2.get(i26);
                                        i26++;
                                        CategoryModel categoryModel2 = (CategoryModel) obj2;
                                        if (category_id2.equalsIgnoreCase(categoryModel2.getId())) {
                                            str2 = categoryModel2.getName();
                                        }
                                    } else {
                                        str2 = "UnNamed Category";
                                    }
                                }
                                intent3.putExtra("category_name", str2);
                            }
                            seriesSecondActivity.startActivity(intent3);
                            break;
                        } else {
                            Intent intent4 = new Intent(seriesSecondActivity, (Class<?>) SeasonActivity.class);
                            intent4.putExtra("series_name", seriesModel.getName());
                            intent4.putExtra("series_id", seriesModel.getSeries_id());
                            seriesSecondActivity.startActivity(intent4);
                            break;
                        }
                }
            default:
                x0 x0Var2 = (x0) this.f4065r;
                int i27 = x0Var2.f4219j;
                x0Var2.f4219j = this.f4063p;
                x0Var2.e(i27);
                x0Var2.e(x0Var2.f4219j);
                a6.n nVar2 = (a6.n) x0Var2.f4220k;
                MovieModel movieModel = (MovieModel) this.f4064q;
                try {
                    switch (nVar2.f73o) {
                        case 9:
                            MovieActivity movieActivity = (MovieActivity) nVar2.f74p;
                            if (movieActivity.f1729g0 <= 1) {
                                String lowerCase = movieModel.getCategory_name().toLowerCase();
                                z10 = false;
                                if (movieActivity.S.g() ? lowerCase.contains("xxx") || lowerCase.contains("porn") || lowerCase.contains("adult") : e5.l.f4607b.contains(movieModel.getCategory_id())) {
                                    androidx.fragment.app.j0 n10 = movieActivity.n();
                                    i10 = android.support.v4.media.d.i(n10, n10);
                                    A = n10.A("fragment_lock");
                                    if (A == null) {
                                        h5.h0 N = h5.h0.N(movieActivity.S.u());
                                        N.f5607z0 = new x4.r(movieActivity, movieModel, 2);
                                        N.M(n10, "fragment_lock");
                                        break;
                                    }
                                }
                            }
                            if (!((CategoryModel) movieActivity.N.get(movieActivity.f1729g0)).getId().equalsIgnoreCase("resume_id")) {
                                Intent intent5 = new Intent(movieActivity, (Class<?>) MovieInfoActivity.class);
                                intent5.putExtra("name", movieModel.getName());
                                intent5.putExtra("stream_id", movieModel.getStream_id());
                                if (movieActivity.S.g()) {
                                    intent5.putExtra("category_name", movieModel.getCategory_name());
                                } else {
                                    intent5.putExtra("category_name", MovieActivity.u(movieModel.getCategory_id()));
                                }
                                movieActivity.startActivity(intent5);
                                break;
                            } else {
                                int f10 = movieActivity.S.f();
                                String url = movieActivity.S.g() ? movieModel.getUrl() : app.shamel.tv.helper.a.h(movieActivity.S.B(), movieActivity.S.I(), movieActivity.S.v(), movieModel.getStream_id(), movieModel.getExtension());
                                if (f10 != 0) {
                                    if (f10 != 1) {
                                        if (f10 == 2) {
                                            x4.e j10 = k5.j.j(movieActivity);
                                            if (j10 == null) {
                                                movieActivity.w(2);
                                                break;
                                            } else {
                                                String str3 = (String) j10.f13543q;
                                                String str4 = (String) j10.f13542p;
                                                Uri parse = Uri.parse(url);
                                                Intent intent6 = new Intent("android.intent.action.VIEW");
                                                intent6.setPackage(str3);
                                                intent6.setClassName(str3, str4);
                                                intent6.setDataAndType(parse, "application/x-mpegURL");
                                                movieActivity.startActivity(intent6);
                                                break;
                                            }
                                        }
                                    } else if (k5.j.l(movieActivity) == null) {
                                        movieActivity.w(1);
                                        break;
                                    } else {
                                        String name = movieModel.getName();
                                        Uri parse2 = Uri.parse(url);
                                        Intent intent7 = new Intent("android.intent.action.VIEW");
                                        intent7.setPackage("org.videolan.vlc");
                                        intent7.setDataAndTypeAndNormalize(parse2, "video/*");
                                        intent7.putExtra("title", name);
                                        intent7.putExtra("from_start", true);
                                        intent7.putExtra("position", 90000L);
                                        intent7.setComponent(new ComponentName("org.videolan.vlc", "org.videolan.vlc.gui.video.VideoPlayerActivity"));
                                        movieActivity.startActivity(intent7);
                                        break;
                                    }
                                } else {
                                    Intent intent8 = app.shamel.tv.helper.a.l(movieActivity) ? new Intent(movieActivity, (Class<?>) MoviePlayerActivity.class) : new Intent(movieActivity, (Class<?>) MovieMobilePlayer.class);
                                    intent8.putExtra("name", movieModel.getName());
                                    intent8.putExtra("stream_id", movieModel.getStream_id());
                                    intent8.putExtra("description", _UrlKt.FRAGMENT_ENCODE_SET);
                                    intent8.putExtra("category_name", movieActivity.S.g() ? movieModel.getCategory_name() : MovieActivity.u(movieModel.getCategory_id()));
                                    movieActivity.startActivity(intent8);
                                    break;
                                }
                            }
                            break;
                        default:
                            MovieSecondActivity movieSecondActivity = (MovieSecondActivity) nVar2.f74p;
                            if (movieSecondActivity.f1781b0 <= 1) {
                                String lowerCase2 = movieModel.getCategory_name().toLowerCase();
                                z10 = false;
                                if (movieSecondActivity.P.g() ? lowerCase2.contains("xxx") || lowerCase2.contains("porn") || lowerCase2.contains("adult") : e5.l.f4607b.contains(movieModel.getCategory_id())) {
                                    androidx.fragment.app.j0 n11 = movieSecondActivity.n();
                                    i10 = android.support.v4.media.d.i(n11, n11);
                                    A = n11.A("fragment_lock");
                                    if (A == null) {
                                        h5.h0 N2 = h5.h0.N(movieSecondActivity.P.u());
                                        N2.f5607z0 = new x4.c(movieSecondActivity, movieModel, 3, false);
                                        N2.M(n11, "fragment_lock");
                                        break;
                                    }
                                }
                            }
                            if (!((CategoryModel) movieSecondActivity.M.get(movieSecondActivity.f1781b0)).getId().equalsIgnoreCase("resume_id")) {
                                Intent intent9 = new Intent(movieSecondActivity, (Class<?>) MovieInfoActivity.class);
                                intent9.putExtra("name", movieModel.getName());
                                intent9.putExtra("stream_id", movieModel.getStream_id());
                                if (movieSecondActivity.P.g()) {
                                    intent9.putExtra("category_name", movieModel.getCategory_name());
                                } else {
                                    intent9.putExtra("category_name", MovieSecondActivity.u(movieModel.getCategory_id()));
                                }
                                movieSecondActivity.startActivity(intent9);
                                break;
                            } else {
                                int f11 = movieSecondActivity.P.f();
                                String url2 = movieSecondActivity.P.g() ? movieModel.getUrl() : app.shamel.tv.helper.a.h(movieSecondActivity.P.B(), movieSecondActivity.P.I(), movieSecondActivity.P.v(), movieModel.getStream_id(), movieModel.getExtension());
                                if (f11 != 0) {
                                    if (f11 != 1) {
                                        if (f11 == 2) {
                                            x4.e j11 = k5.j.j(movieSecondActivity);
                                            if (j11 == null) {
                                                movieSecondActivity.w(2);
                                                break;
                                            } else {
                                                String str5 = (String) j11.f13543q;
                                                String str6 = (String) j11.f13542p;
                                                Uri parse3 = Uri.parse(url2);
                                                Intent intent10 = new Intent("android.intent.action.VIEW");
                                                intent10.setPackage(str5);
                                                intent10.setClassName(str5, str6);
                                                intent10.setDataAndType(parse3, "application/x-mpegURL");
                                                movieSecondActivity.startActivity(intent10);
                                                break;
                                            }
                                        }
                                    } else if (k5.j.l(movieSecondActivity) == null) {
                                        movieSecondActivity.w(1);
                                        break;
                                    } else {
                                        String name2 = movieModel.getName();
                                        Uri parse4 = Uri.parse(url2);
                                        Intent intent11 = new Intent("android.intent.action.VIEW");
                                        intent11.setPackage("org.videolan.vlc");
                                        intent11.setDataAndTypeAndNormalize(parse4, "video/*");
                                        intent11.putExtra("title", name2);
                                        intent11.putExtra("from_start", true);
                                        intent11.putExtra("position", 90000L);
                                        intent11.setComponent(new ComponentName("org.videolan.vlc", "org.videolan.vlc.gui.video.VideoPlayerActivity"));
                                        movieSecondActivity.startActivity(intent11);
                                        break;
                                    }
                                } else {
                                    Intent intent12 = app.shamel.tv.helper.a.l(movieSecondActivity) ? new Intent(movieSecondActivity, (Class<?>) MoviePlayerActivity.class) : new Intent(movieSecondActivity, (Class<?>) MovieMobilePlayer.class);
                                    intent12.putExtra("name", movieModel.getName());
                                    intent12.putExtra("stream_id", movieModel.getStream_id());
                                    intent12.putExtra("description", _UrlKt.FRAGMENT_ENCODE_SET);
                                    intent12.putExtra("category_name", movieSecondActivity.P.g() ? movieModel.getCategory_name() : MovieSecondActivity.u(movieModel.getCategory_id()));
                                    movieSecondActivity.startActivity(intent12);
                                    break;
                                }
                            }
                            break;
                    }
                    android.support.v4.media.d.v(i10, A, z10);
                    break;
                } catch (ActivityNotFoundException unused) {
                    return;
                }
                break;
        }
    }

    public /* synthetic */ b(b4.f0 f0Var, Serializable serializable, int i10, int i11) {
        this.f4062o = i11;
        this.f4065r = f0Var;
        this.f4064q = serializable;
        this.f4063p = i10;
    }
}
