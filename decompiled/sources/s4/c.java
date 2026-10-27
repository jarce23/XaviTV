package s4;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemjob.SystemJobService;
import com.google.android.gms.internal.cast.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import o4.p;
import o4.q;
import p4.h;
import x4.i;
import x4.j;
import x4.o;
import y4.g;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements h {

    /* renamed from: t, reason: collision with root package name */
    public static final String f11567t = p.f("SystemJobScheduler");

    /* renamed from: o, reason: collision with root package name */
    public final Context f11568o;

    /* renamed from: p, reason: collision with root package name */
    public final JobScheduler f11569p;

    /* renamed from: q, reason: collision with root package name */
    public final b f11570q;

    /* renamed from: r, reason: collision with root package name */
    public final WorkDatabase f11571r;

    /* renamed from: s, reason: collision with root package name */
    public final o4.a f11572s;

    public c(Context context, WorkDatabase workDatabase, o4.a aVar) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        b bVar = new b(context, (q) aVar.g);
        this.f11568o = context;
        this.f11569p = jobScheduler;
        this.f11570q = bVar;
        this.f11571r = workDatabase;
        this.f11572s = aVar;
    }

    public static void b(JobScheduler jobScheduler, int i10) {
        try {
            jobScheduler.cancel(i10);
        } catch (Throwable th) {
            p.d().c(f11567t, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i10)), th);
        }
    }

    public static ArrayList e(Context context, JobScheduler jobScheduler, String str) {
        ArrayList f10 = f(context, jobScheduler);
        if (f10 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        int size = f10.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = f10.get(i10);
            i10++;
            JobInfo jobInfo = (JobInfo) obj;
            j g = g(jobInfo);
            if (g != null && str.equals(g.f13557a)) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public static ArrayList f(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            p.d().c(f11567t, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static j g(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new j(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // p4.h
    public final void a(o... oVarArr) {
        int intValue;
        ArrayList e7;
        int intValue2;
        WorkDatabase workDatabase = this.f11571r;
        final g gVar = new g(workDatabase, 0);
        for (o oVar : oVarArr) {
            workDatabase.c();
            try {
                x4.p t3 = workDatabase.t();
                String str = oVar.f13569a;
                o i10 = t3.i(str);
                String str2 = f11567t;
                if (i10 == null) {
                    p.d().g(str2, "Skipping scheduling " + str + " because it's no longer in the DB");
                    workDatabase.o();
                } else if (i10.f13570b != 1) {
                    p.d().g(str2, "Skipping scheduling " + str + " because it is no longer enqueued");
                    workDatabase.o();
                } else {
                    j g = n.g(oVar);
                    x4.g n10 = workDatabase.p().n(g);
                    o4.a aVar = this.f11572s;
                    WorkDatabase workDatabase2 = gVar.f13833a;
                    if (n10 != null) {
                        intValue = n10.f13550c;
                    } else {
                        aVar.getClass();
                        final int i11 = aVar.f9474b;
                        Object n11 = workDatabase2.n(new Callable() { // from class: y4.f
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                WorkDatabase workDatabase3 = g.this.f13833a;
                                Long h10 = workDatabase3.l().h("next_job_scheduler_id");
                                int i12 = 0;
                                int longValue = h10 != null ? (int) h10.longValue() : 0;
                                workDatabase3.l().k(new x4.d("next_job_scheduler_id", Long.valueOf(longValue == Integer.MAX_VALUE ? 0 : longValue + 1)));
                                if (longValue < 0 || longValue > i11) {
                                    workDatabase3.l().k(new x4.d("next_job_scheduler_id", Long.valueOf(1)));
                                } else {
                                    i12 = longValue;
                                }
                                return Integer.valueOf(i12);
                            }
                        });
                        za.h.d("workDatabase.runInTransa…            id\n        })", n11);
                        intValue = ((Number) n11).intValue();
                    }
                    if (n10 == null) {
                        workDatabase.p().o(new x4.g(g.f13557a, g.f13558b, intValue));
                    }
                    h(oVar, intValue);
                    if (Build.VERSION.SDK_INT == 23 && (e7 = e(this.f11568o, this.f11569p, str)) != null) {
                        int indexOf = e7.indexOf(Integer.valueOf(intValue));
                        if (indexOf >= 0) {
                            e7.remove(indexOf);
                        }
                        if (e7.isEmpty()) {
                            aVar.getClass();
                            final int i12 = aVar.f9474b;
                            Object n12 = workDatabase2.n(new Callable() { // from class: y4.f
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    WorkDatabase workDatabase3 = g.this.f13833a;
                                    Long h10 = workDatabase3.l().h("next_job_scheduler_id");
                                    int i122 = 0;
                                    int longValue = h10 != null ? (int) h10.longValue() : 0;
                                    workDatabase3.l().k(new x4.d("next_job_scheduler_id", Long.valueOf(longValue == Integer.MAX_VALUE ? 0 : longValue + 1)));
                                    if (longValue < 0 || longValue > i12) {
                                        workDatabase3.l().k(new x4.d("next_job_scheduler_id", Long.valueOf(1)));
                                    } else {
                                        i122 = longValue;
                                    }
                                    return Integer.valueOf(i122);
                                }
                            });
                            za.h.d("workDatabase.runInTransa…            id\n        })", n12);
                            intValue2 = ((Number) n12).intValue();
                        } else {
                            intValue2 = ((Integer) e7.get(0)).intValue();
                        }
                        h(oVar, intValue2);
                    }
                    workDatabase.o();
                }
            } finally {
                workDatabase.k();
            }
        }
    }

    @Override // p4.h
    public final void c(String str) {
        Context context = this.f11568o;
        JobScheduler jobScheduler = this.f11569p;
        ArrayList e7 = e(context, jobScheduler, str);
        if (e7 == null || e7.isEmpty()) {
            return;
        }
        int size = e7.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = e7.get(i10);
            i10++;
            b(jobScheduler, ((Integer) obj).intValue());
        }
        i p10 = this.f11571r.p();
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) p10.f13553p;
        workDatabase_Impl.b();
        x4.h hVar = (x4.h) p10.f13556s;
        h4.i a10 = hVar.a();
        if (str == null) {
            a10.o(1);
        } else {
            a10.j(1, str);
        }
        workDatabase_Impl.c();
        try {
            a10.a();
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.k();
            hVar.d(a10);
        }
    }

    @Override // p4.h
    public final boolean d() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0075, code lost:
    
        if (r10 < 26) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(x4.o r21, int r22) {
        /*
            Method dump skipped, instructions count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.c.h(x4.o, int):void");
    }
}
