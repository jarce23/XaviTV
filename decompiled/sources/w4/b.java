package w4;

import a3.f;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.activity.h;
import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.gms.internal.cast.n;
import ib.p0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import o4.g;
import o4.p;
import p4.l;
import p4.r;
import x4.i;
import x4.j;
import x4.o;
import y4.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements t4.e, p4.c {

    /* renamed from: x, reason: collision with root package name */
    public static final String f13090x = p.f("SystemFgDispatcher");

    /* renamed from: o, reason: collision with root package name */
    public final r f13091o;

    /* renamed from: p, reason: collision with root package name */
    public final i f13092p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f13093q = new Object();

    /* renamed from: r, reason: collision with root package name */
    public j f13094r;

    /* renamed from: s, reason: collision with root package name */
    public final LinkedHashMap f13095s;

    /* renamed from: t, reason: collision with root package name */
    public final HashMap f13096t;

    /* renamed from: u, reason: collision with root package name */
    public final HashMap f13097u;

    /* renamed from: v, reason: collision with root package name */
    public final f f13098v;

    /* renamed from: w, reason: collision with root package name */
    public SystemForegroundService f13099w;

    public b(Context context) {
        r b2 = r.b(context);
        this.f13091o = b2;
        this.f13092p = b2.f9960d;
        this.f13094r = null;
        this.f13095s = new LinkedHashMap();
        this.f13097u = new HashMap();
        this.f13096t = new HashMap();
        this.f13098v = new f(b2.f9965j);
        b2.f9962f.a(this);
    }

    public static Intent a(Context context, j jVar, g gVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", gVar.f9499a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", gVar.f9500b);
        intent.putExtra("KEY_NOTIFICATION", gVar.f9501c);
        intent.putExtra("KEY_WORKSPEC_ID", jVar.f13557a);
        intent.putExtra("KEY_GENERATION", jVar.f13558b);
        return intent;
    }

    public static Intent c(Context context, j jVar, g gVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", jVar.f13557a);
        intent.putExtra("KEY_GENERATION", jVar.f13558b);
        intent.putExtra("KEY_NOTIFICATION_ID", gVar.f9499a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", gVar.f9500b);
        intent.putExtra("KEY_NOTIFICATION", gVar.f9501c);
        return intent;
    }

    @Override // p4.c
    public final void b(j jVar, boolean z10) {
        Map.Entry entry;
        synchronized (this.f13093q) {
            try {
                p0 p0Var = ((o) this.f13096t.remove(jVar)) != null ? (p0) this.f13097u.remove(jVar) : null;
                if (p0Var != null) {
                    p0Var.c(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g gVar = (g) this.f13095s.remove(jVar);
        if (jVar.equals(this.f13094r)) {
            if (this.f13095s.size() > 0) {
                Iterator it = this.f13095s.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    } else {
                        next = it.next();
                    }
                }
                this.f13094r = (j) entry.getKey();
                if (this.f13099w != null) {
                    g gVar2 = (g) entry.getValue();
                    SystemForegroundService systemForegroundService = this.f13099w;
                    systemForegroundService.f1551p.post(new c(systemForegroundService, gVar2.f9499a, gVar2.f9501c, gVar2.f9500b));
                    SystemForegroundService systemForegroundService2 = this.f13099w;
                    systemForegroundService2.f1551p.post(new androidx.emoji2.text.j(gVar2.f9499a, 6, systemForegroundService2));
                }
            } else {
                this.f13094r = null;
            }
        }
        SystemForegroundService systemForegroundService3 = this.f13099w;
        if (gVar == null || systemForegroundService3 == null) {
            return;
        }
        p.d().a(f13090x, "Removing Notification (id: " + gVar.f9499a + ", workSpecId: " + jVar + ", notificationType: " + gVar.f9500b);
        systemForegroundService3.f1551p.post(new androidx.emoji2.text.j(gVar.f9499a, 6, systemForegroundService3));
    }

    public final void d(Intent intent) {
        int i10 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        j jVar = new j(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        p.d().a(f13090x, "Notifying with (id:" + intExtra + ", workSpecId: " + stringExtra + ", notificationType :" + intExtra2 + ")");
        if (notification == null || this.f13099w == null) {
            return;
        }
        g gVar = new g(intExtra, notification, intExtra2);
        LinkedHashMap linkedHashMap = this.f13095s;
        linkedHashMap.put(jVar, gVar);
        if (this.f13094r == null) {
            this.f13094r = jVar;
            SystemForegroundService systemForegroundService = this.f13099w;
            systemForegroundService.f1551p.post(new c(systemForegroundService, intExtra, notification, intExtra2));
            return;
        }
        SystemForegroundService systemForegroundService2 = this.f13099w;
        systemForegroundService2.f1551p.post(new h(systemForegroundService2, intExtra, notification, 8));
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            i10 |= ((g) ((Map.Entry) it.next()).getValue()).f9500b;
        }
        g gVar2 = (g) linkedHashMap.get(this.f13094r);
        if (gVar2 != null) {
            SystemForegroundService systemForegroundService3 = this.f13099w;
            systemForegroundService3.f1551p.post(new c(systemForegroundService3, gVar2.f9499a, gVar2.f9501c, i10));
        }
    }

    @Override // t4.e
    public final void e(o oVar, t4.c cVar) {
        if (cVar instanceof t4.b) {
            String str = oVar.f13569a;
            p.d().a(f13090x, "Constraints unmet for WorkSpec " + str);
            j g = n.g(oVar);
            r rVar = this.f13091o;
            i iVar = rVar.f9960d;
            p4.f fVar = rVar.f9962f;
            l lVar = new l(g);
            za.h.e("processor", fVar);
            iVar.g(new m(fVar, lVar, true, -512));
        }
    }

    public final void f() {
        this.f13099w = null;
        synchronized (this.f13093q) {
            try {
                Iterator it = this.f13097u.values().iterator();
                while (it.hasNext()) {
                    ((p0) it.next()).c(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f13091o.f9962f.h(this);
    }
}
