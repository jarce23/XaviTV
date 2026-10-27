package la;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final Object f8328o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f8329p;

    public d(Object obj, Object obj2) {
        this.f8328o = obj;
        this.f8329p = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return za.h.a(this.f8328o, dVar.f8328o) && za.h.a(this.f8329p, dVar.f8329p);
    }

    public final int hashCode() {
        Object obj = this.f8328o;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f8329p;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f8328o + ", " + this.f8329p + ')';
    }
}
