package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.CastDevice;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w0 {

    /* renamed from: j, reason: collision with root package name */
    public static final l7.b f3542j = new l7.b("ApplicationAnalytics", null);

    /* renamed from: a, reason: collision with root package name */
    public final l0 f3543a;

    /* renamed from: b, reason: collision with root package name */
    public final c f3544b;

    /* renamed from: c, reason: collision with root package name */
    public final y0 f3545c;

    /* renamed from: f, reason: collision with root package name */
    public final SharedPreferences f3548f;
    public x0 g;

    /* renamed from: h, reason: collision with root package name */
    public h7.d f3549h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3550i;

    /* renamed from: e, reason: collision with root package name */
    public final b8.e f3547e = new b8.e(Looper.getMainLooper(), 2);

    /* renamed from: d, reason: collision with root package name */
    public final w f3546d = new w(1, this);

    public w0(SharedPreferences sharedPreferences, l0 l0Var, c cVar, Bundle bundle, String str) {
        this.f3548f = sharedPreferences;
        this.f3543a = l0Var;
        this.f3544b = cVar;
        this.f3545c = new y0(str, bundle);
    }

    public static void a(w0 w0Var, int i10) {
        f3542j.b("log session ended with error = %d", Integer.valueOf(i10));
        w0Var.c();
        w0Var.f3543a.a(w0Var.f3545c.a(w0Var.g, i10), 228);
        w0Var.f3547e.removeCallbacks(w0Var.f3546d);
        if (w0Var.f3550i) {
            return;
        }
        w0Var.g = null;
    }

    public static void b(w0 w0Var) {
        x0 x0Var = w0Var.g;
        SharedPreferences sharedPreferences = w0Var.f3548f;
        x0Var.getClass();
        if (sharedPreferences == null) {
            return;
        }
        x0.f3569k.b("Save the ApplicationAnalyticsSession to SharedPreferences %s", sharedPreferences);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("application_id", x0Var.f3572b);
        edit.putString("receiver_metrics_id", x0Var.f3573c);
        edit.putLong("analytics_session_id", x0Var.f3574d);
        edit.putInt("event_sequence_number", x0Var.f3575e);
        edit.putString("receiver_session_id", x0Var.f3576f);
        edit.putInt("device_capabilities", x0Var.g);
        edit.putString("device_model_name", x0Var.f3577h);
        edit.putInt("analytics_session_start_type", x0Var.f3579j);
        edit.putBoolean("is_output_switcher_enabled", x0Var.f3578i);
        edit.apply();
    }

    public final void c() {
        CastDevice castDevice;
        x0 x0Var;
        if (!f()) {
            l7.b bVar = f3542j;
            Log.w(bVar.f8271a, bVar.d("The analyticsSession should not be null for logging. Create a dummy one.", new Object[0]));
            d();
            return;
        }
        h7.d dVar = this.f3549h;
        if (dVar != null) {
            r7.r.b();
            castDevice = dVar.f5734k;
        } else {
            castDevice = null;
        }
        if (castDevice != null) {
            String str = castDevice.f3139z;
            if (!TextUtils.equals(this.g.f3573c, str) && (x0Var = this.g) != null) {
                x0Var.f3573c = str;
                x0Var.g = castDevice.f3136w;
                x0Var.f3577h = castDevice.f3132s;
            }
        }
        r7.r.e(this.g);
    }

    public final void d() {
        CastDevice castDevice;
        x0 x0Var;
        f3542j.b("Create a new ApplicationAnalyticsSession based on CastSession", new Object[0]);
        x0 x0Var2 = new x0(this.f3544b);
        x0.f3570l++;
        this.g = x0Var2;
        h7.d dVar = this.f3549h;
        x0Var2.f3578i = dVar != null && dVar.g.f3436h;
        l7.b bVar = h7.b.f5697l;
        r7.r.b();
        h7.b bVar2 = h7.b.f5699n;
        r7.r.e(bVar2);
        r7.r.b();
        x0Var2.f3572b = bVar2.f5704e.f5712o;
        h7.d dVar2 = this.f3549h;
        if (dVar2 == null) {
            castDevice = null;
        } else {
            r7.r.b();
            castDevice = dVar2.f5734k;
        }
        if (castDevice != null && (x0Var = this.g) != null) {
            x0Var.f3573c = castDevice.f3139z;
            x0Var.g = castDevice.f3136w;
            x0Var.f3577h = castDevice.f3132s;
        }
        x0 x0Var3 = this.g;
        r7.r.e(x0Var3);
        h7.d dVar3 = this.f3549h;
        x0Var3.f3579j = dVar3 != null ? dVar3.c() : 0;
        r7.r.e(this.g);
    }

    public final void e() {
        b8.e eVar = this.f3547e;
        r7.r.e(eVar);
        w wVar = this.f3546d;
        r7.r.e(wVar);
        eVar.postDelayed(wVar, 300000L);
    }

    public final boolean f() {
        String str;
        l7.b bVar = f3542j;
        if (this.g == null) {
            bVar.b("The analytics session is null when matching with application ID.", new Object[0]);
            return false;
        }
        l7.b bVar2 = h7.b.f5697l;
        r7.r.b();
        h7.b bVar3 = h7.b.f5699n;
        r7.r.e(bVar3);
        r7.r.b();
        String str2 = bVar3.f5704e.f5712o;
        if (str2 == null || (str = this.g.f3572b) == null || !TextUtils.equals(str, str2)) {
            bVar.b("The analytics session doesn't match the application ID %s", str2);
            return false;
        }
        r7.r.e(this.g);
        return true;
    }

    public final boolean g(String str) {
        String str2;
        if (!f()) {
            return false;
        }
        r7.r.e(this.g);
        if (str != null && (str2 = this.g.f3576f) != null && TextUtils.equals(str2, str)) {
            return true;
        }
        f3542j.b("The analytics session doesn't match the receiver session ID %s.", str);
        return false;
    }
}
