package y4;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f13843o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f13844p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f13845q;

    public /* synthetic */ p(Object obj, int i10, Object obj2) {
        this.f13843o = i10;
        this.f13844p = obj;
        this.f13845q = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13843o) {
            case 0:
                q qVar = (q) this.f13844p;
                z4.j jVar = (z4.j) this.f13845q;
                if (!(qVar.f13847o.f14111o instanceof z4.a)) {
                    jVar.k(qVar.f13850r.a());
                    break;
                } else {
                    jVar.cancel(true);
                    break;
                }
            default:
                JobInfoSchedulerService jobInfoSchedulerService = (JobInfoSchedulerService) this.f13844p;
                JobParameters jobParameters = (JobParameters) this.f13845q;
                int i10 = JobInfoSchedulerService.f3115o;
                jobInfoSchedulerService.jobFinished(jobParameters, false);
                break;
        }
    }
}
