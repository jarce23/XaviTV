package f;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t extends w7.b {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f4849q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f4850r;

    public /* synthetic */ t(int i10, Object obj) {
        this.f4849q = i10;
        this.f4850r = obj;
    }

    @Override // m0.q0
    public final void c() {
        int i10 = this.f4849q;
        Object obj = this.f4850r;
        switch (i10) {
            case 0:
                b0 b0Var = ((r) obj).f4846p;
                b0Var.J.setAlpha(1.0f);
                b0Var.M.d(null);
                b0Var.M = null;
                break;
            case 1:
                b0 b0Var2 = (b0) obj;
                b0Var2.J.setAlpha(1.0f);
                b0Var2.M.d(null);
                b0Var2.M = null;
                break;
            default:
                b0 b0Var3 = (b0) ((x4.c) obj).f13538q;
                b0Var3.J.setVisibility(8);
                PopupWindow popupWindow = b0Var3.K;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (b0Var3.J.getParent() instanceof View) {
                    View view = (View) b0Var3.J.getParent();
                    WeakHashMap weakHashMap = m0.k0.f8683a;
                    m0.a0.c(view);
                }
                b0Var3.J.e();
                b0Var3.M.d(null);
                b0Var3.M = null;
                ViewGroup viewGroup = b0Var3.P;
                WeakHashMap weakHashMap2 = m0.k0.f8683a;
                m0.a0.c(viewGroup);
                break;
        }
    }

    @Override // w7.b, m0.q0
    public void e() {
        int i10 = this.f4849q;
        Object obj = this.f4850r;
        switch (i10) {
            case 0:
                ((r) obj).f4846p.J.setVisibility(0);
                break;
            case 1:
                b0 b0Var = (b0) obj;
                b0Var.J.setVisibility(0);
                if (b0Var.J.getParent() instanceof View) {
                    View view = (View) b0Var.J.getParent();
                    WeakHashMap weakHashMap = m0.k0.f8683a;
                    m0.a0.c(view);
                    break;
                }
                break;
        }
    }
}
