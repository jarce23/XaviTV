package app.shamel.tv.models;

import android.support.v4.media.d;
import java.io.Serializable;
import java.util.List;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MovieInfo implements Serializable {
    private String actors;
    private String age;
    private String backdrop;
    private List<String> backdrop_path;
    private String cast;
    private String category_id;
    private String country;
    private String cover_big;
    private String description;
    private String director;
    private String duration;
    private String duration_secs;
    private String episode_run_time;
    private String genre;
    private String kinopoisk_url;
    private String movie_image;
    private String name;
    private String o_name;
    private String plot;
    private String rating;
    private String rating_count_kinopoisk;
    private String rating_mpaa;
    private String releasedate;
    private String tmdb_id;
    private String youtube_trailer;

    public String getAge() {
        String str = this.age;
        return str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
    }

    public String getBackdrop() {
        return this.backdrop;
    }

    public String getCast() {
        String str = this.cast;
        return str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
    }

    public String getCategory_id() {
        return this.category_id;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCover_big() {
        List<String> list = this.backdrop_path;
        if (list != null && !list.isEmpty()) {
            return this.backdrop_path.get(0);
        }
        String str = this.backdrop;
        if (str != null && !str.isEmpty()) {
            return this.backdrop;
        }
        String str2 = this.cover_big;
        return (str2 == null || str2.isEmpty()) ? _UrlKt.FRAGMENT_ENCODE_SET : this.cover_big;
    }

    public String getDescription() {
        String str = this.description;
        if (str != null && !str.isEmpty()) {
            return this.description;
        }
        String str2 = this.plot;
        return str2 == null ? _UrlKt.FRAGMENT_ENCODE_SET : str2;
    }

    public String getDirector() {
        return this.director;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getDuration_secs() {
        String str = this.duration_secs;
        return str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
    }

    public String getGenre() {
        String str = this.genre;
        return str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
    }

    public String getKinopoisk_url() {
        return this.kinopoisk_url;
    }

    public String getMovie_image() {
        return this.movie_image;
    }

    public String getName() {
        return this.name;
    }

    public String getO_name() {
        return this.o_name;
    }

    public String getPlot() {
        return this.plot;
    }

    public float getRating() {
        String str = this.rating;
        if (str == null || str.isEmpty()) {
            return 0.0f;
        }
        return Float.parseFloat(this.rating) / 2.0f;
    }

    public String getRating_count_kinopoisk() {
        return this.rating_count_kinopoisk;
    }

    public String getRating_mpaa() {
        return this.rating_mpaa;
    }

    public String getReleasedate() {
        String str = this.releasedate;
        return str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
    }

    public String getTmdb_id() {
        String str = this.tmdb_id;
        return str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
    }

    public String getYoutube_trailer() {
        String str = this.youtube_trailer;
        return str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("MovieInfo{movie_image='");
        sb2.append(this.movie_image);
        sb2.append("', youtube_trailer='");
        sb2.append(this.youtube_trailer);
        sb2.append("', genre='");
        sb2.append(this.genre);
        sb2.append("', plot='");
        sb2.append(this.plot);
        sb2.append("', cast='");
        sb2.append(this.cast);
        sb2.append("', rating='");
        sb2.append(this.rating);
        sb2.append("', director='");
        sb2.append(this.director);
        sb2.append("', releasedate='");
        sb2.append(this.releasedate);
        sb2.append("', tmdb_id='");
        sb2.append(this.tmdb_id);
        sb2.append("', kinopoisk_url='");
        sb2.append(this.kinopoisk_url);
        sb2.append("', name='");
        sb2.append(this.name);
        sb2.append("', o_name='");
        sb2.append(this.o_name);
        sb2.append("', cover_big='");
        sb2.append(this.cover_big);
        sb2.append("', episode_run_time='");
        sb2.append(this.episode_run_time);
        sb2.append("', actors='");
        sb2.append(this.actors);
        sb2.append("', description='");
        sb2.append(this.description);
        sb2.append("', age='");
        sb2.append(this.age);
        sb2.append("', rating_mpaa='");
        sb2.append(this.rating_mpaa);
        sb2.append("', rating_count_kinopoisk='");
        sb2.append(this.rating_count_kinopoisk);
        sb2.append("', country='");
        sb2.append(this.country);
        sb2.append("', duration='");
        sb2.append(this.duration);
        sb2.append("', backdrop='");
        sb2.append(this.backdrop);
        sb2.append("', duration_secs='");
        sb2.append(this.duration_secs);
        sb2.append("', backdrop_path='");
        sb2.append(this.backdrop_path);
        sb2.append("', category_id='");
        return d.r(sb2, this.category_id, "'}");
    }
}
