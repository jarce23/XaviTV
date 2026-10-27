package o;

import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Map.Entry {

    /* renamed from: o, reason: collision with root package name */
    public final Object f9358o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f9359p;

    /* renamed from: q, reason: collision with root package name */
    public c f9360q;

    /* renamed from: r, reason: collision with root package name */
    public c f9361r;

    public c(Object obj, Object obj2) {
        this.f9358o = obj;
        this.f9359p = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f9358o.equals(cVar.f9358o) && this.f9359p.equals(cVar.f9359p);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9358o;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f9359p;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f9358o.hashCode() ^ this.f9359p.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f9358o + "=" + this.f9359p;
    }
}
