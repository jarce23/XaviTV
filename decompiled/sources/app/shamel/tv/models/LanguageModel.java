package app.shamel.tv.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class LanguageModel implements Serializable {

    @SerializedName("code")
    private String code;

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("words")
    private WordModels wordModels;

    public String getCode() {
        return this.code;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public WordModels getWordModel() {
        return this.wordModels;
    }
}
