package l8;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.leanback.widget.w0;
import java.util.WeakHashMap;
import m0.k0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a extends z.a {

    /* renamed from: a, reason: collision with root package name */
    public w0 f8325a;

    @Override // z.a
    public boolean g(CoordinatorLayout coordinatorLayout, View view, int i10) {
        r(coordinatorLayout, view, i10);
        if (this.f8325a == null) {
            w0 w0Var = new w0();
            w0Var.f1089q = view;
            this.f8325a = w0Var;
        }
        w0 w0Var2 = this.f8325a;
        View view2 = (View) w0Var2.f1089q;
        w0Var2.f1087o = view2.getTop();
        w0Var2.f1088p = view2.getLeft();
        w0 w0Var3 = this.f8325a;
        View view3 = (View) w0Var3.f1089q;
        int top = 0 - (view3.getTop() - w0Var3.f1087o);
        WeakHashMap weakHashMap = k0.f8683a;
        view3.offsetTopAndBottom(top);
        view3.offsetLeftAndRight(0 - (view3.getLeft() - w0Var3.f1088p));
        return true;
    }

    public void r(CoordinatorLayout coordinatorLayout, View view, int i10) {
        coordinatorLayout.q(view, i10);
    }
}
