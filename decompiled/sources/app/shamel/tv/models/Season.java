package app.shamel.tv.models;

import android.support.v4.media.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class Season implements Serializable {
    private String air_date;
    private String category_name;
    private String cover;
    private String cover_big;
    private List<EpisodeModel> episodeModels;
    private String episode_count;
    private String id;
    private String name;
    private String overview;
    private int season_number;

    public Season() {
    }

    public String getAir_date() {
        return this.air_date;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    public String getCover() {
        return this.cover;
    }

    public String getCover_big() {
        return this.cover_big;
    }

    public List<EpisodeModel> getEpisodeModels() {
        List<EpisodeModel> list = this.episodeModels;
        return list == null ? new ArrayList() : list;
    }

    public String getEpisode_count() {
        String str = this.episode_count;
        return (str == null || str.isEmpty()) ? "0" : this.episode_count;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getOverview() {
        return this.overview;
    }

    public int getSeason_number() {
        return this.season_number;
    }

    public void setAir_date(String str) {
        this.air_date = str;
    }

    public void setCategory_name(String str) {
        this.category_name = str;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setCover_big(String str) {
        this.cover_big = str;
    }

    public void setEpisodeModels(List<EpisodeModel> list) {
        this.episodeModels = list;
    }

    public void setEpisode_count(String str) {
        this.episode_count = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOverview(String str) {
        this.overview = str;
    }

    public void setSeason_number(int i10) {
        this.season_number = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Season{air_date='");
        sb2.append(this.air_date);
        sb2.append("', episode_count='");
        sb2.append(this.episode_count);
        sb2.append("', id='");
        sb2.append(this.id);
        sb2.append("', name='");
        sb2.append(this.name);
        sb2.append("', overview='");
        sb2.append(this.overview);
        sb2.append("', season_number=");
        sb2.append(this.season_number);
        sb2.append(", cover='");
        sb2.append(this.cover);
        sb2.append("', cover_big='");
        return d.r(sb2, this.cover_big, "'}");
    }

    public Season(String str, int i10, String str2) {
        this.name = str;
        this.season_number = i10;
        this.cover = str2;
    }
}
