package b0;

import android.app.Notification;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends j {

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f2144b;

    @Override // b0.j
    public final void a(x4.m mVar) {
        new Notification.BigTextStyle((Notification.Builder) mVar.f13564p).setBigContentTitle(null).bigText(this.f2144b);
    }

    @Override // b0.j
    public final String b() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }
}
