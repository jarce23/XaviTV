package app.shamel.tv.helper;

import android.content.Context;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.WordModels;
import com.google.gson.Gson;
import java.net.URL;
import java.util.ArrayList;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a {
    public static boolean a(String str) {
        if (!str.contains("/")) {
            return false;
        }
        try {
            if (str.contains("playlist")) {
                return str.split("/")[3].equalsIgnoreCase("playlist");
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String b(Context context) {
        new Gson();
        return context.getSharedPreferences("PREF", 0).getInt("time_format", 0) == 0 ? "hh:mm a" : "HH:mm";
    }

    public static ArrayList c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CategoryModel("resume_id", "Recently Viewed"));
        arrayList.add(new CategoryModel("fav_id", "Favorite"));
        return arrayList;
    }

    public static ArrayList d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CategoryModel("all_id", "All"));
        arrayList.add(new CategoryModel("fav_id", "Favorite"));
        return arrayList;
    }

    public static String e(String str) {
        try {
            URL url = new URL(str.replaceAll(" ", _UrlKt.FRAGMENT_ENCODE_SET).trim());
            return url.getProtocol() + "://" + url.getAuthority();
        } catch (Exception unused) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
    }

    public static String f(String str, String str2, String str3, String str4, String str5) {
        return str + "/series/" + str2 + "/" + str3 + "/" + str4 + "." + str5;
    }

    public static String g(String str, String str2, String str3, String str4, String str5) {
        return str + "/live/" + str2 + "/" + str3 + "/" + str4 + "." + str5;
    }

    public static String h(String str, String str2, String str3, String str4, String str5) {
        return str + "/movie/" + str2 + "/" + str3 + "/" + str4 + "." + str5;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int i(e5.k r4) {
        /*
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.String r1 = "PREF"
            r2 = 0
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r1, r2)
            java.lang.String r1 = "APP_INFO_MODEL"
            java.lang.String r3 = ""
            java.lang.String r1 = r4.getString(r1, r3)     // Catch: java.lang.Exception -> L25
            if (r1 == 0) goto L25
            boolean r3 = r1.isEmpty()     // Catch: java.lang.Exception -> L25
            if (r3 != 0) goto L25
            java.lang.Class<app.shamel.tv.models.AppInfoModel> r3 = app.shamel.tv.models.AppInfoModel.class
            java.lang.Object r0 = r0.fromJson(r1, r3)     // Catch: java.lang.Exception -> L25
            app.shamel.tv.models.AppInfoModel r0 = (app.shamel.tv.models.AppInfoModel) r0     // Catch: java.lang.Exception -> L25
            goto L26
        L25:
            r0 = 0
        L26:
            java.lang.String r1 = "playlist_position"
            int r4 = r4.getInt(r1, r2)
            java.util.List r0 = r0.getResult()
            int r0 = r0.size()
            int r0 = r0 + (-1)
            if (r4 <= r0) goto L39
            return r2
        L39:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.helper.a.i(e5.k):int");
    }

    public static ArrayList j(WordModels wordModels) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(wordModels.getOrder_by_number());
        arrayList.add(wordModels.getOrder_by_added());
        arrayList.add(wordModels.getOrder_by_rating());
        arrayList.add(wordModels.getSort_a_z());
        arrayList.add(wordModels.getSort_z_a());
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r5.isEmpty() == false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static app.shamel.tv.models.WordModels k(android.content.Context r7) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "language_code"
            com.google.gson.Gson r2 = new com.google.gson.Gson
            r2.<init>()
            java.lang.String r3 = "PREF"
            r4 = 0
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r3, r4)
            r3 = 0
            java.lang.String r5 = r7.getString(r1, r0)     // Catch: java.lang.Exception -> L1e
            if (r5 == 0) goto L1e
            boolean r6 = r5.isEmpty()     // Catch: java.lang.Exception -> L1e
            if (r6 != 0) goto L1e
            goto L1f
        L1e:
            r5 = r3
        L1f:
            java.lang.String r6 = "APP_INFO_MODEL"
            java.lang.String r0 = r7.getString(r6, r0)     // Catch: java.lang.Exception -> L36
            if (r0 == 0) goto L36
            boolean r6 = r0.isEmpty()     // Catch: java.lang.Exception -> L36
            if (r6 != 0) goto L36
            java.lang.Class<app.shamel.tv.models.AppInfoModel> r6 = app.shamel.tv.models.AppInfoModel.class
            java.lang.Object r0 = r2.fromJson(r0, r6)     // Catch: java.lang.Exception -> L36
            app.shamel.tv.models.AppInfoModel r0 = (app.shamel.tv.models.AppInfoModel) r0     // Catch: java.lang.Exception -> L36
            r3 = r0
        L36:
            if (r3 == 0) goto La5
            r0 = r4
        L39:
            java.util.List r2 = r3.getLanguageModels()
            int r2 = r2.size()
            if (r0 >= r2) goto L69
            java.util.List r2 = r3.getLanguageModels()
            java.lang.Object r2 = r2.get(r0)
            app.shamel.tv.models.LanguageModel r2 = (app.shamel.tv.models.LanguageModel) r2
            java.lang.String r2 = r2.getCode()
            boolean r2 = r5.equalsIgnoreCase(r2)
            if (r2 == 0) goto L66
            java.util.List r7 = r3.getLanguageModels()
            java.lang.Object r7 = r7.get(r0)
            app.shamel.tv.models.LanguageModel r7 = (app.shamel.tv.models.LanguageModel) r7
            app.shamel.tv.models.WordModels r7 = r7.getWordModel()
            return r7
        L66:
            int r0 = r0 + 1
            goto L39
        L69:
            java.util.List r0 = r3.getLanguageModels()
            int r0 = r0.size()
            if (r4 >= r0) goto La5
            java.util.List r0 = r3.getLanguageModels()
            java.lang.Object r0 = r0.get(r4)
            app.shamel.tv.models.LanguageModel r0 = (app.shamel.tv.models.LanguageModel) r0
            java.lang.String r0 = r0.getCode()
            java.lang.String r2 = "en"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto La2
            android.content.SharedPreferences$Editor r7 = r7.edit()
            r7.putString(r1, r2)
            r7.apply()
            java.util.List r7 = r3.getLanguageModels()
            java.lang.Object r7 = r7.get(r4)
            app.shamel.tv.models.LanguageModel r7 = (app.shamel.tv.models.LanguageModel) r7
            app.shamel.tv.models.WordModels r7 = r7.getWordModel()
            return r7
        La2:
            int r4 = r4 + 1
            goto L69
        La5:
            app.shamel.tv.models.WordModels r7 = new app.shamel.tv.models.WordModels
            r7.<init>()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.helper.a.k(android.content.Context):app.shamel.tv.models.WordModels");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if (r3.isEmpty() == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean l(android.content.Context r3) {
        /*
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.String r0 = "PREF"
            r1 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r0, r1)
            java.lang.String r0 = "device_type"
            java.lang.String r2 = ""
            java.lang.String r3 = r3.getString(r0, r2)     // Catch: java.lang.Exception -> L1d
            if (r3 == 0) goto L1d
            boolean r0 = r3.isEmpty()     // Catch: java.lang.Exception -> L1d
            if (r0 != 0) goto L1d
            goto L1e
        L1d:
            r3 = 0
        L1e:
            java.lang.String r0 = "tv"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L30
            java.lang.String r0 = "amazon"
            boolean r3 = r3.equalsIgnoreCase(r0)
            if (r3 == 0) goto L2f
            goto L30
        L2f:
            return r1
        L30:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.helper.a.l(android.content.Context):boolean");
    }
}
