package com.google.android.gms.internal.cast;

import java.util.AbstractMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j0 extends e0 {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ k0 f3344q;

    public j0(k0 k0Var) {
        this.f3344q = k0Var;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i10) {
        k0 k0Var = this.f3344q;
        j1.c.s(i10, k0Var.f3351t);
        Object[] objArr = k0Var.f3350s;
        int i11 = i10 + i10;
        Object obj = objArr[i11];
        obj.getClass();
        Object obj2 = objArr[i11 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3344q.f3351t;
    }
}
