package f;

import android.view.ViewGroup;
import m0.p0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4845o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ b0 f4846p;

    public /* synthetic */ r(b0 b0Var, int i10) {
        this.f4845o = i10;
        this.f4846p = b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        switch (this.f4845o) {
            case 0:
                b0 b0Var = this.f4846p;
                if ((b0Var.f4733o0 & 1) != 0) {
                    b0Var.u(0);
                }
                if ((b0Var.f4733o0 & 4096) != 0) {
                    b0Var.u(108);
                }
                b0Var.f4732n0 = false;
                b0Var.f4733o0 = 0;
                break;
            default:
                b0 b0Var2 = this.f4846p;
                b0Var2.K.showAtLocation(b0Var2.J, 55, 0, 0);
                p0 p0Var = b0Var2.M;
                if (p0Var != null) {
                    p0Var.b();
                }
                if (!b0Var2.O || (viewGroup = b0Var2.P) == null || !viewGroup.isLaidOut()) {
                    b0Var2.J.setAlpha(1.0f);
                    b0Var2.J.setVisibility(0);
                    break;
                } else {
                    b0Var2.J.setAlpha(0.0f);
                    p0 a10 = m0.k0.a(b0Var2.J);
                    a10.a(1.0f);
                    b0Var2.M = a10;
                    a10.d(new t(0, this));
                    break;
                }
        }
    }
}
