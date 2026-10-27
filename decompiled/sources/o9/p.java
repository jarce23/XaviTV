package o9;

import java.io.Serializable;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p extends v0 implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final n9.d f9653o;

    /* renamed from: p, reason: collision with root package name */
    public final v0 f9654p;

    public p(n9.d dVar, v0 v0Var) {
        this.f9653o = dVar;
        this.f9654p = v0Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        n9.d dVar = this.f9653o;
        return this.f9654p.compare(dVar.apply(obj), dVar.apply(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f9653o.equals(pVar.f9653o) && this.f9654p.equals(pVar.f9654p)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9653o, this.f9654p});
    }

    public final String toString() {
        return this.f9654p + ".onResultOf(" + this.f9653o + ")";
    }
}
