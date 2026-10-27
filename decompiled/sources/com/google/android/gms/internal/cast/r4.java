package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r4 implements Iterator {

    /* renamed from: o, reason: collision with root package name */
    public int f3440o = 0;

    /* renamed from: p, reason: collision with root package name */
    public final int f3441p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ t4 f3442q;

    public r4(t4 t4Var) {
        this.f3442q = t4Var;
        this.f3441p = t4Var.h();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3440o < this.f3441p;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i10 = this.f3440o;
        if (i10 >= this.f3441p) {
            throw new NoSuchElementException();
        }
        this.f3440o = i10 + 1;
        return Byte.valueOf(this.f3442q.g(i10));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
