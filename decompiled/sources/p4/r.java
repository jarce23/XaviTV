package p4;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import java.util.List;
import o4.w;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends w {

    /* renamed from: k, reason: collision with root package name */
    public static r f9954k;

    /* renamed from: l, reason: collision with root package name */
    public static r f9955l;

    /* renamed from: m, reason: collision with root package name */
    public static final Object f9956m;

    /* renamed from: a, reason: collision with root package name */
    public final Context f9957a;

    /* renamed from: b, reason: collision with root package name */
    public final o4.a f9958b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkDatabase f9959c;

    /* renamed from: d, reason: collision with root package name */
    public final x4.i f9960d;

    /* renamed from: e, reason: collision with root package name */
    public final List f9961e;

    /* renamed from: f, reason: collision with root package name */
    public final f f9962f;
    public final y4.g g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9963h = false;

    /* renamed from: i, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f9964i;

    /* renamed from: j, reason: collision with root package name */
    public final x4.i f9965j;

    static {
        o4.p.f("WorkManagerImpl");
        f9954k = null;
        f9955l = null;
        f9956m = new Object();
    }

    public r(Context context, final o4.a aVar, x4.i iVar, final WorkDatabase workDatabase, final List list, f fVar, x4.i iVar2) {
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 24 && q.a(applicationContext)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        o4.p pVar = new o4.p(aVar.f9473a);
        synchronized (o4.p.f9510b) {
            o4.p.f9511c = pVar;
        }
        this.f9957a = applicationContext;
        this.f9960d = iVar;
        this.f9959c = workDatabase;
        this.f9962f = fVar;
        this.f9965j = iVar2;
        this.f9958b = aVar;
        this.f9961e = list;
        this.g = new y4.g(workDatabase, 1);
        final f.o oVar = (f.o) iVar.f13553p;
        String str = k.f9938a;
        fVar.a(new c() { // from class: p4.i
            @Override // p4.c
            public final void b(x4.j jVar, boolean z10) {
                oVar.execute(new j(list, jVar, aVar, workDatabase, 0));
            }
        });
        iVar.g(new y4.d(applicationContext, this));
    }

    public static r a() {
        synchronized (f9956m) {
            try {
                r rVar = f9954k;
                if (rVar != null) {
                    return rVar;
                }
                return f9955l;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static r b(Context context) {
        r a10;
        synchronized (f9956m) {
            try {
                a10 = a();
                if (a10 == null) {
                    context.getApplicationContext();
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a10;
    }

    public final void c() {
        synchronized (f9956m) {
            try {
                this.f9963h = true;
                BroadcastReceiver.PendingResult pendingResult = this.f9964i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.f9964i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        ArrayList f10;
        String str = s4.c.f11567t;
        Context context = this.f9957a;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (f10 = s4.c.f(context, jobScheduler)) != null && !f10.isEmpty()) {
            int size = f10.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = f10.get(i10);
                i10++;
                s4.c.b(jobScheduler, ((JobInfo) obj).getId());
            }
        }
        WorkDatabase workDatabase = this.f9959c;
        x4.p t3 = workDatabase.t();
        WorkDatabase_Impl workDatabase_Impl = t3.f13591a;
        workDatabase_Impl.b();
        x4.h hVar = t3.f13602m;
        h4.i a10 = hVar.a();
        workDatabase_Impl.c();
        try {
            a10.a();
            workDatabase_Impl.o();
            workDatabase_Impl.k();
            hVar.d(a10);
            k.b(this.f9958b, workDatabase, this.f9961e);
        } catch (Throwable th) {
            workDatabase_Impl.k();
            hVar.d(a10);
            throw th;
        }
    }
}
