package o9;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v extends v0 implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final f2.c f9685o;

    public v(f2.c cVar) {
        this.f9685o = cVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f9685o.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            return this.f9685o.equals(((v) obj).f9685o);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9685o.hashCode();
    }

    public final String toString() {
        return this.f9685o.toString();
    }
}
