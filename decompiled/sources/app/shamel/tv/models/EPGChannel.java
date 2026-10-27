package app.shamel.tv.models;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.annotations.SerializedName;
import io.realm.internal.y;
import io.realm.k0;
import ja.a;
import java.io.Serializable;
import java.util.Random;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class EPGChannel extends k0 implements Serializable {

    @SerializedName("epg_channel_id")
    private String Id;

    @SerializedName("added")
    private String added;

    @SerializedName("category_id")
    private String category_id;
    private String category_name;
    private int cell;
    private int channelID;

    @SerializedName("custom_sid")
    private String custom_sid;

    @SerializedName("direct_source")
    private String direct_source;
    private boolean is_favorite;
    private boolean is_locked;
    private boolean is_recent;

    @SerializedName("name")
    private String name;

    @SerializedName("num")
    private String num;
    private long recent_pos;
    public boolean selected;

    @SerializedName("stream_icon")
    private String stream_icon;

    @SerializedName("stream_id")
    private String stream_id;

    @SerializedName("stream_type")
    private String stream_type;

    @SerializedName("tv_archive")
    private String tv_archive;

    @SerializedName("tv_archive_duration")
    private String tv_archive_duration;
    private String url;

    /* JADX WARN: Multi-variable type inference failed */
    public EPGChannel() {
        boolean z10 = this instanceof y;
        if (z10) {
            ((y) this).b();
        }
        if (z10) {
            ((y) this).b();
        }
        setNum(_UrlKt.FRAGMENT_ENCODE_SET);
        setName(_UrlKt.FRAGMENT_ENCODE_SET);
        setStream_type(_UrlKt.FRAGMENT_ENCODE_SET);
        setStream_id("-1");
        setStream_icon(_UrlKt.FRAGMENT_ENCODE_SET);
        setId(_UrlKt.FRAGMENT_ENCODE_SET);
        setAdded(_UrlKt.FRAGMENT_ENCODE_SET);
        setCategory_id("-1");
        setCustom_sid(_UrlKt.FRAGMENT_ENCODE_SET);
        setTv_archive("0");
        setDirect_source(_UrlKt.FRAGMENT_ENCODE_SET);
        setTv_archive_duration(_UrlKt.FRAGMENT_ENCODE_SET);
        setIs_locked(false);
        setIs_favorite(false);
        setIs_recent(false);
        setRecent_pos(0L);
        setCell(-1);
        setChannelID(0);
    }

    public static EPGChannel fromM3UItem(a aVar) {
        EPGChannel ePGChannel;
        try {
            ePGChannel = new EPGChannel();
            ePGChannel.setCategory_name(TextUtils.isEmpty(aVar.a()) ? "All" : aVar.a());
            if (!TextUtils.isEmpty(aVar.f7507a)) {
                ePGChannel.setId(aVar.f7507a);
            }
            if (!TextUtils.isEmpty(aVar.f7508b)) {
                ePGChannel.setName(aVar.f7508b);
            }
        } catch (Exception e7) {
            Log.e("EPGChannel", "fromM3UItem", e7);
            return null;
        }
        if (!TextUtils.isEmpty(aVar.f7513h)) {
            ePGChannel.setUrl(aVar.f7513h);
            if (aVar.f7513h.contains("live")) {
                try {
                    String str = ePGChannel.getUrl().split("/")[6];
                    if (str.contains(".")) {
                        ePGChannel.setStream_id(str.split("\\.")[0]);
                    } else {
                        ePGChannel.setStream_id(str);
                    }
                } catch (Exception unused) {
                    ePGChannel.setStream_id(_UrlKt.FRAGMENT_ENCODE_SET + new Random().nextInt());
                }
            } else {
                try {
                    ePGChannel.setStream_id(ePGChannel.getUrl().split("/")[5]);
                } catch (Exception unused2) {
                    ePGChannel.setStream_id(_UrlKt.FRAGMENT_ENCODE_SET + new Random().nextInt());
                }
            }
            Log.e("EPGChannel", "fromM3UItem", e7);
            return null;
        }
        if (!TextUtils.isEmpty(aVar.f7512f)) {
            ePGChannel.setStream_icon(aVar.f7512f);
        }
        return ePGChannel;
    }

    public String getAdded() {
        return realmGet$added();
    }

    public String getCategory_id() {
        return realmGet$category_id() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$category_id();
    }

    public String getCategory_name() {
        return realmGet$category_name() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$category_name();
    }

    public int getCell() {
        return realmGet$cell();
    }

    public int getChannelID() {
        return realmGet$channelID();
    }

    public String getCustom_sid() {
        return realmGet$custom_sid();
    }

    public String getDirect_source() {
        return realmGet$direct_source();
    }

    public String getId() {
        return realmGet$Id();
    }

    public String getName() {
        return realmGet$name() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$name();
    }

    public String getNum() {
        return realmGet$num() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$num();
    }

    public long getRecent_pos() {
        return realmGet$recent_pos();
    }

    public String getStream_icon() {
        return realmGet$stream_icon() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$stream_icon();
    }

    public String getStream_id() {
        return realmGet$stream_id() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$stream_id();
    }

    public String getStream_type() {
        return realmGet$stream_type();
    }

    public String getTv_archive() {
        return realmGet$tv_archive();
    }

    public String getTv_archive_duration() {
        return realmGet$tv_archive_duration();
    }

    public String getUrl() {
        return realmGet$url() == null ? _UrlKt.FRAGMENT_ENCODE_SET : realmGet$url();
    }

    public boolean isSelected() {
        return realmGet$selected();
    }

    public boolean is_favorite() {
        return realmGet$is_favorite();
    }

    public boolean is_locked() {
        return realmGet$is_locked();
    }

    public boolean is_recent() {
        return realmGet$is_recent();
    }

    public String realmGet$Id() {
        return this.Id;
    }

    public String realmGet$added() {
        return this.added;
    }

    public String realmGet$category_id() {
        return this.category_id;
    }

    public String realmGet$category_name() {
        return this.category_name;
    }

    public int realmGet$cell() {
        return this.cell;
    }

    public int realmGet$channelID() {
        return this.channelID;
    }

    public String realmGet$custom_sid() {
        return this.custom_sid;
    }

    public String realmGet$direct_source() {
        return this.direct_source;
    }

    public boolean realmGet$is_favorite() {
        return this.is_favorite;
    }

    public boolean realmGet$is_locked() {
        return this.is_locked;
    }

    public boolean realmGet$is_recent() {
        return this.is_recent;
    }

    public String realmGet$name() {
        return this.name;
    }

    public String realmGet$num() {
        return this.num;
    }

    public long realmGet$recent_pos() {
        return this.recent_pos;
    }

    public boolean realmGet$selected() {
        return this.selected;
    }

    public String realmGet$stream_icon() {
        return this.stream_icon;
    }

    public String realmGet$stream_id() {
        return this.stream_id;
    }

    public String realmGet$stream_type() {
        return this.stream_type;
    }

    public String realmGet$tv_archive() {
        return this.tv_archive;
    }

    public String realmGet$tv_archive_duration() {
        return this.tv_archive_duration;
    }

    public String realmGet$url() {
        return this.url;
    }

    public void realmSet$Id(String str) {
        this.Id = str;
    }

    public void realmSet$added(String str) {
        this.added = str;
    }

    public void realmSet$category_id(String str) {
        this.category_id = str;
    }

    public void realmSet$category_name(String str) {
        this.category_name = str;
    }

    public void realmSet$cell(int i10) {
        this.cell = i10;
    }

    public void realmSet$channelID(int i10) {
        this.channelID = i10;
    }

    public void realmSet$custom_sid(String str) {
        this.custom_sid = str;
    }

    public void realmSet$direct_source(String str) {
        this.direct_source = str;
    }

    public void realmSet$is_favorite(boolean z10) {
        this.is_favorite = z10;
    }

    public void realmSet$is_locked(boolean z10) {
        this.is_locked = z10;
    }

    public void realmSet$is_recent(boolean z10) {
        this.is_recent = z10;
    }

    public void realmSet$name(String str) {
        this.name = str;
    }

    public void realmSet$num(String str) {
        this.num = str;
    }

    public void realmSet$recent_pos(long j10) {
        this.recent_pos = j10;
    }

    public void realmSet$selected(boolean z10) {
        this.selected = z10;
    }

    public void realmSet$stream_icon(String str) {
        this.stream_icon = str;
    }

    public void realmSet$stream_id(String str) {
        this.stream_id = str;
    }

    public void realmSet$stream_type(String str) {
        this.stream_type = str;
    }

    public void realmSet$tv_archive(String str) {
        this.tv_archive = str;
    }

    public void realmSet$tv_archive_duration(String str) {
        this.tv_archive_duration = str;
    }

    public void realmSet$url(String str) {
        this.url = str;
    }

    public void setAdded(String str) {
        realmSet$added(str);
    }

    public void setCategory_id(String str) {
        realmSet$category_id(str);
    }

    public void setCategory_name(String str) {
        realmSet$category_name(str);
    }

    public void setCell(int i10) {
        realmSet$cell(i10);
    }

    public void setChannelID(int i10) {
        realmSet$channelID(i10);
    }

    public void setCustom_sid(String str) {
        realmSet$custom_sid(str);
    }

    public void setDirect_source(String str) {
        realmSet$direct_source(str);
    }

    public void setId(String str) {
        realmSet$Id(str);
    }

    public void setIs_favorite(boolean z10) {
        realmSet$is_favorite(z10);
    }

    public void setIs_locked(boolean z10) {
        realmSet$is_locked(z10);
    }

    public void setIs_recent(boolean z10) {
        realmSet$is_recent(z10);
    }

    public void setName(String str) {
        realmSet$name(str);
    }

    public void setNum(String str) {
        realmSet$num(str);
    }

    public void setRecent_pos(long j10) {
        realmSet$recent_pos(j10);
    }

    public void setSelected(boolean z10) {
        realmSet$selected(z10);
    }

    public void setStream_icon(String str) {
        realmSet$stream_icon(str);
    }

    public void setStream_id(String str) {
        realmSet$stream_id(str);
    }

    public void setStream_type(String str) {
        realmSet$stream_type(str);
    }

    public void setTv_archive(String str) {
        realmSet$tv_archive(str);
    }

    public void setTv_archive_duration(String str) {
        realmSet$tv_archive_duration(str);
    }

    public void setUrl(String str) {
        realmSet$url(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EPGChannel(String str, String str2, int i10, String str3, String str4, String str5) {
        boolean z10 = this instanceof y;
        if (z10) {
            ((y) this).b();
        }
        if (z10) {
            ((y) this).b();
        }
        setNum(_UrlKt.FRAGMENT_ENCODE_SET);
        setName(_UrlKt.FRAGMENT_ENCODE_SET);
        setStream_type(_UrlKt.FRAGMENT_ENCODE_SET);
        setStream_id("-1");
        setStream_icon(_UrlKt.FRAGMENT_ENCODE_SET);
        setId(_UrlKt.FRAGMENT_ENCODE_SET);
        setAdded(_UrlKt.FRAGMENT_ENCODE_SET);
        setCategory_id("-1");
        setCustom_sid(_UrlKt.FRAGMENT_ENCODE_SET);
        setTv_archive("0");
        setDirect_source(_UrlKt.FRAGMENT_ENCODE_SET);
        setTv_archive_duration(_UrlKt.FRAGMENT_ENCODE_SET);
        setIs_locked(false);
        setIs_favorite(false);
        setIs_recent(false);
        setRecent_pos(0L);
        setCell(-1);
        setChannelID(0);
        setStream_icon(str);
        setName(str2);
        setChannelID(i10);
        setId(str3);
        setNum(str4);
        setStream_id(str5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EPGChannel(String str, String str2, String str3) {
        boolean z10 = this instanceof y;
        if (z10) {
            ((y) this).b();
        }
        if (z10) {
            ((y) this).b();
        }
        setNum(_UrlKt.FRAGMENT_ENCODE_SET);
        setName(_UrlKt.FRAGMENT_ENCODE_SET);
        setStream_type(_UrlKt.FRAGMENT_ENCODE_SET);
        setStream_id("-1");
        setStream_icon(_UrlKt.FRAGMENT_ENCODE_SET);
        setId(_UrlKt.FRAGMENT_ENCODE_SET);
        setAdded(_UrlKt.FRAGMENT_ENCODE_SET);
        setCategory_id("-1");
        setCustom_sid(_UrlKt.FRAGMENT_ENCODE_SET);
        setTv_archive("0");
        setDirect_source(_UrlKt.FRAGMENT_ENCODE_SET);
        setTv_archive_duration(_UrlKt.FRAGMENT_ENCODE_SET);
        setIs_locked(false);
        setIs_favorite(false);
        setIs_recent(false);
        setRecent_pos(0L);
        setCell(-1);
        setChannelID(0);
        setStream_icon(str);
        setName(str2);
        setId(str3);
    }
}
