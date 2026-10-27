package m;

import android.database.DataSetObserver;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x1 extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z1 f8595a;

    public x1(z1 z1Var) {
        this.f8595a = z1Var;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        z1 z1Var = this.f8595a;
        if (z1Var.N.isShowing()) {
            z1Var.c();
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.f8595a.dismiss();
    }
}
