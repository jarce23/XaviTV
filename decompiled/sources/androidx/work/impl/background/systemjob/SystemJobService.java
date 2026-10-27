package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import g7.c0;
import j5.g;
import java.util.Arrays;
import java.util.HashMap;
import o4.p;
import p4.c;
import p4.f;
import p4.l;
import p4.r;
import s4.d;
import s4.e;
import x4.i;
import x4.j;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SystemJobService extends JobService implements c {

    /* renamed from: s, reason: collision with root package name */
    public static final String f1544s = p.f("SystemJobService");

    /* renamed from: o, reason: collision with root package name */
    public r f1545o;

    /* renamed from: p, reason: collision with root package name */
    public final HashMap f1546p = new HashMap();

    /* renamed from: q, reason: collision with root package name */
    public final g f1547q = new g(14);

    /* renamed from: r, reason: collision with root package name */
    public x4.c f1548r;

    public static j a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new j(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // p4.c
    public final void b(j jVar, boolean z10) {
        JobParameters jobParameters;
        p.d().a(f1544s, jVar.f13557a + " executed on JobScheduler");
        synchronized (this.f1546p) {
            jobParameters = (JobParameters) this.f1546p.remove(jVar);
        }
        this.f1547q.w(jVar);
        if (jobParameters != null) {
            jobFinished(jobParameters, z10);
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            r b2 = r.b(getApplicationContext());
            this.f1545o = b2;
            f fVar = b2.f9962f;
            this.f1548r = new x4.c(fVar, b2.f9960d);
            fVar.a(this);
        } catch (IllegalStateException e7) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e7);
            }
            p.d().g(f1544s, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        r rVar = this.f1545o;
        if (rVar != null) {
            rVar.f9962f.h(this);
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        x4.c cVar;
        if (this.f1545o == null) {
            p.d().a(f1544s, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        j a10 = a(jobParameters);
        if (a10 == null) {
            p.d().b(f1544s, "WorkSpec id not found!");
            return false;
        }
        synchronized (this.f1546p) {
            try {
                if (this.f1546p.containsKey(a10)) {
                    p.d().a(f1544s, "Job is already being executed by SystemJobService: " + a10);
                    return false;
                }
                p.d().a(f1544s, "onStartJob for " + a10);
                this.f1546p.put(a10, jobParameters);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 24) {
                    cVar = new x4.c(13);
                    if (d.b(jobParameters) != null) {
                        cVar.f13538q = Arrays.asList(d.b(jobParameters));
                    }
                    if (d.a(jobParameters) != null) {
                        cVar.f13537p = Arrays.asList(d.a(jobParameters));
                    }
                    if (i10 >= 28) {
                        e.a(jobParameters);
                    }
                } else {
                    cVar = null;
                }
                x4.c cVar2 = this.f1548r;
                ((i) cVar2.f13538q).g(new c0((f) cVar2.f13537p, this.f1547q.x(a10), cVar));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        if (this.f1545o == null) {
            p.d().a(f1544s, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        j a10 = a(jobParameters);
        if (a10 == null) {
            p.d().b(f1544s, "WorkSpec id not found!");
            return false;
        }
        p.d().a(f1544s, "onStopJob for " + a10);
        synchronized (this.f1546p) {
            this.f1546p.remove(a10);
        }
        l w10 = this.f1547q.w(a10);
        if (w10 != null) {
            int a11 = Build.VERSION.SDK_INT >= 31 ? s4.f.a(jobParameters) : -512;
            x4.c cVar = this.f1548r;
            cVar.getClass();
            cVar.e0(w10, a11);
        }
        return !this.f1545o.f9962f.f(a10.f13557a);
    }
}
