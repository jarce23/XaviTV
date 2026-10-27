package com.google.android.gms.internal.cast;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b5 extends p4 implements RandomAccess, c5, z5 {

    /* renamed from: r, reason: collision with root package name */
    public static final b5 f3269r = new b5(0, false, new int[0]);

    /* renamed from: p, reason: collision with root package name */
    public int[] f3270p;

    /* renamed from: q, reason: collision with root package name */
    public int f3271q;

    public b5(int i10, boolean z10, int[] iArr) {
        super(z10);
        this.f3270p = iArr;
        this.f3271q = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int i11;
        int intValue = ((Integer) obj).intValue();
        f();
        if (i10 < 0 || i10 > (i11 = this.f3271q)) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("Index:", ", Size:", i10, this.f3271q));
        }
        int i12 = i10 + 1;
        int[] iArr = this.f3270p;
        if (i11 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i12, i11 - i10);
        } else {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(this.f3270p, i10, iArr2, i12, this.f3271q - i10);
            this.f3270p = iArr2;
        }
        this.f3270p[i10] = intValue;
        this.f3271q++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        f();
        Charset charset = g5.f3312a;
        collection.getClass();
        if (!(collection instanceof b5)) {
            return super.addAll(collection);
        }
        b5 b5Var = (b5) collection;
        int i10 = b5Var.f3271q;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f3271q;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        int[] iArr = this.f3270p;
        if (i12 > iArr.length) {
            this.f3270p = Arrays.copyOf(iArr, i12);
        }
        System.arraycopy(b5Var.f3270p, 0, this.f3270p, this.f3271q, b5Var.f3271q);
        this.f3271q = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.cast.f5
    public final f5 c(int i10) {
        if (i10 < this.f3271q) {
            throw new IllegalArgumentException();
        }
        return new b5(this.f3271q, true, Arrays.copyOf(this.f3270p, i10));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b5)) {
            return super.equals(obj);
        }
        b5 b5Var = (b5) obj;
        if (this.f3271q != b5Var.f3271q) {
            return false;
        }
        int[] iArr = b5Var.f3270p;
        for (int i10 = 0; i10 < this.f3271q; i10++) {
            if (this.f3270p[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void g(int i10) {
        f();
        int i11 = this.f3271q;
        int[] iArr = this.f3270p;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f3270p = iArr2;
        }
        int[] iArr3 = this.f3270p;
        int i12 = this.f3271q;
        this.f3271q = i12 + 1;
        iArr3[i12] = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        h(i10);
        return Integer.valueOf(this.f3270p[i10]);
    }

    public final void h(int i10) {
        if (i10 < 0 || i10 >= this.f3271q) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("Index:", ", Size:", i10, this.f3271q));
        }
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f3271q; i11++) {
            i10 = (i10 * 31) + this.f3270p[i11];
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i10 = this.f3271q;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f3270p[i11] == intValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        f();
        h(i10);
        int[] iArr = this.f3270p;
        int i11 = iArr[i10];
        if (i10 < this.f3271q - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (r2 - i10) - 1);
        }
        this.f3271q--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        f();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f3270p;
        System.arraycopy(iArr, i11, iArr, i10, this.f3271q - i11);
        this.f3271q -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        int intValue = ((Integer) obj).intValue();
        f();
        h(i10);
        int[] iArr = this.f3270p;
        int i11 = iArr[i10];
        iArr[i10] = intValue;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3271q;
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        g(((Integer) obj).intValue());
        return true;
    }
}
