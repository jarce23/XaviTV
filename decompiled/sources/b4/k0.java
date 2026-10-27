package b4;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    public e0 f2294a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f2295b;

    /* renamed from: c, reason: collision with root package name */
    public long f2296c;

    /* renamed from: d, reason: collision with root package name */
    public long f2297d;

    /* renamed from: e, reason: collision with root package name */
    public long f2298e;

    /* renamed from: f, reason: collision with root package name */
    public long f2299f;

    public static void b(f1 f1Var) {
        RecyclerView recyclerView;
        int i10 = f1Var.f2240j;
        if (f1Var.g() || (i10 & 4) != 0 || (recyclerView = f1Var.f2248r) == null) {
            return;
        }
        recyclerView.G(f1Var);
    }

    public abstract boolean a(f1 f1Var, f1 f1Var2, j0 j0Var, j0 j0Var2);

    public final void c(f1 f1Var) {
        e0 e0Var = this.f2294a;
        if (e0Var != null) {
            RecyclerView recyclerView = e0Var.f2214a;
            boolean z10 = true;
            f1Var.o(true);
            View view = f1Var.f2232a;
            if (f1Var.f2238h != null && f1Var.f2239i == null) {
                f1Var.f2238h = null;
            }
            f1Var.f2239i = null;
            if ((f1Var.f2240j & 16) != 0) {
                return;
            }
            u0 u0Var = recyclerView.f1476q;
            recyclerView.i0();
            android.support.v4.media.session.a0 a0Var = recyclerView.f1482t;
            c cVar = (c) a0Var.f231q;
            e0 e0Var2 = (e0) a0Var.f230p;
            int indexOfChild = e0Var2.f2214a.indexOfChild(view);
            if (indexOfChild == -1) {
                a0Var.d0(view);
            } else if (cVar.v(indexOfChild)) {
                cVar.y(indexOfChild);
                a0Var.d0(view);
                e0Var2.h(indexOfChild);
            } else {
                z10 = false;
            }
            if (z10) {
                f1 J = RecyclerView.J(view);
                u0Var.m(J);
                u0Var.j(J);
            }
            recyclerView.j0(!z10);
            if (z10 || !f1Var.k()) {
                return;
            }
            recyclerView.removeDetachedView(view, false);
        }
    }

    public abstract void d(f1 f1Var);

    public abstract void e();

    public abstract boolean f();
}
