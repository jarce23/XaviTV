package p4;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends d4.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9927c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final Context f9928d;

    public g(Context context, int i10, int i11) {
        super(i10, i11);
        this.f9928d = context;
    }

    @Override // d4.a
    public final void a(h4.c cVar) {
        int i10 = this.f9927c;
        Context context = this.f9928d;
        switch (i10) {
            case 0:
                if (this.f4051b >= 10) {
                    cVar.K(new Object[]{"reschedule_needed", 1});
                    return;
                } else {
                    context.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
                    return;
                }
            default:
                cVar.x("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
                if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                    long j10 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
                    long j11 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
                    cVar.a();
                    try {
                        cVar.K(new Object[]{"last_cancel_all_time_ms", Long.valueOf(j10)});
                        cVar.K(new Object[]{"reschedule_needed", Long.valueOf(j11)});
                        sharedPreferences.edit().clear().apply();
                        cVar.Q();
                    } finally {
                    }
                }
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
                if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                    int i11 = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                    int i12 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                    cVar.a();
                    try {
                        cVar.K(new Object[]{"next_job_scheduler_id", Integer.valueOf(i11)});
                        cVar.K(new Object[]{"next_alarm_manager_id", Integer.valueOf(i12)});
                        sharedPreferences2.edit().clear().apply();
                        cVar.Q();
                        return;
                    } finally {
                    }
                }
                return;
        }
    }

    public g(Context context) {
        super(9, 10);
        this.f9928d = context;
    }
}
