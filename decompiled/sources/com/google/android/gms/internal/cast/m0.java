package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m0 extends g0 {

    /* renamed from: r, reason: collision with root package name */
    public final transient o0 f3372r;

    /* renamed from: s, reason: collision with root package name */
    public final transient n0 f3373s;

    public m0(o0 o0Var, n0 n0Var) {
        this.f3372r = o0Var;
        this.f3373s = n0Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f3372r.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final int f(Object[] objArr) {
        return this.f3373s.f(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.f3373s.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f3372r.f3410t;
    }
}
