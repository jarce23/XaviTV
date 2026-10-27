package app.shamel.tv.models;

import android.util.Log;
import j9.w1;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import k5.j;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CatchUpEpg implements Serializable {
    private String channel_id;
    private String description;
    private String end;
    private long epg_id;
    private int has_archive;
    private long id;
    private String lang;
    private int now_playing;
    private String start;
    private long start_timestamp;
    private long stop_timestamp;
    private String title;

    public String getChannel_id() {
        return this.channel_id;
    }

    public String getDescription() {
        return this.description;
    }

    public int getDuration() {
        return (int) (((j.i(getEnd()).getTime() - j.i(getStart()).getTime()) / 1000) / 60);
    }

    public String getEnd() {
        return this.end;
    }

    public long getEpg_id() {
        return this.epg_id;
    }

    public int getHas_archive() {
        return this.has_archive;
    }

    public long getId() {
        return this.id;
    }

    public String getLang() {
        return this.lang;
    }

    public int getNow_playing() {
        return this.now_playing;
    }

    public int getProgress() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long stop_timestamp = getStop_timestamp() - getStart_timestamp();
        if (stop_timestamp != 0) {
            return (int) (((currentTimeMillis - getStart_timestamp()) * 100) / stop_timestamp);
        }
        return 1;
    }

    public String getStart() {
        return this.start;
    }

    public String getStartForUrl() {
        String start = getStart();
        w1[] w1VarArr = j.f7826a;
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(start);
            if (parse != null) {
                return new SimpleDateFormat("yyyy-MM-dd:HH-mm", Locale.getDefault()).format(parse);
            }
            Log.e("Utils", "decode64String: parsed date is null");
            return _UrlKt.FRAGMENT_ENCODE_SET;
        } catch (ParseException e7) {
            Log.e("Utils", "decode64String", e7);
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
    }

    public long getStart_timestamp() {
        return this.start_timestamp;
    }

    public long getStop_timestamp() {
        return this.stop_timestamp;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl(String str, String str2, String str3, String str4) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("/timeshift/");
        sb2.append(str2);
        sb2.append("/");
        sb2.append(str3);
        sb2.append("/");
        sb2.append(getDuration());
        sb2.append("/");
        sb2.append(getStartForUrl());
        sb2.append("/");
        return ((Object) sb2) + str4 + ".ts";
    }

    public void setChannel_id(String str) {
        this.channel_id = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setEnd(String str) {
        this.end = str;
    }

    public void setEpg_id(long j10) {
        this.epg_id = j10;
    }

    public void setHas_archive(int i10) {
        this.has_archive = i10;
    }

    public void setId(long j10) {
        this.id = j10;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setNow_playing(int i10) {
        this.now_playing = i10;
    }

    public void setStart(String str) {
        this.start = str;
    }

    public void setStart_timestamp(long j10) {
        this.start_timestamp = j10;
    }

    public void setStop_timestamp(long j10) {
        this.stop_timestamp = j10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "Epg{id=" + this.id + ", epg_id=" + this.epg_id + ", title='" + this.title + "', lang='" + this.lang + "', start='" + this.start + "', end='" + this.end + "', description='" + this.description + "', channel_id='" + this.channel_id + "', start_timestamp=" + this.start_timestamp + ", stop_timestamp=" + this.stop_timestamp + ", now_playing=" + this.now_playing + ", has_archive=" + this.has_archive + '}';
    }
}
