package o9;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class l extends AbstractCollection implements List {

    /* renamed from: o, reason: collision with root package name */
    public final Object f9634o;

    /* renamed from: p, reason: collision with root package name */
    public Collection f9635p;

    /* renamed from: q, reason: collision with root package name */
    public final l f9636q;

    /* renamed from: r, reason: collision with root package name */
    public final Collection f9637r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ s0 f9638s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ s0 f9639t;

    public l(s0 s0Var, Object obj, List list, l lVar) {
        this.f9639t = s0Var;
        this.f9638s = s0Var;
        this.f9634o = obj;
        this.f9635p = list;
        this.f9636q = lVar;
        this.f9637r = lVar == null ? null : lVar.f9635p;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g();
        boolean isEmpty = this.f9635p.isEmpty();
        boolean add = this.f9635p.add(obj);
        if (add) {
            this.f9638s.f9667s++;
            if (isEmpty) {
                f();
            }
        }
        return add;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.f9635p.addAll(collection);
        if (addAll) {
            this.f9638s.f9667s += this.f9635p.size() - size;
            if (size == 0) {
                f();
            }
        }
        return addAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f9635p.clear();
        this.f9638s.f9667s -= size;
        h();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        g();
        return this.f9635p.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean containsAll(Collection collection) {
        g();
        return this.f9635p.containsAll(collection);
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        g();
        return this.f9635p.equals(obj);
    }

    public final void f() {
        l lVar = this.f9636q;
        if (lVar != null) {
            lVar.f();
        } else {
            this.f9638s.f9666r.put(this.f9634o, this.f9635p);
        }
    }

    public final void g() {
        Collection collection;
        l lVar = this.f9636q;
        if (lVar != null) {
            lVar.g();
            if (lVar.f9635p != this.f9637r) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.f9635p.isEmpty() || (collection = (Collection) this.f9638s.f9666r.get(this.f9634o)) == null) {
                return;
            }
            this.f9635p = collection;
        }
    }

    @Override // java.util.List
    public final Object get(int i10) {
        g();
        return ((List) this.f9635p).get(i10);
    }

    public final void h() {
        l lVar = this.f9636q;
        if (lVar != null) {
            lVar.h();
        } else if (this.f9635p.isEmpty()) {
            this.f9638s.f9666r.remove(this.f9634o);
        }
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        g();
        return this.f9635p.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        g();
        return ((List) this.f9635p).indexOf(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        g();
        return new c(this);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        g();
        return ((List) this.f9635p).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        g();
        return new k(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
        boolean remove = this.f9635p.remove(obj);
        if (remove) {
            s0 s0Var = this.f9638s;
            s0Var.f9667s--;
            h();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.f9635p.removeAll(collection);
        if (removeAll) {
            this.f9638s.f9667s += this.f9635p.size() - size;
            h();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean retainAll = this.f9635p.retainAll(collection);
        if (retainAll) {
            this.f9638s.f9667s += this.f9635p.size() - size;
            h();
        }
        return retainAll;
    }

    @Override // java.util.List
    public final Object set(int i10, Object obj) {
        g();
        return ((List) this.f9635p).set(i10, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        g();
        return this.f9635p.size();
    }

    @Override // java.util.List
    public final List subList(int i10, int i11) {
        g();
        List subList = ((List) this.f9635p).subList(i10, i11);
        l lVar = this.f9636q;
        if (lVar == null) {
            lVar = this;
        }
        boolean z10 = subList instanceof RandomAccess;
        s0 s0Var = this.f9639t;
        Object obj = this.f9634o;
        return z10 ? new h(s0Var, obj, subList, lVar) : new l(s0Var, obj, subList, lVar);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        g();
        return this.f9635p.toString();
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i10) {
        g();
        return new k(this, i10);
    }

    @Override // java.util.List
    public final Object remove(int i10) {
        g();
        Object remove = ((List) this.f9635p).remove(i10);
        s0 s0Var = this.f9639t;
        s0Var.f9667s--;
        h();
        return remove;
    }

    @Override // java.util.List
    public final void add(int i10, Object obj) {
        g();
        boolean isEmpty = this.f9635p.isEmpty();
        ((List) this.f9635p).add(i10, obj);
        this.f9639t.f9667s++;
        if (isEmpty) {
            f();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i10, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.f9635p).addAll(i10, collection);
        if (addAll) {
            this.f9639t.f9667s += this.f9635p.size() - size;
            if (size == 0) {
                f();
            }
        }
        return addAll;
    }
}
