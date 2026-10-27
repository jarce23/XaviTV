package la;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements c, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public ya.a f8331o;

    /* renamed from: p, reason: collision with root package name */
    public volatile Object f8332p = h.f8334a;

    /* renamed from: q, reason: collision with root package name */
    public final Object f8333q = this;

    public g(ya.a aVar) {
        this.f8331o = aVar;
    }

    public final Object a() {
        Object obj;
        Object obj2 = this.f8332p;
        h hVar = h.f8334a;
        if (obj2 != hVar) {
            return obj2;
        }
        synchronized (this.f8333q) {
            obj = this.f8332p;
            if (obj == hVar) {
                ya.a aVar = this.f8331o;
                za.h.b(aVar);
                obj = aVar.invoke();
                this.f8332p = obj;
                this.f8331o = null;
            }
        }
        return obj;
    }

    public final String toString() {
        return this.f8332p != h.f8334a ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
