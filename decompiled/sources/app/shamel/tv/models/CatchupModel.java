package app.shamel.tv.models;

import java.io.Serializable;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CatchupModel implements Serializable {
    private String dayofweek;
    private List<CatchUpEpg> epgEvents;
    private String name;

    public String getDayofweek() {
        return this.dayofweek;
    }

    public List<CatchUpEpg> getEpgEvents() {
        return this.epgEvents;
    }

    public String getName() {
        return this.name;
    }

    public void setDayofweek(String str) {
        this.dayofweek = str;
    }

    public void setEpgEvents(List<CatchUpEpg> list) {
        this.epgEvents = list;
    }

    public void setName(String str) {
        this.name = str;
    }
}
