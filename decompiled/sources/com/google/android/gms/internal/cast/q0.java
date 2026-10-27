package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q0 extends g0 {

    /* renamed from: r, reason: collision with root package name */
    public final transient Object f3437r;

    public q0(Object obj) {
        this.f3437r = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f3437r.equals(obj);
    }

    @Override // com.google.android.gms.internal.cast.b0
    public final int f(Object[] objArr) {
        objArr[0] = this.f3437r;
        return 1;
    }

    @Override // com.google.android.gms.internal.cast.g0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f3437r.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return new h0(this.f3437r);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return android.support.v4.media.d.q("[", this.f3437r.toString(), "]");
    }
}
