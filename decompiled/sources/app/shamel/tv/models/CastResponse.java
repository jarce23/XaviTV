package app.shamel.tv.models;

import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CastResponse {
    public List<CastModel> cast;
    public int id;

    public List<CastModel> getCast() {
        return this.cast;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return "CastResponse{id=" + this.id + ", cast=" + this.cast + '}';
    }
}
