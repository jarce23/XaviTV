package o9;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p0 extends AbstractSequentialList implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final List f9655o;

    /* renamed from: p, reason: collision with root package name */
    public final n9.d f9656p;

    public p0(List list, n9.d dVar) {
        list.getClass();
        this.f9655o = list;
        this.f9656p = dVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f9655o.isEmpty();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i10) {
        return new n0(this, this.f9655o.listIterator(i10), 1);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        this.f9655o.subList(i10, i11).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9655o.size();
    }
}
