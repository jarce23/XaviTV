package com.google.android.gms.internal.cast;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 extends c8.g implements ListIterator {

    /* renamed from: p, reason: collision with root package name */
    public final int f3278p;

    /* renamed from: q, reason: collision with root package name */
    public int f3279q;

    /* renamed from: r, reason: collision with root package name */
    public final e0 f3280r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(e0 e0Var, int i10) {
        super(1);
        int size = e0Var.size();
        j1.c.t(i10, size);
        this.f3278p = size;
        this.f3279q = i10;
        this.f3280r = e0Var;
    }

    public final Object a(int i10) {
        return this.f3280r.get(i10);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f3279q < this.f3278p;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f3279q > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f3279q;
        this.f3279q = i10 + 1;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f3279q;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f3279q - 1;
        this.f3279q = i10;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f3279q - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
