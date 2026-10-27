package com.google.android.gms.internal.cast;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k6 extends AbstractList implements RandomAccess, j5 {

    /* renamed from: o, reason: collision with root package name */
    public final i5 f3354o;

    public k6(i5 i5Var) {
        this.f3354o = i5Var;
    }

    @Override // com.google.android.gms.internal.cast.j5
    public final Object a(int i10) {
        return this.f3354o.f3340p.get(i10);
    }

    @Override // com.google.android.gms.internal.cast.j5
    public final List d() {
        return Collections.unmodifiableList(this.f3354o.f3340p);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i10) {
        return this.f3354o.get(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new j6(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i10) {
        return new i6(this, i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3354o.f3340p.size();
    }

    @Override // com.google.android.gms.internal.cast.j5
    public final j5 e() {
        return this;
    }
}
