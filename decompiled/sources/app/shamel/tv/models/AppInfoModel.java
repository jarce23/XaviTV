package app.shamel.tv.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class AppInfoModel implements Serializable {

    @SerializedName("apk_link")
    private String apk_link;

    @SerializedName("app_version")
    private String app_version;

    @SerializedName("device_key")
    private String device_key;

    @SerializedName("expire_date")
    private String expiredDate;
    private boolean is_google_pay;

    @SerializedName("is_trial")
    private int is_trial;

    @SerializedName("languages")
    private List<LanguageModel> languageModels;

    @SerializedName("lock")
    private int lock;

    @SerializedName("mac_address")
    private String mac_address;

    @SerializedName("parent_control")
    private String parent_control;

    @SerializedName("parent_synced")
    private int parent_synced;

    @SerializedName("pin")
    private String pin_code;

    @SerializedName("plan_id")
    private String plan_id;

    @SerializedName("price")
    private String price;

    @SerializedName("urls")
    private List<UrlModel> result;

    @SerializedName("mac_registered")
    private boolean success;

    @SerializedName("android_testing")
    private AndroidTestingModel testingModel;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static class AndroidTestingModel implements Serializable {

        @SerializedName("ibo")
        private boolean is_ibo;

        @SerializedName("vu")
        private boolean is_vu;

        public boolean isIs_ibo() {
            return this.is_ibo;
        }

        public boolean isIs_vu() {
            return this.is_vu;
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static class UrlModel implements Serializable {

        @SerializedName("id")
        private String id;

        @SerializedName("is_protected")
        private String is_protected;

        @SerializedName("name")
        private String name;

        @SerializedName("type")
        private String type;

        @SerializedName("url")
        private String url;

        public String getId() {
            return this.id;
        }

        public String getIs_protected() {
            String str = this.is_protected;
            return str == null ? "0" : str;
        }

        public String getName() {
            return this.name;
        }

        public String getType() {
            return this.type;
        }

        public String getUrl() {
            String str = this.url;
            return str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public String getApk_link() {
        return this.apk_link;
    }

    public String getApp_version() {
        String str = this.app_version;
        return str == null ? "1.0" : str;
    }

    public String getDevice_key() {
        return this.device_key;
    }

    public String getExpiredDate() {
        String str = this.expiredDate;
        return str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
    }

    public int getIs_trial() {
        return this.is_trial;
    }

    public List<LanguageModel> getLanguageModels() {
        List<LanguageModel> list = this.languageModels;
        return list == null ? new ArrayList() : list;
    }

    public int getLock() {
        return this.lock;
    }

    public String getMac_address() {
        return this.mac_address;
    }

    public String getParent_control() {
        String str = this.parent_control;
        return (str == null || str.isEmpty()) ? "0000" : this.parent_control;
    }

    public int getParent_synced() {
        return this.parent_synced;
    }

    public String getPin_code() {
        String str = this.pin_code;
        return str == null ? "0000" : str;
    }

    public String getPlan_id() {
        return this.plan_id;
    }

    public String getPrice() {
        String str = this.price;
        return (str == null || str.isEmpty()) ? "-.-" : this.price;
    }

    public List<UrlModel> getResult() {
        List<UrlModel> list = this.result;
        return list == null ? new ArrayList() : list;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public AndroidTestingModel getTestingModel() {
        AndroidTestingModel androidTestingModel = this.testingModel;
        return androidTestingModel == null ? new AndroidTestingModel() : androidTestingModel;
    }

    public boolean isIs_google_pay() {
        return this.is_google_pay;
    }

    public void setExpiredDate(String str) {
        this.expiredDate = str;
    }

    public void setIs_google_pay(boolean z10) {
        this.is_google_pay = z10;
    }

    public void setIs_trial(int i10) {
        this.is_trial = i10;
    }

    public void setLanguageModels(List<LanguageModel> list) {
        this.languageModels = list;
    }

    public void setLock(int i10) {
        this.lock = i10;
    }

    public void setPin_code(String str) {
        this.pin_code = str;
    }

    public void setResult(List<UrlModel> list) {
        this.result = list;
    }
}
