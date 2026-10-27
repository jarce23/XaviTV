package r4;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.concurrent.Callable;
import o4.p;
import x4.j;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10745a = p.f("Alarms");

    public static void a(Context context, j jVar, int i10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        String str = c.f10746t;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        c.e(intent, jVar);
        PendingIntent service = PendingIntent.getService(context, i10, intent, 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        p.d().a(f10745a, "Cancelling existing alarm with (workSpecId, systemId) (" + jVar + ", " + i10 + ")");
        alarmManager.cancel(service);
    }

    public static void b(Context context, WorkDatabase workDatabase, j jVar, long j10) {
        x4.i p10 = workDatabase.p();
        x4.g n10 = p10.n(jVar);
        if (n10 != null) {
            int i10 = n10.f13550c;
            a(context, jVar, i10);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            String str = c.f10746t;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_DELAY_MET");
            c.e(intent, jVar);
            PendingIntent service = PendingIntent.getService(context, i10, intent, 201326592);
            if (alarmManager != null) {
                a.a(alarmManager, 0, j10, service);
                return;
            }
            return;
        }
        final y4.g gVar = new y4.g(workDatabase, 0);
        Object n11 = workDatabase.n(new Callable() { // from class: y4.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WorkDatabase workDatabase2 = g.this.f13833a;
                Long h10 = workDatabase2.l().h("next_alarm_manager_id");
                int longValue = h10 != null ? (int) h10.longValue() : 0;
                workDatabase2.l().k(new x4.d("next_alarm_manager_id", Long.valueOf(longValue != Integer.MAX_VALUE ? longValue + 1 : 0)));
                return Integer.valueOf(longValue);
            }
        });
        za.h.d("workDatabase.runInTransa…ANAGER_ID_KEY)\n        })", n11);
        int intValue = ((Number) n11).intValue();
        p10.o(new x4.g(jVar.f13557a, jVar.f13558b, intValue));
        AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
        String str2 = c.f10746t;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_DELAY_MET");
        c.e(intent2, jVar);
        PendingIntent service2 = PendingIntent.getService(context, intValue, intent2, 201326592);
        if (alarmManager2 != null) {
            a.a(alarmManager2, 0, j10, service2);
        }
    }
}
