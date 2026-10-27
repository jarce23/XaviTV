package n7;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.graphics.drawable.IconCompat;
import androidx.fragment.app.j0;
import com.google.android.gms.common.api.GoogleApiActivity;
import okhttp3.internal.url._UrlKt;
import r7.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f9225d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final d f9226e = new d();

    /* renamed from: c, reason: collision with root package name */
    public t7.d f9227c;

    public static AlertDialog e(Activity activity, int i10, r7.m mVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i10 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(r7.l.b(activity, i10));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        String string = i10 != 1 ? i10 != 2 ? i10 != 3 ? resources.getString(R.string.ok) : resources.getString(org.chromium.net.R.string.common_google_play_services_enable_button) : resources.getString(org.chromium.net.R.string.common_google_play_services_update_button) : resources.getString(org.chromium.net.R.string.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, mVar);
        }
        String a10 = r7.l.a(activity, i10);
        if (a10 != null) {
            builder.setTitle(a10);
        }
        Log.w("GoogleApiAvailability", android.support.v4.media.d.m(i10, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static void h(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof f.j) {
                j0 n10 = ((f.j) activity).n();
                j jVar = new j();
                r.f("Cannot display null dialog", alertDialog);
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                jVar.f9235x0 = alertDialog;
                if (onCancelListener != null) {
                    jVar.f9236y0 = onCancelListener;
                }
                jVar.M(n10, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        b bVar = new b();
        r.f("Cannot display null dialog", alertDialog);
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        bVar.f9218o = alertDialog;
        if (onCancelListener != null) {
            bVar.f9219p = onCancelListener;
        }
        bVar.show(fragmentManager, str);
    }

    public final void d(GoogleApiActivity googleApiActivity, int i10, GoogleApiActivity googleApiActivity2) {
        AlertDialog e7 = e(googleApiActivity, i10, new r7.m(super.a(i10, googleApiActivity, "d"), googleApiActivity, 0), googleApiActivity2);
        if (e7 == null) {
            return;
        }
        h(googleApiActivity, e7, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void f(Activity activity, p7.e eVar, int i10, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog e7 = e(activity, i10, new r7.m(super.a(i10, activity, "d"), eVar, 1), onCancelListener);
        if (e7 == null) {
            return;
        }
        h(activity, e7, "GooglePlayServicesErrorDialog", onCancelListener);
    }

    public final void g(Context context, int i10, PendingIntent pendingIntent) {
        int i11;
        NotificationChannel notificationChannel;
        CharSequence name;
        Log.w("GoogleApiAvailability", android.support.v4.media.d.o("GMS core API Availability. ConnectionResult=", i10, ", tag=null"), new IllegalArgumentException());
        if (i10 == 18) {
            new k(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i10 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String e7 = i10 == 6 ? r7.l.e(context, "common_google_play_services_resolution_required_title") : r7.l.a(context, i10);
        if (e7 == null) {
            e7 = context.getResources().getString(org.chromium.net.R.string.common_google_play_services_notification_ticker);
        }
        String d6 = (i10 == 6 || i10 == 19) ? r7.l.d(context, "common_google_play_services_resolution_required_text", r7.l.c(context)) : r7.l.b(context, i10);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        r.e(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        b0.i iVar = new b0.i(context, null);
        iVar.f2155l = true;
        iVar.f2160q.flags |= 16;
        iVar.f2149e = b0.i.b(e7);
        b0.h hVar = new b0.h();
        hVar.f2144b = b0.i.b(d6);
        iVar.c(hVar);
        PackageManager packageManager = context.getPackageManager();
        if (x4.f.f13544o == null) {
            x4.f.f13544o = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        boolean booleanValue = x4.f.f13544o.booleanValue();
        int i12 = R.drawable.stat_sys_warning;
        if (booleanValue) {
            int i13 = context.getApplicationInfo().icon;
            if (i13 != 0) {
                i12 = i13;
            }
            iVar.f2160q.icon = i12;
            iVar.f2152i = 2;
            if (x4.f.D(context)) {
                iVar.f2146b.add(new b0.g(IconCompat.b(null, _UrlKt.FRAGMENT_ENCODE_SET, org.chromium.net.R.drawable.common_full_open_on_phone), resources.getString(org.chromium.net.R.string.common_open_on_phone), pendingIntent, new Bundle(), null, null, true, true));
            } else {
                iVar.g = pendingIntent;
            }
        } else {
            iVar.f2160q.icon = R.drawable.stat_sys_warning;
            iVar.f2160q.tickerText = b0.i.b(resources.getString(org.chromium.net.R.string.common_google_play_services_notification_ticker));
            iVar.f2160q.when = System.currentTimeMillis();
            iVar.g = pendingIntent;
            iVar.f2150f = b0.i.b(d6);
        }
        if (y7.d.k()) {
            if (!y7.d.k()) {
                throw new IllegalStateException();
            }
            synchronized (f9225d) {
            }
            notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(org.chromium.net.R.string.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(n0.b.d(string));
            } else {
                name = notificationChannel.getName();
                if (!string.contentEquals(name)) {
                    notificationChannel.setName(string);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            iVar.f2158o = "com.google.android.gms.availability";
        }
        Notification a10 = iVar.a();
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            h.f9230a.set(false);
            i11 = 10436;
        } else {
            i11 = 39789;
        }
        notificationManager.notify(i11, a10);
    }
}
