package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p0 extends g0 {

    /* renamed from: w, reason: collision with root package name */
    public static final Object[] f3416w;

    /* renamed from: x, reason: collision with root package name */
    public static final p0 f3417x;

    /* renamed from: r, reason: collision with root package name */
    public final transient Object[] f3418r;

    /* renamed from: s, reason: collision with root package name */
    public final transient int f3419s;

    /* renamed from: t, reason: collision with root package name */
    public final transient Object[] f3420t;

    /* renamed from: u, reason: collision with root package name */
    public final transient int f3421u;

    /* renamed from: v, reason: collision with root package name */
    public final transient int f3422v;

    static {
        Object[] objArr = new Object[0];
        f3416w = objArr;
        f3417x = new p0(0, 0, 0, objArr, objArr);
    }

    public p0(int i10, int i11, int i12, Object[] objArr, Object[] objArr2) {
        this.f3418r = objArr;
        this.f3419s = i10;
        this.f3420t = objArr2;
        this.f3421u = i11;
        this.f3422v = i12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f3420t;
            if (objArr.length != 0) {
                int z10 = w7.b.z(obj.hashCode());
                while (true) {
                    int i10 = z10 & this.f3421u;
                    Object obj2 = objArr[i10];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    z10 = i10 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final int f(Object[] objArr) {
        Object[] objArr2 = this.f3418r;
        int i10 = this.f3422v;
        System.arraycopy(objArr2, 0, objArr, 0, i10);
        return i10;
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final int g() {
        return this.f3422v;
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final int h() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.g0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f3419s;
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final Object[] i() {
        return this.f3418r;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        e0 e0Var = this.f3311p;
        if (e0Var == null) {
            e0Var = e0.k(this.f3422v, this.f3418r);
            this.f3311p = e0Var;
        }
        return e0Var.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f3422v;
    }
}
