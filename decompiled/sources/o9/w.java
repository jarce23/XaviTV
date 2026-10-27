package o9;

import java.util.Comparator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w extends y {
    public static y f(int i10) {
        return i10 < 0 ? y.f9692b : i10 > 0 ? y.f9693c : y.f9691a;
    }

    @Override // o9.y
    public final y a(int i10, int i11) {
        return f(Integer.compare(i10, i11));
    }

    @Override // o9.y
    public final y b(Object obj, Object obj2, Comparator comparator) {
        return f(comparator.compare(obj, obj2));
    }

    @Override // o9.y
    public final y c(boolean z10, boolean z11) {
        return f(Boolean.compare(z10, z11));
    }

    @Override // o9.y
    public final y d(boolean z10, boolean z11) {
        return f(Boolean.compare(z11, z10));
    }

    @Override // o9.y
    public final int e() {
        return 0;
    }
}
