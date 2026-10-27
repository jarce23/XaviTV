package f2;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import i1.v0;
import i1.y0;
import i1.z0;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends y0 {
    public final boolean F;
    public final boolean G;
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public final boolean L;
    public final SparseArray M;
    public final SparseBooleanArray N;

    public j(k kVar) {
        c(kVar);
        this.F = kVar.f4908o0;
        this.G = kVar.f4909p0;
        this.H = kVar.f4910q0;
        this.I = kVar.f4911r0;
        this.J = kVar.f4912s0;
        this.K = kVar.f4913t0;
        this.L = kVar.f4914u0;
        SparseArray sparseArray = kVar.f4915v0;
        SparseArray sparseArray2 = new SparseArray();
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            sparseArray2.put(sparseArray.keyAt(i10), new HashMap((Map) sparseArray.valueAt(i10)));
        }
        this.M = sparseArray2;
        this.N = kVar.f4916w0.clone();
    }

    @Override // i1.y0
    public final z0 a() {
        return new k(this);
    }

    @Override // i1.y0
    public final y0 b(int i10) {
        super.b(i10);
        return this;
    }

    @Override // i1.y0
    public final y0 e() {
        this.f6096y = -3;
        return this;
    }

    @Override // i1.y0
    public final y0 f(v0 v0Var) {
        super.f(v0Var);
        return this;
    }

    @Override // i1.y0
    public final y0 g() {
        super.g();
        return this;
    }

    @Override // i1.y0
    public final y0 h(String[] strArr) {
        super.h(strArr);
        return this;
    }

    @Override // i1.y0
    public final y0 i() {
        super.i();
        return this;
    }

    @Override // i1.y0
    public final y0 j(int i10, boolean z10) {
        super.j(i10, z10);
        return this;
    }

    public final void k(Set set) {
        this.E.clear();
        this.E.addAll(set);
    }

    public j() {
        this.M = new SparseArray();
        this.N = new SparseBooleanArray();
        this.F = true;
        this.G = true;
        this.H = true;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = true;
    }
}
