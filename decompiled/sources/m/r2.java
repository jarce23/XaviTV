package m;

import androidx.appcompat.widget.Toolbar;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class r2 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f8539o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Toolbar f8540p;

    public /* synthetic */ r2(Toolbar toolbar, int i10) {
        this.f8539o = i10;
        this.f8540p = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8539o) {
            case 0:
                u2 u2Var = this.f8540p.f470c0;
                l.n nVar = u2Var == null ? null : u2Var.f8574p;
                if (nVar != null) {
                    nVar.collapseActionView();
                    break;
                }
                break;
            default:
                this.f8540p.m();
                break;
        }
    }
}
