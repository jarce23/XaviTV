package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 extends e0 {

    /* renamed from: q, reason: collision with root package name */
    public final transient Object[] f3387q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int f3388r;

    /* renamed from: s, reason: collision with root package name */
    public final transient int f3389s;

    public n0(Object[] objArr, int i10, int i11) {
        this.f3387q = objArr;
        this.f3388r = i10;
        this.f3389s = i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        j1.c.s(i10, this.f3389s);
        Object obj = this.f3387q[i10 + i10 + this.f3388r];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3389s;
    }
}
