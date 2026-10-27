package r9;

import com.bumptech.glide.e;
import com.google.android.gms.internal.cast.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends AbstractList implements RandomAccess, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public final int[] f10980o;

    /* renamed from: p, reason: collision with root package name */
    public final int f10981p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10982q;

    public b(int i10, int i11, int[] iArr) {
        this.f10980o = iArr;
        this.f10981p = i10;
        this.f10982q = i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return n.n(this.f10980o, ((Integer) obj).intValue(), this.f10981p, this.f10982q) != -1;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return super.equals(obj);
        }
        b bVar = (b) obj;
        int size = size();
        if (bVar.size() != size) {
            return false;
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f10980o[this.f10981p + i10] != bVar.f10980o[bVar.f10981p + i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        e.g(i10, size());
        return Integer.valueOf(this.f10980o[this.f10981p + i10]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = this.f10981p; i11 < this.f10982q; i11++) {
            i10 = (i10 * 31) + this.f10980o[i11];
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i10 = this.f10982q;
        int[] iArr = this.f10980o;
        int i11 = this.f10981p;
        int n10 = n.n(iArr, intValue, i11, i10);
        if (n10 >= 0) {
            return n10 - i11;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int i10;
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int i11 = this.f10982q;
            while (true) {
                i11--;
                i10 = this.f10981p;
                if (i11 < i10) {
                    i11 = -1;
                    break;
                }
                if (this.f10980o[i11] == intValue) {
                    break;
                }
            }
            if (i11 >= 0) {
                return i11 - i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        Integer num = (Integer) obj;
        e.g(i10, size());
        int i11 = this.f10981p + i10;
        int[] iArr = this.f10980o;
        int i12 = iArr[i11];
        num.getClass();
        iArr[i11] = num.intValue();
        return Integer.valueOf(i12);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10982q - this.f10981p;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i10, int i11) {
        e.i(i10, i11, size());
        if (i10 == i11) {
            return Collections.EMPTY_LIST;
        }
        int i12 = this.f10981p;
        return new b(i10 + i12, i12 + i11, this.f10980o);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb2 = new StringBuilder(size() * 5);
        sb2.append('[');
        int[] iArr = this.f10980o;
        int i10 = this.f10981p;
        sb2.append(iArr[i10]);
        while (true) {
            i10++;
            if (i10 >= this.f10982q) {
                sb2.append(']');
                return sb2.toString();
            }
            sb2.append(", ");
            sb2.append(iArr[i10]);
        }
    }
}
