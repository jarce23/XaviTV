package app.shamel.tv.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CatchUpEpgResponse implements Serializable {
    public List<CatchUpEpg> epg_listings = new ArrayList();

    public List<CatchUpEpg> getEpg_listings() {
        return this.epg_listings;
    }

    public void setEpg_listings(List<CatchUpEpg> list) {
        this.epg_listings = list;
    }

    public String toString() {
        return "CatchUpEpgResponse{epg_listings=" + this.epg_listings + '}';
    }
}
