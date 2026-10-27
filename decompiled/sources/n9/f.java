package n9;

import java.io.Serializable;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements e, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final List f9254o;

    public f(List list) {
        this.f9254o = list;
    }

    @Override // n9.e
    public final boolean apply(Object obj) {
        int i10 = 0;
        while (true) {
            List list = this.f9254o;
            if (i10 >= list.size()) {
                return true;
            }
            if (!((e) list.get(i10)).apply(obj)) {
                return false;
            }
            i10++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f9254o.equals(((f) obj).f9254o);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9254o.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Predicates.and(");
        boolean z10 = true;
        for (Object obj : this.f9254o) {
            if (!z10) {
                sb2.append(',');
            }
            sb2.append(obj);
            z10 = false;
        }
        sb2.append(')');
        return sb2.toString();
    }
}
