package b4;

import android.util.SparseArray;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray f2414a;

    /* renamed from: b, reason: collision with root package name */
    public int f2415b;

    /* renamed from: c, reason: collision with root package name */
    public Set f2416c;

    public final s0 a(int i10) {
        SparseArray sparseArray = this.f2414a;
        s0 s0Var = (s0) sparseArray.get(i10);
        if (s0Var != null) {
            return s0Var;
        }
        s0 s0Var2 = new s0();
        sparseArray.put(i10, s0Var2);
        return s0Var2;
    }
}
