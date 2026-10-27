package app.shamel.tv.models;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CastModel implements Serializable {
    public boolean adult;
    public int cast_id;
    public String character;
    public String credit_id;
    public int gender;
    public int id;
    public String known_for_department;
    public String name;
    public int order;
    public String original_name;
    public float popularity;
    public String profile_path;

    public int getCast_id() {
        return this.cast_id;
    }

    public String getCharacter() {
        return this.character;
    }

    public String getCredit_id() {
        return this.credit_id;
    }

    public int getGender() {
        return this.gender;
    }

    public int getId() {
        return this.id;
    }

    public String getKnown_for_department() {
        return this.known_for_department;
    }

    public String getName() {
        return this.name;
    }

    public int getOrder() {
        return this.order;
    }

    public String getOriginal_name() {
        return this.original_name;
    }

    public float getPopularity() {
        return this.popularity;
    }

    public String getProfile_path() {
        return this.profile_path;
    }

    public boolean isAdult() {
        return this.adult;
    }

    public String toString() {
        return "CastModel{adult='" + this.adult + "', gender=" + this.gender + ", id=" + this.id + ", known_for_department='" + this.known_for_department + "', name='" + this.name + "', original_name='" + this.original_name + "', popularity=" + this.popularity + ", profile_path='" + this.profile_path + "', cast_id=" + this.cast_id + ", character='" + this.character + "', credit_id='" + this.credit_id + "', order=" + this.order + '}';
    }
}
