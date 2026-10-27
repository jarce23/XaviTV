package j9;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h1 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7301a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f7302b;

    public h1(Context context) {
        this.f7301a = context;
        this.f7302b = (NotificationManager) context.getSystemService("notification");
    }

    public final Notification a(Bundle bundle) {
        Notification.Builder timeoutAfter;
        PendingIntent activity;
        int i10 = Build.VERSION.SDK_INT;
        Context context = this.f7301a;
        if (i10 < 26) {
            timeoutAfter = new Notification.Builder(context).setPriority(-2);
        } else {
            timeoutAfter = a6.q.d(context).setTimeoutAfter(bundle.getLong("notification_timeout", 600000L));
        }
        Parcelable parcelable = bundle.getParcelable("notification_on_click_intent");
        if (parcelable instanceof PendingIntent) {
            activity = (PendingIntent) parcelable;
        } else if (bundle.getBoolean("notification_intent_reconstruct_from_data")) {
            Intent intent = new Intent();
            String string = bundle.getString("notification_intent_component_class_name");
            String string2 = bundle.getString("notification_intent_component_package_name");
            if (string != null && string2 != null) {
                intent.setComponent(new ComponentName(string2, string));
            }
            intent.setPackage(bundle.getString("notification_intent_package"));
            intent.setAction(bundle.getString("notification_intent_action"));
            intent.setFlags(bundle.getInt("notification_intent_flags"));
            String string3 = bundle.getString("notification_intent_data");
            if (string3 != null) {
                intent.setData(Uri.parse(string3));
            }
            intent.putExtra("error_doc_id", bundle.getString("notification_intent_extra_error_dialog_document_id"));
            activity = PendingIntent.getActivity(context, 0, intent, 201326592);
        } else {
            activity = null;
        }
        if (activity != null) {
            timeoutAfter.setContentIntent(activity);
        }
        String string4 = bundle.getString("notification_title");
        String string5 = bundle.getString("notification_subtext");
        Notification.Builder ongoing = timeoutAfter.setSmallIcon(R.drawable.stat_sys_download).setOngoing(false);
        if (string4 == null) {
            string4 = "Downloading additional file";
        }
        Notification.Builder contentTitle = ongoing.setContentTitle(string4);
        if (string5 == null) {
            string5 = "Transferring";
        }
        contentTitle.setSubText(string5);
        int i11 = bundle.getInt("notification_color");
        if (i11 != 0) {
            timeoutAfter.setColor(i11).setVisibility(-1);
        }
        return timeoutAfter.build();
    }

    public final void b(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            String string = bundle.getString("notification_channel_name");
            synchronized (this) {
                if (string == null) {
                    string = "File downloads by Play";
                }
                try {
                    a6.q.B();
                    this.f7302b.createNotificationChannel(a6.q.A(string));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
