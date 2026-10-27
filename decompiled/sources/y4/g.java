package y4;

import androidx.work.impl.WorkDatabase;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase f13833a;

    public g(WorkDatabase workDatabase, int i10) {
        switch (i10) {
            case 1:
                this.f13833a = workDatabase;
                break;
            default:
                za.h.e("workDatabase", workDatabase);
                this.f13833a = workDatabase;
                break;
        }
    }
}
