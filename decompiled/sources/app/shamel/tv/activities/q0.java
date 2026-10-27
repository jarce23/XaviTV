package app.shamel.tv.activities;

import android.util.Log;
import android.widget.Toast;
import app.shamel.tv.models.EpisodeInfoModel;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.Info;
import app.shamel.tv.models.Season;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class q0 implements m5.l, m5.k {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ SeasonActivity f2047o;

    public /* synthetic */ q0(SeasonActivity seasonActivity) {
        this.f2047o = seasonActivity;
    }

    @Override // m5.l
    public void a(Object obj) {
        boolean z10;
        Season season;
        SeasonActivity seasonActivity = this.f2047o;
        String str = (String) obj;
        int i10 = SeasonActivity.h0;
        try {
            Gson gson = new Gson();
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("seasons");
            seasonActivity.Z = new ArrayList();
            ArrayList arrayList = new ArrayList((Collection) gson.fromJson(jSONArray.toString(), new s0().getType()));
            JSONArray jSONArray2 = jSONObject.getJSONArray("episodes");
            int i11 = 0;
            while (i11 < jSONArray2.length()) {
                int i12 = i11 + 1;
                ArrayList arrayList2 = new ArrayList(arrayList);
                String valueOf = String.valueOf(i12);
                int size = arrayList2.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size) {
                        z10 = true;
                        season = new Season(r.a.l("Season  ", valueOf), Integer.parseInt(valueOf), _UrlKt.FRAGMENT_ENCODE_SET);
                        break;
                    }
                    Object obj2 = arrayList2.get(i13);
                    i13++;
                    Season season2 = (Season) obj2;
                    z10 = true;
                    try {
                        if (valueOf.equals(String.valueOf(season2.getSeason_number()))) {
                            season = season2;
                            break;
                        }
                    } catch (Exception unused) {
                        seasonActivity.Q.setFocusable(z10);
                        seasonActivity.Q.requestFocus();
                        Toast.makeText(seasonActivity, seasonActivity.f1791d0.getNo_episode(), 0).show();
                        return;
                    }
                }
                try {
                    JSONArray jSONArray3 = jSONArray2.getJSONArray(i11);
                    ArrayList arrayList3 = new ArrayList();
                    for (int i14 = 0; i14 < jSONArray3.length(); i14++) {
                        try {
                            JSONObject jSONObject2 = jSONArray3.getJSONObject(i14);
                            EpisodeModel episodeModel = (EpisodeModel) gson.fromJson(jSONObject2.toString(), EpisodeModel.class);
                            if (jSONObject2.has("info")) {
                                try {
                                    Info info = (Info) gson.fromJson(jSONObject2.getJSONObject("info").toString(), Info.class);
                                    EpisodeInfoModel episodeInfoModel = new EpisodeInfoModel();
                                    episodeInfoModel.setMovie_image(info.getMovie_image());
                                    episodeInfoModel.setPlot(info.getPlot());
                                    episodeInfoModel.setTmdb_id(info.getTmdb_id());
                                    episodeModel.setInfo(episodeInfoModel);
                                } catch (JSONException unused2) {
                                    Log.e("info error", "info _error");
                                }
                            }
                            arrayList3.add(episodeModel);
                        } catch (JSONException unused3) {
                            Log.e("episode error", "episode error");
                        }
                    }
                    season.setEpisodeModels(arrayList3);
                } catch (JSONException unused4) {
                    Log.e("JSONException error", "JSONException error");
                }
                seasonActivity.Z.add(season);
                i11 = i12;
            }
            z10 = true;
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
        } catch (Exception unused5) {
            z10 = true;
        }
    }

    @Override // m5.k
    public void g() {
        SeasonActivity seasonActivity = this.f2047o;
        seasonActivity.Q.setFocusable(true);
        seasonActivity.Q.requestFocus();
        Toast.makeText(seasonActivity, seasonActivity.f1791d0.getNo_episode(), 0).show();
    }
}
