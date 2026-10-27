package app.shamel.tv.models;

import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class TMDBVideoResponse {
    public int id;
    public List<TMDBVideoModel> results;

    public int getId() {
        return this.id;
    }

    public List<TMDBVideoModel> getResults() {
        return this.results;
    }

    public String toString() {
        return "TMDBVideoResponse{id=" + this.id + ", results=" + this.results + '}';
    }
}
