package r4;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.ArrayList;
import o4.p;
import o4.q;
import p4.r;
import x4.j;
import y4.n;
import y4.w;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements p4.c {

    /* renamed from: y, reason: collision with root package name */
    public static final String f10773y = p.f("SystemAlarmDispatcher");

    /* renamed from: o, reason: collision with root package name */
    public final Context f10774o;

    /* renamed from: p, reason: collision with root package name */
    public final x4.i f10775p;

    /* renamed from: q, reason: collision with root package name */
    public final w f10776q;

    /* renamed from: r, reason: collision with root package name */
    public final p4.f f10777r;

    /* renamed from: s, reason: collision with root package name */
    public final r f10778s;

    /* renamed from: t, reason: collision with root package name */
    public final c f10779t;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f10780u;

    /* renamed from: v, reason: collision with root package name */
    public Intent f10781v;

    /* renamed from: w, reason: collision with root package name */
    public SystemAlarmService f10782w;

    /* renamed from: x, reason: collision with root package name */
    public final x4.c f10783x;

    public i(SystemAlarmService systemAlarmService) {
        Context applicationContext = systemAlarmService.getApplicationContext();
        this.f10774o = applicationContext;
        j5.g gVar = new j5.g(14);
        r b2 = r.b(systemAlarmService);
        o4.a aVar = b2.f9958b;
        this.f10778s = b2;
        this.f10779t = new c(applicationContext, (q) aVar.g, gVar);
        this.f10776q = new w((h5.i) aVar.f9481j);
        p4.f fVar = b2.f9962f;
        this.f10777r = fVar;
        x4.i iVar = b2.f9960d;
        this.f10775p = iVar;
        this.f10783x = new x4.c(fVar, iVar);
        fVar.a(this);
        this.f10780u = new ArrayList();
        this.f10781v = null;
    }

    public static void c() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public final void a(Intent intent, int i10) {
        p d6 = p.d();
        String str = f10773y;
        d6.a(str, "Adding command " + intent + " (" + i10 + ")");
        c();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            p.d().g(str, "Unknown command. Ignoring");
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && d()) {
            return;
        }
        intent.putExtra("KEY_START_ID", i10);
        synchronized (this.f10780u) {
            try {
                boolean isEmpty = this.f10780u.isEmpty();
                this.f10780u.add(intent);
                if (isEmpty) {
                    e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p4.c
    public final void b(j jVar, boolean z10) {
        a5.a aVar = (a5.a) this.f10775p.f13556s;
        String str = c.f10746t;
        Intent intent = new Intent(this.f10774o, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z10);
        c.e(intent, jVar);
        aVar.execute(new androidx.activity.h(this, intent, 0, 7));
    }

    public final boolean d() {
        c();
        synchronized (this.f10780u) {
            try {
                ArrayList arrayList = this.f10780u;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) obj).getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        c();
        PowerManager.WakeLock a10 = n.a(this.f10774o, "ProcessCommand");
        try {
            a10.acquire();
            this.f10778s.f9960d.g(new h(this, 0));
        } finally {
            a10.release();
        }
    }
}
