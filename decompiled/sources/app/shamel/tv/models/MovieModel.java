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
public class MovieModel extends k0 implements Serializable {

    @SerializedName("added")
    private String added;

    @SerializedName("category_id")
    private String category_id;
    private String category_name;

    @SerializedName("custom_sid")
    private String custom_sid;

    @SerializedName("container_extension")
    private String extension;
    private boolean is_favorite;
    private boolean is_locked;
    private boolean is_recent;

    @SerializedName("name")
    private String name;

    @SerializedName("num")
    private int num;
    private int pro;

    @SerializedName("rating")
    private String rating;
    private long recent_mil;

    @SerializedName("stream_icon")
    private String stream_icon;

    @SerializedName("stream_id")
    private String stream_id;

    @SerializedName("stream_type")
    private String stream_type;
    private long time;

    @SerializedName("tmdb_id")
    private String tmdb_id;
    private String type;
    private String url;

    /* JADX WARN: Multi-variable type inference failed */
    public MovieModel() {
        boolean z10 = this instanceof y;
        if (z10) {
            ((y) this).b();
        }
        if (z10) {
            ((y) this).b();
        }
        setPro(0);
        setTime(0L);
        setRecent_mil(0L);
        setIs_locked(false);
        setIs_favorite(false);
        setIs_recent(false);
    }

    public static MovieModel fromM3UItem(a aVar) {
        MovieModel movieModel;
        try {
            movieModel = new MovieModel();
            movieModel.setCategory_name(TextUtils.isEmpty(aVar.a()) ? "All" : aVar.a());
            if (!TextUtils.isEmpty(aVar.f7508b)) {
                movieModel.setName(aVar.f7508b);
            }
        } catch (Exception e7) {
            Log.e("MovieModel", "fromM3UItem", e7);
            return null;
        }
        if (!TextUtils.isEmpty(aVar.f7513h)) {
            movieModel.setUrl(aVar.f7513h);
            if (movieModel.getUrl().contains("movie")) {
                try {
                    String str = movieModel.getUrl().split("/")[6];
                    if (str.contains(".")) {
                        movieModel.setStream_id(str.split("\\.")[0]);
                    } else {
                        movieModel.setStream_id(str);
                    }
                } catch (Exception unused) {
                    movieModel.setStream_id("0");
                }
            } else {
                try {
                    movieModel.setStream_id(movieModel.getUrl().split("/")[5]);
                } catch (Exception unused2) {
                    movieModel.setStream_id("0");
                }
            }
            Log.e("MovieModel", "fromM3UItem", e7);
            return null;
        }
        if (!TextUtils.isEmpty(aVar.f7512f)) {
            movieModel.setStream_icon(aVar.f7512f);
        }
        return movieModel;
    }

    public String getAdded() {
        return realmGet$added() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$added();
    }

    public String getCategory_id() {
        return realmGet$category_id() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$category_id();
    }

    public String getCategory_name() {
        return realmGet$category_name() == null ? "!@#%" : realmGet$category_name();
    }

    public String getCustom_sid() {
        return realmGet$custom_sid();
    }

    public String getExtension() {
        return realmGet$extension();
    }

    public String getName() {
        return realmGet$name();
    }

    public int getNum() {
        return realmGet$num();
    }

    public int getPro() {
        return realmGet$pro();
    }

    public String getRating() {
        return realmGet$rating();
    }

    public long getRecent_mil() {
        return realmGet$recent_mil();
    }

    public String getStream_icon() {
        return realmGet$stream_icon() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$stream_icon();
    }

    public String getStream_id() {
        return realmGet$stream_id() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$stream_id();
    }

    public String getStream_type() {
        return realmGet$stream_type();
    }

    public long getTime() {
        return realmGet$time();
    }

    public String getTmdb_id() {
        return realmGet$tmdb_id() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$tmdb_id();
    }

    public String getType() {
        return realmGet$type();
    }

    public String getUrl() {
        return realmGet$url();
    }

    public boolean isIs_favorite() {
        return realmGet$is_favorite();
    }

    public boolean isIs_locked() {
        return realmGet$is_locked();
    }

    public boolean isIs_recent() {
        return realmGet$is_recent();
    }

    public String realmGet$added() {
        return this.added;
    }

    public String realmGet$category_id() {
        return this.category_id;
    }

