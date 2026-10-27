package app.shamel.tv.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class InfoSerie implements Serializable {
    public List<Season> seasons = new ArrayList();
    public ListEpisode episodes = new ListEpisode();

    public ListEpisode getEpisodes() {
        return this.episodes;
    }

    public List<Season> getSeasons() {
        return this.seasons;
    }

    public void setEpisodes(ListEpisode listEpisode) {
        this.episodes = listEpisode;
    }

    public void setSeasons(List<Season> list) {
        this.seasons = list;
    }

    public String toString() {
        return "InfoSerie{seasons=" + this.seasons + "episodes=" + this.episodes + '}';
    }
}
