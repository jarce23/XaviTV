package app.shamel.tv.apps;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class LTVApp extends Application {

    /* renamed from: r, reason: collision with root package name */
    public static long f2083r;

    /* renamed from: s, reason: collision with root package name */
    public static String f2084s;

    /* renamed from: t, reason: collision with root package name */
    public static LTVApp f2085t;

    /* renamed from: u, reason: collision with root package name */
    public static ArrayList f2086u = new ArrayList();

    /* renamed from: v, reason: collision with root package name */
    public static ArrayList f2087v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    public static ArrayList f2088w = new ArrayList();

    /* renamed from: x, reason: collision with root package name */
    public static String f2089x = "1.0";

    /* renamed from: y, reason: collision with root package name */
    public static int f2090y = 1;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f2091o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f2092p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f2093q = new ArrayList();

    public static LTVApp a() {
        if (f2085t == null) {
            f2085t = new LTVApp();
        }
        return f2085t;
    }

    public static void c() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
    }

    public final void b() {
        PackageInfo packageInfo;
        String str;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e7) {
            e7.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null || (str = packageInfo.versionName) == null) {
            f2089x = "1.0";
        } else {
            f2089x = str;
        }
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        f2085t = this;
    }
}
