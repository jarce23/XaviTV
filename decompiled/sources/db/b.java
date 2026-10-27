package db;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements Iterator, ab.a {

    /* renamed from: o, reason: collision with root package name */
    public final int f4353o;

    /* renamed from: p, reason: collision with root package name */
    public final int f4354p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4355q;

    /* renamed from: r, reason: collision with root package name */
    public int f4356r;

    public b(int i10, int i11, int i12) {
        this.f4353o = i12;
        this.f4354p = i11;
        boolean z10 = false;
        if (i12 <= 0 ? i10 >= i11 : i10 <= i11) {
            z10 = true;
        }
        this.f4355q = z10;
        this.f4356r = z10 ? i10 : i11;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4355q;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i10 = this.f4356r;
        if (i10 != this.f4354p) {
            this.f4356r = this.f4353o + i10;
        } else {
            if (!this.f4355q) {
                throw new NoSuchElementException();
            }
            this.f4355q = false;
        }
        return Integer.valueOf(i10);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
