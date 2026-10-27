package app.shamel.tv.activities;

import android.util.Log;
import android.widget.Toast;
import app.shamel.tv.models.Episode;
import app.shamel.tv.models.EpisodeInfoModel;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.Info;
import app.shamel.tv.models.InfoSerie;
import app.shamel.tv.models.Season;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r0 implements m5.l, m5.k, Callback {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ SeasonActivity f2049o;

    public /* synthetic */ r0(SeasonActivity seasonActivity) {
        this.f2049o = seasonActivity;
    }

    @Override // m5.l
    public void a(Object obj) {
        String str = (String) obj;
        SeasonActivity seasonActivity = this.f2049o;
        try {
            Gson gson = new Gson();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("episodes");
            seasonActivity.Z = new ArrayList();
            try {
                Iterator<String> keys = jSONObject.keys();
                int i10 = 1;
                while (keys.hasNext()) {
                    String next = keys.next();
                    Season season = new Season("Season " + next, i10, _UrlKt.FRAGMENT_ENCODE_SET);
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    ArrayList arrayList = new ArrayList();
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                            EpisodeModel episodeModel = (EpisodeModel) gson.fromJson(jSONObject2.toString(), EpisodeModel.class);
                            if (jSONObject2.has("info")) {
                                try {
                                    Info info = (Info) gson.fromJson(jSONObject2.getJSONObject("info").toString(), Info.class);
                                    EpisodeInfoModel episodeInfoModel = new EpisodeInfoModel();
                                    episodeInfoModel.setMovie_image(info.getMovie_image());
                                    episodeInfoModel.setPlot(info.getPlot());
                                    episodeInfoModel.setTmdb_id(info.getTmdb_id());
                                    episodeModel.setInfo(episodeInfoModel);
                                } catch (JSONException unused) {
                                    Log.e("info error", "info _error");
                                }
                            }
                            arrayList.add(episodeModel);
                        } catch (JSONException unused2) {
                            Log.e("episode error", "episode error");
                        }
                    }
                    season.setEpisodeModels(arrayList);
                    seasonActivity.Z.add(season);
                    i10++;
                }
            } catch (Exception unused3) {
                seasonActivity.Q.setFocusable(true);
                seasonActivity.Q.requestFocus();
                Toast.makeText(seasonActivity, seasonActivity.f1791d0.getNo_episode(), 0).show();
            }
            if (seasonActivity.Z.isEmpty()) {
                return;
            }
            d5.e eVar = seasonActivity.U;
            eVar.f4087f = seasonActivity.Z;
            eVar.d();
            int season_pos = seasonActivity.N.getSeason_pos();
            seasonActivity.f1794g0 = season_pos;
            if (season_pos > seasonActivity.Z.size() - 1) {
                seasonActivity.f1794g0 = 0;
            }
            List<EpisodeModel> episodeModels = ((Season) seasonActivity.Z.get(seasonActivity.f1794g0)).getEpisodeModels();
            seasonActivity.f1788a0 = episodeModels;
            d5.t tVar = seasonActivity.O;
            String name = ((Season) seasonActivity.Z.get(seasonActivity.f1794g0)).getName();
            tVar.f4190f = episodeModels;
            tVar.g = name;
            tVar.d();
            int episode_pos = seasonActivity.N.getEpisode_pos();
            seasonActivity.f1793f0 = episode_pos;
            if (episode_pos > seasonActivity.f1788a0.size() - 1) {
                seasonActivity.f1793f0 = 0;
            }
            seasonActivity.P.e0(seasonActivity.f1793f0);
            seasonActivity.U.o(seasonActivity.f1794g0);
            seasonActivity.V.setSelectedPosition(seasonActivity.f1794g0);
            seasonActivity.V.requestFocus();
        } catch (Exception unused4) {
            seasonActivity.Q.setFocusable(true);
            seasonActivity.Q.requestFocus();
            Toast.makeText(seasonActivity, seasonActivity.f1791d0.getNo_episode(), 0).show();
        }
    }

    @Override // m5.k
    public void g() {
        SeasonActivity seasonActivity = this.f2049o;
        seasonActivity.Q.setFocusable(true);
        seasonActivity.Q.requestFocus();
        Toast.makeText(seasonActivity, seasonActivity.f1791d0.getNo_episode(), 0).show();
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        SeasonActivity seasonActivity = this.f2049o;
        seasonActivity.Q.setFocusable(true);
        seasonActivity.Q.requestFocus();
        a.a.p(seasonActivity).a(new n5.f(seasonActivity.T.B() + "/player_api.php?action=get_series_info&username=" + seasonActivity.T.I() + "&password=" + seasonActivity.T.v() + "&series_id=" + seasonActivity.f1789b0, new q0(seasonActivity), new q0(seasonActivity)));
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        Object body = response.body();
        SeasonActivity seasonActivity = this.f2049o;
        if (body == null) {
            seasonActivity.Q.setFocusable(true);
            seasonActivity.Q.requestFocus();
            Toast.makeText(seasonActivity, seasonActivity.f1791d0.getNo_episode(), 0).show();
            return;
        }
        response.body();
        InfoSerie infoSerie = (InfoSerie) response.body();
        seasonActivity.Z = new ArrayList();
        List<Season> listSerieDisp = infoSerie.getEpisodes().getListSerieDisp(infoSerie.getSeasons());
        if (listSerieDisp != null) {
            if (listSerieDisp.size() <= 0) {
                a.a.p(seasonActivity).a(new n5.f(seasonActivity.T.B() + "/player_api.php?action=get_series_info&username=" + seasonActivity.T.I() + "&password=" + seasonActivity.T.v() + "&series_id=" + seasonActivity.f1789b0, new r0(seasonActivity), new r0(seasonActivity)));
                return;
            }
            for (int i10 = 0; i10 < listSerieDisp.size(); i10++) {
                Season season = listSerieDisp.get(i10);
                int season_number = listSerieDisp.get(i10).getSeason_number();
                ArrayList arrayList = new ArrayList();
                List<Episode> episodesBySaison = infoSerie.getEpisodes().getEpisodesBySaison(season_number);
                for (int i11 = 0; i11 < episodesBySaison.size(); i11++) {
                    Episode episode = episodesBySaison.get(i11);
                    EpisodeModel episodeModel = new EpisodeModel();
                    episodeModel.setTitle(episode.getTitle());
                    episodeModel.setSeason(episode.getSeason());
                    episodeModel.setEpisode_num(episode.getEpisode_num());
                    episodeModel.setId(episode.getId());
                    episodeModel.setContainer_extension(episode.getContainer_extension());
                    EpisodeInfoModel episodeInfoModel = new EpisodeInfoModel();
                    Gson create = new GsonBuilder().create();
                    if (episode.getInfo() != null) {
                        try {
                            Info info = (Info) create.fromJson(create.toJson(episode.getInfo()), Info.class);
                            episodeInfoModel.setTmdb_id(info.getTmdb_id());
                            episodeInfoModel.setMovie_image(info.getMovie_image());
                            episodeInfoModel.setPlot(info.getPlot());
                        } catch (Exception e7) {
                            Log.e("SeasonActivity", "getEpisodesFromInfoSerie", e7);
                        }
                    }
                    episodeModel.setInfo(episodeInfoModel);
                    arrayList.add(episodeModel);
                }
                season.setEpisodeModels(arrayList);
                seasonActivity.Z.add(season);
            }
            d5.e eVar = seasonActivity.U;
            eVar.f4087f = seasonActivity.Z;
            eVar.d();
            int season_pos = seasonActivity.N.getSeason_pos();
            seasonActivity.f1794g0 = season_pos;
            if (season_pos > seasonActivity.Z.size() - 1) {
                seasonActivity.f1794g0 = 0;
            }
            List<EpisodeModel> episodeModels = ((Season) seasonActivity.Z.get(seasonActivity.f1794g0)).getEpisodeModels();
            seasonActivity.f1788a0 = episodeModels;
            d5.t tVar = seasonActivity.O;
            String name = ((Season) seasonActivity.Z.get(seasonActivity.f1794g0)).getName();
            tVar.f4190f = episodeModels;
            tVar.g = name;
            tVar.d();
            int episode_pos = seasonActivity.N.getEpisode_pos();
            seasonActivity.f1793f0 = episode_pos;
            if (episode_pos > seasonActivity.f1788a0.size() - 1) {
                seasonActivity.f1793f0 = 0;
            }
            seasonActivity.P.e0(seasonActivity.f1793f0);
            seasonActivity.U.o(seasonActivity.f1794g0);
            seasonActivity.V.setSelectedPosition(seasonActivity.f1794g0);
            seasonActivity.V.requestFocus();
        }
    }
}
