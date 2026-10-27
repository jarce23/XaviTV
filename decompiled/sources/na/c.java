package na;

import com.google.android.gms.internal.cast.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends ma.e implements RandomAccess, Serializable {

    /* renamed from: r, reason: collision with root package name */
    public static final c f9280r;

    /* renamed from: o, reason: collision with root package name */
    public Object[] f9281o;

    /* renamed from: p, reason: collision with root package name */
    public int f9282p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9283q;

    static {
        c cVar = new c(0);
        cVar.f9283q = true;
        f9280r = cVar;
    }

    public c(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.f9281o = new Object[i10];
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        k();
        int i10 = this.f9282p;
        ((AbstractList) this).modCount++;
        l(i10, 1);
        this.f9281o[i10] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        za.h.e("elements", collection);
        k();
        int size = collection.size();
        i(this.f9282p, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        k();
        n(0, this.f9282p);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f9281o;
            int i10 = this.f9282p;
            if (i10 == list.size()) {
                for (int i11 = 0; i11 < i10; i11++) {
                    if (za.h.a(objArr[i11], list.get(i11))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // ma.e
    public final int f() {
        return this.f9282p;
    }

    @Override // ma.e
    public final Object g(int i10) {
        k();
        int i11 = this.f9282p;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
        }
        return m(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        int i11 = this.f9282p;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
        }
        return this.f9281o[i10];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f9281o;
        int i10 = this.f9282p;
        int i11 = 1;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            i11 = (i11 * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return i11;
    }

    public final void i(int i10, Collection collection, int i11) {
        ((AbstractList) this).modCount++;
        l(i10, i11);
        Iterator it = collection.iterator();
        for (int i12 = 0; i12 < i11; i12++) {
            this.f9281o[i10 + i12] = it.next();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i10 = 0; i10 < this.f9282p; i10++) {
            if (za.h.a(this.f9281o[i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f9282p == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i10, Object obj) {
        ((AbstractList) this).modCount++;
        l(i10, 1);
        this.f9281o[i10] = obj;
    }

    public final void k() {
        if (this.f9283q) {
            throw new UnsupportedOperationException();
        }
    }

    public final void l(int i10, int i11) {
        int i12 = this.f9282p + i11;
        if (i12 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f9281o;
        if (i12 > objArr.length) {
            int length = objArr.length;
            int i13 = length + (length >> 1);
            if (i13 - i12 < 0) {
                i13 = i12;
            }
            if (i13 - 2147483639 > 0) {
                i13 = i12 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] copyOf = Arrays.copyOf(objArr, i13);
            za.h.d("copyOf(...)", copyOf);
            this.f9281o = copyOf;
        }
        Object[] objArr2 = this.f9281o;
        ma.i.E(i10 + i11, i10, this.f9282p, objArr2, objArr2);
        this.f9282p += i11;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i10 = this.f9282p - 1; i10 >= 0; i10--) {
            if (za.h.a(this.f9281o[i10], obj)) {
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
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f9281o;
        Object obj = objArr[i10];
        ma.i.E(i10, i10 + 1, this.f9282p, objArr, objArr);
        Object[] objArr2 = this.f9281o;
        int i11 = this.f9282p - 1;
        za.h.e("<this>", objArr2);
        objArr2[i11] = null;
        this.f9282p--;
        return obj;
    }

    public final void n(int i10, int i11) {
        if (i11 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f9281o;
        ma.i.E(i10, i10 + i11, this.f9282p, objArr, objArr);
        Object[] objArr2 = this.f9281o;
        int i12 = this.f9282p;
        n.r(objArr2, i12 - i11, i12);
        this.f9282p -= i11;
    }

    public final int o(int i10, int i11, Collection collection, boolean z10) {
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = i10 + i12;
            if (collection.contains(this.f9281o[i14]) == z10) {
                Object[] objArr = this.f9281o;
                i12++;
                objArr[i13 + i10] = objArr[i14];
                i13++;
            } else {
                i12++;
            }
        }
        int i15 = i11 - i13;
        Object[] objArr2 = this.f9281o;
        ma.i.E(i10 + i13, i11 + i10, this.f9282p, objArr2, objArr2);
        Object[] objArr3 = this.f9281o;
        int i16 = this.f9282p;
        n.r(objArr3, i16 - i15, i16);
        if (i15 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f9282p -= i15;
        return i15;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
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
        k();
        return o(0, this.f9282p, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        za.h.e("elements", collection);
        k();
        return o(0, this.f9282p, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        k();
        int i11 = this.f9282p;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
        }
        Object[] objArr = this.f9281o;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i10, int i11) {
        com.bumptech.glide.d.f(i10, i11, this.f9282p);
        return new b(this.f9281o, i10, i11 - i10, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        za.h.e("array", objArr);
        int length = objArr.length;
        int i10 = this.f9282p;
        if (length < i10) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f9281o, 0, i10, objArr.getClass());
            za.h.d("copyOfRange(...)", copyOfRange);
            return copyOfRange;
        }
        ma.i.E(0, 0, i10, this.f9281o, objArr);
        int i11 = this.f9282p;
        if (i11 < objArr.length) {
            objArr[i11] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return n.a(this.f9281o, 0, this.f9282p, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i10) {
        int i11 = this.f9282p;
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
        }
        return new a(this, i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection collection) {
        za.h.e("elements", collection);
        k();
        int i11 = this.f9282p;
        if (i10 >= 0 && i10 <= i11) {
            int size = collection.size();
            i(i10, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        k();
        int i11 = this.f9282p;
        if (i10 >= 0 && i10 <= i11) {
            ((AbstractList) this).modCount++;
            l(i10, 1);
            this.f9281o[i10] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return ma.i.H(this.f9281o, 0, this.f9282p);
    }
}
