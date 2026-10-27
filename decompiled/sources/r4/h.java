package r4;

import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import f.o;
import o4.p;
import y4.n;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f10771o;

    /* renamed from: p, reason: collision with root package name */
    public final i f10772p;

    public /* synthetic */ h(i iVar, int i10) {
        this.f10771o = i10;
        this.f10772p = iVar;
    }

    private final void a() {
        a5.a aVar;
        h hVar;
        synchronized (this.f10772p.f10780u) {
            i iVar = this.f10772p;
            iVar.f10781v = (Intent) iVar.f10780u.get(0);
        }
        Intent intent = this.f10772p.f10781v;
        if (intent != null) {
            String action = intent.getAction();
            int intExtra = this.f10772p.f10781v.getIntExtra("KEY_START_ID", 0);
            p d6 = p.d();
            String str = i.f10773y;
            d6.a(str, "Processing command " + this.f10772p.f10781v + ", " + intExtra);
            PowerManager.WakeLock a10 = n.a(this.f10772p.f10774o, action + " (" + intExtra + ")");
            try {
                p.d().a(str, "Acquiring operation wake lock (" + action + ") " + a10);
                a10.acquire();
                i iVar2 = this.f10772p;
                iVar2.f10779t.c(iVar2.f10781v, intExtra, iVar2);
                p.d().a(str, "Releasing operation wake lock (" + action + ") " + a10);
                a10.release();
                i iVar3 = this.f10772p;
                aVar = (a5.a) iVar3.f10775p.f13556s;
                hVar = new h(iVar3, 1);
            } catch (Throwable th) {
                try {
                    p d10 = p.d();
                    String str2 = i.f10773y;
                    d10.c(str2, "Unexpected error in onHandleIntent", th);
                    p.d().a(str2, "Releasing operation wake lock (" + action + ") " + a10);
                    a10.release();
                    i iVar4 = this.f10772p;
                    aVar = (a5.a) iVar4.f10775p.f13556s;
                    hVar = new h(iVar4, 1);
                } catch (Throwable th2) {
                    p.d().a(i.f10773y, "Releasing operation wake lock (" + action + ") " + a10);
                    a10.release();
                    i iVar5 = this.f10772p;
                    ((a5.a) iVar5.f10775p.f13556s).execute(new h(iVar5, 1));
                    throw th2;
                }
            }
            aVar.execute(hVar);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10771o) {
            case 0:
                a();
                return;
            default:
                i iVar = this.f10772p;
                p d6 = p.d();
                String str = i.f10773y;
                d6.a(str, "Checking if commands are complete.");
                i.c();
                synchronized (iVar.f10780u) {
                    try {
                        if (iVar.f10781v != null) {
                            p.d().a(str, "Removing command " + iVar.f10781v);
                            if (!((Intent) iVar.f10780u.remove(0)).equals(iVar.f10781v)) {
                                throw new IllegalStateException("Dequeue-d command is not the first.");
                            }
                            iVar.f10781v = null;
                        }
                        o oVar = (o) iVar.f10775p.f13553p;
                        if (!iVar.f10779t.a() && iVar.f10780u.isEmpty() && !oVar.b()) {
                            p.d().a(str, "No more commands & intents.");
                            SystemAlarmService systemAlarmService = iVar.f10782w;
                            if (systemAlarmService != null) {
                                systemAlarmService.a();
                            }
                        } else if (!iVar.f10780u.isEmpty()) {
                            iVar.e();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }
}