    public String realmGet$category_name() {
        return this.category_name;
    }

    public String realmGet$custom_sid() {
        return this.custom_sid;
    }

    public String realmGet$extension() {
        return this.extension;
    }

    public boolean realmGet$is_favorite() {
        return this.is_favorite;
    }

    public boolean realmGet$is_locked() {
        return this.is_locked;
    }

    public boolean realmGet$is_recent() {
        return this.is_recent;
    }

    public String realmGet$name() {
        return this.name;
    }

    public int realmGet$num() {
        return this.num;
    }

    public int realmGet$pro() {
        return this.pro;
    }

    public String realmGet$rating() {
        return this.rating;
    }

    public long realmGet$recent_mil() {
        return this.recent_mil;
    }

    public String realmGet$stream_icon() {
        return this.stream_icon;
    }

    public String realmGet$stream_id() {
        return this.stream_id;
    }

    public String realmGet$stream_type() {
        return this.stream_type;
    }

    public long realmGet$time() {
        return this.time;
    }

    public String realmGet$tmdb_id() {
        return this.tmdb_id;
    }

    public String realmGet$type() {
        return this.type;
    }

    public String realmGet$url() {
        return this.url;
    }

    public void realmSet$added(String str) {
        this.added = str;
    }

    public void realmSet$category_id(String str) {
        this.category_id = str;
    }

    public void realmSet$category_name(String str) {
        this.category_name = str;
    }

    public void realmSet$custom_sid(String str) {
        this.custom_sid = str;
    }

    public void realmSet$extension(String str) {
        this.extension = str;
    }

    public void realmSet$is_favorite(boolean z10) {
        this.is_favorite = z10;
    }

    public void realmSet$is_locked(boolean z10) {
        this.is_locked = z10;
    }

    public void realmSet$is_recent(boolean z10) {
        this.is_recent = z10;
    }

    public void realmSet$name(String str) {
        this.name = str;
    }

    public void realmSet$num(int i10) {
        this.num = i10;
    }

    public void realmSet$pro(int i10) {
        this.pro = i10;
    }

    public void realmSet$rating(String str) {
        this.rating = str;
    }

    public void realmSet$recent_mil(long j10) {
        this.recent_mil = j10;
    }

    public void realmSet$stream_icon(String str) {
        this.stream_icon = str;
    }

    public void realmSet$stream_id(String str) {
        this.stream_id = str;
    }

    public void realmSet$stream_type(String str) {
        this.stream_type = str;
    }

    public void realmSet$time(long j10) {
        this.time = j10;
    }

    public void realmSet$tmdb_id(String str) {
        this.tmdb_id = str;
    }

    public void realmSet$type(String str) {
        this.type = str;
    }

    public void realmSet$url(String str) {
        this.url = str;
    }

    public void setAdded(String str) {
        realmSet$added(str);
    }

    public void setCategory_id(String str) {
        realmSet$category_id(str);
    }

    public void setCategory_name(String str) {
        realmSet$category_name(str);
    }

    public void setCustom_sid(String str) {
        realmSet$custom_sid(str);
    }

    public void setExtension(String str) {
        realmSet$extension(str);
    }

    public void setIs_favorite(boolean z10) {
        realmSet$is_favorite(z10);
    }

    public void setIs_locked(boolean z10) {
        realmSet$is_locked(z10);
    }

    public void setIs_recent(boolean z10) {
        realmSet$is_recent(z10);
    }

    public void setName(String str) {
        realmSet$name(str);
    }

    public void setNum(int i10) {
        realmSet$num(i10);
    }

    public void setPro(int i10) {
        realmSet$pro(i10);
    }

    public void setRating(String str) {
        realmSet$rating(str);
    }

    public void setRecent_mil(long j10) {
        realmSet$recent_mil(j10);
    }

    public void setStream_icon(String str) {
        realmSet$stream_icon(str);
    }

    public void setStream_id(String str) {
        realmSet$stream_id(str);
    }

    public void setStream_type(String str) {
        realmSet$stream_type(str);
    }

    public void setTime(long j10) {
        realmSet$time(j10);
    }

    public void setTmdb_id(String str) {
        realmSet$tmdb_id(str);
    }

    public void setType(String str) {
        realmSet$type(str);
    }

    public void setUrl(String str) {
        realmSet$url(str);
    }
}
