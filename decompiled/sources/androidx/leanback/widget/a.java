package androidx.leanback.widget;

import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import b4.f1;
import b4.n1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements b4.v0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f1000a;

    public a(f fVar) {
        this.f1000a = fVar;
    }

    public final void a(f1 f1Var) {
        f fVar = this.f1000a;
        p pVar = fVar.W0;
        pVar.getClass();
        int b2 = f1Var.b();
        if (b2 != -1) {
            w0 w0Var = pVar.Z;
            View view = f1Var.f2232a;
            int i10 = w0Var.f1087o;
            if (i10 == 1) {
                n1 n1Var = (n1) w0Var.f1089q;
                if (n1Var != null && n1Var.m() != 0) {
                    ((n1) w0Var.f1089q).l(Integer.toString(b2));
                }
            } else if ((i10 == 2 || i10 == 3) && ((n1) w0Var.f1089q) != null) {
                String num = Integer.toString(b2);
                SparseArray<Parcelable> sparseArray = new SparseArray<>();
                view.saveHierarchyState(sparseArray);
                ((n1) w0Var.f1089q).k(num, sparseArray);
            }
        }
        b4.v0 v0Var = fVar.f1016a1;
        if (v0Var != null) {
            ((a) v0Var).a(f1Var);
        }
    }
}
