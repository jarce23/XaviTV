package app.shamel.tv.models;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.annotations.SerializedName;
import io.realm.internal.y;
import io.realm.k0;
import ja.a;
import java.io.Serializable;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class EpisodeModel extends k0 implements Serializable {
    private String category_name;

    @SerializedName("container_extension")
    private String container_extension;
    private String episode_num;

    @SerializedName("id")
    private String id;
    private EpisodeInfoModel info_model;

    @SerializedName("season")
    private int season;
    private String season_name;
    private String series_name;
    private String stream_icon;

    @SerializedName("title")
    private String title;
    private String url;

    /* JADX WARN: Multi-variable type inference failed */
    public EpisodeModel() {
        boolean z10 = this instanceof y;
        if (z10) {
            ((y) this).b();
        }
        if (z10) {
            ((y) this).b();
        }
    }

    public static EpisodeModel fromM3UItem(a aVar) {
        try {
            EpisodeModel episodeModel = new EpisodeModel();
            episodeModel.setCategory_name(TextUtils.isEmpty(aVar.a()) ? "All" : aVar.a());
            if (!TextUtils.isEmpty(aVar.f7508b)) {
                episodeModel.setTitle(aVar.f7508b);
                for (String str : episodeModel.getTitle().split(" ")) {
                    if (str.matches("S\\d{2}")) {
                        episodeModel.setSeason_name(episodeModel.getTitle().split(str)[0] + str);
                        episodeModel.setSeries_name(episodeModel.getTitle().split(str)[0]);
                    }
                }
            }
            if (!TextUtils.isEmpty(aVar.f7513h)) {
                episodeModel.setUrl(aVar.f7513h);
            }
            if (!TextUtils.isEmpty(aVar.f7512f)) {
                episodeModel.setStream_icon(aVar.f7512f);
            }
            return episodeModel;
        } catch (Exception e7) {
            Log.e("EpisodeModel", "fromM3UItem", e7);
            return null;
        }
    }

    public String getCategory_name() {
        return realmGet$category_name() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$category_name();
    }

    public String getContainer_extension() {
        return realmGet$container_extension();
    }

    public String getEpisode_num() {
        return realmGet$episode_num() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$episode_num();
    }

    public String getId() {
        return realmGet$id();
    }

    public EpisodeInfoModel getInfo() {
        return realmGet$info_model();
    }

    public int getSeason() {
        return realmGet$season();
    }

    public String getSeason_name() {
        return realmGet$season_name() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$season_name();
    }

    public String getSeries_name() {
        return realmGet$series_name() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$series_name();
    }

    public String getStream_icon() {
        return realmGet$stream_icon() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$stream_icon();
    }

    public String getTitle() {
        return realmGet$title();
    }

    public String getUrl() {
        return realmGet$url() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$url();
    }

    public String realmGet$category_name() {
        return this.category_name;
    }

    public String realmGet$container_extension() {
        return this.container_extension;
    }

    public String realmGet$episode_num() {
        return this.episode_num;
    }

    public String realmGet$id() {
        return this.id;
    }

    public EpisodeInfoModel realmGet$info_model() {
        return this.info_model;
    }

    public int realmGet$season() {
        return this.season;
    }

    public String realmGet$season_name() {
        return this.season_name;
    }

    public String realmGet$series_name() {
        return this.series_name;
    }

    public String realmGet$stream_icon() {
        return this.stream_icon;
    }

    public String realmGet$title() {
        return this.title;
    }

    public String realmGet$url() {
        return this.url;
    }

    public void realmSet$category_name(String str) {
        this.category_name = str;
    }

    public void realmSet$container_extension(String str) {
        this.container_extension = str;
    }

    public void realmSet$episode_num(String str) {
        this.episode_num = str;
    }

    public void realmSet$id(String str) {
        this.id = str;
    }

    public void realmSet$info_model(EpisodeInfoModel episodeInfoModel) {
        this.info_model = episodeInfoModel;
    }

    public void realmSet$season(int i10) {
        this.season = i10;
    }

    public void realmSet$season_name(String str) {
        this.season_name = str;
    }

    public void realmSet$series_name(String str) {
        this.series_name = str;
    }

    public void realmSet$stream_icon(String str) {
        this.stream_icon = str;
    }

    public void realmSet$title(String str) {
        this.title = str;
    }

    public void realmSet$url(String str) {
        this.url = str;
    }

    public void setCategory_name(String str) {
        realmSet$category_name(str);
    }

    public void setContainer_extension(String str) {
        realmSet$container_extension(str);
    }

    public void setEpisode_num(String str) {
        realmSet$episode_num(str);
    }

    public void setId(String str) {
        realmSet$id(str);
    }

    public void setInfo(EpisodeInfoModel episodeInfoModel) {
        realmSet$info_model(episodeInfoModel);
    }

    public void setSeason(int i10) {
        realmSet$season(i10);
    }

    public void setSeason_name(String str) {
        realmSet$season_name(str);
    }

    public void setSeries_name(String str) {
        realmSet$series_name(str);
    }

    public void setStream_icon(String str) {
        realmSet$stream_icon(str);
    }

    public void setTitle(String str) {
        realmSet$title(str);
    }

    public void setUrl(String str) {
        realmSet$url(str);
    }
}
