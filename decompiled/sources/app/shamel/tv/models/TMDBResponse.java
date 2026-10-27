package app.shamel.tv.models;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class TMDBResponse implements Serializable {
    public String backdrop_path;
    public int id;
    public String imdb_id;
    public String original_language;
    public String overview;
    public String poster_path;
    public String release_date;
    public int runtime;
    public float vote_average;

    public String getBackdrop_path() {
        return this.backdrop_path;
    }

    public int getId() {
        return this.id;
    }

    public String getImdb_id() {
        return this.imdb_id;
    }

    public String getOriginal_language() {
        return this.original_language;
    }

    public String getOverview() {
        return this.overview;
    }

    public String getPoster_path() {
        return this.poster_path;
    }

    public String getRelease_date() {
        return this.release_date;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public float getVote_average() {
        return this.vote_average;
    }

    public String toString() {
        return "TMDBResponse{backdrop_path='" + this.backdrop_path + "', id='" + this.id + "', imdb_id='" + this.imdb_id + "', original_language='" + this.original_language + "', overview='" + this.overview + "', poster_path='" + this.poster_path + "', release_date='" + this.release_date + "', runtime=" + this.runtime + ", vote_average=" + this.vote_average + '}';
    }
}
