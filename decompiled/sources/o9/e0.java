package o9;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 extends k1 implements ListIterator {

    /* renamed from: o, reason: collision with root package name */
    public final int f9605o;

    /* renamed from: p, reason: collision with root package name */
    public int f9606p;

    /* renamed from: q, reason: collision with root package name */
    public final g0 f9607q;

    public e0(g0 g0Var, int i10) {
        int size = g0Var.size();
        com.bumptech.glide.e.h(i10, size);
        this.f9605o = size;
        this.f9606p = i10;
        this.f9607q = g0Var;
    }

    public final Object a(int i10) {
        return this.f9607q.get(i10);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f9606p < this.f9605o;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f9606p > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f9606p;
        this.f9606p = i10 + 1;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f9606p;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f9606p - 1;
        this.f9606p = i10;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f9606p - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
