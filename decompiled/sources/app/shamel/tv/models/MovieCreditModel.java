package app.shamel.tv.models;

import android.support.v4.media.d;
import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MovieCreditModel implements Serializable {
    public String backdrop_path;
    public String character;
    public String credit_id;
    public int id;
    public String original_language;
    public String original_title;
    public String overview;
    public String poster_path;
    public String release_date;
    public String title;
    public float vote_average;
    public int vote_count;

    public String getBackdrop_path() {
        return this.backdrop_path;
    }

    public String getCharacter() {
        return this.character;
    }

    public String getCredit_id() {
        return this.credit_id;
    }

    public int getId() {
        return this.id;
    }

    public String getOriginal_language() {
        return this.original_language;
    }

    public String getOriginal_title() {
        return this.original_title;
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

    public String getTitle() {
        return this.title;
    }

    public float getVote_average() {
        return this.vote_average;
    }

    public int getVote_count() {
        return this.vote_count;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("MovieCreditModels{id='");
        sb2.append(this.id);
        sb2.append("'character='");
        sb2.append(this.character);
        sb2.append("', credit_id='");
        sb2.append(this.credit_id);
        sb2.append("', release_date='");
        sb2.append(this.release_date);
        sb2.append("', vote_count=");
        sb2.append(this.vote_count);
        sb2.append(", vote_average=");
        sb2.append(this.vote_average);
        sb2.append(", title='");
        sb2.append(this.title);
        sb2.append("', original_language='");
        sb2.append(this.original_language);
        sb2.append("', original_title='");
        sb2.append(this.original_title);
        sb2.append("', backdrop_path='");
        sb2.append(this.backdrop_path);
        sb2.append("', overview='");
        sb2.append(this.overview);
        sb2.append("', poster_path='");
        return d.r(sb2, this.poster_path, "'}");
    }
}
