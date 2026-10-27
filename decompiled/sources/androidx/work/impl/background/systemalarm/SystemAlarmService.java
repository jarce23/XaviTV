package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import androidx.lifecycle.u;
import java.util.LinkedHashMap;
import java.util.Map;
import o4.p;
import r4.i;
import y4.n;
import y4.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SystemAlarmService extends u {

    /* renamed from: r, reason: collision with root package name */
    public static final String f1541r = p.f("SystemAlarmService");

    /* renamed from: p, reason: collision with root package name */
    public i f1542p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1543q;

    public final void a() {
        this.f1543q = true;
        p.d().a(f1541r, "All commands completed in dispatcher");
        String str = n.f13840a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (o.f13841a) {
            linkedHashMap.putAll(o.f13842b);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str2 = (String) entry.getValue();
            if (wakeLock != null && wakeLock.isHeld()) {
                p.d().g(n.f13840a, "WakeLock held for " + str2);
            }
        }
        stopSelf();
    }

    @Override // androidx.lifecycle.u, android.app.Service
    public final void onCreate() {
        super.onCreate();
        i iVar = new i(this);
        this.f1542p = iVar;
        if (iVar.f10782w != null) {
            p.d().b(i.f10773y, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            iVar.f10782w = this;
        }
        this.f1543q = false;
    }

    @Override // androidx.lifecycle.u, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f1543q = true;
        i iVar = this.f1542p;
        iVar.getClass();
        p.d().a(i.f10773y, "Destroying SystemAlarmDispatcher");
        iVar.f10777r.h(iVar);
        iVar.f10782w = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f1543q) {
            p.d().e(f1541r, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            i iVar = this.f1542p;
            iVar.getClass();
            p d6 = p.d();
            String str = i.f10773y;
            d6.a(str, "Destroying SystemAlarmDispatcher");
            iVar.f10777r.h(iVar);
            iVar.f10782w = null;
            i iVar2 = new i(this);
            this.f1542p = iVar2;
            if (iVar2.f10782w != null) {
                p.d().b(str, "A completion listener for SystemAlarmDispatcher already exists.");
            } else {
                iVar2.f10782w = this;
            }
            this.f1543q = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f1542p.a(intent, i11);
        return 3;
    }
}
