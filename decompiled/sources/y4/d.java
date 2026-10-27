package y4;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.work.impl.utils.ForceStopRunnable$BroadcastReceiver;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: s, reason: collision with root package name */
    public static final String f13824s = o4.p.f("ForceStopRunnable");

    /* renamed from: t, reason: collision with root package name */
    public static final long f13825t = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: o, reason: collision with root package name */
    public final Context f13826o;

    /* renamed from: p, reason: collision with root package name */
    public final p4.r f13827p;

    /* renamed from: q, reason: collision with root package name */
    public final g f13828q;

    /* renamed from: r, reason: collision with root package name */
    public int f13829r = 0;

    public d(Context context, p4.r rVar) {
        this.f13826o = context.getApplicationContext();
        this.f13827p = rVar;
        this.f13828q = rVar.g;
    }

    public static void c(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i10 = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) ForceStopRunnable$BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i10);
        long currentTimeMillis = System.currentTimeMillis() + f13825t;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, broadcast);
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0235  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.d.a():void");
    }

    public final boolean b() {
        o4.a aVar = this.f13827p.f9958b;
        aVar.getClass();
        boolean isEmpty = TextUtils.isEmpty(null);
        String str = f13824s;
        if (isEmpty) {
            o4.p.d().a(str, "The default process name was not specified.");
            return true;
        }
        boolean a10 = l.a(this.f13826o, aVar);
        o4.p.d().a(str, "Is default app process = " + a10);
        return a10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f13826o;
        String str = f13824s;
        p4.r rVar = this.f13827p;
        try {
            if (!b()) {
                return;
            }
            while (true) {
                try {
                    com.bumptech.glide.e.q(context);
                    o4.p.d().a(str, "Performing cleanup operations.");
                    try {
                        a();
                        return;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e7) {
                        int i10 = this.f13829r + 1;
                        this.f13829r = i10;
                        if (i10 >= 3) {
                            String str2 = Build.VERSION.SDK_INT >= 24 ? i0.c.d(context) : true ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                            o4.p.d().c(str, str2, e7);
                            IllegalStateException illegalStateException = new IllegalStateException(str2, e7);
                            rVar.f9958b.getClass();
                            throw illegalStateException;
                        }
                        String str3 = "Retrying after " + (i10 * 300);
                        if (o4.p.d().f9512a <= 3) {
                            Log.d(str, str3, e7);
                        }
                        try {
                            Thread.sleep(this.f13829r * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (SQLiteException e8) {
                    o4.p.d().b(str, "Unexpected SQLite exception during migrations");
                    IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e8);
                    rVar.f9958b.getClass();
                    throw illegalStateException2;
                }
            }
        } finally {
            rVar.c();
        }
    }
}
