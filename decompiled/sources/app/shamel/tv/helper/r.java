package app.shamel.tv.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import app.shamel.tv.models.AppInfoModel;
import app.shamel.tv.models.LoginModel;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final Gson f2097a = new Gson();

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f2098b;

    public r(Context context) {
        this.f2098b = context.getSharedPreferences("PREF", 0);
    }

    public final List A() {
        try {
            String string = this.f2098b.getString("episode_resume_model" + H(), _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new f().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final String B() {
        try {
            String string = this.f2098b.getString("server_url", _UrlKt.FRAGMENT_ENCODE_SET);
            return string == null ? _UrlKt.FRAGMENT_ENCODE_SET : string;
        } catch (Exception unused) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
    }

    public final String C() {
        try {
            return this.f2098b.getString("subtitle_bg_color", "#00ffffff");
        } catch (Exception unused) {
            return "#00ffffff";
        }
    }

    public final String D() {
        try {
            return this.f2098b.getString("subtitle_color", "#ffffff");
        } catch (Exception unused) {
            return "#ffffff";
        }
    }

    public final boolean E() {
        try {
            return this.f2098b.getBoolean("subtitle_enable", false);
        } catch (Exception unused) {
            return false;
        }
    }

    public final int F() {
        try {
            return this.f2098b.getInt("subtitle_font", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final int G() {
        return this.f2098b.getInt("update_period", 1);
    }

    public final String H() {
        try {
            return this.f2098b.getString("user_id", _UrlKt.FRAGMENT_ENCODE_SET);
        } catch (Exception unused) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
    }

    public final String I() {
        try {
            String string = this.f2098b.getString("user_name", _UrlKt.FRAGMENT_ENCODE_SET);
            return string == null ? _UrlKt.FRAGMENT_ENCODE_SET : string;
        } catch (Exception unused) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
    }

    public final List J() {
        try {
            String string = this.f2098b.getString("vod_category", _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new g().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final List K() {
        try {
            String string = this.f2098b.getString("vod_fav_names" + H(), _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new h().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final void L(AppInfoModel appInfoModel) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("APP_INFO_MODEL", this.f2097a.toJson(appInfoModel));
        edit.apply();
        edit.commit();
    }

    public final void M(int i10) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putInt("category_pos" + H(), i10);
        edit.apply();
    }

    public final void N(int i10) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putInt("channel_pos" + H(), i10);
        edit.apply();
    }

    public final void O(String str) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("device_type", str);
        edit.apply();
    }

    public final void P(boolean z10) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putBoolean("is_m3u", z10);
        edit.apply();
    }

    public final void Q(long j10) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putLong("last_playlist_date", j10);
        edit.apply();
    }

    public final void R(List list) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("live_category", this.f2097a.toJson(list));
        edit.apply();
    }

    public final void S(List list) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("live_fav_names" + H(), this.f2097a.toJson(list));
        edit.apply();
    }

    public final void T(ArrayList arrayList) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("live_lock_names" + H(), this.f2097a.toJson(arrayList));
        edit.apply();
    }

    public final void U(List list) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("my_group" + H(), this.f2097a.toJson(list));
        edit.apply();
        edit.commit();
    }

    public final void V(String str, List list) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString(str + H(), this.f2097a.toJson(list));
        edit.apply();
        edit.commit();
    }

    public final void W(ArrayList arrayList) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("series_recent_models" + H(), this.f2097a.toJson(arrayList));
        edit.apply();
    }

    public final void X(ArrayList arrayList) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("vod_resume_model" + H(), this.f2097a.toJson(arrayList));
        edit.apply();
        edit.commit();
    }

    public final void Y(List list) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("series_category", this.f2097a.toJson(list));
        edit.apply();
    }

    public final void Z(ArrayList arrayList) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("series_fav_names" + H(), this.f2097a.toJson(arrayList));
        edit.apply();
    }

    public final List a() {
        try {
            String string = this.f2098b.getString("live_category", _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new i().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final void a0(List list) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("episode_resume_model" + H(), this.f2097a.toJson(list));
        edit.apply();
        edit.commit();
    }

    public final AppInfoModel b() {
        try {
            String string = this.f2098b.getString("APP_INFO_MODEL", _UrlKt.FRAGMENT_ENCODE_SET);
            if (string == null || string.isEmpty()) {
                return null;
            }
            return (AppInfoModel) this.f2097a.fromJson(string, AppInfoModel.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void b0(int i10) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putInt("subtitle_font", i10);
        edit.apply();
    }

    public final int c() {
        try {
            return this.f2098b.getInt("category_pos" + H(), 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final void c0(List list) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("vod_category", this.f2097a.toJson(list));
        edit.apply();
    }

    public final int d() {
        try {
            return this.f2098b.getInt("channel_pos" + H(), 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final void d0(ArrayList arrayList) {
        SharedPreferences.Editor edit = this.f2098b.edit();
        edit.putString("vod_fav_names" + H(), this.f2097a.toJson(arrayList));
        edit.apply();
    }

    public final List e() {
        try {
            String string = this.f2098b.getString("episode_models", _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new j().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final int f() {
        try {
            return this.f2098b.getInt("external_player", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final boolean g() {
        try {
            return this.f2098b.getBoolean("is_m3u", false);
        } catch (Exception unused) {
            return false;
        }
    }

    public final List h() {
        try {
            String string = this.f2098b.getString("invisible_live_categories" + H(), _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new k().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final List i() {
        try {
            String string = this.f2098b.getString("invisible_series_categories" + H(), _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new l().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final List j() {
        try {
            String string = this.f2098b.getString("invisible_vod_categories" + H(), _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new m().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final boolean k() {
        try {
            return this.f2098b.getBoolean("is_allow_protocol", false);
        } catch (Exception unused) {
            return false;
        }
    }

    public final long l() {
        return this.f2098b.getLong("last_playlist_date", 0L);
    }

    public final List m() {
        try {
            String string = this.f2098b.getString("live_fav_names" + H(), _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new n().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final List n() {
        try {
            String string = this.f2098b.getString("live_lock_names" + H(), _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new o().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final int o() {
        return this.f2098b.getInt("live_order", 0);
    }

    public final String p() {
        try {
            String string = this.f2098b.getString("live_stream_format", _UrlKt.FRAGMENT_ENCODE_SET);
            return string != null ? !string.isEmpty() ? string : "ts" : "ts";
        } catch (Exception unused) {
            return "ts";
        }
    }

    public final LoginModel q() {
        try {
            String string = this.f2098b.getString("login_models", _UrlKt.FRAGMENT_ENCODE_SET);
            if (string == null || string.isEmpty()) {
                return null;
            }
            return (LoginModel) this.f2097a.fromJson(string, LoginModel.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String r() {
        try {
            String string = this.f2098b.getString("mac_address", _UrlKt.FRAGMENT_ENCODE_SET);
            if (string == null) {
                return null;
            }
            if (string.isEmpty()) {
                return null;
            }
            return string;
        } catch (Exception e7) {
            Log.e("PreferenceHelper", "getSharedPreferenceMacAddress", e7);
            return null;
        }
    }

    public final List s() {
        try {
            String string = this.f2098b.getString("my_group" + H(), _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new p().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final List t(String str) {
        try {
            String string = this.f2098b.getString(str + H(), _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new q().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final String u() {
        try {
            String string = this.f2098b.getString("parent_control", "0000");
            if (string != null) {
                if (!string.isEmpty()) {
                    return string;
                }
            }
        } catch (Exception e7) {
            Log.e("PreferenceHelper", "getSharedPreferenceParentPassword", e7);
        }
        return "0000";
    }

    public final String v() {
        try {
            String string = this.f2098b.getString("password", _UrlKt.FRAGMENT_ENCODE_SET);
            return string == null ? _UrlKt.FRAGMENT_ENCODE_SET : string;
        } catch (Exception unused) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
    }

    public final List w() {
        try {
            String string = this.f2098b.getString("series_recent_models" + H(), _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new b().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final List x() {
        try {
            String string = this.f2098b.getString("vod_resume_model" + H(), _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new c().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final List y() {
        try {
            String string = this.f2098b.getString("series_category", _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new d().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public final List z() {
        try {
            String string = this.f2098b.getString("series_fav_names" + H(), _UrlKt.FRAGMENT_ENCODE_SET);
            return (string == null || string.isEmpty()) ? new ArrayList() : (List) this.f2097a.fromJson(string, new e().getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }
}
