package o9;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g1 extends f1 implements SortedSet {
    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return ((SortedSet) this.f9614o).comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        Iterator it = this.f9614o.iterator();
        it.getClass();
        n9.e eVar = this.f9615p;
        eVar.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (eVar.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        return new g1(((SortedSet) this.f9614o).headSet(obj), this.f9615p);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        SortedSet sortedSet = (SortedSet) this.f9614o;
        while (true) {
            Object last = sortedSet.last();
            if (this.f9615p.apply(last)) {
                return last;
            }
            sortedSet = sortedSet.headSet(last);
        }
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return new g1(((SortedSet) this.f9614o).subSet(obj, obj2), this.f9615p);
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        return new g1(((SortedSet) this.f9614o).tailSet(obj), this.f9615p);
    }
}
