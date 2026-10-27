package w3;

import android.util.SparseArray;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f12936o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ j0 f12937p;

    public /* synthetic */ i0(j0 j0Var, int i10) {
        this.f12936o = i10;
        this.f12937p = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12936o) {
            case 0:
                SparseArray sparseArray = this.f12937p.f12946h;
                int size = sparseArray.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((l0) sparseArray.valueAt(i10)).getClass();
                    l0.a(null, null);
                }
                sparseArray.clear();
                break;
            default:
                j0 j0Var = this.f12937p;
                o0 o0Var = j0Var.f12947i;
                if (o0Var.f12990n == j0Var) {
                    o0Var.k();
                    break;
                }
                break;
        }
    }
}
