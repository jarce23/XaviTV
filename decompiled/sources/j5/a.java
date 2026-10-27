package j5;

import app.shamel.tv.models.CastResponse;
import app.shamel.tv.models.CatchUpEpgResponse;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.InfoSerie;
import app.shamel.tv.models.LoginResponse;
import app.shamel.tv.models.MovieCreditResponse;
import app.shamel.tv.models.MovieInfoResponse;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import app.shamel.tv.models.TMDBResponse;
import app.shamel.tv.models.TMDBVideoResponse;
import java.util.List;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public interface a {
    @GET("/player_api.php?")
    Call<LoginResponse> authentication(@Query("username") String str, @Query("password") String str2);

    @GET
    Call<CastResponse> getCastModels(@Url String str);

    @Streaming
    @GET("/xmltv.php")
    Call<ResponseBody> getEpgXml(@Query("username") String str, @Query("password") String str2);

    @GET
    Call<MovieCreditResponse> getMovieCreditModels(@Url String str);

    @GET
    Call<TMDBResponse> getRSS(@Url String str);

    @GET
    Call<TMDBVideoResponse> getTmdbVideoModels(@Url String str);

    @GET("/player_api.php?action=get_simple_data_table")
    Call<CatchUpEpgResponse> get_full_epg(@Query("username") String str, @Query("password") String str2, @Query("stream_id") String str3);

    @GET("/player_api.php?action=get_live_categories")
    Call<List<CategoryModel>> get_live_categories(@Query("username") String str, @Query("password") String str2);

    @GET("/player_api.php?action=get_live_streams&category_id=*")
    Call<List<EPGChannel>> get_live_streams(@Query("username") String str, @Query("password") String str2);

    @GET("/player_api.php?action=get_live_streams")
    Call<List<EPGChannel>> get_second_live_streams(@Query("username") String str, @Query("password") String str2);

    @GET("/player_api.php?action=get_series")
    Call<List<SeriesModel>> get_second_series(@Query("username") String str, @Query("password") String str2);

    @GET("/player_api.php?action=get_vod_streams")
    Call<List<MovieModel>> get_second_vod_streams(@Query("username") String str, @Query("password") String str2);

    @GET("/player_api.php?action=get_series&category_id=*")
    Call<List<SeriesModel>> get_series(@Query("username") String str, @Query("password") String str2);

    @GET("/player_api.php?action=get_series_categories")
    Call<List<CategoryModel>> get_series_categories(@Query("username") String str, @Query("password") String str2);

    @GET("/player_api.php?action=get_series_info")
    Call<InfoSerie> get_series_info(@Query("username") String str, @Query("password") String str2, @Query("series_id") String str3);

    @GET("/player_api.php?action=get_series_info")
    Call<JSONObject> get_series_info_response(@Query("username") String str, @Query("password") String str2, @Query("series_id") String str3);

    @GET("/player_api.php?action=get_short_epg")
    Call<CatchUpEpgResponse> get_short_epg(@Query("username") String str, @Query("password") String str2, @Query("stream_id") String str3);

    @GET("/player_api.php?action=get_vod_categories")
    Call<List<CategoryModel>> get_vod_categories(@Query("username") String str, @Query("password") String str2);

    @GET("/player_api.php?action=get_vod_info")
    Call<MovieInfoResponse> get_vod_info(@Query("username") String str, @Query("password") String str2, @Query("vod_id") String str3);

    @GET("/player_api.php?action=get_vod_streams&category_id=*")
    Call<List<MovieModel>> get_vod_streams(@Query("username") String str, @Query("password") String str2);
}
