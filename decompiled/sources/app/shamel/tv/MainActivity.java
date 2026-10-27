package app.shamel.tv;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;
import androidx.fragment.app.j0;
import androidx.fragment.app.s;
import app.shamel.tv.activities.ChangePlaylistActivity;
import app.shamel.tv.activities.HomeActivity;
import app.shamel.tv.helper.r;
import app.shamel.tv.models.AppInfoModel;
import app.shamel.tv.models.WordModels;
import com.google.android.gms.internal.cast.n;
import com.google.gson.Gson;
import e5.k;
import h5.p;
import h5.u;
import j5.d;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import k5.j;
import okhttp3.internal.url._UrlKt;
import org.json.JSONObject;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MainActivity extends k implements d {

    /* renamed from: l0, reason: collision with root package name */
    public static final /* synthetic */ int f1561l0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public AppInfoModel f1562c0;

    /* renamed from: d0, reason: collision with root package name */
    public AppInfoModel.UrlModel f1563d0;

    /* renamed from: e0, reason: collision with root package name */
    public GifImageView f1564e0;

    /* renamed from: f0, reason: collision with root package name */
    public r f1565f0;

    /* renamed from: g0, reason: collision with root package name */
    public String f1566g0 = _UrlKt.FRAGMENT_ENCODE_SET;
    public String h0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: i0, reason: collision with root package name */
    public WordModels f1567i0 = new WordModels();

    /* renamed from: j0, reason: collision with root package name */
    public int f1568j0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    public int f1569k0 = 0;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P(app.shamel.tv.models.AppInfoModel r10) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.MainActivity.P(app.shamel.tv.models.AppInfoModel):void");
    }

    public final void Q() {
        if (j.d().isEmpty()) {
            AppInfoModel b2 = this.f1565f0.b();
            this.f1562c0 = b2;
            if (b2 != null) {
                P(b2);
                return;
            }
            int i10 = this.f1568j0 + 1;
            this.f1568j0 = i10;
            if (i10 < 3) {
                T();
                return;
            } else {
                Toast.makeText(this, "Network Error! Please check your internet connection!", 0).show();
                return;
            }
        }
        AppInfoModel appInfoModel = (AppInfoModel) new Gson().fromJson(new String(Base64.decode(j.d(), 0), StandardCharsets.UTF_8).trim(), new a().getType());
        this.f1562c0 = appInfoModel;
        if (appInfoModel == null) {
            int i11 = this.f1568j0 + 1;
            this.f1568j0 = i11;
            if (i11 < 3) {
                T();
                return;
            } else {
                Toast.makeText(this, "Network Error! Please check your internet connection!", 0).show();
                return;
            }
        }
        this.f1565f0.L(appInfoModel);
        P(this.f1562c0);
        r rVar = this.f1565f0;
        String mac_address = this.f1562c0.getMac_address();
        SharedPreferences.Editor edit = rVar.f2098b.edit();
        edit.putString("mac_address", mac_address);
        edit.apply();
    }

    public final void R() {
        List<ActivityManager.AppTask> appTasks;
        System.exit(0);
        Process.killProcess(Process.myPid());
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        if (activityManager != null && (appTasks = activityManager.getAppTasks()) != null && !appTasks.isEmpty()) {
            appTasks.get(0).setExcludeFromRecents(true);
        }
        finishAndRemoveTask();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r2.isEmpty() == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S() {
        /*
            r4 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "language_code"
            app.shamel.tv.helper.r r2 = r4.f1565f0
            r2.getClass()
            android.content.SharedPreferences r2 = r2.f2098b     // Catch: java.lang.Exception -> L18
            java.lang.String r2 = r2.getString(r1, r0)     // Catch: java.lang.Exception -> L18
            if (r2 == 0) goto L18
            boolean r3 = r2.isEmpty()     // Catch: java.lang.Exception -> L18
            if (r3 != 0) goto L18
            goto L19
        L18:
            r2 = 0
        L19:
            if (r2 == 0) goto L2d
            app.shamel.tv.helper.r r2 = r4.f1565f0
            r2.getClass()
            android.content.SharedPreferences r2 = r2.f2098b     // Catch: java.lang.Exception -> L43
            java.lang.String r0 = r2.getString(r1, r0)     // Catch: java.lang.Exception -> L43
            if (r0 == 0) goto L43
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> L43
            goto L43
        L2d:
            app.shamel.tv.helper.r r0 = r4.f1565f0
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r2 = r2.getLanguage()
            android.content.SharedPreferences r0 = r0.f2098b
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putString(r1, r2)
            r0.apply()
        L43:
            app.shamel.tv.helper.r r0 = r4.f1565f0
            int r0 = r0.F()
            if (r0 != 0) goto L6d
            boolean r0 = app.shamel.tv.helper.a.l(r4)
            if (r0 == 0) goto L59
            app.shamel.tv.helper.r r0 = r4.f1565f0
            r1 = 46
            r0.b0(r1)
            goto L60
        L59:
            app.shamel.tv.helper.r r0 = r4.f1565f0
            r1 = 12
            r0.b0(r1)
        L60:
            boolean r0 = k5.j.b()
            if (r0 == 0) goto L6d
            app.shamel.tv.helper.r r0 = r4.f1565f0
            r1 = 35
            r0.b0(r1)
        L6d:
            app.shamel.tv.apps.LTVApp r0 = app.shamel.tv.apps.LTVApp.f2085t
            r0.getClass()
            app.shamel.tv.apps.LTVApp.c()
            app.shamel.tv.apps.LTVApp r0 = app.shamel.tv.apps.LTVApp.f2085t
            r0.b()
            r4.T()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.MainActivity.S():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0037, code lost:
    
        if (r3.isEmpty() == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T() {
        /*
            r6 = this;
            j9.w1[] r0 = k5.j.f7826a
            java.lang.String r0 = new java.lang.String
            android.content.ContentResolver r1 = r6.getContentResolver()
            java.lang.String r2 = "android_id"
            java.lang.String r1 = android.provider.Settings.Secure.getString(r1, r2)
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r1 = r1.getBytes(r2)
            r2 = 0
            byte[] r1 = android.util.Base64.encode(r1, r2)
            r0.<init>(r1)
            java.lang.String r0 = r0.trim()
            java.lang.String r1 = app.shamel.tv.apps.LTVApp.f2089x
            app.shamel.tv.helper.r r3 = r6.f1565f0
            r3.getClass()
            android.content.SharedPreferences r3 = r3.f2098b     // Catch: java.lang.Exception -> L3a
            java.lang.String r4 = "device_type"
            java.lang.String r5 = ""
            java.lang.String r3 = r3.getString(r4, r5)     // Catch: java.lang.Exception -> L3a
            if (r3 == 0) goto L3a
            boolean r4 = r3.isEmpty()     // Catch: java.lang.Exception -> L3a
            if (r4 != 0) goto L3a
            goto L3b
        L3a:
            r3 = 0
        L3b:
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r5 = "app_device_id"
            r4.put(r5, r0)     // Catch: java.lang.Exception -> L55
            java.lang.String r0 = "app_type"
            r4.put(r0, r3)     // Catch: java.lang.Exception -> L55
            java.lang.String r0 = "version"
            r4.put(r0, r1)     // Catch: java.lang.Exception -> L55
            java.lang.String r0 = "is_paid"
            r4.put(r0, r2)     // Catch: java.lang.Exception -> L55
            goto L5d
        L55:
            r0 = move-exception
            java.lang.String r1 = "Security"
            java.lang.String r3 = "getStringData"
            android.util.Log.e(r1, r3, r0)
        L5d:
            java.lang.String r0 = new java.lang.String
            java.lang.String r1 = r4.toString()
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r1 = r1.getBytes(r3)
            byte[] r1 = android.util.Base64.encode(r1, r2)
            r0.<init>(r1)
            java.lang.String r0 = r0.trim()
            java.util.Random r1 = new java.util.Random
            r1.<init>()
            r3 = 20
            int r1 = r1.nextInt(r3)
            java.util.Random r3 = new java.util.Random
            r3.<init>()
            int r4 = r0.length()
            int r3 = r3.nextInt(r4)
            r4 = 42
            if (r3 <= r4) goto L91
            r3 = r4
        L91:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = r0.substring(r2, r3)
            r5.append(r2)
            java.lang.String r2 = com.google.android.gms.internal.cast.n.j(r1)
            r5.append(r2)
            java.lang.String r0 = r0.substring(r3)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r4.append(r0)
            java.lang.String r0 = com.google.android.gms.internal.cast.n.k(r3)
            r4.append(r0)
            java.lang.String r0 = com.google.android.gms.internal.cast.n.k(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r0 = r0.trim()
            c2.j1 r1 = new c2.j1
            r2 = 1000(0x3e8, float:1.401E-42)
            r1.<init>(r6, r2)
            org.json.JSONObject r0 = com.google.android.gms.internal.cast.n.l(r0)
            java.lang.String r2 = e5.l.f4608c
            r1.i(r0, r2)
            r1.f2627r = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.MainActivity.T():void");
    }

    public final void U() {
        this.f1564e0.setVisibility(0);
        this.f1569k0 = app.shamel.tv.helper.a.i(this);
        try {
            AppInfoModel appInfoModel = this.f1562c0;
            if (appInfoModel != null && appInfoModel.getResult() != null && this.f1562c0.getResult().size() > 0) {
                if (!j.b() && this.f1562c0.getResult().get(0).getId().equalsIgnoreCase("0")) {
                    startActivity(new Intent(this, (Class<?>) ChangePlaylistActivity.class));
                    finish();
                }
                AppInfoModel.UrlModel urlModel = this.f1562c0.getResult().get(this.f1569k0);
                this.f1563d0 = urlModel;
                if (urlModel.getUrl().contains("username")) {
                    this.f1565f0.P(false);
                    L(this.f1563d0.getUrl(), this.f1567i0);
                } else if (app.shamel.tv.helper.a.a(this.f1563d0.getUrl())) {
                    this.f1565f0.P(false);
                    M(this.f1563d0.getUrl(), this.f1567i0);
                } else {
                    this.f1565f0.P(true);
                    N(this.f1563d0.getUrl(), this.f1567i0);
                }
            }
            startActivity(new Intent(this, (Class<?>) ChangePlaylistActivity.class));
            finish();
        } catch (Exception e7) {
            try {
                Log.e("MainActivity", "loadingData", e7);
            } catch (Exception unused) {
                startActivity(new Intent(this, (Class<?>) ChangePlaylistActivity.class));
                finish();
            }
        }
    }

    public final void V(String str, int i10, String str2) {
        this.f1564e0.setVisibility(8);
        j0 n10 = n();
        n10.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(n10);
        s A = n10.A("fragment_description");
        if (A != null) {
            android.support.v4.media.d.v(aVar, A, false);
            return;
        }
        p pVar = new p();
        Bundle bundle = new Bundle();
        bundle.putString("arg_subscription", str);
        bundle.putString("arg_description", str2);
        bundle.putInt("arg_playlist_size", i10);
        pVar.I(bundle);
        pVar.K0 = new b(i10, 0, this);
        pVar.M(n10, "fragment_description");
    }

    @Override // j5.d
    public final void a(JSONObject jSONObject, int i10) {
        if (jSONObject == null) {
            try {
                Q();
                return;
            } catch (IOException e7) {
                throw new RuntimeException(e7);
            }
        }
        if (i10 == 1000) {
            if (!jSONObject.has("data")) {
                try {
                    Q();
                    return;
                } catch (IOException e8) {
                    throw new RuntimeException(e8);
                }
            }
            try {
                AppInfoModel appInfoModel = (AppInfoModel) new Gson().fromJson(new JSONObject(n.h(jSONObject.getString("data"))).toString(), AppInfoModel.class);
                this.f1562c0 = appInfoModel;
                this.f1565f0.L(appInfoModel);
                SharedPreferences.Editor edit = this.f1565f0.f2098b.edit();
                edit.putBoolean("is_changed", false);
                edit.apply();
                SharedPreferences.Editor edit2 = this.f1565f0.f2098b.edit();
                edit2.putBoolean("first_lunch", false);
                edit2.apply();
                r rVar = this.f1565f0;
                String mac_address = this.f1562c0.getMac_address();
                SharedPreferences.Editor edit3 = rVar.f2098b.edit();
                edit3.putString("mac_address", mac_address);
                edit3.apply();
                r rVar2 = this.f1565f0;
                String device_key = this.f1562c0.getDevice_key();
                SharedPreferences.Editor edit4 = rVar2.f2098b.edit();
                edit4.putString("device_key", device_key);
                edit4.apply();
                if (this.f1562c0.getParent_synced() == 1) {
                    r rVar3 = this.f1565f0;
                    String parent_control = this.f1562c0.getParent_control();
                    SharedPreferences.Editor edit5 = rVar3.f2098b.edit();
                    edit5.putString("parent_control", parent_control);
                    edit5.apply();
                }
                j.p(this.f1562c0);
                P(this.f1562c0);
            } catch (Exception e10) {
                try {
                    try {
                        Q();
                        Log.e("MainActivity", "OnGetResponseResult", e10);
                    } catch (Exception unused) {
                        Q();
                    }
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
    }

    @Override // f.j, b0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.f1564e0.getVisibility() == 0) {
            this.Y = true;
            startActivity(new Intent(this, (Class<?>) ChangePlaylistActivity.class));
            finish();
            return true;
        }
        this.Y = true;
        j0 n10 = n();
        androidx.fragment.app.a i10 = android.support.v4.media.d.i(n10, n10);
        s A = n10.A("fragment_exit");
        if (A != null) {
            android.support.v4.media.d.v(i10, A, false);
            return true;
        }
        u N = u.N(this.f1567i0.getExit(), this.f1567i0.getExit_description(), this.f1567i0.getStr_yes(), this.f1567i0.getNo());
        N.B0 = new a6.n(7, this);
        N.M(n10, "fragment_exit");
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
    
        if (r6 > 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ce, code lost:
    
        if ((getResources().getConfiguration().touchscreen != 1) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003f, code lost:
    
        if (r6.isEmpty() == false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012e  */
    @Override // e5.k, f.j, androidx.activity.n, b0.e, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r6) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.MainActivity.onCreate(android.os.Bundle):void");
    }

    @Override // f.j, androidx.activity.n, android.app.Activity
    public final void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        S();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // e5.k
    public final void w(boolean z10) {
        if (z10) {
            this.f1565f0.Q(System.currentTimeMillis() / 1000);
            startActivity(new Intent(this, (Class<?>) HomeActivity.class));
        } else {
            this.f1564e0.setVisibility(8);
            Toast.makeText(this, String.valueOf(this.f1567i0.getPlaylist_is_not_working()), 0).show();
            startActivity(new Intent(this, (Class<?>) ChangePlaylistActivity.class));
        }
        finish();
    }
}
