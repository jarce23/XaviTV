package h5;

import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o0 implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5637o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ q0 f5638p;

    public /* synthetic */ o0(q0 q0Var, int i10) {
        this.f5637o = i10;
        this.f5638p = q0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5637o) {
            case 0:
                q0 q0Var = this.f5638p;
                q0Var.C0.e();
                q0Var.J(false, false);
                break;
            default:
                this.f5638p.C0.a();
                break;
        }
    }
}
