package com.google.android.gms.internal.cast;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n5 extends p4 implements RandomAccess, e5, z5 {

    /* renamed from: r, reason: collision with root package name */
    public static final n5 f3396r = new n5(new long[0], 0, false);

    /* renamed from: p, reason: collision with root package name */
    public long[] f3397p;

    /* renamed from: q, reason: collision with root package name */
    public int f3398q;

    public n5(long[] jArr, int i10, boolean z10) {
        super(z10);
        this.f3397p = jArr;
        this.f3398q = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int i11;
        long longValue = ((Long) obj).longValue();
        f();
        if (i10 < 0 || i10 > (i11 = this.f3398q)) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("Index:", ", Size:", i10, this.f3398q));
        }
        int i12 = i10 + 1;
        long[] jArr = this.f3397p;
        if (i11 < jArr.length) {
            System.arraycopy(jArr, i10, jArr, i12, i11 - i10);
        } else {
            long[] jArr2 = new long[((i11 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            System.arraycopy(this.f3397p, i10, jArr2, i12, this.f3398q - i10);
            this.f3397p = jArr2;
        }
        this.f3397p[i10] = longValue;
        this.f3398q++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        f();
        Charset charset = g5.f3312a;
        collection.getClass();
        if (!(collection instanceof n5)) {
            return super.addAll(collection);
        }
        n5 n5Var = (n5) collection;
        int i10 = n5Var.f3398q;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f3398q;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        long[] jArr = this.f3397p;
        if (i12 > jArr.length) {
            this.f3397p = Arrays.copyOf(jArr, i12);
        }
        System.arraycopy(n5Var.f3397p, 0, this.f3397p, this.f3398q, n5Var.f3398q);
        this.f3398q = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.cast.f5
    public final /* bridge */ /* synthetic */ f5 c(int i10) {
        if (i10 >= this.f3398q) {
            return new n5(Arrays.copyOf(this.f3397p, i10), this.f3398q, true);
        }
        throw new IllegalArgumentException();
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
        if (!(obj instanceof n5)) {
            return super.equals(obj);
        }
        n5 n5Var = (n5) obj;
        if (this.f3398q != n5Var.f3398q) {
            return false;
        }
        long[] jArr = n5Var.f3397p;
        for (int i10 = 0; i10 < this.f3398q; i10++) {
            if (this.f3397p[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void g(int i10) {
        if (i10 < 0 || i10 >= this.f3398q) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("Index:", ", Size:", i10, this.f3398q));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        g(i10);
        return Long.valueOf(this.f3397p[i10]);
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f3398q; i11++) {
            long j10 = this.f3397p[i11];
            Charset charset = g5.f3312a;
            i10 = (i10 * 31) + ((int) (j10 ^ (j10 >>> 32)));
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i10 = this.f3398q;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f3397p[i11] == longValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        f();
        g(i10);
        long[] jArr = this.f3397p;
        long j10 = jArr[i10];
        if (i10 < this.f3398q - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (r3 - i10) - 1);
        }
        this.f3398q--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        f();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f3397p;
        System.arraycopy(jArr, i11, jArr, i10, this.f3398q - i11);
        this.f3398q -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        long longValue = ((Long) obj).longValue();
        f();
        g(i10);
        long[] jArr = this.f3397p;
        long j10 = jArr[i10];
        jArr[i10] = longValue;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3398q;
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        long longValue = ((Long) obj).longValue();
        f();
        int i10 = this.f3398q;
        long[] jArr = this.f3397p;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[((i10 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            this.f3397p = jArr2;
        }
        long[] jArr3 = this.f3397p;
        int i11 = this.f3398q;
        this.f3398q = i11 + 1;
        jArr3[i11] = longValue;
        return true;
    }
}
