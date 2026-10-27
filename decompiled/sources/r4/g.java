package r4;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import f.o;
import ib.h0;
import ib.s0;
import o4.p;
import p4.l;
import x4.j;
import y4.n;
import y4.u;
import y4.v;
import y4.w;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements t4.e, u {
    public static final String C = p.f("DelayMetCommandHandler");
    public final h0 A;
    public volatile s0 B;

    /* renamed from: o, reason: collision with root package name */
    public final Context f10759o;

    /* renamed from: p, reason: collision with root package name */
    public final int f10760p;

    /* renamed from: q, reason: collision with root package name */
    public final j f10761q;

    /* renamed from: r, reason: collision with root package name */
    public final i f10762r;

    /* renamed from: s, reason: collision with root package name */
    public final a3.f f10763s;

    /* renamed from: t, reason: collision with root package name */
    public final Object f10764t;

    /* renamed from: u, reason: collision with root package name */
    public int f10765u;

    /* renamed from: v, reason: collision with root package name */
    public final o f10766v;

    /* renamed from: w, reason: collision with root package name */
    public final a5.a f10767w;

    /* renamed from: x, reason: collision with root package name */
    public PowerManager.WakeLock f10768x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f10769y;

    /* renamed from: z, reason: collision with root package name */
    public final l f10770z;

    public g(Context context, int i10, i iVar, l lVar) {
        this.f10759o = context;
        this.f10760p = i10;
        this.f10762r = iVar;
        this.f10761q = lVar.f9939a;
        this.f10770z = lVar;
        x4.i iVar2 = iVar.f10778s.f9965j;
        x4.i iVar3 = iVar.f10775p;
        this.f10766v = (o) iVar3.f13553p;
        this.f10767w = (a5.a) iVar3.f13556s;
        this.A = (h0) iVar3.f13554q;
        this.f10763s = new a3.f(iVar2);
        this.f10769y = false;
        this.f10765u = 0;
        this.f10764t = new Object();
    }

    public static void a(g gVar) {
        int i10 = gVar.f10760p;
        a5.a aVar = gVar.f10767w;
        Context context = gVar.f10759o;
        i iVar = gVar.f10762r;
        j jVar = gVar.f10761q;
        String str = jVar.f13557a;
        int i11 = gVar.f10765u;
        String str2 = C;
        if (i11 >= 2) {
            p.d().a(str2, "Already stopped work for " + str);
            return;
        }
        gVar.f10765u = 2;
        p.d().a(str2, "Stopping work for WorkSpec " + str);
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        c.e(intent, jVar);
        aVar.execute(new androidx.activity.h(iVar, intent, i10, 7));
        if (!iVar.f10777r.g(str)) {
            p.d().a(str2, "Processor does not have WorkSpec " + str + ". No need to reschedule");
            return;
        }
        p.d().a(str2, "WorkSpec " + str + " needs to be rescheduled");
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_SCHEDULE_WORK");
        c.e(intent2, jVar);
        aVar.execute(new androidx.activity.h(iVar, intent2, i10, 7));
    }

    public static void b(g gVar) {
        if (gVar.f10765u != 0) {
            p.d().a(C, "Already started work for " + gVar.f10761q);
            return;
        }
        gVar.f10765u = 1;
        p.d().a(C, "onAllConstraintsMet for " + gVar.f10761q);
        if (!gVar.f10762r.f10777r.j(gVar.f10770z, null)) {
            gVar.c();
            return;
        }
        w wVar = gVar.f10762r.f10776q;
        j jVar = gVar.f10761q;
        synchronized (wVar.f13867d) {
            p.d().a(w.f13863e, "Starting timer for " + jVar);
            wVar.a(jVar);
            v vVar = new v(wVar, jVar);
            wVar.f13865b.put(jVar, vVar);
            wVar.f13866c.put(jVar, gVar);
            ((Handler) wVar.f13864a.f5610p).postDelayed(vVar, 600000L);
        }
    }

    public final void c() {
        synchronized (this.f10764t) {
            try {
                if (this.B != null) {
                    this.B.c(null);
                }
                this.f10762r.f10776q.a(this.f10761q);
                PowerManager.WakeLock wakeLock = this.f10768x;
                if (wakeLock != null && wakeLock.isHeld()) {
                    p.d().a(C, "Releasing wakelock " + this.f10768x + "for WorkSpec " + this.f10761q);
                    this.f10768x.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        String str = this.f10761q.f13557a;
        Context context = this.f10759o;
        StringBuilder a10 = s.e.a(str, " (");
        a10.append(this.f10760p);
        a10.append(")");
        this.f10768x = n.a(context, a10.toString());
        p d6 = p.d();
        String str2 = C;
        d6.a(str2, "Acquiring wakelock " + this.f10768x + "for WorkSpec " + str);
        this.f10768x.acquire();
        x4.o i10 = this.f10762r.f10778s.f9959c.t().i(str);
        if (i10 == null) {
            this.f10766v.execute(new f(this, 0));
            return;
        }
        boolean b2 = i10.b();
        this.f10769y = b2;
        if (b2) {
            this.B = t4.h.a(this.f10763s, i10, this.A, this);
            return;
        }
        p.d().a(str2, "No constraints for " + str);
        this.f10766v.execute(new f(this, 1));
    }

    @Override // t4.e
    public final void e(x4.o oVar, t4.c cVar) {
        boolean z10 = cVar instanceof t4.a;
        o oVar2 = this.f10766v;
        if (z10) {
            oVar2.execute(new f(this, 1));
        } else {
            oVar2.execute(new f(this, 0));
        }
    }

    public final void f(boolean z10) {
        p d6 = p.d();
        StringBuilder sb2 = new StringBuilder("onExecuted ");
        j jVar = this.f10761q;
        sb2.append(jVar);
        sb2.append(", ");
        sb2.append(z10);
        d6.a(C, sb2.toString());
        c();
        int i10 = this.f10760p;
        i iVar = this.f10762r;
        a5.a aVar = this.f10767w;
        Context context = this.f10759o;
        if (z10) {
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_SCHEDULE_WORK");
            c.e(intent, jVar);
            aVar.execute(new androidx.activity.h(iVar, intent, i10, 7));
        }
        if (this.f10769y) {
            Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
            aVar.execute(new androidx.activity.h(iVar, intent2, i10, 7));
        }
    }
}
