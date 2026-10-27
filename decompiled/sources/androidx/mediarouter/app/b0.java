package androidx.mediarouter.app;

import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1274o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ n0 f1275p;

    public /* synthetic */ b0(n0 n0Var, int i10) {
        this.f1274o = i10;
        this.f1275p = n0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f1274o) {
            case 0:
                this.f1275p.dismiss();
                break;
            default:
                n0 n0Var = this.f1275p;
                if (n0Var.f1356w.g()) {
                    n0Var.f1353t.getClass();
                    w3.b0.j(2);
                }
                n0Var.dismiss();
                break;
        }
    }
}
