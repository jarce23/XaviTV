package app.shamel.tv.models;

import android.support.v4.media.d;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CategoryModel implements Serializable {

    @SerializedName("category_id")
    private String id;

    @SerializedName("category_name")
    private String name;

    public CategoryModel(String str, String str2) {
        this.id = str;
        this.name = str2;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        String str = this.name;
        return (str == null || str.isEmpty()) ? "Unknown category" : this.name.contains("!@#%") ? this.name.split("!@#%")[1] : this.name;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("CategoryModel{category_id='");
        sb2.append(this.id);
        sb2.append("', category_name='");
        return d.r(sb2, this.name, "'}");
    }
}
