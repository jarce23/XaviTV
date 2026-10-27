package n9;

import i2.q;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: r, reason: collision with root package name */
    public static final q f9266r = new q(1);

    /* renamed from: o, reason: collision with root package name */
    public final Object f9267o = new Object();

    /* renamed from: p, reason: collision with root package name */
    public volatile h f9268p;

    /* renamed from: q, reason: collision with root package name */
    public Object f9269q;

    public j(h hVar) {
        this.f9268p = hVar;
    }

    @Override // n9.h
    public final Object get() {
        h hVar = this.f9268p;
        q qVar = f9266r;
        if (hVar != qVar) {
            synchronized (this.f9267o) {
                try {
                    if (this.f9268p != qVar) {
                        Object obj = this.f9268p.get();
                        this.f9269q = obj;
                        this.f9268p = qVar;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f9269q;
    }

    public final String toString() {
        Object obj = this.f9268p;
        StringBuilder sb2 = new StringBuilder("Suppliers.memoize(");
        if (obj == f9266r) {
            obj = "<supplier that returned " + this.f9269q + ">";
        }
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }
}
