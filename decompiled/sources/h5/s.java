package h5;

import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5653o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ u f5654p;

    public /* synthetic */ s(u uVar, int i10) {
        this.f5653o = i10;
        this.f5654p = uVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5653o) {
            case 0:
                u uVar = this.f5654p;
                uVar.B0.e();
                uVar.J(false, false);
                break;
            default:
                this.f5654p.B0.a();
                break;
        }
    }
}
