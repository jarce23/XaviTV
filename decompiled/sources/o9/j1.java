package o9;

import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class j1 implements Iterator {

    /* renamed from: o, reason: collision with root package name */
    public final Iterator f9627o;

    public j1(Iterator it) {
        it.getClass();
        this.f9627o = it;
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9627o.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f9627o.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f9627o.remove();
    }
}
