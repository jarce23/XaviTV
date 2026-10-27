package app.shamel.tv.activities;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
import app.shamel.tv.activities.mobile.SeriesMobilePlayer;
import app.shamel.tv.models.AppInfoModel;
import app.shamel.tv.models.CastModel;
import app.shamel.tv.models.CatchUpEpg;
import app.shamel.tv.models.CatchupModel;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.Season;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements ya.q {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1884o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f1885p;

    public /* synthetic */ f(int i10, Object obj) {
        this.f1884o = i10;
        this.f1885p = obj;
    }

    @Override // ya.q
    public final Object c(Object obj, Serializable serializable, Serializable serializable2) {
        int i10 = this.f1884o;
        Object obj2 = this.f1885p;
        switch (i10) {
            case 0:
                CatchupModel catchupModel = (CatchupModel) obj;
                Integer num = (Integer) serializable;
                CatchUpActivity catchUpActivity = (CatchUpActivity) obj2;
                if (((Boolean) serializable2).booleanValue()) {
                    catchUpActivity.Q = catchupModel.getEpgEvents();
                    int i11 = -1;
                    for (int i12 = 0; i12 < catchUpActivity.Q.size(); i12++) {
                        if (((CatchUpEpg) catchUpActivity.Q.get(i12)).getNow_playing() == 1) {
                            i11 = i12;
                        }
                    }
                    if (i11 == -1) {
                        catchUpActivity.f1578b0 = 0;
                    } else {
                        catchUpActivity.f1578b0 = i11;
                    }
                    d5.e eVar = catchUpActivity.W;
                    eVar.f4087f = catchUpActivity.Q;
                    eVar.d();
                    catchUpActivity.T.setSelectedPosition(catchUpActivity.f1578b0);
                    d5.e eVar2 = catchUpActivity.W;
                    int i13 = catchUpActivity.f1578b0;
                    eVar2.getClass();
                    eVar2.e(i13);
                    d5.e eVar3 = catchUpActivity.W;
                    eVar3.f4086e = i11;
                    eVar3.e(i11);
                }
                catchUpActivity.f1577a0 = num.intValue();
                break;
            case 1:
                CategoryModel categoryModel = (CategoryModel) obj;
                Integer num2 = (Integer) serializable;
                LiveActivity liveActivity = (LiveActivity) obj2;
                liveActivity.f1655e1 = num2.intValue();
                if (((Boolean) serializable2).booleanValue()) {
                    if (num2.intValue() == 0) {
                        if (((CategoryModel) liveActivity.Q.get(liveActivity.f1651c1)).getId().equalsIgnoreCase("resume_id") && liveActivity.C0 != null) {
                            liveActivity.K();
                        }
                        liveActivity.J();
                        liveActivity.f1671n1.z(new Intent(liveActivity, (Class<?>) AddGroupActivity.class));
                        break;
                    } else if (liveActivity.f1651c1 != num2.intValue()) {
                        liveActivity.f1648b0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
                        if (!e5.l.f4606a.contains(categoryModel.getId()) && !categoryModel.getId().equalsIgnoreCase("lock_id")) {
                            liveActivity.f1651c1 = num2.intValue();
                            liveActivity.f1669m1 = (liveActivity.f1651c1 + 1) + " • Group : " + ((CategoryModel) liveActivity.Q.get(liveActivity.f1651c1)).getName();
                            int i14 = liveActivity.f1651c1;
                            if (i14 <= 4 || i14 >= liveActivity.f1682x0.s().size() + 5) {
                                io.realm.n0 w10 = a6.n.K().w(categoryModel, _UrlKt.FRAGMENT_ENCODE_SET, liveActivity.f1682x0.g(), liveActivity.f1682x0.o());
                                liveActivity.X = w10;
                                liveActivity.R.q(-1, w10);
                                liveActivity.f1684z0.setSelectedPosition(0);
                                break;
                            } else if (liveActivity.f1682x0.s().size() > 0) {
                                a6.n K = a6.n.K();
                                app.shamel.tv.helper.r rVar = liveActivity.f1682x0;
                                io.realm.n0 s10 = K.s(_UrlKt.FRAGMENT_ENCODE_SET, rVar.t((String) rVar.s().get(liveActivity.f1651c1 - 5)));
                                liveActivity.X = s10;
                                liveActivity.R.q(-1, s10);
                                liveActivity.f1684z0.setSelectedPosition(0);
                                break;
                            }
                        } else if (categoryModel.getId().equalsIgnoreCase("lock_id")) {
                            if (liveActivity.f1682x0.n().size() > 0) {
                                LiveActivity.u(liveActivity, num2.intValue());
                                break;
                            } else {
                                liveActivity.f1651c1 = num2.intValue();
                                Toast.makeText(liveActivity, liveActivity.f1649b1.getStr_no_lock_channels(), 0).show();
                                break;
                            }
                        } else {
                            LiveActivity.u(liveActivity, num2.intValue());
                            break;
                        }
                    }
                }
                break;
            case 2:
                CategoryModel categoryModel2 = (CategoryModel) obj;
                Integer num3 = (Integer) serializable;
                MovieActivity movieActivity = (MovieActivity) obj2;
                movieActivity.f1730i0 = num3.intValue();
                if (((Boolean) serializable2).booleanValue() && movieActivity.f1729g0 != num3.intValue()) {
                    if (e5.l.f4607b.contains(categoryModel2.getId())) {
                        int intValue = num3.intValue();
                        androidx.fragment.app.j0 n10 = movieActivity.n();
                        androidx.fragment.app.a i15 = android.support.v4.media.d.i(n10, n10);
                        androidx.fragment.app.s A = n10.A("fragment_lock");
                        if (A != null) {
                            android.support.v4.media.d.v(i15, A, false);
                            break;
                        } else {
                            h5.h0 N = h5.h0.N(movieActivity.S.u());
                            N.f5607z0 = new app.shamel.tv.b(intValue, 2, movieActivity);
                            N.M(n10, "fragment_lock");
                            break;
                        }
                    } else {
                        movieActivity.f1729g0 = num3.intValue();
                        movieActivity.O.setText(_UrlKt.FRAGMENT_ENCODE_SET);
                        movieActivity.R = a6.n.K().A(categoryModel2, _UrlKt.FRAGMENT_ENCODE_SET, movieActivity.S.g(), movieActivity.h0);
                        movieActivity.X.setText(categoryModel2.getName() + "(" + movieActivity.R.size() + ")");
                        movieActivity.f1726d0.p(movieActivity.R);
                        d5.x0 x0Var = movieActivity.f1726d0;
                        int i16 = x0Var.f4219j;
                        x0Var.f4219j = -1;
                        x0Var.e(i16);
                        x0Var.e(x0Var.f4219j);
                        movieActivity.U.setSelectedPosition(0);
                        break;
                    }
                }
                break;
            case 3:
                CastModel castModel = (CastModel) obj;
                MovieInfoActivity movieInfoActivity = (MovieInfoActivity) obj2;
                if (((Boolean) serializable2).booleanValue() && castModel.getId() > 0) {
                    Intent intent = new Intent(movieInfoActivity, (Class<?>) MovieCreditActivity.class);
                    intent.putExtra("person_id", castModel.getId());
                    intent.putExtra("name", movieInfoActivity.T.getName());
                    movieInfoActivity.startActivity(intent);
                    break;
                }
                break;
            case 4:
                EpisodeModel episodeModel = (EpisodeModel) obj;
                Integer num4 = (Integer) serializable;
                SeasonActivity seasonActivity = (SeasonActivity) obj2;
                seasonActivity.f1793f0 = num4.intValue();
                if (((Boolean) serializable2).booleanValue()) {
                    a6.n.K().m(seasonActivity.X, true, seasonActivity.f1794g0, num4.intValue(), new k(this));
                    int f10 = seasonActivity.T.f();
                    if (seasonActivity.T.g()) {
                        seasonActivity.f1790c0 = episodeModel.getUrl();
                    } else {
                        seasonActivity.f1790c0 = app.shamel.tv.helper.a.f(seasonActivity.T.B(), seasonActivity.T.I(), seasonActivity.T.v(), episodeModel.getId(), episodeModel.getContainer_extension());
                    }
                    if (f10 == 0) {
                        if (!seasonActivity.T.g()) {
                            app.shamel.tv.helper.r rVar2 = seasonActivity.T;
                            List list = seasonActivity.f1788a0;
                            SharedPreferences.Editor edit = rVar2.f2098b.edit();
                            edit.putString("episode_models", rVar2.f2097a.toJson(list));
                            edit.apply();
                        }
                        Intent intent2 = app.shamel.tv.helper.a.l(seasonActivity) ? new Intent(seasonActivity, (Class<?>) SeriesPlayerActivity.class) : new Intent(seasonActivity, (Class<?>) SeriesMobilePlayer.class);
                        intent2.putExtra("season_pos", seasonActivity.f1794g0);
                        intent2.putExtra("position", num4);
                        intent2.putExtra("series_name", seasonActivity.X);
                        intent2.putExtra("season_name", ((Season) seasonActivity.Z.get(seasonActivity.f1794g0)).getName());
                        intent2.putExtra("tmdb_id", seasonActivity.N.getTmdb());
                        seasonActivity.startActivity(intent2);
                        break;
                    } else if (f10 == 1) {
                        if (k5.j.l(seasonActivity) != null) {
                            String str = seasonActivity.f1790c0;
                            String title = episodeModel.getTitle();
                            Uri parse = Uri.parse(str);
                            Intent intent3 = new Intent("android.intent.action.VIEW");
                            intent3.setPackage("org.videolan.vlc");
                            intent3.setDataAndTypeAndNormalize(parse, "video/*");
                            intent3.putExtra("title", title);
                            intent3.putExtra("from_start", true);
                            intent3.putExtra("position", 90000L);
                            intent3.setComponent(new ComponentName("org.videolan.vlc", "org.videolan.vlc.gui.video.VideoPlayerActivity"));
                            seasonActivity.startActivity(intent3);
                            break;
                        } else {
                            SeasonActivity.u(seasonActivity, 1);
                            break;
                        }
                    } else if (f10 == 2) {
                        x4.e j10 = k5.j.j(seasonActivity);
                        if (j10 != null) {
                            String str2 = (String) j10.f13543q;
                            String str3 = (String) j10.f13542p;
                            try {
                                Uri parse2 = Uri.parse(seasonActivity.f1790c0);
                                Intent intent4 = new Intent("android.intent.action.VIEW");
                                intent4.setPackage(str2);
                                intent4.setClassName(str2, str3);
                                intent4.setDataAndType(parse2, "application/x-mpegURL");
                                seasonActivity.startActivity(intent4);
                                break;
                            } catch (ActivityNotFoundException e7) {
                                Log.e("SeasonActivity", "externalMXplayer", e7);
                                break;
                            }
                        } else {
                            SeasonActivity.u(seasonActivity, 2);
                            break;
                        }
                    }
                }
                break;
            case 5:
                Integer num5 = (Integer) serializable;
                SeriesPlayerActivity seriesPlayerActivity = (SeriesPlayerActivity) obj2;
                if (((Boolean) serializable2).booleanValue()) {
                    if (seriesPlayerActivity.Z != num5.intValue()) {
                        seriesPlayerActivity.A();
                        int intValue2 = num5.intValue();
                        seriesPlayerActivity.Z = intValue2;
                        seriesPlayerActivity.y(intValue2);
                        seriesPlayerActivity.D(false);
                        seriesPlayerActivity.f1821f0.setVisibility(8);
                        break;
                    }
                } else {
                    seriesPlayerActivity.F0 = num5.intValue();
                    seriesPlayerActivity.G0.removeCallbacks(seriesPlayerActivity.f1817b0);
                    seriesPlayerActivity.x();
                    break;
                }
                break;
            case 6:
                CategoryModel categoryModel3 = (CategoryModel) obj;
                Integer num6 = (Integer) serializable;
                LiveMobileActivity liveMobileActivity = (LiveMobileActivity) obj2;
                if (((Boolean) serializable2).booleanValue()) {
                    if (num6.intValue() == 0) {
                        if (((CategoryModel) liveMobileActivity.f1952c0.get(liveMobileActivity.R0)).getId().equalsIgnoreCase("resume_id") && liveMobileActivity.B0 != null) {
                            liveMobileActivity.J();
                        }
                        liveMobileActivity.I();
                        liveMobileActivity.f1963i1.z(new Intent(liveMobileActivity, (Class<?>) AddGroupActivity.class));
                        break;
                    } else if (liveMobileActivity.R0 != num6.intValue()) {
                        liveMobileActivity.f1969n0.setText(_UrlKt.FRAGMENT_ENCODE_SET);
                        if (!e5.l.f4606a.contains(categoryModel3.getId()) && !categoryModel3.getId().equalsIgnoreCase("lock_id")) {
                            liveMobileActivity.R0 = num6.intValue();
                            liveMobileActivity.Y0 = (liveMobileActivity.R0 + 1) + " • Group : " + ((CategoryModel) liveMobileActivity.f1952c0.get(liveMobileActivity.R0)).getName();
                            int i17 = liveMobileActivity.R0;
                            if (i17 <= 4 || i17 >= liveMobileActivity.f1978w0.s().size() + 5) {
                                io.realm.n0 w11 = a6.n.K().w(categoryModel3, _UrlKt.FRAGMENT_ENCODE_SET, liveMobileActivity.f1978w0.g(), liveMobileActivity.f1978w0.o());
                                liveMobileActivity.f1964j0 = w11;
                                liveMobileActivity.f1954d0.q(-1, w11);
                                liveMobileActivity.f1980y0.e0(0);
                                break;
                            } else if (liveMobileActivity.f1978w0.s().size() > 0) {
                                a6.n K2 = a6.n.K();
                                app.shamel.tv.helper.r rVar3 = liveMobileActivity.f1978w0;
                                io.realm.n0 s11 = K2.s(_UrlKt.FRAGMENT_ENCODE_SET, rVar3.t((String) rVar3.s().get(liveMobileActivity.R0 - 5)));
                                liveMobileActivity.f1964j0 = s11;
                                liveMobileActivity.f1954d0.q(-1, s11);
                                liveMobileActivity.f1980y0.e0(0);
                                break;
                            }
                        } else if (categoryModel3.getId().equalsIgnoreCase("lock_id")) {
                            if (liveMobileActivity.f1978w0.n().isEmpty()) {
                                liveMobileActivity.R0 = num6.intValue();
                                Toast.makeText(liveMobileActivity, liveMobileActivity.Q0.getStr_no_lock_channels(), 0).show();
                                break;
                            } else {
                                LiveMobileActivity.v(liveMobileActivity, num6.intValue());
                                break;
                            }
                        } else {
                            LiveMobileActivity.v(liveMobileActivity, num6.intValue());
                            break;
                        }
                    }
                }
                break;
            case 7:
                h5.n nVar = (h5.n) obj2;
                nVar.J(false, false);
                q qVar = nVar.D0;
                int intValue3 = ((Integer) serializable).intValue();
                AppInfoModel.UrlModel urlModel = qVar.f2045b;
                int i18 = qVar.f2044a;
                ChangePlaylistActivity changePlaylistActivity = qVar.f2046c;
                if (intValue3 == 0) {
                    if (!changePlaylistActivity.F0 || changePlaylistActivity.C0 != i18) {
                        changePlaylistActivity.C0 = i18;
                        ChangePlaylistActivity.P(changePlaylistActivity, urlModel);
                        break;
                    } else {
                        changePlaylistActivity.startActivity(new Intent(changePlaylistActivity, (Class<?>) HomeActivity.class));
                        changePlaylistActivity.finish();
                        break;
                    }
                } else if (intValue3 != 1) {
                    if (intValue3 == 2) {
                        int i19 = ChangePlaylistActivity.G0;
                        androidx.fragment.app.j0 n11 = changePlaylistActivity.n();
                        androidx.fragment.app.a i20 = android.support.v4.media.d.i(n11, n11);
                        androidx.fragment.app.s A2 = n11.A("fragment_delete");
                        if (A2 != null) {
                            android.support.v4.media.d.v(i20, A2, false);
                            break;
                        } else {
                            h5.u N2 = h5.u.N(changePlaylistActivity.B0.getDelete_playlist() + "?", changePlaylistActivity.B0.getWant_delete_playlist(), changePlaylistActivity.B0.getStr_yes(), changePlaylistActivity.B0.getNo());
                            N2.B0 = new o(changePlaylistActivity, N2, urlModel);
                            N2.M(n11, "fragment_delete");
                            break;
                        }
                    }
                } else if (urlModel.getIs_protected().equalsIgnoreCase("1")) {
                    Toast.makeText(changePlaylistActivity, changePlaylistActivity.B0.getPlaylist_protected(), 0).show();
                    break;
                } else {
                    ChangePlaylistActivity.Q(changePlaylistActivity, i18);
                    break;
                }
                break;
            case 8:
                Integer num7 = (Integer) serializable;
                h5.x xVar = (h5.x) obj2;
                if (((Boolean) serializable2).booleanValue()) {
                    h5.d dVar = xVar.B0;
                    int intValue4 = num7.intValue();
                    h5.f fVar = dVar.f5589a;
                    fVar.X0 = intValue4;
                    fVar.R0.setText(((CategoryModel) fVar.f5595y0.get(intValue4)).getName());
                    fVar.S0.setText(((CategoryModel) fVar.f5595y0.get(intValue4)).getName());
                    io.realm.n0 w12 = a6.n.K().w((CategoryModel) fVar.f5595y0.get(intValue4), _UrlKt.FRAGMENT_ENCODE_SET, fVar.Y0, 0);
                    fVar.D0 = w12;
                    fVar.C0 = new boolean[w12.size()];
                    for (int i21 = 0; i21 < fVar.D0.size(); i21++) {
                        fVar.C0[i21] = !fVar.W0.contains(((EPGChannel) fVar.D0.get(i21)).getName());
                    }
                    fVar.A0.m(fVar.D0, fVar.C0);
                    if (fVar.D0.size() > 0) {
                        fVar.B0.setSelectedPosition(0);
                    }
                    xVar.J(false, false);
                    break;
                }
                break;
            case 9:
                h5.r0 r0Var = (h5.r0) obj2;
                r0Var.J(false, false);
                d dVar2 = r0Var.A0;
                int intValue5 = ((Integer) serializable).intValue();
                AddGroupActivity addGroupActivity = dVar2.f1877a;
                if (intValue5 == 0) {
                    addGroupActivity.u((String) addGroupActivity.f1573c0.get(addGroupActivity.Z), true);
                    break;
                } else {
                    List a10 = addGroupActivity.S.a();
                    ArrayList arrayList = new ArrayList(a10);
                    int i22 = 0;
                    while (true) {
                        if (i22 < a10.size()) {
                            if (((String) addGroupActivity.f1573c0.get(addGroupActivity.Z)).equalsIgnoreCase(((CategoryModel) a10.get(i22)).getName())) {
                                arrayList.remove(a10.get(i22));
                            } else {
                                i22++;
                            }
                        }
                    }
                    List s12 = addGroupActivity.S.s();
                    ArrayList arrayList2 = new ArrayList(s12);
                    int i23 = 0;
                    while (true) {
                        if (i23 < a10.size()) {
                            if (((String) addGroupActivity.f1573c0.get(addGroupActivity.Z)).equalsIgnoreCase((String) s12.get(i23))) {
                                arrayList2.remove(s12.get(i23));
                            } else {
                                i23++;
                            }
                        }
                    }
                    addGroupActivity.S.U(arrayList2);
                    addGroupActivity.S.R(arrayList);
                    Log.e("changeModelSize", String.valueOf(arrayList.size()));
                    Log.e("myModelSize", String.valueOf(arrayList2.size()));
                    e5.l.a(addGroupActivity, addGroupActivity.S.h());
                    app.shamel.tv.helper.r rVar4 = addGroupActivity.S;
                    String str4 = (String) addGroupActivity.f1573c0.get(addGroupActivity.Z);
                    SharedPreferences.Editor edit2 = rVar4.f2098b.edit();
                    edit2.remove(str4 + rVar4.H());
                    edit2.commit();
                    List list2 = addGroupActivity.f1573c0;
                    list2.remove(list2.get(addGroupActivity.Z));
                    d5.e eVar4 = addGroupActivity.P;
                    eVar4.f4087f = addGroupActivity.f1573c0;
                    eVar4.f4086e = 0;
                    eVar4.d();
                    addGroupActivity.T.setSelectedPosition(0);
                    addGroupActivity.Q.m(new ArrayList());
                    break;
                }
            default:
                EPGChannel ePGChannel = (EPGChannel) obj;
                h5.s0 s0Var = (h5.s0) obj2;
                if (((Boolean) serializable2).booleanValue()) {
                    if (s0Var.P0.contains(ePGChannel.getName())) {
                        s0Var.P0.removeAll(Collections.singletonList(ePGChannel.getName()));
                        break;
                    }
                } else if (!s0Var.P0.contains(ePGChannel.getName())) {
                    s0Var.P0.add(ePGChannel.getName());
                    break;
                }
                break;
        }
        return null;
        return null;
    }
}
