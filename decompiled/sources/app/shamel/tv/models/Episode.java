package app.shamel.tv.models;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class Episode implements Serializable {
    private String container_extension;
    private String episode_num;
    private String id;
    private Object info;
    private int season;
    private String title;

    public String getContainer_extension() {
        return this.container_extension;
    }

    public String getEpisode_num() {
        return this.episode_num;
    }

    public String getId() {
        return this.id;
    }

    public Object getInfo() {
        return this.info;
    }

    public int getSeason() {
        return this.season;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContainer_extension(String str) {
        this.container_extension = str;
    }

    public void setEpisode_num(String str) {
        this.episode_num = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setInfo(Object obj) {
        this.info = obj;
    }

    public void setSeason(int i10) {
        this.season = i10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "Episode{id='" + this.id + "', episode_num='" + this.episode_num + "', title='" + this.title + "', container_extension='" + this.container_extension + "', season=" + this.season + ", info=" + this.info + '}';
    }
}
