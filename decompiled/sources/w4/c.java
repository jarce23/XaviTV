package w4;

import android.app.Notification;
import android.os.Build;
import androidx.work.impl.foreground.SystemForegroundService;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f13100o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Notification f13101p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f13102q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f13103r;

    public c(SystemForegroundService systemForegroundService, int i10, Notification notification, int i11) {
        this.f13103r = systemForegroundService;
        this.f13100o = i10;
        this.f13101p = notification;
        this.f13102q = i11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = Build.VERSION.SDK_INT;
        int i11 = this.f13102q;
        Notification notification = this.f13101p;
        int i12 = this.f13100o;
        SystemForegroundService systemForegroundService = this.f13103r;
        if (i10 >= 31) {
            e.a(systemForegroundService, i12, notification, i11);
        } else if (i10 >= 29) {
            d.a(systemForegroundService, i12, notification, i11);
        } else {
            systemForegroundService.startForeground(i12, notification);
        }
    }
}
