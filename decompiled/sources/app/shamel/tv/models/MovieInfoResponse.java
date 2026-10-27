package app.shamel.tv.models;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MovieInfoResponse implements Serializable {
    public MovieInfo info;

    public MovieInfo getInfo() {
        return this.info;
    }

    public void setInfo(MovieInfo movieInfo) {
        this.info = movieInfo;
    }

    public String toString() {
        return "MovieInfoResponse{info=" + this.info + '}';
    }
}
