package i1;

import android.util.SparseBooleanArray;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final n f5914a;

    static {
        new SparseBooleanArray();
        l1.d.g(!false);
        l1.a0.J(0);
    }

    public k0(n nVar) {
        this.f5914a = nVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k0) {
            return this.f5914a.equals(((k0) obj).f5914a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5914a.hashCode();
    }
}
