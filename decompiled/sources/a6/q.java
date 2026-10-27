package a6;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PictureInPictureParams;
import android.content.Context;
import android.media.AudioFocusRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class q {
    public static /* synthetic */ NotificationChannel A(String str) {
        return new NotificationChannel("playcore-assetpacks-service-notification-channel", str, 2);
    }

    public static /* synthetic */ void B() {
    }

    public static /* synthetic */ Notification.Builder d(Context context) {
        return new Notification.Builder(context, "playcore-assetpacks-service-notification-channel");
    }

    public static /* synthetic */ NotificationChannel e(String str) {
        return new NotificationChannel("cast_media_notification", str, 2);
    }

    public static /* synthetic */ AudioFocusRequest.Builder h(int i10) {
        return new AudioFocusRequest.Builder(i10);
    }

    public static /* bridge */ /* synthetic */ AudioFocusRequest m(Object obj) {
        return (AudioFocusRequest) obj;
    }

    public static /* synthetic */ void o() {
        new PictureInPictureParams.Builder();
    }
}
