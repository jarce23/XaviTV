package app.shamel.tv.models;

import android.support.v4.media.d;
import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class TMDBVideoModel implements Serializable {
    public String id;
    public String key;
    public String name;
    public String published_at;
    public String site;
    public String type;

    public String getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getPublished_at() {
        return this.published_at;
    }

    public String getSite() {
        return this.site;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("TMDBVideoModel{name='");
        sb2.append(this.name);
        sb2.append("', key='");
        sb2.append(this.key);
        sb2.append("', site='");
        sb2.append(this.site);
        sb2.append("', type='");
        sb2.append(this.type);
        sb2.append("', published_at='");
        sb2.append(this.published_at);
        sb2.append("', id='");
        return d.r(sb2, this.id, "'}");
    }
}
