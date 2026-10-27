package androidx.work.impl.foreground;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.u;
import java.util.UUID;
import o4.p;
import p4.r;
import p7.m;
import w4.b;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SystemForegroundService extends u {

    /* renamed from: t, reason: collision with root package name */
    public static final String f1550t = p.f("SystemFgService");

    /* renamed from: p, reason: collision with root package name */
    public Handler f1551p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1552q;

    /* renamed from: r, reason: collision with root package name */
    public b f1553r;

    /* renamed from: s, reason: collision with root package name */
    public NotificationManager f1554s;

    public final void a() {
        this.f1551p = new Handler(Looper.getMainLooper());
        this.f1554s = (NotificationManager) getApplicationContext().getSystemService("notification");
        b bVar = new b(getApplicationContext());
        this.f1553r = bVar;
        if (bVar.f13099w != null) {
            p.d().b(b.f13090x, "A callback already exists.");
        } else {
            bVar.f13099w = this;
        }
    }

    @Override // androidx.lifecycle.u, android.app.Service
    public final void onCreate() {
        super.onCreate();
        a();
    }

    @Override // androidx.lifecycle.u, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f1553r.f();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        boolean z10 = this.f1552q;
        String str = f1550t;
        if (z10) {
            p.d().e(str, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.f1553r.f();
            a();
            this.f1552q = false;
        }
        if (intent == null) {
            return 3;
        }
        b bVar = this.f1553r;
        bVar.getClass();
        String str2 = b.f13090x;
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            p.d().e(str2, "Started foreground service " + intent);
            bVar.f13092p.g(new m(bVar, 3, intent.getStringExtra("KEY_WORKSPEC_ID")));
            bVar.d(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            bVar.d(intent);
            return 3;
        }
        if (!"ACTION_CANCEL_WORK".equals(action)) {
            if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            }
            p.d().e(str2, "Stopping foreground service");
            SystemForegroundService systemForegroundService = bVar.f13099w;
            if (systemForegroundService == null) {
                return 3;
            }
            systemForegroundService.f1552q = true;
            p.d().a(str, "All commands completed.");
            if (Build.VERSION.SDK_INT >= 26) {
                systemForegroundService.stopForeground(true);
            }
            systemForegroundService.stopSelf();
            return 3;
        }
        p.d().e(str2, "Stopping foreground work for " + intent);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return 3;
        }
        r rVar = bVar.f13091o;
        UUID fromString = UUID.fromString(stringExtra);
        rVar.getClass();
        rVar.f9960d.g(new y4.b(rVar, fromString, 0));
        return 3;
    }
}
