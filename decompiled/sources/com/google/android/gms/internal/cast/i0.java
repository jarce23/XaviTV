package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i0 extends e0 {

    /* renamed from: s, reason: collision with root package name */
    public static final i0 f3335s = new i0(0, new Object[0]);

    /* renamed from: q, reason: collision with root package name */
    public final transient Object[] f3336q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int f3337r;

    public i0(int i10, Object[] objArr) {
        this.f3336q = objArr;
        this.f3337r = i10;
    }

    @Override // com.google.android.gms.internal.cast.e0, com.google.android.gms.internal.cast.b0
    public final int f(Object[] objArr) {
        Object[] objArr2 = this.f3336q;
        int i10 = this.f3337r;
        System.arraycopy(objArr2, 0, objArr, 0, i10);
        return i10;
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final int g() {
        return this.f3337r;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        j1.c.s(i10, this.f3337r);
        Object obj = this.f3336q[i10];
        obj.getClass();
        return obj;
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final int h() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final Object[] i() {
        return this.f3336q;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3337r;
    }
}
