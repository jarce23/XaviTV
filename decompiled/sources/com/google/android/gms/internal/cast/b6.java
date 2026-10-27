package com.google.android.gms.internal.cast;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b6 extends p4 implements RandomAccess {

    /* renamed from: r, reason: collision with root package name */
    public static final b6 f3272r = new b6(new Object[0], 0, false);

    /* renamed from: p, reason: collision with root package name */
    public Object[] f3273p;

    /* renamed from: q, reason: collision with root package name */
    public int f3274q;

    public b6(Object[] objArr, int i10, boolean z10) {
        super(z10);
        this.f3273p = objArr;
        this.f3274q = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int i11;
        f();
        if (i10 < 0 || i10 > (i11 = this.f3274q)) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("Index:", ", Size:", i10, this.f3274q));
        }
        int i12 = i10 + 1;
        Object[] objArr = this.f3273p;
        if (i11 < objArr.length) {
            System.arraycopy(objArr, i10, objArr, i12, i11 - i10);
        } else {
            Object[] objArr2 = new Object[((i11 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i10);
            System.arraycopy(this.f3273p, i10, objArr2, i12, this.f3274q - i10);
            this.f3273p = objArr2;
        }
        this.f3273p[i10] = obj;
        this.f3274q++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.cast.f5
    public final /* bridge */ /* synthetic */ f5 c(int i10) {
        if (i10 >= this.f3274q) {
            return new b6(Arrays.copyOf(this.f3273p, i10), this.f3274q, true);
        }
        throw new IllegalArgumentException();
    }

    public final void g(int i10) {
        if (i10 < 0 || i10 >= this.f3274q) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.p("Index:", ", Size:", i10, this.f3274q));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        g(i10);
        return this.f3273p[i10];
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractList, java.util.List
    public final Object remove(int i10) {
        f();
        g(i10);
        Object[] objArr = this.f3273p;
        Object obj = objArr[i10];
        if (i10 < this.f3274q - 1) {
            System.arraycopy(objArr, i10 + 1, objArr, i10, (r2 - i10) - 1);
        }
        this.f3274q--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        f();
        g(i10);
        Object[] objArr = this.f3273p;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3274q;
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        int i10 = this.f3274q;
        Object[] objArr = this.f3273p;
        if (i10 == objArr.length) {
            this.f3273p = Arrays.copyOf(objArr, ((i10 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f3273p;
        int i11 = this.f3274q;
        this.f3274q = i11 + 1;
        objArr2[i11] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
