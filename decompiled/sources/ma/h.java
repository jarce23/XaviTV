package ma;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends e {

    /* renamed from: r, reason: collision with root package name */
    public static final Object[] f9046r = new Object[0];

    /* renamed from: o, reason: collision with root package name */
    public int f9047o;

    /* renamed from: p, reason: collision with root package name */
    public Object[] f9048p = f9046r;

    /* renamed from: q, reason: collision with root package name */
    public int f9049q;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int i11;
        int i12 = this.f9049q;
        if (i10 < 0 || i10 > i12) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i12));
        }
        if (i10 == i12) {
            addLast(obj);
            return;
        }
        if (i10 == 0) {
            addFirst(obj);
            return;
        }
        n();
        i(this.f9049q + 1);
        int m10 = m(this.f9047o + i10);
        int i13 = this.f9049q;
        if (i10 < ((i13 + 1) >> 1)) {
            if (m10 == 0) {
                Object[] objArr = this.f9048p;
                za.h.e("<this>", objArr);
                m10 = objArr.length;
            }
            int i14 = m10 - 1;
            int i15 = this.f9047o;
            if (i15 == 0) {
                Object[] objArr2 = this.f9048p;
                za.h.e("<this>", objArr2);
                i11 = objArr2.length - 1;
            } else {
                i11 = i15 - 1;
            }
            int i16 = this.f9047o;
            if (i14 >= i16) {
                Object[] objArr3 = this.f9048p;
                objArr3[i11] = objArr3[i16];
                i.E(i16, i16 + 1, i14 + 1, objArr3, objArr3);
            } else {
                Object[] objArr4 = this.f9048p;
                i.E(i16 - 1, i16, objArr4.length, objArr4, objArr4);
                Object[] objArr5 = this.f9048p;
                objArr5[objArr5.length - 1] = objArr5[0];
                i.E(0, 1, i14 + 1, objArr5, objArr5);
            }
            this.f9048p[i14] = obj;
            this.f9047o = i11;
        } else {
            int m11 = m(i13 + this.f9047o);
            if (m10 < m11) {
                Object[] objArr6 = this.f9048p;
                i.E(m10 + 1, m10, m11, objArr6, objArr6);
            } else {
                Object[] objArr7 = this.f9048p;
                i.E(1, 0, m11, objArr7, objArr7);
                Object[] objArr8 = this.f9048p;
                objArr8[0] = objArr8[objArr8.length - 1];
                i.E(m10 + 1, m10, objArr8.length - 1, objArr8, objArr8);
            }
            this.f9048p[m10] = obj;
        }
        this.f9049q++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection collection) {
        za.h.e("elements", collection);
        int i11 = this.f9049q;
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i10 == this.f9049q) {
            return addAll(collection);
        }
        n();
        i(collection.size() + this.f9049q);
        int m10 = m(this.f9049q + this.f9047o);
        int m11 = m(this.f9047o + i10);
        int size = collection.size();
        if (i10 >= ((this.f9049q + 1) >> 1)) {
            int i12 = m11 + size;
            if (m11 < m10) {
                int i13 = size + m10;
                Object[] objArr = this.f9048p;
                if (i13 <= objArr.length) {
                    i.E(i12, m11, m10, objArr, objArr);
                } else if (i12 >= objArr.length) {
                    i.E(i12 - objArr.length, m11, m10, objArr, objArr);
                } else {
                    int length = m10 - (i13 - objArr.length);
                    i.E(0, length, m10, objArr, objArr);
                    Object[] objArr2 = this.f9048p;
                    i.E(i12, m11, length, objArr2, objArr2);
                }
            } else {
                Object[] objArr3 = this.f9048p;
                i.E(size, 0, m10, objArr3, objArr3);
                Object[] objArr4 = this.f9048p;
                if (i12 >= objArr4.length) {
                    i.E(i12 - objArr4.length, m11, objArr4.length, objArr4, objArr4);
                } else {
                    i.E(0, objArr4.length - size, objArr4.length, objArr4, objArr4);
                    Object[] objArr5 = this.f9048p;
                    i.E(i12, m11, objArr5.length - size, objArr5, objArr5);
                }
            }
            h(m11, collection);
            return true;
        }
        int i14 = this.f9047o;
        int i15 = i14 - size;
        if (m11 < i14) {
            Object[] objArr6 = this.f9048p;
            i.E(i15, i14, objArr6.length, objArr6, objArr6);
            if (size >= m11) {
                Object[] objArr7 = this.f9048p;
                i.E(objArr7.length - size, 0, m11, objArr7, objArr7);
            } else {
                Object[] objArr8 = this.f9048p;
                i.E(objArr8.length - size, 0, size, objArr8, objArr8);
                Object[] objArr9 = this.f9048p;
                i.E(0, size, m11, objArr9, objArr9);
            }
        } else if (i15 >= 0) {
            Object[] objArr10 = this.f9048p;
            i.E(i15, i14, m11, objArr10, objArr10);
        } else {
            Object[] objArr11 = this.f9048p;
            i15 += objArr11.length;
            int i16 = m11 - i14;
            int length2 = objArr11.length - i15;
            if (length2 >= i16) {
                i.E(i15, i14, m11, objArr11, objArr11);
            } else {
                i.E(i15, i14, i14 + length2, objArr11, objArr11);
                Object[] objArr12 = this.f9048p;
                i.E(0, this.f9047o + length2, m11, objArr12, objArr12);
            }
        }
        this.f9047o = i15;
        h(k(m11 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        n();
        i(this.f9049q + 1);
        int i10 = this.f9047o;
        if (i10 == 0) {
            Object[] objArr = this.f9048p;
            za.h.e("<this>", objArr);
            i10 = objArr.length;
        }
        int i11 = i10 - 1;
        this.f9047o = i11;
        this.f9048p[i11] = obj;
        this.f9049q++;
    }

    public final void addLast(Object obj) {
        n();
        i(f() + 1);
        this.f9048p[m(f() + this.f9047o)] = obj;
        this.f9049q = f() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            n();
            l(this.f9047o, m(f() + this.f9047o));
        }
        this.f9047o = 0;
        this.f9049q = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // ma.e
    public final int f() {
        return this.f9049q;
    }

    @Override // ma.e
    public final Object g(int i10) {
        int i11 = this.f9049q;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, i11));
        }
        if (i10 == k.w(this)) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        n();
        int m10 = m(this.f9047o + i10);
        Object[] objArr = this.f9048p;
        Object obj = objArr[m10];
        if (i10 < (this.f9049q >> 1)) {
            int i12 = this.f9047o;
            if (m10 >= i12) {
                i.E(i12 + 1, i12, m10, objArr, objArr);
            } else {
                i.E(1, 0, m10, objArr, objArr);
                Object[] objArr2 = this.f9048p;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i13 = this.f9047o;
                i.E(i13 + 1, i13, objArr2.length - 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.f9048p;
            int i14 = this.f9047o;
            objArr3[i14] = null;
            this.f9047o = j(i14);
        } else {
            int m11 = m(k.w(this) + this.f9047o);
            if (m10 <= m11) {
                Object[] objArr4 = this.f9048p;
                i.E(m10, m10 + 1, m11 + 1, objArr4, objArr4);
            } else {
                Object[] objArr5 = this.f9048p;
                i.E(m10, m10 + 1, objArr5.length, objArr5, objArr5);
                Object[] objArr6 = this.f9048p;
                objArr6[objArr6.length - 1] = objArr6[0];
                i.E(0, 1, m11 + 1, objArr6, objArr6);
            }
            this.f9048p[m11] = null;
        }
        this.f9049q--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        int f10 = f();
        if (i10 < 0 || i10 >= f10) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, f10));
        }
        return this.f9048p[m(this.f9047o + i10)];
    }

    public final void h(int i10, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f9048p.length;
        while (i10 < length && it.hasNext()) {
            this.f9048p[i10] = it.next();
            i10++;
        }
        int i11 = this.f9047o;
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            this.f9048p[i12] = it.next();
        }
        this.f9049q = collection.size() + this.f9049q;
    }

    public final void i(int i10) {
        if (i10 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f9048p;
        if (i10 <= objArr.length) {
            return;
        }
        if (objArr == f9046r) {
            if (i10 < 10) {
                i10 = 10;
            }
            this.f9048p = new Object[i10];
            return;
        }
        int length = objArr.length;
        int i11 = length + (length >> 1);
        if (i11 - i10 < 0) {
            i11 = i10;
        }
        if (i11 - 2147483639 > 0) {
            i11 = i10 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i11];
        i.E(0, this.f9047o, objArr.length, objArr, objArr2);
        Object[] objArr3 = this.f9048p;
        int length2 = objArr3.length;
        int i12 = this.f9047o;
        i.E(length2 - i12, 0, i12, objArr3, objArr2);
        this.f9047o = 0;
        this.f9048p = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i10;
        int m10 = m(f() + this.f9047o);
        int i11 = this.f9047o;
        if (i11 < m10) {
            while (i11 < m10) {
                if (za.h.a(obj, this.f9048p[i11])) {
                    i10 = this.f9047o;
                } else {
                    i11++;
                }
            }
            return -1;
        }
        if (i11 < m10) {
            return -1;
        }
        int length = this.f9048p.length;
        while (true) {
            if (i11 >= length) {
                for (int i12 = 0; i12 < m10; i12++) {
                    if (za.h.a(obj, this.f9048p[i12])) {
                        i11 = i12 + this.f9048p.length;
                        i10 = this.f9047o;
                    }
                }
                return -1;
            }
            if (za.h.a(obj, this.f9048p[i11])) {
                i10 = this.f9047o;
                break;
            }
            i11++;
        }
        return i11 - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return f() == 0;
    }

    public final int j(int i10) {
        za.h.e("<this>", this.f9048p);
        if (i10 == r0.length - 1) {
            return 0;
        }
        return i10 + 1;
    }

    public final int k(int i10) {
        return i10 < 0 ? i10 + this.f9048p.length : i10;
    }

    public final void l(int i10, int i11) {
        if (i10 < i11) {
            i.I(this.f9048p, null, i10, i11);
            return;
        }
        Object[] objArr = this.f9048p;
        i.I(objArr, null, i10, objArr.length);
        i.I(this.f9048p, null, 0, i11);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i10;
        int m10 = m(this.f9049q + this.f9047o);
        int i11 = this.f9047o;
        if (i11 < m10) {
            length = m10 - 1;
            if (i11 <= length) {
                while (!za.h.a(obj, this.f9048p[length])) {
                    if (length != i11) {
                        length--;
                    }
                }
                i10 = this.f9047o;
                return length - i10;
            }
            return -1;
        }
        if (i11 > m10) {
            int i12 = m10 - 1;
            while (true) {
                if (-1 >= i12) {
                    Object[] objArr = this.f9048p;
                    za.h.e("<this>", objArr);
                    length = objArr.length - 1;
                    int i13 = this.f9047o;
                    if (i13 <= length) {
                        while (!za.h.a(obj, this.f9048p[length])) {
                            if (length != i13) {
                                length--;
                            }
                        }
                        i10 = this.f9047o;
                    }
                } else {
                    if (za.h.a(obj, this.f9048p[i12])) {
                        length = i12 + this.f9048p.length;
                        i10 = this.f9047o;
                        break;
                    }
                    i12--;
                }
            }
        }
        return -1;
    }

    public final int m(int i10) {
        Object[] objArr = this.f9048p;
        return i10 >= objArr.length ? i10 - objArr.length : i10;
    }

    public final void n() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        g(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int m10;
        za.h.e("elements", collection);
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f9048p.length != 0) {
            int m11 = m(f() + this.f9047o);
            int i10 = this.f9047o;
            if (i10 < m11) {
                m10 = i10;
                while (i10 < m11) {
                    Object obj = this.f9048p[i10];
                    if (collection.contains(obj)) {
                        z10 = true;
                    } else {
                        this.f9048p[m10] = obj;
                        m10++;
                    }
                    i10++;
                }
                i.I(this.f9048p, null, m10, m11);
            } else {
                int length = this.f9048p.length;
                boolean z11 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr = this.f9048p;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (collection.contains(obj2)) {
                        z11 = true;
                    } else {
                        this.f9048p[i11] = obj2;
                        i11++;
                    }
                    i10++;
                }
                m10 = m(i11);
                for (int i12 = 0; i12 < m11; i12++) {
                    Object[] objArr2 = this.f9048p;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (collection.contains(obj3)) {
                        z11 = true;
                    } else {
                        this.f9048p[m10] = obj3;
                        m10 = j(m10);
                    }
                }
                z10 = z11;
            }
            if (z10) {
                n();
                this.f9049q = k(m10 - this.f9047o);
            }
        }
        return z10;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        Object[] objArr = this.f9048p;
        int i10 = this.f9047o;
        Object obj = objArr[i10];
        objArr[i10] = null;
        this.f9047o = j(i10);
        this.f9049q = f() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        int m10 = m(k.w(this) + this.f9047o);
        Object[] objArr = this.f9048p;
        Object obj = objArr[m10];
        objArr[m10] = null;
        this.f9049q = f() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        com.bumptech.glide.d.f(i10, i11, this.f9049q);
        int i12 = i11 - i10;
        if (i12 == 0) {
            return;
        }
        if (i12 == this.f9049q) {
            clear();
            return;
        }
        if (i12 == 1) {
            g(i10);
            return;
        }
        n();
        if (i10 < this.f9049q - i11) {
            int m10 = m(this.f9047o + (i10 - 1));
            int m11 = m(this.f9047o + (i11 - 1));
            while (i10 > 0) {
                int i13 = m10 + 1;
                int min = Math.min(i10, Math.min(i13, m11 + 1));
                Object[] objArr = this.f9048p;
                int i14 = m11 - min;
                int i15 = m10 - min;
                i.E(i14 + 1, i15 + 1, i13, objArr, objArr);
                m10 = k(i15);
                m11 = k(i14);
                i10 -= min;
            }
            int m12 = m(this.f9047o + i12);
            l(this.f9047o, m12);
            this.f9047o = m12;
        } else {
            int m13 = m(this.f9047o + i11);
            int m14 = m(this.f9047o + i10);
            int i16 = this.f9049q;
            while (true) {
                i16 -= i11;
                if (i16 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f9048p;
                i11 = Math.min(i16, Math.min(objArr2.length - m13, objArr2.length - m14));
                Object[] objArr3 = this.f9048p;
                int i17 = m13 + i11;
                i.E(m14, m13, i17, objArr3, objArr3);
                m13 = m(i17);
                m14 = m(m14 + i11);
            }
            int m15 = m(this.f9049q + this.f9047o);
            l(k(m15 - i12), m15);
        }
        this.f9049q -= i12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int m10;
        za.h.e("elements", collection);
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f9048p.length != 0) {
            int m11 = m(f() + this.f9047o);
            int i10 = this.f9047o;
            if (i10 < m11) {
                m10 = i10;
                while (i10 < m11) {
                    Object obj = this.f9048p[i10];
                    if (collection.contains(obj)) {
                        this.f9048p[m10] = obj;
                        m10++;
                    } else {
                        z10 = true;
                    }
                    i10++;
                }
                i.I(this.f9048p, null, m10, m11);
            } else {
                int length = this.f9048p.length;
                boolean z11 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr = this.f9048p;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (collection.contains(obj2)) {
                        this.f9048p[i11] = obj2;
                        i11++;
                    } else {
                        z11 = true;
                    }
                    i10++;
                }
                m10 = m(i11);
                for (int i12 = 0; i12 < m11; i12++) {
                    Object[] objArr2 = this.f9048p;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (collection.contains(obj3)) {
                        this.f9048p[m10] = obj3;
                        m10 = j(m10);
                    } else {
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            if (z10) {
                n();
                this.f9049q = k(m10 - this.f9047o);
            }
        }
        return z10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        int f10 = f();
        if (i10 < 0 || i10 >= f10) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("index: ", ", size: ", i10, f10));
        }
        int m10 = m(this.f9047o + i10);
        Object[] objArr = this.f9048p;
        Object obj2 = objArr[m10];
        objArr[m10] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[f()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        za.h.e("array", objArr);
        int length = objArr.length;
        int i10 = this.f9049q;
        if (length < i10) {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i10);
            za.h.c("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>", newInstance);
            objArr = (Object[]) newInstance;
        }
        int m10 = m(this.f9049q + this.f9047o);
        int i11 = this.f9047o;
        if (i11 < m10) {
            i.F(i11, m10, 2, this.f9048p, objArr);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f9048p;
            i.E(0, this.f9047o, objArr2.length, objArr2, objArr);
            Object[] objArr3 = this.f9048p;
            i.E(objArr3.length - this.f9047o, 0, m10, objArr3, objArr);
        }
        int i12 = this.f9049q;
        if (i12 < objArr.length) {
            objArr[i12] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        za.h.e("elements", collection);
        if (collection.isEmpty()) {
            return false;
        }
        n();
        i(collection.size() + f());
        h(m(f() + this.f9047o), collection);
        return true;
    }
}
