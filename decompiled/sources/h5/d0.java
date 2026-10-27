package h5;

import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5590o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ f0 f5591p;

    public /* synthetic */ d0(f0 f0Var, int i10) {
        this.f5590o = i10;
        this.f5591p = f0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5590o) {
            case 0:
                f0 f0Var = this.f5591p;
                f0Var.C0.a(f0Var.G0);
                f0Var.J(false, false);
                break;
            default:
                this.f5591p.J(false, false);
                break;
        }
    }
}
