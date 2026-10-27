package k5;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.StrictMode;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.Log;
import androidx.emoji2.text.s;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.AppInfoModel;
import com.google.gson.Gson;
import j9.w1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final w1[] f7826a;

    /* renamed from: b, reason: collision with root package name */
    public static final x4.e[] f7827b;

    /* renamed from: c, reason: collision with root package name */
    public static final s[] f7828c;

    static {
        new SimpleDateFormat("yyyyMMddHHmmss Z", Locale.US);
        int i10 = 2;
        boolean z10 = false;
        f7826a = new w1[]{new w1(i10)};
        int i11 = 10;
        f7827b = new x4.e[]{new x4.e("com.mxtech.videoplayer.pro", "com.mxtech.videoplayer.ActivityScreen", i11, z10), new x4.e("com.mxtech.videoplayer.ad", "com.mxtech.videoplayer.ad.ActivityScreen", i11, z10)};
        f7828c = new s[]{new s("com.google.android.youtube.tv", z10, i10), new s("com.google.android.youtube", z10, i10), new s("com.amazon.firetv.youtube", z10, i10), new s("com.liskovsoft.videomanager", z10, i10)};
    }

    public static void a(Activity activity) {
        activity.getWindow().setFlags(1024, 1024);
        activity.getWindow().addFlags(128);
        activity.getWindow().getDecorView().setSystemUiVisibility(4098);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        if (activity.getResources().getConfiguration().getLayoutDirection() == 1) {
            Log.e("rtl", "ltr");
            Configuration configuration = activity.getResources().getConfiguration();
            configuration.setLocale(Locale.getDefault());
            configuration.setLayoutDirection(new Locale("en"));
            activity.createConfigurationContext(configuration);
        }
    }

    public static boolean b() {
        return Build.MANUFACTURER.toLowerCase().contains("amazon") || Build.MODEL.contains("AFT");
    }

    public static String c(long j10, f.j jVar) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return new SimpleDateFormat(app.shamel.tv.helper.a.b(jVar), Locale.getDefault()).format(calendar.getTime());
    }

    public static String d() {
        String str = _UrlKt.FRAGMENT_ENCODE_SET;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(LTVApp.a().getExternalFilesDir(null), "log.txt"));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    fileInputStream.close();
                    str = sb2.toString();
                    bufferedReader.close();
                    return str;
                }
                sb2.append(readLine);
                sb2.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e7) {
            Log.e("Utils", "ReadFile_001", e7);
            return str;
        } catch (IOException e8) {
            Log.e("Utils", "ReadFile_002", e8);
            return str;
        }
    }

    public static String e(String str) {
        try {
            return new String(Base64.decode(str, 0), StandardCharsets.UTF_8).trim();
        } catch (Exception e7) {
            Log.e("Utils", "decode64String", e7);
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
    }

    public static String f(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str);
            if (parse != null) {
                return new SimpleDateFormat("yyyy", Locale.getDefault()).format(parse);
            }
            Log.e("Utils", "formateDateFromstring: parsed date is null");
            return _UrlKt.FRAGMENT_ENCODE_SET;
        } catch (ParseException e7) {
            Log.e("Utils", "formateDateFromstring", e7);
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
    }

    public static String g(Long l10) {
        if (l10 == null) {
            return "unlimited";
        }
        try {
            if (l10.longValue() == 0) {
                return "unlimited";
            }
            try {
                Calendar calendar = Calendar.getInstance(Locale.getDefault());
                calendar.setTimeInMillis(l10.longValue() * 1000);
                return DateFormat.format("yyyy-MM-dd", calendar).toString();
            } catch (Exception e7) {
                Log.e("Utils", "getDate_001", e7);
                return "unlimited";
            }
        } catch (Exception e8) {
            Log.e("Utils", "getDate_002", e8);
            return "unlimited";
        }
    }

    public static String h(long j10, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j10));
    }

    public static Date i(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str);
        } catch (ParseException unused) {
            return new Date();
        }
    }

    public static x4.e j(Context context) {
        PackageManager packageManager = context.getPackageManager();
        for (x4.e eVar : f7827b) {
            try {
            } catch (PackageManager.NameNotFoundException e7) {
                Log.e("Utils", "getMXPackageInfo", e7);
            }
            if (packageManager.getApplicationInfo((String) eVar.f13543q, 0).enabled) {
                return eVar;
            }
        }
        return null;
    }

    public static int k(long j10, long j11) {
        if (j11 <= 0) {
            return 0;
        }
        return (int) Math.round((j10 / j11) * 100.0d);
    }

    public static w1 l(Context context) {
        w1[] w1VarArr = f7826a;
        if (w1VarArr.length <= 0) {
            return null;
        }
        w1 w1Var = w1VarArr[0];
        try {
            PackageManager packageManager = context.getPackageManager();
            Objects.requireNonNull(w1Var);
            if (packageManager.getApplicationInfo("org.videolan.vlc", 0).enabled) {
                return w1Var;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e7) {
            Log.e("Utils", "getVlcPackageInfo", e7);
            return null;
        }
    }

    public static s m(Context context) {
        PackageManager packageManager = context.getPackageManager();
        for (s sVar : f7828c) {
            if (packageManager.getApplicationInfo(sVar.f595p, 0).enabled) {
                return sVar;
            }
        }
        throw new IllegalStateException("No YouTube package found on this device");
    }

    public static String n(long j10) {
        String str;
        if (j10 < 0) {
            return "00:00";
        }
        int i10 = (int) (j10 / 3600000);
        long j11 = j10 % 3600000;
        int i11 = ((int) j11) / 60000;
        int i12 = (int) ((j11 % RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS) / 1000);
        if (i10 <= 0) {
            str = _UrlKt.FRAGMENT_ENCODE_SET;
        } else if (i10 < 10) {
            str = android.support.v4.media.d.o("0", i10, ":");
        } else {
            str = i10 + ":";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(i11 < 10 ? android.support.v4.media.d.m(i11, "0") : android.support.v4.media.d.m(i11, _UrlKt.FRAGMENT_ENCODE_SET));
        sb2.append(":");
        sb2.append(i12 < 10 ? android.support.v4.media.d.m(i12, "0") : android.support.v4.media.d.m(i12, _UrlKt.FRAGMENT_ENCODE_SET));
        return sb2.toString();
    }

    public static int o(int i10, long j10) {
        return ((int) ((i10 / 100.0d) * ((int) (j10 / 1000)))) * 1000;
    }

    public static void p(AppInfoModel appInfoModel) {
        Gson gson = new Gson();
        try {
            File file = new File(LTVApp.a().getExternalFilesDir(null), "log.txt");
            if (file.exists() && !file.delete()) {
                Log.e("FileUtils", "Failed to delete file: " + file.getAbsolutePath());
            }
            if (!file.exists() && !file.createNewFile()) {
                Log.e("FileWrite", "Unable to create file: " + file.getAbsolutePath());
            } else {
                new FileOutputStream(file, true).write((new String(Base64.encode(gson.toJson(appInfoModel).getBytes(StandardCharsets.UTF_8), 0)).trim() + System.getProperty("line.separator")).getBytes());
            }
        } catch (FileNotFoundException e7) {
            Log.e("Utils", "progressToTimer_001", e7);
        } catch (IOException e8) {
            Log.e("Utils", "progressToTimer_002", e8);
        }
    }
}
