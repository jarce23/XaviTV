package r4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import com.google.android.gms.internal.cast.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import o4.p;
import o4.q;
import p4.l;
import x4.j;
import x4.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements p4.c {

    /* renamed from: t, reason: collision with root package name */
    public static final String f10746t = p.f("CommandHandler");

    /* renamed from: o, reason: collision with root package name */
    public final Context f10747o;

    /* renamed from: p, reason: collision with root package name */
    public final HashMap f10748p = new HashMap();

    /* renamed from: q, reason: collision with root package name */
    public final Object f10749q = new Object();

    /* renamed from: r, reason: collision with root package name */
    public final q f10750r;

    /* renamed from: s, reason: collision with root package name */
    public final j5.g f10751s;

    public c(Context context, q qVar, j5.g gVar) {
        this.f10747o = context;
        this.f10750r = qVar;
        this.f10751s = gVar;
    }

    public static j d(Intent intent) {
        return new j(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static void e(Intent intent, j jVar) {
        intent.putExtra("KEY_WORKSPEC_ID", jVar.f13557a);
        intent.putExtra("KEY_WORKSPEC_GENERATION", jVar.f13558b);
    }

    public final boolean a() {
        boolean z10;
        synchronized (this.f10749q) {
            z10 = !this.f10748p.isEmpty();
        }
        return z10;
    }

    @Override // p4.c
    public final void b(j jVar, boolean z10) {
        synchronized (this.f10749q) {
            try {
                g gVar = (g) this.f10748p.remove(jVar);
                this.f10751s.w(jVar);
                if (gVar != null) {
                    gVar.f(z10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Intent intent, int i10, i iVar) {
        List<l> list;
        String action = intent.getAction();
        int i11 = 7;
        int i12 = 0;
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            p.d().a(f10746t, "Handling constraints changed " + intent);
            Context context = this.f10747o;
            e eVar = new e(context, this.f10750r, i10, iVar);
            ArrayList f10 = iVar.f10778s.f9959c.t().f();
            String str = d.f10752a;
            int size = f10.size();
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            int i13 = 0;
            while (i13 < size) {
                Object obj = f10.get(i13);
                i13++;
                o4.d dVar = ((o) obj).f13577j;
                z10 |= dVar.f9490d;
                z11 |= dVar.f9488b;
                z12 |= dVar.f9491e;
                z13 |= dVar.f9487a != 1;
                if (z10 && z11 && z12 && z13) {
                    break;
                }
            }
            String str2 = ConstraintProxyUpdateReceiver.f1539a;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z10).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z11).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z12).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z13);
            context.sendBroadcast(intent2);
            ArrayList arrayList = new ArrayList(f10.size());
            eVar.f10754a.getClass();
            long currentTimeMillis = System.currentTimeMillis();
            int size2 = f10.size();
            int i14 = 0;
            while (i14 < size2) {
                Object obj2 = f10.get(i14);
                i14++;
                o oVar = (o) obj2;
                if (currentTimeMillis >= oVar.a() && (!oVar.b() || eVar.f10756c.b(oVar))) {
                    arrayList.add(oVar);
                }
            }
            int size3 = arrayList.size();
            while (i12 < size3) {
                Object obj3 = arrayList.get(i12);
                i12++;
                o oVar2 = (o) obj3;
                String str3 = oVar2.f13569a;
                j g = n.g(oVar2);
                Intent intent3 = new Intent(context, (Class<?>) SystemAlarmService.class);
                intent3.setAction("ACTION_DELAY_MET");
                e(intent3, g);
                p.d().a(e.f10753d, "Creating a delay_met command for workSpec with id (" + str3 + ")");
                ((a5.a) iVar.f10775p.f13556s).execute(new androidx.activity.h(iVar, intent3, eVar.f10755b, i11));
            }
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            p.d().a(f10746t, "Handling reschedule " + intent + ", " + i10);
            iVar.f10778s.d();
            return;
        }
        Bundle extras = intent.getExtras();
        String[] strArr = {"KEY_WORKSPEC_ID"};
        if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
            p.d().b(f10746t, "Invalid request for " + action + " , requires KEY_WORKSPEC_ID .");
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            Context context2 = this.f10747o;
            j d6 = d(intent);
            p d10 = p.d();
            String str4 = f10746t;
            d10.a(str4, "Handling schedule work for " + d6);
            WorkDatabase workDatabase = iVar.f10778s.f9959c;
            workDatabase.c();
            try {
                o i15 = workDatabase.t().i(d6.f13557a);
                if (i15 == null) {
                    p.d().g(str4, "Skipping scheduling " + d6 + " because it's no longer in the DB");
                    return;
                }
                if (android.support.v4.media.d.c(i15.f13570b)) {
                    p.d().g(str4, "Skipping scheduling " + d6 + "because it is finished.");
                    return;
                }
                long a10 = i15.a();
                if (i15.b()) {
                    p.d().a(str4, "Opportunistically setting an alarm for " + d6 + "at " + a10);
                    b.b(context2, workDatabase, d6, a10);
                    Intent intent4 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                    intent4.setAction("ACTION_CONSTRAINTS_CHANGED");
                    ((a5.a) iVar.f10775p.f13556s).execute(new androidx.activity.h(iVar, intent4, i10, i11));
                } else {
                    p.d().a(str4, "Setting up Alarms for " + d6 + "at " + a10);
                    b.b(context2, workDatabase, d6, a10);
                }
                workDatabase.o();
                return;
            } finally {
                workDatabase.k();
            }
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            synchronized (this.f10749q) {
                try {
                    j d11 = d(intent);
                    p d12 = p.d();
                    String str5 = f10746t;
                    d12.a(str5, "Handing delay met for " + d11);
                    if (this.f10748p.containsKey(d11)) {
                        p.d().a(str5, "WorkSpec " + d11 + " is is already being handled for ACTION_DELAY_MET");
                    } else {
                        g gVar = new g(this.f10747o, i10, iVar, this.f10751s.x(d11));
                        this.f10748p.put(d11, gVar);
                        gVar.d();
                    }
                } finally {
                }
            }
            return;
        }
        if (!"ACTION_STOP_WORK".equals(action)) {
            if (!"ACTION_EXECUTION_COMPLETED".equals(action)) {
                p.d().g(f10746t, "Ignoring intent " + intent);
                return;
            }
            j d13 = d(intent);
            boolean z14 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
            p.d().a(f10746t, "Handling onExecutionCompleted " + intent + ", " + i10);
            b(d13, z14);
            return;
        }
        j5.g gVar2 = this.f10751s;
        Bundle extras2 = intent.getExtras();
        String string = extras2.getString("KEY_WORKSPEC_ID");
        if (extras2.containsKey("KEY_WORKSPEC_GENERATION")) {
            int i16 = extras2.getInt("KEY_WORKSPEC_GENERATION");
            ArrayList arrayList2 = new ArrayList(1);
            l w10 = gVar2.w(new j(string, i16));
            list = arrayList2;
            if (w10 != null) {
                arrayList2.add(w10);
                list = arrayList2;
            }
        } else {
            list = gVar2.s(string);
        }
        for (l lVar : list) {
            p.d().a(f10746t, "Handing stopWork work for " + string);
            x4.c cVar = iVar.f10783x;
            cVar.getClass();
            za.h.e("workSpecId", lVar);
            cVar.e0(lVar, -512);
            j jVar = lVar.f9939a;
            Context context3 = this.f10747o;
            WorkDatabase workDatabase2 = iVar.f10778s.f9959c;
            String str6 = b.f10745a;
            x4.i p10 = workDatabase2.p();
            x4.g n10 = p10.n(jVar);
            if (n10 != null) {
                b.a(context3, jVar, n10.f13550c);
                p.d().a(b.f10745a, "Removing SystemIdInfo for workSpecId (" + jVar + ")");
                String str7 = jVar.f13557a;
                int i17 = jVar.f13558b;
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) p10.f13553p;
                workDatabase_Impl.b();
                x4.h hVar = (x4.h) p10.f13555r;
                h4.i a11 = hVar.a();
                if (str7 == null) {
                    a11.o(1);
                } else {
                    a11.j(1, str7);
                }
                a11.A(2, i17);
                workDatabase_Impl.c();
                try {
                    a11.a();
                    workDatabase_Impl.o();
                } finally {
                    workDatabase_Impl.k();
                    hVar.d(a11);
                }
            }
            iVar.b(jVar, false);
        }
    }
}
