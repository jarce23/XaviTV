package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.support.v4.media.session.a0;
import android.util.Base64;
import d7.a;
import j9.n;
import java.util.concurrent.Executor;
import s6.i;
import s6.o;
import y4.p;
import z6.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f3115o = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i10 = jobParameters.getExtras().getInt("priority");
        int i11 = jobParameters.getExtras().getInt("attemptNumber");
        o.b(getApplicationContext());
        a0 a10 = i.a();
        a10.X(string);
        a10.f232r = a.b(i10);
        if (string2 != null) {
            a10.f231q = Base64.decode(string2, 0);
        }
        n nVar = o.a().f11629d;
        ((Executor) nVar.f7386t).execute(new d(nVar, a10.B(), i11, new p(this, 1, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
