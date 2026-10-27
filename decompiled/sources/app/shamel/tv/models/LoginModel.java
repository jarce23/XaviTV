package app.shamel.tv.models;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class LoginModel implements Serializable {
    private String active_cons;
    private String auth;
    private Long created_at;
    private Long exp_date = 0L;
    private String max_connections;
    private String message;
    private String password;
    private String status;
    private String username;

    public String getActive_cons() {
        return this.active_cons;
    }

    public String getAuth() {
        return this.auth;
    }

    public Long getCreated_at() {
        return this.created_at;
    }

    public Long getExp_date() {
        return this.exp_date;
    }

    public String getMax_connections() {
        return this.max_connections;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPassword() {
        return this.password;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUsername() {
        return this.username;
    }

    public void setActive_cons(String str) {
        this.active_cons = str;
    }

    public void setAuth(String str) {
        this.auth = str;
    }

    public void setCreated_at(Long l10) {
        this.created_at = l10;
    }

    public void setExp_date(Long l10) {
        this.exp_date = l10;
    }

    public void setMax_connections(String str) {
        this.max_connections = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        return "LoginModel{username='" + this.username + "', password='" + this.password + "', status='" + this.status + "', auth='" + this.auth + "', exp_date='" + this.exp_date + "', created_at='" + this.created_at + "'}";
    }
}
