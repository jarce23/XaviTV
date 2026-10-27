package s4;

import android.app.job.JobParameters;
import android.net.Network;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e {
    public static Network a(JobParameters jobParameters) {
        return jobParameters.getNetwork();
    }
}
