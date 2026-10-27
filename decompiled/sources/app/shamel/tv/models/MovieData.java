package app.shamel.tv.models;

import android.support.v4.media.d;
import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MovieData implements Serializable {
    private String added;
    private String category_id;
    private String container_extension;
    private String custom_sid;
    private String direct_source;
    private String name;
    private String stream_id;

    public String getAdded() {
        return this.added;
    }

    public String getCategory_id() {
        return this.category_id;
    }

    public String getContainer_extension() {
        return this.container_extension;
    }

    public String getCustom_sid() {
        return this.custom_sid;
    }

    public String getDirect_source() {
        return this.direct_source;
    }

    public String getName() {
        return this.name;
    }

    public String getStream_id() {
        return this.stream_id;
    }

    public void setAdded(String str) {
        this.added = str;
    }

    public void setCategory_id(String str) {
        this.category_id = str;
    }

    public void setContainer_extension(String str) {
        this.container_extension = str;
    }

    public void setCustom_sid(String str) {
        this.custom_sid = str;
    }

    public void setDirect_source(String str) {
        this.direct_source = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStream_id(String str) {
        this.stream_id = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("MovieData{stream_id='");
        sb2.append(this.stream_id);
        sb2.append("', name='");
        sb2.append(this.name);
        sb2.append("', added='");
        sb2.append(this.added);
        sb2.append("', category_id='");
        sb2.append(this.category_id);
        sb2.append("', container_extension='");
        sb2.append(this.container_extension);
        sb2.append("', custom_sid='");
        sb2.append(this.custom_sid);
        sb2.append("', direct_source='");
        return d.r(sb2, this.direct_source, "'}");
    }
}
