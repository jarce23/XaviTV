package app.shamel.tv.models;

import java.io.Serializable;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ResumeModel implements Serializable {
    public long last_position;
    public String name;
    public int pro;
    public String tmdb_id = _UrlKt.FRAGMENT_ENCODE_SET;

    public long getLast_position() {
        return this.last_position;
    }

    public String getName() {
        return this.name;
    }

    public int getPro() {
        return this.pro;
    }

    public String getTmdb_id() {
        return this.tmdb_id;
    }

    public void setLast_position(long j10) {
        this.last_position = j10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPro(int i10) {
        this.pro = i10;
    }

    public void setTmdb_id(String str) {
        this.tmdb_id = str;
    }
}
