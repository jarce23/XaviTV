package app.shamel.tv.models;

import android.support.v4.media.d;
import java.io.Serializable;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class Info implements Serializable {
    private String movie_image;
    private String plot;
    private String tmdb_id;

    public String getMovie_image() {
        return this.movie_image;
    }

    public String getPlot() {
        String str = this.plot;
        return str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
    }

    public String getTmdb_id() {
        String str = this.tmdb_id;
        return str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
    }

    public void setMovie_image(String str) {
        this.movie_image = str;
    }

    public void setPlot(String str) {
        this.plot = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Info{movie_image='");
        sb2.append(this.movie_image);
        sb2.append("', plot='");
        sb2.append(this.plot);
        sb2.append("', tmdb_id='");
        return d.r(sb2, this.tmdb_id, "'}");
    }
}
