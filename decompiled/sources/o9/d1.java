package o9;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d1 extends v0 implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final v0 f9602o;

    public d1(v0 v0Var) {
        this.f9602o = v0Var;
    }

    @Override // o9.v0
    public final v0 a() {
        return this.f9602o;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f9602o.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d1) {
            return this.f9602o.equals(((d1) obj).f9602o);
        }
        return false;
    }

    public final int hashCode() {
        return -this.f9602o.hashCode();
    }

    public final String toString() {
        return this.f9602o + ".reverse()";
    }
}
