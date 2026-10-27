package c8;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends g implements ListIterator {

    /* renamed from: p, reason: collision with root package name */
    public final int f2958p;

    /* renamed from: q, reason: collision with root package name */
    public int f2959q;

    /* renamed from: r, reason: collision with root package name */
    public final e f2960r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar, int i10) {
        super(0);
        int size = eVar.size();
        if (i10 < 0 || i10 > size) {
            throw new IndexOutOfBoundsException(com.bumptech.glide.d.P("index", i10, size));
        }
        this.f2958p = size;
        this.f2959q = i10;
        this.f2960r = eVar;
    }

    public final Object a(int i10) {
        return this.f2960r.get(i10);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f2959q < this.f2958p;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f2959q > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f2959q;
        this.f2959q = i10 + 1;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f2959q;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f2959q - 1;
        this.f2959q = i10;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f2959q - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
