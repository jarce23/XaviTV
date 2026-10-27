package app.shamel.tv.models;

import com.google.gson.annotations.SerializedName;
import io.realm.internal.y;
import io.realm.k0;
import java.io.Serializable;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class EpisodeInfoModel extends k0 implements Serializable {

    @SerializedName("bitrate")
    private int bitrate;

    @SerializedName("duration")
    private String duration;

    @SerializedName("duration_secs")
    private int duration_secs;

    @SerializedName("movie_image")
    private String movie_image;

    @SerializedName("name")
    private String name;

    @SerializedName("plot")
    private String plot;

    @SerializedName("rating")
    private String rating;

    @SerializedName("releasedate")
    private String releasedate;

    @SerializedName("tmdb_id")
    public String tmdb_id;

    /* JADX WARN: Multi-variable type inference failed */
    public EpisodeInfoModel() {
        boolean z10 = this instanceof y;
        if (z10) {
            ((y) this).b();
        }
        if (z10) {
            ((y) this).b();
        }
    }

    public int getBitrate() {
        return realmGet$bitrate();
    }

    public String getDuration() {
        return realmGet$duration();
    }

    public int getDuration_secs() {
        return realmGet$duration_secs();
    }

    public String getMovie_image() {
        return realmGet$movie_image() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$movie_image();
    }

    public String getName() {
        return realmGet$name();
    }

    public String getPlot() {
        return realmGet$plot() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$plot();
    }

    public String getRating() {
        return realmGet$rating() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$rating();
    }

    public String getReleasedate() {
        return realmGet$releasedate();
    }

    public String getTmdb_id() {
        return realmGet$tmdb_id() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$tmdb_id();
    }

    public int realmGet$bitrate() {
        return this.bitrate;
    }

    public String realmGet$duration() {
        return this.duration;
    }

    public int realmGet$duration_secs() {
        return this.duration_secs;
    }

    public String realmGet$movie_image() {
        return this.movie_image;
    }

    public String realmGet$name() {
        return this.name;
    }

    public String realmGet$plot() {
        return this.plot;
    }

    public String realmGet$rating() {
        return this.rating;
    }

    public String realmGet$releasedate() {
        return this.releasedate;
    }

    public String realmGet$tmdb_id() {
        return this.tmdb_id;
    }

    public void realmSet$bitrate(int i10) {
        this.bitrate = i10;
    }

    public void realmSet$duration(String str) {
        this.duration = str;
    }

    public void realmSet$duration_secs(int i10) {
        this.duration_secs = i10;
    }

    public void realmSet$movie_image(String str) {
        this.movie_image = str;
    }

    public void realmSet$name(String str) {
        this.name = str;
    }

    public void realmSet$plot(String str) {
        this.plot = str;
    }

    public void realmSet$rating(String str) {
        this.rating = str;
    }

    public void realmSet$releasedate(String str) {
        this.releasedate = str;
    }

    public void realmSet$tmdb_id(String str) {
        this.tmdb_id = str;
    }

    public void setBitrate(int i10) {
        realmSet$bitrate(i10);
    }

    public void setDuration(String str) {
        realmSet$duration(str);
    }

    public void setDuration_secs(int i10) {
        realmSet$duration_secs(i10);
    }

    public void setMovie_image(String str) {
        realmSet$movie_image(str);
    }

    public void setName(String str) {
        realmSet$name(str);
    }

    public void setPlot(String str) {
        realmSet$plot(str);
    }

    public void setRating(String str) {
        realmSet$rating(str);
    }

    public void setReleasedate(String str) {
        realmSet$releasedate(str);
    }

    public void setTmdb_id(String str) {
        realmSet$tmdb_id(str);
    }
}
