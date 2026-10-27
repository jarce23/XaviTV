package o9;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements Iterator {

    /* renamed from: o, reason: collision with root package name */
    public final Iterator f9565o;

    /* renamed from: p, reason: collision with root package name */
    public Object f9566p = null;

    /* renamed from: q, reason: collision with root package name */
    public Collection f9567q = null;

    /* renamed from: r, reason: collision with root package name */
    public Iterator f9568r = l0.f9640o;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ s0 f9569s;

    public a(s0 s0Var) {
        this.f9569s = s0Var;
        this.f9565o = s0Var.f9666r.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9565o.hasNext() || this.f9568r.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f9568r.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f9565o.next();
            this.f9566p = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.f9567q = collection;
            this.f9568r = collection.iterator();
        }
        return this.f9568r.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f9568r.remove();
        Collection collection = this.f9567q;
        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            this.f9565o.remove();
        }
        s0 s0Var = this.f9569s;
        s0Var.f9667s--;
    }
}
