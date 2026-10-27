package o9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g0 extends b0 implements List, RandomAccess {

    /* renamed from: p, reason: collision with root package name */
    public static final e0 f9617p = new e0(w0.f9686s, 0);

    public static w0 l(int i10, Object[] objArr) {
        return i10 == 0 ? w0.f9686s : new w0(i10, objArr);
    }

    public static d0 m() {
        return new d0(4);
    }

    public static g0 n(Collection collection) {
        if (!(collection instanceof b0)) {
            Object[] array = collection.toArray();
            q.a(array.length, array);
            return l(array.length, array);
        }
        g0 f10 = ((b0) collection).f();
        if (!f10.k()) {
            return f10;
        }
        Object[] array2 = f10.toArray(b0.f9577o);
        return l(array2.length, array2);
    }

    public static w0 o(Object[] objArr) {
        if (objArr.length == 0) {
            return w0.f9686s;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        q.a(objArr2.length, objArr2);
        return l(objArr2.length, objArr2);
    }

    public static w0 q(Long l10, Long l11, Long l12, Long l13, Long l14) {
        Object[] objArr = {l10, l11, l12, l13, l14};
        q.a(5, objArr);
        return l(5, objArr);
    }

    public static w0 r(Object obj) {
        Object[] objArr = {obj};
        q.a(1, objArr);
        return l(1, objArr);
    }

    public static w0 s(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        q.a(2, objArr);
        return l(2, objArr);
    }

    public static w0 t(Comparator comparator, List list) {
        comparator.getClass();
        if (!r.a.k(list)) {
            Iterator it = list.iterator();
            ArrayList arrayList = new ArrayList();
            it.getClass();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            list = arrayList;
        }
        Object[] array = list.toArray();
        q.a(array.length, array);
        Arrays.sort(array, comparator);
        return l(array.length, array);
    }

    @Override // java.util.List
    public final void add(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // o9.b0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = size();
                if (size == list.size()) {
                    if (!(list instanceof RandomAccess)) {
                        Iterator it = iterator();
                        Iterator it2 = list.iterator();
                        while (it.hasNext()) {
                            if (it2.hasNext() && com.bumptech.glide.d.k(it.next(), it2.next())) {
                            }
                        }
                        return !it2.hasNext();
                    }
                    for (int i10 = 0; i10 < size; i10++) {
                        if (com.bumptech.glide.d.k(get(i10), list.get(i10))) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // o9.b0
    public int g(int i10, Object[] objArr) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i10 + i11] = get(i11);
        }
        return i10 + size;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~(get(i11).hashCode() + (i10 * 31)));
        }
        return i10;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (obj.equals(get(i10))) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final e0 listIterator(int i10) {
        com.bumptech.glide.e.h(i10, size());
        return isEmpty() ? f9617p : new e0(this, i10);
    }

    @Override // java.util.List
    public final Object remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public g0 subList(int i10, int i11) {
        com.bumptech.glide.e.i(i10, i11, size());
        int i12 = i11 - i10;
        return i12 == size() ? this : i12 == 0 ? w0.f9686s : new f0(this, i10, i12);
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // o9.b0
    public final g0 f() {
        return this;
    }
}
