package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import o4.p;
import p4.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1540a = p.f("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        p.d().a(f1540a, "Received intent " + intent);
        try {
            r b2 = r.b(context);
            BroadcastReceiver.PendingResult goAsync = goAsync();
            synchronized (r.f9956m) {
                try {
                    BroadcastReceiver.PendingResult pendingResult = b2.f9964i;
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    b2.f9964i = goAsync;
                    if (b2.f9963h) {
                        goAsync.finish();
                        b2.f9964i = null;
                    }
                } finally {
                }
            }
        } catch (IllegalStateException e7) {
            p.d().c(f1540a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e7);
        }
    }
}
