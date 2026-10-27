package n9;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements h, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final transient Object f9262o = new Object();

    /* renamed from: p, reason: collision with root package name */
    public final h f9263p;

    /* renamed from: q, reason: collision with root package name */
    public volatile transient boolean f9264q;

    /* renamed from: r, reason: collision with root package name */
    public transient Object f9265r;

    public i(h hVar) {
        this.f9263p = hVar;
    }

    @Override // n9.h
    public final Object get() {
        if (!this.f9264q) {
            synchronized (this.f9262o) {
                try {
                    if (!this.f9264q) {
                        Object obj = this.f9263p.get();
                        this.f9265r = obj;
                        this.f9264q = true;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f9265r;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder("Suppliers.memoize(");
        if (this.f9264q) {
            obj = "<supplier that returned " + this.f9265r + ">";
        } else {
            obj = this.f9263p;
        }
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }
}
