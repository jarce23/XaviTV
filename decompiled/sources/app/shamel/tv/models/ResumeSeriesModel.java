package app.shamel.tv.models;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ResumeSeriesModel implements Serializable {
    public int episode_pos;
    public String name;
    public int season_pos;

    public int getEpisode_pos() {
        return this.episode_pos;
    }

    public String getName() {
        return this.name;
    }

    public int getSeason_pos() {
        return this.season_pos;
    }

    public void setEpisode_pos(int i10) {
        this.episode_pos = i10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSeason_pos(int i10) {
        this.season_pos = i10;
    }
}
