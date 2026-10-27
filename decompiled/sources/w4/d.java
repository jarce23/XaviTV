package w4;

import android.app.Notification;
import android.app.Service;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d {
    public static void a(Service service, int i10, Notification notification, int i11) {
        service.startForeground(i10, notification, i11);
    }
}
