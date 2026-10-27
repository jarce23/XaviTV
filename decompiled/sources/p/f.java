package p;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ma.k;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements Collection, Set, ab.a {

    /* renamed from: o, reason: collision with root package name */
    public int[] f9770o = q.a.f10216a;

    /* renamed from: p, reason: collision with root package name */
    public Object[] f9771p = q.a.f10217b;

    /* renamed from: q, reason: collision with root package name */
    public int f9772q;

    public f(int i10) {
        if (i10 > 0) {
            h.a(this, i10);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i10;
        int b2;
        int i11 = this.f9772q;
        if (obj == null) {
            b2 = h.b(this, null, 0);
            i10 = 0;
        } else {
            int hashCode = obj.hashCode();
            i10 = hashCode;
            b2 = h.b(this, obj, hashCode);
        }
        if (b2 >= 0) {
            return false;
        }
        int i12 = ~b2;
        int[] iArr = this.f9770o;
        if (i11 >= iArr.length) {
            int i13 = 8;
            if (i11 >= 8) {
                i13 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i13 = 4;
            }
            Object[] objArr = this.f9771p;
            int[] iArr2 = new int[i13];
            this.f9770o = iArr2;
            this.f9771p = new Object[i13];
            if (i11 != this.f9772q) {
                throw new ConcurrentModificationException();
            }
            if (iArr2.length != 0) {
                ma.i.D(0, 0, iArr.length, iArr, iArr2);
                ma.i.F(0, objArr.length, 6, objArr, this.f9771p);
            }
        }
        if (i12 < i11) {
            int[] iArr3 = this.f9770o;
            int i14 = i12 + 1;
            ma.i.D(i14, i12, i11, iArr3, iArr3);
            Object[] objArr2 = this.f9771p;
            ma.i.E(i14, i12, i11, objArr2, objArr2);
        }
        int i15 = this.f9772q;
        if (i11 == i15) {
            int[] iArr4 = this.f9770o;
            if (i12 < iArr4.length) {
                iArr4[i12] = i10;
                this.f9771p[i12] = obj;
                this.f9772q = i15 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        za.h.e("elements", collection);
        int size = collection.size() + this.f9772q;
        int i10 = this.f9772q;
        int[] iArr = this.f9770o;
        boolean z10 = false;
        if (iArr.length < size) {
            Object[] objArr = this.f9771p;
            int[] iArr2 = new int[size];
            this.f9770o = iArr2;
            this.f9771p = new Object[size];
            if (i10 > 0) {
                ma.i.D(0, 0, i10, iArr, iArr2);
                ma.i.F(0, this.f9772q, 6, objArr, this.f9771p);
            }
        }
        if (this.f9772q != i10) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            z10 |= add(it.next());
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f9772q != 0) {
            this.f9770o = q.a.f10216a;
            this.f9771p = q.a.f10217b;
            this.f9772q = 0;
        }
        if (this.f9772q != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? h.b(this, null, 0) : h.b(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        za.h.e("elements", collection);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this.f9772q != ((Set) obj).size()) {
            return false;
        }
        try {
            int i10 = this.f9772q;
            for (int i11 = 0; i11 < i10; i11++) {
                if (!((Set) obj).contains(this.f9771p[i11])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final Object f(int i10) {
        int i11 = this.f9772q;
        Object[] objArr = this.f9771p;
        Object obj = objArr[i10];
        if (i11 <= 1) {
            clear();
            return obj;
        }
        int i12 = i11 - 1;
        int[] iArr = this.f9770o;
        if (iArr.length <= 8 || i11 >= iArr.length / 3) {
            if (i10 < i12) {
                int i13 = i10 + 1;
                ma.i.D(i10, i13, i11, iArr, iArr);
                Object[] objArr2 = this.f9771p;
                ma.i.E(i10, i13, i11, objArr2, objArr2);
            }
            this.f9771p[i12] = null;
        } else {
            int i14 = i11 > 8 ? i11 + (i11 >> 1) : 8;
            int[] iArr2 = new int[i14];
            this.f9770o = iArr2;
            this.f9771p = new Object[i14];
            if (i10 > 0) {
                ma.i.D(0, 0, i10, iArr, iArr2);
                ma.i.F(0, i10, 6, objArr, this.f9771p);
            }
            if (i10 < i12) {
                int i15 = i10 + 1;
                ma.i.D(i10, i15, i11, iArr, this.f9770o);
                ma.i.E(i10, i15, i11, objArr, this.f9771p);
            }
        }
        if (i11 != this.f9772q) {
            throw new ConcurrentModificationException();
        }
        this.f9772q = i12;
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f9770o;
        int i10 = this.f9772q;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f9772q <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new a(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int b2 = obj == null ? h.b(this, null, 0) : h.b(this, obj, obj.hashCode());
        if (b2 < 0) {
            return false;
        }
        f(b2);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        za.h.e("elements", collection);
        Iterator it = collection.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= remove(it.next());
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean z10;
        za.h.e("elements", collection);
        int i10 = this.f9772q - 1;
        boolean z11 = false;
        while (true) {
            int i11 = -1;
            if (-1 >= i10) {
                return z11;
            }
            Object obj = this.f9771p[i10];
            Collection collection2 = collection;
            if (collection2 instanceof Collection) {
                z10 = collection2.contains(obj);
            } else {
                if (!(collection2 instanceof List)) {
                    Iterator it = collection2.iterator();
                    int i12 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (i12 < 0) {
                            k.y();
                            throw null;
                        }
                        if (za.h.a(obj, next)) {
                            i11 = i12;
                            break;
                        }
                        i12++;
                    }
                } else {
                    i11 = ((List) collection2).indexOf(obj);
                }
                z10 = i11 >= 0;
            }
            if (!z10) {
                f(i10);
                z11 = true;
            }
            i10--;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f9772q;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return ma.i.H(this.f9771p, 0, this.f9772q);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f9772q * 14);
        sb2.append('{');
        int i10 = this.f9772q;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            Object obj = this.f9771p[i11];
            if (obj != this) {
                sb2.append(obj);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        za.h.d("StringBuilder(capacity).…builderAction).toString()", sb3);
        return sb3;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        za.h.e("array", objArr);
        int i10 = this.f9772q;
        if (objArr.length < i10) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i10);
        } else if (objArr.length > i10) {
            objArr[i10] = null;
        }
        ma.i.E(0, 0, this.f9772q, this.f9771p, objArr);
        return objArr;
    }
}
