package na;

import com.google.android.gms.internal.cast.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends ma.e implements RandomAccess, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public Object[] f9275o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9276p;

    /* renamed from: q, reason: collision with root package name */
    public int f9277q;

    /* renamed from: r, reason: collision with root package name */
    public final b f9278r;

    /* renamed from: s, reason: collision with root package name */
    public final c f9279s;

    public b(Object[] objArr, int i10, int i11, b bVar, c cVar) {
        int i12;
        za.h.e("backing", objArr);
        za.h.e("root", cVar);
        this.f9275o = objArr;
        this.f9276p = i10;
        this.f9277q = i11;
        this.f9278r = bVar;
        this.f9279s = cVar;
        i12 = ((AbstractList) cVar).modCount;
        ((AbstractList) this).modCount = i12;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        l();
        k();
        j(this.f9276p + this.f9277q, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        za.h.e("elements", collection);
        l();
        k();
        int size = collection.size();
        i(this.f9276p + this.f9277q, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        l();
        k();
        n(this.f9276p, this.f9277q);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        k();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f9275o;
            int i10 = this.f9277q;
            if (i10 == list.size()) {
                for (int i11 = 0; i11 < i10; i11++) {
                    if (za.h.a(objArr[this.f9276p + i11], list.get(i11))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // ma.e
    public final int f() {
        k();
        return this.f9277q;
    }

    @Override // ma.e
    public final Object g(int i10) {
        l();
        k();
        int i11 = this.f9277q;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
        }
        return m(this.f9276p + i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        k();
        int i11 = this.f9277q;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
        }
        return this.f9275o[this.f9276p + i10];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        k();
        Object[] objArr = this.f9275o;
        int i10 = this.f9277q;
        int i11 = 1;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[this.f9276p + i12];
            i11 = (i11 * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return i11;
    }

    public final void i(int i10, Collection collection, int i11) {
        ((AbstractList) this).modCount++;
        c cVar = this.f9279s;
        b bVar = this.f9278r;
        if (bVar != null) {
            bVar.i(i10, collection, i11);
        } else {
            c cVar2 = c.f9280r;
            cVar.i(i10, collection, i11);
        }
        this.f9275o = cVar.f9281o;
        this.f9277q += i11;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        k();
        for (int i10 = 0; i10 < this.f9277q; i10++) {
            if (za.h.a(this.f9275o[this.f9276p + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        k();
        return this.f9277q == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i10, Object obj) {
        ((AbstractList) this).modCount++;
        c cVar = this.f9279s;
        b bVar = this.f9278r;
        if (bVar != null) {
            bVar.j(i10, obj);
        } else {
            c cVar2 = c.f9280r;
            cVar.j(i10, obj);
        }
        this.f9275o = cVar.f9281o;
        this.f9277q++;
    }

    public final void k() {
        int i10;
        i10 = ((AbstractList) this.f9279s).modCount;
        if (i10 != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void l() {
        if (this.f9279s.f9283q) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        k();
        for (int i10 = this.f9277q - 1; i10 >= 0; i10--) {
            if (za.h.a(this.f9275o[this.f9276p + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public final Object m(int i10) {
        Object m10;
        ((AbstractList) this).modCount++;
        b bVar = this.f9278r;
        if (bVar != null) {
            m10 = bVar.m(i10);
        } else {
            c cVar = c.f9280r;
            m10 = this.f9279s.m(i10);
        }
        this.f9277q--;
        return m10;
    }

    public final void n(int i10, int i11) {
        if (i11 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.f9278r;
        if (bVar != null) {
            bVar.n(i10, i11);
        } else {
            c cVar = c.f9280r;
            this.f9279s.n(i10, i11);
        }
        this.f9277q -= i11;
    }

    public final int o(int i10, int i11, Collection collection, boolean z10) {
        int o2;
        b bVar = this.f9278r;
        if (bVar != null) {
            o2 = bVar.o(i10, i11, collection, z10);
        } else {
            c cVar = c.f9280r;
            o2 = this.f9279s.o(i10, i11, collection, z10);
        }
        if (o2 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f9277q -= o2;
        return o2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        l();
        k();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            g(indexOf);
        }
        return indexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        za.h.e("elements", collection);
        l();
        k();
        return o(this.f9276p, this.f9277q, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        za.h.e("elements", collection);
        l();
        k();
        return o(this.f9276p, this.f9277q, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        l();
        k();
        int i11 = this.f9277q;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
        }
        Object[] objArr = this.f9275o;
        int i12 = this.f9276p;
        Object obj2 = objArr[i12 + i10];
        objArr[i12 + i10] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i10, int i11) {
        com.bumptech.glide.d.f(i10, i11, this.f9277q);
        return new b(this.f9275o, this.f9276p + i10, i11 - i10, this, this.f9279s);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        za.h.e("array", objArr);
        k();
        int length = objArr.length;
        int i10 = this.f9277q;
        int i11 = this.f9276p;
        if (length < i10) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f9275o, i11, i10 + i11, objArr.getClass());
            za.h.d("copyOfRange(...)", copyOfRange);
            return copyOfRange;
        }
        ma.i.E(0, i11, i10 + i11, this.f9275o, objArr);
        int i12 = this.f9277q;
        if (i12 < objArr.length) {
            objArr[i12] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        k();
        return n.a(this.f9275o, this.f9276p, this.f9277q, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i10) {
        k();
        int i11 = this.f9277q;
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
        }
        return new a(this, i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        l();
        k();
        int i11 = this.f9277q;
        if (i10 >= 0 && i10 <= i11) {
            j(this.f9276p + i10, obj);
            return;
        }
        throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection collection) {
        za.h.e("elements", collection);
        l();
        k();
        int i11 = this.f9277q;
        if (i10 >= 0 && i10 <= i11) {
            int size = collection.size();
            i(this.f9276p + i10, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        k();
        Object[] objArr = this.f9275o;
        int i10 = this.f9277q;
        int i11 = this.f9276p;
        return ma.i.H(objArr, i11, i10 + i11);
    }
}
