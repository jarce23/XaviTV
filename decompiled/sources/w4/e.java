package w4;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.Service;
import android.util.Log;
import androidx.work.impl.foreground.SystemForegroundService;
import o4.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e {
    public static void a(Service service, int i10, Notification notification, int i11) {
        try {
            service.startForeground(i10, notification, i11);
        } catch (ForegroundServiceStartNotAllowedException e7) {
            p d6 = p.d();
            String str = SystemForegroundService.f1550t;
            if (d6.f9512a <= 5) {
                Log.w(str, "Unable to start foreground service", e7);
            }
        } catch (SecurityException e8) {
            p d10 = p.d();
            String str2 = SystemForegroundService.f1550t;
            if (d10.f9512a <= 5) {
                Log.w(str2, "Unable to start foreground service", e8);
            }
        }
    }
}
