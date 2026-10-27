package app.shamel.tv.models;

import android.support.v4.media.d;
import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ServerModel implements Serializable {
    private String time_now;
    private long timestamp_now = 0;

    public String getTime_now() {
        return this.time_now;
    }

    public long getTimestamp_now() {
        return this.timestamp_now;
    }

    public void setTime_now(String str) {
        this.time_now = str;
    }

    public void setTimestamp_now(long j10) {
        this.timestamp_now = j10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ServerModel{timestamp_now='");
        sb2.append(this.timestamp_now);
        sb2.append("', time_now='");
        return d.r(sb2, this.time_now, "'}");
    }
}
